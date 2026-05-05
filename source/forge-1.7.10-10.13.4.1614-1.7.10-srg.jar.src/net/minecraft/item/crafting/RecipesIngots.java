/*    */ package net.minecraft.item.crafting;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class RecipesIngots {
/*  8 */   private Object[][] field_77591_a = new Object[][] { { Blocks.field_150340_R, new ItemStack(Items.field_151043_k, 9) }, { Blocks.field_150339_S, new ItemStack(Items.field_151042_j, 9) }, { Blocks.field_150484_ah, new ItemStack(Items.field_151045_i, 9) }, { Blocks.field_150475_bE, new ItemStack(Items.field_151166_bC, 9) }, { Blocks.field_150368_y, new ItemStack(Items.field_151100_aR, 9, 4) }, { Blocks.field_150451_bX, new ItemStack(Items.field_151137_ax, 9) }, { Blocks.field_150402_ci, new ItemStack(Items.field_151044_h, 9, 0) }, { Blocks.field_150407_cf, new ItemStack(Items.field_151015_O, 9) } };
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static final String __OBFID = "CL_00000089";
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_77590_a(CraftingManager p_77590_1_) {
/* 20 */     for (byte b = 0; b < this.field_77591_a.length; b++) {
/* 21 */       Block block = (Block)this.field_77591_a[b][0];
/* 22 */       ItemStack itemStack = (ItemStack)this.field_77591_a[b][1];
/* 23 */       p_77590_1_.func_92103_a(new ItemStack(block), new Object[] { "###", "###", "###", Character.valueOf('#'), itemStack });
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 30 */       p_77590_1_.func_92103_a(itemStack, new Object[] { "#", Character.valueOf('#'), block });
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 35 */     p_77590_1_.func_92103_a(new ItemStack(Items.field_151043_k), new Object[] { "###", "###", "###", Character.valueOf('#'), Items.field_151074_bl });
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 41 */     p_77590_1_.func_92103_a(new ItemStack(Items.field_151074_bl, 9), new Object[] { "#", Character.valueOf('#'), Items.field_151043_k });
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\crafting\RecipesIngots.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */