/*     */ package JinRyuu.DragonBC.common.Npcs.dbbaba;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelDevil
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer tail1;
/*     */   public ModelRenderer HornL;
/*     */   public ModelRenderer HornR;
/*     */   public ModelRenderer HornL2;
/*     */   public ModelRenderer HornL3;
/*     */   public ModelRenderer HornR2;
/*     */   public ModelRenderer HornR3;
/*     */   public ModelRenderer WingR;
/*     */   public ModelRenderer WingL;
/*     */   public ModelRenderer tail2;
/*     */   public ModelRenderer tail3;
/*     */   public ModelRenderer tail4;
/*     */   public ModelRenderer tail5;
/*     */   
/*     */   public ModelDevil() {
/*  32 */     this.field_78090_t = 64;
/*  33 */     this.field_78089_u = 64;
/*  34 */     this.WingL = new ModelRenderer(this, 0, 34);
/*  35 */     this.WingL.field_78809_i = true;
/*  36 */     this.WingL.func_78793_a(2.9F, 2.0F, 2.0F);
/*  37 */     this.WingL.func_78790_a(0.0F, -9.0F, 0.0F, 19, 19, 0, 0.0F);
/*  38 */     setRotateAngle(this.WingL, 0.0F, -0.17453292F, 0.0F);
/*  39 */     this.Head = new ModelRenderer(this, 0, 0);
/*  40 */     this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
/*  41 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  42 */     this.HornL2 = new ModelRenderer(this, 42, 8);
/*  43 */     this.HornL2.field_78809_i = true;
/*  44 */     this.HornL2.func_78793_a(0.0F, -3.0F, 0.0F);
/*  45 */     this.HornL2.func_78790_a(-1.0F, -2.8F, -1.0F, 2, 3, 2, 0.0F);
/*  46 */     setRotateAngle(this.HornL2, -0.12217305F, 0.0F, 0.12217305F);
/*  47 */     this.tail2 = new ModelRenderer(this, 32, 0);
/*  48 */     this.tail2.func_78793_a(0.0F, 0.0F, 4.0F);
/*  49 */     this.tail2.func_78790_a(-0.5F, -0.0F, 0.0F, 1, 0, 4, 0.0F);
/*  50 */     this.LegR = new ModelRenderer(this, 0, 16);
/*  51 */     this.LegR.func_78793_a(-2.0F, 12.0F, 0.0F);
/*  52 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  53 */     this.tail5 = new ModelRenderer(this, 32, 5);
/*  54 */     this.tail5.func_78793_a(0.0F, 0.0F, 4.0F);
/*  55 */     this.tail5.func_78790_a(-1.5F, 0.0F, 0.0F, 3, 0, 3, 0.0F);
/*  56 */     this.HornR3 = new ModelRenderer(this, 51, 9);
/*  57 */     this.HornR3.func_78793_a(0.0F, -3.2F, 0.0F);
/*  58 */     this.HornR3.func_78790_a(-0.6F, -2.6F, -0.5F, 1, 3, 1, 0.0F);
/*  59 */     setRotateAngle(this.HornR3, -0.08726646F, 0.0F, -0.08726646F);
/*  60 */     this.HornR = new ModelRenderer(this, 42, 1);
/*  61 */     this.HornR.func_78793_a(-2.1F, -7.3F, -1.3F);
/*  62 */     this.HornR.func_78790_a(-1.5F, -3.0F, -1.5F, 3, 3, 3, 0.0F);
/*  63 */     setRotateAngle(this.HornR, -0.43633232F, 0.0F, -0.04363323F);
/*  64 */     this.ArmL = new ModelRenderer(this, 40, 16);
/*  65 */     this.ArmL.field_78809_i = true;
/*  66 */     this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
/*  67 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  68 */     this.tail3 = new ModelRenderer(this, 32, 0);
/*  69 */     this.tail3.func_78793_a(0.0F, 0.0F, 4.0F);
/*  70 */     this.tail3.func_78790_a(-0.5F, 0.0F, 0.0F, 1, 0, 4, 0.0F);
/*  71 */     this.Body = new ModelRenderer(this, 16, 16);
/*  72 */     this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
/*  73 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
/*  74 */     this.tail1 = new ModelRenderer(this, 32, 0);
/*  75 */     this.tail1.func_78793_a(0.0F, 10.4F, 1.9F);
/*  76 */     this.tail1.func_78790_a(-0.5F, 0.0F, 0.0F, 1, 0, 4, 0.0F);
/*  77 */     this.ArmR = new ModelRenderer(this, 40, 16);
/*  78 */     this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  79 */     this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  80 */     this.tail4 = new ModelRenderer(this, 32, 0);
/*  81 */     this.tail4.func_78793_a(0.0F, 0.0F, 4.0F);
/*  82 */     this.tail4.func_78790_a(-0.5F, 0.0F, 0.0F, 1, 0, 4, 0.0F);
/*  83 */     this.LegL = new ModelRenderer(this, 0, 16);
/*  84 */     this.LegL.field_78809_i = true;
/*  85 */     this.LegL.func_78793_a(2.0F, 12.0F, 0.0F);
/*  86 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  87 */     this.HornR2 = new ModelRenderer(this, 42, 8);
/*  88 */     this.HornR2.func_78793_a(0.0F, -3.0F, 0.0F);
/*  89 */     this.HornR2.func_78790_a(-1.0F, -2.8F, -1.0F, 2, 3, 2, 0.0F);
/*  90 */     setRotateAngle(this.HornR2, -0.12217305F, 0.0F, -0.13665928F);
/*  91 */     this.HornL = new ModelRenderer(this, 42, 1);
/*  92 */     this.HornL.field_78809_i = true;
/*  93 */     this.HornL.func_78793_a(2.1F, -7.3F, -1.3F);
/*  94 */     this.HornL.func_78790_a(-1.5F, -3.0F, -1.5F, 3, 3, 3, 0.0F);
/*  95 */     setRotateAngle(this.HornL, -0.43633232F, 0.0F, 0.08726646F);
/*  96 */     this.WingR = new ModelRenderer(this, 0, 34);
/*  97 */     this.WingR.func_78793_a(-2.9F, 2.0F, 2.0F);
/*  98 */     this.WingR.func_78790_a(-19.0F, -9.0F, 0.0F, 19, 19, 0, 0.0F);
/*  99 */     setRotateAngle(this.WingR, 0.0F, 0.17453292F, 0.0F);
/* 100 */     this.HornL3 = new ModelRenderer(this, 51, 9);
/* 101 */     this.HornL3.field_78809_i = true;
/* 102 */     this.HornL3.func_78793_a(0.0F, -3.2F, 0.0F);
/* 103 */     this.HornL3.func_78790_a(-0.6F, -2.6F, -0.5F, 1, 3, 1, 0.0F);
/* 104 */     setRotateAngle(this.HornL3, -0.08726646F, 0.0F, 0.08726646F);
/* 105 */     this.Body.func_78792_a(this.WingL);
/* 106 */     this.HornL.func_78792_a(this.HornL2);
/* 107 */     this.tail1.func_78792_a(this.tail2);
/* 108 */     this.tail4.func_78792_a(this.tail5);
/* 109 */     this.HornR2.func_78792_a(this.HornR3);
/* 110 */     this.Head.func_78792_a(this.HornR);
/* 111 */     this.tail2.func_78792_a(this.tail3);
/* 112 */     this.tail3.func_78792_a(this.tail4);
/* 113 */     this.HornR.func_78792_a(this.HornR2);
/* 114 */     this.Head.func_78792_a(this.HornL);
/* 115 */     this.Body.func_78792_a(this.WingR);
/* 116 */     this.HornL2.func_78792_a(this.HornL3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 121 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 123 */     this.Head.func_78785_a(f5);
/*     */     
/* 125 */     this.Body.func_78785_a(f5);
/* 126 */     this.ArmR.func_78785_a(f5);
/* 127 */     this.ArmL.func_78785_a(f5);
/* 128 */     this.LegL.func_78785_a(f5);
/* 129 */     this.LegR.func_78785_a(f5);
/* 130 */     this.tail1.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 139 */     modelRenderer.field_78795_f = x;
/* 140 */     modelRenderer.field_78796_g = y;
/* 141 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 145 */     int calc = par7Entity.field_70173_aa;
/* 146 */     if (calc > 100) calc -= 100; 
/* 147 */     float r = 360.0F;
/* 148 */     float r2 = 180.0F;
/* 149 */     float n4 = par4;
/* 150 */     float n5 = par5;
/*     */     
/* 152 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 153 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 154 */     float ex = par7Entity.field_70173_aa;
/* 155 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 156 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 158 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 159 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */     
/* 161 */     this.tail1.field_78795_f = 0.2F;
/* 162 */     this.tail1.field_78795_f += r4 / 2.0F;
/*     */     
/* 164 */     this.tail2.field_78795_f = 0.2F;
/* 165 */     this.tail2.field_78795_f += r4 / 2.0F;
/*     */     
/* 167 */     this.tail3.field_78795_f = 0.2F;
/* 168 */     this.tail3.field_78795_f += r4 / 2.0F;
/*     */     
/* 170 */     this.tail4.field_78795_f = 0.2F;
/* 171 */     this.tail4.field_78795_f += r4 / 2.0F;
/*     */     
/* 173 */     this.tail5.field_78796_g = 0.2F;
/* 174 */     this.tail5.field_78796_g += r4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 208 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 209 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 210 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 211 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 213 */     this.LegR.field_78796_g = 0.0F;
/* 214 */     this.LegL.field_78796_g = 0.0F;
/* 215 */     this.ArmR.field_78796_g = 0.0F;
/* 216 */     this.ArmL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbbaba\ModelDevil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */