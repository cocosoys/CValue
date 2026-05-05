/*    */ package net.minecraft.client.model;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.passive.EntitySheep;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ModelSheep1 extends ModelQuadruped {
/*    */   private float field_78152_i;
/*    */   
/*    */   public ModelSheep1() {
/* 13 */     super(12, 0.0F);
/*    */     
/* 15 */     this.field_78150_a = new ModelRenderer(this, 0, 0);
/* 16 */     this.field_78150_a.func_78790_a(-3.0F, -4.0F, -4.0F, 6, 6, 6, 0.6F);
/* 17 */     this.field_78150_a.func_78793_a(0.0F, 6.0F, -8.0F);
/*    */     
/* 19 */     this.field_78148_b = new ModelRenderer(this, 28, 8);
/* 20 */     this.field_78148_b.func_78790_a(-4.0F, -10.0F, -7.0F, 8, 16, 6, 1.75F);
/* 21 */     this.field_78148_b.func_78793_a(0.0F, 5.0F, 2.0F);
/*    */     
/* 23 */     float f = 0.5F;
/* 24 */     this.field_78149_c = new ModelRenderer(this, 0, 16);
/* 25 */     this.field_78149_c.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, f);
/* 26 */     this.field_78149_c.func_78793_a(-3.0F, 12.0F, 7.0F);
/*    */     
/* 28 */     this.field_78146_d = new ModelRenderer(this, 0, 16);
/* 29 */     this.field_78146_d.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, f);
/* 30 */     this.field_78146_d.func_78793_a(3.0F, 12.0F, 7.0F);
/*    */     
/* 32 */     this.field_78147_e = new ModelRenderer(this, 0, 16);
/* 33 */     this.field_78147_e.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, f);
/* 34 */     this.field_78147_e.func_78793_a(-3.0F, 12.0F, -5.0F);
/*    */     
/* 36 */     this.field_78144_f = new ModelRenderer(this, 0, 16);
/* 37 */     this.field_78144_f.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, f);
/* 38 */     this.field_78144_f.func_78793_a(3.0F, 12.0F, -5.0F);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000852";
/*    */   
/*    */   public void func_78086_a(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_) {
/* 43 */     super.func_78086_a(p_78086_1_, p_78086_2_, p_78086_3_, p_78086_4_);
/*    */     
/* 45 */     this.field_78150_a.field_78797_d = 6.0F + ((EntitySheep)p_78086_1_).func_70894_j(p_78086_4_) * 9.0F;
/* 46 */     this.field_78152_i = ((EntitySheep)p_78086_1_).func_70890_k(p_78086_4_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
/* 51 */     super.func_78087_a(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
/*    */     
/* 53 */     this.field_78150_a.field_78795_f = this.field_78152_i;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\ModelSheep1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */