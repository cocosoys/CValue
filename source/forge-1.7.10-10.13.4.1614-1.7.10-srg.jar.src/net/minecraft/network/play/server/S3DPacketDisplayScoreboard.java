/*    */ package net.minecraft.network.play.server;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayClient;
/*    */ import net.minecraft.scoreboard.ScoreObjective;
/*    */ 
/*    */ public class S3DPacketDisplayScoreboard extends Packet {
/*    */   private int field_149374_a;
/*    */   private String field_149373_b;
/*    */   
/*    */   public S3DPacketDisplayScoreboard(int p_i45216_1_, ScoreObjective p_i45216_2_) {
/* 17 */     this.field_149374_a = p_i45216_1_;
/*    */     
/* 19 */     if (p_i45216_2_ == null) {
/* 20 */       this.field_149373_b = "";
/*    */     } else {
/* 22 */       this.field_149373_b = p_i45216_2_.func_96679_b();
/*    */     } 
/*    */   }
/*    */   private static final String __OBFID = "CL_00001325";
/*    */   public S3DPacketDisplayScoreboard() {}
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 28 */     this.field_149374_a = p_148837_1_.readByte();
/* 29 */     this.field_149373_b = p_148837_1_.func_150789_c(16);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 34 */     p_148840_1_.writeByte(this.field_149374_a);
/* 35 */     p_148840_1_.func_150785_a(this.field_149373_b);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 40 */     p_148833_1_.func_147254_a(this);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149371_c() {
/* 44 */     return this.field_149374_a;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public String func_149370_d() {
/* 48 */     return this.field_149373_b;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S3DPacketDisplayScoreboard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */