/*     */ package JinRyuu.DragonBC.common.Npcs.dbpilaf;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelShu
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer tail1;
/*     */   public ModelRenderer Head_1;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer Sword;
/*     */   public ModelRenderer Sword2;
/*     */   public ModelRenderer LegL_1;
/*     */   public ModelRenderer LegR_1;
/*     */   public ModelRenderer tail2;
/*     */   public ModelRenderer tail3;
/*     */   
/*     */   public ModelShu() {
/*  28 */     this.field_78090_t = 64;
/*  29 */     this.field_78089_u = 64;
/*  30 */     this.LegR = new ModelRenderer(this, 1, 42);
/*  31 */     this.LegR.func_78793_a(-1.9F, 17.0F, 0.0F);
/*  32 */     this.LegR.func_78790_a(-2.1F, 0.0F, -2.4F, 4, 5, 5, 0.0F);
/*  33 */     this.EarR = new ModelRenderer(this, 31, 1);
/*  34 */     this.EarR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  35 */     this.EarR.func_78790_a(-3.4F, -10.4F, -0.1F, 3, 4, 0, 0.0F);
/*  36 */     setRotateAngle(this.EarR, 0.10995574F, 0.0F, 0.0F);
/*  37 */     this.LegL = new ModelRenderer(this, 1, 42);
/*  38 */     this.LegL.field_78809_i = true;
/*  39 */     this.LegL.func_78793_a(1.9F, 17.0F, 0.0F);
/*  40 */     this.LegL.func_78790_a(-1.9F, 0.0F, -2.4F, 4, 5, 5, 0.0F);
/*  41 */     this.EarL = new ModelRenderer(this, 31, 1);
/*  42 */     this.EarL.field_78809_i = true;
/*  43 */     this.EarL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  44 */     this.EarL.func_78790_a(0.4F, -10.4F, 0.1F, 3, 4, 0, 0.0F);
/*  45 */     setRotateAngle(this.EarL, 0.10995574F, 0.0F, 0.0F);
/*  46 */     this.tail1 = new ModelRenderer(this, 42, 1);
/*  47 */     this.tail1.func_78793_a(0.0F, 16.1F, 2.7F);
/*  48 */     this.tail1.func_78790_a(-1.0F, -1.0F, -0.4F, 2, 2, 2, 0.0F);
/*  49 */     setRotateAngle(this.tail1, -0.01379388F, 0.0F, 0.0F);
/*  50 */     this.Sword = new ModelRenderer(this, 27, 16);
/*  51 */     this.Sword.func_78793_a(-0.7F, 2.6F, 3.5F);
/*  52 */     this.Sword.func_78790_a(-8.8F, -1.0F, 0.2F, 18, 2, 0, 0.0F);
/*  53 */     setRotateAngle(this.Sword, 0.0F, 0.098262034F, 0.63739425F);
/*  54 */     this.LegL_1 = new ModelRenderer(this, 2, 53);
/*  55 */     this.LegL_1.field_78809_i = true;
/*  56 */     this.LegL_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  57 */     this.LegL_1.func_78790_a(-1.5F, 5.0F, -2.0F, 3, 2, 4, 0.0F);
/*  58 */     this.ArmL = new ModelRenderer(this, 1, 31);
/*  59 */     this.ArmL.field_78809_i = true;
/*  60 */     this.ArmL.func_78793_a(4.5F, 9.0F, 0.0F);
/*  61 */     this.ArmL.func_78790_a(-0.6F, -0.6F, -1.5F, 3, 7, 3, 0.0F);
/*  62 */     setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.04363323F);
/*  63 */     this.Head = new ModelRenderer(this, 0, 0);
/*  64 */     this.Head.func_78793_a(0.0F, 8.3F, 0.0F);
/*  65 */     this.Head.func_78790_a(-4.0F, -6.8F, -4.1F, 8, 7, 7, -0.2F);
/*  66 */     this.ArmR = new ModelRenderer(this, 1, 31);
/*  67 */     this.ArmR.func_78793_a(-4.6F, 9.0F, 0.0F);
/*  68 */     this.ArmR.func_78790_a(-2.3F, -0.6F, -1.4F, 3, 7, 3, 0.0F);
/*  69 */     setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.04363323F);
/*  70 */     this.Body = new ModelRenderer(this, 1, 15);
/*  71 */     this.Body.func_78793_a(0.0F, 8.0F, 0.0F);
/*  72 */     this.Body.func_78790_a(-4.0F, 0.3F, -3.0F, 8, 9, 6, 0.0F);
/*  73 */     this.tail2 = new ModelRenderer(this, 48, 2);
/*  74 */     this.tail2.func_78793_a(0.0F, 0.1F, 1.4F);
/*  75 */     this.tail2.func_78790_a(-1.5F, -1.4F, -0.5F, 3, 3, 5, 0.0F);
/*  76 */     setRotateAngle(this.tail2, 0.06021386F, 0.0F, 0.0F);
/*  77 */     this.Sword2 = new ModelRenderer(this, 31, 17);
/*  78 */     this.Sword2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  79 */     this.Sword2.func_78790_a(-3.9F, -2.0F, -0.7F, 0, 4, 2, 0.0F);
/*  80 */     this.tail3 = new ModelRenderer(this, 53, 10);
/*  81 */     this.tail3.func_78793_a(0.0F, 0.0F, 4.2F);
/*  82 */     this.tail3.func_78790_a(-1.0F, -0.9F, -0.6F, 2, 2, 3, 0.0F);
/*  83 */     this.Head_1 = new ModelRenderer(this, 32, 7);
/*  84 */     this.Head_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  85 */     this.Head_1.func_78790_a(-1.5F, -2.9F, -5.9F, 3, 3, 2, 0.0F);
/*  86 */     this.LegR_1 = new ModelRenderer(this, 2, 53);
/*  87 */     this.LegR_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  88 */     this.LegR_1.func_78790_a(-1.5F, 5.0F, -2.0F, 3, 2, 4, 0.0F);
/*  89 */     this.Head.func_78792_a(this.EarR);
/*  90 */     this.Head.func_78792_a(this.EarL);
/*  91 */     this.Body.func_78792_a(this.Sword);
/*  92 */     this.LegL.func_78792_a(this.LegL_1);
/*  93 */     this.tail1.func_78792_a(this.tail2);
/*  94 */     this.Sword.func_78792_a(this.Sword2);
/*  95 */     this.tail2.func_78792_a(this.tail3);
/*  96 */     this.Head.func_78792_a(this.Head_1);
/*  97 */     this.LegR.func_78792_a(this.LegR_1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 102 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 104 */     this.Body.func_78785_a(f5);
/* 105 */     this.ArmR.func_78785_a(f5);
/* 106 */     this.ArmL.func_78785_a(f5);
/* 107 */     this.LegL.func_78785_a(f5);
/* 108 */     this.Head.func_78785_a(f5);
/* 109 */     this.LegR.func_78785_a(f5);
/* 110 */     this.tail1.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 116 */     modelRenderer.field_78795_f = x;
/* 117 */     modelRenderer.field_78796_g = y;
/* 118 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 122 */     int calc = par7Entity.field_70173_aa;
/* 123 */     if (calc > 100) calc -= 100; 
/* 124 */     float r = 360.0F;
/* 125 */     float r2 = 180.0F;
/* 126 */     float n4 = par4;
/* 127 */     float n5 = par5;
/*     */     
/* 129 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 130 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 131 */     float ex = par7Entity.field_70173_aa;
/* 132 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 133 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 135 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 136 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */     
/* 138 */     this.tail1.field_78795_f = 0.2F;
/* 139 */     this.tail1.field_78795_f += r4 / 2.0F;
/*     */     
/* 141 */     this.tail2.field_78795_f = 0.2F;
/* 142 */     this.tail2.field_78795_f += r4 / 2.0F;
/*     */     
/* 144 */     this.tail3.field_78795_f = 0.2F;
/* 145 */     this.tail3.field_78795_f += r4 / 2.0F;
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
/* 185 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 186 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 187 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 188 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 190 */     this.LegR.field_78796_g = 0.0F;
/* 191 */     this.LegL.field_78796_g = 0.0F;
/* 192 */     this.ArmR.field_78796_g = 0.0F;
/* 193 */     this.ArmL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbpilaf\ModelShu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */