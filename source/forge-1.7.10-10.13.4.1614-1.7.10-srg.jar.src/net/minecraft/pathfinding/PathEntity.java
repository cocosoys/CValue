/*    */ package net.minecraft.pathfinding;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.Vec3;
/*    */ 
/*    */ public class PathEntity
/*    */ {
/*    */   private final PathPoint[] field_75884_a;
/*    */   private int field_75882_b;
/*    */   
/*    */   public PathEntity(PathPoint[] p_i2136_1_) {
/* 12 */     this.field_75884_a = p_i2136_1_;
/* 13 */     this.field_75883_c = p_i2136_1_.length;
/*    */   }
/*    */   private int field_75883_c; private static final String __OBFID = "CL_00000575";
/*    */   public void func_75875_a() {
/* 17 */     this.field_75882_b++;
/*    */   }
/*    */   
/*    */   public boolean func_75879_b() {
/* 21 */     return (this.field_75882_b >= this.field_75883_c);
/*    */   }
/*    */   
/*    */   public PathPoint func_75870_c() {
/* 25 */     if (this.field_75883_c > 0) {
/* 26 */       return this.field_75884_a[this.field_75883_c - 1];
/*    */     }
/* 28 */     return null;
/*    */   }
/*    */   
/*    */   public PathPoint func_75877_a(int p_75877_1_) {
/* 32 */     return this.field_75884_a[p_75877_1_];
/*    */   }
/*    */   
/*    */   public int func_75874_d() {
/* 36 */     return this.field_75883_c;
/*    */   }
/*    */   
/*    */   public void func_75871_b(int p_75871_1_) {
/* 40 */     this.field_75883_c = p_75871_1_;
/*    */   }
/*    */   
/*    */   public int func_75873_e() {
/* 44 */     return this.field_75882_b;
/*    */   }
/*    */   
/*    */   public void func_75872_c(int p_75872_1_) {
/* 48 */     this.field_75882_b = p_75872_1_;
/*    */   }
/*    */   
/*    */   public Vec3 func_75881_a(Entity p_75881_1_, int p_75881_2_) {
/* 52 */     double d1 = (this.field_75884_a[p_75881_2_]).field_75839_a + (int)(p_75881_1_.field_70130_N + 1.0F) * 0.5D;
/* 53 */     double d2 = (this.field_75884_a[p_75881_2_]).field_75837_b;
/* 54 */     double d3 = (this.field_75884_a[p_75881_2_]).field_75838_c + (int)(p_75881_1_.field_70130_N + 1.0F) * 0.5D;
/* 55 */     return Vec3.func_72443_a(d1, d2, d3);
/*    */   }
/*    */   
/*    */   public Vec3 func_75878_a(Entity p_75878_1_) {
/* 59 */     return func_75881_a(p_75878_1_, this.field_75882_b);
/*    */   }
/*    */   
/*    */   public boolean func_75876_a(PathEntity p_75876_1_) {
/* 63 */     if (p_75876_1_ == null) return false; 
/* 64 */     if (p_75876_1_.field_75884_a.length != this.field_75884_a.length) return false; 
/* 65 */     for (byte b = 0; b < this.field_75884_a.length; b++) {
/* 66 */       if ((this.field_75884_a[b]).field_75839_a != (p_75876_1_.field_75884_a[b]).field_75839_a || (this.field_75884_a[b]).field_75837_b != (p_75876_1_.field_75884_a[b]).field_75837_b || (this.field_75884_a[b]).field_75838_c != (p_75876_1_.field_75884_a[b]).field_75838_c)
/* 67 */         return false; 
/* 68 */     }  return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_75880_b(Vec3 p_75880_1_) {
/* 78 */     PathPoint pathPoint = func_75870_c();
/* 79 */     if (pathPoint == null) return false; 
/* 80 */     return (pathPoint.field_75839_a == (int)p_75880_1_.field_72450_a && pathPoint.field_75838_c == (int)p_75880_1_.field_72449_c);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\pathfinding\PathEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */