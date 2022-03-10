package io.github.jeemartin.bingo.items;

import io.github.jeemartin.bingo.Main;
import io.github.jeemartin.bingo.card.BingoCard;
import io.github.jeemartin.bingo.game.Bingo;
import io.github.jeemartin.bingo.game.BingoHandler;
import io.github.jeemartin.bingo.game.BingoTeam;
import io.github.jeemartin.bingo.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitTask;

import java.util.Date;

public class ItemHandler {
    private Main plugin;
    private BukkitTask task;

    public ItemHandler(Main plugin) {
        this.plugin = plugin;
    }

    public void run() {
        Bingo game = BingoHandler.currentGame;
        task = Bukkit.getScheduler().runTaskTimer(plugin, new Runnable() {
            @Override
            public void run() {
                for(Player player : Bukkit.getOnlinePlayers()) {
                    if(!game.isPlaying(player)) continue;
                    BingoTeam team = game.getTeam(player);
                    BingoCard bc = team.getBingoCard();
                    for(ItemStack is : player.getInventory().getContents()) {
                        if(is != null && bc.fillItem(is)) {
                            player.getInventory().removeItem(is);
                            if(bc.isComplete()) {
                                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                                game.processFinished(team);
                                team.setTime((int) (new Date().getTime() / 1000) - game.getStartTime());
                                Bukkit.broadcastMessage(String.format("§c[BINGO]: §eTeam %s §ehave completed their Bingo card §c%s!",
                                        team.getName(), Utils.ordinal(game.getPlaceIndex())));
                                if(game.getFinishedCount() >= game.teamCount() - 1) {
                                    BingoHandler.stopGame();
                                    Bukkit.broadcastMessage("§c[BINGO]: §eThe game has ended! The results are:");
                                    for(int j = 0; j < game.teamCount(); j++) {
                                        BingoTeam t = game.getTeam(j);
                                        String time;
                                        if(t.getTime() == -1) {
                                            time = "DNF";
                                        }
                                        else {
                                            int minutes = t.getTime() / 60;
                                            int seconds = t.getTime() % 60;
                                            time = String.format("%02d", minutes) + ":" + String.format("%02d", seconds);
                                        }
                                        Bukkit.broadcastMessage(String.format("  §e%s. %s §e(%s)", j + 1, t.getName(), time));
                                    }
                                }
                                return;
                            }
                            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                            Bukkit.broadcastMessage(String.format("§c[BINGO]: §eTeam %s §ehave found §c%s!",
                                    team.getName(), Utils.formatMaterialName(is.getType())));
                        }
                    }
                }
            }
        }, 0l, 10l);
    }

    public void cancel() {
        task.cancel();
    }
}
