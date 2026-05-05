/*    */ package net.minecraft.client.particle;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class EntitySuspendFX extends EntityFX {
/*    */   public EntitySuspendFX(World p_i1231_1_, double p_i1231_2_, double p_i1231_4_, double p_i1231_6_, double p_i1231_8_, double p_i1231_10_, double p_i1231_12_) {
/*  9 */     super(p_i1231_1_, p_i1231_2_, p_i1231_4_ - 0.125D, p_i1231_6_, p_i1231_8_, p_i1231_10_, p_i1231_12_);
/*    */     
/* 11 */     this.field_70552_h = 0.4F;
/* 12 */     this.field_70553_i = 0.4F;
/* 13 */     this.field_70551_j = 0.7F;
/* 14 */     func_70536_a(0);
/* 15 */     func_70105_a(0.01F, 0.01F);
/*    */     
/* 17 */     this.field_70544_f *= this.field_70146_Z.nextFloat() * 0.6F + 0.2F;
/*    */     
/* 19 */     this.field_70159_w = p_i1231_8_ * 0.0D;
/* 20 */     this.field_70181_x = p_i1231_10_ * 0.0D;
/* 21 */     this.field_70179_y = p_i1231_12_ * 0.0D;
/*    */     
/* 23 */     this.field_70547_e = (int)(16.0D / (Math.random() * 0.8D + 0.2D));
/*    */   }
/*    */   private static final String __OBFID = "CL_00000928";
/*    */   
/*    */   public void func_70071_h_() {
/* 28 */     this.field_70169_q = this.field_70165_t;
/* 29 */     this.field_70167_r = this.field_70163_u;
/* 30 */     this.field_70166_s = this.field_70161_v;
/*    */     
/* 32 */     func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*    */     
/* 34 */     if (this.field_70170_p.func_147439_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v)).func_149688_o() != Material.field_151586_h) func_70106_y();
/*    */     
/* 36 */     if (this.field_70547_e-- <= 0) func_70106_y(); 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\particle\EntitySuspendFX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */