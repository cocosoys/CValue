/*    */ package net.minecraft.client.gui;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.util.MathHelper;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ScaledResolution {
/*    */   private int field_78333_a;
/*    */   private int field_78331_b;
/*    */   private double field_78332_c;
/*    */   
/*    */   public ScaledResolution(Minecraft p_i1094_1_, int p_i1094_2_, int p_i1094_3_) {
/* 15 */     this.field_78333_a = p_i1094_2_;
/* 16 */     this.field_78331_b = p_i1094_3_;
/* 17 */     this.field_78330_e = 1;
/*    */     
/* 19 */     boolean bool = p_i1094_1_.func_152349_b();
/* 20 */     int i = p_i1094_1_.field_71474_y.field_74335_Z;
/* 21 */     if (i == 0) i = 1000; 
/* 22 */     while (this.field_78330_e < i && this.field_78333_a / (this.field_78330_e + 1) >= 320 && this.field_78331_b / (this.field_78330_e + 1) >= 240) {
/* 23 */       this.field_78330_e++;
/*    */     }
/* 25 */     if (bool && this.field_78330_e % 2 != 0 && this.field_78330_e != 1) {
/* 26 */       this.field_78330_e--;
/*    */     }
/* 28 */     this.field_78332_c = this.field_78333_a / this.field_78330_e;
/* 29 */     this.field_78329_d = this.field_78331_b / this.field_78330_e;
/* 30 */     this.field_78333_a = MathHelper.func_76143_f(this.field_78332_c);
/* 31 */     this.field_78331_b = MathHelper.func_76143_f(this.field_78329_d);
/*    */   }
/*    */   private double field_78329_d; private int field_78330_e; private static final String __OBFID = "CL_00000666";
/*    */   public int func_78326_a() {
/* 35 */     return this.field_78333_a;
/*    */   }
/*    */   
/*    */   public int func_78328_b() {
/* 39 */     return this.field_78331_b;
/*    */   }
/*    */   
/*    */   public double func_78327_c() {
/* 43 */     return this.field_78332_c;
/*    */   }
/*    */   
/*    */   public double func_78324_d() {
/* 47 */     return this.field_78329_d;
/*    */   }
/*    */   
/*    */   public int func_78325_e() {
/* 51 */     return this.field_78330_e;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\ScaledResolution.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */