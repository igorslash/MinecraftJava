package trainin.pluginm;

import org.bukkit.plugin.java.JavaPlugin;
import trainin.pluginm.Commands.Calculator.CalculatorCMD;
import trainin.pluginm.Entity.SpawnCommand;

public final class PluginM extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("calculator").setExecutor(new CalculatorCMD());
        getCommand("spawnEntity").setExecutor(new SpawnCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
