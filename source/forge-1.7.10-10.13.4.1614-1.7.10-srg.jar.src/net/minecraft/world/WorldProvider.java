/*     */ package net.minecraft.world;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import net.minecraft.world.biome.WorldChunkManager;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ import net.minecraft.world.gen.ChunkProviderFlat;
/*     */ import net.minecraft.world.gen.ChunkProviderGenerate;
/*     */ import net.minecraft.world.gen.FlatGeneratorInfo;
/*     */ 
/*     */ public abstract class WorldProvider {
/*  15 */   public static final float[] field_111203_a = new float[] { 1.0F, 0.75F, 0.5F, 0.25F, 0.0F, 0.25F, 0.5F, 0.75F };
/*     */   
/*     */   public World field_76579_a;
/*     */   
/*     */   public WorldType field_76577_b;
/*     */   public String field_82913_c;
/*     */   public WorldChunkManager field_76578_c;
/*     */   public boolean field_76575_d;
/*     */   public boolean field_76576_e;
/*  24 */   public float[] field_76573_f = new float[16];
/*     */   public int field_76574_g;
/*     */   
/*     */   public final void func_76558_a(World p_76558_1_) {
/*  28 */     this.field_76579_a = p_76558_1_;
/*  29 */     this.field_76577_b = p_76558_1_.func_72912_H().func_76067_t();
/*  30 */     this.field_82913_c = p_76558_1_.func_72912_H().func_82571_y();
/*  31 */     func_76572_b();
/*  32 */     func_76556_a();
/*     */   }
/*     */   
/*     */   protected void func_76556_a() {
/*  36 */     float f = 0.0F;
/*  37 */     for (byte b = 0; b <= 15; b++) {
/*  38 */       float f1 = 1.0F - b / 15.0F;
/*  39 */       this.field_76573_f[b] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_76572_b() {
/*  44 */     if (this.field_76579_a.func_72912_H().func_76067_t() == WorldType.field_77138_c) {
/*  45 */       FlatGeneratorInfo flatGeneratorInfo = FlatGeneratorInfo.func_82651_a(this.field_76579_a.func_72912_H().func_82571_y());
/*  46 */       this.field_76578_c = (WorldChunkManager)new WorldChunkManagerHell(BiomeGenBase.func_150568_d(flatGeneratorInfo.func_82648_a()), 0.5F);
/*     */     } else {
/*  48 */       this.field_76578_c = new WorldChunkManager(this.field_76579_a);
/*     */     } 
/*     */   }
/*     */   
/*     */   public IChunkProvider func_76555_c() {
/*  53 */     if (this.field_76577_b == WorldType.field_77138_c)
/*     */     {
/*  55 */       return (IChunkProvider)new ChunkProviderFlat(this.field_76579_a, this.field_76579_a.func_72905_C(), this.field_76579_a.func_72912_H().func_76089_r(), this.field_82913_c);
/*     */     }
/*  57 */     return (IChunkProvider)new ChunkProviderGenerate(this.field_76579_a, this.field_76579_a.func_72905_C(), this.field_76579_a.func_72912_H().func_76089_r());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_76566_a(int p_76566_1_, int p_76566_2_) {
/*  62 */     return (this.field_76579_a.func_147474_b(p_76566_1_, p_76566_2_) == Blocks.field_150349_c);
/*     */   }
/*     */   
/*     */   public float func_76563_a(long p_76563_1_, float p_76563_3_) {
/*  66 */     int i = (int)(p_76563_1_ % 24000L);
/*  67 */     float f1 = (i + p_76563_3_) / 24000.0F - 0.25F;
/*  68 */     if (f1 < 0.0F) f1++; 
/*  69 */     if (f1 > 1.0F) f1--; 
/*  70 */     float f2 = f1;
/*  71 */     f1 = 1.0F - (float)((Math.cos(f1 * Math.PI) + 1.0D) / 2.0D);
/*  72 */     f1 = f2 + (f1 - f2) / 3.0F;
/*  73 */     return f1;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_76559_b(long p_76559_1_) {
/*  78 */     return (int)(p_76559_1_ / 24000L % 8L + 8L) % 8;
/*     */   }
/*     */   
/*     */   public boolean func_76569_d() {
/*  82 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  87 */   private float[] field_76580_h = new float[4]; private static final String __OBFID = "CL_00000386";
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float[] func_76560_a(float p_76560_1_, float p_76560_2_) {
/*  91 */     float f1 = 0.4F;
/*  92 */     float f2 = MathHelper.func_76134_b(p_76560_1_ * 3.1415927F * 2.0F) - 0.0F;
/*  93 */     float f3 = -0.0F;
/*  94 */     if (f2 >= f3 - f1 && f2 <= f3 + f1) {
/*  95 */       float f4 = (f2 - f3) / f1 * 0.5F + 0.5F;
/*  96 */       float f5 = 1.0F - (1.0F - MathHelper.func_76126_a(f4 * 3.1415927F)) * 0.99F;
/*  97 */       f5 *= f5;
/*  98 */       this.field_76580_h[0] = f4 * 0.3F + 0.7F;
/*  99 */       this.field_76580_h[1] = f4 * f4 * 0.7F + 0.2F;
/* 100 */       this.field_76580_h[2] = f4 * f4 * 0.0F + 0.2F;
/* 101 */       this.field_76580_h[3] = f5;
/* 102 */       return this.field_76580_h;
/*     */     } 
/*     */     
/* 105 */     return null;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Vec3 func_76562_b(float p_76562_1_, float p_76562_2_) {
/* 109 */     float f1 = MathHelper.func_76134_b(p_76562_1_ * 3.1415927F * 2.0F) * 2.0F + 0.5F;
/* 110 */     if (f1 < 0.0F) f1 = 0.0F; 
/* 111 */     if (f1 > 1.0F) f1 = 1.0F;
/*     */     
/* 113 */     float f2 = 0.7529412F;
/* 114 */     float f3 = 0.84705883F;
/* 115 */     float f4 = 1.0F;
/* 116 */     f2 *= f1 * 0.94F + 0.06F;
/* 117 */     f3 *= f1 * 0.94F + 0.06F;
/* 118 */     f4 *= f1 * 0.91F + 0.09F;
/*     */     
/* 120 */     return Vec3.func_72443_a(f2, f3, f4);
/*     */   }
/*     */   
/*     */   public boolean func_76567_e() {
/* 124 */     return true;
/*     */   }
/*     */   
/*     */   public static WorldProvider func_76570_a(int p_76570_0_) {
/* 128 */     if (p_76570_0_ == -1) return new WorldProviderHell(); 
/* 129 */     if (p_76570_0_ == 0) return new WorldProviderSurface(); 
/* 130 */     if (p_76570_0_ == 1) return new WorldProviderEnd(); 
/* 131 */     return null;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_76571_f() {
/* 135 */     return 128.0F;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_76561_g() {
/* 139 */     return true;
/*     */   }
/*     */   
/*     */   public ChunkCoordinates func_76554_h() {
/* 143 */     return null;
/*     */   }
/*     */   
/*     */   public int func_76557_i() {
/* 147 */     if (this.field_76577_b == WorldType.field_77138_c) {
/* 148 */       return 4;
/*     */     }
/* 150 */     return 64;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_76564_j() {
/* 154 */     return (this.field_76577_b != WorldType.field_77138_c && !this.field_76576_e);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public double func_76565_k() {
/* 158 */     if (this.field_76577_b == WorldType.field_77138_c) {
/* 159 */       return 1.0D;
/*     */     }
/* 161 */     return 0.03125D;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_76568_b(int p_76568_1_, int p_76568_2_) {
/* 165 */     return false;
/*     */   }
/*     */   
/*     */   public abstract String func_80007_l();
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\WorldProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */