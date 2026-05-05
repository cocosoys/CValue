/*     */ package org.bukkit.craftbukkit.v1_7_R4.scoreboard;
/*     */ 
/*     */ import com.google.common.collect.ImmutableSet;
/*     */ import java.util.Set;
/*     */ import net.minecraft.server.v1_7_R4.ScoreboardTeam;
/*     */ import org.apache.commons.lang.Validate;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.OfflinePlayer;
/*     */ import org.bukkit.scoreboard.Scoreboard;
/*     */ import org.bukkit.scoreboard.Team;
/*     */ 
/*     */ final class CraftTeam
/*     */   extends CraftScoreboardComponent
/*     */   implements Team {
/*     */   private final ScoreboardTeam team;
/*     */   
/*     */   CraftTeam(CraftScoreboard scoreboard, ScoreboardTeam team) {
/*  18 */     super(scoreboard);
/*  19 */     this.team = team;
/*  20 */     scoreboard.teams.put(team.getName(), this);
/*     */   }
/*     */   
/*     */   public String getName() throws IllegalStateException {
/*  24 */     CraftScoreboard scoreboard = checkState();
/*     */     
/*  26 */     return this.team.getName();
/*     */   }
/*     */   
/*     */   public String getDisplayName() throws IllegalStateException {
/*  30 */     CraftScoreboard scoreboard = checkState();
/*     */     
/*  32 */     return this.team.getDisplayName();
/*     */   }
/*     */   
/*     */   public void setDisplayName(String displayName) throws IllegalStateException {
/*  36 */     Validate.notNull(displayName, "Display name cannot be null");
/*  37 */     Validate.isTrue((displayName.length() <= 32), "Display name '" + displayName + "' is longer than the limit of 32 characters");
/*  38 */     CraftScoreboard scoreboard = checkState();
/*     */     
/*  40 */     this.team.setDisplayName(displayName);
/*     */   }
/*     */   
/*     */   public String getPrefix() throws IllegalStateException {
/*  44 */     CraftScoreboard scoreboard = checkState();
/*     */     
/*  46 */     return this.team.getPrefix();
/*     */   }
/*     */   
/*     */   public void setPrefix(String prefix) throws IllegalStateException, IllegalArgumentException {
/*  50 */     Validate.notNull(prefix, "Prefix cannot be null");
/*  51 */     Validate.isTrue((prefix.length() <= 32), "Prefix '" + prefix + "' is longer than the limit of 32 characters");
/*  52 */     CraftScoreboard scoreboard = checkState();
/*     */     
/*  54 */     this.team.setPrefix(prefix);
/*     */   }
/*     */   
/*     */   public String getSuffix() throws IllegalStateException {
/*  58 */     CraftScoreboard scoreboard = checkState();
/*     */     
/*  60 */     return this.team.getSuffix();
/*     */   }
/*     */   
/*     */   public void setSuffix(String suffix) throws IllegalStateException, IllegalArgumentException {
/*  64 */     Validate.notNull(suffix, "Suffix cannot be null");
/*  65 */     Validate.isTrue((suffix.length() <= 32), "Suffix '" + suffix + "' is longer than the limit of 32 characters");
/*  66 */     CraftScoreboard scoreboard = checkState();
/*     */     
/*  68 */     this.team.setSuffix(suffix);
/*     */   }
/*     */   
/*     */   public boolean allowFriendlyFire() throws IllegalStateException {
/*  72 */     CraftScoreboard scoreboard = checkState();
/*     */     
/*  74 */     return this.team.allowFriendlyFire();
/*     */   }
/*     */   
/*     */   public void setAllowFriendlyFire(boolean enabled) throws IllegalStateException {
/*  78 */     CraftScoreboard scoreboard = checkState();
/*     */     
/*  80 */     this.team.setAllowFriendlyFire(enabled);
/*     */   }
/*     */   
/*     */   public boolean canSeeFriendlyInvisibles() throws IllegalStateException {
/*  84 */     CraftScoreboard scoreboard = checkState();
/*     */     
/*  86 */     return this.team.canSeeFriendlyInvisibles();
/*     */   }
/*     */   
/*     */   public void setCanSeeFriendlyInvisibles(boolean enabled) throws IllegalStateException {
/*  90 */     CraftScoreboard scoreboard = checkState();
/*     */     
/*  92 */     this.team.setCanSeeFriendlyInvisibles(enabled);
/*     */   }
/*     */   
/*     */   public Set<OfflinePlayer> getPlayers() throws IllegalStateException {
/*  96 */     CraftScoreboard scoreboard = checkState();
/*     */     
/*  98 */     ImmutableSet.Builder<OfflinePlayer> players = ImmutableSet.builder();
/*  99 */     for (Object o : this.team.getPlayerNameSet()) {
/* 100 */       players.add(Bukkit.getOfflinePlayer(o.toString()));
/*     */     }
/* 102 */     return (Set<OfflinePlayer>)players.build();
/*     */   }
/*     */   
/*     */   public int getSize() throws IllegalStateException {
/* 106 */     CraftScoreboard scoreboard = checkState();
/*     */     
/* 108 */     return this.team.getPlayerNameSet().size();
/*     */   }
/*     */   
/*     */   public void addPlayer(OfflinePlayer player) throws IllegalStateException, IllegalArgumentException {
/* 112 */     Validate.notNull(player, "OfflinePlayer cannot be null");
/* 113 */     CraftScoreboard scoreboard = checkState();
/*     */     
/* 115 */     scoreboard.board.addPlayerToTeam(player.getName(), this.team.getName());
/*     */   }
/*     */   
/*     */   public boolean removePlayer(OfflinePlayer player) throws IllegalStateException, IllegalArgumentException {
/* 119 */     Validate.notNull(player, "OfflinePlayer cannot be null");
/* 120 */     CraftScoreboard scoreboard = checkState();
/*     */     
/* 122 */     if (!this.team.getPlayerNameSet().contains(player.getName())) {
/* 123 */       return false;
/*     */     }
/*     */     
/* 126 */     scoreboard.board.removePlayerFromTeam(player.getName(), this.team);
/* 127 */     return true;
/*     */   }
/*     */   
/*     */   public boolean hasPlayer(OfflinePlayer player) throws IllegalArgumentException, IllegalStateException {
/* 131 */     Validate.notNull(player, "OfflinePlayer cannot be null");
/* 132 */     CraftScoreboard scoreboard = checkState();
/*     */     
/* 134 */     return this.team.getPlayerNameSet().contains(player.getName());
/*     */   }
/*     */ 
/*     */   
/*     */   public void unregister() throws IllegalStateException {
/* 139 */     CraftScoreboard scoreboard = checkState();
/*     */     
/* 141 */     scoreboard.board.removeTeam(this.team);
/* 142 */     scoreboard.teams.remove(this.team.getName());
/* 143 */     setUnregistered();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R4\scoreboard\CraftTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */