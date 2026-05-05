/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
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
/*     */ 
/*     */ public class ModelYakon
/*     */   extends ModelBiped
/*     */ {
/*     */   ModelRenderer head;
/*     */   ModelRenderer body;
/*     */   ModelRenderer body2;
/*     */   ModelRenderer leftarm;
/*     */   ModelRenderer leftarm1;
/*     */   ModelRenderer leftarm2;
/*     */   ModelRenderer leftarm3;
/*     */   ModelRenderer rightarm;
/*     */   ModelRenderer rightarm1;
/*     */   ModelRenderer rightarm2;
/*     */   ModelRenderer rightarm3;
/*     */   ModelRenderer leftleg;
/*     */   ModelRenderer leftleg1;
/*     */   ModelRenderer leftleg2;
/*     */   ModelRenderer leftleg3;
/*     */   ModelRenderer rightleg;
/*     */   ModelRenderer rightleg1;
/*     */   ModelRenderer rightleg2;
/*     */   ModelRenderer rightleg3;
/*     */   ModelRenderer back1;
/*     */   ModelRenderer back2;
/*     */   ModelRenderer back3;
/*     */   ModelRenderer back4;
/*     */   ModelRenderer tail;
/*  49 */   private float F = 1.0F;
/*     */   public ModelYakon(float f) {
/*  51 */     this();
/*  52 */     this.F = f;
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelYakon() {
/*  57 */     this.field_78090_t = 128;
/*  58 */     this.field_78089_u = 64;
/*     */     
/*  60 */     this.head = new ModelRenderer((ModelBase)this, 0, 0);
/*  61 */     this.head.func_78789_a(-4.0F, -4.0F, -5.0F, 8, 8, 5);
/*  62 */     this.head.func_78793_a(0.0F, -6.0F, -4.0F);
/*  63 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/*  64 */     this.body = new ModelRenderer((ModelBase)this, 0, 29);
/*  65 */     this.body.func_78789_a(-4.0F, 8.0F, -2.0F, 8, 8, 4);
/*  66 */     this.body.func_78793_a(0.0F, -8.0F, 0.0F);
/*  67 */     setRotation(this.body, 0.0F, 0.0F, 0.0F);
/*  68 */     this.body2 = new ModelRenderer((ModelBase)this, 0, 13);
/*  69 */     this.body2.func_78789_a(-6.0F, 0.0F, -4.0F, 12, 8, 8);
/*  70 */     this.body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  71 */     setRotation(this.body2, 0.0F, 0.0F, 0.0F);
/*  72 */     this.leftarm = new ModelRenderer((ModelBase)this, 40, 0);
/*  73 */     this.leftarm.func_78789_a(0.0F, -3.0F, -3.0F, 6, 6, 6);
/*  74 */     this.leftarm.func_78793_a(6.0F, -5.0F, 0.0F);
/*  75 */     this.leftarm.field_78809_i = true;
/*  76 */     setRotation(this.leftarm, 0.0F, 0.0F, 0.0F);
/*  77 */     this.leftarm1 = new ModelRenderer((ModelBase)this, 40, 12);
/*  78 */     this.leftarm1.func_78789_a(0.0F, 3.0F, -2.0F, 4, 7, 4);
/*  79 */     this.leftarm1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  80 */     this.leftarm1.field_78809_i = true;
/*  81 */     setRotation(this.leftarm1, 0.0F, 0.0F, 0.0F);
/*  82 */     this.leftarm2 = new ModelRenderer((ModelBase)this, 64, 0);
/*  83 */     this.leftarm2.func_78789_a(0.0F, 6.0F, -12.0F, 4, 4, 10);
/*  84 */     this.leftarm2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  85 */     this.leftarm2.field_78809_i = true;
/*  86 */     setRotation(this.leftarm2, 0.0F, 0.0F, 0.0F);
/*  87 */     this.leftarm3 = new ModelRenderer((ModelBase)this, 56, 14);
/*  88 */     this.leftarm3.func_78789_a(1.0F, 7.0F, -13.0F, 2, 2, 8);
/*  89 */     this.leftarm3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  90 */     this.leftarm3.field_78809_i = true;
/*  91 */     setRotation(this.leftarm3, -0.1745329F, 0.0F, 0.0F);
/*  92 */     this.rightarm = new ModelRenderer((ModelBase)this, 40, 0);
/*  93 */     this.rightarm.func_78789_a(-6.0F, -3.0F, -3.0F, 6, 6, 6);
/*  94 */     this.rightarm.func_78793_a(-6.0F, -5.0F, 0.0F);
/*  95 */     setRotation(this.rightarm, 0.0F, 0.0F, 0.0F);
/*  96 */     this.rightarm1 = new ModelRenderer((ModelBase)this, 40, 12);
/*  97 */     this.rightarm1.func_78789_a(-4.0F, 3.0F, -2.0F, 4, 7, 4);
/*  98 */     this.rightarm1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  99 */     setRotation(this.rightarm1, 0.0F, 0.0F, 0.0F);
/* 100 */     this.rightarm2 = new ModelRenderer((ModelBase)this, 64, 0);
/* 101 */     this.rightarm2.func_78789_a(-4.0F, 6.0F, -12.0F, 4, 4, 10);
/* 102 */     this.rightarm2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 103 */     setRotation(this.rightarm2, 0.0F, 0.0F, 0.0F);
/* 104 */     this.rightarm3 = new ModelRenderer((ModelBase)this, 56, 14);
/* 105 */     this.rightarm3.func_78789_a(-3.0F, 7.0F, -13.0F, 2, 2, 8);
/* 106 */     this.rightarm3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 107 */     setRotation(this.rightarm3, -0.1745329F, 0.0F, 0.0F);
/* 108 */     this.leftleg = new ModelRenderer((ModelBase)this, 0, 41);
/* 109 */     this.leftleg.func_78789_a(0.0F, -2.0F, -10.0F, 4, 4, 12);
/* 110 */     this.leftleg.func_78793_a(4.0F, 8.0F, 0.0F);
/* 111 */     this.leftleg.field_78809_i = true;
/* 112 */     setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
/* 113 */     this.leftleg1 = new ModelRenderer((ModelBase)this, 22, 47);
/* 114 */     this.leftleg1.func_78789_a(0.0F, 4.0F, -9.0F, 4, 4, 10);
/* 115 */     this.leftleg1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 116 */     this.leftleg1.field_78809_i = true;
/* 117 */     setRotation(this.leftleg1, -0.3490659F, 0.0F, 0.0174533F);
/* 118 */     this.leftleg2 = new ModelRenderer((ModelBase)this, 40, 42);
/* 119 */     this.leftleg2.func_78789_a(0.0F, 4.0F, 1.0F, 4, 11, 4);
/* 120 */     this.leftleg2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 121 */     this.leftleg2.field_78809_i = true;
/* 122 */     setRotation(this.leftleg2, -0.3665191F, 0.0F, 0.0174533F);
/* 123 */     this.leftleg3 = new ModelRenderer((ModelBase)this, 20, 39);
/* 124 */     this.leftleg3.func_78789_a(0.0F, 14.0F, -8.0F, 4, 2, 6);
/* 125 */     this.leftleg3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 126 */     this.leftleg3.field_78809_i = true;
/* 127 */     setRotation(this.leftleg3, 0.0F, 0.0F, 0.0174533F);
/* 128 */     this.rightleg = new ModelRenderer((ModelBase)this, 0, 41);
/* 129 */     this.rightleg.func_78789_a(-4.0F, -2.0F, -10.0F, 4, 4, 12);
/* 130 */     this.rightleg.func_78793_a(-4.0F, 8.0F, 0.0F);
/* 131 */     setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
/* 132 */     this.rightleg1 = new ModelRenderer((ModelBase)this, 22, 47);
/* 133 */     this.rightleg1.func_78789_a(-4.0F, 4.0F, -9.0F, 4, 4, 10);
/* 134 */     this.rightleg1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 135 */     setRotation(this.rightleg1, -0.3490659F, 0.0F, 0.0174533F);
/* 136 */     this.rightleg2 = new ModelRenderer((ModelBase)this, 40, 42);
/* 137 */     this.rightleg2.func_78789_a(-4.0F, 4.0F, 1.0F, 4, 11, 4);
/* 138 */     this.rightleg2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 139 */     setRotation(this.rightleg2, -0.3665191F, 0.0F, 0.0174533F);
/* 140 */     this.rightleg3 = new ModelRenderer((ModelBase)this, 20, 39);
/* 141 */     this.rightleg3.func_78789_a(-4.0F, 14.0F, -8.0F, 4, 2, 6);
/* 142 */     this.rightleg3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 143 */     setRotation(this.rightleg3, 0.0F, 0.0F, 0.0174533F);
/* 144 */     this.back1 = new ModelRenderer((ModelBase)this, 40, 32);
/* 145 */     this.back1.func_78789_a(1.0F, 1.0F, 1.0F, 4, 4, 6);
/* 146 */     this.back1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 147 */     setRotation(this.back1, 0.5235988F, 0.2617994F, 0.0F);
/* 148 */     this.back2 = new ModelRenderer((ModelBase)this, 40, 32);
/* 149 */     this.back2.func_78789_a(-5.0F, 1.0F, 1.0F, 4, 4, 6);
/* 150 */     this.back2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 151 */     setRotation(this.back2, 0.5235988F, -0.2617994F, 0.0F);
/* 152 */     this.back3 = new ModelRenderer((ModelBase)this, 40, 23);
/* 153 */     this.back3.func_78789_a(1.0F, 5.0F, 1.0F, 3, 3, 6);
/* 154 */     this.back3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 155 */     setRotation(this.back3, 0.2617994F, 0.2617994F, 0.0F);
/* 156 */     this.back4 = new ModelRenderer((ModelBase)this, 40, 23);
/* 157 */     this.back4.func_78789_a(-4.0F, 5.0F, 2.0F, 3, 3, 6);
/* 158 */     this.back4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 159 */     setRotation(this.back4, 0.2617994F, -0.2617994F, 0.0F);
/* 160 */     this.tail = new ModelRenderer((ModelBase)this, 56, 38);
/* 161 */     this.tail.func_78789_a(-2.0F, 8.0F, -3.0F, 4, 12, 4);
/* 162 */     this.tail.func_78793_a(0.0F, 0.0F, 0.0F);
/* 163 */     setRotation(this.tail, 0.3316126F, 0.0F, 0.0F);
/*     */     
/* 165 */     this.leftarm.func_78792_a(this.leftarm1);
/* 166 */     this.leftarm.func_78792_a(this.leftarm2);
/* 167 */     this.leftarm.func_78792_a(this.leftarm3);
/* 168 */     this.rightarm.func_78792_a(this.rightarm1);
/* 169 */     this.rightarm.func_78792_a(this.rightarm2);
/* 170 */     this.rightarm.func_78792_a(this.rightarm3);
/* 171 */     this.leftleg.func_78792_a(this.leftleg1);
/* 172 */     this.leftleg.func_78792_a(this.leftleg2);
/* 173 */     this.leftleg.func_78792_a(this.leftleg3);
/* 174 */     this.rightleg.func_78792_a(this.rightleg1);
/* 175 */     this.rightleg.func_78792_a(this.rightleg2);
/* 176 */     this.rightleg.func_78792_a(this.rightleg3);
/* 177 */     this.body.func_78792_a(this.body2);
/* 178 */     this.body.func_78792_a(this.back1);
/* 179 */     this.body.func_78792_a(this.back2);
/* 180 */     this.body.func_78792_a(this.back3);
/* 181 */     this.body.func_78792_a(this.back4);
/* 182 */     this.body.func_78792_a(this.tail);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 188 */     model.field_78795_f = x;
/* 189 */     model.field_78796_g = y;
/* 190 */     model.field_78808_h = z;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 196 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 197 */     GL11.glPushMatrix();
/* 198 */     GL11.glScalef(this.F, this.F, this.F);
/* 199 */     GL11.glTranslatef(0.0F, (this.F - 1.0F) * -0.74F, 0.0F);
/* 200 */     this.head.func_78785_a(f5);
/* 201 */     this.body.func_78785_a(f5);
/* 202 */     this.rightarm.func_78785_a(f5);
/* 203 */     this.leftarm.func_78785_a(f5);
/* 204 */     this.rightleg.func_78785_a(f5);
/* 205 */     this.leftleg.func_78785_a(f5);
/* 206 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 212 */     this.head.field_78796_g = par4 / 57.295776F;
/* 213 */     this.head.field_78795_f = par5 / 57.295776F;
/* 214 */     this.rightarm.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 2.0F * par2 * 0.5F;
/* 215 */     this.leftarm.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
/* 216 */     this.rightarm.field_78808_h = 0.0F;
/* 217 */     this.leftarm.field_78808_h = 0.0F;
/* 218 */     this.rightleg.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 1.4F * par2;
/* 219 */     this.leftleg.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.4F * par2;
/* 220 */     this.rightleg.field_78796_g = 0.0F;
/* 221 */     this.leftleg.field_78796_g = 0.0F;
/*     */     
/* 223 */     if (this.field_78093_q) {
/*     */       
/* 225 */       this.rightarm.field_78795_f += -0.62831855F;
/* 226 */       this.leftarm.field_78795_f += -0.62831855F;
/* 227 */       this.rightleg.field_78795_f = -1.2566371F;
/* 228 */       this.leftleg.field_78795_f = -1.2566371F;
/* 229 */       this.rightleg.field_78796_g = 0.31415927F;
/* 230 */       this.leftleg.field_78796_g = -0.31415927F;
/*     */     } 
/*     */     
/* 233 */     this.rightarm.field_78796_g = 0.0F;
/* 234 */     this.leftarm.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */     
/* 238 */     if (this.field_78095_p > -9990.0F) {
/*     */       
/* 240 */       float var8 = this.field_78095_p;
/* 241 */       this.body.field_78796_g = MathHelper.func_76126_a(MathHelper.func_76129_c(var8) * 3.1415927F * 2.0F) * 0.2F;
/* 242 */       this.rightarm.field_78798_e = MathHelper.func_76126_a(this.body.field_78796_g) * 5.0F;
/* 243 */       this.rightarm.field_78800_c = -MathHelper.func_76134_b(this.body.field_78796_g) * 5.0F;
/* 244 */       this.leftarm.field_78798_e = -MathHelper.func_76126_a(this.body.field_78796_g) * 5.0F;
/* 245 */       this.leftarm.field_78800_c = MathHelper.func_76134_b(this.body.field_78796_g) * 5.0F;
/* 246 */       this.rightarm.field_78796_g += this.body.field_78796_g;
/* 247 */       this.leftarm.field_78796_g += this.body.field_78796_g;
/* 248 */       this.leftarm.field_78795_f += this.body.field_78796_g;
/* 249 */       var8 = 1.0F - this.field_78095_p;
/* 250 */       var8 *= var8;
/* 251 */       var8 *= var8;
/* 252 */       var8 = 1.0F - var8;
/* 253 */       float var9 = MathHelper.func_76126_a(var8 * 3.1415927F);
/* 254 */       float var10 = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -(this.head.field_78795_f - 0.7F) * 0.75F;
/* 255 */       this.rightarm.field_78795_f = (float)(this.rightarm.field_78795_f - var9 * 1.2D + var10);
/* 256 */       this.rightarm.field_78796_g += this.body.field_78796_g * 2.0F;
/* 257 */       this.rightarm.field_78808_h = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -0.4F;
/*     */     } 
/*     */ 
/*     */     
/* 261 */     this.rightarm.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 262 */     this.leftarm.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 263 */     this.rightarm.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 264 */     this.leftarm.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelYakon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */