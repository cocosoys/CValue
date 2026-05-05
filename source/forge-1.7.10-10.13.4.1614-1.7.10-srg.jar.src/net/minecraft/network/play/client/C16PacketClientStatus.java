/*    */ package net.minecraft.network.play.client;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayServer;
/*    */ 
/*    */ public class C16PacketClientStatus extends Packet {
/*    */   private EnumState field_149437_a;
/*    */   private static final String __OBFID = "CL_00001348";
/*    */   
/*    */   public enum EnumState {
/* 10 */     PERFORM_RESPAWN(0),
/* 11 */     REQUEST_STATS(1),
/* 12 */     OPEN_INVENTORY_ACHIEVEMENT(2);
/*    */     
/*    */     private final int field_151403_d;
/* 15 */     private static final EnumState[] field_151404_e = new EnumState[(values()).length];
/*    */ 
/*    */     
/*    */     private static final String __OBFID = "CL_00001349";
/*    */ 
/*    */     
/*    */     static {
/* 22 */       for (EnumState enumState : values()) {
/* 23 */         field_151404_e[enumState.field_151403_d] = enumState;
/*    */       }
/*    */     }
/*    */     
/*    */     EnumState(int p_i45241_3_) {
/*    */       this.field_151403_d = p_i45241_3_;
/*    */     }
/*    */   }
/*    */   
/*    */   public C16PacketClientStatus() {}
/*    */   
/*    */   public C16PacketClientStatus(EnumState p_i45242_1_) {
/* 35 */     this.field_149437_a = p_i45242_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 40 */     this.field_149437_a = EnumState.field_151404_e[p_148837_1_.readByte() % EnumState.field_151404_e.length];
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 45 */     p_148840_1_.writeByte(this.field_149437_a.field_151403_d);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayServer p_148833_1_) {
/* 50 */     p_148833_1_.func_147342_a(this);
/*    */   }
/*    */   
/*    */   public EnumState func_149435_c() {
/* 54 */     return this.field_149437_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\client\C16PacketClientStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */