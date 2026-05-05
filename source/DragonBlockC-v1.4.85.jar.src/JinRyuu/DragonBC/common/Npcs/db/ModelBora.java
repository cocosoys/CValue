/*     */ package JinRyuu.DragonBC.common.Npcs.db;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelBora
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer Hair;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Chest;
/*     */   public ModelRenderer Body3;
/*     */   
/*     */   public ModelBora() {
/*  22 */     this.field_78090_t = 128;
/*  23 */     this.field_78089_u = 64;
/*  24 */     this.LegR = new ModelRenderer(this, 0, 43);
/*  25 */     this.LegR.func_78793_a(-2.4F, 10.1F, 0.0F);
/*  26 */     this.LegR.func_78790_a(-2.5F, 0.0F, -2.5F, 5, 14, 5, -0.1F);
/*  27 */     this.Head = new ModelRenderer(this, 0, 0);
/*  28 */     this.Head.func_78793_a(0.0F, -3.4F, 0.0F);
/*  29 */     this.Head.func_78790_a(-4.0F, -8.2F, -4.0F, 8, 8, 8, 0.0F);
/*  30 */     this.Body3 = new ModelRenderer(this, 22, 44);
/*  31 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  32 */     this.Body3.func_78790_a(-5.0F, 9.7F, -2.5F, 10, 4, 5, 0.0F);
/*  33 */     this.ArmL = new ModelRenderer(this, 0, 17);
/*  34 */     this.ArmL.field_78809_i = true;
/*  35 */     this.ArmL.func_78793_a(5.8F, -1.7F, 0.0F);
/*  36 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.5F, 5, 14, 5, -0.2F);
/*  37 */     this.Chest = new ModelRenderer(this, 54, 19);
/*  38 */     this.Chest.func_78793_a(0.0F, 0.0F, 0.0F);
/*  39 */     this.Chest.func_78790_a(-5.0F, 1.0F, -2.7F, 10, 4, 1, 0.0F);
/*  40 */     this.LegL = new ModelRenderer(this, 0, 43);
/*  41 */     this.LegL.field_78809_i = true;
/*  42 */     this.LegL.func_78793_a(2.4F, 10.1F, 0.0F);
/*  43 */     this.LegL.func_78790_a(-2.5F, 0.0F, -2.5F, 5, 14, 5, -0.1F);
/*  44 */     this.ArmR = new ModelRenderer(this, 0, 17);
/*  45 */     this.ArmR.func_78793_a(-5.8F, -1.7F, 0.0F);
/*  46 */     this.ArmR.func_78790_a(-4.0F, -2.0F, -2.5F, 5, 14, 5, -0.2F);
/*  47 */     this.Body = new ModelRenderer(this, 22, 17);
/*  48 */     this.Body.func_78793_a(0.0F, -3.5F, 0.0F);
/*  49 */     this.Body.func_78790_a(-5.0F, 0.0F, -2.0F, 10, 7, 5, 0.1F);
/*  50 */     this.Hair = new ModelRenderer(this, 33, 0);
/*  51 */     this.Hair.func_78793_a(0.0F, -1.2F, 4.0F);
/*  52 */     this.Hair.func_78790_a(-2.0F, 0.0F, 0.0F, 4, 6, 0, 0.0F);
/*  53 */     setRotateAngle(this.Hair, 0.04712389F, 0.0F, 0.0F);
/*  54 */     this.Body2 = new ModelRenderer(this, 23, 31);
/*  55 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  56 */     this.Body2.func_78790_a(-4.5F, 4.7F, -2.4F, 9, 5, 5, 0.0F);
/*  57 */     this.Body2.func_78792_a(this.Body3);
/*  58 */     this.Body.func_78792_a(this.Chest);
/*  59 */     this.Head.func_78792_a(this.Hair);
/*  60 */     this.Body.func_78792_a(this.Body2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  65 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  67 */     this.Head.func_78785_a(f5);
/*     */     
/*  69 */     this.Body.func_78785_a(f5);
/*  70 */     this.ArmR.func_78785_a(f5);
/*  71 */     this.ArmL.func_78785_a(f5);
/*  72 */     this.LegL.func_78785_a(f5);
/*  73 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/*  83 */     modelRenderer.field_78795_f = x;
/*  84 */     modelRenderer.field_78796_g = y;
/*  85 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/*  89 */     int calc = par7Entity.field_70173_aa;
/*  90 */     if (calc > 100) calc -= 100; 
/*  91 */     float r = 360.0F;
/*  92 */     float r2 = 180.0F;
/*  93 */     float n4 = par4;
/*  94 */     float n5 = par5;
/*     */     
/*  96 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/*  97 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/*  98 */     float ex = par7Entity.field_70173_aa;
/*  99 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 100 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 102 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 103 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 130 */     this.Hair.field_78795_f = -0.15F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 131 */     if (0.0F > this.Hair.field_78795_f) this.Hair.field_78795_f *= -1.0F; 
/* 132 */     this.Hair.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 152 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 153 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 154 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 155 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 157 */     this.LegR.field_78796_g = 0.0F;
/* 158 */     this.LegL.field_78796_g = 0.0F;
/* 159 */     this.ArmR.field_78796_g = 0.0F;
/* 160 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 168 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\db\ModelBora.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */