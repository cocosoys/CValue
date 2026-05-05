/*     */ package net.minecraft.world.gen.structure;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.monster.EntityWitch;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ 
/*     */ 
/*     */ public class MapGenScatteredFeature
/*     */   extends MapGenStructure
/*     */ {
/*  17 */   private static List field_75061_e = Arrays.asList(new BiomeGenBase[] { BiomeGenBase.field_76769_d, BiomeGenBase.field_76786_s, BiomeGenBase.field_76782_w, BiomeGenBase.field_76792_x, BiomeGenBase.field_76780_h });
/*     */   
/*  19 */   private List field_82668_f = new ArrayList();
/*  20 */   private int field_82669_g = 32;
/*  21 */   private int field_82670_h = 8;
/*     */   
/*     */   private static final String __OBFID = "CL_00000471";
/*     */   
/*     */   public MapGenScatteredFeature() {
/*  26 */     this.field_82668_f.add(new BiomeGenBase.SpawnListEntry(EntityWitch.class, 1, 1, 1));
/*     */   }
/*     */   
/*     */   public MapGenScatteredFeature(Map p_i2061_1_) {
/*  30 */     this();
/*     */     
/*  32 */     for (Map.Entry entry : p_i2061_1_.entrySet()) {
/*  33 */       if (((String)entry.getKey()).equals("distance")) {
/*  34 */         this.field_82669_g = MathHelper.func_82714_a((String)entry.getValue(), this.field_82669_g, this.field_82670_h + 1);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_143025_a() {
/*  41 */     return "Temple";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_75047_a(int p_75047_1_, int p_75047_2_) {
/*  47 */     int i = p_75047_1_;
/*  48 */     int j = p_75047_2_;
/*  49 */     if (p_75047_1_ < 0) p_75047_1_ -= this.field_82669_g - 1; 
/*  50 */     if (p_75047_2_ < 0) p_75047_2_ -= this.field_82669_g - 1;
/*     */     
/*  52 */     int k = p_75047_1_ / this.field_82669_g;
/*  53 */     int m = p_75047_2_ / this.field_82669_g;
/*  54 */     Random random = this.field_75039_c.func_72843_D(k, m, 14357617);
/*  55 */     k *= this.field_82669_g;
/*  56 */     m *= this.field_82669_g;
/*  57 */     k += random.nextInt(this.field_82669_g - this.field_82670_h);
/*  58 */     m += random.nextInt(this.field_82669_g - this.field_82670_h);
/*  59 */     p_75047_1_ = i;
/*  60 */     p_75047_2_ = j;
/*     */     
/*  62 */     if (p_75047_1_ == k && p_75047_2_ == m) {
/*  63 */       BiomeGenBase biomeGenBase = this.field_75039_c.func_72959_q().func_76935_a(p_75047_1_ * 16 + 8, p_75047_2_ * 16 + 8);
/*  64 */       for (BiomeGenBase biomeGenBase1 : field_75061_e) {
/*  65 */         if (biomeGenBase == biomeGenBase1) {
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
/*     */   protected StructureStart func_75049_b(int p_75049_1_, int p_75049_2_) {
/*  77 */     return new Start(this.field_75039_c, this.field_75038_b, p_75049_1_, p_75049_2_);
/*     */   }
/*     */   
/*     */   public static class Start
/*     */     extends StructureStart
/*     */   {
/*     */     private static final String __OBFID = "CL_00000472";
/*     */     
/*     */     public Start() {}
/*     */     
/*     */     public Start(World p_i2060_1_, Random p_i2060_2_, int p_i2060_3_, int p_i2060_4_) {
/*  88 */       super(p_i2060_3_, p_i2060_4_);
/*  89 */       BiomeGenBase biomeGenBase = p_i2060_1_.func_72807_a(p_i2060_3_ * 16 + 8, p_i2060_4_ * 16 + 8);
/*  90 */       if (biomeGenBase == BiomeGenBase.field_76782_w || biomeGenBase == BiomeGenBase.field_76792_x) {
/*  91 */         ComponentScatteredFeaturePieces.JunglePyramid junglePyramid = new ComponentScatteredFeaturePieces.JunglePyramid(p_i2060_2_, p_i2060_3_ * 16, p_i2060_4_ * 16);
/*  92 */         this.field_75075_a.add(junglePyramid);
/*  93 */       } else if (biomeGenBase == BiomeGenBase.field_76780_h) {
/*  94 */         ComponentScatteredFeaturePieces.SwampHut swampHut = new ComponentScatteredFeaturePieces.SwampHut(p_i2060_2_, p_i2060_3_ * 16, p_i2060_4_ * 16);
/*  95 */         this.field_75075_a.add(swampHut);
/*     */       } else {
/*  97 */         ComponentScatteredFeaturePieces.DesertPyramid desertPyramid = new ComponentScatteredFeaturePieces.DesertPyramid(p_i2060_2_, p_i2060_3_ * 16, p_i2060_4_ * 16);
/*  98 */         this.field_75075_a.add(desertPyramid);
/*     */       } 
/*     */       
/* 101 */       func_75072_c();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_143030_a(int p_143030_1_, int p_143030_2_, int p_143030_3_) {
/* 107 */     StructureStart structureStart = func_143028_c(p_143030_1_, p_143030_2_, p_143030_3_);
/* 108 */     if (structureStart == null || !(structureStart instanceof Start) || structureStart.field_75075_a.isEmpty()) {
/* 109 */       return false;
/*     */     }
/* 111 */     StructureComponent structureComponent = structureStart.field_75075_a.getFirst();
/* 112 */     return structureComponent instanceof ComponentScatteredFeaturePieces.SwampHut;
/*     */   }
/*     */   
/*     */   public List func_82667_a() {
/* 116 */     return this.field_82668_f;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\structure\MapGenScatteredFeature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */