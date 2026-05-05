/*     */ package org.bukkit.craftbukkit.v1_7_R4.scoreboard;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.minecraft.server.v1_7_R4.EntityPlayer;
/*     */ import net.minecraft.server.v1_7_R4.IScoreboardCriteria;
/*     */ import net.minecraft.server.v1_7_R4.MinecraftServer;
/*     */ import net.minecraft.server.v1_7_R4.Packet;
/*     */ import net.minecraft.server.v1_7_R4.PacketPlayOutScoreboardObjective;
/*     */ import net.minecraft.server.v1_7_R4.PacketPlayOutScoreboardTeam;
/*     */ import net.minecraft.server.v1_7_R4.Scoreboard;
/*     */ import net.minecraft.server.v1_7_R4.ScoreboardObjective;
/*     */ import net.minecraft.server.v1_7_R4.ScoreboardScore;
/*     */ import net.minecraft.server.v1_7_R4.ScoreboardServer;
/*     */ import net.minecraft.server.v1_7_R4.ScoreboardTeam;
/*     */ import org.apache.commons.lang.Validate;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.util.WeakCollection;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.scoreboard.Scoreboard;
/*     */ import org.bukkit.scoreboard.ScoreboardManager;
/*     */ 
/*     */ public final class CraftScoreboardManager implements ScoreboardManager {
/*     */   private final CraftScoreboard mainScoreboard;
/*     */   private final MinecraftServer server;
/*  31 */   private final Collection<CraftScoreboard> scoreboards = (Collection<CraftScoreboard>)new WeakCollection();
/*  32 */   private final Map<CraftPlayer, CraftScoreboard> playerBoards = new HashMap<CraftPlayer, CraftScoreboard>();
/*     */   
/*     */   public CraftScoreboardManager(MinecraftServer minecraftserver, Scoreboard scoreboardServer) {
/*  35 */     this.mainScoreboard = new CraftScoreboard(scoreboardServer);
/*  36 */     this.server = minecraftserver;
/*  37 */     this.scoreboards.add(this.mainScoreboard);
/*     */   }
/*     */   
/*     */   public CraftScoreboard getMainScoreboard() {
/*  41 */     return this.mainScoreboard;
/*     */   }
/*     */   
/*     */   public CraftScoreboard getNewScoreboard() {
/*  45 */     CraftScoreboard scoreboard = new CraftScoreboard((Scoreboard)new ScoreboardServer(this.server));
/*  46 */     this.scoreboards.add(scoreboard);
/*  47 */     return scoreboard;
/*     */   }
/*     */ 
/*     */   
/*     */   public CraftScoreboard getPlayerBoard(CraftPlayer player) {
/*  52 */     CraftScoreboard board = this.playerBoards.get(player);
/*  53 */     return (board == null) ? getMainScoreboard() : board;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPlayerBoard(CraftPlayer player, Scoreboard bukkitScoreboard) throws IllegalArgumentException {
/*  58 */     Validate.isTrue(bukkitScoreboard instanceof CraftScoreboard, "Cannot set player scoreboard to an unregistered Scoreboard");
/*     */     
/*  60 */     CraftScoreboard scoreboard = (CraftScoreboard)bukkitScoreboard;
/*  61 */     Scoreboard oldboard = getPlayerBoard(player).getHandle();
/*  62 */     Scoreboard newboard = scoreboard.getHandle();
/*  63 */     EntityPlayer entityplayer = player.getHandle();
/*     */     
/*  65 */     if (oldboard == newboard) {
/*     */       return;
/*     */     }
/*     */     
/*  69 */     if (scoreboard == this.mainScoreboard) {
/*  70 */       this.playerBoards.remove(player);
/*     */     } else {
/*  72 */       this.playerBoards.put(player, scoreboard);
/*     */     } 
/*     */ 
/*     */     
/*  76 */     HashSet<ScoreboardObjective> removed = new HashSet<ScoreboardObjective>();
/*  77 */     for (int i = 0; i < 3; i++) {
/*  78 */       ScoreboardObjective scoreboardobjective = oldboard.getObjectiveForSlot(i);
/*  79 */       if (scoreboardobjective != null && !removed.contains(scoreboardobjective)) {
/*  80 */         entityplayer.playerConnection.sendPacket((Packet)new PacketPlayOutScoreboardObjective(scoreboardobjective, 1));
/*  81 */         removed.add(scoreboardobjective);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  86 */     Iterator<?> iterator = oldboard.getTeams().iterator();
/*  87 */     while (iterator.hasNext()) {
/*  88 */       ScoreboardTeam scoreboardteam = (ScoreboardTeam)iterator.next();
/*  89 */       entityplayer.playerConnection.sendPacket((Packet)new PacketPlayOutScoreboardTeam(scoreboardteam, 1));
/*     */     } 
/*     */ 
/*     */     
/*  93 */     this.server.getPlayerList().sendScoreboard((ScoreboardServer)newboard, player.getHandle());
/*     */   }
/*     */ 
/*     */   
/*     */   public void removePlayer(Player player) {
/*  98 */     this.playerBoards.remove(player);
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection<ScoreboardScore> getScoreboardScores(IScoreboardCriteria criteria, String name, Collection<ScoreboardScore> collection) {
/* 103 */     for (CraftScoreboard scoreboard : this.scoreboards) {
/* 104 */       Scoreboard board = scoreboard.board;
/* 105 */       for (ScoreboardObjective objective : board.getObjectivesForCriteria(criteria)) {
/* 106 */         collection.add(board.getPlayerScoreForObjective(name, objective));
/*     */       }
/*     */     } 
/* 109 */     return collection;
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateAllScoresForList(IScoreboardCriteria criteria, String name, List<EntityPlayer> of) {
/* 114 */     for (ScoreboardScore score : getScoreboardScores(criteria, name, new ArrayList<ScoreboardScore>()))
/* 115 */       score.updateForList(of); 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R4\scoreboard\CraftScoreboardManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */