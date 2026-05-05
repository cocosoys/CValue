/*    */ package net.minecraft.client.model;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ModelEnderman extends ModelBiped {
/*    */   public boolean field_78126_a;
/*    */   
/*    */   public ModelEnderman() {
/* 11 */     super(0.0F, -14.0F, 64, 32);
/* 12 */     float f1 = -14.0F;
/* 13 */     float f2 = 0.0F;
/*    */     
/* 15 */     this.field_78114_d = new ModelRenderer(this, 0, 16);
/* 16 */     this.field_78114_d.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, f2 - 0.5F);
/* 17 */     this.field_78114_d.func_78793_a(0.0F, 0.0F + f1, 0.0F);
/*    */     
/* 19 */     this.field_78115_e = new ModelRenderer(this, 32, 16);
/* 20 */     this.field_78115_e.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, f2);
/* 21 */     this.field_78115_e.func_78793_a(0.0F, 0.0F + f1, 0.0F);
/*    */     
/* 23 */     this.field_78112_f = new ModelRenderer(this, 56, 0);
/* 24 */     this.field_78112_f.func_78790_a(-1.0F, -2.0F, -1.0F, 2, 30, 2, f2);
/* 25 */     this.field_78112_f.func_78793_a(-3.0F, 2.0F + f1, 0.0F);
/*    */     
/* 27 */     this.field_78113_g = new ModelRenderer(this, 56, 0);
/* 28 */     this.field_78113_g.field_78809_i = true;
/* 29 */     this.field_78113_g.func_78790_a(-1.0F, -2.0F, -1.0F, 2, 30, 2, f2);
/* 30 */     this.field_78113_g.func_78793_a(5.0F, 2.0F + f1, 0.0F);
/*    */     
/* 32 */     this.field_78123_h = new ModelRenderer(this, 56, 0);
/* 33 */     this.field_78123_h.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 30, 2, f2);
/* 34 */     this.field_78123_h.func_78793_a(-2.0F, 12.0F + f1, 0.0F);
/*    */     
/* 36 */     this.field_78124_i = new ModelRenderer(this, 56, 0);
/* 37 */     this.field_78124_i.field_78809_i = true;
/* 38 */     this.field_78124_i.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 30, 2, f2);
/* 39 */     this.field_78124_i.func_78793_a(2.0F, 12.0F + f1, 0.0F);
/*    */   }
/*    */   public boolean field_78125_b; private static final String __OBFID = "CL_00000838";
/*    */   
/*    */   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
/* 44 */     super.func_78087_a(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
/*    */     
/* 46 */     this.field_78116_c.field_78806_j = true;
/*    */     
/* 48 */     float f1 = -14.0F;
/* 49 */     this.field_78115_e.field_78795_f = 0.0F;
/* 50 */     this.field_78115_e.field_78797_d = f1;
/* 51 */     this.field_78115_e.field_78798_e = -0.0F;
/*    */     
/* 53 */     this.field_78123_h.field_78795_f -= 0.0F;
/* 54 */     this.field_78124_i.field_78795_f -= 0.0F;
/*    */     
/* 56 */     this.field_78112_f.field_78795_f = (float)(this.field_78112_f.field_78795_f * 0.5D);
/* 57 */     this.field_78113_g.field_78795_f = (float)(this.field_78113_g.field_78795_f * 0.5D);
/* 58 */     this.field_78123_h.field_78795_f = (float)(this.field_78123_h.field_78795_f * 0.5D);
/* 59 */     this.field_78124_i.field_78795_f = (float)(this.field_78124_i.field_78795_f * 0.5D);
/*    */     
/* 61 */     float f2 = 0.4F;
/* 62 */     if (this.field_78112_f.field_78795_f > f2) this.field_78112_f.field_78795_f = f2; 
/* 63 */     if (this.field_78113_g.field_78795_f > f2) this.field_78113_g.field_78795_f = f2; 
/* 64 */     if (this.field_78112_f.field_78795_f < -f2) this.field_78112_f.field_78795_f = -f2; 
/* 65 */     if (this.field_78113_g.field_78795_f < -f2) this.field_78113_g.field_78795_f = -f2; 
/* 66 */     if (this.field_78123_h.field_78795_f > f2) this.field_78123_h.field_78795_f = f2; 
/* 67 */     if (this.field_78124_i.field_78795_f > f2) this.field_78124_i.field_78795_f = f2; 
/* 68 */     if (this.field_78123_h.field_78795_f < -f2) this.field_78123_h.field_78795_f = -f2; 
/* 69 */     if (this.field_78124_i.field_78795_f < -f2) this.field_78124_i.field_78795_f = -f2;
/*    */     
/* 71 */     if (this.field_78126_a) {
/* 72 */       this.field_78112_f.field_78795_f = -0.5F;
/* 73 */       this.field_78113_g.field_78795_f = -0.5F;
/* 74 */       this.field_78112_f.field_78808_h = 0.05F;
/* 75 */       this.field_78113_g.field_78808_h = -0.05F;
/*    */     } 
/*    */     
/* 78 */     this.field_78112_f.field_78798_e = 0.0F;
/* 79 */     this.field_78113_g.field_78798_e = 0.0F;
/* 80 */     this.field_78123_h.field_78798_e = 0.0F;
/* 81 */     this.field_78124_i.field_78798_e = 0.0F;
/*    */     
/* 83 */     this.field_78123_h.field_78797_d = 9.0F + f1;
/* 84 */     this.field_78124_i.field_78797_d = 9.0F + f1;
/*    */     
/* 86 */     this.field_78116_c.field_78798_e = -0.0F;
/* 87 */     this.field_78116_c.field_78797_d = f1 + 1.0F;
/*    */     
/* 89 */     this.field_78114_d.field_78800_c = this.field_78116_c.field_78800_c;
/* 90 */     this.field_78114_d.field_78797_d = this.field_78116_c.field_78797_d;
/* 91 */     this.field_78114_d.field_78798_e = this.field_78116_c.field_78798_e;
/* 92 */     this.field_78114_d.field_78795_f = this.field_78116_c.field_78795_f;
/* 93 */     this.field_78114_d.field_78796_g = this.field_78116_c.field_78796_g;
/* 94 */     this.field_78114_d.field_78808_h = this.field_78116_c.field_78808_h;
/*    */     
/* 96 */     if (this.field_78125_b) {
/* 97 */       float f = 1.0F;
/* 98 */       this.field_78116_c.field_78797_d -= f * 5.0F;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\ModelEnderman.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */