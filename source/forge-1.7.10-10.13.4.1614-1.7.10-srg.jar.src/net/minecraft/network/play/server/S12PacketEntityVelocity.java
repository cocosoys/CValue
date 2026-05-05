/*    */ package net.minecraft.network.play.server;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayClient;
/*    */ 
/*    */ public class S12PacketEntityVelocity
/*    */   extends Packet {
/*    */   private int field_149417_a;
/*    */   private int field_149415_b;
/*    */   private int field_149416_c;
/*    */   
/*    */   public S12PacketEntityVelocity(Entity p_i45219_1_) {
/* 19 */     this(p_i45219_1_.func_145782_y(), p_i45219_1_.field_70159_w, p_i45219_1_.field_70181_x, p_i45219_1_.field_70179_y);
/*    */   } private int field_149414_d; private static final String __OBFID = "CL_00001328";
/*    */   public S12PacketEntityVelocity() {}
/*    */   public S12PacketEntityVelocity(int p_i45220_1_, double p_i45220_2_, double p_i45220_4_, double p_i45220_6_) {
/* 23 */     this.field_149417_a = p_i45220_1_;
/* 24 */     double d = 3.9D;
/* 25 */     if (p_i45220_2_ < -d) p_i45220_2_ = -d; 
/* 26 */     if (p_i45220_4_ < -d) p_i45220_4_ = -d; 
/* 27 */     if (p_i45220_6_ < -d) p_i45220_6_ = -d; 
/* 28 */     if (p_i45220_2_ > d) p_i45220_2_ = d; 
/* 29 */     if (p_i45220_4_ > d) p_i45220_4_ = d; 
/* 30 */     if (p_i45220_6_ > d) p_i45220_6_ = d; 
/* 31 */     this.field_149415_b = (int)(p_i45220_2_ * 8000.0D);
/* 32 */     this.field_149416_c = (int)(p_i45220_4_ * 8000.0D);
/* 33 */     this.field_149414_d = (int)(p_i45220_6_ * 8000.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 38 */     this.field_149417_a = p_148837_1_.readInt();
/* 39 */     this.field_149415_b = p_148837_1_.readShort();
/* 40 */     this.field_149416_c = p_148837_1_.readShort();
/* 41 */     this.field_149414_d = p_148837_1_.readShort();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 46 */     p_148840_1_.writeInt(this.field_149417_a);
/* 47 */     p_148840_1_.writeShort(this.field_149415_b);
/* 48 */     p_148840_1_.writeShort(this.field_149416_c);
/* 49 */     p_148840_1_.writeShort(this.field_149414_d);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 54 */     p_148833_1_.func_147244_a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_148835_b() {
/* 59 */     return String.format("id=%d, x=%.2f, y=%.2f, z=%.2f", new Object[] { Integer.valueOf(this.field_149417_a), Float.valueOf(this.field_149415_b / 8000.0F), Float.valueOf(this.field_149416_c / 8000.0F), Float.valueOf(this.field_149414_d / 8000.0F) });
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149412_c() {
/* 63 */     return this.field_149417_a;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149411_d() {
/* 67 */     return this.field_149415_b;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149410_e() {
/* 71 */     return this.field_149416_c;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149409_f() {
/* 75 */     return this.field_149414_d;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S12PacketEntityVelocity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */