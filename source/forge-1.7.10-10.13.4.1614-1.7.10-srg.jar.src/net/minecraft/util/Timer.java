/*    */ package net.minecraft.util;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.Minecraft;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class Timer {
/*    */   float field_74282_a;
/* 10 */   public float field_74278_d = 1.0F; private double field_74276_f; public int field_74280_b;
/*    */   public float field_74281_c;
/*    */   public float field_74279_e;
/*    */   private long field_74277_g;
/*    */   private long field_74284_h;
/*    */   private long field_74285_i;
/* 16 */   private double field_74283_j = 1.0D; private static final String __OBFID = "CL_00000658";
/*    */   
/*    */   public Timer(float p_i1018_1_) {
/* 19 */     this.field_74282_a = p_i1018_1_;
/* 20 */     this.field_74277_g = Minecraft.func_71386_F();
/* 21 */     this.field_74284_h = System.nanoTime() / 1000000L;
/*    */   }
/*    */   
/*    */   public void func_74275_a() {
/* 25 */     long l1 = Minecraft.func_71386_F();
/* 26 */     long l2 = l1 - this.field_74277_g;
/* 27 */     long l3 = System.nanoTime() / 1000000L;
/* 28 */     double d1 = l3 / 1000.0D;
/*    */     
/* 30 */     if (l2 > 1000L || l2 < 0L) {
/* 31 */       this.field_74276_f = d1;
/*    */     } else {
/* 33 */       this.field_74285_i += l2;
/* 34 */       if (this.field_74285_i > 1000L) {
/* 35 */         long l = l3 - this.field_74284_h;
/*    */         
/* 37 */         double d = this.field_74285_i / l;
/* 38 */         this.field_74283_j += (d - this.field_74283_j) * 0.20000000298023224D;
/*    */         
/* 40 */         this.field_74284_h = l3;
/* 41 */         this.field_74285_i = 0L;
/*    */       } 
/* 43 */       if (this.field_74285_i < 0L) {
/* 44 */         this.field_74284_h = l3;
/*    */       }
/*    */     } 
/* 47 */     this.field_74277_g = l1;
/*    */     
/* 49 */     double d2 = (d1 - this.field_74276_f) * this.field_74283_j;
/* 50 */     this.field_74276_f = d1;
/*    */     
/* 52 */     if (d2 < 0.0D) d2 = 0.0D; 
/* 53 */     if (d2 > 1.0D) d2 = 1.0D;
/*    */     
/* 55 */     this.field_74279_e = (float)(this.field_74279_e + d2 * this.field_74278_d * this.field_74282_a);
/*    */     
/* 57 */     this.field_74280_b = (int)this.field_74279_e;
/* 58 */     this.field_74279_e -= this.field_74280_b;
/* 59 */     if (this.field_74280_b > 10) this.field_74280_b = 10; 
/* 60 */     this.field_74281_c = this.field_74279_e;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\Timer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */