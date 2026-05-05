/*    */ package net.minecraft.client.particle;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class EntityPortalFX extends EntityFX {
/*    */   private float field_70571_a;
/*    */   private double field_70574_aq;
/*    */   
/*    */   public EntityPortalFX(World p_i1222_1_, double p_i1222_2_, double p_i1222_4_, double p_i1222_6_, double p_i1222_8_, double p_i1222_10_, double p_i1222_12_) {
/* 11 */     super(p_i1222_1_, p_i1222_2_, p_i1222_4_, p_i1222_6_, p_i1222_8_, p_i1222_10_, p_i1222_12_);
/*    */     
/* 13 */     this.field_70159_w = p_i1222_8_;
/* 14 */     this.field_70181_x = p_i1222_10_;
/* 15 */     this.field_70179_y = p_i1222_12_;
/* 16 */     this.field_70574_aq = this.field_70165_t = p_i1222_2_;
/* 17 */     this.field_70573_ar = this.field_70163_u = p_i1222_4_;
/* 18 */     this.field_70572_as = this.field_70161_v = p_i1222_6_;
/*    */     
/* 20 */     float f = this.field_70146_Z.nextFloat() * 0.6F + 0.4F;
/* 21 */     this.field_70571_a = this.field_70544_f = this.field_70146_Z.nextFloat() * 0.2F + 0.5F;
/* 22 */     this.field_70552_h = this.field_70553_i = this.field_70551_j = 1.0F * f;
/* 23 */     this.field_70553_i *= 0.3F;
/* 24 */     this.field_70552_h *= 0.9F;
/*    */     
/* 26 */     this.field_70547_e = (int)(Math.random() * 10.0D) + 40;
/* 27 */     this.field_70145_X = true;
/* 28 */     func_70536_a((int)(Math.random() * 8.0D));
/*    */   }
/*    */   private double field_70573_ar; private double field_70572_as; private static final String __OBFID = "CL_00000921";
/*    */   
/*    */   public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {
/* 33 */     float f = (this.field_70546_d + p_70539_2_) / this.field_70547_e;
/* 34 */     f = 1.0F - f;
/* 35 */     f *= f;
/* 36 */     f = 1.0F - f;
/* 37 */     this.field_70544_f = this.field_70571_a * f;
/* 38 */     super.func_70539_a(p_70539_1_, p_70539_2_, p_70539_3_, p_70539_4_, p_70539_5_, p_70539_6_, p_70539_7_);
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_70070_b(float p_70070_1_) {
/* 43 */     int i = super.func_70070_b(p_70070_1_);
/*    */     
/* 45 */     float f = this.field_70546_d / this.field_70547_e;
/* 46 */     f *= f;
/* 47 */     f *= f;
/*    */     
/* 49 */     int j = i & 0xFF;
/* 50 */     int k = i >> 16 & 0xFF;
/* 51 */     k += (int)(f * 15.0F * 16.0F);
/* 52 */     if (k > 240) k = 240; 
/* 53 */     return j | k << 16;
/*    */   }
/*    */ 
/*    */   
/*    */   public float func_70013_c(float p_70013_1_) {
/* 58 */     float f1 = super.func_70013_c(p_70013_1_);
/* 59 */     float f2 = this.field_70546_d / this.field_70547_e;
/* 60 */     f2 = f2 * f2 * f2 * f2;
/* 61 */     return f1 * (1.0F - f2) + f2;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70071_h_() {
/* 66 */     this.field_70169_q = this.field_70165_t;
/* 67 */     this.field_70167_r = this.field_70163_u;
/* 68 */     this.field_70166_s = this.field_70161_v;
/*    */     
/* 70 */     float f1 = this.field_70546_d / this.field_70547_e;
/* 71 */     float f2 = f1;
/* 72 */     f1 = -f1 + f1 * f1 * 2.0F;
/* 73 */     f1 = 1.0F - f1;
/*    */     
/* 75 */     this.field_70165_t = this.field_70574_aq + this.field_70159_w * f1;
/* 76 */     this.field_70163_u = this.field_70573_ar + this.field_70181_x * f1 + (1.0F - f2);
/* 77 */     this.field_70161_v = this.field_70572_as + this.field_70179_y * f1;
/*    */     
/* 79 */     if (this.field_70546_d++ >= this.field_70547_e) func_70106_y(); 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\particle\EntityPortalFX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */