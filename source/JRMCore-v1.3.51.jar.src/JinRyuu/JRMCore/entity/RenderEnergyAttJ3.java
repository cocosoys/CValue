/*    */ package JinRyuu.JRMCore.entity;
/*    */ 
/*    */ import JinRyuu.JRMCore.m.mEnergy4;
/*    */ import JinRyuu.JRMCore.m.mEnergy6;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderEnergyAttJ3
/*    */   extends RenderJRMC {
/*    */   private mEnergy4 ener;
/*    */   private mEnergy6 ener2;
/* 17 */   private final String[] jutsus = new String[] { "", "", "", "Earth_Wall", "EarthStyle_MudWall", "" };
/*    */   
/*    */   public RenderEnergyAttJ3() {
/* 20 */     super((ModelBase)new mEnergy4(), 0.5F);
/* 21 */     this.ener = new mEnergy4();
/* 22 */     this.ener2 = new mEnergy6();
/*    */   }
/*    */ 
/*    */   
/*    */   private double dist;
/*    */   
/*    */   public void renderEnergy(EntityEnergyAttJ3 par1Entity, double par2, double par4, double par6, float par8, float par9) {
/* 29 */     if (par1Entity.getjtsre() == 4 || par1Entity.getjtsre() == 5) {
/* 30 */       byte type = par1Entity.getType();
/* 31 */       byte perc = par1Entity.getPerc();
/* 32 */       int dam = par1Entity.getDam();
/* 33 */       float size = par1Entity.getSizePerc();
/*    */       
/* 35 */       double x = par1Entity.field_70165_t;
/* 36 */       double y = par1Entity.field_70163_u;
/* 37 */       double z = par1Entity.field_70161_v;
/*    */       
/* 39 */       if (type == 1) {
/* 40 */         GL11.glPushMatrix();
/* 41 */         GL11.glEnable(2977);
/* 42 */         GL11.glEnable(3042);
/* 43 */         GL11.glBlendFunc(770, 771);
/*    */         
/* 45 */         GL11.glTranslatef((float)par2, (float)par4, (float)par6);
/*    */         
/* 47 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 48 */         GL11.glRotatef(par1Entity.getrota(), 0.0F, -1.0F, 0.0F);
/* 49 */         GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
/* 50 */         float seb_szaz = 5.0F;
/* 51 */         float seb_one = seb_szaz / 100.0F;
/* 52 */         float max = 1.0F;
/* 53 */         float ti = par1Entity.field_70173_aa;
/* 54 */         float curr = ti * seb_one;
/* 55 */         curr = (curr >= max) ? max : curr;
/*    */ 
/*    */         
/* 58 */         GL11.glScalef(1.0F, 1.0F, 1.0F);
/* 59 */         GL11.glTranslatef(0.0F, max - curr, 0.0F);
/* 60 */         GL11.glTranslatef(0.0F, -1.2F, 0.0F);
/*    */         
/* 62 */         ResourceLocation tx = new ResourceLocation("jinryuunarutoc:jutsu/" + this.jutsus[par1Entity.getjtsre() - 1] + ".png");
/* 63 */         this.field_76990_c.field_78724_e.func_110577_a(tx);
/* 64 */         if (par1Entity.getjtsre() == 4) { this.ener.func_78088_a(par1Entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F); }
/* 65 */         else if (par1Entity.getjtsre() == 5) { this.ener2.func_78088_a(par1Entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F); }
/*    */         
/* 67 */         GL11.glDisable(3042);
/* 68 */         GL11.glDisable(2977);
/* 69 */         GL11.glPopMatrix();
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void tex(int col) {
/* 75 */     float h2 = (col >> 16 & 0xFF) / 255.0F;
/* 76 */     float h3 = (col >> 8 & 0xFF) / 255.0F;
/* 77 */     float h4 = (col & 0xFF) / 255.0F;
/* 78 */     GL11.glColor4f(h2, h3, h4, 0.5F);
/* 79 */     ResourceLocation txx = new ResourceLocation("jinryuumodscore:allw.png");
/* 80 */     this.field_76990_c.field_78724_e.func_110577_a(txx);
/*    */   }
/*    */   protected float handleRotationFloat(Entity par1Entity, float par2) {
/* 83 */     return par2;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_76986_a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
/* 92 */     renderEnergy((EntityEnergyAttJ3)par1Entity, par2, par4, par6, par8, par9);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\RenderEnergyAttJ3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */