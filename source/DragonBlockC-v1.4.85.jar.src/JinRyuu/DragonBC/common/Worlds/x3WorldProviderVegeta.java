/*     */ package JinRyuu.DragonBC.common.Worlds;
/*     */ 
/*     */ import net.minecraft.world.WorldProvider;
/*     */ import net.minecraft.world.biome.WorldChunkManager;
/*     */ import net.minecraft.world.biome.WorldChunkManagerHell;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class x3WorldProviderVegeta
/*     */   extends WorldProvider
/*     */ {
/*     */   public int registerWorld() {
/*  19 */     return 21;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean renderClouds() {
/*  26 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean renderEndSky() {
/*  31 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean renderVoidFog() {
/*  36 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float setMoonSize() {
/*  44 */     return 5.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float setSunSize() {
/*  50 */     return 4.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSunTexture() {
/*  59 */     return "jinryuudragonbc:sun.png";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMoonTexture() {
/*  66 */     return "jinryuudragonbc:moon_phases.png";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean renderStars() {
/*  73 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean darkenSkyDuringRain() {
/*  81 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRespawnMessage() {
/*  88 */     return " Leaving Planet Vegeta ";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasMultipleBiomes() {
/*  94 */     return true;
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
/* 107 */     this.field_76578_c = (WorldChunkManager)new WorldChunkManagerHell(BiomeGenBaseDBC.Vegeta, 0.8F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IChunkProvider func_76555_c() {
/* 117 */     return new x0ChunkProviderNamek(this.field_76579_a, this.field_76579_a.func_72905_C(), true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_76567_e() {
/* 127 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float func_76563_a(long par1, float par3) {
/* 134 */     return 1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSaveFolder() {
/* 139 */     return func_80007_l();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_80007_l() {
/* 145 */     return "Vegeta";
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Worlds\x3WorldProviderVegeta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */