/*    */ package cpw.mods.fml.client.registry;
/*    */ 
/*    */ import cpw.mods.fml.common.registry.GameRegistry;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
/*    */ import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
/*    */ import net.minecraft.client.settings.KeyBinding;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import org.apache.commons.lang3.ArrayUtils;
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
/*    */ public class ClientRegistry
/*    */ {
/*    */   public static void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String id, TileEntitySpecialRenderer specialRenderer) {
/* 36 */     GameRegistry.registerTileEntity(tileEntityClass, id);
/* 37 */     bindTileEntitySpecialRenderer(tileEntityClass, specialRenderer);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void bindTileEntitySpecialRenderer(Class<? extends TileEntity> tileEntityClass, TileEntitySpecialRenderer specialRenderer) {
/* 43 */     TileEntityRendererDispatcher.instance.mapSpecialRenderers.put(tileEntityClass, specialRenderer);
/* 44 */     specialRenderer.func_147497_a(TileEntityRendererDispatcher.instance);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void registerKeyBinding(KeyBinding key) {
/* 49 */     (Minecraft.getMinecraft()).gameSettings.keyBindings = (KeyBinding[])ArrayUtils.add((Object[])(Minecraft.getMinecraft()).gameSettings.keyBindings, key);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\registry\ClientRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */