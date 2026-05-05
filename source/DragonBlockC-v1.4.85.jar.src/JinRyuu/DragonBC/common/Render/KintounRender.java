/*    */ package JinRyuu.DragonBC.common.Render;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.entity.Render;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class KintounRender
/*    */   extends Render {
/* 11 */   private final String[] texture = new String[] { "Flying_Nimbus", "Dark_Nimbus" };
/* 12 */   private int type = 0;
/*    */   private ModelBase aModel;
/*    */   
/*    */   public KintounRender() {
/* 16 */     this.aModel = new KintounModel();
/* 17 */     this.field_76989_e = 0.5F;
/*    */   }
/*    */   
/*    */   public KintounRender(int id) {
/* 21 */     this.type = id;
/* 22 */     this.aModel = new KintounModel();
/* 23 */     this.field_76989_e = 0.5F;
/*    */   }
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
/*    */   public void renderAModelAt(KintounBaseEntity entity, double d, double d1, double d2, float f, float par9) {
/* 39 */     GL11.glPushMatrix();
/* 40 */     GL11.glTranslatef((float)d, (float)d1 - 0.7F, (float)d2);
/* 41 */     GL11.glRotatef(90.0F - f, 0.0F, 1.0F, 0.0F);
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
/* 60 */     ResourceLocation tx = new ResourceLocation("jinryuudragonbc:npcs/" + this.texture[this.type] + ".png");
/* 61 */     this.field_76990_c.field_78724_e.func_110577_a(tx);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 68 */     GL11.glEnable(2977);
/* 69 */     GL11.glEnable(3042);
/* 70 */     GL11.glBlendFunc(770, 771);
/* 71 */     GL11.glScalef(-1.0F, -1.0F, 1.0F);
/* 72 */     this.aModel.func_78088_a(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
/* 73 */     GL11.glDisable(3042);
/* 74 */     GL11.glPopMatrix();
/*    */   }
/*    */   
/*    */   public void func_76986_a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
/* 78 */     renderAModelAt((KintounBaseEntity)par1Entity, par2, par4, par6, par8, par9);
/*    */   }
/* 80 */   private static final ResourceLocation shearedSheepTextures = new ResourceLocation("jinryuudragonbc:armor/halo.png");
/*    */   protected ResourceLocation func_110775_a(Entity entity) {
/* 82 */     return shearedSheepTextures;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\KintounRender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */