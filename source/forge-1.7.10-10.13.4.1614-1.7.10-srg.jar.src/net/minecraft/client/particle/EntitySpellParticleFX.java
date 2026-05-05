/*    */ package net.minecraft.client.particle;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class EntitySpellParticleFX extends EntityFX {
/*  8 */   private int field_70590_a = 128; private static final String __OBFID = "CL_00000926";
/*    */   
/*    */   public EntitySpellParticleFX(World p_i1229_1_, double p_i1229_2_, double p_i1229_4_, double p_i1229_6_, double p_i1229_8_, double p_i1229_10_, double p_i1229_12_) {
/* 11 */     super(p_i1229_1_, p_i1229_2_, p_i1229_4_, p_i1229_6_, p_i1229_8_, p_i1229_10_, p_i1229_12_);
/* 12 */     this.field_70181_x *= 0.20000000298023224D;
/* 13 */     if (p_i1229_8_ == 0.0D && p_i1229_12_ == 0.0D) {
/* 14 */       this.field_70159_w *= 0.10000000149011612D;
/* 15 */       this.field_70179_y *= 0.10000000149011612D;
/*    */     } 
/*    */     
/* 18 */     this.field_70544_f *= 0.75F;
/*    */     
/* 20 */     this.field_70547_e = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
/* 21 */     this.field_70145_X = false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {
/* 26 */     float f = (this.field_70546_d + p_70539_2_) / this.field_70547_e * 32.0F;
/* 27 */     if (f < 0.0F) f = 0.0F; 
/* 28 */     if (f > 1.0F) f = 1.0F;
/*    */     
/* 30 */     super.func_70539_a(p_70539_1_, p_70539_2_, p_70539_3_, p_70539_4_, p_70539_5_, p_70539_6_, p_70539_7_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70071_h_() {
/* 35 */     this.field_70169_q = this.field_70165_t;
/* 36 */     this.field_70167_r = this.field_70163_u;
/* 37 */     this.field_70166_s = this.field_70161_v;
/*    */     
/* 39 */     if (this.field_70546_d++ >= this.field_70547_e) func_70106_y();
/*    */     
/* 41 */     func_70536_a(this.field_70590_a + 7 - this.field_70546_d * 8 / this.field_70547_e);
/*    */     
/* 43 */     this.field_70181_x += 0.004D;
/* 44 */     func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/* 45 */     if (this.field_70163_u == this.field_70167_r) {
/* 46 */       this.field_70159_w *= 1.1D;
/* 47 */       this.field_70179_y *= 1.1D;
/*    */     } 
/* 49 */     this.field_70159_w *= 0.9599999785423279D;
/* 50 */     this.field_70181_x *= 0.9599999785423279D;
/* 51 */     this.field_70179_y *= 0.9599999785423279D;
/*    */     
/* 53 */     if (this.field_70122_E) {
/* 54 */       this.field_70159_w *= 0.699999988079071D;
/* 55 */       this.field_70179_y *= 0.699999988079071D;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void func_70589_b(int p_70589_1_) {
/* 60 */     this.field_70590_a = p_70589_1_;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\particle\EntitySpellParticleFX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */