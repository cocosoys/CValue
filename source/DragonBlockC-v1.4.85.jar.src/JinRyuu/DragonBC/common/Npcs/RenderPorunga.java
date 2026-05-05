/*    */ package JinRyuu.DragonBC.common.Npcs;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Random;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderPorunga
/*    */   extends RenderLiving
/*    */ {
/*    */   private ModelPorunga aModel;
/*    */   
/*    */   public RenderPorunga() {
/* 20 */     super((ModelBase)new ModelPorunga(), 0.5F);
/* 21 */     this.aModel = new ModelPorunga();
/* 22 */     this.aModel.whis_granted = false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderPorunga(EntityPorunga par1Entity, double par2, double par4, double par6, float par8, float par9) {
/* 27 */     GL11.glPushMatrix();
/*    */     
/* 29 */     float var13 = func_77044_a((EntityLivingBase)par1Entity, par9);
/* 30 */     float size = handleSizeFloat((Entity)par1Entity, par9);
/*    */     
/* 32 */     Random rand = new Random();
/* 33 */     float randfloat = (float)(rand.nextInt(5) * 0.1D);
/*    */     
/* 35 */     float var20 = size;
/* 36 */     GL11.glTranslatef((float)par2 + 0.0F, (float)par4 + 3.5F, (float)par6 + 0.0F);
/* 37 */     GL11.glRotatef(-(par1Entity.field_70126_B + (par1Entity.field_70177_z - par1Entity.field_70126_B) * par9 - 180.0F), 0.0F, 1.0F, 0.0F);
/* 38 */     GL11.glRotatef(0.0F, 1.0F, 0.0F, 0.0F);
/* 39 */     GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/* 40 */     ResourceLocation txx = new ResourceLocation("jinryuudragonbc:npcs/Porunga.png");
/* 41 */     this.field_76990_c.field_78724_e.func_110577_a(txx);
/* 42 */     GL11.glEnable(2977);
/*    */ 
/*    */     
/* 45 */     GL11.glPushMatrix();
/* 46 */     GL11.glScalef(var20, var20, var20);
/* 47 */     this.aModel.renderModel((Entity)par1Entity, 0.0625F);
/*    */     
/* 49 */     GL11.glPopMatrix();
/* 50 */     GL11.glPopMatrix();
/*    */   }
/*    */ 
/*    */   
/*    */   protected float handleRotationFloat(Entity par1Entity, float par2) {
/* 55 */     return par1Entity.field_70173_aa + par2;
/*    */   }
/*    */ 
/*    */   
/*    */   protected float handleSizeFloat(Entity par1Entity, float par2) {
/* 60 */     float ticksExsisted = par1Entity.field_70173_aa * 0.05F;
/* 61 */     if (ticksExsisted > 3.0F) {
/* 62 */       ticksExsisted = 3.0F;
/*    */     }
/*    */     
/* 65 */     return ticksExsisted;
/*    */   }
/*    */   public void func_76986_a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
/* 68 */     renderPorunga((EntityPorunga)par1Entity, par2, par4, par6, par8, par9);
/*    */   }
/* 70 */   private static final ResourceLocation endermanTextures = new ResourceLocation("jinryuudragonbc:npcs/Porunga.png");
/*    */   protected ResourceLocation func_110775_a(Entity entity) {
/* 72 */     return endermanTextures;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\RenderPorunga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */