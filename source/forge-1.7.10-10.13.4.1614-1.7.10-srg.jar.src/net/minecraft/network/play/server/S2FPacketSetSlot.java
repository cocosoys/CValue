/*    */ package net.minecraft.network.play.server;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayClient;
/*    */ 
/*    */ 
/*    */ public class S2FPacketSetSlot
/*    */   extends Packet
/*    */ {
/*    */   private int field_149179_a;
/*    */   private int field_149177_b;
/*    */   
/*    */   public S2FPacketSetSlot(int p_i45188_1_, int p_i45188_2_, ItemStack p_i45188_3_) {
/* 20 */     this.field_149179_a = p_i45188_1_;
/* 21 */     this.field_149177_b = p_i45188_2_;
/* 22 */     this.field_149178_c = (p_i45188_3_ == null) ? null : p_i45188_3_.func_77946_l();
/*    */   }
/*    */   private ItemStack field_149178_c; private static final String __OBFID = "CL_00001296";
/*    */   public S2FPacketSetSlot() {}
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 27 */     p_148833_1_.func_147266_a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 32 */     this.field_149179_a = p_148837_1_.readByte();
/* 33 */     this.field_149177_b = p_148837_1_.readShort();
/* 34 */     this.field_149178_c = p_148837_1_.func_150791_c();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 39 */     p_148840_1_.writeByte(this.field_149179_a);
/* 40 */     p_148840_1_.writeShort(this.field_149177_b);
/* 41 */     p_148840_1_.func_150788_a(this.field_149178_c);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149175_c() {
/* 45 */     return this.field_149179_a;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149173_d() {
/* 49 */     return this.field_149177_b;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public ItemStack func_149174_e() {
/* 53 */     return this.field_149178_c;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S2FPacketSetSlot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */