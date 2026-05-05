/*    */ package net.minecraft.util;public class MovingObjectPosition { public MovingObjectType field_72313_a; public int field_72311_b; public int field_72312_c;
/*    */   public int field_72309_d;
/*    */   public int field_72310_e;
/*    */   public Vec3 field_72307_f;
/*    */   public Entity field_72308_g;
/*    */   private static final String __OBFID = "CL_00000610";
/*    */   
/*  8 */   public enum MovingObjectType { MISS,
/*  9 */     BLOCK,
/* 10 */     ENTITY;
/*    */ 
/*    */     
/*    */     private static final String __OBFID = "CL_00000611"; }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public MovingObjectPosition(int p_i2303_1_, int p_i2303_2_, int p_i2303_3_, int p_i2303_4_, Vec3 p_i2303_5_) {
/* 19 */     this(p_i2303_1_, p_i2303_2_, p_i2303_3_, p_i2303_4_, p_i2303_5_, true);
/*    */   }
/*    */   
/*    */   public MovingObjectPosition(int p_i45481_1_, int p_i45481_2_, int p_i45481_3_, int p_i45481_4_, Vec3 p_i45481_5_, boolean p_i45481_6_) {
/* 23 */     this.field_72313_a = p_i45481_6_ ? MovingObjectType.BLOCK : MovingObjectType.MISS;
/* 24 */     this.field_72311_b = p_i45481_1_;
/* 25 */     this.field_72312_c = p_i45481_2_;
/* 26 */     this.field_72309_d = p_i45481_3_;
/* 27 */     this.field_72310_e = p_i45481_4_;
/* 28 */     this.field_72307_f = Vec3.func_72443_a(p_i45481_5_.field_72450_a, p_i45481_5_.field_72448_b, p_i45481_5_.field_72449_c);
/*    */   }
/*    */   
/*    */   public MovingObjectPosition(Entity p_i2304_1_) {
/* 32 */     this(p_i2304_1_, Vec3.func_72443_a(p_i2304_1_.field_70165_t, p_i2304_1_.field_70163_u, p_i2304_1_.field_70161_v));
/*    */   }
/*    */   
/*    */   public MovingObjectPosition(Entity p_i45482_1_, Vec3 p_i45482_2_) {
/* 36 */     this.field_72313_a = MovingObjectType.ENTITY;
/* 37 */     this.field_72308_g = p_i45482_1_;
/* 38 */     this.field_72307_f = p_i45482_2_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 50 */     return "HitResult{type=" + this.field_72313_a + ", x=" + this.field_72311_b + ", y=" + this.field_72312_c + ", z=" + this.field_72309_d + ", f=" + this.field_72310_e + ", pos=" + this.field_72307_f + ", entity=" + this.field_72308_g + '}';
/*    */   } }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\MovingObjectPosition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */