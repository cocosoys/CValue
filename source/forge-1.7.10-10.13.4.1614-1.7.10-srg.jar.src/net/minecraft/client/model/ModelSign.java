/*    */ package net.minecraft.client.model;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ModelSign extends ModelBase {
/*    */   public ModelRenderer field_78166_a;
/*    */   
/*    */   public ModelSign() {
/* 10 */     this.field_78166_a = new ModelRenderer(this, 0, 0);
/* 11 */     this.field_78166_a.func_78790_a(-12.0F, -14.0F, -1.0F, 24, 12, 2, 0.0F);
/*    */     
/* 13 */     this.field_78165_b = new ModelRenderer(this, 0, 14);
/* 14 */     this.field_78165_b.func_78790_a(-1.0F, -2.0F, -1.0F, 2, 14, 2, 0.0F);
/*    */   }
/*    */   public ModelRenderer field_78165_b; private static final String __OBFID = "CL_00000854";
/*    */   public void func_78164_a() {
/* 18 */     this.field_78166_a.func_78785_a(0.0625F);
/* 19 */     this.field_78165_b.func_78785_a(0.0625F);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\ModelSign.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */