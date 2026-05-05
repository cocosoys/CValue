/*     */ package net.minecraft.scoreboard;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Scoreboard
/*     */ {
/*  15 */   private final Map field_96545_a = new HashMap<Object, Object>();
/*  16 */   private final Map field_96543_b = new HashMap<Object, Object>();
/*  17 */   private final Map field_96544_c = new HashMap<Object, Object>();
/*  18 */   private final ScoreObjective[] field_96541_d = new ScoreObjective[3];
/*  19 */   private final Map field_96542_e = new HashMap<Object, Object>();
/*  20 */   private final Map field_96540_f = new HashMap<Object, Object>();
/*     */   
/*     */   public ScoreObjective func_96518_b(String p_96518_1_) {
/*  23 */     return (ScoreObjective)this.field_96545_a.get(p_96518_1_);
/*     */   }
/*     */   private static final String __OBFID = "CL_00000619";
/*     */   public ScoreObjective func_96535_a(String p_96535_1_, IScoreObjectiveCriteria p_96535_2_) {
/*  27 */     ScoreObjective scoreObjective = func_96518_b(p_96535_1_);
/*  28 */     if (scoreObjective != null) throw new IllegalArgumentException("An objective with the name '" + p_96535_1_ + "' already exists!");
/*     */     
/*  30 */     scoreObjective = new ScoreObjective(this, p_96535_1_, p_96535_2_);
/*     */     
/*  32 */     List<ScoreObjective> list = (List)this.field_96543_b.get(p_96535_2_);
/*     */     
/*  34 */     if (list == null) {
/*  35 */       list = new ArrayList();
/*  36 */       this.field_96543_b.put(p_96535_2_, list);
/*     */     } 
/*     */     
/*  39 */     list.add(scoreObjective);
/*  40 */     this.field_96545_a.put(p_96535_1_, scoreObjective);
/*  41 */     func_96522_a(scoreObjective);
/*     */     
/*  43 */     return scoreObjective;
/*     */   }
/*     */   
/*     */   public Collection func_96520_a(IScoreObjectiveCriteria p_96520_1_) {
/*  47 */     Collection<?> collection = (Collection)this.field_96543_b.get(p_96520_1_);
/*     */     
/*  49 */     return (collection == null) ? new ArrayList() : new ArrayList(collection);
/*     */   }
/*     */   
/*     */   public Score func_96529_a(String p_96529_1_, ScoreObjective p_96529_2_) {
/*  53 */     Map<Object, Object> map = (Map)this.field_96544_c.get(p_96529_1_);
/*     */     
/*  55 */     if (map == null) {
/*  56 */       map = new HashMap<Object, Object>();
/*  57 */       this.field_96544_c.put(p_96529_1_, map);
/*     */     } 
/*     */     
/*  60 */     Score score = (Score)map.get(p_96529_2_);
/*     */     
/*  62 */     if (score == null) {
/*  63 */       score = new Score(this, p_96529_2_, p_96529_1_);
/*  64 */       map.put(p_96529_2_, score);
/*     */     } 
/*     */     
/*  67 */     return score;
/*     */   }
/*     */   
/*     */   public Collection func_96534_i(ScoreObjective p_96534_1_) {
/*  71 */     ArrayList<Score> arrayList = new ArrayList();
/*     */     
/*  73 */     for (Map map : this.field_96544_c.values()) {
/*  74 */       Score score = (Score)map.get(p_96534_1_);
/*  75 */       if (score != null) arrayList.add(score);
/*     */     
/*     */     } 
/*  78 */     Collections.sort(arrayList, Score.field_96658_a);
/*     */     
/*  80 */     return arrayList;
/*     */   }
/*     */   
/*     */   public Collection func_96514_c() {
/*  84 */     return this.field_96545_a.values();
/*     */   }
/*     */   
/*     */   public Collection func_96526_d() {
/*  88 */     return this.field_96544_c.keySet();
/*     */   }
/*     */   
/*     */   public void func_96515_c(String p_96515_1_) {
/*  92 */     Map map = (Map)this.field_96544_c.remove(p_96515_1_);
/*     */     
/*  94 */     if (map != null) {
/*  95 */       func_96516_a(p_96515_1_);
/*     */     }
/*     */   }
/*     */   
/*     */   public Collection func_96528_e() {
/* 100 */     Collection collection = this.field_96544_c.values();
/* 101 */     ArrayList arrayList = new ArrayList();
/*     */     
/* 103 */     for (Map map : collection) {
/* 104 */       arrayList.addAll(map.values());
/*     */     }
/*     */     
/* 107 */     return arrayList;
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
/*     */ 
/*     */   
/*     */   public Map func_96510_d(String p_96510_1_) {
/* 123 */     Map<Object, Object> map = (Map)this.field_96544_c.get(p_96510_1_);
/* 124 */     if (map == null) map = new HashMap<Object, Object>(); 
/* 125 */     return map;
/*     */   }
/*     */   
/*     */   public void func_96519_k(ScoreObjective p_96519_1_) {
/* 129 */     this.field_96545_a.remove(p_96519_1_.func_96679_b());
/*     */     
/* 131 */     for (byte b = 0; b < 3; b++) {
/* 132 */       if (func_96539_a(b) == p_96519_1_) func_96530_a(b, null);
/*     */     
/*     */     } 
/* 135 */     List list = (List)this.field_96543_b.get(p_96519_1_.func_96680_c());
/* 136 */     if (list != null) list.remove(p_96519_1_);
/*     */     
/* 138 */     for (Map map : this.field_96544_c.values()) {
/* 139 */       map.remove(p_96519_1_);
/*     */     }
/*     */     
/* 142 */     func_96533_c(p_96519_1_);
/*     */   }
/*     */   
/*     */   public void func_96530_a(int p_96530_1_, ScoreObjective p_96530_2_) {
/* 146 */     this.field_96541_d[p_96530_1_] = p_96530_2_;
/*     */   }
/*     */   
/*     */   public ScoreObjective func_96539_a(int p_96539_1_) {
/* 150 */     return this.field_96541_d[p_96539_1_];
/*     */   }
/*     */   
/*     */   public ScorePlayerTeam func_96508_e(String p_96508_1_) {
/* 154 */     return (ScorePlayerTeam)this.field_96542_e.get(p_96508_1_);
/*     */   }
/*     */   
/*     */   public ScorePlayerTeam func_96527_f(String p_96527_1_) {
/* 158 */     ScorePlayerTeam scorePlayerTeam = func_96508_e(p_96527_1_);
/* 159 */     if (scorePlayerTeam != null) throw new IllegalArgumentException("A team with the name '" + p_96527_1_ + "' already exists!");
/*     */     
/* 161 */     scorePlayerTeam = new ScorePlayerTeam(this, p_96527_1_);
/* 162 */     this.field_96542_e.put(p_96527_1_, scorePlayerTeam);
/* 163 */     func_96523_a(scorePlayerTeam);
/*     */     
/* 165 */     return scorePlayerTeam;
/*     */   }
/*     */   
/*     */   public void func_96511_d(ScorePlayerTeam p_96511_1_) {
/* 169 */     this.field_96542_e.remove(p_96511_1_.func_96661_b());
/*     */ 
/*     */ 
/*     */     
/* 173 */     for (String str : p_96511_1_.func_96670_d()) {
/* 174 */       this.field_96540_f.remove(str);
/*     */     }
/*     */     
/* 177 */     func_96513_c(p_96511_1_);
/*     */   }
/*     */   
/*     */   public boolean func_151392_a(String p_151392_1_, String p_151392_2_) {
/* 181 */     if (!this.field_96542_e.containsKey(p_151392_2_)) return false; 
/* 182 */     ScorePlayerTeam scorePlayerTeam = func_96508_e(p_151392_2_);
/*     */     
/* 184 */     if (func_96509_i(p_151392_1_) != null) {
/* 185 */       func_96524_g(p_151392_1_);
/*     */     }
/*     */     
/* 188 */     this.field_96540_f.put(p_151392_1_, scorePlayerTeam);
/* 189 */     scorePlayerTeam.func_96670_d().add(p_151392_1_);
/* 190 */     return true;
/*     */   }
/*     */   
/*     */   public boolean func_96524_g(String p_96524_1_) {
/* 194 */     ScorePlayerTeam scorePlayerTeam = func_96509_i(p_96524_1_);
/*     */     
/* 196 */     if (scorePlayerTeam != null) {
/* 197 */       func_96512_b(p_96524_1_, scorePlayerTeam);
/* 198 */       return true;
/*     */     } 
/* 200 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_96512_b(String p_96512_1_, ScorePlayerTeam p_96512_2_) {
/* 205 */     if (func_96509_i(p_96512_1_) != p_96512_2_) {
/* 206 */       throw new IllegalStateException("Player is either on another team or not on any team. Cannot remove from team '" + p_96512_2_.func_96661_b() + "'.");
/*     */     }
/*     */     
/* 209 */     this.field_96540_f.remove(p_96512_1_);
/* 210 */     p_96512_2_.func_96670_d().remove(p_96512_1_);
/*     */   }
/*     */   
/*     */   public Collection func_96531_f() {
/* 214 */     return this.field_96542_e.keySet();
/*     */   }
/*     */   
/*     */   public Collection func_96525_g() {
/* 218 */     return this.field_96542_e.values();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ScorePlayerTeam func_96509_i(String p_96509_1_) {
/* 226 */     return (ScorePlayerTeam)this.field_96540_f.get(p_96509_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_96522_a(ScoreObjective p_96522_1_) {}
/*     */ 
/*     */   
/*     */   public void func_96532_b(ScoreObjective p_96532_1_) {}
/*     */ 
/*     */   
/*     */   public void func_96533_c(ScoreObjective p_96533_1_) {}
/*     */ 
/*     */   
/*     */   public void func_96536_a(Score p_96536_1_) {}
/*     */ 
/*     */   
/*     */   public void func_96516_a(String p_96516_1_) {}
/*     */ 
/*     */   
/*     */   public void func_96523_a(ScorePlayerTeam p_96523_1_) {}
/*     */ 
/*     */   
/*     */   public void func_96538_b(ScorePlayerTeam p_96538_1_) {}
/*     */ 
/*     */   
/*     */   public void func_96513_c(ScorePlayerTeam p_96513_1_) {}
/*     */   
/*     */   public static String func_96517_b(int p_96517_0_) {
/* 254 */     switch (p_96517_0_) {
/*     */       case 0:
/* 256 */         return "list";
/*     */       case 1:
/* 258 */         return "sidebar";
/*     */       case 2:
/* 260 */         return "belowName";
/*     */     } 
/* 262 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int func_96537_j(String p_96537_0_) {
/* 267 */     if (p_96537_0_.equalsIgnoreCase("list"))
/* 268 */       return 0; 
/* 269 */     if (p_96537_0_.equalsIgnoreCase("sidebar"))
/* 270 */       return 1; 
/* 271 */     if (p_96537_0_.equalsIgnoreCase("belowName")) {
/* 272 */       return 2;
/*     */     }
/* 274 */     return -1;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\scoreboard\Scoreboard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */