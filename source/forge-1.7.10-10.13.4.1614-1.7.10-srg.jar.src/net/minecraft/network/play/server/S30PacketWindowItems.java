/*    */ package net.minecraft.network.play.server;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayClient;
/*    */ 
/*    */ public class S30PacketWindowItems
/*    */   extends Packet
/*    */ {
/*    */   private int field_148914_a;
/*    */   private ItemStack[] field_148913_b;
/*    */   
/*    */   public S30PacketWindowItems(int p_i45186_1_, List<ItemStack> p_i45186_2_) {
/* 20 */     this.field_148914_a = p_i45186_1_;
/* 21 */     this.field_148913_b = new ItemStack[p_i45186_2_.size()];
/* 22 */     for (byte b = 0; b < this.field_148913_b.length; b++) {
/* 23 */       ItemStack itemStack = p_i45186_2_.get(b);
/* 24 */       this.field_148913_b[b] = (itemStack == null) ? null : itemStack.func_77946_l();
/*    */     } 
/*    */   }
/*    */   private static final String __OBFID = "CL_00001294";
/*    */   public S30PacketWindowItems() {}
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 30 */     this.field_148914_a = p_148837_1_.readUnsignedByte();
/* 31 */     short s = p_148837_1_.readShort();
/* 32 */     this.field_148913_b = new ItemStack[s];
/* 33 */     for (byte b = 0; b < s; b++) {
/* 34 */       this.field_148913_b[b] = p_148837_1_.func_150791_c();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 40 */     p_148840_1_.writeByte(this.field_148914_a);
/* 41 */     p_148840_1_.writeShort(this.field_148913_b.length);
/* 42 */     for (ItemStack itemStack : this.field_148913_b) {
/* 43 */       p_148840_1_.func_150788_a(itemStack);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 49 */     p_148833_1_.func_147241_a(this);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_148911_c() {
/* 53 */     return this.field_148914_a;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public ItemStack[] func_148910_d() {
/* 57 */     return this.field_148913_b;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S30PacketWindowItems.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */