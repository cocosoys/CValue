/*     */ package net.minecraft.network;
/*     */ 
/*     */ import com.google.common.base.Charsets;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import io.netty.buffer.ByteBufAllocator;
/*     */ import io.netty.buffer.ByteBufProcessor;
/*     */ import io.netty.util.ReferenceCounted;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
/*     */ import java.nio.channels.GatheringByteChannel;
/*     */ import java.nio.channels.ScatteringByteChannel;
/*     */ import java.nio.charset.Charset;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.CompressedStreamTools;
/*     */ import net.minecraft.nbt.NBTSizeTracker;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ 
/*     */ public class PacketBuffer
/*     */   extends ByteBuf
/*     */ {
/*     */   private final ByteBuf field_150794_a;
/*     */   private static final String __OBFID = "CL_00001251";
/*     */   
/*     */   public PacketBuffer(ByteBuf p_i45154_1_) {
/*  29 */     this.field_150794_a = p_i45154_1_;
/*     */   }
/*     */   
/*     */   public static int func_150790_a(int p_150790_0_) {
/*  33 */     if ((p_150790_0_ & 0xFFFFFF80) == 0) return 1; 
/*  34 */     if ((p_150790_0_ & 0xFFFFC000) == 0) return 2; 
/*  35 */     if ((p_150790_0_ & 0xFFE00000) == 0) return 3; 
/*  36 */     if ((p_150790_0_ & 0xF0000000) == 0) return 4; 
/*  37 */     return 5;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_150792_a() {
/*     */     byte b1;
/*  46 */     int i = 0;
/*  47 */     byte b = 0;
/*     */     
/*     */     do {
/*  50 */       b1 = readByte();
/*     */       
/*  52 */       i |= (b1 & Byte.MAX_VALUE) << b++ * 7;
/*     */       
/*  54 */       if (b > 5) throw new RuntimeException("VarInt too big");
/*     */     
/*  56 */     } while ((b1 & 0x80) == 128);
/*     */ 
/*     */     
/*  59 */     return i;
/*     */   }
/*     */   
/*     */   public void func_150787_b(int p_150787_1_) {
/*     */     while (true) {
/*  64 */       if ((p_150787_1_ & 0xFFFFFF80) == 0) {
/*  65 */         writeByte(p_150787_1_);
/*     */         
/*     */         return;
/*     */       } 
/*  69 */       writeByte(p_150787_1_ & 0x7F | 0x80);
/*  70 */       p_150787_1_ >>>= 7;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_150786_a(NBTTagCompound p_150786_1_) throws IOException {
/*  75 */     if (p_150786_1_ == null) {
/*  76 */       writeShort(-1);
/*     */     } else {
/*  78 */       byte[] arrayOfByte = CompressedStreamTools.func_74798_a(p_150786_1_);
/*  79 */       writeShort((short)arrayOfByte.length);
/*  80 */       writeBytes(arrayOfByte);
/*     */     } 
/*     */   }
/*     */   
/*     */   public NBTTagCompound func_150793_b() throws IOException {
/*  85 */     short s = readShort();
/*  86 */     if (s < 0) return null; 
/*  87 */     byte[] arrayOfByte = new byte[s];
/*  88 */     readBytes(arrayOfByte);
/*  89 */     return CompressedStreamTools.func_152457_a(arrayOfByte, new NBTSizeTracker(2097152L));
/*     */   }
/*     */   
/*     */   public void func_150788_a(ItemStack p_150788_1_) throws IOException {
/*  93 */     if (p_150788_1_ == null) {
/*  94 */       writeShort(-1);
/*     */     } else {
/*  96 */       writeShort(Item.func_150891_b(p_150788_1_.func_77973_b()));
/*  97 */       writeByte(p_150788_1_.field_77994_a);
/*  98 */       writeShort(p_150788_1_.func_77960_j());
/*     */       
/* 100 */       NBTTagCompound nBTTagCompound = null;
/* 101 */       if (p_150788_1_.func_77973_b().func_77645_m() || p_150788_1_.func_77973_b().func_77651_p()) {
/* 102 */         nBTTagCompound = p_150788_1_.field_77990_d;
/*     */       }
/* 104 */       func_150786_a(nBTTagCompound);
/*     */     } 
/*     */   }
/*     */   
/*     */   public ItemStack func_150791_c() throws IOException {
/* 109 */     ItemStack itemStack = null;
/* 110 */     short s = readShort();
/* 111 */     if (s >= 0) {
/* 112 */       byte b = readByte();
/* 113 */       short s1 = readShort();
/*     */       
/* 115 */       itemStack = new ItemStack(Item.func_150899_d(s), b, s1);
/* 116 */       itemStack.field_77990_d = func_150793_b();
/*     */     } 
/*     */     
/* 119 */     return itemStack;
/*     */   }
/*     */   
/*     */   public String func_150789_c(int p_150789_1_) throws IOException {
/* 123 */     int i = func_150792_a();
/* 124 */     if (i > p_150789_1_ * 4) {
/* 125 */       throw new IOException("The received encoded string buffer length is longer than maximum allowed (" + i + " > " + (p_150789_1_ * 4) + ")");
/*     */     }
/* 127 */     if (i < 0) {
/* 128 */       throw new IOException("The received encoded string buffer length is less than zero! Weird string!");
/*     */     }
/*     */     
/* 131 */     String str = new String(readBytes(i).array(), Charsets.UTF_8);
/*     */     
/* 133 */     if (str.length() > p_150789_1_) {
/* 134 */       throw new IOException("The received string length is longer than maximum allowed (" + i + " > " + p_150789_1_ + ")");
/*     */     }
/*     */     
/* 137 */     return str;
/*     */   }
/*     */   
/*     */   public void func_150785_a(String p_150785_1_) throws IOException {
/* 141 */     byte[] arrayOfByte = p_150785_1_.getBytes(Charsets.UTF_8);
/* 142 */     if (arrayOfByte.length > 32767) {
/* 143 */       throw new IOException("String too big (was " + p_150785_1_.length() + " bytes encoded, max " + '翿' + ")");
/*     */     }
/* 145 */     func_150787_b(arrayOfByte.length);
/* 146 */     writeBytes(arrayOfByte);
/*     */   }
/*     */ 
/*     */   
/*     */   public int capacity() {
/* 151 */     return this.field_150794_a.capacity();
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf capacity(int p_capacity_1_) {
/* 156 */     return this.field_150794_a.capacity(p_capacity_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int maxCapacity() {
/* 161 */     return this.field_150794_a.maxCapacity();
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBufAllocator alloc() {
/* 166 */     return this.field_150794_a.alloc();
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteOrder order() {
/* 171 */     return this.field_150794_a.order();
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf order(ByteOrder p_order_1_) {
/* 176 */     return this.field_150794_a.order(p_order_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf unwrap() {
/* 181 */     return this.field_150794_a.unwrap();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDirect() {
/* 186 */     return this.field_150794_a.isDirect();
/*     */   }
/*     */ 
/*     */   
/*     */   public int readerIndex() {
/* 191 */     return this.field_150794_a.readerIndex();
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf readerIndex(int p_readerIndex_1_) {
/* 196 */     return this.field_150794_a.readerIndex(p_readerIndex_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int writerIndex() {
/* 201 */     return this.field_150794_a.writerIndex();
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf writerIndex(int p_writerIndex_1_) {
/* 206 */     return this.field_150794_a.writerIndex(p_writerIndex_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf setIndex(int p_setIndex_1_, int p_setIndex_2_) {
/* 211 */     return this.field_150794_a.setIndex(p_setIndex_1_, p_setIndex_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int readableBytes() {
/* 216 */     return this.field_150794_a.readableBytes();
/*     */   }
/*     */ 
/*     */   
/*     */   public int writableBytes() {
/* 221 */     return this.field_150794_a.writableBytes();
/*     */   }
/*     */ 
/*     */   
/*     */   public int maxWritableBytes() {
/* 226 */     return this.field_150794_a.maxWritableBytes();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isReadable() {
/* 231 */     return this.field_150794_a.isReadable();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isReadable(int p_isReadable_1_) {
/* 236 */     return this.field_150794_a.isReadable(p_isReadable_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isWritable() {
/* 241 */     return this.field_150794_a.isWritable();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isWritable(int p_isWritable_1_) {
/* 246 */     return this.field_150794_a.isWritable(p_isWritable_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf clear() {
/* 251 */     return this.field_150794_a.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf markReaderIndex() {
/* 256 */     return this.field_150794_a.markReaderIndex();
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf resetReaderIndex() {
/* 261 */     return this.field_150794_a.resetReaderIndex();
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf markWriterIndex() {
/* 266 */     return this.field_150794_a.markWriterIndex();
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf resetWriterIndex() {
/* 271 */     return this.field_150794_a.resetWriterIndex();
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf discardReadBytes() {
/* 276 */     return this.field_150794_a.discardReadBytes();
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf discardSomeReadBytes() {
/* 281 */     return this.field_150794_a.discardSomeReadBytes();
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf ensureWritable(int p_ensureWritable_1_) {
/* 286 */     return this.field_150794_a.ensureWritable(p_ensureWritable_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int ensureWritable(int p_ensureWritable_1_, boolean p_ensureWritable_2_) {
/* 291 */     return this.field_150794_a.ensureWritable(p_ensureWritable_1_, p_ensureWritable_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getBoolean(int p_getBoolean_1_) {
/* 296 */     return this.field_150794_a.getBoolean(p_getBoolean_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public byte getByte(int p_getByte_1_) {
/* 301 */     return this.field_150794_a.getByte(p_getByte_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public short getUnsignedByte(int p_getUnsignedByte_1_) {
/* 306 */     return this.field_150794_a.getUnsignedByte(p_getUnsignedByte_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public short getShort(int p_getShort_1_) {
/* 311 */     return this.field_150794_a.getShort(p_getShort_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getUnsignedShort(int p_getUnsignedShort_1_) {
/* 316 */     return this.field_150794_a.getUnsignedShort(p_getUnsignedShort_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMedium(int p_getMedium_1_) {
/* 321 */     return this.field_150794_a.getMedium(p_getMedium_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getUnsignedMedium(int p_getUnsignedMedium_1_) {
/* 326 */     return this.field_150794_a.getUnsignedMedium(p_getUnsignedMedium_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getInt(int p_getInt_1_) {
/* 331 */     return this.field_150794_a.getInt(p_getInt_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getUnsignedInt(int p_getUnsignedInt_1_) {
/* 336 */     return this.field_150794_a.getUnsignedInt(p_getUnsignedInt_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getLong(int p_getLong_1_) {
/* 341 */     return this.field_150794_a.getLong(p_getLong_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public char getChar(int p_getChar_1_) {
/* 346 */     return this.field_150794_a.getChar(p_getChar_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public float getFloat(int p_getFloat_1_) {
/* 351 */     return this.field_150794_a.getFloat(p_getFloat_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public double getDouble(int p_getDouble_1_) {
/* 356 */     return this.field_150794_a.getDouble(p_getDouble_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf getBytes(int p_getBytes_1_, ByteBuf p_getBytes_2_) {
/* 361 */     return this.field_150794_a.getBytes(p_getBytes_1_, p_getBytes_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf getBytes(int p_getBytes_1_, ByteBuf p_getBytes_2_, int p_getBytes_3_) {
/* 366 */     return this.field_150794_a.getBytes(p_getBytes_1_, p_getBytes_2_, p_getBytes_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf getBytes(int p_getBytes_1_, ByteBuf p_getBytes_2_, int p_getBytes_3_, int p_getBytes_4_) {
/* 371 */     return this.field_150794_a.getBytes(p_getBytes_1_, p_getBytes_2_, p_getBytes_3_, p_getBytes_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf getBytes(int p_getBytes_1_, byte[] p_getBytes_2_) {
/* 376 */     return this.field_150794_a.getBytes(p_getBytes_1_, p_getBytes_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf getBytes(int p_getBytes_1_, byte[] p_getBytes_2_, int p_getBytes_3_, int p_getBytes_4_) {
/* 381 */     return this.field_150794_a.getBytes(p_getBytes_1_, p_getBytes_2_, p_getBytes_3_, p_getBytes_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf getBytes(int p_getBytes_1_, ByteBuffer p_getBytes_2_) {
/* 386 */     return this.field_150794_a.getBytes(p_getBytes_1_, p_getBytes_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf getBytes(int p_getBytes_1_, OutputStream p_getBytes_2_, int p_getBytes_3_) throws IOException {
/* 391 */     return this.field_150794_a.getBytes(p_getBytes_1_, p_getBytes_2_, p_getBytes_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getBytes(int p_getBytes_1_, GatheringByteChannel p_getBytes_2_, int p_getBytes_3_) throws IOException {
/* 396 */     return this.field_150794_a.getBytes(p_getBytes_1_, p_getBytes_2_, p_getBytes_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf setBoolean(int p_setBoolean_1_, boolean p_setBoolean_2_) {
/* 401 */     return this.field_150794_a.setBoolean(p_setBoolean_1_, p_setBoolean_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf setByte(int p_setByte_1_, int p_setByte_2_) {
/* 406 */     return this.field_150794_a.setByte(p_setByte_1_, p_setByte_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf setShort(int p_setShort_1_, int p_setShort_2_) {
/* 411 */     return this.field_150794_a.setShort(p_setShort_1_, p_setShort_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf setMedium(int p_setMedium_1_, int p_setMedium_2_) {
/* 416 */     return this.field_150794_a.setMedium(p_setMedium_1_, p_setMedium_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf setInt(int p_setInt_1_, int p_setInt_2_) {
/* 421 */     return this.field_150794_a.setInt(p_setInt_1_, p_setInt_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf setLong(int p_setLong_1_, long p_setLong_2_) {
/* 426 */     return this.field_150794_a.setLong(p_setLong_1_, p_setLong_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf setChar(int p_setChar_1_, int p_setChar_2_) {
/* 431 */     return this.field_150794_a.setChar(p_setChar_1_, p_setChar_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf setFloat(int p_setFloat_1_, float p_setFloat_2_) {
/* 436 */     return this.field_150794_a.setFloat(p_setFloat_1_, p_setFloat_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf setDouble(int p_setDouble_1_, double p_setDouble_2_) {
/* 441 */     return this.field_150794_a.setDouble(p_setDouble_1_, p_setDouble_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf setBytes(int p_setBytes_1_, ByteBuf p_setBytes_2_) {
/* 446 */     return this.field_150794_a.setBytes(p_setBytes_1_, p_setBytes_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf setBytes(int p_setBytes_1_, ByteBuf p_setBytes_2_, int p_setBytes_3_) {
/* 451 */     return this.field_150794_a.setBytes(p_setBytes_1_, p_setBytes_2_, p_setBytes_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf setBytes(int p_setBytes_1_, ByteBuf p_setBytes_2_, int p_setBytes_3_, int p_setBytes_4_) {
/* 456 */     return this.field_150794_a.setBytes(p_setBytes_1_, p_setBytes_2_, p_setBytes_3_, p_setBytes_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf setBytes(int p_setBytes_1_, byte[] p_setBytes_2_) {
/* 461 */     return this.field_150794_a.setBytes(p_setBytes_1_, p_setBytes_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf setBytes(int p_setBytes_1_, byte[] p_setBytes_2_, int p_setBytes_3_, int p_setBytes_4_) {
/* 466 */     return this.field_150794_a.setBytes(p_setBytes_1_, p_setBytes_2_, p_setBytes_3_, p_setBytes_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf setBytes(int p_setBytes_1_, ByteBuffer p_setBytes_2_) {
/* 471 */     return this.field_150794_a.setBytes(p_setBytes_1_, p_setBytes_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int setBytes(int p_setBytes_1_, InputStream p_setBytes_2_, int p_setBytes_3_) throws IOException {
/* 476 */     return this.field_150794_a.setBytes(p_setBytes_1_, p_setBytes_2_, p_setBytes_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int setBytes(int p_setBytes_1_, ScatteringByteChannel p_setBytes_2_, int p_setBytes_3_) throws IOException {
/* 481 */     return this.field_150794_a.setBytes(p_setBytes_1_, p_setBytes_2_, p_setBytes_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf setZero(int p_setZero_1_, int p_setZero_2_) {
/* 486 */     return this.field_150794_a.setZero(p_setZero_1_, p_setZero_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean readBoolean() {
/* 491 */     return this.field_150794_a.readBoolean();
/*     */   }
/*     */ 
/*     */   
/*     */   public byte readByte() {
/* 496 */     return this.field_150794_a.readByte();
/*     */   }
/*     */ 
/*     */   
/*     */   public short readUnsignedByte() {
/* 501 */     return this.field_150794_a.readUnsignedByte();
/*     */   }
/*     */ 
/*     */   
/*     */   public short readShort() {
/* 506 */     return this.field_150794_a.readShort();
/*     */   }
/*     */ 
/*     */   
/*     */   public int readUnsignedShort() {
/* 511 */     return this.field_150794_a.readUnsignedShort();
/*     */   }
/*     */ 
/*     */   
/*     */   public int readMedium() {
/* 516 */     return this.field_150794_a.readMedium();
/*     */   }
/*     */ 
/*     */   
/*     */   public int readUnsignedMedium() {
/* 521 */     return this.field_150794_a.readUnsignedMedium();
/*     */   }
/*     */ 
/*     */   
/*     */   public int readInt() {
/* 526 */     return this.field_150794_a.readInt();
/*     */   }
/*     */ 
/*     */   
/*     */   public long readUnsignedInt() {
/* 531 */     return this.field_150794_a.readUnsignedInt();
/*     */   }
/*     */ 
/*     */   
/*     */   public long readLong() {
/* 536 */     return this.field_150794_a.readLong();
/*     */   }
/*     */ 
/*     */   
/*     */   public char readChar() {
/* 541 */     return this.field_150794_a.readChar();
/*     */   }
/*     */ 
/*     */   
/*     */   public float readFloat() {
/* 546 */     return this.field_150794_a.readFloat();
/*     */   }
/*     */ 
/*     */   
/*     */   public double readDouble() {
/* 551 */     return this.field_150794_a.readDouble();
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf readBytes(int p_readBytes_1_) {
/* 556 */     return this.field_150794_a.readBytes(p_readBytes_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf readSlice(int p_readSlice_1_) {
/* 561 */     return this.field_150794_a.readSlice(p_readSlice_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf readBytes(ByteBuf p_readBytes_1_) {
/* 566 */     return this.field_150794_a.readBytes(p_readBytes_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf readBytes(ByteBuf p_readBytes_1_, int p_readBytes_2_) {
/* 571 */     return this.field_150794_a.readBytes(p_readBytes_1_, p_readBytes_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf readBytes(ByteBuf p_readBytes_1_, int p_readBytes_2_, int p_readBytes_3_) {
/* 576 */     return this.field_150794_a.readBytes(p_readBytes_1_, p_readBytes_2_, p_readBytes_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf readBytes(byte[] p_readBytes_1_) {
/* 581 */     return this.field_150794_a.readBytes(p_readBytes_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf readBytes(byte[] p_readBytes_1_, int p_readBytes_2_, int p_readBytes_3_) {
/* 586 */     return this.field_150794_a.readBytes(p_readBytes_1_, p_readBytes_2_, p_readBytes_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf readBytes(ByteBuffer p_readBytes_1_) {
/* 591 */     return this.field_150794_a.readBytes(p_readBytes_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf readBytes(OutputStream p_readBytes_1_, int p_readBytes_2_) throws IOException {
/* 596 */     return this.field_150794_a.readBytes(p_readBytes_1_, p_readBytes_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int readBytes(GatheringByteChannel p_readBytes_1_, int p_readBytes_2_) throws IOException {
/* 601 */     return this.field_150794_a.readBytes(p_readBytes_1_, p_readBytes_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf skipBytes(int p_skipBytes_1_) {
/* 606 */     return this.field_150794_a.skipBytes(p_skipBytes_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf writeBoolean(boolean p_writeBoolean_1_) {
/* 611 */     return this.field_150794_a.writeBoolean(p_writeBoolean_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf writeByte(int p_writeByte_1_) {
/* 616 */     return this.field_150794_a.writeByte(p_writeByte_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf writeShort(int p_writeShort_1_) {
/* 621 */     return this.field_150794_a.writeShort(p_writeShort_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf writeMedium(int p_writeMedium_1_) {
/* 626 */     return this.field_150794_a.writeMedium(p_writeMedium_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf writeInt(int p_writeInt_1_) {
/* 631 */     return this.field_150794_a.writeInt(p_writeInt_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf writeLong(long p_writeLong_1_) {
/* 636 */     return this.field_150794_a.writeLong(p_writeLong_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf writeChar(int p_writeChar_1_) {
/* 641 */     return this.field_150794_a.writeChar(p_writeChar_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf writeFloat(float p_writeFloat_1_) {
/* 646 */     return this.field_150794_a.writeFloat(p_writeFloat_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf writeDouble(double p_writeDouble_1_) {
/* 651 */     return this.field_150794_a.writeDouble(p_writeDouble_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf writeBytes(ByteBuf p_writeBytes_1_) {
/* 656 */     return this.field_150794_a.writeBytes(p_writeBytes_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf writeBytes(ByteBuf p_writeBytes_1_, int p_writeBytes_2_) {
/* 661 */     return this.field_150794_a.writeBytes(p_writeBytes_1_, p_writeBytes_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf writeBytes(ByteBuf p_writeBytes_1_, int p_writeBytes_2_, int p_writeBytes_3_) {
/* 666 */     return this.field_150794_a.writeBytes(p_writeBytes_1_, p_writeBytes_2_, p_writeBytes_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf writeBytes(byte[] p_writeBytes_1_) {
/* 671 */     return this.field_150794_a.writeBytes(p_writeBytes_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf writeBytes(byte[] p_writeBytes_1_, int p_writeBytes_2_, int p_writeBytes_3_) {
/* 676 */     return this.field_150794_a.writeBytes(p_writeBytes_1_, p_writeBytes_2_, p_writeBytes_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf writeBytes(ByteBuffer p_writeBytes_1_) {
/* 681 */     return this.field_150794_a.writeBytes(p_writeBytes_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int writeBytes(InputStream p_writeBytes_1_, int p_writeBytes_2_) throws IOException {
/* 686 */     return this.field_150794_a.writeBytes(p_writeBytes_1_, p_writeBytes_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int writeBytes(ScatteringByteChannel p_writeBytes_1_, int p_writeBytes_2_) throws IOException {
/* 691 */     return this.field_150794_a.writeBytes(p_writeBytes_1_, p_writeBytes_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf writeZero(int p_writeZero_1_) {
/* 696 */     return this.field_150794_a.writeZero(p_writeZero_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int indexOf(int p_indexOf_1_, int p_indexOf_2_, byte p_indexOf_3_) {
/* 701 */     return this.field_150794_a.indexOf(p_indexOf_1_, p_indexOf_2_, p_indexOf_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int bytesBefore(byte p_bytesBefore_1_) {
/* 706 */     return this.field_150794_a.bytesBefore(p_bytesBefore_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int bytesBefore(int p_bytesBefore_1_, byte p_bytesBefore_2_) {
/* 711 */     return this.field_150794_a.bytesBefore(p_bytesBefore_1_, p_bytesBefore_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int bytesBefore(int p_bytesBefore_1_, int p_bytesBefore_2_, byte p_bytesBefore_3_) {
/* 716 */     return this.field_150794_a.bytesBefore(p_bytesBefore_1_, p_bytesBefore_2_, p_bytesBefore_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int forEachByte(ByteBufProcessor p_forEachByte_1_) {
/* 721 */     return this.field_150794_a.forEachByte(p_forEachByte_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int forEachByte(int p_forEachByte_1_, int p_forEachByte_2_, ByteBufProcessor p_forEachByte_3_) {
/* 726 */     return this.field_150794_a.forEachByte(p_forEachByte_1_, p_forEachByte_2_, p_forEachByte_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int forEachByteDesc(ByteBufProcessor p_forEachByteDesc_1_) {
/* 731 */     return this.field_150794_a.forEachByteDesc(p_forEachByteDesc_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int forEachByteDesc(int p_forEachByteDesc_1_, int p_forEachByteDesc_2_, ByteBufProcessor p_forEachByteDesc_3_) {
/* 736 */     return this.field_150794_a.forEachByteDesc(p_forEachByteDesc_1_, p_forEachByteDesc_2_, p_forEachByteDesc_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf copy() {
/* 741 */     return this.field_150794_a.copy();
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf copy(int p_copy_1_, int p_copy_2_) {
/* 746 */     return this.field_150794_a.copy(p_copy_1_, p_copy_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf slice() {
/* 751 */     return this.field_150794_a.slice();
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf slice(int p_slice_1_, int p_slice_2_) {
/* 756 */     return this.field_150794_a.slice(p_slice_1_, p_slice_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf duplicate() {
/* 761 */     return this.field_150794_a.duplicate();
/*     */   }
/*     */ 
/*     */   
/*     */   public int nioBufferCount() {
/* 766 */     return this.field_150794_a.nioBufferCount();
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuffer nioBuffer() {
/* 771 */     return this.field_150794_a.nioBuffer();
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuffer nioBuffer(int p_nioBuffer_1_, int p_nioBuffer_2_) {
/* 776 */     return this.field_150794_a.nioBuffer(p_nioBuffer_1_, p_nioBuffer_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuffer internalNioBuffer(int p_internalNioBuffer_1_, int p_internalNioBuffer_2_) {
/* 781 */     return this.field_150794_a.internalNioBuffer(p_internalNioBuffer_1_, p_internalNioBuffer_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuffer[] nioBuffers() {
/* 786 */     return this.field_150794_a.nioBuffers();
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuffer[] nioBuffers(int p_nioBuffers_1_, int p_nioBuffers_2_) {
/* 791 */     return this.field_150794_a.nioBuffers(p_nioBuffers_1_, p_nioBuffers_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasArray() {
/* 796 */     return this.field_150794_a.hasArray();
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] array() {
/* 801 */     return this.field_150794_a.array();
/*     */   }
/*     */ 
/*     */   
/*     */   public int arrayOffset() {
/* 806 */     return this.field_150794_a.arrayOffset();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasMemoryAddress() {
/* 811 */     return this.field_150794_a.hasMemoryAddress();
/*     */   }
/*     */ 
/*     */   
/*     */   public long memoryAddress() {
/* 816 */     return this.field_150794_a.memoryAddress();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString(Charset p_toString_1_) {
/* 821 */     return this.field_150794_a.toString(p_toString_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString(int p_toString_1_, int p_toString_2_, Charset p_toString_3_) {
/* 826 */     return this.field_150794_a.toString(p_toString_1_, p_toString_2_, p_toString_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 831 */     return this.field_150794_a.hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object p_equals_1_) {
/* 836 */     return this.field_150794_a.equals(p_equals_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int compareTo(ByteBuf p_compareTo_1_) {
/* 841 */     return this.field_150794_a.compareTo(p_compareTo_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 846 */     return this.field_150794_a.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf retain(int p_retain_1_) {
/* 851 */     return this.field_150794_a.retain(p_retain_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuf retain() {
/* 856 */     return this.field_150794_a.retain();
/*     */   }
/*     */ 
/*     */   
/*     */   public int refCnt() {
/* 861 */     return this.field_150794_a.refCnt();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean release() {
/* 866 */     return this.field_150794_a.release();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean release(int p_release_1_) {
/* 871 */     return this.field_150794_a.release(p_release_1_);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\PacketBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */