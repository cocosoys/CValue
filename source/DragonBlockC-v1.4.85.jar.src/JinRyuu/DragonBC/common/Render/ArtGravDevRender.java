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
/*    */ public class ArtGravDevRender
/*    */   extends TileEntitySpecialRenderer
/*    */ {
/* 15 */   private ArtGravDevModel aModel = new ArtGravDevModel();
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderAModelAt(ArtGravDevTileEntity tileentity, double d, double d1, double d2, float f) {
/* 20 */     GL11.glPushMatrix();
/*    */     
/* 22 */     GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
/* 23 */     GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/*    */     
/* 25 */     ResourceLocation tx = new ResourceLocation("jinryuudragonbc:textures/blockmodels/GravDev" + ((tileentity.isBurning() && tileentity.getGravity() > 1.0F) ? "On" : "") + ".png"); func_147499_a(tx);
/* 26 */     GL11.glPushMatrix();
/* 27 */     this.aModel.renderModel(0.0625F);
/* 28 */     GL11.glPopMatrix();
/* 29 */     GL11.glPopMatrix();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_147500_a(TileEntity tileentity, double d, double d1, double d2, float f) {
/* 35 */     renderAModelAt((ArtGravDevTileEntity)tileentity, d, d1, d2, f);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\ArtGravDevRender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */