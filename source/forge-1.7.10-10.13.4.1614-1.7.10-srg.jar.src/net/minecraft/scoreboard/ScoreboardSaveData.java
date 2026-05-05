/*     */ package net.minecraft.scoreboard;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.nbt.NBTTagString;
/*     */ import net.minecraft.world.WorldSavedData;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ public class ScoreboardSaveData extends WorldSavedData {
/*  13 */   private static final Logger field_151481_a = LogManager.getLogger();
/*     */   
/*     */   private Scoreboard field_96507_a;
/*     */   private NBTTagCompound field_96506_b;
/*     */   private static final String __OBFID = "CL_00000620";
/*     */   
/*     */   public ScoreboardSaveData() {
/*  20 */     this("scoreboard");
/*     */   }
/*     */   
/*     */   public ScoreboardSaveData(String p_i2310_1_) {
/*  24 */     super(p_i2310_1_);
/*     */   }
/*     */   
/*     */   public void func_96499_a(Scoreboard p_96499_1_) {
/*  28 */     this.field_96507_a = p_96499_1_;
/*     */     
/*  30 */     if (this.field_96506_b != null) {
/*  31 */       func_76184_a(this.field_96506_b);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_76184_a(NBTTagCompound p_76184_1_) {
/*  37 */     if (this.field_96507_a == null) {
/*  38 */       this.field_96506_b = p_76184_1_;
/*     */       
/*     */       return;
/*     */     } 
/*  42 */     func_96501_b(p_76184_1_.func_150295_c("Objectives", 10));
/*  43 */     func_96500_c(p_76184_1_.func_150295_c("PlayerScores", 10));
/*     */     
/*  45 */     if (p_76184_1_.func_150297_b("DisplaySlots", 10)) {
/*  46 */       func_96504_c(p_76184_1_.func_74775_l("DisplaySlots"));
/*     */     }
/*     */     
/*  49 */     if (p_76184_1_.func_150297_b("Teams", 9)) {
/*  50 */       func_96498_a(p_76184_1_.func_150295_c("Teams", 10));
/*     */     }
/*     */   }
/*     */   
/*     */   protected void func_96498_a(NBTTagList p_96498_1_) {
/*  55 */     for (byte b = 0; b < p_96498_1_.func_74745_c(); b++) {
/*  56 */       NBTTagCompound nBTTagCompound = p_96498_1_.func_150305_b(b);
/*     */       
/*  58 */       ScorePlayerTeam scorePlayerTeam = this.field_96507_a.func_96527_f(nBTTagCompound.func_74779_i("Name"));
/*  59 */       scorePlayerTeam.func_96664_a(nBTTagCompound.func_74779_i("DisplayName"));
/*  60 */       scorePlayerTeam.func_96666_b(nBTTagCompound.func_74779_i("Prefix"));
/*  61 */       scorePlayerTeam.func_96662_c(nBTTagCompound.func_74779_i("Suffix"));
/*  62 */       if (nBTTagCompound.func_150297_b("AllowFriendlyFire", 99)) scorePlayerTeam.func_96660_a(nBTTagCompound.func_74767_n("AllowFriendlyFire")); 
/*  63 */       if (nBTTagCompound.func_150297_b("SeeFriendlyInvisibles", 99)) scorePlayerTeam.func_98300_b(nBTTagCompound.func_74767_n("SeeFriendlyInvisibles"));
/*     */       
/*  65 */       func_96502_a(scorePlayerTeam, nBTTagCompound.func_150295_c("Players", 8));
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_96502_a(ScorePlayerTeam p_96502_1_, NBTTagList p_96502_2_) {
/*  70 */     for (byte b = 0; b < p_96502_2_.func_74745_c(); b++) {
/*  71 */       this.field_96507_a.func_151392_a(p_96502_2_.func_150307_f(b), p_96502_1_.func_96661_b());
/*     */     }
/*     */   }
/*     */   
/*     */   protected void func_96504_c(NBTTagCompound p_96504_1_) {
/*  76 */     for (byte b = 0; b < 3; b++) {
/*  77 */       if (p_96504_1_.func_150297_b("slot_" + b, 8)) {
/*  78 */         String str = p_96504_1_.func_74779_i("slot_" + b);
/*  79 */         ScoreObjective scoreObjective = this.field_96507_a.func_96518_b(str);
/*  80 */         this.field_96507_a.func_96530_a(b, scoreObjective);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_96501_b(NBTTagList p_96501_1_) {
/*  86 */     for (byte b = 0; b < p_96501_1_.func_74745_c(); b++) {
/*  87 */       NBTTagCompound nBTTagCompound = p_96501_1_.func_150305_b(b);
/*     */       
/*  89 */       IScoreObjectiveCriteria iScoreObjectiveCriteria = (IScoreObjectiveCriteria)IScoreObjectiveCriteria.field_96643_a.get(nBTTagCompound.func_74779_i("CriteriaName"));
/*  90 */       ScoreObjective scoreObjective = this.field_96507_a.func_96535_a(nBTTagCompound.func_74779_i("Name"), iScoreObjectiveCriteria);
/*  91 */       scoreObjective.func_96681_a(nBTTagCompound.func_74779_i("DisplayName"));
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_96500_c(NBTTagList p_96500_1_) {
/*  96 */     for (byte b = 0; b < p_96500_1_.func_74745_c(); b++) {
/*  97 */       NBTTagCompound nBTTagCompound = p_96500_1_.func_150305_b(b);
/*     */       
/*  99 */       ScoreObjective scoreObjective = this.field_96507_a.func_96518_b(nBTTagCompound.func_74779_i("Objective"));
/* 100 */       Score score = this.field_96507_a.func_96529_a(nBTTagCompound.func_74779_i("Name"), scoreObjective);
/* 101 */       score.func_96647_c(nBTTagCompound.func_74762_e("Score"));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_76187_b(NBTTagCompound p_76187_1_) {
/* 107 */     if (this.field_96507_a == null) {
/* 108 */       field_151481_a.warn("Tried to save scoreboard without having a scoreboard...");
/*     */       
/*     */       return;
/*     */     } 
/* 112 */     p_76187_1_.func_74782_a("Objectives", (NBTBase)func_96505_b());
/* 113 */     p_76187_1_.func_74782_a("PlayerScores", (NBTBase)func_96503_e());
/* 114 */     p_76187_1_.func_74782_a("Teams", (NBTBase)func_96496_a());
/*     */     
/* 116 */     func_96497_d(p_76187_1_);
/*     */   }
/*     */   
/*     */   protected NBTTagList func_96496_a() {
/* 120 */     NBTTagList nBTTagList = new NBTTagList();
/* 121 */     Collection collection = this.field_96507_a.func_96525_g();
/*     */     
/* 123 */     for (ScorePlayerTeam scorePlayerTeam : collection) {
/* 124 */       NBTTagCompound nBTTagCompound = new NBTTagCompound();
/*     */       
/* 126 */       nBTTagCompound.func_74778_a("Name", scorePlayerTeam.func_96661_b());
/* 127 */       nBTTagCompound.func_74778_a("DisplayName", scorePlayerTeam.func_96669_c());
/* 128 */       nBTTagCompound.func_74778_a("Prefix", scorePlayerTeam.func_96668_e());
/* 129 */       nBTTagCompound.func_74778_a("Suffix", scorePlayerTeam.func_96663_f());
/* 130 */       nBTTagCompound.func_74757_a("AllowFriendlyFire", scorePlayerTeam.func_96665_g());
/* 131 */       nBTTagCompound.func_74757_a("SeeFriendlyInvisibles", scorePlayerTeam.func_98297_h());
/*     */       
/* 133 */       NBTTagList nBTTagList1 = new NBTTagList();
/*     */       
/* 135 */       for (String str : scorePlayerTeam.func_96670_d()) {
/* 136 */         nBTTagList1.func_74742_a((NBTBase)new NBTTagString(str));
/*     */       }
/*     */       
/* 139 */       nBTTagCompound.func_74782_a("Players", (NBTBase)nBTTagList1);
/*     */       
/* 141 */       nBTTagList.func_74742_a((NBTBase)nBTTagCompound);
/*     */     } 
/*     */     
/* 144 */     return nBTTagList;
/*     */   }
/*     */   
/*     */   protected void func_96497_d(NBTTagCompound p_96497_1_) {
/* 148 */     NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 149 */     boolean bool = false;
/*     */     
/* 151 */     for (byte b = 0; b < 3; b++) {
/* 152 */       ScoreObjective scoreObjective = this.field_96507_a.func_96539_a(b);
/*     */       
/* 154 */       if (scoreObjective != null) {
/* 155 */         nBTTagCompound.func_74778_a("slot_" + b, scoreObjective.func_96679_b());
/* 156 */         bool = true;
/*     */       } 
/*     */     } 
/*     */     
/* 160 */     if (bool) p_96497_1_.func_74782_a("DisplaySlots", (NBTBase)nBTTagCompound); 
/*     */   }
/*     */   
/*     */   protected NBTTagList func_96505_b() {
/* 164 */     NBTTagList nBTTagList = new NBTTagList();
/* 165 */     Collection collection = this.field_96507_a.func_96514_c();
/*     */     
/* 167 */     for (ScoreObjective scoreObjective : collection) {
/* 168 */       NBTTagCompound nBTTagCompound = new NBTTagCompound();
/*     */       
/* 170 */       nBTTagCompound.func_74778_a("Name", scoreObjective.func_96679_b());
/* 171 */       nBTTagCompound.func_74778_a("CriteriaName", scoreObjective.func_96680_c().func_96636_a());
/* 172 */       nBTTagCompound.func_74778_a("DisplayName", scoreObjective.func_96678_d());
/*     */       
/* 174 */       nBTTagList.func_74742_a((NBTBase)nBTTagCompound);
/*     */     } 
/*     */     
/* 177 */     return nBTTagList;
/*     */   }
/*     */   
/*     */   protected NBTTagList func_96503_e() {
/* 181 */     NBTTagList nBTTagList = new NBTTagList();
/* 182 */     Collection collection = this.field_96507_a.func_96528_e();
/*     */     
/* 184 */     for (Score score : collection) {
/* 185 */       NBTTagCompound nBTTagCompound = new NBTTagCompound();
/*     */       
/* 187 */       nBTTagCompound.func_74778_a("Name", score.func_96653_e());
/* 188 */       nBTTagCompound.func_74778_a("Objective", score.func_96645_d().func_96679_b());
/* 189 */       nBTTagCompound.func_74768_a("Score", score.func_96652_c());
/*     */       
/* 191 */       nBTTagList.func_74742_a((NBTBase)nBTTagCompound);
/*     */     } 
/*     */     
/* 194 */     return nBTTagList;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\scoreboard\ScoreboardSaveData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */