/*     */ package net.minecraft.client.stream;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import tv.twitch.ErrorCode;
/*     */ import tv.twitch.broadcast.IngestServer;
/*     */ import tv.twitch.chat.ChatUserInfo;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class NullStream implements IStream {
/*     */   private final Throwable field_152938_a;
/*     */   
/*     */   public NullStream(Throwable p_i1006_1_) {
/*  14 */     this.field_152938_a = p_i1006_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   private static final String __OBFID = "CL_00001809";
/*     */ 
/*     */   
/*     */   public void func_152923_i() {}
/*     */ 
/*     */   
/*     */   public void func_152935_j() {}
/*     */ 
/*     */   
/*     */   public void func_152922_k() {}
/*     */ 
/*     */   
/*     */   public boolean func_152936_l() {
/*  31 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_152924_m() {
/*  36 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_152934_n() {
/*  41 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_152911_a(Metadata p_152911_1_, long p_152911_2_) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_152919_o() {
/*  54 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_152931_p() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_152916_q() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_152933_r() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_152915_s() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_152930_t() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_152914_u() {}
/*     */ 
/*     */   
/*     */   public IngestServer[] func_152925_v() {
/*  83 */     return new IngestServer[0];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_152909_x() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IngestServerTester func_152932_y() {
/*  97 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_152908_z() {
/* 102 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_152920_A() {
/* 107 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_152927_B() {
/* 112 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_152921_C() {
/* 117 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public ChatUserInfo func_152926_a(String p_152926_1_) {
/* 122 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_152917_b(String p_152917_1_) {}
/*     */ 
/*     */   
/*     */   public boolean func_152928_D() {
/* 131 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public ErrorCode func_152912_E() {
/* 136 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_152913_F() {
/* 141 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_152910_a(boolean p_152910_1_) {}
/*     */ 
/*     */   
/*     */   public boolean func_152929_G() {
/* 150 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IStream.AuthFailureReason func_152918_H() {
/* 156 */     return IStream.AuthFailureReason.ERROR;
/*     */   }
/*     */   
/*     */   public Throwable func_152937_a() {
/* 160 */     return this.field_152938_a;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\stream\NullStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */