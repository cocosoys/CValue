/*    */ package net.minecraft.network.play.server;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayClient;
/*    */ import org.apache.commons.lang3.ArrayUtils;
/*    */ 
/*    */ public class S3APacketTabComplete
/*    */   extends Packet
/*    */ {
/*    */   private String[] field_149632_a;
/*    */   
/*    */   public S3APacketTabComplete(String[] p_i45178_1_) {
/* 18 */     this.field_149632_a = p_i45178_1_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001288";
/*    */   public S3APacketTabComplete() {}
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 23 */     this.field_149632_a = new String[p_148837_1_.func_150792_a()];
/*    */     
/* 25 */     for (byte b = 0; b < this.field_149632_a.length; b++) {
/* 26 */       this.field_149632_a[b] = p_148837_1_.func_150789_c(32767);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 32 */     p_148840_1_.func_150787_b(this.field_149632_a.length);
/*    */     
/* 34 */     for (String str : this.field_149632_a) {
/* 35 */       p_148840_1_.func_150785_a(str);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 41 */     p_148833_1_.func_147274_a(this);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public String[] func_149630_c() {
/* 45 */     return this.field_149632_a;
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_148835_b() {
/* 50 */     return String.format("candidates='%s'", new Object[] { ArrayUtils.toString(this.field_149632_a) });
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S3APacketTabComplete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */