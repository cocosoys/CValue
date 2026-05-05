/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ import java.io.DataInput;
/*    */ import java.io.DataOutput;
/*    */ import java.util.Arrays;
/*    */ 
/*    */ public class NBTTagIntArray
/*    */   extends NBTBase {
/*    */   private int[] data;
/*    */   
/*    */   NBTTagIntArray() {}
/*    */   
/*    */   public NBTTagIntArray(int[] paramArrayOfint) {
/* 14 */     this.data = paramArrayOfint;
/*    */   }
/*    */ 
/*    */   
/*    */   void write(DataOutput paramDataOutput) {
/* 19 */     paramDataOutput.writeInt(this.data.length);
/* 20 */     for (byte b = 0; b < this.data.length; b++) {
/* 21 */       paramDataOutput.writeInt(this.data[b]);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   void load(DataInput paramDataInput, int paramInt, NBTReadLimiter paramNBTReadLimiter) {
/* 27 */     int i = paramDataInput.readInt();
/* 28 */     paramNBTReadLimiter.a((32 * i));
/* 29 */     this.data = new int[i];
/* 30 */     for (byte b = 0; b < i; b++) {
/* 31 */       this.data[b] = paramDataInput.readInt();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public byte getTypeId() {
/* 37 */     return 11;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 42 */     String str = "[";
/* 43 */     for (int i : this.data) {
/* 44 */       str = str + i + ",";
/*    */     }
/* 46 */     return str + "]";
/*    */   }
/*    */ 
/*    */   
/*    */   public NBTBase clone() {
/* 51 */     int[] arrayOfInt = new int[this.data.length];
/* 52 */     System.arraycopy(this.data, 0, arrayOfInt, 0, this.data.length);
/* 53 */     return new NBTTagIntArray(arrayOfInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 58 */     if (super.equals(paramObject)) {
/* 59 */       return Arrays.equals(this.data, ((NBTTagIntArray)paramObject).data);
/*    */     }
/* 61 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 66 */     return super.hashCode() ^ Arrays.hashCode(this.data);
/*    */   }
/*    */   
/*    */   public int[] c() {
/* 70 */     return this.data;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\NBTTagIntArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */