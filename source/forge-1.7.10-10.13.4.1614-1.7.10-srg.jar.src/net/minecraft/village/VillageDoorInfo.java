/*    */ package net.minecraft.village;
/*    */ 
/*    */ public class VillageDoorInfo {
/*    */   public VillageDoorInfo(int p_i1673_1_, int p_i1673_2_, int p_i1673_3_, int p_i1673_4_, int p_i1673_5_, int p_i1673_6_) {
/*  5 */     this.field_75481_a = p_i1673_1_;
/*  6 */     this.field_75479_b = p_i1673_2_;
/*  7 */     this.field_75480_c = p_i1673_3_;
/*  8 */     this.field_75477_d = p_i1673_4_;
/*  9 */     this.field_75478_e = p_i1673_5_;
/* 10 */     this.field_75475_f = p_i1673_6_;
/*    */   }
/*    */ 
/*    */   
/*    */   public final int field_75481_a;
/*    */   
/*    */   public final int field_75479_b;
/*    */   
/*    */   public final int field_75480_c;
/*    */   public final int field_75477_d;
/*    */   public final int field_75478_e;
/*    */   public int field_75475_f;
/*    */   public boolean field_75476_g;
/*    */   private int field_75482_h;
/*    */   private static final String __OBFID = "CL_00001630";
/*    */   
/*    */   public int func_75474_b(int p_75474_1_, int p_75474_2_, int p_75474_3_) {
/* 27 */     int i = p_75474_1_ - this.field_75481_a;
/* 28 */     int j = p_75474_2_ - this.field_75479_b;
/* 29 */     int k = p_75474_3_ - this.field_75480_c;
/* 30 */     return i * i + j * j + k * k;
/*    */   }
/*    */   
/*    */   public int func_75469_c(int p_75469_1_, int p_75469_2_, int p_75469_3_) {
/* 34 */     int i = p_75469_1_ - this.field_75481_a - this.field_75477_d;
/* 35 */     int j = p_75469_2_ - this.field_75479_b;
/* 36 */     int k = p_75469_3_ - this.field_75480_c - this.field_75478_e;
/* 37 */     return i * i + j * j + k * k;
/*    */   }
/*    */   
/*    */   public int func_75471_a() {
/* 41 */     return this.field_75481_a + this.field_75477_d;
/*    */   }
/*    */   
/*    */   public int func_75473_b() {
/* 45 */     return this.field_75479_b;
/*    */   }
/*    */   
/*    */   public int func_75472_c() {
/* 49 */     return this.field_75480_c + this.field_75478_e;
/*    */   }
/*    */   
/*    */   public boolean func_75467_a(int p_75467_1_, int p_75467_2_) {
/* 53 */     int i = p_75467_1_ - this.field_75481_a;
/* 54 */     int j = p_75467_2_ - this.field_75480_c;
/* 55 */     return (i * this.field_75477_d + j * this.field_75478_e >= 0);
/*    */   }
/*    */   
/*    */   public void func_75466_d() {
/* 59 */     this.field_75482_h = 0;
/*    */   }
/*    */   
/*    */   public void func_75470_e() {
/* 63 */     this.field_75482_h++;
/*    */   }
/*    */   
/*    */   public int func_75468_f() {
/* 67 */     return this.field_75482_h;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\village\VillageDoorInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */