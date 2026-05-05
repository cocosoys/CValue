/*    */ package net.minecraft.client.particle;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class EntityBubbleFX extends EntityFX {
/*    */   public EntityBubbleFX(World p_i1198_1_, double p_i1198_2_, double p_i1198_4_, double p_i1198_6_, double p_i1198_8_, double p_i1198_10_, double p_i1198_12_) {
/*  9 */     super(p_i1198_1_, p_i1198_2_, p_i1198_4_, p_i1198_6_, p_i1198_8_, p_i1198_10_, p_i1198_12_);
/*    */     
/* 11 */     this.field_70552_h = 1.0F;
/* 12 */     this.field_70553_i = 1.0F;
/* 13 */     this.field_70551_j = 1.0F;
/* 14 */     func_70536_a(32);
/* 15 */     func_70105_a(0.02F, 0.02F);
/*    */     
/* 17 */     this.field_70544_f *= this.field_70146_Z.nextFloat() * 0.6F + 0.2F;
/*    */     
/* 19 */     this.field_70159_w = p_i1198_8_ * 0.20000000298023224D + ((float)(Math.random() * 2.0D - 1.0D) * 0.02F);
/* 20 */     this.field_70181_x = p_i1198_10_ * 0.20000000298023224D + ((float)(Math.random() * 2.0D - 1.0D) * 0.02F);
/* 21 */     this.field_70179_y = p_i1198_12_ * 0.20000000298023224D + ((float)(Math.random() * 2.0D - 1.0D) * 0.02F);
/*    */     
/* 23 */     this.field_70547_e = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
/*    */   }
/*    */   private static final String __OBFID = "CL_00000898";
/*    */   
/*    */   public void func_70071_h_() {
/* 28 */     this.field_70169_q = this.field_70165_t;
/* 29 */     this.field_70167_r = this.field_70163_u;
/* 30 */     this.field_70166_s = this.field_70161_v;
/*    */     
/* 32 */     this.field_70181_x += 0.002D;
/* 33 */     func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/* 34 */     this.field_70159_w *= 0.8500000238418579D;
/* 35 */     this.field_70181_x *= 0.8500000238418579D;
/* 36 */     this.field_70179_y *= 0.8500000238418579D;
/*    */     
/* 38 */     if (this.field_70170_p.func_147439_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v)).func_149688_o() != Material.field_151586_h) func_70106_y();
/*    */     
/* 40 */     if (this.field_70547_e-- <= 0) func_70106_y(); 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\particle\EntityBubbleFX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */