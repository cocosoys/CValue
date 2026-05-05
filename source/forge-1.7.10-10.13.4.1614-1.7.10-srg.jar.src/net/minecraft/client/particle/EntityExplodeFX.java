/*    */ package net.minecraft.client.particle;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class EntityExplodeFX extends EntityFX {
/*    */   public EntityExplodeFX(World p_i1205_1_, double p_i1205_2_, double p_i1205_4_, double p_i1205_6_, double p_i1205_8_, double p_i1205_10_, double p_i1205_12_) {
/*  7 */     super(p_i1205_1_, p_i1205_2_, p_i1205_4_, p_i1205_6_, p_i1205_8_, p_i1205_10_, p_i1205_12_);
/*  8 */     this.field_70159_w = p_i1205_8_ + ((float)(Math.random() * 2.0D - 1.0D) * 0.05F);
/*  9 */     this.field_70181_x = p_i1205_10_ + ((float)(Math.random() * 2.0D - 1.0D) * 0.05F);
/* 10 */     this.field_70179_y = p_i1205_12_ + ((float)(Math.random() * 2.0D - 1.0D) * 0.05F);
/*    */     
/* 12 */     this.field_70552_h = this.field_70553_i = this.field_70551_j = this.field_70146_Z.nextFloat() * 0.3F + 0.7F;
/* 13 */     this.field_70544_f = this.field_70146_Z.nextFloat() * this.field_70146_Z.nextFloat() * 6.0F + 1.0F;
/*    */     
/* 15 */     this.field_70547_e = (int)(16.0D / (this.field_70146_Z.nextFloat() * 0.8D + 0.2D)) + 2;
/*    */   }
/*    */   private static final String __OBFID = "CL_00000903";
/*    */   
/*    */   public void func_70071_h_() {
/* 20 */     this.field_70169_q = this.field_70165_t;
/* 21 */     this.field_70167_r = this.field_70163_u;
/* 22 */     this.field_70166_s = this.field_70161_v;
/*    */     
/* 24 */     if (this.field_70546_d++ >= this.field_70547_e) func_70106_y();
/*    */     
/* 26 */     func_70536_a(7 - this.field_70546_d * 8 / this.field_70547_e);
/*    */     
/* 28 */     this.field_70181_x += 0.004D;
/* 29 */     func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/* 30 */     this.field_70159_w *= 0.8999999761581421D;
/* 31 */     this.field_70181_x *= 0.8999999761581421D;
/* 32 */     this.field_70179_y *= 0.8999999761581421D;
/*    */     
/* 34 */     if (this.field_70122_E) {
/* 35 */       this.field_70159_w *= 0.699999988079071D;
/* 36 */       this.field_70179_y *= 0.699999988079071D;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\particle\EntityExplodeFX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */