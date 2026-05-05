/*    */ package net.minecraft.client.model;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.MathHelper;
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ModelBlaze
/*    */   extends ModelBase
/*    */ {
/* 13 */   private ModelRenderer[] field_78106_a = new ModelRenderer[12]; private ModelRenderer field_78105_b;
/*    */   public ModelBlaze() {
/* 15 */     for (byte b = 0; b < this.field_78106_a.length; b++) {
/* 16 */       this.field_78106_a[b] = new ModelRenderer(this, 0, 16);
/* 17 */       this.field_78106_a[b].func_78789_a(0.0F, 0.0F, 0.0F, 2, 8, 2);
/*    */     } 
/*    */     
/* 20 */     this.field_78105_b = new ModelRenderer(this, 0, 0);
/* 21 */     this.field_78105_b.func_78789_a(-4.0F, -4.0F, -4.0F, 8, 8, 8);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000831";
/*    */   
/*    */   public int func_78104_a() {
/* 26 */     return 8;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
/* 31 */     func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
/*    */     
/* 33 */     this.field_78105_b.func_78785_a(p_78088_7_);
/* 34 */     for (byte b = 0; b < this.field_78106_a.length; b++) {
/* 35 */       this.field_78106_a[b].func_78785_a(p_78088_7_);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
/* 41 */     float f = p_78087_3_ * 3.1415927F * -0.1F; byte b;
/* 42 */     for (b = 0; b < 4; b++) {
/* 43 */       (this.field_78106_a[b]).field_78797_d = -2.0F + MathHelper.func_76134_b(((b * 2) + p_78087_3_) * 0.25F);
/* 44 */       (this.field_78106_a[b]).field_78800_c = MathHelper.func_76134_b(f) * 9.0F;
/* 45 */       (this.field_78106_a[b]).field_78798_e = MathHelper.func_76126_a(f) * 9.0F;
/* 46 */       f += 1.5707964F;
/*    */     } 
/*    */     
/* 49 */     f = 0.7853982F + p_78087_3_ * 3.1415927F * 0.03F;
/* 50 */     for (b = 4; b < 8; b++) {
/* 51 */       (this.field_78106_a[b]).field_78797_d = 2.0F + MathHelper.func_76134_b(((b * 2) + p_78087_3_) * 0.25F);
/* 52 */       (this.field_78106_a[b]).field_78800_c = MathHelper.func_76134_b(f) * 7.0F;
/* 53 */       (this.field_78106_a[b]).field_78798_e = MathHelper.func_76126_a(f) * 7.0F;
/* 54 */       f += 1.5707964F;
/*    */     } 
/*    */     
/* 57 */     f = 0.47123894F + p_78087_3_ * 3.1415927F * -0.05F;
/* 58 */     for (b = 8; b < 12; b++) {
/* 59 */       (this.field_78106_a[b]).field_78797_d = 11.0F + MathHelper.func_76134_b((b * 1.5F + p_78087_3_) * 0.5F);
/* 60 */       (this.field_78106_a[b]).field_78800_c = MathHelper.func_76134_b(f) * 5.0F;
/* 61 */       (this.field_78106_a[b]).field_78798_e = MathHelper.func_76126_a(f) * 5.0F;
/* 62 */       f += 1.5707964F;
/*    */     } 
/*    */     
/* 65 */     this.field_78105_b.field_78796_g = p_78087_4_ / 57.295776F;
/* 66 */     this.field_78105_b.field_78795_f = p_78087_5_ / 57.295776F;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\ModelBlaze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */