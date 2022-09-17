package miencraftguns.gunsm.Guns;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.RayTraceResult;

public enum Gun {
    AKM(10,30, "AKM", Material.CYAN_DYE),
    GLOCK(2, 20, "GLOCK", Material.INK_SAC);

    public static Gun getGunFrom(ItemStack itemStack) {
        ItemMeta meta = itemStack.getItemMeta();
        String name = meta.getPersistentDataContainer()
                .get(NamespacedKey.fromString("gun_name"), PersistentDataType.STRING);
        if (name == null) {
            return null;
        }
        Gun gun = valueOf(name);
        return gun;
    }

    private double damage;
    private int bulletsNum;
    private String name;
    private Material gunMaterial;

    Gun(double damage, int bulletsNum, String name, Material gunMaterial) {
        this.damage = damage;
        this.bulletsNum = bulletsNum;
        this.name = name;
        this.gunMaterial = gunMaterial;
    }

    public void shot(ItemStack itemStack, Player player) {
        ItemMeta meta = itemStack.getItemMeta();
        int bullets = meta.getPersistentDataContainer()
                .get(NamespacedKey.fromString("bullets_num"), PersistentDataType.INTEGER);
        if (bullets <= 0) {
            return;
        }
        meta.getPersistentDataContainer().set(NamespacedKey.fromString("bullets_num"),
                PersistentDataType.INTEGER, bullets - 1);

        RayTraceResult rayTraceResult = player.getWorld().rayTraceEntities(
                player.getEyeLocation(),
                player.getLocation().getDirection(),
                100,
                entity -> entity != player && entity instanceof LivingEntity);
        if (rayTraceResult != null) {
            LivingEntity target = (LivingEntity) rayTraceResult.getHitEntity();
            target.damage(damage);
        }

        RayTraceResult rayTraceBlocks = player.getWorld().rayTraceBlocks(player
                .getEyeLocation(), player.getLocation().getDirection(), 99);
        if (rayTraceBlocks == null) {
            return;
        }
        Block block = rayTraceBlocks.getHitBlock();
        // Проверяем, находится ли он ближе, чем сущность
        if (block != null) {
            if (player.getLocation().distance(block.getLocation()) < player
                    .getLocation().distance(player.getLocation())) {
                return;
            }
        }
    }
    public void reload(ItemStack itemStack) {
        ItemMeta meta = itemStack.getItemMeta();
        meta.getPersistentDataContainer().set(NamespacedKey.fromString("bullets_num"),
                PersistentDataType.INTEGER, bulletsNum);
        itemStack.setItemMeta(meta);

    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public int getBulletsNum() {
        return bulletsNum;
    }

    public void setBulletsNum(int bulletsNum) {
        this.bulletsNum = bulletsNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Material getGunMaterial() {
        return gunMaterial;
    }

    public void setGunMaterial(Material gunMaterial) {
        this.gunMaterial = gunMaterial;
    }
}
