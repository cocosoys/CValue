/*    */ package JinRyuu.DragonBC.common.Npcs;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Random;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderPorunga2
/*    */   extends RenderDBC {
/*    */   private ModelPorunga aModel;
/*    */   
/*    */   public RenderPorunga2() {
/* 18 */     super((ModelBase)new ModelPorunga(), 0.5F);
/* 19 */     this.aModel = new ModelPorunga();
/* 20 */     this.aModel.whis_granted = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderPorunga(EntityPorunga2 par1Entity, double par2, double par4, double par6, float par8, float par9) {
/* 25 */     GL11.glPushMatrix();
/*    */     
/* 27 */     float var13 = func_77044_a((EntityLivingBase)par1Entity, par9);
/* 28 */     float size = handleSizeFloat((Entity)par1Entity, par9);
/*    */     
/* 30 */     Random rand = new Random();
/* 31 */     float randfloat = (float)(rand.nextInt(5) * 0.1D);
/*    */     
/* 33 */     float var20 = size;
/* 34 */     GL11.glTranslatef((float)par2 + 0.0F, (float)par4 + 3.5F, (float)par6 + 0.0F);
/* 35 */     GL11.glRotatef(-(par1Entity.field_70126_B + (par1Entity.field_70177_z - par1Entity.field_70126_B) * par9 - 180.0F), 0.0F, 1.0F, 0.0F);
/* 36 */     GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/* 37 */     ResourceLocation txx = new ResourceLocation("jinryuudragonbc:npcs/Porunga.png");
/* 38 */     this.field_76990_c.field_78724_e.func_110577_a(txx);
/*    */     
/* 40 */     GL11.glEnable(2977);
/* 41 */     GL11.glPushMatrix();
/* 42 */     GL11.glScalef(var20, var20, var20);
/* 43 */     this.aModel.renderModel2((Entity)par1Entity, 0.0625F);
/*    */     
/* 45 */     GL11.glPopMatrix();
/*    */     
/* 47 */     GL11.glPopMatrix();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected float handleRotationFloat(Entity par1Entity, float par2) {
/* 53 */     return par1Entity.field_70173_aa + par2;
/*    */   }
/*    */ 
/*    */   
/*    */   protected float handleSizeFloat(Entity par1Entity, float par2) {
/* 58 */     float ticksExsisted = 3.0F - par1Entity.field_70173_aa * 0.02F;
/* 59 */     if (ticksExsisted < 0.0F)
/*    */     {
/* 61 */       ticksExsisted = 0.0F;
/*    */     }
/* 63 */     return ticksExsisted;
/*    */   }
/*    */   
/*    */   public void func_76986_a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
/* 67 */     renderPorunga((EntityPorunga2)par1Entity, par2, par4, par6, par8, par9);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\RenderPorunga2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */