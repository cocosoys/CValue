/*     */ package net.minecraft.scoreboard;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.server.S3BPacketScoreboardObjective;
/*     */ import net.minecraft.network.play.server.S3CPacketUpdateScore;
/*     */ import net.minecraft.network.play.server.S3DPacketDisplayScoreboard;
/*     */ import net.minecraft.network.play.server.S3EPacketTeams;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ 
/*     */ public class ServerScoreboard extends Scoreboard {
/*  15 */   private final Set field_96553_b = new HashSet(); private final MinecraftServer field_96555_a; private ScoreboardSaveData field_96554_c;
/*     */   private static final String __OBFID = "CL_00001424";
/*     */   
/*     */   public ServerScoreboard(MinecraftServer p_i1501_1_) {
/*  19 */     this.field_96555_a = p_i1501_1_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_96536_a(Score p_96536_1_) {
/*  28 */     super.func_96536_a(p_96536_1_);
/*     */     
/*  30 */     if (this.field_96553_b.contains(p_96536_1_.func_96645_d())) {
/*  31 */       this.field_96555_a.func_71203_ab().func_148540_a((Packet)new S3CPacketUpdateScore(p_96536_1_, 0));
/*     */     }
/*     */     
/*  34 */     func_96551_b();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_96516_a(String p_96516_1_) {
/*  39 */     super.func_96516_a(p_96516_1_);
/*  40 */     this.field_96555_a.func_71203_ab().func_148540_a((Packet)new S3CPacketUpdateScore(p_96516_1_));
/*  41 */     func_96551_b();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_96530_a(int p_96530_1_, ScoreObjective p_96530_2_) {
/*  46 */     ScoreObjective scoreObjective = func_96539_a(p_96530_1_);
/*     */     
/*  48 */     super.func_96530_a(p_96530_1_, p_96530_2_);
/*     */     
/*  50 */     if (scoreObjective != p_96530_2_ && scoreObjective != null) {
/*  51 */       if (func_96552_h(scoreObjective) > 0) {
/*  52 */         this.field_96555_a.func_71203_ab().func_148540_a((Packet)new S3DPacketDisplayScoreboard(p_96530_1_, p_96530_2_));
/*     */       } else {
/*  54 */         func_96546_g(scoreObjective);
/*     */       } 
/*     */     }
/*     */     
/*  58 */     if (p_96530_2_ != null) {
/*  59 */       if (this.field_96553_b.contains(p_96530_2_)) {
/*  60 */         this.field_96555_a.func_71203_ab().func_148540_a((Packet)new S3DPacketDisplayScoreboard(p_96530_1_, p_96530_2_));
/*     */       } else {
/*  62 */         func_96549_e(p_96530_2_);
/*     */       } 
/*     */     }
/*     */     
/*  66 */     func_96551_b();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_151392_a(String p_151392_1_, String p_151392_2_) {
/*  71 */     if (super.func_151392_a(p_151392_1_, p_151392_2_)) {
/*  72 */       ScorePlayerTeam scorePlayerTeam = func_96508_e(p_151392_2_);
/*  73 */       this.field_96555_a.func_71203_ab().func_148540_a((Packet)new S3EPacketTeams(scorePlayerTeam, Arrays.asList(new String[] { p_151392_1_ }, ), 3));
/*  74 */       func_96551_b();
/*     */       
/*  76 */       return true;
/*     */     } 
/*     */     
/*  79 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_96512_b(String p_96512_1_, ScorePlayerTeam p_96512_2_) {
/*  84 */     super.func_96512_b(p_96512_1_, p_96512_2_);
/*     */     
/*  86 */     this.field_96555_a.func_71203_ab().func_148540_a((Packet)new S3EPacketTeams(p_96512_2_, Arrays.asList(new String[] { p_96512_1_ }, ), 4));
/*     */     
/*  88 */     func_96551_b();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_96522_a(ScoreObjective p_96522_1_) {
/*  93 */     super.func_96522_a(p_96522_1_);
/*  94 */     func_96551_b();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_96532_b(ScoreObjective p_96532_1_) {
/*  99 */     super.func_96532_b(p_96532_1_);
/*     */     
/* 101 */     if (this.field_96553_b.contains(p_96532_1_)) {
/* 102 */       this.field_96555_a.func_71203_ab().func_148540_a((Packet)new S3BPacketScoreboardObjective(p_96532_1_, 2));
/*     */     }
/*     */     
/* 105 */     func_96551_b();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_96533_c(ScoreObjective p_96533_1_) {
/* 110 */     super.func_96533_c(p_96533_1_);
/*     */     
/* 112 */     if (this.field_96553_b.contains(p_96533_1_)) {
/* 113 */       func_96546_g(p_96533_1_);
/*     */     }
/*     */     
/* 116 */     func_96551_b();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_96523_a(ScorePlayerTeam p_96523_1_) {
/* 121 */     super.func_96523_a(p_96523_1_);
/*     */     
/* 123 */     this.field_96555_a.func_71203_ab().func_148540_a((Packet)new S3EPacketTeams(p_96523_1_, 0));
/*     */     
/* 125 */     func_96551_b();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_96538_b(ScorePlayerTeam p_96538_1_) {
/* 130 */     super.func_96538_b(p_96538_1_);
/*     */     
/* 132 */     this.field_96555_a.func_71203_ab().func_148540_a((Packet)new S3EPacketTeams(p_96538_1_, 2));
/*     */     
/* 134 */     func_96551_b();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_96513_c(ScorePlayerTeam p_96513_1_) {
/* 139 */     super.func_96513_c(p_96513_1_);
/*     */     
/* 141 */     this.field_96555_a.func_71203_ab().func_148540_a((Packet)new S3EPacketTeams(p_96513_1_, 1));
/*     */     
/* 143 */     func_96551_b();
/*     */   }
/*     */   
/*     */   public void func_96547_a(ScoreboardSaveData p_96547_1_) {
/* 147 */     this.field_96554_c = p_96547_1_;
/*     */   }
/*     */   
/*     */   protected void func_96551_b() {
/* 151 */     if (this.field_96554_c != null) {
/* 152 */       this.field_96554_c.func_76185_a();
/*     */     }
/*     */   }
/*     */   
/*     */   public List func_96550_d(ScoreObjective p_96550_1_) {
/* 157 */     ArrayList<S3BPacketScoreboardObjective> arrayList = new ArrayList();
/* 158 */     arrayList.add(new S3BPacketScoreboardObjective(p_96550_1_, 0));
/*     */     
/* 160 */     for (byte b = 0; b < 3; b++) {
/* 161 */       if (func_96539_a(b) == p_96550_1_) arrayList.add(new S3DPacketDisplayScoreboard(b, p_96550_1_));
/*     */     
/*     */     } 
/* 164 */     for (Score score : func_96534_i(p_96550_1_)) {
/* 165 */       arrayList.add(new S3CPacketUpdateScore(score, 0));
/*     */     }
/*     */     
/* 168 */     return arrayList;
/*     */   }
/*     */   
/*     */   public void func_96549_e(ScoreObjective p_96549_1_) {
/* 172 */     List list = func_96550_d(p_96549_1_);
/*     */     
/* 174 */     for (EntityPlayerMP entityPlayerMP : (this.field_96555_a.func_71203_ab()).field_72404_b) {
/* 175 */       for (Packet packet : list) {
/* 176 */         entityPlayerMP.field_71135_a.func_147359_a(packet);
/*     */       }
/*     */     } 
/*     */     
/* 180 */     this.field_96553_b.add(p_96549_1_);
/*     */   }
/*     */   
/*     */   public List func_96548_f(ScoreObjective p_96548_1_) {
/* 184 */     ArrayList<S3BPacketScoreboardObjective> arrayList = new ArrayList();
/* 185 */     arrayList.add(new S3BPacketScoreboardObjective(p_96548_1_, 1));
/*     */     
/* 187 */     for (byte b = 0; b < 3; b++) {
/* 188 */       if (func_96539_a(b) == p_96548_1_) arrayList.add(new S3DPacketDisplayScoreboard(b, p_96548_1_));
/*     */     
/*     */     } 
/* 191 */     return arrayList;
/*     */   }
/*     */   
/*     */   public void func_96546_g(ScoreObjective p_96546_1_) {
/* 195 */     List list = func_96548_f(p_96546_1_);
/*     */     
/* 197 */     for (EntityPlayerMP entityPlayerMP : (this.field_96555_a.func_71203_ab()).field_72404_b) {
/* 198 */       for (Packet packet : list) {
/* 199 */         entityPlayerMP.field_71135_a.func_147359_a(packet);
/*     */       }
/*     */     } 
/*     */     
/* 203 */     this.field_96553_b.remove(p_96546_1_);
/*     */   }
/*     */   
/*     */   public int func_96552_h(ScoreObjective p_96552_1_) {
/* 207 */     byte b1 = 0;
/*     */     
/* 209 */     for (byte b2 = 0; b2 < 3; b2++) {
/* 210 */       if (func_96539_a(b2) == p_96552_1_) b1++;
/*     */     
/*     */     } 
/* 213 */     return b1;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\scoreboard\ServerScoreboard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */