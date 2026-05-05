/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelBasil
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer Tail1;
/*     */   public ModelRenderer Snout;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer EarR2;
/*     */   public ModelRenderer EarL2;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Chest;
/*     */   public ModelRenderer Scarf;
/*     */   public ModelRenderer Fur;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer Back;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer LegL2;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer Tail2;
/*     */   public ModelRenderer Tail3;
/*     */   public ModelRenderer Tail4;
/*     */   public ModelRenderer Tail5;
/*     */   
/*     */   public ModelBasil() {
/*  38 */     this.field_78090_t = 64;
/*  39 */     this.field_78089_u = 64;
/*  40 */     this.Back = new ModelRenderer(this, 44, 48);
/*  41 */     this.Back.func_78793_a(0.0F, 1.6F, 3.0F);
/*  42 */     this.Back.func_78790_a(-5.0F, 0.4F, 0.0F, 10, 12, 0, 0.0F);
/*  43 */     setRotateAngle(this.Back, -0.091106184F, 0.0F, 0.0F);
/*  44 */     this.LegR2 = new ModelRenderer(this, 0, 53);
/*  45 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  46 */     this.LegR2.func_78790_a(-2.0F, 6.0F, -0.6F, 4, 7, 4, 0.0F);
/*  47 */     this.Tail5 = new ModelRenderer(this, 54, 38);
/*  48 */     this.Tail5.func_78793_a(0.0F, 0.0F, 2.9F);
/*  49 */     this.Tail5.func_78790_a(-1.0F, -1.0F, 0.0F, 2, 2, 3, 0.0F);
/*  50 */     setRotateAngle(this.Tail5, 0.13665928F, 0.0F, 0.0F);
/*  51 */     this.Tail1 = new ModelRenderer(this, 54, 9);
/*  52 */     this.Tail1.func_78793_a(0.0F, 8.2F, 1.8F);
/*  53 */     this.Tail1.func_78790_a(-1.0F, -1.0F, 0.0F, 2, 2, 3, 0.0F);
/*  54 */     setRotateAngle(this.Tail1, -0.4098033F, 0.0F, 0.0F);
/*  55 */     this.EarL = new ModelRenderer(this, 27, 2);
/*  56 */     this.EarL.field_78809_i = true;
/*  57 */     this.EarL.func_78793_a(3.1F, -6.1F, 0.0F);
/*  58 */     this.EarL.func_78790_a(-2.0F, -4.0F, 0.0F, 4, 6, 0, 0.0F);
/*  59 */     setRotateAngle(this.EarL, 0.0F, -0.27925268F, 0.6981317F);
/*  60 */     this.Body3 = new ModelRenderer(this, 19, 40);
/*  61 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  62 */     this.Body3.func_78790_a(-4.0F, 10.7F, -2.0F, 8, 3, 4, 0.0F);
/*  63 */     this.ArmR = new ModelRenderer(this, 0, 18);
/*  64 */     this.ArmR.func_78793_a(-5.0F, -1.0F, 0.5F);
/*  65 */     this.ArmR.func_78790_a(-3.0F, -2.0F, -2.6F, 4, 5, 5, 0.0F);
/*  66 */     this.Chest = new ModelRenderer(this, 33, 9);
/*  67 */     this.Chest.func_78793_a(0.0F, 0.0F, 0.0F);
/*  68 */     this.Chest.func_78790_a(-4.0F, 1.0F, -2.5F, 8, 4, 1, 0.0F);
/*  69 */     this.Tail2 = new ModelRenderer(this, 48, 14);
/*  70 */     this.Tail2.func_78793_a(0.0F, 0.0F, 2.3F);
/*  71 */     this.Tail2.func_78790_a(-1.5F, -1.5F, 0.0F, 3, 3, 5, 0.0F);
/*  72 */     setRotateAngle(this.Tail2, -0.59184116F, 0.0F, 0.0F);
/*  73 */     this.Tail3 = new ModelRenderer(this, 44, 22);
/*  74 */     this.Tail3.func_78793_a(0.0F, 0.0F, 4.4F);
/*  75 */     this.Tail3.func_78790_a(-2.0F, -2.0F, 0.0F, 4, 4, 6, 0.0F);
/*  76 */     setRotateAngle(this.Tail3, 0.4553564F, 0.0F, 0.0F);
/*  77 */     this.Tail4 = new ModelRenderer(this, 52, 32);
/*  78 */     this.Tail4.func_78793_a(0.0F, 0.0F, 5.8F);
/*  79 */     this.Tail4.func_78790_a(-1.5F, -1.5F, 0.0F, 3, 3, 3, 0.0F);
/*  80 */     setRotateAngle(this.Tail4, 0.27314404F, 0.0F, 0.0F);
/*  81 */     this.EarR2 = new ModelRenderer(this, 49, 2);
/*  82 */     this.EarR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  83 */     this.EarR2.func_78790_a(-1.3F, -3.2F, 0.05F, 3, 4, 0, 0.0F);
/*  84 */     this.LegR = new ModelRenderer(this, 0, 43);
/*  85 */     this.LegR.func_78793_a(-2.3F, 10.6F, 0.0F);
/*  86 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
/*  87 */     this.ArmL = new ModelRenderer(this, 0, 18);
/*  88 */     this.ArmL.field_78809_i = true;
/*  89 */     this.ArmL.func_78793_a(5.0F, -1.0F, 0.5F);
/*  90 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.5F, 4, 5, 5, 0.0F);
/*  91 */     this.LegL2 = new ModelRenderer(this, 0, 53);
/*  92 */     this.LegL2.field_78809_i = true;
/*  93 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  94 */     this.LegL2.func_78790_a(-2.0F, 6.0F, -0.6F, 4, 7, 4, 0.0F);
/*  95 */     this.EarR = new ModelRenderer(this, 27, 2);
/*  96 */     this.EarR.func_78793_a(-3.0F, -6.1F, 0.0F);
/*  97 */     this.EarR.func_78790_a(-2.0F, -4.0F, 0.0F, 4, 6, 0, 0.0F);
/*  98 */     setRotateAngle(this.EarR, 0.0F, 0.27925268F, -0.6981317F);
/*  99 */     this.Scarf = new ModelRenderer(this, 17, 53);
/* 100 */     this.Scarf.func_78793_a(0.0F, 0.0F, 0.0F);
/* 101 */     this.Scarf.func_78790_a(-4.5F, -1.0F, -3.8F, 9, 3, 8, 0.0F);
/* 102 */     setRotateAngle(this.Scarf, 0.16231562F, 0.0F, 0.0F);
/* 103 */     this.Head = new ModelRenderer(this, 0, 0);
/* 104 */     this.Head.func_78793_a(0.0F, -3.0F, 0.0F);
/* 105 */     this.Head.func_78790_a(-4.0F, -7.2F, -4.0F, 8, 7, 8, 0.0F);
/* 106 */     this.EarL2 = new ModelRenderer(this, 49, 2);
/* 107 */     this.EarL2.field_78809_i = true;
/* 108 */     this.EarL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 109 */     this.EarL2.func_78790_a(-1.7F, -3.2F, 0.05F, 3, 4, 0, 0.0F);
/* 110 */     this.Body2 = new ModelRenderer(this, 20, 29);
/* 111 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 112 */     this.Body2.func_78790_a(-3.5F, 4.7F, -2.0F, 7, 6, 4, 0.0F);
/* 113 */     this.ArmL2 = new ModelRenderer(this, 0, 28);
/* 114 */     this.ArmL2.field_78809_i = true;
/* 115 */     this.ArmL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 116 */     this.ArmL2.func_78790_a(-0.6F, 2.8F, -2.0F, 3, 9, 4, 0.0F);
/* 117 */     this.Snout = new ModelRenderer(this, 36, 1);
/* 118 */     this.Snout.func_78793_a(0.0F, 0.0F, 0.0F);
/* 119 */     this.Snout.func_78790_a(-2.0F, -3.9F, -6.0F, 4, 3, 2, 0.0F);
/* 120 */     this.Body1 = new ModelRenderer(this, 20, 16);
/* 121 */     this.Body1.func_78793_a(0.0F, -3.0F, 0.0F);
/* 122 */     this.Body1.func_78790_a(-4.0F, 0.0F, -1.4F, 8, 8, 4, 0.0F);
/* 123 */     this.LegL = new ModelRenderer(this, 0, 43);
/* 124 */     this.LegL.field_78809_i = true;
/* 125 */     this.LegL.func_78793_a(2.3F, 10.6F, 0.0F);
/* 126 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
/* 127 */     this.Fur = new ModelRenderer(this, 42, 14);
/* 128 */     this.Fur.func_78793_a(0.2F, 0.9F, -3.0F);
/* 129 */     this.Fur.func_78790_a(-1.6F, -1.2F, -0.9F, 3, 3, 2, 0.0F);
/* 130 */     this.ArmR2 = new ModelRenderer(this, 0, 28);
/* 131 */     this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 132 */     this.ArmR2.func_78790_a(-2.6F, 2.8F, -2.0F, 3, 9, 4, 0.0F);
/* 133 */     this.Scarf.func_78792_a(this.Back);
/* 134 */     this.LegR.func_78792_a(this.LegR2);
/* 135 */     this.Tail4.func_78792_a(this.Tail5);
/* 136 */     this.Head.func_78792_a(this.EarL);
/* 137 */     this.Body2.func_78792_a(this.Body3);
/* 138 */     this.Body1.func_78792_a(this.Chest);
/* 139 */     this.Tail1.func_78792_a(this.Tail2);
/* 140 */     this.Tail2.func_78792_a(this.Tail3);
/* 141 */     this.Tail3.func_78792_a(this.Tail4);
/* 142 */     this.EarR.func_78792_a(this.EarR2);
/* 143 */     this.LegL.func_78792_a(this.LegL2);
/* 144 */     this.Head.func_78792_a(this.EarR);
/* 145 */     this.Body1.func_78792_a(this.Scarf);
/* 146 */     this.EarL.func_78792_a(this.EarL2);
/* 147 */     this.Body1.func_78792_a(this.Body2);
/* 148 */     this.ArmL.func_78792_a(this.ArmL2);
/* 149 */     this.Head.func_78792_a(this.Snout);
/* 150 */     this.Body1.func_78792_a(this.Fur);
/* 151 */     this.ArmR.func_78792_a(this.ArmR2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 156 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 159 */     this.LegL.func_78785_a(f5);
/* 160 */     this.Head.func_78785_a(f5);
/* 161 */     this.ArmL.func_78785_a(f5);
/* 162 */     this.ArmR.func_78785_a(f5);
/* 163 */     this.Body1.func_78785_a(f5);
/* 164 */     this.LegR.func_78785_a(f5);
/* 165 */     this.Tail1.func_78785_a(f5);
/*     */   }
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 169 */     modelRenderer.field_78795_f = x;
/* 170 */     modelRenderer.field_78796_g = y;
/* 171 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 175 */     int calc = par7Entity.field_70173_aa;
/* 176 */     if (calc > 100) calc -= 100; 
/* 177 */     float r = 360.0F;
/* 178 */     float r2 = 180.0F;
/* 179 */     float n4 = par4;
/* 180 */     float n5 = par5;
/*     */     
/* 182 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 183 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 184 */     float ex = par7Entity.field_70173_aa;
/* 185 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 186 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 188 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 189 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */     
/* 191 */     this.Tail1.field_78795_f = 0.2F;
/* 192 */     this.Tail1.field_78795_f += r4 / 2.0F;
/*     */     
/* 194 */     this.Tail2.field_78795_f = 0.2F;
/* 195 */     this.Tail2.field_78795_f += r4 / 2.0F;
/*     */     
/* 197 */     this.Tail3.field_78795_f = 0.2F;
/* 198 */     this.Tail3.field_78795_f += r4 / 2.0F;
/*     */     
/* 200 */     this.Tail4.field_78795_f = 0.2F;
/* 201 */     this.Tail4.field_78795_f += r4 / 2.0F;
/*     */     
/* 203 */     this.Tail5.field_78796_g = 0.2F;
/* 204 */     this.Tail5.field_78796_g += r4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 228 */     this.Back.field_78795_f = -0.15F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 229 */     if (0.0F > this.Back.field_78795_f) this.Back.field_78795_f *= -1.0F; 
/* 230 */     this.Back.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 235 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 236 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 237 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 238 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 240 */     this.LegR.field_78796_g = 0.0F;
/* 241 */     this.LegL.field_78796_g = 0.0F;
/* 242 */     this.ArmR.field_78796_g = 0.0F;
/* 243 */     this.ArmL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelBasil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */