/*     */ package JinRyuu.DragonBC.common.Entitys;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Npcs.ModelEnergy;
/*     */ import JinRyuu.DragonBC.common.Npcs.RenderDBC;
/*     */ import JinRyuu.JRMCore.JRMCoreClient;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderEnergyFM
/*     */   extends RenderDBC
/*     */ {
/*     */   private ModelEnergy ener;
/*     */   private double dist;
/*     */   
/*     */   public RenderEnergyFM() {
/*  26 */     super((ModelBase)new ModelEnergy(), 0.5F);
/*  27 */     this.ener = new ModelEnergy();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderEnergy(EntityEnergyFM par1Entity, double par2, double par4, double par6, float par8, float par9) {
/*  34 */     int shrink = par1Entity.getShrink();
/*  35 */     int col = JRMCoreH.techCol[1];
/*  36 */     boolean b = false;
/*  37 */     if (par1Entity.shootingEntity != null) {
/*  38 */       b = (par1Entity.shootingEntity.func_145782_y() == JRMCoreClient.mc.field_71439_g.func_145782_y());
/*     */     }
/*     */     
/*  41 */     float var13 = handleRotationFloat(par1Entity, par9);
/*  42 */     double sx = par1Entity.strtX();
/*  43 */     double sy = par1Entity.strtY();
/*  44 */     double sz = par1Entity.strtZ();
/*  45 */     double x = sx - par1Entity.field_70165_t;
/*  46 */     double y = sy - par1Entity.field_70163_u;
/*  47 */     double z = sz - par1Entity.field_70161_v;
/*     */     
/*  49 */     double tsx = sx - par1Entity.trgtX();
/*  50 */     double tsy = sy - par1Entity.trgtY();
/*  51 */     double tsz = sz - par1Entity.trgtZ();
/*     */ 
/*     */     
/*  54 */     if (shrink > 0) {
/*  55 */       double d = this.dist - (par1Entity.getSpe() * 0.05F);
/*  56 */       this.dist = (d < 0.0D) ? 0.0D : d;
/*     */     } else {
/*     */       
/*  59 */       this.dist = MathHelper.func_76133_a(x * x + y * y + z * z);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  66 */     int sbh = (int)((par1Entity.field_70163_u > 80.0D) ? (par1Entity.field_70163_u - 80.0D) : 1.0D) * 4;
/*  67 */     float var20 = 1.0F + (sbh / 5 * 100) * 0.02F * 0.15F;
/*     */ 
/*     */ 
/*     */     
/*  71 */     double sx2 = sx - JRMCoreClient.mc.field_71439_g.field_70165_t;
/*  72 */     double sy2 = sy - JRMCoreClient.mc.field_71439_g.field_70163_u;
/*  73 */     double sz2 = sz - JRMCoreClient.mc.field_71439_g.field_70161_v;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  80 */     GL11.glPushMatrix();
/*  81 */     GL11.glDisable(2896);
/*  82 */     OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, 240.0F, 240.0F);
/*  83 */     GL11.glDepthMask(false);
/*     */     
/*  85 */     GL11.glEnable(3042);
/*  86 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  91 */     GL11.glTranslatef((float)par2, (float)par4, (float)par6);
/*  92 */     GL11.glRotatef(par1Entity.field_70126_B + (par1Entity.field_70177_z - par1Entity.field_70126_B) * par9 - 180.0F, 0.0F, 1.0F, 0.0F);
/*  93 */     GL11.glRotatef(par1Entity.field_70127_C + (par1Entity.field_70125_A - par1Entity.field_70127_C) * par9, 1.0F, 0.0F, 0.0F);
/*  94 */     GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
/*  95 */     tex(col);
/*  96 */     GL11.glScalef(var20 / 2.0F, var20 / 2.0F, var20 / 2.0F);
/*  97 */     this.ener.renderModel((byte)1, par1Entity, 0.0F, 0.0F, 0.0625F, var13, false);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 102 */     GL11.glDepthMask(true);
/*     */ 
/*     */     
/* 105 */     GL11.glEnable(2896);
/* 106 */     GL11.glDisable(3042);
/* 107 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 108 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   public void tex(int col) {
/* 112 */     float h2 = (col >> 16 & 0xFF) / 255.0F;
/* 113 */     float h3 = (col >> 8 & 0xFF) / 255.0F;
/* 114 */     float h4 = (col & 0xFF) / 255.0F;
/* 115 */     GL11.glColor4f(h2, h3, h4, 0.5F);
/* 116 */     ResourceLocation txx = new ResourceLocation("jinryuumodscore:allw.png");
/* 117 */     this.field_76990_c.field_78724_e.func_110577_a(txx);
/*     */   }
/*     */ 
/*     */   
/*     */   protected float handleRotationFloat(Entity par1Entity, float par2) {
/* 122 */     return par1Entity.field_70173_aa + par2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_76986_a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
/* 133 */     renderEnergy((EntityEnergyFM)par1Entity, par2, par4, par6, par8, par9);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Entitys\RenderEnergyFM.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */