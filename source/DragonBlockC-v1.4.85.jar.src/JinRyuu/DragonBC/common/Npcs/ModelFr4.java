/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelFr4
/*     */   extends ModelBiped
/*     */ {
/*     */   ModelRenderer head;
/*     */   ModelRenderer body;
/*     */   ModelRenderer rightarm;
/*     */   ModelRenderer leftarm;
/*     */   ModelRenderer rightleg;
/*     */   ModelRenderer leftleg;
/*     */   ModelRenderer body2;
/*     */   ModelRenderer body3;
/*     */   ModelRenderer tail1;
/*     */   ModelRenderer tail2;
/*     */   
/*     */   public ModelFr4() {
/*  24 */     this.field_78090_t = 128;
/*  25 */     this.field_78089_u = 64;
/*     */     
/*  27 */     this.head = new ModelRenderer((ModelBase)this, 0, 0);
/*  28 */     this.head.func_78789_a(-4.0F, -8.0F, -4.0F, 8, 8, 8);
/*  29 */     this.head.func_78793_a(0.0F, 0.0F, 0.0F);
/*  30 */     this.head.func_78787_b(128, 64);
/*  31 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/*  32 */     this.body = new ModelRenderer((ModelBase)this, 64, 0);
/*  33 */     this.body.func_78789_a(-4.0F, 0.0F, -2.0F, 8, 5, 4);
/*  34 */     this.body.func_78793_a(0.0F, 0.0F, 0.0F);
/*  35 */     this.body.func_78787_b(128, 64);
/*  36 */     setRotation(this.body, 0.0F, 0.0F, 0.0F);
/*  37 */     this.rightarm = new ModelRenderer((ModelBase)this, 40, 16);
/*  38 */     this.rightarm.func_78789_a(-3.0F, -2.0F, -2.0F, 4, 12, 4);
/*  39 */     this.rightarm.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  40 */     this.rightarm.func_78787_b(128, 64);
/*  41 */     setRotation(this.rightarm, 0.0F, 0.0F, 0.0F);
/*  42 */     this.leftarm = new ModelRenderer((ModelBase)this, 64, 48);
/*  43 */     this.leftarm.field_78809_i = true;
/*  44 */     this.leftarm.func_78789_a(-1.0F, -2.0F, -2.0F, 4, 12, 4);
/*  45 */     this.leftarm.func_78793_a(5.0F, 2.0F, 0.0F);
/*  46 */     this.leftarm.func_78787_b(128, 64);
/*  47 */     setRotation(this.leftarm, 0.0F, 0.0F, 0.0F);
/*  48 */     this.rightleg = new ModelRenderer((ModelBase)this, 0, 16);
/*  49 */     this.rightleg.func_78789_a(-2.0F, 0.0F, -2.0F, 4, 12, 4);
/*  50 */     this.rightleg.func_78793_a(-2.0F, 12.0F, 0.0F);
/*  51 */     this.rightleg.func_78787_b(128, 64);
/*  52 */     setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
/*  53 */     this.leftleg = new ModelRenderer((ModelBase)this, 0, 16);
/*  54 */     this.leftleg.field_78809_i = true;
/*  55 */     this.leftleg.func_78789_a(-2.0F, 0.0F, -2.0F, 4, 12, 4);
/*  56 */     this.leftleg.func_78793_a(2.0F, 12.0F, 0.0F);
/*  57 */     this.leftleg.func_78787_b(128, 64);
/*  58 */     setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
/*  59 */     this.body2 = new ModelRenderer((ModelBase)this, 64, 12);
/*  60 */     this.body2.func_78789_a(-3.5F, 1.0F, -1.933333F, 7, 4, 1);
/*  61 */     this.body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  62 */     this.body2.func_78787_b(128, 64);
/*  63 */     setRotation(this.body2, -0.1745329F, 0.0F, 0.0F);
/*  64 */     this.body3 = new ModelRenderer((ModelBase)this, 16, 16);
/*  65 */     this.body3.func_78789_a(-3.5F, 5.0F, -2.0F, 7, 7, 4);
/*  66 */     this.body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  67 */     this.body3.func_78787_b(128, 64);
/*  68 */     setRotation(this.body3, 0.0F, 0.0F, 0.0F);
/*  69 */     this.tail1 = new ModelRenderer((ModelBase)this, 32, 48);
/*  70 */     this.tail1.func_78789_a(-2.0F, 7.0F, 4.0F, 4, 4, 12);
/*  71 */     this.tail1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  72 */     this.tail1.func_78787_b(128, 64);
/*  73 */     setRotation(this.tail1, -0.3490659F, 0.0F, 0.0F);
/*  74 */     this.tail2 = new ModelRenderer((ModelBase)this, 32, 48);
/*  75 */     this.tail2.func_78789_a(-2.0F, 15.0F, 2.0F, 4, 4, 12);
/*  76 */     this.tail2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  77 */     this.tail2.func_78787_b(128, 64);
/*  78 */     setRotation(this.tail2, 0.5235988F, 0.0F, 0.0F);
/*  79 */     this.body.func_78792_a(this.body2);
/*  80 */     this.body.func_78792_a(this.body3);
/*  81 */     this.body.func_78792_a(this.tail1);
/*  82 */     this.body.func_78792_a(this.tail2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  87 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*  88 */     this.head.func_78785_a(f5);
/*  89 */     this.body.func_78785_a(f5);
/*  90 */     this.rightarm.func_78785_a(f5);
/*  91 */     this.leftarm.func_78785_a(f5);
/*  92 */     this.rightleg.func_78785_a(f5);
/*  93 */     this.leftleg.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/*  98 */     model.field_78795_f = x;
/*  99 */     model.field_78796_g = y;
/* 100 */     model.field_78808_h = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 105 */     this.head.field_78796_g = par4 / 57.295776F;
/* 106 */     this.head.field_78795_f = par5 / 57.295776F;
/* 107 */     this.rightarm.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 2.0F * par2 * 0.5F;
/* 108 */     this.leftarm.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
/* 109 */     this.rightarm.field_78808_h = 0.0F;
/* 110 */     this.leftarm.field_78808_h = 0.0F;
/* 111 */     this.rightleg.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 1.4F * par2;
/* 112 */     this.leftleg.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.4F * par2;
/* 113 */     this.rightleg.field_78796_g = 0.0F;
/* 114 */     this.leftleg.field_78796_g = 0.0F;
/*     */     
/* 116 */     if (this.field_78093_q) {
/*     */       
/* 118 */       this.rightarm.field_78795_f += -0.62831855F;
/* 119 */       this.leftarm.field_78795_f += -0.62831855F;
/* 120 */       this.rightleg.field_78795_f = -1.2566371F;
/* 121 */       this.leftleg.field_78795_f = -1.2566371F;
/* 122 */       this.rightleg.field_78796_g = 0.31415927F;
/* 123 */       this.leftleg.field_78796_g = -0.31415927F;
/*     */     } 
/*     */     
/* 126 */     this.rightarm.field_78796_g = 0.0F;
/* 127 */     this.leftarm.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */     
/* 131 */     if (this.field_78095_p > -9990.0F) {
/*     */       
/* 133 */       float var8 = this.field_78095_p;
/* 134 */       this.body.field_78796_g = MathHelper.func_76126_a(MathHelper.func_76129_c(var8) * 3.1415927F * 2.0F) * 0.2F;
/* 135 */       this.rightarm.field_78798_e = MathHelper.func_76126_a(this.body.field_78796_g) * 5.0F;
/* 136 */       this.rightarm.field_78800_c = -MathHelper.func_76134_b(this.body.field_78796_g) * 5.0F;
/* 137 */       this.leftarm.field_78798_e = -MathHelper.func_76126_a(this.body.field_78796_g) * 5.0F;
/* 138 */       this.leftarm.field_78800_c = MathHelper.func_76134_b(this.body.field_78796_g) * 5.0F;
/* 139 */       this.rightarm.field_78796_g += this.body.field_78796_g;
/* 140 */       this.leftarm.field_78796_g += this.body.field_78796_g;
/* 141 */       this.leftarm.field_78795_f += this.body.field_78796_g;
/* 142 */       var8 = 1.0F - this.field_78095_p;
/* 143 */       var8 *= var8;
/* 144 */       var8 *= var8;
/* 145 */       var8 = 1.0F - var8;
/* 146 */       float var9 = MathHelper.func_76126_a(var8 * 3.1415927F);
/* 147 */       float var10 = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -(this.head.field_78795_f - 0.7F) * 0.75F;
/* 148 */       this.rightarm.field_78795_f = (float)(this.rightarm.field_78795_f - var9 * 1.2D + var10);
/* 149 */       this.rightarm.field_78796_g += this.body.field_78796_g * 2.0F;
/* 150 */       this.rightarm.field_78808_h = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -0.4F;
/*     */     } 
/*     */ 
/*     */     
/* 154 */     this.rightarm.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 155 */     this.leftarm.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 156 */     this.rightarm.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 157 */     this.leftarm.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelFr4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */