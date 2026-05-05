/*    */ package JinRyuu.DragonBC.common.Worlds.Dimension.NullRealm;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.Worlds.BiomeGenBaseDBC;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.ColorizerFoliage;
/*    */ import net.minecraft.world.biome.BiomeGenBase;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BiomeNullRealm
/*    */   extends BiomeGenBaseDBC
/*    */ {
/*    */   public BiomeNullRealm(int par1) {
/* 17 */     super(par1);
/* 18 */     func_76735_a("Null Realm");
/* 19 */     this.field_76752_A = Blocks.field_150350_a;
/* 20 */     this.field_76753_B = Blocks.field_150350_a;
/* 21 */     func_76745_m();
/* 22 */     func_76739_b(16777215);
/* 23 */     setMinMaxHeight(0.0F, 0.0F);
/* 24 */     func_76732_a(0.8F, 0.9F);
/*    */     
/* 26 */     this.field_76750_F = 0.5F;
/* 27 */     this.field_76759_H = 10631373;
/* 28 */     this.field_76761_J.clear();
/* 29 */     this.field_76762_K.clear();
/* 30 */     this.field_76755_L.clear();
/*    */   }
/*    */   
/*    */   public BiomeGenBase func_76732_a(float par1, float par2) {
/* 34 */     if (par1 > 0.1F && par1 < 0.2F)
/*    */     {
/* 36 */       throw new IllegalArgumentException("Please avoid temperatures in the range 0.1 - 0.2 because of snow");
/*    */     }
/*    */ 
/*    */     
/* 40 */     this.field_76750_F = par1;
/* 41 */     this.field_76751_G = par2;
/* 42 */     return (BiomeGenBase)this;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public BiomeGenBase setMinMaxHeight(float par1, float par2) {
/* 51 */     this.field_76748_D = par1;
/* 52 */     this.field_76749_E = par2;
/* 53 */     return (BiomeGenBase)this;
/*    */   }
/*    */   
/*    */   public final int getIntTemperature2() {
/* 57 */     return (int)(this.field_76750_F * 65536.0F);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final float getFloatTemperature2() {
/* 66 */     return this.field_76750_F;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_76731_a(float par1) {
/* 84 */     return x2WorldProviderNullRealm.getBGColor();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getBiomeFoliageColor() {
/* 90 */     double var1 = MathHelper.func_76131_a(getFloatTemperature2(), 0.0F, 1.0F);
/* 91 */     double var3 = MathHelper.func_76131_a(func_76727_i(), 0.0F, 1.0F);
/* 92 */     return ColorizerFoliage.func_77470_a(var1, var3);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Worlds\Dimension\NullRealm\BiomeNullRealm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */