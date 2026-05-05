/*    */ package cpw.mods.fml.client;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.client.gui.GuiScreen;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface IModGuiFactory
/*    */ {
/*    */   void initialize(Minecraft paramMinecraft);
/*    */   
/*    */   Class<? extends GuiScreen> mainConfigGuiClass();
/*    */   
/*    */   Set<RuntimeOptionCategoryElement> runtimeGuiCategories();
/*    */   
/*    */   RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement paramRuntimeOptionCategoryElement);
/*    */   
/*    */   public static interface RuntimeOptionGuiHandler
/*    */   {
/*    */     void addWidgets(List<Gui> param1List, int param1Int1, int param1Int2, int param1Int3, int param1Int4);
/*    */     
/*    */     void paint(int param1Int1, int param1Int2, int param1Int3, int param1Int4);
/*    */     
/*    */     void actionCallback(int param1Int);
/*    */     
/*    */     void close();
/*    */   }
/*    */   
/*    */   public static class RuntimeOptionCategoryElement
/*    */   {
/*    */     public final String parent;
/*    */     public final String child;
/*    */     
/*    */     public RuntimeOptionCategoryElement(String parent, String child) {
/* 83 */       this.parent = parent;
/* 84 */       this.child = child;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\IModGuiFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */