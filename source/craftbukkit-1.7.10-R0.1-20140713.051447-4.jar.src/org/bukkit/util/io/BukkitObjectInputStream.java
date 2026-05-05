/*    */ package org.bukkit.util.io;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.ObjectInputStream;
/*    */ import java.util.Map;
/*    */ import org.bukkit.configuration.serialization.ConfigurationSerialization;
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
/*    */ public class BukkitObjectInputStream
/*    */   extends ObjectInputStream
/*    */ {
/*    */   protected BukkitObjectInputStream() throws IOException, SecurityException {
/* 30 */     enableResolveObject(true);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public BukkitObjectInputStream(InputStream in) throws IOException {
/* 41 */     super(in);
/* 42 */     enableResolveObject(true);
/*    */   }
/*    */ 
/*    */   
/*    */   protected Object resolveObject(Object obj) throws IOException {
/* 47 */     if (obj instanceof Wrapper) {
/*    */       try {
/* 49 */         (obj = ConfigurationSerialization.deserializeObject((Map)((Wrapper)obj).map)).getClass();
/* 50 */       } catch (Throwable ex) {
/* 51 */         throw newIOException("Failed to deserialize object", ex);
/*    */       } 
/*    */     }
/*    */     
/* 55 */     return super.resolveObject(obj);
/*    */   }
/*    */   
/*    */   private static IOException newIOException(String string, Throwable cause) {
/* 59 */     IOException exception = new IOException(string);
/* 60 */     exception.initCause(cause);
/* 61 */     return exception;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukki\\util\io\BukkitObjectInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */