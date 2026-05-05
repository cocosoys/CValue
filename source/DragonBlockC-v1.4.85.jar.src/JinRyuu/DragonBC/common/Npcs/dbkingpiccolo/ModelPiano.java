/*     */ package JinRyuu.DragonBC.common.Npcs.dbkingpiccolo;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelPiano
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer Head2;
/*     */   public ModelRenderer Beak;
/*     */   public ModelRenderer Head3;
/*     */   public ModelRenderer Beak2;
/*     */   public ModelRenderer Cloth;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer FeetR;
/*     */   public ModelRenderer FeetL;
/*     */   
/*     */   public ModelPiano() {
/*  27 */     this.field_78090_t = 64;
/*  28 */     this.field_78089_u = 64;
/*  29 */     this.ArmR = new ModelRenderer(this, 27, 24);
/*  30 */     this.ArmR.func_78793_a(-4.6F, 10.4F, 0.1F);
/*  31 */     this.ArmR.func_78790_a(-3.0F, -1.7F, -2.0F, 4, 7, 4, -0.3F);
/*  32 */     this.LegR = new ModelRenderer(this, 0, 40);
/*  33 */     this.LegR.func_78793_a(-1.9F, 17.0F, 0.0F);
/*  34 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 5, 4, 0.0F);
/*  35 */     this.Body = new ModelRenderer(this, 0, 23);
/*  36 */     this.Body.func_78793_a(0.0F, 9.0F, 0.1F);
/*  37 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.5F, 8, 8, 5, 0.0F);
/*  38 */     this.ArmL2 = new ModelRenderer(this, 27, 38);
/*  39 */     this.ArmL2.field_78809_i = true;
/*  40 */     this.ArmL2.func_78793_a(1.1F, 4.4F, 0.1F);
/*  41 */     this.ArmL2.func_78790_a(-1.6F, 0.0F, -1.5F, 3, 2, 3, 0.0F);
/*  42 */     this.Head = new ModelRenderer(this, 0, 0);
/*  43 */     this.Head.func_78793_a(0.0F, 9.4F, 0.0F);
/*  44 */     this.Head.func_78790_a(-4.0F, -6.9F, -4.0F, 8, 8, 8, -1.0F);
/*  45 */     this.ArmL = new ModelRenderer(this, 27, 24);
/*  46 */     this.ArmL.field_78809_i = true;
/*  47 */     this.ArmL.func_78793_a(4.6F, 10.4F, 0.1F);
/*  48 */     this.ArmL.func_78790_a(-1.0F, -1.7F, -2.0F, 4, 7, 4, -0.3F);
/*  49 */     this.Head2 = new ModelRenderer(this, 51, 2);
/*  50 */     this.Head2.func_78793_a(0.0F, -3.6F, 0.8F);
/*  51 */     this.Head2.func_78790_a(-0.5F, -3.6F, -2.3F, 1, 3, 5, 0.0F);
/*  52 */     setRotateAngle(this.Head2, 0.4553564F, 0.0F, 0.0F);
/*  53 */     this.FeetL = new ModelRenderer(this, 1, 54);
/*  54 */     this.FeetL.field_78809_i = true;
/*  55 */     this.FeetL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  56 */     this.FeetL.func_78790_a(-1.5F, 5.0F, -2.5F, 3, 2, 4, 0.0F);
/*  57 */     this.Beak = new ModelRenderer(this, 34, 5);
/*  58 */     this.Beak.func_78793_a(0.0F, -1.7F, -2.3F);
/*  59 */     this.Beak.func_78790_a(-2.5F, -1.5F, -2.6F, 5, 3, 3, 0.0F);
/*  60 */     setRotateAngle(this.Beak, 0.13962634F, 0.0F, 0.0F);
/*  61 */     this.Head3 = new ModelRenderer(this, 51, 11);
/*  62 */     this.Head3.func_78793_a(0.0F, -1.6F, 2.7F);
/*  63 */     this.Head3.func_78790_a(-0.5F, -2.0F, 0.0F, 1, 2, 4, 0.0F);
/*  64 */     this.FeetR = new ModelRenderer(this, 1, 54);
/*  65 */     this.FeetR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  66 */     this.FeetR.func_78790_a(-1.5F, 5.0F, -2.5F, 3, 2, 4, 0.0F);
/*  67 */     this.Beak2 = new ModelRenderer(this, 34, 12);
/*  68 */     this.Beak2.func_78793_a(0.0F, 0.5F, -2.9F);
/*  69 */     this.Beak2.func_78790_a(-2.0F, -1.0F, -2.7F, 4, 2, 3, 0.0F);
/*  70 */     this.Cloth = new ModelRenderer(this, 45, 23);
/*  71 */     this.Cloth.func_78793_a(0.0F, 0.0F, -2.7F);
/*  72 */     this.Cloth.func_78790_a(-3.5F, 0.0F, 0.0F, 7, 5, 0, 0.0F);
/*  73 */     setRotateAngle(this.Cloth, -0.05235988F, 0.0F, 0.0F);
/*  74 */     this.ArmR2 = new ModelRenderer(this, 27, 38);
/*  75 */     this.ArmR2.func_78793_a(-1.0F, 4.5F, 0.1F);
/*  76 */     this.ArmR2.func_78790_a(-1.6F, 0.0F, -1.5F, 3, 2, 3, 0.0F);
/*  77 */     this.LegL = new ModelRenderer(this, 0, 40);
/*  78 */     this.LegL.field_78809_i = true;
/*  79 */     this.LegL.func_78793_a(1.9F, 17.0F, 0.0F);
/*  80 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 5, 4, 0.0F);
/*  81 */     this.ArmL.func_78792_a(this.ArmL2);
/*  82 */     this.Head.func_78792_a(this.Head2);
/*  83 */     this.LegL.func_78792_a(this.FeetL);
/*  84 */     this.Head.func_78792_a(this.Beak);
/*  85 */     this.Head2.func_78792_a(this.Head3);
/*  86 */     this.LegR.func_78792_a(this.FeetR);
/*  87 */     this.Beak.func_78792_a(this.Beak2);
/*  88 */     this.Body.func_78792_a(this.Cloth);
/*  89 */     this.ArmR.func_78792_a(this.ArmR2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  94 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  96 */     this.Head.func_78785_a(f5);
/*     */     
/*  98 */     this.Body.func_78785_a(f5);
/*  99 */     this.ArmR.func_78785_a(f5);
/* 100 */     this.ArmL.func_78785_a(f5);
/* 101 */     this.LegL.func_78785_a(f5);
/* 102 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 112 */     modelRenderer.field_78795_f = x;
/* 113 */     modelRenderer.field_78796_g = y;
/* 114 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 118 */     int calc = par7Entity.field_70173_aa;
/* 119 */     if (calc > 100) calc -= 100; 
/* 120 */     float r = 360.0F;
/* 121 */     float r2 = 180.0F;
/* 122 */     float n4 = par4;
/* 123 */     float n5 = par5;
/*     */     
/* 125 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 126 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 127 */     float ex = par7Entity.field_70173_aa;
/* 128 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 129 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 131 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 132 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 181 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 182 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 183 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 184 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 186 */     this.LegR.field_78796_g = 0.0F;
/* 187 */     this.LegL.field_78796_g = 0.0F;
/* 188 */     this.ArmR.field_78796_g = 0.0F;
/* 189 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 197 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbkingpiccolo\ModelPiano.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */