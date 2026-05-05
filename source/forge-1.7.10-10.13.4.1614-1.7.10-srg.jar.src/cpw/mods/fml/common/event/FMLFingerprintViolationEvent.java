/*    */ package cpw.mods.fml.common.event;
/*    */ 
/*    */ import com.google.common.collect.ImmutableSet;
/*    */ import java.io.File;
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
/*    */ 
/*    */ 
/*    */ public class FMLFingerprintViolationEvent
/*    */   extends FMLEvent
/*    */ {
/*    */   public final boolean isDirectory;
/*    */   public final Set<String> fingerprints;
/*    */   public final File source;
/*    */   public final String expectedFingerprint;
/*    */   
/*    */   public FMLFingerprintViolationEvent(boolean isDirectory, File source, ImmutableSet<String> fingerprints, String expectedFingerprint) {
/* 31 */     this.isDirectory = isDirectory;
/* 32 */     this.source = source;
/* 33 */     this.fingerprints = (Set<String>)fingerprints;
/* 34 */     this.expectedFingerprint = expectedFingerprint;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\event\FMLFingerprintViolationEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */