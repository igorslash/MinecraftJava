package miencraftguns.gunsm.HandlerArm;

import miencraftguns.gunsm.Guns.Gun;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class ArmsHandler {
    public static void handle(Gun gun, Player player) {
        ItemStack gunItem = new ItemStack(gun.getGunMaterial());
        ItemMeta meta = gunItem.getItemMeta();
        meta.getPersistentDataContainer().set(NamespacedKey
                .fromString("gun_name"), PersistentDataType.STRING, gun.getName());
        meta.getPersistentDataContainer().set(NamespacedKey.fromString("Bullets_num"),
                PersistentDataType.INTEGER, gun.getBulletsNum());

        meta.setDisplayName(gun.getName());

        gunItem.setItemMeta(meta);

        player.getInventory().addItem(gunItem);
    }
}
