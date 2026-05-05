/*     */ package net.minecraftforge.oredict;
/*     */ 
/*     */ import com.google.common.base.Joiner;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.common.collect.Sets;
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import cpw.mods.fml.common.toposort.TopologicalSort;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import net.minecraft.item.crafting.CraftingManager;
/*     */ import net.minecraft.item.crafting.IRecipe;
/*     */ import net.minecraft.item.crafting.RecipeBookCloning;
/*     */ import net.minecraft.item.crafting.RecipeFireworks;
/*     */ import net.minecraft.item.crafting.RecipesArmorDyes;
/*     */ import net.minecraft.item.crafting.RecipesMapCloning;
/*     */ import net.minecraft.item.crafting.RecipesMapExtending;
/*     */ import net.minecraft.item.crafting.ShapedRecipes;
/*     */ import net.minecraft.item.crafting.ShapelessRecipes;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RecipeSorter
/*     */   implements Comparator<IRecipe>
/*     */ {
/*     */   public enum Category
/*     */   {
/*  33 */     UNKNOWN,
/*  34 */     SHAPELESS,
/*  35 */     SHAPED;
/*     */   }
/*     */   
/*     */   private static class SortEntry
/*     */   {
/*     */     private String name;
/*     */     private Class<?> cls;
/*     */     private RecipeSorter.Category cat;
/*  43 */     List<String> before = Lists.newArrayList();
/*  44 */     List<String> after = Lists.newArrayList();
/*     */ 
/*     */     
/*     */     private SortEntry(String name, Class<?> cls, RecipeSorter.Category cat, String deps) {
/*  48 */       this.name = name;
/*  49 */       this.cls = cls;
/*  50 */       this.cat = cat;
/*  51 */       parseDepends(deps);
/*     */     }
/*     */ 
/*     */     
/*     */     private void parseDepends(String deps) {
/*  56 */       if (deps.isEmpty())
/*  57 */         return;  for (String dep : deps.split(" ")) {
/*     */         
/*  59 */         if (dep.startsWith("before:")) {
/*     */           
/*  61 */           this.before.add(dep.substring(7));
/*     */         }
/*  63 */         else if (dep.startsWith("after:")) {
/*     */           
/*  65 */           this.after.add(dep.substring(6));
/*     */         }
/*     */         else {
/*     */           
/*  69 */           throw new IllegalArgumentException("Invalid dependancy: " + dep);
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/*  77 */       StringBuilder buf = new StringBuilder();
/*  78 */       buf.append("RecipeEntry(\"").append(this.name).append("\", ");
/*  79 */       buf.append(this.cat.name()).append(", ");
/*  80 */       buf.append((this.cls == null) ? "" : this.cls.getName()).append(")");
/*     */       
/*  82 */       if (this.before.size() > 0)
/*     */       {
/*  84 */         buf.append(" Before: ").append(Joiner.on(", ").join(this.before));
/*     */       }
/*     */       
/*  87 */       if (this.after.size() > 0)
/*     */       {
/*  89 */         buf.append(" After: ").append(Joiner.on(", ").join(this.after));
/*     */       }
/*     */       
/*  92 */       return buf.toString();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*  98 */       return this.name.hashCode();
/*     */     }
/*     */   }
/*     */   
/* 102 */   private static Map<Class, Category> categories = Maps.newHashMap();
/*     */   
/* 104 */   private static Map<String, SortEntry> entries = Maps.newHashMap();
/* 105 */   private static Map<Class, Integer> priorities = Maps.newHashMap();
/*     */   
/* 107 */   public static RecipeSorter INSTANCE = new RecipeSorter();
/*     */   
/*     */   private static boolean isDirty = true;
/* 110 */   private static SortEntry before = new SortEntry("Before", null, Category.UNKNOWN, "");
/* 111 */   private static SortEntry after = new SortEntry("After", null, Category.UNKNOWN, "");
/*     */ 
/*     */   
/*     */   private RecipeSorter() {
/* 115 */     register("minecraft:shaped", ShapedRecipes.class, Category.SHAPED, "before:minecraft:shapeless");
/* 116 */     register("minecraft:mapextending", RecipesMapExtending.class, Category.SHAPED, "after:minecraft:shaped before:minecraft:shapeless");
/* 117 */     register("minecraft:shapeless", ShapelessRecipes.class, Category.SHAPELESS, "after:minecraft:shaped");
/* 118 */     register("minecraft:bookcloning", RecipeBookCloning.class, Category.SHAPELESS, "after:minecraft:shapeless");
/* 119 */     register("minecraft:fireworks", RecipeFireworks.class, Category.SHAPELESS, "after:minecraft:shapeless");
/* 120 */     register("minecraft:armordyes", RecipesArmorDyes.class, Category.SHAPELESS, "after:minecraft:shapeless");
/* 121 */     register("minecraft:mapcloning", RecipesMapCloning.class, Category.SHAPELESS, "after:minecraft:shapeless");
/*     */     
/* 123 */     register("forge:shapedore", ShapedOreRecipe.class, Category.SHAPED, "after:minecraft:shaped before:minecraft:shapeless");
/* 124 */     register("forge:shapelessore", ShapelessOreRecipe.class, Category.SHAPELESS, "after:minecraft:shapeless");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int compare(IRecipe r1, IRecipe r2) {
/* 130 */     Category c1 = getCategory(r1);
/* 131 */     Category c2 = getCategory(r2);
/* 132 */     if (c1 == Category.SHAPELESS && c2 == Category.SHAPED) return 1; 
/* 133 */     if (c1 == Category.SHAPED && c2 == Category.SHAPELESS) return -1; 
/* 134 */     if (r2.getRecipeSize() < r1.getRecipeSize()) return -1; 
/* 135 */     if (r2.getRecipeSize() > r1.getRecipeSize()) return 1; 
/* 136 */     return getPriority(r2) - getPriority(r1);
/*     */   }
/*     */   
/* 139 */   private static Set<Class> warned = Sets.newHashSet();
/*     */ 
/*     */   
/*     */   public static void sortCraftManager() {
/* 143 */     bake();
/* 144 */     FMLLog.fine("Sorting recipies", new Object[0]);
/* 145 */     warned.clear();
/* 146 */     Collections.sort(CraftingManager.getInstance().getRecipeList(), INSTANCE);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void register(String name, Class<?> recipe, Category category, String dependancies) {
/* 151 */     assert category != Category.UNKNOWN : "Category must not be unknown!";
/* 152 */     isDirty = true;
/*     */     
/* 154 */     SortEntry entry = new SortEntry(name, recipe, category, dependancies);
/* 155 */     entries.put(name, entry);
/* 156 */     setCategory(recipe, category);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setCategory(Class<?> recipe, Category category) {
/* 161 */     assert category != Category.UNKNOWN : "Category must not be unknown!";
/* 162 */     categories.put(recipe, category);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Category getCategory(IRecipe recipe) {
/* 167 */     return getCategory(recipe.getClass());
/*     */   }
/*     */ 
/*     */   
/*     */   public static Category getCategory(Class<?> recipe) {
/* 172 */     Class<?> cls = recipe;
/* 173 */     Category ret = categories.get(cls);
/*     */     
/* 175 */     if (ret == null)
/*     */     {
/* 177 */       while (cls != Object.class) {
/*     */         
/* 179 */         cls = cls.getSuperclass();
/* 180 */         ret = categories.get(cls);
/* 181 */         if (ret != null) {
/*     */           
/* 183 */           categories.put(recipe, ret);
/* 184 */           return ret;
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 189 */     return (ret == null) ? Category.UNKNOWN : ret;
/*     */   }
/*     */ 
/*     */   
/*     */   private static int getPriority(IRecipe recipe) {
/* 194 */     Class<?> cls = recipe.getClass();
/* 195 */     Integer ret = priorities.get(cls);
/*     */     
/* 197 */     if (ret == null) {
/*     */       
/* 199 */       if (!warned.contains(cls)) {
/*     */         
/* 201 */         FMLLog.info("  Unknown recipe class! %s Modder please refer to %s", new Object[] { cls.getName(), RecipeSorter.class.getName() });
/* 202 */         warned.add(cls);
/*     */       } 
/* 204 */       cls = cls.getSuperclass();
/* 205 */       while (cls != Object.class) {
/*     */         
/* 207 */         ret = priorities.get(cls);
/* 208 */         if (ret != null) {
/*     */           
/* 210 */           priorities.put(recipe.getClass(), ret);
/* 211 */           FMLLog.fine("    Parent Found: %d - %s", new Object[] { Integer.valueOf(ret.intValue()), cls.getName() });
/* 212 */           return ret.intValue();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 217 */     return (ret == null) ? 0 : ret.intValue();
/*     */   }
/*     */ 
/*     */   
/*     */   private static void bake() {
/* 222 */     if (!isDirty)
/* 223 */       return;  FMLLog.fine("Forge RecipeSorter Baking:", new Object[0]);
/* 224 */     TopologicalSort.DirectedGraph<SortEntry> sorter = new TopologicalSort.DirectedGraph();
/* 225 */     sorter.addNode(before);
/* 226 */     sorter.addNode(after);
/* 227 */     sorter.addEdge(before, after);
/*     */     
/* 229 */     for (Map.Entry<String, SortEntry> entry : entries.entrySet())
/*     */     {
/* 231 */       sorter.addNode(entry.getValue());
/*     */     }
/*     */     
/* 234 */     for (Map.Entry<String, SortEntry> e : entries.entrySet()) {
/*     */       
/* 236 */       SortEntry entry = e.getValue();
/* 237 */       boolean postAdded = false;
/*     */       
/* 239 */       sorter.addEdge(before, entry);
/* 240 */       for (String dep : entry.after) {
/*     */         
/* 242 */         if (entries.containsKey(dep))
/*     */         {
/* 244 */           sorter.addEdge(entries.get(dep), entry);
/*     */         }
/*     */       } 
/*     */       
/* 248 */       for (String dep : entry.before) {
/*     */         
/* 250 */         postAdded = true;
/* 251 */         sorter.addEdge(entry, after);
/* 252 */         if (entries.containsKey(dep))
/*     */         {
/* 254 */           sorter.addEdge(entry, entries.get(dep));
/*     */         }
/*     */       } 
/*     */       
/* 258 */       if (!postAdded)
/*     */       {
/* 260 */         sorter.addEdge(entry, after);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 265 */     List<SortEntry> sorted = TopologicalSort.topologicalSort(sorter);
/* 266 */     int x = sorted.size();
/* 267 */     for (SortEntry entry : sorted) {
/*     */       
/* 269 */       FMLLog.fine("  %d: %s", new Object[] { Integer.valueOf(x), entry });
/* 270 */       priorities.put(entry.cls, Integer.valueOf(x--));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\oredict\RecipeSorter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */