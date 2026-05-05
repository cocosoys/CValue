/*    */ package net.minecraft.client.renderer.entity;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.projectile.EntityFishHook;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.util.Vec3;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderFish extends Render {
/* 14 */   private static final ResourceLocation field_110792_a = new ResourceLocation("textures/particle/particles.png");
/*    */   private static final String __OBFID = "CL_00000996";
/*    */   
/*    */   public void func_76986_a(EntityFishHook p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/* 18 */     GL11.glPushMatrix();
/*    */     
/* 20 */     GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
/* 21 */     GL11.glEnable(32826);
/* 22 */     GL11.glScalef(0.5F, 0.5F, 0.5F);
/* 23 */     func_110777_b((Entity)p_76986_1_);
/* 24 */     Tessellator tessellator = Tessellator.field_78398_a;
/*    */     
/* 26 */     byte b1 = 1;
/* 27 */     byte b2 = 2;
/* 28 */     float f1 = (b1 * 8 + 0) / 128.0F;
/* 29 */     float f2 = (b1 * 8 + 8) / 128.0F;
/* 30 */     float f3 = (b2 * 8 + 0) / 128.0F;
/* 31 */     float f4 = (b2 * 8 + 8) / 128.0F;
/*    */     
/* 33 */     float f5 = 1.0F;
/* 34 */     float f6 = 0.5F;
/* 35 */     float f7 = 0.5F;
/*    */     
/* 37 */     GL11.glRotatef(180.0F - this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
/* 38 */     GL11.glRotatef(-this.field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
/* 39 */     tessellator.func_78382_b();
/* 40 */     tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
/* 41 */     tessellator.func_78374_a((0.0F - f6), (0.0F - f7), 0.0D, f1, f4);
/* 42 */     tessellator.func_78374_a((f5 - f6), (0.0F - f7), 0.0D, f2, f4);
/* 43 */     tessellator.func_78374_a((f5 - f6), (1.0F - f7), 0.0D, f2, f3);
/* 44 */     tessellator.func_78374_a((0.0F - f6), (1.0F - f7), 0.0D, f1, f3);
/* 45 */     tessellator.func_78381_a();
/*    */     
/* 47 */     GL11.glDisable(32826);
/* 48 */     GL11.glPopMatrix();
/*    */     
/* 50 */     if (p_76986_1_.field_146042_b != null) {
/* 51 */       float f8 = p_76986_1_.field_146042_b.func_70678_g(p_76986_9_);
/* 52 */       float f9 = MathHelper.func_76126_a(MathHelper.func_76129_c(f8) * 3.1415927F);
/*    */       
/* 54 */       Vec3 vec3 = Vec3.func_72443_a(-0.5D, 0.03D, 0.8D);
/* 55 */       vec3.func_72440_a(-(p_76986_1_.field_146042_b.field_70127_C + (p_76986_1_.field_146042_b.field_70125_A - p_76986_1_.field_146042_b.field_70127_C) * p_76986_9_) * 3.1415927F / 180.0F);
/* 56 */       vec3.func_72442_b(-(p_76986_1_.field_146042_b.field_70126_B + (p_76986_1_.field_146042_b.field_70177_z - p_76986_1_.field_146042_b.field_70126_B) * p_76986_9_) * 3.1415927F / 180.0F);
/* 57 */       vec3.func_72442_b(f9 * 0.5F);
/* 58 */       vec3.func_72440_a(-f9 * 0.7F);
/*    */       
/* 60 */       double d1 = p_76986_1_.field_146042_b.field_70169_q + (p_76986_1_.field_146042_b.field_70165_t - p_76986_1_.field_146042_b.field_70169_q) * p_76986_9_ + vec3.field_72450_a;
/* 61 */       double d2 = p_76986_1_.field_146042_b.field_70167_r + (p_76986_1_.field_146042_b.field_70163_u - p_76986_1_.field_146042_b.field_70167_r) * p_76986_9_ + vec3.field_72448_b;
/* 62 */       double d3 = p_76986_1_.field_146042_b.field_70166_s + (p_76986_1_.field_146042_b.field_70161_v - p_76986_1_.field_146042_b.field_70166_s) * p_76986_9_ + vec3.field_72449_c;
/* 63 */       double d4 = (p_76986_1_.field_146042_b == (Minecraft.func_71410_x()).field_71439_g) ? 0.0D : p_76986_1_.field_146042_b.func_70047_e();
/*    */       
/* 65 */       if (this.field_76990_c.field_78733_k.field_74320_O > 0 || p_76986_1_.field_146042_b != (Minecraft.func_71410_x()).field_71439_g) {
/* 66 */         float f = (p_76986_1_.field_146042_b.field_70760_ar + (p_76986_1_.field_146042_b.field_70761_aq - p_76986_1_.field_146042_b.field_70760_ar) * p_76986_9_) * 3.1415927F / 180.0F;
/* 67 */         double d11 = MathHelper.func_76126_a(f);
/* 68 */         double d12 = MathHelper.func_76134_b(f);
/* 69 */         d1 = p_76986_1_.field_146042_b.field_70169_q + (p_76986_1_.field_146042_b.field_70165_t - p_76986_1_.field_146042_b.field_70169_q) * p_76986_9_ - d12 * 0.35D - d11 * 0.85D;
/* 70 */         d2 = p_76986_1_.field_146042_b.field_70167_r + d4 + (p_76986_1_.field_146042_b.field_70163_u - p_76986_1_.field_146042_b.field_70167_r) * p_76986_9_ - 0.45D;
/* 71 */         d3 = p_76986_1_.field_146042_b.field_70166_s + (p_76986_1_.field_146042_b.field_70161_v - p_76986_1_.field_146042_b.field_70166_s) * p_76986_9_ - d11 * 0.35D + d12 * 0.85D;
/*    */       } 
/*    */       
/* 74 */       double d5 = p_76986_1_.field_70169_q + (p_76986_1_.field_70165_t - p_76986_1_.field_70169_q) * p_76986_9_;
/* 75 */       double d6 = p_76986_1_.field_70167_r + (p_76986_1_.field_70163_u - p_76986_1_.field_70167_r) * p_76986_9_ + 0.25D;
/* 76 */       double d7 = p_76986_1_.field_70166_s + (p_76986_1_.field_70161_v - p_76986_1_.field_70166_s) * p_76986_9_;
/*    */       
/* 78 */       double d8 = (float)(d1 - d5);
/* 79 */       double d9 = (float)(d2 - d6);
/* 80 */       double d10 = (float)(d3 - d7);
/*    */       
/* 82 */       GL11.glDisable(3553);
/* 83 */       GL11.glDisable(2896);
/* 84 */       tessellator.func_78371_b(3);
/* 85 */       tessellator.func_78378_d(0);
/* 86 */       byte b3 = 16;
/* 87 */       for (byte b4 = 0; b4 <= b3; b4++) {
/* 88 */         float f = b4 / b3;
/* 89 */         tessellator.func_78377_a(p_76986_2_ + d8 * f, p_76986_4_ + d9 * (f * f + f) * 0.5D + 0.25D, p_76986_6_ + d10 * f);
/*    */       } 
/* 91 */       tessellator.func_78381_a();
/* 92 */       GL11.glEnable(2896);
/* 93 */       GL11.glEnable(3553);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntityFishHook p_110775_1_) {
/* 99 */     return field_110792_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderFish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */