/*   */ package cpw.mods.fml.common;
/*   */ 
/*   */ 
/*   */ public class ClassNameUtils
/*   */ {
/*   */   public static String shortName(Class<?> clz) {
/* 7 */     String nm = clz.getName();
/* 8 */     return (nm.indexOf('.') > -1) ? nm.substring(nm.lastIndexOf('.') + 1) : nm;
/*   */   }
/*   */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\ClassNameUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */