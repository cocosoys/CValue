/*    */ package net.minecraft.command.server;
/*    */ import java.util.List;
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.ICommand;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.command.PlayerNotFoundException;
/*    */ import net.minecraft.command.WrongUsageException;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ 
/*    */ public class CommandTeleport extends CommandBase {
/*    */   public String func_71517_b() {
/* 13 */     return "tp";
/*    */   }
/*    */   private static final String __OBFID = "CL_00001180";
/*    */   
/*    */   public int func_82362_a() {
/* 18 */     return 2;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 24 */     return "commands.tp.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 29 */     if (p_71515_2_.length >= 1) {
/*    */       EntityPlayerMP entityPlayerMP;
/*    */       
/* 32 */       if (p_71515_2_.length == 2 || p_71515_2_.length == 4) {
/* 33 */         entityPlayerMP = func_82359_c(p_71515_1_, p_71515_2_[0]);
/* 34 */         if (entityPlayerMP == null) throw new PlayerNotFoundException(); 
/*    */       } else {
/* 36 */         entityPlayerMP = func_71521_c(p_71515_1_);
/*    */       } 
/*    */       
/* 39 */       if (p_71515_2_.length == 3 || p_71515_2_.length == 4) {
/* 40 */         if (entityPlayerMP.field_70170_p != null) {
/* 41 */           int i = p_71515_2_.length - 3;
/*    */           
/* 43 */           double d1 = func_110666_a(p_71515_1_, entityPlayerMP.field_70165_t, p_71515_2_[i++]);
/* 44 */           double d2 = func_110665_a(p_71515_1_, entityPlayerMP.field_70163_u, p_71515_2_[i++], 0, 0);
/* 45 */           double d3 = func_110666_a(p_71515_1_, entityPlayerMP.field_70161_v, p_71515_2_[i++]);
/*    */           
/* 47 */           entityPlayerMP.func_70078_a(null);
/* 48 */           entityPlayerMP.func_70634_a(d1, d2, d3);
/* 49 */           func_152373_a(p_71515_1_, (ICommand)this, "commands.tp.success.coordinates", new Object[] { entityPlayerMP.func_70005_c_(), Double.valueOf(d1), Double.valueOf(d2), Double.valueOf(d3) });
/*    */         } 
/* 51 */       } else if (p_71515_2_.length == 1 || p_71515_2_.length == 2) {
/* 52 */         EntityPlayerMP entityPlayerMP1 = func_82359_c(p_71515_1_, p_71515_2_[p_71515_2_.length - 1]);
/* 53 */         if (entityPlayerMP1 == null) throw new PlayerNotFoundException(); 
/* 54 */         if (entityPlayerMP1.field_70170_p != entityPlayerMP.field_70170_p) {
/* 55 */           func_152373_a(p_71515_1_, (ICommand)this, "commands.tp.notSameDimension", new Object[0]);
/*    */           
/*    */           return;
/*    */         } 
/* 59 */         entityPlayerMP.func_70078_a(null);
/* 60 */         entityPlayerMP.field_71135_a.func_147364_a(entityPlayerMP1.field_70165_t, entityPlayerMP1.field_70163_u, entityPlayerMP1.field_70161_v, entityPlayerMP1.field_70177_z, entityPlayerMP1.field_70125_A);
/* 61 */         func_152373_a(p_71515_1_, (ICommand)this, "commands.tp.success", new Object[] { entityPlayerMP.func_70005_c_(), entityPlayerMP1.func_70005_c_() });
/*    */       } 
/*    */       
/*    */       return;
/*    */     } 
/*    */     
/* 67 */     throw new WrongUsageException("commands.tp.usage", new Object[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
/* 72 */     if (p_71516_2_.length == 1 || p_71516_2_.length == 2) {
/* 73 */       return func_71530_a(p_71516_2_, MinecraftServer.func_71276_C().func_71213_z());
/*    */     }
/*    */     
/* 76 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
/* 81 */     return (p_82358_2_ == 0);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\server\CommandTeleport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */