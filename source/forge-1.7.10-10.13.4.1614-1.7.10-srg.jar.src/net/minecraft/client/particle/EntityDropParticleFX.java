/*    */ package net.minecraft.client.particle;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.block.BlockLiquid;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class EntityDropParticleFX extends EntityFX {
/*    */   private Material field_70563_a;
/*    */   
/*    */   public EntityDropParticleFX(World p_i1203_1_, double p_i1203_2_, double p_i1203_4_, double p_i1203_6_, Material p_i1203_8_) {
/* 14 */     super(p_i1203_1_, p_i1203_2_, p_i1203_4_, p_i1203_6_, 0.0D, 0.0D, 0.0D);
/* 15 */     this.field_70159_w = this.field_70181_x = this.field_70179_y = 0.0D;
/*    */     
/* 17 */     if (p_i1203_8_ == Material.field_151586_h) {
/* 18 */       this.field_70552_h = 0.0F;
/* 19 */       this.field_70553_i = 0.0F;
/* 20 */       this.field_70551_j = 1.0F;
/*    */     } else {
/* 22 */       this.field_70552_h = 1.0F;
/* 23 */       this.field_70553_i = 0.0F;
/* 24 */       this.field_70551_j = 0.0F;
/*    */     } 
/* 26 */     func_70536_a(113);
/* 27 */     func_70105_a(0.01F, 0.01F);
/* 28 */     this.field_70545_g = 0.06F;
/* 29 */     this.field_70563_a = p_i1203_8_;
/* 30 */     this.field_70564_aq = 40;
/*    */     
/* 32 */     this.field_70547_e = (int)(64.0D / (Math.random() * 0.8D + 0.2D));
/* 33 */     this.field_70159_w = this.field_70181_x = this.field_70179_y = 0.0D;
/*    */   }
/*    */   private int field_70564_aq; private static final String __OBFID = "CL_00000901";
/*    */   
/*    */   public int func_70070_b(float p_70070_1_) {
/* 38 */     if (this.field_70563_a == Material.field_151586_h) return super.func_70070_b(p_70070_1_); 
/* 39 */     return 257;
/*    */   }
/*    */ 
/*    */   
/*    */   public float func_70013_c(float p_70013_1_) {
/* 44 */     if (this.field_70563_a == Material.field_151586_h) return super.func_70013_c(p_70013_1_); 
/* 45 */     return 1.0F;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70071_h_() {
/* 50 */     this.field_70169_q = this.field_70165_t;
/* 51 */     this.field_70167_r = this.field_70163_u;
/* 52 */     this.field_70166_s = this.field_70161_v;
/*    */     
/* 54 */     if (this.field_70563_a == Material.field_151586_h) {
/* 55 */       this.field_70552_h = 0.2F;
/* 56 */       this.field_70553_i = 0.3F;
/* 57 */       this.field_70551_j = 1.0F;
/*    */     } else {
/* 59 */       this.field_70552_h = 1.0F;
/* 60 */       this.field_70553_i = 16.0F / (40 - this.field_70564_aq + 16);
/* 61 */       this.field_70551_j = 4.0F / (40 - this.field_70564_aq + 8);
/*    */     } 
/*    */     
/* 64 */     this.field_70181_x -= this.field_70545_g;
/* 65 */     if (this.field_70564_aq-- > 0) {
/* 66 */       this.field_70159_w *= 0.02D;
/* 67 */       this.field_70181_x *= 0.02D;
/* 68 */       this.field_70179_y *= 0.02D;
/* 69 */       func_70536_a(113);
/*    */     } else {
/* 71 */       func_70536_a(112);
/*    */     } 
/* 73 */     func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/* 74 */     this.field_70159_w *= 0.9800000190734863D;
/* 75 */     this.field_70181_x *= 0.9800000190734863D;
/* 76 */     this.field_70179_y *= 0.9800000190734863D;
/*    */     
/* 78 */     if (this.field_70547_e-- <= 0) func_70106_y();
/*    */     
/* 80 */     if (this.field_70122_E) {
/* 81 */       if (this.field_70563_a == Material.field_151586_h) {
/* 82 */         func_70106_y();
/* 83 */         this.field_70170_p.func_72869_a("splash", this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0D, 0.0D, 0.0D);
/*    */       } else {
/* 85 */         func_70536_a(114);
/*    */       } 
/*    */       
/* 88 */       this.field_70159_w *= 0.699999988079071D;
/* 89 */       this.field_70179_y *= 0.699999988079071D;
/*    */     } 
/*    */     
/* 92 */     Material material = this.field_70170_p.func_147439_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v)).func_149688_o();
/* 93 */     if (material.func_76224_d() || material.func_76220_a()) {
/* 94 */       double d = ((MathHelper.func_76128_c(this.field_70163_u) + 1) - BlockLiquid.func_149801_b(this.field_70170_p.func_72805_g(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v))));
/* 95 */       if (this.field_70163_u < d)
/* 96 */         func_70106_y(); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\particle\EntityDropParticleFX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */