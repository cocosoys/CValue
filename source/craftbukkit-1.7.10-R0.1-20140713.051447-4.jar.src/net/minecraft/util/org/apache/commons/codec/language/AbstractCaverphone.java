/*    */ package net.minecraft.util.org.apache.commons.codec.language;
/*    */ 
/*    */ import net.minecraft.util.org.apache.commons.codec.EncoderException;
/*    */ import net.minecraft.util.org.apache.commons.codec.StringEncoder;
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
/*    */ public abstract class AbstractCaverphone
/*    */   implements StringEncoder
/*    */ {
/*    */   public Object encode(Object source) throws EncoderException {
/* 57 */     if (!(source instanceof String)) {
/* 58 */       throw new EncoderException("Parameter supplied to Caverphone encode is not of type java.lang.String");
/*    */     }
/* 60 */     return encode((String)source);
/*    */   }
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
/*    */   public boolean isEncodeEqual(String str1, String str2) throws EncoderException {
/* 76 */     return encode(str1).equals(encode(str2));
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\org\apache\commons\codec\language\AbstractCaverphone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */