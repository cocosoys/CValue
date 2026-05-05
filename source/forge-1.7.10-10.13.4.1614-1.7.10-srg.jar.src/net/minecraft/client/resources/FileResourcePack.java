/*    */ package net.minecraft.client.resources;
/*    */ import com.google.common.base.Splitter;
/*    */ import com.google.common.collect.Sets;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.Enumeration;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ import java.util.zip.ZipEntry;
/*    */ import java.util.zip.ZipFile;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class FileResourcePack extends AbstractResourcePack implements Closeable {
/* 19 */   public static final Splitter field_110601_c = Splitter.on('/').omitEmptyStrings().limit(3); private ZipFile field_110600_d;
/*    */   private static final String __OBFID = "CL_00001075";
/*    */   
/*    */   public FileResourcePack(File p_i1290_1_) {
/* 23 */     super(p_i1290_1_);
/*    */   }
/*    */   
/*    */   private ZipFile func_110599_c() throws IOException {
/* 27 */     if (this.field_110600_d == null) {
/* 28 */       this.field_110600_d = new ZipFile(this.field_110597_b);
/*    */     }
/*    */     
/* 31 */     return this.field_110600_d;
/*    */   }
/*    */ 
/*    */   
/*    */   protected InputStream func_110591_a(String p_110591_1_) throws IOException {
/* 36 */     ZipFile zipFile = func_110599_c();
/* 37 */     ZipEntry zipEntry = zipFile.getEntry(p_110591_1_);
/*    */     
/* 39 */     if (zipEntry == null) {
/* 40 */       throw new ResourcePackFileNotFoundException(this.field_110597_b, p_110591_1_);
/*    */     }
/*    */     
/* 43 */     return zipFile.getInputStream(zipEntry);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_110593_b(String p_110593_1_) {
/*    */     try {
/* 49 */       return (func_110599_c().getEntry(p_110593_1_) != null);
/* 50 */     } catch (IOException iOException) {
/* 51 */       return false;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public Set func_110587_b() {
/*    */     ZipFile zipFile;
/*    */     try {
/* 59 */       zipFile = func_110599_c();
/* 60 */     } catch (IOException iOException) {
/* 61 */       return Collections.emptySet();
/*    */     } 
/*    */     
/* 64 */     Enumeration<? extends ZipEntry> enumeration = zipFile.entries();
/*    */     
/* 66 */     HashSet<String> hashSet = Sets.newHashSet();
/*    */     
/* 68 */     while (enumeration.hasMoreElements()) {
/* 69 */       ZipEntry zipEntry = enumeration.nextElement();
/*    */       
/* 71 */       String str = zipEntry.getName();
/* 72 */       if (str.startsWith("assets/")) {
/* 73 */         ArrayList<String> arrayList = Lists.newArrayList(field_110601_c.split(str));
/* 74 */         if (arrayList.size() > 1) {
/* 75 */           String str1 = arrayList.get(1);
/* 76 */           if (!str1.equals(str1.toLowerCase())) {
/* 77 */             func_110594_c(str1); continue;
/*    */           } 
/* 79 */           hashSet.add(str1);
/*    */         } 
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 85 */     return hashSet;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void finalize() throws Throwable {
/* 90 */     close();
/* 91 */     super.finalize();
/*    */   }
/*    */ 
/*    */   
/*    */   public void close() throws IOException {
/* 96 */     if (this.field_110600_d != null) {
/* 97 */       this.field_110600_d.close();
/* 98 */       this.field_110600_d = null;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\resources\FileResourcePack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */