/*    */ package net.minecraft.network.play.client;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayServer;
/*    */ 
/*    */ public class C0EPacketClickWindow
/*    */   extends Packet {
/*    */   private int field_149554_a;
/*    */   private int field_149552_b;
/*    */   private int field_149553_c;
/*    */   private short field_149550_d;
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public C0EPacketClickWindow(int p_i45246_1_, int p_i45246_2_, int p_i45246_3_, int p_i45246_4_, ItemStack p_i45246_5_, short p_i45246_6_) {
/* 22 */     this.field_149554_a = p_i45246_1_;
/* 23 */     this.field_149552_b = p_i45246_2_;
/* 24 */     this.field_149553_c = p_i45246_3_;
/* 25 */     this.field_149551_e = (p_i45246_5_ != null) ? p_i45246_5_.func_77946_l() : null;
/* 26 */     this.field_149550_d = p_i45246_6_;
/* 27 */     this.field_149549_f = p_i45246_4_;
/*    */   }
/*    */   private ItemStack field_149551_e; private int field_149549_f; private static final String __OBFID = "CL_00001353";
/*    */   public C0EPacketClickWindow() {}
/*    */   public void func_148833_a(INetHandlerPlayServer p_148833_1_) {
/* 32 */     p_148833_1_.func_147351_a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 37 */     this.field_149554_a = p_148837_1_.readByte();
/* 38 */     this.field_149552_b = p_148837_1_.readShort();
/* 39 */     this.field_149553_c = p_148837_1_.readByte();
/* 40 */     this.field_149550_d = p_148837_1_.readShort();
/* 41 */     this.field_149549_f = p_148837_1_.readByte();
/*    */     
/* 43 */     this.field_149551_e = p_148837_1_.func_150791_c();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 48 */     p_148840_1_.writeByte(this.field_149554_a);
/* 49 */     p_148840_1_.writeShort(this.field_149552_b);
/* 50 */     p_148840_1_.writeByte(this.field_149553_c);
/* 51 */     p_148840_1_.writeShort(this.field_149550_d);
/* 52 */     p_148840_1_.writeByte(this.field_149549_f);
/*    */     
/* 54 */     p_148840_1_.func_150788_a(this.field_149551_e);
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_148835_b() {
/* 59 */     if (this.field_149551_e != null) {
/* 60 */       return String.format("id=%d, slot=%d, button=%d, type=%d, itemid=%d, itemcount=%d, itemaux=%d", new Object[] { Integer.valueOf(this.field_149554_a), Integer.valueOf(this.field_149552_b), Integer.valueOf(this.field_149553_c), Integer.valueOf(this.field_149549_f), Integer.valueOf(Item.func_150891_b(this.field_149551_e.func_77973_b())), Integer.valueOf(this.field_149551_e.field_77994_a), Integer.valueOf(this.field_149551_e.func_77960_j()) });
/*    */     }
/*    */     
/* 63 */     return String.format("id=%d, slot=%d, button=%d, type=%d, itemid=-1", new Object[] { Integer.valueOf(this.field_149554_a), Integer.valueOf(this.field_149552_b), Integer.valueOf(this.field_149553_c), Integer.valueOf(this.field_149549_f) });
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149548_c() {
/* 68 */     return this.field_149554_a;
/*    */   }
/*    */   
/*    */   public int func_149544_d() {
/* 72 */     return this.field_149552_b;
/*    */   }
/*    */   
/*    */   public int func_149543_e() {
/* 76 */     return this.field_149553_c;
/*    */   }
/*    */   
/*    */   public short func_149547_f() {
/* 80 */     return this.field_149550_d;
/*    */   }
/*    */   
/*    */   public ItemStack func_149546_g() {
/* 84 */     return this.field_149551_e;
/*    */   }
/*    */   
/*    */   public int func_149542_h() {
/* 88 */     return this.field_149549_f;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\client\C0EPacketClickWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */