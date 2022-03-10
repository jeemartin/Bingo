package io.github.jeemartin.bingo;

import io.github.jeemartin.bingo.card.OnCardDrop;
import io.github.jeemartin.bingo.card.BingoUIHandler;
import io.github.jeemartin.bingo.commands.Commands;
import io.github.jeemartin.bingo.game.BlockBreakHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        new Commands(this);
        Bukkit.getPluginManager().registerEvents(new BingoUIHandler(this), this);
        Bukkit.getPluginManager().registerEvents(new BlockBreakHandler(this), this);
        Bukkit.getPluginManager().registerEvents(new OnCardDrop(this), this);

        this.getConfig().options().copyDefaults();
        this.saveConfig();
    }
}
