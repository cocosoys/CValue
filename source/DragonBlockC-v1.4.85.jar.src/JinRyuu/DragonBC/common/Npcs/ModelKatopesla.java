/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelKatopesla
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR1;
/*     */   public ModelRenderer ArmL1;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer Head_1;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer Chest;
/*     */   public ModelRenderer BeltBuckle;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmR3;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer ArmL3;
/*     */   
/*     */   public ModelKatopesla() {
/*  29 */     this.field_78090_t = 128;
/*  30 */     this.field_78089_u = 64;
/*  31 */     this.EarR = new ModelRenderer(this, 33, 8);
/*  32 */     this.EarR.func_78793_a(-4.0F, -4.2F, 0.4F);
/*  33 */     this.EarR.func_78790_a(-1.0F, -1.5F, -1.6F, 1, 3, 3, 0.0F);
/*  34 */     this.ArmR3 = new ModelRenderer(this, 63, 28);
/*  35 */     this.ArmR3.func_78793_a(0.0F, 4.1F, -0.5F);
/*  36 */     this.ArmR3.func_78790_a(-2.5F, 0.0F, -1.9F, 5, 8, 5, 0.0F);
/*  37 */     this.ArmL1 = new ModelRenderer(this, 63, 5);
/*  38 */     this.ArmL1.field_78809_i = true;
/*  39 */     this.ArmL1.func_78793_a(6.4F, -4.7F, 0.0F);
/*  40 */     this.ArmL1.func_78790_a(0.0F, -3.0F, -3.0F, 5, 6, 6, 0.0F);
/*  41 */     this.Body3 = new ModelRenderer(this, 0, 48);
/*  42 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  43 */     this.Body3.func_78790_a(-5.5F, 12.0F, -3.0F, 11, 5, 6, 0.0F);
/*  44 */     this.Head_1 = new ModelRenderer(this, 42, 0);
/*  45 */     this.Head_1.func_78793_a(0.0F, -7.4F, -3.5F);
/*  46 */     this.Head_1.func_78790_a(-1.0F, -8.0F, -0.5F, 2, 8, 1, 0.0F);
/*  47 */     setRotateAngle(this.Head_1, -1.2747885F, 0.0F, 0.0F);
/*  48 */     this.LegR = new ModelRenderer(this, 41, 42);
/*  49 */     this.LegR.func_78793_a(-3.0F, 9.0F, 0.0F);
/*  50 */     this.LegR.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 15, 6, 0.0F);
/*  51 */     this.ArmL3 = new ModelRenderer(this, 84, 28);
/*  52 */     this.ArmL3.field_78809_i = true;
/*  53 */     this.ArmL3.func_78793_a(0.0F, 4.1F, -0.5F);
/*  54 */     this.ArmL3.func_78790_a(-2.5F, 0.0F, -1.8F, 5, 8, 5, 0.0F);
/*  55 */     this.Head = new ModelRenderer(this, 0, 0);
/*  56 */     this.Head.func_78793_a(0.0F, -8.0F, -0.5F);
/*  57 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  58 */     this.Body1 = new ModelRenderer(this, 0, 17);
/*  59 */     this.Body1.func_78793_a(0.0F, -8.0F, 0.0F);
/*  60 */     this.Body1.func_78790_a(-6.5F, 0.0F, -3.3F, 13, 8, 7, 0.0F);
/*  61 */     this.ArmL2 = new ModelRenderer(this, 64, 18);
/*  62 */     this.ArmL2.field_78809_i = true;
/*  63 */     this.ArmL2.func_78793_a(2.5F, 2.0F, 0.0F);
/*  64 */     this.ArmL2.func_78790_a(-2.3F, 0.4F, -2.5F, 5, 4, 5, 0.0F);
/*  65 */     this.Body2 = new ModelRenderer(this, 0, 34);
/*  66 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  67 */     this.Body2.func_78790_a(-5.0F, 6.0F, -3.1F, 10, 6, 6, 0.0F);
/*  68 */     this.ArmR1 = new ModelRenderer(this, 63, 5);
/*  69 */     this.ArmR1.func_78793_a(-6.4F, -4.7F, 0.0F);
/*  70 */     this.ArmR1.func_78790_a(-5.0F, -3.0F, -3.0F, 5, 6, 6, 0.0F);
/*  71 */     this.BeltBuckle = new ModelRenderer(this, 2, 60);
/*  72 */     this.BeltBuckle.func_78793_a(0.0F, 0.0F, 0.0F);
/*  73 */     this.BeltBuckle.func_78790_a(-2.5F, 10.8F, -3.3F, 5, 4, 0, 0.0F);
/*  74 */     this.LegL = new ModelRenderer(this, 41, 42);
/*  75 */     this.LegL.field_78809_i = true;
/*  76 */     this.LegL.func_78793_a(3.0F, 9.0F, 0.0F);
/*  77 */     this.LegL.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 15, 6, 0.0F);
/*  78 */     this.EarL = new ModelRenderer(this, 33, 8);
/*  79 */     this.EarL.field_78809_i = true;
/*  80 */     this.EarL.func_78793_a(4.0F, -4.2F, 0.4F);
/*  81 */     this.EarL.func_78790_a(0.0F, -1.5F, -1.6F, 1, 3, 3, 0.0F);
/*  82 */     this.ArmR2 = new ModelRenderer(this, 64, 18);
/*  83 */     this.ArmR2.func_78793_a(-2.5F, 2.0F, 0.0F);
/*  84 */     this.ArmR2.func_78790_a(-2.7F, 0.4F, -2.5F, 5, 4, 5, 0.0F);
/*  85 */     this.Chest = new ModelRenderer(this, 35, 33);
/*  86 */     this.Chest.func_78793_a(0.0F, 0.0F, 0.0F);
/*  87 */     this.Chest.func_78790_a(-6.0F, 1.4F, -4.1F, 12, 5, 1, 0.0F);
/*  88 */     this.Head.func_78792_a(this.EarR);
/*  89 */     this.ArmR2.func_78792_a(this.ArmR3);
/*  90 */     this.Body2.func_78792_a(this.Body3);
/*  91 */     this.Head.func_78792_a(this.Head_1);
/*  92 */     this.ArmL2.func_78792_a(this.ArmL3);
/*  93 */     this.ArmL1.func_78792_a(this.ArmL2);
/*  94 */     this.Body1.func_78792_a(this.Body2);
/*  95 */     this.Body3.func_78792_a(this.BeltBuckle);
/*  96 */     this.Head.func_78792_a(this.EarL);
/*  97 */     this.ArmR1.func_78792_a(this.ArmR2);
/*  98 */     this.Body2.func_78792_a(this.Chest);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 103 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 106 */     this.ArmL1.func_78785_a(f5);
/* 107 */     this.LegR.func_78785_a(f5);
/* 108 */     this.Head.func_78785_a(f5);
/* 109 */     this.Body1.func_78785_a(f5);
/* 110 */     this.ArmR1.func_78785_a(f5);
/* 111 */     this.LegL.func_78785_a(f5);
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
/* 183 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 184 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 185 */     this.ArmR1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 186 */     this.ArmL1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 188 */     this.LegR.field_78796_g = 0.0F;
/* 189 */     this.LegL.field_78796_g = 0.0F;
/* 190 */     this.ArmR1.field_78796_g = 0.0F;
/* 191 */     this.ArmL1.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 198 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelKatopesla.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */