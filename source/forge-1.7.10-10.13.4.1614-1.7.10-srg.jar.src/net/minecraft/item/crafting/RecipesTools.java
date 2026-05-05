/*    */ package net.minecraft.item.crafting;
/*    */ 
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class RecipesTools {
/*  9 */   private String[][] field_77588_a = new String[][] { { "XXX", " # ", " # " }, { "X", "#", "#" }, { "XX", "X#", " #" }, { "XX", " #", " #" } };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 27 */   private Object[][] field_77587_b = new Object[][] { { Blocks.field_150344_f, Blocks.field_150347_e, Items.field_151042_j, Items.field_151045_i, Items.field_151043_k }, { Items.field_151039_o, Items.field_151050_s, Items.field_151035_b, Items.field_151046_w, Items.field_151005_D }, { Items.field_151038_n, Items.field_151051_r, Items.field_151037_a, Items.field_151047_v, Items.field_151011_C }, { Items.field_151053_p, Items.field_151049_t, Items.field_151036_c, Items.field_151056_x, Items.field_151006_E }, { Items.field_151017_I, Items.field_151018_J, Items.field_151019_K, Items.field_151012_L, Items.field_151013_M } };
/*    */ 
/*    */ 
/*    */   
/*    */   private static final String __OBFID = "CL_00000096";
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_77586_a(CraftingManager p_77586_1_) {
/* 37 */     for (byte b = 0; b < (this.field_77587_b[0]).length; b++) {
/* 38 */       Object object = this.field_77587_b[0][b];
/*    */       
/* 40 */       for (byte b1 = 0; b1 < this.field_77587_b.length - 1; b1++) {
/* 41 */         Item item = (Item)this.field_77587_b[b1 + 1][b];
/* 42 */         p_77586_1_.func_92103_a(new ItemStack(item), new Object[] { this.field_77588_a[b1], Character.valueOf('#'), Items.field_151055_y, Character.valueOf('X'), object });
/*    */       } 
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 48 */     p_77586_1_.func_92103_a(new ItemStack((Item)Items.field_151097_aZ), new Object[] { " #", "# ", Character.valueOf('#'), Items.field_151042_j });
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\crafting\RecipesTools.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */