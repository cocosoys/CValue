/*    */ package JinRyuu.JRMCore.entity;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.entity.Render;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderPrjtls_1
/*    */   extends Render
/*    */ {
/*    */   private ModelPrjtls_1 mod1;
/*    */   private ModelPrjtls_2 mod2;
/*    */   private ModelPrjtls_3 mod3;
/* 17 */   String[] wt = new String[] { "Rocket1", "Rocket2", "Rocket3", "Rocket2", "Rocket2", "Rocket2", "Rocket2" };
/*    */ 
/*    */   
/*    */   public RenderPrjtls_1() {
/* 21 */     this.mod1 = new ModelPrjtls_1();
/* 22 */     this.mod2 = new ModelPrjtls_2();
/* 23 */     this.mod3 = new ModelPrjtls_3();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity) {
/* 29 */     return null;
/*    */   }
/*    */   
/*    */   public void renderItemKunai(EntityPrjtls_1 Entity, double par2, double par4, double par6, float par8, float par9) {
/* 33 */     int wt = Entity.getWpnTyp();
/*    */     
/* 35 */     if (wt > -1) {
/*    */       
/* 37 */       ResourceLocation txx = new ResourceLocation("jinryuudragonbc:projectiles/" + this.wt[wt] + ".png"); this.field_76990_c.field_78724_e.func_110577_a(txx);
/* 38 */       GL11.glPushMatrix();
/* 39 */       GL11.glEnable(2977);
/* 40 */       GL11.glEnable(3042);
/* 41 */       GL11.glBlendFunc(770, 771);
/* 42 */       GL11.glDepthMask(true);
/* 43 */       GL11.glTranslatef((float)par2, (float)par4, (float)par6);
/*    */       
/* 45 */       GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
/* 46 */       GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
/* 47 */       GL11.glRotatef(-Entity.field_70177_z, 0.0F, 1.0F, 0.0F);
/* 48 */       GL11.glRotatef(Entity.field_70125_A - 90.0F, 0.0F, 0.0F, 1.0F);
/*    */       
/* 50 */       GL11.glRotatef(90.0F, -1.0F, 0.0F, 0.0F);
/* 51 */       float sc = 0.7F;
/* 52 */       if (wt == 0) { sc = 0.7F; }
/* 53 */       else if (wt == 1 || wt == 5) { sc = 1.3F; }
/* 54 */       else if (wt == 2) { sc = 2.0F; }
/* 55 */       else { sc = 0.2F; }
/*    */       
/* 57 */       GL11.glScalef(sc, sc, sc);
/* 58 */       GL11.glColor3f(1.0F, 1.0F, 1.0F);
/* 59 */       if (wt == 0) { this.mod1.func_78088_a((Entity)Entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F); }
/* 60 */       else if (wt == 1 || wt == 5) { this.mod2.func_78088_a((Entity)Entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F); }
/* 61 */       else if (wt == 2) { this.mod3.func_78088_a((Entity)Entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F); }
/* 62 */       else { this.mod2.func_78088_a((Entity)Entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F); }
/*    */ 
/*    */       
/* 65 */       GL11.glDisable(3042);
/* 66 */       GL11.glAlphaFunc(516, 0.1F);
/* 67 */       GL11.glDepthMask(true);
/* 68 */       GL11.glPopMatrix();
/*    */     } 
/*    */   }
/*    */   public void func_76986_a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
/* 72 */     renderItemKunai((EntityPrjtls_1)par1Entity, par2, par4, par6, par8, par9);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\RenderPrjtls_1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */