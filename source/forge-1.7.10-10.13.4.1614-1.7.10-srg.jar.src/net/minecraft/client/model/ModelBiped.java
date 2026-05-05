/*     */ package net.minecraft.client.model;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ModelBiped extends ModelBase {
/*     */   public ModelRenderer field_78116_c;
/*     */   public ModelRenderer field_78114_d;
/*     */   public ModelRenderer field_78115_e;
/*     */   public ModelRenderer field_78112_f;
/*     */   public ModelRenderer field_78113_g;
/*     */   public ModelRenderer field_78123_h;
/*     */   public ModelRenderer field_78124_i;
/*     */   
/*     */   public ModelBiped() {
/*  18 */     this(0.0F);
/*     */   }
/*     */   public ModelRenderer field_78121_j; public ModelRenderer field_78122_k; public int field_78119_l; public int field_78120_m; public boolean field_78117_n; public boolean field_78118_o; private static final String __OBFID = "CL_00000840";
/*     */   public ModelBiped(float p_i1148_1_) {
/*  22 */     this(p_i1148_1_, 0.0F, 64, 32);
/*     */   }
/*     */   
/*     */   public ModelBiped(float p_i1149_1_, float p_i1149_2_, int p_i1149_3_, int p_i1149_4_) {
/*  26 */     this.field_78090_t = p_i1149_3_;
/*  27 */     this.field_78089_u = p_i1149_4_;
/*     */     
/*  29 */     this.field_78122_k = new ModelRenderer(this, 0, 0);
/*  30 */     this.field_78122_k.func_78790_a(-5.0F, 0.0F, -1.0F, 10, 16, 1, p_i1149_1_);
/*     */     
/*  32 */     this.field_78121_j = new ModelRenderer(this, 24, 0);
/*  33 */     this.field_78121_j.func_78790_a(-3.0F, -6.0F, -1.0F, 6, 6, 1, p_i1149_1_);
/*     */     
/*  35 */     this.field_78116_c = new ModelRenderer(this, 0, 0);
/*  36 */     this.field_78116_c.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, p_i1149_1_);
/*  37 */     this.field_78116_c.func_78793_a(0.0F, 0.0F + p_i1149_2_, 0.0F);
/*     */     
/*  39 */     this.field_78114_d = new ModelRenderer(this, 32, 0);
/*  40 */     this.field_78114_d.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, p_i1149_1_ + 0.5F);
/*  41 */     this.field_78114_d.func_78793_a(0.0F, 0.0F + p_i1149_2_, 0.0F);
/*     */     
/*  43 */     this.field_78115_e = new ModelRenderer(this, 16, 16);
/*  44 */     this.field_78115_e.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, p_i1149_1_);
/*  45 */     this.field_78115_e.func_78793_a(0.0F, 0.0F + p_i1149_2_, 0.0F);
/*     */     
/*  47 */     this.field_78112_f = new ModelRenderer(this, 40, 16);
/*  48 */     this.field_78112_f.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, p_i1149_1_);
/*  49 */     this.field_78112_f.func_78793_a(-5.0F, 2.0F + p_i1149_2_, 0.0F);
/*     */     
/*  51 */     this.field_78113_g = new ModelRenderer(this, 40, 16);
/*  52 */     this.field_78113_g.field_78809_i = true;
/*  53 */     this.field_78113_g.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, p_i1149_1_);
/*  54 */     this.field_78113_g.func_78793_a(5.0F, 2.0F + p_i1149_2_, 0.0F);
/*     */     
/*  56 */     this.field_78123_h = new ModelRenderer(this, 0, 16);
/*  57 */     this.field_78123_h.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, p_i1149_1_);
/*  58 */     this.field_78123_h.func_78793_a(-1.9F, 12.0F + p_i1149_2_, 0.0F);
/*     */     
/*  60 */     this.field_78124_i = new ModelRenderer(this, 0, 16);
/*  61 */     this.field_78124_i.field_78809_i = true;
/*  62 */     this.field_78124_i.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, p_i1149_1_);
/*  63 */     this.field_78124_i.func_78793_a(1.9F, 12.0F + p_i1149_2_, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
/*  68 */     func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
/*     */     
/*  70 */     if (this.field_78091_s) {
/*  71 */       float f = 2.0F;
/*  72 */       GL11.glPushMatrix();
/*  73 */       GL11.glScalef(1.5F / f, 1.5F / f, 1.5F / f);
/*  74 */       GL11.glTranslatef(0.0F, 16.0F * p_78088_7_, 0.0F);
/*  75 */       this.field_78116_c.func_78785_a(p_78088_7_);
/*  76 */       GL11.glPopMatrix();
/*  77 */       GL11.glPushMatrix();
/*  78 */       GL11.glScalef(1.0F / f, 1.0F / f, 1.0F / f);
/*  79 */       GL11.glTranslatef(0.0F, 24.0F * p_78088_7_, 0.0F);
/*  80 */       this.field_78115_e.func_78785_a(p_78088_7_);
/*  81 */       this.field_78112_f.func_78785_a(p_78088_7_);
/*  82 */       this.field_78113_g.func_78785_a(p_78088_7_);
/*  83 */       this.field_78123_h.func_78785_a(p_78088_7_);
/*  84 */       this.field_78124_i.func_78785_a(p_78088_7_);
/*  85 */       this.field_78114_d.func_78785_a(p_78088_7_);
/*  86 */       GL11.glPopMatrix();
/*     */     } else {
/*  88 */       this.field_78116_c.func_78785_a(p_78088_7_);
/*  89 */       this.field_78115_e.func_78785_a(p_78088_7_);
/*  90 */       this.field_78112_f.func_78785_a(p_78088_7_);
/*  91 */       this.field_78113_g.func_78785_a(p_78088_7_);
/*  92 */       this.field_78123_h.func_78785_a(p_78088_7_);
/*  93 */       this.field_78124_i.func_78785_a(p_78088_7_);
/*  94 */       this.field_78114_d.func_78785_a(p_78088_7_);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
/* 100 */     this.field_78116_c.field_78796_g = p_78087_4_ / 57.295776F;
/* 101 */     this.field_78116_c.field_78795_f = p_78087_5_ / 57.295776F;
/* 102 */     this.field_78114_d.field_78796_g = this.field_78116_c.field_78796_g;
/* 103 */     this.field_78114_d.field_78795_f = this.field_78116_c.field_78795_f;
/*     */     
/* 105 */     this.field_78112_f.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F + 3.1415927F) * 2.0F * p_78087_2_ * 0.5F;
/*     */     
/* 107 */     this.field_78113_g.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F) * 2.0F * p_78087_2_ * 0.5F;
/* 108 */     this.field_78112_f.field_78808_h = 0.0F;
/* 109 */     this.field_78113_g.field_78808_h = 0.0F;
/*     */     
/* 111 */     this.field_78123_h.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
/* 112 */     this.field_78124_i.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F + 3.1415927F) * 1.4F * p_78087_2_;
/* 113 */     this.field_78123_h.field_78796_g = 0.0F;
/* 114 */     this.field_78124_i.field_78796_g = 0.0F;
/*     */     
/* 116 */     if (this.field_78093_q) {
/* 117 */       this.field_78112_f.field_78795_f += -0.62831855F;
/* 118 */       this.field_78113_g.field_78795_f += -0.62831855F;
/* 119 */       this.field_78123_h.field_78795_f = -1.2566371F;
/* 120 */       this.field_78124_i.field_78795_f = -1.2566371F;
/* 121 */       this.field_78123_h.field_78796_g = 0.31415927F;
/* 122 */       this.field_78124_i.field_78796_g = -0.31415927F;
/*     */     } 
/*     */     
/* 125 */     if (this.field_78119_l != 0) {
/* 126 */       this.field_78113_g.field_78795_f = this.field_78113_g.field_78795_f * 0.5F - 0.31415927F * this.field_78119_l;
/*     */     }
/* 128 */     if (this.field_78120_m != 0) {
/* 129 */       this.field_78112_f.field_78795_f = this.field_78112_f.field_78795_f * 0.5F - 0.31415927F * this.field_78120_m;
/*     */     }
/* 131 */     this.field_78112_f.field_78796_g = 0.0F;
/* 132 */     this.field_78113_g.field_78796_g = 0.0F;
/*     */     
/* 134 */     if (this.field_78095_p > -9990.0F) {
/* 135 */       float f1 = this.field_78095_p;
/* 136 */       this.field_78115_e.field_78796_g = MathHelper.func_76126_a(MathHelper.func_76129_c(f1) * 3.1415927F * 2.0F) * 0.2F;
/* 137 */       this.field_78112_f.field_78798_e = MathHelper.func_76126_a(this.field_78115_e.field_78796_g) * 5.0F;
/* 138 */       this.field_78112_f.field_78800_c = -MathHelper.func_76134_b(this.field_78115_e.field_78796_g) * 5.0F;
/* 139 */       this.field_78113_g.field_78798_e = -MathHelper.func_76126_a(this.field_78115_e.field_78796_g) * 5.0F;
/* 140 */       this.field_78113_g.field_78800_c = MathHelper.func_76134_b(this.field_78115_e.field_78796_g) * 5.0F;
/* 141 */       this.field_78112_f.field_78796_g += this.field_78115_e.field_78796_g;
/* 142 */       this.field_78113_g.field_78796_g += this.field_78115_e.field_78796_g;
/* 143 */       this.field_78113_g.field_78795_f += this.field_78115_e.field_78796_g;
/*     */       
/* 145 */       f1 = 1.0F - this.field_78095_p;
/* 146 */       f1 *= f1;
/* 147 */       f1 *= f1;
/* 148 */       f1 = 1.0F - f1;
/* 149 */       float f2 = MathHelper.func_76126_a(f1 * 3.1415927F);
/* 150 */       float f3 = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -(this.field_78116_c.field_78795_f - 0.7F) * 0.75F;
/* 151 */       this.field_78112_f.field_78795_f = (float)(this.field_78112_f.field_78795_f - f2 * 1.2D + f3);
/* 152 */       this.field_78112_f.field_78796_g += this.field_78115_e.field_78796_g * 2.0F;
/* 153 */       this.field_78112_f.field_78808_h = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -0.4F;
/*     */     } 
/*     */     
/* 156 */     if (this.field_78117_n) {
/* 157 */       this.field_78115_e.field_78795_f = 0.5F;
/* 158 */       this.field_78112_f.field_78795_f += 0.4F;
/* 159 */       this.field_78113_g.field_78795_f += 0.4F;
/* 160 */       this.field_78123_h.field_78798_e = 4.0F;
/* 161 */       this.field_78124_i.field_78798_e = 4.0F;
/* 162 */       this.field_78123_h.field_78797_d = 9.0F;
/* 163 */       this.field_78124_i.field_78797_d = 9.0F;
/* 164 */       this.field_78116_c.field_78797_d = 1.0F;
/* 165 */       this.field_78114_d.field_78797_d = 1.0F;
/*     */     } else {
/* 167 */       this.field_78115_e.field_78795_f = 0.0F;
/* 168 */       this.field_78123_h.field_78798_e = 0.1F;
/* 169 */       this.field_78124_i.field_78798_e = 0.1F;
/* 170 */       this.field_78123_h.field_78797_d = 12.0F;
/* 171 */       this.field_78124_i.field_78797_d = 12.0F;
/* 172 */       this.field_78116_c.field_78797_d = 0.0F;
/* 173 */       this.field_78114_d.field_78797_d = 0.0F;
/*     */     } 
/*     */     
/* 176 */     this.field_78112_f.field_78808_h += MathHelper.func_76134_b(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
/* 177 */     this.field_78113_g.field_78808_h -= MathHelper.func_76134_b(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
/* 178 */     this.field_78112_f.field_78795_f += MathHelper.func_76126_a(p_78087_3_ * 0.067F) * 0.05F;
/* 179 */     this.field_78113_g.field_78795_f -= MathHelper.func_76126_a(p_78087_3_ * 0.067F) * 0.05F;
/*     */     
/* 181 */     if (this.field_78118_o) {
/* 182 */       float f1 = 0.0F;
/* 183 */       float f2 = 0.0F;
/*     */       
/* 185 */       this.field_78112_f.field_78808_h = 0.0F;
/* 186 */       this.field_78113_g.field_78808_h = 0.0F;
/* 187 */       this.field_78112_f.field_78796_g = -(0.1F - f1 * 0.6F) + this.field_78116_c.field_78796_g;
/* 188 */       this.field_78113_g.field_78796_g = 0.1F - f1 * 0.6F + this.field_78116_c.field_78796_g + 0.4F;
/* 189 */       this.field_78112_f.field_78795_f = -1.5707964F + this.field_78116_c.field_78795_f;
/* 190 */       this.field_78113_g.field_78795_f = -1.5707964F + this.field_78116_c.field_78795_f;
/* 191 */       this.field_78112_f.field_78795_f -= f1 * 1.2F - f2 * 0.4F;
/* 192 */       this.field_78113_g.field_78795_f -= f1 * 1.2F - f2 * 0.4F;
/*     */       
/* 194 */       this.field_78112_f.field_78808_h += MathHelper.func_76134_b(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
/* 195 */       this.field_78113_g.field_78808_h -= MathHelper.func_76134_b(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
/* 196 */       this.field_78112_f.field_78795_f += MathHelper.func_76126_a(p_78087_3_ * 0.067F) * 0.05F;
/* 197 */       this.field_78113_g.field_78795_f -= MathHelper.func_76126_a(p_78087_3_ * 0.067F) * 0.05F;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78110_b(float p_78110_1_) {
/* 208 */     this.field_78121_j.field_78796_g = this.field_78116_c.field_78796_g;
/* 209 */     this.field_78121_j.field_78795_f = this.field_78116_c.field_78795_f;
/* 210 */     this.field_78121_j.field_78800_c = 0.0F;
/* 211 */     this.field_78121_j.field_78797_d = 0.0F;
/* 212 */     this.field_78121_j.func_78785_a(p_78110_1_);
/*     */   }
/*     */   
/*     */   public void func_78111_c(float p_78111_1_) {
/* 216 */     this.field_78122_k.func_78785_a(p_78111_1_);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\ModelBiped.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */