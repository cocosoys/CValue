/*    */ package net.minecraft.block;
/*    */ 
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public abstract class BlockContainer extends Block implements ITileEntityProvider {
/*    */   protected BlockContainer(Material p_i45386_1_) {
/*  9 */     super(p_i45386_1_);
/* 10 */     this.field_149758_A = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
/* 15 */     super.func_149726_b(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000193";
/*    */   
/*    */   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
/* 20 */     super.func_149749_a(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
/* 21 */     p_149749_1_.func_147475_p(p_149749_2_, p_149749_3_, p_149749_4_);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_149696_a(World p_149696_1_, int p_149696_2_, int p_149696_3_, int p_149696_4_, int p_149696_5_, int p_149696_6_) {
/* 26 */     super.func_149696_a(p_149696_1_, p_149696_2_, p_149696_3_, p_149696_4_, p_149696_5_, p_149696_6_);
/* 27 */     TileEntity tileEntity = p_149696_1_.func_147438_o(p_149696_2_, p_149696_3_, p_149696_4_);
/* 28 */     if (tileEntity != null) {
/* 29 */       return tileEntity.func_145842_c(p_149696_5_, p_149696_6_);
/*    */     }
/* 31 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */