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
/*     */ public class ModelSaibaiman
/*     */   extends ModelBiped
/*     */ {
/*     */   ModelRenderer head;
/*     */   ModelRenderer body;
/*     */   ModelRenderer rightarm;
/*     */   ModelRenderer leftarm;
/*     */   ModelRenderer rightleg;
/*     */   ModelRenderer leftleg;
/*     */   
/*     */   public ModelSaibaiman() {
/*  28 */     float var1 = 8.0F;
/*     */ 
/*     */     
/*  31 */     this.head = new ModelRenderer((ModelBase)this, 0, 0);
/*  32 */     this.head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  33 */     this.head.func_78793_a(0.0F, 0.0F + var1, 0.0F);
/*  34 */     this.body = new ModelRenderer((ModelBase)this, 16, 16);
/*  35 */     this.body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 8, 4, 0.0F);
/*  36 */     this.body.func_78793_a(0.0F, 8.0F, 0.0F);
/*  37 */     this.rightarm = new ModelRenderer((ModelBase)this, 40, 16);
/*  38 */     this.rightarm.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F);
/*  39 */     this.rightarm.func_78793_a(-5.0F, 10.0F, 0.0F);
/*  40 */     this.leftarm = new ModelRenderer((ModelBase)this, 40, 16);
/*  41 */     this.leftarm.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F);
/*  42 */     this.leftarm.func_78793_a(5.0F, 10.0F, 0.0F);
/*  43 */     this.leftarm.field_78809_i = true;
/*  44 */     this.rightleg = new ModelRenderer((ModelBase)this, 0, 16);
/*  45 */     this.rightleg.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F);
/*  46 */     this.rightleg.func_78793_a(-2.0F, 16.0F, 0.0F);
/*  47 */     this.leftleg = new ModelRenderer((ModelBase)this, 0, 16);
/*  48 */     this.leftleg.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F);
/*  49 */     this.leftleg.func_78793_a(2.0F, 16.0F, 0.0F);
/*  50 */     this.leftleg.field_78809_i = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  55 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*  56 */     if (this.field_78091_s) {
/*  57 */       float var8 = 2.0F;
/*  58 */       GL11.glPushMatrix();
/*  59 */       GL11.glScalef(1.5F / var8, 1.5F / var8, 1.5F / var8);
/*  60 */       GL11.glTranslatef(0.0F, 16.0F * f5, 0.0F);
/*  61 */       this.head.func_78785_a(f5);
/*  62 */       GL11.glPopMatrix();
/*  63 */       GL11.glPushMatrix();
/*  64 */       GL11.glScalef(1.0F / var8, 1.0F / var8, 1.0F / var8);
/*  65 */       GL11.glTranslatef(0.0F, 24.0F * f5, 0.0F);
/*  66 */       this.body.func_78785_a(f5);
/*  67 */       this.rightarm.func_78785_a(f5);
/*  68 */       this.leftarm.func_78785_a(f5);
/*  69 */       this.rightleg.func_78785_a(f5);
/*  70 */       this.leftleg.func_78785_a(f5);
/*  71 */       GL11.glPopMatrix();
/*     */     } else {
/*  73 */       this.head.func_78785_a(f5);
/*  74 */       this.body.func_78785_a(f5);
/*  75 */       this.rightarm.func_78785_a(f5);
/*  76 */       this.leftarm.func_78785_a(f5);
/*  77 */       this.rightleg.func_78785_a(f5);
/*  78 */       this.leftleg.func_78785_a(f5);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/*  90 */     this.head.field_78796_g = par4 / 57.295776F;
/*  91 */     this.head.field_78795_f = par5 / 57.295776F;
/*     */ 
/*     */     
/*  94 */     this.rightarm.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 2.0F * par2 * 0.5F;
/*  95 */     this.leftarm.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
/*  96 */     this.rightarm.field_78808_h = 0.0F;
/*  97 */     this.leftarm.field_78808_h = 0.0F;
/*  98 */     this.rightleg.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 1.4F * par2;
/*  99 */     this.leftleg.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.4F * par2;
/* 100 */     this.rightleg.field_78796_g = 0.0F;
/* 101 */     this.leftleg.field_78796_g = 0.0F;
/*     */     
/* 103 */     if (this.field_78093_q) {
/* 104 */       this.rightarm.field_78795_f += -0.62831855F;
/* 105 */       this.leftarm.field_78795_f += -0.62831855F;
/* 106 */       this.rightleg.field_78795_f = -1.2566371F;
/* 107 */       this.leftleg.field_78795_f = -1.2566371F;
/* 108 */       this.rightleg.field_78796_g = 0.31415927F;
/* 109 */       this.leftleg.field_78796_g = -0.31415927F;
/*     */     } 
/*     */     
/* 112 */     if (this.field_78119_l != 0) {
/* 113 */       this.leftarm.field_78795_f = this.leftarm.field_78795_f * 0.5F - 0.31415927F * this.field_78119_l;
/*     */     }
/*     */     
/* 116 */     if (this.field_78120_m != 0) {
/* 117 */       this.rightarm.field_78795_f = this.rightarm.field_78795_f * 0.5F - 0.31415927F * this.field_78120_m;
/*     */     }
/*     */     
/* 120 */     this.rightarm.field_78796_g = 0.0F;
/* 121 */     this.leftarm.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */     
/* 125 */     if (this.field_78095_p > -9990.0F) {
/* 126 */       float var8 = this.field_78095_p;
/* 127 */       this.body.field_78796_g = MathHelper.func_76126_a(MathHelper.func_76129_c(var8) * 3.1415927F * 2.0F) * 0.2F;
/* 128 */       this.rightarm.field_78798_e = MathHelper.func_76126_a(this.body.field_78796_g) * 5.0F;
/* 129 */       this.rightarm.field_78800_c = -MathHelper.func_76134_b(this.body.field_78796_g) * 5.0F;
/* 130 */       this.leftarm.field_78798_e = -MathHelper.func_76126_a(this.body.field_78796_g) * 5.0F;
/* 131 */       this.leftarm.field_78800_c = MathHelper.func_76134_b(this.body.field_78796_g) * 5.0F;
/* 132 */       this.rightarm.field_78796_g += this.body.field_78796_g;
/* 133 */       this.leftarm.field_78796_g += this.body.field_78796_g;
/* 134 */       this.leftarm.field_78795_f += this.body.field_78796_g;
/* 135 */       var8 = 1.0F - this.field_78095_p;
/* 136 */       var8 *= var8;
/* 137 */       var8 *= var8;
/* 138 */       var8 = 1.0F - var8;
/* 139 */       float var9 = MathHelper.func_76126_a(var8 * 3.1415927F);
/* 140 */       float var10 = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -(this.head.field_78795_f - 0.7F) * 0.75F;
/* 141 */       this.rightarm.field_78795_f = (float)(this.rightarm.field_78795_f - var9 * 1.2D + var10);
/* 142 */       this.rightarm.field_78796_g += this.body.field_78796_g * 2.0F;
/* 143 */       this.rightarm.field_78808_h = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -0.4F;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 148 */     this.rightarm.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 149 */     this.leftarm.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 150 */     this.rightarm.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 151 */     this.leftarm.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelSaibaiman.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */