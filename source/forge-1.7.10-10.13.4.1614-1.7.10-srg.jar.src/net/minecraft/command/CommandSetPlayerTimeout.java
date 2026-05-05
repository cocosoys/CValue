/*    */ package net.minecraft.command;
/*    */ 
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ 
/*    */ public class CommandSetPlayerTimeout
/*    */   extends CommandBase
/*    */ {
/*    */   private static final String __OBFID = "CL_00000999";
/*    */   
/*    */   public String func_71517_b() {
/* 11 */     return "setidletimeout";
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_82362_a() {
/* 16 */     return 3;
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 21 */     return "commands.setidletimeout.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 26 */     if (p_71515_2_.length == 1) {
/* 27 */       int i = func_71528_a(p_71515_1_, p_71515_2_[0], 0);
/* 28 */       MinecraftServer.func_71276_C().func_143006_e(i);
/* 29 */       func_152373_a(p_71515_1_, this, "commands.setidletimeout.success", new Object[] { Integer.valueOf(i) });
/*    */       
/*    */       return;
/*    */     } 
/* 33 */     throw new WrongUsageException("commands.setidletimeout.usage", new Object[0]);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\CommandSetPlayerTimeout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */