/*    */ package net.minecraft.client.model;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.MathHelper;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ModelZombie extends ModelBiped {
/*    */   public ModelZombie() {
/*  8 */     this(0.0F, false);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000869";
/*    */   protected ModelZombie(float p_i1167_1_, float p_i1167_2_, int p_i1167_3_, int p_i1167_4_) {
/* 12 */     super(p_i1167_1_, p_i1167_2_, p_i1167_3_, p_i1167_4_);
/*    */   }
/*    */   
/*    */   public ModelZombie(float p_i1168_1_, boolean p_i1168_2_) {
/* 16 */     super(p_i1168_1_, 0.0F, 64, p_i1168_2_ ? 32 : 64);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
/* 21 */     super.func_78087_a(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
/*    */     
/* 23 */     float f1 = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F);
/* 24 */     float f2 = MathHelper.func_76126_a((1.0F - (1.0F - this.field_78095_p) * (1.0F - this.field_78095_p)) * 3.1415927F);
/* 25 */     this.field_78112_f.field_78808_h = 0.0F;
/* 26 */     this.field_78113_g.field_78808_h = 0.0F;
/* 27 */     this.field_78112_f.field_78796_g = -(0.1F - f1 * 0.6F);
/* 28 */     this.field_78113_g.field_78796_g = 0.1F - f1 * 0.6F;
/* 29 */     this.field_78112_f.field_78795_f = -1.5707964F;
/* 30 */     this.field_78113_g.field_78795_f = -1.5707964F;
/* 31 */     this.field_78112_f.field_78795_f -= f1 * 1.2F - f2 * 0.4F;
/* 32 */     this.field_78113_g.field_78795_f -= f1 * 1.2F - f2 * 0.4F;
/*    */     
/* 34 */     this.field_78112_f.field_78808_h += MathHelper.func_76134_b(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
/* 35 */     this.field_78113_g.field_78808_h -= MathHelper.func_76134_b(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
/* 36 */     this.field_78112_f.field_78795_f += MathHelper.func_76126_a(p_78087_3_ * 0.067F) * 0.05F;
/* 37 */     this.field_78113_g.field_78795_f -= MathHelper.func_76126_a(p_78087_3_ * 0.067F) * 0.05F;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\ModelZombie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */