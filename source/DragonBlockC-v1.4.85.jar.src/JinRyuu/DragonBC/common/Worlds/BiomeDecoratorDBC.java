/*     */ package JinRyuu.DragonBC.common.Worlds;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
/*     */ import JinRyuu.DragonBC.common.Villages.ChkInSt;
/*     */ import JinRyuu.DragonBC.common.Villages.NamekianHouse1;
/*     */ import JinRyuu.DragonBC.common.m.WorldGenMahagonyTree;
/*     */ import JinRyuu.DragonBC.common.m.WorldGenMapleTree;
/*     */ import JinRyuu.DragonBC.common.m.WorldGenSakuraTree;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockFlower;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.biome.BiomeDecorator;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import net.minecraft.world.gen.feature.WorldGenerator;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
/*     */ import net.minecraftforge.event.terraingen.OreGenEvent;
/*     */ import net.minecraftforge.event.terraingen.TerrainGen;
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
/*     */ public class BiomeDecoratorDBC
/*     */   extends BiomeDecorator
/*     */ {
/*  65 */   protected WorldGenerator WarenaiOreGen = new WorldGenOre(BlocksDBC.BlockOreWrenai, 5, Blocks.field_150348_b);
/*  66 */   protected WorldGenerator NamekTreeGen = new WorldGenNamekTrees(true);
/*  67 */   protected WorldGenerator NamekianHouse = (WorldGenerator)new NamekianHouse1();
/*  68 */   protected WorldGenerator NamekMedMossGen = new WorldGenNamekMedMoss(false);
/*     */   
/*  70 */   protected WorldGenerator ChkInSt = (WorldGenerator)new ChkInSt();
/*     */   
/*     */   protected int field_76803_B;
/*     */   protected int field_76832_z;
/*     */   protected int WarenaiOrePerChunk;
/*     */   protected int NamekMedMossPerChunk;
/*     */   protected int NamekTreePerChunk;
/*     */   protected int NamekianHouseChunk;
/*     */   protected int NamekFreezaSoldiersChunk;
/*     */   
/*     */   public void func_150512_a(World p_150512_1_, Random p_150512_2_, BiomeGenBase p_150512_3_, int p_150512_4_, int p_150512_5_) {
/*  81 */     if (this.field_76815_a != null)
/*     */     {
/*  83 */       throw new RuntimeException("Already decorating!!");
/*     */     }
/*     */ 
/*     */     
/*  87 */     this.field_76815_a = p_150512_1_;
/*  88 */     this.field_76813_b = p_150512_2_;
/*  89 */     this.field_76814_c = p_150512_4_;
/*  90 */     this.field_76811_d = p_150512_5_;
/*  91 */     func_150513_a(p_150512_3_);
/*  92 */     this.field_76815_a = null;
/*  93 */     this.field_76813_b = null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int ChkInStChunk;
/*     */   
/*     */   protected void func_150513_a(BiomeGenBase p_150513_1_) {
/* 100 */     MinecraftForge.EVENT_BUS.post((Event)new DecorateBiomeEvent.Pre(this.field_76815_a, this.field_76813_b, this.field_76814_c, this.field_76811_d));
/* 101 */     func_76797_b();
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
/* 121 */     boolean doGen = TerrainGen.decorate(this.field_76815_a, this.field_76813_b, this.field_76814_c, this.field_76811_d, DecorateBiomeEvent.Decorate.EventType.TREE); int j;
/* 122 */     for (j = 0; doGen && j < this.OWtri1PerChunk; j++) {
/*     */       
/* 124 */       int var3 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
/* 125 */       int var4 = this.field_76813_b.nextInt(50);
/* 126 */       int var7 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
/* 127 */       (new WorldGenOWTrees(false)).func_76484_a(this.field_76815_a, this.field_76813_b, var3, var4, var7);
/*     */     } 
/*     */     
/* 130 */     for (j = 0; doGen && j < this.OWtri2PerChunk; j++) {
/*     */       
/* 132 */       int var3 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
/* 133 */       int var4 = this.field_76813_b.nextInt(50);
/* 134 */       int var7 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
/* 135 */       (new WorldGenMahagonyTree()).func_76484_a(this.field_76815_a, this.field_76813_b, var3, var4, var7);
/*     */     } 
/* 137 */     for (j = 0; doGen && j < this.OWtri3PerChunk; j++) {
/*     */       
/* 139 */       int var3 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
/* 140 */       int var4 = this.field_76813_b.nextInt(50);
/* 141 */       int var7 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
/* 142 */       (new WorldGenSakuraTree()).func_76484_a(this.field_76815_a, this.field_76813_b, var3, var4, var7);
/*     */     } 
/* 144 */     for (j = 0; doGen && j < this.OWtri4PerChunk; j++) {
/*     */       
/* 146 */       int var3 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
/* 147 */       int var4 = this.field_76813_b.nextInt(50);
/* 148 */       int var7 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
/* 149 */       (new WorldGenMapleTree()).func_76484_a(this.field_76815_a, this.field_76813_b, var3, var4, var7);
/*     */     } 
/*     */     
/* 152 */     doGen = TerrainGen.decorate(this.field_76815_a, this.field_76813_b, this.field_76814_c, this.field_76811_d, DecorateBiomeEvent.Decorate.EventType.FLOWERS);
/* 153 */     for (j = 0; doGen && j < this.yellowFlowersPerChunk; j++) {
/*     */       
/* 155 */       int k = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
/* 156 */       int l = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
/* 157 */       int i1 = this.field_76813_b.nextInt(50);
/* 158 */       String s = "dandelion";
/* 159 */       BlockFlower blockflower = BlockFlower.func_149857_e(s);
/*     */       
/* 161 */       if (blockflower.func_149688_o() != Material.field_151579_a) {
/*     */         
/* 163 */         this.field_150514_p.func_150550_a((Block)blockflower, BlockFlower.func_149856_f(s));
/* 164 */         this.field_150514_p.func_76484_a(this.field_76815_a, this.field_76813_b, k, i1, l);
/*     */       } 
/*     */     } 
/*     */     
/* 168 */     doGen = TerrainGen.decorate(this.field_76815_a, this.field_76813_b, this.field_76814_c, this.field_76811_d, DecorateBiomeEvent.Decorate.EventType.FLOWERS);
/* 169 */     for (j = 0; doGen && j < this.roseBushPerChunk; j++) {
/*     */       
/* 171 */       int k = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
/* 172 */       int l = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
/* 173 */       int i1 = this.field_76813_b.nextInt(50);
/* 174 */       String s = "tulipRed";
/* 175 */       BlockFlower blockflower = BlockFlower.func_149857_e(s);
/*     */       
/* 177 */       if (blockflower.func_149688_o() != Material.field_151579_a) {
/*     */         
/* 179 */         this.field_150514_p.func_150550_a((Block)blockflower, BlockFlower.func_149856_f(s));
/* 180 */         this.field_150514_p.func_76484_a(this.field_76815_a, this.field_76813_b, k, i1, l);
/*     */       } 
/*     */     } 
/*     */     
/*     */     int var2;
/*     */     
/* 186 */     for (var2 = 0; doGen && var2 < this.NamekMedMossPerChunk; var2++) {
/*     */       
/* 188 */       int var3 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
/* 189 */       int var4 = 65 + this.field_76813_b.nextInt(50);
/* 190 */       int var7 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
/* 191 */       this.NamekMedMossGen.func_76484_a(this.field_76815_a, this.field_76813_b, var3, var4, var7);
/*     */     } 
/*     */ 
/*     */     
/* 195 */     doGen = TerrainGen.decorate(this.field_76815_a, this.field_76813_b, this.field_76814_c, this.field_76811_d, DecorateBiomeEvent.Decorate.EventType.TREE);
/* 196 */     for (var2 = 0; doGen && var2 < this.NamekTreePerChunk; var2++) {
/*     */       
/* 198 */       int var3 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
/* 199 */       int var4 = 65 + this.field_76813_b.nextInt(50);
/* 200 */       int var7 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
/* 201 */       this.NamekTreeGen.func_76484_a(this.field_76815_a, this.field_76813_b, var3, var4, var7);
/*     */     } 
/*     */ 
/*     */     
/* 205 */     doGen = TerrainGen.decorate(this.field_76815_a, this.field_76813_b, this.field_76814_c, this.field_76811_d, DecorateBiomeEvent.Decorate.EventType.CUSTOM);
/* 206 */     for (var2 = 0; doGen && var2 < this.WarenaiOrePerChunk; var2++) {
/*     */       
/* 208 */       int var3 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
/* 209 */       int var4 = 32 + this.field_76813_b.nextInt(128);
/* 210 */       int var7 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
/* 211 */       this.WarenaiOreGen.func_76484_a(this.field_76815_a, this.field_76813_b, var3, var4, var7);
/*     */     } 
/* 213 */     for (var2 = 0; doGen && var2 < this.NamekianHouseChunk; var2++) {
/*     */       
/* 215 */       int var3 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
/* 216 */       int var4 = 65 + this.field_76813_b.nextInt(20);
/* 217 */       int var7 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
/*     */ 
/*     */       
/* 220 */       this.NamekianHouse.func_76484_a(this.field_76815_a, this.field_76813_b, var3, var4, var7);
/*     */     } 
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
/* 250 */     MinecraftForge.EVENT_BUS.post((Event)new DecorateBiomeEvent.Post(this.field_76815_a, this.field_76813_b, this.field_76814_c, this.field_76811_d));
/*     */   }
/*     */ 
/*     */   
/*     */   protected int OWtri1PerChunk;
/*     */   
/*     */   protected int OWtri2PerChunk;
/*     */   
/*     */   protected int OWtri3PerChunk;
/*     */   
/*     */   protected int yellowFlowersPerChunk;
/*     */   protected int OWtri4PerChunk;
/*     */   protected int roseBushPerChunk;
/*     */   
/*     */   protected void func_76797_b() {
/* 265 */     MinecraftForge.ORE_GEN_BUS.post((Event)new OreGenEvent.Pre(this.field_76815_a, this.field_76813_b, this.field_76814_c, this.field_76811_d));
/* 266 */     if (TerrainGen.generateOre(this.field_76815_a, this.field_76813_b, this.field_76823_i, this.field_76814_c, this.field_76811_d, OreGenEvent.GenerateMinable.EventType.DIRT)) {
/* 267 */       func_76795_a(20, this.field_76823_i, 0, 256);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 272 */     if (TerrainGen.generateOre(this.field_76815_a, this.field_76813_b, this.field_76818_l, this.field_76814_c, this.field_76811_d, OreGenEvent.GenerateMinable.EventType.IRON))
/* 273 */       func_76795_a(20, this.field_76818_l, 0, 64); 
/* 274 */     if (TerrainGen.generateOre(this.field_76815_a, this.field_76813_b, this.field_76819_m, this.field_76814_c, this.field_76811_d, OreGenEvent.GenerateMinable.EventType.GOLD)) {
/* 275 */       func_76795_a(2, this.field_76819_m, 0, 32);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 282 */     MinecraftForge.ORE_GEN_BUS.post((Event)new OreGenEvent.Post(this.field_76815_a, this.field_76813_b, this.field_76814_c, this.field_76811_d));
/*     */   }
/*     */   
/*     */   private int nextInt(int i) {
/* 286 */     if (i <= 1)
/* 287 */       return 0; 
/* 288 */     return this.field_76813_b.nextInt(i);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Worlds\BiomeDecoratorDBC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */