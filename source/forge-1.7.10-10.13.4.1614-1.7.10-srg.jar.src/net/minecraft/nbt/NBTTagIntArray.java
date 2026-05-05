/*    */ package net.minecraft.nbt;
/*    */ 
/*    */ import java.io.DataInput;
/*    */ import java.io.DataOutput;
/*    */ import java.io.IOException;
/*    */ import java.util.Arrays;
/*    */ 
/*    */ public class NBTTagIntArray
/*    */   extends NBTBase
/*    */ {
/*    */   private int[] field_74749_a;
/*    */   
/*    */   public NBTTagIntArray(int[] p_i45132_1_) {
/* 14 */     this.field_74749_a = p_i45132_1_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001221";
/*    */   NBTTagIntArray() {}
/*    */   void func_74734_a(DataOutput p_74734_1_) throws IOException {
/* 19 */     p_74734_1_.writeInt(this.field_74749_a.length);
/* 20 */     for (byte b = 0; b < this.field_74749_a.length; b++) {
/* 21 */       p_74734_1_.writeInt(this.field_74749_a[b]);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   void func_152446_a(DataInput p_152446_1_, int p_152446_2_, NBTSizeTracker p_152446_3_) throws IOException {
/* 27 */     int i = p_152446_1_.readInt();
/* 28 */     p_152446_3_.func_152450_a((32 * i));
/* 29 */     this.field_74749_a = new int[i];
/* 30 */     for (byte b = 0; b < i; b++) {
/* 31 */       this.field_74749_a[b] = p_152446_1_.readInt();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public byte func_74732_a() {
/* 37 */     return 11;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 42 */     String str = "[";
/* 43 */     for (int i : this.field_74749_a) {
/* 44 */       str = str + i + ",";
/*    */     }
/* 46 */     return str + "]";
/*    */   }
/*    */ 
/*    */   
/*    */   public NBTBase func_74737_b() {
/* 51 */     int[] arrayOfInt = new int[this.field_74749_a.length];
/* 52 */     System.arraycopy(this.field_74749_a, 0, arrayOfInt, 0, this.field_74749_a.length);
/* 53 */     return new NBTTagIntArray(arrayOfInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object p_equals_1_) {
/* 58 */     if (super.equals(p_equals_1_)) {
/* 59 */       return Arrays.equals(this.field_74749_a, ((NBTTagIntArray)p_equals_1_).field_74749_a);
/*    */     }
/* 61 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 66 */     return super.hashCode() ^ Arrays.hashCode(this.field_74749_a);
/*    */   }
/*    */   
/*    */   public int[] func_150302_c() {
/* 70 */     return this.field_74749_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\nbt\NBTTagIntArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */