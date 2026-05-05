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
/*    */ public class S05PacketSpawnPosition
/*    */   extends Packet {
/*    */   private int field_149364_a;
/*    */   private int field_149362_b;
/*    */   
/*    */   public S05PacketSpawnPosition(int p_i45229_1_, int p_i45229_2_, int p_i45229_3_) {
/* 17 */     this.field_149364_a = p_i45229_1_;
/* 18 */     this.field_149362_b = p_i45229_2_;
/* 19 */     this.field_149363_c = p_i45229_3_;
/*    */   }
/*    */   private int field_149363_c; private static final String __OBFID = "CL_00001336";
/*    */   public S05PacketSpawnPosition() {}
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 24 */     this.field_149364_a = p_148837_1_.readInt();
/* 25 */     this.field_149362_b = p_148837_1_.readInt();
/* 26 */     this.field_149363_c = p_148837_1_.readInt();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 31 */     p_148840_1_.writeInt(this.field_149364_a);
/* 32 */     p_148840_1_.writeInt(this.field_149362_b);
/* 33 */     p_148840_1_.writeInt(this.field_149363_c);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 38 */     p_148833_1_.func_147271_a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_148836_a() {
/* 43 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_148835_b() {
/* 48 */     return String.format("x=%d, y=%d, z=%d", new Object[] { Integer.valueOf(this.field_149364_a), Integer.valueOf(this.field_149362_b), Integer.valueOf(this.field_149363_c) });
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149360_c() {
/* 52 */     return this.field_149364_a;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149359_d() {
/* 56 */     return this.field_149362_b;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149358_e() {
/* 60 */     return this.field_149363_c;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S05PacketSpawnPosition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */