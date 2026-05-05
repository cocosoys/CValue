/*    */ package net.minecraft.src;
/*    */ 
/*    */ import cpw.mods.fml.client.registry.RenderingRegistry;
/*    */ import cpw.mods.fml.common.FMLLog;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.renderer.RenderBlocks;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import org.apache.logging.log4j.Level;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ import org.apache.logging.log4j.Logger;
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
/*    */ public class FMLRenderAccessLibrary
/*    */ {
/*    */   public static Logger getLogger() {
/* 36 */     Logger l = LogManager.getLogger("FMLRenderAccessLibrary");
/* 37 */     return l;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void log(Level level, String message) {
/* 42 */     FMLLog.log("FMLRenderAccessLibrary", level, message, new Object[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void log(Level level, String message, Throwable throwable) {
/* 47 */     FMLLog.log(level, throwable, message, new Object[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean renderWorldBlock(RenderBlocks renderer, IBlockAccess world, int x, int y, int z, Block block, int modelId) {
/* 53 */     return RenderingRegistry.instance().renderWorldBlock(renderer, world, x, y, z, block, modelId);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void renderInventoryBlock(RenderBlocks renderer, Block block, int metadata, int modelID) {
/* 59 */     RenderingRegistry.instance().renderInventoryBlock(renderer, block, metadata, modelID);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean renderItemAsFull3DBlock(int modelId) {
/* 65 */     return RenderingRegistry.instance().renderItemAsFull3DBlock(modelId);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraft\src\FMLRenderAccessLibrary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */