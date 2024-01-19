package org.domi.function;

import net.minecraft.nbt.NBTTagCompound;
import org.bukkit.craftbukkit.v1_20_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class NBT {

    //이거는 nms 을 사용해서 아이템에게 nbt태그를 추가하는 메소드들 입니다.


    public static NBTTagCompound getTagCompound(net.minecraft.world.item.ItemStack item) {
        return item.u() ? item.v() : new NBTTagCompound();
    }

    @NotNull
    public static ItemStack setStringTag(ItemStack objitem, String key, String value) {
        System.out.println("setStringTag");
        net.minecraft.world.item.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = getTagCompound(item);
        ntc.a(key, value);
        item.c(ntc);
        return CraftItemStack.asBukkitCopy(item);
    }


    public static boolean hasTagKey(ItemStack objitem, String key) {
        net.minecraft.world.item.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = getTagCompound(item);
        return ntc.e(key);
    }
}
