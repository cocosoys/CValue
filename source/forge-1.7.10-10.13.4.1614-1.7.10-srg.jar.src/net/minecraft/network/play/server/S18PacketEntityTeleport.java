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
/*    */ public class S18PacketEntityTeleport
/*    */   extends Packet
/*    */ {
/*    */   private int field_149458_a;
/*    */   private int field_149456_b;
/*    */   private int field_149457_c;
/*    */   private int field_149454_d;
/*    */   
/*    */   public S18PacketEntityTeleport(Entity p_i45233_1_) {
/* 22 */     this.field_149458_a = p_i45233_1_.func_145782_y();
/* 23 */     this.field_149456_b = MathHelper.func_76128_c(p_i45233_1_.field_70165_t * 32.0D);
/* 24 */     this.field_149457_c = MathHelper.func_76128_c(p_i45233_1_.field_70163_u * 32.0D);
/* 25 */     this.field_149454_d = MathHelper.func_76128_c(p_i45233_1_.field_70161_v * 32.0D);
/* 26 */     this.field_149455_e = (byte)(int)(p_i45233_1_.field_70177_z * 256.0F / 360.0F);
/* 27 */     this.field_149453_f = (byte)(int)(p_i45233_1_.field_70125_A * 256.0F / 360.0F);
/*    */   } private byte field_149455_e; private byte field_149453_f; private static final String __OBFID = "CL_00001340";
/*    */   public S18PacketEntityTeleport() {}
/*    */   public S18PacketEntityTeleport(int p_i45234_1_, int p_i45234_2_, int p_i45234_3_, int p_i45234_4_, byte p_i45234_5_, byte p_i45234_6_) {
/* 31 */     this.field_149458_a = p_i45234_1_;
/* 32 */     this.field_149456_b = p_i45234_2_;
/* 33 */     this.field_149457_c = p_i45234_3_;
/* 34 */     this.field_149454_d = p_i45234_4_;
/* 35 */     this.field_149455_e = p_i45234_5_;
/* 36 */     this.field_149453_f = p_i45234_6_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 41 */     this.field_149458_a = p_148837_1_.readInt();
/* 42 */     this.field_149456_b = p_148837_1_.readInt();
/* 43 */     this.field_149457_c = p_148837_1_.readInt();
/* 44 */     this.field_149454_d = p_148837_1_.readInt();
/* 45 */     this.field_149455_e = p_148837_1_.readByte();
/* 46 */     this.field_149453_f = p_148837_1_.readByte();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 51 */     p_148840_1_.writeInt(this.field_149458_a);
/* 52 */     p_148840_1_.writeInt(this.field_149456_b);
/* 53 */     p_148840_1_.writeInt(this.field_149457_c);
/* 54 */     p_148840_1_.writeInt(this.field_149454_d);
/* 55 */     p_148840_1_.writeByte(this.field_149455_e);
/* 56 */     p_148840_1_.writeByte(this.field_149453_f);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 61 */     p_148833_1_.func_147275_a(this);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149451_c() {
/* 65 */     return this.field_149458_a;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149449_d() {
/* 69 */     return this.field_149456_b;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149448_e() {
/* 73 */     return this.field_149457_c;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149446_f() {
/* 77 */     return this.field_149454_d;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public byte func_149450_g() {
/* 81 */     return this.field_149455_e;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public byte func_149447_h() {
/* 85 */     return this.field_149453_f;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S18PacketEntityTeleport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */