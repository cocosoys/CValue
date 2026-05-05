package net.minecraft.util.com.google.common.hash;

import java.nio.charset.Charset;
import net.minecraft.util.com.google.common.annotations.Beta;

@Beta
public interface HashFunction {
  Hasher newHasher();
  
  Hasher newHasher(int paramInt);
  
  HashCode hashInt(int paramInt);
  
  HashCode hashLong(long paramLong);
  
  HashCode hashBytes(byte[] paramArrayOfbyte);
  
  HashCode hashBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2);
  
  HashCode hashUnencodedChars(CharSequence paramCharSequence);
  
  HashCode hashString(CharSequence paramCharSequence, Charset paramCharset);
  
  <T> HashCode hashObject(T paramT, Funnel<? super T> paramFunnel);
  
  int bits();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\com\google\common\hash\HashFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */