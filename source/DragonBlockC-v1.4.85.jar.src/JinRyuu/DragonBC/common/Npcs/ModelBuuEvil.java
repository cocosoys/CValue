/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelBuuEvil
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer Head2;
/*     */   public ModelRenderer Jaw;
/*     */   public ModelRenderer Head3;
/*     */   public ModelRenderer Head4;
/*     */   public ModelRenderer Neck;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer CapeBase;
/*     */   public ModelRenderer Cape3R;
/*     */   public ModelRenderer Cape3L;
/*     */   public ModelRenderer CapeShoulderR;
/*     */   public ModelRenderer CapeShoulderL;
/*     */   public ModelRenderer Body3;
/*     */   
/*     */   public ModelBuuEvil() {
/*  30 */     this.field_78090_t = 64;
/*  31 */     this.field_78089_u = 64;
/*  32 */     this.ArmL = new ModelRenderer(this, 0, 25);
/*  33 */     this.ArmL.field_78809_i = true;
/*  34 */     this.ArmL.func_78793_a(5.0F, -0.5F, 0.0F);
/*  35 */     this.ArmL.func_78790_a(-1.0F, -1.5F, -1.8F, 3, 13, 4, 0.0F);
/*  36 */     this.Body1 = new ModelRenderer(this, 15, 19);
/*  37 */     this.Body1.func_78793_a(0.0F, -2.0F, 0.0F);
/*  38 */     this.Body1.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 5, 4, 0.0F);
/*  39 */     this.ArmR = new ModelRenderer(this, 0, 25);
/*  40 */     this.ArmR.func_78793_a(-5.0F, -0.5F, 0.0F);
/*  41 */     this.ArmR.func_78790_a(-2.0F, -1.5F, -1.8F, 3, 13, 4, 0.0F);
/*  42 */     this.Cape3R = new ModelRenderer(this, 43, 15);
/*  43 */     this.Cape3R.func_78793_a(-0.5F, 1.4F, -1.6F);
/*  44 */     this.Cape3R.func_78790_a(-0.5F, 0.2F, -0.4F, 2, 4, 0, 0.0F);
/*  45 */     setRotateAngle(this.Cape3R, -0.27314404F, 0.3642502F, 0.8651597F);
/*  46 */     this.LegR = new ModelRenderer(this, 0, 45);
/*  47 */     this.LegR.func_78793_a(-1.9F, 10.0F, 0.0F);
/*  48 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 14, 4, 0.0F);
/*  49 */     this.CapeBase = new ModelRenderer(this, 43, 23);
/*  50 */     this.CapeBase.func_78793_a(0.0F, 0.3F, 2.3F);
/*  51 */     this.CapeBase.func_78790_a(-4.5F, 0.0F, -0.3F, 9, 19, 1, 0.0F);
/*  52 */     setRotateAngle(this.CapeBase, 0.090757124F, 0.0F, 0.0F);
/*  53 */     this.CapeShoulderL = new ModelRenderer(this, 44, 15);
/*  54 */     this.CapeShoulderL.field_78809_i = true;
/*  55 */     this.CapeShoulderL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  56 */     this.CapeShoulderL.func_78790_a(2.4F, -0.1F, -2.3F, 3, 1, 5, 0.0F);
/*  57 */     this.Jaw = new ModelRenderer(this, 33, 8);
/*  58 */     this.Jaw.func_78793_a(0.0F, -3.1F, 0.0F);
/*  59 */     this.Jaw.func_78790_a(-3.0F, 2.9F, -3.4F, 6, 2, 3, 0.0F);
/*  60 */     this.CapeShoulderR = new ModelRenderer(this, 44, 15);
/*  61 */     this.CapeShoulderR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  62 */     this.CapeShoulderR.func_78790_a(-5.4F, -0.1F, -2.3F, 3, 1, 5, 0.0F);
/*  63 */     this.Body2 = new ModelRenderer(this, 17, 29);
/*  64 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  65 */     this.Body2.func_78790_a(-3.0F, 5.0F, -1.7F, 6, 4, 3, 0.0F);
/*  66 */     this.Cape3L = new ModelRenderer(this, 43, 15);
/*  67 */     this.Cape3L.field_78809_i = true;
/*  68 */     this.Cape3L.func_78793_a(0.4F, 1.4F, -1.6F);
/*  69 */     this.Cape3L.func_78790_a(-1.6F, 0.2F, -0.4F, 2, 4, 0, 0.0F);
/*  70 */     setRotateAngle(this.Cape3L, -0.31869712F, -0.40142572F, -0.8196066F);
/*  71 */     this.Head = new ModelRenderer(this, 0, 0);
/*  72 */     this.Head.func_78793_a(0.0F, -4.4F, 0.0F);
/*  73 */     this.Head.func_78790_a(-4.0F, -6.2F, -4.4F, 8, 7, 8, -1.0F);
/*  74 */     this.Body3 = new ModelRenderer(this, 15, 37);
/*  75 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  76 */     this.Body3.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 3, 4, 0.0F);
/*  77 */     this.LegL = new ModelRenderer(this, 0, 45);
/*  78 */     this.LegL.field_78809_i = true;
/*  79 */     this.LegL.func_78793_a(1.9F, 10.0F, 0.0F);
/*  80 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 14, 4, 0.0F);
/*  81 */     this.Head4 = new ModelRenderer(this, 44, 0);
/*  82 */     this.Head4.func_78793_a(0.0F, -1.6F, -0.2F);
/*  83 */     this.Head4.func_78790_a(-0.5F, -1.9F, -0.8F, 1, 2, 1, 0.0F);
/*  84 */     setRotateAngle(this.Head4, -0.4098033F, 0.0F, 0.0F);
/*  85 */     this.Head2 = new ModelRenderer(this, 25, 0);
/*  86 */     this.Head2.func_78793_a(0.0F, -4.8F, -2.0F);
/*  87 */     this.Head2.func_78790_a(-1.0F, -3.8F, -1.3F, 2, 4, 3, 0.0F);
/*  88 */     setRotateAngle(this.Head2, -0.22759093F, 0.0F, 0.0F);
/*  89 */     this.Neck = new ModelRenderer(this, 2, 19);
/*  90 */     this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
/*  91 */     this.Neck.func_78790_a(-2.0F, -2.8F, -0.5F, 4, 3, 2, 0.0F);
/*  92 */     this.Head3 = new ModelRenderer(this, 36, 0);
/*  93 */     this.Head3.func_78793_a(0.0F, -3.3F, -0.1F);
/*  94 */     this.Head3.func_78790_a(-0.5F, -1.9F, -1.1F, 1, 2, 2, 0.0F);
/*  95 */     setRotateAngle(this.Head3, -0.4553564F, 0.0F, 0.0F);
/*  96 */     this.Body1.func_78792_a(this.Cape3R);
/*  97 */     this.Body1.func_78792_a(this.CapeBase);
/*  98 */     this.Body1.func_78792_a(this.CapeShoulderL);
/*  99 */     this.Head.func_78792_a(this.Jaw);
/* 100 */     this.Body1.func_78792_a(this.CapeShoulderR);
/* 101 */     this.Body1.func_78792_a(this.Body2);
/* 102 */     this.Body1.func_78792_a(this.Cape3L);
/* 103 */     this.Body2.func_78792_a(this.Body3);
/* 104 */     this.Head3.func_78792_a(this.Head4);
/* 105 */     this.Head.func_78792_a(this.Head2);
/* 106 */     this.Body1.func_78792_a(this.Neck);
/* 107 */     this.Head2.func_78792_a(this.Head3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 112 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 115 */     this.LegL.func_78785_a(f5);
/* 116 */     this.Head.func_78785_a(f5);
/* 117 */     this.ArmL.func_78785_a(f5);
/* 118 */     this.ArmR.func_78785_a(f5);
/* 119 */     this.Body1.func_78785_a(f5);
/* 120 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 125 */     modelRenderer.field_78795_f = x;
/* 126 */     modelRenderer.field_78796_g = y;
/* 127 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 131 */     int calc = par7Entity.field_70173_aa;
/* 132 */     if (calc > 100) calc -= 100; 
/* 133 */     float r = 360.0F;
/* 134 */     float r2 = 180.0F;
/* 135 */     float n4 = par4;
/* 136 */     float n5 = par5;
/*     */     
/* 138 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 139 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 140 */     float ex = par7Entity.field_70173_aa;
/* 141 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 142 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 144 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 145 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
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
/* 175 */     float rota = -MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 176 */     if (rota > 0.0F) rota *= -1.0F; 
/* 177 */     this.CapeBase.field_78795_f = -0.23F + rota;
/* 178 */     if (0.0F > this.CapeBase.field_78795_f) this.CapeBase.field_78795_f *= -1.0F; 
/* 179 */     this.CapeBase.field_78796_g = 0.0F;
/*     */ 
/*     */     
/* 182 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 183 */     this.LegL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 184 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 185 */     this.ArmL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 186 */     this.LegR.field_78796_g = 0.0F;
/* 187 */     this.LegL.field_78796_g = 0.0F;
/* 188 */     this.ArmR.field_78796_g = 0.0F;
/* 189 */     this.ArmL.field_78796_g = 0.0F;
/* 190 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelBuuEvil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */