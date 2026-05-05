/*    */ package net.minecraftforge.client.model;
/*    */ 
/*    */ import com.google.common.collect.Maps;
/*    */ import cpw.mods.fml.common.FMLLog;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Collection;
/*    */ import java.util.Map;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.client.model.obj.ObjModelLoader;
/*    */ import net.minecraftforge.client.model.techne.TechneModelLoader;
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
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class AdvancedModelLoader
/*    */ {
/* 27 */   private static Map<String, IModelCustomLoader> instances = Maps.newHashMap();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void registerModelHandler(IModelCustomLoader modelHandler) {
/* 35 */     for (String suffix : modelHandler.getSuffixes())
/*    */     {
/* 37 */       instances.put(suffix, modelHandler);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static IModelCustom loadModel(ResourceLocation resource) throws IllegalArgumentException, ModelFormatException {
/* 50 */     String name = resource.getResourcePath();
/* 51 */     int i = name.lastIndexOf('.');
/* 52 */     if (i == -1) {
/*    */       
/* 54 */       FMLLog.severe("The resource name %s is not valid", new Object[] { resource });
/* 55 */       throw new IllegalArgumentException("The resource name is not valid");
/*    */     } 
/* 57 */     String suffix = name.substring(i + 1);
/* 58 */     IModelCustomLoader loader = instances.get(suffix);
/* 59 */     if (loader == null) {
/*    */       
/* 61 */       FMLLog.severe("The resource name %s is not supported", new Object[] { resource });
/* 62 */       throw new IllegalArgumentException("The resource name is not supported");
/*    */     } 
/*    */     
/* 65 */     return loader.loadInstance(resource);
/*    */   }
/*    */ 
/*    */   
/*    */   public static Collection<String> getSupportedSuffixes() {
/* 70 */     return instances.keySet();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   static {
/* 76 */     registerModelHandler((IModelCustomLoader)new ObjModelLoader());
/* 77 */     registerModelHandler((IModelCustomLoader)new TechneModelLoader());
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\model\AdvancedModelLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */