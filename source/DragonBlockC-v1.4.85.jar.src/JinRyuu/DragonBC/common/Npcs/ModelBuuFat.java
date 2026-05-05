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
/*     */ public class ModelBuuFat
/*     */   extends ModelBiped
/*     */ {
/*     */   ModelRenderer head;
/*     */   ModelRenderer body;
/*     */   ModelRenderer body2;
/*     */   ModelRenderer rightarm;
/*     */   ModelRenderer leftarm;
/*     */   ModelRenderer rightleg;
/*     */   ModelRenderer leftleg;
/*     */   ModelRenderer headtail1;
/*     */   ModelRenderer headtail2;
/*     */   ModelRenderer headtail3;
/*     */   ModelRenderer cape;
/*  36 */   private float F = 1.0F;
/*     */   public ModelBuuFat(float f) {
/*  38 */     this();
/*  39 */     this.F = f;
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelBuuFat() {
/*  44 */     this.field_78090_t = 128;
/*  45 */     this.field_78089_u = 64;
/*     */     
/*  47 */     this.head = new ModelRenderer((ModelBase)this, 0, 0);
/*  48 */     this.head.func_78789_a(-4.0F, -8.0F, -4.0F, 8, 8, 8);
/*  49 */     this.head.func_78793_a(0.0F, 0.0F, 0.0F);
/*  50 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/*  51 */     this.body = new ModelRenderer((ModelBase)this, 0, 16);
/*  52 */     this.body.func_78789_a(-6.0F, 0.0F, -3.0F, 12, 8, 6);
/*  53 */     this.body.func_78793_a(0.0F, 0.0F, 0.0F);
/*  54 */     setRotation(this.body, 0.0F, 0.0F, 0.0F);
/*  55 */     this.body2 = new ModelRenderer((ModelBase)this, 0, 30);
/*  56 */     this.body2.func_78789_a(-7.0F, 8.0F, -4.0F, 14, 8, 8);
/*  57 */     this.body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  58 */     setRotation(this.body2, 0.0F, 0.0F, 0.0F);
/*  59 */     this.rightarm = new ModelRenderer((ModelBase)this, 36, 16);
/*  60 */     this.rightarm.func_78789_a(-5.0F, -2.0F, -2.0F, 4, 10, 4);
/*  61 */     this.rightarm.func_78793_a(-6.0F, 2.0F, 0.0F);
/*  62 */     setRotation(this.rightarm, 0.0F, 0.0F, 0.1745329F);
/*  63 */     this.leftarm = new ModelRenderer((ModelBase)this, 36, 16);
/*  64 */     this.leftarm.func_78789_a(1.0F, -2.0F, -2.0F, 4, 10, 4);
/*  65 */     this.leftarm.func_78793_a(6.0F, 2.0F, 0.0F);
/*  66 */     this.leftarm.field_78809_i = true;
/*  67 */     setRotation(this.leftarm, 0.0F, 0.0F, -0.1745329F);
/*  68 */     this.rightleg = new ModelRenderer((ModelBase)this, 0, 46);
/*  69 */     this.rightleg.func_78789_a(-2.0F, 0.0F, -2.0F, 4, 8, 4);
/*  70 */     this.rightleg.func_78793_a(-4.0F, 16.0F, 0.0F);
/*  71 */     setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
/*  72 */     this.leftleg = new ModelRenderer((ModelBase)this, 0, 46);
/*  73 */     this.leftleg.func_78789_a(0.0F, 0.0F, -2.0F, 4, 8, 4);
/*  74 */     this.leftleg.func_78793_a(2.0F, 16.0F, 0.0F);
/*  75 */     this.leftleg.field_78809_i = true;
/*  76 */     setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
/*  77 */     this.headtail1 = new ModelRenderer((ModelBase)this, 52, 0);
/*  78 */     this.headtail1.func_78789_a(-2.0F, -10.0F, -6.0F, 4, 5, 4);
/*  79 */     this.headtail1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  80 */     setRotation(this.headtail1, -0.6283185F, 0.0F, 0.0F);
/*  81 */     this.headtail2 = new ModelRenderer((ModelBase)this, 40, 0);
/*  82 */     this.headtail2.func_78789_a(-1.5F, -12.0F, -8.0F, 3, 4, 3);
/*  83 */     this.headtail2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  84 */     setRotation(this.headtail2, -0.8901179F, 0.0F, 0.0F);
/*  85 */     this.headtail3 = new ModelRenderer((ModelBase)this, 32, 0);
/*  86 */     this.headtail3.func_78789_a(-1.0F, -12.0F, -11.0F, 2, 4, 2);
/*  87 */     this.headtail3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  88 */     setRotation(this.headtail3, -1.22173F, 0.0F, 0.0F);
/*  89 */     this.cape = new ModelRenderer((ModelBase)this, 44, 30);
/*  90 */     this.cape.func_78789_a(-7.0F, 1.0F, 3.0F, 14, 20, 0);
/*  91 */     this.cape.func_78793_a(0.0F, 0.0F, 0.0F);
/*  92 */     setRotation(this.cape, 0.2268928F, 0.0F, 0.0F);
/*     */     
/*  94 */     this.head.func_78792_a(this.headtail1);
/*  95 */     this.head.func_78792_a(this.headtail2);
/*  96 */     this.head.func_78792_a(this.headtail3);
/*  97 */     this.body.func_78792_a(this.cape);
/*  98 */     this.body.func_78792_a(this.body2);
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
/* 132 */     this.rightarm.field_78808_h = 0.1745329F;
/* 133 */     this.leftarm.field_78808_h = -0.1745329F;
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
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 177 */     float rota = -MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 178 */     if (rota > 0.0F) rota *= -1.0F; 
/* 179 */     this.cape.field_78795_f = -0.23F + rota;
/* 180 */     if (0.0F > this.cape.field_78795_f) this.cape.field_78795_f *= -1.0F; 
/* 181 */     this.cape.field_78796_g = 0.0F;
/*     */     
/* 183 */     this.rightarm.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 184 */     this.leftarm.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 185 */     this.rightarm.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 186 */     this.leftarm.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelBuuFat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */