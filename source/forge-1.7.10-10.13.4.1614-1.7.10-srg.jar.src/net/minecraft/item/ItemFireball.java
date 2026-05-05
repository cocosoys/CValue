/*    */ package net.minecraft.item;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemFireball extends Item {
/*    */   public ItemFireball() {
/* 10 */     func_77637_a(CreativeTabs.field_78026_f);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000029";
/*    */   
/*    */   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
/* 15 */     if (p_77648_3_.field_72995_K) {
/* 16 */       return true;
/*    */     }
/*    */     
/* 19 */     if (p_77648_7_ == 0) p_77648_5_--; 
/* 20 */     if (p_77648_7_ == 1) p_77648_5_++; 
/* 21 */     if (p_77648_7_ == 2) p_77648_6_--; 
/* 22 */     if (p_77648_7_ == 3) p_77648_6_++; 
/* 23 */     if (p_77648_7_ == 4) p_77648_4_--; 
/* 24 */     if (p_77648_7_ == 5) p_77648_4_++;
/*    */     
/* 26 */     if (!p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_)) return false;
/*    */     
/* 28 */     if (p_77648_3_.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_).func_149688_o() == Material.field_151579_a) {
/* 29 */       p_77648_3_.func_72908_a(p_77648_4_ + 0.5D, p_77648_5_ + 0.5D, p_77648_6_ + 0.5D, "fire.ignite", 1.0F, field_77697_d.nextFloat() * 0.4F + 0.8F);
/* 30 */       p_77648_3_.func_147449_b(p_77648_4_, p_77648_5_, p_77648_6_, (Block)Blocks.field_150480_ab);
/*    */     } 
/* 32 */     if (!p_77648_2_.field_71075_bZ.field_75098_d) {
/* 33 */       p_77648_1_.field_77994_a--;
/*    */     }
/* 35 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemFireball.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */