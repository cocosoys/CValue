/*     */ package JinRyuu.DragonBC.common.Worlds;
/*     */ 
/*     */ 
/*     */ public class x3BiomeGenVegata extends BiomeGenBaseDBC {
/*     */   BiomeDecoratorDBC customBiomeDecorator;
/*     */   final float HUE;
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
/*  22 */   public x3BiomeGenVegata(int par1) { super(par1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  97 */     this.HUE = Color.RGBtoHSB(255, 102, 102, null)[0]; func_76735_a("Vegeta"); this.field_76752_A = BlocksDBC.BlockNamekDirt; this.field_76753_B = BlocksDBC.BlockAlienStone; this.field_76760_I = new BiomeDecoratorDBC(); this.customBiomeDecorator = (BiomeDecoratorDBC)this.field_76760_I; func_76739_b(8368696); setMinMaxHeight(0.0F, 0.7F); func_76732_a(0.8F, 0.9F); this.field_76750_F = 0.5F; this.field_76759_H = 16711680; this.field_76761_J.clear(); this.field_76762_K.clear(); this.field_76755_L.clear();
/*     */     if (DBCConfig.spwnrt_syn > 0)
/*     */       this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntitySaiyan01.class, DBCConfig.spwnrt_syn, 1, 3)); 
/*     */     if (DBCConfig.spwnrt_syn2 > 0)
/* 101 */       this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntitySaiyan02.class, DBCConfig.spwnrt_syn2, 1, 3));  } public int func_76731_a(float par1) { par1 /= 3.0F;
/*     */     
/* 103 */     if (par1 < -1.0F)
/*     */     {
/* 105 */       par1 = -1.0F;
/*     */     }
/*     */     
/* 108 */     if (par1 > 1.0F)
/*     */     {
/* 110 */       par1 = 1.0F;
/*     */     }
/*     */     
/* 113 */     return Color.getHSBColor(this.HUE, 0.5F + par1 * 0.1F, 1.0F).getRGB(); } public final int getIntTemperature2() { return (int)(this.field_76750_F * 65536.0F); } public final float getFloatTemperature2() {
/*     */     return this.field_76750_F;
/*     */   } public BiomeGenBase func_76739_b(int par1) {
/*     */     this.field_76790_z = Color.getHSBColor(0.42F - par1 * 0.05F, 0.5F + par1 * 0.1F, 1.0F).getRGB();
/*     */     return this;
/*     */   }
/*     */   public int getBiomeFoliageColor() {
/* 120 */     double var1 = MathHelper.func_76131_a(getFloatTemperature2(), 0.0F, 1.0F);
/* 121 */     double var3 = MathHelper.func_76131_a(func_76727_i(), 0.0F, 1.0F);
/* 122 */     return ColorizerFoliage.func_77470_a(var1, var3);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Worlds\x3BiomeGenVegata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */