/*    */ package net.minecraft.client.renderer.entity;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.projectile.EntityArrow;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderArrow extends Render {
/* 14 */   private static final ResourceLocation field_110780_a = new ResourceLocation("textures/entity/arrow.png");
/*    */   private static final String __OBFID = "CL_00000978";
/*    */   
/*    */   public void func_76986_a(EntityArrow p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/* 18 */     func_110777_b((Entity)p_76986_1_);
/*    */     
/* 20 */     GL11.glPushMatrix();
/*    */     
/* 22 */     GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
/* 23 */     GL11.glRotatef(p_76986_1_.field_70126_B + (p_76986_1_.field_70177_z - p_76986_1_.field_70126_B) * p_76986_9_ - 90.0F, 0.0F, 1.0F, 0.0F);
/* 24 */     GL11.glRotatef(p_76986_1_.field_70127_C + (p_76986_1_.field_70125_A - p_76986_1_.field_70127_C) * p_76986_9_, 0.0F, 0.0F, 1.0F);
/*    */     
/* 26 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 27 */     byte b1 = 0;
/*    */     
/* 29 */     float f1 = 0.0F;
/* 30 */     float f2 = 0.5F;
/* 31 */     float f3 = (0 + b1 * 10) / 32.0F;
/* 32 */     float f4 = (5 + b1 * 10) / 32.0F;
/*    */     
/* 34 */     float f5 = 0.0F;
/* 35 */     float f6 = 0.15625F;
/* 36 */     float f7 = (5 + b1 * 10) / 32.0F;
/* 37 */     float f8 = (10 + b1 * 10) / 32.0F;
/* 38 */     float f9 = 0.05625F;
/* 39 */     GL11.glEnable(32826);
/* 40 */     float f10 = p_76986_1_.field_70249_b - p_76986_9_;
/* 41 */     if (f10 > 0.0F) {
/* 42 */       float f = -MathHelper.func_76126_a(f10 * 3.0F) * f10;
/* 43 */       GL11.glRotatef(f, 0.0F, 0.0F, 1.0F);
/*    */     } 
/* 45 */     GL11.glRotatef(45.0F, 1.0F, 0.0F, 0.0F);
/* 46 */     GL11.glScalef(f9, f9, f9);
/*    */     
/* 48 */     GL11.glTranslatef(-4.0F, 0.0F, 0.0F);
/*    */     
/* 50 */     GL11.glNormal3f(f9, 0.0F, 0.0F);
/* 51 */     tessellator.func_78382_b();
/* 52 */     tessellator.func_78374_a(-7.0D, -2.0D, -2.0D, f5, f7);
/* 53 */     tessellator.func_78374_a(-7.0D, -2.0D, 2.0D, f6, f7);
/* 54 */     tessellator.func_78374_a(-7.0D, 2.0D, 2.0D, f6, f8);
/* 55 */     tessellator.func_78374_a(-7.0D, 2.0D, -2.0D, f5, f8);
/* 56 */     tessellator.func_78381_a();
/*    */     
/* 58 */     GL11.glNormal3f(-f9, 0.0F, 0.0F);
/* 59 */     tessellator.func_78382_b();
/* 60 */     tessellator.func_78374_a(-7.0D, 2.0D, -2.0D, f5, f7);
/* 61 */     tessellator.func_78374_a(-7.0D, 2.0D, 2.0D, f6, f7);
/* 62 */     tessellator.func_78374_a(-7.0D, -2.0D, 2.0D, f6, f8);
/* 63 */     tessellator.func_78374_a(-7.0D, -2.0D, -2.0D, f5, f8);
/* 64 */     tessellator.func_78381_a();
/*    */     
/* 66 */     for (byte b2 = 0; b2 < 4; b2++) {
/*    */       
/* 68 */       GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
/* 69 */       GL11.glNormal3f(0.0F, 0.0F, f9);
/* 70 */       tessellator.func_78382_b();
/* 71 */       tessellator.func_78374_a(-8.0D, -2.0D, 0.0D, f1, f3);
/* 72 */       tessellator.func_78374_a(8.0D, -2.0D, 0.0D, f2, f3);
/* 73 */       tessellator.func_78374_a(8.0D, 2.0D, 0.0D, f2, f4);
/* 74 */       tessellator.func_78374_a(-8.0D, 2.0D, 0.0D, f1, f4);
/* 75 */       tessellator.func_78381_a();
/*    */     } 
/*    */     
/* 78 */     GL11.glDisable(32826);
/* 79 */     GL11.glPopMatrix();
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntityArrow p_110775_1_) {
/* 84 */     return field_110780_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderArrow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */