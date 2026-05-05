/*    */ package cpw.mods.fml.common.event;
/*    */ 
/*    */ import com.google.common.base.Throwables;
/*    */ import cpw.mods.fml.common.Loader;
/*    */ import cpw.mods.fml.common.LoaderState;
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
/*    */ public class FMLPostInitializationEvent
/*    */   extends FMLStateEvent
/*    */ {
/*    */   public FMLPostInitializationEvent(Object... data) {
/* 24 */     super(data);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public LoaderState.ModState getModState() {
/* 30 */     return LoaderState.ModState.POSTINITIALIZED;
/*    */   }
/*    */ 
/*    */   
/*    */   public Object buildSoftDependProxy(String modId, String className) {
/* 35 */     if (Loader.isModLoaded(modId)) {
/*    */       
/*    */       try {
/*    */         
/* 39 */         Class<?> clz = Class.forName(className, true, Loader.instance().getModClassLoader());
/* 40 */         return clz.newInstance();
/*    */       }
/* 42 */       catch (Exception e) {
/*    */         
/* 44 */         Throwables.propagateIfPossible(e);
/* 45 */         return null;
/*    */       } 
/*    */     }
/* 48 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\event\FMLPostInitializationEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */