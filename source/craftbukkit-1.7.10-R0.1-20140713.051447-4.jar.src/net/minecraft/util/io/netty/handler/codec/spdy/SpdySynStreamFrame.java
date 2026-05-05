package net.minecraft.util.io.netty.handler.codec.spdy;

public interface SpdySynStreamFrame extends SpdyHeadersFrame {
  int getAssociatedToStreamId();
  
  SpdySynStreamFrame setAssociatedToStreamId(int paramInt);
  
  byte getPriority();
  
  SpdySynStreamFrame setPriority(byte paramByte);
  
  boolean isUnidirectional();
  
  SpdySynStreamFrame setUnidirectional(boolean paramBoolean);
  
  SpdySynStreamFrame setStreamId(int paramInt);
  
  SpdySynStreamFrame setLast(boolean paramBoolean);
  
  SpdySynStreamFrame setInvalid();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\netty\handler\codec\spdy\SpdySynStreamFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */