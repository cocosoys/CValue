package net.minecraft.util.com.google.common.hash;

import java.nio.charset.Charset;
import net.minecraft.util.com.google.common.annotations.Beta;

@Beta
public interface PrimitiveSink {
  PrimitiveSink putByte(byte paramByte);
  
  PrimitiveSink putBytes(byte[] paramArrayOfbyte);
  
  PrimitiveSink putBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2);
  
  PrimitiveSink putShort(short paramShort);
  
  PrimitiveSink putInt(int paramInt);
  
  PrimitiveSink putLong(long paramLong);
  
  PrimitiveSink putFloat(float paramFloat);
  
  PrimitiveSink putDouble(double paramDouble);
  
  PrimitiveSink putBoolean(boolean paramBoolean);
  
  PrimitiveSink putChar(char paramChar);
  
  PrimitiveSink putUnencodedChars(CharSequence paramCharSequence);
  
  PrimitiveSink putString(CharSequence paramCharSequence, Charset paramCharset);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\com\google\common\hash\PrimitiveSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */