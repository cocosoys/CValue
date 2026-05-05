/*     */ package net.minecraft.world.gen.structure;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.ChunkCoordIntPair;
/*     */ import net.minecraft.world.ChunkPosition;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ 
/*     */ public class MapGenStronghold
/*     */   extends MapGenStructure
/*     */ {
/*     */   public final List field_151546_e;
/*     */   private boolean field_75056_f;
/*  18 */   private ChunkCoordIntPair[] field_75057_g = new ChunkCoordIntPair[3];
/*  19 */   private double field_82671_h = 32.0D;
/*  20 */   private int field_82672_i = 3;
/*     */   private static final String __OBFID = "CL_00000481";
/*     */   
/*     */   public MapGenStronghold() {
/*  24 */     this.field_151546_e = new ArrayList();
/*  25 */     for (BiomeGenBase biomeGenBase : BiomeGenBase.func_150565_n()) {
/*  26 */       if (biomeGenBase != null && biomeGenBase.field_76748_D > 0.0F) {
/*  27 */         this.field_151546_e.add(biomeGenBase);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public MapGenStronghold(Map p_i2068_1_) {
/*  33 */     this();
/*  34 */     for (Map.Entry entry : p_i2068_1_.entrySet()) {
/*  35 */       if (((String)entry.getKey()).equals("distance")) {
/*  36 */         this.field_82671_h = MathHelper.func_82713_a((String)entry.getValue(), this.field_82671_h, 1.0D); continue;
/*  37 */       }  if (((String)entry.getKey()).equals("count")) {
/*  38 */         this.field_75057_g = new ChunkCoordIntPair[MathHelper.func_82714_a((String)entry.getValue(), this.field_75057_g.length, 1)]; continue;
/*  39 */       }  if (((String)entry.getKey()).equals("spread")) {
/*  40 */         this.field_82672_i = MathHelper.func_82714_a((String)entry.getValue(), this.field_82672_i, 1);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_143025_a() {
/*  47 */     return "Stronghold";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_75047_a(int p_75047_1_, int p_75047_2_) {
/*  53 */     if (!this.field_75056_f) {
/*  54 */       Random random = new Random();
/*     */       
/*  56 */       random.setSeed(this.field_75039_c.func_72905_C());
/*     */       
/*  58 */       double d = random.nextDouble() * Math.PI * 2.0D;
/*  59 */       int i = 1;
/*     */       
/*  61 */       for (byte b = 0; b < this.field_75057_g.length; b++) {
/*  62 */         double d1 = (1.25D * i + random.nextDouble()) * this.field_82671_h * i;
/*  63 */         int j = (int)Math.round(Math.cos(d) * d1);
/*  64 */         int k = (int)Math.round(Math.sin(d) * d1);
/*     */         
/*  66 */         ChunkPosition chunkPosition = this.field_75039_c.func_72959_q().func_150795_a((j << 4) + 8, (k << 4) + 8, 112, this.field_151546_e, random);
/*  67 */         if (chunkPosition != null) {
/*  68 */           j = chunkPosition.field_151329_a >> 4;
/*  69 */           k = chunkPosition.field_151328_c >> 4;
/*     */         } 
/*     */         
/*  72 */         this.field_75057_g[b] = new ChunkCoordIntPair(j, k);
/*     */         
/*  74 */         d += 6.283185307179586D * i / this.field_82672_i;
/*     */         
/*  76 */         if (b == this.field_82672_i) {
/*  77 */           i += 2 + random.nextInt(5);
/*  78 */           this.field_82672_i += 1 + random.nextInt(2);
/*     */         } 
/*     */       } 
/*     */       
/*  82 */       this.field_75056_f = true;
/*     */     } 
/*  84 */     for (ChunkCoordIntPair chunkCoordIntPair : this.field_75057_g) {
/*  85 */       if (p_75047_1_ == chunkCoordIntPair.field_77276_a && p_75047_2_ == chunkCoordIntPair.field_77275_b) {
/*  86 */         return true;
/*     */       }
/*     */     } 
/*  89 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected List func_75052_o_() {
/*  94 */     ArrayList<ChunkPosition> arrayList = new ArrayList();
/*  95 */     for (ChunkCoordIntPair chunkCoordIntPair : this.field_75057_g) {
/*  96 */       if (chunkCoordIntPair != null) {
/*  97 */         arrayList.add(chunkCoordIntPair.func_151349_a(64));
/*     */       }
/*     */     } 
/* 100 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   protected StructureStart func_75049_b(int p_75049_1_, int p_75049_2_) {
/* 105 */     Start start = new Start(this.field_75039_c, this.field_75038_b, p_75049_1_, p_75049_2_);
/*     */     
/* 107 */     while (start.func_75073_b().isEmpty() || ((StructureStrongholdPieces.Stairs2)start.func_75073_b().get(0)).field_75025_b == null)
/*     */     {
/* 109 */       start = new Start(this.field_75039_c, this.field_75038_b, p_75049_1_, p_75049_2_);
/*     */     }
/*     */     
/* 112 */     return start;
/*     */   }
/*     */   
/*     */   public static class Start
/*     */     extends StructureStart {
/*     */     private static final String __OBFID = "CL_00000482";
/*     */     
/*     */     public Start() {}
/*     */     
/*     */     public Start(World p_i2067_1_, Random p_i2067_2_, int p_i2067_3_, int p_i2067_4_) {
/* 122 */       super(p_i2067_3_, p_i2067_4_);
/*     */       
/* 124 */       StructureStrongholdPieces.func_75198_a();
/*     */       
/* 126 */       StructureStrongholdPieces.Stairs2 stairs2 = new StructureStrongholdPieces.Stairs2(0, p_i2067_2_, (p_i2067_3_ << 4) + 2, (p_i2067_4_ << 4) + 2);
/* 127 */       this.field_75075_a.add(stairs2);
/* 128 */       stairs2.func_74861_a(stairs2, this.field_75075_a, p_i2067_2_);
/*     */       
/* 130 */       List<StructureComponent> list = stairs2.field_75026_c;
/* 131 */       while (!list.isEmpty()) {
/* 132 */         int i = p_i2067_2_.nextInt(list.size());
/* 133 */         StructureComponent structureComponent = list.remove(i);
/* 134 */         structureComponent.func_74861_a(stairs2, this.field_75075_a, p_i2067_2_);
/*     */       } 
/*     */       
/* 137 */       func_75072_c();
/* 138 */       func_75067_a(p_i2067_1_, p_i2067_2_, 10);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\structure\MapGenStronghold.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */