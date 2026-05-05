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
/*    */ public class S36PacketSignEditorOpen
/*    */   extends Packet {
/*    */   private int field_149133_a;
/*    */   private int field_149131_b;
/*    */   
/*    */   public S36PacketSignEditorOpen(int p_i45207_1_, int p_i45207_2_, int p_i45207_3_) {
/* 17 */     this.field_149133_a = p_i45207_1_;
/* 18 */     this.field_149131_b = p_i45207_2_;
/* 19 */     this.field_149132_c = p_i45207_3_;
/*    */   }
/*    */   private int field_149132_c; private static final String __OBFID = "CL_00001316";
/*    */   public S36PacketSignEditorOpen() {}
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 24 */     p_148833_1_.func_147268_a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 29 */     this.field_149133_a = p_148837_1_.readInt();
/* 30 */     this.field_149131_b = p_148837_1_.readInt();
/* 31 */     this.field_149132_c = p_148837_1_.readInt();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 36 */     p_148840_1_.writeInt(this.field_149133_a);
/* 37 */     p_148840_1_.writeInt(this.field_149131_b);
/* 38 */     p_148840_1_.writeInt(this.field_149132_c);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149129_c() {
/* 42 */     return this.field_149133_a;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149128_d() {
/* 46 */     return this.field_149131_b;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149127_e() {
/* 50 */     return this.field_149132_c;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S36PacketSignEditorOpen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */