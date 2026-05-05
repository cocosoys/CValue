/*    */ package org.bukkit.craftbukkit.libs.joptsimple.internal;
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
/*    */ 
/*    */ 
/*    */ class ColumnWidthCalculator
/*    */ {
/*    */   int calculate(int totalWidth, int numberOfColumns) {
/* 34 */     if (numberOfColumns == 1) {
/* 35 */       return totalWidth;
/*    */     }
/* 37 */     int remainder = totalWidth % numberOfColumns;
/* 38 */     if (remainder == numberOfColumns - 1)
/* 39 */       return totalWidth / numberOfColumns; 
/* 40 */     return totalWidth / numberOfColumns - 1;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\libs\joptsimple\internal\ColumnWidthCalculator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */