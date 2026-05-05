/*    */ package cpw.mods.fml.common;
/*    */ 
/*    */ import com.google.common.base.Strings;
/*    */ import cpw.mods.fml.common.discovery.ASMDataTable;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import java.lang.reflect.Field;
/*    */ import java.util.Set;
/*    */ import org.apache.logging.log4j.Level;
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
/*    */ public class ProxyInjector
/*    */ {
/*    */   public static void inject(ModContainer mod, ASMDataTable data, Side side, ILanguageAdapter languageAdapter) {
/* 34 */     FMLLog.fine("Attempting to inject @SidedProxy classes into %s", new Object[] { mod.getModId() });
/* 35 */     Set<ASMDataTable.ASMData> targets = data.getAnnotationsFor(mod).get(SidedProxy.class.getName());
/* 36 */     ClassLoader mcl = Loader.instance().getModClassLoader();
/*    */     
/* 38 */     for (ASMDataTable.ASMData targ : targets) {
/*    */ 
/*    */       
/*    */       try {
/* 42 */         Class<?> proxyTarget = Class.forName(targ.getClassName(), true, mcl);
/* 43 */         Field target = proxyTarget.getDeclaredField(targ.getObjectName());
/* 44 */         if (target == null) {
/*    */ 
/*    */           
/* 47 */           FMLLog.severe("Attempted to load a proxy type into %s.%s but the field was not found", new Object[] { targ.getClassName(), targ.getObjectName() });
/* 48 */           throw new LoaderException(String.format("Attempted to load a proxy type into %s.%s but the field was not found", new Object[] { targ.getClassName(), targ.getObjectName() }));
/*    */         } 
/* 50 */         target.setAccessible(true);
/*    */         
/* 52 */         SidedProxy annotation = target.<SidedProxy>getAnnotation(SidedProxy.class);
/* 53 */         if (!Strings.isNullOrEmpty(annotation.modId()) && !annotation.modId().equals(mod.getModId())) {
/*    */           
/* 55 */           FMLLog.fine("Skipping proxy injection for %s.%s since it is not for mod %s", new Object[] { targ.getClassName(), targ.getObjectName(), mod.getModId() });
/*    */           continue;
/*    */         } 
/* 58 */         String targetType = side.isClient() ? annotation.clientSide() : annotation.serverSide();
/* 59 */         Object proxy = Class.forName(targetType, true, mcl).newInstance();
/*    */         
/* 61 */         if (languageAdapter.supportsStatics() && (target.getModifiers() & 0x8) == 0) {
/*    */           
/* 63 */           FMLLog.severe("Attempted to load a proxy type %s into %s.%s, but the field is not static", new Object[] { targetType, targ.getClassName(), targ.getObjectName() });
/* 64 */           throw new LoaderException(String.format("Attempted to load a proxy type %s into %s.%s, but the field is not static", new Object[] { targetType, targ.getClassName(), targ.getObjectName() }));
/*    */         } 
/* 66 */         if (!target.getType().isAssignableFrom(proxy.getClass())) {
/*    */           
/* 68 */           FMLLog.severe("Attempted to load a proxy type %s into %s.%s, but the types don't match", new Object[] { targetType, targ.getClassName(), targ.getObjectName() });
/* 69 */           throw new LoaderException(String.format("Attempted to load a proxy type %s into %s.%s, but the types don't match", new Object[] { targetType, targ.getClassName(), targ.getObjectName() }));
/*    */         } 
/* 71 */         languageAdapter.setProxy(target, proxyTarget, proxy);
/*    */       }
/* 73 */       catch (Exception e) {
/*    */         
/* 75 */         FMLLog.log(Level.ERROR, e, "An error occured trying to load a proxy into %s.%s", new Object[] { targ.getAnnotationInfo(), targ.getClassName(), targ.getObjectName() });
/* 76 */         throw new LoaderException(e);
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 81 */     languageAdapter.setInternalProxies(mod, side, mcl);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\ProxyInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */