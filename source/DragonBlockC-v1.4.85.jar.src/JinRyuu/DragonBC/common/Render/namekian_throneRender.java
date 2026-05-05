/*    */ package JinRyuu.DragonBC.common.Render;
/*    */ 
/*    */ import JinRyuu.JRMCore.JRMCoreH;
/*    */ import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class namekian_throneRender
/*    */   extends TileEntitySpecialRenderer
/*    */ {
/* 15 */   private namekian_throneModel aModel = new namekian_throneModel();
/*    */ 
/*    */   
/*    */   public void renderAModelAt(namekian_throneTileEntity tileentity, double d, double d1, double d2, float f) {
/* 19 */     int id = tileentity.func_145831_w().func_72805_g(tileentity.field_145851_c, tileentity.field_145848_d, tileentity.field_145849_e);
/*    */ 
/*    */     
/* 22 */     GL11.glPushMatrix();
/*    */     
/* 24 */     GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
/* 25 */     GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/* 26 */     GL11.glRotatef((90 * id), 0.0F, 1.0F, 0.0F);
/*    */     
/* 28 */     ResourceLocation tx = new ResourceLocation(JRMCoreH.tjdbcAssts + ":textures/tile/namekian_throne.png");
/* 29 */     func_147499_a(tx);
/* 30 */     GL11.glPushMatrix();
/* 31 */     this.aModel.renderModel(0.0625F);
/* 32 */     GL11.glPopMatrix();
/* 33 */     GL11.glPopMatrix();
/*    */   }
/*    */   public void func_147500_a(TileEntity tileentity, double d, double d1, double d2, float f) {
/* 36 */     renderAModelAt((namekian_throneTileEntity)tileentity, d, d1, d2, f);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\namekian_throneRender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */