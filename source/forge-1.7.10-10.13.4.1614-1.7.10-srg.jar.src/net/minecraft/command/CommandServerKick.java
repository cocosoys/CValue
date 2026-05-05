/*    */ package net.minecraft.command;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CommandServerKick
/*    */   extends CommandBase
/*    */ {
/*    */   private static final String __OBFID = "CL_00000550";
/*    */   
/*    */   public String func_71517_b() {
/* 15 */     return "kick";
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_82362_a() {
/* 20 */     return 2;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 26 */     return "commands.kick.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 31 */     if (p_71515_2_.length > 0 && p_71515_2_[0].length() > 1) {
/* 32 */       EntityPlayerMP entityPlayerMP = MinecraftServer.func_71276_C().func_71203_ab().func_152612_a(p_71515_2_[0]);
/* 33 */       String str = "Kicked by an operator.";
/* 34 */       boolean bool = false;
/*    */       
/* 36 */       if (entityPlayerMP == null) {
/* 37 */         throw new PlayerNotFoundException();
/*    */       }
/*    */       
/* 40 */       if (p_71515_2_.length >= 2) {
/* 41 */         str = func_147178_a(p_71515_1_, p_71515_2_, 1).func_150260_c();
/* 42 */         bool = true;
/*    */       } 
/*    */       
/* 45 */       entityPlayerMP.field_71135_a.func_147360_c(str);
/*    */       
/* 47 */       if (bool) {
/* 48 */         func_152373_a(p_71515_1_, this, "commands.kick.success.reason", new Object[] { entityPlayerMP.func_70005_c_(), str });
/*    */       } else {
/* 50 */         func_152373_a(p_71515_1_, this, "commands.kick.success", new Object[] { entityPlayerMP.func_70005_c_() });
/*    */       } 
/*    */       
/*    */       return;
/*    */     } 
/*    */     
/* 56 */     throw new WrongUsageException("commands.kick.usage", new Object[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
/* 61 */     if (p_71516_2_.length >= 1) {
/* 62 */       return func_71530_a(p_71516_2_, MinecraftServer.func_71276_C().func_71213_z());
/*    */     }
/*    */     
/* 65 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\CommandServerKick.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */