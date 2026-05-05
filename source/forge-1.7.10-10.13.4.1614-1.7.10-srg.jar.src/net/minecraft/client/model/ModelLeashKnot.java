/*    */ package net.minecraft.client.model;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ModelLeashKnot extends ModelBase {
/*    */   public ModelRenderer field_110723_a;
/*    */   
/*    */   public ModelLeashKnot() {
/* 12 */     this(0, 0, 32, 32);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000843";
/*    */   public ModelLeashKnot(int p_i1150_1_, int p_i1150_2_, int p_i1150_3_, int p_i1150_4_) {
/* 16 */     this.field_78090_t = p_i1150_3_;
/* 17 */     this.field_78089_u = p_i1150_4_;
/* 18 */     this.field_110723_a = new ModelRenderer(this, p_i1150_1_, p_i1150_2_);
/* 19 */     this.field_110723_a.func_78790_a(-3.0F, -6.0F, -3.0F, 6, 8, 6, 0.0F);
/* 20 */     this.field_110723_a.func_78793_a(0.0F, 0.0F, 0.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
/* 25 */     func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
/*    */     
/* 27 */     this.field_110723_a.func_78785_a(p_78088_7_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
/* 32 */     super.func_78087_a(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
/*    */     
/* 34 */     this.field_110723_a.field_78796_g = p_78087_4_ / 57.295776F;
/* 35 */     this.field_110723_a.field_78795_f = p_78087_5_ / 57.295776F;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\ModelLeashKnot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */