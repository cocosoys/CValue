/*     */ package net.minecraftforge.common;
/*     */ 
/*     */ import com.google.common.base.Predicate;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.projectile.EntityFishHook;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.stats.StatBase;
/*     */ import net.minecraft.stats.StatList;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.WeightedRandom;
/*     */ import net.minecraft.util.WeightedRandomFishable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FishingHooks
/*     */ {
/*  20 */   private static ArrayList<WeightedRandomFishable> fish = new ArrayList<WeightedRandomFishable>();
/*  21 */   private static ArrayList<WeightedRandomFishable> junk = new ArrayList<WeightedRandomFishable>();
/*  22 */   private static ArrayList<WeightedRandomFishable> treasure = new ArrayList<WeightedRandomFishable>();
/*     */   
/*  24 */   public static void addFish(WeightedRandomFishable item) { fish.add(item); }
/*  25 */   public static void addJunk(WeightedRandomFishable item) { junk.add(item); } public static void addTreasure(WeightedRandomFishable item) {
/*  26 */     treasure.add(item);
/*     */   }
/*  28 */   public static void removeFish(Predicate<WeightedRandomFishable> test) { remove(fish.iterator(), test); }
/*  29 */   public static void removeJunk(Predicate<WeightedRandomFishable> test) { remove(junk.iterator(), test); } public static void removeTreasure(Predicate<WeightedRandomFishable> test) {
/*  30 */     remove(treasure.iterator(), test);
/*     */   }
/*     */   
/*     */   public static ItemStack getRandomFishable(Random rand, float chance) {
/*  34 */     return getRandomFishable(rand, chance, 0, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public static ItemStack getRandomFishable(Random rand, float chance, int luck, int speed) {
/*  39 */     float junkChance = 0.1F - luck * 0.025F - speed * 0.01F;
/*  40 */     float treasureChance = 0.05F + luck * 0.01F - speed * 0.01F;
/*  41 */     junkChance = MathHelper.clamp_float(junkChance, 0.0F, 1.0F);
/*  42 */     treasureChance = MathHelper.clamp_float(treasureChance, 0.0F, 1.0F);
/*     */     
/*  44 */     if (chance < junkChance)
/*     */     {
/*  46 */       return ((WeightedRandomFishable)WeightedRandom.getRandomItem(rand, junk)).func_150708_a(rand);
/*     */     }
/*     */     
/*  49 */     chance -= junkChance;
/*  50 */     if (chance < treasureChance)
/*     */     {
/*  52 */       return ((WeightedRandomFishable)WeightedRandom.getRandomItem(rand, treasure)).func_150708_a(rand);
/*     */     }
/*     */     
/*  55 */     chance -= treasureChance;
/*     */ 
/*     */     
/*  58 */     return ((WeightedRandomFishable)WeightedRandom.getRandomItem(rand, fish)).func_150708_a(rand);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static FishableCategory getFishableCategory(float chance, int luck, int speed) {
/*  64 */     float junkChance = 0.1F - luck * 0.025F - speed * 0.01F;
/*  65 */     float treasureChance = 0.05F + luck * 0.01F - speed * 0.01F;
/*  66 */     junkChance = MathHelper.clamp_float(junkChance, 0.0F, 1.0F);
/*  67 */     treasureChance = MathHelper.clamp_float(treasureChance, 0.0F, 1.0F);
/*     */     
/*  69 */     if (chance < junkChance)
/*     */     {
/*  71 */       return FishableCategory.JUNK;
/*     */     }
/*     */     
/*  74 */     chance -= junkChance;
/*  75 */     if (chance < treasureChance)
/*     */     {
/*  77 */       return FishableCategory.TREASURE;
/*     */     }
/*     */     
/*  80 */     chance -= treasureChance;
/*     */ 
/*     */     
/*  83 */     return FishableCategory.FISH;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void remove(Iterator<WeightedRandomFishable> iter, Predicate<WeightedRandomFishable> test) {
/*  89 */     while (iter.hasNext()) {
/*  90 */       if (!test.apply(iter.next()))
/*  91 */         iter.remove(); 
/*     */     } 
/*     */   }
/*     */   
/*     */   static {
/*  96 */     fish.addAll(EntityFishHook.field_146036_f);
/*  97 */     junk.addAll(EntityFishHook.field_146039_d);
/*  98 */     treasure.addAll(EntityFishHook.field_146041_e);
/*     */   }
/*     */   
/*     */   public enum FishableCategory
/*     */   {
/* 103 */     JUNK((String)StatList.field_151183_A),
/* 104 */     TREASURE((String)StatList.field_151184_B),
/* 105 */     FISH((String)StatList.fishCaughtStat);
/*     */     
/*     */     public final StatBase stat;
/*     */ 
/*     */     
/*     */     FishableCategory(StatBase stat) {
/* 111 */       this.stat = stat;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\common\FishingHooks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */