/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelLavender
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer Tail1;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer Snout;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer EarR2;
/*     */   public ModelRenderer EarL2;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Chest;
/*     */   public ModelRenderer Fur;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer Tail2;
/*     */   public ModelRenderer Tail3;
/*     */   public ModelRenderer Tail4;
/*     */   public ModelRenderer Tail5;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer LegR2_1;
/*     */   
/*     */   public ModelLavender() {
/*  34 */     this.field_78090_t = 64;
/*  35 */     this.field_78089_u = 64;
/*  36 */     this.ArmL = new ModelRenderer(this, 0, 16);
/*  37 */     this.ArmL.field_78809_i = true;
/*  38 */     this.ArmL.func_78793_a(5.0F, -0.5F, -1.4F);
/*  39 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 16, 4, 0.0F);
/*  40 */     this.Body2 = new ModelRenderer(this, 20, 29);
/*  41 */     this.Body2.func_78793_a(0.0F, 7.5F, 0.0F);
/*  42 */     this.Body2.func_78790_a(-3.5F, -0.7F, -1.5F, 7, 4, 4, 0.0F);
/*  43 */     setRotateAngle(this.Body2, -0.2617994F, 0.0F, 0.0F);
/*  44 */     this.Tail4 = new ModelRenderer(this, 52, 32);
/*  45 */     this.Tail4.func_78793_a(0.0F, 0.0F, 5.8F);
/*  46 */     this.Tail4.func_78790_a(-1.5F, -1.5F, 0.0F, 3, 3, 3, 0.0F);
/*  47 */     setRotateAngle(this.Tail4, 0.27314404F, 0.0F, 0.0F);
/*  48 */     this.Tail1 = new ModelRenderer(this, 54, 9);
/*  49 */     this.Tail1.func_78793_a(0.0F, 9.2F, 1.0F);
/*  50 */     this.Tail1.func_78790_a(-1.0F, -1.0F, 0.0F, 2, 2, 3, 0.0F);
/*  51 */     setRotateAngle(this.Tail1, -0.4098033F, 0.0F, 0.0F);
/*  52 */     this.LegR2_1 = new ModelRenderer(this, 0, 50);
/*  53 */     this.LegR2_1.func_78793_a(0.1F, 6.0F, 1.3F);
/*  54 */     this.LegR2_1.func_78790_a(-2.0F, -1.5F, -0.6F, 4, 9, 4, 0.0F);
/*  55 */     setRotateAngle(this.LegR2_1, 0.4886922F, 0.0F, 0.0F);
/*  56 */     this.Tail5 = new ModelRenderer(this, 54, 38);
/*  57 */     this.Tail5.func_78793_a(0.0F, 0.0F, 2.9F);
/*  58 */     this.Tail5.func_78790_a(-1.0F, -1.0F, 0.0F, 2, 2, 3, 0.0F);
/*  59 */     setRotateAngle(this.Tail5, 0.13665928F, 0.0F, 0.0F);
/*  60 */     this.EarL2 = new ModelRenderer(this, 49, 2);
/*  61 */     this.EarL2.field_78809_i = true;
/*  62 */     this.EarL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  63 */     this.EarL2.func_78790_a(-1.7F, -3.2F, 0.05F, 3, 4, 0, 0.0F);
/*  64 */     this.LegR2 = new ModelRenderer(this, 0, 50);
/*  65 */     this.LegR2.func_78793_a(-0.1F, 6.0F, 1.3F);
/*  66 */     this.LegR2.func_78790_a(-2.0F, -1.5F, -0.6F, 4, 9, 4, 0.0F);
/*  67 */     setRotateAngle(this.LegR2, 0.4886922F, 0.0F, 0.0F);
/*  68 */     this.Body1 = new ModelRenderer(this, 20, 16);
/*  69 */     this.Body1.func_78793_a(0.0F, -3.0F, -1.9F);
/*  70 */     this.Body1.func_78790_a(-4.0F, 0.0F, -1.4F, 8, 8, 4, 0.0F);
/*  71 */     setRotateAngle(this.Body1, 0.17453292F, 0.0F, 0.0F);
/*  72 */     this.LegL = new ModelRenderer(this, 0, 39);
/*  73 */     this.LegL.func_78793_a(2.6F, 10.6F, -1.6F);
/*  74 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 7, 4, 0.0F);
/*  75 */     setRotateAngle(this.LegL, -0.4886922F, 0.0F, 0.0F);
/*  76 */     this.LegR = new ModelRenderer(this, 0, 39);
/*  77 */     this.LegR.func_78793_a(-2.5F, 10.6F, -1.6F);
/*  78 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 7, 4, 0.0F);
/*  79 */     setRotateAngle(this.LegR, -0.4886922F, 0.0F, 0.0F);
/*  80 */     this.EarR = new ModelRenderer(this, 27, 2);
/*  81 */     this.EarR.func_78793_a(-3.0F, -5.3F, -1.1F);
/*  82 */     this.EarR.func_78790_a(-2.0F, -4.0F, 0.0F, 4, 6, 0, 0.0F);
/*  83 */     setRotateAngle(this.EarR, 0.0F, 0.27925268F, -0.6981317F);
/*  84 */     this.ArmR = new ModelRenderer(this, 0, 16);
/*  85 */     this.ArmR.func_78793_a(-5.0F, -0.5F, -1.4F);
/*  86 */     this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 16, 4, 0.0F);
/*  87 */     this.EarL = new ModelRenderer(this, 27, 2);
/*  88 */     this.EarL.field_78809_i = true;
/*  89 */     this.EarL.func_78793_a(3.1F, -5.3F, -1.1F);
/*  90 */     this.EarL.func_78790_a(-2.0F, -4.0F, 0.0F, 4, 6, 0, 0.0F);
/*  91 */     setRotateAngle(this.EarL, 0.0F, -0.27925268F, 0.6981317F);
/*  92 */     this.Tail2 = new ModelRenderer(this, 48, 14);
/*  93 */     this.Tail2.func_78793_a(0.0F, 0.0F, 2.3F);
/*  94 */     this.Tail2.func_78790_a(-1.5F, -1.5F, 0.0F, 3, 3, 5, 0.0F);
/*  95 */     setRotateAngle(this.Tail2, -0.59184116F, 0.0F, 0.0F);
/*  96 */     this.Head = new ModelRenderer(this, 0, 0);
/*  97 */     this.Head.func_78793_a(0.0F, -1.6F, -3.0F);
/*  98 */     this.Head.func_78790_a(-4.0F, -5.8F, -4.9F, 8, 7, 8, 0.0F);
/*  99 */     setRotateAngle(this.Head, 0.045553092F, 0.0F, 0.0F);
/* 100 */     this.EarR2 = new ModelRenderer(this, 49, 2);
/* 101 */     this.EarR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 102 */     this.EarR2.func_78790_a(-1.3F, -3.2F, 0.05F, 3, 4, 0, 0.0F);
/* 103 */     this.Body3 = new ModelRenderer(this, 19, 40);
/* 104 */     this.Body3.func_78793_a(0.0F, 3.1F, 0.4F);
/* 105 */     this.Body3.func_78790_a(-4.0F, 0.2F, -2.0F, 8, 3, 4, 0.0F);
/* 106 */     setRotateAngle(this.Body3, 0.08726646F, 0.0F, 0.0F);
/* 107 */     this.Snout = new ModelRenderer(this, 36, 1);
/* 108 */     this.Snout.func_78793_a(0.0F, 0.0F, 0.0F);
/* 109 */     this.Snout.func_78790_a(-2.0F, -2.5F, -6.9F, 4, 3, 2, 0.0F);
/* 110 */     this.Chest = new ModelRenderer(this, 33, 9);
/* 111 */     this.Chest.func_78793_a(0.0F, 0.0F, 0.0F);
/* 112 */     this.Chest.func_78790_a(-4.0F, 2.1F, -2.5F, 8, 4, 1, 0.0F);
/* 113 */     this.Fur = new ModelRenderer(this, 45, 44);
/* 114 */     this.Fur.func_78793_a(0.0F, 0.9F, -3.0F);
/* 115 */     this.Fur.func_78790_a(-2.5F, 0.2F, -0.5F, 5, 4, 2, 0.0F);
/* 116 */     this.Tail3 = new ModelRenderer(this, 44, 22);
/* 117 */     this.Tail3.func_78793_a(0.0F, 0.0F, 4.4F);
/* 118 */     this.Tail3.func_78790_a(-2.0F, -2.0F, 0.0F, 4, 4, 6, 0.0F);
/* 119 */     setRotateAngle(this.Tail3, 0.4553564F, 0.0F, 0.0F);
/* 120 */     this.Body1.func_78792_a(this.Body2);
/* 121 */     this.Tail3.func_78792_a(this.Tail4);
/* 122 */     this.LegR.func_78792_a(this.LegR2_1);
/* 123 */     this.Tail4.func_78792_a(this.Tail5);
/* 124 */     this.EarL.func_78792_a(this.EarL2);
/* 125 */     this.LegL.func_78792_a(this.LegR2);
/* 126 */     this.Head.func_78792_a(this.EarR);
/* 127 */     this.Head.func_78792_a(this.EarL);
/* 128 */     this.Tail1.func_78792_a(this.Tail2);
/* 129 */     this.EarR.func_78792_a(this.EarR2);
/* 130 */     this.Body2.func_78792_a(this.Body3);
/* 131 */     this.Head.func_78792_a(this.Snout);
/* 132 */     this.Body1.func_78792_a(this.Chest);
/* 133 */     this.Body1.func_78792_a(this.Fur);
/* 134 */     this.Tail2.func_78792_a(this.Tail3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 139 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 142 */     this.LegL.func_78785_a(f5);
/* 143 */     this.Head.func_78785_a(f5);
/* 144 */     this.ArmL.func_78785_a(f5);
/* 145 */     this.ArmR.func_78785_a(f5);
/* 146 */     this.Body1.func_78785_a(f5);
/* 147 */     this.LegR.func_78785_a(f5);
/* 148 */     this.Tail1.func_78785_a(f5);
/*     */   }
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 152 */     modelRenderer.field_78795_f = x;
/* 153 */     modelRenderer.field_78796_g = y;
/* 154 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 158 */     int calc = par7Entity.field_70173_aa;
/* 159 */     if (calc > 100) calc -= 100; 
/* 160 */     float r = 360.0F;
/* 161 */     float r2 = 180.0F;
/* 162 */     float n4 = par4;
/* 163 */     float n5 = par5;
/*     */     
/* 165 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 166 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 167 */     float ex = par7Entity.field_70173_aa;
/* 168 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 169 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 171 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 172 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */     
/* 174 */     this.Tail1.field_78795_f = 0.2F;
/* 175 */     this.Tail1.field_78795_f += r4 / 2.0F;
/*     */     
/* 177 */     this.Tail2.field_78795_f = 0.2F;
/* 178 */     this.Tail2.field_78795_f += r4 / 2.0F;
/*     */     
/* 180 */     this.Tail3.field_78795_f = 0.2F;
/* 181 */     this.Tail3.field_78795_f += r4 / 2.0F;
/*     */     
/* 183 */     this.Tail4.field_78795_f = 0.2F;
/* 184 */     this.Tail4.field_78795_f += r4 / 2.0F;
/*     */     
/* 186 */     this.Tail5.field_78796_g = 0.2F;
/* 187 */     this.Tail5.field_78796_g += r4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 213 */     this.LegR.field_78795_f = -0.4F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 214 */     this.LegL.field_78795_f = -0.4F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 215 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 216 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 218 */     this.LegR.field_78796_g = 0.0F;
/* 219 */     this.LegL.field_78796_g = 0.0F;
/* 220 */     this.ArmR.field_78796_g = 0.0F;
/* 221 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 232 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelLavender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */