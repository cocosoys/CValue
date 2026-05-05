/*    */ package cpw.mods.fml.common.functions;
/*    */ 
/*    */ import com.google.common.base.Function;
/*    */ import cpw.mods.fml.common.versioning.ArtifactVersion;
/*    */ 
/*    */ 
/*    */ public class ArtifactVersionNameFunction
/*    */   implements Function<ArtifactVersion, String>
/*    */ {
/*    */   public String apply(ArtifactVersion v) {
/* 11 */     return v.getLabel();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\functions\ArtifactVersionNameFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */