/*     */ package net.minecraft.network.play.server;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.IOException;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.network.INetHandler;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.PacketBuffer;
/*     */ import net.minecraft.network.play.INetHandlerPlayClient;
/*     */ import net.minecraft.world.ChunkCoordIntPair;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ public class S22PacketMultiBlockChange extends Packet {
/*  18 */   private static final Logger field_148927_a = LogManager.getLogger();
/*     */   
/*     */   private ChunkCoordIntPair field_148925_b;
/*     */   
/*     */   private byte[] field_148926_c;
/*     */   private int field_148924_d;
/*     */   private static final String __OBFID = "CL_00001290";
/*     */   
/*     */   public S22PacketMultiBlockChange() {}
/*     */   
/*     */   public S22PacketMultiBlockChange(int p_i45181_1_, short[] p_i45181_2_, Chunk p_i45181_3_) {
/*  29 */     this.field_148925_b = new ChunkCoordIntPair(p_i45181_3_.field_76635_g, p_i45181_3_.field_76647_h);
/*  30 */     this.field_148924_d = p_i45181_1_;
/*     */     
/*  32 */     int i = 4 * p_i45181_1_;
/*     */     
/*     */     try {
/*  35 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i);
/*  36 */       DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
/*     */       
/*  38 */       for (byte b = 0; b < p_i45181_1_; b++) {
/*  39 */         int j = p_i45181_2_[b] >> 12 & 0xF;
/*  40 */         int k = p_i45181_2_[b] >> 8 & 0xF;
/*  41 */         int m = p_i45181_2_[b] & 0xFF;
/*     */         
/*  43 */         dataOutputStream.writeShort(p_i45181_2_[b]);
/*  44 */         dataOutputStream.writeShort((short)((Block.func_149682_b(p_i45181_3_.func_150810_a(j, m, k)) & 0xFFF) << 4 | p_i45181_3_.func_76628_c(j, m, k) & 0xF));
/*     */       } 
/*     */       
/*  47 */       this.field_148926_c = byteArrayOutputStream.toByteArray();
/*  48 */       if (this.field_148926_c.length != i) {
/*  49 */         throw new RuntimeException("Expected length " + i + " doesn't match received length " + this.field_148926_c.length);
/*     */       }
/*  51 */     } catch (IOException iOException) {
/*  52 */       field_148927_a.error("Couldn't create bulk block update packet", iOException);
/*  53 */       this.field_148926_c = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/*  59 */     this.field_148925_b = new ChunkCoordIntPair(p_148837_1_.readInt(), p_148837_1_.readInt());
/*  60 */     this.field_148924_d = p_148837_1_.readShort() & 0xFFFF;
/*  61 */     int i = p_148837_1_.readInt();
/*  62 */     if (i > 0) {
/*  63 */       this.field_148926_c = new byte[i];
/*  64 */       p_148837_1_.readBytes(this.field_148926_c);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/*  70 */     p_148840_1_.writeInt(this.field_148925_b.field_77276_a);
/*  71 */     p_148840_1_.writeInt(this.field_148925_b.field_77275_b);
/*  72 */     p_148840_1_.writeShort((short)this.field_148924_d);
/*  73 */     if (this.field_148926_c != null) {
/*  74 */       p_148840_1_.writeInt(this.field_148926_c.length);
/*  75 */       p_148840_1_.writeBytes(this.field_148926_c);
/*     */     } else {
/*  77 */       p_148840_1_.writeInt(0);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/*  83 */     p_148833_1_.func_147287_a(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_148835_b() {
/*  88 */     return String.format("xc=%d, zc=%d, count=%d", new Object[] { Integer.valueOf(this.field_148925_b.field_77276_a), Integer.valueOf(this.field_148925_b.field_77275_b), Integer.valueOf(this.field_148924_d) });
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public ChunkCoordIntPair func_148920_c() {
/*  92 */     return this.field_148925_b;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public byte[] func_148921_d() {
/*  96 */     return this.field_148926_c;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_148922_e() {
/* 100 */     return this.field_148924_d;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S22PacketMultiBlockChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */