/*     */ package JinRyuu.DragonBC.common.Worlds;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldProvider;
/*     */ import net.minecraft.world.biome.WorldChunkManager;
/*     */ import net.minecraft.world.biome.WorldChunkManagerHell;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class x2WorldProviderTC
/*     */   extends WorldProvider
/*     */ {
/*     */   public int registerWorld() {
/*  24 */     return 23;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean renderClouds() {
/*  31 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean renderEndSky() {
/*  36 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean renderVoidFog() {
/*  41 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float setMoonSize() {
/*  49 */     return 0.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float setSunSize() {
/*  55 */     return 0.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSunTexture() {
/*  64 */     return "jinryuudragonbc:sun.png";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMoonTexture() {
/*  71 */     return "jinryuudragonbc:moon_phases.png";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean renderStars() {
/*  78 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean darkenSkyDuringRain() {
/*  86 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRespawnMessage() {
/*  93 */     return " Leaving Time Chamber";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasMultipleBiomes() {
/*  99 */     return false;
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
/*     */   public void func_76572_b() {
/* 112 */     this.field_76578_c = (WorldChunkManager)new WorldChunkManagerHell(BiomeGenBaseDBC.TC, 0.8F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IChunkProvider func_76555_c() {
/* 119 */     return new x2ChunkProviderTC(this.field_76579_a, this.field_76579_a.func_72905_C(), false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_76567_e() {
/* 129 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float func_76563_a(long par1, float par3) {
/* 136 */     return 1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSaveFolder() {
/* 141 */     return func_80007_l();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_80007_l() {
/* 147 */     return "TimeChamber";
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
/* 164 */     return getCloudHeight_();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_76557_i() {
/* 170 */     return getMinimumSpawnHeight(this.field_76579_a);
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
/* 181 */     return hasVoidParticles(this.field_76576_e);
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
/* 193 */     return voidFadeMagnitude();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double getHorizon() {
/* 199 */     return getHorizon(this.field_76579_a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMinimumSpawnHeight(World world) {
/* 206 */     return 4;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getCloudHeight_() {
/* 211 */     return 98.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getHorizon(World world) {
/* 216 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasVoidParticles(boolean flag) {
/* 221 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public double voidFadeMagnitude() {
/* 226 */     return 1.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canDoLightning(Chunk chunk) {
/* 231 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canDoRainSnowIce(Chunk chunk) {
/* 236 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Worlds\x2WorldProviderTC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */