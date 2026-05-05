/*     */ package net.minecraft.client.model;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.passive.EntityOcelot;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ModelOcelot
/*     */   extends ModelBase {
/*     */   ModelRenderer field_78161_a;
/*     */   ModelRenderer field_78159_b;
/*     */   ModelRenderer field_78160_c;
/*     */   ModelRenderer field_78157_d;
/*     */   ModelRenderer field_78158_e;
/*     */   ModelRenderer field_78155_f;
/*     */   ModelRenderer field_78156_g;
/*     */   ModelRenderer field_78162_h;
/*  22 */   int field_78163_i = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String __OBFID = "CL_00000848";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelOcelot() {
/*  43 */     func_78085_a("head.main", 0, 0);
/*  44 */     func_78085_a("head.nose", 0, 24);
/*  45 */     func_78085_a("head.ear1", 0, 10);
/*  46 */     func_78085_a("head.ear2", 6, 10);
/*     */     
/*  48 */     this.field_78156_g = new ModelRenderer(this, "head");
/*  49 */     this.field_78156_g.func_78786_a("main", -2.5F, -2.0F, -3.0F, 5, 4, 5);
/*  50 */     this.field_78156_g.func_78786_a("nose", -1.5F, 0.0F, -4.0F, 3, 2, 2);
/*  51 */     this.field_78156_g.func_78786_a("ear1", -2.0F, -3.0F, 0.0F, 1, 1, 2);
/*  52 */     this.field_78156_g.func_78786_a("ear2", 1.0F, -3.0F, 0.0F, 1, 1, 2);
/*  53 */     this.field_78156_g.func_78793_a(0.0F, 15.0F, -9.0F);
/*     */     
/*  55 */     this.field_78162_h = new ModelRenderer(this, 20, 0);
/*  56 */     this.field_78162_h.func_78790_a(-2.0F, 3.0F, -8.0F, 4, 16, 6, 0.0F);
/*  57 */     this.field_78162_h.func_78793_a(0.0F, 12.0F, -10.0F);
/*     */     
/*  59 */     this.field_78158_e = new ModelRenderer(this, 0, 15);
/*  60 */     this.field_78158_e.func_78789_a(-0.5F, 0.0F, 0.0F, 1, 8, 1);
/*  61 */     this.field_78158_e.field_78795_f = 0.9F;
/*  62 */     this.field_78158_e.func_78793_a(0.0F, 15.0F, 8.0F);
/*     */     
/*  64 */     this.field_78155_f = new ModelRenderer(this, 4, 15);
/*  65 */     this.field_78155_f.func_78789_a(-0.5F, 0.0F, 0.0F, 1, 8, 1);
/*  66 */     this.field_78155_f.func_78793_a(0.0F, 20.0F, 14.0F);
/*     */     
/*  68 */     this.field_78161_a = new ModelRenderer(this, 8, 13);
/*  69 */     this.field_78161_a.func_78789_a(-1.0F, 0.0F, 1.0F, 2, 6, 2);
/*  70 */     this.field_78161_a.func_78793_a(1.1F, 18.0F, 5.0F);
/*     */     
/*  72 */     this.field_78159_b = new ModelRenderer(this, 8, 13);
/*  73 */     this.field_78159_b.func_78789_a(-1.0F, 0.0F, 1.0F, 2, 6, 2);
/*  74 */     this.field_78159_b.func_78793_a(-1.1F, 18.0F, 5.0F);
/*     */     
/*  76 */     this.field_78160_c = new ModelRenderer(this, 40, 0);
/*  77 */     this.field_78160_c.func_78789_a(-1.0F, 0.0F, 0.0F, 2, 10, 2);
/*  78 */     this.field_78160_c.func_78793_a(1.2F, 13.8F, -5.0F);
/*     */     
/*  80 */     this.field_78157_d = new ModelRenderer(this, 40, 0);
/*  81 */     this.field_78157_d.func_78789_a(-1.0F, 0.0F, 0.0F, 2, 10, 2);
/*  82 */     this.field_78157_d.func_78793_a(-1.2F, 13.8F, -5.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
/*  87 */     func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
/*  88 */     if (this.field_78091_s) {
/*  89 */       float f = 2.0F;
/*  90 */       GL11.glPushMatrix();
/*  91 */       GL11.glScalef(1.5F / f, 1.5F / f, 1.5F / f);
/*  92 */       GL11.glTranslatef(0.0F, 10.0F * p_78088_7_, 4.0F * p_78088_7_);
/*  93 */       this.field_78156_g.func_78785_a(p_78088_7_);
/*  94 */       GL11.glPopMatrix();
/*  95 */       GL11.glPushMatrix();
/*  96 */       GL11.glScalef(1.0F / f, 1.0F / f, 1.0F / f);
/*  97 */       GL11.glTranslatef(0.0F, 24.0F * p_78088_7_, 0.0F);
/*  98 */       this.field_78162_h.func_78785_a(p_78088_7_);
/*  99 */       this.field_78161_a.func_78785_a(p_78088_7_);
/* 100 */       this.field_78159_b.func_78785_a(p_78088_7_);
/* 101 */       this.field_78160_c.func_78785_a(p_78088_7_);
/* 102 */       this.field_78157_d.func_78785_a(p_78088_7_);
/* 103 */       this.field_78158_e.func_78785_a(p_78088_7_);
/* 104 */       this.field_78155_f.func_78785_a(p_78088_7_);
/* 105 */       GL11.glPopMatrix();
/*     */     } else {
/* 107 */       this.field_78156_g.func_78785_a(p_78088_7_);
/* 108 */       this.field_78162_h.func_78785_a(p_78088_7_);
/* 109 */       this.field_78158_e.func_78785_a(p_78088_7_);
/* 110 */       this.field_78155_f.func_78785_a(p_78088_7_);
/* 111 */       this.field_78161_a.func_78785_a(p_78088_7_);
/* 112 */       this.field_78159_b.func_78785_a(p_78088_7_);
/* 113 */       this.field_78160_c.func_78785_a(p_78088_7_);
/* 114 */       this.field_78157_d.func_78785_a(p_78088_7_);
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
/*     */   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
/* 152 */     this.field_78156_g.field_78795_f = p_78087_5_ / 57.295776F;
/* 153 */     this.field_78156_g.field_78796_g = p_78087_4_ / 57.295776F;
/*     */     
/* 155 */     if (this.field_78163_i != 3) {
/* 156 */       this.field_78162_h.field_78795_f = 1.5707964F;
/* 157 */       if (this.field_78163_i == 2) {
/* 158 */         this.field_78161_a.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F) * 1.0F * p_78087_2_;
/* 159 */         this.field_78159_b.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F + 0.3F) * 1.0F * p_78087_2_;
/* 160 */         this.field_78160_c.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F + 3.1415927F + 0.3F) * 1.0F * p_78087_2_;
/* 161 */         this.field_78157_d.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F + 3.1415927F) * 1.0F * p_78087_2_;
/* 162 */         this.field_78155_f.field_78795_f = 1.7278761F + 0.31415927F * MathHelper.func_76134_b(p_78087_1_) * p_78087_2_;
/*     */       } else {
/* 164 */         this.field_78161_a.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F) * 1.0F * p_78087_2_;
/* 165 */         this.field_78159_b.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F + 3.1415927F) * 1.0F * p_78087_2_;
/* 166 */         this.field_78160_c.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F + 3.1415927F) * 1.0F * p_78087_2_;
/* 167 */         this.field_78157_d.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F) * 1.0F * p_78087_2_;
/*     */         
/* 169 */         if (this.field_78163_i == 1) { this.field_78155_f.field_78795_f = 1.7278761F + 0.7853982F * MathHelper.func_76134_b(p_78087_1_) * p_78087_2_; }
/* 170 */         else { this.field_78155_f.field_78795_f = 1.7278761F + 0.47123894F * MathHelper.func_76134_b(p_78087_1_) * p_78087_2_; }
/*     */       
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_78086_a(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_) {
/* 177 */     EntityOcelot entityOcelot = (EntityOcelot)p_78086_1_;
/*     */     
/* 179 */     this.field_78162_h.field_78797_d = 12.0F;
/* 180 */     this.field_78162_h.field_78798_e = -10.0F;
/* 181 */     this.field_78156_g.field_78797_d = 15.0F;
/* 182 */     this.field_78156_g.field_78798_e = -9.0F;
/* 183 */     this.field_78158_e.field_78797_d = 15.0F;
/* 184 */     this.field_78158_e.field_78798_e = 8.0F;
/* 185 */     this.field_78155_f.field_78797_d = 20.0F;
/* 186 */     this.field_78155_f.field_78798_e = 14.0F;
/* 187 */     this.field_78157_d.field_78797_d = 13.8F;
/* 188 */     this.field_78157_d.field_78798_e = -5.0F;
/* 189 */     this.field_78159_b.field_78797_d = 18.0F;
/* 190 */     this.field_78159_b.field_78798_e = 5.0F;
/* 191 */     this.field_78158_e.field_78795_f = 0.9F;
/*     */     
/* 193 */     if (entityOcelot.func_70093_af()) {
/* 194 */       this.field_78162_h.field_78797_d++;
/* 195 */       this.field_78156_g.field_78797_d += 2.0F;
/* 196 */       this.field_78158_e.field_78797_d++;
/* 197 */       this.field_78155_f.field_78797_d += -4.0F;
/* 198 */       this.field_78155_f.field_78798_e += 2.0F;
/* 199 */       this.field_78158_e.field_78795_f = 1.5707964F;
/* 200 */       this.field_78155_f.field_78795_f = 1.5707964F;
/* 201 */       this.field_78163_i = 0;
/* 202 */     } else if (entityOcelot.func_70051_ag()) {
/* 203 */       this.field_78155_f.field_78797_d = this.field_78158_e.field_78797_d;
/* 204 */       this.field_78155_f.field_78798_e += 2.0F;
/* 205 */       this.field_78158_e.field_78795_f = 1.5707964F;
/* 206 */       this.field_78155_f.field_78795_f = 1.5707964F;
/* 207 */       this.field_78163_i = 2;
/* 208 */     } else if (entityOcelot.func_70906_o()) {
/* 209 */       this.field_78162_h.field_78795_f = 0.7853982F;
/* 210 */       this.field_78162_h.field_78797_d += -4.0F;
/* 211 */       this.field_78162_h.field_78798_e += 5.0F;
/* 212 */       this.field_78156_g.field_78797_d += -3.3F;
/* 213 */       this.field_78156_g.field_78798_e++;
/*     */       
/* 215 */       this.field_78158_e.field_78797_d += 8.0F;
/* 216 */       this.field_78158_e.field_78798_e += -2.0F;
/* 217 */       this.field_78155_f.field_78797_d += 2.0F;
/* 218 */       this.field_78155_f.field_78798_e += -0.8F;
/* 219 */       this.field_78158_e.field_78795_f = 1.7278761F;
/* 220 */       this.field_78155_f.field_78795_f = 2.670354F;
/*     */       
/* 222 */       this.field_78157_d.field_78795_f = -0.15707964F;
/* 223 */       this.field_78157_d.field_78797_d = 15.8F;
/* 224 */       this.field_78157_d.field_78798_e = -7.0F;
/*     */       
/* 226 */       this.field_78159_b.field_78795_f = -1.5707964F;
/* 227 */       this.field_78159_b.field_78797_d = 21.0F;
/* 228 */       this.field_78159_b.field_78798_e = 1.0F;
/* 229 */       this.field_78163_i = 3;
/*     */     } else {
/* 231 */       this.field_78163_i = 1;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\ModelOcelot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */