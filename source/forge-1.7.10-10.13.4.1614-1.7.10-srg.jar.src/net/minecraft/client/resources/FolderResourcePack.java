/*    */ package net.minecraft.client.resources;
/*    */ import com.google.common.collect.Sets;
/*    */ import java.io.BufferedInputStream;
/*    */ import java.io.File;
/*    */ import java.io.InputStream;
/*    */ import java.util.HashSet;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class FolderResourcePack extends AbstractResourcePack {
/*    */   public FolderResourcePack(File p_i1291_1_) {
/* 11 */     super(p_i1291_1_);
/*    */   }
/*    */   private static final String __OBFID = "CL_00001076";
/*    */   
/*    */   protected InputStream func_110591_a(String p_110591_1_) throws IOException {
/* 16 */     return new BufferedInputStream(new FileInputStream(new File(this.field_110597_b, p_110591_1_)));
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean func_110593_b(String p_110593_1_) {
/* 21 */     return (new File(this.field_110597_b, p_110593_1_)).isFile();
/*    */   }
/*    */ 
/*    */   
/*    */   public Set func_110587_b() {
/* 26 */     HashSet<String> hashSet = Sets.newHashSet();
/* 27 */     File file = new File(this.field_110597_b, "assets/");
/*    */     
/* 29 */     if (file.isDirectory()) {
/* 30 */       for (File file1 : file.listFiles((FileFilter)DirectoryFileFilter.DIRECTORY)) {
/* 31 */         String str = func_110595_a(file, file1);
/*    */         
/* 33 */         if (!str.equals(str.toLowerCase())) {
/* 34 */           func_110594_c(str);
/*    */         } else {
/* 36 */           hashSet.add(str.substring(0, str.length() - 1));
/*    */         } 
/*    */       } 
/*    */     }
/*    */     
/* 41 */     return hashSet;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\resources\FolderResourcePack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */