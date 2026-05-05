/*    */ package net.minecraft.client.model;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ModelChest extends ModelBase {
/*    */   public ModelRenderer field_78234_a;
/*    */   public ModelRenderer field_78232_b;
/*    */   
/*    */   public ModelChest() {
/* 11 */     this.field_78234_a = (new ModelRenderer(this, 0, 0)).func_78787_b(64, 64);
/* 12 */     this.field_78234_a.func_78790_a(0.0F, -5.0F, -14.0F, 14, 5, 14, 0.0F);
/* 13 */     this.field_78234_a.field_78800_c = 1.0F;
/* 14 */     this.field_78234_a.field_78797_d = 7.0F;
/* 15 */     this.field_78234_a.field_78798_e = 15.0F;
/*    */     
/* 17 */     this.field_78233_c = (new ModelRenderer(this, 0, 0)).func_78787_b(64, 64);
/* 18 */     this.field_78233_c.func_78790_a(-1.0F, -2.0F, -15.0F, 2, 4, 1, 0.0F);
/* 19 */     this.field_78233_c.field_78800_c = 8.0F;
/* 20 */     this.field_78233_c.field_78797_d = 7.0F;
/* 21 */     this.field_78233_c.field_78798_e = 15.0F;
/*    */     
/* 23 */     this.field_78232_b = (new ModelRenderer(this, 0, 19)).func_78787_b(64, 64);
/* 24 */     this.field_78232_b.func_78790_a(0.0F, 0.0F, 0.0F, 14, 10, 14, 0.0F);
/* 25 */     this.field_78232_b.field_78800_c = 1.0F;
/* 26 */     this.field_78232_b.field_78797_d = 6.0F;
/* 27 */     this.field_78232_b.field_78798_e = 1.0F;
/*    */   }
/*    */   public ModelRenderer field_78233_c; private static final String __OBFID = "CL_00000834";
/*    */   public void func_78231_a() {
/* 31 */     this.field_78233_c.field_78795_f = this.field_78234_a.field_78795_f;
/*    */     
/* 33 */     this.field_78234_a.func_78785_a(0.0625F);
/* 34 */     this.field_78233_c.func_78785_a(0.0625F);
/* 35 */     this.field_78232_b.func_78785_a(0.0625F);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\ModelChest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */