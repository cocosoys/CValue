/*    */ package net.minecraft.util.com.google.common.hash;
/*    */ 
/*    */ import java.io.FilterOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.OutputStream;
/*    */ import net.minecraft.util.com.google.common.annotations.Beta;
/*    */ import net.minecraft.util.com.google.common.base.Preconditions;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Beta
/*    */ public final class HashingOutputStream
/*    */   extends FilterOutputStream
/*    */ {
/*    */   private final Hasher hasher;
/*    */   
/*    */   public HashingOutputStream(HashFunction hashFunction, OutputStream out) {
/* 46 */     super((OutputStream)Preconditions.checkNotNull(out));
/* 47 */     this.hasher = (Hasher)Preconditions.checkNotNull(hashFunction.newHasher());
/*    */   }
/*    */   
/*    */   public void write(int b) throws IOException {
/* 51 */     this.hasher.putByte((byte)b);
/* 52 */     this.out.write(b);
/*    */   }
/*    */   
/*    */   public void write(byte[] bytes, int off, int len) throws IOException {
/* 56 */     this.hasher.putBytes(bytes, off, len);
/* 57 */     this.out.write(bytes, off, len);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public HashCode hash() {
/* 65 */     return this.hasher.hash();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\com\google\common\hash\HashingOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */