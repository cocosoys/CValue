/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelZamasu
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer Hair1;
/*     */   public ModelRenderer earR;
/*     */   public ModelRenderer earL;
/*     */   public ModelRenderer Hair2;
/*     */   public ModelRenderer Hair3;
/*     */   public ModelRenderer Hair4;
/*     */   public ModelRenderer Hair5;
/*     */   public ModelRenderer earR2;
/*     */   public ModelRenderer earL2;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer ClothF;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer ShoulderR;
/*     */   public ModelRenderer ShoulderL;
/*     */   
/*     */   public ModelZamasu() {
/*  32 */     this.field_78090_t = 64;
/*  33 */     this.field_78089_u = 64;
/*  34 */     this.earR2 = new ModelRenderer(this, 30, 1);
/*  35 */     this.earR2.func_78793_a(-0.5F, 1.2F, 0.0F);
/*  36 */     this.earR2.func_78790_a(-0.4F, -0.4F, -0.5F, 1, 1, 1, 0.0F);
/*  37 */     setRotateAngle(this.earR2, 0.0F, -0.34906584F, -0.34906584F);
/*  38 */     this.LegL = new ModelRenderer(this, 0, 45);
/*  39 */     this.LegL.field_78809_i = true;
/*  40 */     this.LegL.func_78793_a(1.9F, 11.0F, 0.0F);
/*  41 */     this.LegL.func_78790_a(-1.9F, 0.0F, -2.0F, 4, 13, 4, 0.0F);
/*  42 */     this.ShoulderL = new ModelRenderer(this, 3, 18);
/*  43 */     this.ShoulderL.field_78809_i = true;
/*  44 */     this.ShoulderL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  45 */     this.ShoulderL.func_78790_a(-1.0F, -0.9F, -1.8F, 6, 4, 4, 0.0F);
/*  46 */     this.Hair2 = new ModelRenderer(this, 46, 6);
/*  47 */     this.Hair2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  48 */     this.Hair2.func_78790_a(-1.3F, -11.2F, -5.0F, 2, 2, 6, 0.0F);
/*  49 */     this.earL2 = new ModelRenderer(this, 30, 1);
/*  50 */     this.earL2.field_78809_i = true;
/*  51 */     this.earL2.func_78793_a(0.3F, 1.2F, 0.0F);
/*  52 */     this.earL2.func_78790_a(-0.5F, -0.4F, -0.5F, 1, 1, 1, 0.0F);
/*  53 */     setRotateAngle(this.earL2, 0.0F, 0.34906584F, 0.34906584F);
/*  54 */     this.ClothF = new ModelRenderer(this, 25, 51);
/*  55 */     this.ClothF.func_78793_a(0.0F, 9.0F, -2.1F);
/*  56 */     this.ClothF.func_78790_a(-2.0F, 0.0F, 0.1F, 4, 11, 0, 0.0F);
/*  57 */     setRotateAngle(this.ClothF, -0.061086524F, 0.0F, 0.0F);
/*  58 */     this.Hair1 = new ModelRenderer(this, 33, 0);
/*  59 */     this.Hair1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  60 */     this.Hair1.func_78790_a(-1.4F, -9.7F, -4.0F, 3, 3, 6, 0.0F);
/*  61 */     this.Body3 = new ModelRenderer(this, 20, 43);
/*  62 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  63 */     this.Body3.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 3, 4, 0.0F);
/*  64 */     this.Head = new ModelRenderer(this, 0, 0);
/*  65 */     this.Head.func_78793_a(0.0F, -1.1F, 0.0F);
/*  66 */     this.Head.func_78790_a(-4.0F, -7.3F, -4.0F, 8, 8, 8, -0.5F);
/*  67 */     this.Body2 = new ModelRenderer(this, 23, 36);
/*  68 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  69 */     this.Body2.func_78790_a(-3.5F, 7.0F, -1.7F, 7, 2, 3, 0.0F);
/*  70 */     this.earR = new ModelRenderer(this, 0, 1);
/*  71 */     this.earR.func_78793_a(-3.2F, -1.9F, -1.5F);
/*  72 */     this.earR.func_78790_a(-4.2F, -2.1F, 0.0F, 4, 3, 0, 0.0F);
/*  73 */     setRotateAngle(this.earR, 0.1134464F, 0.5235988F, 0.34906584F);
/*  74 */     this.ArmR = new ModelRenderer(this, 0, 27);
/*  75 */     this.ArmR.func_78793_a(-5.0F, -0.1F, 0.0F);
/*  76 */     this.ArmR.func_78790_a(-1.9F, -0.8F, -1.8F, 3, 12, 4, -0.1F);
/*  77 */     this.Hair3 = new ModelRenderer(this, 46, 0);
/*  78 */     this.Hair3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  79 */     this.Hair3.func_78790_a(-0.7F, -12.0F, -1.7F, 1, 1, 2, 0.0F);
/*  80 */     this.ShoulderR = new ModelRenderer(this, 3, 18);
/*  81 */     this.ShoulderR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  82 */     this.ShoulderR.func_78790_a(-5.0F, -0.9F, -1.8F, 6, 4, 4, 0.0F);
/*  83 */     this.Hair4 = new ModelRenderer(this, 46, 6);
/*  84 */     this.Hair4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  85 */     this.Hair4.func_78790_a(-1.5F, -10.6F, -0.6F, 2, 3, 6, 0.0F);
/*  86 */     setRotateAngle(this.Hair4, 0.8651597F, 0.0F, 0.0F);
/*  87 */     this.Body1 = new ModelRenderer(this, 20, 23);
/*  88 */     this.Body1.func_78793_a(0.0F, -1.0F, 0.0F);
/*  89 */     this.Body1.func_78790_a(-4.0F, 0.0F, -1.8F, 8, 7, 4, 0.0F);
/*  90 */     this.earL = new ModelRenderer(this, 0, 4);
/*  91 */     this.earL.func_78793_a(3.2F, -1.9F, -1.5F);
/*  92 */     this.earL.func_78790_a(0.2F, -2.1F, 0.0F, 4, 3, 0, 0.0F);
/*  93 */     setRotateAngle(this.earL, 0.1134464F, -0.5235988F, -0.34906584F);
/*  94 */     this.LegR = new ModelRenderer(this, 0, 45);
/*  95 */     this.LegR.func_78793_a(-1.9F, 11.0F, 0.0F);
/*  96 */     this.LegR.func_78790_a(-2.1F, 0.0F, -2.0F, 4, 13, 4, 0.0F);
/*  97 */     this.Hair5 = new ModelRenderer(this, 46, 0);
/*  98 */     this.Hair5.func_78793_a(0.0F, 0.0F, 0.0F);
/*  99 */     this.Hair5.func_78790_a(-1.3F, -9.2F, -1.8F, 1, 2, 2, 0.0F);
/* 100 */     this.ArmL = new ModelRenderer(this, 0, 27);
/* 101 */     this.ArmL.field_78809_i = true;
/* 102 */     this.ArmL.func_78793_a(5.0F, -0.1F, 0.0F);
/* 103 */     this.ArmL.func_78790_a(-1.1F, -0.8F, -1.8F, 3, 12, 4, -0.1F);
/* 104 */     this.earR.func_78792_a(this.earR2);
/* 105 */     this.ArmL.func_78792_a(this.ShoulderL);
/* 106 */     this.Hair1.func_78792_a(this.Hair2);
/* 107 */     this.earL.func_78792_a(this.earL2);
/* 108 */     this.Body1.func_78792_a(this.ClothF);
/* 109 */     this.Head.func_78792_a(this.Hair1);
/* 110 */     this.Body2.func_78792_a(this.Body3);
/* 111 */     this.Body1.func_78792_a(this.Body2);
/* 112 */     this.Head.func_78792_a(this.earR);
/* 113 */     this.Hair1.func_78792_a(this.Hair3);
/* 114 */     this.ArmR.func_78792_a(this.ShoulderR);
/* 115 */     this.Hair1.func_78792_a(this.Hair4);
/* 116 */     this.Head.func_78792_a(this.earL);
/* 117 */     this.Hair4.func_78792_a(this.Hair5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 122 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 125 */     this.LegL.func_78785_a(f5);
/* 126 */     this.Head.func_78785_a(f5);
/* 127 */     this.ArmL.func_78785_a(f5);
/* 128 */     this.ArmR.func_78785_a(f5);
/* 129 */     this.Body1.func_78785_a(f5);
/* 130 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 135 */     modelRenderer.field_78795_f = x;
/* 136 */     modelRenderer.field_78796_g = y;
/* 137 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 141 */     int calc = par7Entity.field_70173_aa;
/* 142 */     if (calc > 100) calc -= 100; 
/* 143 */     float r = 360.0F;
/* 144 */     float r2 = 180.0F;
/* 145 */     float n4 = par4;
/* 146 */     float n5 = par5;
/*     */     
/* 148 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 149 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 150 */     float ex = par7Entity.field_70173_aa;
/* 151 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 152 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 154 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 155 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
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
/* 186 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 187 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 188 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 189 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 191 */     this.LegR.field_78796_g = 0.0F;
/* 192 */     this.LegL.field_78796_g = 0.0F;
/* 193 */     this.ArmR.field_78796_g = 0.0F;
/* 194 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */     
/* 197 */     this.ClothF.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/*     */ 
/*     */ 
/*     */     
/* 201 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelZamasu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */