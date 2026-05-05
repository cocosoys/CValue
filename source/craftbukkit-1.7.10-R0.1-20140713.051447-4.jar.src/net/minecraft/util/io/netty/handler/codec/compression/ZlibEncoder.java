/*    */ package net.minecraft.util.io.netty.handler.codec.compression;
/*    */ 
/*    */ import net.minecraft.util.io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.util.io.netty.channel.ChannelFuture;
/*    */ import net.minecraft.util.io.netty.channel.ChannelPromise;
/*    */ import net.minecraft.util.io.netty.handler.codec.MessageToByteEncoder;
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
/*    */ public abstract class ZlibEncoder
/*    */   extends MessageToByteEncoder<ByteBuf>
/*    */ {
/*    */   protected ZlibEncoder() {
/* 29 */     super(false);
/*    */   }
/*    */   
/*    */   public abstract boolean isClosed();
/*    */   
/*    */   public abstract ChannelFuture close();
/*    */   
/*    */   public abstract ChannelFuture close(ChannelPromise paramChannelPromise);
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\netty\handler\codec\compression\ZlibEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */