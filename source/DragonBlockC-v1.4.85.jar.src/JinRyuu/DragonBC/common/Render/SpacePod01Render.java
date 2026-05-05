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
/*    */ public class SpacePod01Render
/*    */   extends TileEntitySpecialRenderer
/*    */ {
/* 15 */   private SpacePod01Model aModel = new SpacePod01Model();
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderAModelAt(SpacePod01TileEntity tileentity, double d, double d1, double d2, float f) {
/* 20 */     GL11.glPushMatrix();
/*    */     
/* 22 */     GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
/* 23 */     GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/* 24 */     ResourceLocation tx = new ResourceLocation("jinryuudragonbc:SpacePodBlock.png"); func_147499_a(tx);
/* 25 */     GL11.glEnable(2977);
/* 26 */     GL11.glEnable(3042);
/* 27 */     GL11.glBlendFunc(770, 771);
/* 28 */     GL11.glPushMatrix();
/* 29 */     this.aModel.renderModel(0.0625F);
/* 30 */     GL11.glPopMatrix();
/* 31 */     GL11.glDisable(3042);
/* 32 */     GL11.glPopMatrix();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_147500_a(TileEntity tileentity, double d, double d1, double d2, float f) {
/* 40 */     renderAModelAt((SpacePod01TileEntity)tileentity, d, d1, d2, f);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\SpacePod01Render.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */