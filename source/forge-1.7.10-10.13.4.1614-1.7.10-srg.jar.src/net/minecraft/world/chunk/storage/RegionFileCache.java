/*    */ package net.minecraft.world.chunk.storage;
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
/* 38 */   private static final Map field_76553_a = new HashMap<Object, Object>();
/*    */   
/*    */   private static final String __OBFID = "CL_00000383";
/*    */ 
/*    */   
/*    */   public static synchronized RegionFile func_76550_a(File p_76550_0_, int p_76550_1_, int p_76550_2_) {
/* 44 */     File file1 = new File(p_76550_0_, "region");
/* 45 */     File file2 = new File(file1, "r." + (p_76550_1_ >> 5) + "." + (p_76550_2_ >> 5) + ".mca");
/*    */     
/* 47 */     RegionFile regionFile1 = (RegionFile)field_76553_a.get(file2);
/* 48 */     if (regionFile1 != null) {
/* 49 */       return regionFile1;
/*    */     }
/*    */     
/* 52 */     if (!file1.exists()) {
/* 53 */       file1.mkdirs();
/*    */     }
/*    */     
/* 56 */     if (field_76553_a.size() >= 256) {
/* 57 */       func_76551_a();
/*    */     }
/*    */     
/* 60 */     RegionFile regionFile2 = new RegionFile(file2);
/* 61 */     field_76553_a.put(file2, regionFile2);
/* 62 */     return regionFile2;
/*    */   }
/*    */   
/*    */   public static synchronized void func_76551_a() {
/* 66 */     for (RegionFile regionFile : field_76553_a.values()) {
/*    */       try {
/* 68 */         if (regionFile != null) {
/* 69 */           regionFile.func_76708_c();
/*    */         }
/* 71 */       } catch (IOException iOException) {
/* 72 */         iOException.printStackTrace();
/*    */       } 
/*    */     } 
/* 75 */     field_76553_a.clear();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static DataInputStream func_76549_c(File p_76549_0_, int p_76549_1_, int p_76549_2_) {
/* 84 */     RegionFile regionFile = func_76550_a(p_76549_0_, p_76549_1_, p_76549_2_);
/* 85 */     return regionFile.func_76704_a(p_76549_1_ & 0x1F, p_76549_2_ & 0x1F);
/*    */   }
/*    */   
/*    */   public static DataOutputStream func_76552_d(File p_76552_0_, int p_76552_1_, int p_76552_2_) {
/* 89 */     RegionFile regionFile = func_76550_a(p_76552_0_, p_76552_1_, p_76552_2_);
/* 90 */     return regionFile.func_76710_b(p_76552_1_ & 0x1F, p_76552_2_ & 0x1F);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\chunk\storage\RegionFileCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */