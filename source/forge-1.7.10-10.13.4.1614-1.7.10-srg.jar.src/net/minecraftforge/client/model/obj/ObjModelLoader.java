/*    */ package net.minecraftforge.client.model.obj;
/*    */ 
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.client.model.IModelCustom;
/*    */ import net.minecraftforge.client.model.IModelCustomLoader;
/*    */ import net.minecraftforge.client.model.ModelFormatException;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ObjModelLoader
/*    */   implements IModelCustomLoader
/*    */ {
/*    */   public String getType() {
/* 14 */     return "OBJ model";
/*    */   }
/*    */   
/* 17 */   private static final String[] types = new String[] { "obj" };
/*    */ 
/*    */   
/*    */   public String[] getSuffixes() {
/* 21 */     return types;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IModelCustom loadInstance(ResourceLocation resource) throws ModelFormatException {
/* 27 */     return new WavefrontObject(resource);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\model\obj\ObjModelLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */