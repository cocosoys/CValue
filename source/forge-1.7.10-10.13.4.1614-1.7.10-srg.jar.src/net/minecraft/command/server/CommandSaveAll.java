/*    */ package net.minecraft.command.server;
/*    */ import net.minecraft.command.ICommand;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.util.ChatComponentTranslation;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ import net.minecraft.world.MinecraftException;
/*    */ import net.minecraft.world.WorldServer;
/*    */ 
/*    */ public class CommandSaveAll extends CommandBase {
/*    */   public String func_71517_b() {
/* 12 */     return "save-all";
/*    */   }
/*    */   private static final String __OBFID = "CL_00000826";
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 17 */     return "commands.save.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 22 */     MinecraftServer minecraftServer = MinecraftServer.func_71276_C();
/*    */     
/* 24 */     p_71515_1_.func_145747_a((IChatComponent)new ChatComponentTranslation("commands.save.start", new Object[0]));
/*    */     
/* 26 */     if (minecraftServer.func_71203_ab() != null) {
/* 27 */       minecraftServer.func_71203_ab().func_72389_g();
/*    */     }
/*    */     try {
/*    */       byte b;
/* 31 */       for (b = 0; b < minecraftServer.field_71305_c.length; b++) {
/* 32 */         if (minecraftServer.field_71305_c[b] != null) {
/* 33 */           WorldServer worldServer = minecraftServer.field_71305_c[b];
/* 34 */           boolean bool = worldServer.field_73058_d;
/* 35 */           worldServer.field_73058_d = false;
/* 36 */           worldServer.func_73044_a(true, null);
/* 37 */           worldServer.field_73058_d = bool;
/*    */         } 
/*    */       } 
/* 40 */       if (p_71515_2_.length > 0 && "flush".equals(p_71515_2_[0])) {
/* 41 */         p_71515_1_.func_145747_a((IChatComponent)new ChatComponentTranslation("commands.save.flushStart", new Object[0]));
/* 42 */         for (b = 0; b < minecraftServer.field_71305_c.length; b++) {
/* 43 */           if (minecraftServer.field_71305_c[b] != null) {
/* 44 */             WorldServer worldServer = minecraftServer.field_71305_c[b];
/* 45 */             boolean bool = worldServer.field_73058_d;
/* 46 */             worldServer.field_73058_d = false;
/* 47 */             worldServer.func_104140_m();
/* 48 */             worldServer.field_73058_d = bool;
/*    */           } 
/*    */         } 
/* 51 */         p_71515_1_.func_145747_a((IChatComponent)new ChatComponentTranslation("commands.save.flushEnd", new Object[0]));
/*    */       } 
/* 53 */     } catch (MinecraftException minecraftException) {
/* 54 */       func_152373_a(p_71515_1_, (ICommand)this, "commands.save.failed", new Object[] { minecraftException.getMessage() });
/*    */       
/*    */       return;
/*    */     } 
/* 58 */     func_152373_a(p_71515_1_, (ICommand)this, "commands.save.success", new Object[0]);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\server\CommandSaveAll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */