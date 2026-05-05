/*    */ package net.minecraft.network.play.client;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayServer;
/*    */ 
/*    */ public class C02PacketUseEntity extends Packet {
/*    */   private int field_149567_a;
/*    */   private Action field_149566_b;
/*    */   private static final String __OBFID = "CL_00001357";
/*    */   
/*    */   public enum Action {
/* 12 */     INTERACT(0), ATTACK(1); private static final String __OBFID = "CL_00001358";
/*    */     private final int field_151418_d;
/* 14 */     private static final Action[] field_151421_c = new Action[(values()).length];
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     static {
/* 23 */       for (Action action : values()) {
/* 24 */         field_151421_c[action.field_151418_d] = action;
/*    */       }
/*    */     }
/*    */     
/*    */     Action(int p_i45250_3_) {
/*    */       this.field_151418_d = p_i45250_3_;
/*    */     }
/*    */   }
/*    */   
/*    */   public C02PacketUseEntity() {}
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public C02PacketUseEntity(Entity p_i45251_1_, Action p_i45251_2_) {
/* 37 */     this.field_149567_a = p_i45251_1_.func_145782_y();
/* 38 */     this.field_149566_b = p_i45251_2_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 43 */     this.field_149567_a = p_148837_1_.readInt();
/* 44 */     this.field_149566_b = Action.field_151421_c[p_148837_1_.readByte() % Action.field_151421_c.length];
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 49 */     p_148840_1_.writeInt(this.field_149567_a);
/* 50 */     p_148840_1_.writeByte(this.field_149566_b.field_151418_d);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayServer p_148833_1_) {
/* 55 */     p_148833_1_.func_147340_a(this);
/*    */   }
/*    */   
/*    */   public Entity func_149564_a(World p_149564_1_) {
/* 59 */     return p_149564_1_.func_73045_a(this.field_149567_a);
/*    */   }
/*    */   
/*    */   public Action func_149565_c() {
/* 63 */     return this.field_149566_b;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\client\C02PacketUseEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */