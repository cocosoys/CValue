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
/*     */ public class ModelBabidi
/*     */   extends ModelBiped
/*     */ {
/*     */   ModelRenderer head;
/*     */   ModelRenderer body;
/*     */   ModelRenderer rightarm;
/*     */   ModelRenderer leftarm;
/*     */   ModelRenderer rightleg;
/*     */   ModelRenderer leftleg;
/*     */   ModelRenderer cape1;
/*     */   ModelRenderer cape2;
/*     */   ModelRenderer eye1;
/*     */   ModelRenderer eye2;
/*     */   ModelRenderer mouth;
/*     */   ModelRenderer mouthtenna1;
/*     */   ModelRenderer mouthtenna2;
/*  38 */   private float F = 1.0F;
/*     */   public ModelBabidi(float f) {
/*  40 */     this();
/*  41 */     this.F = f;
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelBabidi() {
/*  46 */     this.field_78090_t = 128;
/*  47 */     this.field_78089_u = 64;
/*     */     
/*  49 */     this.head = new ModelRenderer((ModelBase)this, 0, 0);
/*  50 */     this.head.func_78789_a(-4.0F, -8.0F, -5.0F, 8, 8, 8);
/*  51 */     this.head.func_78793_a(0.0F, 11.0F, -1.0F);
/*  52 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/*  53 */     this.body = new ModelRenderer((ModelBase)this, 16, 16);
/*  54 */     this.body.func_78789_a(-4.0F, 0.0F, -3.0F, 8, 11, 5);
/*  55 */     this.body.func_78793_a(0.0F, 11.0F, 0.0F);
/*  56 */     setRotation(this.body, 0.0F, 0.0F, 0.0F);
/*  57 */     this.rightarm = new ModelRenderer((ModelBase)this, 42, 16);
/*  58 */     this.rightarm.func_78789_a(-1.0F, -1.0F, -1.0F, 2, 7, 2);
/*  59 */     this.rightarm.func_78793_a(-5.0F, 13.0F, 0.0F);
/*  60 */     setRotation(this.rightarm, 0.0F, 0.0F, 0.0F);
/*  61 */     this.leftarm = new ModelRenderer((ModelBase)this, 42, 16);
/*  62 */     this.leftarm.func_78789_a(-1.0F, -1.0F, -1.0F, 2, 7, 2);
/*  63 */     this.leftarm.func_78793_a(5.0F, 13.0F, 0.0F);
/*  64 */     this.leftarm.field_78809_i = true;
/*  65 */     setRotation(this.leftarm, 0.0F, 0.0F, 0.0F);
/*  66 */     this.rightleg = new ModelRenderer((ModelBase)this, 0, 16);
/*  67 */     this.rightleg.func_78789_a(-2.0F, 3.0F, -2.0F, 4, 2, 4);
/*  68 */     this.rightleg.func_78793_a(-2.0F, 19.0F, 0.0F);
/*  69 */     setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
/*  70 */     this.leftleg = new ModelRenderer((ModelBase)this, 0, 16);
/*  71 */     this.leftleg.func_78789_a(-2.0F, 3.0F, -2.0F, 4, 2, 4);
/*  72 */     this.leftleg.func_78793_a(2.0F, 19.0F, 0.0F);
/*  73 */     this.leftleg.field_78809_i = true;
/*  74 */     setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
/*  75 */     this.cape1 = new ModelRenderer((ModelBase)this, 0, 39);
/*  76 */     this.cape1.func_78789_a(-6.0F, 0.0F, 2.0F, 12, 11, 0);
/*  77 */     this.cape1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  78 */     setRotation(this.cape1, 0.2617994F, 0.0F, 0.0F);
/*  79 */     this.cape2 = new ModelRenderer((ModelBase)this, 0, 32);
/*  80 */     this.cape2.func_78789_a(-6.0F, -7.0F, 2.0F, 12, 7, 0);
/*  81 */     this.cape2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  82 */     setRotation(this.cape2, -0.1745329F, 0.0F, 0.0F);
/*  83 */     this.eye1 = new ModelRenderer((ModelBase)this, 32, 7);
/*  84 */     this.eye1.func_78789_a(-5.0F, -5.0F, -6.0F, 3, 3, 2);
/*  85 */     this.eye1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  86 */     setRotation(this.eye1, 0.0F, 0.0F, 0.0F);
/*  87 */     this.eye2 = new ModelRenderer((ModelBase)this, 32, 7);
/*  88 */     this.eye2.func_78789_a(2.0F, -5.0F, -6.0F, 3, 3, 2);
/*  89 */     this.eye2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  90 */     this.eye2.field_78809_i = true;
/*  91 */     setRotation(this.eye2, 0.0F, 0.0F, 0.0F);
/*  92 */     this.mouth = new ModelRenderer((ModelBase)this, 24, 0);
/*  93 */     this.mouth.func_78789_a(-2.0F, -2.0F, -7.0F, 4, 3, 4);
/*  94 */     this.mouth.func_78793_a(0.0F, 0.0F, 0.0F);
/*  95 */     setRotation(this.mouth, 0.0F, 0.0F, 0.0F);
/*  96 */     this.mouthtenna1 = new ModelRenderer((ModelBase)this, 0, 0);
/*  97 */     this.mouthtenna1.func_78789_a(-2.533333F, 0.0F, -6.0F, 1, 3, 1);
/*  98 */     this.mouthtenna1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  99 */     setRotation(this.mouthtenna1, 0.0F, 0.0F, 0.7853982F);
/* 100 */     this.mouthtenna2 = new ModelRenderer((ModelBase)this, 0, 0);
/* 101 */     this.mouthtenna2.func_78789_a(1.466667F, 0.0F, -6.0F, 1, 3, 1);
/* 102 */     this.mouthtenna2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 103 */     this.mouthtenna2.field_78809_i = true;
/* 104 */     setRotation(this.mouthtenna2, 0.0F, 0.0F, -0.7853982F);
/*     */     
/* 106 */     this.head.func_78792_a(this.eye1);
/* 107 */     this.head.func_78792_a(this.eye2);
/* 108 */     this.head.func_78792_a(this.mouth);
/* 109 */     this.head.func_78792_a(this.mouthtenna1);
/* 110 */     this.head.func_78792_a(this.mouthtenna2);
/* 111 */     this.body.func_78792_a(this.cape1);
/* 112 */     this.body.func_78792_a(this.cape2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 118 */     model.field_78795_f = x;
/* 119 */     model.field_78796_g = y;
/* 120 */     model.field_78808_h = z;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 126 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 127 */     GL11.glPushMatrix();
/* 128 */     GL11.glScalef(this.F, this.F, this.F);
/* 129 */     GL11.glTranslatef(0.0F, (this.F - 1.0F) * -0.74F, 0.0F);
/* 130 */     this.head.func_78785_a(f5);
/* 131 */     this.body.func_78785_a(f5);
/* 132 */     this.rightarm.func_78785_a(f5);
/* 133 */     this.leftarm.func_78785_a(f5);
/* 134 */     this.rightleg.func_78785_a(f5);
/* 135 */     this.leftleg.func_78785_a(f5);
/* 136 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 142 */     this.head.field_78796_g = par4 / 57.295776F;
/* 143 */     this.head.field_78795_f = par5 / 57.295776F;
/* 144 */     this.rightarm.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 2.0F * par2 * 0.5F;
/* 145 */     this.leftarm.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
/* 146 */     this.rightarm.field_78808_h = 0.0F;
/* 147 */     this.leftarm.field_78808_h = 0.0F;
/* 148 */     this.rightleg.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 1.4F * par2;
/* 149 */     this.leftleg.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.4F * par2;
/* 150 */     this.rightleg.field_78796_g = 0.0F;
/* 151 */     this.leftleg.field_78796_g = 0.0F;
/*     */     
/* 153 */     if (this.field_78093_q) {
/*     */       
/* 155 */       this.rightarm.field_78795_f += -0.62831855F;
/* 156 */       this.leftarm.field_78795_f += -0.62831855F;
/* 157 */       this.rightleg.field_78795_f = -1.2566371F;
/* 158 */       this.leftleg.field_78795_f = -1.2566371F;
/* 159 */       this.rightleg.field_78796_g = 0.31415927F;
/* 160 */       this.leftleg.field_78796_g = -0.31415927F;
/*     */     } 
/*     */     
/* 163 */     this.rightarm.field_78796_g = 0.0F;
/* 164 */     this.leftarm.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */     
/* 168 */     if (this.field_78095_p > -9990.0F) {
/*     */       
/* 170 */       float var8 = this.field_78095_p;
/* 171 */       this.body.field_78796_g = MathHelper.func_76126_a(MathHelper.func_76129_c(var8) * 3.1415927F * 2.0F) * 0.2F;
/* 172 */       this.rightarm.field_78798_e = MathHelper.func_76126_a(this.body.field_78796_g) * 5.0F;
/* 173 */       this.rightarm.field_78800_c = -MathHelper.func_76134_b(this.body.field_78796_g) * 5.0F;
/* 174 */       this.leftarm.field_78798_e = -MathHelper.func_76126_a(this.body.field_78796_g) * 5.0F;
/* 175 */       this.leftarm.field_78800_c = MathHelper.func_76134_b(this.body.field_78796_g) * 5.0F;
/* 176 */       this.rightarm.field_78796_g += this.body.field_78796_g;
/* 177 */       this.leftarm.field_78796_g += this.body.field_78796_g;
/* 178 */       this.leftarm.field_78795_f += this.body.field_78796_g;
/* 179 */       var8 = 1.0F - this.field_78095_p;
/* 180 */       var8 *= var8;
/* 181 */       var8 *= var8;
/* 182 */       var8 = 1.0F - var8;
/* 183 */       float var9 = MathHelper.func_76126_a(var8 * 3.1415927F);
/* 184 */       float var10 = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -(this.head.field_78795_f - 0.7F) * 0.75F;
/* 185 */       this.rightarm.field_78795_f = (float)(this.rightarm.field_78795_f - var9 * 1.2D + var10);
/* 186 */       this.rightarm.field_78796_g += this.body.field_78796_g * 2.0F;
/* 187 */       this.rightarm.field_78808_h = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -0.4F;
/*     */     } 
/*     */ 
/*     */     
/* 191 */     this.rightarm.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 192 */     this.leftarm.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 193 */     this.rightarm.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 194 */     this.leftarm.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelBabidi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */