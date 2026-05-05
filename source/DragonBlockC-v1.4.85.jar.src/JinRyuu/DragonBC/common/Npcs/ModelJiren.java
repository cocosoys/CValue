/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelJiren
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR1;
/*     */   public ModelRenderer ArmL1;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer Chest;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmR3;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer ArmL3;
/*     */   
/*     */   public ModelJiren() {
/*  27 */     this.field_78090_t = 128;
/*  28 */     this.field_78089_u = 64;
/*  29 */     this.EarR = new ModelRenderer(this, 33, 8);
/*  30 */     this.EarR.func_78793_a(-4.0F, -4.2F, 0.4F);
/*  31 */     this.EarR.func_78790_a(-1.0F, -1.5F, -1.6F, 1, 3, 3, 0.0F);
/*  32 */     this.LegL = new ModelRenderer(this, 41, 42);
/*  33 */     this.LegL.field_78809_i = true;
/*  34 */     this.LegL.func_78793_a(3.0F, 9.0F, 0.0F);
/*  35 */     this.LegL.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 15, 6, 0.0F);
/*  36 */     this.Chest = new ModelRenderer(this, 35, 33);
/*  37 */     this.Chest.func_78793_a(0.0F, 0.0F, 0.0F);
/*  38 */     this.Chest.func_78790_a(-6.0F, 1.8F, -4.1F, 12, 5, 1, 0.0F);
/*  39 */     this.EarL = new ModelRenderer(this, 33, 8);
/*  40 */     this.EarL.field_78809_i = true;
/*  41 */     this.EarL.func_78793_a(4.0F, -4.2F, 0.4F);
/*  42 */     this.EarL.func_78790_a(0.0F, -1.5F, -1.6F, 1, 3, 3, 0.0F);
/*  43 */     this.Head = new ModelRenderer(this, 0, 0);
/*  44 */     this.Head.func_78793_a(0.0F, -8.0F, -0.5F);
/*  45 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  46 */     this.Body3 = new ModelRenderer(this, 0, 48);
/*  47 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  48 */     this.Body3.func_78790_a(-6.0F, 12.0F, -3.0F, 12, 5, 6, 0.0F);
/*  49 */     this.ArmL3 = new ModelRenderer(this, 63, 28);
/*  50 */     this.ArmL3.field_78809_i = true;
/*  51 */     this.ArmL3.func_78793_a(0.0F, 4.1F, -0.5F);
/*  52 */     this.ArmL3.func_78790_a(-2.7F, 0.0F, -1.8F, 5, 9, 5, 0.0F);
/*  53 */     this.ArmR2 = new ModelRenderer(this, 64, 18);
/*  54 */     this.ArmR2.func_78793_a(-2.0F, 2.0F, 0.0F);
/*  55 */     this.ArmR2.func_78790_a(-2.7F, 0.4F, -2.5F, 5, 4, 5, 0.0F);
/*  56 */     this.ArmL2 = new ModelRenderer(this, 64, 18);
/*  57 */     this.ArmL2.field_78809_i = true;
/*  58 */     this.ArmL2.func_78793_a(2.0F, 2.0F, 0.0F);
/*  59 */     this.ArmL2.func_78790_a(-2.3F, 0.4F, -2.5F, 5, 4, 5, 0.0F);
/*  60 */     this.Body1 = new ModelRenderer(this, 0, 17);
/*  61 */     this.Body1.func_78793_a(0.0F, -8.0F, 0.0F);
/*  62 */     this.Body1.func_78790_a(-7.0F, 0.0F, -3.3F, 14, 8, 7, 0.0F);
/*  63 */     this.ArmR1 = new ModelRenderer(this, 63, 5);
/*  64 */     this.ArmR1.func_78793_a(-7.5F, -4.7F, 0.0F);
/*  65 */     this.ArmR1.func_78790_a(-5.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
/*  66 */     this.Body2 = new ModelRenderer(this, 0, 34);
/*  67 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  68 */     this.Body2.func_78790_a(-5.5F, 6.2F, -3.5F, 11, 6, 6, 0.0F);
/*  69 */     this.ArmL1 = new ModelRenderer(this, 63, 5);
/*  70 */     this.ArmL1.field_78809_i = true;
/*  71 */     this.ArmL1.func_78793_a(7.5F, -4.7F, 0.0F);
/*  72 */     this.ArmL1.func_78790_a(-1.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
/*  73 */     this.LegR = new ModelRenderer(this, 41, 42);
/*  74 */     this.LegR.func_78793_a(-3.0F, 9.0F, 0.0F);
/*  75 */     this.LegR.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 15, 6, 0.0F);
/*  76 */     this.ArmR3 = new ModelRenderer(this, 63, 28);
/*  77 */     this.ArmR3.func_78793_a(0.0F, 4.1F, -0.5F);
/*  78 */     this.ArmR3.func_78790_a(-2.3F, 0.0F, -1.9F, 5, 9, 5, 0.0F);
/*  79 */     this.Head.func_78792_a(this.EarR);
/*  80 */     this.Body2.func_78792_a(this.Chest);
/*  81 */     this.Head.func_78792_a(this.EarL);
/*  82 */     this.Body2.func_78792_a(this.Body3);
/*  83 */     this.ArmL2.func_78792_a(this.ArmL3);
/*  84 */     this.ArmR1.func_78792_a(this.ArmR2);
/*  85 */     this.ArmL1.func_78792_a(this.ArmL2);
/*  86 */     this.Body1.func_78792_a(this.Body2);
/*  87 */     this.ArmR2.func_78792_a(this.ArmR3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  92 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  98 */     this.LegL.func_78785_a(f5);
/*  99 */     this.Head.func_78785_a(f5);
/* 100 */     this.ArmL1.func_78785_a(f5);
/* 101 */     this.ArmR1.func_78785_a(f5);
/* 102 */     this.Body1.func_78785_a(f5);
/* 103 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 110 */     modelRenderer.field_78795_f = x;
/* 111 */     modelRenderer.field_78796_g = y;
/* 112 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 116 */     int calc = par7Entity.field_70173_aa;
/* 117 */     if (calc > 100) calc -= 100; 
/* 118 */     float r = 360.0F;
/* 119 */     float r2 = 180.0F;
/* 120 */     float n4 = par4;
/* 121 */     float n5 = par5;
/*     */     
/* 123 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 124 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 125 */     float ex = par7Entity.field_70173_aa;
/* 126 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 127 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 129 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 130 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 176 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 177 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 178 */     this.ArmR1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 179 */     this.ArmL1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 181 */     this.LegR.field_78796_g = 0.0F;
/* 182 */     this.LegL.field_78796_g = 0.0F;
/* 183 */     this.ArmR1.field_78796_g = 0.0F;
/* 184 */     this.ArmL1.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 191 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelJiren.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */