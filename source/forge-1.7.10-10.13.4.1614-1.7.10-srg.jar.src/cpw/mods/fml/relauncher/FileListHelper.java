/*    */ package cpw.mods.fml.relauncher;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FilenameFilter;
/*    */ import java.util.Arrays;
/*    */ import java.util.Comparator;
/*    */ 
/*    */ public final class FileListHelper {
/*    */   private enum CaseInsensitiveFileComparator
/*    */     implements Comparator<File> {
/* 11 */     INSTANCE;
/*    */ 
/*    */     
/*    */     public int compare(File o1, File o2) {
/* 15 */       return (o1 != null && o2 != null) ? o1.getName().compareToIgnoreCase(o2.getName()) : ((o1 == null) ? -1 : 1);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public static File[] sortFileList(File[] files) {
/* 21 */     Arrays.sort(files, CaseInsensitiveFileComparator.INSTANCE);
/* 22 */     return files;
/*    */   }
/*    */   
/*    */   public static File[] sortFileList(File dir, FilenameFilter filter) {
/* 26 */     File[] files = dir.listFiles(filter);
/* 27 */     return sortFileList(files);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\relauncher\FileListHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */