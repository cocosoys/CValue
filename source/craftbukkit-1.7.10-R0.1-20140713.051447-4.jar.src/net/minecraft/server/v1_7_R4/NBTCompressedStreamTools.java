/*     */ package net.minecraft.server.v1_7_R4;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.DataInput;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.DataOutput;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.util.zip.GZIPInputStream;
/*     */ import java.util.zip.GZIPOutputStream;
/*     */ 
/*     */ public class NBTCompressedStreamTools {
/*     */   public static NBTTagCompound a(InputStream paramInputStream) {
/*  13 */     DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(paramInputStream)));
/*     */     try {
/*  15 */       return a(dataInputStream, NBTReadLimiter.a);
/*     */     } finally {
/*  17 */       dataInputStream.close();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void a(NBTTagCompound paramNBTTagCompound, OutputStream paramOutputStream) {
/*  22 */     DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream(paramOutputStream)));
/*     */     try {
/*  24 */       a(paramNBTTagCompound, dataOutputStream);
/*     */     } finally {
/*  26 */       dataOutputStream.close();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static NBTTagCompound a(byte[] paramArrayOfbyte, NBTReadLimiter paramNBTReadLimiter) {
/*  31 */     DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(new ByteArrayInputStream(paramArrayOfbyte))));
/*     */     try {
/*  33 */       return a(dataInputStream, paramNBTReadLimiter);
/*     */     } finally {
/*  35 */       dataInputStream.close();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static byte[] a(NBTTagCompound paramNBTTagCompound) {
/*  40 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*  41 */     DataOutputStream dataOutputStream = new DataOutputStream(new GZIPOutputStream(byteArrayOutputStream));
/*     */     try {
/*  43 */       a(paramNBTTagCompound, dataOutputStream);
/*     */     } finally {
/*  45 */       dataOutputStream.close();
/*     */     } 
/*  47 */     return byteArrayOutputStream.toByteArray();
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
/*     */   public static NBTTagCompound a(DataInputStream paramDataInputStream) {
/*  85 */     return a(paramDataInputStream, NBTReadLimiter.a);
/*     */   }
/*     */   
/*     */   public static NBTTagCompound a(DataInput paramDataInput, NBTReadLimiter paramNBTReadLimiter) {
/*  89 */     NBTBase nBTBase = a(paramDataInput, 0, paramNBTReadLimiter);
/*  90 */     if (nBTBase instanceof NBTTagCompound) {
/*  91 */       return (NBTTagCompound)nBTBase;
/*     */     }
/*  93 */     throw new IOException("Root tag must be a named compound tag");
/*     */   }
/*     */   
/*     */   public static void a(NBTTagCompound paramNBTTagCompound, DataOutput paramDataOutput) {
/*  97 */     a(paramNBTTagCompound, paramDataOutput);
/*     */   }
/*     */   
/*     */   private static void a(NBTBase paramNBTBase, DataOutput paramDataOutput) {
/* 101 */     paramDataOutput.writeByte(paramNBTBase.getTypeId());
/* 102 */     if (paramNBTBase.getTypeId() == 0) {
/*     */       return;
/*     */     }
/* 105 */     paramDataOutput.writeUTF("");
/*     */     
/* 107 */     paramNBTBase.write(paramDataOutput);
/*     */   }
/*     */   
/*     */   private static NBTBase a(DataInput paramDataInput, int paramInt, NBTReadLimiter paramNBTReadLimiter) {
/* 111 */     byte b = paramDataInput.readByte();
/* 112 */     if (b == 0) return new NBTTagEnd();
/*     */ 
/*     */     
/* 115 */     paramDataInput.readUTF();
/*     */     
/* 117 */     NBTBase nBTBase = NBTBase.createTag(b);
/*     */     
/*     */     try {
/* 120 */       nBTBase.load(paramDataInput, paramInt, paramNBTReadLimiter);
/* 121 */     } catch (IOException iOException) {
/* 122 */       CrashReport crashReport = CrashReport.a(iOException, "Loading NBT data");
/* 123 */       CrashReportSystemDetails crashReportSystemDetails = crashReport.a("NBT Tag");
/* 124 */       crashReportSystemDetails.a("Tag name", "[UNNAMED TAG]");
/* 125 */       crashReportSystemDetails.a("Tag type", Byte.valueOf(b));
/* 126 */       throw new ReportedException(crashReport);
/*     */     } 
/*     */     
/* 129 */     return nBTBase;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\NBTCompressedStreamTools.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */