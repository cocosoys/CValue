/*    */ package net.minecraft.command.server;
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.CommandException;
/*    */ import net.minecraft.command.ICommand;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.world.WorldServer;
/*    */ 
/*    */ public class CommandSaveOff extends CommandBase {
/*    */   public String func_71517_b() {
/* 11 */     return "save-off";
/*    */   }
/*    */   private static final String __OBFID = "CL_00000847";
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 16 */     return "commands.save-off.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 21 */     MinecraftServer minecraftServer = MinecraftServer.func_71276_C();
/* 22 */     boolean bool = false;
/*    */     
/* 24 */     for (byte b = 0; b < minecraftServer.field_71305_c.length; b++) {
/* 25 */       if (minecraftServer.field_71305_c[b] != null) {
/* 26 */         WorldServer worldServer = minecraftServer.field_71305_c[b];
/* 27 */         if (!worldServer.field_73058_d) {
/* 28 */           worldServer.field_73058_d = true;
/* 29 */           bool = true;
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 34 */     if (bool) {
/* 35 */       func_152373_a(p_71515_1_, (ICommand)this, "commands.save.disabled", new Object[0]);
/*    */     } else {
/* 37 */       throw new CommandException("commands.save-off.alreadyOff", new Object[0]);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\server\CommandSaveOff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */