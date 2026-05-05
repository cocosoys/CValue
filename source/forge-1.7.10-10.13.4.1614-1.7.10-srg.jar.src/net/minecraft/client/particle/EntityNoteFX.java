/*    */ package net.minecraft.client.particle;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class EntityNoteFX extends EntityFX {
/*    */   float field_70585_a;
/*    */   
/*    */   public EntityNoteFX(World p_i1216_1_, double p_i1216_2_, double p_i1216_4_, double p_i1216_6_, double p_i1216_8_, double p_i1216_10_, double p_i1216_12_) {
/* 11 */     this(p_i1216_1_, p_i1216_2_, p_i1216_4_, p_i1216_6_, p_i1216_8_, p_i1216_10_, p_i1216_12_, 2.0F);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000913";
/*    */   public EntityNoteFX(World p_i1217_1_, double p_i1217_2_, double p_i1217_4_, double p_i1217_6_, double p_i1217_8_, double p_i1217_10_, double p_i1217_12_, float p_i1217_14_) {
/* 15 */     super(p_i1217_1_, p_i1217_2_, p_i1217_4_, p_i1217_6_, 0.0D, 0.0D, 0.0D);
/* 16 */     this.field_70159_w *= 0.009999999776482582D;
/* 17 */     this.field_70181_x *= 0.009999999776482582D;
/* 18 */     this.field_70179_y *= 0.009999999776482582D;
/* 19 */     this.field_70181_x += 0.2D;
/*    */     
/* 21 */     this.field_70552_h = MathHelper.func_76126_a(((float)p_i1217_8_ + 0.0F) * 3.1415927F * 2.0F) * 0.65F + 0.35F;
/* 22 */     this.field_70553_i = MathHelper.func_76126_a(((float)p_i1217_8_ + 0.33333334F) * 3.1415927F * 2.0F) * 0.65F + 0.35F;
/* 23 */     this.field_70551_j = MathHelper.func_76126_a(((float)p_i1217_8_ + 0.6666667F) * 3.1415927F * 2.0F) * 0.65F + 0.35F;
/*    */     
/* 25 */     this.field_70544_f *= 0.75F;
/* 26 */     this.field_70544_f *= p_i1217_14_;
/* 27 */     this.field_70585_a = this.field_70544_f;
/*    */     
/* 29 */     this.field_70547_e = 6;
/* 30 */     this.field_70145_X = false;
/*    */     
/* 32 */     func_70536_a(64);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {
/* 38 */     float f = (this.field_70546_d + p_70539_2_) / this.field_70547_e * 32.0F;
/* 39 */     if (f < 0.0F) f = 0.0F; 
/* 40 */     if (f > 1.0F) f = 1.0F;
/*    */     
/* 42 */     this.field_70544_f = this.field_70585_a * f;
/* 43 */     super.func_70539_a(p_70539_1_, p_70539_2_, p_70539_3_, p_70539_4_, p_70539_5_, p_70539_6_, p_70539_7_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70071_h_() {
/* 48 */     this.field_70169_q = this.field_70165_t;
/* 49 */     this.field_70167_r = this.field_70163_u;
/* 50 */     this.field_70166_s = this.field_70161_v;
/*    */     
/* 52 */     if (this.field_70546_d++ >= this.field_70547_e) func_70106_y();
/*    */     
/* 54 */     func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/* 55 */     if (this.field_70163_u == this.field_70167_r) {
/* 56 */       this.field_70159_w *= 1.1D;
/* 57 */       this.field_70179_y *= 1.1D;
/*    */     } 
/* 59 */     this.field_70159_w *= 0.6600000262260437D;
/* 60 */     this.field_70181_x *= 0.6600000262260437D;
/* 61 */     this.field_70179_y *= 0.6600000262260437D;
/*    */     
/* 63 */     if (this.field_70122_E) {
/* 64 */       this.field_70159_w *= 0.699999988079071D;
/* 65 */       this.field_70179_y *= 0.699999988079071D;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\particle\EntityNoteFX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */