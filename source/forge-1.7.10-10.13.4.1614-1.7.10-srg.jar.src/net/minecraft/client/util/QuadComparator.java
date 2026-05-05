/*    */ package net.minecraft.client.util;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Comparator;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class QuadComparator implements Comparator {
/*    */   private float field_147630_a;
/*    */   private float field_147628_b;
/*    */   
/*    */   public QuadComparator(int[] p_i45077_1_, float p_i45077_2_, float p_i45077_3_, float p_i45077_4_) {
/* 13 */     this.field_147627_d = p_i45077_1_;
/* 14 */     this.field_147630_a = p_i45077_2_;
/* 15 */     this.field_147628_b = p_i45077_3_;
/* 16 */     this.field_147629_c = p_i45077_4_;
/*    */   }
/*    */   private float field_147629_c; private int[] field_147627_d; private static final String __OBFID = "CL_00000958";
/*    */   
/*    */   public int compare(Integer p_compare_1_, Integer p_compare_2_) {
/* 21 */     float f1 = Float.intBitsToFloat(this.field_147627_d[p_compare_1_.intValue()]) - this.field_147630_a;
/* 22 */     float f2 = Float.intBitsToFloat(this.field_147627_d[p_compare_1_.intValue() + 1]) - this.field_147628_b;
/* 23 */     float f3 = Float.intBitsToFloat(this.field_147627_d[p_compare_1_.intValue() + 2]) - this.field_147629_c;
/* 24 */     float f4 = Float.intBitsToFloat(this.field_147627_d[p_compare_1_.intValue() + 8]) - this.field_147630_a;
/* 25 */     float f5 = Float.intBitsToFloat(this.field_147627_d[p_compare_1_.intValue() + 9]) - this.field_147628_b;
/* 26 */     float f6 = Float.intBitsToFloat(this.field_147627_d[p_compare_1_.intValue() + 10]) - this.field_147629_c;
/* 27 */     float f7 = Float.intBitsToFloat(this.field_147627_d[p_compare_1_.intValue() + 16]) - this.field_147630_a;
/* 28 */     float f8 = Float.intBitsToFloat(this.field_147627_d[p_compare_1_.intValue() + 17]) - this.field_147628_b;
/* 29 */     float f9 = Float.intBitsToFloat(this.field_147627_d[p_compare_1_.intValue() + 18]) - this.field_147629_c;
/* 30 */     float f10 = Float.intBitsToFloat(this.field_147627_d[p_compare_1_.intValue() + 24]) - this.field_147630_a;
/* 31 */     float f11 = Float.intBitsToFloat(this.field_147627_d[p_compare_1_.intValue() + 25]) - this.field_147628_b;
/* 32 */     float f12 = Float.intBitsToFloat(this.field_147627_d[p_compare_1_.intValue() + 26]) - this.field_147629_c;
/*    */     
/* 34 */     float f13 = Float.intBitsToFloat(this.field_147627_d[p_compare_2_.intValue()]) - this.field_147630_a;
/* 35 */     float f14 = Float.intBitsToFloat(this.field_147627_d[p_compare_2_.intValue() + 1]) - this.field_147628_b;
/* 36 */     float f15 = Float.intBitsToFloat(this.field_147627_d[p_compare_2_.intValue() + 2]) - this.field_147629_c;
/* 37 */     float f16 = Float.intBitsToFloat(this.field_147627_d[p_compare_2_.intValue() + 8]) - this.field_147630_a;
/* 38 */     float f17 = Float.intBitsToFloat(this.field_147627_d[p_compare_2_.intValue() + 9]) - this.field_147628_b;
/* 39 */     float f18 = Float.intBitsToFloat(this.field_147627_d[p_compare_2_.intValue() + 10]) - this.field_147629_c;
/* 40 */     float f19 = Float.intBitsToFloat(this.field_147627_d[p_compare_2_.intValue() + 16]) - this.field_147630_a;
/* 41 */     float f20 = Float.intBitsToFloat(this.field_147627_d[p_compare_2_.intValue() + 17]) - this.field_147628_b;
/* 42 */     float f21 = Float.intBitsToFloat(this.field_147627_d[p_compare_2_.intValue() + 18]) - this.field_147629_c;
/* 43 */     float f22 = Float.intBitsToFloat(this.field_147627_d[p_compare_2_.intValue() + 24]) - this.field_147630_a;
/* 44 */     float f23 = Float.intBitsToFloat(this.field_147627_d[p_compare_2_.intValue() + 25]) - this.field_147628_b;
/* 45 */     float f24 = Float.intBitsToFloat(this.field_147627_d[p_compare_2_.intValue() + 26]) - this.field_147629_c;
/*    */     
/* 47 */     float f25 = (f1 + f4 + f7 + f10) * 0.25F;
/* 48 */     float f26 = (f2 + f5 + f8 + f11) * 0.25F;
/* 49 */     float f27 = (f3 + f6 + f9 + f12) * 0.25F;
/*    */     
/* 51 */     float f28 = (f13 + f16 + f19 + f22) * 0.25F;
/* 52 */     float f29 = (f14 + f17 + f20 + f23) * 0.25F;
/* 53 */     float f30 = (f15 + f18 + f21 + f24) * 0.25F;
/*    */     
/* 55 */     float f31 = f25 * f25 + f26 * f26 + f27 * f27;
/* 56 */     float f32 = f28 * f28 + f29 * f29 + f30 * f30;
/*    */     
/* 58 */     return Float.compare(f32, f31);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\clien\\util\QuadComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */