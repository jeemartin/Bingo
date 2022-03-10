package io.github.jeemartin.bingo.card;

import org.bukkit.inventory.ItemStack;

public class BingoCard {
    private ItemStack[][] card = new ItemStack[5][5];

    public BingoCard(ItemStack[][] items) {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                this.card[i][j] = items[i][j];
            }
        }
    }

    public ItemStack[] getOneDimension() {
        ItemStack[] converted = new ItemStack[25];
        int x = 0;
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                converted[x++] = this.card[i][j];
            }
        }
        return converted;
    }

    private Boolean containsItem(ItemStack is) {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                ItemStack current = this.card[i][j];
                if(current != null && current.getType() == is.getType()) {
                    return true;
                }
            }
        }
        return false;
    }

    public Boolean fillItem(ItemStack is) {
        if(this.containsItem(is)) {
            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 5; j++) {
                    ItemStack current = this.card[i][j];
                    if(current != null && current.getType() == is.getType()) {
                        this.card[i][j] = null;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public Boolean isComplete() {
        //horizontal
        for(int j = 0; j < 1; j++){
            for(int i = 0; i < 5; i++){
                if (card[i][j] == null && card[i][j+1] == null && card[i][j+2] == null &&
                        card[i][j+3] == null && card[i][j+4] == null) {
                    return true;
                }
            }
        }
        //vertical
        for(int i = 0; i < 1; i++){
            for(int j = 0; j < 5; j++){
                if (card[i][j] == null && card[i+1][j] == null && card[i+2][j] == null &&
                        card[i+3][j] == null && card[i+4][j] == null) {
                    return true;
                }
            }
        }
        //diagonalAscending
        for(int i = 4; i < 5; i++){
            for(int j = 0; j < 1; j++){
                if (card[i][j] == null && card[i-1][j+1] == null && card[i-2][j+2] == null &&
                        card[i-3][j+3] == null && card[i-4][j+4] == null) {
                    return true;
                }
            }
        }
        //diagonalDescending
        for(int i = 4; i < 5; i++){
            for(int j = 4; j < 5; j++){
                if (card[i][j] == null && card[i-1][j-1] == null && card[i-2][j-2] == null &&
                        card[i-3][j-3] == null && card[i-4][j-4] == null) {
                    return true;
                }
            }
        }
        return false;
    }
}
