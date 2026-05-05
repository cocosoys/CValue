package net.minecraft.util.io.netty.channel;

import net.minecraft.util.io.netty.buffer.ByteBuf;
import net.minecraft.util.io.netty.buffer.ByteBufAllocator;

public interface RecvByteBufAllocator {
  Handle newHandle();
  
  public static interface Handle {
    ByteBuf allocate(ByteBufAllocator param1ByteBufAllocator);
    
    int guess();
    
    void record(int param1Int);
  }
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\netty\channel\RecvByteBufAllocator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */