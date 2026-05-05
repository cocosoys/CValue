/*    */ package net.minecraft.client.renderer;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class DestroyBlockProgress
/*    */ {
/*    */   private final int field_73115_a;
/*    */   
/*    */   public DestroyBlockProgress(int p_i1511_1_, int p_i1511_2_, int p_i1511_3_, int p_i1511_4_) {
/* 12 */     this.field_73115_a = p_i1511_1_;
/* 13 */     this.field_73113_b = p_i1511_2_;
/* 14 */     this.field_73114_c = p_i1511_3_;
/* 15 */     this.field_73111_d = p_i1511_4_;
/*    */   }
/*    */   private final int field_73113_b; private final int field_73114_c; private final int field_73111_d;
/*    */   private int field_73112_e;
/*    */   private int field_82745_f;
/*    */   private static final String __OBFID = "CL_00001427";
/*    */   
/*    */   public int func_73110_b() {
/* 23 */     return this.field_73113_b;
/*    */   }
/*    */   
/*    */   public int func_73109_c() {
/* 27 */     return this.field_73114_c;
/*    */   }
/*    */   
/*    */   public int func_73108_d() {
/* 31 */     return this.field_73111_d;
/*    */   }
/*    */   
/*    */   public void func_73107_a(int p_73107_1_) {
/* 35 */     if (p_73107_1_ > 10) {
/* 36 */       p_73107_1_ = 10;
/*    */     }
/* 38 */     this.field_73112_e = p_73107_1_;
/*    */   }
/*    */   
/*    */   public int func_73106_e() {
/* 42 */     return this.field_73112_e;
/*    */   }
/*    */   
/*    */   public void func_82744_b(int p_82744_1_) {
/* 46 */     this.field_82745_f = p_82744_1_;
/*    */   }
/*    */   
/*    */   public int func_82743_f() {
/* 50 */     return this.field_82745_f;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\DestroyBlockProgress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */