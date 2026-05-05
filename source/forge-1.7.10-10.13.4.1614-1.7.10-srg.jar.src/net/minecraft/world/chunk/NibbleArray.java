/*    */ package net.minecraft.world.chunk;
/*    */ 
/*    */ public class NibbleArray
/*    */ {
/*    */   public final byte[] field_76585_a;
/*    */   private final int field_76583_b;
/*    */   
/*    */   public NibbleArray(int p_i1992_1_, int p_i1992_2_) {
/*  9 */     this.field_76585_a = new byte[p_i1992_1_ >> 1];
/* 10 */     this.field_76583_b = p_i1992_2_;
/* 11 */     this.field_76584_c = p_i1992_2_ + 4;
/*    */   }
/*    */   private final int field_76584_c; private static final String __OBFID = "CL_00000371";
/*    */   public NibbleArray(byte[] p_i1993_1_, int p_i1993_2_) {
/* 15 */     this.field_76585_a = p_i1993_1_;
/* 16 */     this.field_76583_b = p_i1993_2_;
/* 17 */     this.field_76584_c = p_i1993_2_ + 4;
/*    */   }
/*    */   
/*    */   public int func_76582_a(int p_76582_1_, int p_76582_2_, int p_76582_3_) {
/* 21 */     int i = p_76582_2_ << this.field_76584_c | p_76582_3_ << this.field_76583_b | p_76582_1_;
/* 22 */     int j = i >> 1;
/* 23 */     int k = i & 0x1;
/*    */     
/* 25 */     if (k == 0) {
/* 26 */       return this.field_76585_a[j] & 0xF;
/*    */     }
/* 28 */     return this.field_76585_a[j] >> 4 & 0xF;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_76581_a(int p_76581_1_, int p_76581_2_, int p_76581_3_, int p_76581_4_) {
/* 33 */     int i = p_76581_2_ << this.field_76584_c | p_76581_3_ << this.field_76583_b | p_76581_1_;
/*    */     
/* 35 */     int j = i >> 1;
/* 36 */     int k = i & 0x1;
/*    */     
/* 38 */     if (k == 0) {
/* 39 */       this.field_76585_a[j] = (byte)(this.field_76585_a[j] & 0xF0 | p_76581_4_ & 0xF);
/*    */     } else {
/* 41 */       this.field_76585_a[j] = (byte)(this.field_76585_a[j] & 0xF | (p_76581_4_ & 0xF) << 4);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\chunk\NibbleArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */