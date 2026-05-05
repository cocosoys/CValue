/*     */ package JinRyuu.DragonBC.common.Npcs.dbtournament;
/*     */ 
/*     */ import JinRyuu.JRMCore.client.JGRenderHelper;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ public class ModelGiran
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer tail1;
/*     */   public ModelRenderer Head2;
/*     */   public ModelRenderer Nose;
/*     */   public ModelRenderer Head3;
/*     */   public ModelRenderer NoseHorn;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Chest;
/*     */   public ModelRenderer WingR;
/*     */   public ModelRenderer WingL;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer WingR_1;
/*     */   public ModelRenderer WingL_1;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer LegL2;
/*     */   public ModelRenderer tail2;
/*     */   public ModelRenderer tail3;
/*     */   public ModelRenderer tail4;
/*     */   public ModelRenderer tail5;
/*     */   
/*     */   public ModelGiran() {
/*  42 */     this.field_78090_t = 128;
/*  43 */     this.field_78089_u = 128;
/*  44 */     this.tail5 = new ModelRenderer(this, 111, 109);
/*  45 */     this.tail5.func_78793_a(0.0F, 0.0F, 5.9F);
/*  46 */     this.tail5.func_78790_a(-1.0F, -1.0F, 0.0F, 2, 2, 5, 0.0F);
/*  47 */     this.ArmL2 = new ModelRenderer(this, 90, 19);
/*  48 */     this.ArmL2.field_78809_i = true;
/*  49 */     this.ArmL2.func_78793_a(0.8F, 7.1F, -0.3F);
/*  50 */     this.ArmL2.func_78790_a(-2.8F, -0.5F, -2.5F, 6, 9, 6, 0.0F);
/*  51 */     setRotateAngle(this.ArmL2, -0.4098033F, 0.0F, 0.08726646F);
/*  52 */     this.Body2 = new ModelRenderer(this, 0, 46);
/*  53 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  54 */     this.Body2.func_78790_a(-9.0F, 7.0F, -4.1F, 18, 11, 11, 0.0F);
/*  55 */     this.Body1 = new ModelRenderer(this, 0, 26);
/*  56 */     this.Body1.func_78793_a(0.0F, -2.9F, 0.0F);
/*  57 */     this.Body1.func_78790_a(-8.0F, 0.0F, -2.4F, 16, 7, 9, 0.0F);
/*  58 */     this.Head3 = new ModelRenderer(this, 76, 4);
/*  59 */     this.Head3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  60 */     this.Head3.func_78790_a(-0.5F, -3.6F, 0.8F, 1, 2, 4, 0.0F);
/*  61 */     this.LegR2 = new ModelRenderer(this, 91, 64);
/*  62 */     this.LegR2.func_78793_a(0.0F, 10.0F, 1.9F);
/*  63 */     this.LegR2.func_78790_a(-3.5F, 0.0F, -5.8F, 7, 3, 9, 0.0F);
/*  64 */     this.tail2 = new ModelRenderer(this, 67, 116);
/*  65 */     this.tail2.func_78793_a(0.0F, -0.2F, 5.9F);
/*  66 */     this.tail2.func_78790_a(-2.5F, -2.5F, 0.0F, 5, 5, 5, 0.0F);
/*  67 */     this.LegL2 = new ModelRenderer(this, 91, 64);
/*  68 */     this.LegL2.func_78793_a(0.0F, 10.0F, 1.9F);
/*  69 */     this.LegL2.func_78790_a(-3.5F, 0.0F, -5.8F, 7, 3, 9, 0.0F);
/*  70 */     this.Chest = new ModelRenderer(this, 53, 43);
/*  71 */     this.Chest.func_78793_a(0.0F, 4.2F, -1.7F);
/*  72 */     this.Chest.func_78790_a(-7.0F, -2.1F, -1.4F, 14, 5, 2, 0.0F);
/*  73 */     setRotateAngle(this.Chest, -0.091106184F, 0.0F, 0.0F);
/*  74 */     this.ArmL = new ModelRenderer(this, 92, 3);
/*  75 */     this.ArmL.field_78809_i = true;
/*  76 */     this.ArmL.func_78793_a(8.8F, 0.0F, 2.0F);
/*  77 */     this.ArmL.func_78790_a(-1.5F, -2.0F, -2.5F, 5, 9, 5, 0.0F);
/*  78 */     setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.38397244F);
/*  79 */     this.tail3 = new ModelRenderer(this, 88, 116);
/*  80 */     this.tail3.func_78793_a(0.0F, 0.0F, 4.9F);
/*  81 */     this.tail3.func_78790_a(-2.0F, -2.0F, 0.0F, 4, 4, 6, 0.0F);
/*  82 */     this.tail4 = new ModelRenderer(this, 109, 117);
/*  83 */     this.tail4.func_78793_a(0.0F, 0.0F, 5.9F);
/*  84 */     this.tail4.func_78790_a(-1.5F, -1.5F, 0.0F, 3, 3, 6, 0.0F);
/*  85 */     this.LegR = new ModelRenderer(this, 91, 43);
/*  86 */     this.LegR.func_78793_a(-7.2F, 11.0F, 1.0F);
/*  87 */     this.LegR.func_78790_a(-3.5F, 0.0F, -3.5F, 7, 10, 8, 0.0F);
/*  88 */     this.tail1 = new ModelRenderer(this, 42, 114);
/*  89 */     this.tail1.func_78793_a(0.0F, 11.5F, 6.5F);
/*  90 */     this.tail1.func_78790_a(-3.0F, -3.0F, 0.0F, 6, 6, 6, 0.0F);
/*  91 */     this.Nose = new ModelRenderer(this, 35, 2);
/*  92 */     this.Nose.func_78793_a(0.0F, -2.4F, -2.5F);
/*  93 */     this.Nose.func_78790_a(-3.0F, -1.0F, -6.1F, 6, 4, 6, 0.0F);
/*  94 */     this.Head2 = new ModelRenderer(this, 61, 2);
/*  95 */     this.Head2.func_78793_a(0.0F, -6.3F, 2.7F);
/*  96 */     this.Head2.func_78790_a(-0.5F, -3.6F, -5.2F, 1, 4, 6, 0.0F);
/*  97 */     setRotateAngle(this.Head2, 0.4553564F, 0.0F, 0.0F);
/*  98 */     this.WingL_1 = new ModelRenderer(this, 2, 88);
/*  99 */     this.WingL_1.field_78809_i = true;
/* 100 */     this.WingL_1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 101 */     this.WingL_1.func_78790_a(0.0F, -10.9F, 0.01F, 19, 19, 0, 0.0F);
/* 102 */     this.ArmR2 = new ModelRenderer(this, 90, 19);
/* 103 */     this.ArmR2.func_78793_a(-0.6F, 7.1F, -0.3F);
/* 104 */     this.ArmR2.func_78790_a(-3.5F, -0.5F, -2.5F, 6, 9, 6, 0.0F);
/* 105 */     setRotateAngle(this.ArmR2, -0.4098033F, 0.0F, -0.08726646F);
/* 106 */     this.ArmR = new ModelRenderer(this, 92, 3);
/* 107 */     this.ArmR.func_78793_a(-8.8F, 0.0F, 2.0F);
/* 108 */     this.ArmR.func_78790_a(-3.5F, -2.0F, -2.5F, 5, 9, 5, 0.0F);
/* 109 */     setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.38397244F);
/* 110 */     this.WingR_1 = new ModelRenderer(this, 2, 88);
/* 111 */     this.WingR_1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 112 */     this.WingR_1.func_78790_a(-19.0F, -10.9F, 0.01F, 19, 19, 0, 0.0F);
/* 113 */     this.NoseHorn = new ModelRenderer(this, 32, 2);
/* 114 */     this.NoseHorn.func_78793_a(0.0F, -0.3F, -3.8F);
/* 115 */     this.NoseHorn.func_78790_a(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
/* 116 */     this.WingR = new ModelRenderer(this, 2, 107);
/* 117 */     this.WingR.func_78793_a(-2.9F, 4.0F, 6.9F);
/* 118 */     this.WingR.func_78790_a(-19.0F, -10.7F, 0.0F, 19, 19, 0, 0.0F);
/* 119 */     setRotateAngle(this.WingR, 0.0F, 0.17453292F, 0.0F);
/* 120 */     this.WingL = new ModelRenderer(this, 2, 107);
/* 121 */     this.WingL.field_78809_i = true;
/* 122 */     this.WingL.func_78793_a(2.9F, 4.0F, 6.9F);
/* 123 */     this.WingL.func_78790_a(0.0F, -10.7F, 0.0F, 19, 19, 0, 0.0F);
/* 124 */     setRotateAngle(this.WingL, 0.0F, -0.17453292F, 0.0F);
/* 125 */     this.LegL = new ModelRenderer(this, 91, 43);
/* 126 */     this.LegL.field_78809_i = true;
/* 127 */     this.LegL.func_78793_a(7.2F, 11.0F, 1.0F);
/* 128 */     this.LegL.func_78790_a(-3.5F, 0.0F, -3.5F, 7, 10, 8, 0.0F);
/* 129 */     this.Head = new ModelRenderer(this, 0, 0);
/* 130 */     this.Head.func_78793_a(0.0F, -2.2F, 0.2F);
/* 131 */     this.Head.func_78790_a(-4.5F, -7.2F, -4.0F, 9, 7, 8, 0.0F);
/* 132 */     this.Body3 = new ModelRenderer(this, 0, 73);
/* 133 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 134 */     this.Body3.func_78790_a(-7.0F, 18.0F, -3.2F, 14, 2, 9, 0.0F);
/* 135 */     this.tail4.func_78792_a(this.tail5);
/* 136 */     this.ArmL.func_78792_a(this.ArmL2);
/* 137 */     this.Body1.func_78792_a(this.Body2);
/* 138 */     this.Head2.func_78792_a(this.Head3);
/* 139 */     this.LegR.func_78792_a(this.LegR2);
/* 140 */     this.tail1.func_78792_a(this.tail2);
/* 141 */     this.LegL.func_78792_a(this.LegL2);
/* 142 */     this.Body1.func_78792_a(this.Chest);
/* 143 */     this.tail2.func_78792_a(this.tail3);
/* 144 */     this.tail3.func_78792_a(this.tail4);
/* 145 */     this.Head.func_78792_a(this.Nose);
/* 146 */     this.Head.func_78792_a(this.Head2);
/* 147 */     this.WingL.func_78792_a(this.WingL_1);
/* 148 */     this.ArmR.func_78792_a(this.ArmR2);
/* 149 */     this.WingR.func_78792_a(this.WingR_1);
/* 150 */     this.Nose.func_78792_a(this.NoseHorn);
/* 151 */     this.Body1.func_78792_a(this.WingR);
/* 152 */     this.Body1.func_78792_a(this.WingL);
/* 153 */     this.Body2.func_78792_a(this.Body3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 158 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 160 */     GL11.glPushMatrix();
/* 161 */     float F = 1.5F;
/* 162 */     JGRenderHelper.modelScalePositionHelper(1.5F);
/*     */     
/* 164 */     this.Head.func_78785_a(f5);
/* 165 */     this.Body1.func_78785_a(f5);
/* 166 */     this.ArmR.func_78785_a(f5);
/* 167 */     this.ArmL.func_78785_a(f5);
/* 168 */     this.LegL.func_78785_a(f5);
/* 169 */     this.LegR.func_78785_a(f5);
/* 170 */     this.tail1.func_78785_a(f5);
/*     */     
/* 172 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 176 */     modelRenderer.field_78795_f = x;
/* 177 */     modelRenderer.field_78796_g = y;
/* 178 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 182 */     int calc = par7Entity.field_70173_aa;
/* 183 */     if (calc > 100) calc -= 100; 
/* 184 */     float r = 360.0F;
/* 185 */     float r2 = 180.0F;
/* 186 */     float n4 = par4;
/* 187 */     float n5 = par5;
/*     */     
/* 189 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 190 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 191 */     float ex = par7Entity.field_70173_aa;
/* 192 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 193 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 195 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 196 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */     
/* 198 */     this.tail1.field_78795_f = 0.2F;
/* 199 */     this.tail1.field_78795_f += r4 / 2.0F;
/*     */     
/* 201 */     this.tail2.field_78795_f = 0.2F;
/* 202 */     this.tail2.field_78795_f += r4 / 2.0F;
/*     */     
/* 204 */     this.tail3.field_78795_f = 0.2F;
/* 205 */     this.tail3.field_78795_f += r4 / 2.0F;
/*     */     
/* 207 */     this.tail4.field_78795_f = 0.2F;
/* 208 */     this.tail4.field_78795_f += r4 / 2.0F;
/*     */     
/* 210 */     this.tail5.field_78796_g = 0.2F;
/* 211 */     this.tail5.field_78796_g += r4;
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
/* 245 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 246 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 247 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 248 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 250 */     this.LegR.field_78796_g = 0.0F;
/* 251 */     this.LegL.field_78796_g = 0.0F;
/* 252 */     this.ArmR.field_78796_g = 0.0F;
/* 253 */     this.ArmL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbtournament\ModelGiran.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */