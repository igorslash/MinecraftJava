package miencraftguns.gunsm;

import miencraftguns.gunsm.Events.GunsEvents;
import org.bukkit.plugin.java.JavaPlugin;

public final class GunsM extends JavaPlugin {

    private static GunsM instance;

    private static GunsM getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        getServer().getPluginManager().registerEvents(new GunsEvents(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        instance = null;
    }
}
