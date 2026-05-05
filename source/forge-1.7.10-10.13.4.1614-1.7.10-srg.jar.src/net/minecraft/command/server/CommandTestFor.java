/*    */ package net.minecraft.command.server;
/*    */ 
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.CommandException;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.command.WrongUsageException;
/*    */ 
/*    */ public class CommandTestFor
/*    */   extends CommandBase {
/*    */   private static final String __OBFID = "CL_00001182";
/*    */   
/*    */   public String func_71517_b() {
/* 13 */     return "testfor";
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_82362_a() {
/* 18 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 23 */     return "commands.testfor.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 28 */     if (p_71515_2_.length != 1) throw new WrongUsageException("commands.testfor.usage", new Object[0]); 
/* 29 */     if (!(p_71515_1_ instanceof CommandBlockLogic)) throw new CommandException("commands.testfor.failed", new Object[0]); 
/* 30 */     func_82359_c(p_71515_1_, p_71515_2_[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
/* 35 */     return (p_82358_2_ == 0);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\server\CommandTestFor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */