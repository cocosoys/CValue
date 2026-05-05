/*    */ package net.minecraft.client.model;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.MathHelper;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ModelWitch extends ModelVillager {
/*    */   public boolean field_82900_g;
/*    */   private ModelRenderer field_82901_h;
/*    */   
/*    */   public ModelWitch(float p_i1166_1_) {
/* 13 */     super(p_i1166_1_, 0.0F, 64, 128);
/*    */     
/* 15 */     this.field_82901_h = (new ModelRenderer(this)).func_78787_b(64, 128);
/* 16 */     this.field_82901_h.func_78793_a(0.0F, -2.0F, 0.0F);
/* 17 */     this.field_82901_h.func_78784_a(0, 0).func_78790_a(0.0F, 3.0F, -6.75F, 1, 1, 1, -0.25F);
/* 18 */     this.field_82898_f.func_78792_a(this.field_82901_h);
/*    */     
/* 20 */     this.field_82902_i = (new ModelRenderer(this)).func_78787_b(64, 128);
/* 21 */     this.field_82902_i.func_78793_a(-5.0F, -10.03125F, -5.0F);
/* 22 */     this.field_82902_i.func_78784_a(0, 64).func_78789_a(0.0F, 0.0F, 0.0F, 10, 2, 10);
/* 23 */     this.field_78191_a.func_78792_a(this.field_82902_i);
/*    */     
/* 25 */     ModelRenderer modelRenderer1 = (new ModelRenderer(this)).func_78787_b(64, 128);
/* 26 */     modelRenderer1.func_78793_a(1.75F, -4.0F, 2.0F);
/* 27 */     modelRenderer1.func_78784_a(0, 76).func_78789_a(0.0F, 0.0F, 0.0F, 7, 4, 7);
/* 28 */     modelRenderer1.field_78795_f = -0.05235988F;
/* 29 */     modelRenderer1.field_78808_h = 0.02617994F;
/* 30 */     this.field_82902_i.func_78792_a(modelRenderer1);
/*    */     
/* 32 */     ModelRenderer modelRenderer2 = (new ModelRenderer(this)).func_78787_b(64, 128);
/* 33 */     modelRenderer2.func_78793_a(1.75F, -4.0F, 2.0F);
/* 34 */     modelRenderer2.func_78784_a(0, 87).func_78789_a(0.0F, 0.0F, 0.0F, 4, 4, 4);
/* 35 */     modelRenderer2.field_78795_f = -0.10471976F;
/* 36 */     modelRenderer2.field_78808_h = 0.05235988F;
/* 37 */     modelRenderer1.func_78792_a(modelRenderer2);
/*    */     
/* 39 */     ModelRenderer modelRenderer3 = (new ModelRenderer(this)).func_78787_b(64, 128);
/* 40 */     modelRenderer3.func_78793_a(1.75F, -2.0F, 2.0F);
/* 41 */     modelRenderer3.func_78784_a(0, 95).func_78790_a(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.25F);
/* 42 */     modelRenderer3.field_78795_f = -0.20943952F;
/* 43 */     modelRenderer3.field_78808_h = 0.10471976F;
/* 44 */     modelRenderer2.func_78792_a(modelRenderer3);
/*    */   }
/*    */   private ModelRenderer field_82902_i; private static final String __OBFID = "CL_00000866";
/*    */   
/*    */   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
/* 49 */     super.func_78087_a(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
/*    */     
/* 51 */     this.field_82898_f.field_82906_o = this.field_82898_f.field_82908_p = this.field_82898_f.field_82907_q = 0.0F;
/*    */     
/* 53 */     float f = 0.01F * (p_78087_7_.func_145782_y() % 10);
/* 54 */     this.field_82898_f.field_78795_f = MathHelper.func_76126_a(p_78087_7_.field_70173_aa * f) * 4.5F * 3.1415927F / 180.0F;
/* 55 */     this.field_82898_f.field_78796_g = 0.0F;
/* 56 */     this.field_82898_f.field_78808_h = MathHelper.func_76134_b(p_78087_7_.field_70173_aa * f) * 2.5F * 3.1415927F / 180.0F;
/*    */     
/* 58 */     if (this.field_82900_g) {
/* 59 */       this.field_82898_f.field_78795_f = -0.9F;
/* 60 */       this.field_82898_f.field_82907_q = -0.09375F;
/* 61 */       this.field_82898_f.field_82908_p = 0.1875F;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\ModelWitch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */