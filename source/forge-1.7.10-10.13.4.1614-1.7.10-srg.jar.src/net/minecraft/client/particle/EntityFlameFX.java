/*    */ package net.minecraft.client.particle;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class EntityFlameFX extends EntityFX {
/*    */   private float field_70562_a;
/*    */   
/*    */   public EntityFlameFX(World p_i1209_1_, double p_i1209_2_, double p_i1209_4_, double p_i1209_6_, double p_i1209_8_, double p_i1209_10_, double p_i1209_12_) {
/* 10 */     super(p_i1209_1_, p_i1209_2_, p_i1209_4_, p_i1209_6_, p_i1209_8_, p_i1209_10_, p_i1209_12_);
/* 11 */     this.field_70159_w = this.field_70159_w * 0.009999999776482582D + p_i1209_8_;
/* 12 */     this.field_70181_x = this.field_70181_x * 0.009999999776482582D + p_i1209_10_;
/* 13 */     this.field_70179_y = this.field_70179_y * 0.009999999776482582D + p_i1209_12_;
/* 14 */     p_i1209_2_ += ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.05F);
/* 15 */     p_i1209_4_ += ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.05F);
/* 16 */     p_i1209_6_ += ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.05F);
/*    */     
/* 18 */     this.field_70562_a = this.field_70544_f;
/* 19 */     this.field_70552_h = this.field_70553_i = this.field_70551_j = 1.0F;
/*    */     
/* 21 */     this.field_70547_e = (int)(8.0D / (Math.random() * 0.8D + 0.2D)) + 4;
/* 22 */     this.field_70145_X = true;
/* 23 */     func_70536_a(48);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000907";
/*    */   
/*    */   public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {
/* 28 */     float f = (this.field_70546_d + p_70539_2_) / this.field_70547_e;
/* 29 */     this.field_70544_f = this.field_70562_a * (1.0F - f * f * 0.5F);
/* 30 */     super.func_70539_a(p_70539_1_, p_70539_2_, p_70539_3_, p_70539_4_, p_70539_5_, p_70539_6_, p_70539_7_);
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_70070_b(float p_70070_1_) {
/* 35 */     float f = (this.field_70546_d + p_70070_1_) / this.field_70547_e;
/* 36 */     if (f < 0.0F) f = 0.0F; 
/* 37 */     if (f > 1.0F) f = 1.0F; 
/* 38 */     int i = super.func_70070_b(p_70070_1_);
/*    */     
/* 40 */     int j = i & 0xFF;
/* 41 */     int k = i >> 16 & 0xFF;
/* 42 */     j += (int)(f * 15.0F * 16.0F);
/* 43 */     if (j > 240) j = 240; 
/* 44 */     return j | k << 16;
/*    */   }
/*    */ 
/*    */   
/*    */   public float func_70013_c(float p_70013_1_) {
/* 49 */     float f1 = (this.field_70546_d + p_70013_1_) / this.field_70547_e;
/* 50 */     if (f1 < 0.0F) f1 = 0.0F; 
/* 51 */     if (f1 > 1.0F) f1 = 1.0F; 
/* 52 */     float f2 = super.func_70013_c(p_70013_1_);
/*    */     
/* 54 */     return f2 * f1 + 1.0F - f1;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70071_h_() {
/* 59 */     this.field_70169_q = this.field_70165_t;
/* 60 */     this.field_70167_r = this.field_70163_u;
/* 61 */     this.field_70166_s = this.field_70161_v;
/*    */     
/* 63 */     if (this.field_70546_d++ >= this.field_70547_e) func_70106_y();
/*    */     
/* 65 */     func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/* 66 */     this.field_70159_w *= 0.9599999785423279D;
/* 67 */     this.field_70181_x *= 0.9599999785423279D;
/* 68 */     this.field_70179_y *= 0.9599999785423279D;
/*    */     
/* 70 */     if (this.field_70122_E) {
/* 71 */       this.field_70159_w *= 0.699999988079071D;
/* 72 */       this.field_70179_y *= 0.699999988079071D;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\particle\EntityFlameFX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */