/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PacketPlayOutEntityMetadata
/*    */   extends Packet
/*    */ {
/*    */   private int a;
/*    */   private List b;
/*    */   
/*    */   public PacketPlayOutEntityMetadata() {}
/*    */   
/*    */   public PacketPlayOutEntityMetadata(int paramInt, DataWatcher paramDataWatcher, boolean paramBoolean) {
/* 19 */     this.a = paramInt;
/* 20 */     if (paramBoolean) {
/* 21 */       this.b = paramDataWatcher.c();
/*    */     } else {
/* 23 */       this.b = paramDataWatcher.b();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 29 */     this.a = paramPacketDataSerializer.readInt();
/* 30 */     this.b = DataWatcher.b(paramPacketDataSerializer);
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 35 */     paramPacketDataSerializer.writeInt(this.a);
/* 36 */     DataWatcher.a(this.b, paramPacketDataSerializer);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 41 */     paramPacketPlayOutListener.a(this);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutEntityMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */