package org.domi.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.domi.SpawnItem;
import org.domi.function.NBT;

public class Event implements Listener {
    private static final SpawnItem plugin = SpawnItem.getInstance();

    //이벤트 등록
    public Event() {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e){

        //이벤트를 발생 시킨 플레이어를 player로 지정
        Player player = e.getPlayer();

        //만약에 플레이어의 손에 들린 아이템에 spawn 태그가 있다면
        if (NBT.hasTagKey(player.getInventory().getItemInMainHand(), "spawn")){

            //만약 플레이어가 공기를 향해 우클 혹은 블럭을 향해서 우클
            if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK ){

                //플레이어 위치를 스폰으로 이동
                player.teleport(player.getWorld().getSpawnLocation());
            }
        }
    }

    //click bed event
    @EventHandler
    public void onClickBed(PlayerInteractEvent e){
        Player player = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK){
            if (e.getClickedBlock().getType() == Material.GREEN_BED || e.getClickedBlock().getType() == Material.BLACK_BED || e.getClickedBlock().getType() == Material.BROWN_BED || e.getClickedBlock().getType() == Material.BLUE_BED || e.getClickedBlock().getType() == Material.CYAN_BED || e.getClickedBlock().getType() == Material.GRAY_BED || e.getClickedBlock().getType() == Material.LIGHT_BLUE_BED || e.getClickedBlock().getType() == Material.LIGHT_GRAY_BED || e.getClickedBlock().getType() == Material.LIME_BED || e.getClickedBlock().getType() == Material.MAGENTA_BED || e.getClickedBlock().getType() == Material.ORANGE_BED || e.getClickedBlock().getType() == Material.PINK_BED || e.getClickedBlock().getType() == Material.PURPLE_BED || e.getClickedBlock().getType() == Material.RED_BED || e.getClickedBlock().getType() == Material.WHITE_BED || e.getClickedBlock().getType() == Material.YELLOW_BED){
                player.getWorld().setSpawnLocation(e.getClickedBlock().getLocation());
            }
        }
    }
}
