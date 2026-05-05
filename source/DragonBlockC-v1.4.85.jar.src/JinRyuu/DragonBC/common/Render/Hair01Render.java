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
/*    */ public class Hair01Render
/*    */   extends TileEntitySpecialRenderer
/*    */ {
/* 14 */   private hair aModel = new hair();
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderAModelAt(Hair01TileEntity tileentity1, double d, double d1, double d2, float f) {
/* 19 */     GL11.glPushMatrix();
/* 20 */     GL11.glTranslatef((float)d + 0.5F, (float)d1 + 0.5F, (float)d2 + 0.5F);
/* 21 */     GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/* 22 */     ResourceLocation tx = new ResourceLocation("jinryuudragonbc:armor/hair.png"); func_147499_a(tx);
/* 23 */     GL11.glPushMatrix();
/* 24 */     this.aModel.renderModel(0.0625F);
/* 25 */     GL11.glPopMatrix();
/* 26 */     GL11.glPopMatrix();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_147500_a(TileEntity tileentity, double d, double d1, double d2, float f) {
/* 32 */     renderAModelAt((Hair01TileEntity)tileentity, d, d1, d2, f);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\Hair01Render.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */