/*     */ package JinRyuu.DragonBC.common.Gui;
/*     */ import JinRyuu.DragonBC.common.DBCH;
/*     */ import JinRyuu.DragonBC.common.Npcs.EntityDBC;
/*     */ import JinRyuu.DragonBC.common.Npcs.EntityDBCEvil;
/*     */ import JinRyuu.DragonBC.common.Npcs.EntityGodHeles;
/*     */ import JinRyuu.DragonBC.common.Npcs.EntityMonaka;
/*     */ import JinRyuu.DragonBC.common.Npcs.EntityNapapa;
/*     */ import JinRyuu.DragonBC.common.Npcs.EntitySaiyan01;
/*     */ import JinRyuu.DragonBC.common.Npcs.EntitySaiyan02;
/*     */ import JinRyuu.DragonBC.common.Npcs.EntityShisami;
/*     */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityGeneralBlue2;
/*     */ import JinRyuu.DragonBC.common.Npcs.dbsbroly.EntityDBSBroly1;
/*     */ import JinRyuu.DragonBC.common.Npcs.dbsbroly.EntityDBSBroly2;
/*     */ import JinRyuu.DragonBC.common.Npcs.dbsbroly.EntityDBSBroly3;
/*     */ import JinRyuu.DragonBC.common.Npcs.dbsbroly.EntityDBSBroly4;
/*     */ import JinRyuu.DragonBC.common.Npcs.dbsbroly.EntityDBSParagus2;
/*     */ import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityBacterian;
/*     */ import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityNam;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ 
/*     */ public class ComDbcSpawn extends CommandBase {
/*     */   public String func_71517_b() {
/*  29 */     return "dbcspawn";
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_71518_a(ICommandSender icommandsender) {
/*  34 */     return "Use '/dbcspawn (DBCmobName) or /dbcspawn (DBCmobName) (Health)' to spawn the DBC mobs or /dbcspawn (DBCmobName) (Health) (Damage)' to spawn the DBC mobs.";
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_82362_a() {
/*  39 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_71519_b(ICommandSender par1ICommandSender) {
/*  44 */     return (MinecraftServer.func_71276_C().func_71264_H() || super.func_71519_b(par1ICommandSender));
/*     */   }
/*     */   private NBTTagCompound nbt(EntityPlayer p, String s) {
/*  47 */     return JRMCoreH.nbt((Entity)p, s);
/*     */   }
/*     */   
/*     */   public void func_71515_b(ICommandSender commandSender, String[] stringArray) {
/*  51 */     if (stringArray.length <= 0)
/*     */     {
/*  53 */       throw new WrongUsageException("Use '/dbcspawn (DBCmobName) or /dbcspawn (DBCmobName) (Health)' to spawn the DBC mobs or /dbcspawn (DBCmobName) (Health) (Damage)' to spawn the DBC mobs.", new Object[0]);
/*     */     }
/*     */ 
/*     */     
/*  57 */     if (stringArray.length <= 1) {
/*     */ 
/*     */       
/*  60 */       EntityPlayerMP entityplayermp = func_71521_c(commandSender);
/*     */ 
/*     */ 
/*     */       
/*  64 */       EntityDBC[] ent = getEntityList(entityplayermp);
/*  65 */       String[] entnams = getEntityNameList();
/*     */       
/*  67 */       String s2 = stringArray[0].toLowerCase();
/*     */       
/*  69 */       EntityDBC entity = null;
/*  70 */       boolean spawned = false;
/*  71 */       for (int i1 = 0; i1 < entnams.length; i1++) {
/*     */         
/*  73 */         if (entnams[i1].toLowerCase().contains(s2)) {
/*     */           
/*  75 */           entity = ent[i1];
/*  76 */           entity.func_70029_a(entityplayermp.field_70170_p);
/*  77 */           String[] v = DBCH.NpcSpawnLoc((int)entityplayermp.field_70165_t, (int)entityplayermp.field_70163_u, (int)entityplayermp.field_70161_v, entityplayermp.field_70170_p).split(";");
/*  78 */           entity.func_70012_b(Double.parseDouble(v[0]), Double.parseDouble(v[1]), Double.parseDouble(v[2]), 0.0F, 0.0F);
/*  79 */           if (entity instanceof EntityDBCEvil) ((EntityDBCEvil)entity).setSpwner((Entity)entityplayermp);
/*     */           
/*  81 */           entityplayermp.field_70170_p.func_72838_d((Entity)entity);
/*  82 */           notifyAdmins(commandSender, "%s spawned %s!", new Object[] { entityplayermp.func_70005_c_(), entnams[i1] });
/*  83 */           spawned = true;
/*     */           break;
/*     */         } 
/*     */       } 
/*  87 */       if (!spawned) {
/*  88 */         notifyAdmins(commandSender, "%s couldn't spawn %s!", new Object[] { entityplayermp.func_70005_c_(), s2 });
/*     */       
/*     */       }
/*     */     }
/*  92 */     else if (stringArray.length <= 4) {
/*     */       EntityPlayerMP entityplayermp;
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
/* 105 */       if (stringArray.length > 3) {
/*     */         
/* 107 */         entityplayermp = func_82359_c(commandSender, stringArray[3]);
/*     */       }
/*     */       else {
/*     */         
/* 111 */         entityplayermp = func_71521_c(commandSender);
/*     */       } 
/*     */ 
/*     */       
/* 115 */       String s = stringArray[0];
/* 116 */       String stringHealth = "";
/* 117 */       String stringDamage = "";
/* 118 */       if (stringArray.length >= 2) {
/*     */         
/* 120 */         stringHealth = stringArray[1];
/* 121 */         if (stringArray.length == 3) stringDamage = stringArray[2];
/*     */       
/*     */       } 
/*     */       
/* 125 */       EntityDBC[] ent = getEntityList(entityplayermp);
/* 126 */       String[] entnams = getEntityNameList();
/*     */       
/* 128 */       String s2 = s.toLowerCase();
/*     */       
/* 130 */       EntityDBC entity = null;
/* 131 */       boolean spawned = false;
/*     */       
/* 133 */       for (int i1 = 0; i1 < entnams.length; i1++) {
/*     */         
/* 135 */         if (entnams[i1].toLowerCase().contains(s2)) {
/*     */           
/* 137 */           entity = ent[i1];
/* 138 */           entity.func_70029_a(entityplayermp.field_70170_p);
/* 139 */           String[] v = DBCH.NpcSpawnLoc((int)entityplayermp.field_70165_t, (int)entityplayermp.field_70163_u, (int)entityplayermp.field_70161_v, entityplayermp.field_70170_p).split(";");
/* 140 */           entity.func_70012_b(Double.parseDouble(v[0]), Double.parseDouble(v[1]), Double.parseDouble(v[2]), 0.0F, 0.0F);
/* 141 */           if (entity instanceof EntityDBCEvil) ((EntityDBCEvil)entity).setSpwner((Entity)entityplayermp);
/*     */ 
/*     */           
/* 144 */           NBTTagCompound nbt = JRMCoreH.nbt((Entity)entity);
/* 145 */           JGEntityHelper.setAttributes((EntityLivingBase)entity, stringHealth, stringDamage, "", "", 1);
/*     */ 
/*     */           
/* 148 */           entityplayermp.field_70170_p.func_72838_d((Entity)entity);
/* 149 */           notifyAdmins(commandSender, "%s spawned %s!", new Object[] { entityplayermp.func_70005_c_(), entnams[i1] });
/* 150 */           spawned = true;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/* 155 */       if (!spawned)
/*     */       {
/* 157 */         notifyAdmins(commandSender, "%s couldn't spawn %s!", new Object[] { entityplayermp.func_70005_c_(), s2 });
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void notifyAdmins(ICommandSender commandSender, String string, Object[] objects) {
/* 163 */     func_152373_a(commandSender, (ICommand)this, string, objects);
/*     */   }
/*     */   private String[] getEntityNameList() {
/* 166 */     String[] entityNames = { "Nam", "Piccolo", "Piccolo2", "Raditz", "Nappa", "Vegeta", "Saibaiman", "Saiyan01", "Saiyan02", "Ogre1", "Ogre2", "Kiwi", "Dodoria", "Zarbon", "Zarbon2", "Guldo", "Recoome", "Barta", "Jeice", "Ginyu", "FreezaSoldier1", "FreezaSoldier2", "FreezaSoldier3", "Freeza1", "Freeza2", "Freeza3", "Freeza4", "Freeza5", "Freeza6", "FreezaGolden", "KingCold", "MechaFreeza", "Cyborg16", "Cyborg17", "Cyborg18", "Cyborg19", "Cyborg20", "Cell1", "Cell2", "Cell3", "Cell4", "Namekian01", "PuiPui", "Yakon", "Dabura", "BuuFat", "BuuSuper", "Dino01", "Beerus", "Dino02", "Dino03", "RRMecha1", "Sabertooth", "CellJr", "BuuEvil", "BuuFusion", "BuuPiccolo", "BuuUltimate", "BuuBuffed", "BuuKid", "Monaka", "BeerusMonaka", "BeerusMonaka2", "BeerusMonaka3", "Berryblue", "Botamo", "Champa", "Frost1", "Frost2", "Frost3", "Frost4", "Frost5", "Frost6", "Hit", "Krillin", "Magetta", "Roshi_super", "Shisami", "Sorbet", "Tagoma", "Vados", "Whis", "GokuBlack", "GokuBlackRose", "VegetaCopy", "VegetaCopyBlue", "Cabba", "CabbaSSJ", "Zamasu", "Zamasu_fused", "Zamasu_fused2", "Zamasu_fused3", "Zeno", "Goku_enemy", "Goku_enemy2", "Goku_enemy3", "Goku_enemy4", "Vegeta_enemy", "Vegeta_enemy2", "Vegeta_enemy3", "Vegeta_enemy4", "Gohan_enemy", "Gohan_enemy2", "Gohan_enemy2_1", "Gohan_enemy2_2", "Trunks_enemy", "Trunks_enemy2", "Trunks_enemy2_1", "Trunks_enemy2_2", "Awamo", "Camparri", "Cognac", "Cuktail", "Korn", "Kusu", "Marcarita", "Martinu", "Mohito", "Sour", "Arak", "Belmod", "Giin", "Heles", "Iwan", "Liquiir", "Mosco", "Quitela", "Rumsshi", "Sidra", "Basil", "Bergamo", "Lavender", "Brianne", "Caulifla", "Caulifla2", "Dyspo", "Jiren", "Jiren2", "Kale", "Kale2", "Kefla", "Kefla2", "Toppo", "Toppo2", "Aniraza", "Biarra", "Cocotte", "Dercori", "Ganos", "Ganos2", "Hop", "Kahseral", "Kakunsa", "Kunshi", "Majora", "Murichim", "Napapa", "Narirama", "Obni", "Paparoni", "Roasie", "Rylibeu", "Shosa", "Sorrel", "Borareta", "Koichiarator", "Koitsukai", "Panchia", "Katopesla", "Katopesla2", "Katopesla3", "Katopesla4", "DBSBroly", "DBSBroly2", "DBSBroly3", "DBSBroly4", "DBSBrolyBuff", "DBSBrolyBuffSSJ", "DBSBrolyLegendary", "DBSParagus", "DBSParagusOld", "Cheelai", "Cheelai2", "Lemo", "FortunetellerBaba", "BandagesTheMummy", "SeeThroughTheInvisibleMan", "FangsTheVampire", "SpikeTheDevil", "GrandpaGohan", "GrandpaGohan2", "Cymbal", "Drum", "KingPiccolo", "KingPiccolo2", "Piano", "Tambourine", "DBMasterRoshi", "DBMasterRoshi2", "DBMasterRoshi3", "BearThief", "TigerBandit", "Puar", "Yamcha", "Yamcha2", "Yamcha3", "Yamcha4", "Yamcha5", "DBMai", "DBPilaf", "DBShu", "DBMaiMecha", "DBPilafMecha", "DBShuMecha", "DBPilafMechaCombined", "Bacterian", "Giran", "JackieChun", "JackieChun2", "JackieChun3", "TournamentAnnouncer", "KingChappa", "ManWolf", "MasterShen", "Pamput", "TienShinhan", "TienShinhan2", "TienShinhan3", "Android8", "Buyon", "ColonelSilver", "ColonelViolet", "CommanderRed", "GeneralBlue", "GeneralBlue2", "GeneralWhite", "GeneralWhite2", "LaunchGood", "LaunchBad", "MajorMetallitron", "MajorMetallitron1", "MajorMetallitron2", "MajorMetallitron3", "MercenaryTao", "NinjaMurasaki", "RedRibbonSoldier", "RedRibbonSoldier2", "RedRibbonSoldier3", "RedRibbonSoldierB", "RedRibbonSoldierB2", "RedRibbonSoldierB3", "DBBora", "DBUpa", "Oolong", "Yajirobe", "MercenaryTao2", "MercenaryTao3", "OfficerBlack", "OfficerBlack2", "OfficerBlack3", "OfficeOgre", "OfficeOgre2", "OfficeOgre3", "OfficeOgre4", "OfficeOgre5", "DBZSpirit", "Chiaotzu", "Chiaotzu2", "Chiaotzu3", "Chiaotzu4", "TienShinhan4", "TienShinhan5", "TienShinhan6", "TienShinhan7" };
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 224 */     return entityNames;
/*     */   }
/*     */   
/*     */   private EntityDBC[] getEntityList(EntityPlayerMP entityplayermp) {
/* 228 */     EntityDBC[] entities = { (EntityDBC)new EntityNam(entityplayermp.field_70170_p), (EntityDBC)new EntityPiccolo(entityplayermp.field_70170_p), (EntityDBC)new EntityPiccolo2(entityplayermp.field_70170_p), (EntityDBC)new EntitySaiyanRaditz(entityplayermp.field_70170_p), (EntityDBC)new EntitySaiyanNappa(entityplayermp.field_70170_p), (EntityDBC)new EntitySaiyanVegeta(entityplayermp.field_70170_p), (EntityDBC)new EntitySaibaiman(entityplayermp.field_70170_p), (EntityDBC)new EntitySaiyan01(entityplayermp.field_70170_p), (EntityDBC)new EntitySaiyan02(entityplayermp.field_70170_p), (EntityDBC)new EntityHell01(entityplayermp.field_70170_p), (EntityDBC)new EntityHell02(entityplayermp.field_70170_p), (EntityDBC)new EntityKiwi(entityplayermp.field_70170_p), (EntityDBC)new EntityDodoria(entityplayermp.field_70170_p), (EntityDBC)new EntityZarbon(entityplayermp.field_70170_p), (EntityDBC)new EntityZarbon2(entityplayermp.field_70170_p), (EntityDBC)new EntityGuldo(entityplayermp.field_70170_p), (EntityDBC)new EntityRecoome(entityplayermp.field_70170_p), (EntityDBC)new EntityBarta(entityplayermp.field_70170_p), (EntityDBC)new EntityJeice(entityplayermp.field_70170_p), (EntityDBC)new EntityGinyu(entityplayermp.field_70170_p), (EntityDBC)new EntityFreezaSoldier1(entityplayermp.field_70170_p), (EntityDBC)new EntityFreezaSoldier2(entityplayermp.field_70170_p), (EntityDBC)new EntityFreezaSoldier3(entityplayermp.field_70170_p), (EntityDBC)new EntityFreeza1(entityplayermp.field_70170_p), (EntityDBC)new EntityFreeza2(entityplayermp.field_70170_p), (EntityDBC)new EntityFreeza3(entityplayermp.field_70170_p), (EntityDBC)new EntityFreeza4(entityplayermp.field_70170_p), (EntityDBC)new EntityFreeza5(entityplayermp.field_70170_p), (EntityDBC)new EntityFreeza6(entityplayermp.field_70170_p), (EntityDBC)new EntityFreeza7(entityplayermp.field_70170_p), (EntityDBC)new EntityFreezaFather(entityplayermp.field_70170_p), (EntityDBC)new EntityFreezaMecha(entityplayermp.field_70170_p), (EntityDBC)new EntityCyborg16(entityplayermp.field_70170_p), (EntityDBC)new EntityCyborg17(entityplayermp.field_70170_p), (EntityDBC)new EntityCyborg18(entityplayermp.field_70170_p), (EntityDBC)new EntityCyborg19(entityplayermp.field_70170_p), (EntityDBC)new EntityCyborg20(entityplayermp.field_70170_p), (EntityDBC)new EntityCell1(entityplayermp.field_70170_p), (EntityDBC)new EntityCell2(entityplayermp.field_70170_p), (EntityDBC)new EntityCell3(entityplayermp.field_70170_p), (EntityDBC)new EntityCell4(entityplayermp.field_70170_p), (EntityDBC)new EntityNamekian01(entityplayermp.field_70170_p), (EntityDBC)new EntityPuipui(entityplayermp.field_70170_p), (EntityDBC)new EntityYakon(entityplayermp.field_70170_p), (EntityDBC)new EntityDarbura(entityplayermp.field_70170_p), (EntityDBC)new EntityBuuFat(entityplayermp.field_70170_p), (EntityDBC)new EntityBuuSuper(entityplayermp.field_70170_p), (EntityDBC)new EntityDino01(entityplayermp.field_70170_p), (EntityDBC)new EntityBeerus(entityplayermp.field_70170_p), (EntityDBC)new EntityDino02(entityplayermp.field_70170_p), (EntityDBC)new EntityDino03(entityplayermp.field_70170_p), (EntityDBC)new EntityRRMecha(entityplayermp.field_70170_p), (EntityDBC)new EntitySabertooth(entityplayermp.field_70170_p), (EntityDBC)new EntityCellJr(entityplayermp.field_70170_p), (EntityDBC)new EntityBuuEvil(entityplayermp.field_70170_p), (EntityDBC)new EntityBuuFusion(entityplayermp.field_70170_p), (EntityDBC)new EntityBuuPiccolo(entityplayermp.field_70170_p), (EntityDBC)new EntityBuuUltimate(entityplayermp.field_70170_p), (EntityDBC)new EntityBuuBuffed(entityplayermp.field_70170_p), (EntityDBC)new EntityBuuKid(entityplayermp.field_70170_p), (EntityDBC)new EntityMonaka(entityplayermp.field_70170_p), (EntityDBC)new EntityBeerusMonaka(entityplayermp.field_70170_p), (EntityDBC)new EntityBeerusMonaka2(entityplayermp.field_70170_p), (EntityDBC)new EntityBeerusMonaka3(entityplayermp.field_70170_p), (EntityDBC)new EntityBerryblue(entityplayermp.field_70170_p), (EntityDBC)new EntityBotamo(entityplayermp.field_70170_p), (EntityDBC)new EntityChampa(entityplayermp.field_70170_p), (EntityDBC)new EntityFrost1(entityplayermp.field_70170_p), (EntityDBC)new EntityFrost2(entityplayermp.field_70170_p), (EntityDBC)new EntityFrost3(entityplayermp.field_70170_p), (EntityDBC)new EntityFrost4(entityplayermp.field_70170_p), (EntityDBC)new EntityFrost5(entityplayermp.field_70170_p), (EntityDBC)new EntityFrost6(entityplayermp.field_70170_p), (EntityDBC)new EntityHit(entityplayermp.field_70170_p), (EntityDBC)new EntityKrillin(entityplayermp.field_70170_p), (EntityDBC)new EntityMagetta(entityplayermp.field_70170_p), (EntityDBC)new EntityRoshi_super(entityplayermp.field_70170_p), (EntityDBC)new EntityShisami(entityplayermp.field_70170_p), (EntityDBC)new EntitySorbet(entityplayermp.field_70170_p), (EntityDBC)new EntityTagoma(entityplayermp.field_70170_p), (EntityDBC)new EntityVados(entityplayermp.field_70170_p), (EntityDBC)new EntityWhis(entityplayermp.field_70170_p), (EntityDBC)new EntityGokuBlack(entityplayermp.field_70170_p), (EntityDBC)new EntityGokuBlackRose(entityplayermp.field_70170_p), (EntityDBC)new EntityVegetaCopy(entityplayermp.field_70170_p), (EntityDBC)new EntityVegetaCopyBlue(entityplayermp.field_70170_p), (EntityDBC)new EntityCabba(entityplayermp.field_70170_p), (EntityDBC)new EntityCabbaSSJ(entityplayermp.field_70170_p), (EntityDBC)new EntityZamasu(entityplayermp.field_70170_p), (EntityDBC)new EntityZamasu_Fused(entityplayermp.field_70170_p), (EntityDBC)new EntityZamasu_Fused2(entityplayermp.field_70170_p), (EntityDBC)new EntityZamasu_Fused3(entityplayermp.field_70170_p), (EntityDBC)new EntityZeno(entityplayermp.field_70170_p), (EntityDBC)new EntityGoku(entityplayermp.field_70170_p), (EntityDBC)new EntityGoku2(entityplayermp.field_70170_p), (EntityDBC)new EntityGoku3(entityplayermp.field_70170_p), (EntityDBC)new EntityGoku4(entityplayermp.field_70170_p), (EntityDBC)new EntityVegeta(entityplayermp.field_70170_p), (EntityDBC)new EntityVegeta2(entityplayermp.field_70170_p), (EntityDBC)new EntityVegeta3(entityplayermp.field_70170_p), (EntityDBC)new EntityVegeta4(entityplayermp.field_70170_p), (EntityDBC)new EntityGohan(entityplayermp.field_70170_p), (EntityDBC)new EntityGohan2(entityplayermp.field_70170_p), (EntityDBC)new EntityGohan_orange(entityplayermp.field_70170_p), (EntityDBC)new EntityGohan_orange2(entityplayermp.field_70170_p), (EntityDBC)new EntityTrunks(entityplayermp.field_70170_p), (EntityDBC)new EntityTrunks2(entityplayermp.field_70170_p), (EntityDBC)new EntityTrunks_dbs(entityplayermp.field_70170_p), (EntityDBC)new EntityTrunks_dbs2(entityplayermp.field_70170_p), (EntityDBC)new EntityAngelAwamo(entityplayermp.field_70170_p), (EntityDBC)new EntityAngelCamparri(entityplayermp.field_70170_p), (EntityDBC)new EntityAngelCognac(entityplayermp.field_70170_p), (EntityDBC)new EntityAngelCukatail(entityplayermp.field_70170_p), (EntityDBC)new EntityAngelKorn(entityplayermp.field_70170_p), (EntityDBC)new EntityAngelKusu(entityplayermp.field_70170_p), (EntityDBC)new EntityAngelMarcarita(entityplayermp.field_70170_p), (EntityDBC)new EntityAngelMartinu(entityplayermp.field_70170_p), (EntityDBC)new EntityAngelMohito(entityplayermp.field_70170_p), (EntityDBC)new EntityAngelSour(entityplayermp.field_70170_p), (EntityDBC)new EntityGodArak(entityplayermp.field_70170_p), (EntityDBC)new EntityGodBelmod(entityplayermp.field_70170_p), (EntityDBC)new EntityGodGiin(entityplayermp.field_70170_p), (EntityDBC)new EntityGodHeles(entityplayermp.field_70170_p), (EntityDBC)new EntityGodIwan(entityplayermp.field_70170_p), (EntityDBC)new EntityGodLiquiir(entityplayermp.field_70170_p), (EntityDBC)new EntityGodMosco(entityplayermp.field_70170_p), (EntityDBC)new EntityGodQuitela(entityplayermp.field_70170_p), (EntityDBC)new EntityGodRumsshi(entityplayermp.field_70170_p), (EntityDBC)new EntityGodSidra(entityplayermp.field_70170_p), (EntityDBC)new EntityBasil(entityplayermp.field_70170_p), (EntityDBC)new EntityBergamo(entityplayermp.field_70170_p), (EntityDBC)new EntityLavender(entityplayermp.field_70170_p), (EntityDBC)new EntityBrianne(entityplayermp.field_70170_p), (EntityDBC)new EntityCaulifla(entityplayermp.field_70170_p), (EntityDBC)new EntityCaulifla2(entityplayermp.field_70170_p), (EntityDBC)new EntityDyspo(entityplayermp.field_70170_p), (EntityDBC)new EntityJiren(entityplayermp.field_70170_p), (EntityDBC)new EntityJiren2(entityplayermp.field_70170_p), (EntityDBC)new EntityKale(entityplayermp.field_70170_p), (EntityDBC)new EntityKale2(entityplayermp.field_70170_p), (EntityDBC)new EntityKefla(entityplayermp.field_70170_p), (EntityDBC)new EntityKefla2(entityplayermp.field_70170_p), (EntityDBC)new EntityToppo(entityplayermp.field_70170_p), (EntityDBC)new EntityToppo2(entityplayermp.field_70170_p), (EntityDBC)new EntityAniraza(entityplayermp.field_70170_p), (EntityDBC)new EntityBiarra(entityplayermp.field_70170_p), (EntityDBC)new EntityCocotte(entityplayermp.field_70170_p), (EntityDBC)new EntityDercori(entityplayermp.field_70170_p), (EntityDBC)new EntityGanos(entityplayermp.field_70170_p), (EntityDBC)new EntityGanos2(entityplayermp.field_70170_p), (EntityDBC)new EntityHop(entityplayermp.field_70170_p), (EntityDBC)new EntityKahseral(entityplayermp.field_70170_p), (EntityDBC)new EntityKakunsa(entityplayermp.field_70170_p), (EntityDBC)new EntityKunshi(entityplayermp.field_70170_p), (EntityDBC)new EntityMajora(entityplayermp.field_70170_p), (EntityDBC)new EntityMurichim(entityplayermp.field_70170_p), (EntityDBC)new EntityNapapa(entityplayermp.field_70170_p), (EntityDBC)new EntityNarirama(entityplayermp.field_70170_p), (EntityDBC)new EntityObni(entityplayermp.field_70170_p), (EntityDBC)new EntityPaparoni(entityplayermp.field_70170_p), (EntityDBC)new EntityRoasie(entityplayermp.field_70170_p), (EntityDBC)new EntityRylibeu(entityplayermp.field_70170_p), (EntityDBC)new EntityShosa(entityplayermp.field_70170_p), (EntityDBC)new EntitySorrel(entityplayermp.field_70170_p), (EntityDBC)new EntityBorareta(entityplayermp.field_70170_p), (EntityDBC)new EntityKoichiarator(entityplayermp.field_70170_p), (EntityDBC)new EntityKoitsukai(entityplayermp.field_70170_p), (EntityDBC)new EntityPanchia(entityplayermp.field_70170_p), (EntityDBC)new EntityKatopesla(entityplayermp.field_70170_p), (EntityDBC)new EntityKatopesla2(entityplayermp.field_70170_p), (EntityDBC)new EntityKatopesla3(entityplayermp.field_70170_p), (EntityDBC)new EntityKatopesla4(entityplayermp.field_70170_p), (EntityDBC)new EntityDBSBroly1(entityplayermp.field_70170_p), (EntityDBC)new EntityDBSBroly2(entityplayermp.field_70170_p), (EntityDBC)new EntityDBSBroly3(entityplayermp.field_70170_p), (EntityDBC)new EntityDBSBroly4(entityplayermp.field_70170_p), (EntityDBC)new EntityDBSBrolyBuff(entityplayermp.field_70170_p), (EntityDBC)new EntityDBSBrolyBuffSSJ(entityplayermp.field_70170_p), (EntityDBC)new EntityDBSBrolyLegendary(entityplayermp.field_70170_p), (EntityDBC)new EntityDBSParagus(entityplayermp.field_70170_p), (EntityDBC)new EntityDBSParagus2(entityplayermp.field_70170_p), (EntityDBC)new EntityCheelai(entityplayermp.field_70170_p), (EntityDBC)new EntityCheelai2(entityplayermp.field_70170_p), (EntityDBC)new EntityLemo(entityplayermp.field_70170_p), (EntityDBC)new EntityFortunetellerBaba(entityplayermp.field_70170_p), (EntityDBC)new EntityMummy(entityplayermp.field_70170_p), (EntityDBC)new EntityInvisibleMan(entityplayermp.field_70170_p), (EntityDBC)new EntityVampire(entityplayermp.field_70170_p), (EntityDBC)new EntityDevil(entityplayermp.field_70170_p), (EntityDBC)new EntityGrandpaGohan(entityplayermp.field_70170_p), (EntityDBC)new EntityGrandpaGohan2(entityplayermp.field_70170_p), (EntityDBC)new EntityCymbal(entityplayermp.field_70170_p), (EntityDBC)new EntityDrum(entityplayermp.field_70170_p), (EntityDBC)new EntityKingPiccolo(entityplayermp.field_70170_p), (EntityDBC)new EntityKingPiccolo2(entityplayermp.field_70170_p), (EntityDBC)new EntityPiano(entityplayermp.field_70170_p), (EntityDBC)new EntityTambourine(entityplayermp.field_70170_p), (EntityDBC)new EntityDBMasterRoshi(entityplayermp.field_70170_p), (EntityDBC)new EntityDBMasterRoshi2(entityplayermp.field_70170_p), (EntityDBC)new EntityDBMasterRoshi3(entityplayermp.field_70170_p), (EntityDBC)new EntityBearThief(entityplayermp.field_70170_p), (EntityDBC)new EntityTigerBandit(entityplayermp.field_70170_p), (EntityDBC)new EntityPuar(entityplayermp.field_70170_p), (EntityDBC)new EntityYamcha(entityplayermp.field_70170_p), (EntityDBC)new EntityYamcha2(entityplayermp.field_70170_p), (EntityDBC)new EntityYamcha3(entityplayermp.field_70170_p), (EntityDBC)new EntityYamcha4(entityplayermp.field_70170_p), (EntityDBC)new EntityYamcha5(entityplayermp.field_70170_p), (EntityDBC)new EntityMai(entityplayermp.field_70170_p), (EntityDBC)new EntityPilaf(entityplayermp.field_70170_p), (EntityDBC)new EntityShu(entityplayermp.field_70170_p), (EntityDBC)new EntityMaiMecha(entityplayermp.field_70170_p), (EntityDBC)new EntityPilafMecha(entityplayermp.field_70170_p), (EntityDBC)new EntityShuMecha(entityplayermp.field_70170_p), (EntityDBC)new EntityPilafMechaCombined(entityplayermp.field_70170_p), (EntityDBC)new EntityBacterian(entityplayermp.field_70170_p), (EntityDBC)new EntityGiran(entityplayermp.field_70170_p), (EntityDBC)new EntityJackieChun(entityplayermp.field_70170_p), (EntityDBC)new EntityJackieChun2(entityplayermp.field_70170_p), (EntityDBC)new EntityJackieChun3(entityplayermp.field_70170_p), (EntityDBC)new EntityTournamentAnnouncer(entityplayermp.field_70170_p), (EntityDBC)new EntityKingChappa(entityplayermp.field_70170_p), (EntityDBC)new EntityManWolf(entityplayermp.field_70170_p), (EntityDBC)new EntityMasterShen(entityplayermp.field_70170_p), (EntityDBC)new EntityPamput(entityplayermp.field_70170_p), (EntityDBC)new EntityTien(entityplayermp.field_70170_p), (EntityDBC)new EntityTien2(entityplayermp.field_70170_p), (EntityDBC)new EntityTien3(entityplayermp.field_70170_p), (EntityDBC)new EntityAndroid8(entityplayermp.field_70170_p), (EntityDBC)new EntityBuyon(entityplayermp.field_70170_p), (EntityDBC)new EntityColonelSilver(entityplayermp.field_70170_p), (EntityDBC)new EntityColonelViolet(entityplayermp.field_70170_p), (EntityDBC)new EntityCommanderRed(entityplayermp.field_70170_p), (EntityDBC)new EntityGeneralBlue(entityplayermp.field_70170_p), (EntityDBC)new EntityGeneralBlue2(entityplayermp.field_70170_p), (EntityDBC)new EntityGeneralWhite(entityplayermp.field_70170_p), (EntityDBC)new EntityGeneralWhite2(entityplayermp.field_70170_p), (EntityDBC)new EntityLaunch(entityplayermp.field_70170_p), (EntityDBC)new EntityLaunch2(entityplayermp.field_70170_p), (EntityDBC)new EntityMajorMetallitron(entityplayermp.field_70170_p), (EntityDBC)new EntityMajorMetallitron1(entityplayermp.field_70170_p), (EntityDBC)new EntityMajorMetallitron2(entityplayermp.field_70170_p), (EntityDBC)new EntityMajorMetallitron3(entityplayermp.field_70170_p), (EntityDBC)new EntityMercenaryTao(entityplayermp.field_70170_p), (EntityDBC)new EntityNinjaMurasaki(entityplayermp.field_70170_p), (EntityDBC)new EntityRedRibbonSoldier(entityplayermp.field_70170_p), (EntityDBC)new EntityRedRibbonSoldier2(entityplayermp.field_70170_p), (EntityDBC)new EntityRedRibbonSoldier3(entityplayermp.field_70170_p), (EntityDBC)new EntityRedRibbonSoldierB(entityplayermp.field_70170_p), (EntityDBC)new EntityRedRibbonSoldierB2(entityplayermp.field_70170_p), (EntityDBC)new EntityRedRibbonSoldierB3(entityplayermp.field_70170_p), (EntityDBC)new EntityBora(entityplayermp.field_70170_p), (EntityDBC)new EntityUpa(entityplayermp.field_70170_p), (EntityDBC)new EntityOolong(entityplayermp.field_70170_p), (EntityDBC)new EntityYajirobe(entityplayermp.field_70170_p), (EntityDBC)new EntityMercenaryTao2(entityplayermp.field_70170_p), (EntityDBC)new EntityMercenaryTao3(entityplayermp.field_70170_p), (EntityDBC)new EntityOfficerBlack(entityplayermp.field_70170_p), (EntityDBC)new EntityOfficerBlack2(entityplayermp.field_70170_p), (EntityDBC)new EntityOfficerBlack3(entityplayermp.field_70170_p), (EntityDBC)new EntityOfficeOgre(entityplayermp.field_70170_p), (EntityDBC)new EntityOfficeOgre2(entityplayermp.field_70170_p), (EntityDBC)new EntityOfficeOgre3(entityplayermp.field_70170_p), (EntityDBC)new EntityOfficeOgre4(entityplayermp.field_70170_p), (EntityDBC)new EntityOfficeOgre5(entityplayermp.field_70170_p), (EntityDBC)new EntitySpirit(entityplayermp.field_70170_p), (EntityDBC)new EntityChiaotzu(entityplayermp.field_70170_p), (EntityDBC)new EntityChiaotzu2(entityplayermp.field_70170_p), (EntityDBC)new EntityChiaotzu3(entityplayermp.field_70170_p), (EntityDBC)new EntityChiaotzu4(entityplayermp.field_70170_p), (EntityDBC)new EntityTien4(entityplayermp.field_70170_p), (EntityDBC)new EntityTien5(entityplayermp.field_70170_p), (EntityDBC)new EntityTien6(entityplayermp.field_70170_p), (EntityDBC)new EntityTien7(entityplayermp.field_70170_p) };
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
/* 294 */     return entities;
/*     */   }
/*     */ 
/*     */   
/*     */   public List func_71516_a(ICommandSender par1ICommandSender, String[] arrayString) {
/* 299 */     int length = arrayString.length;
/* 300 */     switch (length) { case 1:
/* 301 */         return func_71530_a(arrayString, getEntityNameList());
/* 302 */       case 2: return func_71530_a(arrayString, new String[] { "1000" });
/* 303 */       case 3: return func_71530_a(arrayString, new String[] { "1000" });
/* 304 */       case 4: return func_71530_a(arrayString, getListOfPlayers()); }
/* 305 */      return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected String[] getListOfPlayers() {
/* 311 */     return MinecraftServer.func_71276_C().func_71213_z();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isUsernameIndex(int id) {
/* 316 */     return (id == 3);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Gui\ComDbcSpawn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */