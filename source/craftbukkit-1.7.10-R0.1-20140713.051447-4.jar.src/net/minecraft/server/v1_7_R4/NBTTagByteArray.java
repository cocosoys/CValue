/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ import java.io.DataInput;
/*    */ import java.io.DataOutput;
/*    */ import java.util.Arrays;
/*    */ 
/*    */ public class NBTTagByteArray
/*    */   extends NBTBase {
/*    */   private byte[] data;
/*    */   
/*    */   NBTTagByteArray() {}
/*    */   
/*    */   public NBTTagByteArray(byte[] paramArrayOfbyte) {
/* 14 */     this.data = paramArrayOfbyte;
/*    */   }
/*    */ 
/*    */   
/*    */   void write(DataOutput paramDataOutput) {
/* 19 */     paramDataOutput.writeInt(this.data.length);
/* 20 */     paramDataOutput.write(this.data);
/*    */   }
/*    */ 
/*    */   
/*    */   void load(DataInput paramDataInput, int paramInt, NBTReadLimiter paramNBTReadLimiter) {
/* 25 */     int i = paramDataInput.readInt();
/* 26 */     paramNBTReadLimiter.a((8 * i));
/* 27 */     this.data = new byte[i];
/* 28 */     paramDataInput.readFully(this.data);
/*    */   }
/*    */ 
/*    */   
/*    */   public byte getTypeId() {
/* 33 */     return 7;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 38 */     return "[" + this.data.length + " bytes]";
/*    */   }
/*    */ 
/*    */   
/*    */   public NBTBase clone() {
/* 43 */     byte[] arrayOfByte = new byte[this.data.length];
/* 44 */     System.arraycopy(this.data, 0, arrayOfByte, 0, this.data.length);
/* 45 */     return new NBTTagByteArray(arrayOfByte);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 50 */     if (super.equals(paramObject)) {
/* 51 */       return Arrays.equals(this.data, ((NBTTagByteArray)paramObject).data);
/*    */     }
/* 53 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 58 */     return super.hashCode() ^ Arrays.hashCode(this.data);
/*    */   }
/*    */   
/*    */   public byte[] c() {
/* 62 */     return this.data;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\NBTTagByteArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */