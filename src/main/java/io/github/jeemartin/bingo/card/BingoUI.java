package io.github.jeemartin.bingo.card;

import io.github.jeemartin.bingo.game.BingoTeam;
import io.github.jeemartin.bingo.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BingoUI {
    private Inventory inventory;
    private int size = 45;
    private BingoTeam team;
    private List<Integer> borderSlots = new ArrayList<Integer>(Arrays.asList(
            0, 1, 7, 8, 9, 10, 16, 17, 18, 19, 25, 26, 27, 28, 34, 35, 36, 37, 43, 44));

    public BingoUI(BingoTeam team) {
        this.team = team;
        inventory = Bukkit.createInventory(null, size, team.getTitleUI());
    }

    public void open(Player p) {
        this.addItems();
        p.openInventory(inventory);
    }

    private void addItems() {
        BingoCard bc = team.getBingoCard();
        ItemStack[] items = bc.getOneDimension();

        int x = 0;
        for(int i = 0; i < size; i++) {
            if(borderSlots.contains(i)) {
                inventory.setItem(i, createItemStack(Material.BLACK_STAINED_GLASS_PANE, " "));
            }
            else {
                if(items[x] == null) {
                    String name = "§aSlot Filled!";
                    inventory.setItem(i, createItemStack(Material.LIME_STAINED_GLASS_PANE, name));
                }
                else {
                    String name = "§4Missing " + Utils.formatMaterialName(items[x].getType());
                    inventory.setItem(i, createItemStack(items[x].getType(), name));
                }
                x++;
            }
        }
    }

    private ItemStack createItemStack(Material material, String name) {
        ItemStack is = new ItemStack(material);
        ItemMeta meta = is.getItemMeta();
        meta.setDisplayName(name);
        is.setItemMeta(meta);
        return is;
    }
}
