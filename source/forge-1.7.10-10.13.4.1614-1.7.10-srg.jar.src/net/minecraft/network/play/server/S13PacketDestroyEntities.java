/*    */ package net.minecraft.network.play.server;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayClient;
/*    */ 
/*    */ public class S13PacketDestroyEntities
/*    */   extends Packet {
/*    */   private int[] field_149100_a;
/*    */   private static final String __OBFID = "CL_00001320";
/*    */   
/*    */   public S13PacketDestroyEntities() {}
/*    */   
/*    */   public S13PacketDestroyEntities(int... p_i45211_1_) {
/* 19 */     this.field_149100_a = p_i45211_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 24 */     this.field_149100_a = new int[p_148837_1_.readByte()];
/*    */     
/* 26 */     for (byte b = 0; b < this.field_149100_a.length; b++) {
/* 27 */       this.field_149100_a[b] = p_148837_1_.readInt();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 33 */     p_148840_1_.writeByte(this.field_149100_a.length);
/*    */     
/* 35 */     for (byte b = 0; b < this.field_149100_a.length; b++) {
/* 36 */       p_148840_1_.writeInt(this.field_149100_a[b]);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 42 */     p_148833_1_.func_147238_a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_148835_b() {
/* 47 */     StringBuilder stringBuilder = new StringBuilder();
/*    */     
/* 49 */     for (byte b = 0; b < this.field_149100_a.length; b++) {
/* 50 */       if (b > 0) stringBuilder.append(", "); 
/* 51 */       stringBuilder.append(this.field_149100_a[b]);
/*    */     } 
/*    */     
/* 54 */     return String.format("entities=%d[%s]", new Object[] { Integer.valueOf(this.field_149100_a.length), stringBuilder });
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int[] func_149098_c() {
/* 58 */     return this.field_149100_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S13PacketDestroyEntities.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */