/*    */ package net.minecraft.nbt;
/*    */ 
/*    */ import java.io.DataInput;
/*    */ import java.io.DataOutput;
/*    */ import java.io.IOException;
/*    */ import java.util.Arrays;
/*    */ 
/*    */ public class NBTTagByteArray
/*    */   extends NBTBase
/*    */ {
/*    */   private byte[] field_74754_a;
/*    */   
/*    */   public NBTTagByteArray(byte[] p_i45128_1_) {
/* 14 */     this.field_74754_a = p_i45128_1_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001213";
/*    */   NBTTagByteArray() {}
/*    */   void func_74734_a(DataOutput p_74734_1_) throws IOException {
/* 19 */     p_74734_1_.writeInt(this.field_74754_a.length);
/* 20 */     p_74734_1_.write(this.field_74754_a);
/*    */   }
/*    */ 
/*    */   
/*    */   void func_152446_a(DataInput p_152446_1_, int p_152446_2_, NBTSizeTracker p_152446_3_) throws IOException {
/* 25 */     int i = p_152446_1_.readInt();
/* 26 */     p_152446_3_.func_152450_a((8 * i));
/* 27 */     this.field_74754_a = new byte[i];
/* 28 */     p_152446_1_.readFully(this.field_74754_a);
/*    */   }
/*    */ 
/*    */   
/*    */   public byte func_74732_a() {
/* 33 */     return 7;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 38 */     return "[" + this.field_74754_a.length + " bytes]";
/*    */   }
/*    */ 
/*    */   
/*    */   public NBTBase func_74737_b() {
/* 43 */     byte[] arrayOfByte = new byte[this.field_74754_a.length];
/* 44 */     System.arraycopy(this.field_74754_a, 0, arrayOfByte, 0, this.field_74754_a.length);
/* 45 */     return new NBTTagByteArray(arrayOfByte);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object p_equals_1_) {
/* 50 */     if (super.equals(p_equals_1_)) {
/* 51 */       return Arrays.equals(this.field_74754_a, ((NBTTagByteArray)p_equals_1_).field_74754_a);
/*    */     }
/* 53 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 58 */     return super.hashCode() ^ Arrays.hashCode(this.field_74754_a);
/*    */   }
/*    */   
/*    */   public byte[] func_150292_c() {
/* 62 */     return this.field_74754_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\nbt\NBTTagByteArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */