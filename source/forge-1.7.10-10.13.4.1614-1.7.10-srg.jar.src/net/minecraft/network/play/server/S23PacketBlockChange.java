/*    */ package net.minecraft.network.play.server;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayClient;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class S23PacketBlockChange
/*    */   extends Packet
/*    */ {
/*    */   private int field_148887_a;
/*    */   private int field_148885_b;
/*    */   private int field_148886_c;
/*    */   
/*    */   public S23PacketBlockChange(int p_i45177_1_, int p_i45177_2_, int p_i45177_3_, World p_i45177_4_) {
/* 23 */     this.field_148887_a = p_i45177_1_;
/* 24 */     this.field_148885_b = p_i45177_2_;
/* 25 */     this.field_148886_c = p_i45177_3_;
/* 26 */     this.field_148883_d = p_i45177_4_.func_147439_a(p_i45177_1_, p_i45177_2_, p_i45177_3_);
/* 27 */     this.field_148884_e = p_i45177_4_.func_72805_g(p_i45177_1_, p_i45177_2_, p_i45177_3_);
/*    */   }
/*    */   public Block field_148883_d; public int field_148884_e; private static final String __OBFID = "CL_00001287";
/*    */   public S23PacketBlockChange() {}
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 32 */     this.field_148887_a = p_148837_1_.readInt();
/* 33 */     this.field_148885_b = p_148837_1_.readUnsignedByte();
/* 34 */     this.field_148886_c = p_148837_1_.readInt();
/* 35 */     this.field_148883_d = Block.func_149729_e(p_148837_1_.func_150792_a());
/* 36 */     this.field_148884_e = p_148837_1_.readUnsignedByte();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 41 */     p_148840_1_.writeInt(this.field_148887_a);
/* 42 */     p_148840_1_.writeByte(this.field_148885_b);
/* 43 */     p_148840_1_.writeInt(this.field_148886_c);
/* 44 */     p_148840_1_.func_150787_b(Block.func_149682_b(this.field_148883_d));
/* 45 */     p_148840_1_.writeByte(this.field_148884_e);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 50 */     p_148833_1_.func_147234_a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_148835_b() {
/* 55 */     return String.format("type=%d, data=%d, x=%d, y=%d, z=%d", new Object[] { Integer.valueOf(Block.func_149682_b(this.field_148883_d)), Integer.valueOf(this.field_148884_e), Integer.valueOf(this.field_148887_a), Integer.valueOf(this.field_148885_b), Integer.valueOf(this.field_148886_c) });
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public Block func_148880_c() {
/* 59 */     return this.field_148883_d;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_148879_d() {
/* 63 */     return this.field_148887_a;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_148878_e() {
/* 67 */     return this.field_148885_b;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_148877_f() {
/* 71 */     return this.field_148886_c;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_148881_g() {
/* 75 */     return this.field_148884_e;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S23PacketBlockChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */