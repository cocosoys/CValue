package net.minecraft.command;

import java.util.List;

public interface ICommand extends Comparable {
  String func_71517_b();
  
  String func_71518_a(ICommandSender paramICommandSender);
  
  List func_71514_a();
  
  void func_71515_b(ICommandSender paramICommandSender, String[] paramArrayOfString);
  
  boolean func_71519_b(ICommandSender paramICommandSender);
  
  List func_71516_a(ICommandSender paramICommandSender, String[] paramArrayOfString);
  
  boolean func_82358_a(String[] paramArrayOfString, int paramInt);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\ICommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */