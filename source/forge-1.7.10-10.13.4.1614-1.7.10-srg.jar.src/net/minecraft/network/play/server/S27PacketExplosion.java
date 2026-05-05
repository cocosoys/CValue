/*     */ package net.minecraft.network.play.server;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.network.INetHandler;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.PacketBuffer;
/*     */ import net.minecraft.network.play.INetHandlerPlayClient;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.ChunkPosition;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class S27PacketExplosion
/*     */   extends Packet
/*     */ {
/*     */   private double field_149158_a;
/*     */   private double field_149156_b;
/*     */   private double field_149157_c;
/*     */   private float field_149154_d;
/*     */   private List field_149155_e;
/*     */   
/*     */   public S27PacketExplosion(double p_i45193_1_, double p_i45193_3_, double p_i45193_5_, float p_i45193_7_, List<?> p_i45193_8_, Vec3 p_i45193_9_) {
/*  28 */     this.field_149158_a = p_i45193_1_;
/*  29 */     this.field_149156_b = p_i45193_3_;
/*  30 */     this.field_149157_c = p_i45193_5_;
/*  31 */     this.field_149154_d = p_i45193_7_;
/*  32 */     this.field_149155_e = new ArrayList(p_i45193_8_);
/*     */     
/*  34 */     if (p_i45193_9_ != null) {
/*  35 */       this.field_149152_f = (float)p_i45193_9_.field_72450_a;
/*  36 */       this.field_149153_g = (float)p_i45193_9_.field_72448_b;
/*  37 */       this.field_149159_h = (float)p_i45193_9_.field_72449_c;
/*     */     } 
/*     */   }
/*     */   private float field_149152_f; private float field_149153_g; private float field_149159_h; private static final String __OBFID = "CL_00001300";
/*     */   public S27PacketExplosion() {}
/*     */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/*  43 */     this.field_149158_a = p_148837_1_.readFloat();
/*  44 */     this.field_149156_b = p_148837_1_.readFloat();
/*  45 */     this.field_149157_c = p_148837_1_.readFloat();
/*  46 */     this.field_149154_d = p_148837_1_.readFloat();
/*  47 */     int i = p_148837_1_.readInt();
/*     */     
/*  49 */     this.field_149155_e = new ArrayList(i);
/*     */     
/*  51 */     int j = (int)this.field_149158_a;
/*  52 */     int k = (int)this.field_149156_b;
/*  53 */     int m = (int)this.field_149157_c;
/*  54 */     for (byte b = 0; b < i; b++) {
/*  55 */       int n = p_148837_1_.readByte() + j;
/*  56 */       int i1 = p_148837_1_.readByte() + k;
/*  57 */       int i2 = p_148837_1_.readByte() + m;
/*  58 */       this.field_149155_e.add(new ChunkPosition(n, i1, i2));
/*     */     } 
/*     */     
/*  61 */     this.field_149152_f = p_148837_1_.readFloat();
/*  62 */     this.field_149153_g = p_148837_1_.readFloat();
/*  63 */     this.field_149159_h = p_148837_1_.readFloat();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/*  68 */     p_148840_1_.writeFloat((float)this.field_149158_a);
/*  69 */     p_148840_1_.writeFloat((float)this.field_149156_b);
/*  70 */     p_148840_1_.writeFloat((float)this.field_149157_c);
/*  71 */     p_148840_1_.writeFloat(this.field_149154_d);
/*  72 */     p_148840_1_.writeInt(this.field_149155_e.size());
/*     */     
/*  74 */     int i = (int)this.field_149158_a;
/*  75 */     int j = (int)this.field_149156_b;
/*  76 */     int k = (int)this.field_149157_c;
/*  77 */     for (ChunkPosition chunkPosition : this.field_149155_e) {
/*  78 */       int m = chunkPosition.field_151329_a - i;
/*  79 */       int n = chunkPosition.field_151327_b - j;
/*  80 */       int i1 = chunkPosition.field_151328_c - k;
/*  81 */       p_148840_1_.writeByte(m);
/*  82 */       p_148840_1_.writeByte(n);
/*  83 */       p_148840_1_.writeByte(i1);
/*     */     } 
/*     */     
/*  86 */     p_148840_1_.writeFloat(this.field_149152_f);
/*  87 */     p_148840_1_.writeFloat(this.field_149153_g);
/*  88 */     p_148840_1_.writeFloat(this.field_149159_h);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/*  93 */     p_148833_1_.func_147283_a(this);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_149149_c() {
/*  97 */     return this.field_149152_f;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_149144_d() {
/* 101 */     return this.field_149153_g;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_149147_e() {
/* 105 */     return this.field_149159_h;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public double func_149148_f() {
/* 109 */     return this.field_149158_a;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public double func_149143_g() {
/* 113 */     return this.field_149156_b;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public double func_149145_h() {
/* 117 */     return this.field_149157_c;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_149146_i() {
/* 121 */     return this.field_149154_d;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public List func_149150_j() {
/* 125 */     return this.field_149155_e;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S27PacketExplosion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */