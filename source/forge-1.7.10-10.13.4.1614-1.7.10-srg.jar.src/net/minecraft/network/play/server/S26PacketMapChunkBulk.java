/*     */ package net.minecraft.network.play.server;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import java.util.zip.DataFormatException;
/*     */ import java.util.zip.Deflater;
/*     */ import java.util.zip.Inflater;
/*     */ import net.minecraft.network.INetHandler;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.PacketBuffer;
/*     */ import net.minecraft.network.play.INetHandlerPlayClient;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ 
/*     */ public class S26PacketMapChunkBulk
/*     */   extends Packet
/*     */ {
/*     */   private int[] field_149266_a;
/*     */   private int[] field_149264_b;
/*     */   private int[] field_149265_c;
/*     */   private int[] field_149262_d;
/*  23 */   private static byte[] field_149268_i = new byte[0]; private byte[] field_149263_e; private byte[][] field_149260_f;
/*     */   private int field_149261_g;
/*     */   private boolean field_149267_h;
/*     */   private static final String __OBFID = "CL_00001306";
/*     */   
/*     */   public S26PacketMapChunkBulk() {}
/*     */   
/*     */   public S26PacketMapChunkBulk(List<Chunk> p_i45197_1_) {
/*  31 */     int i = p_i45197_1_.size();
/*     */     
/*  33 */     this.field_149266_a = new int[i];
/*  34 */     this.field_149264_b = new int[i];
/*  35 */     this.field_149265_c = new int[i];
/*  36 */     this.field_149262_d = new int[i];
/*  37 */     this.field_149260_f = new byte[i][];
/*  38 */     this.field_149267_h = (!p_i45197_1_.isEmpty() && !((Chunk)p_i45197_1_.get(0)).field_76637_e.field_73011_w.field_76576_e);
/*     */     
/*  40 */     int j = 0;
/*     */     
/*  42 */     for (byte b = 0; b < i; b++) {
/*  43 */       Chunk chunk = p_i45197_1_.get(b);
/*  44 */       S21PacketChunkData.Extracted extracted = S21PacketChunkData.func_149269_a(chunk, true, 65535);
/*     */       
/*  46 */       if (field_149268_i.length < j + extracted.field_150282_a.length) {
/*  47 */         byte[] arrayOfByte = new byte[j + extracted.field_150282_a.length];
/*  48 */         System.arraycopy(field_149268_i, 0, arrayOfByte, 0, field_149268_i.length);
/*  49 */         field_149268_i = arrayOfByte;
/*     */       } 
/*     */       
/*  52 */       System.arraycopy(extracted.field_150282_a, 0, field_149268_i, j, extracted.field_150282_a.length);
/*  53 */       j += extracted.field_150282_a.length;
/*     */       
/*  55 */       this.field_149266_a[b] = chunk.field_76635_g;
/*  56 */       this.field_149264_b[b] = chunk.field_76647_h;
/*  57 */       this.field_149265_c[b] = extracted.field_150280_b;
/*  58 */       this.field_149262_d[b] = extracted.field_150281_c;
/*  59 */       this.field_149260_f[b] = extracted.field_150282_a;
/*     */     } 
/*     */     
/*  62 */     Deflater deflater = new Deflater(-1);
/*     */     
/*     */     try {
/*  65 */       deflater.setInput(field_149268_i, 0, j);
/*  66 */       deflater.finish();
/*  67 */       this.field_149263_e = new byte[j];
/*  68 */       this.field_149261_g = deflater.deflate(this.field_149263_e);
/*     */     } finally {
/*  70 */       deflater.end();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static int func_149258_c() {
/*  75 */     return 5;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/*  80 */     short s = p_148837_1_.readShort();
/*  81 */     this.field_149261_g = p_148837_1_.readInt();
/*  82 */     this.field_149267_h = p_148837_1_.readBoolean();
/*     */     
/*  84 */     this.field_149266_a = new int[s];
/*  85 */     this.field_149264_b = new int[s];
/*  86 */     this.field_149265_c = new int[s];
/*  87 */     this.field_149262_d = new int[s];
/*  88 */     this.field_149260_f = new byte[s][];
/*     */     
/*  90 */     if (field_149268_i.length < this.field_149261_g) {
/*  91 */       field_149268_i = new byte[this.field_149261_g];
/*     */     }
/*  93 */     p_148837_1_.readBytes(field_149268_i, 0, this.field_149261_g);
/*     */     
/*  95 */     byte[] arrayOfByte = new byte[S21PacketChunkData.func_149275_c() * s];
/*     */     
/*  97 */     Inflater inflater = new Inflater();
/*  98 */     inflater.setInput(field_149268_i, 0, this.field_149261_g);
/*     */     try {
/* 100 */       inflater.inflate(arrayOfByte);
/* 101 */     } catch (DataFormatException dataFormatException) {
/* 102 */       throw new IOException("Bad compressed data format");
/*     */     } finally {
/* 104 */       inflater.end();
/*     */     } 
/*     */     
/* 107 */     int i = 0;
/* 108 */     for (byte b = 0; b < s; b++) {
/* 109 */       this.field_149266_a[b] = p_148837_1_.readInt();
/* 110 */       this.field_149264_b[b] = p_148837_1_.readInt();
/* 111 */       this.field_149265_c[b] = p_148837_1_.readShort();
/* 112 */       this.field_149262_d[b] = p_148837_1_.readShort();
/*     */       
/* 114 */       int j = 0;
/* 115 */       int k = 0; int m;
/* 116 */       for (m = 0; m < 16; m++) {
/* 117 */         j += this.field_149265_c[b] >> m & 0x1;
/* 118 */         k += this.field_149262_d[b] >> m & 0x1;
/*     */       } 
/*     */       
/* 121 */       m = 2048 * 4 * j + 256;
/* 122 */       m += 2048 * k;
/* 123 */       if (this.field_149267_h) {
/* 124 */         m += 2048 * j;
/*     */       }
/*     */       
/* 127 */       this.field_149260_f[b] = new byte[m];
/* 128 */       System.arraycopy(arrayOfByte, i, this.field_149260_f[b], 0, m);
/* 129 */       i += m;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 135 */     p_148840_1_.writeShort(this.field_149266_a.length);
/* 136 */     p_148840_1_.writeInt(this.field_149261_g);
/* 137 */     p_148840_1_.writeBoolean(this.field_149267_h);
/* 138 */     p_148840_1_.writeBytes(this.field_149263_e, 0, this.field_149261_g);
/*     */     
/* 140 */     for (byte b = 0; b < this.field_149266_a.length; b++) {
/* 141 */       p_148840_1_.writeInt(this.field_149266_a[b]);
/* 142 */       p_148840_1_.writeInt(this.field_149264_b[b]);
/* 143 */       p_148840_1_.writeShort((short)(this.field_149265_c[b] & 0xFFFF));
/* 144 */       p_148840_1_.writeShort((short)(this.field_149262_d[b] & 0xFFFF));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 150 */     p_148833_1_.func_147269_a(this);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149255_a(int p_149255_1_) {
/* 154 */     return this.field_149266_a[p_149255_1_];
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149253_b(int p_149253_1_) {
/* 158 */     return this.field_149264_b[p_149253_1_];
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149254_d() {
/* 162 */     return this.field_149266_a.length;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public byte[] func_149256_c(int p_149256_1_) {
/* 166 */     return this.field_149260_f[p_149256_1_];
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_148835_b() {
/* 171 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 173 */     for (byte b = 0; b < this.field_149266_a.length; b++) {
/* 174 */       if (b > 0) stringBuilder.append(", "); 
/* 175 */       stringBuilder.append(String.format("{x=%d, z=%d, sections=%d, adds=%d, data=%d}", new Object[] { Integer.valueOf(this.field_149266_a[b]), Integer.valueOf(this.field_149264_b[b]), Integer.valueOf(this.field_149265_c[b]), Integer.valueOf(this.field_149262_d[b]), Integer.valueOf((this.field_149260_f[b]).length) }));
/*     */     } 
/*     */     
/* 178 */     return String.format("size=%d, chunks=%d[%s]", new Object[] { Integer.valueOf(this.field_149261_g), Integer.valueOf(this.field_149266_a.length), stringBuilder });
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int[] func_149252_e() {
/* 182 */     return this.field_149265_c;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int[] func_149257_f() {
/* 186 */     return this.field_149262_d;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S26PacketMapChunkBulk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */