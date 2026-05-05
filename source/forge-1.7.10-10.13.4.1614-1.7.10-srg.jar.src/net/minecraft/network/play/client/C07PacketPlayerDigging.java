/*    */ package net.minecraft.network.play.client;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayServer;
/*    */ 
/*    */ 
/*    */ public class C07PacketPlayerDigging
/*    */   extends Packet
/*    */ {
/*    */   private int field_149511_a;
/*    */   private int field_149509_b;
/*    */   private int field_149510_c;
/*    */   private int field_149507_d;
/*    */   private int field_149508_e;
/*    */   private static final String __OBFID = "CL_00001365";
/*    */   
/*    */   public C07PacketPlayerDigging() {}
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public C07PacketPlayerDigging(int p_i45258_1_, int p_i45258_2_, int p_i45258_3_, int p_i45258_4_, int p_i45258_5_) {
/* 26 */     this.field_149508_e = p_i45258_1_;
/* 27 */     this.field_149511_a = p_i45258_2_;
/* 28 */     this.field_149509_b = p_i45258_3_;
/* 29 */     this.field_149510_c = p_i45258_4_;
/* 30 */     this.field_149507_d = p_i45258_5_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 35 */     this.field_149508_e = p_148837_1_.readUnsignedByte();
/* 36 */     this.field_149511_a = p_148837_1_.readInt();
/* 37 */     this.field_149509_b = p_148837_1_.readUnsignedByte();
/* 38 */     this.field_149510_c = p_148837_1_.readInt();
/* 39 */     this.field_149507_d = p_148837_1_.readUnsignedByte();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 44 */     p_148840_1_.writeByte(this.field_149508_e);
/* 45 */     p_148840_1_.writeInt(this.field_149511_a);
/* 46 */     p_148840_1_.writeByte(this.field_149509_b);
/* 47 */     p_148840_1_.writeInt(this.field_149510_c);
/* 48 */     p_148840_1_.writeByte(this.field_149507_d);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayServer p_148833_1_) {
/* 53 */     p_148833_1_.func_147345_a(this);
/*    */   }
/*    */   
/*    */   public int func_149505_c() {
/* 57 */     return this.field_149511_a;
/*    */   }
/*    */   
/*    */   public int func_149503_d() {
/* 61 */     return this.field_149509_b;
/*    */   }
/*    */   
/*    */   public int func_149502_e() {
/* 65 */     return this.field_149510_c;
/*    */   }
/*    */   
/*    */   public int func_149501_f() {
/* 69 */     return this.field_149507_d;
/*    */   }
/*    */   
/*    */   public int func_149506_g() {
/* 73 */     return this.field_149508_e;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\client\C07PacketPlayerDigging.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */