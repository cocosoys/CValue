/*    */ package net.minecraft.client.particle;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class EntitySmokeFX extends EntityFX {
/*    */   public EntitySmokeFX(World p_i1225_1_, double p_i1225_2_, double p_i1225_4_, double p_i1225_6_, double p_i1225_8_, double p_i1225_10_, double p_i1225_12_) {
/*  8 */     this(p_i1225_1_, p_i1225_2_, p_i1225_4_, p_i1225_6_, p_i1225_8_, p_i1225_10_, p_i1225_12_, 1.0F);
/*    */   }
/*    */   float field_70587_a;
/*    */   private static final String __OBFID = "CL_00000924";
/*    */   
/*    */   public EntitySmokeFX(World p_i1226_1_, double p_i1226_2_, double p_i1226_4_, double p_i1226_6_, double p_i1226_8_, double p_i1226_10_, double p_i1226_12_, float p_i1226_14_) {
/* 14 */     super(p_i1226_1_, p_i1226_2_, p_i1226_4_, p_i1226_6_, 0.0D, 0.0D, 0.0D);
/* 15 */     this.field_70159_w *= 0.10000000149011612D;
/* 16 */     this.field_70181_x *= 0.10000000149011612D;
/* 17 */     this.field_70179_y *= 0.10000000149011612D;
/* 18 */     this.field_70159_w += p_i1226_8_;
/* 19 */     this.field_70181_x += p_i1226_10_;
/* 20 */     this.field_70179_y += p_i1226_12_;
/*    */     
/* 22 */     this.field_70552_h = this.field_70553_i = this.field_70551_j = (float)(Math.random() * 0.30000001192092896D);
/* 23 */     this.field_70544_f *= 0.75F;
/* 24 */     this.field_70544_f *= p_i1226_14_;
/* 25 */     this.field_70587_a = this.field_70544_f;
/*    */     
/* 27 */     this.field_70547_e = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
/* 28 */     this.field_70547_e = (int)(this.field_70547_e * p_i1226_14_);
/* 29 */     this.field_70145_X = false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {
/* 34 */     float f = (this.field_70546_d + p_70539_2_) / this.field_70547_e * 32.0F;
/* 35 */     if (f < 0.0F) f = 0.0F; 
/* 36 */     if (f > 1.0F) f = 1.0F;
/*    */     
/* 38 */     this.field_70544_f = this.field_70587_a * f;
/* 39 */     super.func_70539_a(p_70539_1_, p_70539_2_, p_70539_3_, p_70539_4_, p_70539_5_, p_70539_6_, p_70539_7_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70071_h_() {
/* 44 */     this.field_70169_q = this.field_70165_t;
/* 45 */     this.field_70167_r = this.field_70163_u;
/* 46 */     this.field_70166_s = this.field_70161_v;
/*    */     
/* 48 */     if (this.field_70546_d++ >= this.field_70547_e) func_70106_y();
/*    */     
/* 50 */     func_70536_a(7 - this.field_70546_d * 8 / this.field_70547_e);
/*    */     
/* 52 */     this.field_70181_x += 0.004D;
/* 53 */     func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/* 54 */     if (this.field_70163_u == this.field_70167_r) {
/* 55 */       this.field_70159_w *= 1.1D;
/* 56 */       this.field_70179_y *= 1.1D;
/*    */     } 
/* 58 */     this.field_70159_w *= 0.9599999785423279D;
/* 59 */     this.field_70181_x *= 0.9599999785423279D;
/* 60 */     this.field_70179_y *= 0.9599999785423279D;
/*    */     
/* 62 */     if (this.field_70122_E) {
/* 63 */       this.field_70159_w *= 0.699999988079071D;
/* 64 */       this.field_70179_y *= 0.699999988079071D;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\particle\EntitySmokeFX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */