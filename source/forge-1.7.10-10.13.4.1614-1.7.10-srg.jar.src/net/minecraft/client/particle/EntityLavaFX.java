/*    */ package net.minecraft.client.particle;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class EntityLavaFX extends EntityFX {
/*    */   private float field_70586_a;
/*    */   
/*    */   public EntityLavaFX(World p_i1215_1_, double p_i1215_2_, double p_i1215_4_, double p_i1215_6_) {
/* 10 */     super(p_i1215_1_, p_i1215_2_, p_i1215_4_, p_i1215_6_, 0.0D, 0.0D, 0.0D);
/* 11 */     this.field_70159_w *= 0.800000011920929D;
/* 12 */     this.field_70181_x *= 0.800000011920929D;
/* 13 */     this.field_70179_y *= 0.800000011920929D;
/* 14 */     this.field_70181_x = (this.field_70146_Z.nextFloat() * 0.4F + 0.05F);
/*    */     
/* 16 */     this.field_70552_h = this.field_70553_i = this.field_70551_j = 1.0F;
/* 17 */     this.field_70544_f *= this.field_70146_Z.nextFloat() * 2.0F + 0.2F;
/* 18 */     this.field_70586_a = this.field_70544_f;
/*    */     
/* 20 */     this.field_70547_e = (int)(16.0D / (Math.random() * 0.8D + 0.2D));
/* 21 */     this.field_70145_X = false;
/* 22 */     func_70536_a(49);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000912";
/*    */   
/*    */   public int func_70070_b(float p_70070_1_) {
/* 27 */     float f = (this.field_70546_d + p_70070_1_) / this.field_70547_e;
/* 28 */     if (f < 0.0F) f = 0.0F; 
/* 29 */     if (f > 1.0F) f = 1.0F; 
/* 30 */     int i = super.func_70070_b(p_70070_1_);
/*    */     
/* 32 */     char c = 'ð';
/* 33 */     int j = i >> 16 & 0xFF;
/* 34 */     return c | j << 16;
/*    */   }
/*    */ 
/*    */   
/*    */   public float func_70013_c(float p_70013_1_) {
/* 39 */     return 1.0F;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {
/* 44 */     float f = (this.field_70546_d + p_70539_2_) / this.field_70547_e;
/* 45 */     this.field_70544_f = this.field_70586_a * (1.0F - f * f);
/* 46 */     super.func_70539_a(p_70539_1_, p_70539_2_, p_70539_3_, p_70539_4_, p_70539_5_, p_70539_6_, p_70539_7_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70071_h_() {
/* 51 */     this.field_70169_q = this.field_70165_t;
/* 52 */     this.field_70167_r = this.field_70163_u;
/* 53 */     this.field_70166_s = this.field_70161_v;
/*    */     
/* 55 */     if (this.field_70546_d++ >= this.field_70547_e) func_70106_y(); 
/* 56 */     float f = this.field_70546_d / this.field_70547_e;
/* 57 */     if (this.field_70146_Z.nextFloat() > f) this.field_70170_p.func_72869_a("smoke", this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*    */     
/* 59 */     this.field_70181_x -= 0.03D;
/* 60 */     func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/* 61 */     this.field_70159_w *= 0.9990000128746033D;
/* 62 */     this.field_70181_x *= 0.9990000128746033D;
/* 63 */     this.field_70179_y *= 0.9990000128746033D;
/*    */     
/* 65 */     if (this.field_70122_E) {
/* 66 */       this.field_70159_w *= 0.699999988079071D;
/* 67 */       this.field_70179_y *= 0.699999988079071D;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\particle\EntityLavaFX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */