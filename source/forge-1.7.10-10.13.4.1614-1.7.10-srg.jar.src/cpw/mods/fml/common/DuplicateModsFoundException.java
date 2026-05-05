/*    */ package cpw.mods.fml.common;
/*    */ 
/*    */ import com.google.common.collect.SetMultimap;
/*    */ import java.io.File;
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
/*    */ public class DuplicateModsFoundException
/*    */   extends LoaderException
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   public SetMultimap<ModContainer, File> dupes;
/*    */   
/*    */   public DuplicateModsFoundException(SetMultimap<ModContainer, File> dupes) {
/* 27 */     this.dupes = dupes;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void printStackTrace(EnhancedRuntimeException.WrappedPrintStream stream) {
/* 33 */     stream.println("Duplicate Mods:");
/* 34 */     for (Map.Entry<ModContainer, File> e : (Iterable<Map.Entry<ModContainer, File>>)this.dupes.entries()) {
/*    */       
/* 36 */       stream.println(String.format("\t%s : %s", new Object[] { ((ModContainer)e.getKey()).getModId(), ((File)e.getValue()).getAbsolutePath() }));
/*    */     } 
/* 38 */     stream.println("");
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\DuplicateModsFoundException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */