/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WorldGenLargeFeature
/*     */   extends StructureGenerator
/*     */ {
/*  17 */   private static List e = Arrays.asList(new BiomeBase[] { BiomeBase.DESERT, BiomeBase.DESERT_HILLS, BiomeBase.JUNGLE, BiomeBase.JUNGLE_HILLS, BiomeBase.SWAMPLAND });
/*     */   
/*  19 */   private List f = new ArrayList();
/*  20 */   private int g = 32;
/*  21 */   private int h = 8;
/*     */ 
/*     */ 
/*     */   
/*     */   public WorldGenLargeFeature() {
/*  26 */     this.f.add(new BiomeMeta(EntityWitch.class, 1, 1, 1));
/*     */   }
/*     */   
/*     */   public WorldGenLargeFeature(Map paramMap) {
/*  30 */     this();
/*     */     
/*  32 */     for (Map.Entry entry : paramMap.entrySet()) {
/*  33 */       if (((String)entry.getKey()).equals("distance")) {
/*  34 */         this.g = MathHelper.a((String)entry.getValue(), this.g, this.h + 1);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String a() {
/*  41 */     return "Temple";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean a(int paramInt1, int paramInt2) {
/*  47 */     int i = paramInt1;
/*  48 */     int j = paramInt2;
/*  49 */     if (paramInt1 < 0) paramInt1 -= this.g - 1; 
/*  50 */     if (paramInt2 < 0) paramInt2 -= this.g - 1;
/*     */     
/*  52 */     int k = paramInt1 / this.g;
/*  53 */     int m = paramInt2 / this.g;
/*  54 */     Random random = this.c.A(k, m, 14357617);
/*  55 */     k *= this.g;
/*  56 */     m *= this.g;
/*  57 */     k += random.nextInt(this.g - this.h);
/*  58 */     m += random.nextInt(this.g - this.h);
/*  59 */     paramInt1 = i;
/*  60 */     paramInt2 = j;
/*     */     
/*  62 */     if (paramInt1 == k && paramInt2 == m) {
/*  63 */       BiomeBase biomeBase = this.c.getWorldChunkManager().getBiome(paramInt1 * 16 + 8, paramInt2 * 16 + 8);
/*  64 */       for (BiomeBase biomeBase1 : e) {
/*  65 */         if (biomeBase == biomeBase1) {
/*  66 */           return true;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  71 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected StructureStart b(int paramInt1, int paramInt2) {
/*  77 */     return new WorldGenLargeFeatureStart(this.c, this.b, paramInt1, paramInt2);
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
/*     */   public boolean a(int paramInt1, int paramInt2, int paramInt3) {
/* 107 */     StructureStart structureStart = c(paramInt1, paramInt2, paramInt3);
/* 108 */     if (structureStart == null || !(structureStart instanceof WorldGenLargeFeatureStart) || structureStart.a.isEmpty()) {
/* 109 */       return false;
/*     */     }
/* 111 */     StructurePiece structurePiece = structureStart.a.getFirst();
/* 112 */     return structurePiece instanceof WorldGenWitchHut;
/*     */   }
/*     */   
/*     */   public List b() {
/* 116 */     return this.f;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\WorldGenLargeFeature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */