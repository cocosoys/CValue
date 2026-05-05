/*    */ package net.minecraft.item.crafting;
/*    */ 
/*    */ import net.minecraft.inventory.InventoryCrafting;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ShapedRecipes
/*    */   implements IRecipe {
/*    */   public final int field_77576_b;
/*    */   public final int field_77577_c;
/*    */   public final ItemStack[] field_77574_d;
/*    */   
/*    */   public ShapedRecipes(int p_i1917_1_, int p_i1917_2_, ItemStack[] p_i1917_3_, ItemStack p_i1917_4_) {
/* 15 */     this.field_77576_b = p_i1917_1_;
/* 16 */     this.field_77577_c = p_i1917_2_;
/* 17 */     this.field_77574_d = p_i1917_3_;
/* 18 */     this.field_77575_e = p_i1917_4_;
/*    */   }
/*    */   private ItemStack field_77575_e; private boolean field_92101_f; private static final String __OBFID = "CL_00000093";
/*    */   
/*    */   public ItemStack func_77571_b() {
/* 23 */     return this.field_77575_e;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_77569_a(InventoryCrafting p_77569_1_, World p_77569_2_) {
/* 28 */     for (byte b = 0; b <= 3 - this.field_77576_b; b++) {
/* 29 */       for (byte b1 = 0; b1 <= 3 - this.field_77577_c; b1++) {
/* 30 */         if (func_77573_a(p_77569_1_, b, b1, true)) return true; 
/* 31 */         if (func_77573_a(p_77569_1_, b, b1, false)) return true; 
/*    */       } 
/*    */     } 
/* 34 */     return false;
/*    */   }
/*    */   
/*    */   private boolean func_77573_a(InventoryCrafting p_77573_1_, int p_77573_2_, int p_77573_3_, boolean p_77573_4_) {
/* 38 */     for (byte b = 0; b < 3; b++) {
/* 39 */       for (byte b1 = 0; b1 < 3; b1++) {
/* 40 */         int i = b - p_77573_2_;
/* 41 */         int j = b1 - p_77573_3_;
/* 42 */         ItemStack itemStack1 = null;
/* 43 */         if (i >= 0 && j >= 0 && i < this.field_77576_b && j < this.field_77577_c)
/* 44 */           if (p_77573_4_) { itemStack1 = this.field_77574_d[this.field_77576_b - i - 1 + j * this.field_77576_b]; }
/* 45 */           else { itemStack1 = this.field_77574_d[i + j * this.field_77576_b]; }
/*    */            
/* 47 */         ItemStack itemStack2 = p_77573_1_.func_70463_b(b, b1);
/* 48 */         if (itemStack2 != null || itemStack1 != null) {
/*    */ 
/*    */           
/* 51 */           if ((itemStack2 == null && itemStack1 != null) || (itemStack2 != null && itemStack1 == null)) {
/* 52 */             return false;
/*    */           }
/* 54 */           if (itemStack1.func_77973_b() != itemStack2.func_77973_b()) {
/* 55 */             return false;
/*    */           }
/* 57 */           if (itemStack1.func_77960_j() != 32767 && itemStack1.func_77960_j() != itemStack2.func_77960_j())
/* 58 */             return false; 
/*    */         } 
/*    */       } 
/*    */     } 
/* 62 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack func_77572_b(InventoryCrafting p_77572_1_) {
/* 67 */     ItemStack itemStack = func_77571_b().func_77946_l();
/*    */     
/* 69 */     if (this.field_92101_f) {
/* 70 */       for (byte b = 0; b < p_77572_1_.func_70302_i_(); b++) {
/* 71 */         ItemStack itemStack1 = p_77572_1_.func_70301_a(b);
/*    */         
/* 73 */         if (itemStack1 != null && itemStack1.func_77942_o()) {
/* 74 */           itemStack.func_77982_d((NBTTagCompound)itemStack1.field_77990_d.func_74737_b());
/*    */         }
/*    */       } 
/*    */     }
/*    */     
/* 79 */     return itemStack;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77570_a() {
/* 84 */     return this.field_77576_b * this.field_77577_c;
/*    */   }
/*    */   
/*    */   public ShapedRecipes func_92100_c() {
/* 88 */     this.field_92101_f = true;
/* 89 */     return this;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\crafting\ShapedRecipes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */