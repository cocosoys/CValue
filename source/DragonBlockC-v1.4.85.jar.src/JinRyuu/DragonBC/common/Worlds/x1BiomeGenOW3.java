/*     */ package JinRyuu.DragonBC.common.Worlds;
/*     */ public class x1BiomeGenOW3 extends BiomeGenBaseDBC {
/*     */   BiomeDecoratorDBC customBiomeDecorator;
/*     */   final float HUE;
/*     */   
/*     */   public void func_76728_a(World world, Random random, int par3, int par4) {
/*     */     super.func_76728_a(world, random, par3, par4);
/*     */   }
/*     */   
/*     */   public BiomeGenBase func_76732_a(float par1, float par2) {
/*     */     if (par1 > 0.1F && par1 < 0.2F)
/*     */       throw new IllegalArgumentException("Please avoid temperatures in the range 0.1 - 0.2 because of snow"); 
/*     */     this.field_76750_F = par1;
/*     */     this.field_76751_G = par2;
/*     */     return this;
/*     */   }
/*     */   
/*     */   public BiomeGenBase setMinMaxHeight(float par1, float par2) {
/*     */     this.field_76748_D = par1;
/*     */     this.field_76749_E = par2;
/*     */     return this;
/*     */   }
/*     */   
/*  24 */   public x1BiomeGenOW3(int par1) { super(par1);
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
/* 140 */     this.HUE = Color.RGBtoHSB(255, 102, 102, null)[0]; func_76735_a("Other World type 3"); this.field_76752_A = (Block)Blocks.field_150349_c; this.field_76753_B = (Block)Blocks.field_150349_c; this.field_76760_I = new BiomeDecoratorDBC(); this.customBiomeDecorator = (BiomeDecoratorDBC)this.field_76760_I; this.customBiomeDecorator.OWtri3PerChunk = 1; this.customBiomeDecorator.yellowFlowersPerChunk = 10; setMinMaxHeight(0.1F, 0.11F); func_76739_b(16421912); func_76745_m(); func_76732_a(2.0F, 0.0F); this.field_76750_F = 0.5F; this.field_76759_H = 16711680; this.field_76761_J.clear(); this.field_76762_K.clear(); this.field_76755_L.clear();
/*     */     if (!DBCConfig.DsblO && DBCConfig.spwnrt_ogre > 0) {
/*     */       this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityHell01.class, DBCConfig.spwnrt_ogre, 1, 2));
/*     */       this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityHell02.class, DBCConfig.spwnrt_ogre, 1, 2));
/* 144 */     }  } public int func_76731_a(float par1) { par1 /= 3.0F;
/*     */     
/* 146 */     if (par1 < -1.0F)
/*     */     {
/* 148 */       par1 = -1.0F;
/*     */     }
/*     */     
/* 151 */     if (par1 > 1.0F)
/*     */     {
/* 153 */       par1 = 1.0F;
/*     */     }
/*     */     
/* 156 */     return Color.getHSBColor(this.HUE, 0.5F + par1 * 0.1F, 1.0F).getRGB(); } public final int getIntTemperature2() { return (int)(this.field_76750_F * 65536.0F); } public final float getFloatTemperature2() {
/*     */     return this.field_76750_F;
/*     */   } public BiomeGenBase func_76739_b(int par1) {
/*     */     this.field_76790_z = Color.getHSBColor(0.42F - par1 * 0.05F, 0.5F + par1 * 0.1F, 1.0F).getRGB();
/*     */     return this;
/*     */   }
/*     */   public int getBiomeFoliageColor() {
/* 163 */     double var1 = MathHelper.func_76131_a(getFloatTemperature2(), 0.0F, 1.0F);
/* 164 */     double var3 = MathHelper.func_76131_a(func_76727_i(), 0.0F, 1.0F);
/* 165 */     return ColorizerFoliage.func_77470_a(var1, var3);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Worlds\x1BiomeGenOW3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */