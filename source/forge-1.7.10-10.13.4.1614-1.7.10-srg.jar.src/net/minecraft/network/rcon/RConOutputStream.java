/*    */ package net.minecraft.network.rcon;
/*    */ import java.io.DataOutputStream;
/*    */ import java.io.IOException;
/*    */ 
/*    */ @SideOnly(Side.SERVER)
/*    */ public class RConOutputStream {
/*    */   private ByteArrayOutputStream field_72674_a;
/*    */   
/*    */   public RConOutputStream(int p_i1533_1_) {
/* 10 */     this.field_72674_a = new ByteArrayOutputStream(p_i1533_1_);
/* 11 */     this.field_72673_b = new DataOutputStream(this.field_72674_a);
/*    */   }
/*    */   private DataOutputStream field_72673_b; private static final String __OBFID = "CL_00001798";
/*    */   public void func_72670_a(byte[] p_72670_1_) throws IOException {
/* 15 */     this.field_72673_b.write(p_72670_1_, 0, p_72670_1_.length);
/*    */   }
/*    */   
/*    */   public void func_72671_a(String p_72671_1_) throws IOException {
/* 19 */     this.field_72673_b.writeBytes(p_72671_1_);
/* 20 */     this.field_72673_b.write(0);
/*    */   }
/*    */   
/*    */   public void func_72667_a(int p_72667_1_) throws IOException {
/* 24 */     this.field_72673_b.write(p_72667_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_72668_a(short p_72668_1_) throws IOException {
/* 29 */     this.field_72673_b.writeShort(Short.reverseBytes(p_72668_1_));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public byte[] func_72672_a() {
/* 41 */     return this.field_72674_a.toByteArray();
/*    */   }
/*    */   
/*    */   public void func_72669_b() {
/* 45 */     this.field_72674_a.reset();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\rcon\RConOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */