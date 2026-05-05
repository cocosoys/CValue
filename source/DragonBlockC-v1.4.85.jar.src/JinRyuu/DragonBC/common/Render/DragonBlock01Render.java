/*    */ package JinRyuu.DragonBC.common.Render;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DragonBlock01Render
/*    */   extends TileEntitySpecialRenderer
/*    */ {
/* 16 */   private DragonBlock01Model aModel = new DragonBlock01Model();
/*    */ 
/*    */   
/*    */   public void renderAModelAt(DragonBlock01TileEntity tileentity, double d, double d1, double d2, float f) {
/* 20 */     GL11.glPushMatrix();
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
/* 36 */     Block b = tileentity.func_145838_q();
/* 37 */     if (b == BlocksDBC.BlockDragonBall) {
/* 38 */       GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.51F, (float)d2 + 0.5F);
/* 39 */     } else if (b == BlocksDBC.BlockNamekDragonBall) {
/* 40 */       GL11.glTranslatef((float)d + 0.5F, (float)d1 + 3.01F, (float)d2 + 0.5F);
/* 41 */       GL11.glScalef(2.0F, 2.0F, 2.0F);
/*    */     } 
/* 43 */     GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/* 44 */     ResourceLocation tx = new ResourceLocation("jinryuudragonbc:DragonBlock.png"); func_147499_a(tx);
/* 45 */     GL11.glEnable(2977);
/* 46 */     GL11.glEnable(3042);
/* 47 */     GL11.glBlendFunc(770, 771);
/* 48 */     GL11.glPushMatrix();
/* 49 */     this.aModel.renderModel(0.0625F);
/* 50 */     GL11.glPopMatrix();
/* 51 */     GL11.glDisable(3042);
/* 52 */     GL11.glPopMatrix();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_147500_a(TileEntity tileentity, double d, double d1, double d2, float f) {
/* 57 */     renderAModelAt((DragonBlock01TileEntity)tileentity, d, d1, d2, f);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\DragonBlock01Render.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */