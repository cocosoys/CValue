/*     */ package net.minecraftforge.common;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import net.minecraft.stats.Achievement;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AchievementPage
/*     */ {
/*     */   private String name;
/*     */   private LinkedList<Achievement> achievements;
/*     */   
/*     */   public AchievementPage(String name, Achievement... achievements) {
/*  23 */     this.name = name;
/*  24 */     this.achievements = new LinkedList<Achievement>(Arrays.asList(achievements));
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/*  29 */     return this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Achievement> getAchievements() {
/*  34 */     return this.achievements;
/*     */   }
/*     */   
/*  37 */   private static LinkedList<AchievementPage> achievementPages = new LinkedList<AchievementPage>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void registerAchievementPage(AchievementPage page) {
/*  45 */     if (getAchievementPage(page.getName()) != null)
/*     */     {
/*  47 */       throw new RuntimeException("Duplicate achievement page name \"" + page.getName() + "\"!");
/*     */     }
/*  49 */     achievementPages.add(page);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static AchievementPage getAchievementPage(int index) {
/*  59 */     return achievementPages.get(index);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static AchievementPage getAchievementPage(String name) {
/*  69 */     for (AchievementPage page : achievementPages) {
/*     */       
/*  71 */       if (page.getName().equals(name))
/*     */       {
/*  73 */         return page;
/*     */       }
/*     */     } 
/*  76 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Set<AchievementPage> getAchievementPages() {
/*  85 */     return new HashSet<AchievementPage>(achievementPages);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isAchievementInPages(Achievement achievement) {
/*  94 */     for (AchievementPage page : achievementPages) {
/*     */       
/*  96 */       if (page.getAchievements().contains(achievement))
/*     */       {
/*  98 */         return true;
/*     */       }
/*     */     } 
/* 101 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getTitle(int index) {
/* 106 */     return (index == -1) ? "Minecraft" : getAchievementPage(index).getName();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\common\AchievementPage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */