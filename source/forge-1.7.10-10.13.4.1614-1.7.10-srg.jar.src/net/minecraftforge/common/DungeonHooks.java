/*     */ package net.minecraftforge.common;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import net.minecraft.util.WeightedRandom;
/*     */ 
/*     */ 
/*     */ public class DungeonHooks
/*     */ {
/*  10 */   private static ArrayList<DungeonMob> dungeonMobs = new ArrayList<DungeonMob>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float addDungeonMob(String name, int rarity) {
/*  28 */     if (rarity <= 0)
/*     */     {
/*  30 */       throw new IllegalArgumentException("Rarity must be greater then zero");
/*     */     }
/*     */     
/*  33 */     for (DungeonMob mob : dungeonMobs) {
/*     */       
/*  35 */       if (name.equals(mob.type))
/*     */       {
/*  37 */         return (mob.itemWeight += rarity);
/*     */       }
/*     */     } 
/*     */     
/*  41 */     dungeonMobs.add(new DungeonMob(rarity, name));
/*  42 */     return rarity;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int removeDungeonMob(String name) {
/*  53 */     for (DungeonMob mob : dungeonMobs) {
/*     */       
/*  55 */       if (name.equals(mob.type)) {
/*     */         
/*  57 */         dungeonMobs.remove(mob);
/*  58 */         return mob.itemWeight;
/*     */       } 
/*     */     } 
/*  61 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getRandomDungeonMob(Random rand) {
/*  71 */     DungeonMob mob = (DungeonMob)WeightedRandom.getRandomItem(rand, dungeonMobs);
/*  72 */     if (mob == null)
/*     */     {
/*  74 */       return "";
/*     */     }
/*  76 */     return mob.type;
/*     */   }
/*     */   
/*     */   public static class DungeonMob
/*     */     extends WeightedRandom.Item
/*     */   {
/*     */     public String type;
/*     */     
/*     */     public DungeonMob(int weight, String type) {
/*  85 */       super(weight);
/*  86 */       this.type = type;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(Object target) {
/*  92 */       return (target instanceof DungeonMob && this.type.equals(((DungeonMob)target).type));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static {
/*  98 */     addDungeonMob("Skeleton", 100);
/*  99 */     addDungeonMob("Zombie", 200);
/* 100 */     addDungeonMob("Spider", 100);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\common\DungeonHooks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */