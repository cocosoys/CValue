/*    */ package net.minecraft.client.particle;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class EntityReddustFX extends EntityFX {
/*    */   float field_70570_a;
/*    */   
/*    */   public EntityReddustFX(World p_i1223_1_, double p_i1223_2_, double p_i1223_4_, double p_i1223_6_, float p_i1223_8_, float p_i1223_9_, float p_i1223_10_) {
/* 10 */     this(p_i1223_1_, p_i1223_2_, p_i1223_4_, p_i1223_6_, 1.0F, p_i1223_8_, p_i1223_9_, p_i1223_10_);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000923";
/*    */   public EntityReddustFX(World p_i1224_1_, double p_i1224_2_, double p_i1224_4_, double p_i1224_6_, float p_i1224_8_, float p_i1224_9_, float p_i1224_10_, float p_i1224_11_) {
/* 14 */     super(p_i1224_1_, p_i1224_2_, p_i1224_4_, p_i1224_6_, 0.0D, 0.0D, 0.0D);
/* 15 */     this.field_70159_w *= 0.10000000149011612D;
/* 16 */     this.field_70181_x *= 0.10000000149011612D;
/* 17 */     this.field_70179_y *= 0.10000000149011612D;
/*    */     
/* 19 */     if (p_i1224_9_ == 0.0F) {
/* 20 */       p_i1224_9_ = 1.0F;
/*    */     }
/* 22 */     float f = (float)Math.random() * 0.4F + 0.6F;
/* 23 */     this.field_70552_h = ((float)(Math.random() * 0.20000000298023224D) + 0.8F) * p_i1224_9_ * f;
/* 24 */     this.field_70553_i = ((float)(Math.random() * 0.20000000298023224D) + 0.8F) * p_i1224_10_ * f;
/* 25 */     this.field_70551_j = ((float)(Math.random() * 0.20000000298023224D) + 0.8F) * p_i1224_11_ * f;
/* 26 */     this.field_70544_f *= 0.75F;
/* 27 */     this.field_70544_f *= p_i1224_8_;
/* 28 */     this.field_70570_a = this.field_70544_f;
/*    */     
/* 30 */     this.field_70547_e = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
/* 31 */     this.field_70547_e = (int)(this.field_70547_e * p_i1224_8_);
/* 32 */     this.field_70145_X = false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {
/* 37 */     float f = (this.field_70546_d + p_70539_2_) / this.field_70547_e * 32.0F;
/* 38 */     if (f < 0.0F) f = 0.0F; 
/* 39 */     if (f > 1.0F) f = 1.0F;
/*    */     
/* 41 */     this.field_70544_f = this.field_70570_a * f;
/* 42 */     super.func_70539_a(p_70539_1_, p_70539_2_, p_70539_3_, p_70539_4_, p_70539_5_, p_70539_6_, p_70539_7_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70071_h_() {
/* 47 */     this.field_70169_q = this.field_70165_t;
/* 48 */     this.field_70167_r = this.field_70163_u;
/* 49 */     this.field_70166_s = this.field_70161_v;
/*    */     
/* 51 */     if (this.field_70546_d++ >= this.field_70547_e) func_70106_y();
/*    */     
/* 53 */     func_70536_a(7 - this.field_70546_d * 8 / this.field_70547_e);
/*    */     
/* 55 */     func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/* 56 */     if (this.field_70163_u == this.field_70167_r) {
/* 57 */       this.field_70159_w *= 1.1D;
/* 58 */       this.field_70179_y *= 1.1D;
/*    */     } 
/* 60 */     this.field_70159_w *= 0.9599999785423279D;
/* 61 */     this.field_70181_x *= 0.9599999785423279D;
/* 62 */     this.field_70179_y *= 0.9599999785423279D;
/*    */     
/* 64 */     if (this.field_70122_E) {
/* 65 */       this.field_70159_w *= 0.699999988079071D;
/* 66 */       this.field_70179_y *= 0.699999988079071D;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\particle\EntityReddustFX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */