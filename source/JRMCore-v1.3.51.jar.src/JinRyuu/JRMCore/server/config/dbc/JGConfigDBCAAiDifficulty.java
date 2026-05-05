/*     */ package JinRyuu.JRMCore.server.config.dbc;
/*     */ 
/*     */ import JinRyuu.JRMCore.server.config.JGConfigBase;
/*     */ import net.minecraftforge.common.config.Configuration;
/*     */ import net.minecraftforge.common.config.Property;
/*     */ 
/*     */ public class JGConfigDBCAAiDifficulty
/*     */   extends JGConfigBase {
/*   9 */   public static final String[] DIFFICULTIES = new String[] { "Easy", "Medium", "Hard", "Insane" };
/*  10 */   public static final String[] AAIs = new String[] { "Ground Dash", "Jump", "Flying Dash", "Ki Attack Charge", "Teleport" };
/*     */ 
/*     */   
/*  13 */   public static double[] SpeedMulti = new double[DIFFICULTIES.length];
/*     */   
/*  15 */   public static double[] GroundDashSpeedMulti = new double[DIFFICULTIES.length];
/*  16 */   public static double[] GroundDashSpeedMulti2 = new double[DIFFICULTIES.length];
/*  17 */   public static double[] GroundDashLimit = new double[DIFFICULTIES.length];
/*     */   
/*  19 */   public static double[] JumpMulti = new double[DIFFICULTIES.length];
/*  20 */   public static double[] JumpMulti2 = new double[DIFFICULTIES.length];
/*  21 */   public static double[] JumpLimit = new double[DIFFICULTIES.length];
/*  22 */   public static double[] JumpLimit2 = new double[DIFFICULTIES.length];
/*  23 */   public static double[] JumpRate = new double[DIFFICULTIES.length];
/*     */   
/*  25 */   public static double[] FlyingDashMulti = new double[DIFFICULTIES.length];
/*  26 */   public static double[] FlyingDashLimit = new double[DIFFICULTIES.length];
/*     */   
/*  28 */   public static double[] KiAttackChargeMulti = new double[DIFFICULTIES.length];
/*  29 */   public static double[] KiAttackChargeLimit = new double[DIFFICULTIES.length];
/*     */   
/*  31 */   public static int[] TeleportRateMin = new int[DIFFICULTIES.length];
/*  32 */   public static int[] TeleportRateMax = new int[DIFFICULTIES.length];
/*     */ 
/*     */   
/*  35 */   public static double[] cSpeedMulti = new double[DIFFICULTIES.length];
/*     */   
/*  37 */   public static double[] cGroundDashSpeedMulti = new double[DIFFICULTIES.length];
/*  38 */   public static double[] cGroundDashSpeedMulti2 = new double[DIFFICULTIES.length];
/*  39 */   public static double[] cGroundDashLimit = new double[DIFFICULTIES.length];
/*     */   
/*  41 */   public static double[] cJumpMulti = new double[DIFFICULTIES.length];
/*  42 */   public static double[] cJumpMulti2 = new double[DIFFICULTIES.length];
/*  43 */   public static double[] cJumpLimit = new double[DIFFICULTIES.length];
/*  44 */   public static double[] cJumpLimit2 = new double[DIFFICULTIES.length];
/*  45 */   public static double[] cJumpRate = new double[DIFFICULTIES.length];
/*     */   
/*  47 */   public static double[] cFlyingDashMulti = new double[DIFFICULTIES.length];
/*  48 */   public static double[] cFlyingDashLimit = new double[DIFFICULTIES.length];
/*     */   
/*  50 */   public static double[] cKiAttackChargeMulti = new double[DIFFICULTIES.length];
/*  51 */   public static double[] cKiAttackChargeLimit = new double[DIFFICULTIES.length];
/*     */   
/*  53 */   public static int[] cTeleportRateMin = new int[DIFFICULTIES.length];
/*  54 */   public static int[] cTeleportRateMax = new int[DIFFICULTIES.length];
/*     */ 
/*     */ 
/*     */   
/*     */   public static void init(Configuration config, byte difficultyID) {
/*  59 */     config.load();
/*  60 */     init_difficulty(config, difficultyID);
/*  61 */     config.save();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void init_difficulty(Configuration config, byte difficultyID) {
/*  67 */     String name = "DBC " + DIFFICULTIES[difficultyID];
/*  68 */     String percentage = " (Percentage)";
/*  69 */     String server = "Server Sided! ";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  75 */     String CATEGORY = "Main Settings";
/*     */     
/*  77 */     int min = 0;
/*  78 */     int max = 10000;
/*  79 */     String title = CATEGORY + " Speed Multiplier";
/*  80 */     (new double[4])[0] = -1.0D; (new double[4])[1] = 1.3D; (new double[4])[2] = 1.8D; (new double[4])[3] = 2.3D; Property property = config.get(CATEGORY, title, (new double[4])[difficultyID]);
/*  81 */     property.comment = "Server Sided! " + title + getDefault("" + min, "" + max);
/*  82 */     cSpeedMulti[difficultyID] = property.getDouble();
/*  83 */     if (cSpeedMulti[difficultyID] < min) { cSpeedMulti[difficultyID] = min; }
/*  84 */     else if (cSpeedMulti[difficultyID] > max) { cSpeedMulti[difficultyID] = max; }
/*  85 */      SpeedMulti[difficultyID] = cSpeedMulti[difficultyID];
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  90 */     CATEGORY = AAIs[0];
/*     */     
/*  92 */     min = 0;
/*  93 */     max = 10000;
/*  94 */     title = CATEGORY + " Speed Multiplier";
/*  95 */     (new double[4])[0] = 1.2D; (new double[4])[1] = 1.3D; (new double[4])[2] = 1.4D; (new double[4])[3] = 1.5D; property = config.get(CATEGORY, title, (new double[4])[difficultyID]);
/*  96 */     property.comment = "Server Sided! " + title + getDefault("" + min, "" + max);
/*  97 */     cGroundDashSpeedMulti[difficultyID] = property.getDouble();
/*  98 */     if (cGroundDashSpeedMulti[difficultyID] < min) { cGroundDashSpeedMulti[difficultyID] = min; }
/*  99 */     else if (cGroundDashSpeedMulti[difficultyID] > max) { cGroundDashSpeedMulti[difficultyID] = max; }
/* 100 */      GroundDashSpeedMulti[difficultyID] = cGroundDashSpeedMulti[difficultyID];
/*     */     
/* 102 */     min = 0;
/* 103 */     max = 10000;
/* 104 */     title = CATEGORY + " Position Difference Speed Multiplier";
/* 105 */     (new double[4])[0] = 0.3D; (new double[4])[1] = 0.4D; (new double[4])[2] = 0.5D; (new double[4])[3] = 0.8D; property = config.get(CATEGORY, title, (new double[4])[difficultyID]);
/* 106 */     property.comment = "Server Sided! " + title + getDefault("" + min, "" + max);
/* 107 */     cGroundDashSpeedMulti2[difficultyID] = property.getDouble();
/* 108 */     if (cGroundDashSpeedMulti2[difficultyID] < min) { cGroundDashSpeedMulti2[difficultyID] = min; }
/* 109 */     else if (cGroundDashSpeedMulti2[difficultyID] > max) { cGroundDashSpeedMulti2[difficultyID] = max; }
/* 110 */      GroundDashSpeedMulti2[difficultyID] = cGroundDashSpeedMulti2[difficultyID];
/*     */     
/* 112 */     min = 0;
/* 113 */     max = 10000;
/* 114 */     title = CATEGORY + " Speed Limit";
/* 115 */     (new double[4])[0] = 0.2D; (new double[4])[1] = 0.3D; (new double[4])[2] = 0.4D; (new double[4])[3] = 0.5D; property = config.get(CATEGORY, title, (new double[4])[difficultyID]);
/* 116 */     property.comment = "Server Sided! " + title + getDefault("" + min, "" + max);
/* 117 */     cGroundDashLimit[difficultyID] = property.getDouble();
/* 118 */     if (cGroundDashLimit[difficultyID] < min) { cGroundDashLimit[difficultyID] = min; }
/* 119 */     else if (cGroundDashLimit[difficultyID] > max) { cGroundDashLimit[difficultyID] = max; }
/* 120 */      GroundDashLimit[difficultyID] = cGroundDashLimit[difficultyID];
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 125 */     CATEGORY = AAIs[1];
/*     */     
/* 127 */     min = 0;
/* 128 */     max = 10000;
/* 129 */     title = CATEGORY + " Upwards Multiplier";
/* 130 */     (new double[4])[0] = 0.9D; (new double[4])[1] = 0.9D; (new double[4])[2] = 0.9D; (new double[4])[3] = 0.9D; property = config.get(CATEGORY, title, (new double[4])[difficultyID]);
/* 131 */     property.comment = "Server Sided! " + title + getDefault("" + min, "" + max);
/* 132 */     cJumpMulti[difficultyID] = property.getDouble();
/* 133 */     if (cJumpMulti[difficultyID] < min) { cJumpMulti[difficultyID] = min; }
/* 134 */     else if (cJumpMulti[difficultyID] > max) { cJumpMulti[difficultyID] = max; }
/* 135 */      JumpMulti[difficultyID] = cJumpMulti[difficultyID];
/*     */     
/* 137 */     min = 0;
/* 138 */     max = 10000;
/* 139 */     title = CATEGORY + " Sideways Multiplier";
/* 140 */     (new double[4])[0] = 0.5D; (new double[4])[1] = 0.8D; (new double[4])[2] = 1.0D; (new double[4])[3] = 1.2D; property = config.get(CATEGORY, title, (new double[4])[difficultyID]);
/* 141 */     property.comment = "Server Sided! " + title + getDefault("" + min, "" + max);
/* 142 */     cJumpMulti2[difficultyID] = property.getDouble();
/* 143 */     if (cJumpMulti2[difficultyID] < min) { cJumpMulti2[difficultyID] = min; }
/* 144 */     else if (cJumpMulti2[difficultyID] > max) { cJumpMulti2[difficultyID] = max; }
/* 145 */      JumpMulti2[difficultyID] = cJumpMulti2[difficultyID];
/*     */     
/* 147 */     min = 0;
/* 148 */     max = 10000;
/* 149 */     title = CATEGORY + " Sideways Limit";
/* 150 */     (new double[4])[0] = 2.5D; (new double[4])[1] = 4.0D; (new double[4])[2] = -1.0D; (new double[4])[3] = -1.0D; property = config.get(CATEGORY, title, (new double[4])[difficultyID]);
/* 151 */     property.comment = "Server Sided! " + title + getDefault("" + min, "" + max);
/* 152 */     cJumpLimit[difficultyID] = property.getDouble();
/* 153 */     if (cJumpLimit[difficultyID] < min) { cJumpLimit[difficultyID] = min; }
/* 154 */     else if (cJumpLimit[difficultyID] > max) { cJumpLimit[difficultyID] = max; }
/* 155 */      JumpLimit[difficultyID] = cJumpLimit[difficultyID];
/*     */     
/* 157 */     min = 0;
/* 158 */     max = 10000;
/* 159 */     title = CATEGORY + " Upwards Limit";
/* 160 */     (new double[4])[0] = 2.0D; (new double[4])[1] = 3.0D; (new double[4])[2] = 7.0D; (new double[4])[3] = 7.0D; property = config.get(CATEGORY, title, (new double[4])[difficultyID]);
/* 161 */     property.comment = "Server Sided! " + title + getDefault("" + min, "" + max);
/* 162 */     cJumpLimit2[difficultyID] = property.getDouble();
/* 163 */     if (cJumpLimit2[difficultyID] < min) { cJumpLimit2[difficultyID] = min; }
/* 164 */     else if (cJumpLimit2[difficultyID] > max) { cJumpLimit2[difficultyID] = max; }
/* 165 */      JumpLimit2[difficultyID] = cJumpLimit2[difficultyID];
/*     */     
/* 167 */     min = 0;
/* 168 */     max = 10000;
/* 169 */     title = CATEGORY + " Rate";
/* 170 */     (new double[4])[0] = 0.6D; (new double[4])[1] = 0.8D; (new double[4])[2] = 0.9D; (new double[4])[3] = 0.9D; property = config.get(CATEGORY, title, (new double[4])[difficultyID]);
/* 171 */     property.comment = "Server Sided! " + title + getDefault("" + min, "" + max);
/* 172 */     cJumpRate[difficultyID] = property.getDouble();
/* 173 */     if (cJumpRate[difficultyID] < min) { cJumpRate[difficultyID] = min; }
/* 174 */     else if (cJumpRate[difficultyID] > max) { cJumpRate[difficultyID] = max; }
/* 175 */      JumpRate[difficultyID] = cJumpRate[difficultyID];
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 180 */     CATEGORY = AAIs[2];
/*     */     
/* 182 */     min = 0;
/* 183 */     max = 10000;
/* 184 */     title = CATEGORY + " Speed Multiplier";
/* 185 */     (new double[4])[0] = 1.0D; (new double[4])[1] = 2.0D; (new double[4])[2] = 4.0D; (new double[4])[3] = 6.0D; property = config.get(CATEGORY, title, (new double[4])[difficultyID]);
/* 186 */     property.comment = "Server Sided! " + title + getDefault("" + min, "" + max);
/* 187 */     cFlyingDashMulti[difficultyID] = property.getDouble();
/* 188 */     if (cFlyingDashMulti[difficultyID] < min) { cFlyingDashMulti[difficultyID] = min; }
/* 189 */     else if (cFlyingDashMulti[difficultyID] > max) { cFlyingDashMulti[difficultyID] = max; }
/* 190 */      FlyingDashMulti[difficultyID] = cFlyingDashMulti[difficultyID];
/*     */     
/* 192 */     min = 0;
/* 193 */     max = 10000;
/* 194 */     title = CATEGORY + " Speed Limit";
/* 195 */     (new double[4])[0] = 0.15D; (new double[4])[1] = 0.2D; (new double[4])[2] = 0.8D; (new double[4])[3] = 1.0D; property = config.get(CATEGORY, title, (new double[4])[difficultyID]);
/* 196 */     property.comment = "Server Sided! " + title + getDefault("" + min, "" + max);
/* 197 */     cFlyingDashLimit[difficultyID] = property.getDouble();
/* 198 */     if (cFlyingDashLimit[difficultyID] < min) { cFlyingDashLimit[difficultyID] = min; }
/* 199 */     else if (cFlyingDashLimit[difficultyID] > max) { cFlyingDashLimit[difficultyID] = max; }
/* 200 */      FlyingDashLimit[difficultyID] = cFlyingDashLimit[difficultyID];
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 205 */     CATEGORY = AAIs[3];
/*     */     
/* 207 */     min = 0;
/* 208 */     max = 10000;
/* 209 */     title = CATEGORY + " Runaway Speed Multiplier";
/* 210 */     (new double[4])[0] = 0.6D; (new double[4])[1] = 0.7D; (new double[4])[2] = 0.9D; (new double[4])[3] = 1.1D; property = config.get(CATEGORY, title, (new double[4])[difficultyID]);
/* 211 */     property.comment = "Server Sided! " + title + getDefault("" + min, "" + max);
/* 212 */     cKiAttackChargeMulti[difficultyID] = property.getDouble();
/* 213 */     if (cKiAttackChargeMulti[difficultyID] < min) { cKiAttackChargeMulti[difficultyID] = min; }
/* 214 */     else if (cKiAttackChargeMulti[difficultyID] > max) { cKiAttackChargeMulti[difficultyID] = max; }
/* 215 */      KiAttackChargeMulti[difficultyID] = cKiAttackChargeMulti[difficultyID];
/*     */     
/* 217 */     min = 0;
/* 218 */     max = 10000;
/* 219 */     title = CATEGORY + " Runaway Speed Limit";
/* 220 */     (new double[4])[0] = 0.2D; (new double[4])[1] = 0.4D; (new double[4])[2] = 0.7D; (new double[4])[3] = 1.0D; property = config.get(CATEGORY, title, (new double[4])[difficultyID]);
/* 221 */     property.comment = "Server Sided! " + title + getDefault("" + min, "" + max);
/* 222 */     cKiAttackChargeLimit[difficultyID] = property.getDouble();
/* 223 */     if (cKiAttackChargeLimit[difficultyID] < min) { cKiAttackChargeLimit[difficultyID] = min; }
/* 224 */     else if (cKiAttackChargeLimit[difficultyID] > max) { cKiAttackChargeLimit[difficultyID] = max; }
/* 225 */      KiAttackChargeLimit[difficultyID] = cKiAttackChargeLimit[difficultyID];
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 230 */     CATEGORY = AAIs[4];
/*     */     
/* 232 */     min = 0;
/* 233 */     max = 10000;
/* 234 */     title = CATEGORY + " Minimum Rate";
/* 235 */     (new int[4])[0] = 120; (new int[4])[1] = 100; (new int[4])[2] = 90; (new int[4])[3] = 75; property = config.get(CATEGORY, title, (new int[4])[difficultyID]);
/* 236 */     property.comment = "Server Sided! " + title + getDefault("" + min, "" + max);
/* 237 */     cTeleportRateMin[difficultyID] = property.getInt();
/* 238 */     if (cTeleportRateMin[difficultyID] < min) { cTeleportRateMin[difficultyID] = min; }
/* 239 */     else if (cTeleportRateMin[difficultyID] > max) { cTeleportRateMin[difficultyID] = max; }
/* 240 */      TeleportRateMin[difficultyID] = cTeleportRateMin[difficultyID];
/*     */     
/* 242 */     min = 0;
/* 243 */     max = 10000;
/* 244 */     title = CATEGORY + " Maximum Rate";
/* 245 */     (new int[4])[0] = 50; (new int[4])[1] = 50; (new int[4])[2] = 45; (new int[4])[3] = 45; property = config.get(CATEGORY, title, (new int[4])[difficultyID]);
/* 246 */     property.comment = "Server Sided! " + title + getDefault("" + min, "" + max);
/* 247 */     cTeleportRateMax[difficultyID] = property.getInt();
/* 248 */     if (cTeleportRateMax[difficultyID] < min) { cTeleportRateMax[difficultyID] = min; }
/* 249 */     else if (cTeleportRateMax[difficultyID] > max) { cTeleportRateMax[difficultyID] = max; }
/* 250 */      TeleportRateMax[difficultyID] = cTeleportRateMax[difficultyID];
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\server\config\dbc\JGConfigDBCAAiDifficulty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */