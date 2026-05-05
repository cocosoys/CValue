/*    */ package net.minecraft.client.model;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ModelChicken extends ModelBase {
/*    */   public ModelRenderer field_78142_a;
/*    */   public ModelRenderer field_78140_b;
/*    */   public ModelRenderer field_78141_c;
/*    */   public ModelRenderer field_78138_d;
/*    */   
/*    */   public ModelChicken() {
/* 16 */     byte b = 16;
/* 17 */     this.field_78142_a = new ModelRenderer(this, 0, 0);
/* 18 */     this.field_78142_a.func_78790_a(-2.0F, -6.0F, -2.0F, 4, 6, 3, 0.0F);
/* 19 */     this.field_78142_a.func_78793_a(0.0F, (-1 + b), -4.0F);
/*    */     
/* 21 */     this.field_78137_g = new ModelRenderer(this, 14, 0);
/* 22 */     this.field_78137_g.func_78790_a(-2.0F, -4.0F, -4.0F, 4, 2, 2, 0.0F);
/* 23 */     this.field_78137_g.func_78793_a(0.0F, (-1 + b), -4.0F);
/*    */     
/* 25 */     this.field_78143_h = new ModelRenderer(this, 14, 4);
/* 26 */     this.field_78143_h.func_78790_a(-1.0F, -2.0F, -3.0F, 2, 2, 2, 0.0F);
/* 27 */     this.field_78143_h.func_78793_a(0.0F, (-1 + b), -4.0F);
/*    */     
/* 29 */     this.field_78140_b = new ModelRenderer(this, 0, 9);
/* 30 */     this.field_78140_b.func_78790_a(-3.0F, -4.0F, -3.0F, 6, 8, 6, 0.0F);
/* 31 */     this.field_78140_b.func_78793_a(0.0F, b, 0.0F);
/*    */     
/* 33 */     this.field_78141_c = new ModelRenderer(this, 26, 0);
/* 34 */     this.field_78141_c.func_78789_a(-1.0F, 0.0F, -3.0F, 3, 5, 3);
/* 35 */     this.field_78141_c.func_78793_a(-2.0F, (3 + b), 1.0F);
/*    */     
/* 37 */     this.field_78138_d = new ModelRenderer(this, 26, 0);
/* 38 */     this.field_78138_d.func_78789_a(-1.0F, 0.0F, -3.0F, 3, 5, 3);
/* 39 */     this.field_78138_d.func_78793_a(1.0F, (3 + b), 1.0F);
/*    */     
/* 41 */     this.field_78139_e = new ModelRenderer(this, 24, 13);
/* 42 */     this.field_78139_e.func_78789_a(0.0F, 0.0F, -3.0F, 1, 4, 6);
/* 43 */     this.field_78139_e.func_78793_a(-4.0F, (-3 + b), 0.0F);
/*    */     
/* 45 */     this.field_78136_f = new ModelRenderer(this, 24, 13);
/* 46 */     this.field_78136_f.func_78789_a(-1.0F, 0.0F, -3.0F, 1, 4, 6);
/* 47 */     this.field_78136_f.func_78793_a(4.0F, (-3 + b), 0.0F);
/*    */   }
/*    */   public ModelRenderer field_78139_e; public ModelRenderer field_78136_f; public ModelRenderer field_78137_g; public ModelRenderer field_78143_h; private static final String __OBFID = "CL_00000835";
/*    */   
/*    */   public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
/* 52 */     func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
/*    */     
/* 54 */     if (this.field_78091_s) {
/* 55 */       float f = 2.0F;
/* 56 */       GL11.glPushMatrix();
/* 57 */       GL11.glTranslatef(0.0F, 5.0F * p_78088_7_, 2.0F * p_78088_7_);
/* 58 */       this.field_78142_a.func_78785_a(p_78088_7_);
/* 59 */       this.field_78137_g.func_78785_a(p_78088_7_);
/* 60 */       this.field_78143_h.func_78785_a(p_78088_7_);
/* 61 */       GL11.glPopMatrix();
/* 62 */       GL11.glPushMatrix();
/* 63 */       GL11.glScalef(1.0F / f, 1.0F / f, 1.0F / f);
/* 64 */       GL11.glTranslatef(0.0F, 24.0F * p_78088_7_, 0.0F);
/* 65 */       this.field_78140_b.func_78785_a(p_78088_7_);
/* 66 */       this.field_78141_c.func_78785_a(p_78088_7_);
/* 67 */       this.field_78138_d.func_78785_a(p_78088_7_);
/* 68 */       this.field_78139_e.func_78785_a(p_78088_7_);
/* 69 */       this.field_78136_f.func_78785_a(p_78088_7_);
/* 70 */       GL11.glPopMatrix();
/*    */     } else {
/* 72 */       this.field_78142_a.func_78785_a(p_78088_7_);
/* 73 */       this.field_78137_g.func_78785_a(p_78088_7_);
/* 74 */       this.field_78143_h.func_78785_a(p_78088_7_);
/* 75 */       this.field_78140_b.func_78785_a(p_78088_7_);
/* 76 */       this.field_78141_c.func_78785_a(p_78088_7_);
/* 77 */       this.field_78138_d.func_78785_a(p_78088_7_);
/* 78 */       this.field_78139_e.func_78785_a(p_78088_7_);
/* 79 */       this.field_78136_f.func_78785_a(p_78088_7_);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
/* 85 */     this.field_78142_a.field_78795_f = p_78087_5_ / 57.295776F;
/* 86 */     this.field_78142_a.field_78796_g = p_78087_4_ / 57.295776F;
/*    */     
/* 88 */     this.field_78137_g.field_78795_f = this.field_78142_a.field_78795_f;
/* 89 */     this.field_78137_g.field_78796_g = this.field_78142_a.field_78796_g;
/*    */     
/* 91 */     this.field_78143_h.field_78795_f = this.field_78142_a.field_78795_f;
/* 92 */     this.field_78143_h.field_78796_g = this.field_78142_a.field_78796_g;
/*    */     
/* 94 */     this.field_78140_b.field_78795_f = 1.5707964F;
/*    */     
/* 96 */     this.field_78141_c.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
/* 97 */     this.field_78138_d.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F + 3.1415927F) * 1.4F * p_78087_2_;
/* 98 */     this.field_78139_e.field_78808_h = p_78087_3_;
/* 99 */     this.field_78136_f.field_78808_h = -p_78087_3_;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\ModelChicken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */