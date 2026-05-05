/*    */ package JinRyuu.JRMCore.entity;
/*    */ 
/*    */ import JinRyuu.JRMCore.client.JGRenderHelper;
/*    */ import net.minecraft.entity.Entity;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModelNPCNormalScaled
/*    */   extends ModelNPCNormal
/*    */ {
/*    */   public void func_78088_a(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
/* 13 */     GL11.glPushMatrix();
/* 14 */     float F = par1Entity.field_70131_O / 2.0F;
/* 15 */     JGRenderHelper.modelScalePositionHelper(F);
/* 16 */     super.func_78088_a(par1Entity, par2, par3, par4, par5, par6, par7);
/* 17 */     GL11.glPopMatrix();
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\ModelNPCNormalScaled.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */