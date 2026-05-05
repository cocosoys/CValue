/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CommandStop
/*    */   extends CommandAbstract
/*    */ {
/*    */   public String getCommand() {
/*  9 */     return "stop";
/*    */   }
/*    */ 
/*    */   
/*    */   public String c(ICommandListener paramICommandListener) {
/* 14 */     return "commands.stop.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(ICommandListener paramICommandListener, String[] paramArrayOfString) {
/* 19 */     if ((MinecraftServer.getServer()).worldServer != null) {
/* 20 */       a(paramICommandListener, this, "commands.stop.start", new Object[0]);
/*    */     }
/* 22 */     MinecraftServer.getServer().safeShutdown();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\CommandStop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */