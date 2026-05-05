/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelShosa
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
/*     */   public ModelRenderer Hair;
/*     */   public ModelRenderer Beard;
/*     */   public ModelRenderer EarR2;
/*     */   public ModelRenderer EarL2;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Chest;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer LegL2;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer Tail2;
/*     */   public ModelRenderer Tail3;
/*     */   public ModelRenderer Tail4;
/*     */   public ModelRenderer Tail5;
/*     */   
/*     */   public ModelShosa() {
/*  37 */     this.field_78090_t = 64;
/*  38 */     this.field_78089_u = 64;
/*  39 */     this.Hair = new ModelRenderer(this, 27, 52);
/*  40 */     this.Hair.func_78793_a(0.0F, -0.1F, 3.6F);
/*  41 */     this.Hair.func_78790_a(-3.5F, -0.3F, 0.0F, 7, 7, 0, 0.0F);
/*  42 */     this.Tail3 = new ModelRenderer(this, 44, 22);
/*  43 */     this.Tail3.func_78793_a(0.0F, 0.0F, 4.4F);
/*  44 */     this.Tail3.func_78790_a(-2.0F, -2.0F, 0.0F, 4, 4, 6, 0.0F);
/*  45 */     setRotateAngle(this.Tail3, 0.4553564F, 0.0F, 0.0F);
/*  46 */     this.EarR2 = new ModelRenderer(this, 49, 2);
/*  47 */     this.EarR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  48 */     this.EarR2.func_78790_a(-1.3F, -3.2F, 0.05F, 3, 4, 0, 0.0F);
/*  49 */     this.Body3 = new ModelRenderer(this, 19, 40);
/*  50 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  51 */     this.Body3.func_78790_a(-4.0F, 10.7F, -2.0F, 8, 3, 4, 0.0F);
/*  52 */     this.Tail2 = new ModelRenderer(this, 48, 14);
/*  53 */     this.Tail2.func_78793_a(0.0F, 0.0F, 2.3F);
/*  54 */     this.Tail2.func_78790_a(-1.5F, -1.5F, 0.0F, 3, 3, 5, 0.0F);
/*  55 */     setRotateAngle(this.Tail2, -0.59184116F, 0.0F, 0.0F);
/*  56 */     this.Head = new ModelRenderer(this, 0, 0);
/*  57 */     this.Head.func_78793_a(0.0F, -2.8F, 0.0F);
/*  58 */     this.Head.func_78790_a(-4.0F, -7.2F, -4.0F, 8, 7, 8, 0.0F);
/*  59 */     this.LegL = new ModelRenderer(this, 0, 43);
/*  60 */     this.LegL.field_78809_i = true;
/*  61 */     this.LegL.func_78793_a(2.3F, 10.6F, 0.0F);
/*  62 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
/*  63 */     this.Beard = new ModelRenderer(this, 41, 52);
/*  64 */     this.Beard.func_78793_a(0.0F, -0.2F, -3.5F);
/*  65 */     this.Beard.func_78790_a(-3.5F, -0.3F, 0.0F, 7, 7, 0, 0.0F);
/*  66 */     setRotateAngle(this.Beard, 0.0837758F, 0.0F, 0.0F);
/*  67 */     this.Tail1 = new ModelRenderer(this, 54, 9);
/*  68 */     this.Tail1.func_78793_a(0.0F, 8.2F, 1.8F);
/*  69 */     this.Tail1.func_78790_a(-1.0F, -1.0F, 0.0F, 2, 2, 3, 0.0F);
/*  70 */     setRotateAngle(this.Tail1, -0.4098033F, 0.0F, 0.0F);
/*  71 */     this.ArmL2 = new ModelRenderer(this, 0, 28);
/*  72 */     this.ArmL2.field_78809_i = true;
/*  73 */     this.ArmL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  74 */     this.ArmL2.func_78790_a(-0.6F, 2.8F, -2.0F, 4, 9, 4, 0.0F);
/*  75 */     this.Tail5 = new ModelRenderer(this, 54, 38);
/*  76 */     this.Tail5.func_78793_a(0.0F, 0.0F, 2.9F);
/*  77 */     this.Tail5.func_78790_a(-1.0F, -1.0F, 0.0F, 2, 2, 3, 0.0F);
/*  78 */     setRotateAngle(this.Tail5, 0.13665928F, 0.0F, 0.0F);
/*  79 */     this.EarR = new ModelRenderer(this, 27, 2);
/*  80 */     this.EarR.func_78793_a(-3.5F, -6.7F, 0.0F);
/*  81 */     this.EarR.func_78790_a(-2.0F, -4.0F, 0.0F, 4, 6, 0, 0.0F);
/*  82 */     setRotateAngle(this.EarR, 0.0F, 0.27925268F, -0.6981317F);
/*  83 */     this.EarL2 = new ModelRenderer(this, 49, 2);
/*  84 */     this.EarL2.field_78809_i = true;
/*  85 */     this.EarL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  86 */     this.EarL2.func_78790_a(-1.7F, -3.2F, 0.05F, 3, 4, 0, 0.0F);
/*  87 */     this.EarL = new ModelRenderer(this, 27, 2);
/*  88 */     this.EarL.field_78809_i = true;
/*  89 */     this.EarL.func_78793_a(3.5F, -6.7F, 0.0F);
/*  90 */     this.EarL.func_78790_a(-2.0F, -4.0F, 0.0F, 4, 6, 0, 0.0F);
/*  91 */     setRotateAngle(this.EarL, 0.0F, -0.27925268F, 0.6981317F);
/*  92 */     this.ArmL = new ModelRenderer(this, 0, 18);
/*  93 */     this.ArmL.field_78809_i = true;
/*  94 */     this.ArmL.func_78793_a(5.0F, -1.0F, 0.7F);
/*  95 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.5F, 5, 5, 5, 0.0F);
/*  96 */     this.ArmR2 = new ModelRenderer(this, 0, 28);
/*  97 */     this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  98 */     this.ArmR2.func_78790_a(-3.4F, 2.8F, -2.0F, 4, 9, 4, 0.0F);
/*  99 */     this.Body2 = new ModelRenderer(this, 20, 29);
/* 100 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 101 */     this.Body2.func_78790_a(-3.5F, 4.7F, -2.0F, 7, 6, 4, 0.0F);
/* 102 */     this.LegL2 = new ModelRenderer(this, 0, 53);
/* 103 */     this.LegL2.field_78809_i = true;
/* 104 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 105 */     this.LegL2.func_78790_a(-2.0F, 6.0F, -1.4F, 4, 7, 4, 0.0F);
/* 106 */     this.Body1 = new ModelRenderer(this, 20, 16);
/* 107 */     this.Body1.func_78793_a(0.0F, -3.0F, 0.0F);
/* 108 */     this.Body1.func_78790_a(-4.0F, 0.0F, -1.4F, 8, 8, 4, 0.0F);
/* 109 */     this.LegR = new ModelRenderer(this, 0, 43);
/* 110 */     this.LegR.func_78793_a(-2.3F, 10.6F, 0.0F);
/* 111 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
/* 112 */     this.Tail4 = new ModelRenderer(this, 52, 32);
/* 113 */     this.Tail4.func_78793_a(0.0F, 0.0F, 5.8F);
/* 114 */     this.Tail4.func_78790_a(-1.5F, -1.5F, 0.0F, 3, 3, 3, 0.0F);
/* 115 */     setRotateAngle(this.Tail4, 0.27314404F, 0.0F, 0.0F);
/* 116 */     this.LegR2 = new ModelRenderer(this, 0, 53);
/* 117 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 118 */     this.LegR2.func_78790_a(-2.0F, 6.0F, -1.4F, 4, 7, 4, 0.0F);
/* 119 */     this.Snout = new ModelRenderer(this, 36, 1);
/* 120 */     this.Snout.func_78793_a(0.0F, 0.0F, 0.0F);
/* 121 */     this.Snout.func_78790_a(-2.0F, -3.9F, -6.0F, 4, 3, 2, 0.0F);
/* 122 */     this.Chest = new ModelRenderer(this, 33, 9);
/* 123 */     this.Chest.func_78793_a(0.0F, 0.0F, 0.0F);
/* 124 */     this.Chest.func_78790_a(-4.0F, 1.0F, -2.5F, 8, 4, 1, 0.0F);
/* 125 */     this.ArmR = new ModelRenderer(this, 0, 18);
/* 126 */     this.ArmR.func_78793_a(-5.0F, -1.0F, 0.7F);
/* 127 */     this.ArmR.func_78790_a(-4.0F, -2.0F, -2.5F, 5, 5, 5, 0.0F);
/* 128 */     this.Head.func_78792_a(this.Hair);
/* 129 */     this.Tail2.func_78792_a(this.Tail3);
/* 130 */     this.EarR.func_78792_a(this.EarR2);
/* 131 */     this.Body2.func_78792_a(this.Body3);
/* 132 */     this.Tail1.func_78792_a(this.Tail2);
/* 133 */     this.Head.func_78792_a(this.Beard);
/* 134 */     this.ArmL.func_78792_a(this.ArmL2);
/* 135 */     this.Tail4.func_78792_a(this.Tail5);
/* 136 */     this.Head.func_78792_a(this.EarR);
/* 137 */     this.EarL.func_78792_a(this.EarL2);
/* 138 */     this.Head.func_78792_a(this.EarL);
/* 139 */     this.ArmR.func_78792_a(this.ArmR2);
/* 140 */     this.Body1.func_78792_a(this.Body2);
/* 141 */     this.LegL.func_78792_a(this.LegL2);
/* 142 */     this.Tail3.func_78792_a(this.Tail4);
/* 143 */     this.LegR.func_78792_a(this.LegR2);
/* 144 */     this.Head.func_78792_a(this.Snout);
/* 145 */     this.Body1.func_78792_a(this.Chest);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 150 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 153 */     this.Head.func_78785_a(f5);
/* 154 */     this.LegL.func_78785_a(f5);
/* 155 */     this.Tail1.func_78785_a(f5);
/* 156 */     this.ArmL.func_78785_a(f5);
/* 157 */     this.Body1.func_78785_a(f5);
/* 158 */     this.LegR.func_78785_a(f5);
/* 159 */     this.ArmR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 165 */     modelRenderer.field_78795_f = x;
/* 166 */     modelRenderer.field_78796_g = y;
/* 167 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 171 */     int calc = par7Entity.field_70173_aa;
/* 172 */     if (calc > 100) calc -= 100; 
/* 173 */     float r = 360.0F;
/* 174 */     float r2 = 180.0F;
/* 175 */     float n4 = par4;
/* 176 */     float n5 = par5;
/*     */ 
/*     */ 
/*     */     
/* 180 */     float ex = par7Entity.field_70173_aa;
/* 181 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 182 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 184 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 185 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */     
/* 187 */     this.Tail1.field_78795_f = 0.2F;
/* 188 */     this.Tail1.field_78795_f += r4 / 2.0F;
/*     */     
/* 190 */     this.Tail2.field_78795_f = 0.2F;
/* 191 */     this.Tail2.field_78795_f += r4 / 2.0F;
/*     */     
/* 193 */     this.Tail3.field_78795_f = 0.2F;
/* 194 */     this.Tail3.field_78795_f += r4 / 2.0F;
/*     */     
/* 196 */     this.Tail4.field_78795_f = 0.2F;
/* 197 */     this.Tail4.field_78795_f += r4 / 2.0F;
/*     */     
/* 199 */     this.Tail5.field_78796_g = 0.2F;
/* 200 */     this.Tail5.field_78796_g += r4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 231 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 232 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 233 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 234 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 236 */     this.LegR.field_78796_g = 0.0F;
/* 237 */     this.LegL.field_78796_g = 0.0F;
/* 238 */     this.ArmR.field_78796_g = 0.0F;
/* 239 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 246 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelShosa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */