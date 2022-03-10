package io.github.jeemartin.bingo.game;

import io.github.jeemartin.bingo.Main;
import io.github.jeemartin.bingo.card.BingoCard;
import io.github.jeemartin.bingo.items.ItemGenerator;
import io.github.jeemartin.bingo.items.ItemHandler;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import java.util.*;

public class BingoHandler {
    public static Bingo currentGame = null;
    public static World gameWorld = null;
    private static Countdown countDown;
    private static ItemHandler itemHandler;
    private static int prepareTime;

    public static void startGame(Main plugin, List<Player> players, World world) {
        currentGame = new Bingo();
        currentGame.setState(BingoState.STARTING);

        gameWorld = world;
        Location startingLoc = new Location(gameWorld, 0, world.getHighestBlockYAt(0, 0) + 1, 0);
        gameWorld.setSpawnLocation(startingLoc);

        prepareTime = plugin.getConfig().getInt("prepareTime");

        List<PotionEffect> potionEffects = new ArrayList<PotionEffect>(Arrays.asList(
                new PotionEffect(PotionEffectType.REGENERATION, 20*prepareTime, 3, false, false, false),
                new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20*prepareTime, 3, false, false, false),
                new PotionEffect(PotionEffectType.SATURATION, 20*prepareTime, 3, false, false, false)
        ));

        for(int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            player.setGameMode(GameMode.SURVIVAL);
            player.getInventory().clear();
            player.teleport(startingLoc);
            player.addPotionEffects(potionEffects);
        }
        WorldBorder wb = gameWorld.getWorldBorder();
        wb.setCenter(0, 0);
        wb.setSize(50);

        ItemGenerator ig = new ItemGenerator();
        ItemStack[][] bingoItems = new ItemStack[5][5];

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                bingoItems[i][j] = ig.generateItem();
            }
        }

        createTeams(currentGame, plugin.getConfig().getInt("teamSize"), players, bingoItems);
        itemHandler = new ItemHandler(plugin);
        itemHandler.run();
        currentGame.giveCards();

        Bukkit.broadcastMessage("§c[BINGO]: §eGame is starting!");
        countDown = new Countdown();
        countDown.start(prepareTime, plugin);
    }

    @SuppressWarnings("deprecation")
    private static void createTeams(Bingo game, int teamSize, List<Player> players, ItemStack[][] bingoItems) {
        Collections.shuffle(players);
        TeamGenerator tg = new TeamGenerator();
        Random rand = new Random();

        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getMainScoreboard();
        for(Team t : board.getTeams()) {
            t.unregister();
        }

        Bukkit.broadcastMessage("§c[BINGO]: §eTeams were created:");

        while(players.size() != 0) {
            TeamAppearance appearance = tg.getRandomAppearance();
            BingoCard card = new BingoCard(bingoItems);
            ItemStack cardItem = new ItemStack(Material.PAPER);
            ItemMeta meta = cardItem.getItemMeta();
            meta.setDisplayName(appearance.getColor() + "Your Bingo Card");
            cardItem.setItemMeta(meta);
            Bukkit.broadcastMessage("  " + appearance.getName() + ":");

            UUID[] members = new UUID[teamSize];
            for(int i = 0; i < teamSize; i++) {
                Player player = players.get(rand.nextInt(players.size()));
                members[i] = player.getUniqueId();
                players.remove(player);
                Bukkit.broadcastMessage(String.format("    §e• %s%s", appearance.getColor(), player.getName()));
            }

            BingoTeam team = new BingoTeam(appearance, members, card, cardItem);
            game.addTeam(team);

            Team t = board.registerNewTeam(ChatColor.stripColor(team.getName().split(" ")[0]));
            t.setColor(team.getColor());
            for(Player player : Bukkit.getOnlinePlayers()) {
                if(team.hasPlayer(player)) {
                    t.addPlayer(player);
                }
            }
        }
    }

    public static void stopGame(){
        Location startingLoc = new Location(gameWorld, 0, gameWorld.getHighestBlockYAt(0, 0) + 1, 0);
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getMainScoreboard();

        for(Team t : board.getTeams()) {
            t.unregister();
        }

        for(Player player : Bukkit.getOnlinePlayers()) {
            if(!currentGame.isPlaying(player)) continue;
            player.teleport(startingLoc);
            player.setGameMode(GameMode.SURVIVAL);
        }
        currentGame.removeItems();
        itemHandler.cancel();
        if(currentGame.getState() == BingoState.STARTING) {
            countDown.cancel();
            for(Player player : Bukkit.getOnlinePlayers()) {
                if(currentGame.isPlaying(player)) {
                    removePotionEffects(player);
                }
            }
        }
        currentGame.setState(BingoState.STOPPED);
        currentGame = null;
        gameWorld = null;
    }

    private static void removePotionEffects(Player player) {
        for(PotionEffect effect : player.getActivePotionEffects()) {
            player.removePotionEffect(effect.getType());
        }
    }
}
