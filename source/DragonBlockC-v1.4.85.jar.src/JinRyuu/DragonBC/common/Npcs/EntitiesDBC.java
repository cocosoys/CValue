/*      */ package JinRyuu.DragonBC.common.Npcs;
/*      */ import JinRyuu.DragonBC.common.DBCConfig;
/*      */ import JinRyuu.DragonBC.common.Entitys.EntityEnergyFM;
/*      */ import JinRyuu.DragonBC.common.Entitys.EntityInstantTransmission;
/*      */ import JinRyuu.DragonBC.common.Entitys.EntityMajinAbsorption;
/*      */ import JinRyuu.DragonBC.common.Entitys.RenderEnergyFM;
/*      */ import JinRyuu.DragonBC.common.Entitys.RenderInstantTransmission;
/*      */ import JinRyuu.DragonBC.common.Entitys.RenderMajinAbsorption;
/*      */ import JinRyuu.DragonBC.common.Npcs.db.EntityBearThief;
/*      */ import JinRyuu.DragonBC.common.Npcs.db.EntityBora;
/*      */ import JinRyuu.DragonBC.common.Npcs.db.EntityDBMasterRoshi;
/*      */ import JinRyuu.DragonBC.common.Npcs.db.EntityDBMasterRoshi2;
/*      */ import JinRyuu.DragonBC.common.Npcs.db.EntityDBMasterRoshi3;
/*      */ import JinRyuu.DragonBC.common.Npcs.db.EntityOolong;
/*      */ import JinRyuu.DragonBC.common.Npcs.db.EntityPuar;
/*      */ import JinRyuu.DragonBC.common.Npcs.db.EntityTigerBandit;
/*      */ import JinRyuu.DragonBC.common.Npcs.db.EntityUpa;
/*      */ import JinRyuu.DragonBC.common.Npcs.db.EntityYajirobe;
/*      */ import JinRyuu.DragonBC.common.Npcs.db.EntityYamcha;
/*      */ import JinRyuu.DragonBC.common.Npcs.db.EntityYamcha2;
/*      */ import JinRyuu.DragonBC.common.Npcs.db.EntityYamcha3;
/*      */ import JinRyuu.DragonBC.common.Npcs.db.EntityYamcha4;
/*      */ import JinRyuu.DragonBC.common.Npcs.db.EntityYamcha5;
/*      */ import JinRyuu.DragonBC.common.Npcs.db.ModelBearThief;
/*      */ import JinRyuu.DragonBC.common.Npcs.db.ModelBora;
/*      */ import JinRyuu.DragonBC.common.Npcs.db.ModelMasterRoshi;
/*      */ import JinRyuu.DragonBC.common.Npcs.db.ModelMasterRoshi2;
/*      */ import JinRyuu.DragonBC.common.Npcs.db.ModelMasterRoshi3;
/*      */ import JinRyuu.DragonBC.common.Npcs.db.ModelOolong;
/*      */ import JinRyuu.DragonBC.common.Npcs.db.ModelPuar;
/*      */ import JinRyuu.DragonBC.common.Npcs.db.ModelTigerBandit;
/*      */ import JinRyuu.DragonBC.common.Npcs.db.ModelUpa;
/*      */ import JinRyuu.DragonBC.common.Npcs.db.ModelYajirobe;
/*      */ import JinRyuu.DragonBC.common.Npcs.db.ModelYamcha;
/*      */ import JinRyuu.DragonBC.common.Npcs.db.ModelYamcha2;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbbaba.EntityDevil;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbbaba.EntityFortunetellerBaba;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbbaba.EntityGrandpaGohan;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbbaba.EntityGrandpaGohan2;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbbaba.EntityInvisibleMan;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbbaba.EntityMummy;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbbaba.EntityVampire;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbbaba.ModelDevil;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbbaba.ModelFortunetellerBaba;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbbaba.ModelGrandpaGohan;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbbaba.ModelInvisibleMan;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbbaba.ModelMummy;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbbaba.ModelVampire;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbkingpiccolo.EntityCymbal;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbkingpiccolo.EntityDrum;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbkingpiccolo.EntityKingPiccolo;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbkingpiccolo.EntityKingPiccolo2;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbkingpiccolo.EntityPiano;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbkingpiccolo.EntityTambourine;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbkingpiccolo.ModelCymbal;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbkingpiccolo.ModelDrum;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbkingpiccolo.ModelKingPiccolo;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbkingpiccolo.ModelKingPiccolo2;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbkingpiccolo.ModelPiano;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbkingpiccolo.ModelTambourine;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbpilaf.EntityMai;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbpilaf.EntityMaiMecha;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbpilaf.EntityPilaf;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbpilaf.EntityPilafMecha;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbpilaf.EntityPilafMechaCombined;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbpilaf.EntityShu;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbpilaf.EntityShuMecha;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbpilaf.ModelMai;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbpilaf.ModelMaiMecha;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbpilaf.ModelPilaf;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbpilaf.ModelPilafMecha;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbpilaf.ModelPilafMechaCombined;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbpilaf.ModelShu;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbpilaf.ModelShuMecha;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityAndroid8;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityBuyon;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityColonelSilver;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityColonelViolet;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityCommanderRed;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityGeneralBlue;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityGeneralBlue2;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityGeneralWhite;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityGeneralWhite2;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityLaunch;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityLaunch2;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityMajorMetallitron;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityMajorMetallitron1;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityMajorMetallitron2;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityMajorMetallitron3;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityMercenaryTao;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityMercenaryTao2;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityMercenaryTao3;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityNinjaMurasaki;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityOfficerBlack;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityOfficerBlack2;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityOfficerBlack3;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityRedRibbonSoldier;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityRedRibbonSoldier2;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityRedRibbonSoldier3;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityRedRibbonSoldierB;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityRedRibbonSoldierB2;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityRedRibbonSoldierB3;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.ModelAndroid8;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.ModelBuyon;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.ModelColonelSilver;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.ModelColonelViolet;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.ModelCommanderRed;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.ModelGeneralBlue;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.ModelGeneralWhite;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.ModelLaunch;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.ModelMajorMetallitron;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.ModelMercenaryTao;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.ModelMercenaryTao2;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.ModelNinjaMurasaki;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.ModelOfficerBlack;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.ModelOfficerBlack2;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.ModelRedRibbonSoldierBazooka;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.ModelRedRibbonSoldierGunner;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbsbroly.EntityCheelai;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbsbroly.EntityCheelai2;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbsbroly.EntityDBSBroly1;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbsbroly.EntityDBSBroly2;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbsbroly.EntityDBSBroly3;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbsbroly.EntityDBSBroly4;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbsbroly.EntityDBSBrolyBuff;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbsbroly.EntityDBSBrolyBuffSSJ;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbsbroly.EntityDBSBrolyLegendary;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbsbroly.EntityDBSParagus;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbsbroly.EntityDBSParagus2;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbsbroly.EntityLemo;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbsbroly.ModelCheelai;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbsbroly.ModelDBSBrolyBuff;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbsbroly.ModelDBSBrolyLegendary;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbsbroly.ModelDBSBrolyNormal;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbsbroly.ModelDBSParagus;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbsbroly.ModelDBSParagus2;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbsbroly.ModelLemo;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityBacterian;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityChiaotzu;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityChiaotzu2;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityChiaotzu3;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityChiaotzu4;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityGiran;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityJackieChun;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityJackieChun2;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityJackieChun3;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityKingChappa;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityManWolf;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityMasterShen;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityNam;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityPamput;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityTien;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityTien2;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityTien3;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityTien4;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityTien5;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityTien6;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityTien7;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.EntityTournamentAnnouncer;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.ModelBacterian;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.ModelChiaotzu;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.ModelChiaotzu2;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.ModelGiran;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.ModelJackieChun;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.ModelJackieChun2;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.ModelJackieChun3;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.ModelKingChappa;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.ModelManWolf;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.ModelMasterShen;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.ModelNam;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.ModelPamput;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.ModelTien;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.ModelTien2;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbtournament.ModelTournamentAnnouncer;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbz.EntityOfficeOgre;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbz.EntityOfficeOgre2;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbz.EntityOfficeOgre3;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbz.EntityOfficeOgre4;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbz.EntityOfficeOgre5;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbz.EntitySpirit;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbz.ModelOfficeOgre;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbz.ModelOfficeOgre2;
/*      */ import JinRyuu.DragonBC.common.Npcs.dbz.ModelSpirit;
/*      */ import JinRyuu.DragonBC.common.Render.ArtGravDevRender;
/*      */ import JinRyuu.DragonBC.common.Render.ArtGravDevTileEntity;
/*      */ import JinRyuu.DragonBC.common.Render.DragonBlock01Render;
/*      */ import JinRyuu.DragonBC.common.Render.DragonBlock01TileEntity;
/*      */ import JinRyuu.DragonBC.common.Render.DragonBlockNS01Render;
/*      */ import JinRyuu.DragonBC.common.Render.DragonBlockNS01TileEntity;
/*      */ import JinRyuu.DragonBC.common.Render.DragonBlockNamek01Render;
/*      */ import JinRyuu.DragonBC.common.Render.DragonBlockNamek01TileEntity;
/*      */ import JinRyuu.DragonBC.common.Render.DragonBlockS01Render;
/*      */ import JinRyuu.DragonBC.common.Render.DragonBlockS01TileEntity;
/*      */ import JinRyuu.DragonBC.common.Render.KintounBlackEntity;
/*      */ import JinRyuu.DragonBC.common.Render.KintounEntity;
/*      */ import JinRyuu.DragonBC.common.Render.KintounRender;
/*      */ import JinRyuu.DragonBC.common.Render.MedPodDoor1Render;
/*      */ import JinRyuu.DragonBC.common.Render.MedPodDoor1TileEntity;
/*      */ import JinRyuu.DragonBC.common.Render.SaibaiHatchedRender;
/*      */ import JinRyuu.DragonBC.common.Render.SaibaiHatchedTileEntity;
/*      */ import JinRyuu.DragonBC.common.Render.SpacePod01Entity;
/*      */ import JinRyuu.DragonBC.common.Render.SpacePod01Render;
/*      */ import JinRyuu.DragonBC.common.Render.SpacePod01RenderPod;
/*      */ import JinRyuu.DragonBC.common.Render.SpacePod01TileEntity;
/*      */ import JinRyuu.DragonBC.common.Render.block01dbcEntity;
/*      */ import JinRyuu.DragonBC.common.Render.block01dbcRender;
/*      */ import JinRyuu.DragonBC.common.Render.namekian_throneTileEntity;
/*      */ import JinRyuu.DragonBC.common.Render.ppRender;
/*      */ import JinRyuu.DragonBC.common.Render.ppTileEntity;
/*      */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*      */ import JinRyuu.JRMCore.entity.EntityEnergyAtt;
/*      */ import JinRyuu.JRMCore.entity.EntityPrjtls_1;
/*      */ import JinRyuu.JRMCore.entity.RenderEnergyAttackKi;
/*      */ import JinRyuu.JRMCore.entity.RenderPrjtls_1;
/*      */ import cpw.mods.fml.client.registry.ClientRegistry;
/*      */ import cpw.mods.fml.client.registry.RenderingRegistry;
/*      */ import cpw.mods.fml.common.registry.EntityRegistry;
/*      */ import cpw.mods.fml.common.registry.GameRegistry;
/*      */ import cpw.mods.fml.relauncher.Side;
/*      */ import cpw.mods.fml.relauncher.SideOnly;
/*      */ import net.minecraft.client.model.ModelBase;
/*      */ import net.minecraft.client.renderer.entity.Render;
/*      */ import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EnumCreatureType;
/*      */ import net.minecraft.world.biome.BiomeGenBase;
/*      */ 
/*      */ public final class EntitiesDBC {
/*  229 */   public static int renderId = 100;
/*  230 */   public static int entityID = 0; public static int nextEntityID() {
/*  231 */     entityID++; return entityID;
/*      */   }
/*      */   
/*      */   public static void addEntityClient(Class<? extends Entity> entityClass, Render renderer) {
/*  235 */     RenderingRegistry.registerEntityRenderingHandler(entityClass, renderer);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void addEntityServer(Class<? extends Entity> entityClass, String entityName) {
/*  240 */     addEntityServer(entityClass, entityName, 80, 5);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void addEntityServer(Class<? extends Entity> entityClass, String entityName, int updateFrequency) {
/*  245 */     addEntityServer(entityClass, entityName, 80, updateFrequency, true);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void addEntityServer(Class<? extends Entity> entityClass, String entityName, int trackingRange, int updateFrequency) {
/*  250 */     addEntityServer(entityClass, entityName, trackingRange, updateFrequency, true);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void addEntityServer(Class<? extends Entity> entityClass, String entityName, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates) {
/*  255 */     EntityRegistry.registerModEntity(entityClass, entityName, nextEntityID(), mod_DragonBC.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public static void client() {
/*  263 */     addEntityClient((Class)EntityEnergyAtt.class, (Render)new RenderEnergyAttackKi());
/*  264 */     addEntityClient((Class)EntityEnergyFM.class, (Render)new RenderEnergyFM());
/*  265 */     addEntityClient((Class)EntityPrjtls_1.class, (Render)new RenderPrjtls_1());
/*      */     
/*  267 */     addEntityClient((Class)SpacePod01Entity.class, (Render)new SpacePod01RenderPod());
/*  268 */     addEntityClient((Class)KintounEntity.class, (Render)new KintounRender(0));
/*  269 */     addEntityClient((Class)KintounBlackEntity.class, (Render)new KintounRender(1));
/*      */ 
/*      */     
/*  272 */     addEntityClient((Class)EntityAuraRed.class, (Render)new RenderAuraRed());
/*  273 */     addEntityClient((Class)EntityAuraSup.class, (Render)new RenderAuraSup());
/*  274 */     addEntityClient((Class)EntityAuraPur.class, (Render)new RenderAuraPur());
/*  275 */     addEntityClient((Class)EntityPorunga.class, (Render)new RenderPorunga());
/*  276 */     addEntityClient((Class)EntityPorunga2.class, (Render)new RenderPorunga2());
/*  277 */     addEntityClient((Class)EntityDragon2.class, (Render)new RenderDBC(new ModelDragon(), 0.5F));
/*  278 */     addEntityClient((Class)EntityDragon.class, (Render)new RenderDBC(new ModelDragon(), 0.5F));
/*  279 */     addEntityClient((Class)EntityAura.class, (Render)new RenderAura());
/*  280 */     addEntityClient((Class)EntityAuraRing.class, (Render)new RenderAuraRing());
/*  281 */     addEntityClient((Class)EntityAuraRingSup.class, (Render)new RenderAuraRingSup());
/*  282 */     addEntityClient((Class)EntityAuraRingPur.class, (Render)new RenderAuraRingPur());
/*  283 */     addEntityClient((Class)EntityAuraRingRed.class, (Render)new RenderAuraRingRed());
/*      */     
/*  285 */     addEntityClient((Class)EntityAuraLightning.class, (Render)new RenderAuraLightning());
/*  286 */     addEntityClient((Class)EntityAura2.class, (Render)new RenderAura2());
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  291 */     addEntityClient((Class)EntityHell01.class, (Render)new RenderDBC((ModelBase)new ModelNPCNormal(), 0.5F));
/*  292 */     addEntityClient((Class)EntityHell02.class, (Render)new RenderDBC((ModelBase)new ModelNPCNormal(), 0.5F));
/*  293 */     addEntityClient((Class)EntityMasterEnma.class, (Render)new RenderDBC(new ModelEnma(), 0.5F));
/*  294 */     addEntityClient((Class)EntityMasterKami.class, (Render)new RenderDBC((ModelBase)new ModelNPCNormal(), 0.5F));
/*  295 */     addEntityClient((Class)EntityMasterKaio.class, (Render)new RenderDBC(new ModelKaio(), 0.5F));
/*  296 */     addEntityClient((Class)EntityMasterKarin.class, (Render)new RenderDBC((ModelBase)new ModelKarin(), 0.5F));
/*  297 */     addEntityClient((Class)EntityMasterRoshi.class, (Render)new RenderDBC((ModelBase)new ModelRoshi(1.0F), 0.5F));
/*  298 */     addEntityClient((Class)EntityMasterCell.class, (Render)new RenderDBC((ModelBase)new ModelRaditz(), 0.5F));
/*  299 */     addEntityClient((Class)EntityMasterGoku.class, (Render)new RenderDBC((ModelBase)new ModelDBCZed(0), 0.5F));
/*  300 */     addEntityClient((Class)EntityMasterGohan.class, (Render)new RenderDBC((ModelBase)new ModelDBCZed(1), 0.5F));
/*  301 */     addEntityClient((Class)EntityMasterTrunksFuture.class, (Render)new RenderDBC((ModelBase)new ModelDBCZed(2), 0.5F));
/*  302 */     addEntityClient((Class)EntityMasterFreeza.class, (Render)new RenderDBC((ModelBase)new ModelFr4(), 0.5F));
/*  303 */     addEntityClient((Class)EntityMasterJin.class, (Render)new RenderDBC((ModelBase)new ModelDBCZed(2), 0.5F));
/*  304 */     addEntityClient((Class)EntityMasterGuru.class, (Render)new RenderDBC(new ModelGuru(), 0.5F));
/*  305 */     addEntityClient((Class)EntityMasterWhis.class, (Render)new RenderDBC(new ModelWhis(), 0.5F));
/*      */     
/*  307 */     addEntityClient((Class)EntityNamekian01.class, (Render)new RenderDBC((ModelBase)new ModelNPCNormal(), 0.5F));
/*  308 */     addEntityClient((Class)EntityNamekian03.class, (Render)new RenderDBC((ModelBase)new ModelNPCNormal(), 0.5F));
/*  309 */     addEntityClient((Class)EntitySaiyan01.class, (Render)new RenderDBC((ModelBase)new ModelNPCNormal(), 0.5F));
/*  310 */     addEntityClient((Class)EntitySaiyan02.class, (Render)new RenderDBC((ModelBase)new ModelNPCNormal(), 0.5F));
/*  311 */     addEntityClient((Class)EntitySaibaiman.class, (Render)new RenderDBC((ModelBase)new ModelSaibaiman(), 0.5F));
/*  312 */     addEntityClient((Class)EntitySaiyanRaditz.class, (Render)new RenderDBC((ModelBase)new ModelRaditz(), 0.5F));
/*  313 */     addEntityClient((Class)EntitySaiyanNappa.class, (Render)new RenderDBC((ModelBase)new ModelRaditz(), 0.5F));
/*  314 */     addEntityClient((Class)EntitySaiyanVegeta.class, (Render)new RenderDBC((ModelBase)new ModelVegeta(), 0.5F));
/*      */     
/*  316 */     addEntityClient((Class)EntityDino01.class, (Render)new RenderDBC(new ModelDino01(), 0.5F));
/*  317 */     addEntityClient((Class)EntityDino02.class, (Render)new RenderDBC(new ModelDino02(), 0.5F));
/*  318 */     addEntityClient((Class)EntityDino03.class, (Render)new RenderDBC(new ModelDino03(), 0.5F));
/*  319 */     addEntityClient((Class)EntityRRMecha.class, (Render)new RenderDBC(new ModelRRMecha(), 0.5F));
/*  320 */     addEntityClient((Class)EntitySabertooth.class, (Render)new RenderDBC(new ModelSabertooth(), 0.5F));
/*      */ 
/*      */ 
/*      */     
/*  324 */     addEntityClient((Class)EntityKiwi.class, (Render)new RenderDBC((ModelBase)new ModelRaditz(), 0.5F));
/*  325 */     addEntityClient((Class)EntityDodoria.class, (Render)new RenderDBC((ModelBase)new ModelRaditz(), 0.5F));
/*  326 */     addEntityClient((Class)EntityZarbon.class, (Render)new RenderDBC((ModelBase)new ModelRaditz(), 0.5F));
/*  327 */     addEntityClient((Class)EntityGuldo.class, (Render)new RenderDBC((ModelBase)new ModelRaditz(0.6F, false, true), 0.5F));
/*  328 */     addEntityClient((Class)EntityRecoome.class, (Render)new RenderDBC((ModelBase)new ModelRaditz(), 0.5F));
/*  329 */     addEntityClient((Class)EntityBarta.class, (Render)new RenderDBC((ModelBase)new ModelRaditz(), 0.5F));
/*  330 */     addEntityClient((Class)EntityJeice.class, (Render)new RenderDBC((ModelBase)new ModelRaditz(), 0.5F));
/*  331 */     addEntityClient((Class)EntityGinyu.class, (Render)new RenderDBC((ModelBase)new ModelRaditz(), 0.5F));
/*  332 */     addEntityClient((Class)EntityFreezaSoldier1.class, (Render)new RenderDBC((ModelBase)new ModelRaditz(), 0.5F));
/*  333 */     addEntityClient((Class)EntityFreezaSoldier2.class, (Render)new RenderDBC((ModelBase)new ModelRaditz(), 0.5F));
/*  334 */     addEntityClient((Class)EntityFreezaSoldier3.class, (Render)new RenderDBC((ModelBase)new ModelRaditz(), 0.5F));
/*  335 */     addEntityClient((Class)EntityFreeza1.class, (Render)new RenderDBC((ModelBase)new ModelRaditz(), 0.5F));
/*  336 */     addEntityClient((Class)EntityFreeza2.class, (Render)new RenderDBC((ModelBase)new ModelRaditz(1.25F), 0.5F));
/*  337 */     addEntityClient((Class)EntityFreeza3.class, (Render)new RenderDBC((ModelBase)new ModelRaditz(1.25F), 0.5F));
/*  338 */     addEntityClient((Class)EntityFreeza4.class, (Render)new RenderDBC((ModelBase)new ModelFr4(), 0.5F));
/*  339 */     addEntityClient((Class)EntityFreeza5.class, (Render)new RenderDBC((ModelBase)new ModelFr4(), 0.5F));
/*  340 */     addEntityClient((Class)EntityFreeza6.class, (Render)new RenderDBC((ModelBase)new ModelFr6(), 0.5F));
/*  341 */     addEntityClient((Class)EntityPuipui.class, (Render)new RenderDBC((ModelBase)new ModelRaditz(), 0.5F));
/*  342 */     addEntityClient((Class)EntityYakon.class, (Render)new RenderDBC((ModelBase)new ModelYakon(2.0F), 0.5F));
/*  343 */     addEntityClient((Class)EntityDarbura.class, (Render)new RenderDBC((ModelBase)new ModelRaditz(), 0.5F));
/*  344 */     addEntityClient((Class)EntityBuuFat.class, (Render)new RenderDBC((ModelBase)new ModelBuuFat(), 0.5F));
/*  345 */     addEntityClient((Class)EntityBuuSuper.class, (Render)new RenderDBC(new ModelBuuSuper(), 0.5F));
/*  346 */     addEntityClient((Class)EntityMasterBabidi.class, (Render)new RenderDBC((ModelBase)new ModelBabidi(), 0.5F));
/*      */     
/*  348 */     addEntityClient((Class)EntityBeerus.class, (Render)new RenderDBC(new ModelBeerus(), 0.5F));
/*      */ 
/*      */ 
/*      */     
/*  352 */     addEntityClient((Class)EntityFreezaFather.class, (Render)new RenderDBC((ModelBase)new ModelRaditz(2.0F), 0.5F));
/*  353 */     addEntityClient((Class)EntityFreezaMecha.class, (Render)new RenderDBC((ModelBase)new ModelFr4(), 0.5F));
/*      */     
/*  355 */     addEntityClient((Class)EntityCyborg16.class, (Render)new RenderDBC((ModelBase)new ModelRaditz(), 0.5F));
/*  356 */     addEntityClient((Class)EntityCyborg17.class, (Render)new RenderDBC((ModelBase)new ModelRaditz(), 0.5F));
/*  357 */     addEntityClient((Class)EntityCyborg18.class, (Render)new RenderDBC((ModelBase)new ModelRaditz(), 0.5F));
/*  358 */     addEntityClient((Class)EntityCyborg19.class, (Render)new RenderDBC((ModelBase)new ModelRaditz(), 0.5F));
/*  359 */     addEntityClient((Class)EntityCyborg20.class, (Render)new RenderDBC((ModelBase)new ModelRaditz(), 0.5F));
/*      */     
/*  361 */     addEntityClient((Class)EntityCell1.class, (Render)new RenderDBC((ModelBase)new ModelRaditz(), 0.5F));
/*  362 */     addEntityClient((Class)EntityCell2.class, (Render)new RenderDBC((ModelBase)new ModelRaditz(), 0.5F));
/*  363 */     addEntityClient((Class)EntityCell3.class, (Render)new RenderDBC((ModelBase)new ModelRaditz(), 0.5F));
/*  364 */     addEntityClient((Class)EntityCell4.class, (Render)new RenderDBC((ModelBase)new ModelRaditz(), 0.5F));
/*      */ 
/*      */ 
/*      */     
/*  368 */     addEntityClient((Class)EntityMasterPiccolo.class, (Render)new RenderDBC((ModelBase)new ModelRaditz(), 0.5F));
/*  369 */     addEntityClient((Class)EntityMasterVegeta.class, (Render)new RenderDBC((ModelBase)new ModelDBCZed(3), 0.5F));
/*  370 */     addEntityClient((Class)EntityFreeza7.class, (Render)new RenderDBC((ModelBase)new ModelFr4(), 0.5F));
/*  371 */     addEntityClient((Class)EntityZarbon2.class, (Render)new RenderDBC((ModelBase)new ModelRaditz(), 0.5F));
/*      */ 
/*      */ 
/*      */     
/*  375 */     addEntityClient((Class)EntityNamekFrog.class, (Render)new RenderDBC(new ModelFrog(), 0.5F));
/*  376 */     addEntityClient((Class)EntityCellJr.class, (Render)new RenderDBC((ModelBase)new ModelRaditz2(0.8F, true), 0.5F));
/*      */     
/*  378 */     addEntityClient((Class)EntityBuuEvil.class, (Render)new RenderDBC(new ModelBuuEvil(), 0.5F));
/*  379 */     addEntityClient((Class)EntityBuuFusion.class, (Render)new RenderDBC(new ModelBuuSuper_Fusion(), 0.5F));
/*  380 */     addEntityClient((Class)EntityBuuPiccolo.class, (Render)new RenderDBC(new ModelBuuSuper_Piccolo(), 0.5F));
/*  381 */     addEntityClient((Class)EntityBuuUltimate.class, (Render)new RenderDBC(new ModelBuuSuper_Ultimate(), 0.5F));
/*  382 */     addEntityClient((Class)EntityBuuBuffed.class, (Render)new RenderDBC(new ModelBuuSuper_Buffed(), 0.5F));
/*  383 */     addEntityClient((Class)EntityBuuKid.class, (Render)new RenderDBC(new ModelBuuKid(), 0.5F));
/*      */     
/*  385 */     addEntityClient((Class)EntityBeerusMonaka.class, (Render)new RenderDBC(new ModelBeerusMonaka(), 0.5F));
/*  386 */     addEntityClient((Class)EntityBeerusMonaka2.class, (Render)new RenderDBC(new ModelBeerusMonaka2(), 0.5F));
/*  387 */     addEntityClient((Class)EntityBeerusMonaka3.class, (Render)new RenderDBC(new ModelBeerusMonaka3(), 0.5F));
/*  388 */     addEntityClient((Class)EntityBerryblue.class, (Render)new RenderDBC(new ModelBerryblue(), 0.5F));
/*  389 */     addEntityClient((Class)EntityBotamo.class, (Render)new RenderDBC(new ModelBotamo(), 0.5F));
/*  390 */     addEntityClient((Class)EntityChampa.class, (Render)new RenderDBC(new ModelChampa(), 0.5F));
/*  391 */     addEntityClient((Class)EntityFrost1.class, (Render)new RenderDBC((ModelBase)new ModelRaditz(), 0.5F));
/*  392 */     addEntityClient((Class)EntityFrost2.class, (Render)new RenderDBC((ModelBase)new ModelRaditz(1.25F), 0.5F));
/*  393 */     addEntityClient((Class)EntityFrost3.class, (Render)new RenderDBC((ModelBase)new ModelRaditz(1.25F), 0.5F));
/*  394 */     addEntityClient((Class)EntityFrost4.class, (Render)new RenderDBC((ModelBase)new ModelFr4(), 0.5F));
/*  395 */     addEntityClient((Class)EntityFrost5.class, (Render)new RenderDBC((ModelBase)new ModelFr4(), 0.5F));
/*  396 */     addEntityClient((Class)EntityFrost6.class, (Render)new RenderDBC((ModelBase)new ModelFr6(), 0.5F));
/*  397 */     addEntityClient((Class)EntityHit.class, (Render)new RenderDBC(new ModelHit(), 0.5F));
/*  398 */     addEntityClient((Class)EntityKrillin.class, (Render)new RenderDBC(new ModelKrillin(), 0.5F));
/*  399 */     addEntityClient((Class)EntityMagetta.class, (Render)new RenderDBC(new ModelMagetta(), 0.5F));
/*  400 */     addEntityClient((Class)EntityMonaka.class, (Render)new RenderDBC(new ModelMonaka(), 0.5F));
/*  401 */     addEntityClient((Class)EntityRoshi_super.class, (Render)new RenderDBC(new ModelRoshi_super(), 0.5F));
/*  402 */     addEntityClient((Class)EntityShisami.class, (Render)new RenderDBC(new ModelShisami(), 0.5F));
/*  403 */     addEntityClient((Class)EntitySorbet.class, (Render)new RenderDBC(new ModelSorbet(), 0.5F));
/*  404 */     addEntityClient((Class)EntityTagoma.class, (Render)new RenderDBC(new ModelTagoma(), 0.5F));
/*  405 */     addEntityClient((Class)EntityVados.class, (Render)new RenderDBC(new ModelVados(), 0.5F));
/*  406 */     addEntityClient((Class)EntityWhis.class, (Render)new RenderDBC(new ModelWhis(), 0.5F));
/*      */     
/*  408 */     addEntityClient((Class)EntityGokuBlack.class, (Render)new RenderDBC((ModelBase)new ModelDBCZed(0), 0.5F));
/*  409 */     addEntityClient((Class)EntityGokuBlackRose.class, (Render)new RenderDBC((ModelBase)new ModelDBCZed(4), 0.5F));
/*      */     
/*  411 */     addEntityClient((Class)EntityVegetaCopy.class, (Render)new RenderDBC((ModelBase)new ModelDBCZed(3), 0.5F));
/*  412 */     addEntityClient((Class)EntityVegetaCopyBlue.class, (Render)new RenderDBC((ModelBase)new ModelDBCZed(3), 0.5F));
/*      */     
/*  414 */     addEntityClient((Class)EntityCabba.class, (Render)new RenderDBC(new ModelCabba(), 0.5F));
/*  415 */     addEntityClient((Class)EntityCabbaSSJ.class, (Render)new RenderDBC(new ModelCabba(), 0.5F));
/*      */     
/*  417 */     addEntityClient((Class)EntityZamasu.class, (Render)new RenderDBC(new ModelZamasu(), 0.5F));
/*  418 */     addEntityClient((Class)EntityZamasu_Fused.class, (Render)new RenderDBC(new ModelZamasu_Fused(), 0.5F));
/*  419 */     addEntityClient((Class)EntityZamasu_Fused2.class, (Render)new RenderDBC(new ModelZamasu_Fused2(), 0.5F));
/*  420 */     addEntityClient((Class)EntityZamasu_Fused3.class, (Render)new RenderDBC(new ModelZamasu_Fused2(1.35F), 0.5F));
/*      */     
/*  422 */     addEntityClient((Class)EntityZeno.class, (Render)new RenderDBC(new ModelZeno(), 0.5F));
/*      */ 
/*      */     
/*  425 */     addEntityClient((Class)EntityGoku.class, (Render)new RenderDBC((ModelBase)new ModelDBCZed(0), 0.5F));
/*  426 */     addEntityClient((Class)EntityGoku2.class, (Render)new RenderDBC((ModelBase)new ModelDBCZed(4), 0.5F));
/*  427 */     addEntityClient((Class)EntityGoku3.class, (Render)new RenderDBC((ModelBase)new ModelDBCZed(0), 0.5F));
/*  428 */     addEntityClient((Class)EntityGoku4.class, (Render)new RenderDBC((ModelBase)new ModelDBCZed(4), 0.5F));
/*      */     
/*  430 */     addEntityClient((Class)EntityVegeta.class, (Render)new RenderDBC((ModelBase)new ModelDBCZed(3), 0.5F));
/*  431 */     addEntityClient((Class)EntityVegeta2.class, (Render)new RenderDBC((ModelBase)new ModelDBCZed(3), 0.5F));
/*  432 */     addEntityClient((Class)EntityVegeta3.class, (Render)new RenderDBC((ModelBase)new ModelDBCZed(3), 0.5F));
/*  433 */     addEntityClient((Class)EntityVegeta4.class, (Render)new RenderDBC((ModelBase)new ModelDBCZed(3), 0.5F));
/*      */     
/*  435 */     addEntityClient((Class)EntityGohan.class, (Render)new RenderDBC((ModelBase)new ModelDBCZed(1), 0.5F));
/*  436 */     addEntityClient((Class)EntityGohan2.class, (Render)new RenderDBC((ModelBase)new ModelDBCZed(1), 0.5F));
/*  437 */     addEntityClient((Class)EntityGohan_orange.class, (Render)new RenderDBC((ModelBase)new ModelDBCZed(1), 0.5F));
/*  438 */     addEntityClient((Class)EntityGohan_orange2.class, (Render)new RenderDBC((ModelBase)new ModelDBCZed(1), 0.5F));
/*      */     
/*  440 */     addEntityClient((Class)EntityTrunks.class, (Render)new RenderDBC((ModelBase)new ModelDBCZed(2), 0.5F));
/*  441 */     addEntityClient((Class)EntityTrunks2.class, (Render)new RenderDBC((ModelBase)new ModelDBCZed(5), 0.5F));
/*  442 */     addEntityClient((Class)EntityTrunks_dbs.class, (Render)new RenderDBC((ModelBase)new ModelDBCZed(2), 0.5F));
/*  443 */     addEntityClient((Class)EntityTrunks_dbs2.class, (Render)new RenderDBC((ModelBase)new ModelDBCZed(5), 0.5F));
/*      */ 
/*      */     
/*  446 */     addEntityClient((Class)EntityAngelAwamo.class, (Render)new RenderDBC(new ModelAngelAwamo(), 0.5F));
/*  447 */     addEntityClient((Class)EntityAngelCamparri.class, (Render)new RenderDBC(new ModelAngelCamparri(), 0.5F));
/*  448 */     addEntityClient((Class)EntityAngelCognac.class, (Render)new RenderDBC(new ModelAngelCognac(), 0.5F));
/*  449 */     addEntityClient((Class)EntityAngelCukatail.class, (Render)new RenderDBC(new ModelAngelCukatail(), 0.5F));
/*  450 */     addEntityClient((Class)EntityAngelKorn.class, (Render)new RenderDBC(new ModelAngelKorn(), 0.5F));
/*  451 */     addEntityClient((Class)EntityAngelKusu.class, (Render)new RenderDBC(new ModelAngelKusu(), 0.5F));
/*  452 */     addEntityClient((Class)EntityAngelMarcarita.class, (Render)new RenderDBC(new ModelAngelMarcarita(), 0.5F));
/*  453 */     addEntityClient((Class)EntityAngelMartinu.class, (Render)new RenderDBC(new ModelAngelMartinu(), 0.5F));
/*  454 */     addEntityClient((Class)EntityAngelMohito.class, (Render)new RenderDBC(new ModelAngelMohito(), 0.5F));
/*  455 */     addEntityClient((Class)EntityAngelSour.class, (Render)new RenderDBC(new ModelAngelSour(), 0.5F));
/*      */ 
/*      */     
/*  458 */     addEntityClient((Class)EntityGodArak.class, (Render)new RenderDBC(new ModelGodArak(), 0.5F));
/*  459 */     addEntityClient((Class)EntityGodBelmod.class, (Render)new RenderDBC(new ModelGodBelmod(), 0.5F));
/*  460 */     addEntityClient((Class)EntityGodGiin.class, (Render)new RenderDBC(new ModelGodGiin(), 0.5F));
/*  461 */     addEntityClient((Class)EntityGodHeles.class, (Render)new RenderDBC(new ModelGodHeles(), 0.5F));
/*  462 */     addEntityClient((Class)EntityGodIwan.class, (Render)new RenderDBC(new ModelGodIwan(), 0.5F));
/*  463 */     addEntityClient((Class)EntityGodLiquiir.class, (Render)new RenderDBC(new ModelGodLiquiir(), 0.5F));
/*  464 */     addEntityClient((Class)EntityGodMosco.class, (Render)new RenderDBC(new ModelGodMosco(), 0.5F));
/*  465 */     addEntityClient((Class)EntityGodQuitela.class, (Render)new RenderDBC(new ModelGodQuitela(), 0.5F));
/*  466 */     addEntityClient((Class)EntityGodRumsshi.class, (Render)new RenderDBC(new ModelGodRumsshi(), 0.5F));
/*  467 */     addEntityClient((Class)EntityGodSidra.class, (Render)new RenderDBC(new ModelGodSidra(), 0.5F));
/*      */ 
/*      */     
/*  470 */     addEntityClient((Class)EntityBasil.class, (Render)new RenderDBC(new ModelBasil(), 0.5F));
/*  471 */     addEntityClient((Class)EntityBergamo.class, (Render)new RenderDBC(new ModelBergamo(), 0.5F));
/*  472 */     addEntityClient((Class)EntityLavender.class, (Render)new RenderDBC(new ModelLavender(), 0.5F));
/*      */ 
/*      */     
/*  475 */     addEntityClient((Class)EntityBrianne.class, (Render)new RenderDBC(new ModelBrianne(), 0.5F));
/*  476 */     addEntityClient((Class)EntityCaulifla.class, (Render)new RenderDBC(new ModelCaulifla(), 0.5F));
/*  477 */     addEntityClient((Class)EntityCaulifla2.class, (Render)new RenderDBC(new ModelCauliflaSSJ(), 0.5F));
/*  478 */     addEntityClient((Class)EntityDyspo.class, (Render)new RenderDBC(new ModelDyspo(), 0.5F));
/*  479 */     addEntityClient((Class)EntityJiren.class, (Render)new RenderDBC(new ModelJiren(), 0.5F));
/*  480 */     addEntityClient((Class)EntityJiren2.class, (Render)new RenderDBC(new ModelJiren_Full_Power(), 0.5F));
/*  481 */     addEntityClient((Class)EntityKale.class, (Render)new RenderDBC(new ModelKale(), 0.5F));
/*  482 */     addEntityClient((Class)EntityKale2.class, (Render)new RenderDBC(new ModelKaleSSJ(), 0.5F));
/*  483 */     addEntityClient((Class)EntityKefla.class, (Render)new RenderDBC(new ModelKefla(), 0.5F));
/*  484 */     addEntityClient((Class)EntityKefla2.class, (Render)new RenderDBC(new ModelKeflaSSJ(), 0.5F));
/*  485 */     addEntityClient((Class)EntityToppo.class, (Render)new RenderDBC(new ModelToppo(), 0.5F));
/*  486 */     addEntityClient((Class)EntityToppo2.class, (Render)new RenderDBC(new ModelToppo_GoD(), 0.5F));
/*      */ 
/*      */     
/*  489 */     addEntityClient((Class)EntityAniraza.class, (Render)new RenderDBC(new ModelAniraza(), 0.5F));
/*  490 */     addEntityClient((Class)EntityBiarra.class, (Render)new RenderDBC(new ModelBiarra(), 0.5F));
/*  491 */     addEntityClient((Class)EntityCocotte.class, (Render)new RenderDBC(new ModelCocotte(), 0.5F));
/*  492 */     addEntityClient((Class)EntityDercori.class, (Render)new RenderDBC(new ModelDercori(), 0.5F));
/*      */     
/*  494 */     addEntityClient((Class)EntityGanos.class, (Render)new RenderDBC(new ModelGanos(), 0.5F));
/*  495 */     addEntityClient((Class)EntityGanos2.class, (Render)new RenderDBC(new ModelGanos2(), 0.5F));
/*  496 */     addEntityClient((Class)EntityHop.class, (Render)new RenderDBC(new ModelHop(), 0.5F));
/*  497 */     addEntityClient((Class)EntityKahseral.class, (Render)new RenderDBC(new ModelKahseral(), 0.5F));
/*  498 */     addEntityClient((Class)EntityKakunsa.class, (Render)new RenderDBC(new ModelKakunsa(), 0.5F));
/*  499 */     addEntityClient((Class)EntityKunshi.class, (Render)new RenderDBC(new ModelKunshi(), 0.5F));
/*  500 */     addEntityClient((Class)EntityMajora.class, (Render)new RenderDBC(new ModelMajora(), 0.5F));
/*  501 */     addEntityClient((Class)EntityMurichim.class, (Render)new RenderDBC(new ModelMurichim(), 0.5F));
/*  502 */     addEntityClient((Class)EntityNapapa.class, (Render)new RenderDBC(new ModelNapapa(), 0.5F));
/*  503 */     addEntityClient((Class)EntityNarirama.class, (Render)new RenderDBC(new ModelNarirama(), 0.5F));
/*  504 */     addEntityClient((Class)EntityObni.class, (Render)new RenderDBC(new ModelObni(), 0.5F));
/*  505 */     addEntityClient((Class)EntityPaparoni.class, (Render)new RenderDBC(new ModelPaparoni(), 0.5F));
/*  506 */     addEntityClient((Class)EntityRoasie.class, (Render)new RenderDBC(new ModelRoasie(), 0.5F));
/*  507 */     addEntityClient((Class)EntityRylibeu.class, (Render)new RenderDBC(new ModelRylibeu(), 0.5F));
/*  508 */     addEntityClient((Class)EntityShosa.class, (Render)new RenderDBC(new ModelShosa(), 0.5F));
/*  509 */     addEntityClient((Class)EntitySorrel.class, (Render)new RenderDBC(new ModelSorrel(), 0.5F));
/*  510 */     addEntityClient((Class)EntityBorareta.class, (Render)new RenderDBC(new ModelBorareta(), 0.5F));
/*  511 */     addEntityClient((Class)EntityKoichiarator.class, (Render)new RenderDBC(new ModelKoichiarator(), 0.5F));
/*  512 */     addEntityClient((Class)EntityKoitsukai.class, (Render)new RenderDBC(new ModelKoitsukai(), 0.5F));
/*  513 */     addEntityClient((Class)EntityPanchia.class, (Render)new RenderDBC(new ModelPanchia(), 0.5F));
/*      */     
/*  515 */     addEntityClient((Class)EntityKatopesla.class, (Render)new RenderDBC(new ModelKatopesla(), 0.5F));
/*  516 */     addEntityClient((Class)EntityKatopesla2.class, (Render)new RenderDBC(new ModelKatopesla(), 0.5F));
/*  517 */     addEntityClient((Class)EntityKatopesla3.class, (Render)new RenderDBC(new ModelKatopesla(), 0.5F));
/*  518 */     addEntityClient((Class)EntityKatopesla4.class, (Render)new RenderDBC(new ModelKatopesla(), 0.5F));
/*      */ 
/*      */ 
/*      */     
/*  522 */     addEntityClient((Class)EntityDBSBroly1.class, (Render)new RenderDBC((ModelBase)new ModelDBSBrolyNormal(), 0.5F));
/*  523 */     addEntityClient((Class)EntityDBSBroly2.class, (Render)new RenderDBC((ModelBase)new ModelDBSBrolyNormal(), 0.5F));
/*  524 */     addEntityClient((Class)EntityDBSBroly3.class, (Render)new RenderDBC((ModelBase)new ModelDBSBrolyNormal(), 0.5F));
/*  525 */     addEntityClient((Class)EntityDBSBroly4.class, (Render)new RenderDBC((ModelBase)new ModelDBSBrolyNormal(), 0.5F));
/*  526 */     addEntityClient((Class)EntityDBSBrolyBuff.class, (Render)new RenderDBC((ModelBase)new ModelDBSBrolyBuff(), 0.5F));
/*  527 */     addEntityClient((Class)EntityDBSBrolyBuffSSJ.class, (Render)new RenderDBC((ModelBase)new ModelDBSBrolyBuff(), 0.5F));
/*  528 */     addEntityClient((Class)EntityDBSBrolyLegendary.class, (Render)new RenderDBC((ModelBase)new ModelDBSBrolyLegendary(), 0.5F));
/*  529 */     addEntityClient((Class)EntityDBSParagus.class, (Render)new RenderDBC((ModelBase)new ModelDBSParagus(), 0.5F));
/*  530 */     addEntityClient((Class)EntityDBSParagus2.class, (Render)new RenderDBC((ModelBase)new ModelDBSParagus2(), 0.5F));
/*  531 */     addEntityClient((Class)EntityCheelai.class, (Render)new RenderDBC((ModelBase)new ModelCheelai(), 0.5F));
/*  532 */     addEntityClient((Class)EntityCheelai2.class, (Render)new RenderDBC((ModelBase)new ModelCheelai(), 0.5F));
/*  533 */     addEntityClient((Class)EntityLemo.class, (Render)new RenderDBC((ModelBase)new ModelLemo(), 0.5F));
/*      */ 
/*      */     
/*  536 */     addEntityClient((Class)EntityFortunetellerBaba.class, (Render)new RenderDBC((ModelBase)new ModelFortunetellerBaba(), 0.5F));
/*  537 */     addEntityClient((Class)EntityMummy.class, (Render)new RenderDBC((ModelBase)new ModelMummy(), 0.5F));
/*  538 */     addEntityClient((Class)EntityVampire.class, (Render)new RenderDBC((ModelBase)new ModelVampire(), 0.5F));
/*  539 */     addEntityClient((Class)EntityInvisibleMan.class, (Render)new RenderDBC((ModelBase)new ModelInvisibleMan(), 0.5F));
/*  540 */     addEntityClient((Class)EntityDevil.class, (Render)new RenderDBC((ModelBase)new ModelDevil(), 0.5F));
/*  541 */     addEntityClient((Class)EntityGrandpaGohan.class, (Render)new RenderDBC((ModelBase)new ModelGrandpaGohan(), 0.5F));
/*  542 */     addEntityClient((Class)EntityGrandpaGohan2.class, (Render)new RenderDBC((ModelBase)new ModelGrandpaGohan(), 0.5F));
/*      */ 
/*      */     
/*  545 */     addEntityClient((Class)EntityCymbal.class, (Render)new RenderDBC((ModelBase)new ModelCymbal(), 0.5F));
/*  546 */     addEntityClient((Class)EntityDrum.class, (Render)new RenderDBC((ModelBase)new ModelDrum(), 0.5F));
/*  547 */     addEntityClient((Class)EntityKingPiccolo.class, (Render)new RenderDBC((ModelBase)new ModelKingPiccolo(), 0.5F));
/*  548 */     addEntityClient((Class)EntityKingPiccolo2.class, (Render)new RenderDBC((ModelBase)new ModelKingPiccolo2(), 0.5F));
/*  549 */     addEntityClient((Class)EntityPiano.class, (Render)new RenderDBC((ModelBase)new ModelPiano(), 0.5F));
/*  550 */     addEntityClient((Class)EntityTambourine.class, (Render)new RenderDBC((ModelBase)new ModelTambourine(), 0.5F));
/*      */ 
/*      */     
/*  553 */     addEntityClient((Class)EntityDBMasterRoshi.class, (Render)new RenderDBC((ModelBase)new ModelMasterRoshi(), 0.5F));
/*  554 */     addEntityClient((Class)EntityDBMasterRoshi2.class, (Render)new RenderDBC((ModelBase)new ModelMasterRoshi2(), 0.5F));
/*  555 */     addEntityClient((Class)EntityDBMasterRoshi3.class, (Render)new RenderDBC((ModelBase)new ModelMasterRoshi3(), 0.5F));
/*  556 */     addEntityClient((Class)EntityBearThief.class, (Render)new RenderDBC((ModelBase)new ModelBearThief(), 0.5F));
/*  557 */     addEntityClient((Class)EntityTigerBandit.class, (Render)new RenderDBC((ModelBase)new ModelTigerBandit(), 0.5F));
/*  558 */     addEntityClient((Class)EntityPuar.class, (Render)new RenderDBC((ModelBase)new ModelPuar(), 0.5F));
/*  559 */     addEntityClient((Class)EntityYamcha.class, (Render)new RenderDBC((ModelBase)new ModelYamcha(), 0.5F));
/*  560 */     addEntityClient((Class)EntityYamcha2.class, (Render)new RenderDBC((ModelBase)new ModelYamcha2(), 0.5F));
/*  561 */     addEntityClient((Class)EntityYamcha3.class, (Render)new RenderDBC((ModelBase)new ModelYamcha2(), 0.5F));
/*  562 */     addEntityClient((Class)EntityYamcha4.class, (Render)new RenderDBC((ModelBase)new ModelYamcha2(), 0.5F));
/*  563 */     addEntityClient((Class)EntityYamcha5.class, (Render)new RenderDBC((ModelBase)new ModelYamcha(), 0.5F));
/*      */ 
/*      */     
/*  566 */     addEntityClient((Class)EntityMai.class, (Render)new RenderDBC((ModelBase)new ModelMai(), 0.5F));
/*  567 */     addEntityClient((Class)EntityPilaf.class, (Render)new RenderDBC((ModelBase)new ModelPilaf(), 0.5F));
/*  568 */     addEntityClient((Class)EntityShu.class, (Render)new RenderDBC((ModelBase)new ModelShu(), 0.5F));
/*  569 */     addEntityClient((Class)EntityMaiMecha.class, (Render)new RenderDBC((ModelBase)new ModelMaiMecha(), 0.5F));
/*  570 */     addEntityClient((Class)EntityPilafMecha.class, (Render)new RenderDBC((ModelBase)new ModelPilafMecha(), 0.5F));
/*  571 */     addEntityClient((Class)EntityShuMecha.class, (Render)new RenderDBC((ModelBase)new ModelShuMecha(), 0.5F));
/*  572 */     addEntityClient((Class)EntityPilafMechaCombined.class, (Render)new RenderDBC((ModelBase)new ModelPilafMechaCombined(), 0.5F));
/*      */ 
/*      */     
/*  575 */     addEntityClient((Class)EntityBacterian.class, (Render)new RenderDBC((ModelBase)new ModelBacterian(), 0.5F));
/*  576 */     addEntityClient((Class)EntityGiran.class, (Render)new RenderDBC((ModelBase)new ModelGiran(), 0.5F));
/*  577 */     addEntityClient((Class)EntityJackieChun.class, (Render)new RenderDBC((ModelBase)new ModelJackieChun(), 0.5F));
/*  578 */     addEntityClient((Class)EntityJackieChun2.class, (Render)new RenderDBC((ModelBase)new ModelJackieChun2(), 0.5F));
/*  579 */     addEntityClient((Class)EntityJackieChun3.class, (Render)new RenderDBC((ModelBase)new ModelJackieChun3(), 0.5F));
/*  580 */     addEntityClient((Class)EntityNam.class, (Render)new RenderDBC((ModelBase)new ModelNam(), 0.5F));
/*  581 */     addEntityClient((Class)EntityTournamentAnnouncer.class, (Render)new RenderDBC((ModelBase)new ModelTournamentAnnouncer(), 0.5F));
/*      */     
/*  583 */     addEntityClient((Class)EntityKingChappa.class, (Render)new RenderDBC((ModelBase)new ModelKingChappa(), 0.5F));
/*  584 */     addEntityClient((Class)EntityManWolf.class, (Render)new RenderDBC((ModelBase)new ModelManWolf(), 0.5F));
/*  585 */     addEntityClient((Class)EntityMasterShen.class, (Render)new RenderDBC((ModelBase)new ModelMasterShen(), 0.5F));
/*  586 */     addEntityClient((Class)EntityPamput.class, (Render)new RenderDBC((ModelBase)new ModelPamput(), 0.5F));
/*  587 */     addEntityClient((Class)EntityTien.class, (Render)new RenderDBC((ModelBase)new ModelTien(), 0.5F));
/*  588 */     addEntityClient((Class)EntityTien2.class, (Render)new RenderDBC((ModelBase)new ModelTien(), 0.5F));
/*  589 */     addEntityClient((Class)EntityTien3.class, (Render)new RenderDBC((ModelBase)new ModelTien(), 0.5F));
/*      */ 
/*      */     
/*  592 */     addEntityClient((Class)EntityAndroid8.class, (Render)new RenderDBC((ModelBase)new ModelAndroid8(), 0.5F));
/*  593 */     addEntityClient((Class)EntityBuyon.class, (Render)new RenderDBC((ModelBase)new ModelBuyon(), 0.5F));
/*  594 */     addEntityClient((Class)EntityColonelSilver.class, (Render)new RenderDBC((ModelBase)new ModelColonelSilver(), 0.5F));
/*  595 */     addEntityClient((Class)EntityColonelViolet.class, (Render)new RenderDBC((ModelBase)new ModelColonelViolet(), 0.5F));
/*  596 */     addEntityClient((Class)EntityCommanderRed.class, (Render)new RenderDBC((ModelBase)new ModelCommanderRed(), 0.5F));
/*  597 */     addEntityClient((Class)EntityGeneralBlue.class, (Render)new RenderDBC((ModelBase)new ModelGeneralBlue(), 0.5F));
/*  598 */     addEntityClient((Class)EntityGeneralBlue2.class, (Render)new RenderDBC((ModelBase)new ModelGeneralBlue(), 0.5F));
/*  599 */     addEntityClient((Class)EntityGeneralWhite.class, (Render)new RenderDBC((ModelBase)new ModelGeneralWhite(), 0.5F));
/*  600 */     addEntityClient((Class)EntityGeneralWhite2.class, (Render)new RenderDBC((ModelBase)new ModelGeneralWhite(), 0.5F));
/*  601 */     addEntityClient((Class)EntityLaunch.class, (Render)new RenderDBC((ModelBase)new ModelLaunch(), 0.5F));
/*  602 */     addEntityClient((Class)EntityLaunch2.class, (Render)new RenderDBC((ModelBase)new ModelLaunch(), 0.5F));
/*  603 */     addEntityClient((Class)EntityMajorMetallitron.class, (Render)new RenderDBC((ModelBase)new ModelMajorMetallitron(), 0.5F));
/*  604 */     addEntityClient((Class)EntityMajorMetallitron1.class, (Render)new RenderDBC((ModelBase)new ModelMajorMetallitron(), 0.5F));
/*  605 */     addEntityClient((Class)EntityMajorMetallitron2.class, (Render)new RenderDBC((ModelBase)new ModelMajorMetallitron(), 0.5F));
/*  606 */     addEntityClient((Class)EntityMajorMetallitron3.class, (Render)new RenderDBC((ModelBase)new ModelMajorMetallitron(), 0.5F));
/*  607 */     addEntityClient((Class)EntityMercenaryTao.class, (Render)new RenderDBC((ModelBase)new ModelMercenaryTao(), 0.5F));
/*  608 */     addEntityClient((Class)EntityNinjaMurasaki.class, (Render)new RenderDBC((ModelBase)new ModelNinjaMurasaki(), 0.5F));
/*  609 */     addEntityClient((Class)EntityRedRibbonSoldier.class, (Render)new RenderDBC((ModelBase)new ModelRedRibbonSoldierGunner(), 0.5F));
/*  610 */     addEntityClient((Class)EntityRedRibbonSoldier2.class, (Render)new RenderDBC((ModelBase)new ModelRedRibbonSoldierGunner(), 0.5F));
/*  611 */     addEntityClient((Class)EntityRedRibbonSoldier3.class, (Render)new RenderDBC((ModelBase)new ModelRedRibbonSoldierBazooka(), 0.5F));
/*  612 */     addEntityClient((Class)EntityRedRibbonSoldierB.class, (Render)new RenderDBC((ModelBase)new ModelRedRibbonSoldierGunner(), 0.5F));
/*  613 */     addEntityClient((Class)EntityRedRibbonSoldierB2.class, (Render)new RenderDBC((ModelBase)new ModelRedRibbonSoldierGunner(), 0.5F));
/*  614 */     addEntityClient((Class)EntityRedRibbonSoldierB3.class, (Render)new RenderDBC((ModelBase)new ModelRedRibbonSoldierBazooka(), 0.5F));
/*      */     
/*  616 */     addEntityClient((Class)EntityBora.class, (Render)new RenderDBC((ModelBase)new ModelBora(), 0.5F));
/*  617 */     addEntityClient((Class)EntityUpa.class, (Render)new RenderDBC((ModelBase)new ModelUpa(), 0.5F));
/*  618 */     addEntityClient((Class)EntityOolong.class, (Render)new RenderDBC((ModelBase)new ModelOolong(), 0.5F));
/*  619 */     addEntityClient((Class)EntityYajirobe.class, (Render)new RenderDBC((ModelBase)new ModelYajirobe(), 0.5F));
/*  620 */     addEntityClient((Class)EntityMercenaryTao2.class, (Render)new RenderDBC((ModelBase)new ModelMercenaryTao2(), 0.5F));
/*  621 */     addEntityClient((Class)EntityMercenaryTao3.class, (Render)new RenderDBC((ModelBase)new ModelMercenaryTao2(), 0.5F));
/*  622 */     addEntityClient((Class)EntityOfficerBlack.class, (Render)new RenderDBC((ModelBase)new ModelOfficerBlack(), 0.5F));
/*  623 */     addEntityClient((Class)EntityOfficerBlack2.class, (Render)new RenderDBC((ModelBase)new ModelOfficerBlack(), 0.5F));
/*  624 */     addEntityClient((Class)EntityOfficerBlack3.class, (Render)new RenderDBC((ModelBase)new ModelOfficerBlack2(), 0.5F));
/*      */     
/*  626 */     addEntityClient((Class)EntityOfficeOgre.class, (Render)new RenderDBC((ModelBase)new ModelOfficeOgre(), 0.5F));
/*  627 */     addEntityClient((Class)EntityOfficeOgre2.class, (Render)new RenderDBC((ModelBase)new ModelOfficeOgre(), 0.5F));
/*  628 */     addEntityClient((Class)EntityOfficeOgre3.class, (Render)new RenderDBC((ModelBase)new ModelOfficeOgre(), 0.5F));
/*  629 */     addEntityClient((Class)EntityOfficeOgre4.class, (Render)new RenderDBC((ModelBase)new ModelOfficeOgre2(), 0.5F));
/*  630 */     addEntityClient((Class)EntityOfficeOgre5.class, (Render)new RenderDBC((ModelBase)new ModelOfficeOgre2(), 0.5F));
/*  631 */     addEntityClient((Class)EntitySpirit.class, (Render)new RenderDBC((ModelBase)new ModelSpirit(), 0.5F));
/*      */     
/*  633 */     addEntityClient((Class)EntityChiaotzu.class, (Render)new RenderDBC((ModelBase)new ModelChiaotzu(), 0.5F));
/*  634 */     addEntityClient((Class)EntityChiaotzu2.class, (Render)new RenderDBC((ModelBase)new ModelChiaotzu(), 0.5F));
/*  635 */     addEntityClient((Class)EntityChiaotzu3.class, (Render)new RenderDBC((ModelBase)new ModelChiaotzu2(), 0.5F));
/*  636 */     addEntityClient((Class)EntityChiaotzu4.class, (Render)new RenderDBC((ModelBase)new ModelChiaotzu(), 0.5F));
/*      */     
/*  638 */     addEntityClient((Class)EntityTien4.class, (Render)new RenderDBC((ModelBase)new ModelTien(), 0.5F));
/*  639 */     addEntityClient((Class)EntityTien5.class, (Render)new RenderDBC((ModelBase)new ModelTien2(), 0.5F));
/*  640 */     addEntityClient((Class)EntityTien6.class, (Render)new RenderDBC((ModelBase)new ModelTien2(), 0.5F));
/*  641 */     addEntityClient((Class)EntityTien7.class, (Render)new RenderDBC((ModelBase)new ModelTien(), 0.5F));
/*      */     
/*  643 */     addEntityClient((Class)EntityPiccolo.class, (Render)new RenderDBC((ModelBase)new ModelRaditz(), 0.5F));
/*  644 */     addEntityClient((Class)EntityPiccolo2.class, (Render)new RenderDBC((ModelBase)new ModelRaditz(2.5F, false, true), 0.5F));
/*      */ 
/*      */     
/*  647 */     ClientRegistry.registerTileEntity(namekian_throneTileEntity.class, "namekian_throneTileEntityRender", (TileEntitySpecialRenderer)new namekian_throneRender());
/*      */ 
/*      */     
/*  650 */     ClientRegistry.registerTileEntity(DragonBlockNS01TileEntity.class, "DragonBlockNS01TileEntityRender", (TileEntitySpecialRenderer)new DragonBlockNS01Render());
/*  651 */     ClientRegistry.registerTileEntity(DragonBlockS01TileEntity.class, "DragonBlockS01TileEntityRender", (TileEntitySpecialRenderer)new DragonBlockS01Render());
/*  652 */     ClientRegistry.registerTileEntity(DragonBlockNamek01TileEntity.class, "DragonBlockNamek01TileEntityRender", (TileEntitySpecialRenderer)new DragonBlockNamek01Render());
/*  653 */     ClientRegistry.registerTileEntity(DragonBlock01TileEntity.class, "DragonBlock01TileEntityRender", (TileEntitySpecialRenderer)new DragonBlock01Render());
/*  654 */     ClientRegistry.registerTileEntity(SpacePod01TileEntity.class, "SpacePod01TileEntityRender", (TileEntitySpecialRenderer)new SpacePod01Render());
/*  655 */     ClientRegistry.registerTileEntity(SaibaiHatchedTileEntity.class, "SaibaiHatchedEntityRender", (TileEntitySpecialRenderer)new SaibaiHatchedRender());
/*  656 */     ClientRegistry.registerTileEntity(MedPodDoor1TileEntity.class, "MedPodDoor1EntityRender", (TileEntitySpecialRenderer)new MedPodDoor1Render());
/*  657 */     ClientRegistry.registerTileEntity(ArtGravDevTileEntity.class, "ArtGravDevRender", (TileEntitySpecialRenderer)new ArtGravDevRender());
/*  658 */     ClientRegistry.registerTileEntity(ppTileEntity.class, "ppRender", (TileEntitySpecialRenderer)new ppRender());
/*  659 */     addEntityClient((Class)block01dbcEntity.class, (Render)new block01dbcRender());
/*      */ 
/*      */     
/*  662 */     addEntityClient((Class)EntityInstantTransmission.class, (Render)new RenderInstantTransmission());
/*  663 */     addEntityClient((Class)EntityMajinAbsorption.class, (Render)new RenderMajinAbsorption());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void common() {
/*  671 */     addEntityServer((Class)EntityPorunga.class, "Dragonp");
/*  672 */     addEntityServer((Class)EntityPorunga2.class, "Dragonp2");
/*  673 */     addEntityServer((Class)EntityDragon2.class, "Dragon2");
/*  674 */     addEntityServer((Class)EntityDragon.class, "Dragon");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  682 */     addEntityServer((Class)EntitySaiyanRaditz.class, "Raditz");
/*  683 */     addEntityServer((Class)EntitySaiyanNappa.class, "Nappa");
/*  684 */     addEntityServer((Class)EntitySaiyanVegeta.class, "Vegeta");
/*  685 */     addEntityServer((Class)EntitySaibaiman.class, "Saibaiman");
/*  686 */     addEntityServer((Class)EntitySaiyan01.class, "Saiyan01");
/*  687 */     addEntityServer((Class)EntitySaiyan02.class, "Saiyan02");
/*      */ 
/*      */     
/*  690 */     addEntityServer((Class)EntityKiwi.class, "Kiwi");
/*  691 */     addEntityServer((Class)EntityDodoria.class, "Dodoria");
/*  692 */     addEntityServer((Class)EntityZarbon.class, "Zarbon");
/*  693 */     addEntityServer((Class)EntityGuldo.class, "Guldo");
/*  694 */     addEntityServer((Class)EntityRecoome.class, "Recoome");
/*  695 */     addEntityServer((Class)EntityBarta.class, "Barta");
/*  696 */     addEntityServer((Class)EntityJeice.class, "Jeice");
/*  697 */     addEntityServer((Class)EntityGinyu.class, "Ginyu");
/*  698 */     addEntityServer((Class)EntityFreezaSoldier1.class, "FreezaSoldier1");
/*  699 */     addEntityServer((Class)EntityFreezaSoldier2.class, "FreezaSoldier2");
/*  700 */     addEntityServer((Class)EntityFreezaSoldier3.class, "FreezaSoldier3");
/*  701 */     addEntityServer((Class)EntityFreeza1.class, "Freeza1");
/*  702 */     addEntityServer((Class)EntityFreeza2.class, "Freeza2");
/*  703 */     addEntityServer((Class)EntityFreeza3.class, "Freeza3");
/*  704 */     addEntityServer((Class)EntityFreeza4.class, "Freeza4");
/*  705 */     addEntityServer((Class)EntityFreeza5.class, "Freeza5");
/*  706 */     addEntityServer((Class)EntityFreeza6.class, "Freeza6");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  711 */     addEntityServer((Class)EntityFreezaFather.class, "KingCold");
/*  712 */     addEntityServer((Class)EntityFreezaMecha.class, "MechaFreeza");
/*      */     
/*  714 */     addEntityServer((Class)EntityCyborg16.class, "Cyborg16");
/*  715 */     addEntityServer((Class)EntityCyborg17.class, "Cyborg17");
/*  716 */     addEntityServer((Class)EntityCyborg18.class, "Cyborg18");
/*  717 */     addEntityServer((Class)EntityCyborg19.class, "Cyborg19");
/*  718 */     addEntityServer((Class)EntityCyborg20.class, "Cyborg20");
/*      */     
/*  720 */     addEntityServer((Class)EntityCell1.class, "Cell1");
/*  721 */     addEntityServer((Class)EntityCell2.class, "Cell2");
/*  722 */     addEntityServer((Class)EntityCell3.class, "Cell3");
/*  723 */     addEntityServer((Class)EntityCell4.class, "Cell4");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  728 */     addEntityServer((Class)SpacePod01Entity.class, "SpacePod");
/*  729 */     addEntityServer((Class)KintounEntity.class, "Kintoun");
/*  730 */     addEntityServer((Class)KintounBlackEntity.class, "KintounBlack");
/*      */ 
/*      */ 
/*      */     
/*  734 */     addEntityServer((Class)EntityHell01.class, "hell01");
/*  735 */     addEntityServer((Class)EntityHell02.class, "hell02");
/*  736 */     addEntityServer((Class)EntityMasterEnma.class, "enma");
/*  737 */     addEntityServer((Class)EntityNamekian01.class, "Namekian01");
/*  738 */     addEntityServer((Class)EntityNamekian03.class, "Namekian03");
/*  739 */     addEntityServer((Class)EntityMasterKami.class, "kami");
/*  740 */     addEntityServer((Class)EntityMasterKaio.class, "northkaio");
/*  741 */     addEntityServer((Class)EntityMasterKarin.class, "karin");
/*  742 */     addEntityServer((Class)EntityMasterRoshi.class, "roshi");
/*  743 */     addEntityServer((Class)EntityMasterCell.class, "cellmaster");
/*  744 */     addEntityServer((Class)EntityMasterGoku.class, "gokumaster");
/*  745 */     addEntityServer((Class)EntityMasterGohan.class, "gohanmaster");
/*  746 */     addEntityServer((Class)EntityMasterTrunksFuture.class, "trunksfuturemaster");
/*  747 */     addEntityServer((Class)EntityMasterFreeza.class, "Freezamaster");
/*  748 */     addEntityServer((Class)EntityMasterJin.class, "jin");
/*  749 */     addEntityServer((Class)EntityMasterGuru.class, "gurumaster");
/*  750 */     addEntityServer((Class)EntityMasterWhis.class, "whismaster");
/*      */     
/*  752 */     addEntityServer((Class)EntityDino01.class, "EntityDino01");
/*  753 */     addEntityServer((Class)EntityDino02.class, "EntityDino02");
/*  754 */     addEntityServer((Class)EntityDino03.class, "EntityDino03");
/*  755 */     addEntityServer((Class)EntityRRMecha.class, "EntityRRMecha");
/*  756 */     if (DBCConfig.spwnrt_rrmech1 > 0) EntityRegistry.addSpawn(EntityRRMecha.class, DBCConfig.spwnrt_rrmech1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.field_76770_e, BiomeGenBase.field_76768_g, BiomeGenBase.field_150584_S, BiomeGenBase.field_150579_T, BiomeGenBase.field_76774_n, BiomeGenBase.field_76784_u });
/*      */     
/*  758 */     addEntityServer((Class)EntitySabertooth.class, "EntitySabertooth");
/*  759 */     if (DBCConfig.spwnrt_sabert > 0) EntityRegistry.addSpawn(EntitySabertooth.class, DBCConfig.spwnrt_sabert, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.field_76772_c, BiomeGenBase.field_76767_f, BiomeGenBase.field_76785_t, BiomeGenBase.field_150583_P, BiomeGenBase.field_150582_Q });
/*      */ 
/*      */     
/*  762 */     addEntityServer((Class)EntityEnergyAtt.class, "EnergyAttack");
/*  763 */     addEntityServer((Class)EntityPrjtls_1.class, "DBCProjectile_1", 1);
/*      */ 
/*      */     
/*  766 */     addEntityServer((Class)EntityPuipui.class, "Puipui");
/*  767 */     addEntityServer((Class)EntityYakon.class, "Yakon");
/*  768 */     addEntityServer((Class)EntityDarbura.class, "Darbura");
/*  769 */     addEntityServer((Class)EntityBuuFat.class, "BuuFat");
/*  770 */     addEntityServer((Class)EntityBuuSuper.class, "BuuSuper");
/*  771 */     addEntityServer((Class)EntityMasterBabidi.class, "masterbabidi");
/*  772 */     addEntityServer((Class)EntityBeerus.class, "Beerus");
/*      */     
/*  774 */     addEntityServer((Class)EntityMasterPiccolo.class, "masterpiccolo");
/*  775 */     addEntityServer((Class)EntityMasterVegeta.class, "mastervegeta");
/*  776 */     addEntityServer((Class)EntityZarbon2.class, "Zarbon2");
/*  777 */     addEntityServer((Class)EntityFreeza7.class, "FreezaGolden");
/*      */     
/*  779 */     addEntityServer((Class)EntityEnergyFM.class, "KiFakeMoon", 400, 5);
/*      */ 
/*      */ 
/*      */     
/*  783 */     addEntityServer((Class)EntityNamekFrog.class, "EntityNamekFrog");
/*  784 */     addEntityServer((Class)EntityCellJr.class, "CellJr");
/*      */     
/*  786 */     addEntityServer((Class)EntityBuuEvil.class, "BuuEvil");
/*  787 */     addEntityServer((Class)EntityBuuFusion.class, "BuuFusion");
/*  788 */     addEntityServer((Class)EntityBuuPiccolo.class, "BuuPiccolo");
/*  789 */     addEntityServer((Class)EntityBuuUltimate.class, "BuuUltimate");
/*  790 */     addEntityServer((Class)EntityBuuBuffed.class, "BuuBuffed");
/*  791 */     addEntityServer((Class)EntityBuuKid.class, "BuuKid");
/*      */ 
/*      */     
/*  794 */     addEntityServer((Class)EntityBerryblue.class, "Berryblue");
/*  795 */     addEntityServer((Class)EntityBeerusMonaka.class, "BeerusMonaka");
/*  796 */     addEntityServer((Class)EntityBeerusMonaka2.class, "BeerusMonaka2");
/*  797 */     addEntityServer((Class)EntityBeerusMonaka3.class, "BeerusMonaka3");
/*  798 */     addEntityServer((Class)EntityBotamo.class, "Botamo");
/*  799 */     addEntityServer((Class)EntityChampa.class, "Champa");
/*  800 */     addEntityServer((Class)EntityFrost1.class, "Frost1");
/*  801 */     addEntityServer((Class)EntityFrost2.class, "Frost2");
/*  802 */     addEntityServer((Class)EntityFrost3.class, "Frost3");
/*  803 */     addEntityServer((Class)EntityFrost4.class, "Frost4");
/*  804 */     addEntityServer((Class)EntityFrost5.class, "Frost5");
/*  805 */     addEntityServer((Class)EntityFrost6.class, "Frost6");
/*  806 */     addEntityServer((Class)EntityHit.class, "Hit");
/*  807 */     addEntityServer((Class)EntityKrillin.class, "Krillin");
/*  808 */     addEntityServer((Class)EntityMagetta.class, "Magetta");
/*  809 */     addEntityServer((Class)EntityMonaka.class, "Monaka");
/*  810 */     addEntityServer((Class)EntityRoshi_super.class, "Roshi_super");
/*  811 */     addEntityServer((Class)EntityShisami.class, "Shisami");
/*  812 */     addEntityServer((Class)EntitySorbet.class, "Sorbet");
/*  813 */     addEntityServer((Class)EntityTagoma.class, "Tagoma");
/*  814 */     addEntityServer((Class)EntityVados.class, "Vados");
/*  815 */     addEntityServer((Class)EntityWhis.class, "Whis");
/*      */     
/*  817 */     addEntityServer((Class)EntityGokuBlack.class, "GokuBlack");
/*  818 */     addEntityServer((Class)EntityGokuBlackRose.class, "GokuBlackRose");
/*      */     
/*  820 */     addEntityServer((Class)EntityVegetaCopy.class, "VegetaCopy");
/*  821 */     addEntityServer((Class)EntityVegetaCopyBlue.class, "VegetaCopyBlue");
/*      */     
/*  823 */     addEntityServer((Class)EntityCabba.class, "Cabba");
/*  824 */     addEntityServer((Class)EntityCabbaSSJ.class, "CabbaSSJ");
/*      */     
/*  826 */     addEntityServer((Class)EntityZamasu.class, "Zamasu");
/*  827 */     addEntityServer((Class)EntityZamasu_Fused.class, "Zamasu_fused");
/*  828 */     addEntityServer((Class)EntityZamasu_Fused2.class, "Zamasu_fused2");
/*  829 */     addEntityServer((Class)EntityZamasu_Fused3.class, "Zamasu_fused3");
/*      */     
/*  831 */     addEntityServer((Class)EntityZeno.class, "Zeno");
/*      */ 
/*      */     
/*  834 */     addEntityServer((Class)EntityGoku.class, "Goku_enemy");
/*  835 */     addEntityServer((Class)EntityGoku2.class, "Goku_enemy2");
/*  836 */     addEntityServer((Class)EntityGoku3.class, "Goku_enemy3");
/*  837 */     addEntityServer((Class)EntityGoku4.class, "Goku_enemy4");
/*      */     
/*  839 */     addEntityServer((Class)EntityVegeta.class, "Vegeta_enemy");
/*  840 */     addEntityServer((Class)EntityVegeta2.class, "Vegeta_enemy2");
/*  841 */     addEntityServer((Class)EntityVegeta3.class, "Vegeta_enemy3");
/*  842 */     addEntityServer((Class)EntityVegeta4.class, "Vegeta_enemy4");
/*      */     
/*  844 */     addEntityServer((Class)EntityGohan.class, "Gohan_enemy");
/*  845 */     addEntityServer((Class)EntityGohan2.class, "Gohan_enemy2");
/*  846 */     addEntityServer((Class)EntityGohan_orange.class, "Gohan_enemy2_1");
/*  847 */     addEntityServer((Class)EntityGohan_orange2.class, "Gohan_enemy2_2");
/*      */     
/*  849 */     addEntityServer((Class)EntityTrunks.class, "Trunks_enemy");
/*  850 */     addEntityServer((Class)EntityTrunks2.class, "Trunks_enemy2");
/*  851 */     addEntityServer((Class)EntityTrunks_dbs.class, "Trunks_enemy2_1");
/*  852 */     addEntityServer((Class)EntityTrunks_dbs2.class, "Trunks_enemy2_2");
/*      */ 
/*      */     
/*  855 */     addEntityServer((Class)EntityAngelAwamo.class, "AngelAwamo");
/*  856 */     addEntityServer((Class)EntityAngelCamparri.class, "AngelCamparri");
/*  857 */     addEntityServer((Class)EntityAngelCognac.class, "AngelCognac");
/*  858 */     addEntityServer((Class)EntityAngelCukatail.class, "AngelCuktail");
/*  859 */     addEntityServer((Class)EntityAngelKorn.class, "AngelKorn");
/*  860 */     addEntityServer((Class)EntityAngelKusu.class, "AngelKusu");
/*  861 */     addEntityServer((Class)EntityAngelMarcarita.class, "AngelMarcarita");
/*  862 */     addEntityServer((Class)EntityAngelMartinu.class, "AngelMartinu");
/*  863 */     addEntityServer((Class)EntityAngelMohito.class, "AngelMohito");
/*  864 */     addEntityServer((Class)EntityAngelSour.class, "AngelSour");
/*      */ 
/*      */     
/*  867 */     addEntityServer((Class)EntityGodArak.class, "GodArak");
/*  868 */     addEntityServer((Class)EntityGodBelmod.class, "GodBelmod");
/*  869 */     addEntityServer((Class)EntityGodGiin.class, "GodGiin");
/*  870 */     addEntityServer((Class)EntityGodHeles.class, "GodHeles");
/*  871 */     addEntityServer((Class)EntityGodIwan.class, "GodIwan");
/*  872 */     addEntityServer((Class)EntityGodLiquiir.class, "GodLiquiir");
/*  873 */     addEntityServer((Class)EntityGodMosco.class, "GodMosco");
/*  874 */     addEntityServer((Class)EntityGodQuitela.class, "GodQuitela");
/*  875 */     addEntityServer((Class)EntityGodRumsshi.class, "GodRumsshi");
/*  876 */     addEntityServer((Class)EntityGodSidra.class, "GodSidra");
/*      */ 
/*      */     
/*  879 */     addEntityServer((Class)EntityBasil.class, "Basil");
/*  880 */     addEntityServer((Class)EntityBergamo.class, "Bergamo");
/*  881 */     addEntityServer((Class)EntityLavender.class, "Lavender");
/*      */ 
/*      */     
/*  884 */     addEntityServer((Class)EntityBrianne.class, "Brianne");
/*  885 */     addEntityServer((Class)EntityCaulifla.class, "Caulifla");
/*  886 */     addEntityServer((Class)EntityCaulifla2.class, "Caulifla2");
/*  887 */     addEntityServer((Class)EntityDyspo.class, "Dyspo");
/*  888 */     addEntityServer((Class)EntityJiren.class, "Jiren");
/*  889 */     addEntityServer((Class)EntityJiren2.class, "Jiren2");
/*  890 */     addEntityServer((Class)EntityKale.class, "Kale");
/*  891 */     addEntityServer((Class)EntityKale2.class, "Kale2");
/*  892 */     addEntityServer((Class)EntityKefla.class, "Kefla");
/*  893 */     addEntityServer((Class)EntityKefla2.class, "Kefla2");
/*  894 */     addEntityServer((Class)EntityToppo.class, "Toppo");
/*  895 */     addEntityServer((Class)EntityToppo2.class, "Toppo2");
/*      */ 
/*      */     
/*  898 */     addEntityServer((Class)EntityAniraza.class, "Aniraza");
/*  899 */     addEntityServer((Class)EntityBiarra.class, "Biarra");
/*  900 */     addEntityServer((Class)EntityCocotte.class, "Cocotte");
/*  901 */     addEntityServer((Class)EntityDercori.class, "Dercori");
/*      */     
/*  903 */     addEntityServer((Class)EntityGanos.class, "Ganos");
/*  904 */     addEntityServer((Class)EntityGanos2.class, "Ganos2");
/*  905 */     addEntityServer((Class)EntityHop.class, "Hop");
/*  906 */     addEntityServer((Class)EntityKahseral.class, "Kahseral");
/*  907 */     addEntityServer((Class)EntityKakunsa.class, "Kakunsa");
/*  908 */     addEntityServer((Class)EntityKunshi.class, "Kunshi");
/*  909 */     addEntityServer((Class)EntityMajora.class, "Majora");
/*  910 */     addEntityServer((Class)EntityMurichim.class, "Murichim");
/*  911 */     addEntityServer((Class)EntityNapapa.class, "Napapa");
/*  912 */     addEntityServer((Class)EntityNarirama.class, "Narirama");
/*  913 */     addEntityServer((Class)EntityObni.class, "Obni");
/*  914 */     addEntityServer((Class)EntityPaparoni.class, "Paparoni");
/*  915 */     addEntityServer((Class)EntityRoasie.class, "Roasie");
/*  916 */     addEntityServer((Class)EntityRylibeu.class, "Rylibeu");
/*  917 */     addEntityServer((Class)EntityShosa.class, "Shosa");
/*  918 */     addEntityServer((Class)EntitySorrel.class, "Sorrel");
/*  919 */     addEntityServer((Class)EntityBorareta.class, "Borareta");
/*  920 */     addEntityServer((Class)EntityKoichiarator.class, "Koichiarator");
/*  921 */     addEntityServer((Class)EntityKoitsukai.class, "Koitsukai");
/*  922 */     addEntityServer((Class)EntityPanchia.class, "Panchia");
/*      */     
/*  924 */     addEntityServer((Class)EntityKatopesla.class, "Katopesla");
/*  925 */     addEntityServer((Class)EntityKatopesla2.class, "Katopesla2");
/*  926 */     addEntityServer((Class)EntityKatopesla3.class, "Katopesla3");
/*  927 */     addEntityServer((Class)EntityKatopesla4.class, "Katopesla4");
/*      */ 
/*      */ 
/*      */     
/*  931 */     addEntityServer((Class)EntityDBSBroly1.class, "DBSBroly");
/*  932 */     addEntityServer((Class)EntityDBSBroly2.class, "DBSBroly2");
/*  933 */     addEntityServer((Class)EntityDBSBroly3.class, "DBSBroly3");
/*  934 */     addEntityServer((Class)EntityDBSBroly4.class, "DBSBroly4");
/*  935 */     addEntityServer((Class)EntityDBSBrolyBuff.class, "DBSBrolyBuff");
/*  936 */     addEntityServer((Class)EntityDBSBrolyBuffSSJ.class, "DBSBrolyBuffSSJ");
/*  937 */     addEntityServer((Class)EntityDBSBrolyLegendary.class, "DBSBrolyLegendary");
/*  938 */     addEntityServer((Class)EntityDBSParagus.class, "DBSParagus");
/*  939 */     addEntityServer((Class)EntityDBSParagus2.class, "DBSParagusOld");
/*  940 */     addEntityServer((Class)EntityCheelai.class, "Cheelai");
/*  941 */     addEntityServer((Class)EntityCheelai2.class, "Cheelai2");
/*  942 */     addEntityServer((Class)EntityLemo.class, "Lemo");
/*      */ 
/*      */     
/*  945 */     addEntityServer((Class)EntityFortunetellerBaba.class, "FortunetellerBaba");
/*  946 */     addEntityServer((Class)EntityMummy.class, "BandagesTheMummy");
/*  947 */     addEntityServer((Class)EntityVampire.class, "FangsTheVampire");
/*  948 */     addEntityServer((Class)EntityInvisibleMan.class, "SeeThroughTheInvisibleMan");
/*  949 */     addEntityServer((Class)EntityDevil.class, "SpikeTheDevil");
/*  950 */     addEntityServer((Class)EntityGrandpaGohan.class, "GrandpaGohan");
/*  951 */     addEntityServer((Class)EntityGrandpaGohan2.class, "GrandpaGohan2");
/*      */ 
/*      */     
/*  954 */     addEntityServer((Class)EntityCymbal.class, "Cymbal");
/*  955 */     addEntityServer((Class)EntityDrum.class, "Drum");
/*  956 */     addEntityServer((Class)EntityKingPiccolo.class, "KingPiccolo");
/*  957 */     addEntityServer((Class)EntityKingPiccolo2.class, "KingPiccolo2");
/*  958 */     addEntityServer((Class)EntityPiano.class, "Piano");
/*  959 */     addEntityServer((Class)EntityTambourine.class, "Tambourine");
/*      */ 
/*      */     
/*  962 */     addEntityServer((Class)EntityDBMasterRoshi.class, "DBMasterRoshi");
/*  963 */     addEntityServer((Class)EntityDBMasterRoshi2.class, "DBMasterRoshi2");
/*  964 */     addEntityServer((Class)EntityDBMasterRoshi3.class, "DBMasterRoshi3");
/*  965 */     addEntityServer((Class)EntityBearThief.class, "BearThief");
/*  966 */     addEntityServer((Class)EntityTigerBandit.class, "TigerBandit");
/*  967 */     addEntityServer((Class)EntityPuar.class, "Puar");
/*  968 */     addEntityServer((Class)EntityYamcha.class, "Yamcha");
/*  969 */     addEntityServer((Class)EntityYamcha2.class, "Yamcha2");
/*  970 */     addEntityServer((Class)EntityYamcha3.class, "Yamcha3");
/*  971 */     addEntityServer((Class)EntityYamcha4.class, "Yamcha4");
/*  972 */     addEntityServer((Class)EntityYamcha5.class, "Yamcha5");
/*      */ 
/*      */     
/*  975 */     addEntityServer((Class)EntityMai.class, "DBMai");
/*  976 */     addEntityServer((Class)EntityPilaf.class, "DBPilaf");
/*  977 */     addEntityServer((Class)EntityShu.class, "DBShu");
/*  978 */     addEntityServer((Class)EntityMaiMecha.class, "DBMaiMecha");
/*  979 */     addEntityServer((Class)EntityPilafMecha.class, "DBPilafMecha");
/*  980 */     addEntityServer((Class)EntityShuMecha.class, "DBShuMecha");
/*  981 */     addEntityServer((Class)EntityPilafMechaCombined.class, "DBPilafMechaCombined");
/*      */ 
/*      */     
/*  984 */     addEntityServer((Class)EntityBacterian.class, "Bacterian");
/*  985 */     addEntityServer((Class)EntityGiran.class, "Giran");
/*  986 */     addEntityServer((Class)EntityJackieChun.class, "JackieChun");
/*  987 */     addEntityServer((Class)EntityJackieChun2.class, "JackieChun2");
/*  988 */     addEntityServer((Class)EntityJackieChun3.class, "JackieChun3");
/*  989 */     addEntityServer((Class)EntityNam.class, "Nam");
/*  990 */     addEntityServer((Class)EntityTournamentAnnouncer.class, "TournamentAnnouncer");
/*      */     
/*  992 */     addEntityServer((Class)EntityKingChappa.class, "KingChappa");
/*  993 */     addEntityServer((Class)EntityManWolf.class, "ManWolf");
/*  994 */     addEntityServer((Class)EntityMasterShen.class, "MasterShen");
/*  995 */     addEntityServer((Class)EntityPamput.class, "Pamput");
/*  996 */     addEntityServer((Class)EntityTien.class, "TienShinhan");
/*  997 */     addEntityServer((Class)EntityTien2.class, "TienShinhan2");
/*  998 */     addEntityServer((Class)EntityTien3.class, "TienShinhan3");
/*      */ 
/*      */     
/* 1001 */     addEntityServer((Class)EntityAndroid8.class, "Android8");
/* 1002 */     addEntityServer((Class)EntityBuyon.class, "Buyon");
/* 1003 */     addEntityServer((Class)EntityColonelSilver.class, "ColonelSilver");
/* 1004 */     addEntityServer((Class)EntityColonelViolet.class, "ColonelViolet");
/* 1005 */     addEntityServer((Class)EntityCommanderRed.class, "CommanderRed");
/* 1006 */     addEntityServer((Class)EntityGeneralBlue.class, "GeneralBlue");
/* 1007 */     addEntityServer((Class)EntityGeneralBlue2.class, "GeneralBlue2");
/* 1008 */     addEntityServer((Class)EntityGeneralWhite.class, "GeneralWhite");
/* 1009 */     addEntityServer((Class)EntityGeneralWhite2.class, "GeneralWhite2");
/* 1010 */     addEntityServer((Class)EntityLaunch.class, "LaunchGood");
/* 1011 */     addEntityServer((Class)EntityLaunch2.class, "LaunchBad");
/* 1012 */     addEntityServer((Class)EntityMajorMetallitron.class, "MajorMetallitron");
/* 1013 */     addEntityServer((Class)EntityMajorMetallitron1.class, "MajorMetallitron1");
/* 1014 */     addEntityServer((Class)EntityMajorMetallitron2.class, "MajorMetallitron2");
/* 1015 */     addEntityServer((Class)EntityMajorMetallitron3.class, "MajorMetallitron3");
/* 1016 */     addEntityServer((Class)EntityMercenaryTao.class, "MercenaryTao");
/* 1017 */     addEntityServer((Class)EntityNinjaMurasaki.class, "NinjaMurasaki");
/* 1018 */     addEntityServer((Class)EntityRedRibbonSoldier.class, "RedRibbonSoldier");
/* 1019 */     addEntityServer((Class)EntityRedRibbonSoldier2.class, "RedRibbonSoldier2");
/* 1020 */     addEntityServer((Class)EntityRedRibbonSoldier3.class, "RedRibbonSoldier3");
/* 1021 */     addEntityServer((Class)EntityRedRibbonSoldierB.class, "RedRibbonSoldierB");
/* 1022 */     addEntityServer((Class)EntityRedRibbonSoldierB2.class, "RedRibbonSoldierB2");
/* 1023 */     addEntityServer((Class)EntityRedRibbonSoldierB3.class, "RedRibbonSoldierB3");
/*      */     
/* 1025 */     addEntityServer((Class)EntityBora.class, "DBBora");
/* 1026 */     addEntityServer((Class)EntityUpa.class, "DBUpa");
/* 1027 */     addEntityServer((Class)EntityOolong.class, "Oolong");
/* 1028 */     addEntityServer((Class)EntityYajirobe.class, "Yajirobe");
/* 1029 */     addEntityServer((Class)EntityMercenaryTao2.class, "MercenaryTao2");
/* 1030 */     addEntityServer((Class)EntityMercenaryTao3.class, "MercenaryTao3");
/* 1031 */     addEntityServer((Class)EntityOfficerBlack.class, "OfficerBlack");
/* 1032 */     addEntityServer((Class)EntityOfficerBlack2.class, "OfficerBlack2");
/* 1033 */     addEntityServer((Class)EntityOfficerBlack3.class, "OfficerBlack3");
/*      */     
/* 1035 */     addEntityServer((Class)EntityOfficeOgre.class, "OfficeOgre");
/* 1036 */     addEntityServer((Class)EntityOfficeOgre2.class, "OfficeOgre2");
/* 1037 */     addEntityServer((Class)EntityOfficeOgre3.class, "OfficeOgre3");
/* 1038 */     addEntityServer((Class)EntityOfficeOgre4.class, "OfficeOgre4");
/* 1039 */     addEntityServer((Class)EntityOfficeOgre5.class, "OfficeOgre5");
/* 1040 */     addEntityServer((Class)EntitySpirit.class, "DBZSpirit");
/*      */     
/* 1042 */     addEntityServer((Class)EntityChiaotzu.class, "Chiaotzu");
/* 1043 */     addEntityServer((Class)EntityChiaotzu2.class, "Chiaotzu2");
/* 1044 */     addEntityServer((Class)EntityChiaotzu3.class, "Chiaotzu3");
/* 1045 */     addEntityServer((Class)EntityChiaotzu4.class, "Chiaotzu4");
/*      */     
/* 1047 */     addEntityServer((Class)EntityTien4.class, "TienShinhan4");
/* 1048 */     addEntityServer((Class)EntityTien5.class, "TienShinhan5");
/* 1049 */     addEntityServer((Class)EntityTien6.class, "TienShinhan6");
/* 1050 */     addEntityServer((Class)EntityTien7.class, "TienShinhan7");
/*      */ 
/*      */     
/* 1053 */     addEntityServer((Class)EntityPiccolo.class, "Piccolo");
/* 1054 */     addEntityServer((Class)EntityPiccolo2.class, "Piccolo2");
/*      */ 
/*      */ 
/*      */     
/* 1058 */     if (DBCConfig.SpawnrateBearThief > 0) EntityRegistry.addSpawn(EntityBearThief.class, DBCConfig.SpawnrateBearThief, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.field_76772_c, BiomeGenBase.field_76767_f, BiomeGenBase.field_76785_t, BiomeGenBase.field_150583_P, BiomeGenBase.field_150582_Q }); 
/* 1059 */     if (DBCConfig.SpawnrateTigerBandit > 0) EntityRegistry.addSpawn(EntityTigerBandit.class, DBCConfig.SpawnrateTigerBandit, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.field_76772_c, BiomeGenBase.field_76767_f, BiomeGenBase.field_76785_t, BiomeGenBase.field_150583_P, BiomeGenBase.field_150582_Q });
/*      */     
/* 1061 */     if (DBCConfig.SpawnrateRRMajor > 0) EntityRegistry.addSpawn(EntityMajorMetallitron.class, DBCConfig.SpawnrateRRMajor, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.field_76770_e, BiomeGenBase.field_76768_g, BiomeGenBase.field_150584_S, BiomeGenBase.field_150579_T, BiomeGenBase.field_76774_n, BiomeGenBase.field_76784_u }); 
/* 1062 */     if (DBCConfig.SpawnrateRRSoldiers > 0) {
/*      */       
/* 1064 */       EntityRegistry.addSpawn(EntityRedRibbonSoldier.class, DBCConfig.SpawnrateRRSoldiers, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.field_76770_e, BiomeGenBase.field_76768_g, BiomeGenBase.field_150584_S, BiomeGenBase.field_150579_T, BiomeGenBase.field_76774_n, BiomeGenBase.field_76784_u });
/* 1065 */       EntityRegistry.addSpawn(EntityRedRibbonSoldier2.class, DBCConfig.SpawnrateRRSoldiers, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.field_76770_e, BiomeGenBase.field_76768_g, BiomeGenBase.field_150584_S, BiomeGenBase.field_150579_T, BiomeGenBase.field_76774_n, BiomeGenBase.field_76784_u });
/* 1066 */       EntityRegistry.addSpawn(EntityRedRibbonSoldier3.class, DBCConfig.SpawnrateRRSoldiers, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.field_76770_e, BiomeGenBase.field_76768_g, BiomeGenBase.field_150584_S, BiomeGenBase.field_150579_T, BiomeGenBase.field_76774_n, BiomeGenBase.field_76784_u });
/*      */       
/* 1068 */       EntityRegistry.addSpawn(EntityRedRibbonSoldierB.class, DBCConfig.SpawnrateRRSoldiers, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.field_76770_e, BiomeGenBase.field_76768_g, BiomeGenBase.field_150584_S, BiomeGenBase.field_150579_T, BiomeGenBase.field_76774_n, BiomeGenBase.field_76784_u });
/* 1069 */       EntityRegistry.addSpawn(EntityRedRibbonSoldierB2.class, DBCConfig.SpawnrateRRSoldiers, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.field_76770_e, BiomeGenBase.field_76768_g, BiomeGenBase.field_150584_S, BiomeGenBase.field_150579_T, BiomeGenBase.field_76774_n, BiomeGenBase.field_76784_u });
/* 1070 */       EntityRegistry.addSpawn(EntityRedRibbonSoldierB3.class, DBCConfig.SpawnrateRRSoldiers, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.field_76770_e, BiomeGenBase.field_76768_g, BiomeGenBase.field_150584_S, BiomeGenBase.field_150579_T, BiomeGenBase.field_76774_n, BiomeGenBase.field_76784_u });
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1075 */     addEntityServer((Class)block01dbcEntity.class, "block01dbcEntity", 80, 1, false);
/*      */ 
/*      */ 
/*      */     
/* 1079 */     GameRegistry.registerTileEntity(DragonBlockS01TileEntity.class, "DragonBlockS01TileEntity");
/* 1080 */     GameRegistry.registerTileEntity(DragonBlockNS01TileEntity.class, "DragonBlockNS01TileEntity");
/* 1081 */     GameRegistry.registerTileEntity(DragonBlockNamek01TileEntity.class, "DragonBlockNamek01TileEntity");
/* 1082 */     GameRegistry.registerTileEntity(DragonBlock01TileEntity.class, "DragonBlock01TileEntity");
/* 1083 */     GameRegistry.registerTileEntity(SpacePod01TileEntity.class, "SpacePod01TileEntity");
/* 1084 */     GameRegistry.registerTileEntity(SaibaiHatchedTileEntity.class, "SaibaiHatchedTileEntity");
/* 1085 */     GameRegistry.registerTileEntity(MedPodDoor1TileEntity.class, "MedPodDoor1TileEntity");
/* 1086 */     GameRegistry.registerTileEntity(ArtGravDevTileEntity.class, "ArtGravDevTileEntity");
/* 1087 */     GameRegistry.registerTileEntity(ppTileEntity.class, "ppTileEntity");
/* 1088 */     GameRegistry.registerTileEntity(namekian_throneTileEntity.class, "namekian_throneTileEntity");
/*      */ 
/*      */ 
/*      */     
/* 1092 */     addEntityServer((Class)EntityInstantTransmission.class, "KiInstantTransmission", 400, 5);
/* 1093 */     addEntityServer((Class)EntityMajinAbsorption.class, "MajinAbsorption", 80, 1);
/*      */   }
/*      */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntitiesDBC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */