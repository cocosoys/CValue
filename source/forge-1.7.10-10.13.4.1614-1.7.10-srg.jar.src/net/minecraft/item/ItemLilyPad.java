/*    */ package net.minecraft.item;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemLilyPad extends ItemColored {
/*    */   public ItemLilyPad(Block p_i45357_1_) {
/* 13 */     super(p_i45357_1_, false);
/*    */   }
/*    */   
/*    */   private static final String __OBFID = "CL_00000074";
/*    */   
/*    */   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
/* 19 */     MovingObjectPosition movingObjectPosition = func_77621_a(p_77659_2_, p_77659_3_, true);
/* 20 */     if (movingObjectPosition == null) return p_77659_1_;
/*    */     
/* 22 */     if (movingObjectPosition.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) {
/* 23 */       int i = movingObjectPosition.field_72311_b;
/* 24 */       int j = movingObjectPosition.field_72312_c;
/* 25 */       int k = movingObjectPosition.field_72309_d;
/*    */       
/* 27 */       if (!p_77659_2_.func_72962_a(p_77659_3_, i, j, k)) {
/* 28 */         return p_77659_1_;
/*    */       }
/* 30 */       if (!p_77659_3_.func_82247_a(i, j, k, movingObjectPosition.field_72310_e, p_77659_1_)) return p_77659_1_;
/*    */       
/* 32 */       if (p_77659_2_.func_147439_a(i, j, k).func_149688_o() == Material.field_151586_h && p_77659_2_.func_72805_g(i, j, k) == 0 && p_77659_2_.func_147437_c(i, j + 1, k)) {
/* 33 */         p_77659_2_.func_147449_b(i, j + 1, k, Blocks.field_150392_bi);
/* 34 */         if (!p_77659_3_.field_71075_bZ.field_75098_d) {
/* 35 */           p_77659_1_.field_77994_a--;
/*    */         }
/*    */       } 
/*    */     } 
/* 39 */     return p_77659_1_;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_82790_a(ItemStack p_82790_1_, int p_82790_2_) {
/* 44 */     return Blocks.field_150392_bi.func_149741_i(p_82790_1_.func_77960_j());
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemLilyPad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */