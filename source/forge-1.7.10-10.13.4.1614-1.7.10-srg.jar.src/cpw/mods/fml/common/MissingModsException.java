/*    */ package cpw.mods.fml.common;
/*    */ 
/*    */ import cpw.mods.fml.common.versioning.ArtifactVersion;
/*    */ import java.util.Set;
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
/*    */ public class MissingModsException
/*    */   extends EnhancedRuntimeException
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   public final Set<ArtifactVersion> missingMods;
/*    */   
/*    */   public MissingModsException(Set<ArtifactVersion> missingMods) {
/* 26 */     this.missingMods = missingMods;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void printStackTrace(EnhancedRuntimeException.WrappedPrintStream stream) {
/* 32 */     stream.println("Missing Mods:");
/* 33 */     for (ArtifactVersion v : this.missingMods) {
/*    */       
/* 35 */       stream.println(String.format("\t%s : %s", new Object[] { v.getLabel(), v.getRangeString() }));
/*    */     } 
/* 37 */     stream.println("");
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\MissingModsException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */