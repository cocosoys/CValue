/*    */ package net.minecraft.client.particle;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class EntityFishWakeFX extends EntityFX {
/*    */   public EntityFishWakeFX(World p_i45073_1_, double p_i45073_2_, double p_i45073_4_, double p_i45073_6_, double p_i45073_8_, double p_i45073_10_, double p_i45073_12_) {
/*  7 */     super(p_i45073_1_, p_i45073_2_, p_i45073_4_, p_i45073_6_, 0.0D, 0.0D, 0.0D);
/*  8 */     this.field_70159_w *= 0.30000001192092896D;
/*  9 */     this.field_70181_x = ((float)Math.random() * 0.2F + 0.1F);
/* 10 */     this.field_70179_y *= 0.30000001192092896D;
/*    */     
/* 12 */     this.field_70552_h = 1.0F;
/* 13 */     this.field_70553_i = 1.0F;
/* 14 */     this.field_70551_j = 1.0F;
/* 15 */     func_70536_a(19);
/* 16 */     func_70105_a(0.01F, 0.01F);
/*    */     
/* 18 */     this.field_70547_e = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
/*    */     
/* 20 */     this.field_70545_g = 0.0F;
/* 21 */     this.field_70159_w = p_i45073_8_;
/* 22 */     this.field_70181_x = p_i45073_10_;
/* 23 */     this.field_70179_y = p_i45073_12_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00000933";
/*    */   
/*    */   public void func_70071_h_() {
/* 28 */     this.field_70169_q = this.field_70165_t;
/* 29 */     this.field_70167_r = this.field_70163_u;
/* 30 */     this.field_70166_s = this.field_70161_v;
/*    */     
/* 32 */     this.field_70181_x -= this.field_70545_g;
/* 33 */     func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/* 34 */     this.field_70159_w *= 0.9800000190734863D;
/* 35 */     this.field_70181_x *= 0.9800000190734863D;
/* 36 */     this.field_70179_y *= 0.9800000190734863D;
/*    */     
/* 38 */     int i = 60 - this.field_70547_e;
/* 39 */     float f = i * 0.001F;
/* 40 */     func_70105_a(f, f);
/* 41 */     func_70536_a(19 + i % 4);
/*    */     
/* 43 */     if (this.field_70547_e-- <= 0) func_70106_y(); 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\particle\EntityFishWakeFX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */