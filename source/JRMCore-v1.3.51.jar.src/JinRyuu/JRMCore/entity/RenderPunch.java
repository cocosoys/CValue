/*    */ package JinRyuu.JRMCore.entity;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Random;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderPunch
/*    */   extends RenderJRMC
/*    */ {
/*    */   private ModelKiExplosion aModel;
/*    */   
/*    */   public RenderPunch() {
/* 18 */     super((ModelBase)new ModelKiExplosion(), 0.5F);
/* 19 */     this.aModel = new ModelKiExplosion();
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderPunch(EntityPunch par1Entity, double par2, double par4, double par6, float par8, float par9) {
/* 24 */     GL11.glPushMatrix();
/*    */     
/* 26 */     float var13 = handleRotationFloat(par1Entity, par9);
/*    */     
/* 28 */     Random rand = new Random();
/* 29 */     float randfloat = (float)(rand.nextInt(5) * 0.1D);
/* 30 */     float var20 = 0.001F;
/*    */     
/* 32 */     GL11.glTranslatef((float)par2 + 0.0F, (float)par4 + 0.0F, (float)par6 + 0.0F);
/* 33 */     GL11.glRotatef(par1Entity.field_70126_B + (par1Entity.field_70177_z - par1Entity.field_70126_B) * par9 - 180.0F, 0.0F, 1.0F, 0.0F);
/* 34 */     GL11.glRotatef(par1Entity.field_70127_C + (par1Entity.field_70125_A - par1Entity.field_70127_C) * par9, 1.0F, 0.0F, 0.0F);
/* 35 */     GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
/*    */ 
/*    */     
/* 38 */     ResourceLocation txx = new ResourceLocation("jinryuudragonbc:Ki/ki.png"); this.field_76990_c.field_78724_e.func_110577_a(txx);
/* 39 */     GL11.glEnable(2977);
/* 40 */     GL11.glEnable(3042);
/* 41 */     GL11.glBlendFunc(770, 771);
/* 42 */     GL11.glPushMatrix();
/* 43 */     GL11.glScalef(var20, var20, var20);
/* 44 */     this.aModel.renderModel(par1Entity, 0.0F, 0.0F, 0.0625F, var13);
/* 45 */     GL11.glPopMatrix();
/* 46 */     GL11.glDisable(3042);
/* 47 */     GL11.glPopMatrix();
/*    */   }
/*    */ 
/*    */   
/*    */   protected float handleRotationFloat(Entity par1Entity, float par2) {
/* 52 */     return par1Entity.field_70173_aa + par2;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_76986_a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
/* 63 */     renderPunch((EntityPunch)par1Entity, par2, par4, par6, par8, par9);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\RenderPunch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */