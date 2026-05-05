/*    */ package JinRyuu.DragonBC.common;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.Render.ArtGravDevTileEntity;
/*    */ import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.renderer.RenderBlocks;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ 
/*    */ public class BlockRenderingHandler implements ISimpleBlockRenderingHandler {
/*    */   public static final double POSITION_FIX = -0.5D;
/* 13 */   private static ArtGravDevTileEntity generator = new ArtGravDevTileEntity();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {}
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
/* 29 */     Tessellator tes = Tessellator.field_78398_a;
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
/* 42 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void RenderStaticTileEntity(IBlockAccess world, int x, int y, int z, RenderBlocks blocksRenderer, TileEntity tile) {}
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getRenderId() {
/* 61 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean shouldRender3DInInventory(int modelId) {
/* 66 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\BlockRenderingHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */