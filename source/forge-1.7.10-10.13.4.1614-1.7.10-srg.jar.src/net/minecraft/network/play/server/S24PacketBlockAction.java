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
/*    */ 
/*    */ 
/*    */ public class S24PacketBlockAction
/*    */   extends Packet
/*    */ {
/*    */   private int field_148876_a;
/*    */   private int field_148874_b;
/*    */   private int field_148875_c;
/*    */   private int field_148872_d;
/*    */   
/*    */   public S24PacketBlockAction(int p_i45176_1_, int p_i45176_2_, int p_i45176_3_, Block p_i45176_4_, int p_i45176_5_, int p_i45176_6_) {
/* 22 */     this.field_148876_a = p_i45176_1_;
/* 23 */     this.field_148874_b = p_i45176_2_;
/* 24 */     this.field_148875_c = p_i45176_3_;
/* 25 */     this.field_148872_d = p_i45176_5_;
/* 26 */     this.field_148873_e = p_i45176_6_;
/* 27 */     this.field_148871_f = p_i45176_4_;
/*    */   }
/*    */   private int field_148873_e; private Block field_148871_f; private static final String __OBFID = "CL_00001286";
/*    */   public S24PacketBlockAction() {}
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 32 */     this.field_148876_a = p_148837_1_.readInt();
/* 33 */     this.field_148874_b = p_148837_1_.readShort();
/* 34 */     this.field_148875_c = p_148837_1_.readInt();
/* 35 */     this.field_148872_d = p_148837_1_.readUnsignedByte();
/* 36 */     this.field_148873_e = p_148837_1_.readUnsignedByte();
/* 37 */     this.field_148871_f = Block.func_149729_e(p_148837_1_.func_150792_a() & 0xFFF);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 42 */     p_148840_1_.writeInt(this.field_148876_a);
/* 43 */     p_148840_1_.writeShort(this.field_148874_b);
/* 44 */     p_148840_1_.writeInt(this.field_148875_c);
/* 45 */     p_148840_1_.writeByte(this.field_148872_d);
/* 46 */     p_148840_1_.writeByte(this.field_148873_e);
/* 47 */     p_148840_1_.func_150787_b(Block.func_149682_b(this.field_148871_f) & 0xFFF);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 52 */     p_148833_1_.func_147261_a(this);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public Block func_148868_c() {
/* 56 */     return this.field_148871_f;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_148867_d() {
/* 60 */     return this.field_148876_a;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_148866_e() {
/* 64 */     return this.field_148874_b;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_148865_f() {
/* 68 */     return this.field_148875_c;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_148869_g() {
/* 72 */     return this.field_148872_d;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_148864_h() {
/* 76 */     return this.field_148873_e;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S24PacketBlockAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */