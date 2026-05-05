/*    */ package cpw.mods.fml.common.discovery;
/*    */ 
/*    */ import com.google.common.base.Throwables;
/*    */ import cpw.mods.fml.common.ModContainer;
/*    */ import java.util.List;
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
/*    */ public enum ContainerType
/*    */ {
/* 23 */   JAR((Class)JarDiscoverer.class),
/* 24 */   DIR((Class)DirectoryDiscoverer.class);
/*    */ 
/*    */   
/*    */   private ITypeDiscoverer discoverer;
/*    */ 
/*    */   
/*    */   ContainerType(Class<? extends ITypeDiscoverer> discovererClass) {
/*    */     try {
/* 32 */       this.discoverer = discovererClass.newInstance();
/*    */     }
/* 34 */     catch (Exception e) {
/*    */       
/* 36 */       throw Throwables.propagate(e);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public List<ModContainer> findMods(ModCandidate candidate, ASMDataTable table) {
/* 42 */     return this.discoverer.discover(candidate, table);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\discovery\ContainerType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */