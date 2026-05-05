/*    */ package net.minecraft.network.play.client;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayServer;
/*    */ 
/*    */ public class C11PacketEnchantItem extends Packet {
/*    */   private int field_149541_a;
/*    */   private int field_149540_b;
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public C11PacketEnchantItem(int p_i45245_1_, int p_i45245_2_) {
/* 16 */     this.field_149541_a = p_i45245_1_;
/* 17 */     this.field_149540_b = p_i45245_2_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001352";
/*    */   public C11PacketEnchantItem() {}
/*    */   public void func_148833_a(INetHandlerPlayServer p_148833_1_) {
/* 22 */     p_148833_1_.func_147338_a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 27 */     this.field_149541_a = p_148837_1_.readByte();
/* 28 */     this.field_149540_b = p_148837_1_.readByte();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 33 */     p_148840_1_.writeByte(this.field_149541_a);
/* 34 */     p_148840_1_.writeByte(this.field_149540_b);
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_148835_b() {
/* 39 */     return String.format("id=%d, button=%d", new Object[] { Integer.valueOf(this.field_149541_a), Integer.valueOf(this.field_149540_b) });
/*    */   }
/*    */   
/*    */   public int func_149539_c() {
/* 43 */     return this.field_149541_a;
/*    */   }
/*    */   
/*    */   public int func_149537_d() {
/* 47 */     return this.field_149540_b;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\client\C11PacketEnchantItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */