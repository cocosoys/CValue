/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelNarirama
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR1;
/*     */   public ModelRenderer ArmL1;
/*     */   public ModelRenderer LegR1;
/*     */   public ModelRenderer LegL1;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer EarR1;
/*     */   public ModelRenderer Eye;
/*     */   public ModelRenderer EarR2;
/*     */   public ModelRenderer EarR2_1;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer Chest1;
/*     */   public ModelRenderer Body4;
/*     */   public ModelRenderer Chest2;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmR3;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer ArmL3;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer LegR3;
/*     */   public ModelRenderer LegL2;
/*     */   public ModelRenderer LegL3;
/*     */   
/*     */   public ModelNarirama() {
/*  36 */     this.field_78090_t = 128;
/*  37 */     this.field_78089_u = 64;
/*  38 */     this.LegR1 = new ModelRenderer(this, 67, 3);
/*  39 */     this.LegR1.func_78793_a(-3.0F, 5.5F, 0.0F);
/*  40 */     this.LegR1.func_78790_a(-2.5F, 0.0F, -2.5F, 5, 8, 5, 0.0F);
/*  41 */     this.LegL1 = new ModelRenderer(this, 67, 3);
/*  42 */     this.LegL1.field_78809_i = true;
/*  43 */     this.LegL1.func_78793_a(3.0F, 5.5F, 0.0F);
/*  44 */     this.LegL1.func_78790_a(-2.5F, 0.0F, -2.5F, 5, 8, 5, 0.0F);
/*  45 */     this.Body2 = new ModelRenderer(this, 0, 31);
/*  46 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  47 */     this.Body2.func_78790_a(-5.5F, 10.0F, -3.0F, 11, 2, 6, 0.0F);
/*  48 */     this.ArmR1 = new ModelRenderer(this, 101, 2);
/*  49 */     this.ArmR1.func_78793_a(-7.0F, -11.0F, 0.0F);
/*  50 */     this.ArmR1.func_78790_a(-6.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
/*  51 */     this.Chest2 = new ModelRenderer(this, 43, 23);
/*  52 */     this.Chest2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  53 */     this.Chest2.func_78790_a(-2.5F, 2.8F, -5.2F, 5, 5, 1, 0.0F);
/*  54 */     this.ArmL1 = new ModelRenderer(this, 101, 2);
/*  55 */     this.ArmL1.field_78809_i = true;
/*  56 */     this.ArmL1.func_78793_a(7.0F, -11.0F, 0.0F);
/*  57 */     this.ArmL1.func_78790_a(0.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
/*  58 */     this.Eye = new ModelRenderer(this, 27, 0);
/*  59 */     this.Eye.func_78793_a(0.0F, -2.0F, -2.2F);
/*  60 */     this.Eye.func_78790_a(-2.5F, -1.1F, -0.8F, 5, 3, 1, 0.0F);
/*  61 */     this.ArmR2 = new ModelRenderer(this, 102, 15);
/*  62 */     this.ArmR2.func_78793_a(-2.8F, 2.9F, 0.0F);
/*  63 */     this.ArmR2.func_78790_a(-2.7F, -0.1F, -2.5F, 5, 8, 5, 0.0F);
/*  64 */     this.EarR2 = new ModelRenderer(this, 50, 6);
/*  65 */     this.EarR2.func_78793_a(0.0F, 0.5F, 0.0F);
/*  66 */     this.EarR2.func_78790_a(0.0F, -2.6F, 0.0F, 1, 2, 0, 0.0F);
/*  67 */     setRotateAngle(this.EarR2, 0.0F, 0.0F, -1.0168288F);
/*  68 */     this.ArmL3 = new ModelRenderer(this, 101, 29);
/*  69 */     this.ArmL3.field_78809_i = true;
/*  70 */     this.ArmL3.func_78793_a(0.0F, 7.3F, -0.5F);
/*  71 */     this.ArmL3.func_78790_a(-2.7F, 0.0F, -2.4F, 6, 10, 6, 0.0F);
/*  72 */     this.LegR2 = new ModelRenderer(this, 66, 17);
/*  73 */     this.LegR2.func_78793_a(0.0F, 8.0F, 0.0F);
/*  74 */     this.LegR2.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 10, 6, 0.0F);
/*  75 */     this.EarR1 = new ModelRenderer(this, 38, 4);
/*  76 */     this.EarR1.func_78793_a(-3.0F, -3.8F, 0.4F);
/*  77 */     this.EarR1.func_78790_a(-1.0F, -1.5F, -1.6F, 2, 3, 3, 0.0F);
/*  78 */     this.Body4 = new ModelRenderer(this, 0, 50);
/*  79 */     this.Body4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  80 */     this.Body4.func_78790_a(-5.5F, 16.0F, -3.0F, 11, 4, 6, 0.0F);
/*  81 */     this.LegR3 = new ModelRenderer(this, 61, 35);
/*  82 */     this.LegR3.func_78793_a(0.0F, 8.5F, 0.0F);
/*  83 */     this.LegR3.func_78790_a(-2.5F, 0.0F, -6.0F, 5, 2, 11, 0.0F);
/*  84 */     this.EarR2_1 = new ModelRenderer(this, 49, 4);
/*  85 */     this.EarR2_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  86 */     this.EarR2_1.func_78790_a(-0.5F, -4.6F, 0.0F, 2, 2, 0, 0.0F);
/*  87 */     this.Body1 = new ModelRenderer(this, 0, 13);
/*  88 */     this.Body1.func_78793_a(0.0F, -14.5F, 0.0F);
/*  89 */     this.Body1.func_78790_a(-7.0F, 0.0F, -3.3F, 14, 10, 7, 0.0F);
/*  90 */     this.LegL2 = new ModelRenderer(this, 66, 17);
/*  91 */     this.LegL2.func_78793_a(0.0F, 8.0F, 0.0F);
/*  92 */     this.LegL2.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 10, 6, 0.0F);
/*  93 */     this.EarL = new ModelRenderer(this, 29, 5);
/*  94 */     this.EarL.field_78809_i = true;
/*  95 */     this.EarL.func_78793_a(3.0F, -4.2F, 0.4F);
/*  96 */     this.EarL.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/*  97 */     this.Chest1 = new ModelRenderer(this, 43, 14);
/*  98 */     this.Chest1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  99 */     this.Chest1.func_78790_a(-3.0F, 1.8F, -4.3F, 6, 7, 1, 0.0F);
/* 100 */     this.ArmL2 = new ModelRenderer(this, 102, 15);
/* 101 */     this.ArmL2.field_78809_i = true;
/* 102 */     this.ArmL2.func_78793_a(2.8F, 2.9F, 0.0F);
/* 103 */     this.ArmL2.func_78790_a(-2.2F, -0.1F, -2.5F, 5, 8, 5, 0.0F);
/* 104 */     this.Head = new ModelRenderer(this, 0, 0);
/* 105 */     this.Head.func_78793_a(0.0F, -14.5F, -0.3F);
/* 106 */     this.Head.func_78790_a(-3.5F, -5.0F, -2.3F, 7, 5, 6, 0.0F);
/* 107 */     this.ArmR3 = new ModelRenderer(this, 101, 29);
/* 108 */     this.ArmR3.func_78793_a(0.0F, 7.3F, -0.5F);
/* 109 */     this.ArmR3.func_78790_a(-3.2F, 0.0F, -2.4F, 6, 10, 6, 0.0F);
/* 110 */     this.Body3 = new ModelRenderer(this, 0, 40);
/* 111 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 112 */     this.Body3.func_78790_a(-4.5F, 12.0F, -2.8F, 9, 4, 5, 0.0F);
/* 113 */     this.LegL3 = new ModelRenderer(this, 61, 35);
/* 114 */     this.LegL3.func_78793_a(0.0F, 8.5F, 0.0F);
/* 115 */     this.LegL3.func_78790_a(-2.5F, 0.0F, -6.0F, 5, 2, 11, 0.0F);
/* 116 */     this.Body1.func_78792_a(this.Body2);
/* 117 */     this.Chest1.func_78792_a(this.Chest2);
/* 118 */     this.Head.func_78792_a(this.Eye);
/* 119 */     this.ArmR1.func_78792_a(this.ArmR2);
/* 120 */     this.EarR1.func_78792_a(this.EarR2);
/* 121 */     this.ArmL2.func_78792_a(this.ArmL3);
/* 122 */     this.LegR1.func_78792_a(this.LegR2);
/* 123 */     this.Head.func_78792_a(this.EarR1);
/* 124 */     this.Body3.func_78792_a(this.Body4);
/* 125 */     this.LegR2.func_78792_a(this.LegR3);
/* 126 */     this.EarR2.func_78792_a(this.EarR2_1);
/* 127 */     this.LegL1.func_78792_a(this.LegL2);
/* 128 */     this.Head.func_78792_a(this.EarL);
/* 129 */     this.Body3.func_78792_a(this.Chest1);
/* 130 */     this.ArmL1.func_78792_a(this.ArmL2);
/* 131 */     this.ArmR2.func_78792_a(this.ArmR3);
/* 132 */     this.Body2.func_78792_a(this.Body3);
/* 133 */     this.LegL2.func_78792_a(this.LegL3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 138 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 141 */     this.LegR1.func_78785_a(f5);
/* 142 */     this.LegL1.func_78785_a(f5);
/* 143 */     this.ArmR1.func_78785_a(f5);
/* 144 */     this.ArmL1.func_78785_a(f5);
/* 145 */     this.Body1.func_78785_a(f5);
/* 146 */     this.Head.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
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
/*     */ 
/*     */     
/* 167 */     float ex = par7Entity.field_70173_aa;
/* 168 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 169 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 171 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 172 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
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
/* 218 */     this.LegR1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 219 */     this.LegL1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 220 */     this.ArmR1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 221 */     this.ArmL1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 223 */     this.LegR1.field_78796_g = 0.0F;
/* 224 */     this.LegL1.field_78796_g = 0.0F;
/* 225 */     this.ArmR1.field_78796_g = 0.0F;
/* 226 */     this.ArmL1.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 233 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelNarirama.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */