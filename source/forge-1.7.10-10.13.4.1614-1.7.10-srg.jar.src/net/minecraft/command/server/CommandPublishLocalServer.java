/*    */ package net.minecraft.command.server;
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.ICommand;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.world.WorldSettings;
/*    */ 
/*    */ public class CommandPublishLocalServer extends CommandBase {
/*    */   public String func_71517_b() {
/* 10 */     return "publish";
/*    */   }
/*    */   private static final String __OBFID = "CL_00000799";
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 15 */     return "commands.publish.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 20 */     String str = MinecraftServer.func_71276_C().func_71206_a(WorldSettings.GameType.SURVIVAL, false);
/*    */     
/* 22 */     if (str != null) {
/* 23 */       func_152373_a(p_71515_1_, (ICommand)this, "commands.publish.started", new Object[] { str });
/*    */     } else {
/* 25 */       func_152373_a(p_71515_1_, (ICommand)this, "commands.publish.failed", new Object[0]);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\server\CommandPublishLocalServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */