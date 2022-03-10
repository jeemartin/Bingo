package io.github.jeemartin.bingo.card;

import io.github.jeemartin.bingo.Main;
import io.github.jeemartin.bingo.game.Bingo;
import io.github.jeemartin.bingo.game.BingoHandler;
import io.github.jeemartin.bingo.game.BingoState;
import io.github.jeemartin.bingo.game.BingoTeam;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class BingoUIHandler implements Listener {
    @SuppressWarnings("unused")
    private Main plugin;

    public BingoUIHandler(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        Bingo game = BingoHandler.currentGame;
        if(game == null || (game.getState() != BingoState.RUNNING && game.getState() != BingoState.STARTING)) return;
        Player player = event.getPlayer();
        if(game.isPlaying(player)) {
            BingoTeam team = game.getTeam(player);
            Action action = event.getAction();
            if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK){
                if(event.getItem() != null && event.getItem().getType() == Material.PAPER &&
                        event.getItem().isSimilar(team.getCardItem())) {
                    BingoUI ui = new BingoUI(team);
                    ui.open(player);
                }
            }
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Bingo game = BingoHandler.currentGame;
        if(game == null || (game.getState() != BingoState.RUNNING && game.getState() != BingoState.STARTING)) return;
        String title = event.getView().getTitle();
        Player player = (Player) event.getWhoClicked();
        if(game.isPlaying(player)) {
            BingoTeam team = game.getTeam(player);
            if(title.equals(team.getTitleUI())) {
                event.setCancelled(true);
                if(event.getCurrentItem() == null) {
                    return;
                }
            }
        }
    }
}
