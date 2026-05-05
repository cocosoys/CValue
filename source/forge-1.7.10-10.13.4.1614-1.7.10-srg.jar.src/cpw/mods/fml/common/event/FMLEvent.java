/*    */ package cpw.mods.fml.common.event;
/*    */ 
/*    */ import cpw.mods.fml.common.ModContainer;
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
/*    */ public class FMLEvent
/*    */ {
/*    */   public final String getEventType() {
/* 21 */     return getClass().getSimpleName();
/*    */   }
/*    */   
/*    */   public final String description() {
/* 25 */     String cn = getClass().getName();
/* 26 */     return cn.substring(cn.lastIndexOf('.') + 4, cn.length() - 5);
/*    */   }
/*    */   
/*    */   public void applyModContainer(ModContainer activeContainer) {}
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\event\FMLEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */