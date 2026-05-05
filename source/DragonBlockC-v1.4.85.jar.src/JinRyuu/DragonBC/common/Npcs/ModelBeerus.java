/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelBeerus extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer Snout1;
/*     */   public ModelRenderer EarL_1;
/*     */   public ModelRenderer Snout2;
/*     */   public ModelRenderer SnoutSideR;
/*     */   public ModelRenderer SnoutSideL;
/*     */   public ModelRenderer Neck;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Cloth1;
/*     */   public ModelRenderer tail1;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer tail2;
/*     */   public ModelRenderer tail3;
/*     */   public ModelRenderer tail4;
/*     */   public ModelRenderer tail5;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer LegL2;
/*     */   
/*     */   public ModelBeerus() {
/*  35 */     this.field_78090_t = 64;
/*  36 */     this.field_78089_u = 64;
/*  37 */     this.Body2 = new ModelRenderer(this, 23, 29);
/*  38 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  39 */     this.Body2.func_78790_a(-3.0F, 5.0F, -1.7F, 6, 3, 3, 0.0F);
/*  40 */     this.Snout2 = new ModelRenderer(this, 42, 11);
/*  41 */     this.Snout2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  42 */     this.Snout2.func_78790_a(-0.5F, 1.1F, -5.4F, 1, 2, 1, 0.0F);
/*  43 */     setRotateAngle(this.Snout2, -1.0927507F, 0.0F, 0.0F);
/*  44 */     this.LegR2 = new ModelRenderer(this, 0, 16);
/*  45 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  46 */     this.LegR2.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  47 */     this.ArmR = new ModelRenderer(this, 50, 16);
/*  48 */     this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  49 */     this.ArmR.func_78790_a(-2.0F, -2.0F, -1.8F, 3, 12, 4, 0.0F);
/*  50 */     this.SnoutSideL = new ModelRenderer(this, 47, 11);
/*  51 */     this.SnoutSideL.field_78809_i = true;
/*  52 */     this.SnoutSideL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  53 */     this.SnoutSideL.func_78790_a(-1.7F, -3.2F, -5.0F, 2, 2, 1, 0.0F);
/*  54 */     setRotateAngle(this.SnoutSideL, 0.0F, -0.5934119F, 0.0F);
/*  55 */     this.EarR = new ModelRenderer(this, 31, 0);
/*  56 */     this.EarR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  57 */     this.EarR.func_78790_a(-5.0F, -15.1F, 1.9F, 4, 10, 1, 0.0F);
/*  58 */     setRotateAngle(this.EarR, 0.10995574F, 0.0F, 0.0F);
/*  59 */     this.EarL_1 = new ModelRenderer(this, 47, 1);
/*  60 */     this.EarL_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  61 */     this.EarL_1.func_78790_a(4.1F, -11.8F, 1.4F, 1, 1, 2, 0.0F);
/*  62 */     this.tail1 = new ModelRenderer(this, 42, 1);
/*  63 */     this.tail1.func_78793_a(0.0F, 10.3F, 1.5F);
/*  64 */     this.tail1.func_78790_a(-0.5F, -0.3F, -0.5F, 1, 3, 1, 0.0F);
/*  65 */     setRotateAngle(this.tail1, 1.0011208F, 0.0F, 0.0F);
/*  66 */     this.tail5 = new ModelRenderer(this, 42, 1);
/*  67 */     this.tail5.func_78793_a(0.0F, 2.6F, 0.0F);
/*  68 */     this.tail5.func_78790_a(-0.5F, -0.1F, -0.5F, 1, 3, 1, 0.0F);
/*  69 */     setRotateAngle(this.tail5, 0.27314404F, 0.0F, 0.0F);
/*  70 */     this.tail2 = new ModelRenderer(this, 42, 1);
/*  71 */     this.tail2.func_78793_a(0.0F, 2.6F, 0.0F);
/*  72 */     this.tail2.func_78790_a(-0.5F, -0.1F, -0.5F, 1, 3, 1, 0.0F);
/*  73 */     setRotateAngle(this.tail2, -0.18203785F, 0.0F, 0.0F);
/*  74 */     this.tail4 = new ModelRenderer(this, 42, 1);
/*  75 */     this.tail4.func_78793_a(0.0F, 2.6F, 0.0F);
/*  76 */     this.tail4.func_78790_a(-0.5F, -0.1F, -0.5F, 1, 3, 1, 0.0F);
/*  77 */     setRotateAngle(this.tail4, 0.27314404F, 0.0F, 0.0F);
/*  78 */     this.LegR = new ModelRenderer(this, 0, 33);
/*  79 */     this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
/*  80 */     this.LegR.func_78790_a(-2.3F, 1.4F, -2.0F, 4, 6, 4, 0.2F);
/*  81 */     this.LegL = new ModelRenderer(this, 0, 33);
/*  82 */     this.LegL.field_78809_i = true;
/*  83 */     this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
/*  84 */     this.LegL.func_78790_a(-1.8F, 1.4F, -2.0F, 4, 6, 4, 0.2F);
/*  85 */     this.LegL2 = new ModelRenderer(this, 0, 16);
/*  86 */     this.LegL2.field_78809_i = true;
/*  87 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  88 */     this.LegL2.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  89 */     this.Snout1 = new ModelRenderer(this, 41, 14);
/*  90 */     this.Snout1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  91 */     this.Snout1.func_78790_a(-1.5F, -3.4F, -5.4F, 3, 3, 2, 0.0F);
/*  92 */     this.SnoutSideR = new ModelRenderer(this, 47, 11);
/*  93 */     this.SnoutSideR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  94 */     this.SnoutSideR.func_78790_a(-0.2F, -3.2F, -5.0F, 2, 2, 1, 0.0F);
/*  95 */     setRotateAngle(this.SnoutSideR, 0.0F, 0.5934119F, 0.0F);
/*  96 */     this.Cloth1 = new ModelRenderer(this, 54, 0);
/*  97 */     this.Cloth1.func_78793_a(0.0F, 10.0F, -1.5F);
/*  98 */     this.Cloth1.func_78790_a(-2.5F, 0.0F, -0.5F, 5, 10, 0, 0.0F);
/*  99 */     setRotateAngle(this.Cloth1, -0.090757124F, 0.0F, 0.0F);
/* 100 */     this.Neck = new ModelRenderer(this, 42, 6);
/* 101 */     this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
/* 102 */     this.Neck.func_78790_a(-2.0F, -0.9F, -0.8F, 4, 2, 2, 0.0F);
/* 103 */     this.Body1 = new ModelRenderer(this, 20, 18);
/* 104 */     this.Body1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 105 */     this.Body1.func_78790_a(-4.0F, 0.0F, -1.8F, 8, 5, 4, 0.0F);
/* 106 */     this.Head = new ModelRenderer(this, 0, 0);
/* 107 */     this.Head.func_78793_a(0.0F, -0.4F, 0.0F);
/* 108 */     this.Head.func_78790_a(-3.5F, -8.0F, -4.0F, 7, 8, 8, -0.1F);
/* 109 */     this.tail3 = new ModelRenderer(this, 42, 1);
/* 110 */     this.tail3.func_78793_a(0.0F, 2.6F, 0.0F);
/* 111 */     this.tail3.func_78790_a(-0.5F, -0.1F, -0.5F, 1, 3, 1, 0.0F);
/* 112 */     setRotateAngle(this.tail3, -0.18203785F, 0.0F, 0.0F);
/* 113 */     this.Body3 = new ModelRenderer(this, 20, 37);
/* 114 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 115 */     this.Body3.func_78790_a(-4.0F, 8.0F, -2.0F, 8, 4, 4, 0.0F);
/* 116 */     this.ArmL = new ModelRenderer(this, 50, 16);
/* 117 */     this.ArmL.field_78809_i = true;
/* 118 */     this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
/* 119 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -1.8F, 3, 12, 4, 0.0F);
/* 120 */     this.EarL = new ModelRenderer(this, 31, 0);
/* 121 */     this.EarL.field_78809_i = true;
/* 122 */     this.EarL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 123 */     this.EarL.func_78790_a(0.9F, -15.1F, 1.9F, 4, 10, 1, 0.0F);
/* 124 */     setRotateAngle(this.EarL, 0.10995574F, 0.0F, 0.0F);
/* 125 */     this.Body1.func_78792_a(this.Body2);
/* 126 */     this.Snout1.func_78792_a(this.Snout2);
/* 127 */     this.LegR.func_78792_a(this.LegR2);
/* 128 */     this.Snout1.func_78792_a(this.SnoutSideL);
/* 129 */     this.Head.func_78792_a(this.EarR);
/* 130 */     this.EarL.func_78792_a(this.EarL_1);
/* 131 */     this.Body1.func_78792_a(this.tail1);
/* 132 */     this.tail4.func_78792_a(this.tail5);
/* 133 */     this.tail1.func_78792_a(this.tail2);
/* 134 */     this.tail3.func_78792_a(this.tail4);
/* 135 */     this.LegL.func_78792_a(this.LegL2);
/* 136 */     this.Head.func_78792_a(this.Snout1);
/* 137 */     this.Snout1.func_78792_a(this.SnoutSideR);
/* 138 */     this.Body1.func_78792_a(this.Cloth1);
/* 139 */     this.Body1.func_78792_a(this.Neck);
/* 140 */     this.tail2.func_78792_a(this.tail3);
/* 141 */     this.Body2.func_78792_a(this.Body3);
/* 142 */     this.Head.func_78792_a(this.EarL);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 147 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 150 */     this.LegL.func_78785_a(f5);
/* 151 */     this.Head.func_78785_a(f5);
/* 152 */     this.ArmL.func_78785_a(f5);
/* 153 */     this.ArmR.func_78785_a(f5);
/* 154 */     this.Body1.func_78785_a(f5);
/* 155 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 160 */     modelRenderer.field_78795_f = x;
/* 161 */     modelRenderer.field_78796_g = y;
/* 162 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 166 */     int calc = par7Entity.field_70173_aa;
/* 167 */     if (calc > 100) calc -= 100; 
/* 168 */     float r = 360.0F;
/* 169 */     float r2 = 180.0F;
/* 170 */     float n4 = par4;
/* 171 */     float n5 = par5;
/*     */     
/* 173 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 174 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 175 */     float ex = par7Entity.field_70173_aa;
/* 176 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 177 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 179 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 180 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */     
/* 184 */     this.tail2.field_78795_f = 0.2F;
/* 185 */     this.tail2.field_78795_f += r4 / 2.0F;
/*     */     
/* 187 */     this.tail3.field_78795_f = 0.2F;
/* 188 */     this.tail3.field_78795_f += r4 / 2.0F;
/*     */     
/* 190 */     this.tail4.field_78795_f = 0.2F;
/* 191 */     this.tail4.field_78795_f += r4 / 2.0F;
/*     */     
/* 193 */     this.tail5.field_78796_g = 0.2F;
/* 194 */     this.tail5.field_78796_g += r4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 205 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 206 */     this.LegL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 207 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 208 */     this.ArmL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 209 */     this.LegR.field_78796_g = 0.0F;
/* 210 */     this.LegL.field_78796_g = 0.0F;
/* 211 */     this.ArmR.field_78796_g = 0.0F;
/* 212 */     this.ArmL.field_78796_g = 0.0F;
/*     */     
/* 214 */     this.Cloth1.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/* 215 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelBeerus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */