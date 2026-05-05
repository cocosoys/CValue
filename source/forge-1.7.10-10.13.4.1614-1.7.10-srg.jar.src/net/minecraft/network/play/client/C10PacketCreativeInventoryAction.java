/*    */ package net.minecraft.network.play.client;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayServer;
/*    */ 
/*    */ public class C10PacketCreativeInventoryAction extends Packet {
/*    */   private int field_149629_a;
/*    */   private ItemStack field_149628_b;
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public C10PacketCreativeInventoryAction(int p_i45263_1_, ItemStack p_i45263_2_) {
/* 17 */     this.field_149629_a = p_i45263_1_;
/* 18 */     this.field_149628_b = (p_i45263_2_ != null) ? p_i45263_2_.func_77946_l() : null;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001369";
/*    */   public C10PacketCreativeInventoryAction() {}
/*    */   public void func_148833_a(INetHandlerPlayServer p_148833_1_) {
/* 23 */     p_148833_1_.func_147344_a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 28 */     this.field_149629_a = p_148837_1_.readShort();
/* 29 */     this.field_149628_b = p_148837_1_.func_150791_c();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 34 */     p_148840_1_.writeShort(this.field_149629_a);
/* 35 */     p_148840_1_.func_150788_a(this.field_149628_b);
/*    */   }
/*    */   
/*    */   public int func_149627_c() {
/* 39 */     return this.field_149629_a;
/*    */   }
/*    */   
/*    */   public ItemStack func_149625_d() {
/* 43 */     return this.field_149628_b;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\client\C10PacketCreativeInventoryAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */