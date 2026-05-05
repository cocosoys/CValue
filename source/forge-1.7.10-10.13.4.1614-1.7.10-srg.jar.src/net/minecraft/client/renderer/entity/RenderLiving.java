/*    */ package net.minecraft.client.renderer.entity;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public abstract class RenderLiving extends RendererLivingEntity {
/*    */   public RenderLiving(ModelBase p_i1262_1_, float p_i1262_2_) {
/* 13 */     super(p_i1262_1_, p_i1262_2_);
/*    */   }
/*    */   private static final String __OBFID = "CL_00001015";
/*    */   
/*    */   protected boolean func_110813_b(EntityLiving p_110813_1_) {
/* 18 */     return (super.func_110813_b((EntityLivingBase)p_110813_1_) && (p_110813_1_.func_94059_bO() || (p_110813_1_.func_94056_bM() && p_110813_1_ == this.field_76990_c.field_147941_i)));
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_76986_a(EntityLiving p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/* 23 */     super.func_76986_a((EntityLivingBase)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
/*    */     
/* 25 */     func_110827_b(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
/*    */   }
/*    */   
/*    */   private double func_110828_a(double p_110828_1_, double p_110828_3_, double p_110828_5_) {
/* 29 */     return p_110828_1_ + (p_110828_3_ - p_110828_1_) * p_110828_5_;
/*    */   }
/*    */   
/*    */   protected void func_110827_b(EntityLiving p_110827_1_, double p_110827_2_, double p_110827_4_, double p_110827_6_, float p_110827_8_, float p_110827_9_) {
/* 33 */     Entity entity = p_110827_1_.func_110166_bE();
/* 34 */     if (entity != null) {
/* 35 */       p_110827_4_ -= (1.6D - p_110827_1_.field_70131_O) * 0.5D;
/* 36 */       Tessellator tessellator = Tessellator.field_78398_a;
/* 37 */       double d1 = func_110828_a(entity.field_70126_B, entity.field_70177_z, (p_110827_9_ * 0.5F)) * 0.01745329238474369D;
/* 38 */       double d2 = func_110828_a(entity.field_70127_C, entity.field_70125_A, (p_110827_9_ * 0.5F)) * 0.01745329238474369D;
/* 39 */       double d3 = Math.cos(d1);
/* 40 */       double d4 = Math.sin(d1);
/* 41 */       double d5 = Math.sin(d2);
/* 42 */       if (entity instanceof net.minecraft.entity.EntityHanging) {
/* 43 */         d3 = 0.0D;
/* 44 */         d4 = 0.0D;
/* 45 */         d5 = -1.0D;
/*    */       } 
/* 47 */       double d6 = Math.cos(d2);
/* 48 */       double d7 = func_110828_a(entity.field_70169_q, entity.field_70165_t, p_110827_9_) - d3 * 0.7D - d4 * 0.5D * d6;
/* 49 */       double d8 = func_110828_a(entity.field_70167_r + entity.func_70047_e() * 0.7D, entity.field_70163_u + entity.func_70047_e() * 0.7D, p_110827_9_) - d5 * 0.5D - 0.25D;
/* 50 */       double d9 = func_110828_a(entity.field_70166_s, entity.field_70161_v, p_110827_9_) - d4 * 0.7D + d3 * 0.5D * d6;
/*    */       
/* 52 */       double d10 = func_110828_a(p_110827_1_.field_70760_ar, p_110827_1_.field_70761_aq, p_110827_9_) * 0.01745329238474369D + 1.5707963267948966D;
/* 53 */       d3 = Math.cos(d10) * p_110827_1_.field_70130_N * 0.4D;
/* 54 */       d4 = Math.sin(d10) * p_110827_1_.field_70130_N * 0.4D;
/* 55 */       double d11 = func_110828_a(p_110827_1_.field_70169_q, p_110827_1_.field_70165_t, p_110827_9_) + d3;
/* 56 */       double d12 = func_110828_a(p_110827_1_.field_70167_r, p_110827_1_.field_70163_u, p_110827_9_);
/* 57 */       double d13 = func_110828_a(p_110827_1_.field_70166_s, p_110827_1_.field_70161_v, p_110827_9_) + d4;
/* 58 */       p_110827_2_ += d3;
/* 59 */       p_110827_6_ += d4;
/*    */       
/* 61 */       double d14 = (float)(d7 - d11);
/* 62 */       double d15 = (float)(d8 - d12);
/* 63 */       double d16 = (float)(d9 - d13);
/*    */       
/* 65 */       GL11.glDisable(3553);
/* 66 */       GL11.glDisable(2896);
/* 67 */       GL11.glDisable(2884);
/*    */       
/* 69 */       byte b1 = 24;
/* 70 */       double d17 = 0.025D;
/* 71 */       tessellator.func_78371_b(5); byte b2;
/* 72 */       for (b2 = 0; b2 <= 24; b2++) {
/* 73 */         if (b2 % 2 == 0) {
/* 74 */           tessellator.func_78369_a(0.5F, 0.4F, 0.3F, 1.0F);
/*    */         } else {
/* 76 */           tessellator.func_78369_a(0.35F, 0.28F, 0.21000001F, 1.0F);
/*    */         } 
/* 78 */         float f = b2 / 24.0F;
/* 79 */         tessellator.func_78377_a(p_110827_2_ + d14 * f + 0.0D, p_110827_4_ + d15 * (f * f + f) * 0.5D + ((24.0F - b2) / 18.0F + 0.125F), p_110827_6_ + d16 * f);
/* 80 */         tessellator.func_78377_a(p_110827_2_ + d14 * f + 0.025D, p_110827_4_ + d15 * (f * f + f) * 0.5D + ((24.0F - b2) / 18.0F + 0.125F) + 0.025D, p_110827_6_ + d16 * f);
/*    */       } 
/* 82 */       tessellator.func_78381_a();
/*    */       
/* 84 */       tessellator.func_78371_b(5);
/* 85 */       for (b2 = 0; b2 <= 24; b2++) {
/* 86 */         if (b2 % 2 == 0) {
/* 87 */           tessellator.func_78369_a(0.5F, 0.4F, 0.3F, 1.0F);
/*    */         } else {
/* 89 */           tessellator.func_78369_a(0.35F, 0.28F, 0.21000001F, 1.0F);
/*    */         } 
/* 91 */         float f = b2 / 24.0F;
/* 92 */         tessellator.func_78377_a(p_110827_2_ + d14 * f + 0.0D, p_110827_4_ + d15 * (f * f + f) * 0.5D + ((24.0F - b2) / 18.0F + 0.125F) + 0.025D, p_110827_6_ + d16 * f);
/* 93 */         tessellator.func_78377_a(p_110827_2_ + d14 * f + 0.025D, p_110827_4_ + d15 * (f * f + f) * 0.5D + ((24.0F - b2) / 18.0F + 0.125F), p_110827_6_ + d16 * f + 0.025D);
/*    */       } 
/* 95 */       tessellator.func_78381_a();
/*    */       
/* 97 */       GL11.glEnable(2896);
/* 98 */       GL11.glEnable(3553);
/* 99 */       GL11.glEnable(2884);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderLiving.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */