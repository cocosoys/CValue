package soys.dragoncore.cvalue.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

import java.util.List;

public class CValueCommand extends CommandBase {
    public String getCommandName() {
        return "cvalue";
    }

    public String getCommandUsage(ICommandSender p_71518_1_) {
        return "/cvalue help";
    }

    public void processCommand(ICommandSender p_71515_1_, String[] p_71515_2_) {

    }

    public int getRequiredPermissionLevel() {
        return 4;
    }

    public List addTabCompletionOptions(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
        return null;
    }
}
