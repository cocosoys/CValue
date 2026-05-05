/*   */ package cpw.mods.fml.common.registry;
/*   */ 
/*   */ public class IncompatibleSubstitutionException
/*   */   extends RuntimeException {
/*   */   public IncompatibleSubstitutionException(String fromName, Object replacement, Object original) {
/* 6 */     super(String.format("The substitute %s for %s (type %s) is type incompatible.", new Object[] { replacement.getClass().getName(), fromName, original.getClass().getName() }));
/*   */   }
/*   */   
/*   */   private static final long serialVersionUID = 1L;
/*   */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\registry\IncompatibleSubstitutionException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */