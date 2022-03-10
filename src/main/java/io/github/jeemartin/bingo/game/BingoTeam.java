package io.github.jeemartin.bingo.game;

import io.github.jeemartin.bingo.card.BingoCard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class BingoTeam {
    private String name;
    private ChatColor color;
    private String titleUI;
    private UUID[] members;
    private int memberCount;
    private BingoCard bingoCard;
    private ItemStack cardItem;
    private Boolean finished;
    private int time;

    public BingoTeam(TeamAppearance appearance, UUID[] members, BingoCard bingoCard, ItemStack cardItem) {
        this.name = appearance.getName();
        this.color = appearance.getColor();
        this.titleUI = appearance.getTitle();
        this.members = members;
        this.memberCount = members.length;
        this.bingoCard = bingoCard;
        this.cardItem = cardItem;
        this.finished = false;
        this.time = -1;
    }

    @Override
    public boolean equals(Object obj){
        if(this.getName().equals(((BingoTeam)obj).getName())) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }

    public String getName() {
        return this.name;
    }

    public ChatColor getColor() {
        return this.color;
    }

    public String getTitleUI() {
        return this.titleUI;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public BingoCard getBingoCard() {
        return this.bingoCard;
    }

    public ItemStack getCardItem() {
        return this.cardItem;
    }

    public Boolean isFinished() {
        return this.finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public UUID getMemberUUID(int index) {
        return this.members[index];
    }

    public boolean hasPlayer(Player player) {
        for(int i = 0; i < members.length; i++) {
            if(members[i].equals(player.getUniqueId())) {
                return true;
            }
        }
        return false;
    }

    public void giveCardItem() {
        for(Player p : Bukkit.getOnlinePlayers()) {
            if(this.hasPlayer(p)) {
                p.getInventory().addItem(this.cardItem);
            }
        }
    }

    public void removeItems() {
        for(Player p : Bukkit.getOnlinePlayers()) {
            if(this.hasPlayer(p)) {
                p.getInventory().clear();
            }
        }
    }

    public void spectatorMode() {
        for(Player p : Bukkit.getOnlinePlayers()) {
            if(this.hasPlayer(p)) {
                p.setGameMode(GameMode.SPECTATOR);
            }
        }
    }
}
