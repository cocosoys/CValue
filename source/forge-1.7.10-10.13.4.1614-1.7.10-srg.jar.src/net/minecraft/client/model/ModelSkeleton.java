/*    */ package net.minecraft.client.model;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.monster.EntitySkeleton;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ModelSkeleton extends ModelZombie {
/*    */   public ModelSkeleton() {
/* 10 */     this(0.0F);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000857";
/*    */   public ModelSkeleton(float p_i1156_1_) {
/* 14 */     super(p_i1156_1_, 0.0F, 64, 32);
/* 15 */     this.field_78112_f = new ModelRenderer(this, 40, 16);
/* 16 */     this.field_78112_f.func_78790_a(-1.0F, -2.0F, -1.0F, 2, 12, 2, p_i1156_1_);
/* 17 */     this.field_78112_f.func_78793_a(-5.0F, 2.0F, 0.0F);
/*    */     
/* 19 */     this.field_78113_g = new ModelRenderer(this, 40, 16);
/* 20 */     this.field_78113_g.field_78809_i = true;
/* 21 */     this.field_78113_g.func_78790_a(-1.0F, -2.0F, -1.0F, 2, 12, 2, p_i1156_1_);
/* 22 */     this.field_78113_g.func_78793_a(5.0F, 2.0F, 0.0F);
/*    */     
/* 24 */     this.field_78123_h = new ModelRenderer(this, 0, 16);
/* 25 */     this.field_78123_h.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 12, 2, p_i1156_1_);
/* 26 */     this.field_78123_h.func_78793_a(-2.0F, 12.0F, 0.0F);
/*    */     
/* 28 */     this.field_78124_i = new ModelRenderer(this, 0, 16);
/* 29 */     this.field_78124_i.field_78809_i = true;
/* 30 */     this.field_78124_i.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 12, 2, p_i1156_1_);
/* 31 */     this.field_78124_i.func_78793_a(2.0F, 12.0F, 0.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78086_a(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_) {
/* 36 */     this.field_78118_o = (((EntitySkeleton)p_78086_1_).func_82202_m() == 1);
/* 37 */     super.func_78086_a(p_78086_1_, p_78086_2_, p_78086_3_, p_78086_4_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
/* 42 */     super.func_78087_a(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\ModelSkeleton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */