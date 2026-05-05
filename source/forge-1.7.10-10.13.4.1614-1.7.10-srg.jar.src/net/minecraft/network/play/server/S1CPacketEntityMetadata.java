/*    */ package net.minecraft.network.play.server;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.DataWatcher;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayClient;
/*    */ 
/*    */ public class S1CPacketEntityMetadata
/*    */   extends Packet {
/*    */   private int field_149379_a;
/*    */   private List field_149378_b;
/*    */   
/*    */   public S1CPacketEntityMetadata(int p_i45217_1_, DataWatcher p_i45217_2_, boolean p_i45217_3_) {
/* 19 */     this.field_149379_a = p_i45217_1_;
/* 20 */     if (p_i45217_3_) {
/* 21 */       this.field_149378_b = p_i45217_2_.func_75685_c();
/*    */     } else {
/* 23 */       this.field_149378_b = p_i45217_2_.func_75688_b();
/*    */     } 
/*    */   }
/*    */   private static final String __OBFID = "CL_00001326";
/*    */   public S1CPacketEntityMetadata() {}
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 29 */     this.field_149379_a = p_148837_1_.readInt();
/* 30 */     this.field_149378_b = DataWatcher.func_151508_b(p_148837_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 35 */     p_148840_1_.writeInt(this.field_149379_a);
/* 36 */     DataWatcher.func_151507_a(this.field_149378_b, p_148840_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 41 */     p_148833_1_.func_147284_a(this);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public List func_149376_c() {
/* 45 */     return this.field_149378_b;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149375_d() {
/* 49 */     return this.field_149379_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S1CPacketEntityMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */