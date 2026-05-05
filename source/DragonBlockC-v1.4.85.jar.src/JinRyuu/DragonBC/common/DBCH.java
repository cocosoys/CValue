/*     */ package JinRyuu.DragonBC.common;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
/*     */ import JinRyuu.DragonBC.common.Items.ItemsDBC;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.JRMCoreHDBC;
/*     */ import JinRyuu.JRMCore.p.DBC.DBCPduo;
/*     */ import JinRyuu.JRMCore.p.PD;
/*     */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.event.entity.living.LivingDropsEvent;
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
/*     */ public class DBCH
/*     */ {
/*  41 */   public static String genKH = "";
/*  42 */   public static String genCA = "";
/*     */   
/*  44 */   public static String genGH = "";
/*     */   
/*  46 */   public static String genFS = "";
/*     */   
/*  48 */   public static String genGuru = "";
/*     */   
/*  50 */   public static String genBS = "";
/*  51 */   public static int[] genKHnpc1 = new int[] { -5, 0, -18 };
/*  52 */   public static int[] genCAnpc1 = new int[] { 2, 2, 10 };
/*  53 */   public static int[] genGHnpc1 = new int[] { 8, 1, 31 };
/*  54 */   public static int[] genGHnpc2 = new int[] { 10, 1, 8 };
/*  55 */   public static int[] genFSnpc1 = new int[] { 2, 1, 15 };
/*  56 */   public static int[] genBSnpc1 = new int[] { 14, 1, 20 };
/*  57 */   public static int[] genGurunpc1 = new int[] { 9, 5, 10 };
/*     */   
/*  59 */   public static String wi = "wi.dbc";
/*  60 */   public static void wwi(MinecraftServer server, String d, String rid, boolean b) { String wd = "/data"; JRMCoreH.wd(server, d, rid + "", wd, wi, b); } public static String rwi(MinecraftServer server, String id) {
/*  61 */     String wd = "/data"; return JRMCoreH.rd(server, id + "", wd, wi);
/*     */   }
/*  63 */   public static String kh = "KameHouse";
/*  64 */   public static void khwwi(MinecraftServer server, String d, boolean b) { wwi(server, d, kh, b); } public static String khrwi(MinecraftServer server) {
/*  65 */     return rwi(server, kh);
/*  66 */   } public static String khn1 = "KameHouseNPC1";
/*  67 */   public static void khn1wwi(MinecraftServer server, String d, boolean b) { wwi(server, d, khn1, b); } public static String khn1rwi(MinecraftServer server) {
/*  68 */     return rwi(server, khn1);
/*     */   }
/*  70 */   public static String ca = "CellArena";
/*  71 */   public static void cawwi(MinecraftServer server, String d, boolean b) { wwi(server, d, ca, b); } public static String carwi(MinecraftServer server) {
/*  72 */     return rwi(server, ca);
/*  73 */   } public static String can1 = "CellArenaNPC1";
/*  74 */   public static void can1wwi(MinecraftServer server, String d, boolean b) { wwi(server, d, can1, b); } public static String can1rwi(MinecraftServer server) {
/*  75 */     return rwi(server, can1);
/*     */   }
/*  77 */   public static String gh = "GokuHouse";
/*  78 */   public static void ghwwi(MinecraftServer server, String d, boolean b) { wwi(server, d, gh, b); } public static String ghrwi(MinecraftServer server) {
/*  79 */     return rwi(server, gh);
/*  80 */   } public static String ghn1 = "GokuHouseNPC1";
/*  81 */   public static void ghn1wwi(MinecraftServer server, String d, boolean b) { wwi(server, d, ghn1, b); } public static String ghn1rwi(MinecraftServer server) {
/*  82 */     return rwi(server, ghn1);
/*     */   }
/*  84 */   public static String fs = "FreizaShip";
/*  85 */   public static void fswwi(MinecraftServer server, String d, boolean b) { wwi(server, d, fs, b); } public static String fsrwi(MinecraftServer server) {
/*  86 */     return rwi(server, fs);
/*  87 */   } public static String fsn1 = "FreizaShipNPC1";
/*  88 */   public static void fsn1wwi(MinecraftServer server, String d, boolean b) { wwi(server, d, fsn1, b); } public static String fsn1rwi(MinecraftServer server) {
/*  89 */     return rwi(server, fsn1);
/*     */   }
/*  91 */   public static String bs = "BabidiShip";
/*  92 */   public static void bswwi(MinecraftServer server, String d, boolean b) { wwi(server, d, bs, b); } public static String bsrwi(MinecraftServer server) {
/*  93 */     return rwi(server, bs);
/*     */   }
/*  95 */   public static String guruh = "GuruHouse";
/*  96 */   public static void guruhwwi(MinecraftServer server, String d, boolean b) { wwi(server, d, guruh, b); } public static String guruhrwi(MinecraftServer server) {
/*  97 */     return rwi(server, guruh);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean HTCtrain = false;
/*     */   
/* 103 */   public static int KPminX = 75;
/* 104 */   public static int KPminY = 110;
/* 105 */   public static int KPminZ = -3757;
/* 106 */   public static int KPmaxX = 132;
/* 107 */   public static int KPmaxY = 150;
/* 108 */   public static int KPmaxZ = -3702;
/*     */   
/* 110 */   public static int[] Kami = new int[] { 86, 217, 50, 0 };
/* 111 */   public static int[] Karn = new int[] { 80, 133, 40, 0 };
/* 112 */   public static int[] Enma = new int[] { 75, 91, 53, 0 };
/* 113 */   public static int[] KaiO = new int[] { 107, 116, -3719, 0 };
/* 114 */   public static int[] TrnksF = new int[] { 72, 217, 27, 0 };
/* 115 */   public static int[] Jin = new int[] { 107, 116, -3722, 0 };
/* 116 */   public static int[] Whis1 = new int[] { 69, 217, 60, 0 };
/* 117 */   public static int[] Whis2 = new int[] { 6, 135, 70, 0 };
/*     */ 
/*     */ 
/*     */   
/* 121 */   public static float RotYaw = 0.0F;
/* 122 */   public static float RotPic = 0.0F;
/* 123 */   public static int cbge = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean mvng() {
/* 129 */     float p = (DBCClient.mc.field_71439_g.field_70125_A < 0.0F) ? ((int)DBCClient.mc.field_71439_g.field_70125_A * -1) : (int)DBCClient.mc.field_71439_g.field_70125_A;
/* 130 */     float y = (DBCClient.mc.field_71439_g.field_70177_z < 0.0F) ? ((int)DBCClient.mc.field_71439_g.field_70177_z * -1) : (int)DBCClient.mc.field_71439_g.field_70177_z;
/* 131 */     boolean rotat = ((p > RotPic && p > RotPic + 0.1F) || (p < RotPic && p < RotPic - 0.1F) || (y > RotYaw && y > RotYaw + 0.1F) || (y < RotYaw && y < RotYaw - 0.1F));
/* 132 */     return (DBCClient.mc.field_71439_g.field_70159_w > 0.005D || DBCClient.mc.field_71439_g.field_70179_y > 0.005D || DBCClient.mc.field_71439_g.field_70159_w < -0.005D || DBCClient.mc.field_71439_g.field_70179_y < -0.005D || DBCClient.mc.field_71439_g.field_70181_x > 0.005D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean lkng() {
/* 139 */     float p = (DBCClient.mc.field_71439_g.field_70125_A < 0.0F) ? ((int)DBCClient.mc.field_71439_g.field_70125_A * -1) : (int)DBCClient.mc.field_71439_g.field_70125_A;
/* 140 */     float y = (DBCClient.mc.field_71439_g.field_70177_z < 0.0F) ? ((int)DBCClient.mc.field_71439_g.field_70177_z * -1) : (int)DBCClient.mc.field_71439_g.field_70177_z;
/* 141 */     boolean rotat = ((p > RotPic && p > RotPic + 0.1F) || (p < RotPic && p < RotPic - 0.1F) || (y > RotYaw && y > RotYaw + 0.1F) || (y < RotYaw && y < RotYaw - 0.1F));
/* 142 */     return rotat;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void dbcWish(int id, EntityPlayer p) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public static void DBCDeath(EntityPlayer Player) {
/* 152 */     if (!mod_DragonBC.DeathSystemOff) {
/*     */       
/* 154 */       int a = JRMCoreH.getByte(Player, "jrmcAlv");
/* 155 */       if (a != 1) {
/* 156 */         JRMCoreH.setByte(1, Player, "jrmcAlv");
/* 157 */         JRMCoreH.setInt(DBCConfig.RevTm, Player, "jrmcReviveTmer");
/*     */       } 
/*     */     } 
/*     */     
/* 161 */     if (Player != null) {
/*     */       
/* 163 */       JRMCoreH.setInt(0, Player, "jrmcAlCntr");
/* 164 */       mod_DragonBC.logger.info(Player.func_70005_c_() + " has died");
/* 165 */       byte d = JRMCoreH.getByte(Player, "jrmcDiff");
/* 166 */       byte pwr = JRMCoreH.getByte(Player, "jrmcPwrtyp");
/* 167 */       byte rc = JRMCoreH.getByte(Player, "jrmcRace");
/* 168 */       byte cl = JRMCoreH.getByte(Player, "jrmcClass");
/* 169 */       byte st = JRMCoreH.getByte(Player, "jrmcState");
/* 170 */       JRMCoreH.setByte((rc == 4) ? ((st > 4) ? 4 : st) : 0, Player, "jrmcState");
/* 171 */       JRMCoreH.setByte(0, Player, "jrmcState2");
/*     */       
/* 173 */       String ste = JRMCoreH.getString(Player, "jrmcStatusEff");
/* 174 */       if (JRMCoreH.StusEfcts(9, ste) || JRMCoreH.StusEfcts(2, ste) || JRMCoreH.StusEfcts(6, ste) || JRMCoreH.StusEfcts(21, ste)) {
/* 175 */         String s = "";
/* 176 */         JRMCoreH.StusEfcts(9, s, Player, JRMCoreH.StusEfcts(9, ste));
/* 177 */         JRMCoreH.StusEfcts(2, s, Player, JRMCoreH.StusEfcts(2, ste));
/* 178 */         JRMCoreH.StusEfcts(6, s, Player, JRMCoreH.StusEfcts(6, ste));
/* 179 */         JRMCoreH.StusEfcts(21, s, Player, JRMCoreH.StusEfcts(21, ste));
/*     */       } else {
/* 181 */         JRMCoreH.setString(" ", Player, "jrmcStatusEff");
/*     */       } 
/* 183 */       JRMCoreH.setInt(0, Player, "jrmcHar4va");
/* 184 */       JRMCoreH.setString("0,0,0+0", Player, "jrmcMajinAbsorptionData");
/*     */       
/* 186 */       if (d > 0 && pwr == 1) {
/* 187 */         for (int i1 = 0; i1 < d; i1++) {
/* 188 */           for (int i = 0; i < 2; i++) {
/* 189 */             for (int j = 0; j < 20; j++) {
/* 190 */               int k = (new Random()).nextInt(6);
/* 191 */               int atr = JRMCoreH.getInt(Player, JRMCoreH.AttrbtNbtI[k]);
/* 192 */               int atrs = JRMCoreH.attributeStart(pwr, k, rc, cl);
/* 193 */               if (atr > atrs) {
/* 194 */                 mod_DragonBC.logger.info("Because of death, " + Player.func_70005_c_() + " also lost a " + JRMCoreH.attrNms(pwr, k) + " point.");
/*     */                 break;
/*     */               } 
/*     */             } 
/* 198 */             for (int r = 0; r < 6; r++) {
/* 199 */               int atr = JRMCoreH.getInt(Player, JRMCoreH.AttrbtNbtI[r]);
/* 200 */               int atrs = JRMCoreH.attributeStart(pwr, r, rc, cl);
/* 201 */               if (atr < atrs) {
/* 202 */                 JRMCoreH.setInt(atrs, Player, JRMCoreH.AttrbtNbtI[r]);
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void DBCUpdate(EntityPlayer Player) {}
/*     */   
/*     */   public static void dragonSum(Entity e) {
/* 214 */     double x = e.field_70165_t;
/* 215 */     double y = e.field_70163_u;
/* 216 */     double z = e.field_70161_v;
/* 217 */     int r = 100;
/* 218 */     AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(x - r, y - r, z - r, x + r, y + r, z + r);
/* 219 */     List lst = e.field_70170_p.func_72872_a(EntityPlayer.class, aabb);
/* 220 */     if (!lst.isEmpty()) {
/* 221 */       JRMCoreHDBC.dragonSum = 100;
/*     */     }
/*     */   }
/*     */   
/*     */   public static String NpcSpawnLoc(int x, int y, int z, World w) {
/* 226 */     int k = 0;
/*     */     int i;
/* 228 */     label21: for (i = 3; i < 6; i++) {
/* 229 */       for (int j2 = 0; j2 < 6; j2++) {
/* 230 */         for (int j = y + 5; j > 1; j--) {
/* 231 */           if (w.func_147437_c(x + i, j, z + j2) && !w.func_147437_c(x + i, j - 1, z + j2)) {
/* 232 */             x += i;
/* 233 */             y = j;
/* 234 */             z += j2;
/* 235 */             k++;
/*     */             break label21;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 241 */     double X = x + 0.5D;
/* 242 */     double Z = z + 0.5D;
/* 243 */     return X + ";" + y + ";" + Z;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void DBSpawn(EntityPlayer player, long wt) {
/* 249 */     if (mod_DragonBC.DBSpawnEnabled) {
/* 250 */       int m = 48;
/* 251 */       int t = DBTime("morning") ? 1 : (DBTime("evening") ? 11996 : 6001);
/*     */       
/* 253 */       if (wt == t) {
/* 254 */         int did = player.field_71093_bK;
/* 255 */         Random ran = new Random();
/* 256 */         int rate = (did == DBCConfig.planetEarth) ? DBCConfig.eDBrate : ((did == DBCConfig.planetNamek) ? DBCConfig.nDBrate : 10);
/* 257 */         int r = ran.nextInt(rate);
/* 258 */         if (r == 0) {
/* 259 */           Block dbs = (did == DBCConfig.planetEarth) ? BlocksDBC.BlockDragonBallStone : ((did == DBCConfig.planetNamek) ? BlocksDBC.BlockNamekDragonBallStone : null);
/* 260 */           Block db = (did == DBCConfig.planetEarth) ? BlocksDBC.BlockDragonBall : ((did == DBCConfig.planetNamek) ? BlocksDBC.BlockNamekDragonBall : null);
/* 261 */           Block blockID = null;
/* 262 */           int dbnum = 0;
/*     */           
/* 264 */           int l1 = MathHelper.func_76128_c(player.field_70165_t);
/* 265 */           int i11 = MathHelper.func_76128_c(player.field_70161_v);
/* 266 */           for (int j11 = l1 - m; j11 <= l1 + m; j11++) {
/* 267 */             for (int j2 = i11 - m; j2 <= i11 + m; j2++) {
/* 268 */               for (int k2 = 109; k2 >= 64; k2--) {
/* 269 */                 if (player.field_70170_p.func_147439_a(j11, k2, j2) == db) {
/* 270 */                   dbnum++;
/*     */                 }
/* 272 */                 if (player.field_70170_p.func_147439_a(j11, k2, j2) == dbs) {
/* 273 */                   dbnum++;
/*     */                 }
/*     */               } 
/*     */             } 
/*     */           } 
/* 278 */           int i = MathHelper.func_76128_c(player.field_70165_t + player.field_70170_p.field_73012_v.nextInt(m) + (player.field_70170_p.field_73012_v.nextInt(m) * -1));
/*     */           
/* 280 */           int k = MathHelper.func_76128_c(player.field_70161_v + player.field_70170_p.field_73012_v.nextInt(m) + (player.field_70170_p.field_73012_v.nextInt(m) * -1));
/* 281 */           for (int j = 109; j >= 64; j--) {
/* 282 */             if (!player.field_70170_p.func_147437_c(i, j, k) && player.field_70170_p
/* 283 */               .func_147439_a(i, j, k) != dbs && player.field_70170_p
/* 284 */               .func_147439_a(i, j, k) != db && (player.field_70170_p
/* 285 */               .func_147439_a(i, j, k) == Blocks.field_150349_c || player.field_70170_p
/* 286 */               .func_147439_a(i, j, k) == Blocks.field_150354_m || player.field_70170_p
/* 287 */               .func_147439_a(i, j, k) == BlocksDBC.BlockNamekGrass) && dbnum < mod_DragonBC.DBSpawnChance) {
/*     */ 
/*     */ 
/*     */               
/* 291 */               player.field_70170_p.func_147465_d(i, j + 1, k, dbs, 0, 3);
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/* 300 */   private static boolean DBTime(String s) { return mod_DragonBC.DBSpawnTime.contains(s); } public static void packDuo(int t, int i) {
/* 301 */     PD.sendToServer((IMessage)new DBCPduo(t, i));
/*     */   }
/* 303 */   public static int planetEarth = 0;
/* 304 */   public static int planetNamek = 20;
/* 305 */   public static int planetVegeta = 21;
/* 306 */   public static int otherWorld = 22;
/* 307 */   public static int dimTimeChamber = 23;
/* 308 */   public static int dimNullRealm = 24;
/* 309 */   public static HashMap<Integer, String> plntNms = new HashMap<Integer, String>();
/*     */   public static void plntNmsInit() {
/* 311 */     plntNms.put(Integer.valueOf(DBCConfig.planetEarth), "Earth");
/* 312 */     plntNms.put(Integer.valueOf(DBCConfig.planetNamek), "Namek");
/* 313 */     plntNms.put(Integer.valueOf(DBCConfig.planetVegeta), "Vegeta");
/* 314 */     plntNms.put(Integer.valueOf(DBCConfig.otherWorld), "OtherWorld");
/* 315 */     plntNms.put(Integer.valueOf(DBCConfig.dimTimeChamber), "TimeChamber");
/* 316 */     plntNms.put(Integer.valueOf(DBCConfig.dimNullRealm), "Null Realm");
/*     */   }
/* 318 */   public static ArrayList<String> wishS = new ArrayList<String>();
/* 319 */   public static ArrayList<String> wishP = new ArrayList<String>();
/* 320 */   public static int mult = 1;
/*     */   
/*     */   public static void wishInit() {
/* 323 */     wishS.add("minecraft:diamond;+;" + (3 * mult) + ";+;0");
/* 324 */     wishS.add("jinryuudragonblockc:ItemAlienTechChipTier1;+;" + (3 * mult) + ";+;0");
/* 325 */     wishS.add("jinryuudragonblockc:ItemWarenai;+;" + (5 * mult) + ";+;0");
/* 326 */     wishS.add("jinryuudragonblockc:ItemSenzu;+;" + (3 * mult) + ";+;0");
/* 327 */     wishS.add("jinryuudragonblockc:ItemKatchin;+;" + (1 * mult) + ";+;0");
/* 328 */     wishS.add("revive");
/* 329 */     wishS.add("reviventp");
/* 330 */     wishS.add("reviveall");
/* 331 */     wishS.add("kicolor");
/*     */     
/* 333 */     wishS.add("arcultformcolor");
/* 334 */     if (JRMCoreH.JYC()) {
/* 335 */       wishS.add("young");
/* 336 */       wishS.add("child");
/* 337 */       wishS.add("old");
/*     */     } 
/* 339 */     wishS.add("jinryuudragonblockc:ItemJanembaEssence;+;" + (5 * mult) + ";+;0");
/* 340 */     wishS.add("jinryuudragonblockc:ItemSmallClub;+;" + (1 * mult) + ";+;0");
/* 341 */     wishP.add("jinryuudragonblockc:ItemEvilSpear;+;" + (1 * mult) + ";+;0");
/* 342 */     wishS.add("jinryuudragonblockc:ItemPP;+;" + (1 * mult) + ";+;0");
/*     */     
/* 344 */     wishP.add("minecraft:diamond;+;" + (3 * mult) + ";+;0");
/* 345 */     wishP.add("jinryuudragonblockc:ItemAlienTechChipTier1;+;" + (3 * mult) + ";+;0");
/* 346 */     wishP.add("jinryuudragonblockc:ItemWarenai;+;" + (5 * mult) + ";+;0");
/* 347 */     wishP.add("jinryuudragonblockc:ItemSenzu;+;" + (3 * mult) + ";+;0");
/* 348 */     wishP.add("jinryuudragonblockc:ItemKatchin;+;" + (1 * mult) + ";+;0");
/* 349 */     wishP.add("revive");
/* 350 */     wishP.add("reviventp");
/*     */     
/* 352 */     wishP.add("kicolor");
/* 353 */     wishP.add("arcultformcolor");
/* 354 */     if (JRMCoreH.JYC()) {
/* 355 */       wishP.add("young");
/* 356 */       wishP.add("child");
/* 357 */       wishP.add("old");
/*     */     } 
/* 359 */     wishP.add("jinryuudragonblockc:ItemJanembaEssence;+;" + (5 * mult) + ";+;0");
/* 360 */     wishP.add("jinryuudragonblockc:ItemSmallClub;+;" + (1 * mult) + ";+;0");
/*     */   }
/*     */   public static void toDrop(int o, LivingDropsEvent e) {
/* 363 */     EntityLivingBase entityLivingBase = e.entityLiving;
/* 364 */     int r = e.entityLiving.field_70170_p.field_73012_v.nextInt(100);
/* 365 */     Item[] i = (r < 5) ? ItemsDBC.ItemsOutfit1 : ((r < 10) ? ItemsDBC.ItemsOutfit2 : ((r < 15) ? ItemsDBC.ItemsOutfit3 : ItemsDBC.ItemsOutfit0));
/* 366 */     ItemStack stack = new ItemStack(i[o], 1, 1);
/* 367 */     if (r < 20 && stack != null && stack.field_77994_a != 0 && stack.func_77973_b() != null) {
/*     */       
/* 369 */       EntityItem entityitem = new EntityItem(((Entity)entityLivingBase).field_70170_p, ((Entity)entityLivingBase).field_70165_t, ((Entity)entityLivingBase).field_70163_u, ((Entity)entityLivingBase).field_70161_v, stack);
/* 370 */       entityitem.field_145804_b = 10;
/* 371 */       e.drops.add(entityitem);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void onEventDrop(LivingDropsEvent e) {
/* 379 */     if (e.entityLiving instanceof JinRyuu.DragonBC.common.Npcs.EntityCyborg16) toDrop(0, e); 
/* 380 */     if (e.entityLiving instanceof JinRyuu.DragonBC.common.Npcs.EntityCyborg17) toDrop(1, e); 
/* 381 */     if (e.entityLiving instanceof JinRyuu.DragonBC.common.Npcs.EntityCyborg18) toDrop(2, e); 
/* 382 */     if (e.entityLiving instanceof JinRyuu.DragonBC.common.Npcs.EntityCyborg19) toDrop(3, e); 
/* 383 */     if (e.entityLiving instanceof JinRyuu.DragonBC.common.Npcs.EntityCyborg20) toDrop(4, e); 
/* 384 */     if (e.entityLiving instanceof JinRyuu.DragonBC.common.Npcs.EntityDarbura) toDrop(5, e); 
/* 385 */     if (e.entityLiving instanceof JinRyuu.DragonBC.common.Npcs.EntityBuuFat) toDrop(6, e); 
/* 386 */     if (e.entityLiving instanceof JinRyuu.DragonBC.common.Npcs.EntityBuuSuper) toDrop(7, e); 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\DBCH.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */