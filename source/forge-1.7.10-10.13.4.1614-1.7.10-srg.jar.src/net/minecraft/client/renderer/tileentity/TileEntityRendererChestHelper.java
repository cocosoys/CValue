/*    */ package net.minecraft.client.renderer.tileentity;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.tileentity.TileEntityChest;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class TileEntityRendererChestHelper {
/*  8 */   public static TileEntityRendererChestHelper field_147719_a = new TileEntityRendererChestHelper();
/*    */   
/* 10 */   private TileEntityChest field_147717_b = new TileEntityChest(0);
/* 11 */   private TileEntityChest field_147718_c = new TileEntityChest(1);
/* 12 */   private TileEntityEnderChest field_147716_d = new TileEntityEnderChest(); private static final String __OBFID = "CL_00000946";
/*    */   
/*    */   public void func_147715_a(Block p_147715_1_, int p_147715_2_, float p_147715_3_) {
/* 15 */     if (p_147715_1_ == Blocks.field_150477_bB) {
/* 16 */       TileEntityRendererDispatcher.field_147556_a.func_147549_a((TileEntity)this.field_147716_d, 0.0D, 0.0D, 0.0D, 0.0F);
/* 17 */     } else if (p_147715_1_ == Blocks.field_150447_bR) {
/* 18 */       TileEntityRendererDispatcher.field_147556_a.func_147549_a((TileEntity)this.field_147718_c, 0.0D, 0.0D, 0.0D, 0.0F);
/*    */     } else {
/* 20 */       TileEntityRendererDispatcher.field_147556_a.func_147549_a((TileEntity)this.field_147717_b, 0.0D, 0.0D, 0.0D, 0.0F);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\tileentity\TileEntityRendererChestHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */