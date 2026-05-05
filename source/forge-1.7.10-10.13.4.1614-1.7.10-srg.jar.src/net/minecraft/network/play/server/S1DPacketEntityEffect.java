/*    */ package net.minecraft.network.play.server;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayClient;
/*    */ import net.minecraft.potion.PotionEffect;
/*    */ 
/*    */ public class S1DPacketEntityEffect extends Packet {
/*    */   private int field_149434_a;
/*    */   private byte field_149432_b;
/*    */   private byte field_149433_c;
/*    */   private short field_149431_d;
/*    */   private static final String __OBFID = "CL_00001343";
/*    */   
/*    */   public S1DPacketEntityEffect() {}
/*    */   
/*    */   public S1DPacketEntityEffect(int p_i45237_1_, PotionEffect p_i45237_2_) {
/* 22 */     this.field_149434_a = p_i45237_1_;
/* 23 */     this.field_149432_b = (byte)(p_i45237_2_.func_76456_a() & 0xFF);
/* 24 */     this.field_149433_c = (byte)(p_i45237_2_.func_76458_c() & 0xFF);
/* 25 */     if (p_i45237_2_.func_76459_b() > 32767) {
/* 26 */       this.field_149431_d = Short.MAX_VALUE;
/*    */     } else {
/*    */       
/* 29 */       this.field_149431_d = (short)p_i45237_2_.func_76459_b();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 35 */     this.field_149434_a = p_148837_1_.readInt();
/* 36 */     this.field_149432_b = p_148837_1_.readByte();
/* 37 */     this.field_149433_c = p_148837_1_.readByte();
/* 38 */     this.field_149431_d = p_148837_1_.readShort();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 43 */     p_148840_1_.writeInt(this.field_149434_a);
/* 44 */     p_148840_1_.writeByte(this.field_149432_b);
/* 45 */     p_148840_1_.writeByte(this.field_149433_c);
/* 46 */     p_148840_1_.writeShort(this.field_149431_d);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public boolean func_149429_c() {
/* 50 */     return (this.field_149431_d == Short.MAX_VALUE);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 55 */     p_148833_1_.func_147260_a(this);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149426_d() {
/* 59 */     return this.field_149434_a;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public byte func_149427_e() {
/* 63 */     return this.field_149432_b;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public byte func_149428_f() {
/* 67 */     return this.field_149433_c;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public short func_149425_g() {
/* 71 */     return this.field_149431_d;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S1DPacketEntityEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */