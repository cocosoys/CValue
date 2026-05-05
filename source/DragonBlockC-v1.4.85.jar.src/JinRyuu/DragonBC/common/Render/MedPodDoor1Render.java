/*    */ package JinRyuu.DragonBC.common.Render;
/*    */ 
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class MedPodDoor1Render
/*    */   extends TileEntitySpecialRenderer {
/* 11 */   private int moving = 0;
/*    */   
/*    */   private MedPodDoor1Model aModel;
/*    */   
/*    */   public MedPodDoor1Render() {
/* 16 */     this.aModel = new MedPodDoor1Model();
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderAModelAt(MedPodDoor1TileEntity tileentity, double d, double d1, double d2, float f) {
/* 21 */     String renderMode = "";
/*    */     
/* 23 */     boolean hasAbove = tileentity.func_145831_w().func_147439_a(tileentity.field_145851_c, tileentity.field_145848_d + 1, tileentity.field_145849_e) instanceof MedPodDoor1Block;
/* 24 */     boolean hasBelow = tileentity.func_145831_w().func_147439_a(tileentity.field_145851_c, tileentity.field_145848_d - 1, tileentity.field_145849_e) instanceof MedPodDoor1Block;
/*    */     
/* 26 */     if (hasAbove && hasBelow) { renderMode = "d"; }
/* 27 */     else if (hasAbove) { renderMode = "c"; }
/* 28 */     else if (hasBelow) { renderMode = "b"; }
/*    */     
/* 30 */     GL11.glPushMatrix();
/*    */     
/* 32 */     Block b = tileentity.func_145838_q();
/* 33 */     int meta = tileentity.func_145832_p();
/* 34 */     if (meta == 3 || meta == 7) {
/* 35 */       GL11.glTranslatef((float)d + 0.375F, (float)d1 + 1.0F, (float)d2 + 0.5F);
/* 36 */       GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
/*    */     }
/* 38 */     else if (meta == 1 || meta == 5) {
/* 39 */       GL11.glTranslatef((float)d + 0.625F, (float)d1 + 1.0F, (float)d2 + 0.5F);
/* 40 */       GL11.glRotatef(270.0F, 0.0F, 1.0F, 0.0F);
/*    */     }
/* 42 */     else if (meta == 0 || meta == 4) {
/* 43 */       GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.0F, (float)d2 + 0.375F);
/* 44 */       GL11.glRotatef(0.0F, 0.0F, 1.0F, 0.0F);
/*    */     }
/* 46 */     else if (meta == 2 || meta == 6) {
/* 47 */       GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.0F, (float)d2 + 0.625F);
/* 48 */       GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 58 */     GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/* 59 */     ResourceLocation tx = new ResourceLocation("jinryuudragonbc:textures/blockmodels/MedPodDoor1" + renderMode + ".png");
/* 60 */     func_147499_a(tx);
/* 61 */     GL11.glEnable(2977);
/* 62 */     GL11.glEnable(3042);
/* 63 */     GL11.glBlendFunc(770, 771);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 68 */     GL11.glPushMatrix();
/*    */     
/* 70 */     this.aModel.renderModel(tileentity.getCb(), meta, 0.0625F);
/* 71 */     GL11.glPopMatrix();
/*    */     
/* 73 */     GL11.glDisable(3042);
/* 74 */     GL11.glPopMatrix();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_147500_a(TileEntity tileentity, double d, double d1, double d2, float f) {
/* 79 */     renderAModelAt((MedPodDoor1TileEntity)tileentity, d, d1, d2, f);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\MedPodDoor1Render.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */