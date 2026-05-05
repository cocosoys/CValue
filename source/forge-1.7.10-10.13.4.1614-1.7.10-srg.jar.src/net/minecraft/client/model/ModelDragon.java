/*     */ package net.minecraft.client.model;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.boss.EntityDragon;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ModelDragon
/*     */   extends ModelBase
/*     */ {
/*     */   private ModelRenderer field_78221_a;
/*     */   private ModelRenderer field_78219_b;
/*     */   private ModelRenderer field_78220_c;
/*     */   private ModelRenderer field_78217_d;
/*     */   private ModelRenderer field_78218_e;
/*     */   private ModelRenderer field_78215_f;
/*     */   private ModelRenderer field_78216_g;
/*     */   private ModelRenderer field_78226_h;
/*     */   private ModelRenderer field_78227_i;
/*     */   private ModelRenderer field_78224_j;
/*     */   private ModelRenderer field_78225_k;
/*     */   private ModelRenderer field_78222_l;
/*     */   private float field_78223_m;
/*     */   private static final String __OBFID = "CL_00000870";
/*     */   
/*     */   public ModelDragon(float p_i1169_1_) {
/*  30 */     this.field_78090_t = 256;
/*  31 */     this.field_78089_u = 256;
/*     */     
/*  33 */     func_78085_a("body.body", 0, 0);
/*  34 */     func_78085_a("wing.skin", -56, 88);
/*  35 */     func_78085_a("wingtip.skin", -56, 144);
/*  36 */     func_78085_a("rearleg.main", 0, 0);
/*  37 */     func_78085_a("rearfoot.main", 112, 0);
/*  38 */     func_78085_a("rearlegtip.main", 196, 0);
/*  39 */     func_78085_a("head.upperhead", 112, 30);
/*  40 */     func_78085_a("wing.bone", 112, 88);
/*  41 */     func_78085_a("head.upperlip", 176, 44);
/*  42 */     func_78085_a("jaw.jaw", 176, 65);
/*  43 */     func_78085_a("frontleg.main", 112, 104);
/*  44 */     func_78085_a("wingtip.bone", 112, 136);
/*  45 */     func_78085_a("frontfoot.main", 144, 104);
/*  46 */     func_78085_a("neck.box", 192, 104);
/*  47 */     func_78085_a("frontlegtip.main", 226, 138);
/*  48 */     func_78085_a("body.scale", 220, 53);
/*  49 */     func_78085_a("head.scale", 0, 0);
/*  50 */     func_78085_a("neck.scale", 48, 0);
/*  51 */     func_78085_a("head.nostril", 112, 0);
/*     */     
/*  53 */     float f = -16.0F;
/*  54 */     this.field_78221_a = new ModelRenderer(this, "head");
/*  55 */     this.field_78221_a.func_78786_a("upperlip", -6.0F, -1.0F, -8.0F + f, 12, 5, 16);
/*  56 */     this.field_78221_a.func_78786_a("upperhead", -8.0F, -8.0F, 6.0F + f, 16, 16, 16);
/*  57 */     this.field_78221_a.field_78809_i = true;
/*  58 */     this.field_78221_a.func_78786_a("scale", -5.0F, -12.0F, 12.0F + f, 2, 4, 6);
/*  59 */     this.field_78221_a.func_78786_a("nostril", -5.0F, -3.0F, -6.0F + f, 2, 2, 4);
/*  60 */     this.field_78221_a.field_78809_i = false;
/*  61 */     this.field_78221_a.func_78786_a("scale", 3.0F, -12.0F, 12.0F + f, 2, 4, 6);
/*  62 */     this.field_78221_a.func_78786_a("nostril", 3.0F, -3.0F, -6.0F + f, 2, 2, 4);
/*     */     
/*  64 */     this.field_78220_c = new ModelRenderer(this, "jaw");
/*  65 */     this.field_78220_c.func_78793_a(0.0F, 4.0F, 8.0F + f);
/*  66 */     this.field_78220_c.func_78786_a("jaw", -6.0F, 0.0F, -16.0F, 12, 4, 16);
/*  67 */     this.field_78221_a.func_78792_a(this.field_78220_c);
/*     */     
/*  69 */     this.field_78219_b = new ModelRenderer(this, "neck");
/*  70 */     this.field_78219_b.func_78786_a("box", -5.0F, -5.0F, -5.0F, 10, 10, 10);
/*  71 */     this.field_78219_b.func_78786_a("scale", -1.0F, -9.0F, -3.0F, 2, 4, 6);
/*     */     
/*  73 */     this.field_78217_d = new ModelRenderer(this, "body");
/*  74 */     this.field_78217_d.func_78793_a(0.0F, 4.0F, 8.0F);
/*  75 */     this.field_78217_d.func_78786_a("body", -12.0F, 0.0F, -16.0F, 24, 24, 64);
/*  76 */     this.field_78217_d.func_78786_a("scale", -1.0F, -6.0F, -10.0F, 2, 6, 12);
/*  77 */     this.field_78217_d.func_78786_a("scale", -1.0F, -6.0F, 10.0F, 2, 6, 12);
/*  78 */     this.field_78217_d.func_78786_a("scale", -1.0F, -6.0F, 30.0F, 2, 6, 12);
/*     */     
/*  80 */     this.field_78225_k = new ModelRenderer(this, "wing");
/*  81 */     this.field_78225_k.func_78793_a(-12.0F, 5.0F, 2.0F);
/*  82 */     this.field_78225_k.func_78786_a("bone", -56.0F, -4.0F, -4.0F, 56, 8, 8);
/*  83 */     this.field_78225_k.func_78786_a("skin", -56.0F, 0.0F, 2.0F, 56, 0, 56);
/*  84 */     this.field_78222_l = new ModelRenderer(this, "wingtip");
/*  85 */     this.field_78222_l.func_78793_a(-56.0F, 0.0F, 0.0F);
/*  86 */     this.field_78222_l.func_78786_a("bone", -56.0F, -2.0F, -2.0F, 56, 4, 4);
/*  87 */     this.field_78222_l.func_78786_a("skin", -56.0F, 0.0F, 2.0F, 56, 0, 56);
/*  88 */     this.field_78225_k.func_78792_a(this.field_78222_l);
/*     */     
/*  90 */     this.field_78215_f = new ModelRenderer(this, "frontleg");
/*  91 */     this.field_78215_f.func_78793_a(-12.0F, 20.0F, 2.0F);
/*  92 */     this.field_78215_f.func_78786_a("main", -4.0F, -4.0F, -4.0F, 8, 24, 8);
/*  93 */     this.field_78226_h = new ModelRenderer(this, "frontlegtip");
/*  94 */     this.field_78226_h.func_78793_a(0.0F, 20.0F, -1.0F);
/*  95 */     this.field_78226_h.func_78786_a("main", -3.0F, -1.0F, -3.0F, 6, 24, 6);
/*  96 */     this.field_78215_f.func_78792_a(this.field_78226_h);
/*  97 */     this.field_78224_j = new ModelRenderer(this, "frontfoot");
/*  98 */     this.field_78224_j.func_78793_a(0.0F, 23.0F, 0.0F);
/*  99 */     this.field_78224_j.func_78786_a("main", -4.0F, 0.0F, -12.0F, 8, 4, 16);
/* 100 */     this.field_78226_h.func_78792_a(this.field_78224_j);
/*     */     
/* 102 */     this.field_78218_e = new ModelRenderer(this, "rearleg");
/* 103 */     this.field_78218_e.func_78793_a(-16.0F, 16.0F, 42.0F);
/* 104 */     this.field_78218_e.func_78786_a("main", -8.0F, -4.0F, -8.0F, 16, 32, 16);
/* 105 */     this.field_78216_g = new ModelRenderer(this, "rearlegtip");
/* 106 */     this.field_78216_g.func_78793_a(0.0F, 32.0F, -4.0F);
/* 107 */     this.field_78216_g.func_78786_a("main", -6.0F, -2.0F, 0.0F, 12, 32, 12);
/* 108 */     this.field_78218_e.func_78792_a(this.field_78216_g);
/* 109 */     this.field_78227_i = new ModelRenderer(this, "rearfoot");
/* 110 */     this.field_78227_i.func_78793_a(0.0F, 31.0F, 4.0F);
/* 111 */     this.field_78227_i.func_78786_a("main", -9.0F, 0.0F, -20.0F, 18, 6, 24);
/* 112 */     this.field_78216_g.func_78792_a(this.field_78227_i);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78086_a(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_) {
/* 117 */     this.field_78223_m = p_78086_4_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
/* 122 */     GL11.glPushMatrix();
/* 123 */     EntityDragon entityDragon = (EntityDragon)p_78088_1_;
/* 124 */     float f1 = entityDragon.field_70991_bC + (entityDragon.field_70988_bD - entityDragon.field_70991_bC) * this.field_78223_m;
/* 125 */     this.field_78220_c.field_78795_f = (float)(Math.sin((f1 * 3.1415927F * 2.0F)) + 1.0D) * 0.2F;
/*     */     
/* 127 */     float f2 = (float)(Math.sin((f1 * 3.1415927F * 2.0F - 1.0F)) + 1.0D);
/* 128 */     f2 = (f2 * f2 * 1.0F + f2 * 2.0F) * 0.05F;
/*     */     
/* 130 */     GL11.glTranslatef(0.0F, f2 - 2.0F, -3.0F);
/* 131 */     GL11.glRotatef(f2 * 2.0F, 1.0F, 0.0F, 0.0F);
/*     */     
/* 133 */     float f3 = -30.0F;
/*     */     
/* 135 */     float f5 = 0.0F;
/*     */     
/* 137 */     float f6 = 1.5F;
/*     */     
/* 139 */     double[] arrayOfDouble1 = entityDragon.func_70974_a(6, this.field_78223_m);
/*     */     
/* 141 */     float f7 = func_78214_a(entityDragon.func_70974_a(5, this.field_78223_m)[0] - entityDragon.func_70974_a(10, this.field_78223_m)[0]);
/* 142 */     float f8 = func_78214_a(entityDragon.func_70974_a(5, this.field_78223_m)[0] + (f7 / 2.0F));
/*     */     
/* 144 */     f3 += 2.0F;
/*     */     
/* 146 */     float f9 = f1 * 3.1415927F * 2.0F;
/* 147 */     f3 = 20.0F;
/* 148 */     float f4 = -12.0F;
/* 149 */     for (byte b1 = 0; b1 < 5; b1++) {
/* 150 */       double[] arrayOfDouble = entityDragon.func_70974_a(5 - b1, this.field_78223_m);
/* 151 */       float f = (float)Math.cos((b1 * 0.45F + f9)) * 0.15F;
/* 152 */       this.field_78219_b.field_78796_g = func_78214_a(arrayOfDouble[0] - arrayOfDouble1[0]) * 3.1415927F / 180.0F * f6;
/* 153 */       this.field_78219_b.field_78795_f = f + (float)(arrayOfDouble[1] - arrayOfDouble1[1]) * 3.1415927F / 180.0F * f6 * 5.0F;
/* 154 */       this.field_78219_b.field_78808_h = -func_78214_a(arrayOfDouble[0] - f8) * 3.1415927F / 180.0F * f6;
/*     */       
/* 156 */       this.field_78219_b.field_78797_d = f3;
/* 157 */       this.field_78219_b.field_78798_e = f4;
/* 158 */       this.field_78219_b.field_78800_c = f5;
/* 159 */       f3 = (float)(f3 + Math.sin(this.field_78219_b.field_78795_f) * 10.0D);
/* 160 */       f4 = (float)(f4 - Math.cos(this.field_78219_b.field_78796_g) * Math.cos(this.field_78219_b.field_78795_f) * 10.0D);
/* 161 */       f5 = (float)(f5 - Math.sin(this.field_78219_b.field_78796_g) * Math.cos(this.field_78219_b.field_78795_f) * 10.0D);
/* 162 */       this.field_78219_b.func_78785_a(p_78088_7_);
/*     */     } 
/*     */     
/* 165 */     this.field_78221_a.field_78797_d = f3;
/* 166 */     this.field_78221_a.field_78798_e = f4;
/* 167 */     this.field_78221_a.field_78800_c = f5;
/* 168 */     double[] arrayOfDouble2 = entityDragon.func_70974_a(0, this.field_78223_m);
/* 169 */     this.field_78221_a.field_78796_g = func_78214_a(arrayOfDouble2[0] - arrayOfDouble1[0]) * 3.1415927F / 180.0F * 1.0F;
/* 170 */     this.field_78221_a.field_78808_h = -func_78214_a(arrayOfDouble2[0] - f8) * 3.1415927F / 180.0F * 1.0F;
/* 171 */     this.field_78221_a.func_78785_a(p_78088_7_);
/* 172 */     GL11.glPushMatrix();
/* 173 */     GL11.glTranslatef(0.0F, 1.0F, 0.0F);
/* 174 */     GL11.glRotatef(-f7 * f6 * 1.0F, 0.0F, 0.0F, 1.0F);
/* 175 */     GL11.glTranslatef(0.0F, -1.0F, 0.0F);
/* 176 */     this.field_78217_d.field_78808_h = 0.0F;
/* 177 */     this.field_78217_d.func_78785_a(p_78088_7_);
/*     */     
/* 179 */     for (byte b2 = 0; b2 < 2; b2++) {
/* 180 */       GL11.glEnable(2884);
/* 181 */       float f = f1 * 3.1415927F * 2.0F;
/* 182 */       this.field_78225_k.field_78795_f = 0.125F - (float)Math.cos(f) * 0.2F;
/* 183 */       this.field_78225_k.field_78796_g = 0.25F;
/* 184 */       this.field_78225_k.field_78808_h = (float)(Math.sin(f) + 0.125D) * 0.8F;
/* 185 */       this.field_78222_l.field_78808_h = -((float)(Math.sin((f + 2.0F)) + 0.5D)) * 0.75F;
/*     */       
/* 187 */       this.field_78218_e.field_78795_f = 1.0F + f2 * 0.1F;
/* 188 */       this.field_78216_g.field_78795_f = 0.5F + f2 * 0.1F;
/* 189 */       this.field_78227_i.field_78795_f = 0.75F + f2 * 0.1F;
/*     */       
/* 191 */       this.field_78215_f.field_78795_f = 1.3F + f2 * 0.1F;
/* 192 */       this.field_78226_h.field_78795_f = -0.5F - f2 * 0.1F;
/* 193 */       this.field_78224_j.field_78795_f = 0.75F + f2 * 0.1F;
/* 194 */       this.field_78225_k.func_78785_a(p_78088_7_);
/* 195 */       this.field_78215_f.func_78785_a(p_78088_7_);
/* 196 */       this.field_78218_e.func_78785_a(p_78088_7_);
/* 197 */       GL11.glScalef(-1.0F, 1.0F, 1.0F);
/*     */       
/* 199 */       if (b2 == 0) {
/* 200 */         GL11.glCullFace(1028);
/*     */       }
/*     */     } 
/* 203 */     GL11.glPopMatrix();
/* 204 */     GL11.glCullFace(1029);
/* 205 */     GL11.glDisable(2884);
/*     */     
/* 207 */     float f10 = -((float)Math.sin((f1 * 3.1415927F * 2.0F))) * 0.0F;
/* 208 */     f9 = f1 * 3.1415927F * 2.0F;
/* 209 */     f3 = 10.0F;
/* 210 */     f4 = 60.0F;
/* 211 */     f5 = 0.0F;
/* 212 */     arrayOfDouble1 = entityDragon.func_70974_a(11, this.field_78223_m);
/* 213 */     for (byte b3 = 0; b3 < 12; b3++) {
/* 214 */       arrayOfDouble2 = entityDragon.func_70974_a(12 + b3, this.field_78223_m);
/* 215 */       f10 = (float)(f10 + Math.sin((b3 * 0.45F + f9)) * 0.05000000074505806D);
/* 216 */       this.field_78219_b.field_78796_g = (func_78214_a(arrayOfDouble2[0] - arrayOfDouble1[0]) * f6 + 180.0F) * 3.1415927F / 180.0F;
/* 217 */       this.field_78219_b.field_78795_f = f10 + (float)(arrayOfDouble2[1] - arrayOfDouble1[1]) * 3.1415927F / 180.0F * f6 * 5.0F;
/* 218 */       this.field_78219_b.field_78808_h = func_78214_a(arrayOfDouble2[0] - f8) * 3.1415927F / 180.0F * f6;
/* 219 */       this.field_78219_b.field_78797_d = f3;
/* 220 */       this.field_78219_b.field_78798_e = f4;
/* 221 */       this.field_78219_b.field_78800_c = f5;
/* 222 */       f3 = (float)(f3 + Math.sin(this.field_78219_b.field_78795_f) * 10.0D);
/* 223 */       f4 = (float)(f4 - Math.cos(this.field_78219_b.field_78796_g) * Math.cos(this.field_78219_b.field_78795_f) * 10.0D);
/* 224 */       f5 = (float)(f5 - Math.sin(this.field_78219_b.field_78796_g) * Math.cos(this.field_78219_b.field_78795_f) * 10.0D);
/* 225 */       this.field_78219_b.func_78785_a(p_78088_7_);
/*     */     } 
/* 227 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private float func_78214_a(double p_78214_1_) {
/* 231 */     while (p_78214_1_ >= 180.0D)
/* 232 */       p_78214_1_ -= 360.0D; 
/* 233 */     while (p_78214_1_ < -180.0D)
/* 234 */       p_78214_1_ += 360.0D; 
/* 235 */     return (float)p_78214_1_;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\ModelDragon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */