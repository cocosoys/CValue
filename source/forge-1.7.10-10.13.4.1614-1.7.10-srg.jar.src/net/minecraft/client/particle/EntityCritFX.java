/*    */ package net.minecraft.client.particle;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class EntityCritFX extends EntityFX {
/*    */   public EntityCritFX(World p_i1201_1_, double p_i1201_2_, double p_i1201_4_, double p_i1201_6_, double p_i1201_8_, double p_i1201_10_, double p_i1201_12_) {
/*  8 */     this(p_i1201_1_, p_i1201_2_, p_i1201_4_, p_i1201_6_, p_i1201_8_, p_i1201_10_, p_i1201_12_, 1.0F);
/*    */   }
/*    */   float field_70561_a;
/*    */   private static final String __OBFID = "CL_00000900";
/*    */   
/*    */   public EntityCritFX(World p_i1202_1_, double p_i1202_2_, double p_i1202_4_, double p_i1202_6_, double p_i1202_8_, double p_i1202_10_, double p_i1202_12_, float p_i1202_14_) {
/* 14 */     super(p_i1202_1_, p_i1202_2_, p_i1202_4_, p_i1202_6_, 0.0D, 0.0D, 0.0D);
/* 15 */     this.field_70159_w *= 0.10000000149011612D;
/* 16 */     this.field_70181_x *= 0.10000000149011612D;
/* 17 */     this.field_70179_y *= 0.10000000149011612D;
/* 18 */     this.field_70159_w += p_i1202_8_ * 0.4D;
/* 19 */     this.field_70181_x += p_i1202_10_ * 0.4D;
/* 20 */     this.field_70179_y += p_i1202_12_ * 0.4D;
/*    */     
/* 22 */     this.field_70552_h = this.field_70553_i = this.field_70551_j = (float)(Math.random() * 0.30000001192092896D + 0.6000000238418579D);
/* 23 */     this.field_70544_f *= 0.75F;
/* 24 */     this.field_70544_f *= p_i1202_14_;
/* 25 */     this.field_70561_a = this.field_70544_f;
/*    */     
/* 27 */     this.field_70547_e = (int)(6.0D / (Math.random() * 0.8D + 0.6D));
/* 28 */     this.field_70547_e = (int)(this.field_70547_e * p_i1202_14_);
/* 29 */     this.field_70145_X = false;
/*    */     
/* 31 */     func_70536_a(65);
/* 32 */     func_70071_h_();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {
/* 37 */     float f = (this.field_70546_d + p_70539_2_) / this.field_70547_e * 32.0F;
/* 38 */     if (f < 0.0F) f = 0.0F; 
/* 39 */     if (f > 1.0F) f = 1.0F;
/*    */     
/* 41 */     this.field_70544_f = this.field_70561_a * f;
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
/* 53 */     func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/* 54 */     this.field_70553_i = (float)(this.field_70553_i * 0.96D);
/* 55 */     this.field_70551_j = (float)(this.field_70551_j * 0.9D);
/*    */     
/* 57 */     this.field_70159_w *= 0.699999988079071D;
/* 58 */     this.field_70181_x *= 0.699999988079071D;
/* 59 */     this.field_70179_y *= 0.699999988079071D;
/* 60 */     this.field_70181_x -= 0.019999999552965164D;
/*    */     
/* 62 */     if (this.field_70122_E) {
/* 63 */       this.field_70159_w *= 0.699999988079071D;
/* 64 */       this.field_70179_y *= 0.699999988079071D;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\particle\EntityCritFX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */