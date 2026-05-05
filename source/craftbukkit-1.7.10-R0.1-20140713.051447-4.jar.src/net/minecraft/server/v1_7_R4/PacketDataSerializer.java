/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
/*     */ import java.nio.channels.GatheringByteChannel;
/*     */ import java.nio.channels.ScatteringByteChannel;
/*     */ import java.nio.charset.Charset;
/*     */ import net.minecraft.util.com.google.common.base.Charsets;
/*     */ import net.minecraft.util.io.netty.buffer.ByteBuf;
/*     */ import net.minecraft.util.io.netty.buffer.ByteBufAllocator;
/*     */ import net.minecraft.util.io.netty.buffer.ByteBufProcessor;
/*     */ import net.minecraft.util.io.netty.util.ReferenceCounted;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.inventory.CraftItemStack;
/*     */ 
/*     */ public class PacketDataSerializer
/*     */   extends ByteBuf
/*     */ {
/*     */   private final ByteBuf a;
/*     */   
/*     */   public PacketDataSerializer(ByteBuf bytebuf) {
/*  24 */     this.a = bytebuf;
/*     */   }
/*     */   
/*     */   public static int a(int i) {
/*  28 */     return ((i & 0xFFFFFF80) == 0) ? 1 : (((i & 0xFFFFC000) == 0) ? 2 : (((i & 0xFFE00000) == 0) ? 3 : (((i & 0xF0000000) == 0) ? 4 : 5)));
/*     */   }
/*     */   public int a() {
/*     */     byte b0;
/*  32 */     int i = 0;
/*  33 */     int j = 0;
/*     */ 
/*     */ 
/*     */     
/*     */     do {
/*  38 */       b0 = readByte();
/*  39 */       i |= (b0 & Byte.MAX_VALUE) << j++ * 7;
/*  40 */       if (j > 5) {
/*  41 */         throw new RuntimeException("VarInt too big");
/*     */       }
/*  43 */     } while ((b0 & 0x80) == 128);
/*     */     
/*  45 */     return i;
/*     */   }
/*     */   
/*     */   public void b(int i) {
/*  49 */     while ((i & 0xFFFFFF80) != 0) {
/*  50 */       writeByte(i & 0x7F | 0x80);
/*  51 */       i >>>= 7;
/*     */     } 
/*     */     
/*  54 */     writeByte(i);
/*     */   }
/*     */   
/*     */   public void a(NBTTagCompound nbttagcompound) {
/*  58 */     if (nbttagcompound == null) {
/*  59 */       writeShort(-1);
/*     */     } else {
/*  61 */       byte[] abyte = NBTCompressedStreamTools.a(nbttagcompound);
/*     */       
/*  63 */       writeShort((short)abyte.length);
/*  64 */       writeBytes(abyte);
/*     */     } 
/*     */   }
/*     */   
/*     */   public NBTTagCompound b() {
/*  69 */     short short1 = readShort();
/*     */     
/*  71 */     if (short1 < 0) {
/*  72 */       return null;
/*     */     }
/*  74 */     byte[] abyte = new byte[short1];
/*     */     
/*  76 */     readBytes(abyte);
/*  77 */     return NBTCompressedStreamTools.a(abyte, new NBTReadLimiter(2097152L));
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(ItemStack itemstack) {
/*  82 */     if (itemstack == null || itemstack.getItem() == null) {
/*  83 */       writeShort(-1);
/*     */     } else {
/*  85 */       writeShort(Item.getId(itemstack.getItem()));
/*  86 */       writeByte(itemstack.count);
/*  87 */       writeShort(itemstack.getData());
/*  88 */       NBTTagCompound nbttagcompound = null;
/*     */       
/*  90 */       if (itemstack.getItem().usesDurability() || itemstack.getItem().s()) {
/*  91 */         nbttagcompound = itemstack.tag;
/*     */       }
/*     */       
/*  94 */       a(nbttagcompound);
/*     */     } 
/*     */   }
/*     */   
/*     */   public ItemStack c() {
/*  99 */     ItemStack itemstack = null;
/* 100 */     short short1 = readShort();
/*     */     
/* 102 */     if (short1 >= 0) {
/* 103 */       byte b0 = readByte();
/* 104 */       short short2 = readShort();
/*     */       
/* 106 */       itemstack = new ItemStack(Item.getById(short1), b0, short2);
/* 107 */       itemstack.tag = b();
/*     */       
/* 109 */       if (itemstack.tag != null) {
/* 110 */         CraftItemStack.setItemMeta(itemstack, CraftItemStack.getItemMeta(itemstack));
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 115 */     return itemstack;
/*     */   }
/*     */   
/*     */   public String c(int i) throws IOException {
/* 119 */     int j = a();
/*     */     
/* 121 */     if (j > i * 4)
/* 122 */       throw new IOException("The received encoded string buffer length is longer than maximum allowed (" + j + " > " + (i * 4) + ")"); 
/* 123 */     if (j < 0) {
/* 124 */       throw new IOException("The received encoded string buffer length is less than zero! Weird string!");
/*     */     }
/* 126 */     String s = new String(readBytes(j).array(), Charsets.UTF_8);
/*     */     
/* 128 */     if (s.length() > i) {
/* 129 */       throw new IOException("The received string length is longer than maximum allowed (" + j + " > " + i + ")");
/*     */     }
/* 131 */     return s;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(String s) throws IOException {
/* 137 */     byte[] abyte = s.getBytes(Charsets.UTF_8);
/*     */     
/* 139 */     if (abyte.length > 32767) {
/* 140 */       throw new IOException("String too big (was " + s.length() + " bytes encoded, max " + '翿' + ")");
/*     */     }
/* 142 */     b(abyte.length);
/* 143 */     writeBytes(abyte);
/*     */   }
/*     */ 
/*     */   
/*     */   public int capacity() {
/* 148 */     return this.a.capacity();
/*     */   }
/*     */   
/*     */   public ByteBuf capacity(int i) {
/* 152 */     return this.a.capacity(i);
/*     */   }
/*     */   
/*     */   public int maxCapacity() {
/* 156 */     return this.a.maxCapacity();
/*     */   }
/*     */   
/*     */   public ByteBufAllocator alloc() {
/* 160 */     return this.a.alloc();
/*     */   }
/*     */   
/*     */   public ByteOrder order() {
/* 164 */     return this.a.order();
/*     */   }
/*     */   
/*     */   public ByteBuf order(ByteOrder byteorder) {
/* 168 */     return this.a.order(byteorder);
/*     */   }
/*     */   
/*     */   public ByteBuf unwrap() {
/* 172 */     return this.a.unwrap();
/*     */   }
/*     */   
/*     */   public boolean isDirect() {
/* 176 */     return this.a.isDirect();
/*     */   }
/*     */   
/*     */   public int readerIndex() {
/* 180 */     return this.a.readerIndex();
/*     */   }
/*     */   
/*     */   public ByteBuf readerIndex(int i) {
/* 184 */     return this.a.readerIndex(i);
/*     */   }
/*     */   
/*     */   public int writerIndex() {
/* 188 */     return this.a.writerIndex();
/*     */   }
/*     */   
/*     */   public ByteBuf writerIndex(int i) {
/* 192 */     return this.a.writerIndex(i);
/*     */   }
/*     */   
/*     */   public ByteBuf setIndex(int i, int j) {
/* 196 */     return this.a.setIndex(i, j);
/*     */   }
/*     */   
/*     */   public int readableBytes() {
/* 200 */     return this.a.readableBytes();
/*     */   }
/*     */   
/*     */   public int writableBytes() {
/* 204 */     return this.a.writableBytes();
/*     */   }
/*     */   
/*     */   public int maxWritableBytes() {
/* 208 */     return this.a.maxWritableBytes();
/*     */   }
/*     */   
/*     */   public boolean isReadable() {
/* 212 */     return this.a.isReadable();
/*     */   }
/*     */   
/*     */   public boolean isReadable(int i) {
/* 216 */     return this.a.isReadable(i);
/*     */   }
/*     */   
/*     */   public boolean isWritable() {
/* 220 */     return this.a.isWritable();
/*     */   }
/*     */   
/*     */   public boolean isWritable(int i) {
/* 224 */     return this.a.isWritable(i);
/*     */   }
/*     */   
/*     */   public ByteBuf clear() {
/* 228 */     return this.a.clear();
/*     */   }
/*     */   
/*     */   public ByteBuf markReaderIndex() {
/* 232 */     return this.a.markReaderIndex();
/*     */   }
/*     */   
/*     */   public ByteBuf resetReaderIndex() {
/* 236 */     return this.a.resetReaderIndex();
/*     */   }
/*     */   
/*     */   public ByteBuf markWriterIndex() {
/* 240 */     return this.a.markWriterIndex();
/*     */   }
/*     */   
/*     */   public ByteBuf resetWriterIndex() {
/* 244 */     return this.a.resetWriterIndex();
/*     */   }
/*     */   
/*     */   public ByteBuf discardReadBytes() {
/* 248 */     return this.a.discardReadBytes();
/*     */   }
/*     */   
/*     */   public ByteBuf discardSomeReadBytes() {
/* 252 */     return this.a.discardSomeReadBytes();
/*     */   }
/*     */   
/*     */   public ByteBuf ensureWritable(int i) {
/* 256 */     return this.a.ensureWritable(i);
/*     */   }
/*     */   
/*     */   public int ensureWritable(int i, boolean flag) {
/* 260 */     return this.a.ensureWritable(i, flag);
/*     */   }
/*     */   
/*     */   public boolean getBoolean(int i) {
/* 264 */     return this.a.getBoolean(i);
/*     */   }
/*     */   
/*     */   public byte getByte(int i) {
/* 268 */     return this.a.getByte(i);
/*     */   }
/*     */   
/*     */   public short getUnsignedByte(int i) {
/* 272 */     return this.a.getUnsignedByte(i);
/*     */   }
/*     */   
/*     */   public short getShort(int i) {
/* 276 */     return this.a.getShort(i);
/*     */   }
/*     */   
/*     */   public int getUnsignedShort(int i) {
/* 280 */     return this.a.getUnsignedShort(i);
/*     */   }
/*     */   
/*     */   public int getMedium(int i) {
/* 284 */     return this.a.getMedium(i);
/*     */   }
/*     */   
/*     */   public int getUnsignedMedium(int i) {
/* 288 */     return this.a.getUnsignedMedium(i);
/*     */   }
/*     */   
/*     */   public int getInt(int i) {
/* 292 */     return this.a.getInt(i);
/*     */   }
/*     */   
/*     */   public long getUnsignedInt(int i) {
/* 296 */     return this.a.getUnsignedInt(i);
/*     */   }
/*     */   
/*     */   public long getLong(int i) {
/* 300 */     return this.a.getLong(i);
/*     */   }
/*     */   
/*     */   public char getChar(int i) {
/* 304 */     return this.a.getChar(i);
/*     */   }
/*     */   
/*     */   public float getFloat(int i) {
/* 308 */     return this.a.getFloat(i);
/*     */   }
/*     */   
/*     */   public double getDouble(int i) {
/* 312 */     return this.a.getDouble(i);
/*     */   }
/*     */   
/*     */   public ByteBuf getBytes(int i, ByteBuf bytebuf) {
/* 316 */     return this.a.getBytes(i, bytebuf);
/*     */   }
/*     */   
/*     */   public ByteBuf getBytes(int i, ByteBuf bytebuf, int j) {
/* 320 */     return this.a.getBytes(i, bytebuf, j);
/*     */   }
/*     */   
/*     */   public ByteBuf getBytes(int i, ByteBuf bytebuf, int j, int k) {
/* 324 */     return this.a.getBytes(i, bytebuf, j, k);
/*     */   }
/*     */   
/*     */   public ByteBuf getBytes(int i, byte[] abyte) {
/* 328 */     return this.a.getBytes(i, abyte);
/*     */   }
/*     */   
/*     */   public ByteBuf getBytes(int i, byte[] abyte, int j, int k) {
/* 332 */     return this.a.getBytes(i, abyte, j, k);
/*     */   }
/*     */   
/*     */   public ByteBuf getBytes(int i, ByteBuffer bytebuffer) {
/* 336 */     return this.a.getBytes(i, bytebuffer);
/*     */   }
/*     */   
/*     */   public ByteBuf getBytes(int i, OutputStream outputstream, int j) throws IOException {
/* 340 */     return this.a.getBytes(i, outputstream, j);
/*     */   }
/*     */   
/*     */   public int getBytes(int i, GatheringByteChannel gatheringbytechannel, int j) throws IOException {
/* 344 */     return this.a.getBytes(i, gatheringbytechannel, j);
/*     */   }
/*     */   
/*     */   public ByteBuf setBoolean(int i, boolean flag) {
/* 348 */     return this.a.setBoolean(i, flag);
/*     */   }
/*     */   
/*     */   public ByteBuf setByte(int i, int j) {
/* 352 */     return this.a.setByte(i, j);
/*     */   }
/*     */   
/*     */   public ByteBuf setShort(int i, int j) {
/* 356 */     return this.a.setShort(i, j);
/*     */   }
/*     */   
/*     */   public ByteBuf setMedium(int i, int j) {
/* 360 */     return this.a.setMedium(i, j);
/*     */   }
/*     */   
/*     */   public ByteBuf setInt(int i, int j) {
/* 364 */     return this.a.setInt(i, j);
/*     */   }
/*     */   
/*     */   public ByteBuf setLong(int i, long j) {
/* 368 */     return this.a.setLong(i, j);
/*     */   }
/*     */   
/*     */   public ByteBuf setChar(int i, int j) {
/* 372 */     return this.a.setChar(i, j);
/*     */   }
/*     */   
/*     */   public ByteBuf setFloat(int i, float f) {
/* 376 */     return this.a.setFloat(i, f);
/*     */   }
/*     */   
/*     */   public ByteBuf setDouble(int i, double d0) {
/* 380 */     return this.a.setDouble(i, d0);
/*     */   }
/*     */   
/*     */   public ByteBuf setBytes(int i, ByteBuf bytebuf) {
/* 384 */     return this.a.setBytes(i, bytebuf);
/*     */   }
/*     */   
/*     */   public ByteBuf setBytes(int i, ByteBuf bytebuf, int j) {
/* 388 */     return this.a.setBytes(i, bytebuf, j);
/*     */   }
/*     */   
/*     */   public ByteBuf setBytes(int i, ByteBuf bytebuf, int j, int k) {
/* 392 */     return this.a.setBytes(i, bytebuf, j, k);
/*     */   }
/*     */   
/*     */   public ByteBuf setBytes(int i, byte[] abyte) {
/* 396 */     return this.a.setBytes(i, abyte);
/*     */   }
/*     */   
/*     */   public ByteBuf setBytes(int i, byte[] abyte, int j, int k) {
/* 400 */     return this.a.setBytes(i, abyte, j, k);
/*     */   }
/*     */   
/*     */   public ByteBuf setBytes(int i, ByteBuffer bytebuffer) {
/* 404 */     return this.a.setBytes(i, bytebuffer);
/*     */   }
/*     */   
/*     */   public int setBytes(int i, InputStream inputstream, int j) throws IOException {
/* 408 */     return this.a.setBytes(i, inputstream, j);
/*     */   }
/*     */   
/*     */   public int setBytes(int i, ScatteringByteChannel scatteringbytechannel, int j) throws IOException {
/* 412 */     return this.a.setBytes(i, scatteringbytechannel, j);
/*     */   }
/*     */   
/*     */   public ByteBuf setZero(int i, int j) {
/* 416 */     return this.a.setZero(i, j);
/*     */   }
/*     */   
/*     */   public boolean readBoolean() {
/* 420 */     return this.a.readBoolean();
/*     */   }
/*     */   
/*     */   public byte readByte() {
/* 424 */     return this.a.readByte();
/*     */   }
/*     */   
/*     */   public short readUnsignedByte() {
/* 428 */     return this.a.readUnsignedByte();
/*     */   }
/*     */   
/*     */   public short readShort() {
/* 432 */     return this.a.readShort();
/*     */   }
/*     */   
/*     */   public int readUnsignedShort() {
/* 436 */     return this.a.readUnsignedShort();
/*     */   }
/*     */   
/*     */   public int readMedium() {
/* 440 */     return this.a.readMedium();
/*     */   }
/*     */   
/*     */   public int readUnsignedMedium() {
/* 444 */     return this.a.readUnsignedMedium();
/*     */   }
/*     */   
/*     */   public int readInt() {
/* 448 */     return this.a.readInt();
/*     */   }
/*     */   
/*     */   public long readUnsignedInt() {
/* 452 */     return this.a.readUnsignedInt();
/*     */   }
/*     */   
/*     */   public long readLong() {
/* 456 */     return this.a.readLong();
/*     */   }
/*     */   
/*     */   public char readChar() {
/* 460 */     return this.a.readChar();
/*     */   }
/*     */   
/*     */   public float readFloat() {
/* 464 */     return this.a.readFloat();
/*     */   }
/*     */   
/*     */   public double readDouble() {
/* 468 */     return this.a.readDouble();
/*     */   }
/*     */   
/*     */   public ByteBuf readBytes(int i) {
/* 472 */     return this.a.readBytes(i);
/*     */   }
/*     */   
/*     */   public ByteBuf readSlice(int i) {
/* 476 */     return this.a.readSlice(i);
/*     */   }
/*     */   
/*     */   public ByteBuf readBytes(ByteBuf bytebuf) {
/* 480 */     return this.a.readBytes(bytebuf);
/*     */   }
/*     */   
/*     */   public ByteBuf readBytes(ByteBuf bytebuf, int i) {
/* 484 */     return this.a.readBytes(bytebuf, i);
/*     */   }
/*     */   
/*     */   public ByteBuf readBytes(ByteBuf bytebuf, int i, int j) {
/* 488 */     return this.a.readBytes(bytebuf, i, j);
/*     */   }
/*     */   
/*     */   public ByteBuf readBytes(byte[] abyte) {
/* 492 */     return this.a.readBytes(abyte);
/*     */   }
/*     */   
/*     */   public ByteBuf readBytes(byte[] abyte, int i, int j) {
/* 496 */     return this.a.readBytes(abyte, i, j);
/*     */   }
/*     */   
/*     */   public ByteBuf readBytes(ByteBuffer bytebuffer) {
/* 500 */     return this.a.readBytes(bytebuffer);
/*     */   }
/*     */   
/*     */   public ByteBuf readBytes(OutputStream outputstream, int i) throws IOException {
/* 504 */     return this.a.readBytes(outputstream, i);
/*     */   }
/*     */   
/*     */   public int readBytes(GatheringByteChannel gatheringbytechannel, int i) throws IOException {
/* 508 */     return this.a.readBytes(gatheringbytechannel, i);
/*     */   }
/*     */   
/*     */   public ByteBuf skipBytes(int i) {
/* 512 */     return this.a.skipBytes(i);
/*     */   }
/*     */   
/*     */   public ByteBuf writeBoolean(boolean flag) {
/* 516 */     return this.a.writeBoolean(flag);
/*     */   }
/*     */   
/*     */   public ByteBuf writeByte(int i) {
/* 520 */     return this.a.writeByte(i);
/*     */   }
/*     */   
/*     */   public ByteBuf writeShort(int i) {
/* 524 */     return this.a.writeShort(i);
/*     */   }
/*     */   
/*     */   public ByteBuf writeMedium(int i) {
/* 528 */     return this.a.writeMedium(i);
/*     */   }
/*     */   
/*     */   public ByteBuf writeInt(int i) {
/* 532 */     return this.a.writeInt(i);
/*     */   }
/*     */   
/*     */   public ByteBuf writeLong(long i) {
/* 536 */     return this.a.writeLong(i);
/*     */   }
/*     */   
/*     */   public ByteBuf writeChar(int i) {
/* 540 */     return this.a.writeChar(i);
/*     */   }
/*     */   
/*     */   public ByteBuf writeFloat(float f) {
/* 544 */     return this.a.writeFloat(f);
/*     */   }
/*     */   
/*     */   public ByteBuf writeDouble(double d0) {
/* 548 */     return this.a.writeDouble(d0);
/*     */   }
/*     */   
/*     */   public ByteBuf writeBytes(ByteBuf bytebuf) {
/* 552 */     return this.a.writeBytes(bytebuf);
/*     */   }
/*     */   
/*     */   public ByteBuf writeBytes(ByteBuf bytebuf, int i) {
/* 556 */     return this.a.writeBytes(bytebuf, i);
/*     */   }
/*     */   
/*     */   public ByteBuf writeBytes(ByteBuf bytebuf, int i, int j) {
/* 560 */     return this.a.writeBytes(bytebuf, i, j);
/*     */   }
/*     */   
/*     */   public ByteBuf writeBytes(byte[] abyte) {
/* 564 */     return this.a.writeBytes(abyte);
/*     */   }
/*     */   
/*     */   public ByteBuf writeBytes(byte[] abyte, int i, int j) {
/* 568 */     return this.a.writeBytes(abyte, i, j);
/*     */   }
/*     */   
/*     */   public ByteBuf writeBytes(ByteBuffer bytebuffer) {
/* 572 */     return this.a.writeBytes(bytebuffer);
/*     */   }
/*     */   
/*     */   public int writeBytes(InputStream inputstream, int i) throws IOException {
/* 576 */     return this.a.writeBytes(inputstream, i);
/*     */   }
/*     */   
/*     */   public int writeBytes(ScatteringByteChannel scatteringbytechannel, int i) throws IOException {
/* 580 */     return this.a.writeBytes(scatteringbytechannel, i);
/*     */   }
/*     */   
/*     */   public ByteBuf writeZero(int i) {
/* 584 */     return this.a.writeZero(i);
/*     */   }
/*     */   
/*     */   public int indexOf(int i, int j, byte b0) {
/* 588 */     return this.a.indexOf(i, j, b0);
/*     */   }
/*     */   
/*     */   public int bytesBefore(byte b0) {
/* 592 */     return this.a.bytesBefore(b0);
/*     */   }
/*     */   
/*     */   public int bytesBefore(int i, byte b0) {
/* 596 */     return this.a.bytesBefore(i, b0);
/*     */   }
/*     */   
/*     */   public int bytesBefore(int i, int j, byte b0) {
/* 600 */     return this.a.bytesBefore(i, j, b0);
/*     */   }
/*     */   
/*     */   public int forEachByte(ByteBufProcessor bytebufprocessor) {
/* 604 */     return this.a.forEachByte(bytebufprocessor);
/*     */   }
/*     */   
/*     */   public int forEachByte(int i, int j, ByteBufProcessor bytebufprocessor) {
/* 608 */     return this.a.forEachByte(i, j, bytebufprocessor);
/*     */   }
/*     */   
/*     */   public int forEachByteDesc(ByteBufProcessor bytebufprocessor) {
/* 612 */     return this.a.forEachByteDesc(bytebufprocessor);
/*     */   }
/*     */   
/*     */   public int forEachByteDesc(int i, int j, ByteBufProcessor bytebufprocessor) {
/* 616 */     return this.a.forEachByteDesc(i, j, bytebufprocessor);
/*     */   }
/*     */   
/*     */   public ByteBuf copy() {
/* 620 */     return this.a.copy();
/*     */   }
/*     */   
/*     */   public ByteBuf copy(int i, int j) {
/* 624 */     return this.a.copy(i, j);
/*     */   }
/*     */   
/*     */   public ByteBuf slice() {
/* 628 */     return this.a.slice();
/*     */   }
/*     */   
/*     */   public ByteBuf slice(int i, int j) {
/* 632 */     return this.a.slice(i, j);
/*     */   }
/*     */   
/*     */   public ByteBuf duplicate() {
/* 636 */     return this.a.duplicate();
/*     */   }
/*     */   
/*     */   public int nioBufferCount() {
/* 640 */     return this.a.nioBufferCount();
/*     */   }
/*     */   
/*     */   public ByteBuffer nioBuffer() {
/* 644 */     return this.a.nioBuffer();
/*     */   }
/*     */   
/*     */   public ByteBuffer nioBuffer(int i, int j) {
/* 648 */     return this.a.nioBuffer(i, j);
/*     */   }
/*     */   
/*     */   public ByteBuffer internalNioBuffer(int i, int j) {
/* 652 */     return this.a.internalNioBuffer(i, j);
/*     */   }
/*     */   
/*     */   public ByteBuffer[] nioBuffers() {
/* 656 */     return this.a.nioBuffers();
/*     */   }
/*     */   
/*     */   public ByteBuffer[] nioBuffers(int i, int j) {
/* 660 */     return this.a.nioBuffers(i, j);
/*     */   }
/*     */   
/*     */   public boolean hasArray() {
/* 664 */     return this.a.hasArray();
/*     */   }
/*     */   
/*     */   public byte[] array() {
/* 668 */     return this.a.array();
/*     */   }
/*     */   
/*     */   public int arrayOffset() {
/* 672 */     return this.a.arrayOffset();
/*     */   }
/*     */   
/*     */   public boolean hasMemoryAddress() {
/* 676 */     return this.a.hasMemoryAddress();
/*     */   }
/*     */   
/*     */   public long memoryAddress() {
/* 680 */     return this.a.memoryAddress();
/*     */   }
/*     */   
/*     */   public String toString(Charset charset) {
/* 684 */     return this.a.toString(charset);
/*     */   }
/*     */   
/*     */   public String toString(int i, int j, Charset charset) {
/* 688 */     return this.a.toString(i, j, charset);
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 692 */     return this.a.hashCode();
/*     */   }
/*     */   
/*     */   public boolean equals(Object object) {
/* 696 */     return this.a.equals(object);
/*     */   }
/*     */   
/*     */   public int compareTo(ByteBuf bytebuf) {
/* 700 */     return this.a.compareTo(bytebuf);
/*     */   }
/*     */   
/*     */   public String toString() {
/* 704 */     return this.a.toString();
/*     */   }
/*     */   
/*     */   public ByteBuf retain(int i) {
/* 708 */     return this.a.retain(i);
/*     */   }
/*     */   
/*     */   public ByteBuf retain() {
/* 712 */     return this.a.retain();
/*     */   }
/*     */   
/*     */   public int refCnt() {
/* 716 */     return this.a.refCnt();
/*     */   }
/*     */   
/*     */   public boolean release() {
/* 720 */     return this.a.release();
/*     */   }
/*     */   
/*     */   public boolean release(int i) {
/* 724 */     return this.a.release(i);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketDataSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */