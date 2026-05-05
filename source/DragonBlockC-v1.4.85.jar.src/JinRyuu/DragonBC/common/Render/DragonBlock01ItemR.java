/*    */ package JinRyuu.DragonBC.common.Render;
/*    */ 
/*    */ import JinRyuu.JRMCore.JRMCoreClient;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.client.IItemRenderer;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DragonBlock01ItemR
/*    */   implements IItemRenderer
/*    */ {
/* 15 */   private DragonBlock01Model aModel = new DragonBlock01Model();
/*    */   private float t;
/*    */   
/*    */   public DragonBlock01ItemR(float t) {
/* 19 */     this.t = t;
/*    */   }
/*    */   
/*    */   public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
/* 23 */     return (type != IItemRenderer.ItemRenderType.INVENTORY);
/*    */   }
/*    */   public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) {
/* 26 */     return false;
/*    */   }
/*    */   public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {
/* 29 */     GL11.glPushMatrix();
/*    */     
/* 31 */     ResourceLocation tx = new ResourceLocation("jinryuudragonbc:DragonBlock.png");
/* 32 */     JRMCoreClient.mc.func_110434_K().func_110577_a(tx);
/*    */     
/* 34 */     GL11.glScalef(this.t, this.t, this.t);
/* 35 */     GL11.glTranslatef(((type == IItemRenderer.ItemRenderType.ENTITY) ? 0.1F : 0.5F) + -0.08F * this.t, -0.9F - 0.1F * this.t, 0.0F);
/* 36 */     if (type == IItemRenderer.ItemRenderType.INVENTORY) {
/* 37 */       GL11.glTranslatef(7.0F - (this.t - 1.0F) * 3.0F, -15.5F - (this.t - 1.0F) * 2.0F, 0.0F);
/* 38 */       GL11.glScalef(17.0F, 17.0F, 17.0F);
/*    */     } 
/* 40 */     float h1 = 1.0F;
/* 41 */     GL11.glColor3f(h1, h1, h1);
/* 42 */     GL11.glEnable(3042);
/* 43 */     GL11.glBlendFunc(770, 771);
/* 44 */     GL11.glEnable(2884);
/* 45 */     this.aModel.render();
/* 46 */     GL11.glDisable(3042);
/*    */     
/* 48 */     GL11.glPopMatrix();
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\DragonBlock01ItemR.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */