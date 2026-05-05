/*    */ package net.minecraft.client.model;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.passive.EntitySheep;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ModelSheep2 extends ModelQuadruped {
/*    */   private float field_78153_i;
/*    */   
/*    */   public ModelSheep2() {
/* 13 */     super(12, 0.0F);
/*    */     
/* 15 */     this.field_78150_a = new ModelRenderer(this, 0, 0);
/* 16 */     this.field_78150_a.func_78790_a(-3.0F, -4.0F, -6.0F, 6, 6, 8, 0.0F);
/* 17 */     this.field_78150_a.func_78793_a(0.0F, 6.0F, -8.0F);
/*    */     
/* 19 */     this.field_78148_b = new ModelRenderer(this, 28, 8);
/* 20 */     this.field_78148_b.func_78790_a(-4.0F, -10.0F, -7.0F, 8, 16, 6, 0.0F);
/* 21 */     this.field_78148_b.func_78793_a(0.0F, 5.0F, 2.0F);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000853";
/*    */   
/*    */   public void func_78086_a(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_) {
/* 26 */     super.func_78086_a(p_78086_1_, p_78086_2_, p_78086_3_, p_78086_4_);
/*    */     
/* 28 */     this.field_78150_a.field_78797_d = 6.0F + ((EntitySheep)p_78086_1_).func_70894_j(p_78086_4_) * 9.0F;
/* 29 */     this.field_78153_i = ((EntitySheep)p_78086_1_).func_70890_k(p_78086_4_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
/* 34 */     super.func_78087_a(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
/*    */     
/* 36 */     this.field_78150_a.field_78795_f = this.field_78153_i;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\ModelSheep2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */