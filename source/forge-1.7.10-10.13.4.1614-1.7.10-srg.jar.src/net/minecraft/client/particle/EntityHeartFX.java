/*    */ package net.minecraft.client.particle;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class EntityHeartFX extends EntityFX {
/*    */   float field_70575_a;
/*    */   
/*    */   public EntityHeartFX(World p_i1211_1_, double p_i1211_2_, double p_i1211_4_, double p_i1211_6_, double p_i1211_8_, double p_i1211_10_, double p_i1211_12_) {
/* 10 */     this(p_i1211_1_, p_i1211_2_, p_i1211_4_, p_i1211_6_, p_i1211_8_, p_i1211_10_, p_i1211_12_, 2.0F);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000909";
/*    */   public EntityHeartFX(World p_i1212_1_, double p_i1212_2_, double p_i1212_4_, double p_i1212_6_, double p_i1212_8_, double p_i1212_10_, double p_i1212_12_, float p_i1212_14_) {
/* 14 */     super(p_i1212_1_, p_i1212_2_, p_i1212_4_, p_i1212_6_, 0.0D, 0.0D, 0.0D);
/* 15 */     this.field_70159_w *= 0.009999999776482582D;
/* 16 */     this.field_70181_x *= 0.009999999776482582D;
/* 17 */     this.field_70179_y *= 0.009999999776482582D;
/* 18 */     this.field_70181_x += 0.1D;
/*    */     
/* 20 */     this.field_70544_f *= 0.75F;
/* 21 */     this.field_70544_f *= p_i1212_14_;
/* 22 */     this.field_70575_a = this.field_70544_f;
/*    */     
/* 24 */     this.field_70547_e = 16;
/* 25 */     this.field_70145_X = false;
/*    */     
/* 27 */     func_70536_a(80);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {
/* 32 */     float f = (this.field_70546_d + p_70539_2_) / this.field_70547_e * 32.0F;
/* 33 */     if (f < 0.0F) f = 0.0F; 
/* 34 */     if (f > 1.0F) f = 1.0F;
/*    */     
/* 36 */     this.field_70544_f = this.field_70575_a * f;
/* 37 */     super.func_70539_a(p_70539_1_, p_70539_2_, p_70539_3_, p_70539_4_, p_70539_5_, p_70539_6_, p_70539_7_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70071_h_() {
/* 42 */     this.field_70169_q = this.field_70165_t;
/* 43 */     this.field_70167_r = this.field_70163_u;
/* 44 */     this.field_70166_s = this.field_70161_v;
/*    */     
/* 46 */     if (this.field_70546_d++ >= this.field_70547_e) func_70106_y();
/*    */     
/* 48 */     func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/* 49 */     if (this.field_70163_u == this.field_70167_r) {
/* 50 */       this.field_70159_w *= 1.1D;
/* 51 */       this.field_70179_y *= 1.1D;
/*    */     } 
/* 53 */     this.field_70159_w *= 0.8600000143051147D;
/* 54 */     this.field_70181_x *= 0.8600000143051147D;
/* 55 */     this.field_70179_y *= 0.8600000143051147D;
/*    */     
/* 57 */     if (this.field_70122_E) {
/* 58 */       this.field_70159_w *= 0.699999988079071D;
/* 59 */       this.field_70179_y *= 0.699999988079071D;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\particle\EntityHeartFX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */