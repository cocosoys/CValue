/*    */ package cpw.mods.fml.common.event;
/*    */ 
/*    */ import com.google.common.collect.ListMultimap;
/*    */ import cpw.mods.fml.common.LoaderState;
/*    */ import cpw.mods.fml.common.ModClassLoader;
/*    */ import cpw.mods.fml.common.discovery.ASMDataTable;
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
/*    */ public class FMLConstructionEvent
/*    */   extends FMLStateEvent
/*    */ {
/*    */   private ModClassLoader modClassLoader;
/*    */   private ASMDataTable asmData;
/*    */   private ListMultimap<String, String> reverseDependencies;
/*    */   
/*    */   public FMLConstructionEvent(Object... eventData) {
/* 29 */     super(new Object[0]);
/* 30 */     this.modClassLoader = (ModClassLoader)eventData[0];
/* 31 */     this.asmData = (ASMDataTable)eventData[1];
/* 32 */     this.reverseDependencies = (ListMultimap<String, String>)eventData[2];
/*    */   }
/*    */ 
/*    */   
/*    */   public ModClassLoader getModClassLoader() {
/* 37 */     return this.modClassLoader;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public LoaderState.ModState getModState() {
/* 43 */     return LoaderState.ModState.CONSTRUCTED;
/*    */   }
/*    */ 
/*    */   
/*    */   public ASMDataTable getASMHarvestedData() {
/* 48 */     return this.asmData;
/*    */   }
/*    */ 
/*    */   
/*    */   public ListMultimap<String, String> getReverseDependencies() {
/* 53 */     return this.reverseDependencies;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\event\FMLConstructionEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */