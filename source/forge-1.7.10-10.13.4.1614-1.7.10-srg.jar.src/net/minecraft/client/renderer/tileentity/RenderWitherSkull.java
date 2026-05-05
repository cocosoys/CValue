/*    */ package net.minecraft.client.renderer.tileentity;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.client.model.ModelSkeletonHead;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.projectile.EntityWitherSkull;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderWitherSkull extends Render {
/* 11 */   private static final ResourceLocation field_110811_a = new ResourceLocation("textures/entity/wither/wither_invulnerable.png");
/* 12 */   private static final ResourceLocation field_110810_f = new ResourceLocation("textures/entity/wither/wither.png");
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 17 */   private final ModelSkeletonHead field_82401_a = new ModelSkeletonHead();
/*    */   private static final String __OBFID = "CL_00001035";
/*    */   
/*    */   private float func_82400_a(float p_82400_1_, float p_82400_2_, float p_82400_3_) {
/* 21 */     float f = p_82400_2_ - p_82400_1_;
/* 22 */     while (f < -180.0F)
/* 23 */       f += 360.0F; 
/* 24 */     while (f >= 180.0F)
/* 25 */       f -= 360.0F; 
/* 26 */     return p_82400_1_ + p_82400_3_ * f;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_76986_a(EntityWitherSkull p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/* 32 */     GL11.glPushMatrix();
/* 33 */     GL11.glDisable(2884);
/*    */     
/* 35 */     float f1 = func_82400_a(p_76986_1_.field_70126_B, p_76986_1_.field_70177_z, p_76986_9_);
/* 36 */     float f2 = p_76986_1_.field_70127_C + (p_76986_1_.field_70125_A - p_76986_1_.field_70127_C) * p_76986_9_;
/*    */     
/* 38 */     GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
/*    */     
/* 40 */     float f3 = 0.0625F;
/* 41 */     GL11.glEnable(32826);
/* 42 */     GL11.glScalef(-1.0F, -1.0F, 1.0F);
/*    */     
/* 44 */     GL11.glEnable(3008);
/*    */     
/* 46 */     func_110777_b((Entity)p_76986_1_);
/*    */     
/* 48 */     this.field_82401_a.func_78088_a((Entity)p_76986_1_, 0.0F, 0.0F, 0.0F, f1, f2, f3);
/*    */     
/* 50 */     GL11.glPopMatrix();
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntityWitherSkull p_110775_1_) {
/* 55 */     return p_110775_1_.func_82342_d() ? field_110811_a : field_110810_f;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\tileentity\RenderWitherSkull.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */