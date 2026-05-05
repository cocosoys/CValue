/*     */ package JinRyuu.JBRA;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.JRMCoreHJYC;
/*     */ import JinRyuu.JRMCore.entity.ModelBipedBody;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NC_GiTurtleMdl
/*     */   extends ModelBipedBody
/*     */ {
/*  18 */   private final int VANITY_KONOHAMARU_SCARF = 0; private final int VANITY_NARUTO_GOGGLES = 1;
/*  19 */   public int id = -1;
/*     */   
/*     */   public ModelRenderer Base1;
/*     */   
/*     */   public ModelRenderer Base2;
/*     */   
/*     */   public ModelRenderer ScarfTale1;
/*     */   public ModelRenderer ScarfTale2;
/*     */   public ModelRenderer ScarfTale3;
/*     */   public ModelRenderer ScarfTale4;
/*     */   public ModelRenderer ScarfTale5;
/*     */   public ModelRenderer n_Base;
/*     */   public ModelRenderer n_Front1;
/*     */   public ModelRenderer n_Eye1;
/*     */   public ModelRenderer n_Eye2;
/*     */   private float size;
/*     */   
/*     */   public NC_GiTurtleMdl(int id) {
/*  37 */     super(0.1F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 103 */     this.size = 1.0F; this.id = id; if (id == 0) {
/*     */       this.field_78090_t = 64; this.field_78089_u = 64; this.ScarfTale2 = new ModelRenderer((ModelBase)this, 38, 5); this.ScarfTale2.func_78793_a(-0.6F, 4.4F, 2.2F); this.ScarfTale2.func_78790_a(-2.1F, 0.0F, -0.4F, 4, 3, 1, 0.0F); setRotateAngle(this.ScarfTale2, -0.18203785F, 0.0F, 0.0F); this.ScarfTale3 = new ModelRenderer((ModelBase)this, 38, 10); this.ScarfTale3.func_78793_a(0.0F, 3.0F, 0.0F); this.ScarfTale3.func_78790_a(-2.1F, -0.1F, -0.4F, 4, 3, 1, 0.0F); setRotateAngle(this.ScarfTale3, 0.13665928F, 0.0F, 0.0F); this.ScarfTale1 = new ModelRenderer((ModelBase)this, 38, 1); this.ScarfTale1.func_78793_a(0.0F, 0.0F, 0.0F); this.ScarfTale1.func_78790_a(-2.7F, 2.5F, 1.8F, 4, 2, 1, 0.0F); setRotateAngle(this.ScarfTale1, 0.4098033F, 0.0F, 0.0F); this.ScarfTale5 = new ModelRenderer((ModelBase)this, 49, 1); this.ScarfTale5.func_78793_a(0.0F, 3.6F, 0.0F); this.ScarfTale5.func_78790_a(-2.1F, 0.0F, -0.4F, 4, 6, 1, 0.0F); setRotateAngle(this.ScarfTale5, 0.13665928F, 0.0F, 0.0F); this.Base1 = new ModelRenderer((ModelBase)this, 0, 0); this.Base1.func_78793_a(0.0F, 0.0F, 0.0F); this.Base1.func_78790_a(-5.5F, -0.4F, -4.2F, 11, 2, 8, 0.0F); setRotateAngle(this.Base1, 0.10995574F, 0.0F, 0.0F); this.Base2 = new ModelRenderer((ModelBase)this, 0, 10); this.Base2.func_78793_a(0.0F, 0.0F, 0.0F); this.Base2.func_78790_a(-4.5F, -1.0F, -4.5F, 9, 2, 9, 0.0F); this.ScarfTale4 = new ModelRenderer((ModelBase)this, 38, 15); this.ScarfTale4.func_78793_a(0.0F, 3.0F, 0.0F); this.ScarfTale4.func_78790_a(-2.1F, -0.2F, -0.4F, 4, 4, 1, 0.0F); setRotateAngle(this.ScarfTale4, 0.13665928F, 0.0F, 0.0F); this.ScarfTale1.func_78792_a(this.ScarfTale2); this.ScarfTale2.func_78792_a(this.ScarfTale3); this.Base2.func_78792_a(this.ScarfTale1); this.ScarfTale4.func_78792_a(this.ScarfTale5); this.Base1.func_78792_a(this.Base2); this.ScarfTale3.func_78792_a(this.ScarfTale4); this.field_78116_c.func_78792_a(this.Base1);
/*     */     } else if (id == 1) {
/*     */       this.field_78090_t = 64; this.field_78089_u = 32; this.n_Base = new ModelRenderer((ModelBase)this, 1, 1); this.n_Base.func_78793_a(0.0F, 0.0F, 0.0F); this.n_Base.func_78790_a(-5.0F, -8.7F, -5.9F, 10, 3, 10, 0.0F); setRotateAngle(this.n_Base, -0.18203785F, 0.0F, 0.0F); this.n_Eye2 = new ModelRenderer((ModelBase)this, 1, 6); this.n_Eye2.func_78793_a(0.0F, 0.0F, 0.0F); this.n_Eye2.func_78790_a(1.1F, -8.0F, -7.0F, 3, 2, 1, 0.0F); this.n_Eye1 = new ModelRenderer((ModelBase)this, 1, 2); this.n_Eye1.func_78793_a(0.0F, 0.0F, 0.0F); this.n_Eye1.func_78790_a(-4.2F, -8.0F, -7.0F, 3, 2, 1, 0.0F); this.n_Front1 = new ModelRenderer((ModelBase)this, 1, 15); this.n_Front1.func_78793_a(0.0F, 0.0F, 0.0F); this.n_Front1.func_78790_a(-4.5F, -8.3F, -6.2F, 9, 3, 1, 0.0F); this.n_Base.func_78792_a(this.n_Eye2); this.n_Base.func_78792_a(this.n_Eye1); this.n_Base.func_78792_a(this.n_Front1); this.field_78116_c.func_78792_a(this.n_Base);
/* 107 */     }  } public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { GL11.glPushMatrix();
/* 108 */     float f6 = this.size;
/* 109 */     if (JRMCoreH.JYC()) {
/* 110 */       float age = JRMCoreHJYC.JYCAge((EntityPlayer)entity);
/* 111 */       float childScl = JRMCoreHJYC.JYCsizeBasedOnAge((EntityPlayer)entity);
/* 112 */       childScl = 3.0F - childScl * 2.0F;
/* 113 */       this.size = childScl;
/*     */     } 
/*     */ 
/*     */     
/* 117 */     if (this.id == 0) {
/* 118 */       GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
/* 119 */       GL11.glTranslatef(0.0F, (f6 - 1.0F) * 1.5F, 0.0F);
/* 120 */       func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 121 */       GL11.glPushMatrix();
/* 122 */       GL11.glScalef(1.2F, 1.2F, 1.2F);
/* 123 */       this.Base1.func_78785_a(f5);
/* 124 */       GL11.glPopMatrix();
/*     */     }
/* 126 */     else if (this.id == 1) {
/* 127 */       GL11.glScalef(0.5F + 0.5F / f6, 0.5F + 0.5F / f6, 0.5F + 0.5F / f6);
/* 128 */       GL11.glTranslatef(0.0F, (f6 - 1.0F) / f6 * (2.0F - ((f6 >= 1.5F && f6 <= 2.0F) ? ((2.0F - f6) / 2.5F) : ((f6 < 1.5F && f6 >= 1.0F) ? ((f6 * 2.0F - 2.0F) * 0.2F) : 0.0F))), 0.0F);
/* 129 */       func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 130 */       this.n_Base.func_78785_a(f5);
/*     */     } 
/*     */     
/* 133 */     GL11.glPopMatrix(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 140 */     modelRenderer.field_78795_f = x;
/* 141 */     modelRenderer.field_78796_g = y;
/* 142 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity entity) {
/* 146 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, entity);
/* 147 */     if (this.id == 0) {
/* 148 */       float s = 0.0F;
/*     */       
/* 150 */       if (y == 1) {
/* 151 */         float s2 = MathHelper.func_76134_b(par1 * 0.6662F) * 1.0F * par2;
/* 152 */         float s3 = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.0F * par2;
/* 153 */         this.ScarfTale1.field_78795_f = ((s3 + s > s) ? (s3 + s) : ((s2 + s > s) ? (s2 + s) : s)) / 2.0F;
/* 154 */         this.ScarfTale2.field_78795_f = ((s3 + s > s) ? (s3 + s) : ((s2 + s > s) ? (s2 + s) : s)) / 2.0F;
/* 155 */         this.ScarfTale3.field_78795_f = ((s3 + s > s) ? (s3 + s) : ((s2 + s > s) ? (s2 + s) : s)) / 2.0F;
/* 156 */         this.ScarfTale4.field_78795_f = ((s3 + s > s) ? (s3 + s) : ((s2 + s > s) ? (s2 + s) : s)) / 2.0F;
/*     */       } else {
/*     */         
/* 159 */         float s2 = MathHelper.func_76134_b(par1 * 0.6662F) * 1.0F * par2;
/* 160 */         float s3 = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.0F * par2;
/* 161 */         this.ScarfTale1.field_78795_f = ((s3 + s > s) ? (s3 + s) : ((s2 + s > s) ? (s2 + s) : s)) / 2.0F;
/* 162 */         this.ScarfTale1.field_78795_f -= 0.1F;
/* 163 */         this.ScarfTale2.field_78795_f = ((s3 + s > s) ? (s3 + s) : ((s2 + s > s) ? (s2 + s) : s)) / 2.0F;
/* 164 */         this.ScarfTale2.field_78795_f -= 0.1F;
/* 165 */         this.ScarfTale3.field_78795_f = ((s3 + s > s) ? (s3 + s) : ((s2 + s > s) ? (s2 + s) : s)) / 2.0F;
/* 166 */         this.ScarfTale3.field_78795_f -= 0.1F;
/* 167 */         this.ScarfTale4.field_78795_f = ((s3 + s > s) ? (s3 + s) : ((s2 + s > s) ? (s2 + s) : s)) / 2.0F;
/* 168 */         this.ScarfTale4.field_78795_f -= 0.1F;
/*     */       } 
/*     */       
/* 171 */       if (entity.func_70093_af()) {
/* 172 */         float s2 = MathHelper.func_76134_b(par1 * 0.6662F) * 1.0F * par2;
/* 173 */         float s3 = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.0F * par2;
/* 174 */         this.ScarfTale1.field_78795_f += 0.3F;
/* 175 */         this.Base1.field_78795_f = 0.5F;
/*     */       } else {
/*     */         
/* 178 */         setRotateAngle(this.Base1, 0.10995574F, 0.0F, 0.0F);
/* 179 */         setRotateAngle(this.ScarfTale1, 0.3F, -0.0F, 0.0F);
/*     */       }
/*     */     
/*     */     }
/* 183 */     else if (this.id == 1) {
/* 184 */       this.n_Base.field_78798_e = this.field_78116_c.field_78798_e;
/* 185 */       this.n_Base.field_78797_d = this.field_78116_c.field_78797_d;
/* 186 */       this.n_Base.field_78800_c = this.field_78116_c.field_78800_c;
/*     */       
/* 188 */       this.n_Base.field_78808_h = this.field_78116_c.field_78808_h;
/* 189 */       this.n_Base.field_78796_g = this.field_78116_c.field_78796_g;
/* 190 */       this.n_Base.field_78795_f = this.field_78116_c.field_78795_f;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JBRA-Client-v1.6.52.jar!\JinRyuu\JBRA\NC_GiTurtleMdl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */