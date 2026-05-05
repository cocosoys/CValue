/*    */ package net.minecraft.client.renderer.entity;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.item.EntityBoat;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderBoat extends Render {
/* 12 */   private static final ResourceLocation field_110782_f = new ResourceLocation("textures/entity/boat.png");
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 17 */   protected ModelBase field_76998_a = (ModelBase)new ModelBoat();
/*    */   
/*    */   private static final String __OBFID = "CL_00000981";
/*    */   
/*    */   public void func_76986_a(EntityBoat p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/* 22 */     GL11.glPushMatrix();
/*    */     
/* 24 */     GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
/*    */     
/* 26 */     GL11.glRotatef(180.0F - p_76986_8_, 0.0F, 1.0F, 0.0F);
/* 27 */     float f1 = p_76986_1_.func_70268_h() - p_76986_9_;
/* 28 */     float f2 = p_76986_1_.func_70271_g() - p_76986_9_;
/* 29 */     if (f2 < 0.0F) f2 = 0.0F; 
/* 30 */     if (f1 > 0.0F) {
/* 31 */       GL11.glRotatef(MathHelper.func_76126_a(f1) * f1 * f2 / 10.0F * p_76986_1_.func_70267_i(), 1.0F, 0.0F, 0.0F);
/*    */     }
/*    */     
/* 34 */     float f3 = 0.75F;
/* 35 */     GL11.glScalef(f3, f3, f3);
/* 36 */     GL11.glScalef(1.0F / f3, 1.0F / f3, 1.0F / f3);
/*    */     
/* 38 */     func_110777_b((Entity)p_76986_1_);
/* 39 */     GL11.glScalef(-1.0F, -1.0F, 1.0F);
/* 40 */     this.field_76998_a.func_78088_a((Entity)p_76986_1_, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
/* 41 */     GL11.glPopMatrix();
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntityBoat p_110775_1_) {
/* 46 */     return field_110782_f;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderBoat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */