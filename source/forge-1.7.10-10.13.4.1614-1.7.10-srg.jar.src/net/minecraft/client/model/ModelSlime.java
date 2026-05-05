/*    */ package net.minecraft.client.model;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ModelSlime extends ModelBase {
/*    */   ModelRenderer field_78200_a;
/*    */   ModelRenderer field_78198_b;
/*    */   
/*    */   public ModelSlime(int p_i1157_1_) {
/* 11 */     this.field_78200_a = new ModelRenderer(this, 0, p_i1157_1_);
/* 12 */     this.field_78200_a.func_78789_a(-4.0F, 16.0F, -4.0F, 8, 8, 8);
/* 13 */     if (p_i1157_1_ > 0) {
/* 14 */       this.field_78200_a = new ModelRenderer(this, 0, p_i1157_1_);
/* 15 */       this.field_78200_a.func_78789_a(-3.0F, 17.0F, -3.0F, 6, 6, 6);
/*    */       
/* 17 */       this.field_78198_b = new ModelRenderer(this, 32, 0);
/* 18 */       this.field_78198_b.func_78789_a(-3.25F, 18.0F, -3.5F, 2, 2, 2);
/*    */       
/* 20 */       this.field_78199_c = new ModelRenderer(this, 32, 4);
/* 21 */       this.field_78199_c.func_78789_a(1.25F, 18.0F, -3.5F, 2, 2, 2);
/*    */       
/* 23 */       this.field_78197_d = new ModelRenderer(this, 32, 8);
/* 24 */       this.field_78197_d.func_78789_a(0.0F, 21.0F, -3.5F, 1, 1, 1);
/*    */     } 
/*    */   }
/*    */   ModelRenderer field_78199_c; ModelRenderer field_78197_d; private static final String __OBFID = "CL_00000858";
/*    */   
/*    */   public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
/* 30 */     func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
/*    */     
/* 32 */     this.field_78200_a.func_78785_a(p_78088_7_);
/* 33 */     if (this.field_78198_b != null) {
/* 34 */       this.field_78198_b.func_78785_a(p_78088_7_);
/* 35 */       this.field_78199_c.func_78785_a(p_78088_7_);
/* 36 */       this.field_78197_d.func_78785_a(p_78088_7_);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\ModelSlime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */