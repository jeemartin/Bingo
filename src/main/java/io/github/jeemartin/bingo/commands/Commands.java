package io.github.jeemartin.bingo.commands;

import io.github.jeemartin.bingo.Main;
import io.github.jeemartin.bingo.game.BingoHandler;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Commands implements TabExecutor {
    private Main plugin;

    public Commands(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("bingo").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            return true;
        }
        if(!sender.isOp()) {
            sender.sendMessage("§c[BINGO]: §eYou don't have permission to use this command!");
            return false;
        }

        if(args.length == 0) {
            if(BingoHandler.currentGame == null) {
                sender.sendMessage("§c[BINGO]: §eWrite §c/bingo start §eto start the game!");
            }
            else {
                sender.sendMessage("§c[BINGO]: §eA game is already in progress!");
            }
        }
        else if(args[0].equalsIgnoreCase("start")){

            plugin.reloadConfig();
            int teamSize = (int) plugin.getConfig().get("teamSize");

            if(BingoHandler.currentGame == null) {
                List<Player> players = new ArrayList<Player>(Bukkit.getOnlinePlayers());
                if(players.size() < 2 * teamSize) {
                    sender.sendMessage("§c[BINGO]: §eNot enough players online to start the game!");
                }
                else if(players.size() % teamSize != 0) {
                    sender.sendMessage(String.format("§c[BINGO]: §eThe number of people online has to be a multiple of %d!",
                            teamSize)
                    );
                }
                else {
                    BingoHandler.startGame(plugin, players, ((Player)sender).getWorld());
                }
            }
            else {
                sender.sendMessage("§c[BINGO]: §eA game is already in progress!");
            }
        }
        else if(args[0].equalsIgnoreCase("stop")){
            if(BingoHandler.currentGame != null) {
                BingoHandler.stopGame();
                Bukkit.broadcastMessage("§c[BINGO]: §eGame has been stopped!");
            }
            else {
                sender.sendMessage("§c[BINGO]: §eA game is not in progress!");
            }
        }
        else if(args[0].equalsIgnoreCase("teamsize")) {
            Pattern positiveNumber = Pattern.compile("[1-9]\\d*");

            if(args.length == 1 || (args.length > 1 && !positiveNumber.matcher(args[1]).matches())) {
                sender.sendMessage("§c[BINGO]: §ePlease specify a natural number representing the team size you desire!");
            }
            else {
                int ts = Integer.parseInt(args[1]);
                if(ts > 5) {
                    sender.sendMessage("§c[BINGO]: §eMaximum team size is 5 people!");
                }
                else {
                    plugin.getConfig().set("teamSize", ts);
                    plugin.saveConfig();
                    sender.sendMessage(String.format("§c[BINGO]: §eTeam size has been set to %d!", ts));
                }
            }
        }
        else if(args[0].equalsIgnoreCase("preparetime")) {
            Pattern positiveNumber = Pattern.compile("[1-9]\\d*");

            if(args.length == 1 || (args.length > 1 && !positiveNumber.matcher(args[1]).matches())) {
                sender.sendMessage("§c[BINGO]: §ePlease specify a natural number representing the prepare time (seconds) you desire!");
            }
            else {
                int pt = Integer.parseInt(args[1]);
                if(pt < 10) {
                    sender.sendMessage("§c[BINGO]: §ePrepare time has to be at least 10 seconds long!");
                }
                else if(pt > 100) {
                    sender.sendMessage("§c[BINGO]: §eMaximum prepare time is 100 seconds long!");
                }
                else {
                    plugin.getConfig().set("prepareTime", pt);
                    plugin.saveConfig();
                    sender.sendMessage(String.format("§c[BINGO]: §ePrepare time has been set to %d seconds!", pt));
                }
            }
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            return null;
        }
        Player player = (Player) sender;

        if(args.length == 1) {
            List<String> firstArgs = new ArrayList<>();
            if(player.isOp()) {
                firstArgs.add("start");
                firstArgs.add("stop");
                firstArgs.add("teamsize");
                firstArgs.add("preparetime");
            }
            final List<String> completions = new ArrayList<String>();
            StringUtil.copyPartialMatches(args[0], firstArgs, completions);
            Collections.sort(completions);
            return completions;
        }
        else if(args.length == 2) {
            plugin.reloadConfig();
            if(args[0].equalsIgnoreCase("teamsize") || args[0].equalsIgnoreCase("preparetime")) {

                int ts = (int) plugin.getConfig().get("teamSize");
                int pt = (int) plugin.getConfig().get("prepareTime");
                List<String> secondArgs = new ArrayList<>();

                if(player.isOp()) {
                    if(args[0].equalsIgnoreCase("teamsize")) {
                        secondArgs.add(String.valueOf(ts));
                    }
                    else {
                        secondArgs.add(String.valueOf(pt));
                    }
                }
                final List<String> completions = new ArrayList<>();
                StringUtil.copyPartialMatches(args[1], secondArgs, completions);
                Collections.sort(completions);
                return completions;
            }
        }
        return null;
    }
}
