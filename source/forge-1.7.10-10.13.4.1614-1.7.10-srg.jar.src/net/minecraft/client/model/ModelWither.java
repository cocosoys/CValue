/*    */ package net.minecraft.client.model;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.boss.EntityWither;
/*    */ import net.minecraft.util.MathHelper;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ModelWither extends ModelBase {
/*    */   private ModelRenderer[] field_82905_a;
/*    */   
/*    */   public ModelWither() {
/* 14 */     this.field_78090_t = 64;
/* 15 */     this.field_78089_u = 64;
/*    */     
/* 17 */     this.field_82905_a = new ModelRenderer[3];
/*    */     
/* 19 */     this.field_82905_a[0] = new ModelRenderer(this, 0, 16);
/* 20 */     this.field_82905_a[0].func_78789_a(-10.0F, 3.9F, -0.5F, 20, 3, 3);
/*    */     
/* 22 */     this.field_82905_a[1] = (new ModelRenderer(this)).func_78787_b(this.field_78090_t, this.field_78089_u);
/* 23 */     this.field_82905_a[1].func_78793_a(-2.0F, 6.9F, -0.5F);
/* 24 */     this.field_82905_a[1].func_78784_a(0, 22).func_78789_a(0.0F, 0.0F, 0.0F, 3, 10, 3);
/* 25 */     this.field_82905_a[1].func_78784_a(24, 22).func_78789_a(-4.0F, 1.5F, 0.5F, 11, 2, 2);
/* 26 */     this.field_82905_a[1].func_78784_a(24, 22).func_78789_a(-4.0F, 4.0F, 0.5F, 11, 2, 2);
/* 27 */     this.field_82905_a[1].func_78784_a(24, 22).func_78789_a(-4.0F, 6.5F, 0.5F, 11, 2, 2);
/*    */     
/* 29 */     this.field_82905_a[2] = new ModelRenderer(this, 12, 22);
/* 30 */     this.field_82905_a[2].func_78789_a(0.0F, 0.0F, 0.0F, 3, 6, 3);
/*    */     
/* 32 */     this.field_82904_b = new ModelRenderer[3];
/* 33 */     this.field_82904_b[0] = new ModelRenderer(this, 0, 0);
/* 34 */     this.field_82904_b[0].func_78789_a(-4.0F, -4.0F, -4.0F, 8, 8, 8);
/* 35 */     this.field_82904_b[1] = new ModelRenderer(this, 32, 0);
/* 36 */     this.field_82904_b[1].func_78789_a(-4.0F, -4.0F, -4.0F, 6, 6, 6);
/* 37 */     (this.field_82904_b[1]).field_78800_c = -8.0F;
/* 38 */     (this.field_82904_b[1]).field_78797_d = 4.0F;
/* 39 */     this.field_82904_b[2] = new ModelRenderer(this, 32, 0);
/* 40 */     this.field_82904_b[2].func_78789_a(-4.0F, -4.0F, -4.0F, 6, 6, 6);
/* 41 */     (this.field_82904_b[2]).field_78800_c = 10.0F;
/* 42 */     (this.field_82904_b[2]).field_78797_d = 4.0F;
/*    */   }
/*    */   private ModelRenderer[] field_82904_b; private static final String __OBFID = "CL_00000867";
/*    */   
/*    */   public int func_82903_a() {
/* 47 */     return 32;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
/* 52 */     func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
/*    */     
/* 54 */     for (ModelRenderer modelRenderer : this.field_82904_b) {
/* 55 */       modelRenderer.func_78785_a(p_78088_7_);
/*    */     }
/* 57 */     for (ModelRenderer modelRenderer : this.field_82905_a) {
/* 58 */       modelRenderer.func_78785_a(p_78088_7_);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
/* 65 */     float f = MathHelper.func_76134_b(p_78087_3_ * 0.1F);
/* 66 */     (this.field_82905_a[1]).field_78795_f = (0.065F + 0.05F * f) * 3.1415927F;
/*    */     
/* 68 */     this.field_82905_a[2].func_78793_a(-2.0F, 6.9F + MathHelper.func_76134_b((this.field_82905_a[1]).field_78795_f) * 10.0F, -0.5F + MathHelper.func_76126_a((this.field_82905_a[1]).field_78795_f) * 10.0F);
/* 69 */     (this.field_82905_a[2]).field_78795_f = (0.265F + 0.1F * f) * 3.1415927F;
/*    */     
/* 71 */     (this.field_82904_b[0]).field_78796_g = p_78087_4_ / 57.295776F;
/* 72 */     (this.field_82904_b[0]).field_78795_f = p_78087_5_ / 57.295776F;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78086_a(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_) {
/* 77 */     EntityWither entityWither = (EntityWither)p_78086_1_;
/*    */     
/* 79 */     for (byte b = 1; b < 3; b++) {
/* 80 */       (this.field_82904_b[b]).field_78796_g = (entityWither.func_82207_a(b - 1) - p_78086_1_.field_70761_aq) / 57.295776F;
/* 81 */       (this.field_82904_b[b]).field_78795_f = entityWither.func_82210_r(b - 1) / 57.295776F;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\ModelWither.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */