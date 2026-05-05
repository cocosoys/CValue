/*     */ package cpw.mods.fml.common.network;
/*     */ 
/*     */ import com.google.common.base.Charsets;
/*     */ import com.google.common.base.Throwables;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.io.IOException;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.PacketBuffer;
/*     */ import org.apache.commons.lang3.Validate;
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
/*     */ public class ByteBufUtils
/*     */ {
/*     */   public static int varIntByteCount(int toCount) {
/*  28 */     return ((toCount & 0xFFFFFF80) == 0) ? 1 : (((toCount & 0xFFFFC000) == 0) ? 2 : (((toCount & 0xFFE00000) == 0) ? 3 : (((toCount & 0xF0000000) == 0) ? 4 : 5)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int readVarInt(ByteBuf buf, int maxSize) {
/*     */     byte b0;
/*  39 */     Validate.isTrue((maxSize < 6 && maxSize > 0), "Varint length is between 1 and 5, not %d", maxSize);
/*  40 */     int i = 0;
/*  41 */     int j = 0;
/*     */ 
/*     */ 
/*     */     
/*     */     do {
/*  46 */       b0 = buf.readByte();
/*  47 */       i |= (b0 & Byte.MAX_VALUE) << j++ * 7;
/*     */       
/*  49 */       if (j > maxSize)
/*     */       {
/*  51 */         throw new RuntimeException("VarInt too big");
/*     */       }
/*     */     }
/*  54 */     while ((b0 & 0x80) == 128);
/*     */     
/*  56 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int readVarShort(ByteBuf buf) {
/*  66 */     int low = buf.readUnsignedShort();
/*  67 */     int high = 0;
/*  68 */     if ((low & 0x8000) != 0) {
/*     */       
/*  70 */       low &= 0x7FFF;
/*  71 */       high = buf.readUnsignedByte();
/*     */     } 
/*  73 */     return (high & 0xFF) << 15 | low;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void writeVarShort(ByteBuf buf, int toWrite) {
/*  78 */     int low = toWrite & 0x7FFF;
/*  79 */     int high = (toWrite & 0x7F8000) >> 15;
/*  80 */     if (high != 0)
/*     */     {
/*  82 */       low |= 0x8000;
/*     */     }
/*  84 */     buf.writeShort(low);
/*  85 */     if (high != 0)
/*     */     {
/*  87 */       buf.writeByte(high);
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
/*     */   public static void writeVarInt(ByteBuf to, int toWrite, int maxSize) {
/* 100 */     Validate.isTrue((varIntByteCount(toWrite) <= maxSize), "Integer is too big for %d bytes", maxSize);
/* 101 */     while ((toWrite & 0xFFFFFF80) != 0) {
/*     */       
/* 103 */       to.writeByte(toWrite & 0x7F | 0x80);
/* 104 */       toWrite >>>= 7;
/*     */     } 
/*     */     
/* 107 */     to.writeByte(toWrite);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String readUTF8String(ByteBuf from) {
/* 118 */     int len = readVarInt(from, 2);
/* 119 */     String str = from.toString(from.readerIndex(), len, Charsets.UTF_8);
/* 120 */     from.readerIndex(from.readerIndex() + len);
/* 121 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void writeUTF8String(ByteBuf to, String string) {
/* 132 */     byte[] utf8Bytes = string.getBytes(Charsets.UTF_8);
/* 133 */     Validate.isTrue((varIntByteCount(utf8Bytes.length) < 3), "The string is too long for this encoding.", new Object[0]);
/* 134 */     writeVarInt(to, utf8Bytes.length, 2);
/* 135 */     to.writeBytes(utf8Bytes);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void writeItemStack(ByteBuf to, ItemStack stack) {
/* 146 */     PacketBuffer pb = new PacketBuffer(to);
/*     */     
/*     */     try {
/* 149 */       pb.writeItemStackToBuffer(stack);
/* 150 */     } catch (IOException e) {
/*     */ 
/*     */       
/* 153 */       throw Throwables.propagate(e);
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
/*     */   public static ItemStack readItemStack(ByteBuf from) {
/* 165 */     PacketBuffer pb = new PacketBuffer(from);
/*     */     
/*     */     try {
/* 168 */       return pb.readItemStackFromBuffer();
/* 169 */     } catch (IOException e) {
/*     */ 
/*     */       
/* 172 */       throw Throwables.propagate(e);
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
/*     */   public static void writeTag(ByteBuf to, NBTTagCompound tag) {
/* 184 */     PacketBuffer pb = new PacketBuffer(to);
/*     */     
/*     */     try {
/* 187 */       pb.writeNBTTagCompoundToBuffer(tag);
/* 188 */     } catch (IOException e) {
/*     */ 
/*     */       
/* 191 */       throw Throwables.propagate(e);
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
/*     */   public static NBTTagCompound readTag(ByteBuf from) {
/* 203 */     PacketBuffer pb = new PacketBuffer(from);
/*     */     
/*     */     try {
/* 206 */       return pb.readNBTTagCompoundFromBuffer();
/* 207 */     } catch (IOException e) {
/*     */ 
/*     */       
/* 210 */       throw Throwables.propagate(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getContentDump(ByteBuf buffer) {
/* 216 */     int j, currentLength = buffer.readableBytes();
/* 217 */     StringBuffer returnString = new StringBuffer(currentLength * 3 + currentLength + currentLength / 4 + 30);
/*     */ 
/*     */ 
/*     */     
/*     */     int i;
/*     */ 
/*     */ 
/*     */     
/* 225 */     for (i = 0; i < currentLength; i++) {
/*     */       
/* 227 */       if (i != 0 && i % 16 == 0) {
/*     */ 
/*     */         
/* 230 */         returnString.append('\t');
/* 231 */         for (j = i - 16; j < i; j++) {
/*     */           
/* 233 */           if (buffer.getByte(j) < 32 || buffer.getByte(j) > Byte.MAX_VALUE) {
/* 234 */             returnString.append('.');
/*     */           } else {
/* 236 */             returnString.append((char)buffer.getByte(j));
/*     */           } 
/*     */         } 
/* 239 */         returnString.append("\n");
/*     */       } 
/*     */       
/* 242 */       returnString.append(Integer.toString((buffer.getByte(i) & 0xF0) >> 4, 16) + Integer.toString((buffer.getByte(i) & 0xF) >> 0, 16));
/* 243 */       returnString.append(' ');
/*     */     } 
/*     */ 
/*     */     
/* 247 */     if (i != 0 && i % 16 != 0)
/*     */     {
/* 249 */       for (j = 0; j < (16 - i % 16) * 3; j++)
/*     */       {
/* 251 */         returnString.append(' ');
/*     */       }
/*     */     }
/*     */     
/* 255 */     returnString.append('\t');
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 260 */     if (i > 0 && i % 16 == 0) {
/*     */       
/* 262 */       j = i - 16;
/*     */     } else {
/*     */       
/* 265 */       j = i - i % 16;
/*     */     } 
/*     */     
/* 268 */     for (; i >= 0 && j < i; j++) {
/*     */       
/* 270 */       if (buffer.getByte(j) < 32 || buffer.getByte(j) > Byte.MAX_VALUE) {
/* 271 */         returnString.append('.');
/*     */       } else {
/* 273 */         returnString.append((char)buffer.getByte(j));
/*     */       } 
/*     */     } 
/*     */     
/* 277 */     returnString.append('\n');
/* 278 */     returnString.append("Length: " + currentLength);
/*     */     
/* 280 */     return returnString.toString();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\network\ByteBufUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */