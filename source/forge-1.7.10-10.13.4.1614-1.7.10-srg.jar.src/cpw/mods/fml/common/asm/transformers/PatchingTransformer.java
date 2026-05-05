/*    */ package cpw.mods.fml.common.asm.transformers;
/*    */ 
/*    */ import cpw.mods.fml.common.patcher.ClassPatchManager;
/*    */ import net.minecraft.launchwrapper.IClassTransformer;
/*    */ 
/*    */ public class PatchingTransformer
/*    */   implements IClassTransformer
/*    */ {
/*    */   public byte[] transform(String name, String transformedName, byte[] bytes) {
/* 10 */     return ClassPatchManager.INSTANCE.applyPatch(name, transformedName, bytes);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\asm\transformers\PatchingTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */