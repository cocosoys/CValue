/*     */ package JinRyuu.DragonBC.common.Worlds;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.DBCConfig;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldProvider;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ import net.minecraftforge.common.DimensionManager;
/*     */ 
/*     */ 
/*     */ public class x0WorldProviderNamek
/*     */   extends WorldProvider
/*     */ {
/*     */   public IChunkProvider func_76555_c() {
/*  20 */     return new x0ChunkProviderNamek(this.field_76579_a, this.field_76579_a.func_72905_C(), true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_76572_b() {
/*  26 */     this.field_76578_c = new x0WorldChunkManagerNamek(this.field_76579_a.func_72905_C(), this.field_76577_b);
/*  27 */     this.field_76574_g = DBCConfig.planetNamek;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static WorldProvider getProviderForDimension(int id) {
/*  33 */     return DimensionManager.createProviderFor(DBCConfig.planetNamek);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_80007_l() {
/*  41 */     return "Namek";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSaveFolder() {
/*  47 */     return func_80007_l();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float func_76563_a(long par1, float par3) {
/*  53 */     return 1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean renderStars() {
/*  59 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public double getMovementFactor() {
/*  65 */     return 0.1D;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float getStarBrightness(World world, float f) {
/*  71 */     return 1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean renderClouds() {
/*  77 */     return true;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean renderVoidFog() {
/*  82 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean renderEndSky() {
/*  88 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float setSunSize() {
/*  94 */     return 0.25F;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float setMoonSize() {
/* 100 */     return 4.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Vec3 getSkyColor(Entity cameraEntity, float partialTicks) {
/* 109 */     return this.field_76579_a.getSkyColorBody(cameraEntity, partialTicks);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_76561_g() {
/* 116 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_76567_e() {
/* 123 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_76569_d() {
/* 130 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_76571_f() {
/* 138 */     return this.field_76577_b.getCloudHeight();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ChunkCoordinates func_76554_h() {
/* 144 */     return new ChunkCoordinates(50, 5, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_76556_a() {
/* 151 */     float f = 0.0F;
/*     */     
/* 153 */     for (int i = 0; i <= 15; i++) {
/*     */       
/* 155 */       float f1 = 1.0F - i / 15.0F;
/* 156 */       this.field_76573_f[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getWelcomeMessage() {
/* 165 */     return "Entering Planet Namek";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getDepartMessage() {
/* 173 */     return "Leaving Planet Namek";
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
/*     */   public Vec3 drawClouds(float partialTicks) {
/* 195 */     return super.drawClouds(partialTicks);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Vec3 func_76562_b(float par1, float par2) {
/* 202 */     float f2 = MathHelper.func_76134_b(par1 * 3.1415927F * 2.0F) * 2.0F + 0.5F;
/*     */     
/* 204 */     if (f2 < 0.0F)
/*     */     {
/* 206 */       f2 = 0.0F;
/*     */     }
/*     */     
/* 209 */     if (f2 > 1.0F)
/*     */     {
/* 211 */       f2 = 1.0F;
/*     */     }
/*     */     
/* 214 */     float f3 = 0.7529412F;
/* 215 */     float f4 = 0.84705883F;
/* 216 */     float f5 = 1.0F;
/* 217 */     f3 *= f2 * 0.94F + 0.06F;
/* 218 */     f4 *= f2 * 0.94F + 0.06F;
/* 219 */     f5 *= f2 * 0.91F + 0.09F;
/* 220 */     return Vec3.func_72443_a(f3, f4, f5);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Worlds\x0WorldProviderNamek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */