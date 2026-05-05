/*    */ package net.minecraft.item;
/*    */ 
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemSeedFood
/*    */   extends ItemFood {
/*    */   private Block field_150908_b;
/*    */   private Block field_82809_c;
/*    */   private static final String __OBFID = "CL_00000060";
/*    */   
/*    */   public ItemSeedFood(int p_i45351_1_, float p_i45351_2_, Block p_i45351_3_, Block p_i45351_4_) {
/* 14 */     super(p_i45351_1_, p_i45351_2_, false);
/*    */     
/* 16 */     this.field_150908_b = p_i45351_3_;
/* 17 */     this.field_82809_c = p_i45351_4_;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
/* 22 */     if (p_77648_7_ != 1) return false;
/*    */     
/* 24 */     if (!p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_) || !p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_ + 1, p_77648_6_, p_77648_7_, p_77648_1_)) return false;
/*    */     
/* 26 */     if (p_77648_3_.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_) == this.field_82809_c && p_77648_3_.func_147437_c(p_77648_4_, p_77648_5_ + 1, p_77648_6_)) {
/* 27 */       p_77648_3_.func_147449_b(p_77648_4_, p_77648_5_ + 1, p_77648_6_, this.field_150908_b);
/* 28 */       p_77648_1_.field_77994_a--;
/* 29 */       return true;
/*    */     } 
/* 31 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemSeedFood.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */