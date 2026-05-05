/*     */ package net.minecraftforge.oredict;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.inventory.InventoryCrafting;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.crafting.IRecipe;
/*     */ import net.minecraft.item.crafting.ShapelessRecipes;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ShapelessOreRecipe
/*     */   implements IRecipe
/*     */ {
/*  19 */   private ItemStack output = null;
/*  20 */   private ArrayList<Object> input = new ArrayList();
/*     */   
/*  22 */   public ShapelessOreRecipe(Block result, Object... recipe) { this(new ItemStack(result), recipe); } public ShapelessOreRecipe(Item result, Object... recipe) {
/*  23 */     this(new ItemStack(result), recipe);
/*     */   }
/*     */   
/*     */   public ShapelessOreRecipe(ItemStack result, Object... recipe) {
/*  27 */     this.output = result.copy();
/*  28 */     for (Object in : recipe) {
/*     */       
/*  30 */       if (in instanceof ItemStack) {
/*     */         
/*  32 */         this.input.add(((ItemStack)in).copy());
/*     */       }
/*  34 */       else if (in instanceof Item) {
/*     */         
/*  36 */         this.input.add(new ItemStack((Item)in));
/*     */       }
/*  38 */       else if (in instanceof Block) {
/*     */         
/*  40 */         this.input.add(new ItemStack((Block)in));
/*     */       }
/*  42 */       else if (in instanceof String) {
/*     */         
/*  44 */         this.input.add(OreDictionary.getOres((String)in));
/*     */       }
/*     */       else {
/*     */         
/*  48 */         String ret = "Invalid shapeless ore recipe: ";
/*  49 */         for (Object tmp : recipe)
/*     */         {
/*  51 */           ret = ret + tmp + ", ";
/*     */         }
/*  53 */         ret = ret + this.output;
/*  54 */         throw new RuntimeException(ret);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   ShapelessOreRecipe(ShapelessRecipes recipe, Map<ItemStack, String> replacements) {
/*  62 */     this.output = recipe.getRecipeOutput();
/*     */     
/*  64 */     for (ItemStack ingred : recipe.recipeItems) {
/*     */       
/*  66 */       Object<ItemStack> finalObj = (Object<ItemStack>)ingred;
/*  67 */       for (Map.Entry<ItemStack, String> replace : replacements.entrySet()) {
/*     */         
/*  69 */         if (OreDictionary.itemMatches(replace.getKey(), ingred, false)) {
/*     */           
/*  71 */           finalObj = (Object<ItemStack>)OreDictionary.getOres(replace.getValue());
/*     */           break;
/*     */         } 
/*     */       } 
/*  75 */       this.input.add(finalObj);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRecipeSize() {
/*  83 */     return this.input.size();
/*     */   }
/*     */   public ItemStack getRecipeOutput() {
/*  86 */     return this.output;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getCraftingResult(InventoryCrafting var1) {
/*  92 */     return this.output.copy();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean matches(InventoryCrafting var1, World world) {
/* 101 */     ArrayList<Object> required = new ArrayList(this.input);
/*     */     
/* 103 */     for (int x = 0; x < var1.getSizeInventory(); x++) {
/*     */       
/* 105 */       ItemStack slot = var1.getStackInSlot(x);
/*     */       
/* 107 */       if (slot != null) {
/*     */         
/* 109 */         boolean inRecipe = false;
/* 110 */         Iterator<Object> req = required.iterator();
/*     */         
/* 112 */         while (req.hasNext()) {
/*     */           
/* 114 */           boolean match = false;
/*     */           
/* 116 */           Object next = req.next();
/*     */           
/* 118 */           if (next instanceof ItemStack) {
/*     */             
/* 120 */             match = OreDictionary.itemMatches((ItemStack)next, slot, false);
/*     */           }
/* 122 */           else if (next instanceof ArrayList) {
/*     */             
/* 124 */             Iterator<ItemStack> itr = ((ArrayList<ItemStack>)next).iterator();
/* 125 */             while (itr.hasNext() && !match)
/*     */             {
/* 127 */               match = OreDictionary.itemMatches(itr.next(), slot, false);
/*     */             }
/*     */           } 
/*     */           
/* 131 */           if (match) {
/*     */             
/* 133 */             inRecipe = true;
/* 134 */             required.remove(next);
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/* 139 */         if (!inRecipe)
/*     */         {
/* 141 */           return false;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 146 */     return required.isEmpty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<Object> getInput() {
/* 156 */     return this.input;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\oredict\ShapelessOreRecipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */