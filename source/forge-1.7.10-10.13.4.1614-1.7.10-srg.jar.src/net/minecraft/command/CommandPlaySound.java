/*    */ package net.minecraft.command;
/*    */ 
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.play.server.S29PacketSoundEffect;
/*    */ 
/*    */ public class CommandPlaySound
/*    */   extends CommandBase
/*    */ {
/*    */   private static final String __OBFID = "CL_00000774";
/*    */   
/*    */   public String func_71517_b() {
/* 13 */     return "playsound";
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_82362_a() {
/* 18 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 23 */     return "commands.playsound.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 28 */     if (p_71515_2_.length < 2) {
/* 29 */       throw new WrongUsageException(func_71518_a(p_71515_1_), new Object[0]);
/*    */     }
/*    */     
/* 32 */     byte b = 0;
/* 33 */     String str = p_71515_2_[b++];
/* 34 */     EntityPlayerMP entityPlayerMP = func_82359_c(p_71515_1_, p_71515_2_[b++]);
/* 35 */     double d1 = (entityPlayerMP.func_82114_b()).field_71574_a;
/* 36 */     double d2 = (entityPlayerMP.func_82114_b()).field_71572_b;
/* 37 */     double d3 = (entityPlayerMP.func_82114_b()).field_71573_c;
/* 38 */     double d4 = 1.0D;
/* 39 */     double d5 = 1.0D;
/* 40 */     double d6 = 0.0D;
/*    */     
/* 42 */     if (p_71515_2_.length > b) d1 = func_110666_a(p_71515_1_, d1, p_71515_2_[b++]); 
/* 43 */     if (p_71515_2_.length > b) d2 = func_110665_a(p_71515_1_, d2, p_71515_2_[b++], 0, 0); 
/* 44 */     if (p_71515_2_.length > b) d3 = func_110666_a(p_71515_1_, d3, p_71515_2_[b++]);
/*    */     
/* 46 */     if (p_71515_2_.length > b) d4 = func_110661_a(p_71515_1_, p_71515_2_[b++], 0.0D, 3.4028234663852886E38D); 
/* 47 */     if (p_71515_2_.length > b) d5 = func_110661_a(p_71515_1_, p_71515_2_[b++], 0.0D, 2.0D); 
/* 48 */     if (p_71515_2_.length > b) d6 = func_110661_a(p_71515_1_, p_71515_2_[b++], 0.0D, 1.0D);
/*    */     
/* 50 */     double d7 = (d4 > 1.0D) ? (d4 * 16.0D) : 16.0D;
/* 51 */     double d8 = entityPlayerMP.func_70011_f(d1, d2, d3);
/*    */     
/* 53 */     if (d8 > d7) {
/* 54 */       if (d6 > 0.0D) {
/* 55 */         double d9 = d1 - entityPlayerMP.field_70165_t;
/* 56 */         double d10 = d2 - entityPlayerMP.field_70163_u;
/* 57 */         double d11 = d3 - entityPlayerMP.field_70161_v;
/* 58 */         double d12 = Math.sqrt(d9 * d9 + d10 * d10 + d11 * d11);
/* 59 */         double d13 = entityPlayerMP.field_70165_t;
/* 60 */         double d14 = entityPlayerMP.field_70163_u;
/* 61 */         double d15 = entityPlayerMP.field_70161_v;
/*    */         
/* 63 */         if (d12 > 0.0D) {
/* 64 */           d13 += d9 / d12 * 2.0D;
/* 65 */           d14 += d10 / d12 * 2.0D;
/* 66 */           d15 += d11 / d12 * 2.0D;
/*    */         } 
/*    */         
/* 69 */         entityPlayerMP.field_71135_a.func_147359_a((Packet)new S29PacketSoundEffect(str, d13, d14, d15, (float)d6, (float)d5));
/*    */       } else {
/* 71 */         throw new CommandException("commands.playsound.playerTooFar", new Object[] { entityPlayerMP.func_70005_c_() });
/*    */       } 
/*    */     } else {
/* 74 */       entityPlayerMP.field_71135_a.func_147359_a((Packet)new S29PacketSoundEffect(str, d1, d2, d3, (float)d4, (float)d5));
/*    */     } 
/*    */     
/* 77 */     func_152373_a(p_71515_1_, this, "commands.playsound.success", new Object[] { str, entityPlayerMP.func_70005_c_() });
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
/* 82 */     return (p_82358_2_ == 1);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\CommandPlaySound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */