/*    */ package net.minecraft.item.crafting;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.inventory.InventoryCrafting;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ShapelessRecipes implements IRecipe {
/*    */   private final ItemStack field_77580_a;
/*    */   public final List field_77579_b;
/*    */   private static final String __OBFID = "CL_00000094";
/*    */   
/*    */   public ShapelessRecipes(ItemStack p_i1918_1_, List p_i1918_2_) {
/* 15 */     this.field_77580_a = p_i1918_1_;
/* 16 */     this.field_77579_b = p_i1918_2_;
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack func_77571_b() {
/* 21 */     return this.field_77580_a;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_77569_a(InventoryCrafting p_77569_1_, World p_77569_2_) {
/* 27 */     ArrayList arrayList = new ArrayList(this.field_77579_b);
/*    */     
/* 29 */     for (byte b = 0; b < 3; b++) {
/* 30 */       for (byte b1 = 0; b1 < 3; b1++) {
/* 31 */         ItemStack itemStack = p_77569_1_.func_70463_b(b1, b);
/*    */         
/* 33 */         if (itemStack != null) {
/* 34 */           boolean bool = false;
/* 35 */           for (ItemStack itemStack1 : arrayList) {
/* 36 */             if (itemStack.func_77973_b() == itemStack1.func_77973_b() && (itemStack1.func_77960_j() == 32767 || itemStack.func_77960_j() == itemStack1.func_77960_j())) {
/* 37 */               bool = true;
/* 38 */               arrayList.remove(itemStack1);
/*    */               break;
/*    */             } 
/*    */           } 
/* 42 */           if (!bool) {
/* 43 */             return false;
/*    */           }
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 49 */     return arrayList.isEmpty();
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack func_77572_b(InventoryCrafting p_77572_1_) {
/* 54 */     return this.field_77580_a.func_77946_l();
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77570_a() {
/* 59 */     return this.field_77579_b.size();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\crafting\ShapelessRecipes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */