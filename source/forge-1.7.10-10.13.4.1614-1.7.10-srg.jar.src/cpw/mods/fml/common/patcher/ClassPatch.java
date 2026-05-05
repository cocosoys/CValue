/*    */ package cpw.mods.fml.common.patcher;
/*    */ 
/*    */ public class ClassPatch {
/*    */   public final String name;
/*    */   public final String sourceClassName;
/*    */   public final String targetClassName;
/*    */   public final boolean existsAtTarget;
/*    */   public final byte[] patch;
/*    */   public final int inputChecksum;
/*    */   
/*    */   public ClassPatch(String name, String sourceClassName, String targetClassName, boolean existsAtTarget, int inputChecksum, byte[] patch) {
/* 12 */     this.name = name;
/* 13 */     this.sourceClassName = sourceClassName;
/* 14 */     this.targetClassName = targetClassName;
/* 15 */     this.existsAtTarget = existsAtTarget;
/* 16 */     this.inputChecksum = inputChecksum;
/* 17 */     this.patch = patch;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 23 */     return String.format("%s : %s => %s (%b) size %d", new Object[] { this.name, this.sourceClassName, this.targetClassName, Boolean.valueOf(this.existsAtTarget), Integer.valueOf(this.patch.length) });
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\patcher\ClassPatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */