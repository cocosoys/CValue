/*    */ package net.minecraft.item;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.BlockDoublePlant;
/*    */ import net.minecraft.util.IIcon;
/*    */ import net.minecraft.world.ColorizerGrass;
/*    */ 
/*    */ public class ItemDoublePlant extends ItemMultiTexture {
/*    */   public ItemDoublePlant(Block p_i45335_1_, BlockDoublePlant p_i45335_2_, String[] p_i45335_3_) {
/* 11 */     super(p_i45335_1_, (Block)p_i45335_2_, p_i45335_3_);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000021";
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_77617_a(int p_77617_1_) {
/* 16 */     if (BlockDoublePlant.func_149890_d(p_77617_1_) == 0) {
/* 17 */       return ((BlockDoublePlant)this.field_150941_b).field_149891_b[0];
/*    */     }
/* 19 */     return ((BlockDoublePlant)this.field_150941_b).func_149888_a(true, p_77617_1_);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_82790_a(ItemStack p_82790_1_, int p_82790_2_) {
/* 24 */     int i = BlockDoublePlant.func_149890_d(p_82790_1_.func_77960_j());
/* 25 */     if (i == 2 || i == 3) {
/* 26 */       return ColorizerGrass.func_77480_a(0.5D, 1.0D);
/*    */     }
/* 28 */     return super.func_82790_a(p_82790_1_, p_82790_2_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemDoublePlant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */