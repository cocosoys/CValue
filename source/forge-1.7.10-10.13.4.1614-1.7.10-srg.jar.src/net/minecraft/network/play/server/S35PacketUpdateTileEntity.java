/*    */ package net.minecraft.network.play.server;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayClient;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class S35PacketUpdateTileEntity
/*    */   extends Packet
/*    */ {
/*    */   private int field_148863_a;
/*    */   private int field_148861_b;
/*    */   private int field_148862_c;
/*    */   private int field_148859_d;
/*    */   private NBTTagCompound field_148860_e;
/*    */   private static final String __OBFID = "CL_00001285";
/*    */   
/*    */   public S35PacketUpdateTileEntity() {}
/*    */   
/*    */   public S35PacketUpdateTileEntity(int p_i45175_1_, int p_i45175_2_, int p_i45175_3_, int p_i45175_4_, NBTTagCompound p_i45175_5_) {
/* 28 */     this.field_148863_a = p_i45175_1_;
/* 29 */     this.field_148861_b = p_i45175_2_;
/* 30 */     this.field_148862_c = p_i45175_3_;
/* 31 */     this.field_148859_d = p_i45175_4_;
/* 32 */     this.field_148860_e = p_i45175_5_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 37 */     this.field_148863_a = p_148837_1_.readInt();
/* 38 */     this.field_148861_b = p_148837_1_.readShort();
/* 39 */     this.field_148862_c = p_148837_1_.readInt();
/* 40 */     this.field_148859_d = p_148837_1_.readUnsignedByte();
/* 41 */     this.field_148860_e = p_148837_1_.func_150793_b();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 46 */     p_148840_1_.writeInt(this.field_148863_a);
/* 47 */     p_148840_1_.writeShort(this.field_148861_b);
/* 48 */     p_148840_1_.writeInt(this.field_148862_c);
/* 49 */     p_148840_1_.writeByte((byte)this.field_148859_d);
/* 50 */     p_148840_1_.func_150786_a(this.field_148860_e);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 55 */     p_148833_1_.func_147273_a(this);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_148856_c() {
/* 59 */     return this.field_148863_a;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_148855_d() {
/* 63 */     return this.field_148861_b;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_148854_e() {
/* 67 */     return this.field_148862_c;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_148853_f() {
/* 71 */     return this.field_148859_d;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public NBTTagCompound func_148857_g() {
/* 75 */     return this.field_148860_e;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S35PacketUpdateTileEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */