package org.domi.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.domi.SpawnItem;
import org.domi.function.NBT;

import java.util.Arrays;
import java.util.List;

public class Commands implements CommandExecutor, TabCompleter{
    private static final SpawnItem plugin = SpawnItem.getInstance();
    public final List<String> list = Arrays.asList("생성", "스폰지정");
    public final List<String> list1 = List.of();

    public Commands() {
        plugin.getCommand("스폰아이템").setExecutor(this);
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player)sender;
        //간단한 명령어 추가 입니다
        if (sender instanceof Player p) {
            if (args.length == 0){
                p.sendMessage("§c§l[§f§l스폰아이템§c§l] §f§l/스폰아이템 생성");
            }else{
                switch (args[0]) {
                    case "생성":
                        ItemStack item = NBT.setStringTag(player.getInventory().getItemInMainHand(), "spawn", "true");
                        ItemMeta im = item.getItemMeta();
                        player.getInventory().remove(player.getInventory().getItemInMainHand());
                        player.getInventory().addItem(item);
                        sender.sendMessage("아이템 기능 추가 완료");
                        break;
                    case "스폰지정":
                        //플레이어가 보는 방향까지
                        player.getWorld().setSpawnLocation(player.getLocation());
                        sender.sendMessage("스폰지정 완료");
                        break;
                }
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            return list;
        }
        return list1;
    }
}
