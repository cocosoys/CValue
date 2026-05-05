/*   */ package org.bukkit.craftbukkit.v1_7_R4.util;
/*   */ 
/*   */ import java.io.File;
/*   */ import java.io.FilenameFilter;
/*   */ 
/*   */ public class DatFileFilter implements FilenameFilter {
/*   */   public boolean accept(File dir, String name) {
/* 8 */     return name.endsWith(".dat");
/*   */   }
/*   */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R\\util\DatFileFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */