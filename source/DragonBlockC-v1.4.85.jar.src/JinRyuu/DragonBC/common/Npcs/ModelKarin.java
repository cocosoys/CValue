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
/*     */ public class ModelKarin
/*     */   extends ModelBiped
/*     */ {
/*     */   ModelRenderer head;
/*     */   ModelRenderer body;
/*     */   ModelRenderer rightarm;
/*     */   ModelRenderer leftarm;
/*     */   ModelRenderer rightleg;
/*     */   ModelRenderer leftleg;
/*     */   ModelRenderer staff;
/*     */   ModelRenderer staff2;
/*     */   ModelRenderer ear1;
/*     */   ModelRenderer ear2;
/*     */   ModelRenderer tail;
/*  35 */   private float F = 1.0F;
/*     */   public ModelKarin(float f) {
/*  37 */     this();
/*  38 */     this.F = f;
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelKarin() {
/*  43 */     this.field_78090_t = 64;
/*  44 */     this.field_78089_u = 32;
/*     */     
/*  46 */     this.head = new ModelRenderer((ModelBase)this, 0, 0);
/*  47 */     this.head.func_78789_a(-4.0F, -6.0F, -3.0F, 8, 6, 6);
/*  48 */     this.head.func_78793_a(0.0F, 15.0F, 0.0F);
/*  49 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/*  50 */     this.body = new ModelRenderer((ModelBase)this, 20, 16);
/*  51 */     this.body.func_78789_a(-4.0F, 0.0F, -3.0F, 8, 8, 6);
/*  52 */     this.body.func_78793_a(0.0F, 15.0F, 0.0F);
/*  53 */     setRotation(this.body, 0.0F, 0.0F, 0.0F);
/*  54 */     this.rightarm = new ModelRenderer((ModelBase)this, 32, 0);
/*  55 */     this.rightarm.func_78789_a(-2.0F, -2.0F, -5.0F, 3, 3, 8);
/*  56 */     this.rightarm.func_78793_a(-5.0F, 17.0F, 0.0F);
/*  57 */     setRotation(this.rightarm, 0.0F, 0.0F, 0.0F);
/*  58 */     this.leftarm = new ModelRenderer((ModelBase)this, 48, 16);
/*  59 */     this.leftarm.field_78809_i = true;
/*  60 */     this.leftarm.func_78789_a(-1.0F, -2.0F, -1.0F, 3, 7, 3);
/*  61 */     this.leftarm.func_78793_a(5.0F, 17.0F, 0.0F);
/*  62 */     setRotation(this.leftarm, 0.0F, 0.0F, 0.0F);
/*  63 */     this.rightleg = new ModelRenderer((ModelBase)this, 0, 25);
/*  64 */     this.rightleg.func_78789_a(-2.0F, 0.0F, -4.0F, 4, 1, 6);
/*  65 */     this.rightleg.func_78793_a(-2.0F, 23.0F, 0.0F);
/*  66 */     setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
/*  67 */     this.leftleg = new ModelRenderer((ModelBase)this, 0, 25);
/*  68 */     this.leftleg.field_78809_i = true;
/*  69 */     this.leftleg.func_78789_a(-2.0F, 0.0F, -4.0F, 4, 1, 6);
/*  70 */     this.leftleg.func_78793_a(2.0F, 23.0F, 0.0F);
/*  71 */     setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
/*  72 */     this.staff = new ModelRenderer((ModelBase)this, 60, 0);
/*  73 */     this.staff.func_78789_a(-1.0F, -8.0F, -4.0F, 1, 15, 1);
/*  74 */     this.staff.func_78793_a(0.0F, 0.0F, 0.0F);
/*  75 */     setRotation(this.staff, 0.0F, 0.0F, 0.0F);
/*  76 */     this.staff2 = new ModelRenderer((ModelBase)this, 48, 0);
/*  77 */     this.staff2.func_78789_a(0.0F, -8.0F, -6.0F, 1, 1, 5);
/*  78 */     this.staff2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  79 */     setRotation(this.staff2, 0.0F, 0.3141593F, 0.0174533F);
/*  80 */     this.ear1 = new ModelRenderer((ModelBase)this, 0, 0);
/*  81 */     this.ear1.field_78809_i = true;
/*  82 */     this.ear1.func_78789_a(1.0F, -7.3F, -1.0F, 2, 2, 1);
/*  83 */     this.ear1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  84 */     setRotation(this.ear1, 0.0F, 0.0F, -0.7853982F);
/*  85 */     this.ear2 = new ModelRenderer((ModelBase)this, 0, 0);
/*  86 */     this.ear2.func_78789_a(-3.0F, -7.333333F, -1.0F, 2, 2, 1);
/*  87 */     this.ear2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  88 */     setRotation(this.ear2, 0.0F, 0.0F, 0.7853982F);
/*  89 */     this.tail = new ModelRenderer((ModelBase)this, 0, 22);
/*  90 */     this.tail.func_78789_a(3.0F, -4.666667F, 5.333333F, 1, 8, 1);
/*  91 */     this.tail.func_78793_a(0.0F, 0.0F, 0.0F);
/*  92 */     setRotation(this.tail, -0.6632251F, 0.0F, 0.4712389F);
/*     */     
/*  94 */     this.head.func_78792_a(this.ear1);
/*  95 */     this.head.func_78792_a(this.ear2);
/*  96 */     this.rightarm.func_78792_a(this.staff);
/*  97 */     this.rightarm.func_78792_a(this.staff2);
/*  98 */     this.body.func_78792_a(this.tail);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 104 */     model.field_78795_f = x;
/* 105 */     model.field_78796_g = y;
/* 106 */     model.field_78808_h = z;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 112 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 113 */     GL11.glPushMatrix();
/* 114 */     GL11.glScalef(this.F, this.F, this.F);
/* 115 */     GL11.glTranslatef(0.0F, (this.F - 1.0F) * -0.74F, 0.0F);
/* 116 */     this.head.func_78785_a(f5);
/* 117 */     this.body.func_78785_a(f5);
/* 118 */     this.rightarm.func_78785_a(f5);
/* 119 */     this.leftarm.func_78785_a(f5);
/* 120 */     this.rightleg.func_78785_a(f5);
/* 121 */     this.leftleg.func_78785_a(f5);
/* 122 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 128 */     this.head.field_78796_g = par4 / 57.295776F;
/* 129 */     this.head.field_78795_f = par5 / 57.295776F;
/* 130 */     this.rightarm.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 2.0F * par2 * 0.5F;
/* 131 */     this.leftarm.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
/* 132 */     this.rightarm.field_78808_h = 0.0F;
/* 133 */     this.leftarm.field_78808_h = 0.0F;
/* 134 */     this.rightleg.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 1.4F * par2;
/* 135 */     this.leftleg.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.4F * par2;
/* 136 */     this.rightleg.field_78796_g = 0.0F;
/* 137 */     this.leftleg.field_78796_g = 0.0F;
/*     */     
/* 139 */     if (this.field_78093_q) {
/*     */       
/* 141 */       this.rightarm.field_78795_f += -0.62831855F;
/* 142 */       this.leftarm.field_78795_f += -0.62831855F;
/* 143 */       this.rightleg.field_78795_f = -1.2566371F;
/* 144 */       this.leftleg.field_78795_f = -1.2566371F;
/* 145 */       this.rightleg.field_78796_g = 0.31415927F;
/* 146 */       this.leftleg.field_78796_g = -0.31415927F;
/*     */     } 
/*     */     
/* 149 */     this.rightarm.field_78796_g = 0.0F;
/* 150 */     this.leftarm.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */     
/* 154 */     if (this.field_78095_p > -9990.0F) {
/*     */       
/* 156 */       float var8 = this.field_78095_p;
/* 157 */       this.body.field_78796_g = MathHelper.func_76126_a(MathHelper.func_76129_c(var8) * 3.1415927F * 2.0F) * 0.2F;
/* 158 */       this.rightarm.field_78798_e = MathHelper.func_76126_a(this.body.field_78796_g) * 5.0F;
/* 159 */       this.rightarm.field_78800_c = -MathHelper.func_76134_b(this.body.field_78796_g) * 5.0F;
/* 160 */       this.leftarm.field_78798_e = -MathHelper.func_76126_a(this.body.field_78796_g) * 5.0F;
/* 161 */       this.leftarm.field_78800_c = MathHelper.func_76134_b(this.body.field_78796_g) * 5.0F;
/* 162 */       this.rightarm.field_78796_g += this.body.field_78796_g;
/* 163 */       this.leftarm.field_78796_g += this.body.field_78796_g;
/* 164 */       this.leftarm.field_78795_f += this.body.field_78796_g;
/* 165 */       var8 = 1.0F - this.field_78095_p;
/* 166 */       var8 *= var8;
/* 167 */       var8 *= var8;
/* 168 */       var8 = 1.0F - var8;
/* 169 */       float var9 = MathHelper.func_76126_a(var8 * 3.1415927F);
/* 170 */       float var10 = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -(this.head.field_78795_f - 0.7F) * 0.75F;
/* 171 */       this.rightarm.field_78795_f = (float)(this.rightarm.field_78795_f - var9 * 1.2D + var10);
/* 172 */       this.rightarm.field_78796_g += this.body.field_78796_g * 2.0F;
/* 173 */       this.rightarm.field_78808_h = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -0.4F;
/*     */     } 
/*     */ 
/*     */     
/* 177 */     this.rightarm.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 178 */     this.leftarm.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 179 */     this.rightarm.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 180 */     this.leftarm.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelKarin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */