/*    */ package net.minecraft.network.play.server;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayClient;
/*    */ import net.minecraft.util.MathHelper;
/*    */ 
/*    */ public class S2CPacketSpawnGlobalEntity
/*    */   extends Packet
/*    */ {
/*    */   private int field_149059_a;
/*    */   private int field_149057_b;
/*    */   private int field_149058_c;
/*    */   private int field_149055_d;
/*    */   private int field_149056_e;
/*    */   private static final String __OBFID = "CL_00001278";
/*    */   
/*    */   public S2CPacketSpawnGlobalEntity() {}
/*    */   
/*    */   public S2CPacketSpawnGlobalEntity(Entity p_i45191_1_) {
/* 26 */     this.field_149059_a = p_i45191_1_.func_145782_y();
/* 27 */     this.field_149057_b = MathHelper.func_76128_c(p_i45191_1_.field_70165_t * 32.0D);
/* 28 */     this.field_149058_c = MathHelper.func_76128_c(p_i45191_1_.field_70163_u * 32.0D);
/* 29 */     this.field_149055_d = MathHelper.func_76128_c(p_i45191_1_.field_70161_v * 32.0D);
/* 30 */     if (p_i45191_1_ instanceof net.minecraft.entity.effect.EntityLightningBolt) {
/* 31 */       this.field_149056_e = 1;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 37 */     this.field_149059_a = p_148837_1_.func_150792_a();
/* 38 */     this.field_149056_e = p_148837_1_.readByte();
/* 39 */     this.field_149057_b = p_148837_1_.readInt();
/* 40 */     this.field_149058_c = p_148837_1_.readInt();
/* 41 */     this.field_149055_d = p_148837_1_.readInt();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 46 */     p_148840_1_.func_150787_b(this.field_149059_a);
/* 47 */     p_148840_1_.writeByte(this.field_149056_e);
/* 48 */     p_148840_1_.writeInt(this.field_149057_b);
/* 49 */     p_148840_1_.writeInt(this.field_149058_c);
/* 50 */     p_148840_1_.writeInt(this.field_149055_d);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 55 */     p_148833_1_.func_147292_a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_148835_b() {
/* 60 */     return String.format("id=%d, type=%d, x=%.2f, y=%.2f, z=%.2f", new Object[] { Integer.valueOf(this.field_149059_a), Integer.valueOf(this.field_149056_e), Float.valueOf(this.field_149057_b / 32.0F), Float.valueOf(this.field_149058_c / 32.0F), Float.valueOf(this.field_149055_d / 32.0F) });
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149052_c() {
/* 64 */     return this.field_149059_a;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149051_d() {
/* 68 */     return this.field_149057_b;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149050_e() {
/* 72 */     return this.field_149058_c;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149049_f() {
/* 76 */     return this.field_149055_d;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149053_g() {
/* 80 */     return this.field_149056_e;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S2CPacketSpawnGlobalEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */