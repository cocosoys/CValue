/*     */ package net.minecraftforge.oredict;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.inventory.InventoryCrafting;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.crafting.IRecipe;
/*     */ import net.minecraft.item.crafting.ShapedRecipes;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ShapedOreRecipe
/*     */   implements IRecipe
/*     */ {
/*     */   private static final int MAX_CRAFT_GRID_WIDTH = 3;
/*     */   private static final int MAX_CRAFT_GRID_HEIGHT = 3;
/*  23 */   private ItemStack output = null;
/*  24 */   private Object[] input = null;
/*  25 */   private int width = 0;
/*  26 */   private int height = 0;
/*     */   private boolean mirrored = true;
/*     */   
/*  29 */   public ShapedOreRecipe(Block result, Object... recipe) { this(new ItemStack(result), recipe); } public ShapedOreRecipe(Item result, Object... recipe) {
/*  30 */     this(new ItemStack(result), recipe);
/*     */   }
/*     */   public ShapedOreRecipe(ItemStack result, Object... recipe) {
/*  33 */     this.output = result.copy();
/*     */     
/*  35 */     String shape = "";
/*  36 */     int idx = 0;
/*     */     
/*  38 */     if (recipe[idx] instanceof Boolean) {
/*     */       
/*  40 */       this.mirrored = ((Boolean)recipe[idx]).booleanValue();
/*  41 */       if (recipe[idx + 1] instanceof Object[]) {
/*     */         
/*  43 */         recipe = (Object[])recipe[idx + 1];
/*     */       }
/*     */       else {
/*     */         
/*  47 */         idx = 1;
/*     */       } 
/*     */     } 
/*     */     
/*  51 */     if (recipe[idx] instanceof String[]) {
/*     */       
/*  53 */       String[] parts = (String[])recipe[idx++];
/*     */       
/*  55 */       for (String s : parts) {
/*     */         
/*  57 */         this.width = s.length();
/*  58 */         shape = shape + s;
/*     */       } 
/*     */       
/*  61 */       this.height = parts.length;
/*     */     }
/*     */     else {
/*     */       
/*  65 */       while (recipe[idx] instanceof String) {
/*     */         
/*  67 */         String s = (String)recipe[idx++];
/*  68 */         shape = shape + s;
/*  69 */         this.width = s.length();
/*  70 */         this.height++;
/*     */       } 
/*     */     } 
/*     */     
/*  74 */     if (this.width * this.height != shape.length()) {
/*     */       
/*  76 */       String ret = "Invalid shaped ore recipe: ";
/*  77 */       for (Object tmp : recipe)
/*     */       {
/*  79 */         ret = ret + tmp + ", ";
/*     */       }
/*  81 */       ret = ret + this.output;
/*  82 */       throw new RuntimeException(ret);
/*     */     } 
/*     */     
/*  85 */     HashMap<Character, Object> itemMap = new HashMap<Character, Object>();
/*     */     
/*  87 */     for (; idx < recipe.length; idx += 2) {
/*     */       
/*  89 */       Character chr = (Character)recipe[idx];
/*  90 */       Object in = recipe[idx + 1];
/*     */       
/*  92 */       if (in instanceof ItemStack) {
/*     */         
/*  94 */         itemMap.put(chr, ((ItemStack)in).copy());
/*     */       }
/*  96 */       else if (in instanceof Item) {
/*     */         
/*  98 */         itemMap.put(chr, new ItemStack((Item)in));
/*     */       }
/* 100 */       else if (in instanceof Block) {
/*     */         
/* 102 */         itemMap.put(chr, new ItemStack((Block)in, 1, 32767));
/*     */       }
/* 104 */       else if (in instanceof String) {
/*     */         
/* 106 */         itemMap.put(chr, OreDictionary.getOres((String)in));
/*     */       }
/*     */       else {
/*     */         
/* 110 */         String ret = "Invalid shaped ore recipe: ";
/* 111 */         for (Object tmp : recipe)
/*     */         {
/* 113 */           ret = ret + tmp + ", ";
/*     */         }
/* 115 */         ret = ret + this.output;
/* 116 */         throw new RuntimeException(ret);
/*     */       } 
/*     */     } 
/*     */     
/* 120 */     this.input = new Object[this.width * this.height];
/* 121 */     int x = 0;
/* 122 */     for (char chr : shape.toCharArray())
/*     */     {
/* 124 */       this.input[x++] = itemMap.get(Character.valueOf(chr));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   ShapedOreRecipe(ShapedRecipes recipe, Map<ItemStack, String> replacements) {
/* 130 */     this.output = recipe.getRecipeOutput();
/* 131 */     this.width = recipe.recipeWidth;
/* 132 */     this.height = recipe.recipeHeight;
/*     */     
/* 134 */     this.input = new Object[recipe.recipeItems.length];
/*     */     
/* 136 */     for (int i = 0; i < this.input.length; i++) {
/*     */       
/* 138 */       ItemStack ingred = recipe.recipeItems[i];
/*     */       
/* 140 */       if (ingred != null) {
/*     */         
/* 142 */         this.input[i] = recipe.recipeItems[i];
/*     */         
/* 144 */         for (Map.Entry<ItemStack, String> replace : replacements.entrySet()) {
/*     */           
/* 146 */           if (OreDictionary.itemMatches(replace.getKey(), ingred, true)) {
/*     */             
/* 148 */             this.input[i] = OreDictionary.getOres(replace.getValue());
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getCraftingResult(InventoryCrafting var1) {
/* 159 */     return this.output.copy();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRecipeSize() {
/* 165 */     return this.input.length;
/*     */   }
/*     */   public ItemStack getRecipeOutput() {
/* 168 */     return this.output;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean matches(InventoryCrafting inv, World world) {
/* 176 */     for (int x = 0; x <= 3 - this.width; x++) {
/*     */       
/* 178 */       for (int y = 0; y <= 3 - this.height; y++) {
/*     */         
/* 180 */         if (checkMatch(inv, x, y, false))
/*     */         {
/* 182 */           return true;
/*     */         }
/*     */         
/* 185 */         if (this.mirrored && checkMatch(inv, x, y, true))
/*     */         {
/* 187 */           return true;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 192 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean checkMatch(InventoryCrafting inv, int startX, int startY, boolean mirror) {
/* 198 */     for (int x = 0; x < 3; x++) {
/*     */       
/* 200 */       for (int y = 0; y < 3; y++) {
/*     */         
/* 202 */         int subX = x - startX;
/* 203 */         int subY = y - startY;
/* 204 */         Object target = null;
/*     */         
/* 206 */         if (subX >= 0 && subY >= 0 && subX < this.width && subY < this.height)
/*     */         {
/* 208 */           if (mirror) {
/*     */             
/* 210 */             target = this.input[this.width - subX - 1 + subY * this.width];
/*     */           }
/*     */           else {
/*     */             
/* 214 */             target = this.input[subX + subY * this.width];
/*     */           } 
/*     */         }
/*     */         
/* 218 */         ItemStack slot = inv.getStackInRowAndColumn(x, y);
/*     */         
/* 220 */         if (target instanceof ItemStack) {
/*     */           
/* 222 */           if (!OreDictionary.itemMatches((ItemStack)target, slot, false))
/*     */           {
/* 224 */             return false;
/*     */           }
/*     */         }
/* 227 */         else if (target instanceof ArrayList) {
/*     */           
/* 229 */           boolean matched = false;
/*     */           
/* 231 */           Iterator<ItemStack> itr = ((ArrayList<ItemStack>)target).iterator();
/* 232 */           while (itr.hasNext() && !matched)
/*     */           {
/* 234 */             matched = OreDictionary.itemMatches(itr.next(), slot, false);
/*     */           }
/*     */           
/* 237 */           if (!matched)
/*     */           {
/* 239 */             return false;
/*     */           }
/*     */         }
/* 242 */         else if (target == null && slot != null) {
/*     */           
/* 244 */           return false;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 249 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ShapedOreRecipe setMirrored(boolean mirror) {
/* 254 */     this.mirrored = mirror;
/* 255 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object[] getInput() {
/* 265 */     return this.input;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\oredict\ShapedOreRecipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */