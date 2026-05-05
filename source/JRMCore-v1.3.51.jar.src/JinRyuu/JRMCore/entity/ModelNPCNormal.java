/*     */ package JinRyuu.JRMCore.entity;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
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
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ModelNPCNormal
/*     */   extends ModelBiped
/*     */ {
/*     */   public ModelRenderer field_78116_c;
/*     */   public ModelRenderer field_78114_d;
/*     */   public ModelRenderer field_78115_e;
/*     */   public ModelRenderer field_78112_f;
/*     */   public ModelRenderer field_78113_g;
/*     */   public ModelRenderer field_78123_h;
/*     */   public ModelRenderer field_78124_i;
/*     */   public ModelRenderer field_78121_j;
/*     */   public ModelRenderer field_78122_k;
/*     */   public int field_78119_l;
/*     */   public int field_78120_m;
/*     */   public boolean field_78117_n;
/*     */   public boolean field_78118_o;
/*     */   
/*     */   public ModelNPCNormal() {
/*  42 */     this(0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelNPCNormal(float par1) {
/*  47 */     this(par1, 0.0F, 64, 32);
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelNPCNormal(float par1, float par2, int par3, int par4) {
/*  52 */     this.field_78119_l = 0;
/*  53 */     this.field_78120_m = 0;
/*  54 */     this.field_78117_n = false;
/*  55 */     this.field_78118_o = false;
/*  56 */     this.field_78090_t = par3;
/*  57 */     this.field_78089_u = par4;
/*  58 */     this.field_78122_k = new ModelRenderer((ModelBase)this, 0, 0);
/*  59 */     this.field_78122_k.func_78790_a(-5.0F, 0.0F, -1.0F, 10, 16, 1, par1);
/*  60 */     this.field_78121_j = new ModelRenderer((ModelBase)this, 24, 0);
/*  61 */     this.field_78121_j.func_78790_a(-3.0F, -6.0F, -1.0F, 6, 6, 1, par1);
/*  62 */     this.field_78116_c = new ModelRenderer((ModelBase)this, 0, 0);
/*  63 */     this.field_78116_c.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, par1);
/*  64 */     this.field_78116_c.func_78793_a(0.0F, 0.0F + par2, 0.0F);
/*  65 */     this.field_78114_d = new ModelRenderer((ModelBase)this, 32, 0);
/*  66 */     this.field_78114_d.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, par1 + 0.5F);
/*  67 */     this.field_78114_d.func_78793_a(0.0F, 0.0F + par2, 0.0F);
/*  68 */     this.field_78115_e = new ModelRenderer((ModelBase)this, 16, 16);
/*  69 */     this.field_78115_e.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, par1);
/*  70 */     this.field_78115_e.func_78793_a(0.0F, 0.0F + par2, 0.0F);
/*  71 */     this.field_78112_f = new ModelRenderer((ModelBase)this, 40, 16);
/*  72 */     this.field_78112_f.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, par1);
/*  73 */     this.field_78112_f.func_78793_a(-5.0F, 2.0F + par2, 0.0F);
/*  74 */     this.field_78113_g = new ModelRenderer((ModelBase)this, 40, 16);
/*  75 */     this.field_78113_g.field_78809_i = true;
/*  76 */     this.field_78113_g.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, par1);
/*  77 */     this.field_78113_g.func_78793_a(5.0F, 2.0F + par2, 0.0F);
/*  78 */     this.field_78123_h = new ModelRenderer((ModelBase)this, 0, 16);
/*  79 */     this.field_78123_h.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1);
/*  80 */     this.field_78123_h.func_78793_a(-1.9F, 12.0F + par2, 0.0F);
/*  81 */     this.field_78124_i = new ModelRenderer((ModelBase)this, 0, 16);
/*  82 */     this.field_78124_i.field_78809_i = true;
/*  83 */     this.field_78124_i.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1);
/*  84 */     this.field_78124_i.func_78793_a(1.9F, 12.0F + par2, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
/*  92 */     func_78087_a(par2, par3, par4, par5, par6, par7, par1Entity);
/*     */     
/*  94 */     if (this.field_78091_s) {
/*     */       
/*  96 */       float var8 = 2.0F;
/*  97 */       GL11.glPushMatrix();
/*  98 */       GL11.glScalef(1.5F / var8, 1.5F / var8, 1.5F / var8);
/*  99 */       GL11.glTranslatef(0.0F, 16.0F * par7, 0.0F);
/* 100 */       this.field_78116_c.func_78785_a(par7);
/* 101 */       GL11.glPopMatrix();
/* 102 */       GL11.glPushMatrix();
/* 103 */       GL11.glScalef(1.0F / var8, 1.0F / var8, 1.0F / var8);
/* 104 */       GL11.glTranslatef(0.0F, 24.0F * par7, 0.0F);
/* 105 */       this.field_78115_e.func_78785_a(par7);
/* 106 */       this.field_78112_f.func_78785_a(par7);
/* 107 */       this.field_78113_g.func_78785_a(par7);
/* 108 */       this.field_78123_h.func_78785_a(par7);
/* 109 */       this.field_78124_i.func_78785_a(par7);
/* 110 */       this.field_78114_d.func_78785_a(par7);
/* 111 */       GL11.glPopMatrix();
/*     */     }
/*     */     else {
/*     */       
/* 115 */       this.field_78116_c.func_78785_a(par7);
/* 116 */       this.field_78115_e.func_78785_a(par7);
/* 117 */       this.field_78112_f.func_78785_a(par7);
/* 118 */       this.field_78113_g.func_78785_a(par7);
/* 119 */       this.field_78123_h.func_78785_a(par7);
/* 120 */       this.field_78124_i.func_78785_a(par7);
/* 121 */       this.field_78114_d.func_78785_a(par7);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 132 */     this.field_78116_c.field_78796_g = par4 / 57.295776F;
/* 133 */     this.field_78116_c.field_78795_f = par5 / 57.295776F;
/* 134 */     this.field_78114_d.field_78796_g = this.field_78116_c.field_78796_g;
/* 135 */     this.field_78114_d.field_78795_f = this.field_78116_c.field_78795_f;
/* 136 */     this.field_78112_f.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 2.0F * par2 * 0.5F;
/* 137 */     this.field_78113_g.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
/* 138 */     this.field_78112_f.field_78808_h = 0.0F;
/* 139 */     this.field_78113_g.field_78808_h = 0.0F;
/* 140 */     this.field_78123_h.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 1.4F * par2;
/* 141 */     this.field_78124_i.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.4F * par2;
/* 142 */     this.field_78123_h.field_78796_g = 0.0F;
/* 143 */     this.field_78124_i.field_78796_g = 0.0F;
/*     */     
/* 145 */     if (this.field_78093_q) {
/*     */       
/* 147 */       this.field_78112_f.field_78795_f += -0.62831855F;
/* 148 */       this.field_78113_g.field_78795_f += -0.62831855F;
/* 149 */       this.field_78123_h.field_78795_f = -1.2566371F;
/* 150 */       this.field_78124_i.field_78795_f = -1.2566371F;
/* 151 */       this.field_78123_h.field_78796_g = 0.31415927F;
/* 152 */       this.field_78124_i.field_78796_g = -0.31415927F;
/*     */     } 
/*     */     
/* 155 */     if (this.field_78119_l != 0)
/*     */     {
/* 157 */       this.field_78113_g.field_78795_f = this.field_78113_g.field_78795_f * 0.5F - 0.31415927F * this.field_78119_l;
/*     */     }
/*     */     
/* 160 */     if (this.field_78120_m != 0)
/*     */     {
/* 162 */       this.field_78112_f.field_78795_f = this.field_78112_f.field_78795_f * 0.5F - 0.31415927F * this.field_78120_m;
/*     */     }
/*     */     
/* 165 */     this.field_78112_f.field_78796_g = 0.0F;
/* 166 */     this.field_78113_g.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */     
/* 170 */     if (this.field_78095_p > -9990.0F) {
/*     */       
/* 172 */       float var8 = this.field_78095_p;
/* 173 */       this.field_78115_e.field_78796_g = MathHelper.func_76126_a(MathHelper.func_76129_c(var8) * 3.1415927F * 2.0F) * 0.2F;
/* 174 */       this.field_78112_f.field_78798_e = MathHelper.func_76126_a(this.field_78115_e.field_78796_g) * 5.0F;
/* 175 */       this.field_78112_f.field_78800_c = -MathHelper.func_76134_b(this.field_78115_e.field_78796_g) * 5.0F;
/* 176 */       this.field_78113_g.field_78798_e = -MathHelper.func_76126_a(this.field_78115_e.field_78796_g) * 5.0F;
/* 177 */       this.field_78113_g.field_78800_c = MathHelper.func_76134_b(this.field_78115_e.field_78796_g) * 5.0F;
/* 178 */       this.field_78112_f.field_78796_g += this.field_78115_e.field_78796_g;
/* 179 */       this.field_78113_g.field_78796_g += this.field_78115_e.field_78796_g;
/* 180 */       this.field_78113_g.field_78795_f += this.field_78115_e.field_78796_g;
/* 181 */       var8 = 1.0F - this.field_78095_p;
/* 182 */       var8 *= var8;
/* 183 */       var8 *= var8;
/* 184 */       var8 = 1.0F - var8;
/* 185 */       float var9 = MathHelper.func_76126_a(var8 * 3.1415927F);
/* 186 */       float var10 = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -(this.field_78116_c.field_78795_f - 0.7F) * 0.75F;
/* 187 */       this.field_78112_f.field_78795_f = (float)(this.field_78112_f.field_78795_f - var9 * 1.2D + var10);
/* 188 */       this.field_78112_f.field_78796_g += this.field_78115_e.field_78796_g * 2.0F;
/* 189 */       this.field_78112_f.field_78808_h = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -0.4F;
/*     */     } 
/*     */     
/* 192 */     if (this.field_78117_n) {
/*     */       
/* 194 */       this.field_78115_e.field_78795_f = 0.5F;
/* 195 */       this.field_78112_f.field_78795_f += 0.4F;
/* 196 */       this.field_78113_g.field_78795_f += 0.4F;
/* 197 */       this.field_78123_h.field_78798_e = 4.0F;
/* 198 */       this.field_78124_i.field_78798_e = 4.0F;
/* 199 */       this.field_78123_h.field_78797_d = 9.0F;
/* 200 */       this.field_78124_i.field_78797_d = 9.0F;
/* 201 */       this.field_78116_c.field_78797_d = 1.0F;
/* 202 */       this.field_78114_d.field_78797_d = 1.0F;
/*     */     }
/*     */     else {
/*     */       
/* 206 */       this.field_78115_e.field_78795_f = 0.0F;
/* 207 */       this.field_78123_h.field_78798_e = 0.1F;
/* 208 */       this.field_78124_i.field_78798_e = 0.1F;
/* 209 */       this.field_78123_h.field_78797_d = 12.0F;
/* 210 */       this.field_78124_i.field_78797_d = 12.0F;
/* 211 */       this.field_78116_c.field_78797_d = 0.0F;
/* 212 */       this.field_78114_d.field_78797_d = 0.0F;
/*     */     } 
/*     */     
/* 215 */     this.field_78112_f.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 216 */     this.field_78113_g.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 217 */     this.field_78112_f.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 218 */     this.field_78113_g.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/*     */     
/* 220 */     if (this.field_78118_o) {
/*     */       
/* 222 */       float var8 = 0.0F;
/* 223 */       float var9 = 0.0F;
/* 224 */       this.field_78112_f.field_78808_h = 0.0F;
/* 225 */       this.field_78113_g.field_78808_h = 0.0F;
/* 226 */       this.field_78112_f.field_78796_g = -(0.1F - var8 * 0.6F) + this.field_78116_c.field_78796_g;
/* 227 */       this.field_78113_g.field_78796_g = 0.1F - var8 * 0.6F + this.field_78116_c.field_78796_g + 0.4F;
/* 228 */       this.field_78112_f.field_78795_f = -1.5707964F + this.field_78116_c.field_78795_f;
/* 229 */       this.field_78113_g.field_78795_f = -1.5707964F + this.field_78116_c.field_78795_f;
/* 230 */       this.field_78112_f.field_78795_f -= var8 * 1.2F - var9 * 0.4F;
/* 231 */       this.field_78113_g.field_78795_f -= var8 * 1.2F - var9 * 0.4F;
/* 232 */       this.field_78112_f.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 233 */       this.field_78113_g.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 234 */       this.field_78112_f.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 235 */       this.field_78113_g.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78110_b(float par1) {
/* 244 */     this.field_78121_j.field_78796_g = this.field_78116_c.field_78796_g;
/* 245 */     this.field_78121_j.field_78795_f = this.field_78116_c.field_78795_f;
/* 246 */     this.field_78121_j.field_78800_c = 0.0F;
/* 247 */     this.field_78121_j.field_78797_d = 0.0F;
/* 248 */     this.field_78121_j.func_78785_a(par1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78111_c(float par1) {
/* 256 */     this.field_78122_k.func_78785_a(par1);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\ModelNPCNormal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */