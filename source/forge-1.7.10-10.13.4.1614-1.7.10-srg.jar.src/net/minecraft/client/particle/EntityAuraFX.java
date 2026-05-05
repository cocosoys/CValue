/*    */ package net.minecraft.client.particle;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class EntityAuraFX extends EntityFX {
/*    */   public EntityAuraFX(World p_i1232_1_, double p_i1232_2_, double p_i1232_4_, double p_i1232_6_, double p_i1232_8_, double p_i1232_10_, double p_i1232_12_) {
/*  7 */     super(p_i1232_1_, p_i1232_2_, p_i1232_4_, p_i1232_6_, p_i1232_8_, p_i1232_10_, p_i1232_12_);
/*    */     
/*  9 */     float f = this.field_70146_Z.nextFloat() * 0.1F + 0.2F;
/* 10 */     this.field_70552_h = f;
/* 11 */     this.field_70553_i = f;
/* 12 */     this.field_70551_j = f;
/* 13 */     func_70536_a(0);
/* 14 */     func_70105_a(0.02F, 0.02F);
/*    */     
/* 16 */     this.field_70544_f *= this.field_70146_Z.nextFloat() * 0.6F + 0.5F;
/*    */     
/* 18 */     this.field_70159_w *= 0.019999999552965164D;
/* 19 */     this.field_70181_x *= 0.019999999552965164D;
/* 20 */     this.field_70179_y *= 0.019999999552965164D;
/*    */     
/* 22 */     this.field_70547_e = (int)(20.0D / (Math.random() * 0.8D + 0.2D));
/* 23 */     this.field_70145_X = true;
/*    */   }
/*    */   private static final String __OBFID = "CL_00000929";
/*    */   
/*    */   public void func_70071_h_() {
/* 28 */     this.field_70169_q = this.field_70165_t;
/* 29 */     this.field_70167_r = this.field_70163_u;
/* 30 */     this.field_70166_s = this.field_70161_v;
/*    */     
/* 32 */     func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/* 33 */     this.field_70159_w *= 0.99D;
/* 34 */     this.field_70181_x *= 0.99D;
/* 35 */     this.field_70179_y *= 0.99D;
/*    */     
/* 37 */     if (this.field_70547_e-- <= 0) func_70106_y(); 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\particle\EntityAuraFX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */