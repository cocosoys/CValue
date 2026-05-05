/*    */ package JinRyuu.DragonBC.common.Render;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.entity.Render;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SpacePod01RenderPod
/*    */   extends Render
/*    */ {
/* 16 */   private ModelBase aModel = new SpacePod01Model();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderAModelAt(SpacePod01Entity entity, double d, double d1, double d2, float f, float par9) {
/* 35 */     GL11.glPushMatrix();
/* 36 */     GL11.glTranslatef((float)d, (float)d1 + 1.0F, (float)d2);
/* 37 */     GL11.glRotatef(180.0F - f, 0.0F, 1.0F, 0.0F);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 61 */     ResourceLocation tx = new ResourceLocation("jinryuudragonbc:SpacePodBlock.png");
/* 62 */     this.field_76990_c.field_78724_e.func_110577_a(tx);
/* 63 */     GL11.glEnable(2977);
/* 64 */     GL11.glEnable(3042);
/* 65 */     GL11.glBlendFunc(770, 771);
/* 66 */     GL11.glScalef(-1.0F, -1.0F, 1.0F);
/* 67 */     this.aModel.func_78088_a(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
/* 68 */     GL11.glDisable(3042);
/* 69 */     GL11.glPopMatrix();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_76986_a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
/* 74 */     renderAModelAt((SpacePod01Entity)par1Entity, par2, par4, par6, par8, par9);
/*    */   }
/*    */ 
/*    */   
/* 78 */   private static final ResourceLocation shearedSheepTextures = new ResourceLocation("jinryuudragonbc:SpacePodBlock.png");
/*    */   protected ResourceLocation func_110775_a(Entity entity) {
/* 80 */     return shearedSheepTextures;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\SpacePod01RenderPod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */