/*    */ package net.minecraft.network.play.server;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.entity.item.EntityPainting;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayClient;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class S10PacketSpawnPainting
/*    */   extends Packet
/*    */ {
/*    */   private int field_148973_a;
/*    */   private int field_148971_b;
/*    */   private int field_148972_c;
/*    */   private int field_148969_d;
/*    */   
/*    */   public S10PacketSpawnPainting(EntityPainting p_i45170_1_) {
/* 23 */     this.field_148973_a = p_i45170_1_.func_145782_y();
/* 24 */     this.field_148971_b = p_i45170_1_.field_146063_b;
/* 25 */     this.field_148972_c = p_i45170_1_.field_146064_c;
/* 26 */     this.field_148969_d = p_i45170_1_.field_146062_d;
/* 27 */     this.field_148970_e = p_i45170_1_.field_82332_a;
/* 28 */     this.field_148968_f = p_i45170_1_.field_70522_e.field_75702_A;
/*    */   }
/*    */   private int field_148970_e; private String field_148968_f; private static final String __OBFID = "CL_00001280";
/*    */   public S10PacketSpawnPainting() {}
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 33 */     this.field_148973_a = p_148837_1_.func_150792_a();
/* 34 */     this.field_148968_f = p_148837_1_.func_150789_c(EntityPainting.EnumArt.field_75728_z);
/* 35 */     this.field_148971_b = p_148837_1_.readInt();
/* 36 */     this.field_148972_c = p_148837_1_.readInt();
/* 37 */     this.field_148969_d = p_148837_1_.readInt();
/* 38 */     this.field_148970_e = p_148837_1_.readInt();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 43 */     p_148840_1_.func_150787_b(this.field_148973_a);
/* 44 */     p_148840_1_.func_150785_a(this.field_148968_f);
/* 45 */     p_148840_1_.writeInt(this.field_148971_b);
/* 46 */     p_148840_1_.writeInt(this.field_148972_c);
/* 47 */     p_148840_1_.writeInt(this.field_148969_d);
/* 48 */     p_148840_1_.writeInt(this.field_148970_e);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 53 */     p_148833_1_.func_147288_a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_148835_b() {
/* 58 */     return String.format("id=%d, type=%s, x=%d, y=%d, z=%d", new Object[] { Integer.valueOf(this.field_148973_a), this.field_148968_f, Integer.valueOf(this.field_148971_b), Integer.valueOf(this.field_148972_c), Integer.valueOf(this.field_148969_d) });
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_148965_c() {
/* 62 */     return this.field_148973_a;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_148964_d() {
/* 66 */     return this.field_148971_b;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_148963_e() {
/* 70 */     return this.field_148972_c;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_148962_f() {
/* 74 */     return this.field_148969_d;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_148966_g() {
/* 78 */     return this.field_148970_e;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public String func_148961_h() {
/* 82 */     return this.field_148968_f;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S10PacketSpawnPainting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */