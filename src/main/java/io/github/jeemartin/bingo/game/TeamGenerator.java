package io.github.jeemartin.bingo.game;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TeamGenerator {
    private List<TeamAppearance> names = new ArrayList<TeamAppearance>(Arrays.asList(
            new TeamAppearance(ChatColor.GOLD, "Orange Ocelots", 10),
            new TeamAppearance(ChatColor.GREEN, "Lime Llamas", 13),
            new TeamAppearance(ChatColor.DARK_GREEN, "Green Guardians", 9),
            new TeamAppearance(ChatColor.DARK_AQUA, "Cyan Creepers", 10),
            new TeamAppearance(ChatColor.AQUA, "Aquamarine Axolotls", 8),
            new TeamAppearance(ChatColor.BLUE, "Blue Bees", 14),
            new TeamAppearance(ChatColor.DARK_PURPLE, "Violet Vindicators", 9),
            new TeamAppearance(ChatColor.LIGHT_PURPLE, "Pink Parrots", 12),
            new TeamAppearance(ChatColor.WHITE, "White Wolves", 12),
            new TeamAppearance(ChatColor.GRAY, "Silver Strays", 12),
            new TeamAppearance(ChatColor.DARK_GRAY, "Emperor Evokers", 9)
    ));

    private final Random random;

    public TeamGenerator() {
        random = new Random();
    }

    public TeamAppearance getRandomAppearance() {
        return names.remove(random.nextInt(names.size()));
    }
}
