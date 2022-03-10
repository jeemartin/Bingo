package io.github.jeemartin.bingo.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ItemGenerator {
    private List<ItemStack> items = new ArrayList<ItemStack>();

    public ItemGenerator() {

        //FOOD
        items.add(new ItemStack(Material.MUSHROOM_STEW));
        items.add(new ItemStack(Material.GOLDEN_APPLE));
        items.add(new ItemStack(Material.CAKE));
        items.add(new ItemStack(Material.SWEET_BERRIES));
        items.add(new ItemStack(Material.DRIED_KELP));
        items.add(new ItemStack(Material.PUMPKIN_PIE));
        items.add(new ItemStack(Material.COOKIE));
        items.add(new ItemStack(Material.COOKED_RABBIT));
        items.add(new ItemStack(Material.PUFFERFISH_BUCKET));
        items.add(new ItemStack(Material.TROPICAL_FISH_BUCKET));
        items.add(new ItemStack(Material.COD_BUCKET));
        items.add(new ItemStack(Material.SALMON_BUCKET));
        items.add(new ItemStack(Material.GOLDEN_CARROT));
        items.add(new ItemStack(Material.GLISTERING_MELON_SLICE));
        items.add(new ItemStack(Material.BAKED_POTATO));
        items.add(new ItemStack(Material.BEETROOT_SOUP));

        // STUFF WITH MOB DROPS INCLUDED
        items.add(new ItemStack(Material.RABBIT_HIDE));
        items.add(new ItemStack(Material.ENDER_PEARL));
        items.add(new ItemStack(Material.EGG));
        items.add(new ItemStack(Material.FERMENTED_SPIDER_EYE));
        items.add(new ItemStack(Material.HONEYCOMB));

        // TOOLS & WEAPONS
        items.add(new ItemStack(Material.DIAMOND_PICKAXE));
        items.add(new ItemStack(Material.IRON_PICKAXE));
        items.add(new ItemStack(Material.GOLDEN_PICKAXE));
        items.add(new ItemStack(Material.DIAMOND_AXE));
        items.add(new ItemStack(Material.IRON_AXE));
        items.add(new ItemStack(Material.GOLDEN_AXE));
        items.add(new ItemStack(Material.DIAMOND_SWORD));
        items.add(new ItemStack(Material.IRON_SWORD));
        items.add(new ItemStack(Material.GOLDEN_SWORD));
        items.add(new ItemStack(Material.DIAMOND_SHOVEL));
        items.add(new ItemStack(Material.GOLDEN_SHOVEL));
        items.add(new ItemStack(Material.IRON_SHOVEL));
        items.add(new ItemStack(Material.CLOCK));
        items.add(new ItemStack(Material.FLINT_AND_STEEL));
        items.add(new ItemStack(Material.NAME_TAG));
        items.add(new ItemStack(Material.COMPASS));
        items.add(new ItemStack(Material.FISHING_ROD));
        items.add(new ItemStack(Material.LEATHER_CHESTPLATE));
        items.add(new ItemStack(Material.DIAMOND_CHESTPLATE));
        items.add(new ItemStack(Material.GOLDEN_LEGGINGS));
        items.add(new ItemStack(Material.LEATHER_CHESTPLATE));
        items.add(new ItemStack(Material.LEATHER_BOOTS));
        items.add(new ItemStack(Material.LEATHER_LEGGINGS));
        items.add(new ItemStack(Material.LEATHER_HELMET));
        items.add(new ItemStack(Material.DIAMOND_SWORD));
        items.add(new ItemStack(Material.CROSSBOW));
        items.add(new ItemStack(Material.MAP));
        items.add(new ItemStack(Material.WRITABLE_BOOK));
        items.add(new ItemStack(Material.CARROT_ON_A_STICK));
        items.add(new ItemStack(Material.GLASS_BOTTLE));
        items.add(new ItemStack(Material.FIREWORK_ROCKET));
        items.add(new ItemStack(Material.FIREWORK_STAR));

        //STORAGE
        items.add(new ItemStack(Material.BARREL));
        items.add(new ItemStack(Material.TRAPPED_CHEST));
        items.add(new ItemStack(Material.CHEST_MINECART));
        items.add(new ItemStack(Material.HOPPER));
        items.add(new ItemStack(Material.CAULDRON));

        // TRANSPORTATION
        items.add(new ItemStack(Material.POWERED_RAIL));
        items.add(new ItemStack(Material.DETECTOR_RAIL));
        items.add(new ItemStack(Material.RAIL));
        items.add(new ItemStack(Material.MINECART));
        items.add(new ItemStack(Material.SADDLE));

        // REDSTONE
        items.add(new ItemStack(Material.NOTE_BLOCK));
        items.add(new ItemStack(Material.PISTON));
        items.add(new ItemStack(Material.STICKY_PISTON));
        items.add(new ItemStack(Material.TNT));
        items.add(new ItemStack(Material.TRIPWIRE_HOOK));
        items.add(new ItemStack(Material.REDSTONE_TORCH));
        items.add(new ItemStack(Material.BIRCH_TRAPDOOR));
        items.add(new ItemStack(Material.REDSTONE_LAMP));
        items.add(new ItemStack(Material.COMPARATOR));
        items.add(new ItemStack(Material.REPEATER));
        items.add(new ItemStack(Material.DISPENSER));
        items.add(new ItemStack(Material.DROPPER));

        // DECORATION
        items.add(new ItemStack(Material.IRON_DOOR));
        items.add(new ItemStack(Material.JUKEBOX));
        items.add(new ItemStack(Material.POPPY));
        items.add(new ItemStack(Material.DANDELION));
        items.add(new ItemStack(Material.RED_TULIP));
        items.add(new ItemStack(Material.BLUE_ORCHID));
        items.add(new ItemStack(Material.AZURE_BLUET));
        items.add(new ItemStack(Material.ORANGE_TULIP));
        items.add(new ItemStack(Material.ORANGE_TULIP));
        items.add(new ItemStack(Material.WHITE_TULIP));
        items.add(new ItemStack(Material.PINK_TULIP));
        items.add(new ItemStack(Material.ALLIUM));
        items.add(new ItemStack(Material.ENCHANTING_TABLE));
        items.add(new ItemStack(Material.LILY_PAD));
        items.add(new ItemStack(Material.ANVIL));
        items.add(new ItemStack(Material.ITEM_FRAME));
        items.add(new ItemStack(Material.FLOWER_POT));
        items.add(new ItemStack(Material.ARMOR_STAND));
        items.add(new ItemStack(Material.CAMPFIRE));
        items.add(new ItemStack(Material.BLAST_FURNACE));
        items.add(new ItemStack(Material.LOOM));
        items.add(new ItemStack(Material.FLETCHING_TABLE));
        items.add(new ItemStack(Material.STONECUTTER));
        items.add(new ItemStack(Material.LANTERN));
        items.add(new ItemStack(Material.PAINTING));
        items.add(new ItemStack(Material.ROSE_BUSH));
        items.add(new ItemStack(Material.PEONY));
        items.add(new ItemStack(Material.LILAC));
        items.add(new ItemStack(Material.ANVIL));
        items.add(new ItemStack(Material.SCAFFOLDING));
        items.add(new ItemStack(Material.HAY_BLOCK));
        items.add(new ItemStack(Material.LECTERN));
        items.add(new ItemStack(Material.IRON_BARS));

        // SOME RANDOM BLOCKS
        items.add(new ItemStack(Material.SMOOTH_STONE_SLAB));
        items.add(new ItemStack(Material.LAVA_BUCKET));
        items.add(new ItemStack(Material.MILK_BUCKET));
        items.add(new ItemStack(Material.SANDSTONE_WALL));
        items.add(new ItemStack(Material.POLISHED_GRANITE_SLAB));
        items.add(new ItemStack(Material.POLISHED_GRANITE_STAIRS));
        items.add(new ItemStack(Material.POLISHED_ANDESITE_SLAB));
        items.add(new ItemStack(Material.POLISHED_ANDESITE_STAIRS));
        items.add(new ItemStack(Material.JACK_O_LANTERN));
        items.add(new ItemStack(Material.CARVED_PUMPKIN));
        items.add(new ItemStack(Material.OBSIDIAN));
        items.add(new ItemStack(Material.OAK_LEAVES));
        items.add(new ItemStack(Material.SPRUCE_LEAVES));
        items.add(new ItemStack(Material.BIRCH_LEAVES));

        // COLORED ITEMS
        items.add(new ItemStack(Material.BLACK_WOOL));
        items.add(new ItemStack(Material.ORANGE_WOOL));
        items.add(new ItemStack(Material.PINK_WOOL));
        items.add(new ItemStack(Material.LIGHT_BLUE_WOOL));
        items.add(new ItemStack(Material.YELLOW_WOOL));
        items.add(new ItemStack(Material.PINK_WOOL));
        items.add(new ItemStack(Material.LIGHT_GRAY_WOOL));
        items.add(new ItemStack(Material.CYAN_WOOL));
        items.add(new ItemStack(Material.PURPLE_WOOL));
        items.add(new ItemStack(Material.BLUE_WOOL));
        items.add(new ItemStack(Material.BROWN_WOOL));
        items.add(new ItemStack(Material.GREEN_WOOL));
        items.add(new ItemStack(Material.RED_WOOL));

        items.add(new ItemStack(Material.BLACK_BED));
        items.add(new ItemStack(Material.ORANGE_BED));
        items.add(new ItemStack(Material.PINK_BED));
        items.add(new ItemStack(Material.LIGHT_BLUE_BED));
        items.add(new ItemStack(Material.YELLOW_BED));
        items.add(new ItemStack(Material.PINK_BED));
        items.add(new ItemStack(Material.LIGHT_GRAY_WOOL));
        items.add(new ItemStack(Material.CYAN_BED));
        items.add(new ItemStack(Material.PURPLE_BED));
        items.add(new ItemStack(Material.BLUE_BED));
        items.add(new ItemStack(Material.BROWN_BED));
        items.add(new ItemStack(Material.GREEN_BED));
        items.add(new ItemStack(Material.RED_BED));

        items.add(new ItemStack(Material.WHITE_STAINED_GLASS));
        items.add(new ItemStack(Material.ORANGE_STAINED_GLASS));
        items.add(new ItemStack(Material.PINK_STAINED_GLASS));
        items.add(new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS));
        items.add(new ItemStack(Material.YELLOW_STAINED_GLASS));
        items.add(new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS));
        items.add(new ItemStack(Material.PINK_STAINED_GLASS));
        items.add(new ItemStack(Material.GRAY_STAINED_GLASS));
        items.add(new ItemStack(Material.CYAN_STAINED_GLASS));
        items.add(new ItemStack(Material.PURPLE_STAINED_GLASS));
        items.add(new ItemStack(Material.BLUE_STAINED_GLASS));
        items.add(new ItemStack(Material.BROWN_STAINED_GLASS));
        items.add(new ItemStack(Material.GREEN_STAINED_GLASS));
        items.add(new ItemStack(Material.RED_STAINED_GLASS));
        items.add(new ItemStack(Material.BLACK_STAINED_GLASS));

        items.add(new ItemStack(Material.WHITE_CARPET));
        items.add(new ItemStack(Material.ORANGE_CARPET));
        items.add(new ItemStack(Material.PINK_CARPET));
        items.add(new ItemStack(Material.LIGHT_BLUE_CARPET));
        items.add(new ItemStack(Material.YELLOW_CARPET));
        items.add(new ItemStack(Material.LIGHT_GRAY_CARPET));
        items.add(new ItemStack(Material.PINK_CARPET));
        items.add(new ItemStack(Material.GRAY_CARPET));
        items.add(new ItemStack(Material.LIGHT_GRAY_CARPET));
        items.add(new ItemStack(Material.CYAN_CARPET));
        items.add(new ItemStack(Material.PURPLE_CARPET));
        items.add(new ItemStack(Material.BLUE_CARPET));
        items.add(new ItemStack(Material.BROWN_CARPET));
        items.add(new ItemStack(Material.GREEN_CARPET));
        items.add(new ItemStack(Material.RED_CARPET));
        items.add(new ItemStack(Material.BLACK_CARPET));

        items.add(new ItemStack(Material.BLACK_DYE));
        items.add(new ItemStack(Material.ORANGE_DYE));
        items.add(new ItemStack(Material.PINK_DYE));
        items.add(new ItemStack(Material.LIGHT_BLUE_DYE));
        items.add(new ItemStack(Material.YELLOW_DYE));
        items.add(new ItemStack(Material.PINK_DYE));
        items.add(new ItemStack(Material.GRAY_DYE));
        items.add(new ItemStack(Material.LIGHT_GRAY_DYE));
        items.add(new ItemStack(Material.CYAN_DYE));
        items.add(new ItemStack(Material.PURPLE_DYE));
        items.add(new ItemStack(Material.BLUE_DYE));
        items.add(new ItemStack(Material.BROWN_DYE));
        items.add(new ItemStack(Material.GREEN_DYE));
        items.add(new ItemStack(Material.RED_DYE));

        items.add(new ItemStack(Material.BLACK_CONCRETE));
        items.add(new ItemStack(Material.WHITE_CONCRETE));
        items.add(new ItemStack(Material.ORANGE_CONCRETE));
        items.add(new ItemStack(Material.MAGENTA_CONCRETE));
        items.add(new ItemStack(Material.LIGHT_BLUE_CONCRETE));
        items.add(new ItemStack(Material.YELLOW_CONCRETE));
        items.add(new ItemStack(Material.LIGHT_BLUE_CONCRETE));
        items.add(new ItemStack(Material.LIME_CONCRETE));
        items.add(new ItemStack(Material.PINK_CONCRETE));
        items.add(new ItemStack(Material.GRAY_CONCRETE));
        items.add(new ItemStack(Material.LIGHT_GRAY_CONCRETE));
        items.add(new ItemStack(Material.CYAN_CONCRETE));
        items.add(new ItemStack(Material.PURPLE_CONCRETE));
        items.add(new ItemStack(Material.BLUE_CONCRETE));
        items.add(new ItemStack(Material.BROWN_CONCRETE));
        items.add(new ItemStack(Material.GREEN_CONCRETE));
        items.add(new ItemStack(Material.RED_CONCRETE));

        items.add(new ItemStack(Material.TERRACOTTA));
        items.add(new ItemStack(Material.BLACK_TERRACOTTA));
        items.add(new ItemStack(Material.WHITE_TERRACOTTA));
        items.add(new ItemStack(Material.ORANGE_TERRACOTTA));
        items.add(new ItemStack(Material.MAGENTA_TERRACOTTA));
        items.add(new ItemStack(Material.LIGHT_BLUE_TERRACOTTA));
        items.add(new ItemStack(Material.YELLOW_TERRACOTTA));
        items.add(new ItemStack(Material.LIGHT_BLUE_TERRACOTTA));
        items.add(new ItemStack(Material.LIME_TERRACOTTA));
        items.add(new ItemStack(Material.PINK_TERRACOTTA));
        items.add(new ItemStack(Material.GRAY_TERRACOTTA));
        items.add(new ItemStack(Material.LIGHT_GRAY_TERRACOTTA));
        items.add(new ItemStack(Material.CYAN_TERRACOTTA));
        items.add(new ItemStack(Material.PURPLE_TERRACOTTA));
        items.add(new ItemStack(Material.BLUE_TERRACOTTA));
        items.add(new ItemStack(Material.BROWN_TERRACOTTA));
        items.add(new ItemStack(Material.GREEN_TERRACOTTA));
        items.add(new ItemStack(Material.RED_TERRACOTTA));

        items.add(new ItemStack(Material.BLACK_GLAZED_TERRACOTTA));
        items.add(new ItemStack(Material.WHITE_GLAZED_TERRACOTTA));
        items.add(new ItemStack(Material.ORANGE_GLAZED_TERRACOTTA));
        items.add(new ItemStack(Material.MAGENTA_GLAZED_TERRACOTTA));
        items.add(new ItemStack(Material.LIGHT_BLUE_GLAZED_TERRACOTTA));
        items.add(new ItemStack(Material.YELLOW_GLAZED_TERRACOTTA));
        items.add(new ItemStack(Material.LIGHT_BLUE_GLAZED_TERRACOTTA));
        items.add(new ItemStack(Material.LIME_GLAZED_TERRACOTTA));
        items.add(new ItemStack(Material.PINK_GLAZED_TERRACOTTA));
        items.add(new ItemStack(Material.GRAY_GLAZED_TERRACOTTA));
        items.add(new ItemStack(Material.LIGHT_GRAY_GLAZED_TERRACOTTA));
        items.add(new ItemStack(Material.CYAN_GLAZED_TERRACOTTA));
        items.add(new ItemStack(Material.PURPLE_GLAZED_TERRACOTTA));
        items.add(new ItemStack(Material.BLUE_GLAZED_TERRACOTTA));
        items.add(new ItemStack(Material.BROWN_GLAZED_TERRACOTTA));
        items.add(new ItemStack(Material.GREEN_GLAZED_TERRACOTTA));
        items.add(new ItemStack(Material.RED_GLAZED_TERRACOTTA));

        items.add(new ItemStack(Material.BLACK_BANNER));
        items.add(new ItemStack(Material.WHITE_BANNER));
        items.add(new ItemStack(Material.ORANGE_BANNER));
        items.add(new ItemStack(Material.MAGENTA_BANNER));
        items.add(new ItemStack(Material.LIGHT_BLUE_BANNER));
        items.add(new ItemStack(Material.YELLOW_BANNER));
        items.add(new ItemStack(Material.LIGHT_BLUE_BANNER));
        items.add(new ItemStack(Material.LIME_BANNER));
        items.add(new ItemStack(Material.PINK_BANNER));
        items.add(new ItemStack(Material.GRAY_BANNER));
        items.add(new ItemStack(Material.LIGHT_GRAY_BANNER));
        items.add(new ItemStack(Material.CYAN_BANNER));
        items.add(new ItemStack(Material.PURPLE_BANNER));
        items.add(new ItemStack(Material.BLUE_BANNER));
        items.add(new ItemStack(Material.BROWN_BANNER));
        items.add(new ItemStack(Material.GREEN_BANNER));
        items.add(new ItemStack(Material.RED_BANNER));

        //VALUABLES
        items.add(new ItemStack(Material.REDSTONE_BLOCK));
        items.add(new ItemStack(Material.IRON_BLOCK));
        items.add(new ItemStack(Material.GOLD_BLOCK));
        items.add(new ItemStack(Material.LAPIS_BLOCK));
        items.add(new ItemStack(Material.COAL_BLOCK));
        items.add(new ItemStack(Material.EMERALD));
        items.add(new ItemStack(Material.DIAMOND));

        Collections.shuffle(items);
    }

    public ItemStack generateItem() {
        Random rand = new Random();
        ItemStack is = this.items.get(rand.nextInt(items.size()));
        items.remove(is);

        String name = is.getType().name();
        String[] parts = name.split("_");
        String type = parts[parts.length - 1];

        if (type.equals("GLASS") || type.equals("WOOL") || type.equals("DYE") ||
                type.equals("CARPET") || type.equals("LEAVES") || type.equals("BANNER") ||
                type.equals("LEATHER") || type.equals("TERRACOTTA") || type.equals("TULIP") ||
                type.equals("PICKAXE") || type.equals("AXE") || type.equals("SHOVEL") ||
                type.equals("SWORD") || type.equals("CONCRETE") || type.equals("BED") ||
                type.equals("BUCKET")) {
            items.removeIf(item -> item.getType().name().contains(type));
        }

        return is;
    }
}
