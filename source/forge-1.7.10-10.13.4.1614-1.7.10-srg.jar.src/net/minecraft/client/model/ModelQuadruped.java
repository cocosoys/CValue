/*    */ package net.minecraft.client.model;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ModelQuadruped extends ModelBase {
/*    */   public ModelRenderer field_78150_a;
/*    */   public ModelRenderer field_78148_b;
/*    */   public ModelRenderer field_78149_c;
/* 14 */   protected float field_78145_g = 8.0F; public ModelRenderer field_78146_d; public ModelRenderer field_78147_e; public ModelRenderer field_78144_f;
/* 15 */   protected float field_78151_h = 4.0F; private static final String __OBFID = "CL_00000851";
/*    */   
/*    */   public ModelQuadruped(int p_i1154_1_, float p_i1154_2_) {
/* 18 */     this.field_78150_a = new ModelRenderer(this, 0, 0);
/* 19 */     this.field_78150_a.func_78790_a(-4.0F, -4.0F, -8.0F, 8, 8, 8, p_i1154_2_);
/* 20 */     this.field_78150_a.func_78793_a(0.0F, (18 - p_i1154_1_), -6.0F);
/*    */     
/* 22 */     this.field_78148_b = new ModelRenderer(this, 28, 8);
/* 23 */     this.field_78148_b.func_78790_a(-5.0F, -10.0F, -7.0F, 10, 16, 8, p_i1154_2_);
/* 24 */     this.field_78148_b.func_78793_a(0.0F, (17 - p_i1154_1_), 2.0F);
/*    */     
/* 26 */     this.field_78149_c = new ModelRenderer(this, 0, 16);
/* 27 */     this.field_78149_c.func_78790_a(-2.0F, 0.0F, -2.0F, 4, p_i1154_1_, 4, p_i1154_2_);
/* 28 */     this.field_78149_c.func_78793_a(-3.0F, (24 - p_i1154_1_), 7.0F);
/*    */     
/* 30 */     this.field_78146_d = new ModelRenderer(this, 0, 16);
/* 31 */     this.field_78146_d.func_78790_a(-2.0F, 0.0F, -2.0F, 4, p_i1154_1_, 4, p_i1154_2_);
/* 32 */     this.field_78146_d.func_78793_a(3.0F, (24 - p_i1154_1_), 7.0F);
/*    */     
/* 34 */     this.field_78147_e = new ModelRenderer(this, 0, 16);
/* 35 */     this.field_78147_e.func_78790_a(-2.0F, 0.0F, -2.0F, 4, p_i1154_1_, 4, p_i1154_2_);
/* 36 */     this.field_78147_e.func_78793_a(-3.0F, (24 - p_i1154_1_), -5.0F);
/*    */     
/* 38 */     this.field_78144_f = new ModelRenderer(this, 0, 16);
/* 39 */     this.field_78144_f.func_78790_a(-2.0F, 0.0F, -2.0F, 4, p_i1154_1_, 4, p_i1154_2_);
/* 40 */     this.field_78144_f.func_78793_a(3.0F, (24 - p_i1154_1_), -5.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
/* 45 */     func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
/*    */     
/* 47 */     if (this.field_78091_s) {
/* 48 */       float f = 2.0F;
/* 49 */       GL11.glPushMatrix();
/* 50 */       GL11.glTranslatef(0.0F, this.field_78145_g * p_78088_7_, this.field_78151_h * p_78088_7_);
/* 51 */       this.field_78150_a.func_78785_a(p_78088_7_);
/* 52 */       GL11.glPopMatrix();
/* 53 */       GL11.glPushMatrix();
/* 54 */       GL11.glScalef(1.0F / f, 1.0F / f, 1.0F / f);
/* 55 */       GL11.glTranslatef(0.0F, 24.0F * p_78088_7_, 0.0F);
/* 56 */       this.field_78148_b.func_78785_a(p_78088_7_);
/* 57 */       this.field_78149_c.func_78785_a(p_78088_7_);
/* 58 */       this.field_78146_d.func_78785_a(p_78088_7_);
/* 59 */       this.field_78147_e.func_78785_a(p_78088_7_);
/* 60 */       this.field_78144_f.func_78785_a(p_78088_7_);
/* 61 */       GL11.glPopMatrix();
/*    */     } else {
/* 63 */       this.field_78150_a.func_78785_a(p_78088_7_);
/* 64 */       this.field_78148_b.func_78785_a(p_78088_7_);
/* 65 */       this.field_78149_c.func_78785_a(p_78088_7_);
/* 66 */       this.field_78146_d.func_78785_a(p_78088_7_);
/* 67 */       this.field_78147_e.func_78785_a(p_78088_7_);
/* 68 */       this.field_78144_f.func_78785_a(p_78088_7_);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
/* 74 */     float f = 57.295776F;
/* 75 */     this.field_78150_a.field_78795_f = p_78087_5_ / 57.295776F;
/* 76 */     this.field_78150_a.field_78796_g = p_78087_4_ / 57.295776F;
/* 77 */     this.field_78148_b.field_78795_f = 1.5707964F;
/*    */     
/* 79 */     this.field_78149_c.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
/* 80 */     this.field_78146_d.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F + 3.1415927F) * 1.4F * p_78087_2_;
/* 81 */     this.field_78147_e.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F + 3.1415927F) * 1.4F * p_78087_2_;
/* 82 */     this.field_78144_f.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\ModelQuadruped.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */