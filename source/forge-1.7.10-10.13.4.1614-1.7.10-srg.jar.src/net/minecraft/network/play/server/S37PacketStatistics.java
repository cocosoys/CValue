/*    */ package net.minecraft.network.play.server;
/*    */ 
/*    */ import com.google.common.collect.Maps;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import java.util.Map;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayClient;
/*    */ import net.minecraft.stats.StatBase;
/*    */ import net.minecraft.stats.StatList;
/*    */ 
/*    */ public class S37PacketStatistics
/*    */   extends Packet
/*    */ {
/*    */   private Map field_148976_a;
/*    */   
/*    */   public S37PacketStatistics(Map p_i45173_1_) {
/* 21 */     this.field_148976_a = p_i45173_1_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001283";
/*    */   public S37PacketStatistics() {}
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 26 */     p_148833_1_.func_147293_a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 31 */     int i = p_148837_1_.func_150792_a();
/* 32 */     this.field_148976_a = Maps.newHashMap();
/*    */     
/* 34 */     for (byte b = 0; b < i; b++) {
/* 35 */       StatBase statBase = StatList.func_151177_a(p_148837_1_.func_150789_c(32767));
/* 36 */       int j = p_148837_1_.func_150792_a();
/*    */       
/* 38 */       if (statBase != null) this.field_148976_a.put(statBase, Integer.valueOf(j));
/*    */     
/*    */     } 
/*    */   }
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 44 */     p_148840_1_.func_150787_b(this.field_148976_a.size());
/*    */     
/* 46 */     for (Map.Entry entry : this.field_148976_a.entrySet()) {
/* 47 */       p_148840_1_.func_150785_a(((StatBase)entry.getKey()).field_75975_e);
/* 48 */       p_148840_1_.func_150787_b(((Integer)entry.getValue()).intValue());
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_148835_b() {
/* 54 */     return String.format("count=%d", new Object[] { Integer.valueOf(this.field_148976_a.size()) });
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public Map func_148974_c() {
/* 58 */     return this.field_148976_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S37PacketStatistics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */