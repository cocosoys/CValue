/*    */ package net.minecraft.world.chunk.storage;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NibbleArrayReader
/*    */ {
/*    */   public final byte[] field_76689_a;
/*    */   private final int field_76687_b;
/*    */   private final int field_76688_c;
/*    */   private static final String __OBFID = "CL_00000376";
/*    */   
/*    */   public NibbleArrayReader(byte[] p_i1998_1_, int p_i1998_2_) {
/* 15 */     this.field_76689_a = p_i1998_1_;
/* 16 */     this.field_76687_b = p_i1998_2_;
/* 17 */     this.field_76688_c = p_i1998_2_ + 4;
/*    */   }
/*    */   
/*    */   public int func_76686_a(int p_76686_1_, int p_76686_2_, int p_76686_3_) {
/* 21 */     int i = p_76686_1_ << this.field_76688_c | p_76686_3_ << this.field_76687_b | p_76686_2_;
/* 22 */     int j = i >> 1;
/* 23 */     int k = i & 0x1;
/*    */     
/* 25 */     if (k == 0) {
/* 26 */       return this.field_76689_a[j] & 0xF;
/*    */     }
/* 28 */     return this.field_76689_a[j] >> 4 & 0xF;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\chunk\storage\NibbleArrayReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */