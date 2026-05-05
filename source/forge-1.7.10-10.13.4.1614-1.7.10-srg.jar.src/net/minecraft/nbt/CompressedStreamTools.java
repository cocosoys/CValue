/*     */ package net.minecraft.nbt;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.DataInput;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.DataOutput;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ 
/*     */ public class CompressedStreamTools {
/*     */   public static NBTTagCompound func_74796_a(InputStream p_74796_0_) throws IOException {
/*  13 */     DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(p_74796_0_)));
/*     */     try {
/*  15 */       return func_152456_a(dataInputStream, NBTSizeTracker.field_152451_a);
/*     */     } finally {
/*  17 */       dataInputStream.close();
/*     */     } 
/*     */   }
/*     */   private static final String __OBFID = "CL_00001226";
/*     */   public static void func_74799_a(NBTTagCompound p_74799_0_, OutputStream p_74799_1_) throws IOException {
/*  22 */     DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream(p_74799_1_)));
/*     */     try {
/*  24 */       func_74800_a(p_74799_0_, dataOutputStream);
/*     */     } finally {
/*  26 */       dataOutputStream.close();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static NBTTagCompound func_152457_a(byte[] p_152457_0_, NBTSizeTracker p_152457_1_) throws IOException {
/*  31 */     DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(new ByteArrayInputStream(p_152457_0_))));
/*     */     try {
/*  33 */       return func_152456_a(dataInputStream, p_152457_1_);
/*     */     } finally {
/*  35 */       dataInputStream.close();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static byte[] func_74798_a(NBTTagCompound p_74798_0_) throws IOException {
/*  40 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*  41 */     DataOutputStream dataOutputStream = new DataOutputStream(new GZIPOutputStream(byteArrayOutputStream));
/*     */     try {
/*  43 */       func_74800_a(p_74798_0_, dataOutputStream);
/*     */     } finally {
/*  45 */       dataOutputStream.close();
/*     */     } 
/*  47 */     return byteArrayOutputStream.toByteArray();
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static void func_74793_a(NBTTagCompound p_74793_0_, File p_74793_1_) throws IOException {
/*  51 */     File file = new File(p_74793_1_.getAbsolutePath() + "_tmp");
/*  52 */     if (file.exists()) file.delete(); 
/*  53 */     func_74795_b(p_74793_0_, file);
/*  54 */     if (p_74793_1_.exists()) p_74793_1_.delete(); 
/*  55 */     if (p_74793_1_.exists()) throw new IOException("Failed to delete " + p_74793_1_); 
/*  56 */     file.renameTo(p_74793_1_);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static void func_74795_b(NBTTagCompound p_74795_0_, File p_74795_1_) throws IOException {
/*  60 */     DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(p_74795_1_));
/*     */     try {
/*  62 */       func_74800_a(p_74795_0_, dataOutputStream);
/*     */     } finally {
/*  64 */       dataOutputStream.close();
/*     */     } 
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static NBTTagCompound func_74797_a(File p_74797_0_) throws IOException {
/*  69 */     return func_152458_a(p_74797_0_, NBTSizeTracker.field_152451_a);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static NBTTagCompound func_152458_a(File p_152458_0_, NBTSizeTracker p_152458_1_) throws IOException {
/*  73 */     if (!p_152458_0_.exists()) {
/*  74 */       return null;
/*     */     }
/*  76 */     DataInputStream dataInputStream = new DataInputStream(new FileInputStream(p_152458_0_));
/*     */     try {
/*  78 */       return func_152456_a(dataInputStream, p_152458_1_);
/*     */     } finally {
/*  80 */       dataInputStream.close();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static NBTTagCompound func_74794_a(DataInputStream p_74794_0_) throws IOException {
/*  85 */     return func_152456_a(p_74794_0_, NBTSizeTracker.field_152451_a);
/*     */   }
/*     */   
/*     */   public static NBTTagCompound func_152456_a(DataInput p_152456_0_, NBTSizeTracker p_152456_1_) throws IOException {
/*  89 */     NBTBase nBTBase = func_152455_a(p_152456_0_, 0, p_152456_1_);
/*  90 */     if (nBTBase instanceof NBTTagCompound) {
/*  91 */       return (NBTTagCompound)nBTBase;
/*     */     }
/*  93 */     throw new IOException("Root tag must be a named compound tag");
/*     */   }
/*     */   
/*     */   public static void func_74800_a(NBTTagCompound p_74800_0_, DataOutput p_74800_1_) throws IOException {
/*  97 */     func_150663_a(p_74800_0_, p_74800_1_);
/*     */   }
/*     */   
/*     */   private static void func_150663_a(NBTBase p_150663_0_, DataOutput p_150663_1_) throws IOException {
/* 101 */     p_150663_1_.writeByte(p_150663_0_.func_74732_a());
/* 102 */     if (p_150663_0_.func_74732_a() == 0) {
/*     */       return;
/*     */     }
/* 105 */     p_150663_1_.writeUTF("");
/*     */     
/* 107 */     p_150663_0_.func_74734_a(p_150663_1_);
/*     */   }
/*     */   
/*     */   private static NBTBase func_152455_a(DataInput p_152455_0_, int p_152455_1_, NBTSizeTracker p_152455_2_) throws IOException {
/* 111 */     byte b = p_152455_0_.readByte();
/* 112 */     if (b == 0) return new NBTTagEnd();
/*     */ 
/*     */     
/* 115 */     p_152455_0_.readUTF();
/*     */     
/* 117 */     NBTBase nBTBase = NBTBase.func_150284_a(b);
/*     */     
/*     */     try {
/* 120 */       nBTBase.func_152446_a(p_152455_0_, p_152455_1_, p_152455_2_);
/* 121 */     } catch (IOException iOException) {
/* 122 */       CrashReport crashReport = CrashReport.func_85055_a(iOException, "Loading NBT data");
/* 123 */       CrashReportCategory crashReportCategory = crashReport.func_85058_a("NBT Tag");
/* 124 */       crashReportCategory.func_71507_a("Tag name", "[UNNAMED TAG]");
/* 125 */       crashReportCategory.func_71507_a("Tag type", Byte.valueOf(b));
/* 126 */       throw new ReportedException(crashReport);
/*     */     } 
/*     */     
/* 129 */     return nBTBase;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\nbt\CompressedStreamTools.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */