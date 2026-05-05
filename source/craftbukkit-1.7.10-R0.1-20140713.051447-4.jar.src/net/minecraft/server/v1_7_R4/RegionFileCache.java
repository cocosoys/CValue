/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ import java.io.DataInputStream;
/*    */ import java.io.DataOutputStream;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RegionFileCache
/*    */ {
/* 38 */   private static final Map a = new HashMap<Object, Object>();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static synchronized RegionFile a(File paramFile, int paramInt1, int paramInt2) {
/* 44 */     File file1 = new File(paramFile, "region");
/* 45 */     File file2 = new File(file1, "r." + (paramInt1 >> 5) + "." + (paramInt2 >> 5) + ".mca");
/*    */     
/* 47 */     RegionFile regionFile1 = (RegionFile)a.get(file2);
/* 48 */     if (regionFile1 != null) {
/* 49 */       return regionFile1;
/*    */     }
/*    */     
/* 52 */     if (!file1.exists()) {
/* 53 */       file1.mkdirs();
/*    */     }
/*    */     
/* 56 */     if (a.size() >= 256) {
/* 57 */       a();
/*    */     }
/*    */     
/* 60 */     RegionFile regionFile2 = new RegionFile(file2);
/* 61 */     a.put(file2, regionFile2);
/* 62 */     return regionFile2;
/*    */   }
/*    */   
/*    */   public static synchronized void a() {
/* 66 */     for (RegionFile regionFile : a.values()) {
/*    */       try {
/* 68 */         if (regionFile != null) {
/* 69 */           regionFile.c();
/*    */         }
/* 71 */       } catch (IOException iOException) {
/* 72 */         iOException.printStackTrace();
/*    */       } 
/*    */     } 
/* 75 */     a.clear();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static DataInputStream c(File paramFile, int paramInt1, int paramInt2) {
/* 84 */     RegionFile regionFile = a(paramFile, paramInt1, paramInt2);
/* 85 */     return regionFile.a(paramInt1 & 0x1F, paramInt2 & 0x1F);
/*    */   }
/*    */   
/*    */   public static DataOutputStream d(File paramFile, int paramInt1, int paramInt2) {
/* 89 */     RegionFile regionFile = a(paramFile, paramInt1, paramInt2);
/* 90 */     return regionFile.b(paramInt1 & 0x1F, paramInt2 & 0x1F);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\RegionFileCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */