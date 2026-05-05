/*    */ package net.minecraft.world.gen.layer;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class IntCache {
/*  7 */   private static int field_76451_a = 256;
/*    */   
/*  9 */   private static List field_76449_b = new ArrayList();
/* 10 */   private static List field_76450_c = new ArrayList();
/*    */   
/* 12 */   private static List field_76447_d = new ArrayList();
/* 13 */   private static List field_76448_e = new ArrayList();
/*    */   
/*    */   public static synchronized int[] func_76445_a(int p_76445_0_) {
/* 16 */     if (p_76445_0_ <= 256) {
/* 17 */       if (field_76449_b.isEmpty()) {
/* 18 */         int[] arrayOfInt2 = new int[256];
/* 19 */         field_76450_c.add(arrayOfInt2);
/* 20 */         return arrayOfInt2;
/*    */       } 
/* 22 */       int[] arrayOfInt1 = field_76449_b.remove(field_76449_b.size() - 1);
/* 23 */       field_76450_c.add(arrayOfInt1);
/* 24 */       return arrayOfInt1;
/*    */     } 
/*    */ 
/*    */     
/* 28 */     if (p_76445_0_ > field_76451_a) {
/* 29 */       field_76451_a = p_76445_0_;
/*    */       
/* 31 */       field_76447_d.clear();
/* 32 */       field_76448_e.clear();
/*    */       
/* 34 */       int[] arrayOfInt1 = new int[field_76451_a];
/* 35 */       field_76448_e.add(arrayOfInt1);
/* 36 */       return arrayOfInt1;
/*    */     } 
/* 38 */     if (field_76447_d.isEmpty()) {
/* 39 */       int[] arrayOfInt1 = new int[field_76451_a];
/* 40 */       field_76448_e.add(arrayOfInt1);
/* 41 */       return arrayOfInt1;
/*    */     } 
/* 43 */     int[] arrayOfInt = field_76447_d.remove(field_76447_d.size() - 1);
/* 44 */     field_76448_e.add(arrayOfInt);
/* 45 */     return arrayOfInt;
/*    */   }
/*    */   
/*    */   private static final String __OBFID = "CL_00000557";
/*    */   
/*    */   public static synchronized void func_76446_a() {
/* 51 */     if (!field_76447_d.isEmpty()) field_76447_d.remove(field_76447_d.size() - 1); 
/* 52 */     if (!field_76449_b.isEmpty()) field_76449_b.remove(field_76449_b.size() - 1);
/*    */     
/* 54 */     field_76447_d.addAll(field_76448_e);
/* 55 */     field_76449_b.addAll(field_76450_c);
/*    */     
/* 57 */     field_76448_e.clear();
/* 58 */     field_76450_c.clear();
/*    */   }
/*    */   
/*    */   public static synchronized String func_85144_b() {
/* 62 */     return "cache: " + field_76447_d.size() + ", tcache: " + field_76449_b.size() + ", allocated: " + field_76448_e.size() + ", tallocated: " + field_76450_c.size();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\layer\IntCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */