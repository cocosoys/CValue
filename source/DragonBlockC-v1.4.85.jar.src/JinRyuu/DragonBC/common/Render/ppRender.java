/*    */ package JinRyuu.DragonBC.common.Render;
/*    */ 
/*    */ import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ppRender
/*    */   extends TileEntitySpecialRenderer
/*    */ {
/* 15 */   private ppModel aModel = new ppModel();
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderAModelAt(ppTileEntity tileentity, double d, double d1, double d2, float f) {
/* 20 */     GL11.glPushMatrix();
/*    */     
/* 22 */     int s = 1;
/* 23 */     GL11.glTranslatef((float)d + 0.5F, (float)d1 + 0.0F + s, (float)d2 + 0.5F);
/*    */ 
/*    */     
/* 26 */     ResourceLocation tx = new ResourceLocation("jinryuudragonbc:textures/blades/P.png"); func_147499_a(tx);
/* 27 */     GL11.glPushMatrix();
/* 28 */     GL11.glScaled(1.0D, s, 1.0D);
/* 29 */     this.aModel.renderModel(0.0625F);
/* 30 */     GL11.glPopMatrix();
/* 31 */     GL11.glPopMatrix();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_147500_a(TileEntity tileentity, double d, double d1, double d2, float f) {
/* 37 */     renderAModelAt((ppTileEntity)tileentity, d, d1, d2, f);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\ppRender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */