package trainin.pluginm.items;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GiveItems implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command,
                             String label, String[] args) {
        Player player = (Player) sender;
        if (args[0].equalsIgnoreCase("give")) {
            ItemStack itemStack = new ItemStack(Material.ACACIA_WOOD, 10);
            ItemMeta itemMeta = itemStack.getItemMeta();
            assert itemMeta != null;
            itemMeta.setDisplayName("Great wood");
            List<String> list = new ArrayList<>();
            list.add("Many");
            list.add("Great wood");

            itemMeta.setLore(list);
            itemStack.setItemMeta(itemMeta);

            itemMeta.getPersistentDataContainer().set(Objects.
                            requireNonNull(NamespacedKey.fromString("num")),
                    PersistentDataType.INTEGER, 5);

            player.getInventory().addItem(itemStack);

        } else if (args[0].equalsIgnoreCase("subtractOne")) {
            ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
            if (itemInMainHand.getType() != Material.AIR) {
                if (itemInMainHand.getItemMeta().getPersistentDataContainer()
                        .get(NamespacedKey.fromString("num"),
                                PersistentDataType.INTEGER) != null) ;

                ItemMeta itemMeta = itemInMainHand.getItemMeta();
                int num = itemMeta.getPersistentDataContainer()
                        .get(NamespacedKey.fromString("num"), PersistentDataType.INTEGER);
                num = num - 1;

                if (num >= 0) {
                    ItemStack diemond = new ItemStack(Material.DIAMOND);
                    player.getInventory().addItem(diemond);

                    itemMeta.getPersistentDataContainer()
                            .set(NamespacedKey.fromString("num"),
                                    PersistentDataType.INTEGER, num);
                    itemInMainHand.setItemMeta(itemMeta);
                }
            }

        }
        return true;
    }
}
