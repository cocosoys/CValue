/*     */ package net.minecraft.server.integrated;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.concurrent.Callable;
/*     */ import net.minecraft.client.ClientBrandRetriever;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.multiplayer.ThreadLanServerPing;
/*     */ import net.minecraft.crash.CrashReport;
/*     */ import net.minecraft.profiler.PlayerUsageSnooper;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.CryptManager;
/*     */ import net.minecraft.util.HttpUtil;
/*     */ import net.minecraft.world.EnumDifficulty;
/*     */ import net.minecraft.world.IWorldAccess;
/*     */ import net.minecraft.world.WorldManager;
/*     */ import net.minecraft.world.WorldServer;
/*     */ import net.minecraft.world.WorldServerMulti;
/*     */ import net.minecraft.world.WorldSettings;
/*     */ import net.minecraft.world.WorldType;
/*     */ import net.minecraft.world.demo.DemoWorldServer;
/*     */ import net.minecraft.world.storage.ISaveHandler;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class IntegratedServer extends MinecraftServer {
/*  30 */   private static final Logger field_147148_h = LogManager.getLogger();
/*     */   
/*     */   private final Minecraft field_71349_l;
/*     */   
/*     */   private final WorldSettings field_71350_m;
/*     */   private boolean field_71348_o;
/*     */   
/*     */   public IntegratedServer(Minecraft p_i1317_1_, String p_i1317_2_, String p_i1317_3_, WorldSettings p_i1317_4_) {
/*  38 */     super(new File(p_i1317_1_.field_71412_D, "saves"), p_i1317_1_.func_110437_J());
/*     */     
/*  40 */     func_71224_l(p_i1317_1_.func_110432_I().func_111285_a());
/*  41 */     func_71261_m(p_i1317_2_);
/*  42 */     func_71246_n(p_i1317_3_);
/*  43 */     func_71204_b(p_i1317_1_.func_71355_q());
/*  44 */     func_71194_c(p_i1317_4_.func_77167_c());
/*  45 */     func_71191_d(256);
/*  46 */     func_152361_a(new IntegratedPlayerList(this));
/*     */     
/*  48 */     this.field_71349_l = p_i1317_1_;
/*  49 */     this.field_71350_m = p_i1317_4_;
/*     */   }
/*     */   private boolean field_71346_p; private ThreadLanServerPing field_71345_q; private static final String __OBFID = "CL_00001129";
/*     */   
/*     */   protected void func_71247_a(String p_71247_1_, String p_71247_2_, long p_71247_3_, WorldType p_71247_5_, String p_71247_6_) {
/*  54 */     func_71237_c(p_71247_1_);
/*     */     
/*  56 */     this.field_71305_c = new WorldServer[3];
/*  57 */     this.field_71312_k = new long[this.field_71305_c.length][100];
/*     */     
/*  59 */     ISaveHandler iSaveHandler = func_71254_M().func_75804_a(p_71247_1_, true);
/*     */     
/*  61 */     for (byte b = 0; b < this.field_71305_c.length; b++) {
/*  62 */       byte b1 = 0;
/*  63 */       if (b == 1) b1 = -1; 
/*  64 */       if (b == 2) b1 = 1;
/*     */       
/*  66 */       if (b == 0) {
/*  67 */         if (func_71242_L()) {
/*  68 */           this.field_71305_c[b] = (WorldServer)new DemoWorldServer(this, iSaveHandler, p_71247_2_, b1, this.field_71304_b);
/*     */         } else {
/*  70 */           this.field_71305_c[b] = new WorldServer(this, iSaveHandler, p_71247_2_, b1, this.field_71350_m, this.field_71304_b);
/*     */         } 
/*     */       } else {
/*  73 */         this.field_71305_c[b] = (WorldServer)new WorldServerMulti(this, iSaveHandler, p_71247_2_, b1, this.field_71350_m, this.field_71305_c[0], this.field_71304_b);
/*     */       } 
/*     */       
/*  76 */       this.field_71305_c[b].func_72954_a((IWorldAccess)new WorldManager(this, this.field_71305_c[b]));
/*     */       
/*  78 */       func_71203_ab().func_72364_a(this.field_71305_c);
/*     */     } 
/*     */     
/*  81 */     func_147139_a(func_147135_j());
/*     */     
/*  83 */     func_71222_d();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean func_71197_b() throws IOException {
/*  88 */     field_147148_h.info("Starting integrated minecraft server version 1.7.10");
/*     */     
/*  90 */     func_71229_d(true);
/*  91 */     func_71251_e(true);
/*  92 */     func_71257_f(true);
/*  93 */     func_71188_g(true);
/*  94 */     func_71245_h(true);
/*     */     
/*  96 */     field_147148_h.info("Generating keypair");
/*  97 */     func_71253_a(CryptManager.func_75891_b());
/*     */     
/*  99 */     func_71247_a(func_71270_I(), func_71221_J(), this.field_71350_m.func_77160_d(), this.field_71350_m.func_77165_h(), this.field_71350_m.func_82749_j());
/* 100 */     func_71205_p(func_71214_G() + " - " + this.field_71305_c[0].func_72912_H().func_76065_j());
/*     */     
/* 102 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71217_p() {
/* 107 */     boolean bool = this.field_71348_o;
/* 108 */     this.field_71348_o = (Minecraft.func_71410_x().func_147114_u() != null && Minecraft.func_71410_x().func_147113_T());
/*     */     
/* 110 */     if (!bool && this.field_71348_o) {
/* 111 */       field_147148_h.info("Saving and pausing game...");
/* 112 */       func_71203_ab().func_72389_g();
/* 113 */       func_71267_a(false);
/*     */     } 
/*     */     
/* 116 */     if (!this.field_71348_o) {
/* 117 */       super.func_71217_p();
/*     */       
/* 119 */       if (this.field_71349_l.field_71474_y.field_151451_c != func_71203_ab().func_72395_o()) {
/* 120 */         field_147148_h.info("Changing view distance to {}, from {}", new Object[] { Integer.valueOf(this.field_71349_l.field_71474_y.field_151451_c), Integer.valueOf(func_71203_ab().func_72395_o()) });
/* 121 */         func_71203_ab().func_152611_a(this.field_71349_l.field_71474_y.field_151451_c);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_71225_e() {
/* 128 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public WorldSettings.GameType func_71265_f() {
/* 133 */     return this.field_71350_m.func_77162_e();
/*     */   }
/*     */ 
/*     */   
/*     */   public EnumDifficulty func_147135_j() {
/* 138 */     return this.field_71349_l.field_71474_y.field_74318_M;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_71199_h() {
/* 143 */     return this.field_71350_m.func_77158_f();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_152363_m() {
/* 148 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected File func_71238_n() {
/* 153 */     return this.field_71349_l.field_71412_D;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_71262_S() {
/* 158 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_71228_a(CrashReport p_71228_1_) {
/* 163 */     this.field_71349_l.func_71404_a(p_71228_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public CrashReport func_71230_b(CrashReport p_71230_1_) {
/* 168 */     p_71230_1_ = super.func_71230_b(p_71230_1_);
/*     */     
/* 170 */     p_71230_1_.func_85056_g().func_71500_a("Type", new Callable(this) { private static final String __OBFID = "CL_00001130";
/*     */           
/*     */           public String call() {
/* 173 */             return "Integrated Server (map_client.txt)";
/*     */           } }
/*     */       );
/*     */     
/* 177 */     p_71230_1_.func_85056_g().func_71500_a("Is Modded", new Callable(this) { private static final String __OBFID = "CL_00001131";
/*     */           
/*     */           public String call() {
/* 180 */             String str = ClientBrandRetriever.getClientModName();
/* 181 */             if (!str.equals("vanilla")) return "Definitely; Client brand changed to '" + str + "'";
/*     */             
/* 183 */             str = this.field_76972_a.getServerModName();
/* 184 */             if (!str.equals("vanilla")) return "Definitely; Server brand changed to '" + str + "'";
/*     */             
/* 186 */             if (Minecraft.class.getSigners() == null) return "Very likely; Jar signature invalidated"; 
/* 187 */             return "Probably not. Jar signature remains and both client + server brands are untouched.";
/*     */           } }
/*     */       );
/*     */     
/* 191 */     return p_71230_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70000_a(PlayerUsageSnooper p_70000_1_) {
/* 196 */     super.func_70000_a(p_70000_1_);
/*     */     
/* 198 */     p_70000_1_.func_152768_a("snooper_partner", this.field_71349_l.func_71378_E().func_80006_f());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70002_Q() {
/* 203 */     return Minecraft.func_71410_x().func_70002_Q();
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_71206_a(WorldSettings.GameType p_71206_1_, boolean p_71206_2_) {
/*     */     try {
/* 209 */       int i = -1;
/*     */       
/*     */       try {
/* 212 */         i = HttpUtil.func_76181_a();
/* 213 */       } catch (IOException iOException) {}
/*     */       
/* 215 */       if (i <= 0) i = 25564;
/*     */       
/* 217 */       func_147137_ag().func_151265_a(null, i);
/* 218 */       field_147148_h.info("Started on " + i);
/* 219 */       this.field_71346_p = true;
/*     */       
/* 221 */       this.field_71345_q = new ThreadLanServerPing(func_71273_Y(), i + "");
/* 222 */       this.field_71345_q.start();
/*     */       
/* 224 */       func_71203_ab().func_152604_a(p_71206_1_);
/* 225 */       func_71203_ab().func_72387_b(p_71206_2_);
/*     */       
/* 227 */       return i + "";
/* 228 */     } catch (IOException iOException) {
/*     */       
/* 230 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_71260_j() {
/* 235 */     super.func_71260_j();
/*     */     
/* 237 */     if (this.field_71345_q != null) {
/* 238 */       this.field_71345_q.interrupt();
/* 239 */       this.field_71345_q = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71263_m() {
/* 245 */     super.func_71263_m();
/*     */     
/* 247 */     if (this.field_71345_q != null) {
/* 248 */       this.field_71345_q.interrupt();
/* 249 */       this.field_71345_q = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean func_71344_c() {
/* 254 */     return this.field_71346_p;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71235_a(WorldSettings.GameType p_71235_1_) {
/* 259 */     func_71203_ab().func_152604_a(p_71235_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_82356_Z() {
/* 264 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_110455_j() {
/* 269 */     return 4;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\server\integrated\IntegratedServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */