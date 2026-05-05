/*    */ package net.minecraft.world.gen;
/*    */ 
/*    */ import net.minecraft.block.Block;
/*    */ 
/*    */ public class FlatLayerInfo {
/*    */   private Block field_151537_a;
/*  7 */   private int field_82664_a = 1;
/*    */   
/*    */   private int field_82663_c;
/*    */   
/*    */   public FlatLayerInfo(int p_i45467_1_, Block p_i45467_2_) {
/* 12 */     this.field_82664_a = p_i45467_1_;
/* 13 */     this.field_151537_a = p_i45467_2_;
/*    */   }
/*    */   private int field_82661_d; private static final String __OBFID = "CL_00000441";
/*    */   public FlatLayerInfo(int p_i45468_1_, Block p_i45468_2_, int p_i45468_3_) {
/* 17 */     this(p_i45468_1_, p_i45468_2_);
/* 18 */     this.field_82663_c = p_i45468_3_;
/*    */   }
/*    */   
/*    */   public int func_82657_a() {
/* 22 */     return this.field_82664_a;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Block func_151536_b() {
/* 30 */     return this.field_151537_a;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_82658_c() {
/* 38 */     return this.field_82663_c;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_82656_d() {
/* 46 */     return this.field_82661_d;
/*    */   }
/*    */   
/*    */   public void func_82660_d(int p_82660_1_) {
/* 50 */     this.field_82661_d = p_82660_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 55 */     String str = Integer.toString(Block.func_149682_b(this.field_151537_a));
/*    */     
/* 57 */     if (this.field_82664_a > 1) {
/* 58 */       str = this.field_82664_a + "x" + str;
/*    */     }
/* 60 */     if (this.field_82663_c > 0) {
/* 61 */       str = str + ":" + this.field_82663_c;
/*    */     }
/*    */     
/* 64 */     return str;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\FlatLayerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */