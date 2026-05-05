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
/*     */ public class ModelRoshi
/*     */   extends ModelBiped
/*     */ {
/*     */   ModelRenderer head;
/*     */   ModelRenderer body;
/*     */   ModelRenderer rightarm;
/*     */   ModelRenderer leftarm;
/*     */   ModelRenderer rightleg;
/*     */   ModelRenderer leftleg;
/*     */   ModelRenderer turtleshell;
/*     */   ModelRenderer staff;
/*     */   ModelRenderer staff2;
/*  24 */   private float F = 1.0F;
/*     */   public ModelRoshi(float f) {
/*  26 */     this();
/*  27 */     this.F = f;
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelRoshi() {
/*  32 */     this.field_78090_t = 64;
/*  33 */     this.field_78089_u = 64;
/*     */     
/*  35 */     this.head = new ModelRenderer((ModelBase)this, 0, 0);
/*  36 */     this.head.func_78789_a(-4.0F, -12.0F, -4.0F, 8, 8, 8);
/*  37 */     this.head.func_78793_a(0.0F, 8.0F, 0.0F);
/*  38 */     this.head.func_78787_b(64, 64);
/*  39 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/*  40 */     this.body = new ModelRenderer((ModelBase)this, 0, 16);
/*  41 */     this.body.func_78789_a(-4.0F, 0.0F, -2.0F, 8, 10, 4);
/*  42 */     this.body.func_78793_a(0.0F, 4.0F, 0.0F);
/*  43 */     this.body.func_78787_b(64, 64);
/*  44 */     setRotation(this.body, 0.0F, 0.0F, 0.0F);
/*  45 */     this.rightarm = new ModelRenderer((ModelBase)this, 16, 30);
/*  46 */     this.rightarm.func_78789_a(-3.0F, -3.0F, -8.0F, 4, 4, 10);
/*  47 */     this.rightarm.func_78793_a(-5.0F, 7.0F, 0.0F);
/*  48 */     this.rightarm.func_78787_b(64, 64);
/*  49 */     setRotation(this.rightarm, 0.0F, 0.0F, 0.0F);
/*  50 */     this.leftarm = new ModelRenderer((ModelBase)this, 24, 16);
/*  51 */     this.leftarm.func_78789_a(-1.0F, -2.0F, -2.0F, 4, 10, 4);
/*  52 */     this.leftarm.func_78793_a(5.0F, 6.0F, 0.0F);
/*  53 */     this.leftarm.func_78787_b(64, 64);
/*  54 */     this.leftarm.field_78809_i = true;
/*  55 */     setRotation(this.leftarm, 0.0F, 0.0F, 0.0F);
/*  56 */     this.rightleg = new ModelRenderer((ModelBase)this, 0, 30);
/*  57 */     this.rightleg.func_78789_a(-2.0F, 0.0F, -2.0F, 4, 10, 4);
/*  58 */     this.rightleg.func_78793_a(-2.0F, 14.0F, 0.0F);
/*  59 */     this.rightleg.func_78787_b(64, 64);
/*  60 */     this.rightleg.field_78809_i = true;
/*  61 */     setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
/*  62 */     this.leftleg = new ModelRenderer((ModelBase)this, 0, 30);
/*  63 */     this.leftleg.func_78789_a(-2.0F, 0.0F, -2.0F, 4, 10, 4);
/*  64 */     this.leftleg.func_78793_a(2.0F, 14.0F, 0.0F);
/*  65 */     this.leftleg.func_78787_b(64, 64);
/*  66 */     setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
/*  67 */     this.turtleshell = new ModelRenderer((ModelBase)this, 36, 48);
/*  68 */     this.turtleshell.func_78789_a(-5.0F, -1.0F, 2.0F, 10, 12, 4);
/*  69 */     this.turtleshell.func_78793_a(0.0F, 0.0F, 0.0F);
/*  70 */     this.turtleshell.func_78787_b(64, 64);
/*  71 */     setRotation(this.turtleshell, 0.0F, 0.0F, 0.0F);
/*  72 */     this.staff = new ModelRenderer((ModelBase)this, 60, 0);
/*  73 */     this.staff.func_78789_a(-1.0F, -4.0F, -7.0F, 1, 22, 1);
/*  74 */     this.staff.func_78793_a(0.0F, 0.0F, 0.0F);
/*  75 */     this.staff.func_78787_b(64, 32);
/*  76 */     setRotation(this.staff, 0.0F, 0.0F, 0.0F);
/*  77 */     this.staff2 = new ModelRenderer((ModelBase)this, 48, 0);
/*  78 */     this.staff2.func_78789_a(0.0F, -5.0F, -9.0F, 1, 1, 5);
/*  79 */     this.staff2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  80 */     this.staff2.func_78787_b(64, 32);
/*  81 */     setRotation(this.staff2, 0.0F, 0.1745329F, 0.0174533F);
/*     */     
/*  83 */     this.rightarm.func_78792_a(this.staff);
/*  84 */     this.rightarm.func_78792_a(this.staff2);
/*  85 */     this.body.func_78792_a(this.turtleshell);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  91 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*  92 */     GL11.glPushMatrix();
/*  93 */     GL11.glScalef(this.F, this.F, this.F);
/*  94 */     GL11.glTranslatef(0.0F, (this.F - 1.0F) * -0.74F, 0.0F);
/*  95 */     this.head.func_78785_a(f5);
/*  96 */     this.body.func_78785_a(f5);
/*  97 */     this.rightarm.func_78785_a(f5);
/*  98 */     this.leftarm.func_78785_a(f5);
/*  99 */     this.rightleg.func_78785_a(f5);
/* 100 */     this.leftleg.func_78785_a(f5);
/* 101 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 106 */     model.field_78795_f = x;
/* 107 */     model.field_78796_g = y;
/* 108 */     model.field_78808_h = z;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 114 */     this.head.field_78796_g = par4 / 57.295776F;
/* 115 */     this.head.field_78795_f = par5 / 57.295776F;
/* 116 */     this.rightarm.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 2.0F * par2 * 0.5F;
/* 117 */     this.leftarm.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
/* 118 */     this.rightarm.field_78808_h = 0.0F;
/* 119 */     this.leftarm.field_78808_h = 0.0F;
/* 120 */     this.rightleg.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 1.4F * par2;
/* 121 */     this.leftleg.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.4F * par2;
/* 122 */     this.rightleg.field_78796_g = 0.0F;
/* 123 */     this.leftleg.field_78796_g = 0.0F;
/*     */     
/* 125 */     if (this.field_78093_q) {
/*     */       
/* 127 */       this.rightarm.field_78795_f += -0.62831855F;
/* 128 */       this.leftarm.field_78795_f += -0.62831855F;
/* 129 */       this.rightleg.field_78795_f = -1.2566371F;
/* 130 */       this.leftleg.field_78795_f = -1.2566371F;
/* 131 */       this.rightleg.field_78796_g = 0.31415927F;
/* 132 */       this.leftleg.field_78796_g = -0.31415927F;
/*     */     } 
/*     */     
/* 135 */     this.rightarm.field_78796_g = 0.0F;
/* 136 */     this.leftarm.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */     
/* 140 */     if (this.field_78095_p > -9990.0F) {
/*     */       
/* 142 */       float var8 = this.field_78095_p;
/* 143 */       this.body.field_78796_g = MathHelper.func_76126_a(MathHelper.func_76129_c(var8) * 3.1415927F * 2.0F) * 0.2F;
/* 144 */       this.rightarm.field_78798_e = MathHelper.func_76126_a(this.body.field_78796_g) * 5.0F;
/* 145 */       this.rightarm.field_78800_c = -MathHelper.func_76134_b(this.body.field_78796_g) * 5.0F;
/* 146 */       this.leftarm.field_78798_e = -MathHelper.func_76126_a(this.body.field_78796_g) * 5.0F;
/* 147 */       this.leftarm.field_78800_c = MathHelper.func_76134_b(this.body.field_78796_g) * 5.0F;
/* 148 */       this.rightarm.field_78796_g += this.body.field_78796_g;
/* 149 */       this.leftarm.field_78796_g += this.body.field_78796_g;
/* 150 */       this.leftarm.field_78795_f += this.body.field_78796_g;
/* 151 */       var8 = 1.0F - this.field_78095_p;
/* 152 */       var8 *= var8;
/* 153 */       var8 *= var8;
/* 154 */       var8 = 1.0F - var8;
/* 155 */       float var9 = MathHelper.func_76126_a(var8 * 3.1415927F);
/* 156 */       float var10 = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -(this.head.field_78795_f - 0.7F) * 0.75F;
/* 157 */       this.rightarm.field_78795_f = (float)(this.rightarm.field_78795_f - var9 * 1.2D + var10);
/* 158 */       this.rightarm.field_78796_g += this.body.field_78796_g * 2.0F;
/* 159 */       this.rightarm.field_78808_h = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -0.4F;
/*     */     } 
/*     */ 
/*     */     
/* 163 */     this.rightarm.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 164 */     this.leftarm.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 165 */     this.rightarm.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 166 */     this.leftarm.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelRoshi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */