/*     */ package org.bukkit.event.player;
/*     */ 
/*     */ import java.net.InetAddress;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.HandlerList;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PlayerLoginEvent
/*     */   extends PlayerEvent
/*     */ {
/*  12 */   private static final HandlerList handlers = new HandlerList();
/*     */   private final InetAddress address;
/*     */   private final String hostname;
/*  15 */   private Result result = Result.ALLOWED;
/*  16 */   private String message = "";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public PlayerLoginEvent(Player player) {
/*  23 */     this(player, "", (InetAddress)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public PlayerLoginEvent(Player player, String hostname) {
/*  31 */     this(player, hostname, (InetAddress)null);
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
/*     */   
/*     */   public PlayerLoginEvent(Player player, String hostname, InetAddress address) {
/*  44 */     super(player);
/*  45 */     this.hostname = hostname;
/*  46 */     this.address = address;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public PlayerLoginEvent(Player player, Result result, String message) {
/*  55 */     this(player, "", null, result, message);
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
/*     */ 
/*     */   
/*     */   public PlayerLoginEvent(Player player, String hostname, InetAddress address, Result result, String message) {
/*  69 */     this(player, hostname, address);
/*  70 */     this.result = result;
/*  71 */     this.message = message;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Result getResult() {
/*  80 */     return this.result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setResult(Result result) {
/*  89 */     this.result = result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getKickMessage() {
/*  99 */     return this.message;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKickMessage(String message) {
/* 108 */     this.message = message;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getHostname() {
/* 118 */     return this.hostname;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void allow() {
/* 125 */     this.result = Result.ALLOWED;
/* 126 */     this.message = "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void disallow(Result result, String message) {
/* 136 */     this.result = result;
/* 137 */     this.message = message;
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
/*     */   public InetAddress getAddress() {
/* 149 */     return this.address;
/*     */   }
/*     */ 
/*     */   
/*     */   public HandlerList getHandlers() {
/* 154 */     return handlers;
/*     */   }
/*     */   
/*     */   public static HandlerList getHandlerList() {
/* 158 */     return handlers;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum Result
/*     */   {
/* 169 */     ALLOWED,
/*     */ 
/*     */ 
/*     */     
/* 173 */     KICK_FULL,
/*     */ 
/*     */ 
/*     */     
/* 177 */     KICK_BANNED,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 182 */     KICK_WHITELIST,
/*     */ 
/*     */ 
/*     */     
/* 186 */     KICK_OTHER;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\event\player\PlayerLoginEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */