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
/*    */ public class S2DPacketOpenWindow
/*    */   extends Packet
/*    */ {
/*    */   private int field_148909_a;
/*    */   private int field_148907_b;
/*    */   private String field_148908_c;
/*    */   private int field_148905_d;
/*    */   private boolean field_148906_e;
/*    */   private int field_148904_f;
/*    */   private static final String __OBFID = "CL_00001293";
/*    */   
/*    */   public S2DPacketOpenWindow() {}
/*    */   
/*    */   public S2DPacketOpenWindow(int p_i45184_1_, int p_i45184_2_, String p_i45184_3_, int p_i45184_4_, boolean p_i45184_5_) {
/* 37 */     this.field_148909_a = p_i45184_1_;
/* 38 */     this.field_148907_b = p_i45184_2_;
/* 39 */     this.field_148908_c = p_i45184_3_;
/* 40 */     this.field_148905_d = p_i45184_4_;
/* 41 */     this.field_148906_e = p_i45184_5_;
/*    */   }
/*    */   
/*    */   public S2DPacketOpenWindow(int p_i45185_1_, int p_i45185_2_, String p_i45185_3_, int p_i45185_4_, boolean p_i45185_5_, int p_i45185_6_) {
/* 45 */     this(p_i45185_1_, p_i45185_2_, p_i45185_3_, p_i45185_4_, p_i45185_5_);
/* 46 */     this.field_148904_f = p_i45185_6_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 51 */     p_148833_1_.func_147265_a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 56 */     this.field_148909_a = p_148837_1_.readUnsignedByte();
/* 57 */     this.field_148907_b = p_148837_1_.readUnsignedByte();
/* 58 */     this.field_148908_c = p_148837_1_.func_150789_c(32);
/* 59 */     this.field_148905_d = p_148837_1_.readUnsignedByte();
/* 60 */     this.field_148906_e = p_148837_1_.readBoolean();
/* 61 */     if (this.field_148907_b == 11) {
/* 62 */       this.field_148904_f = p_148837_1_.readInt();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 68 */     p_148840_1_.writeByte(this.field_148909_a);
/* 69 */     p_148840_1_.writeByte(this.field_148907_b);
/* 70 */     p_148840_1_.func_150785_a(this.field_148908_c);
/* 71 */     p_148840_1_.writeByte(this.field_148905_d);
/* 72 */     p_148840_1_.writeBoolean(this.field_148906_e);
/* 73 */     if (this.field_148907_b == 11)
/* 74 */       p_148840_1_.writeInt(this.field_148904_f); 
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_148901_c() {
/* 79 */     return this.field_148909_a;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_148899_d() {
/* 83 */     return this.field_148907_b;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public String func_148902_e() {
/* 87 */     return this.field_148908_c;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_148898_f() {
/* 91 */     return this.field_148905_d;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public boolean func_148900_g() {
/* 95 */     return this.field_148906_e;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_148897_h() {
/* 99 */     return this.field_148904_f;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S2DPacketOpenWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */