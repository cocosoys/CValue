/*    */ package net.minecraft.item;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemRedstone extends Item {
/*    */   public ItemRedstone() {
/*  9 */     func_77637_a(CreativeTabs.field_78028_d);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000058";
/*    */   
/*    */   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
/* 14 */     if (p_77648_3_.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_) != Blocks.field_150431_aC) {
/* 15 */       if (p_77648_7_ == 0) p_77648_5_--; 
/* 16 */       if (p_77648_7_ == 1) p_77648_5_++; 
/* 17 */       if (p_77648_7_ == 2) p_77648_6_--; 
/* 18 */       if (p_77648_7_ == 3) p_77648_6_++; 
/* 19 */       if (p_77648_7_ == 4) p_77648_4_--; 
/* 20 */       if (p_77648_7_ == 5) p_77648_4_++; 
/* 21 */       if (!p_77648_3_.func_147437_c(p_77648_4_, p_77648_5_, p_77648_6_)) return false; 
/*    */     } 
/* 23 */     if (!p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_)) return false; 
/* 24 */     if (Blocks.field_150488_af.func_149742_c(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_)) {
/* 25 */       p_77648_1_.field_77994_a--;
/* 26 */       p_77648_3_.func_147449_b(p_77648_4_, p_77648_5_, p_77648_6_, (Block)Blocks.field_150488_af);
/*    */     } 
/*    */     
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemRedstone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */