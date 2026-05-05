/*    */ package net.minecraft.client.renderer.entity;
/*    */ import net.minecraft.client.renderer.OpenGlHelper;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.item.EntityXPOrb;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderXPOrb extends Render {
/* 12 */   private static final ResourceLocation field_110785_a = new ResourceLocation("textures/entity/experience_orb.png");
/*    */ 
/*    */ 
/*    */   
/*    */   private static final String __OBFID = "CL_00000993";
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_76986_a(EntityXPOrb p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/* 21 */     GL11.glPushMatrix();
/* 22 */     GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
/*    */     
/* 24 */     func_110777_b((Entity)p_76986_1_);
/*    */     
/* 26 */     int i = p_76986_1_.func_70528_g();
/* 27 */     float f1 = (i % 4 * 16 + 0) / 64.0F;
/* 28 */     float f2 = (i % 4 * 16 + 16) / 64.0F;
/* 29 */     float f3 = (i / 4 * 16 + 0) / 64.0F;
/* 30 */     float f4 = (i / 4 * 16 + 16) / 64.0F;
/*    */     
/* 32 */     float f5 = 1.0F;
/* 33 */     float f6 = 0.5F;
/* 34 */     float f7 = 0.25F;
/*    */ 
/*    */     
/* 37 */     int j = p_76986_1_.func_70070_b(p_76986_9_);
/* 38 */     int k = j % 65536;
/* 39 */     int m = j / 65536;
/* 40 */     OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, k / 1.0F, m / 1.0F);
/* 41 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*    */ 
/*    */     
/* 44 */     float f8 = 255.0F;
/* 45 */     float f9 = (p_76986_1_.field_70533_a + p_76986_9_) / 2.0F;
/* 46 */     m = (int)((MathHelper.func_76126_a(f9 + 0.0F) + 1.0F) * 0.5F * f8);
/* 47 */     int n = (int)f8;
/* 48 */     int i1 = (int)((MathHelper.func_76126_a(f9 + 4.1887903F) + 1.0F) * 0.1F * f8);
/* 49 */     int i2 = m << 16 | n << 8 | i1;
/* 50 */     GL11.glRotatef(180.0F - this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
/* 51 */     GL11.glRotatef(-this.field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
/* 52 */     float f10 = 0.3F;
/* 53 */     GL11.glScalef(f10, f10, f10);
/* 54 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 55 */     tessellator.func_78382_b();
/* 56 */     tessellator.func_78384_a(i2, 128);
/* 57 */     tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
/* 58 */     tessellator.func_78374_a((0.0F - f6), (0.0F - f7), 0.0D, f1, f4);
/* 59 */     tessellator.func_78374_a((f5 - f6), (0.0F - f7), 0.0D, f2, f4);
/* 60 */     tessellator.func_78374_a((f5 - f6), (1.0F - f7), 0.0D, f2, f3);
/* 61 */     tessellator.func_78374_a((0.0F - f6), (1.0F - f7), 0.0D, f1, f3);
/* 62 */     tessellator.func_78381_a();
/*    */     
/* 64 */     GL11.glDisable(3042);
/* 65 */     GL11.glDisable(32826);
/* 66 */     GL11.glPopMatrix();
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntityXPOrb p_110775_1_) {
/* 71 */     return field_110785_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderXPOrb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */