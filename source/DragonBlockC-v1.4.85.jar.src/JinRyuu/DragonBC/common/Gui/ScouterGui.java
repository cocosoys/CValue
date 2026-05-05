/*      */ package JinRyuu.DragonBC.common.Gui;
/*      */ 
/*      */ import JinRyuu.DragonBC.common.Blocks.DBCMaterial;
/*      */ import JinRyuu.DragonBC.common.DBCClient;
/*      */ import JinRyuu.DragonBC.common.DBCClientTickHandler;
/*      */ import JinRyuu.DragonBC.common.DBCKiAttacks;
/*      */ import JinRyuu.DragonBC.common.Items.ItemsDBC;
/*      */ import JinRyuu.DragonBC.common.Npcs.EntityDBC;
/*      */ import JinRyuu.DragonBC.common.Npcs.EntityHell01;
/*      */ import JinRyuu.DragonBC.common.Npcs.EntityHell02;
/*      */ import JinRyuu.DragonBC.common.Npcs.EntityMasterEnma;
/*      */ import JinRyuu.DragonBC.common.Npcs.EntityNamekian01;
/*      */ import JinRyuu.DragonBC.common.Npcs.EntitySaiyan01;
/*      */ import JinRyuu.DragonBC.common.Npcs.EntitySaiyan02;
/*      */ import JinRyuu.JRMCore.JRMCoreH;
/*      */ import JinRyuu.JRMCore.i.ExtendedPlayer;
/*      */ import java.util.List;
/*      */ import java.util.Random;
/*      */ import net.minecraft.client.Minecraft;
/*      */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*      */ import net.minecraft.client.gui.FontRenderer;
/*      */ import net.minecraft.client.gui.Gui;
/*      */ import net.minecraft.client.gui.GuiIngame;
/*      */ import net.minecraft.client.gui.ScaledResolution;
/*      */ import net.minecraft.client.multiplayer.WorldClient;
/*      */ import net.minecraft.client.renderer.RenderHelper;
/*      */ import net.minecraft.client.renderer.Tessellator;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityCreature;
/*      */ import net.minecraft.entity.monster.EntityBlaze;
/*      */ import net.minecraft.entity.monster.EntityCaveSpider;
/*      */ import net.minecraft.entity.monster.EntityCreeper;
/*      */ import net.minecraft.entity.monster.EntityEnderman;
/*      */ import net.minecraft.entity.monster.EntityGhast;
/*      */ import net.minecraft.entity.monster.EntityGiantZombie;
/*      */ import net.minecraft.entity.monster.EntityMagmaCube;
/*      */ import net.minecraft.entity.monster.EntityMob;
/*      */ import net.minecraft.entity.monster.EntityPigZombie;
/*      */ import net.minecraft.entity.monster.EntitySilverfish;
/*      */ import net.minecraft.entity.monster.EntitySkeleton;
/*      */ import net.minecraft.entity.monster.EntitySlime;
/*      */ import net.minecraft.entity.monster.EntitySpider;
/*      */ import net.minecraft.entity.monster.EntityWitch;
/*      */ import net.minecraft.entity.monster.EntityZombie;
/*      */ import net.minecraft.entity.passive.EntityWolf;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.entity.player.EntityPlayerMP;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.util.AxisAlignedBB;
/*      */ import net.minecraft.util.ResourceLocation;
/*      */ import net.minecraft.util.Vec3;
/*      */ import org.lwjgl.opengl.GL11;
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ScouterGui
/*      */   extends Gui
/*      */ {
/*   60 */   protected FontRenderer fontRenderer = DBCClient.mc.field_71466_p;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   67 */   private Minecraft mc = DBCClient.mc;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private DBCClientTickHandler tick;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private GuiIngame Guiingame;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void initGui() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void ScFunctionsInit(int var6, int var7, int Tier) {
/*  132 */     ScouterRenderBlur(var6, var7);
/*  133 */     if (DBCClientTickHandler.ScFunc00 == 1) {
/*  134 */       ScouterIntro(var6, var7, Tier);
/*  135 */       this.textureFile = "jinryuudragonbc:misc/intro.png";
/*  136 */       ScouterRenderBlur(var6, var7);
/*      */     } 
/*  138 */     if (DBCClientTickHandler.ScFunc01 == 1) {
/*  139 */       ScouterFunction1(var6, var7, Tier);
/*  140 */       this.textureFile = "jinryuudragonbc:misc/func1.png";
/*  141 */       ScouterRenderBlur(var6, var7);
/*      */     } 
/*  143 */     if (DBCClientTickHandler.ScFunc02 == 1) {
/*  144 */       ScouterFunc2(var6, var7, Tier);
/*  145 */       this.textureFile = "jinryuudragonbc:misc/func2.png";
/*  146 */       ScouterRenderBlur(var6, var7);
/*      */     } 
/*  148 */     if (DBCClientTickHandler.ScFunc03 == 1) {
/*  149 */       ScouterFunc3(var6, var7, Tier);
/*  150 */       this.textureFile = "jinryuudragonbc:misc/func3.png";
/*  151 */       ScouterRenderBlur(var6, var7);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  158 */     if (DBCClientTickHandler.ScFunc04 == 1) {
/*  159 */       ScouterFunc2MP(var6, var7, Tier);
/*  160 */       this.textureFile = "jinryuudragonbc:misc/func2mp.png";
/*  161 */       ScouterRenderBlur(var6, var7);
/*      */     } 
/*  163 */     if (DBCClientTickHandler.ScFunc05 == 1) {
/*  164 */       ScouterFunc3MP(var6, var7, Tier);
/*  165 */       this.textureFile = "jinryuudragonbc:misc/func3mp.png";
/*  166 */       ScouterRenderBlur(var6, var7);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void renderKAC1() {
/*  172 */     ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
/*  173 */     int var6 = var5.func_78326_a();
/*  174 */     int var7 = var5.func_78328_b();
/*  175 */     FontRenderer var8 = this.mc.field_71466_p;
/*  176 */     this.mc.field_71460_t.func_78478_c();
/*      */ 
/*      */     
/*  179 */     this.textureFile = "jinryuudragonbc:misc/KAC1.png";
/*  180 */     ScouterRenderBlur(var6, var7);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void renderKAC2() {
/*  186 */     ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
/*  187 */     int var6 = var5.func_78326_a();
/*  188 */     int var7 = var5.func_78328_b();
/*  189 */     FontRenderer var8 = this.mc.field_71466_p;
/*  190 */     this.mc.field_71460_t.func_78478_c();
/*      */     
/*  192 */     this.textureFile = "jinryuudragonbc:misc/KAC2.png";
/*  193 */     ScouterRenderBlur(var6, var7);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void renderKAC3() {
/*  199 */     ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
/*  200 */     int var6 = var5.func_78326_a();
/*  201 */     int var7 = var5.func_78328_b();
/*  202 */     FontRenderer var8 = this.mc.field_71466_p;
/*  203 */     this.mc.field_71460_t.func_78478_c();
/*      */     
/*  205 */     this.textureFile = "jinryuudragonbc:misc/KAC3.png";
/*  206 */     ScouterRenderBlur(var6, var7);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void renderKAC4() {
/*  212 */     ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
/*  213 */     int var6 = var5.func_78326_a();
/*  214 */     int var7 = var5.func_78328_b();
/*  215 */     FontRenderer var8 = this.mc.field_71466_p;
/*  216 */     this.mc.field_71460_t.func_78478_c();
/*      */     
/*  218 */     this.textureFile = "jinryuudragonbc:misc/KAC4.png";
/*  219 */     ScouterRenderBlur(var6, var7);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void renderKAC5() {
/*  225 */     ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
/*  226 */     int var6 = var5.func_78326_a();
/*  227 */     int var7 = var5.func_78328_b();
/*  228 */     FontRenderer var8 = this.mc.field_71466_p;
/*  229 */     this.mc.field_71460_t.func_78478_c();
/*      */     
/*  231 */     this.textureFile = "jinryuudragonbc:misc/KAC5.png";
/*  232 */     ScouterRenderBlur(var6, var7);
/*      */   }
/*      */ 
/*      */   
/*      */   public void renderScouter() {
/*  237 */     ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
/*  238 */     int var6 = var5.func_78326_a();
/*  239 */     int var7 = var5.func_78328_b();
/*  240 */     FontRenderer var8 = this.mc.field_71466_p;
/*  241 */     this.mc.field_71460_t.func_78478_c();
/*  242 */     ItemStack stackhead = (ExtendedPlayer.get((EntityPlayer)this.mc.field_71439_g)).inventory.func_70301_a(2);
/*  243 */     ItemStack var9s = stackhead;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  259 */     if (var9s != null) {
/*  260 */       Item var9 = var9s.func_77973_b();
/*      */       
/*  262 */       int Tier = 0;
/*  263 */       if (JRMCoreH.armTypScoutOn(var9s)) {
/*  264 */         Tier = 1;
/*      */       }
/*  266 */       if (JRMCoreH.armTypScoutAOn(var9s)) {
/*  267 */         Tier = 2;
/*      */       }
/*  269 */       if (JRMCoreH.armTypScoutBOn(var9s)) {
/*  270 */         Tier = 3;
/*      */       }
/*  272 */       if (var9 == ItemsDBC.BattleArmorHelmet00 || var9 == ItemsDBC.BattleArmorHelmet00a || var9 == ItemsDBC.BattleArmorHelmet00b) {
/*      */ 
/*      */         
/*  275 */         this.textureFile = "jinryuudragonbc:misc/scoutery0.png";
/*  276 */         ScFunctionsInit(var6, var7, Tier);
/*      */       } 
/*  278 */       if (var9 == ItemsDBC.BattleArmorHelmet01 || var9 == ItemsDBC.BattleArmorHelmet01a || var9 == ItemsDBC.BattleArmorHelmet01b) {
/*  279 */         this.textureFile = "jinryuudragonbc:misc/scouterr0.png";
/*  280 */         ScFunctionsInit(var6, var7, Tier);
/*      */       } 
/*  282 */       if (var9 == ItemsDBC.BattleArmorHelmet02 || var9 == ItemsDBC.BattleArmorHelmet02a || var9 == ItemsDBC.BattleArmorHelmet02b) {
/*  283 */         this.textureFile = "jinryuudragonbc:misc/scouterp0.png";
/*  284 */         ScFunctionsInit(var6, var7, Tier);
/*      */       } 
/*  286 */       if (var9 == ItemsDBC.BattleArmorHelmet03 || var9 == ItemsDBC.BattleArmorHelmet03a || var9 == ItemsDBC.BattleArmorHelmet03b) {
/*  287 */         this.textureFile = "jinryuudragonbc:misc/scouterb0.png";
/*  288 */         ScFunctionsInit(var6, var7, Tier);
/*      */       } 
/*  290 */       if (var9 == ItemsDBC.BattleArmorHelmet04 || var9 == ItemsDBC.BattleArmorHelmet04a || var9 == ItemsDBC.BattleArmorHelmet04b) {
/*  291 */         this.textureFile = "jinryuudragonbc:misc/scouterg0.png";
/*  292 */         ScFunctionsInit(var6, var7, Tier);
/*      */       } 
/*  294 */       if (var9 == ItemsDBC.BattleArmorHelmet05 || var9 == ItemsDBC.BattleArmorHelmet05a || var9 == ItemsDBC.BattleArmorHelmet05b) {
/*  295 */         this.textureFile = "jinryuudragonbc:misc/scouterpi0.png";
/*  296 */         ScFunctionsInit(var6, var7, Tier);
/*      */       } 
/*  298 */       if (JRMCoreH.armTypScoutAllOn(var9s)) {
/*  299 */         if (var9.getDamage(var9s) > 100) {
/*  300 */           this.textureFile = "jinryuudragonbc:misc/crack1.png";
/*  301 */           ScouterRenderBlur(var6, var7);
/*      */         } 
/*  303 */         if (var9.getDamage(var9s) > 160) {
/*  304 */           this.textureFile = "jinryuudragonbc:misc/crack2.png";
/*  305 */           ScouterRenderBlur(var6, var7);
/*      */         } 
/*  307 */         if (var9.getDamage(var9s) > 210) {
/*  308 */           this.textureFile = "jinryuudragonbc:misc/crack3.png";
/*  309 */           ScouterRenderBlur(var6, var7);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  314 */     double MXZ = 8.0D;
/*  315 */     double MY = 8.0D;
/*  316 */     double XZ = 32.0D;
/*  317 */     double Y = 32.0D;
/*  318 */     double XZ1 = 16.0D;
/*  319 */     double Y1 = 16.0D;
/*  320 */     double XZ2 = 12.0D;
/*  321 */     double Y2 = 12.0D;
/*  322 */     double XZ3 = 4.0D;
/*  323 */     double Y3 = 4.0D;
/*  324 */     double XZ4 = 2.0D;
/*  325 */     double Y4 = 2.0D;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  343 */   public static int count = 0;
/*  344 */   public static int warn = 0;
/*  345 */   public static int startcount = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void ScouterFunction1(int var6, int var7, int Tier) {
/*  351 */     double MXZ = 8.0D * Tier;
/*  352 */     double MY = 8.0D * Tier;
/*  353 */     double M2XZ = 8.0D * Tier;
/*  354 */     double M2Y = 8.0D * Tier;
/*  355 */     double XZ = 32.0D * Tier;
/*  356 */     double Y = 32.0D * Tier;
/*  357 */     double XZ1 = 16.0D * Tier;
/*  358 */     double Y1 = 16.0D * Tier;
/*  359 */     double XZ2 = 12.0D * Tier;
/*  360 */     double Y2 = 12.0D * Tier;
/*  361 */     double XZ3 = 4.0D * Tier;
/*  362 */     double Y3 = 4.0D * Tier;
/*  363 */     double XZ4 = 2.0D * Tier;
/*  364 */     double Y4 = 2.0D * Tier;
/*      */     
/*  366 */     double AXZ = 32.0D * Tier;
/*  367 */     double AY = 16.0D * Tier;
/*      */     
/*  369 */     double par12 = this.mc.field_71439_g.field_70165_t;
/*  370 */     double par22 = this.mc.field_71439_g.field_70163_u;
/*  371 */     double par32 = this.mc.field_71439_g.field_70161_v;
/*  372 */     double par42 = this.mc.field_71439_g.field_70177_z;
/*  373 */     float par52 = this.mc.field_71439_g.field_70125_A;
/*  374 */     AxisAlignedBB AABB = AxisAlignedBB.func_72330_a(par12 - MXZ, par22 - MY, par32 - MXZ, par12 + MXZ, par22 + MY, par32 + MXZ);
/*  375 */     AxisAlignedBB AABBAll = AxisAlignedBB.func_72330_a(par12 - AXZ, par22 - AY, par32 - AXZ, par12 + AXZ, par22 + AY, par32 + AXZ);
/*  376 */     AxisAlignedBB AABBfent = AxisAlignedBB.func_72330_a(par12 - XZ4, par22 - Y4, par32 - XZ4, par12 + XZ4, par22 + Y1, par32 + XZ4);
/*  377 */     AxisAlignedBB AABBlent = AxisAlignedBB.func_72330_a(par12 - XZ4, par22 - Y1, par32 - XZ4, par12 + XZ4, par22 + Y4, par32 + XZ4);
/*      */     
/*  379 */     Class<EntityCreature> mobok = EntityCreature.class;
/*  380 */     Class<EntityBlaze> b = EntityBlaze.class;
/*  381 */     Class<EntityCaveSpider> c = EntityCaveSpider.class;
/*  382 */     Class<EntityCreeper> a = EntityCreeper.class;
/*  383 */     Class<EntityZombie> z = EntityZombie.class;
/*  384 */     Class<EntityGiantZombie> z2 = EntityGiantZombie.class;
/*  385 */     Class<EntityPigZombie> z3 = EntityPigZombie.class;
/*  386 */     Class<EntityGhast> g = EntityGhast.class;
/*  387 */     Class<EntityMagmaCube> m = EntityMagmaCube.class;
/*  388 */     Class<EntitySilverfish> i = EntitySilverfish.class;
/*  389 */     Class<EntitySkeleton> k = EntitySkeleton.class;
/*  390 */     Class<EntitySlime> l = EntitySlime.class;
/*  391 */     Class<EntitySpider> p = EntitySpider.class;
/*  392 */     Class<EntityPlayerMP> j = EntityPlayerMP.class;
/*  393 */     Class<EntityWitch> w = EntityWitch.class;
/*  394 */     Class<EntityEnderman> h = EntityEnderman.class;
/*  395 */     List korul = this.mc.field_71439_g.field_70170_p.func_72872_a(mobok, AxisAlignedBB.func_72330_a(par12 - XZ1, par22 - Y4, par32 - XZ1, par12 + XZ1, par22 + Y4, par32 + XZ1));
/*  396 */     List fent = this.mc.field_71439_g.field_70170_p.func_72872_a(mobok, AABBfent);
/*  397 */     List lent = this.mc.field_71439_g.field_70170_p.func_72872_a(mobok, AABBlent);
/*  398 */     List sarok = this.mc.field_71439_g.field_70170_p.func_72872_a(mobok, AxisAlignedBB.func_72330_a(par12 - XZ2, par22 - Y2, par32 - XZ2, par12 + XZ2, par22 + Y2, par32 + XZ2));
/*  399 */     List blaz = this.mc.field_71439_g.field_70170_p.func_72872_a(b, AABB);
/*  400 */     List cavs = this.mc.field_71439_g.field_70170_p.func_72872_a(c, AABB);
/*  401 */     List cree = this.mc.field_71439_g.field_70170_p.func_72872_a(a, AABB);
/*  402 */     List zomb = this.mc.field_71439_g.field_70170_p.func_72872_a(z, AABB);
/*  403 */     List zomv = this.mc.field_71439_g.field_70170_p.func_72872_a(z2, AABB);
/*  404 */     List zomp = this.mc.field_71439_g.field_70170_p.func_72872_a(z3, AABB);
/*  405 */     List ghas = this.mc.field_71439_g.field_70170_p.func_72872_a(g, AxisAlignedBB.func_72330_a(par12 - M2XZ, par22 - M2Y, par32 - M2XZ, par12 + M2XZ, par22 + M2Y, par32 + M2XZ));
/*  406 */     List magm = this.mc.field_71439_g.field_70170_p.func_72872_a(m, AABB);
/*  407 */     List silv = this.mc.field_71439_g.field_70170_p.func_72872_a(i, AABB);
/*  408 */     List skel = this.mc.field_71439_g.field_70170_p.func_72872_a(k, AABB);
/*  409 */     List slim = this.mc.field_71439_g.field_70170_p.func_72872_a(l, AABB);
/*  410 */     List spid = this.mc.field_71439_g.field_70170_p.func_72872_a(p, AABB);
/*  411 */     List play = this.mc.field_71439_g.field_70170_p.func_72872_a(j, AABB);
/*  412 */     List witc = this.mc.field_71439_g.field_70170_p.func_72872_a(w, AABB);
/*  413 */     List ende = this.mc.field_71439_g.field_70170_p.func_72872_a(h, AABB);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  428 */     if (!sarok.isEmpty()) {
/*  429 */       this.textureFile = "jinryuudragonbc:misc/scouterjelzo.png";
/*  430 */       ScouterRenderBlur(var6, var7);
/*  431 */       this; warn = 1;
/*      */ 
/*      */ 
/*      */       
/*  435 */       Class<EntityCreature> clazz = EntityCreature.class;
/*  436 */       List mobListAll = this.mc.field_71439_g.field_70170_p.func_72872_a(clazz, AABBAll);
/*  437 */       List mobListfent = this.mc.field_71439_g.field_70170_p.func_72872_a(clazz, AABBfent);
/*  438 */       List mobListlent = this.mc.field_71439_g.field_70170_p.func_72872_a(clazz, AABBlent);
/*  439 */       Entity mobAll = this.mc.field_71439_g.field_70170_p.func_72857_a(clazz, AABBAll, (Entity)this.mc.field_71439_g);
/*  440 */       Entity mobfent = this.mc.field_71439_g.field_70170_p.func_72857_a(clazz, AABBfent, (Entity)this.mc.field_71439_g);
/*  441 */       Entity moblent = this.mc.field_71439_g.field_70170_p.func_72857_a(clazz, AABBlent, (Entity)this.mc.field_71439_g);
/*      */       
/*  443 */       if (!mobListAll.isEmpty()) {
/*      */         
/*  445 */         double var28 = mobAll.field_70165_t - par12;
/*  446 */         double var32 = mobAll.field_70161_v - par32;
/*  447 */         double var27 = 0.0D;
/*  448 */         var27 = (par42 - 90.0D) * Math.PI / 180.0D - Math.atan2(var32, var28);
/*      */         
/*  450 */         double field_76868_i = var27;
/*  451 */         double field_76866_j = 0.0D;
/*      */         double var30;
/*  453 */         for (var30 = var27 - field_76868_i; var30 < -3.141592653589793D; var30 += 6.283185307179586D);
/*      */ 
/*      */ 
/*      */         
/*  457 */         while (var30 >= Math.PI) {
/*  458 */           var30 -= 6.283185307179586D;
/*      */         }
/*      */         
/*  461 */         if (var30 < -1.0D) {
/*  462 */           var30 = -1.0D;
/*      */         }
/*      */         
/*  465 */         if (var30 > 1.0D) {
/*  466 */           var30 = 1.0D;
/*      */         }
/*      */         
/*  469 */         field_76866_j += var30 * 0.1D;
/*  470 */         field_76866_j *= 0.8D;
/*  471 */         field_76868_i += field_76866_j;
/*      */         
/*  473 */         var30 = Math.sin(field_76868_i);
/*  474 */         double var31 = Math.cos(field_76868_i);
/*      */ 
/*      */ 
/*      */         
/*  478 */         double var421 = mobAll.field_70163_u - par22 + 1.0D;
/*      */         
/*  480 */         float par421 = par52;
/*  481 */         double dist = this.mc.field_71439_g.func_70032_d(mobAll);
/*      */         
/*  483 */         double var271 = 0.0D;
/*  484 */         var271 = par421 * Math.PI / 180.0D - Math.atan2(dist, var421);
/*      */ 
/*      */         
/*  487 */         double field_76868_i1 = var271;
/*  488 */         double field_76866_j1 = 0.0D;
/*      */         double var301;
/*  490 */         for (var301 = var271 - field_76868_i1; var301 < -3.141592653589793D; var301 += 6.283185307179586D);
/*      */ 
/*      */ 
/*      */         
/*  494 */         while (var301 >= Math.PI) {
/*  495 */           var301 -= 6.283185307179586D;
/*      */         }
/*      */         
/*  498 */         if (var301 < -1.0D) {
/*  499 */           var301 = -1.0D;
/*      */         }
/*      */         
/*  502 */         if (var301 > 1.0D) {
/*  503 */           var301 = 1.0D;
/*      */         }
/*      */         
/*  506 */         field_76866_j1 += var301 * 0.1D;
/*  507 */         field_76866_j1 *= 0.8D;
/*  508 */         field_76868_i1 += field_76866_j1;
/*      */         
/*  510 */         var301 = Math.sin(field_76868_i1);
/*  511 */         double var311 = Math.cos(field_76868_i1);
/*      */ 
/*      */ 
/*      */         
/*  515 */         if (var31 < -0.5D) {
/*  516 */           this.textureFile = "jinryuudragonbc:misc/eszak.png";
/*  517 */           ScouterRenderBlur(var6, var7);
/*      */         } 
/*  519 */         if (var31 > 0.5D) {
/*  520 */           this.textureFile = "jinryuudragonbc:misc/del.png";
/*  521 */           ScouterRenderBlur(var6, var7);
/*      */         } 
/*  523 */         if (var30 < -0.5D) {
/*  524 */           this.textureFile = "jinryuudragonbc:misc/bal.png";
/*  525 */           ScouterRenderBlur(var6, var7);
/*      */         } 
/*  527 */         if (var30 > 0.5D) {
/*  528 */           this.textureFile = "jinryuudragonbc:misc/jobb.png";
/*  529 */           ScouterRenderBlur(var6, var7);
/*      */         } 
/*  531 */         if (var311 > 0.1D) {
/*  532 */           this.textureFile = "jinryuudragonbc:misc/scouterfent.png";
/*  533 */           ScouterRenderBlur(var6, var7);
/*      */         } 
/*  535 */         if (var311 < -0.1D) {
/*  536 */           this.textureFile = "jinryuudragonbc:misc/scouterlent.png";
/*  537 */           ScouterRenderBlur(var6, var7);
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  552 */       if (!blaz.isEmpty()) {
/*  553 */         this.textureFile = "jinryuudragonbc:misc/scouterB.png";
/*  554 */         ScouterRenderBlur(var6, var7);
/*      */       } 
/*  556 */       if (!cavs.isEmpty()) {
/*  557 */         this.textureFile = "jinryuudragonbc:misc/scouterC.png";
/*  558 */         ScouterRenderBlur(var6, var7);
/*      */       } 
/*  560 */       if (!cree.isEmpty()) {
/*  561 */         this.textureFile = "jinryuudragonbc:misc/scouterA.png";
/*  562 */         ScouterRenderBlur(var6, var7);
/*  563 */         this.textureFile = "jinryuudragonbc:misc/scouteregyeb.png";
/*  564 */         ScouterRenderBlur(var6, var7);
/*      */       } 
/*  566 */       if (!zomb.isEmpty() || !zomv.isEmpty() || !zomp.isEmpty()) {
/*  567 */         this.textureFile = "jinryuudragonbc:misc/scouterZ.png";
/*  568 */         ScouterRenderBlur(var6, var7);
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  573 */       if (!magm.isEmpty()) {
/*  574 */         this.textureFile = "jinryuudragonbc:misc/scouterM.png";
/*  575 */         ScouterRenderBlur(var6, var7);
/*      */       } 
/*  577 */       if (!silv.isEmpty()) {
/*  578 */         this.textureFile = "jinryuudragonbc:misc/scouterI.png";
/*  579 */         ScouterRenderBlur(var6, var7);
/*      */       } 
/*  581 */       if (!skel.isEmpty()) {
/*  582 */         this.textureFile = "jinryuudragonbc:misc/scouterK.png";
/*  583 */         ScouterRenderBlur(var6, var7);
/*      */       } 
/*  585 */       if (!spid.isEmpty()) {
/*  586 */         this.textureFile = "jinryuudragonbc:misc/scouterP.png";
/*  587 */         ScouterRenderBlur(var6, var7);
/*      */       } 
/*  589 */       if (!play.isEmpty()) {
/*  590 */         this.textureFile = "jinryuudragonbc:misc/scouterJ.png";
/*  591 */         ScouterRenderBlur(var6, var7);
/*  592 */         this; count = 1;
/*      */       } 
/*  594 */       if (!witc.isEmpty()) {
/*  595 */         this.textureFile = "jinryuudragonbc:misc/scouterW.png";
/*  596 */         ScouterRenderBlur(var6, var7);
/*      */       } 
/*  598 */       if (!ende.isEmpty()) {
/*  599 */         this.textureFile = "jinryuudragonbc:misc/scouterH.png";
/*  600 */         ScouterRenderBlur(var6, var7);
/*      */       } 
/*      */     } 
/*  603 */     if (!slim.isEmpty()) {
/*  604 */       this.textureFile = "jinryuudragonbc:misc/scouterL.png";
/*  605 */       ScouterRenderBlur(var6, var7);
/*  606 */       this; startcount = 1;
/*      */     } 
/*  608 */     if (!ghas.isEmpty()) {
/*  609 */       this.textureFile = "jinryuudragonbc:misc/scouterG.png";
/*  610 */       ScouterRenderBlur(var6, var7);
/*  611 */       this; startcount = 1;
/*      */     } 
/*  613 */     if (sarok.isEmpty()) {
/*  614 */       this; warn = 0;
/*  615 */       this; count = 0;
/*  616 */       this; startcount = 0;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void ScouterSearch(int var6, int var7) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void ScouterFunc2(int var6, int var7, int Tier) {
/*  676 */     double MXZ = 16.0D * Tier;
/*  677 */     double MY = 2.0D * Tier;
/*  678 */     double M2XZ = 2.0D * Tier;
/*  679 */     double M2Y = 16.0D * Tier;
/*  680 */     double AXZ = 32.0D * Tier;
/*  681 */     double AY = 16.0D * Tier;
/*  682 */     double GXZ = 32.0D * Tier;
/*  683 */     double GY = 32.0D * Tier;
/*  684 */     double par12 = this.mc.field_71439_g.field_70165_t;
/*  685 */     double par22 = this.mc.field_71439_g.field_70163_u;
/*  686 */     double par32 = this.mc.field_71439_g.field_70161_v;
/*  687 */     double par42 = this.mc.field_71439_g.field_70177_z;
/*      */     
/*  689 */     AxisAlignedBB AABBAll = AxisAlignedBB.func_72330_a(par12 - AXZ, par22 - AY, par32 - AXZ, par12 + AXZ, par22 + AY, par32 + AXZ);
/*  690 */     AxisAlignedBB AABB = AxisAlignedBB.func_72330_a(par12 - MXZ, par22 - MY, par32 - MXZ, par12 + MXZ, par22 + MY, par32 + MXZ);
/*  691 */     AxisAlignedBB AABBNear = AxisAlignedBB.func_72330_a(par12 - MXZ, par22 - M2Y, par32 - MXZ, par12 + MXZ, par22 + MY, par32 + MXZ);
/*      */     
/*  693 */     Class<EntityMob> clazz = EntityMob.class;
/*  694 */     Class<EntityNamekian01> clazz1 = EntityNamekian01.class;
/*  695 */     Class<EntitySaiyan01> clazz2 = EntitySaiyan01.class;
/*  696 */     Class<EntitySaiyan02> clazz3 = EntitySaiyan02.class;
/*  697 */     Class<EntityHell01> clazz4 = EntityHell01.class;
/*  698 */     Class<EntityHell02> clazz5 = EntityHell02.class;
/*  699 */     Class<EntityMasterEnma> clazz6 = EntityMasterEnma.class;
/*      */     
/*  701 */     Class<EntityCreature> clazz7 = EntityCreature.class;
/*  702 */     List mobListAll = this.mc.field_71439_g.field_70170_p.func_72872_a(clazz7, AABBAll);
/*  703 */     Entity mobAll = this.mc.field_71439_g.field_70170_p.func_72857_a(clazz7, AABBAll, (Entity)this.mc.field_71439_g);
/*      */     
/*  705 */     if (!mobListAll.isEmpty()) {
/*  706 */       Class<? extends Entity> EntityClass = (Class)mobAll.getClass();
/*      */       
/*  708 */       if (EntityClass == clazz1) {
/*  709 */         Class<EntityNamekian01> clazz8 = clazz1;
/*      */       }
/*  711 */       if (EntityClass == clazz2) {
/*  712 */         Class<EntitySaiyan01> clazz8 = clazz2;
/*      */       }
/*  714 */       if (EntityClass == clazz3) {
/*  715 */         Class<EntitySaiyan02> clazz8 = clazz3;
/*      */       }
/*  717 */       if (EntityClass == clazz4) {
/*  718 */         Class<EntityHell01> clazz8 = clazz4;
/*      */       }
/*  720 */       if (EntityClass == clazz5) {
/*  721 */         Class<EntityHell02> clazz8 = clazz5;
/*      */       }
/*  723 */       if (EntityClass == clazz6) {
/*  724 */         Class<EntityMasterEnma> clazz8 = clazz6;
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  781 */     if (!mobListAll.isEmpty()) {
/*  782 */       Class<? extends Entity> EntityClass = (Class)mobAll.getClass();
/*      */       
/*  784 */       soundFunc2 = 1;
/*  785 */       double entiNam = this.mc.field_71439_g.func_70068_e(mobAll);
/*  786 */       int entiNamInt = (int)entiNam;
/*  787 */       toString(); String entiNamStr = String.valueOf(entiNamInt);
/*  788 */       this.entiLoc = entiNamStr;
/*  789 */       this.textureFile = "jinryuudragonbc:misc/tavolsag.png";
/*  790 */       ScouterRenderBlur(var6, var7);
/*  791 */       Func2TAV();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*  796 */   public static int soundFunc2 = 0;
/*      */   public void ScouterFunc3(int var6, int var7, int Tier) {
/*      */     Class<EntityEnderman> clazz16;
/*  799 */     Vec3 look = this.mc.field_71439_g.func_70040_Z();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  809 */     double MXZ = 16.0D * Tier;
/*  810 */     double MY = 2.0D * Tier;
/*  811 */     double M2XZ = 2.0D * Tier;
/*  812 */     double M2Y = 16.0D * Tier;
/*  813 */     double par12 = this.mc.field_71439_g.field_70165_t;
/*  814 */     double par22 = this.mc.field_71439_g.field_70163_u;
/*  815 */     double par32 = this.mc.field_71439_g.field_70161_v;
/*  816 */     double par42 = this.mc.field_71439_g.field_70177_z;
/*  817 */     AxisAlignedBB AABBX0 = AxisAlignedBB.func_72330_a(par12 - M2XZ, par22 - MY, par32 - MXZ, par12 + MXZ, par22 + MY, par32 + MXZ);
/*  818 */     AxisAlignedBB AABBX1 = AxisAlignedBB.func_72330_a(par12 - MXZ, par22 - MY, par32 - MXZ, par12 + M2XZ, par22 + MY, par32 + MXZ);
/*  819 */     AxisAlignedBB AABBZ0 = AxisAlignedBB.func_72330_a(par12 - MXZ, par22 - MY, par32 - M2XZ, par12 + MXZ, par22 + MY, par32 + MXZ);
/*  820 */     AxisAlignedBB AABBZ1 = AxisAlignedBB.func_72330_a(par12 - MXZ, par22 - MY, par32 - MXZ, par12 + MXZ, par22 + MY, par32 + M2XZ);
/*  821 */     AxisAlignedBB AABBY0 = AxisAlignedBB.func_72330_a(par12 - M2XZ, par22 - M2Y, par32 - M2XZ, par12 + M2XZ, par22 + MY, par32 + M2XZ);
/*  822 */     AxisAlignedBB AABBY1 = AxisAlignedBB.func_72330_a(par12 - M2XZ, par22 - MY, par32 - M2XZ, par12 + M2XZ, par22 + M2Y, par32 + M2XZ);
/*  823 */     AxisAlignedBB AABBNear = AxisAlignedBB.func_72330_a(par12 - MXZ, par22 - M2Y, par32 - MXZ, par12 + MXZ, par22 + MY, par32 + MXZ);
/*      */     
/*  825 */     Class<EntityBlaze> clazz = EntityBlaze.class;
/*  826 */     Class<EntityCaveSpider> clazz1 = EntityCaveSpider.class;
/*  827 */     Class<EntityCreeper> clazz2 = EntityCreeper.class;
/*  828 */     Class<EntityZombie> clazz3 = EntityZombie.class;
/*  829 */     Class<EntityGiantZombie> clazz4 = EntityGiantZombie.class;
/*  830 */     Class<EntityPigZombie> clazz5 = EntityPigZombie.class;
/*  831 */     Class<EntityGhast> clazz6 = EntityGhast.class;
/*  832 */     Class<EntityMagmaCube> clazz7 = EntityMagmaCube.class;
/*  833 */     Class<EntitySilverfish> clazz8 = EntitySilverfish.class;
/*  834 */     Class<EntitySkeleton> clazz9 = EntitySkeleton.class;
/*  835 */     Class<EntitySlime> clazz10 = EntitySlime.class;
/*  836 */     Class<EntitySpider> clazz11 = EntitySpider.class;
/*  837 */     Class<EntityPlayerMP> clazz12 = EntityPlayerMP.class;
/*  838 */     Class<EntityWitch> clazz13 = EntityWitch.class;
/*  839 */     Class<EntityEnderman> clazz14 = EntityEnderman.class;
/*      */     
/*  841 */     Class<EntityMob> clazz15 = EntityMob.class;
/*  842 */     Class<EntityMob> clazz17 = EntityMob.class;
/*      */ 
/*      */     
/*  845 */     Class<EntityCreature> mobok = EntityCreature.class;
/*  846 */     List mobNear = this.mc.field_71439_g.field_70170_p.func_72872_a(mobok, AABBNear);
/*  847 */     Entity entMobok = this.mc.field_71439_g.field_70170_p.func_72857_a(mobok, AABBNear, (Entity)this.mc.field_71439_g);
/*      */     
/*  849 */     if (!mobNear.isEmpty()) {
/*  850 */       Class<? extends Entity> EntityClass = (Class)entMobok.getClass();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  857 */       if (EntityClass == clazz) {
/*  858 */         Class<EntityBlaze> clazz18 = clazz;
/*      */       }
/*  860 */       if (EntityClass == clazz1) {
/*  861 */         Class<EntityCaveSpider> clazz18 = clazz1;
/*      */       }
/*  863 */       if (EntityClass == clazz2) {
/*  864 */         Class<EntityCreeper> clazz18 = clazz2;
/*      */       }
/*  866 */       if (EntityClass == clazz3) {
/*  867 */         Class<EntityZombie> clazz18 = clazz3;
/*      */       }
/*  869 */       if (EntityClass == clazz4) {
/*  870 */         Class<EntityGiantZombie> clazz18 = clazz4;
/*      */       }
/*  872 */       if (EntityClass == clazz5) {
/*  873 */         Class<EntityPigZombie> clazz18 = clazz5;
/*      */       }
/*  875 */       if (EntityClass == clazz6) {
/*  876 */         Class<EntityGhast> clazz18 = clazz6;
/*      */       }
/*  878 */       if (EntityClass == clazz7) {
/*  879 */         Class<EntityMagmaCube> clazz18 = clazz7;
/*      */       }
/*  881 */       if (EntityClass == clazz8) {
/*  882 */         Class<EntitySilverfish> clazz18 = clazz8;
/*      */       }
/*  884 */       if (EntityClass == clazz9) {
/*  885 */         Class<EntitySkeleton> clazz18 = clazz9;
/*      */       }
/*  887 */       if (EntityClass == clazz10) {
/*  888 */         Class<EntitySlime> clazz18 = clazz10;
/*      */       }
/*  890 */       if (EntityClass == clazz11) {
/*  891 */         Class<EntitySpider> clazz18 = clazz11;
/*      */       }
/*  893 */       if (EntityClass == clazz12) {
/*  894 */         Class<EntityPlayerMP> clazz18 = clazz12;
/*      */       }
/*  896 */       if (EntityClass == clazz13) {
/*  897 */         Class<EntityWitch> clazz18 = clazz13;
/*      */       }
/*  899 */       if (EntityClass == clazz14) {
/*  900 */         clazz16 = clazz14;
/*      */       }
/*      */     } 
/*      */     
/*  904 */     List nameX0 = this.mc.field_71439_g.field_70170_p.func_72872_a(clazz15, AABBX0);
/*  905 */     List nameX1 = this.mc.field_71439_g.field_70170_p.func_72872_a(clazz15, AABBX1);
/*  906 */     List nameZ0 = this.mc.field_71439_g.field_70170_p.func_72872_a(clazz15, AABBZ0);
/*  907 */     List nameZ1 = this.mc.field_71439_g.field_70170_p.func_72872_a(clazz15, AABBZ1);
/*  908 */     List nameY0 = this.mc.field_71439_g.field_70170_p.func_72872_a(clazz15, AABBY0);
/*  909 */     List nameY1 = this.mc.field_71439_g.field_70170_p.func_72872_a(clazz15, AABBY1);
/*      */ 
/*      */     
/*  912 */     Entity namek = this.mc.field_71439_g.field_70170_p.func_72857_a(clazz15, AABBNear, (Entity)this.mc.field_71439_g);
/*      */ 
/*      */     
/*  915 */     if (!mobNear.isEmpty()) {
/*  916 */       List mobListAll = this.mc.field_71439_g.field_70170_p.func_72872_a(mobok, AABBNear);
/*  917 */       List mobListfent = this.mc.field_71439_g.field_70170_p.func_72872_a(mobok, AABBY1);
/*  918 */       List mobListlent = this.mc.field_71439_g.field_70170_p.func_72872_a(mobok, AABBY0);
/*  919 */       Entity mobAll = this.mc.field_71439_g.field_70170_p.func_72857_a(mobok, AABBNear, (Entity)this.mc.field_71439_g);
/*  920 */       Entity mobfent = this.mc.field_71439_g.field_70170_p.func_72857_a(mobok, AABBY1, (Entity)this.mc.field_71439_g);
/*  921 */       Entity moblent = this.mc.field_71439_g.field_70170_p.func_72857_a(mobok, AABBY0, (Entity)this.mc.field_71439_g);
/*      */       
/*  923 */       if (!mobListAll.isEmpty()) {
/*  924 */         double var28 = mobAll.field_70165_t - par12;
/*  925 */         double var32 = mobAll.field_70161_v - par32;
/*  926 */         double var27 = 0.0D;
/*  927 */         var27 = (par42 - 90.0D) * Math.PI / 180.0D - Math.atan2(var32, var28);
/*      */         
/*  929 */         double field_76868_i = var27;
/*  930 */         double field_76866_j = 0.0D;
/*      */         double var30;
/*  932 */         for (var30 = var27 - field_76868_i; var30 < -3.141592653589793D; var30 += 6.283185307179586D);
/*      */ 
/*      */ 
/*      */         
/*  936 */         while (var30 >= Math.PI) {
/*  937 */           var30 -= 6.283185307179586D;
/*      */         }
/*      */         
/*  940 */         if (var30 < -1.0D) {
/*  941 */           var30 = -1.0D;
/*      */         }
/*      */         
/*  944 */         if (var30 > 1.0D) {
/*  945 */           var30 = 1.0D;
/*      */         }
/*      */         
/*  948 */         field_76866_j += var30 * 0.1D;
/*  949 */         field_76866_j *= 0.8D;
/*  950 */         field_76868_i += field_76866_j;
/*      */         
/*  952 */         var30 = Math.sin(field_76868_i);
/*  953 */         double var31 = Math.cos(field_76868_i);
/*  954 */         if (var31 < -0.5D) {
/*  955 */           this.textureFile = "jinryuudragonbc:misc/BPeszak.png";
/*  956 */           ScouterRenderBlur(var6, var7);
/*      */         } 
/*  958 */         if (var31 > 0.5D) {
/*  959 */           this.textureFile = "jinryuudragonbc:misc/BPdel.png";
/*  960 */           ScouterRenderBlur(var6, var7);
/*      */         } 
/*  962 */         if (var30 < -0.5D) {
/*  963 */           this.textureFile = "jinryuudragonbc:misc/BPbal.png";
/*  964 */           ScouterRenderBlur(var6, var7);
/*      */         } 
/*  966 */         if (var30 > 0.5D) {
/*  967 */           this.textureFile = "jinryuudragonbc:misc/BPjobb.png";
/*  968 */           ScouterRenderBlur(var6, var7);
/*      */         } 
/*  970 */         if (!mobListfent.isEmpty()) {
/*  971 */           this.textureFile = "jinryuudragonbc:misc/BPfent.png";
/*  972 */           ScouterRenderBlur(var6, var7);
/*      */         } 
/*  974 */         if (!mobListlent.isEmpty()) {
/*  975 */           this.textureFile = "jinryuudragonbc:misc/BPlent.png";
/*  976 */           ScouterRenderBlur(var6, var7);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  981 */     String entiNam = "0";
/*  982 */     int exp = 0;
/*  983 */     Random rand = new Random();
/*      */     
/*  985 */     if (!mobNear.isEmpty()) {
/*  986 */       Class<? extends Entity> EntityClass = (Class)entMobok.getClass();
/*      */       
/*  988 */       if (EntityClass == null) {
/*  989 */         entiNam = "Error";
/*      */       }
/*      */       
/*  992 */       if (EntityClass == clazz16) {
/*      */ 
/*      */         
/*  995 */         entiNam = "" + JRMCoreH.bpc(entMobok);
/*  996 */         this; warn = 1;
/*      */       } 
/*      */ 
/*      */       
/* 1000 */       if (EntityClass != clazz16 && EntityClass != null) {
/* 1001 */         exp = (int)(((EntityCreature)entMobok).func_110143_aJ() * 50.0F);
/* 1002 */         this; warn = 1;
/* 1003 */         if (exp <= 500 && EntityClass != EntityWolf.class) {
/* 1004 */           exp = (int)(((EntityCreature)entMobok).func_110143_aJ() / 2.0F);
/* 1005 */           this; warn = 0;
/*      */         } 
/* 1007 */         entiNam = "" + JRMCoreH.bpc(entMobok);
/*      */       } 
/*      */       
/* 1010 */       Entity dbc = this.mc.field_71439_g.field_70170_p.func_72857_a(EntityDBC.class, AABBNear, (Entity)this.mc.field_71439_g);
/* 1011 */       if (dbc instanceof EntityDBC) {
/*      */ 
/*      */         
/* 1014 */         entiNam = "" + JRMCoreH.bpc(dbc);
/* 1015 */         this; warn = 1;
/*      */       } 
/*      */     } 
/*      */     
/* 1019 */     if (!mobNear.isEmpty()) {
/* 1020 */       soundFunc3 = 1;
/*      */ 
/*      */ 
/*      */       
/* 1024 */       long s = Long.parseLong(entiNam);
/* 1025 */       String bc = "" + JRMCoreH.numSepShort(s);
/* 1026 */       entiNam = "" + bc;
/* 1027 */       if ((Tier == 1 && s > 10000L) || (Tier == 2 && s > 1000000L)) {
/* 1028 */         DBCKiAttacks.dbctick(-2); DBCKiAttacks.scouterRem((EntityPlayer)this.mc.field_71439_g);
/* 1029 */       }  this.entiBP = bc;
/* 1030 */       this.textureFile = "jinryuudragonbc:misc/battlepower.png";
/* 1031 */       ScouterRenderBlur(var6, var7);
/* 1032 */       Func3BP();
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1056 */     if (mobNear.isEmpty()) {
/* 1057 */       this; warn = 0;
/* 1058 */       this; count = 0;
/* 1059 */       this; startcount = 0;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   int otherPlayerValue;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void ScouterFunc2MP(int var6, int var7, int Tier) {
/* 1073 */     double MXZ = 16.0D * Tier;
/* 1074 */     double MY = 2.0D * Tier;
/* 1075 */     double M2XZ = 2.0D * Tier;
/* 1076 */     double M2Y = 16.0D * Tier;
/* 1077 */     double AXZ = 32.0D * Tier;
/* 1078 */     double AY = 16.0D * Tier;
/* 1079 */     double GXZ = 32.0D * Tier;
/* 1080 */     double GY = 32.0D * Tier;
/* 1081 */     double par12 = this.mc.field_71439_g.field_70165_t;
/* 1082 */     double par22 = this.mc.field_71439_g.field_70163_u;
/* 1083 */     double par32 = this.mc.field_71439_g.field_70161_v;
/*      */     
/* 1085 */     AxisAlignedBB AABBAll = AxisAlignedBB.func_72330_a(par12 - AXZ, par22 - AY, par32 - AXZ, par12 + AXZ, par22 + AY, par32 + AXZ);
/* 1086 */     AxisAlignedBB AABB = AxisAlignedBB.func_72330_a(par12 - MXZ, par22 - MY, par32 - MXZ, par12 + MXZ, par22 + MY, par32 + MXZ);
/* 1087 */     AxisAlignedBB AABBNear = AxisAlignedBB.func_72330_a(par12 - MXZ, par22 - M2Y, par32 - MXZ, par12 + MXZ, par22 + MY, par32 + MXZ);
/*      */ 
/*      */     
/* 1090 */     Class<EntityPlayer> clazz = EntityPlayer.class;
/* 1091 */     List mobListAll = this.mc.field_71439_g.field_70170_p.func_72872_a(clazz, AABBAll);
/* 1092 */     Entity mobAll = this.mc.field_71439_g.field_70170_p.func_72857_a(clazz, AABBAll, (Entity)this.mc.field_71439_g);
/*      */     
/* 1094 */     if (!mobListAll.isEmpty() && mobAll != null) {
/* 1095 */       Class<? extends Entity> EntityClass = (Class)mobAll.getClass();
/*      */       
/* 1097 */       if (mobAll == this.mc.field_71439_g) {
/*      */         return;
/*      */       }
/*      */ 
/*      */       
/* 1102 */       soundFunc2 = 1;
/*      */       
/* 1104 */       double entiNam = this.mc.field_71439_g.func_70068_e(mobAll);
/* 1105 */       int entiNamInt = (int)entiNam;
/* 1106 */       toString(); String entiNamStr = String.valueOf(entiNamInt);
/* 1107 */       this.entiLoc = entiNamStr; Func2TAV();
/* 1108 */       this.textureFile = "jinryuudragonbc:misc/tavolsag.png"; ScouterRenderBlur(var6, var7);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void ScouterFunc3MP(int var6, int var7, int Tier) {
/* 1114 */     double MXZ = 16.0D * Tier;
/* 1115 */     double M2Y = 16.0D * Tier;
/* 1116 */     double par12 = this.mc.field_71439_g.field_70165_t;
/* 1117 */     double par22 = this.mc.field_71439_g.field_70163_u;
/* 1118 */     double par32 = this.mc.field_71439_g.field_70161_v;
/* 1119 */     AxisAlignedBB AABBNear = AxisAlignedBB.func_72330_a(par12 - MXZ, par22 - M2Y, par32 - MXZ, par12 + MXZ, par22 + M2Y, par32 + MXZ);
/*      */     
/* 1121 */     Class<EntityPlayer> mobok = EntityPlayer.class;
/* 1122 */     List mobNear = this.mc.field_71439_g.field_70170_p.func_72872_a(mobok, AABBNear);
/* 1123 */     Entity entMobok = this.mc.field_71439_g.field_70170_p.func_72857_a(mobok, AABBNear, (Entity)this.mc.field_71439_g);
/*      */     
/* 1125 */     if (!mobNear.isEmpty() && entMobok != null && entMobok != this.mc.field_71439_g) {
/* 1126 */       soundFunc3 = 1;
/*      */ 
/*      */ 
/*      */       
/* 1130 */       String m = ((EntityPlayer)entMobok).func_70005_c_();
/* 1131 */       long s = JRMCoreH.bpc((EntityPlayer)entMobok, m, JRMCoreH.Pwrtyp);
/* 1132 */       s = JRMCoreH.gkap(s, m);
/*      */       
/* 1134 */       String bc = "" + JRMCoreH.numSepShort(s);
/*      */ 
/*      */ 
/*      */       
/* 1138 */       if ((Tier == 1 && s > 100000L) || (Tier == 2 && s > 1000000L)) {
/* 1139 */         DBCKiAttacks.dbctick(-2); DBCKiAttacks.scouterRem((EntityPlayer)this.mc.field_71439_g);
/*      */       } 
/* 1141 */       String entiNam = bc;
/* 1142 */       this.entiBP = entiNam;
/* 1143 */       this.textureFile = "jinryuudragonbc:misc/battlepower.png";
/* 1144 */       ScouterRenderBlur(var6, var7);
/* 1145 */       Func3BP();
/*      */     } 
/* 1147 */     if (mobNear.isEmpty()) {
/* 1148 */       this; warn = 0;
/* 1149 */       this; count = 0;
/* 1150 */       this; startcount = 0;
/*      */     } 
/*      */   }
/*      */   
/* 1154 */   public ScouterGui() { this.otherPlayerValue = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1179 */     this.entiBP = "§e";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1204 */     this.entiLoc = "§e";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1274 */     this.textureFile = "jinryuudragonbc:misc/scouterjelzo.png"; }
/*      */ 
/*      */   
/*      */   public static int soundFunc3 = 0;
/*      */   protected String entiBP;
/*      */   protected String entiLoc;
/*      */   private String textureFile;
/*      */   
/*      */   public void ScouterRenderBlur(int par1, int par2) {
/* 1283 */     GL11.glEnable(3042);
/* 1284 */     GL11.glBlendFunc(770, 771);
/* 1285 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 1286 */     this.field_73735_i = -600.0F;
/* 1287 */     ResourceLocation tx = new ResourceLocation(this.textureFile);
/* 1288 */     this.mc.field_71446_o.func_110577_a(tx);
/* 1289 */     Tessellator var3 = Tessellator.field_78398_a;
/* 1290 */     var3.func_78382_b();
/* 1291 */     var3.func_78374_a(0.0D, par2, this.field_73735_i, 0.0D, 1.0D);
/* 1292 */     var3.func_78374_a(par1, par2, this.field_73735_i, 1.0D, 1.0D);
/* 1293 */     var3.func_78374_a(par1, 0.0D, this.field_73735_i, 1.0D, 0.0D);
/* 1294 */     var3.func_78374_a(0.0D, 0.0D, this.field_73735_i, 0.0D, 0.0D);
/* 1295 */     var3.func_78381_a();
/* 1296 */     GL11.glDisable(3042);
/*      */   }
/*      */   
/*      */   public void Func3BP() {
/*      */     initGui();
/*      */     Minecraft minecraft = this.mc;
/*      */     WorldClient worldClient = minecraft.field_71441_e;
/*      */     EntityClientPlayerMP entityClientPlayerMP = minecraft.field_71439_g;
/*      */     ScaledResolution scaledresolution = new ScaledResolution(minecraft, minecraft.field_71443_c, minecraft.field_71440_d);
/*      */     int width = scaledresolution.func_78326_a();
/*      */     int height = scaledresolution.func_78328_b();
/*      */     int widthplus = 8;
/*      */     minecraft.field_71460_t.func_78478_c();
/*      */     RenderHelper.func_74519_b();
/*      */     RenderHelper.func_74518_a();
/*      */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */     func_73732_a(this.fontRenderer, this.entiBP, width / 8, height / 40 * 16, 16768306);
/*      */   }
/*      */   
/*      */   public void Func2TAV() {
/*      */     initGui();
/*      */     EntityClientPlayerMP entityClientPlayerMP = this.mc.field_71439_g;
/*      */     ScaledResolution scaledresolution = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
/*      */     int width = scaledresolution.func_78326_a();
/*      */     int height = scaledresolution.func_78328_b();
/*      */     int widthplus = 8;
/*      */     FontRenderer fontRender = this.mc.field_71466_p;
/*      */     this.mc.field_71460_t.func_78478_c();
/*      */     RenderHelper.func_74519_b();
/*      */     RenderHelper.func_74518_a();
/*      */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */     func_73732_a(fontRender, this.entiLoc, width / 400 * 120, height / 40 * 15, 16768306);
/*      */   }
/*      */   
/*      */   public void ScouterDBRadar(int var6, int var7) {
/*      */     double MXZ = 32.0D;
/*      */     double MY = 8.0D;
/*      */     double M2XZ = 8.0D;
/*      */     double par12 = this.mc.field_71439_g.field_70165_t;
/*      */     double par22 = this.mc.field_71439_g.field_70163_u;
/*      */     double par32 = this.mc.field_71439_g.field_70161_v;
/*      */     AxisAlignedBB AABBX0 = AxisAlignedBB.func_72330_a(par12 - M2XZ, par22 - MY, par32 - MXZ, par12 + MXZ, par22 + MY, par32 + MXZ);
/*      */     AxisAlignedBB AABBX1 = AxisAlignedBB.func_72330_a(par12 - MXZ, par22 - MY, par32 - MXZ, par12 + M2XZ, par22 + MY, par32 + MXZ);
/*      */     AxisAlignedBB AABBZ0 = AxisAlignedBB.func_72330_a(par12 - MXZ, par22 - MY, par32 - M2XZ, par12 + MXZ, par22 + MY, par32 + MXZ);
/*      */     AxisAlignedBB AABBZ1 = AxisAlignedBB.func_72330_a(par12 - MXZ, par22 - MY, par32 - MXZ, par12 + MXZ, par22 + MY, par32 + M2XZ);
/*      */     boolean DBX0 = this.mc.field_71439_g.field_70170_p.func_72830_b(AABBX0, DBCMaterial.dragonblock);
/*      */     boolean DBX1 = this.mc.field_71439_g.field_70170_p.func_72830_b(AABBX1, DBCMaterial.dragonblock);
/*      */     boolean DBZ0 = this.mc.field_71439_g.field_70170_p.func_72830_b(AABBZ0, DBCMaterial.dragonblock);
/*      */     boolean DBZ1 = this.mc.field_71439_g.field_70170_p.func_72830_b(AABBZ1, DBCMaterial.dragonblock);
/*      */     if (DBX0 = true) {
/*      */       this.textureFile = "jinryuudragonbc:misc/TAVjobb.png";
/*      */       ScouterRenderBlur(var6, var7);
/*      */     } 
/*      */     if (DBX1 = true) {
/*      */       this.textureFile = "jinryuudragonbc:misc/TAVbal.png";
/*      */       ScouterRenderBlur(var6, var7);
/*      */     } 
/*      */     if (DBZ0 = true) {
/*      */       this.textureFile = "jinryuudragonbc:misc/TAVeszak.png";
/*      */       ScouterRenderBlur(var6, var7);
/*      */     } 
/*      */     if (DBZ1 = true) {
/*      */       this.textureFile = "jinryuudragonbc:misc/TAVdel.png";
/*      */       ScouterRenderBlur(var6, var7);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void ScouterIntro(int var6, int var7, int tier2) {
/*      */     this.textureFile = "jinryuudragonbc:misc/intro.png";
/*      */     ScouterRenderBlur(var6, var7);
/*      */   }
/*      */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Gui\ScouterGui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */