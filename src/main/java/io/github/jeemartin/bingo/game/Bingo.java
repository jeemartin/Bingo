package io.github.jeemartin.bingo.game;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Bingo {
    private BingoState state;
    private List<UUID> players;
    private List<BingoTeam> teams;
    private int placeIndex = 0;
    private int startTime;

    public Bingo() {
        teams = new ArrayList<BingoTeam>();
        players = new ArrayList<UUID>();
    }

    public Bingo(List<BingoTeam> teams) {
        this.teams = teams;
    }

    public BingoState getState() {
        return this.state;
    }

    public void setState(BingoState state) {
        this.state = state;
    }

    public int getPlaceIndex() {
        return this.placeIndex;
    }

    public void appendPlaceIndex() {
        this.placeIndex++;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public void giveCards() {
        for(BingoTeam team : teams) {
            team.giveCardItem();
        }
    }

    public void removeItems() {
        for(BingoTeam team : teams) {
            team.removeItems();
        }
    }

    public void addTeam(BingoTeam team) {
        if(!teams.contains(team)) {
            teams.add(team);
            for(int i = 0; i < team.getMemberCount(); i++) {
                players.add(team.getMemberUUID(i));
            }
        }
    }

    public void removeTeam(BingoTeam team) {
        if(teams.contains(team)) {
            teams.remove(team);
        }
    }

    public BingoTeam getTeam(Player player) {
        for(BingoTeam team : teams) {
            if(team.hasPlayer(player)) {
                return team;
            }
        }
        return null;
    }

    public BingoTeam getTeam(int index) {
        return teams.get(index);
    }

    public int teamCount() {
        return teams.size();
    }

    private int getIndex(BingoTeam team) {
        for(int i = 0; i < teams.size(); i++) {
            if(team.equals(this.teams.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public UUID getPlayerUUID(int index) {
        return players.get(index);
    }

    public int playerCount() {
        return players.size();
    }

    public Boolean isPlaying(Player player) {
        for(UUID uuid : players) {
            if(player.getUniqueId().equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    public void processFinished(BingoTeam team) {
        int index = getIndex(team);
        if(index != -1) {
            Collections.swap(teams, placeIndex, index);
            team.removeItems();
            team.spectatorMode();
            team.setFinished(true);
            placeIndex++;
        }
    }

    public int getFinishedCount() {
        int count = 0;
        for(BingoTeam team : teams) {
            if(team.isFinished()) {
                count++;
            }
        }
        return count;
    }
}
