/*    */ package net.minecraft.item.crafting;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.inventory.InventoryCrafting;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.storage.MapData;
/*    */ 
/*    */ public class RecipesMapExtending extends ShapedRecipes {
/*    */   public RecipesMapExtending() {
/* 12 */     super(3, 3, new ItemStack[] { new ItemStack(Items.field_151121_aF), new ItemStack(Items.field_151121_aF), new ItemStack(Items.field_151121_aF), new ItemStack(Items.field_151121_aF), new ItemStack((Item)Items.field_151098_aY, 0, 32767), new ItemStack(Items.field_151121_aF), new ItemStack(Items.field_151121_aF), new ItemStack(Items.field_151121_aF), new ItemStack(Items.field_151121_aF) }new ItemStack((Item)Items.field_151148_bJ, 0, 0));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static final String __OBFID = "CL_00000088";
/*    */ 
/*    */   
/*    */   public boolean func_77569_a(InventoryCrafting p_77569_1_, World p_77569_2_) {
/* 21 */     if (!super.func_77569_a(p_77569_1_, p_77569_2_)) return false; 
/* 22 */     ItemStack itemStack = null;
/*    */     
/* 24 */     for (byte b = 0; b < p_77569_1_.func_70302_i_() && itemStack == null; b++) {
/* 25 */       ItemStack itemStack1 = p_77569_1_.func_70301_a(b);
/* 26 */       if (itemStack1 != null && itemStack1.func_77973_b() == Items.field_151098_aY) itemStack = itemStack1;
/*    */     
/*    */     } 
/* 29 */     if (itemStack == null) return false; 
/* 30 */     MapData mapData = Items.field_151098_aY.func_77873_a(itemStack, p_77569_2_);
/* 31 */     if (mapData == null) return false; 
/* 32 */     return (mapData.field_76197_d < 4);
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack func_77572_b(InventoryCrafting p_77572_1_) {
/* 37 */     ItemStack itemStack = null;
/*    */     
/* 39 */     for (byte b = 0; b < p_77572_1_.func_70302_i_() && itemStack == null; b++) {
/* 40 */       ItemStack itemStack1 = p_77572_1_.func_70301_a(b);
/* 41 */       if (itemStack1 != null && itemStack1.func_77973_b() == Items.field_151098_aY) itemStack = itemStack1;
/*    */     
/*    */     } 
/* 44 */     itemStack = itemStack.func_77946_l();
/* 45 */     itemStack.field_77994_a = 1;
/*    */     
/* 47 */     if (itemStack.func_77978_p() == null) itemStack.func_77982_d(new NBTTagCompound()); 
/* 48 */     itemStack.func_77978_p().func_74757_a("map_is_scaling", true);
/*    */     
/* 50 */     return itemStack;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\crafting\RecipesMapExtending.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */