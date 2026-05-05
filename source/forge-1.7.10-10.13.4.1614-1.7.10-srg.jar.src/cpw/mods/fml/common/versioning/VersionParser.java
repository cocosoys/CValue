/*    */ package cpw.mods.fml.common.versioning;
/*    */ 
/*    */ import com.google.common.base.Splitter;
/*    */ import com.google.common.base.Strings;
/*    */ import com.google.common.collect.Lists;
/*    */ import cpw.mods.fml.common.FMLLog;
/*    */ import cpw.mods.fml.common.LoaderException;
/*    */ import java.util.List;
/*    */ import org.apache.logging.log4j.Level;
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
/*    */ public class VersionParser
/*    */ {
/* 39 */   private static final Splitter SEPARATOR = Splitter.on('@').omitEmptyStrings().trimResults();
/*    */   
/*    */   public static ArtifactVersion parseVersionReference(String labelledRef) {
/* 42 */     if (Strings.isNullOrEmpty(labelledRef))
/*    */     {
/* 44 */       throw new RuntimeException(String.format("Empty reference %s", new Object[] { labelledRef }));
/*    */     }
/* 46 */     List<String> parts = Lists.newArrayList(SEPARATOR.split(labelledRef));
/* 47 */     if (parts.size() > 2)
/*    */     {
/* 49 */       throw new RuntimeException(String.format("Invalid versioned reference %s", new Object[] { labelledRef }));
/*    */     }
/* 51 */     if (parts.size() == 1)
/*    */     {
/* 53 */       return new DefaultArtifactVersion(parts.get(0), true);
/*    */     }
/* 55 */     return new DefaultArtifactVersion(parts.get(0), parseRange(parts.get(1)));
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean satisfies(ArtifactVersion target, ArtifactVersion source) {
/* 60 */     return target.containsVersion(source);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static VersionRange parseRange(String range) {
/*    */     try {
/* 67 */       return VersionRange.createFromVersionSpec(range);
/*    */     }
/* 69 */     catch (InvalidVersionSpecificationException e) {
/*    */       
/* 71 */       FMLLog.log(Level.ERROR, e, "Unable to parse a version range specification successfully %s", new Object[] { range });
/* 72 */       throw new LoaderException(e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\versioning\VersionParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */