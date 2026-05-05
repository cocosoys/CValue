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
/*    */ public class DragonBlockNS01Render
/*    */   extends TileEntitySpecialRenderer
/*    */ {
/* 15 */   private DragonBlock01Model aModel = new DragonBlock01Model();
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderAModelAt(DragonBlockNS01TileEntity tileentity, double d, double d1, double d2, float f) {
/* 20 */     GL11.glPushMatrix();
/*    */     
/* 22 */     GL11.glTranslatef((float)d + 0.5F, (float)d1 + 3.01F, (float)d2 + 0.5F);
/* 23 */     GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/* 24 */     GL11.glScalef(2.0F, 2.0F, 2.0F);
/* 25 */     ResourceLocation tx = new ResourceLocation("jinryuudragonbc:DragonBlockStone.png"); func_147499_a(tx);
/* 26 */     GL11.glEnable(2977);
/* 27 */     GL11.glEnable(3042);
/* 28 */     GL11.glBlendFunc(770, 771);
/* 29 */     GL11.glPushMatrix();
/* 30 */     this.aModel.renderModel(0.0625F);
/* 31 */     GL11.glPopMatrix();
/* 32 */     GL11.glDisable(3042);
/* 33 */     GL11.glPopMatrix();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_147500_a(TileEntity tileentity, double d, double d1, double d2, float f) {
/* 41 */     renderAModelAt((DragonBlockNS01TileEntity)tileentity, d, d1, d2, f);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\DragonBlockNS01Render.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */