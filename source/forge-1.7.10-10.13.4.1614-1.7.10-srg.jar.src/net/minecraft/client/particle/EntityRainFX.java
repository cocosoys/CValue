/*    */ package net.minecraft.client.particle;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.block.BlockLiquid;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class EntityRainFX extends EntityFX {
/*    */   public EntityRainFX(World p_i1235_1_, double p_i1235_2_, double p_i1235_4_, double p_i1235_6_) {
/* 11 */     super(p_i1235_1_, p_i1235_2_, p_i1235_4_, p_i1235_6_, 0.0D, 0.0D, 0.0D);
/* 12 */     this.field_70159_w *= 0.30000001192092896D;
/* 13 */     this.field_70181_x = ((float)Math.random() * 0.2F + 0.1F);
/* 14 */     this.field_70179_y *= 0.30000001192092896D;
/*    */     
/* 16 */     this.field_70552_h = 1.0F;
/* 17 */     this.field_70553_i = 1.0F;
/* 18 */     this.field_70551_j = 1.0F;
/* 19 */     func_70536_a(19 + this.field_70146_Z.nextInt(4));
/* 20 */     func_70105_a(0.01F, 0.01F);
/* 21 */     this.field_70545_g = 0.06F;
/*    */     
/* 23 */     this.field_70547_e = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
/*    */   }
/*    */   private static final String __OBFID = "CL_00000934";
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
/* 38 */     if (this.field_70547_e-- <= 0) func_70106_y();
/*    */     
/* 40 */     if (this.field_70122_E) {
/* 41 */       if (Math.random() < 0.5D) func_70106_y(); 
/* 42 */       this.field_70159_w *= 0.699999988079071D;
/* 43 */       this.field_70179_y *= 0.699999988079071D;
/*    */     } 
/*    */     
/* 46 */     Material material = this.field_70170_p.func_147439_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v)).func_149688_o();
/* 47 */     if (material.func_76224_d() || material.func_76220_a()) {
/* 48 */       double d = ((MathHelper.func_76128_c(this.field_70163_u) + 1) - BlockLiquid.func_149801_b(this.field_70170_p.func_72805_g(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v))));
/* 49 */       if (this.field_70163_u < d)
/* 50 */         func_70106_y(); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\particle\EntityRainFX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */