package trainin.pluginm;

import org.bukkit.plugin.java.JavaPlugin;
import trainin.pluginm.Entity.SpawnCommand;
import trainin.pluginm.items.GiveItems;

public final class PluginM extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("spawnEntity").setExecutor(new SpawnCommand());
        getCommand("giveItem").setExecutor(new GiveItems());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
