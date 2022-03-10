package io.github.jeemartin.bingo.game;

import com.google.common.base.Strings;
import org.bukkit.ChatColor;

public class TeamAppearance {
    private ChatColor color;
    private String name;
    private String title;

    public TeamAppearance(ChatColor color, String name, int spaces) {
        this.color = color;
        this.name = color + name;
        this.title = Strings.repeat(" ", spaces) + this.name;
    }

    public ChatColor getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }
}
