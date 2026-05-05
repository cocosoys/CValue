/*    */ package net.minecraft.util;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.Random;
/*    */ 
/*    */ public class WeightedRandom {
/*    */   public static int func_76272_a(Collection p_76272_0_) {
/*  8 */     int i = 0;
/*  9 */     for (Item item : p_76272_0_) {
/* 10 */       i += item.field_76292_a;
/*    */     }
/* 12 */     return i;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001503";
/*    */   public static Item func_76273_a(Random p_76273_0_, Collection p_76273_1_, int p_76273_2_) {
/* 16 */     if (p_76273_2_ <= 0) {
/* 17 */       throw new IllegalArgumentException();
/*    */     }
/*    */     
/* 20 */     int i = p_76273_0_.nextInt(p_76273_2_);
/* 21 */     for (Item item : p_76273_1_) {
/* 22 */       i -= item.field_76292_a;
/* 23 */       if (i < 0) {
/* 24 */         return item;
/*    */       }
/*    */     } 
/* 27 */     return null;
/*    */   }
/*    */   
/*    */   public static Item func_76271_a(Random p_76271_0_, Collection p_76271_1_) {
/* 31 */     return func_76273_a(p_76271_0_, p_76271_1_, func_76272_a(p_76271_1_));
/*    */   }
/*    */   
/*    */   public static int func_76270_a(Item[] p_76270_0_) {
/* 35 */     int i = 0;
/* 36 */     for (Item item : p_76270_0_) {
/* 37 */       i += item.field_76292_a;
/*    */     }
/* 39 */     return i;
/*    */   }
/*    */ 
/*    */   
/*    */   public static Item func_76269_a(Random p_76269_0_, Item[] p_76269_1_, int p_76269_2_) {
/* 44 */     if (p_76269_2_ <= 0) {
/* 45 */       throw new IllegalArgumentException();
/*    */     }
/*    */     
/* 48 */     int i = p_76269_0_.nextInt(p_76269_2_);
/* 49 */     for (Item item : p_76269_1_) {
/* 50 */       i -= item.field_76292_a;
/* 51 */       if (i < 0) {
/* 52 */         return item;
/*    */       }
/*    */     } 
/* 55 */     return null;
/*    */   }
/*    */   
/*    */   public static Item func_76274_a(Random p_76274_0_, Item[] p_76274_1_) {
/* 59 */     return func_76269_a(p_76274_0_, p_76274_1_, func_76270_a(p_76274_1_));
/*    */   }
/*    */   
/*    */   public static class Item { public int field_76292_a;
/*    */     private static final String __OBFID = "CL_00001504";
/*    */     
/*    */     public Item(int p_i1556_1_) {
/* 66 */       this.field_76292_a = p_i1556_1_;
/*    */     } }
/*    */ 
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\WeightedRandom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */