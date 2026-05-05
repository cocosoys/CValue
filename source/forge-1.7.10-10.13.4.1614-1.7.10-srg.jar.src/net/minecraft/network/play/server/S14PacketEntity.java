/*     */ package net.minecraft.network.play.server;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.IOException;
/*     */ import net.minecraft.network.INetHandler;
/*     */ import net.minecraft.network.PacketBuffer;
/*     */ import net.minecraft.network.play.INetHandlerPlayClient;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class S14PacketEntity extends Packet {
/*     */   protected int field_149074_a;
/*     */   protected byte field_149072_b;
/*     */   protected byte field_149073_c;
/*     */   protected byte field_149070_d;
/*     */   protected byte field_149071_e;
/*     */   protected byte field_149068_f;
/*     */   protected boolean field_149069_g;
/*     */   private static final String __OBFID = "CL_00001312";
/*     */   
/*     */   public static class S17PacketEntityLookMove extends S14PacketEntity {
/*     */     public S17PacketEntityLookMove() {
/*  22 */       this.field_149069_g = true;
/*     */     }
/*     */     private static final String __OBFID = "CL_00001314";
/*     */     public S17PacketEntityLookMove(int p_i45204_1_, byte p_i45204_2_, byte p_i45204_3_, byte p_i45204_4_, byte p_i45204_5_, byte p_i45204_6_) {
/*  26 */       super(p_i45204_1_);
/*  27 */       this.field_149072_b = p_i45204_2_;
/*  28 */       this.field_149073_c = p_i45204_3_;
/*  29 */       this.field_149070_d = p_i45204_4_;
/*  30 */       this.field_149071_e = p_i45204_5_;
/*  31 */       this.field_149068_f = p_i45204_6_;
/*  32 */       this.field_149069_g = true;
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/*  37 */       super.func_148837_a(p_148837_1_);
/*  38 */       this.field_149072_b = p_148837_1_.readByte();
/*  39 */       this.field_149073_c = p_148837_1_.readByte();
/*  40 */       this.field_149070_d = p_148837_1_.readByte();
/*  41 */       this.field_149071_e = p_148837_1_.readByte();
/*  42 */       this.field_149068_f = p_148837_1_.readByte();
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/*  47 */       super.func_148840_b(p_148840_1_);
/*  48 */       p_148840_1_.writeByte(this.field_149072_b);
/*  49 */       p_148840_1_.writeByte(this.field_149073_c);
/*  50 */       p_148840_1_.writeByte(this.field_149070_d);
/*  51 */       p_148840_1_.writeByte(this.field_149071_e);
/*  52 */       p_148840_1_.writeByte(this.field_149068_f);
/*     */     }
/*     */ 
/*     */     
/*     */     public String func_148835_b() {
/*  57 */       return super.func_148835_b() + String.format(", xa=%d, ya=%d, za=%d, yRot=%d, xRot=%d", new Object[] { Byte.valueOf(this.field_149072_b), Byte.valueOf(this.field_149073_c), Byte.valueOf(this.field_149070_d), Byte.valueOf(this.field_149071_e), Byte.valueOf(this.field_149068_f) });
/*     */     }
/*     */   }
/*     */   
/*     */   public static class S15PacketEntityRelMove extends S14PacketEntity {
/*     */     private static final String __OBFID = "CL_00001313";
/*     */     
/*     */     public S15PacketEntityRelMove() {}
/*     */     
/*     */     public S15PacketEntityRelMove(int p_i45203_1_, byte p_i45203_2_, byte p_i45203_3_, byte p_i45203_4_) {
/*  67 */       super(p_i45203_1_);
/*  68 */       this.field_149072_b = p_i45203_2_;
/*  69 */       this.field_149073_c = p_i45203_3_;
/*  70 */       this.field_149070_d = p_i45203_4_;
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/*  75 */       super.func_148837_a(p_148837_1_);
/*  76 */       this.field_149072_b = p_148837_1_.readByte();
/*  77 */       this.field_149073_c = p_148837_1_.readByte();
/*  78 */       this.field_149070_d = p_148837_1_.readByte();
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/*  83 */       super.func_148840_b(p_148840_1_);
/*  84 */       p_148840_1_.writeByte(this.field_149072_b);
/*  85 */       p_148840_1_.writeByte(this.field_149073_c);
/*  86 */       p_148840_1_.writeByte(this.field_149070_d);
/*     */     }
/*     */ 
/*     */     
/*     */     public String func_148835_b() {
/*  91 */       return super.func_148835_b() + String.format(", xa=%d, ya=%d, za=%d", new Object[] { Byte.valueOf(this.field_149072_b), Byte.valueOf(this.field_149073_c), Byte.valueOf(this.field_149070_d) });
/*     */     } }
/*     */   
/*     */   public static class S16PacketEntityLook extends S14PacketEntity {
/*     */     private static final String __OBFID = "CL_00001315";
/*     */     
/*     */     public S16PacketEntityLook() {
/*  98 */       this.field_149069_g = true;
/*     */     }
/*     */     
/*     */     public S16PacketEntityLook(int p_i45205_1_, byte p_i45205_2_, byte p_i45205_3_) {
/* 102 */       super(p_i45205_1_);
/* 103 */       this.field_149071_e = p_i45205_2_;
/* 104 */       this.field_149068_f = p_i45205_3_;
/* 105 */       this.field_149069_g = true;
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 110 */       super.func_148837_a(p_148837_1_);
/* 111 */       this.field_149071_e = p_148837_1_.readByte();
/* 112 */       this.field_149068_f = p_148837_1_.readByte();
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 117 */       super.func_148840_b(p_148840_1_);
/* 118 */       p_148840_1_.writeByte(this.field_149071_e);
/* 119 */       p_148840_1_.writeByte(this.field_149068_f);
/*     */     }
/*     */ 
/*     */     
/*     */     public String func_148835_b() {
/* 124 */       return super.func_148835_b() + String.format(", yRot=%d, xRot=%d", new Object[] { Byte.valueOf(this.field_149071_e), Byte.valueOf(this.field_149068_f) });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public S14PacketEntity() {}
/*     */ 
/*     */   
/*     */   public S14PacketEntity(int p_i45206_1_) {
/* 133 */     this.field_149074_a = p_i45206_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 138 */     this.field_149074_a = p_148837_1_.readInt();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 143 */     p_148840_1_.writeInt(this.field_149074_a);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 148 */     p_148833_1_.func_147259_a(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_148835_b() {
/* 153 */     return String.format("id=%d", new Object[] { Integer.valueOf(this.field_149074_a) });
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 158 */     return "Entity_" + super.toString();
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Entity func_149065_a(World p_149065_1_) {
/* 162 */     return p_149065_1_.func_73045_a(this.field_149074_a);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public byte func_149062_c() {
/* 166 */     return this.field_149072_b;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public byte func_149061_d() {
/* 170 */     return this.field_149073_c;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public byte func_149064_e() {
/* 174 */     return this.field_149070_d;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public byte func_149066_f() {
/* 178 */     return this.field_149071_e;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public byte func_149063_g() {
/* 182 */     return this.field_149068_f;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149060_h() {
/* 186 */     return this.field_149069_g;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S14PacketEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */