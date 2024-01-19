package org.domi.function;

import net.minecraft.server.v1_16_R3.NBTTagCompound;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class NBT {

    //이거는 nms 을 사용해서 아이템에게 nbt태그를 추가하는 메소드들 입니다.
    @NotNull
    public static ItemStack setStringTag(ItemStack objitem, String key, String value) {
        net.minecraft.server.v1_16_R3.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.hasTag() ? item.getTag() : new NBTTagCompound();
        ntc.setString(key, value);
        item.setTag(ntc);
        return CraftItemStack.asBukkitCopy(item);
    }


    public static boolean hasTagKey(ItemStack objitem, String key) {
        net.minecraft.server.v1_16_R3.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.hasTag() ? item.getTag() : new NBTTagCompound();
        return ntc.hasKey(key);
    }
}
