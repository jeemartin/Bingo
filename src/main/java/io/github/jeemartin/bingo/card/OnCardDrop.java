package io.github.jeemartin.bingo.card;

import io.github.jeemartin.bingo.Main;
import io.github.jeemartin.bingo.game.Bingo;
import io.github.jeemartin.bingo.game.BingoHandler;
import io.github.jeemartin.bingo.game.BingoState;
import io.github.jeemartin.bingo.game.BingoTeam;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class OnCardDrop implements Listener {
    @SuppressWarnings("unused")
    private Main plugin;

    public OnCardDrop(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        Bingo game = BingoHandler.currentGame;
        if(game == null || (game.getState() != BingoState.RUNNING && game.getState() != BingoState.STARTING)) return;
        Player player = event.getPlayer();
        if(game.isPlaying(player)) {
            BingoTeam team = game.getTeam(player);
            ItemStack droppedItem = event.getItemDrop().getItemStack();
            if(team.getCardItem().isSimilar(droppedItem)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Bingo game = BingoHandler.currentGame;
        if(game == null || (game.getState() != BingoState.RUNNING && game.getState() != BingoState.STARTING)) return;
        Player player = event.getEntity();
        if(game.isPlaying(player)) {
            BingoTeam team = game.getTeam(player);
            List<ItemStack> drops = event.getDrops();
            for(ItemStack drop : drops) {
                if(drop.isSimilar(team.getCardItem())) {
                    drops.remove(drop);
                    break;
                }
            }
        }
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        Bingo game = BingoHandler.currentGame;
        if(game == null || (game.getState() != BingoState.RUNNING && game.getState() != BingoState.STARTING)) return;
        Player player = event.getPlayer();
        if(game.isPlaying(player)) {
            BingoTeam team = game.getTeam(player);
            player.getInventory().addItem(team.getCardItem());
        }
    }
}
