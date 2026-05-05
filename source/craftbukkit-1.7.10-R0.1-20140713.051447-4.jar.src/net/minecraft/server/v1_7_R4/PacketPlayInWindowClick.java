/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PacketPlayInWindowClick
/*    */   extends Packet
/*    */ {
/*    */   private int a;
/*    */   private int slot;
/*    */   private int button;
/*    */   private short d;
/*    */   private ItemStack item;
/*    */   private int shift;
/*    */   
/*    */   public void a(PacketPlayInListener paramPacketPlayInListener) {
/* 32 */     paramPacketPlayInListener.a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 37 */     this.a = paramPacketDataSerializer.readByte();
/* 38 */     this.slot = paramPacketDataSerializer.readShort();
/* 39 */     this.button = paramPacketDataSerializer.readByte();
/* 40 */     this.d = paramPacketDataSerializer.readShort();
/* 41 */     this.shift = paramPacketDataSerializer.readByte();
/*    */     
/* 43 */     this.item = paramPacketDataSerializer.c();
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 48 */     paramPacketDataSerializer.writeByte(this.a);
/* 49 */     paramPacketDataSerializer.writeShort(this.slot);
/* 50 */     paramPacketDataSerializer.writeByte(this.button);
/* 51 */     paramPacketDataSerializer.writeShort(this.d);
/* 52 */     paramPacketDataSerializer.writeByte(this.shift);
/*    */     
/* 54 */     paramPacketDataSerializer.a(this.item);
/*    */   }
/*    */ 
/*    */   
/*    */   public String b() {
/* 59 */     if (this.item != null) {
/* 60 */       return String.format("id=%d, slot=%d, button=%d, type=%d, itemid=%d, itemcount=%d, itemaux=%d", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.slot), Integer.valueOf(this.button), Integer.valueOf(this.shift), Integer.valueOf(Item.getId(this.item.getItem())), Integer.valueOf(this.item.count), Integer.valueOf(this.item.getData()) });
/*    */     }
/*    */     
/* 63 */     return String.format("id=%d, slot=%d, button=%d, type=%d, itemid=-1", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.slot), Integer.valueOf(this.button), Integer.valueOf(this.shift) });
/*    */   }
/*    */ 
/*    */   
/*    */   public int c() {
/* 68 */     return this.a;
/*    */   }
/*    */   
/*    */   public int d() {
/* 72 */     return this.slot;
/*    */   }
/*    */   
/*    */   public int e() {
/* 76 */     return this.button;
/*    */   }
/*    */   
/*    */   public short f() {
/* 80 */     return this.d;
/*    */   }
/*    */   
/*    */   public ItemStack g() {
/* 84 */     return this.item;
/*    */   }
/*    */   
/*    */   public int h() {
/* 88 */     return this.shift;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayInWindowClick.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */