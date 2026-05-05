/*    */ package net.minecraft.client.renderer.entity;
/*    */ import net.minecraft.client.model.ModelLeashKnot;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLeashKnot;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderLeashKnot extends Render {
/* 10 */   private static final ResourceLocation field_110802_a = new ResourceLocation("textures/entity/lead_knot.png");
/*    */   
/* 12 */   private ModelLeashKnot field_110801_f = new ModelLeashKnot();
/*    */   
/*    */   private static final String __OBFID = "CL_00001010";
/*    */   
/*    */   public void func_76986_a(EntityLeashKnot p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/* 17 */     GL11.glPushMatrix();
/* 18 */     GL11.glDisable(2884);
/*    */     
/* 20 */     GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
/*    */     
/* 22 */     float f = 0.0625F;
/* 23 */     GL11.glEnable(32826);
/* 24 */     GL11.glScalef(-1.0F, -1.0F, 1.0F);
/*    */     
/* 26 */     GL11.glEnable(3008);
/*    */     
/* 28 */     func_110777_b((Entity)p_76986_1_);
/* 29 */     this.field_110801_f.func_78088_a((Entity)p_76986_1_, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, f);
/*    */     
/* 31 */     GL11.glPopMatrix();
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntityLeashKnot p_110775_1_) {
/* 36 */     return field_110802_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderLeashKnot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */