/*     */ package JinRyuu.DragonBC.common.Worlds.Dimension.NullRealm;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.DBCConfig;
/*     */ import JinRyuu.DragonBC.common.Worlds.BiomeGenBaseDBC;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldProvider;
/*     */ import net.minecraft.world.biome.WorldChunkManager;
/*     */ import net.minecraft.world.biome.WorldChunkManagerHell;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ 
/*     */ public class x2WorldProviderNullRealm extends WorldProvider {
/*     */   public static final String name = "Null Realm";
/*     */   public static final int bgColorGreen = 2309901;
/*     */   public static final int bgColorPurple = 2427193;
/*     */   
/*     */   public int registerWorld() {
/*  21 */     return 24;
/*  22 */   } public boolean renderClouds() { return false; }
/*  23 */   public boolean renderEndSky() { return false; } public boolean renderVoidFog() {
/*  24 */     return true;
/*     */   }
/*  26 */   public float setMoonSize() { return 0.0F; } public float setSunSize() {
/*  27 */     return 0.0F;
/*     */   }
/*  29 */   public String getSunTexture() { return "jinryuudragonbc:sun.png"; } public String getMoonTexture() {
/*  30 */     return "jinryuudragonbc:moon_phases.png";
/*     */   } public boolean renderStars() {
/*  32 */     return true;
/*     */   } public boolean darkenSkyDuringRain() {
/*  34 */     return false;
/*     */   } public String getRespawnMessage() {
/*  36 */     return " Leaving Null Realm";
/*     */   } public boolean hasMultipleBiomes() {
/*  38 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_76572_b() {
/*  45 */     this.field_76578_c = (WorldChunkManager)new WorldChunkManagerHell(BiomeGenBaseDBC.NR, 0.8F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IChunkProvider func_76555_c() {
/*  52 */     return new x2ChunkProviderNullRealm(this.field_76579_a, this.field_76579_a.func_72905_C(), false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_76567_e() {
/*  58 */     return true;
/*     */   }
/*  60 */   public float func_76563_a(long par1, float par3) { return 1.0F; } public String getSaveFolder() {
/*  61 */     return func_80007_l();
/*     */   }
/*     */   public String func_80007_l() {
/*  64 */     return "Null Realm";
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
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_76571_f() {
/*  78 */     return getCloudHeight_();
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_76557_i() {
/*  83 */     return getMinimumSpawnHeight(this.field_76579_a);
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
/*  94 */     return hasVoidParticles(this.field_76576_e);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public double func_76565_k() {
/* 104 */     return voidFadeMagnitude();
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
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Vec3 func_76562_b(float p_76562_1_, float p_76562_2_) {
/* 153 */     int i = getBGColor();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 166 */     float f3 = (i >> 16 & 0xFF) / 255.0F;
/* 167 */     float f4 = (i >> 8 & 0xFF) / 255.0F;
/* 168 */     float f5 = (i & 0xFF) / 255.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 173 */     return Vec3.func_72443_a(f3, f4, f5);
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
/*     */   public double getHorizon() {
/* 191 */     return getHorizon(this.field_76579_a);
/*     */   }
/*     */   
/*     */   public int getMinimumSpawnHeight(World world) {
/* 195 */     return 4;
/*     */   } public float getCloudHeight_() {
/* 197 */     return 98.0F;
/*     */   } public double getHorizon(World world) {
/* 199 */     return 0.0D;
/*     */   } public boolean hasVoidParticles(boolean flag) {
/* 201 */     return false;
/*     */   } public double voidFadeMagnitude() {
/* 203 */     return 1.0D;
/*     */   } public boolean canDoLightning(Chunk chunk) {
/* 205 */     return true;
/*     */   } public boolean canDoRainSnowIce(Chunk chunk) {
/* 207 */     return true;
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
/*     */   public static int getBGColor() {
/* 255 */     if (DBCConfig.NullRealmBGColorNodeGreen) return 2309901; 
/* 256 */     return 2427193;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Worlds\Dimension\NullRealm\x2WorldProviderNullRealm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */