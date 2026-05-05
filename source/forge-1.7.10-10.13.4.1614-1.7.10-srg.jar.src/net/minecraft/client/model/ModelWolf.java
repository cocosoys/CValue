/*     */ package net.minecraft.client.model;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.passive.EntityWolf;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ModelWolf
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer field_78185_a;
/*     */   public ModelRenderer field_78183_b;
/*     */   public ModelRenderer field_78184_c;
/*     */   public ModelRenderer field_78181_d;
/*     */   
/*     */   public ModelWolf() {
/*  22 */     float f1 = 0.0F;
/*     */     
/*  24 */     float f2 = 13.5F;
/*     */     
/*  26 */     this.field_78185_a = new ModelRenderer(this, 0, 0);
/*  27 */     this.field_78185_a.func_78790_a(-3.0F, -3.0F, -2.0F, 6, 6, 4, f1);
/*  28 */     this.field_78185_a.func_78793_a(-1.0F, f2, -7.0F);
/*     */     
/*  30 */     this.field_78183_b = new ModelRenderer(this, 18, 14);
/*  31 */     this.field_78183_b.func_78790_a(-4.0F, -2.0F, -3.0F, 6, 9, 6, f1);
/*  32 */     this.field_78183_b.func_78793_a(0.0F, 14.0F, 2.0F);
/*     */     
/*  34 */     this.field_78186_h = new ModelRenderer(this, 21, 0);
/*  35 */     this.field_78186_h.func_78790_a(-4.0F, -3.0F, -3.0F, 8, 6, 7, f1);
/*  36 */     this.field_78186_h.func_78793_a(-1.0F, 14.0F, 2.0F);
/*     */     
/*  38 */     this.field_78184_c = new ModelRenderer(this, 0, 18);
/*  39 */     this.field_78184_c.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 8, 2, f1);
/*  40 */     this.field_78184_c.func_78793_a(-2.5F, 16.0F, 7.0F);
/*     */     
/*  42 */     this.field_78181_d = new ModelRenderer(this, 0, 18);
/*  43 */     this.field_78181_d.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 8, 2, f1);
/*  44 */     this.field_78181_d.func_78793_a(0.5F, 16.0F, 7.0F);
/*     */     
/*  46 */     this.field_78182_e = new ModelRenderer(this, 0, 18);
/*  47 */     this.field_78182_e.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 8, 2, f1);
/*  48 */     this.field_78182_e.func_78793_a(-2.5F, 16.0F, -4.0F);
/*     */     
/*  50 */     this.field_78179_f = new ModelRenderer(this, 0, 18);
/*  51 */     this.field_78179_f.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 8, 2, f1);
/*  52 */     this.field_78179_f.func_78793_a(0.5F, 16.0F, -4.0F);
/*     */     
/*  54 */     this.field_78180_g = new ModelRenderer(this, 9, 18);
/*  55 */     this.field_78180_g.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 8, 2, f1);
/*  56 */     this.field_78180_g.func_78793_a(-1.0F, 12.0F, 8.0F);
/*     */     
/*  58 */     this.field_78185_a.func_78784_a(16, 14).func_78790_a(-3.0F, -5.0F, 0.0F, 2, 2, 1, f1);
/*  59 */     this.field_78185_a.func_78784_a(16, 14).func_78790_a(1.0F, -5.0F, 0.0F, 2, 2, 1, f1);
/*  60 */     this.field_78185_a.func_78784_a(0, 10).func_78790_a(-1.5F, 0.0F, -5.0F, 3, 3, 4, f1);
/*     */   }
/*     */   public ModelRenderer field_78182_e; public ModelRenderer field_78179_f; ModelRenderer field_78180_g; ModelRenderer field_78186_h; private static final String __OBFID = "CL_00000868";
/*     */   
/*     */   public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
/*  65 */     super.func_78088_a(p_78088_1_, p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_);
/*  66 */     func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
/*     */     
/*  68 */     if (this.field_78091_s) {
/*  69 */       float f = 2.0F;
/*  70 */       GL11.glPushMatrix();
/*  71 */       GL11.glTranslatef(0.0F, 5.0F * p_78088_7_, 2.0F * p_78088_7_);
/*  72 */       this.field_78185_a.func_78791_b(p_78088_7_);
/*  73 */       GL11.glPopMatrix();
/*  74 */       GL11.glPushMatrix();
/*  75 */       GL11.glScalef(1.0F / f, 1.0F / f, 1.0F / f);
/*  76 */       GL11.glTranslatef(0.0F, 24.0F * p_78088_7_, 0.0F);
/*  77 */       this.field_78183_b.func_78785_a(p_78088_7_);
/*  78 */       this.field_78184_c.func_78785_a(p_78088_7_);
/*  79 */       this.field_78181_d.func_78785_a(p_78088_7_);
/*  80 */       this.field_78182_e.func_78785_a(p_78088_7_);
/*  81 */       this.field_78179_f.func_78785_a(p_78088_7_);
/*     */       
/*  83 */       this.field_78180_g.func_78791_b(p_78088_7_);
/*  84 */       this.field_78186_h.func_78785_a(p_78088_7_);
/*  85 */       GL11.glPopMatrix();
/*     */     } else {
/*  87 */       this.field_78185_a.func_78791_b(p_78088_7_);
/*  88 */       this.field_78183_b.func_78785_a(p_78088_7_);
/*  89 */       this.field_78184_c.func_78785_a(p_78088_7_);
/*  90 */       this.field_78181_d.func_78785_a(p_78088_7_);
/*  91 */       this.field_78182_e.func_78785_a(p_78088_7_);
/*  92 */       this.field_78179_f.func_78785_a(p_78088_7_);
/*     */       
/*  94 */       this.field_78180_g.func_78791_b(p_78088_7_);
/*  95 */       this.field_78186_h.func_78785_a(p_78088_7_);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78086_a(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_) {
/* 101 */     EntityWolf entityWolf = (EntityWolf)p_78086_1_;
/*     */     
/* 103 */     if (entityWolf.func_70919_bu()) {
/* 104 */       this.field_78180_g.field_78796_g = 0.0F;
/*     */     } else {
/* 106 */       this.field_78180_g.field_78796_g = MathHelper.func_76134_b(p_78086_2_ * 0.6662F) * 1.4F * p_78086_3_;
/*     */     } 
/*     */     
/* 109 */     if (entityWolf.func_70906_o()) {
/* 110 */       this.field_78186_h.func_78793_a(-1.0F, 16.0F, -3.0F);
/* 111 */       this.field_78186_h.field_78795_f = 1.2566371F;
/* 112 */       this.field_78186_h.field_78796_g = 0.0F;
/*     */       
/* 114 */       this.field_78183_b.func_78793_a(0.0F, 18.0F, 0.0F);
/* 115 */       this.field_78183_b.field_78795_f = 0.7853982F;
/*     */       
/* 117 */       this.field_78180_g.func_78793_a(-1.0F, 21.0F, 6.0F);
/*     */       
/* 119 */       this.field_78184_c.func_78793_a(-2.5F, 22.0F, 2.0F);
/* 120 */       this.field_78184_c.field_78795_f = 4.712389F;
/* 121 */       this.field_78181_d.func_78793_a(0.5F, 22.0F, 2.0F);
/* 122 */       this.field_78181_d.field_78795_f = 4.712389F;
/*     */       
/* 124 */       this.field_78182_e.field_78795_f = 5.811947F;
/* 125 */       this.field_78182_e.func_78793_a(-2.49F, 17.0F, -4.0F);
/* 126 */       this.field_78179_f.field_78795_f = 5.811947F;
/* 127 */       this.field_78179_f.func_78793_a(0.51F, 17.0F, -4.0F);
/*     */     } else {
/* 129 */       this.field_78183_b.func_78793_a(0.0F, 14.0F, 2.0F);
/* 130 */       this.field_78183_b.field_78795_f = 1.5707964F;
/*     */       
/* 132 */       this.field_78186_h.func_78793_a(-1.0F, 14.0F, -3.0F);
/* 133 */       this.field_78186_h.field_78795_f = this.field_78183_b.field_78795_f;
/*     */       
/* 135 */       this.field_78180_g.func_78793_a(-1.0F, 12.0F, 8.0F);
/*     */       
/* 137 */       this.field_78184_c.func_78793_a(-2.5F, 16.0F, 7.0F);
/* 138 */       this.field_78181_d.func_78793_a(0.5F, 16.0F, 7.0F);
/* 139 */       this.field_78182_e.func_78793_a(-2.5F, 16.0F, -4.0F);
/* 140 */       this.field_78179_f.func_78793_a(0.5F, 16.0F, -4.0F);
/*     */       
/* 142 */       this.field_78184_c.field_78795_f = MathHelper.func_76134_b(p_78086_2_ * 0.6662F) * 1.4F * p_78086_3_;
/* 143 */       this.field_78181_d.field_78795_f = MathHelper.func_76134_b(p_78086_2_ * 0.6662F + 3.1415927F) * 1.4F * p_78086_3_;
/* 144 */       this.field_78182_e.field_78795_f = MathHelper.func_76134_b(p_78086_2_ * 0.6662F + 3.1415927F) * 1.4F * p_78086_3_;
/* 145 */       this.field_78179_f.field_78795_f = MathHelper.func_76134_b(p_78086_2_ * 0.6662F) * 1.4F * p_78086_3_;
/*     */     } 
/*     */     
/* 148 */     this.field_78185_a.field_78808_h = entityWolf.func_70917_k(p_78086_4_) + entityWolf.func_70923_f(p_78086_4_, 0.0F);
/*     */     
/* 150 */     this.field_78186_h.field_78808_h = entityWolf.func_70923_f(p_78086_4_, -0.08F);
/* 151 */     this.field_78183_b.field_78808_h = entityWolf.func_70923_f(p_78086_4_, -0.16F);
/* 152 */     this.field_78180_g.field_78808_h = entityWolf.func_70923_f(p_78086_4_, -0.2F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
/* 157 */     super.func_78087_a(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
/* 158 */     this.field_78185_a.field_78795_f = p_78087_5_ / 57.295776F;
/* 159 */     this.field_78185_a.field_78796_g = p_78087_4_ / 57.295776F;
/*     */     
/* 161 */     this.field_78180_g.field_78795_f = p_78087_3_;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\ModelWolf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */