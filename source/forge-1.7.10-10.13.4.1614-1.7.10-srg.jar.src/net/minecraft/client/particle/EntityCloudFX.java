/*    */ package net.minecraft.client.particle;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class EntityCloudFX extends EntityFX {
/*    */   float field_70569_a;
/*    */   
/*    */   public EntityCloudFX(World p_i1221_1_, double p_i1221_2_, double p_i1221_4_, double p_i1221_6_, double p_i1221_8_, double p_i1221_10_, double p_i1221_12_) {
/* 11 */     super(p_i1221_1_, p_i1221_2_, p_i1221_4_, p_i1221_6_, 0.0D, 0.0D, 0.0D);
/*    */     
/* 13 */     float f = 2.5F;
/* 14 */     this.field_70159_w *= 0.10000000149011612D;
/* 15 */     this.field_70181_x *= 0.10000000149011612D;
/* 16 */     this.field_70179_y *= 0.10000000149011612D;
/* 17 */     this.field_70159_w += p_i1221_8_;
/* 18 */     this.field_70181_x += p_i1221_10_;
/* 19 */     this.field_70179_y += p_i1221_12_;
/*    */     
/* 21 */     this.field_70552_h = this.field_70553_i = this.field_70551_j = 1.0F - (float)(Math.random() * 0.30000001192092896D);
/* 22 */     this.field_70544_f *= 0.75F;
/* 23 */     this.field_70544_f *= f;
/* 24 */     this.field_70569_a = this.field_70544_f;
/*    */     
/* 26 */     this.field_70547_e = (int)(8.0D / (Math.random() * 0.8D + 0.3D));
/* 27 */     this.field_70547_e = (int)(this.field_70547_e * f);
/* 28 */     this.field_70145_X = false;
/*    */   }
/*    */   private static final String __OBFID = "CL_00000920";
/*    */   
/*    */   public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {
/* 33 */     float f = (this.field_70546_d + p_70539_2_) / this.field_70547_e * 32.0F;
/* 34 */     if (f < 0.0F) f = 0.0F; 
/* 35 */     if (f > 1.0F) f = 1.0F;
/*    */     
/* 37 */     this.field_70544_f = this.field_70569_a * f;
/* 38 */     super.func_70539_a(p_70539_1_, p_70539_2_, p_70539_3_, p_70539_4_, p_70539_5_, p_70539_6_, p_70539_7_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70071_h_() {
/* 43 */     this.field_70169_q = this.field_70165_t;
/* 44 */     this.field_70167_r = this.field_70163_u;
/* 45 */     this.field_70166_s = this.field_70161_v;
/*    */     
/* 47 */     if (this.field_70546_d++ >= this.field_70547_e) func_70106_y();
/*    */     
/* 49 */     func_70536_a(7 - this.field_70546_d * 8 / this.field_70547_e);
/*    */     
/* 51 */     func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/* 52 */     this.field_70159_w *= 0.9599999785423279D;
/* 53 */     this.field_70181_x *= 0.9599999785423279D;
/* 54 */     this.field_70179_y *= 0.9599999785423279D;
/* 55 */     EntityPlayer entityPlayer = this.field_70170_p.func_72890_a(this, 2.0D);
/* 56 */     if (entityPlayer != null && 
/* 57 */       this.field_70163_u > entityPlayer.field_70121_D.field_72338_b) {
/* 58 */       this.field_70163_u += (entityPlayer.field_70121_D.field_72338_b - this.field_70163_u) * 0.2D;
/* 59 */       this.field_70181_x += (entityPlayer.field_70181_x - this.field_70181_x) * 0.2D;
/* 60 */       func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*    */     } 
/*    */ 
/*    */     
/* 64 */     if (this.field_70122_E) {
/* 65 */       this.field_70159_w *= 0.699999988079071D;
/* 66 */       this.field_70179_y *= 0.699999988079071D;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\particle\EntityCloudFX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */