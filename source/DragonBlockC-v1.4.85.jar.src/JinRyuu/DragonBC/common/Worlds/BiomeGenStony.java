/*     */ package JinRyuu.DragonBC.common.Worlds;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
/*     */ import JinRyuu.DragonBC.common.DBCConfig;
/*     */ import JinRyuu.DragonBC.common.Npcs.EntityDino01;
/*     */ import JinRyuu.DragonBC.common.Npcs.EntityDino02;
/*     */ import JinRyuu.DragonBC.common.Npcs.EntityDino03;
/*     */ import JinRyuu.DragonBC.common.Npcs.EntityRRMecha;
/*     */ import JinRyuu.DragonBC.common.Npcs.EntitySabertooth;
/*     */ import JinRyuu.DragonBC.common.Npcs.db.EntityBearThief;
/*     */ import JinRyuu.DragonBC.common.Npcs.db.EntityTigerBandit;
/*     */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityMajorMetallitron;
/*     */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityRedRibbonSoldier;
/*     */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityRedRibbonSoldier2;
/*     */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityRedRibbonSoldier3;
/*     */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityRedRibbonSoldierB;
/*     */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityRedRibbonSoldierB2;
/*     */ import JinRyuu.DragonBC.common.Npcs.dbredribbon.EntityRedRibbonSoldierB3;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.ColorizerFoliage;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ 
/*     */ public class BiomeGenStony
/*     */   extends BiomeGenBase {
/*     */   BiomeDecoratorDBC customBiomeDecorator;
/*  26 */   public static final BiomeGenBase Stony = BiomeGenBaseDBC.Stony;
/*     */ 
/*     */   
/*     */   public BiomeGenStony(int par1) {
/*  30 */     super(par1);
/*  31 */     func_76735_a("Dirty Stony");
/*  32 */     this.field_76752_A = BlocksDBC.BlockNamekDirt;
/*  33 */     this.field_76753_B = BlocksDBC.BlockAlienStone;
/*  34 */     this.field_76760_I = new BiomeDecoratorDBC();
/*  35 */     this.customBiomeDecorator = (BiomeDecoratorDBC)this.field_76760_I;
/*  36 */     this.customBiomeDecorator.NamekTreePerChunk = 0;
/*  37 */     this.customBiomeDecorator.WarenaiOrePerChunk = 0;
/*  38 */     this.customBiomeDecorator.NamekianHouseChunk = 0;
/*  39 */     this.customBiomeDecorator.NamekFreezaSoldiersChunk = 0;
/*     */     
/*  41 */     setMinMaxHeight(0.4F, 1.5F);
/*  42 */     func_76732_a(0.8F, 0.9F);
/*     */     
/*  44 */     this.field_76750_F = 0.5F;
/*  45 */     this.field_76762_K.clear();
/*  46 */     this.field_76755_L.clear();
/*     */ 
/*     */     
/*  49 */     if (DBCConfig.spwnrt_dino1 > 0) this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityDino01.class, DBCConfig.spwnrt_dino1, 1, 1)); 
/*  50 */     if (DBCConfig.spwnrt_dino2 > 0) this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityDino02.class, DBCConfig.spwnrt_dino2, 1, 1)); 
/*  51 */     if (DBCConfig.spwnrt_dino3 > 0) this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityDino03.class, DBCConfig.spwnrt_dino3, 1, 1)); 
/*  52 */     if (DBCConfig.spwnrt_rrmech1 > 0) this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityRRMecha.class, DBCConfig.spwnrt_rrmech1, 1, 1)); 
/*  53 */     if (DBCConfig.spwnrt_sabert > 0) this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntitySabertooth.class, DBCConfig.spwnrt_sabert, 1, 1));
/*     */     
/*  55 */     if (DBCConfig.SpawnrateBearThief > 0) this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityBearThief.class, DBCConfig.SpawnrateBearThief, 1, 1)); 
/*  56 */     if (DBCConfig.SpawnrateTigerBandit > 0) this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityTigerBandit.class, DBCConfig.SpawnrateTigerBandit, 1, 1));
/*     */     
/*  58 */     if (DBCConfig.SpawnrateRRMajor > 0) this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityMajorMetallitron.class, DBCConfig.SpawnrateRRMajor, 1, 1)); 
/*  59 */     if (DBCConfig.SpawnrateRRSoldiers > 0) {
/*     */       
/*  61 */       this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityRedRibbonSoldier.class, DBCConfig.SpawnrateRRSoldiers, 1, 1));
/*  62 */       this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityRedRibbonSoldier2.class, DBCConfig.SpawnrateRRSoldiers, 1, 1));
/*  63 */       this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityRedRibbonSoldier3.class, DBCConfig.SpawnrateRRSoldiers, 1, 1));
/*     */       
/*  65 */       this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityRedRibbonSoldierB.class, DBCConfig.SpawnrateRRSoldiers, 1, 1));
/*  66 */       this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityRedRibbonSoldierB2.class, DBCConfig.SpawnrateRRSoldiers, 1, 1));
/*  67 */       this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityRedRibbonSoldierB3.class, DBCConfig.SpawnrateRRSoldiers, 1, 1));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public BiomeGenBase func_76732_a(float par1, float par2) {
/*  73 */     if (par1 > 0.1F && par1 < 0.2F)
/*     */     {
/*  75 */       throw new IllegalArgumentException("Please avoid temperatures in the range 0.1 - 0.2 because of snow");
/*     */     }
/*     */ 
/*     */     
/*  79 */     this.field_76750_F = par1;
/*  80 */     this.field_76751_G = par2;
/*  81 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BiomeGenBase setMinMaxHeight(float par1, float par2) {
/*  90 */     this.field_76748_D = par1;
/*  91 */     this.field_76749_E = par2;
/*  92 */     return this;
/*     */   }
/*     */   
/*     */   public final int getIntTemperature2() {
/*  96 */     return (int)(this.field_76750_F * 65536.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float getFloatTemperature2() {
/* 104 */     return this.field_76750_F;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getBiomeFoliageColor() {
/* 109 */     double var1 = MathHelper.func_76131_a(getFloatTemperature2(), 0.0F, 1.0F);
/* 110 */     double var3 = MathHelper.func_76131_a(func_76727_i(), 0.0F, 1.0F);
/* 111 */     return ColorizerFoliage.func_77470_a(var1, var3);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Worlds\BiomeGenStony.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */