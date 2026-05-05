/*    */ package net.minecraft.util.io.netty.buffer;
/*    */ 
/*    */ import net.minecraft.util.io.netty.util.internal.PlatformDependent;
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
/*    */ public final class UnpooledByteBufAllocator
/*    */   extends AbstractByteBufAllocator
/*    */ {
/* 28 */   public static final UnpooledByteBufAllocator DEFAULT = new UnpooledByteBufAllocator(PlatformDependent.directBufferPreferred());
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public UnpooledByteBufAllocator(boolean preferDirect) {
/* 38 */     super(preferDirect);
/*    */   }
/*    */ 
/*    */   
/*    */   protected ByteBuf newHeapBuffer(int initialCapacity, int maxCapacity) {
/* 43 */     return new UnpooledHeapByteBuf(this, initialCapacity, maxCapacity);
/*    */   }
/*    */ 
/*    */   
/*    */   protected ByteBuf newDirectBuffer(int initialCapacity, int maxCapacity) {
/* 48 */     if (PlatformDependent.hasUnsafe()) {
/* 49 */       return new UnpooledUnsafeDirectByteBuf(this, initialCapacity, maxCapacity);
/*    */     }
/* 51 */     return new UnpooledDirectByteBuf(this, initialCapacity, maxCapacity);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isDirectBufferPooled() {
/* 57 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\netty\buffer\UnpooledByteBufAllocator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */