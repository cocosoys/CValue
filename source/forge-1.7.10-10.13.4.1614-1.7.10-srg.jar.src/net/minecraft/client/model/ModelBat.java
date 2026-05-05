/*     */ package net.minecraft.client.model;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.passive.EntityBat;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ModelBat
/*     */   extends ModelBase
/*     */ {
/*     */   private ModelRenderer field_82895_a;
/*     */   private ModelRenderer field_82893_b;
/*     */   private ModelRenderer field_82894_c;
/*     */   
/*     */   public ModelBat() {
/*  19 */     this.field_78090_t = 64;
/*  20 */     this.field_78089_u = 64;
/*     */     
/*  22 */     this.field_82895_a = new ModelRenderer(this, 0, 0);
/*  23 */     this.field_82895_a.func_78789_a(-3.0F, -3.0F, -3.0F, 6, 6, 6);
/*     */     
/*  25 */     ModelRenderer modelRenderer1 = new ModelRenderer(this, 24, 0);
/*  26 */     modelRenderer1.func_78789_a(-4.0F, -6.0F, -2.0F, 3, 4, 1);
/*  27 */     this.field_82895_a.func_78792_a(modelRenderer1);
/*  28 */     ModelRenderer modelRenderer2 = new ModelRenderer(this, 24, 0);
/*  29 */     modelRenderer2.field_78809_i = true;
/*  30 */     modelRenderer2.func_78789_a(1.0F, -6.0F, -2.0F, 3, 4, 1);
/*  31 */     this.field_82895_a.func_78792_a(modelRenderer2);
/*     */     
/*  33 */     this.field_82893_b = new ModelRenderer(this, 0, 16);
/*  34 */     this.field_82893_b.func_78789_a(-3.0F, 4.0F, -3.0F, 6, 12, 6);
/*  35 */     this.field_82893_b.func_78784_a(0, 34).func_78789_a(-5.0F, 16.0F, 0.0F, 10, 6, 1);
/*     */     
/*  37 */     this.field_82894_c = new ModelRenderer(this, 42, 0);
/*  38 */     this.field_82894_c.func_78789_a(-12.0F, 1.0F, 1.5F, 10, 16, 1);
/*  39 */     this.field_82892_e = new ModelRenderer(this, 24, 16);
/*  40 */     this.field_82892_e.func_78793_a(-12.0F, 1.0F, 1.5F);
/*  41 */     this.field_82892_e.func_78789_a(-8.0F, 1.0F, 0.0F, 8, 12, 1);
/*     */     
/*  43 */     this.field_82891_d = new ModelRenderer(this, 42, 0);
/*  44 */     this.field_82891_d.field_78809_i = true;
/*  45 */     this.field_82891_d.func_78789_a(2.0F, 1.0F, 1.5F, 10, 16, 1);
/*  46 */     this.field_82890_f = new ModelRenderer(this, 24, 16);
/*  47 */     this.field_82890_f.field_78809_i = true;
/*  48 */     this.field_82890_f.func_78793_a(12.0F, 1.0F, 1.5F);
/*  49 */     this.field_82890_f.func_78789_a(0.0F, 1.0F, 0.0F, 8, 12, 1);
/*     */     
/*  51 */     this.field_82893_b.func_78792_a(this.field_82894_c);
/*  52 */     this.field_82893_b.func_78792_a(this.field_82891_d);
/*  53 */     this.field_82894_c.func_78792_a(this.field_82892_e);
/*  54 */     this.field_82891_d.func_78792_a(this.field_82890_f);
/*     */   }
/*     */   private ModelRenderer field_82891_d; private ModelRenderer field_82892_e; private ModelRenderer field_82890_f; private static final String __OBFID = "CL_00000830";
/*     */   
/*     */   public int func_82889_a() {
/*  59 */     return 36;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
/*  65 */     EntityBat entityBat = (EntityBat)p_78088_1_;
/*  66 */     if (entityBat.func_82235_h()) {
/*  67 */       float f = 57.295776F;
/*  68 */       this.field_82895_a.field_78795_f = p_78088_6_ / 57.295776F;
/*  69 */       this.field_82895_a.field_78796_g = 3.1415927F - p_78088_5_ / 57.295776F;
/*  70 */       this.field_82895_a.field_78808_h = 3.1415927F;
/*     */       
/*  72 */       this.field_82895_a.func_78793_a(0.0F, -2.0F, 0.0F);
/*  73 */       this.field_82894_c.func_78793_a(-3.0F, 0.0F, 3.0F);
/*  74 */       this.field_82891_d.func_78793_a(3.0F, 0.0F, 3.0F);
/*     */       
/*  76 */       this.field_82893_b.field_78795_f = 3.1415927F;
/*     */       
/*  78 */       this.field_82894_c.field_78795_f = -0.15707964F;
/*  79 */       this.field_82894_c.field_78796_g = -1.2566371F;
/*  80 */       this.field_82892_e.field_78796_g = -1.7278761F;
/*  81 */       this.field_82891_d.field_78795_f = this.field_82894_c.field_78795_f;
/*  82 */       this.field_82891_d.field_78796_g = -this.field_82894_c.field_78796_g;
/*  83 */       this.field_82890_f.field_78796_g = -this.field_82892_e.field_78796_g;
/*     */     } else {
/*  85 */       float f = 57.295776F;
/*  86 */       this.field_82895_a.field_78795_f = p_78088_6_ / 57.295776F;
/*  87 */       this.field_82895_a.field_78796_g = p_78088_5_ / 57.295776F;
/*  88 */       this.field_82895_a.field_78808_h = 0.0F;
/*     */       
/*  90 */       this.field_82895_a.func_78793_a(0.0F, 0.0F, 0.0F);
/*  91 */       this.field_82894_c.func_78793_a(0.0F, 0.0F, 0.0F);
/*  92 */       this.field_82891_d.func_78793_a(0.0F, 0.0F, 0.0F);
/*     */       
/*  94 */       this.field_82893_b.field_78795_f = 0.7853982F + MathHelper.func_76134_b(p_78088_4_ * 0.1F) * 0.15F;
/*  95 */       this.field_82893_b.field_78796_g = 0.0F;
/*     */       
/*  97 */       this.field_82894_c.field_78796_g = MathHelper.func_76134_b(p_78088_4_ * 1.3F) * 3.1415927F * 0.25F;
/*  98 */       this.field_82891_d.field_78796_g = -this.field_82894_c.field_78796_g;
/*  99 */       this.field_82894_c.field_78796_g *= 0.5F;
/* 100 */       this.field_82890_f.field_78796_g = -this.field_82894_c.field_78796_g * 0.5F;
/*     */     } 
/*     */     
/* 103 */     this.field_82895_a.func_78785_a(p_78088_7_);
/* 104 */     this.field_82893_b.func_78785_a(p_78088_7_);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\ModelBat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */