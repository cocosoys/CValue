/*    */ package net.minecraft.client.util;
/*    */ 
/*    */ import com.google.common.collect.ComparisonChain;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Comparator;
/*    */ import net.minecraft.client.renderer.RenderList;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderDistanceSorter
/*    */   implements Comparator {
/*    */   public RenderDistanceSorter(int p_i1051_1_, int p_i1051_2_) {
/* 13 */     this.field_152632_a = p_i1051_1_;
/* 14 */     this.field_152633_b = p_i1051_2_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   int field_152632_a;
/*    */   
/*    */   int field_152633_b;
/*    */   
/*    */   private static final String __OBFID = "CL_00000945";
/*    */ 
/*    */   
/*    */   public int compare(RenderList p_compare_1_, RenderList p_compare_2_) {
/* 27 */     int i = p_compare_1_.field_78429_a - this.field_152632_a;
/* 28 */     int j = p_compare_1_.field_78428_c - this.field_152633_b;
/* 29 */     int k = p_compare_2_.field_78429_a - this.field_152632_a;
/* 30 */     int m = p_compare_2_.field_78428_c - this.field_152633_b;
/* 31 */     int n = i * i + j * j;
/* 32 */     int i1 = k * k + m * m;
/* 33 */     return ComparisonChain.start().compare(i1, n).result();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\clien\\util\RenderDistanceSorter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */