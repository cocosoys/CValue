/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class IntCache {
/*  7 */   private static int a = 256;
/*    */   
/*  9 */   private static List b = new ArrayList();
/* 10 */   private static List c = new ArrayList();
/*    */   
/* 12 */   private static List d = new ArrayList();
/* 13 */   private static List e = new ArrayList();
/*    */   
/*    */   public static synchronized int[] a(int paramInt) {
/* 16 */     if (paramInt <= 256) {
/* 17 */       if (b.isEmpty()) {
/* 18 */         int[] arrayOfInt2 = new int[256];
/* 19 */         c.add(arrayOfInt2);
/* 20 */         return arrayOfInt2;
/*    */       } 
/* 22 */       int[] arrayOfInt1 = b.remove(b.size() - 1);
/* 23 */       c.add(arrayOfInt1);
/* 24 */       return arrayOfInt1;
/*    */     } 
/*    */ 
/*    */     
/* 28 */     if (paramInt > a) {
/* 29 */       a = paramInt;
/*    */       
/* 31 */       d.clear();
/* 32 */       e.clear();
/*    */       
/* 34 */       int[] arrayOfInt1 = new int[a];
/* 35 */       e.add(arrayOfInt1);
/* 36 */       return arrayOfInt1;
/*    */     } 
/* 38 */     if (d.isEmpty()) {
/* 39 */       int[] arrayOfInt1 = new int[a];
/* 40 */       e.add(arrayOfInt1);
/* 41 */       return arrayOfInt1;
/*    */     } 
/* 43 */     int[] arrayOfInt = d.remove(d.size() - 1);
/* 44 */     e.add(arrayOfInt);
/* 45 */     return arrayOfInt;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static synchronized void a() {
/* 51 */     if (!d.isEmpty()) d.remove(d.size() - 1); 
/* 52 */     if (!b.isEmpty()) b.remove(b.size() - 1);
/*    */     
/* 54 */     d.addAll(e);
/* 55 */     b.addAll(c);
/*    */     
/* 57 */     e.clear();
/* 58 */     c.clear();
/*    */   }
/*    */   
/*    */   public static synchronized String b() {
/* 62 */     return "cache: " + d.size() + ", tcache: " + b.size() + ", allocated: " + e.size() + ", tallocated: " + c.size();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\IntCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */