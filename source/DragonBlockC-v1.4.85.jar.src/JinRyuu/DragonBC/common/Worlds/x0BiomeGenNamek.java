/*     */ package JinRyuu.DragonBC.common.Worlds;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
/*     */ import JinRyuu.DragonBC.common.DBCConfig;
/*     */ import JinRyuu.DragonBC.common.Npcs.EntityDino01;
/*     */ import JinRyuu.DragonBC.common.Npcs.EntityDino02;
/*     */ import JinRyuu.DragonBC.common.Npcs.EntityDino03;
/*     */ import JinRyuu.DragonBC.common.Npcs.EntityNamekFrog;
/*     */ import java.awt.Color;
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.monster.EntitySpider;
/*     */ import net.minecraft.entity.monster.EntityZombie;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.ColorizerFoliage;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class x0BiomeGenNamek
/*     */   extends BiomeGenBaseDBC
/*     */ {
/*     */   BiomeDecoratorDBC customBiomeDecorator;
/*     */   
/*     */   public x0BiomeGenNamek(int par1) {
/*  29 */     super(par1);
/*  30 */     func_76735_a("Namek");
/*  31 */     this.field_76752_A = BlocksDBC.BlockNamekGrass;
/*  32 */     this.field_76753_B = BlocksDBC.BlockNamekDirt;
/*  33 */     this.field_76760_I = new BiomeDecoratorDBC();
/*  34 */     this.customBiomeDecorator = (BiomeDecoratorDBC)this.field_76760_I;
/*  35 */     this.customBiomeDecorator.NamekTreePerChunk = 2;
/*  36 */     this.customBiomeDecorator.NamekMedMossPerChunk = 2;
/*  37 */     this.customBiomeDecorator.WarenaiOrePerChunk = 10;
/*  38 */     this.customBiomeDecorator.NamekianHouseChunk = 60;
/*  39 */     this.customBiomeDecorator.NamekFreezaSoldiersChunk = 8;
/*     */ 
/*     */     
/*  42 */     func_76739_b(8368696);
/*     */     
/*  44 */     setMinMaxHeight(-0.3F, 0.4F);
/*  45 */     func_76732_a(0.8F, 0.9F);
/*     */     
/*  47 */     this.field_76750_F = 0.5F;
/*  48 */     this.field_76759_H = 65331;
/*  49 */     this.field_76761_J.clear();
/*  50 */     this.field_76762_K.clear();
/*  51 */     this.field_76755_L.clear();
/*     */     
/*  53 */     this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityZombie.class, 100, 1, 4));
/*  54 */     this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntitySpider.class, 100, 1, 4));
/*  55 */     if (DBCConfig.spwnrt_dino1 > 0) this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityDino01.class, DBCConfig.spwnrt_dino1, 1, 1)); 
/*  56 */     if (DBCConfig.spwnrt_dino2 > 0) this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityDino02.class, DBCConfig.spwnrt_dino2, 1, 1)); 
/*  57 */     if (DBCConfig.spwnrt_dino3 > 0) this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityDino03.class, DBCConfig.spwnrt_dino3, 1, 1));
/*     */     
/*  59 */     if (DBCConfig.spwnrt_frg > 0) this.field_76762_K.add(new BiomeGenBase.SpawnListEntry(EntityNamekFrog.class, DBCConfig.spwnrt_frg, 1, 1));
/*     */   
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
/*     */   public void func_76728_a(World world, Random random, int BlockX, int BlockZ) {
/* 162 */     super.func_76728_a(world, random, BlockX, BlockZ);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTextureFile() {
/* 168 */     return "jinryuudragonbc:watercolor.png";
/*     */   }
/*     */   
/*     */   public BiomeGenBase func_76732_a(float par1, float par2) {
/* 172 */     if (par1 > 0.1F && par1 < 0.2F)
/*     */     {
/* 174 */       throw new IllegalArgumentException("Please avoid temperatures in the range 0.1 - 0.2 because of snow");
/*     */     }
/*     */ 
/*     */     
/* 178 */     this.field_76750_F = par1;
/* 179 */     this.field_76751_G = par2;
/* 180 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BiomeGenBase setMinMaxHeight(float par1, float par2) {
/* 189 */     this.field_76748_D = par1;
/* 190 */     this.field_76749_E = par2;
/* 191 */     return this;
/*     */   }
/*     */   
/*     */   public final int getIntTemperature2() {
/* 195 */     return (int)(this.field_76750_F * 65536.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float getFloatTemperature2() {
/* 204 */     return this.field_76750_F;
/*     */   }
/*     */ 
/*     */   
/*     */   public BiomeGenBase func_76739_b(int par1) {
/* 209 */     this.field_76790_z = par1;
/* 210 */     return this;
/*     */   }
/*     */   
/*     */   public int func_76731_a(float par1) {
/* 214 */     par1 /= 3.0F;
/*     */     
/* 216 */     if (par1 < -1.0F)
/*     */     {
/* 218 */       par1 = -1.0F;
/*     */     }
/*     */     
/* 221 */     if (par1 > 1.0F)
/*     */     {
/* 223 */       par1 = 1.0F;
/*     */     }
/*     */     
/* 226 */     return Color.getHSBColor(0.42F - par1 * 0.05F, 0.5F + par1 * 0.1F, 1.0F).getRGB();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getBiomeFoliageColor() {
/* 231 */     double var1 = MathHelper.func_76131_a(getFloatTemperature2(), 0.0F, 1.0F);
/* 232 */     double var3 = MathHelper.func_76131_a(func_76727_i(), 0.0F, 1.0F);
/* 233 */     return ColorizerFoliage.func_77470_a(var1, var3);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Worlds\x0BiomeGenNamek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */