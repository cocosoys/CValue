/*    */ package cpw.mods.fml.common.registry;
/*    */ 
/*    */ import com.google.common.base.Throwables;
/*    */ import com.google.common.collect.Lists;
/*    */ import com.google.common.collect.Maps;
/*    */ import cpw.mods.fml.common.FMLLog;
/*    */ import cpw.mods.fml.common.discovery.ASMDataTable;
/*    */ import java.lang.reflect.Field;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import org.apache.logging.log4j.Level;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum ItemStackHolderInjector
/*    */ {
/*    */   private List<ItemStackHolderRef> itemStackHolders;
/* 20 */   INSTANCE;
/*    */   ItemStackHolderInjector() {
/* 22 */     this.itemStackHolders = Lists.newArrayList();
/*    */   }
/*    */   public void inject() {
/* 25 */     FMLLog.getLogger().log(Level.INFO, "Injecting itemstacks");
/* 26 */     for (ItemStackHolderRef ishr : this.itemStackHolders) {
/* 27 */       ishr.apply();
/*    */     }
/* 29 */     FMLLog.getLogger().log(Level.INFO, "Itemstack injection complete");
/*    */   }
/*    */   
/*    */   public void findHolders(ASMDataTable table) {
/* 33 */     FMLLog.info("Identifying ItemStackHolder annotations", new Object[0]);
/* 34 */     Set<ASMDataTable.ASMData> allItemStackHolders = table.getAll(GameRegistry.ItemStackHolder.class.getName());
/* 35 */     Map<String, Class<?>> classCache = Maps.newHashMap();
/* 36 */     for (ASMDataTable.ASMData data : allItemStackHolders) {
/*    */       
/* 38 */       String className = data.getClassName();
/* 39 */       String annotationTarget = data.getObjectName();
/* 40 */       String value = (String)data.getAnnotationInfo().get("value");
/* 41 */       int meta = data.getAnnotationInfo().containsKey("meta") ? ((Integer)data.getAnnotationInfo().get("meta")).intValue() : 0;
/* 42 */       String nbt = data.getAnnotationInfo().containsKey("nbt") ? (String)data.getAnnotationInfo().get("nbt") : "";
/* 43 */       addHolder(classCache, className, annotationTarget, value, Integer.valueOf(meta), nbt);
/*    */     } 
/* 45 */     FMLLog.info("Found %d ItemStackHolder annotations", new Object[] { Integer.valueOf(allItemStackHolders.size()) });
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void addHolder(Map<String, Class<?>> classCache, String className, String annotationTarget, String value, Integer meta, String nbt) {
/*    */     Class<?> clazz;
/* 52 */     if (classCache.containsKey(className)) {
/*    */       
/* 54 */       clazz = classCache.get(className);
/*    */     } else {
/*    */ 
/*    */       
/*    */       try {
/*    */         
/* 60 */         clazz = Class.forName(className, true, getClass().getClassLoader());
/* 61 */         classCache.put(className, clazz);
/*    */       }
/* 63 */       catch (Exception ex) {
/*    */ 
/*    */         
/* 66 */         throw Throwables.propagate(ex);
/*    */       } 
/*    */     } 
/*    */     
/*    */     try {
/* 71 */       Field f = clazz.getField(annotationTarget);
/* 72 */       this.itemStackHolders.add(new ItemStackHolderRef(f, value, meta.intValue(), nbt));
/*    */     }
/* 74 */     catch (Exception ex) {
/*    */ 
/*    */       
/* 77 */       throw Throwables.propagate(ex);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\registry\ItemStackHolderInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */