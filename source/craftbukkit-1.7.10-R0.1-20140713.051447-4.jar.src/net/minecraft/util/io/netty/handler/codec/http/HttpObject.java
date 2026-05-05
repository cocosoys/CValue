package net.minecraft.util.io.netty.handler.codec.http;

import net.minecraft.util.io.netty.handler.codec.DecoderResult;

public interface HttpObject {
  DecoderResult getDecoderResult();
  
  void setDecoderResult(DecoderResult paramDecoderResult);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\netty\handler\codec\http\HttpObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */