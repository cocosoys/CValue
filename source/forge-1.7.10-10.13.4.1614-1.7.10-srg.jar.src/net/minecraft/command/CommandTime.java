/*    */ package net.minecraft.command;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.world.WorldServer;
/*    */ 
/*    */ public class CommandTime
/*    */   extends CommandBase
/*    */ {
/*    */   private static final String __OBFID = "CL_00001183";
/*    */   
/*    */   public String func_71517_b() {
/* 13 */     return "time";
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_82362_a() {
/* 18 */     return 2;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 24 */     return "commands.time.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 29 */     if (p_71515_2_.length > 1) {
/* 30 */       if (p_71515_2_[0].equals("set")) {
/*    */         int i;
/*    */         
/* 33 */         if (p_71515_2_[1].equals("day")) {
/* 34 */           i = 1000;
/* 35 */         } else if (p_71515_2_[1].equals("night")) {
/* 36 */           i = 13000;
/*    */         } else {
/* 38 */           i = func_71528_a(p_71515_1_, p_71515_2_[1], 0);
/*    */         } 
/*    */         
/* 41 */         func_71552_a(p_71515_1_, i);
/* 42 */         func_152373_a(p_71515_1_, this, "commands.time.set", new Object[] { Integer.valueOf(i) }); return;
/*    */       } 
/* 44 */       if (p_71515_2_[0].equals("add")) {
/* 45 */         int i = func_71528_a(p_71515_1_, p_71515_2_[1], 0);
/* 46 */         func_71553_b(p_71515_1_, i);
/*    */         
/* 48 */         func_152373_a(p_71515_1_, this, "commands.time.added", new Object[] { Integer.valueOf(i) });
/*    */         
/*    */         return;
/*    */       } 
/*    */     } 
/* 53 */     throw new WrongUsageException("commands.time.usage", new Object[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
/* 58 */     if (p_71516_2_.length == 1)
/* 59 */       return func_71530_a(p_71516_2_, new String[] { "set", "add" }); 
/* 60 */     if (p_71516_2_.length == 2 && p_71516_2_[0].equals("set")) {
/* 61 */       return func_71530_a(p_71516_2_, new String[] { "day", "night" });
/*    */     }
/*    */     
/* 64 */     return null;
/*    */   }
/*    */   
/*    */   protected void func_71552_a(ICommandSender p_71552_1_, int p_71552_2_) {
/* 68 */     for (byte b = 0; b < (MinecraftServer.func_71276_C()).field_71305_c.length; b++) {
/* 69 */       (MinecraftServer.func_71276_C()).field_71305_c[b].func_72877_b(p_71552_2_);
/*    */     }
/*    */   }
/*    */   
/*    */   protected void func_71553_b(ICommandSender p_71553_1_, int p_71553_2_) {
/* 74 */     for (byte b = 0; b < (MinecraftServer.func_71276_C()).field_71305_c.length; b++) {
/* 75 */       WorldServer worldServer = (MinecraftServer.func_71276_C()).field_71305_c[b];
/* 76 */       worldServer.func_72877_b(worldServer.func_72820_D() + p_71553_2_);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\CommandTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */