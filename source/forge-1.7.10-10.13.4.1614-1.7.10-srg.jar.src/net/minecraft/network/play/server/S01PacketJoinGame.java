/*     */ package net.minecraft.network.play.server;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.IOException;
/*     */ import net.minecraft.network.INetHandler;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.PacketBuffer;
/*     */ import net.minecraft.network.play.INetHandlerPlayClient;
/*     */ import net.minecraft.world.EnumDifficulty;
/*     */ import net.minecraft.world.WorldSettings;
/*     */ import net.minecraft.world.WorldType;
/*     */ 
/*     */ public class S01PacketJoinGame
/*     */   extends Packet
/*     */ {
/*     */   private int field_149206_a;
/*     */   private boolean field_149204_b;
/*     */   private WorldSettings.GameType field_149205_c;
/*     */   private int field_149202_d;
/*     */   private EnumDifficulty field_149203_e;
/*     */   private int field_149200_f;
/*     */   private WorldType field_149201_g;
/*     */   private static final String __OBFID = "CL_00001310";
/*     */   
/*     */   public S01PacketJoinGame() {}
/*     */   
/*     */   public S01PacketJoinGame(int p_i45201_1_, WorldSettings.GameType p_i45201_2_, boolean p_i45201_3_, int p_i45201_4_, EnumDifficulty p_i45201_5_, int p_i45201_6_, WorldType p_i45201_7_) {
/*  29 */     this.field_149206_a = p_i45201_1_;
/*  30 */     this.field_149202_d = p_i45201_4_;
/*  31 */     this.field_149203_e = p_i45201_5_;
/*  32 */     this.field_149205_c = p_i45201_2_;
/*  33 */     this.field_149200_f = p_i45201_6_;
/*  34 */     this.field_149204_b = p_i45201_3_;
/*  35 */     this.field_149201_g = p_i45201_7_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/*  40 */     this.field_149206_a = p_148837_1_.readInt();
/*     */     
/*  42 */     short s = p_148837_1_.readUnsignedByte();
/*  43 */     this.field_149204_b = ((s & 0x8) == 8);
/*  44 */     int i = s & 0xFFFFFFF7;
/*  45 */     this.field_149205_c = WorldSettings.GameType.func_77146_a(i);
/*     */     
/*  47 */     this.field_149202_d = p_148837_1_.readByte();
/*  48 */     this.field_149203_e = EnumDifficulty.func_151523_a(p_148837_1_.readUnsignedByte());
/*  49 */     this.field_149200_f = p_148837_1_.readUnsignedByte();
/*  50 */     this.field_149201_g = WorldType.func_77130_a(p_148837_1_.func_150789_c(16));
/*  51 */     if (this.field_149201_g == null) {
/*  52 */       this.field_149201_g = WorldType.field_77137_b;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/*  58 */     p_148840_1_.writeInt(this.field_149206_a);
/*  59 */     int i = this.field_149205_c.func_77148_a();
/*  60 */     if (this.field_149204_b) i |= 0x8; 
/*  61 */     p_148840_1_.writeByte(i);
/*  62 */     p_148840_1_.writeByte(this.field_149202_d);
/*  63 */     p_148840_1_.writeByte(this.field_149203_e.func_151525_a());
/*  64 */     p_148840_1_.writeByte(this.field_149200_f);
/*  65 */     p_148840_1_.func_150785_a(this.field_149201_g.func_77127_a());
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/*  70 */     p_148833_1_.func_147282_a(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_148835_b() {
/*  75 */     return String.format("eid=%d, gameType=%d, hardcore=%b, dimension=%d, difficulty=%s, maxplayers=%d", new Object[] { Integer.valueOf(this.field_149206_a), Integer.valueOf(this.field_149205_c.func_77148_a()), Boolean.valueOf(this.field_149204_b), Integer.valueOf(this.field_149202_d), this.field_149203_e, Integer.valueOf(this.field_149200_f) });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149197_c() {
/*  86 */     return this.field_149206_a;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149195_d() {
/*  90 */     return this.field_149204_b;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public WorldSettings.GameType func_149198_e() {
/*  94 */     return this.field_149205_c;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149194_f() {
/*  98 */     return this.field_149202_d;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public EnumDifficulty func_149192_g() {
/* 102 */     return this.field_149203_e;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149193_h() {
/* 106 */     return this.field_149200_f;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public WorldType func_149196_i() {
/* 110 */     return this.field_149201_g;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S01PacketJoinGame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */