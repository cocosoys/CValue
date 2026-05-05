/*     */ package org.apache.commons.lang;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SerializationUtils
/*     */ {
/*     */   public static Object clone(Serializable object) {
/*  80 */     return deserialize(serialize(object));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void serialize(Serializable obj, OutputStream outputStream) {
/* 101 */     if (outputStream == null) {
/* 102 */       throw new IllegalArgumentException("The OutputStream must not be null");
/*     */     }
/* 104 */     ObjectOutputStream out = null;
/*     */     
/*     */     try {
/* 107 */       out = new ObjectOutputStream(outputStream);
/* 108 */       out.writeObject(obj);
/*     */     } catch (IOException ex) {
/*     */       
/* 111 */       throw new SerializationException(ex);
/*     */     } finally {
/*     */       try {
/* 114 */         if (out != null) {
/* 115 */           out.close();
/*     */         }
/* 117 */       } catch (IOException ex) {}
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] serialize(Serializable obj) {
/* 132 */     ByteArrayOutputStream baos = new ByteArrayOutputStream(512);
/* 133 */     serialize(obj, baos);
/* 134 */     return baos.toByteArray();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object deserialize(InputStream inputStream) {
/* 155 */     if (inputStream == null) {
/* 156 */       throw new IllegalArgumentException("The InputStream must not be null");
/*     */     }
/* 158 */     ObjectInputStream in = null;
/*     */     
/*     */     try {
/* 161 */       in = new ObjectInputStream(inputStream);
/* 162 */       return in.readObject();
/*     */     } catch (ClassNotFoundException ex) {
/*     */       
/* 165 */       throw new SerializationException(ex);
/*     */     } catch (IOException ex) {
/* 167 */       throw new SerializationException(ex);
/*     */     } finally {
/*     */       try {
/* 170 */         if (in != null) {
/* 171 */           in.close();
/*     */         }
/* 173 */       } catch (IOException ex) {}
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object deserialize(byte[] objectData) {
/* 188 */     if (objectData == null) {
/* 189 */       throw new IllegalArgumentException("The byte[] must not be null");
/*     */     }
/* 191 */     ByteArrayInputStream bais = new ByteArrayInputStream(objectData);
/* 192 */     return deserialize(bais);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\SerializationUtils.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */