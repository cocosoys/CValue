/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelPaparoni
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer Hair1;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer Beard;
/*     */   public ModelRenderer Hair2;
/*     */   public ModelRenderer HairR1;
/*     */   public ModelRenderer HairL1;
/*     */   public ModelRenderer HairR2;
/*     */   public ModelRenderer HairR3;
/*     */   public ModelRenderer HairL2;
/*     */   public ModelRenderer HairL3;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Body4;
/*     */   public ModelRenderer Neckerchief;
/*     */   
/*     */   public ModelPaparoni() {
/*  33 */     this.field_78090_t = 64;
/*  34 */     this.field_78089_u = 64;
/*  35 */     this.Body1 = new ModelRenderer(this, 0, 17);
/*  36 */     this.Body1.func_78793_a(0.0F, -2.0F, 0.0F);
/*  37 */     this.Body1.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 7, 4, 0.0F);
/*  38 */     this.Body3 = new ModelRenderer(this, 1, 29);
/*  39 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  40 */     this.Body3.func_78790_a(-3.5F, 7.0F, -1.6F, 7, 3, 3, 0.0F);
/*  41 */     this.ArmL = new ModelRenderer(this, 26, 36);
/*  42 */     this.ArmL.field_78809_i = true;
/*  43 */     this.ArmL.func_78793_a(4.6F, -0.5F, 0.0F);
/*  44 */     this.ArmL.func_78790_a(-1.0F, -1.8F, -2.0F, 4, 14, 4, -0.3F);
/*  45 */     this.HairR2 = new ModelRenderer(this, 56, 13);
/*  46 */     this.HairR2.func_78793_a(0.0F, 2.8F, 0.0F);
/*  47 */     this.HairR2.func_78790_a(-0.7F, -0.3F, -0.8F, 1, 2, 2, 0.0F);
/*  48 */     setRotateAngle(this.HairR2, -0.13665928F, 0.0F, 0.045553092F);
/*  49 */     this.ArmR = new ModelRenderer(this, 26, 36);
/*  50 */     this.ArmR.func_78793_a(-4.6F, -0.5F, 0.0F);
/*  51 */     this.ArmR.func_78790_a(-3.0F, -1.8F, -2.0F, 4, 14, 4, -0.3F);
/*  52 */     this.HairR3 = new ModelRenderer(this, 57, 18);
/*  53 */     this.HairR3.func_78793_a(0.0F, 1.9F, 0.0F);
/*  54 */     this.HairR3.func_78790_a(-0.6F, -0.3F, -0.5F, 1, 3, 1, 0.0F);
/*  55 */     setRotateAngle(this.HairR3, -0.13665928F, 0.0F, 0.045553092F);
/*  56 */     this.LegL = new ModelRenderer(this, 1, 45);
/*  57 */     this.LegL.field_78809_i = true;
/*  58 */     this.LegL.func_78793_a(2.0F, 11.0F, 0.0F);
/*  59 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 13, 4, 0.0F);
/*  60 */     this.HairL3 = new ModelRenderer(this, 57, 18);
/*  61 */     this.HairL3.func_78793_a(0.0F, 1.9F, 0.0F);
/*  62 */     this.HairL3.func_78790_a(-0.6F, -0.3F, -0.5F, 1, 3, 1, 0.0F);
/*  63 */     setRotateAngle(this.HairL3, -0.13665928F, 0.0F, -0.045553092F);
/*  64 */     this.HairL1 = new ModelRenderer(this, 57, 8);
/*  65 */     this.HairL1.func_78793_a(4.2F, 2.8F, -0.7F);
/*  66 */     this.HairL1.func_78790_a(-0.6F, -0.3F, -0.5F, 1, 3, 1, 0.0F);
/*  67 */     setRotateAngle(this.HairL1, -0.13665928F, 0.0F, -0.045553092F);
/*  68 */     this.Head = new ModelRenderer(this, 0, 0);
/*  69 */     this.Head.func_78793_a(0.0F, -2.0F, 0.0F);
/*  70 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  71 */     this.Hair2 = new ModelRenderer(this, 50, 1);
/*  72 */     this.Hair2.func_78793_a(0.0F, 0.0F, -3.9F);
/*  73 */     this.Hair2.func_78790_a(-1.5F, -1.4F, -2.9F, 3, 3, 3, 0.0F);
/*  74 */     this.HairL2 = new ModelRenderer(this, 56, 13);
/*  75 */     this.HairL2.func_78793_a(0.0F, 2.8F, 0.0F);
/*  76 */     this.HairL2.func_78790_a(-0.5F, -0.3F, -0.8F, 1, 2, 2, 0.0F);
/*  77 */     setRotateAngle(this.HairL2, -0.13665928F, 0.0F, -0.045553092F);
/*  78 */     this.EarL = new ModelRenderer(this, 27, 3);
/*  79 */     this.EarL.field_78809_i = true;
/*  80 */     this.EarL.func_78793_a(3.6F, -3.5F, -0.5F);
/*  81 */     this.EarL.func_78790_a(-0.5F, -1.5F, 0.0F, 5, 3, 0, 0.0F);
/*  82 */     setRotateAngle(this.EarL, 0.0F, -0.43633232F, -0.2268928F);
/*  83 */     this.Neckerchief = new ModelRenderer(this, 28, 29);
/*  84 */     this.Neckerchief.func_78793_a(0.0F, 0.0F, -1.4F);
/*  85 */     this.Neckerchief.func_78790_a(-1.5F, -0.1F, -0.2F, 3, 5, 0, 0.0F);
/*  86 */     setRotateAngle(this.Neckerchief, -0.06981317F, 0.0F, 0.0F);
/*  87 */     this.Beard = new ModelRenderer(this, 33, 12);
/*  88 */     this.Beard.func_78793_a(0.0F, -0.7F, -4.1F);
/*  89 */     this.Beard.func_78790_a(-1.5F, 0.0F, 0.0F, 3, 2, 0, 0.0F);
/*  90 */     setRotateAngle(this.Beard, -0.02094395F, 0.0F, 0.0F);
/*  91 */     this.EarR = new ModelRenderer(this, 27, 3);
/*  92 */     this.EarR.func_78793_a(-3.6F, -3.5F, -0.5F);
/*  93 */     this.EarR.func_78790_a(-4.4F, -1.5F, 0.0F, 5, 3, 0, 0.0F);
/*  94 */     setRotateAngle(this.EarR, 0.0F, 0.43633232F, 0.2268928F);
/*  95 */     this.Hair1 = new ModelRenderer(this, 33, 1);
/*  96 */     this.Hair1.func_78793_a(0.0F, -8.0F, 0.0F);
/*  97 */     this.Hair1.func_78790_a(-2.0F, -2.8F, -4.0F, 4, 3, 7, 0.0F);
/*  98 */     this.HairR1 = new ModelRenderer(this, 57, 8);
/*  99 */     this.HairR1.func_78793_a(-4.0F, 2.8F, -0.7F);
/* 100 */     this.HairR1.func_78790_a(-0.6F, -0.3F, -0.5F, 1, 3, 1, 0.0F);
/* 101 */     setRotateAngle(this.HairR1, -0.13665928F, 0.0F, 0.045553092F);
/* 102 */     this.Body2 = new ModelRenderer(this, 25, 18);
/* 103 */     this.Body2.func_78793_a(0.0F, 0.0F, -0.2F);
/* 104 */     this.Body2.func_78790_a(-3.5F, 0.0F, -1.5F, 7, 7, 3, 0.0F);
/* 105 */     this.LegR = new ModelRenderer(this, 1, 45);
/* 106 */     this.LegR.func_78793_a(-2.0F, 11.0F, 0.0F);
/* 107 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 13, 4, 0.0F);
/* 108 */     this.Body4 = new ModelRenderer(this, 0, 36);
/* 109 */     this.Body4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 110 */     this.Body4.func_78790_a(-4.0F, 10.0F, -2.0F, 8, 3, 4, 0.0F);
/* 111 */     this.Body1.func_78792_a(this.Body3);
/* 112 */     this.HairR1.func_78792_a(this.HairR2);
/* 113 */     this.HairR2.func_78792_a(this.HairR3);
/* 114 */     this.HairL2.func_78792_a(this.HairL3);
/* 115 */     this.Hair1.func_78792_a(this.HairL1);
/* 116 */     this.Hair1.func_78792_a(this.Hair2);
/* 117 */     this.HairL1.func_78792_a(this.HairL2);
/* 118 */     this.Head.func_78792_a(this.EarL);
/* 119 */     this.Body2.func_78792_a(this.Neckerchief);
/* 120 */     this.Head.func_78792_a(this.Beard);
/* 121 */     this.Head.func_78792_a(this.EarR);
/* 122 */     this.Head.func_78792_a(this.Hair1);
/* 123 */     this.Hair1.func_78792_a(this.HairR1);
/* 124 */     this.Body1.func_78792_a(this.Body2);
/* 125 */     this.Body3.func_78792_a(this.Body4);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 130 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 133 */     this.Body1.func_78785_a(f5);
/* 134 */     this.ArmL.func_78785_a(f5);
/* 135 */     this.ArmR.func_78785_a(f5);
/* 136 */     this.LegL.func_78785_a(f5);
/* 137 */     this.Head.func_78785_a(f5);
/* 138 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 144 */     modelRenderer.field_78795_f = x;
/* 145 */     modelRenderer.field_78796_g = y;
/* 146 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 150 */     int calc = par7Entity.field_70173_aa;
/* 151 */     if (calc > 100) calc -= 100; 
/* 152 */     float r = 360.0F;
/* 153 */     float r2 = 180.0F;
/* 154 */     float n4 = par4;
/* 155 */     float n5 = par5;
/*     */ 
/*     */ 
/*     */     
/* 159 */     float ex = par7Entity.field_70173_aa;
/* 160 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 161 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 163 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 164 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
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
/* 210 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 211 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 212 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 213 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 215 */     this.LegR.field_78796_g = 0.0F;
/* 216 */     this.LegL.field_78796_g = 0.0F;
/* 217 */     this.ArmR.field_78796_g = 0.0F;
/* 218 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 225 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelPaparoni.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */