package trainin.pluginm.Commands.Calculator;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CalculatorCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        int x, y;
        x = Integer.parseInt(args[0]);
        y = Integer.parseInt(args[2]);
        if (args[1].equals("+")) {
            sender.sendMessage("result =" + (x + y));
        }
        else if (args[2].equals("-")) {
            sender.sendMessage("result =" + (x - y));
        }
        return false;
    }
}
