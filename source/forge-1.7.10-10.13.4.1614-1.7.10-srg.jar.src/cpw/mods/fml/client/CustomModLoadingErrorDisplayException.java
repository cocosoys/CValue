/*    */ package cpw.mods.fml.client;
/*    */ 
/*    */ import cpw.mods.fml.common.EnhancedRuntimeException;
/*    */ import cpw.mods.fml.common.IFMLHandledException;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.GuiErrorScreen;
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
/*    */ @SideOnly(Side.CLIENT)
/*    */ public abstract class CustomModLoadingErrorDisplayException
/*    */   extends EnhancedRuntimeException
/*    */   implements IFMLHandledException
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public CustomModLoadingErrorDisplayException() {}
/*    */   
/*    */   public CustomModLoadingErrorDisplayException(String message, Throwable cause) {
/* 40 */     super(message, cause);
/*    */   }
/*    */   
/*    */   public abstract void initGui(GuiErrorScreen paramGuiErrorScreen, FontRenderer paramFontRenderer);
/*    */   
/*    */   public abstract void drawScreen(GuiErrorScreen paramGuiErrorScreen, FontRenderer paramFontRenderer, int paramInt1, int paramInt2, float paramFloat);
/*    */   
/*    */   public void printStackTrace(EnhancedRuntimeException.WrappedPrintStream s) {}
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\CustomModLoadingErrorDisplayException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */