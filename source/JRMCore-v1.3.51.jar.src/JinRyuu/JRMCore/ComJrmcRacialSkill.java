/*     */ package JinRyuu.JRMCore;
/*     */ import JinRyuu.JRMCore.server.JGRaceHelper;
/*     */ import java.util.List;
/*     */ import net.minecraft.command.CommandBase;
/*     */ import net.minecraft.command.ICommand;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.command.WrongUsageException;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ 
/*     */ public class ComJrmcRacialSkill extends CommandBase {
/*  15 */   private final String[] MODES = new String[] { "set", "add" };
/*  16 */   private final String[] AMOUNT = new String[] { "0", "1", "10", "-1" };
/*  17 */   private final String[] BOOLEAN = new String[] { "true", "false" };
/*     */   
/*  19 */   final String name = "jrmcracialskill";
/*  20 */   final String desc = "Usage: '/jrmcracialskill (Set or Add) amount [playerName] [tpCostOn] [ignoreMindCostOn]' and the ADD amount can be negative too.";
/*     */   
/*     */   private byte result;
/*     */   
/*     */   private boolean doit;
/*     */   private int tp_current;
/*     */   private int tp_cost;
/*     */   
/*     */   public String func_71517_b() {
/*  29 */     return "jrmcracialskill";
/*  30 */   } public int func_82362_a() { return 2; } public String func_71518_a(ICommandSender par1ICommandSender) {
/*  31 */     return "Usage: '/jrmcracialskill (Set or Add) amount [playerName] [tpCostOn] [ignoreMindCostOn]' and the ADD amount can be negative too.";
/*     */   }
/*  33 */   private final byte SET = 0, ADD = 1, TAKE = 2, NA = -1;
/*     */   
/*     */   public void func_71515_b(ICommandSender par1ICommandSender, String[] commandTags) {
/*     */     EntityPlayerMP entityplayermp;
/*  37 */     if (commandTags.length <= 0) throw new WrongUsageException("Usage: '/jrmcracialskill (Set or Add) amount [playerName] [tpCostOn] [ignoreMindCostOn]' and the ADD amount can be negative too.", new Object[0]);
/*     */     
/*  39 */     this.result = -1;
/*  40 */     this.doit = true;
/*  41 */     this.tp_current = 0; this.tp_cost = 0;
/*  42 */     boolean takeTP = false;
/*  43 */     boolean MindCost = false;
/*     */ 
/*     */     
/*  46 */     if (commandTags.length > 2) {
/*  47 */       entityplayermp = func_82359_c(par1ICommandSender, commandTags[2]);
/*  48 */       if (commandTags.length > 3) takeTP = Boolean.parseBoolean(commandTags[3]); 
/*  49 */       if (commandTags.length > 4) MindCost = Boolean.parseBoolean(commandTags[4]); 
/*     */     } else {
/*  51 */       entityplayermp = func_71521_c(par1ICommandSender);
/*     */     } 
/*  53 */     String entitycommansender = "Console";
/*     */     try {
/*  55 */       EntityPlayerMP commansender = func_71521_c(par1ICommandSender);
/*  56 */       entitycommansender = commansender.func_70005_c_();
/*  57 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/*  60 */     boolean boo = entitycommansender.equals("Console") ? JRMCoreConfig.ComRSNAC : (entitycommansender.equals(entityplayermp.func_70005_c_()) ? JRMCoreConfig.ComRSNAS : JRMCoreConfig.ComRSNAO);
/*     */ 
/*     */     
/*  63 */     NBTTagCompound nbt = JRMCoreH.nbt((Entity)entityplayermp, "pres");
/*     */     
/*  65 */     String str = commandTags[0].toLowerCase();
/*  66 */     byte tpMode = str.equals("add") ? 1 : (str.equals("set") ? 0 : -1);
/*  67 */     String str2 = commandTags[1];
/*  68 */     byte i = Byte.parseByte(str2);
/*     */     
/*  70 */     boolean neg = (i < 0);
/*  71 */     if (neg) i = (byte)(i * -1);
/*     */     
/*  73 */     boolean loop = true;
/*     */     
/*  75 */     boolean dbc = (nbt.func_74771_c("jrmcPwrtyp") == 1);
/*  76 */     boolean nc = (nbt.func_74771_c("jrmcPwrtyp") == 2);
/*     */     
/*  78 */     if (dbc || nc) {
/*     */       
/*  80 */       byte race = nbt.func_74771_c("jrmcRace");
/*  81 */       byte startLevel = 0;
/*  82 */       byte currentLevel = 0;
/*  83 */       String key = dbc ? "jrmcSSltX" : "jrmcSSltY";
/*  84 */       if (nbt.func_74764_b(key) && !nbt.func_74779_i(key).contains("pty") && nbt.func_74779_i(key).length() > 1 && (!nc || (
/*  85 */         !nbt.func_74779_i("jrmcSSltY").contains("Sai") && race != 1 && race != 2))) {
/*     */         
/*  87 */         byte max = JGRaceHelper.getMaxRacialSkillLevel(dbc, nc, race);
/*  88 */         currentLevel = Byte.parseByte(nbt.func_74779_i(key).substring(2));
/*  89 */         byte targetLevel = (byte)((tpMode == 0) ? i : ((tpMode == 1) ? (currentLevel + (neg ? -1 : 1) * i) : -1));
/*  90 */         targetLevel = (targetLevel < 0) ? 0 : ((targetLevel > max) ? max : targetLevel);
/*  91 */         boolean targetOverCurrent = (currentLevel < targetLevel);
/*  92 */         byte setLevelTo = (byte)((tpMode == 0) ? ((takeTP || MindCost) ? 1 : i) : ((tpMode == 1) ? 1 : 0));
/*     */         
/*  94 */         startLevel = Byte.parseByte(nbt.func_74779_i(key).substring(2));
/*     */         
/*  96 */         int foolProof = 15;
/*     */         
/*  98 */         while (loop && this.doit && targetLevel != -1 && currentLevel != targetLevel && foolProof > 0) {
/*     */           
/* 100 */           currentLevel = Byte.parseByte(nbt.func_74779_i(key).substring(2));
/*     */           
/* 102 */           if ((takeTP && targetOverCurrent) || MindCost) canAfford(dbc, nc, key, entityplayermp, nbt, race, max, takeTP, MindCost);
/*     */           
/* 104 */           currentLevel = setValue(tpMode, neg, currentLevel, setLevelTo, max, takeTP, targetOverCurrent, MindCost);
/*     */           
/* 106 */           if (this.doit) {
/*     */             
/* 108 */             nbt.func_74778_a(key, (dbc ? JRMCoreH.vlblRSkls[0] : JRMCoreH.ncCSkls[nbt.func_74771_c("jrmcClass")]) + currentLevel);
/*     */             
/* 110 */             if (takeTP && targetOverCurrent)
/*     */             {
/* 112 */               if (takeTP) { nbt.func_74768_a("jrmcTpint", this.tp_current - this.tp_cost); }
/* 113 */               else { loop = false; }
/*     */                } 
/*     */           } 
/* 116 */           foolProof--;
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 122 */         if (boo && this.result != -1) {
/*     */           
/* 124 */           String resultS = (this.result == 0) ? "was set" : (((this.result == 1) ? ("lost " + i + " level(s)") : ("received " + i + " level(s)")) + " (" + (this.doit ? "Success" : "Fail") + ")");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 131 */           currentLevel = Byte.parseByte(nbt.func_74779_i(key).substring(2));
/* 132 */           notifyAdmins(par1ICommandSender, "Racial Skill " + resultS + " from: %s to: %s for %s", new Object[] { Integer.valueOf(startLevel), Integer.valueOf(currentLevel), entityplayermp.func_70005_c_() });
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void notifyAdmins(ICommandSender par1iCommandSender, String string, Object[] objects) {
/* 143 */     func_152373_a(par1iCommandSender, (ICommand)this, string, objects);
/*     */   }
/*     */   
/*     */   public List func_71516_a(ICommandSender commandSender, String[] stringArray) {
/* 147 */     int length = stringArray.length;
/* 148 */     switch (length) { case 1:
/* 149 */         return func_71530_a(stringArray, this.MODES);
/* 150 */       case 2: return func_71530_a(stringArray, this.AMOUNT);
/* 151 */       case 3: return func_71530_a(stringArray, getListOfPlayers());
/* 152 */       case 4: return func_71530_a(stringArray, this.BOOLEAN);
/* 153 */       case 5: return func_71530_a(stringArray, this.BOOLEAN); }
/* 154 */      return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected String[] getListOfPlayers() {
/* 160 */     return MinecraftServer.func_71276_C().func_71213_z();
/*     */   } public boolean isUsernameIndex(int par1) {
/* 162 */     return (par1 == 0);
/*     */   }
/*     */   
/*     */   private void canAfford(boolean dbc, boolean nc, String key, EntityPlayerMP player, NBTTagCompound nbt, byte race, byte max, boolean takeTP, boolean MindCost) {
/*     */     int[][] rSklsLvl;
/*     */     String[] cSkls;
/*     */     int[][] cSklsLvl;
/*     */     String[] skls;
/* 170 */     int[][] sklsMR, rSklsMR = (int[][])null;
/*     */ 
/*     */ 
/*     */     
/* 174 */     int[][] cSklsMR = (int[][])null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 182 */     if (dbc) {
/*     */       
/* 184 */       String[] rSkls = JRMCoreH.vlblRSkls;
/* 185 */       rSklsLvl = JRMCoreH.DBCRacialSkillTPCost;
/* 186 */       String[] rSklsNms = JRMCoreH.vlblRSklsNms;
/* 187 */       rSklsMR = JRMCoreH.DBCRacialSkillMindCost;
/* 188 */       cSkls = JRMCoreH.vlblCSkls;
/* 189 */       cSklsLvl = JRMCoreH.vlblCSklsLvl;
/* 190 */       String[] cSklsNms = JRMCoreH.vlblCSklsNms;
/*     */       
/* 192 */       skls = JRMCoreH.DBCSkillsIDs;
/* 193 */       int[] sklsUps = JRMCoreH.vlblSklsUps;
/* 194 */       int[][] sklsLvl = JRMCoreH.DBCSkillTPCost;
/* 195 */       String[] sklsNms = JRMCoreH.DBCSkillNames;
/* 196 */       sklsMR = JRMCoreH.DBCSkillMindCost;
/* 197 */       String mod = "dbc";
/*     */     }
/*     */     else {
/*     */       
/* 201 */       String[] rSkls = JRMCoreH.ncRSkls;
/* 202 */       rSklsLvl = JRMCoreH.ncRSklsLvl;
/* 203 */       String[] rSklsNms = JRMCoreH.ncRSklsNms;
/*     */       
/* 205 */       cSkls = JRMCoreH.ncCSkls;
/* 206 */       cSklsLvl = JRMCoreH.NCRacialSkillTPCost;
/* 207 */       String[] cSklsNms = JRMCoreH.NCRacialSkillAbilityNames;
/* 208 */       cSklsMR = JRMCoreH.NCRacialSkillMindCost;
/* 209 */       skls = JRMCoreH.NCSkillIDs;
/* 210 */       int[] sklsUps = JRMCoreH.ncSklsUps;
/* 211 */       int[][] sklsLvl = JRMCoreH.NCSkillTPCost;
/* 212 */       String[] sklsNms = JRMCoreH.NCSkillNames;
/* 213 */       sklsMR = JRMCoreH.NCSkillMindCost;
/* 214 */       String mod = "nc";
/*     */     } 
/*     */     
/* 217 */     String PlyrSkillX = nbt.func_74779_i("jrmcSSltX");
/* 218 */     String PlyrSkillY = nbt.func_74779_i("jrmcSSltY");
/*     */     
/* 220 */     int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts((EntityPlayer)player);
/* 221 */     String[] PlyrSkills = nbt.func_74779_i("jrmcSSlts").split(",");
/*     */     
/* 223 */     int SkillLvls = JRMCoreH.skillSlot_SpentMindRequirement(PlyrSkills, skls, sklsMR) + JRMCoreH.skillSlot_SpentMindRequirement_X(PlyrSkillX, race, rSklsMR) + JRMCoreH.skillSlot_SpentMindRequirement(PlyrSkillY, cSkls, cSklsMR);
/* 224 */     boolean SklSlt = JRMCoreH.canAffordSkill(PlyrAttrbts[4], SkillLvls);
/*     */     
/* 226 */     String sklnm = nbt.func_74779_i(key);
/*     */     
/* 228 */     if (MindCost)
/*     */     {
/* 230 */       if (dbc) {
/* 231 */         int mz = JRMCoreH.skillMindRequirement_X(sklnm, race, rSklsMR);
/* 232 */         int mx = SkillLvls + mz;
/* 233 */         SklSlt = JRMCoreH.canAffordSkill(PlyrAttrbts[4], mx);
/*     */       } else {
/*     */         
/* 236 */         int mz = JRMCoreH.skillMindRequirement(sklnm, cSkls, cSklsMR);
/* 237 */         int mx = SkillLvls + mz;
/* 238 */         SklSlt = JRMCoreH.canAffordSkill(PlyrAttrbts[4], mx);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 243 */     int racialSkillLvl = Integer.parseInt(sklnm.substring(2)) + 1;
/*     */     
/* 245 */     int tpLevelCost = 0;
/* 246 */     if (dbc) {
/*     */       
/* 248 */       tpLevelCost = JRMCoreH.skillTPCost_X(PlyrSkillX, race, rSklsLvl);
/*     */     }
/*     */     else {
/*     */       
/* 252 */       tpLevelCost = JRMCoreH.skillTPCost_X(PlyrSkillY, race, cSklsLvl);
/*     */     } 
/*     */     
/* 255 */     if (takeTP) {
/*     */       
/* 257 */       this.tp_current = nbt.func_74762_e("jrmcTpint");
/* 258 */       if (JRMCoreH.rSai(race) && dbc) { this.tp_cost = tpLevelCost; racialSkillLvl = (racialSkillLvl > 7) ? 7 : racialSkillLvl; }
/* 259 */       else if (race == 4 && dbc) { this.tp_cost = tpLevelCost; racialSkillLvl = (racialSkillLvl > 6) ? 6 : racialSkillLvl; }
/* 260 */       else if (race != 4 && dbc) { this.tp_cost = tpLevelCost; racialSkillLvl = (racialSkillLvl > 5) ? 5 : racialSkillLvl; }
/*     */     
/*     */     } 
/*     */     
/* 264 */     this.doit = ((!takeTP || (this.tp_current >= this.tp_cost && this.tp_cost != -1)) && (!MindCost || SklSlt));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private byte setValue(byte tpMode, boolean neg, byte n, byte i, byte max, boolean takeTP, boolean targetOverCurrent, boolean MindCost) {
/* 270 */     if (tpMode == 0) {
/*     */       
/* 272 */       if (!takeTP && !MindCost) {
/*     */         
/* 274 */         n = i;
/* 275 */         if (n < 0) { n = 0; }
/* 276 */         else if (n > max) { n = max;
/*     */            }
/*     */ 
/*     */       
/*     */       }
/* 281 */       else if (!targetOverCurrent) {
/* 282 */         n = (byte)(n - i);
/* 283 */         if (n < 0) n = 0;
/*     */       
/*     */       } else {
/*     */         
/* 287 */         n = (byte)(n + i);
/* 288 */         if (n > max) n = max;
/*     */       
/*     */       } 
/* 291 */       this.result = 0;
/*     */     
/*     */     }
/* 294 */     else if (tpMode == 1) {
/*     */ 
/*     */       
/* 297 */       if (neg) {
/* 298 */         n = (byte)(n - i);
/* 299 */         if (n < 0) n = 0; 
/* 300 */         this.result = 1;
/*     */       }
/*     */       else {
/*     */         
/* 304 */         n = (byte)(n + i);
/* 305 */         if (n > max) n = max; 
/* 306 */         this.result = 2;
/*     */       } 
/*     */     } 
/* 309 */     return n;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\ComJrmcRacialSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */