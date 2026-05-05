/*     */ package JinRyuu.JRMCore.entity;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreClient;
/*     */ import JinRyuu.JRMCore.m.mEnergy5;
/*     */ import JinRyuu.JRMCore.m.mEnergy7;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderEnergyAttJ2
/*     */   extends RenderJRMC
/*     */ {
/*     */   private mEnergy5 ener;
/*     */   private mEnergy7 ener2;
/*  21 */   private final String[] jutsus = new String[] { "rasengan", "chidori", "FireStyle_FireBall", "Earth Wall", "Mud Wall", "Water Pistol" };
/*     */   
/*     */   public RenderEnergyAttJ2() {
/*  24 */     super((ModelBase)new mEnergy5(), 0.5F);
/*  25 */     this.ener = new mEnergy5();
/*  26 */     this.ener2 = new mEnergy7();
/*     */   }
/*     */ 
/*     */   
/*     */   private double dist;
/*     */ 
/*     */   
/*     */   public void renderEnergy(EntityEnergyAttJ2 par1Entity, double par2, double par4, double par6, float par8, float par9) {
/*  34 */     if (par1Entity.getjtsre() > 2) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  69 */       byte type = par1Entity.getType();
/*  70 */       byte perc = par1Entity.getPerc();
/*  71 */       int dam = par1Entity.getDam();
/*  72 */       byte den = par1Entity.getDen();
/*  73 */       int col = par1Entity.getCol();
/*  74 */       float size = par1Entity.getSizePerc();
/*     */       
/*  76 */       boolean b = false;
/*  77 */       if (par1Entity.shootingEntity != null) {
/*  78 */         b = (par1Entity.shootingEntity.func_145782_y() == JRMCoreClient.mc.field_71439_g.func_145782_y());
/*     */       }
/*  80 */       float var13 = handleRotationFloat(par1Entity, par9);
/*  81 */       double sx = par1Entity.strtX();
/*  82 */       double sy = par1Entity.strtY();
/*  83 */       double sz = par1Entity.strtZ();
/*  84 */       double x = sx - par1Entity.field_70165_t;
/*  85 */       double y = sy - par1Entity.field_70163_u;
/*  86 */       double z = sz - par1Entity.field_70161_v;
/*     */       
/*  88 */       double tsx = sx - par1Entity.trgtX();
/*  89 */       double tsy = sy - par1Entity.trgtY();
/*  90 */       double tsz = sz - par1Entity.trgtZ();
/*     */       
/*  92 */       if (par1Entity.getShrink()) { this.dist -= (par1Entity.getSpe() * 20.0F); }
/*  93 */       else { this.dist = MathHelper.func_76133_a(x * x + y * y + z * z); }
/*     */       
/*  95 */       float var20 = size * 2.0F;
/*  96 */       if (var20 > 30.0F) var20 = 30.0F;
/*     */       
/*  98 */       if (type == 1) {
/*  99 */         GL11.glPushMatrix();
/* 100 */         GL11.glEnable(2977);
/* 101 */         GL11.glEnable(3042);
/* 102 */         GL11.glBlendFunc(770, 771);
/*     */         
/* 104 */         if (par1Entity.getjtsre() != 3) GL11.glDepthMask(false); 
/* 105 */         GL11.glTranslatef((float)par2, (float)par4, (float)par6);
/* 106 */         GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
/*     */         
/* 108 */         if (par1Entity.getjtsre() == 3) {
/* 109 */           ResourceLocation tx = new ResourceLocation("jinryuunarutoc:jutsu/" + this.jutsus[par1Entity.getjtsre() - 1] + ".png");
/* 110 */           this.field_76990_c.field_78724_e.func_110577_a(tx);
/*     */           
/* 112 */           float seb_szaz = 10.0F;
/* 113 */           float seb_one = seb_szaz / 100.0F;
/* 114 */           float max = 15.0F;
/* 115 */           float ti = par1Entity.field_70173_aa;
/* 116 */           float curr = ti * seb_one;
/* 117 */           curr = (curr >= max) ? max : curr;
/*     */           
/* 119 */           GL11.glTranslatef(0.0F, -curr / 2.0F, 0.0F);
/*     */           
/* 121 */           GL11.glScalef(curr, curr, curr);
/*     */           
/* 123 */           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 124 */           GL11.glRotatef((par1Entity.field_70173_aa * 10), 1.0F, 1.0F, 0.0F);
/* 125 */           this.ener.func_78088_a(par1Entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
/*     */           
/* 127 */           GL11.glColor4f(1.0F, 0.8F, 0.8F, 0.4F);
/* 128 */           GL11.glScalef(1.2F, 1.2F, 1.2F);
/* 129 */           GL11.glRotatef((par1Entity.field_70173_aa * 5), 0.0F, 1.0F, 1.0F);
/* 130 */           this.ener.func_78088_a(par1Entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
/*     */         }
/* 132 */         else if (par1Entity.getjtsre() == 6) {
/* 133 */           ResourceLocation tx = new ResourceLocation("jinryuumodscore:allw.png");
/* 134 */           this.field_76990_c.field_78724_e.func_110577_a(tx);
/* 135 */           GL11.glDepthMask(true);
/* 136 */           float seb_szaz = 10.0F;
/* 137 */           float seb_one = seb_szaz / 100.0F;
/* 138 */           float max = 1.0F;
/* 139 */           float ti = par1Entity.field_70173_aa;
/* 140 */           float curr = ti * seb_one;
/* 141 */           curr = (curr >= max) ? max : curr;
/*     */           
/* 143 */           GL11.glTranslatef(0.0F, -curr / 2.0F, 0.0F);
/* 144 */           GL11.glScalef(curr, curr, curr);
/* 145 */           GL11.glColor4f(0.3F, 0.6F, 0.8F, 0.7F);
/*     */           
/* 147 */           GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
/* 148 */           GL11.glRotatef(-par1Entity.field_70177_z, 0.0F, 1.0F, 0.0F);
/* 149 */           GL11.glRotatef(par1Entity.field_70125_A, 0.0F, 0.0F, 1.0F);
/* 150 */           this.ener2.func_78088_a(par1Entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
/*     */           
/* 152 */           GL11.glDepthMask(true);
/*     */           
/* 154 */           GL11.glColor4f(0.3F, 0.45F, 0.8F, 0.5F);
/* 155 */           GL11.glScalef(curr * 1.2F, curr * 1.2F, curr * 1.2F);
/* 156 */           this.ener2.func_78088_a(par1Entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
/*     */         } 
/*     */         
/* 159 */         GL11.glDisable(3042);
/* 160 */         GL11.glDisable(2977);
/* 161 */         GL11.glPopMatrix();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void tex(int col) {
/* 568 */     float h2 = (col >> 16 & 0xFF) / 255.0F;
/* 569 */     float h3 = (col >> 8 & 0xFF) / 255.0F;
/* 570 */     float h4 = (col & 0xFF) / 255.0F;
/* 571 */     GL11.glColor4f(h2, h3, h4, 0.5F);
/* 572 */     ResourceLocation txx = new ResourceLocation("jinryuumodscore:allw.png");
/* 573 */     this.field_76990_c.field_78724_e.func_110577_a(txx);
/*     */   }
/*     */   protected float handleRotationFloat(Entity par1Entity, float par2) {
/* 576 */     return par1Entity.field_70173_aa + par2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_76986_a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
/* 585 */     renderEnergy((EntityEnergyAttJ2)par1Entity, par2, par4, par6, par8, par9);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\RenderEnergyAttJ2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */