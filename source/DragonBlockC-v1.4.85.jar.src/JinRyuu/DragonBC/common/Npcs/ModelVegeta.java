/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
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
/*     */ public class ModelVegeta
/*     */   extends ModelBiped
/*     */ {
/*     */   ModelRenderer head;
/*     */   ModelRenderer body;
/*     */   ModelRenderer rightarm;
/*     */   ModelRenderer leftarm;
/*     */   ModelRenderer rightleg;
/*     */   ModelRenderer leftleg;
/*     */   ModelRenderer leftarmshoulder;
/*     */   ModelRenderer rightarmshoulder;
/*     */   ModelRenderer hair1;
/*     */   ModelRenderer hair2;
/*     */   ModelRenderer hair3;
/*     */   ModelRenderer hair4;
/*     */   ModelRenderer hea5;
/*     */   ModelRenderer hea6;
/*     */   
/*     */   public ModelVegeta() {
/*  39 */     this.field_78090_t = 128;
/*  40 */     this.field_78089_u = 64;
/*     */ 
/*     */     
/*  43 */     this.head = new ModelRenderer((ModelBase)this, 0, 0);
/*  44 */     this.head.func_78789_a(-4.0F, -8.0F, -4.0F, 8, 8, 8);
/*  45 */     this.head.func_78793_a(0.0F, 2.0F, 0.0F);
/*  46 */     this.head.func_78787_b(128, 64);
/*  47 */     this.body = new ModelRenderer((ModelBase)this, 16, 16);
/*  48 */     this.body.func_78789_a(-4.0F, 0.0F, -2.0F, 8, 11, 4);
/*  49 */     this.body.func_78793_a(0.0F, 2.0F, 0.0F);
/*  50 */     this.body.func_78787_b(128, 64);
/*  51 */     this.rightarm = new ModelRenderer((ModelBase)this, 40, 16);
/*  52 */     this.rightarm.func_78789_a(-3.0F, -2.0F, -2.0F, 4, 11, 4);
/*  53 */     this.rightarm.func_78793_a(-5.0F, 4.0F, 0.0F);
/*  54 */     this.rightarm.func_78787_b(128, 64);
/*  55 */     this.leftarm = new ModelRenderer((ModelBase)this, 40, 16);
/*  56 */     this.leftarm.field_78809_i = true;
/*  57 */     this.leftarm.func_78789_a(-1.0F, -2.0F, -2.0F, 4, 11, 4);
/*  58 */     this.leftarm.func_78793_a(5.0F, 4.0F, 0.0F);
/*  59 */     this.leftarm.func_78787_b(128, 64);
/*  60 */     this.rightleg = new ModelRenderer((ModelBase)this, 0, 16);
/*  61 */     this.rightleg.func_78789_a(-2.0F, 0.0F, -2.0F, 4, 11, 4);
/*  62 */     this.rightleg.func_78793_a(-2.0F, 13.0F, 0.0F);
/*  63 */     this.rightleg.func_78787_b(128, 64);
/*  64 */     this.leftleg = new ModelRenderer((ModelBase)this, 0, 16);
/*  65 */     this.leftleg.field_78809_i = true;
/*  66 */     this.leftleg.func_78789_a(-2.0F, 0.0F, -2.0F, 4, 11, 4);
/*  67 */     this.leftleg.func_78793_a(2.0F, 13.0F, 0.0F);
/*  68 */     this.leftleg.func_78787_b(128, 64);
/*  69 */     this.rightarmshoulder = new ModelRenderer((ModelBase)this, 40, 32);
/*  70 */     this.rightarmshoulder.func_78789_a(-6.0F, -3.0F, -3.0F, 7, 4, 6);
/*  71 */     this.rightarmshoulder.func_78793_a(-5.0F, 4.0F, 0.0F);
/*  72 */     this.rightarmshoulder.func_78787_b(128, 64);
/*  73 */     this.leftarmshoulder = new ModelRenderer((ModelBase)this, 40, 32);
/*  74 */     this.leftarmshoulder.field_78809_i = true;
/*  75 */     this.leftarmshoulder.func_78789_a(-1.0F, -3.0F, -3.0F, 7, 4, 6);
/*  76 */     this.leftarmshoulder.func_78793_a(5.0F, 4.0F, 0.0F);
/*  77 */     this.leftarmshoulder.func_78787_b(128, 64);
/*  78 */     this.hair1 = new ModelRenderer((ModelBase)this, 32, 0);
/*  79 */     this.hair1.func_78789_a(-4.0F, -10.0F, -6.0F, 8, 4, 8);
/*  80 */     this.hair1.func_78793_a(0.0F, 2.0F, 0.0F);
/*  81 */     this.hair1.func_78787_b(128, 64);
/*  82 */     this.hair2 = new ModelRenderer((ModelBase)this, 64, 0);
/*  83 */     this.hair2.func_78789_a(-3.0F, -12.0F, -7.0F, 6, 4, 6);
/*  84 */     this.hair2.func_78793_a(0.0F, 2.0F, 0.0F);
/*  85 */     this.hair2.func_78787_b(128, 64);
/*  86 */     this.hair3 = new ModelRenderer((ModelBase)this, 88, 0);
/*  87 */     this.hair3.func_78789_a(-2.0F, -13.0F, -8.0F, 4, 4, 4);
/*  88 */     this.hair3.func_78793_a(0.0F, 2.0F, 0.0F);
/*  89 */     this.hair3.func_78787_b(128, 64);
/*  90 */     this.hair4 = new ModelRenderer((ModelBase)this, 104, 0);
/*  91 */     this.hair4.func_78789_a(-1.0F, -15.0F, -7.0F, 2, 4, 2);
/*  92 */     this.hair4.func_78793_a(0.0F, 2.0F, 0.0F);
/*  93 */     this.hair4.func_78787_b(128, 64);
/*  94 */     this.hea5 = new ModelRenderer((ModelBase)this, 112, 0);
/*  95 */     this.hea5.func_78789_a(-1.0F, -15.5F, 3.5F, 2, 8, 2);
/*  96 */     this.hea5.func_78793_a(0.0F, 2.0F, 0.0F);
/*  97 */     this.hea5.func_78787_b(128, 64);
/*  98 */     this.hea6 = new ModelRenderer((ModelBase)this, 56, 12);
/*  99 */     this.hea6.func_78789_a(-5.0F, -6.0F, -7.0F, 10, 2, 8);
/* 100 */     this.hea6.func_78793_a(0.0F, 2.0F, 0.0F);
/* 101 */     this.hea6.func_78787_b(128, 64);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 107 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 108 */     this.head.func_78785_a(f5);
/* 109 */     this.body.func_78785_a(f5);
/* 110 */     this.rightarm.func_78785_a(f5);
/* 111 */     this.leftarm.func_78785_a(f5);
/* 112 */     this.rightleg.func_78785_a(f5);
/* 113 */     this.leftleg.func_78785_a(f5);
/* 114 */     this.leftarmshoulder.func_78785_a(f5);
/* 115 */     this.rightarmshoulder.func_78785_a(f5);
/* 116 */     this.hair1.func_78785_a(f5);
/* 117 */     this.hair2.func_78785_a(f5);
/* 118 */     this.hair3.func_78785_a(f5);
/* 119 */     this.hair4.func_78785_a(f5);
/* 120 */     this.hea5.func_78785_a(f5);
/* 121 */     this.hea6.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 127 */     this.head.field_78796_g = par4 / 57.295776F;
/* 128 */     this.head.field_78795_f = par5 / 57.295776F;
/* 129 */     this.hair1.field_78796_g = this.head.field_78796_g;
/* 130 */     this.hair1.field_78795_f = -0.296706F + this.head.field_78795_f;
/* 131 */     this.hair2.field_78796_g = this.head.field_78796_g;
/* 132 */     this.hair2.field_78795_f = -0.4537856F + this.head.field_78795_f;
/* 133 */     this.hair3.field_78796_g = this.head.field_78796_g;
/* 134 */     this.hair3.field_78795_f = -0.6108652F + this.head.field_78795_f;
/* 135 */     this.hair4.field_78796_g = this.head.field_78796_g;
/* 136 */     this.hair4.field_78795_f = -0.5934119F + this.head.field_78795_f;
/* 137 */     this.hea5.field_78796_g = this.head.field_78796_g;
/* 138 */     this.hea5.field_78795_f = 0.1047198F + this.head.field_78795_f;
/* 139 */     this.hea6.field_78796_g = this.head.field_78796_g;
/* 140 */     this.hea6.field_78795_f = -0.5585054F + this.head.field_78795_f;
/* 141 */     this.rightarm.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 2.0F * par2 * 0.5F;
/* 142 */     this.rightarmshoulder.field_78795_f = this.rightarm.field_78795_f;
/* 143 */     this.leftarm.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
/* 144 */     this.leftarmshoulder.field_78795_f = this.leftarm.field_78795_f;
/* 145 */     this.rightarm.field_78808_h = 0.0F;
/* 146 */     this.rightarmshoulder.field_78808_h = this.rightarm.field_78808_h;
/* 147 */     this.leftarm.field_78808_h = 0.0F;
/* 148 */     this.leftarmshoulder.field_78808_h = this.leftarm.field_78808_h;
/* 149 */     this.rightleg.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 1.4F * par2;
/* 150 */     this.leftleg.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.4F * par2;
/* 151 */     this.rightleg.field_78796_g = 0.0F;
/* 152 */     this.leftleg.field_78796_g = 0.0F;
/*     */     
/* 154 */     if (this.field_78093_q) {
/*     */       
/* 156 */       this.rightarm.field_78795_f += -0.62831855F;
/* 157 */       this.rightarmshoulder.field_78795_f = this.rightarm.field_78795_f;
/* 158 */       this.leftarm.field_78795_f += -0.62831855F;
/* 159 */       this.leftarmshoulder.field_78795_f = this.leftarm.field_78795_f;
/* 160 */       this.rightleg.field_78795_f = -1.2566371F;
/* 161 */       this.leftleg.field_78795_f = -1.2566371F;
/* 162 */       this.rightleg.field_78796_g = 0.31415927F;
/* 163 */       this.leftleg.field_78796_g = -0.31415927F;
/*     */     } 
/*     */     
/* 166 */     this.rightarm.field_78796_g = 0.0F;
/* 167 */     this.rightarmshoulder.field_78796_g = this.rightarm.field_78796_g;
/* 168 */     this.leftarm.field_78796_g = 0.0F;
/* 169 */     this.leftarmshoulder.field_78796_g = this.leftarm.field_78796_g;
/*     */ 
/*     */ 
/*     */     
/* 173 */     if (this.field_78095_p > -9990.0F) {
/*     */       
/* 175 */       float var8 = this.field_78095_p;
/* 176 */       this.body.field_78796_g = MathHelper.func_76126_a(MathHelper.func_76129_c(var8) * 3.1415927F * 2.0F) * 0.2F;
/* 177 */       this.rightarm.field_78798_e = MathHelper.func_76126_a(this.body.field_78796_g) * 5.0F;
/* 178 */       this.rightarm.field_78800_c = -MathHelper.func_76134_b(this.body.field_78796_g) * 5.0F;
/* 179 */       this.leftarm.field_78798_e = -MathHelper.func_76126_a(this.body.field_78796_g) * 5.0F;
/* 180 */       this.leftarm.field_78800_c = MathHelper.func_76134_b(this.body.field_78796_g) * 5.0F;
/* 181 */       this.rightarm.field_78796_g += this.body.field_78796_g;
/* 182 */       this.leftarm.field_78796_g += this.body.field_78796_g;
/* 183 */       this.leftarm.field_78795_f += this.body.field_78796_g;
/* 184 */       this.rightarmshoulder.field_78798_e = MathHelper.func_76126_a(this.body.field_78796_g) * 5.0F;
/* 185 */       this.rightarmshoulder.field_78800_c = -MathHelper.func_76134_b(this.body.field_78796_g) * 5.0F;
/* 186 */       this.leftarmshoulder.field_78798_e = -MathHelper.func_76126_a(this.body.field_78796_g) * 5.0F;
/* 187 */       this.leftarmshoulder.field_78800_c = MathHelper.func_76134_b(this.body.field_78796_g) * 5.0F;
/* 188 */       this.rightarmshoulder.field_78796_g += this.body.field_78796_g;
/* 189 */       this.leftarmshoulder.field_78796_g += this.body.field_78796_g;
/* 190 */       this.leftarmshoulder.field_78795_f += this.body.field_78796_g;
/* 191 */       var8 = 1.0F - this.field_78095_p;
/* 192 */       var8 *= var8;
/* 193 */       var8 *= var8;
/* 194 */       var8 = 1.0F - var8;
/* 195 */       float var9 = MathHelper.func_76126_a(var8 * 3.1415927F);
/* 196 */       float var10 = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -(this.head.field_78795_f - 0.7F) * 0.75F;
/* 197 */       this.rightarm.field_78795_f = (float)(this.rightarm.field_78795_f - var9 * 1.2D + var10);
/* 198 */       this.rightarm.field_78796_g += this.body.field_78796_g * 2.0F;
/* 199 */       this.rightarm.field_78808_h = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -0.4F;
/* 200 */       this.rightarmshoulder.field_78795_f = (float)(this.rightarm.field_78795_f - var9 * 1.2D + var10);
/* 201 */       this.rightarmshoulder.field_78796_g += this.body.field_78796_g * 2.0F;
/* 202 */       this.rightarmshoulder.field_78808_h = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -0.4F;
/*     */     } 
/*     */ 
/*     */     
/* 206 */     this.rightarm.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 207 */     this.rightarmshoulder.field_78808_h = this.rightarm.field_78808_h;
/* 208 */     this.leftarm.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 209 */     this.leftarmshoulder.field_78808_h = this.leftarm.field_78808_h;
/* 210 */     this.rightarm.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 211 */     this.rightarmshoulder.field_78795_f = this.rightarm.field_78795_f;
/* 212 */     this.leftarm.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 213 */     this.leftarmshoulder.field_78795_f = this.leftarm.field_78795_f;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelVegeta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */