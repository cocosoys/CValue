/*    */ package net.minecraft.network.play.server;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayClient;
/*    */ import net.minecraft.scoreboard.Score;
/*    */ 
/*    */ 
/*    */ public class S3CPacketUpdateScore
/*    */   extends Packet
/*    */ {
/* 16 */   private String field_149329_a = "";
/* 17 */   private String field_149327_b = "";
/*    */   
/*    */   private int field_149328_c;
/*    */   
/*    */   private int field_149326_d;
/*    */   private static final String __OBFID = "CL_00001335";
/*    */   
/*    */   public S3CPacketUpdateScore(Score p_i45227_1_, int p_i45227_2_) {
/* 25 */     this.field_149329_a = p_i45227_1_.func_96653_e();
/* 26 */     this.field_149327_b = p_i45227_1_.func_96645_d().func_96679_b();
/* 27 */     this.field_149328_c = p_i45227_1_.func_96652_c();
/* 28 */     this.field_149326_d = p_i45227_2_;
/*    */   }
/*    */   
/*    */   public S3CPacketUpdateScore(String p_i45228_1_) {
/* 32 */     this.field_149329_a = p_i45228_1_;
/* 33 */     this.field_149327_b = "";
/* 34 */     this.field_149328_c = 0;
/* 35 */     this.field_149326_d = 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 40 */     this.field_149329_a = p_148837_1_.func_150789_c(16);
/* 41 */     this.field_149326_d = p_148837_1_.readByte();
/*    */     
/* 43 */     if (this.field_149326_d != 1) {
/* 44 */       this.field_149327_b = p_148837_1_.func_150789_c(16);
/* 45 */       this.field_149328_c = p_148837_1_.readInt();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 51 */     p_148840_1_.func_150785_a(this.field_149329_a);
/* 52 */     p_148840_1_.writeByte(this.field_149326_d);
/*    */     
/* 54 */     if (this.field_149326_d != 1) {
/* 55 */       p_148840_1_.func_150785_a(this.field_149327_b);
/* 56 */       p_148840_1_.writeInt(this.field_149328_c);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 62 */     p_148833_1_.func_147250_a(this);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public String func_149324_c() {
/* 66 */     return this.field_149329_a;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public String func_149321_d() {
/* 70 */     return this.field_149327_b;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149323_e() {
/* 74 */     return this.field_149328_c;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149322_f() {
/* 78 */     return this.field_149326_d;
/*    */   }
/*    */   
/*    */   public S3CPacketUpdateScore() {}
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S3CPacketUpdateScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */