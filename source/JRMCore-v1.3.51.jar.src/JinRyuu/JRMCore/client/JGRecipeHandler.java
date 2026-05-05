/*     */ package JinRyuu.JRMCore.client;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.items.ItemsJRMC;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.crafting.CraftingManager;
/*     */ import net.minecraft.item.crafting.IRecipe;
/*     */ import net.minecraft.item.crafting.ShapedRecipes;
/*     */ import net.minecraft.item.crafting.ShapelessRecipes;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JGRecipeHandler
/*     */ {
/*  26 */   public static final String[] recipelistmods = new String[] { "JRMCore", "Dragon Block C", "Naruto C", "Years C" };
/*  27 */   public static HashMap<String, ItemStack> recipelist = new HashMap<String, ItemStack>();
/*  28 */   public static final String[] recipelistcategories = new String[] { "Blocks", "Items", "Armors", "Weapons", "Tools", "Vanities" };
/*  29 */   public static int[][] recipelistitems = new int[recipelistmods.length][recipelistcategories.length];
/*     */ 
/*     */   
/*     */   public static void registerRecipes() {
/*  33 */     for (int i = 0; i < recipelistmods.length; i++) {
/*     */       
/*  35 */       for (int k = 0; k < recipelistcategories.length; k++)
/*     */       {
/*  37 */         recipelistitems[i][k] = 0;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  45 */     String mod = "JRMCore";
/*     */     
/*  47 */     String category = "Tools";
/*  48 */     addRecipe(mod, category, ItemsJRMC.ItemBarberSnC);
/*  49 */     category = "Items";
/*  50 */     addRecipe(mod, category, ItemsJRMC.Custom_fabric);
/*  51 */     category = "Vanities";
/*  52 */     addRecipe(mod, category, ItemsJRMC.Costume_creeper);
/*  53 */     addRecipe(mod, category, ItemsJRMC.Costume_ender);
/*  54 */     for (int j = 0; j < ItemsJRMC.ItemVanity3.length; ) { addRecipe(mod, category, ItemsJRMC.ItemsVanity[j]); j++; }
/*     */     
/*  56 */     if (JRMCoreH.DBC())
/*     */     {
/*  58 */       JGRecipesDBC.registerRecipes(mod, category);
/*     */     }
/*     */     
/*  61 */     if (JRMCoreH.NC())
/*     */     {
/*  63 */       JGRecipesNC.registerRecipes(mod, category);
/*     */     }
/*     */     
/*  66 */     if (JRMCoreH.JYC())
/*     */     {
/*  68 */       JGRecipesYC.registerRecipes(mod, category);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void addRecipe(String mod, String category, ItemStack stack) {
/*  75 */     int id = 0;
/*     */     
/*  77 */     for (int i = 0; i < recipelistmods.length; i++) {
/*     */       
/*  79 */       for (int j = 0; j < recipelistcategories.length; j++) {
/*     */         
/*  81 */         if (recipelistmods[i].equals(mod) && recipelistcategories[j].equals(category)) {
/*     */           
/*  83 */           id = recipelistitems[i][j];
/*  84 */           recipelistitems[i][j] = recipelistitems[i][j] + 1;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/*  90 */     recipelist.put(mod + "." + category + id, stack);
/*     */   }
/*     */   
/*     */   public static void addRecipe(String mod, String category, Item stack) {
/*  94 */     addRecipe(mod, category, new ItemStack(stack));
/*     */   }
/*     */   
/*     */   public static void addRecipe(String mod, String category, Block stack) {
/*  98 */     addRecipe(mod, category, new ItemStack(stack));
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getRecipeCount(int mod, int category) {
/* 103 */     return recipelistitems[mod][category];
/*     */   }
/*     */   
/*     */   public static boolean hasRecipes(int mod, int category) {
/* 107 */     return (recipelistitems[mod][category] > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getFirstRecipeCategory(int mod) {
/* 112 */     for (int i = 0; i < recipelistcategories.length; i++) {
/*     */       
/* 114 */       if (hasRecipes(mod, i)) return i; 
/*     */     } 
/* 116 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static IRecipe getRecipe(Item item) {
/* 122 */     List<IRecipe> recipes = CraftingManager.func_77594_a().func_77592_b();
/*     */     
/* 124 */     for (IRecipe obj : recipes) {
/*     */       
/* 126 */       if (obj instanceof ShapedRecipes) {
/* 127 */         ShapedRecipes recipe = (ShapedRecipes)obj;
/* 128 */         ItemStack output = recipe.func_77571_b();
/*     */         
/* 130 */         if (output.func_77973_b().equals(item)) {
/* 131 */           return (IRecipe)recipe;
/*     */         }
/*     */         continue;
/*     */       } 
/* 135 */       if (obj instanceof ShapelessRecipes) {
/* 136 */         ShapelessRecipes recipe = (ShapelessRecipes)obj;
/* 137 */         ItemStack output = recipe.func_77571_b();
/*     */         
/* 139 */         if (output.func_77973_b().equals(item)) {
/* 140 */           return (IRecipe)recipe;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 145 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ItemStack colorFix(ItemStack recept, ItemStack receptName) {
/* 151 */     ItemStack item = recept;
/*     */     
/* 153 */     if (item != null)
/*     */     {
/* 155 */       if (item.func_77973_b().func_77658_a().equals("tile.cloth") || item.func_77973_b().func_77658_a().equals("item.dyePowder"))
/*     */       {
/* 157 */         if (receptName.func_77973_b().getDamage(receptName) == 32767) {
/*     */           
/* 159 */           if (item.func_77973_b().func_77658_a().equals("tile.cloth")) {
/*     */             
/* 161 */             item = new ItemStack(Blocks.field_150325_L);
/*     */           }
/*     */           else {
/*     */             
/* 165 */             item = new ItemStack(Items.field_151100_aR);
/*     */           } 
/* 167 */           item.func_77973_b().setDamage(item, 15);
/*     */ 
/*     */ 
/*     */         
/*     */         }
/* 172 */         else if (item.func_77973_b().func_77658_a().equals("tile.cloth")) {
/*     */           
/* 174 */           item = new ItemStack(Blocks.field_150325_L, 1, receptName.func_77973_b().getDamage(receptName));
/*     */         }
/*     */         else {
/*     */           
/* 178 */           item = new ItemStack(Items.field_151100_aR, 1, receptName.func_77973_b().getDamage(receptName));
/*     */         } 
/*     */       }
/*     */     }
/*     */     
/* 183 */     return item;
/*     */   }
/*     */   
/*     */   public static ShapedRecipes getShapedRecipe(Object obj, Item item) {
/* 187 */     ShapedRecipes recipe = (ShapedRecipes)obj;
/* 188 */     ItemStack output = recipe.func_77571_b();
/*     */     
/* 190 */     if (output.func_77973_b().equals(item)) {
/* 191 */       return recipe;
/*     */     }
/* 193 */     return null;
/*     */   }
/*     */   public static ShapelessRecipes getShapelessRecipe(Object obj, Item item) {
/* 196 */     ShapelessRecipes recipe = (ShapelessRecipes)obj;
/* 197 */     ItemStack output = recipe.func_77571_b();
/*     */     
/* 199 */     if (output.func_77973_b().equals(item)) {
/* 200 */       return recipe;
/*     */     }
/* 202 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\client\JGRecipeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */