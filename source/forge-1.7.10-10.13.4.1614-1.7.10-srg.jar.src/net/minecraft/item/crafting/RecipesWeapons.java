/*    */ package net.minecraft.item.crafting;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class RecipesWeapons {
/*  7 */   private String[][] field_77585_a = new String[][] { { "X", "X", "#" } };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 13 */   private Object[][] field_77584_b = new Object[][] { { Blocks.field_150344_f, Blocks.field_150347_e, Items.field_151042_j, Items.field_151045_i, Items.field_151043_k }, { Items.field_151041_m, Items.field_151052_q, Items.field_151040_l, Items.field_151048_u, Items.field_151010_B } };
/*    */   
/*    */   private static final String __OBFID = "CL_00000097";
/*    */ 
/*    */   
/*    */   public void func_77583_a(CraftingManager p_77583_1_) {
/* 19 */     for (byte b = 0; b < (this.field_77584_b[0]).length; b++) {
/* 20 */       Object object = this.field_77584_b[0][b];
/*    */       
/* 22 */       for (byte b1 = 0; b1 < this.field_77584_b.length - 1; b1++) {
/* 23 */         Item item = (Item)this.field_77584_b[b1 + 1][b];
/* 24 */         p_77583_1_.func_92103_a(new ItemStack(item), new Object[] { this.field_77585_a[b1], Character.valueOf('#'), Items.field_151055_y, Character.valueOf('X'), object });
/*    */       } 
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 32 */     p_77583_1_.func_92103_a(new ItemStack((Item)Items.field_151031_f, 1), new Object[] { " #X", "# X", " #X", Character.valueOf('X'), Items.field_151007_F, Character.valueOf('#'), Items.field_151055_y });
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 40 */     p_77583_1_.func_92103_a(new ItemStack(Items.field_151032_g, 4), new Object[] { "X", "#", "Y", Character.valueOf('Y'), Items.field_151008_G, Character.valueOf('X'), Items.field_151145_ak, Character.valueOf('#'), Items.field_151055_y });
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\crafting\RecipesWeapons.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */