package io.github.jeemartin.bingo.game;

import io.github.jeemartin.bingo.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakHandler implements Listener {
    @SuppressWarnings("unused")
    private Main plugin;

    public BlockBreakHandler(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Bingo game = BingoHandler.currentGame;
        if(game != null && game.getState() == BingoState.STARTING) {
            event.setCancelled(true);
        }
    }
}
