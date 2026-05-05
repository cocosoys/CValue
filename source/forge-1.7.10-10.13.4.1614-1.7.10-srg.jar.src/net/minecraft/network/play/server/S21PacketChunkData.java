/*     */ package net.minecraft.network.play.server;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.IOException;
/*     */ import java.util.zip.DataFormatException;
/*     */ import java.util.zip.Deflater;
/*     */ import java.util.zip.Inflater;
/*     */ import net.minecraft.network.INetHandler;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.PacketBuffer;
/*     */ import net.minecraft.network.play.INetHandlerPlayClient;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ import net.minecraft.world.chunk.NibbleArray;
/*     */ import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
/*     */ 
/*     */ public class S21PacketChunkData
/*     */   extends Packet {
/*     */   private int field_149284_a;
/*     */   private int field_149282_b;
/*     */   private int field_149283_c;
/*     */   private int field_149280_d;
/*     */   private byte[] field_149281_e;
/*     */   private byte[] field_149278_f;
/*     */   private boolean field_149279_g;
/*     */   private int field_149285_h;
/*  27 */   private static byte[] field_149286_i = new byte[196864];
/*     */   
/*     */   private static final String __OBFID = "CL_00001304";
/*     */   
/*     */   public S21PacketChunkData() {}
/*     */   
/*     */   public S21PacketChunkData(Chunk p_i45196_1_, boolean p_i45196_2_, int p_i45196_3_) {
/*  34 */     this.field_149284_a = p_i45196_1_.field_76635_g;
/*  35 */     this.field_149282_b = p_i45196_1_.field_76647_h;
/*  36 */     this.field_149279_g = p_i45196_2_;
/*     */     
/*  38 */     Extracted extracted = func_149269_a(p_i45196_1_, p_i45196_2_, p_i45196_3_);
/*  39 */     Deflater deflater = new Deflater(-1);
/*  40 */     this.field_149280_d = extracted.field_150281_c;
/*  41 */     this.field_149283_c = extracted.field_150280_b;
/*     */     
/*     */     try {
/*  44 */       this.field_149278_f = extracted.field_150282_a;
/*  45 */       deflater.setInput(extracted.field_150282_a, 0, extracted.field_150282_a.length);
/*  46 */       deflater.finish();
/*  47 */       this.field_149281_e = new byte[extracted.field_150282_a.length];
/*  48 */       this.field_149285_h = deflater.deflate(this.field_149281_e);
/*     */     } finally {
/*  50 */       deflater.end();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static int func_149275_c() {
/*  55 */     return 196864;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/*  60 */     this.field_149284_a = p_148837_1_.readInt();
/*  61 */     this.field_149282_b = p_148837_1_.readInt();
/*  62 */     this.field_149279_g = p_148837_1_.readBoolean();
/*  63 */     this.field_149283_c = p_148837_1_.readShort();
/*  64 */     this.field_149280_d = p_148837_1_.readShort();
/*     */     
/*  66 */     this.field_149285_h = p_148837_1_.readInt();
/*  67 */     if (field_149286_i.length < this.field_149285_h) {
/*  68 */       field_149286_i = new byte[this.field_149285_h];
/*     */     }
/*  70 */     p_148837_1_.readBytes(field_149286_i, 0, this.field_149285_h);
/*     */     
/*  72 */     int i = 0; int j;
/*  73 */     for (j = 0; j < 16; j++) {
/*  74 */       i += this.field_149283_c >> j & 0x1;
/*     */     }
/*  76 */     j = 12288 * i;
/*  77 */     if (this.field_149279_g) {
/*  78 */       j += 256;
/*     */     }
/*     */     
/*  81 */     this.field_149278_f = new byte[j];
/*     */     
/*  83 */     Inflater inflater = new Inflater();
/*  84 */     inflater.setInput(field_149286_i, 0, this.field_149285_h);
/*     */     try {
/*  86 */       inflater.inflate(this.field_149278_f);
/*  87 */     } catch (DataFormatException dataFormatException) {
/*  88 */       throw new IOException("Bad compressed data format");
/*     */     } finally {
/*  90 */       inflater.end();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/*  96 */     p_148840_1_.writeInt(this.field_149284_a);
/*  97 */     p_148840_1_.writeInt(this.field_149282_b);
/*  98 */     p_148840_1_.writeBoolean(this.field_149279_g);
/*  99 */     p_148840_1_.writeShort((short)(this.field_149283_c & 0xFFFF));
/* 100 */     p_148840_1_.writeShort((short)(this.field_149280_d & 0xFFFF));
/*     */     
/* 102 */     p_148840_1_.writeInt(this.field_149285_h);
/* 103 */     p_148840_1_.writeBytes(this.field_149281_e, 0, this.field_149285_h);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 108 */     p_148833_1_.func_147263_a(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_148835_b() {
/* 113 */     return String.format("x=%d, z=%d, full=%b, sects=%d, add=%d, size=%d", new Object[] { Integer.valueOf(this.field_149284_a), Integer.valueOf(this.field_149282_b), Boolean.valueOf(this.field_149279_g), Integer.valueOf(this.field_149283_c), Integer.valueOf(this.field_149280_d), Integer.valueOf(this.field_149285_h) });
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public byte[] func_149272_d() {
/* 117 */     return this.field_149278_f;
/*     */   }
/*     */   
/*     */   public static Extracted func_149269_a(Chunk p_149269_0_, boolean p_149269_1_, int p_149269_2_) {
/* 121 */     int i = 0;
/* 122 */     ExtendedBlockStorage[] arrayOfExtendedBlockStorage = p_149269_0_.func_76587_i();
/* 123 */     byte b1 = 0;
/* 124 */     Extracted extracted = new Extracted();
/* 125 */     byte[] arrayOfByte = field_149286_i;
/*     */     
/* 127 */     if (p_149269_1_) {
/* 128 */       p_149269_0_.field_76642_o = true;
/*     */     }
/*     */     byte b2;
/* 131 */     for (b2 = 0; b2 < arrayOfExtendedBlockStorage.length; b2++) {
/* 132 */       if (arrayOfExtendedBlockStorage[b2] != null && (!p_149269_1_ || !arrayOfExtendedBlockStorage[b2].func_76663_a()) && (p_149269_2_ & 1 << b2) != 0) {
/* 133 */         extracted.field_150280_b |= 1 << b2;
/*     */         
/* 135 */         if (arrayOfExtendedBlockStorage[b2].func_76660_i() != null) {
/* 136 */           extracted.field_150281_c |= 1 << b2;
/* 137 */           b1++;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 144 */     for (b2 = 0; b2 < arrayOfExtendedBlockStorage.length; b2++) {
/* 145 */       if (arrayOfExtendedBlockStorage[b2] != null && (!p_149269_1_ || !arrayOfExtendedBlockStorage[b2].func_76663_a()) && (p_149269_2_ & 1 << b2) != 0) {
/* 146 */         byte[] arrayOfByte1 = arrayOfExtendedBlockStorage[b2].func_76658_g();
/* 147 */         System.arraycopy(arrayOfByte1, 0, arrayOfByte, i, arrayOfByte1.length);
/* 148 */         i += arrayOfByte1.length;
/*     */       } 
/*     */     } 
/* 151 */     for (b2 = 0; b2 < arrayOfExtendedBlockStorage.length; b2++) {
/* 152 */       if (arrayOfExtendedBlockStorage[b2] != null && (!p_149269_1_ || !arrayOfExtendedBlockStorage[b2].func_76663_a()) && (p_149269_2_ & 1 << b2) != 0) {
/* 153 */         NibbleArray nibbleArray = arrayOfExtendedBlockStorage[b2].func_76669_j();
/* 154 */         System.arraycopy(nibbleArray.field_76585_a, 0, arrayOfByte, i, nibbleArray.field_76585_a.length);
/* 155 */         i += nibbleArray.field_76585_a.length;
/*     */       } 
/*     */     } 
/* 158 */     for (b2 = 0; b2 < arrayOfExtendedBlockStorage.length; b2++) {
/* 159 */       if (arrayOfExtendedBlockStorage[b2] != null && (!p_149269_1_ || !arrayOfExtendedBlockStorage[b2].func_76663_a()) && (p_149269_2_ & 1 << b2) != 0) {
/* 160 */         NibbleArray nibbleArray = arrayOfExtendedBlockStorage[b2].func_76661_k();
/* 161 */         System.arraycopy(nibbleArray.field_76585_a, 0, arrayOfByte, i, nibbleArray.field_76585_a.length);
/* 162 */         i += nibbleArray.field_76585_a.length;
/*     */       } 
/*     */     } 
/* 165 */     if (!p_149269_0_.field_76637_e.field_73011_w.field_76576_e) {
/* 166 */       for (b2 = 0; b2 < arrayOfExtendedBlockStorage.length; b2++) {
/* 167 */         if (arrayOfExtendedBlockStorage[b2] != null && (!p_149269_1_ || !arrayOfExtendedBlockStorage[b2].func_76663_a()) && (p_149269_2_ & 1 << b2) != 0) {
/* 168 */           NibbleArray nibbleArray = arrayOfExtendedBlockStorage[b2].func_76671_l();
/* 169 */           System.arraycopy(nibbleArray.field_76585_a, 0, arrayOfByte, i, nibbleArray.field_76585_a.length);
/* 170 */           i += nibbleArray.field_76585_a.length;
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 175 */     if (b1 > 0) {
/* 176 */       for (b2 = 0; b2 < arrayOfExtendedBlockStorage.length; b2++) {
/* 177 */         if (arrayOfExtendedBlockStorage[b2] != null && (!p_149269_1_ || !arrayOfExtendedBlockStorage[b2].func_76663_a()) && arrayOfExtendedBlockStorage[b2].func_76660_i() != null && (p_149269_2_ & 1 << b2) != 0) {
/* 178 */           NibbleArray nibbleArray = arrayOfExtendedBlockStorage[b2].func_76660_i();
/* 179 */           System.arraycopy(nibbleArray.field_76585_a, 0, arrayOfByte, i, nibbleArray.field_76585_a.length);
/* 180 */           i += nibbleArray.field_76585_a.length;
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 185 */     if (p_149269_1_) {
/* 186 */       byte[] arrayOfByte1 = p_149269_0_.func_76605_m();
/* 187 */       System.arraycopy(arrayOfByte1, 0, arrayOfByte, i, arrayOfByte1.length);
/* 188 */       i += arrayOfByte1.length;
/*     */     } 
/*     */     
/* 191 */     extracted.field_150282_a = new byte[i];
/* 192 */     System.arraycopy(arrayOfByte, 0, extracted.field_150282_a, 0, i);
/*     */     
/* 194 */     return extracted;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149273_e() {
/* 198 */     return this.field_149284_a;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149271_f() {
/* 202 */     return this.field_149282_b;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149276_g() {
/* 206 */     return this.field_149283_c;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149270_h() {
/* 210 */     return this.field_149280_d;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149274_i() {
/* 214 */     return this.field_149279_g;
/*     */   }
/*     */   
/*     */   public static class Extracted {
/*     */     public byte[] field_150282_a;
/*     */     public int field_150280_b;
/*     */     public int field_150281_c;
/*     */     private static final String __OBFID = "CL_00001305";
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S21PacketChunkData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */