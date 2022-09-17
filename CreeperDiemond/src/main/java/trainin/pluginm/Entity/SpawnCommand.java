package trainin.pluginm.Entity;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        Creeper creeper = (Creeper) player.getWorld().spawnEntity(player.getLocation(),
                EntityType.CREEPER);
        creeper.setPowered(true);
        creeper.ignite();
        creeper.setMaxFuseTicks(10);
        return true;
    }
}
