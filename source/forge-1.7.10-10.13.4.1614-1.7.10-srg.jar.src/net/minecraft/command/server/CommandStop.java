/*    */ package net.minecraft.command.server;
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.ICommand;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ 
/*    */ public class CommandStop extends CommandBase {
/*    */   public String func_71517_b() {
/*  9 */     return "stop";
/*    */   }
/*    */   private static final String __OBFID = "CL_00001132";
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 14 */     return "commands.stop.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 19 */     if ((MinecraftServer.func_71276_C()).field_71305_c != null) {
/* 20 */       func_152373_a(p_71515_1_, (ICommand)this, "commands.stop.start", new Object[0]);
/*    */     }
/* 22 */     MinecraftServer.func_71276_C().func_71263_m();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\server\CommandStop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */