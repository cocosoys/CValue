/*    */ package cpw.mods.fml.relauncher;
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
/*    */ public enum Side
/*    */ {
/* 21 */   CLIENT,
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 26 */   SERVER;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isServer() {
/* 33 */     return !isClient();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isClient() {
/* 41 */     return (this == CLIENT);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\cpw\mods\fml\relauncher\Side.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */