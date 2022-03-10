package io.github.jeemartin.bingo.utils;

import org.bukkit.Material;

public class Utils {
    public static String formatMaterialName(Material material) {
        String[] parts = material.toString().split("_");
        for(int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].charAt(0) + parts[i].substring(1).toLowerCase();
        }
        return String.join(" ", parts);
    }
    public static String ordinal(int i) {
        String[] suffixes = new String[] { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };
        switch (i % 100) {
            case 11:
            case 12:
            case 13:
                return i + "th";
            default:
                return i + suffixes[i % 10];
        }
    }
}
