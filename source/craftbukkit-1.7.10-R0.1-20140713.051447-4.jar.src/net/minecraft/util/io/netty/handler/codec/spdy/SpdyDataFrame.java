package net.minecraft.util.io.netty.handler.codec.spdy;

import net.minecraft.util.io.netty.buffer.ByteBuf;
import net.minecraft.util.io.netty.buffer.ByteBufHolder;

public interface SpdyDataFrame extends ByteBufHolder, SpdyStreamFrame {
  SpdyDataFrame setStreamId(int paramInt);
  
  SpdyDataFrame setLast(boolean paramBoolean);
  
  ByteBuf content();
  
  SpdyDataFrame copy();
  
  SpdyDataFrame duplicate();
  
  SpdyDataFrame retain();
  
  SpdyDataFrame retain(int paramInt);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\netty\handler\codec\spdy\SpdyDataFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */