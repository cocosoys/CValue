/*     */ package JinRyuu.DragonBC.common.Worlds;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.DBCConfig;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldProvider;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ import net.minecraftforge.common.DimensionManager;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class x1WorldProviderOW
/*     */   extends WorldProvider
/*     */ {
/*     */   public int registerWorld() {
/*  25 */     return 22;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean renderClouds() {
/*  32 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean renderEndSky() {
/*  37 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean renderVoidFog() {
/*  42 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float setMoonSize() {
/*  50 */     return 5.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float setSunSize() {
/*  56 */     return 4.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSunTexture() {
/*  65 */     return "jinryuudragonbc:sun.png";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMoonTexture() {
/*  72 */     return "jinryuudragonbc:moon_phases.png";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean renderStars() {
/*  79 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean darkenSkyDuringRain() {
/*  87 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRespawnMessage() {
/*  94 */     return " Leaving Other World ";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasMultipleBiomes() {
/* 100 */     return true;
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
/*     */   public void func_76572_b() {
/* 115 */     this.field_76578_c = new x1WorldChunkManagerOW(this.field_76579_a.func_72905_C(), this.field_76577_b);
/* 116 */     this.field_76574_g = DBCConfig.otherWorld;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IChunkProvider func_76555_c() {
/* 122 */     return new x1ChunkProviderOW(this.field_76579_a, this.field_76579_a.func_72905_C(), false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_76567_e() {
/* 133 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float func_76563_a(long par1, float par3) {
/* 141 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSaveFolder() {
/* 147 */     return func_80007_l();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_80007_l() {
/* 153 */     return "OtherWorld";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static WorldProvider getProviderForDimension(int id) {
/* 163 */     return DimensionManager.createProviderFor(DBCConfig.otherWorld);
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
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_76571_f() {
/* 180 */     return getCloudHeight_();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_76557_i() {
/* 186 */     return getMinimumSpawnHeight(this.field_76579_a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_76564_j() {
/* 197 */     return hasVoidParticles(this.field_76576_e);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public double func_76565_k() {
/* 209 */     return voidFadeMagnitude();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double getHorizon() {
/* 215 */     return getHorizon(this.field_76579_a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMinimumSpawnHeight(World world) {
/* 222 */     return 4;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getCloudHeight_() {
/* 227 */     return 128.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getHorizon(World world) {
/* 232 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasVoidParticles(boolean flag) {
/* 237 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public double voidFadeMagnitude() {
/* 242 */     return 1.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canDoLightning(Chunk chunk) {
/* 247 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canDoRainSnowIce(Chunk chunk) {
/* 252 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Worlds\x1WorldProviderOW.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */