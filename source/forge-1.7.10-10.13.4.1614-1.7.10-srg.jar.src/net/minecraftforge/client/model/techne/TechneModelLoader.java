/*    */ package net.minecraftforge.client.model.techne;
/*    */ 
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.client.model.IModelCustom;
/*    */ import net.minecraftforge.client.model.IModelCustomLoader;
/*    */ import net.minecraftforge.client.model.ModelFormatException;
/*    */ 
/*    */ 
/*    */ public class TechneModelLoader
/*    */   implements IModelCustomLoader
/*    */ {
/*    */   public String getType() {
/* 13 */     return "Techne model";
/*    */   }
/*    */   
/* 16 */   private static final String[] types = new String[] { "tcn" };
/*    */ 
/*    */   
/*    */   public String[] getSuffixes() {
/* 20 */     return types;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IModelCustom loadInstance(ResourceLocation resource) throws ModelFormatException {
/* 26 */     return new TechneModel(resource);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\model\techne\TechneModelLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */