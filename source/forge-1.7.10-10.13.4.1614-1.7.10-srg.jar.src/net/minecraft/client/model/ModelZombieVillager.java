/*    */ package net.minecraft.client.model;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.MathHelper;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ModelZombieVillager extends ModelBiped {
/*    */   public ModelZombieVillager() {
/*  9 */     this(0.0F, 0.0F, false);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000865";
/*    */   public ModelZombieVillager(float p_i1165_1_, float p_i1165_2_, boolean p_i1165_3_) {
/* 13 */     super(p_i1165_1_, 0.0F, 64, p_i1165_3_ ? 32 : 64);
/*    */     
/* 15 */     if (p_i1165_3_) {
/* 16 */       this.field_78116_c = new ModelRenderer(this, 0, 0);
/* 17 */       this.field_78116_c.func_78790_a(-4.0F, -10.0F, -4.0F, 8, 6, 8, p_i1165_1_);
/* 18 */       this.field_78116_c.func_78793_a(0.0F, 0.0F + p_i1165_2_, 0.0F);
/*    */     } else {
/* 20 */       this.field_78116_c = new ModelRenderer(this);
/* 21 */       this.field_78116_c.func_78793_a(0.0F, 0.0F + p_i1165_2_, 0.0F);
/* 22 */       this.field_78116_c.func_78784_a(0, 32).func_78790_a(-4.0F, -10.0F, -4.0F, 8, 10, 8, p_i1165_1_);
/* 23 */       this.field_78116_c.func_78784_a(24, 32).func_78790_a(-1.0F, -3.0F, -6.0F, 2, 4, 2, p_i1165_1_);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_82897_a() {
/* 29 */     return 10;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
/* 34 */     super.func_78087_a(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
/*    */     
/* 36 */     float f1 = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F);
/* 37 */     float f2 = MathHelper.func_76126_a((1.0F - (1.0F - this.field_78095_p) * (1.0F - this.field_78095_p)) * 3.1415927F);
/* 38 */     this.field_78112_f.field_78808_h = 0.0F;
/* 39 */     this.field_78113_g.field_78808_h = 0.0F;
/* 40 */     this.field_78112_f.field_78796_g = -(0.1F - f1 * 0.6F);
/* 41 */     this.field_78113_g.field_78796_g = 0.1F - f1 * 0.6F;
/* 42 */     this.field_78112_f.field_78795_f = -1.5707964F;
/* 43 */     this.field_78113_g.field_78795_f = -1.5707964F;
/* 44 */     this.field_78112_f.field_78795_f -= f1 * 1.2F - f2 * 0.4F;
/* 45 */     this.field_78113_g.field_78795_f -= f1 * 1.2F - f2 * 0.4F;
/*    */     
/* 47 */     this.field_78112_f.field_78808_h += MathHelper.func_76134_b(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
/* 48 */     this.field_78113_g.field_78808_h -= MathHelper.func_76134_b(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
/* 49 */     this.field_78112_f.field_78795_f += MathHelper.func_76126_a(p_78087_3_ * 0.067F) * 0.05F;
/* 50 */     this.field_78113_g.field_78795_f -= MathHelper.func_76126_a(p_78087_3_ * 0.067F) * 0.05F;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\ModelZombieVillager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */