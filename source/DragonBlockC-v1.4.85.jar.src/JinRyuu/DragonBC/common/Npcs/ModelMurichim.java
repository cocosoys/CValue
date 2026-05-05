/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelMurichim
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR1;
/*     */   public ModelRenderer ArmL1;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer Head2;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Head2_1;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer Chest;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmR3;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer ArmL3;
/*     */   
/*     */   public ModelMurichim() {
/*  29 */     this.field_78090_t = 128;
/*  30 */     this.field_78089_u = 64;
/*  31 */     this.Head = new ModelRenderer(this, 0, 0);
/*  32 */     this.Head.func_78793_a(0.0F, -8.0F, -0.5F);
/*  33 */     this.Head.func_78790_a(-4.0F, -4.0F, -4.0F, 8, 4, 8, 0.0F);
/*  34 */     this.LegR = new ModelRenderer(this, 41, 42);
/*  35 */     this.LegR.func_78793_a(-3.0F, 9.0F, 0.0F);
/*  36 */     this.LegR.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 15, 6, 0.0F);
/*  37 */     this.Head2 = new ModelRenderer(this, 33, 0);
/*  38 */     this.Head2.func_78793_a(0.0F, 0.0F, -0.5F);
/*  39 */     this.Head2.func_78790_a(-3.5F, -8.0F, -3.5F, 7, 4, 8, 0.0F);
/*  40 */     this.ArmR2 = new ModelRenderer(this, 64, 18);
/*  41 */     this.ArmR2.func_78793_a(-2.0F, 2.0F, 0.0F);
/*  42 */     this.ArmR2.func_78790_a(-2.7F, 0.4F, -2.5F, 5, 4, 5, 0.0F);
/*  43 */     this.Head2_1 = new ModelRenderer(this, 89, 3);
/*  44 */     this.Head2_1.func_78793_a(0.0F, 0.0F, -0.5F);
/*  45 */     this.Head2_1.func_78790_a(-6.0F, -1.0F, -3.1F, 12, 2, 7, 0.0F);
/*  46 */     this.Body1 = new ModelRenderer(this, 0, 17);
/*  47 */     this.Body1.func_78793_a(0.0F, -8.0F, 0.0F);
/*  48 */     this.Body1.func_78790_a(-7.0F, 0.0F, -3.3F, 14, 8, 7, 0.0F);
/*  49 */     this.LegL = new ModelRenderer(this, 41, 42);
/*  50 */     this.LegL.field_78809_i = true;
/*  51 */     this.LegL.func_78793_a(3.0F, 9.0F, 0.0F);
/*  52 */     this.LegL.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 15, 6, 0.0F);
/*  53 */     this.EarR = new ModelRenderer(this, 33, 3);
/*  54 */     this.EarR.func_78793_a(-3.1F, -3.2F, -0.8F);
/*  55 */     this.EarR.func_78790_a(-2.0F, -2.8F, 0.0F, 2, 3, 0, 0.0F);
/*  56 */     setRotateAngle(this.EarR, -0.17453292F, 0.4886922F, -0.2617994F);
/*  57 */     this.ArmL2 = new ModelRenderer(this, 64, 18);
/*  58 */     this.ArmL2.field_78809_i = true;
/*  59 */     this.ArmL2.func_78793_a(2.0F, 2.0F, 0.0F);
/*  60 */     this.ArmL2.func_78790_a(-2.3F, 0.4F, -2.5F, 5, 4, 5, 0.0F);
/*  61 */     this.ArmL1 = new ModelRenderer(this, 63, 5);
/*  62 */     this.ArmL1.field_78809_i = true;
/*  63 */     this.ArmL1.func_78793_a(7.5F, -4.7F, 0.0F);
/*  64 */     this.ArmL1.func_78790_a(-1.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
/*  65 */     this.Body2 = new ModelRenderer(this, 0, 34);
/*  66 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  67 */     this.Body2.func_78790_a(-5.5F, 6.2F, -3.5F, 11, 6, 6, 0.0F);
/*  68 */     this.EarL = new ModelRenderer(this, 33, 3);
/*  69 */     this.EarL.field_78809_i = true;
/*  70 */     this.EarL.func_78793_a(3.1F, -3.2F, -0.8F);
/*  71 */     this.EarL.func_78790_a(0.0F, -2.8F, 0.0F, 2, 3, 0, 0.0F);
/*  72 */     setRotateAngle(this.EarL, -0.17453292F, -0.4886922F, 0.2617994F);
/*  73 */     this.Body3 = new ModelRenderer(this, 0, 48);
/*  74 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  75 */     this.Body3.func_78790_a(-6.0F, 12.0F, -3.0F, 12, 5, 6, 0.0F);
/*  76 */     this.ArmR3 = new ModelRenderer(this, 63, 28);
/*  77 */     this.ArmR3.func_78793_a(0.0F, 4.1F, -0.5F);
/*  78 */     this.ArmR3.func_78790_a(-2.3F, 0.0F, -1.9F, 5, 9, 5, 0.0F);
/*  79 */     this.Chest = new ModelRenderer(this, 35, 33);
/*  80 */     this.Chest.func_78793_a(0.0F, 0.0F, 0.0F);
/*  81 */     this.Chest.func_78790_a(-6.0F, 1.8F, -4.1F, 12, 5, 1, 0.0F);
/*  82 */     this.ArmL3 = new ModelRenderer(this, 63, 28);
/*  83 */     this.ArmL3.field_78809_i = true;
/*  84 */     this.ArmL3.func_78793_a(0.0F, 4.1F, -0.5F);
/*  85 */     this.ArmL3.func_78790_a(-2.7F, 0.0F, -1.8F, 5, 9, 5, 0.0F);
/*  86 */     this.ArmR1 = new ModelRenderer(this, 63, 5);
/*  87 */     this.ArmR1.func_78793_a(-7.5F, -4.7F, 0.0F);
/*  88 */     this.ArmR1.func_78790_a(-5.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
/*  89 */     this.Head.func_78792_a(this.Head2);
/*  90 */     this.ArmR1.func_78792_a(this.ArmR2);
/*  91 */     this.Body1.func_78792_a(this.Head2_1);
/*  92 */     this.Head.func_78792_a(this.EarR);
/*  93 */     this.ArmL1.func_78792_a(this.ArmL2);
/*  94 */     this.Body1.func_78792_a(this.Body2);
/*  95 */     this.Head.func_78792_a(this.EarL);
/*  96 */     this.Body2.func_78792_a(this.Body3);
/*  97 */     this.ArmR2.func_78792_a(this.ArmR3);
/*  98 */     this.Body2.func_78792_a(this.Chest);
/*  99 */     this.ArmL2.func_78792_a(this.ArmL3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 104 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 106 */     this.Head.func_78785_a(f5);
/* 107 */     this.LegR.func_78785_a(f5);
/* 108 */     this.Body1.func_78785_a(f5);
/* 109 */     this.LegL.func_78785_a(f5);
/* 110 */     this.ArmL1.func_78785_a(f5);
/* 111 */     this.ArmR1.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 117 */     modelRenderer.field_78795_f = x;
/* 118 */     modelRenderer.field_78796_g = y;
/* 119 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 123 */     int calc = par7Entity.field_70173_aa;
/* 124 */     if (calc > 100) calc -= 100; 
/* 125 */     float r = 360.0F;
/* 126 */     float r2 = 180.0F;
/* 127 */     float n4 = par4;
/* 128 */     float n5 = par5;
/*     */ 
/*     */ 
/*     */     
/* 132 */     float ex = par7Entity.field_70173_aa;
/* 133 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 134 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 136 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 137 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 186 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 187 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 188 */     this.ArmR1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 189 */     this.ArmL1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 191 */     this.LegR.field_78796_g = 0.0F;
/* 192 */     this.LegL.field_78796_g = 0.0F;
/* 193 */     this.ArmR1.field_78796_g = 0.0F;
/* 194 */     this.ArmL1.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 201 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelMurichim.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */