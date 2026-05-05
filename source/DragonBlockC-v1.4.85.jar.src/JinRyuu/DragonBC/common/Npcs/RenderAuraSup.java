/*    */ package JinRyuu.DragonBC.common.Npcs;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Random;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderAuraSup
/*    */   extends RenderDBC
/*    */ {
/*    */   private ModelAura aModel;
/*    */   private int field_77068_a;
/*    */   
/*    */   public RenderAuraSup() {
/* 22 */     super((ModelBase)new ModelAura(), 0.5F);
/* 23 */     this.aModel = new ModelAura();
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderAuraSup(EntityAuraSup par1Entity, double par2, double par4, double par6, float par8, float par9) {
/* 28 */     this.field_76989_e = 0.0F;
/* 29 */     GL11.glPushMatrix();
/* 30 */     GL11.glPushMatrix();
/*    */     
/* 32 */     float var13 = handleRotationFloat(par1Entity, par9);
/*    */     
/* 34 */     Random rand = new Random();
/* 35 */     float randfloat = (float)(rand.nextInt(5) * 0.1D);
/*    */     
/* 37 */     GL11.glTranslatef((float)par2 + 0.0F, (float)par4 + 1.5F, (float)par6 + 0.0F);
/* 38 */     GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/*    */     
/* 40 */     ResourceLocation txx = new ResourceLocation("jinryuudragonbc:auras.png"); this.field_76990_c.field_78724_e.func_110577_a(txx);
/* 41 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.15F);
/* 42 */     GL11.glDepthMask(false);
/* 43 */     GL11.glEnable(3042);
/* 44 */     GL11.glBlendFunc(770, 771);
/* 45 */     GL11.glAlphaFunc(516, 0.003921569F);
/* 46 */     for (int i = 0; i < 8; i++) {
/* 47 */       GL11.glPushMatrix();
/* 48 */       GL11.glRotatef((i * 45), 0.0F, 1.0F, 0.0F);
/* 49 */       this.aModel.renderModel(par1Entity, 0.0625F, var13, 0.0F, 20.0F);
/* 50 */       GL11.glPopMatrix();
/*    */     } 
/* 52 */     GL11.glDisable(3042);
/* 53 */     GL11.glAlphaFunc(516, 0.1F);
/* 54 */     GL11.glPopMatrix();
/* 55 */     GL11.glDepthMask(true);
/* 56 */     GL11.glPopMatrix();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected float handleRotationFloat(Entity par1Entity, float par2) {
/* 62 */     return par1Entity.field_70173_aa + par2;
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
/*    */   public void func_76986_a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
/* 88 */     renderAuraSup((EntityAuraSup)par1Entity, par2, par4, par6, par8, par9);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\RenderAuraSup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */