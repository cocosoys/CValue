/*    */ package net.minecraft.client.renderer.entity;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Random;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.effect.EntityLightningBolt;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderLightningBolt extends Render {
/*    */   public void func_76986_a(EntityLightningBolt p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/* 14 */     Tessellator tessellator = Tessellator.field_78398_a;
/*    */     
/* 16 */     GL11.glDisable(3553);
/* 17 */     GL11.glDisable(2896);
/* 18 */     GL11.glEnable(3042);
/* 19 */     GL11.glBlendFunc(770, 1);
/*    */     
/* 21 */     double[] arrayOfDouble1 = new double[8];
/* 22 */     double[] arrayOfDouble2 = new double[8];
/* 23 */     double d1 = 0.0D;
/* 24 */     double d2 = 0.0D;
/*    */     
/* 26 */     Random random = new Random(p_76986_1_.field_70264_a);
/* 27 */     for (byte b2 = 7; b2 >= 0; b2--) {
/* 28 */       arrayOfDouble1[b2] = d1;
/* 29 */       arrayOfDouble2[b2] = d2;
/* 30 */       d1 += (random.nextInt(11) - 5);
/* 31 */       d2 += (random.nextInt(11) - 5);
/*    */     } 
/*    */ 
/*    */     
/* 35 */     for (byte b1 = 0; b1 < 4; b1++) {
/* 36 */       Random random1 = new Random(p_76986_1_.field_70264_a);
/* 37 */       for (byte b = 0; b < 3; b++) {
/* 38 */         int i = 7;
/* 39 */         int j = 0;
/* 40 */         if (b > 0) i = 7 - b; 
/* 41 */         if (b > 0) j = i - 2; 
/* 42 */         double d3 = arrayOfDouble1[i] - d1;
/* 43 */         double d4 = arrayOfDouble2[i] - d2;
/* 44 */         for (int k = i; k >= j; k--) {
/* 45 */           double d5 = d3;
/* 46 */           double d6 = d4;
/* 47 */           if (b == 0) {
/* 48 */             d3 += (random1.nextInt(11) - 5);
/* 49 */             d4 += (random1.nextInt(11) - 5);
/*    */           } else {
/* 51 */             d3 += (random1.nextInt(31) - 15);
/* 52 */             d4 += (random1.nextInt(31) - 15);
/*    */           } 
/*    */           
/* 55 */           tessellator.func_78371_b(5);
/* 56 */           float f = 0.5F;
/* 57 */           tessellator.func_78369_a(0.9F * f, 0.9F * f, 1.0F * f, 0.3F);
/*    */           
/* 59 */           double d7 = 0.1D + b1 * 0.2D;
/* 60 */           if (b == 0) d7 *= k * 0.1D + 1.0D;
/*    */           
/* 62 */           double d8 = 0.1D + b1 * 0.2D;
/* 63 */           if (b == 0) d8 *= (k - 1) * 0.1D + 1.0D;
/*    */           
/* 65 */           for (byte b3 = 0; b3 < 5; b3++) {
/* 66 */             double d9 = p_76986_2_ + 0.5D - d7;
/* 67 */             double d10 = p_76986_6_ + 0.5D - d7;
/* 68 */             if (b3 == 1 || b3 == 2) d9 += d7 * 2.0D; 
/* 69 */             if (b3 == 2 || b3 == 3) d10 += d7 * 2.0D;
/*    */             
/* 71 */             double d11 = p_76986_2_ + 0.5D - d8;
/* 72 */             double d12 = p_76986_6_ + 0.5D - d8;
/* 73 */             if (b3 == 1 || b3 == 2) d11 += d8 * 2.0D; 
/* 74 */             if (b3 == 2 || b3 == 3) d12 += d8 * 2.0D;
/*    */             
/* 76 */             tessellator.func_78377_a(d11 + d3, p_76986_4_ + (k * 16), d12 + d4);
/* 77 */             tessellator.func_78377_a(d9 + d5, p_76986_4_ + ((k + 1) * 16), d10 + d6);
/*    */           } 
/*    */ 
/*    */           
/* 81 */           tessellator.func_78381_a();
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 86 */     GL11.glDisable(3042);
/* 87 */     GL11.glEnable(2896);
/* 88 */     GL11.glEnable(3553);
/*    */   }
/*    */   
/*    */   private static final String __OBFID = "CL_00001011";
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntityLightningBolt p_110775_1_) {
/* 94 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderLightningBolt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */