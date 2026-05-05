/*    */ package net.minecraft.network.play.client;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayServer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class C17PacketCustomPayload
/*    */   extends Packet
/*    */ {
/*    */   private String field_149562_a;
/*    */   private int field_149560_b;
/*    */   private byte[] field_149561_c;
/*    */   private static final String __OBFID = "CL_00001356";
/*    */   
/*    */   public C17PacketCustomPayload() {}
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public C17PacketCustomPayload(String p_i45248_1_, ByteBuf p_i45248_2_) {
/* 27 */     this(p_i45248_1_, p_i45248_2_.array());
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public C17PacketCustomPayload(String p_i45249_1_, byte[] p_i45249_2_) {
/* 31 */     this.field_149562_a = p_i45249_1_;
/* 32 */     this.field_149561_c = p_i45249_2_;
/*    */     
/* 34 */     if (p_i45249_2_ != null) {
/* 35 */       this.field_149560_b = p_i45249_2_.length;
/*    */       
/* 37 */       if (this.field_149560_b >= 32767) {
/* 38 */         throw new IllegalArgumentException("Payload may not be larger than 32k");
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 45 */     this.field_149562_a = p_148837_1_.func_150789_c(20);
/* 46 */     this.field_149560_b = p_148837_1_.readShort();
/*    */     
/* 48 */     if (this.field_149560_b > 0 && this.field_149560_b < 32767) {
/* 49 */       this.field_149561_c = new byte[this.field_149560_b];
/* 50 */       p_148837_1_.readBytes(this.field_149561_c);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 56 */     p_148840_1_.func_150785_a(this.field_149562_a);
/* 57 */     p_148840_1_.writeShort((short)this.field_149560_b);
/* 58 */     if (this.field_149561_c != null) {
/* 59 */       p_148840_1_.writeBytes(this.field_149561_c);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayServer p_148833_1_) {
/* 65 */     p_148833_1_.func_147349_a(this);
/*    */   }
/*    */   
/*    */   public String func_149559_c() {
/* 69 */     return this.field_149562_a;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public byte[] func_149558_e() {
/* 77 */     return this.field_149561_c;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\client\C17PacketCustomPayload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */