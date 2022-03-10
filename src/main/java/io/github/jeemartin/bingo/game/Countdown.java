package io.github.jeemartin.bingo.game;

import io.github.jeemartin.bingo.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.WorldBorder;
import org.bukkit.entity.Player;

import java.util.Date;

public class Countdown {
    private int countdownTimer;

    public void start(final int time, Main plugin)
    {
        this.countdownTimer = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable()
        {
            int cd = time;
            Bingo game = BingoHandler.currentGame;

            public void run()
            {
                if (this.cd <= 0)
                {
                    for(Player player : Bukkit.getOnlinePlayers()) {
                        if(!game.isPlaying(player)) continue;
                        player.sendTitle("§cGO!", "", 0, 20, 10);
                        player.playSound(player.getLocation(), Sound.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_ON, 1, 1);
                    }
                    game.setState(BingoState.RUNNING);

                    WorldBorder wb = null;
                    for(Player player : Bukkit.getOnlinePlayers()) {
                        if(game.isPlaying(player)) {
                            wb = player.getWorld().getWorldBorder();
                            break;
                        }
                    }
                    wb.setSize(20000);
                    game.setStartTime((int) (new Date().getTime() / 1000));
                    cancel();
                }
                else {
                    for(Player player : Bukkit.getOnlinePlayers()) {
                        if(!game.isPlaying(player)) continue;
                        player.sendTitle("§c" + String.valueOf(cd), "§eCome up with your plan!", 0, 20, 10);
                        player.playSound(player.getLocation(), Sound.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_ON, 1, 1);
                    }
                }
                this.cd--;
            }
        }, 0L, 20L);
    }

    public void cancel()
    {
        Bukkit.getScheduler().cancelTask(this.countdownTimer);
    }
}
