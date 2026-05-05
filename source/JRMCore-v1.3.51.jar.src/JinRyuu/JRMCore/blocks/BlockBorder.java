/*    */ package JinRyuu.JRMCore.blocks;
/*    */ 
/*    */ import JinRyuu.JRMCore.mod_JRMCore;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockBorder
/*    */   extends BlockBarrier
/*    */ {
/*    */   public BlockBorder() {
/* 13 */     func_149647_a(mod_JRMCore.JRMCore);
/* 14 */     func_149711_c(-1.0F);
/*    */ 
/*    */     
/* 17 */     func_149752_b(6000000.0F);
/* 18 */     this.TileEntity = BlockBorderTileEntity.class;
/*    */   }
/*    */ 
/*    */   
/*    */   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
/* 23 */     return new BlockBorderTileEntity();
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\blocks\BlockBorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */