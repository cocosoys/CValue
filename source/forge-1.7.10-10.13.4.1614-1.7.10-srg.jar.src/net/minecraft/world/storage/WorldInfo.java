/*     */ package net.minecraft.world.storage;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.concurrent.Callable;
/*     */ import net.minecraft.crash.CrashReportCategory;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.world.GameRules;
/*     */ import net.minecraft.world.WorldSettings;
/*     */ import net.minecraft.world.WorldType;
/*     */ 
/*     */ public class WorldInfo {
/*  14 */   private WorldType field_76098_b = WorldType.field_77137_b; private long field_76100_a;
/*  15 */   private String field_82576_c = "";
/*     */   
/*     */   private int field_76099_c;
/*     */   
/*     */   private int field_76096_d;
/*     */   
/*     */   private int field_76097_e;
/*     */   private long field_82575_g;
/*     */   private long field_76094_f;
/*     */   private long field_76095_g;
/*     */   private long field_76107_h;
/*     */   private NBTTagCompound field_76108_i;
/*     */   private int field_76105_j;
/*     */   private String field_76106_k;
/*     */   private int field_76103_l;
/*     */   private boolean field_76104_m;
/*     */   private int field_76101_n;
/*     */   private boolean field_76102_o;
/*     */   private int field_76114_p;
/*     */   private WorldSettings.GameType field_76113_q;
/*     */   private boolean field_76112_r;
/*     */   private boolean field_76111_s;
/*     */   private boolean field_76110_t;
/*     */   private boolean field_76109_u;
/*  39 */   private GameRules field_82577_x = new GameRules();
/*     */ 
/*     */   
/*     */   private static final String __OBFID = "CL_00000587";
/*     */ 
/*     */ 
/*     */   
/*     */   public WorldInfo(NBTTagCompound p_i2157_1_) {
/*  47 */     this.field_76100_a = p_i2157_1_.func_74763_f("RandomSeed");
/*  48 */     if (p_i2157_1_.func_150297_b("generatorName", 8)) {
/*  49 */       String str = p_i2157_1_.func_74779_i("generatorName");
/*  50 */       this.field_76098_b = WorldType.func_77130_a(str);
/*  51 */       if (this.field_76098_b == null) {
/*  52 */         this.field_76098_b = WorldType.field_77137_b;
/*  53 */       } else if (this.field_76098_b.func_77125_e()) {
/*  54 */         int i = 0;
/*  55 */         if (p_i2157_1_.func_150297_b("generatorVersion", 99)) {
/*  56 */           i = p_i2157_1_.func_74762_e("generatorVersion");
/*     */         }
/*  58 */         this.field_76098_b = this.field_76098_b.func_77132_a(i);
/*     */       } 
/*     */       
/*  61 */       if (p_i2157_1_.func_150297_b("generatorOptions", 8)) this.field_82576_c = p_i2157_1_.func_74779_i("generatorOptions"); 
/*     */     } 
/*  63 */     this.field_76113_q = WorldSettings.GameType.func_77146_a(p_i2157_1_.func_74762_e("GameType"));
/*  64 */     if (p_i2157_1_.func_150297_b("MapFeatures", 99)) {
/*  65 */       this.field_76112_r = p_i2157_1_.func_74767_n("MapFeatures");
/*     */     } else {
/*  67 */       this.field_76112_r = true;
/*     */     } 
/*  69 */     this.field_76099_c = p_i2157_1_.func_74762_e("SpawnX");
/*  70 */     this.field_76096_d = p_i2157_1_.func_74762_e("SpawnY");
/*  71 */     this.field_76097_e = p_i2157_1_.func_74762_e("SpawnZ");
/*  72 */     this.field_82575_g = p_i2157_1_.func_74763_f("Time");
/*  73 */     if (p_i2157_1_.func_150297_b("DayTime", 99)) {
/*  74 */       this.field_76094_f = p_i2157_1_.func_74763_f("DayTime");
/*     */     } else {
/*  76 */       this.field_76094_f = this.field_82575_g;
/*     */     } 
/*  78 */     this.field_76095_g = p_i2157_1_.func_74763_f("LastPlayed");
/*  79 */     this.field_76107_h = p_i2157_1_.func_74763_f("SizeOnDisk");
/*  80 */     this.field_76106_k = p_i2157_1_.func_74779_i("LevelName");
/*  81 */     this.field_76103_l = p_i2157_1_.func_74762_e("version");
/*  82 */     this.field_76101_n = p_i2157_1_.func_74762_e("rainTime");
/*  83 */     this.field_76104_m = p_i2157_1_.func_74767_n("raining");
/*  84 */     this.field_76114_p = p_i2157_1_.func_74762_e("thunderTime");
/*  85 */     this.field_76102_o = p_i2157_1_.func_74767_n("thundering");
/*  86 */     this.field_76111_s = p_i2157_1_.func_74767_n("hardcore");
/*     */     
/*  88 */     if (p_i2157_1_.func_150297_b("initialized", 99)) {
/*  89 */       this.field_76109_u = p_i2157_1_.func_74767_n("initialized");
/*     */     } else {
/*  91 */       this.field_76109_u = true;
/*     */     } 
/*     */     
/*  94 */     if (p_i2157_1_.func_150297_b("allowCommands", 99)) {
/*  95 */       this.field_76110_t = p_i2157_1_.func_74767_n("allowCommands");
/*     */     } else {
/*  97 */       this.field_76110_t = (this.field_76113_q == WorldSettings.GameType.CREATIVE);
/*     */     } 
/*     */     
/* 100 */     if (p_i2157_1_.func_150297_b("Player", 10)) {
/* 101 */       this.field_76108_i = p_i2157_1_.func_74775_l("Player");
/* 102 */       this.field_76105_j = this.field_76108_i.func_74762_e("Dimension");
/*     */     } 
/*     */     
/* 105 */     if (p_i2157_1_.func_150297_b("GameRules", 10)) {
/* 106 */       this.field_82577_x.func_82768_a(p_i2157_1_.func_74775_l("GameRules"));
/*     */     }
/*     */   }
/*     */   
/*     */   public WorldInfo(WorldSettings p_i2158_1_, String p_i2158_2_) {
/* 111 */     this.field_76100_a = p_i2158_1_.func_77160_d();
/* 112 */     this.field_76113_q = p_i2158_1_.func_77162_e();
/* 113 */     this.field_76112_r = p_i2158_1_.func_77164_g();
/* 114 */     this.field_76106_k = p_i2158_2_;
/* 115 */     this.field_76111_s = p_i2158_1_.func_77158_f();
/* 116 */     this.field_76098_b = p_i2158_1_.func_77165_h();
/* 117 */     this.field_82576_c = p_i2158_1_.func_82749_j();
/* 118 */     this.field_76110_t = p_i2158_1_.func_77163_i();
/* 119 */     this.field_76109_u = false;
/*     */   }
/*     */   
/*     */   public WorldInfo(WorldInfo p_i2159_1_) {
/* 123 */     this.field_76100_a = p_i2159_1_.field_76100_a;
/* 124 */     this.field_76098_b = p_i2159_1_.field_76098_b;
/* 125 */     this.field_82576_c = p_i2159_1_.field_82576_c;
/* 126 */     this.field_76113_q = p_i2159_1_.field_76113_q;
/* 127 */     this.field_76112_r = p_i2159_1_.field_76112_r;
/* 128 */     this.field_76099_c = p_i2159_1_.field_76099_c;
/* 129 */     this.field_76096_d = p_i2159_1_.field_76096_d;
/* 130 */     this.field_76097_e = p_i2159_1_.field_76097_e;
/* 131 */     this.field_82575_g = p_i2159_1_.field_82575_g;
/* 132 */     this.field_76094_f = p_i2159_1_.field_76094_f;
/* 133 */     this.field_76095_g = p_i2159_1_.field_76095_g;
/* 134 */     this.field_76107_h = p_i2159_1_.field_76107_h;
/* 135 */     this.field_76108_i = p_i2159_1_.field_76108_i;
/* 136 */     this.field_76105_j = p_i2159_1_.field_76105_j;
/* 137 */     this.field_76106_k = p_i2159_1_.field_76106_k;
/* 138 */     this.field_76103_l = p_i2159_1_.field_76103_l;
/* 139 */     this.field_76101_n = p_i2159_1_.field_76101_n;
/* 140 */     this.field_76104_m = p_i2159_1_.field_76104_m;
/* 141 */     this.field_76114_p = p_i2159_1_.field_76114_p;
/* 142 */     this.field_76102_o = p_i2159_1_.field_76102_o;
/* 143 */     this.field_76111_s = p_i2159_1_.field_76111_s;
/* 144 */     this.field_76110_t = p_i2159_1_.field_76110_t;
/* 145 */     this.field_76109_u = p_i2159_1_.field_76109_u;
/* 146 */     this.field_82577_x = p_i2159_1_.field_82577_x;
/*     */   }
/*     */   
/*     */   public NBTTagCompound func_76066_a() {
/* 150 */     NBTTagCompound nBTTagCompound = new NBTTagCompound();
/*     */     
/* 152 */     func_76064_a(nBTTagCompound, this.field_76108_i);
/*     */     
/* 154 */     return nBTTagCompound;
/*     */   }
/*     */   
/*     */   public NBTTagCompound func_76082_a(NBTTagCompound p_76082_1_) {
/* 158 */     NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 159 */     func_76064_a(nBTTagCompound, p_76082_1_);
/*     */     
/* 161 */     return nBTTagCompound;
/*     */   }
/*     */   
/*     */   private void func_76064_a(NBTTagCompound p_76064_1_, NBTTagCompound p_76064_2_) {
/* 165 */     p_76064_1_.func_74772_a("RandomSeed", this.field_76100_a);
/* 166 */     p_76064_1_.func_74778_a("generatorName", this.field_76098_b.func_77127_a());
/* 167 */     p_76064_1_.func_74768_a("generatorVersion", this.field_76098_b.func_77131_c());
/* 168 */     p_76064_1_.func_74778_a("generatorOptions", this.field_82576_c);
/* 169 */     p_76064_1_.func_74768_a("GameType", this.field_76113_q.func_77148_a());
/* 170 */     p_76064_1_.func_74757_a("MapFeatures", this.field_76112_r);
/* 171 */     p_76064_1_.func_74768_a("SpawnX", this.field_76099_c);
/* 172 */     p_76064_1_.func_74768_a("SpawnY", this.field_76096_d);
/* 173 */     p_76064_1_.func_74768_a("SpawnZ", this.field_76097_e);
/* 174 */     p_76064_1_.func_74772_a("Time", this.field_82575_g);
/* 175 */     p_76064_1_.func_74772_a("DayTime", this.field_76094_f);
/* 176 */     p_76064_1_.func_74772_a("SizeOnDisk", this.field_76107_h);
/* 177 */     p_76064_1_.func_74772_a("LastPlayed", MinecraftServer.func_130071_aq());
/* 178 */     p_76064_1_.func_74778_a("LevelName", this.field_76106_k);
/* 179 */     p_76064_1_.func_74768_a("version", this.field_76103_l);
/* 180 */     p_76064_1_.func_74768_a("rainTime", this.field_76101_n);
/* 181 */     p_76064_1_.func_74757_a("raining", this.field_76104_m);
/* 182 */     p_76064_1_.func_74768_a("thunderTime", this.field_76114_p);
/* 183 */     p_76064_1_.func_74757_a("thundering", this.field_76102_o);
/* 184 */     p_76064_1_.func_74757_a("hardcore", this.field_76111_s);
/* 185 */     p_76064_1_.func_74757_a("allowCommands", this.field_76110_t);
/* 186 */     p_76064_1_.func_74757_a("initialized", this.field_76109_u);
/* 187 */     p_76064_1_.func_74782_a("GameRules", (NBTBase)this.field_82577_x.func_82770_a());
/*     */     
/* 189 */     if (p_76064_2_ != null) {
/* 190 */       p_76064_1_.func_74782_a("Player", (NBTBase)p_76064_2_);
/*     */     }
/*     */   }
/*     */   
/*     */   public long func_76063_b() {
/* 195 */     return this.field_76100_a;
/*     */   }
/*     */   
/*     */   public int func_76079_c() {
/* 199 */     return this.field_76099_c;
/*     */   }
/*     */   
/*     */   public int func_76075_d() {
/* 203 */     return this.field_76096_d;
/*     */   }
/*     */   
/*     */   public int func_76074_e() {
/* 207 */     return this.field_76097_e;
/*     */   }
/*     */   
/*     */   public long func_82573_f() {
/* 211 */     return this.field_82575_g;
/*     */   }
/*     */   
/*     */   public long func_76073_f() {
/* 215 */     return this.field_76094_f;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public long func_76092_g() {
/* 219 */     return this.field_76107_h;
/*     */   }
/*     */   
/*     */   public NBTTagCompound func_76072_h() {
/* 223 */     return this.field_76108_i;
/*     */   }
/*     */   
/*     */   public int func_76076_i() {
/* 227 */     return this.field_76105_j;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_76058_a(int p_76058_1_) {
/* 235 */     this.field_76099_c = p_76058_1_;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_76056_b(int p_76056_1_) {
/* 239 */     this.field_76096_d = p_76056_1_;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_76087_c(int p_76087_1_) {
/* 243 */     this.field_76097_e = p_76087_1_;
/*     */   }
/*     */   
/*     */   public void func_82572_b(long p_82572_1_) {
/* 247 */     this.field_82575_g = p_82572_1_;
/*     */   }
/*     */   
/*     */   public void func_76068_b(long p_76068_1_) {
/* 251 */     this.field_76094_f = p_76068_1_;
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
/*     */   public void func_76081_a(int p_76081_1_, int p_76081_2_, int p_76081_3_) {
/* 267 */     this.field_76099_c = p_76081_1_;
/* 268 */     this.field_76096_d = p_76081_2_;
/* 269 */     this.field_76097_e = p_76081_3_;
/*     */   }
/*     */   
/*     */   public String func_76065_j() {
/* 273 */     return this.field_76106_k;
/*     */   }
/*     */   
/*     */   public void func_76062_a(String p_76062_1_) {
/* 277 */     this.field_76106_k = p_76062_1_;
/*     */   }
/*     */   
/*     */   public int func_76088_k() {
/* 281 */     return this.field_76103_l;
/*     */   }
/*     */   
/*     */   public void func_76078_e(int p_76078_1_) {
/* 285 */     this.field_76103_l = p_76078_1_;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public long func_76057_l() {
/* 289 */     return this.field_76095_g;
/*     */   }
/*     */   
/*     */   public boolean func_76061_m() {
/* 293 */     return this.field_76102_o;
/*     */   }
/*     */   
/*     */   public void func_76069_a(boolean p_76069_1_) {
/* 297 */     this.field_76102_o = p_76069_1_;
/*     */   }
/*     */   
/*     */   public int func_76071_n() {
/* 301 */     return this.field_76114_p;
/*     */   }
/*     */   
/*     */   public void func_76090_f(int p_76090_1_) {
/* 305 */     this.field_76114_p = p_76090_1_;
/*     */   }
/*     */   
/*     */   public boolean func_76059_o() {
/* 309 */     return this.field_76104_m;
/*     */   }
/*     */   
/*     */   public void func_76084_b(boolean p_76084_1_) {
/* 313 */     this.field_76104_m = p_76084_1_;
/*     */   }
/*     */   
/*     */   public int func_76083_p() {
/* 317 */     return this.field_76101_n;
/*     */   }
/*     */   
/*     */   public void func_76080_g(int p_76080_1_) {
/* 321 */     this.field_76101_n = p_76080_1_;
/*     */   }
/*     */   
/*     */   public WorldSettings.GameType func_76077_q() {
/* 325 */     return this.field_76113_q;
/*     */   }
/*     */   
/*     */   public boolean func_76089_r() {
/* 329 */     return this.field_76112_r;
/*     */   }
/*     */   
/*     */   public void func_76060_a(WorldSettings.GameType p_76060_1_) {
/* 333 */     this.field_76113_q = p_76060_1_;
/*     */   }
/*     */   
/*     */   public boolean func_76093_s() {
/* 337 */     return this.field_76111_s;
/*     */   }
/*     */   
/*     */   public WorldType func_76067_t() {
/* 341 */     return this.field_76098_b;
/*     */   }
/*     */   
/*     */   public void func_76085_a(WorldType p_76085_1_) {
/* 345 */     this.field_76098_b = p_76085_1_;
/*     */   }
/*     */   
/*     */   public String func_82571_y() {
/* 349 */     return this.field_82576_c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_76086_u() {
/* 357 */     return this.field_76110_t;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_76070_v() {
/* 365 */     return this.field_76109_u;
/*     */   }
/*     */   
/*     */   public void func_76091_d(boolean p_76091_1_) {
/* 369 */     this.field_76109_u = p_76091_1_;
/*     */   }
/*     */   
/*     */   public GameRules func_82574_x() {
/* 373 */     return this.field_82577_x;
/*     */   }
/*     */   
/*     */   public void func_85118_a(CrashReportCategory p_85118_1_) {
/* 377 */     p_85118_1_.func_71500_a("Level seed", new Callable(this) { private static final String __OBFID = "CL_00000588";
/*     */           
/*     */           public String call() {
/* 380 */             return String.valueOf(this.field_85143_a.func_76063_b());
/*     */           } }
/*     */       );
/*     */     
/* 384 */     p_85118_1_.func_71500_a("Level generator", new Callable(this) { private static final String __OBFID = "CL_00000589";
/*     */           
/*     */           public String call() {
/* 387 */             return String.format("ID %02d - %s, ver %d. Features enabled: %b", new Object[] { Integer.valueOf(WorldInfo.access$000(this.field_85139_a).func_82747_f()), WorldInfo.access$000(this.field_85139_a).func_77127_a(), Integer.valueOf(WorldInfo.access$000(this.field_85139_a).func_77131_c()), Boolean.valueOf(WorldInfo.access$100(this.field_85139_a)) });
/*     */           } }
/*     */       );
/*     */     
/* 391 */     p_85118_1_.func_71500_a("Level generator options", new Callable(this) { private static final String __OBFID = "CL_00000590";
/*     */           
/*     */           public String call() {
/* 394 */             return this.field_85141_a.field_82576_c;
/*     */           } }
/*     */       );
/*     */     
/* 398 */     p_85118_1_.func_71500_a("Level spawn location", new Callable(this) { private static final String __OBFID = "CL_00000591";
/*     */           
/*     */           public String call() {
/* 401 */             return CrashReportCategory.func_85071_a(this.field_85135_a.field_76099_c, this.field_85135_a.field_76096_d, this.field_85135_a.field_76097_e);
/*     */           } }
/*     */       );
/*     */     
/* 405 */     p_85118_1_.func_71500_a("Level time", new Callable(this) { private static final String __OBFID = "CL_00000592";
/*     */           
/*     */           public String call() {
/* 408 */             return String.format("%d game time, %d day time", new Object[] { Long.valueOf(WorldInfo.access$600(this.field_85137_a)), Long.valueOf(WorldInfo.access$700(this.field_85137_a)) });
/*     */           } }
/*     */       );
/*     */     
/* 412 */     p_85118_1_.func_71500_a("Level dimension", new Callable(this) { private static final String __OBFID = "CL_00000593";
/*     */           
/*     */           public String call() {
/* 415 */             return String.valueOf(this.field_85115_a.field_76105_j);
/*     */           } }
/*     */       );
/*     */     
/* 419 */     p_85118_1_.func_71500_a("Level storage version", new Callable(this) { private static final String __OBFID = "CL_00000594";
/*     */           
/*     */           public String call() {
/* 422 */             String str = "Unknown?";
/*     */             
/*     */             try {
/* 425 */               switch (this.field_85113_a.field_76103_l) {
/*     */                 case 19133:
/* 427 */                   str = "Anvil";
/*     */                   break;
/*     */                 case 19132:
/* 430 */                   str = "McRegion";
/*     */                   break;
/*     */               } 
/* 433 */             } catch (Throwable throwable) {}
/*     */ 
/*     */ 
/*     */             
/* 437 */             return String.format("0x%05X - %s", new Object[] { Integer.valueOf(WorldInfo.access$900(this.field_85113_a)), str });
/*     */           } }
/*     */       );
/*     */     
/* 441 */     p_85118_1_.func_71500_a("Level weather", new Callable(this) { private static final String __OBFID = "CL_00000595";
/*     */           
/*     */           public String call() {
/* 444 */             return String.format("Rain time: %d (now: %b), thunder time: %d (now: %b)", new Object[] { Integer.valueOf(WorldInfo.access$1000(this.field_85111_a)), Boolean.valueOf(WorldInfo.access$1100(this.field_85111_a)), Integer.valueOf(WorldInfo.access$1200(this.field_85111_a)), Boolean.valueOf(WorldInfo.access$1300(this.field_85111_a)) });
/*     */           } }
/*     */       );
/*     */     
/* 448 */     p_85118_1_.func_71500_a("Level game mode", new Callable(this) { private static final String __OBFID = "CL_00000597";
/*     */           
/*     */           public String call() {
/* 451 */             return String.format("Game mode: %s (ID %d). Hardcore: %b. Cheats: %b", new Object[] { WorldInfo.access$1400(this.field_85109_a).func_77149_b(), Integer.valueOf(WorldInfo.access$1400(this.field_85109_a).func_77148_a()), Boolean.valueOf(WorldInfo.access$1500(this.field_85109_a)), Boolean.valueOf(WorldInfo.access$1600(this.field_85109_a)) });
/*     */           } }
/*     */       );
/*     */   }
/*     */   
/*     */   protected WorldInfo() {}
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\storage\WorldInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */