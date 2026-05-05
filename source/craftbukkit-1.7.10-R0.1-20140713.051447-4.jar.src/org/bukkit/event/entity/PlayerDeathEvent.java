/*     */ package org.bukkit.event.entity;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.bukkit.entity.Entity;
/*     */ import org.bukkit.entity.LivingEntity;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ 
/*     */ public class PlayerDeathEvent
/*     */   extends EntityDeathEvent
/*     */ {
/*  12 */   private int newExp = 0;
/*  13 */   private String deathMessage = "";
/*  14 */   private int newLevel = 0;
/*  15 */   private int newTotalExp = 0;
/*     */   private boolean keepLevel = false;
/*     */   
/*     */   public PlayerDeathEvent(Player player, List<ItemStack> drops, int droppedExp, String deathMessage) {
/*  19 */     this(player, drops, droppedExp, 0, deathMessage);
/*     */   }
/*     */   
/*     */   public PlayerDeathEvent(Player player, List<ItemStack> drops, int droppedExp, int newExp, String deathMessage) {
/*  23 */     this(player, drops, droppedExp, newExp, 0, 0, deathMessage);
/*     */   }
/*     */   
/*     */   public PlayerDeathEvent(Player player, List<ItemStack> drops, int droppedExp, int newExp, int newTotalExp, int newLevel, String deathMessage) {
/*  27 */     super((LivingEntity)player, drops, droppedExp);
/*  28 */     this.newExp = newExp;
/*  29 */     this.newTotalExp = newTotalExp;
/*  30 */     this.newLevel = newLevel;
/*  31 */     this.deathMessage = deathMessage;
/*     */   }
/*     */ 
/*     */   
/*     */   public Player getEntity() {
/*  36 */     return (Player)this.entity;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDeathMessage(String deathMessage) {
/*  45 */     this.deathMessage = deathMessage;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDeathMessage() {
/*  54 */     return this.deathMessage;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNewExp() {
/*  66 */     return this.newExp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNewExp(int exp) {
/*  78 */     this.newExp = exp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNewLevel() {
/*  87 */     return this.newLevel;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNewLevel(int level) {
/*  96 */     this.newLevel = level;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNewTotalExp() {
/* 105 */     return this.newTotalExp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNewTotalExp(int totalExp) {
/* 114 */     this.newTotalExp = totalExp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getKeepLevel() {
/* 125 */     return this.keepLevel;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKeepLevel(boolean keepLevel) {
/* 136 */     this.keepLevel = keepLevel;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\event\entity\PlayerDeathEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */