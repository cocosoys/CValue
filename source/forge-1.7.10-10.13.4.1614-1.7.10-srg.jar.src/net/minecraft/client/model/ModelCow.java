/*    */ package net.minecraft.client.model;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ModelCow extends ModelQuadruped {
/*    */   public ModelCow() {
/*  7 */     super(12, 0.0F);
/*    */     
/*  9 */     this.field_78150_a = new ModelRenderer(this, 0, 0);
/* 10 */     this.field_78150_a.func_78790_a(-4.0F, -4.0F, -6.0F, 8, 8, 6, 0.0F);
/* 11 */     this.field_78150_a.func_78793_a(0.0F, 4.0F, -8.0F);
/*    */     
/* 13 */     this.field_78150_a.func_78784_a(22, 0).func_78790_a(-5.0F, -5.0F, -4.0F, 1, 3, 1, 0.0F);
/* 14 */     this.field_78150_a.func_78784_a(22, 0).func_78790_a(4.0F, -5.0F, -4.0F, 1, 3, 1, 0.0F);
/*    */     
/* 16 */     this.field_78148_b = new ModelRenderer(this, 18, 4);
/* 17 */     this.field_78148_b.func_78790_a(-6.0F, -10.0F, -7.0F, 12, 18, 10, 0.0F);
/* 18 */     this.field_78148_b.func_78793_a(0.0F, 5.0F, 2.0F);
/* 19 */     this.field_78148_b.func_78784_a(52, 0).func_78789_a(-2.0F, 2.0F, -8.0F, 4, 6, 1);
/*    */     
/* 21 */     this.field_78149_c.field_78800_c--;
/* 22 */     this.field_78146_d.field_78800_c++;
/* 23 */     this.field_78149_c.field_78798_e += 0.0F;
/* 24 */     this.field_78146_d.field_78798_e += 0.0F;
/* 25 */     this.field_78147_e.field_78800_c--;
/* 26 */     this.field_78144_f.field_78800_c++;
/* 27 */     this.field_78147_e.field_78798_e--;
/* 28 */     this.field_78144_f.field_78798_e--;
/*    */     
/* 30 */     this.field_78151_h += 2.0F;
/*    */   }
/*    */   
/*    */   private static final String __OBFID = "CL_00000836";
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\ModelCow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */