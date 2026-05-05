/*    */ package net.minecraft.command;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ 
/*    */ 
/*    */ public class CommandXP
/*    */   extends CommandBase
/*    */ {
/*    */   private static final String __OBFID = "CL_00000398";
/*    */   
/*    */   public String func_71517_b() {
/* 14 */     return "xp";
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_82362_a() {
/* 19 */     return 2;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 25 */     return "commands.xp.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 30 */     if (p_71515_2_.length > 0) {
/*    */       EntityPlayerMP entityPlayerMP;
/* 32 */       String str = p_71515_2_[0];
/*    */       
/* 34 */       boolean bool1 = (str.endsWith("l") || str.endsWith("L")) ? true : false;
/* 35 */       if (bool1 && str.length() > 1) str = str.substring(0, str.length() - 1);
/*    */       
/* 37 */       int i = func_71526_a(p_71515_1_, str);
/* 38 */       boolean bool2 = (i < 0) ? true : false;
/*    */       
/* 40 */       if (bool2) i *= -1;
/*    */       
/* 42 */       if (p_71515_2_.length > 1) {
/* 43 */         entityPlayerMP = func_82359_c(p_71515_1_, p_71515_2_[1]);
/*    */       } else {
/* 45 */         entityPlayerMP = func_71521_c(p_71515_1_);
/*    */       } 
/*    */       
/* 48 */       if (bool1) {
/* 49 */         if (bool2) {
/* 50 */           entityPlayerMP.func_82242_a(-i);
/* 51 */           func_152373_a(p_71515_1_, this, "commands.xp.success.negative.levels", new Object[] { Integer.valueOf(i), entityPlayerMP.func_70005_c_() });
/*    */         } else {
/* 53 */           entityPlayerMP.func_82242_a(i);
/* 54 */           func_152373_a(p_71515_1_, this, "commands.xp.success.levels", new Object[] { Integer.valueOf(i), entityPlayerMP.func_70005_c_() });
/*    */         } 
/*    */       } else {
/* 57 */         if (bool2) {
/* 58 */           throw new WrongUsageException("commands.xp.failure.widthdrawXp", new Object[0]);
/*    */         }
/* 60 */         entityPlayerMP.func_71023_q(i);
/* 61 */         func_152373_a(p_71515_1_, this, "commands.xp.success", new Object[] { Integer.valueOf(i), entityPlayerMP.func_70005_c_() });
/*    */       } 
/*    */ 
/*    */       
/*    */       return;
/*    */     } 
/*    */     
/* 68 */     throw new WrongUsageException("commands.xp.usage", new Object[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
/* 73 */     if (p_71516_2_.length == 2) {
/* 74 */       return func_71530_a(p_71516_2_, func_71542_c());
/*    */     }
/*    */     
/* 77 */     return null;
/*    */   }
/*    */   
/*    */   protected String[] func_71542_c() {
/* 81 */     return MinecraftServer.func_71276_C().func_71213_z();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
/* 86 */     return (p_82358_2_ == 1);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\CommandXP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */