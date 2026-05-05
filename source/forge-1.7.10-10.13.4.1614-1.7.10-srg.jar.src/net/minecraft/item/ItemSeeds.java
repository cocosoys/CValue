/*    */ package net.minecraft.item;
/*    */ 
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemSeeds extends Item {
/*    */   private Block field_150925_a;
/*    */   
/*    */   public ItemSeeds(Block p_i45352_1_, Block p_i45352_2_) {
/* 12 */     this.field_150925_a = p_i45352_1_;
/* 13 */     this.field_77838_b = p_i45352_2_;
/* 14 */     func_77637_a(CreativeTabs.field_78035_l);
/*    */   }
/*    */   private Block field_77838_b; private static final String __OBFID = "CL_00000061";
/*    */   
/*    */   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
/* 19 */     if (p_77648_7_ != 1) return false;
/*    */     
/* 21 */     if (!p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_) || !p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_ + 1, p_77648_6_, p_77648_7_, p_77648_1_)) return false;
/*    */     
/* 23 */     if (p_77648_3_.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_) == this.field_77838_b && p_77648_3_.func_147437_c(p_77648_4_, p_77648_5_ + 1, p_77648_6_)) {
/* 24 */       p_77648_3_.func_147449_b(p_77648_4_, p_77648_5_ + 1, p_77648_6_, this.field_150925_a);
/* 25 */       p_77648_1_.field_77994_a--;
/* 26 */       return true;
/*    */     } 
/* 28 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemSeeds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */