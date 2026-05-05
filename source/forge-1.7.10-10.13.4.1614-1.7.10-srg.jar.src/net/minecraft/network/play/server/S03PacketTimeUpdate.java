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
/*    */ public class S03PacketTimeUpdate extends Packet {
/*    */   private long field_149369_a;
/*    */   private long field_149368_b;
/*    */   
/*    */   public S03PacketTimeUpdate(long p_i45230_1_, long p_i45230_3_, boolean p_i45230_5_) {
/* 16 */     this.field_149369_a = p_i45230_1_;
/* 17 */     this.field_149368_b = p_i45230_3_;
/*    */     
/* 19 */     if (!p_i45230_5_) {
/* 20 */       this.field_149368_b = -this.field_149368_b;
/* 21 */       if (this.field_149368_b == 0L)
/* 22 */         this.field_149368_b = -1L; 
/*    */     } 
/*    */   }
/*    */   
/*    */   private static final String __OBFID = "CL_00001337";
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 29 */     this.field_149369_a = p_148837_1_.readLong();
/* 30 */     this.field_149368_b = p_148837_1_.readLong();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 35 */     p_148840_1_.writeLong(this.field_149369_a);
/* 36 */     p_148840_1_.writeLong(this.field_149368_b);
/*    */   }
/*    */   public S03PacketTimeUpdate() {}
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 41 */     p_148833_1_.func_147285_a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_148835_b() {
/* 46 */     return String.format("time=%d,dtime=%d", new Object[] { Long.valueOf(this.field_149369_a), Long.valueOf(this.field_149368_b) });
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public long func_149366_c() {
/* 50 */     return this.field_149369_a;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public long func_149365_d() {
/* 54 */     return this.field_149368_b;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S03PacketTimeUpdate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */