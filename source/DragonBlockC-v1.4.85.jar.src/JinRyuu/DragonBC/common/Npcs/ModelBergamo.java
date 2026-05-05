/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelBergamo
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
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer ScarfBack;
/*     */   public ModelRenderer ScarfFront;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer LegL2;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer Tail2;
/*     */   public ModelRenderer Tail3;
/*     */   public ModelRenderer Tail4;
/*     */   public ModelRenderer Tail5;
/*     */   
/*     */   public ModelBergamo() {
/*  38 */     this.field_78090_t = 64;
/*  39 */     this.field_78089_u = 64;
/*  40 */     this.LegL = new ModelRenderer(this, 0, 43);
/*  41 */     this.LegL.field_78809_i = true;
/*  42 */     this.LegL.func_78793_a(2.3F, 10.6F, 0.0F);
/*  43 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
/*  44 */     this.Body1 = new ModelRenderer(this, 20, 16);
/*  45 */     this.Body1.func_78793_a(0.0F, -3.0F, 0.0F);
/*  46 */     this.Body1.func_78790_a(-4.0F, 0.0F, -1.4F, 8, 8, 4, 0.0F);
/*  47 */     this.Snout = new ModelRenderer(this, 36, 1);
/*  48 */     this.Snout.func_78793_a(0.0F, 0.0F, 0.0F);
/*  49 */     this.Snout.func_78790_a(-2.0F, -3.9F, -6.0F, 4, 3, 2, 0.0F);
/*  50 */     this.LegL2 = new ModelRenderer(this, 0, 53);
/*  51 */     this.LegL2.field_78809_i = true;
/*  52 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  53 */     this.LegL2.func_78790_a(-2.0F, 6.0F, -0.6F, 4, 7, 4, 0.0F);
/*  54 */     this.EarR2 = new ModelRenderer(this, 49, 2);
/*  55 */     this.EarR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  56 */     this.EarR2.func_78790_a(-1.3F, -3.2F, 0.05F, 3, 4, 0, 0.0F);
/*  57 */     this.ScarfFront = new ModelRenderer(this, 57, 47);
/*  58 */     this.ScarfFront.field_78809_i = true;
/*  59 */     this.ScarfFront.func_78793_a(2.7F, 1.6F, -2.9F);
/*  60 */     this.ScarfFront.func_78790_a(-1.6F, 0.4F, 0.0F, 3, 12, 0, 0.0F);
/*  61 */     setRotateAngle(this.ScarfFront, -0.17453292F, 0.0F, 0.0F);
/*  62 */     this.ScarfBack = new ModelRenderer(this, 57, 47);
/*  63 */     this.ScarfBack.func_78793_a(2.7F, 1.6F, 3.6F);
/*  64 */     this.ScarfBack.func_78790_a(-1.6F, 0.4F, 0.0F, 3, 12, 0, 0.0F);
/*  65 */     setRotateAngle(this.ScarfBack, -0.091106184F, 0.0F, 0.0F);
/*  66 */     this.Tail5 = new ModelRenderer(this, 54, 38);
/*  67 */     this.Tail5.func_78793_a(0.0F, 0.0F, 2.9F);
/*  68 */     this.Tail5.func_78790_a(-1.0F, -1.0F, 0.0F, 2, 2, 3, 0.0F);
/*  69 */     setRotateAngle(this.Tail5, 0.13665928F, 0.0F, 0.0F);
/*  70 */     this.ArmL2 = new ModelRenderer(this, 0, 28);
/*  71 */     this.ArmL2.field_78809_i = true;
/*  72 */     this.ArmL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  73 */     this.ArmL2.func_78790_a(-0.6F, 2.8F, -2.0F, 4, 9, 4, 0.0F);
/*  74 */     this.Tail4 = new ModelRenderer(this, 52, 32);
/*  75 */     this.Tail4.func_78793_a(0.0F, 0.0F, 5.8F);
/*  76 */     this.Tail4.func_78790_a(-1.5F, -1.5F, 0.0F, 3, 3, 3, 0.0F);
/*  77 */     setRotateAngle(this.Tail4, 0.27314404F, 0.0F, 0.0F);
/*  78 */     this.Chest = new ModelRenderer(this, 33, 9);
/*  79 */     this.Chest.func_78793_a(0.0F, 0.0F, 0.0F);
/*  80 */     this.Chest.func_78790_a(-4.0F, 1.0F, -2.5F, 8, 4, 1, 0.0F);
/*  81 */     this.EarL2 = new ModelRenderer(this, 49, 2);
/*  82 */     this.EarL2.field_78809_i = true;
/*  83 */     this.EarL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  84 */     this.EarL2.func_78790_a(-1.7F, -3.2F, 0.05F, 3, 4, 0, 0.0F);
/*  85 */     this.Body3 = new ModelRenderer(this, 19, 40);
/*  86 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  87 */     this.Body3.func_78790_a(-4.0F, 10.7F, -2.0F, 8, 3, 4, 0.0F);
/*  88 */     this.ArmR2 = new ModelRenderer(this, 0, 28);
/*  89 */     this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  90 */     this.ArmR2.func_78790_a(-3.4F, 2.8F, -2.0F, 4, 9, 4, 0.0F);
/*  91 */     this.EarL = new ModelRenderer(this, 27, 2);
/*  92 */     this.EarL.field_78809_i = true;
/*  93 */     this.EarL.func_78793_a(3.1F, -6.1F, 0.0F);
/*  94 */     this.EarL.func_78790_a(-2.0F, -4.0F, 0.0F, 4, 6, 0, 0.0F);
/*  95 */     setRotateAngle(this.EarL, 0.0F, -0.27925268F, 0.6981317F);
/*  96 */     this.LegR = new ModelRenderer(this, 0, 43);
/*  97 */     this.LegR.func_78793_a(-2.3F, 10.6F, 0.0F);
/*  98 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
/*  99 */     this.Scarf = new ModelRenderer(this, 28, 52);
/* 100 */     this.Scarf.func_78793_a(0.0F, 0.0F, 0.0F);
/* 101 */     this.Scarf.func_78790_a(-4.5F, -0.9F, -4.3F, 9, 3, 9, 0.0F);
/* 102 */     setRotateAngle(this.Scarf, 0.16231562F, 0.0F, 0.0F);
/* 103 */     this.ArmR = new ModelRenderer(this, 0, 18);
/* 104 */     this.ArmR.func_78793_a(-5.0F, -1.0F, 0.5F);
/* 105 */     this.ArmR.func_78790_a(-4.0F, -2.0F, -2.5F, 5, 5, 5, 0.0F);
/* 106 */     this.LegR2 = new ModelRenderer(this, 0, 53);
/* 107 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 108 */     this.LegR2.func_78790_a(-2.0F, 6.0F, -0.6F, 4, 7, 4, 0.0F);
/* 109 */     this.Head = new ModelRenderer(this, 0, 0);
/* 110 */     this.Head.func_78793_a(0.0F, -3.0F, 0.0F);
/* 111 */     this.Head.func_78790_a(-4.0F, -7.2F, -4.0F, 8, 7, 8, 0.0F);
/* 112 */     this.Tail1 = new ModelRenderer(this, 54, 9);
/* 113 */     this.Tail1.func_78793_a(0.0F, 8.2F, 1.8F);
/* 114 */     this.Tail1.func_78790_a(-1.0F, -1.0F, 0.0F, 2, 2, 3, 0.0F);
/* 115 */     setRotateAngle(this.Tail1, -0.4098033F, 0.0F, 0.0F);
/* 116 */     this.Tail3 = new ModelRenderer(this, 44, 22);
/* 117 */     this.Tail3.func_78793_a(0.0F, 0.0F, 4.4F);
/* 118 */     this.Tail3.func_78790_a(-2.0F, -2.0F, 0.0F, 4, 4, 6, 0.0F);
/* 119 */     setRotateAngle(this.Tail3, 0.4553564F, 0.0F, 0.0F);
/* 120 */     this.ArmL = new ModelRenderer(this, 0, 18);
/* 121 */     this.ArmL.field_78809_i = true;
/* 122 */     this.ArmL.func_78793_a(5.0F, -1.0F, 0.5F);
/* 123 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.5F, 5, 5, 5, 0.0F);
/* 124 */     this.EarR = new ModelRenderer(this, 27, 2);
/* 125 */     this.EarR.func_78793_a(-3.0F, -6.1F, 0.0F);
/* 126 */     this.EarR.func_78790_a(-2.0F, -4.0F, 0.0F, 4, 6, 0, 0.0F);
/* 127 */     setRotateAngle(this.EarR, 0.0F, 0.27925268F, -0.6981317F);
/* 128 */     this.Tail2 = new ModelRenderer(this, 48, 14);
/* 129 */     this.Tail2.func_78793_a(0.0F, 0.0F, 2.3F);
/* 130 */     this.Tail2.func_78790_a(-1.5F, -1.5F, 0.0F, 3, 3, 5, 0.0F);
/* 131 */     setRotateAngle(this.Tail2, -0.59184116F, 0.0F, 0.0F);
/* 132 */     this.Body2 = new ModelRenderer(this, 20, 29);
/* 133 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 134 */     this.Body2.func_78790_a(-3.5F, 4.7F, -2.0F, 7, 6, 4, 0.0F);
/* 135 */     this.Head.func_78792_a(this.Snout);
/* 136 */     this.LegL.func_78792_a(this.LegL2);
/* 137 */     this.EarR.func_78792_a(this.EarR2);
/* 138 */     this.Scarf.func_78792_a(this.ScarfFront);
/* 139 */     this.Scarf.func_78792_a(this.ScarfBack);
/* 140 */     this.Tail4.func_78792_a(this.Tail5);
/* 141 */     this.ArmL.func_78792_a(this.ArmL2);
/* 142 */     this.Tail3.func_78792_a(this.Tail4);
/* 143 */     this.Body1.func_78792_a(this.Chest);
/* 144 */     this.EarL.func_78792_a(this.EarL2);
/* 145 */     this.Body2.func_78792_a(this.Body3);
/* 146 */     this.ArmR.func_78792_a(this.ArmR2);
/* 147 */     this.Head.func_78792_a(this.EarL);
/* 148 */     this.Body1.func_78792_a(this.Scarf);
/* 149 */     this.LegR.func_78792_a(this.LegR2);
/* 150 */     this.Tail2.func_78792_a(this.Tail3);
/* 151 */     this.Head.func_78792_a(this.EarR);
/* 152 */     this.Tail1.func_78792_a(this.Tail2);
/* 153 */     this.Body1.func_78792_a(this.Body2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 158 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 161 */     this.LegL.func_78785_a(f5);
/* 162 */     this.Head.func_78785_a(f5);
/* 163 */     this.ArmL.func_78785_a(f5);
/* 164 */     this.ArmR.func_78785_a(f5);
/* 165 */     this.Body1.func_78785_a(f5);
/* 166 */     this.LegR.func_78785_a(f5);
/* 167 */     this.Tail1.func_78785_a(f5);
/*     */   }
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 171 */     modelRenderer.field_78795_f = x;
/* 172 */     modelRenderer.field_78796_g = y;
/* 173 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 177 */     int calc = par7Entity.field_70173_aa;
/* 178 */     if (calc > 100) calc -= 100; 
/* 179 */     float r = 360.0F;
/* 180 */     float r2 = 180.0F;
/* 181 */     float n4 = par4;
/* 182 */     float n5 = par5;
/*     */     
/* 184 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 185 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 186 */     float ex = par7Entity.field_70173_aa;
/* 187 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 188 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 190 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 191 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */     
/* 193 */     this.Tail1.field_78795_f = 0.2F;
/* 194 */     this.Tail1.field_78795_f += r4 / 2.0F;
/*     */     
/* 196 */     this.Tail2.field_78795_f = 0.2F;
/* 197 */     this.Tail2.field_78795_f += r4 / 2.0F;
/*     */     
/* 199 */     this.Tail3.field_78795_f = 0.2F;
/* 200 */     this.Tail3.field_78795_f += r4 / 2.0F;
/*     */     
/* 202 */     this.Tail4.field_78795_f = 0.2F;
/* 203 */     this.Tail4.field_78795_f += r4 / 2.0F;
/*     */     
/* 205 */     this.Tail5.field_78796_g = 0.2F;
/* 206 */     this.Tail5.field_78796_g += r4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 232 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 233 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 234 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 235 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 237 */     this.LegR.field_78796_g = 0.0F;
/* 238 */     this.LegL.field_78796_g = 0.0F;
/* 239 */     this.ArmR.field_78796_g = 0.0F;
/* 240 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */     
/* 243 */     this.ScarfFront.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/*     */     
/* 245 */     this.ScarfBack.field_78795_f = 0.15F + this.LegL.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/*     */     
/* 247 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelBergamo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */