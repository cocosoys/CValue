/*    */ package net.minecraft.client.particle;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class EntityEnchantmentTableParticleFX extends EntityFX {
/*    */   private float field_70565_a;
/*    */   private double field_70568_aq;
/*    */   
/*    */   public EntityEnchantmentTableParticleFX(World p_i1204_1_, double p_i1204_2_, double p_i1204_4_, double p_i1204_6_, double p_i1204_8_, double p_i1204_10_, double p_i1204_12_) {
/* 11 */     super(p_i1204_1_, p_i1204_2_, p_i1204_4_, p_i1204_6_, p_i1204_8_, p_i1204_10_, p_i1204_12_);
/*    */     
/* 13 */     this.field_70159_w = p_i1204_8_;
/* 14 */     this.field_70181_x = p_i1204_10_;
/* 15 */     this.field_70179_y = p_i1204_12_;
/* 16 */     this.field_70568_aq = this.field_70165_t = p_i1204_2_;
/* 17 */     this.field_70567_ar = this.field_70163_u = p_i1204_4_;
/* 18 */     this.field_70566_as = this.field_70161_v = p_i1204_6_;
/*    */     
/* 20 */     float f = this.field_70146_Z.nextFloat() * 0.6F + 0.4F;
/* 21 */     this.field_70565_a = this.field_70544_f = this.field_70146_Z.nextFloat() * 0.5F + 0.2F;
/* 22 */     this.field_70552_h = this.field_70553_i = this.field_70551_j = 1.0F * f;
/* 23 */     this.field_70553_i *= 0.9F;
/* 24 */     this.field_70552_h *= 0.9F;
/*    */     
/* 26 */     this.field_70547_e = (int)(Math.random() * 10.0D) + 30;
/* 27 */     this.field_70145_X = true;
/* 28 */     func_70536_a((int)(Math.random() * 26.0D + 1.0D + 224.0D));
/*    */   }
/*    */   private double field_70567_ar; private double field_70566_as; private static final String __OBFID = "CL_00000902";
/*    */   
/*    */   public int func_70070_b(float p_70070_1_) {
/* 33 */     int i = super.func_70070_b(p_70070_1_);
/*    */     
/* 35 */     float f = this.field_70546_d / this.field_70547_e;
/* 36 */     f *= f;
/* 37 */     f *= f;
/*    */     
/* 39 */     int j = i & 0xFF;
/* 40 */     int k = i >> 16 & 0xFF;
/* 41 */     k += (int)(f * 15.0F * 16.0F);
/* 42 */     if (k > 240) k = 240; 
/* 43 */     return j | k << 16;
/*    */   }
/*    */ 
/*    */   
/*    */   public float func_70013_c(float p_70013_1_) {
/* 48 */     float f1 = super.func_70013_c(p_70013_1_);
/* 49 */     float f2 = this.field_70546_d / this.field_70547_e;
/* 50 */     f2 *= f2;
/* 51 */     f2 *= f2;
/* 52 */     return f1 * (1.0F - f2) + f2;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70071_h_() {
/* 57 */     this.field_70169_q = this.field_70165_t;
/* 58 */     this.field_70167_r = this.field_70163_u;
/* 59 */     this.field_70166_s = this.field_70161_v;
/*    */     
/* 61 */     float f1 = this.field_70546_d / this.field_70547_e;
/* 62 */     f1 = 1.0F - f1;
/*    */     
/* 64 */     float f2 = 1.0F - f1;
/* 65 */     f2 *= f2;
/* 66 */     f2 *= f2;
/* 67 */     this.field_70165_t = this.field_70568_aq + this.field_70159_w * f1;
/* 68 */     this.field_70163_u = this.field_70567_ar + this.field_70181_x * f1 - (f2 * 1.2F);
/* 69 */     this.field_70161_v = this.field_70566_as + this.field_70179_y * f1;
/*    */     
/* 71 */     if (this.field_70546_d++ >= this.field_70547_e) func_70106_y(); 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\particle\EntityEnchantmentTableParticleFX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */