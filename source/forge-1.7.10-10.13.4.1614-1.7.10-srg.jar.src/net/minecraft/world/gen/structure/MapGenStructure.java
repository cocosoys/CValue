/*     */ package net.minecraft.world.gen.structure;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.concurrent.Callable;
/*     */ import net.minecraft.crash.CrashReport;
/*     */ import net.minecraft.crash.CrashReportCategory;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.world.ChunkCoordIntPair;
/*     */ import net.minecraft.world.ChunkPosition;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public abstract class MapGenStructure extends MapGenBase {
/*  15 */   protected Map field_75053_d = new HashMap<Object, Object>();
/*     */   
/*     */   private MapGenStructureData field_143029_e;
/*     */   
/*     */   private static final String __OBFID = "CL_00000505";
/*     */ 
/*     */   
/*     */   public abstract String func_143025_a();
/*     */ 
/*     */   
/*     */   protected final void func_151538_a(World p_151538_1_, int p_151538_2_, int p_151538_3_, int p_151538_4_, int p_151538_5_, Block[] p_151538_6_) {
/*  26 */     func_143027_a(p_151538_1_);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  32 */     if (this.field_75053_d.containsKey(Long.valueOf(ChunkCoordIntPair.func_77272_a(p_151538_2_, p_151538_3_)))) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*  37 */     this.field_75038_b.nextInt();
/*     */     
/*     */     try {
/*  40 */       if (func_75047_a(p_151538_2_, p_151538_3_)) {
/*     */         
/*  42 */         StructureStart structureStart = func_75049_b(p_151538_2_, p_151538_3_);
/*  43 */         this.field_75053_d.put(Long.valueOf(ChunkCoordIntPair.func_77272_a(p_151538_2_, p_151538_3_)), structureStart);
/*  44 */         func_143026_a(p_151538_2_, p_151538_3_, structureStart);
/*     */       } 
/*  46 */     } catch (Throwable throwable) {
/*  47 */       CrashReport crashReport = CrashReport.func_85055_a(throwable, "Exception preparing structure feature");
/*  48 */       CrashReportCategory crashReportCategory = crashReport.func_85058_a("Feature being prepared");
/*     */       
/*  50 */       crashReportCategory.func_71500_a("Is feature chunk", new Callable(this, p_151538_2_, p_151538_3_) { private static final String __OBFID = "CL_00000506";
/*     */             
/*     */             public String call() {
/*  53 */               return this.field_85168_c.func_75047_a(this.field_85169_a, this.field_85167_b) ? "True" : "False";
/*     */             } }
/*     */         );
/*     */       
/*  57 */       crashReportCategory.func_71507_a("Chunk location", String.format("%d,%d", new Object[] { Integer.valueOf(p_151538_2_), Integer.valueOf(p_151538_3_) }));
/*     */       
/*  59 */       crashReportCategory.func_71500_a("Chunk pos hash", new Callable(this, p_151538_2_, p_151538_3_) { private static final String __OBFID = "CL_00000507";
/*     */             
/*     */             public String call() {
/*  62 */               return String.valueOf(ChunkCoordIntPair.func_77272_a(this.field_85165_a, this.field_85163_b));
/*     */             } }
/*     */         );
/*     */       
/*  66 */       crashReportCategory.func_71500_a("Structure type", new Callable(this) { private static final String __OBFID = "CL_00000508";
/*     */             
/*     */             public String call() {
/*  69 */               return this.field_85161_a.getClass().getCanonicalName();
/*     */             } }
/*     */         );
/*     */       
/*  73 */       throw new ReportedException(crashReport);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_75051_a(World p_75051_1_, Random p_75051_2_, int p_75051_3_, int p_75051_4_) {
/*  79 */     func_143027_a(p_75051_1_);
/*     */     
/*  81 */     int i = (p_75051_3_ << 4) + 8;
/*  82 */     int j = (p_75051_4_ << 4) + 8;
/*     */     
/*  84 */     boolean bool = false;
/*  85 */     for (StructureStart structureStart : this.field_75053_d.values()) {
/*  86 */       if (structureStart.func_75069_d() && 
/*  87 */         structureStart.func_75071_a().func_78885_a(i, j, i + 15, j + 15)) {
/*  88 */         structureStart.func_75068_a(p_75051_1_, p_75051_2_, new StructureBoundingBox(i, j, i + 15, j + 15));
/*  89 */         bool = true;
/*     */ 
/*     */         
/*  92 */         func_143026_a(structureStart.func_143019_e(), structureStart.func_143018_f(), structureStart);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  97 */     return bool;
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
/*     */   public boolean func_75048_a(int p_75048_1_, int p_75048_2_, int p_75048_3_) {
/* 131 */     func_143027_a(this.field_75039_c);
/* 132 */     return (func_143028_c(p_75048_1_, p_75048_2_, p_75048_3_) != null);
/*     */   }
/*     */   
/*     */   protected StructureStart func_143028_c(int p_143028_1_, int p_143028_2_, int p_143028_3_) {
/* 136 */     for (StructureStart structureStart : this.field_75053_d.values()) {
/* 137 */       if (structureStart.func_75069_d() && 
/* 138 */         structureStart.func_75071_a().func_78885_a(p_143028_1_, p_143028_3_, p_143028_1_, p_143028_3_)) {
/*     */         
/* 140 */         Iterator<StructureComponent> iterator = structureStart.func_75073_b().iterator();
/* 141 */         while (iterator.hasNext()) {
/* 142 */           StructureComponent structureComponent = iterator.next();
/* 143 */           if (structureComponent.func_74874_b().func_78890_b(p_143028_1_, p_143028_2_, p_143028_3_)) {
/* 144 */             return structureStart;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 150 */     return null;
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
/*     */   public boolean func_142038_b(int p_142038_1_, int p_142038_2_, int p_142038_3_) {
/* 164 */     func_143027_a(this.field_75039_c);
/*     */     
/* 166 */     for (StructureStart structureStart : this.field_75053_d.values()) {
/* 167 */       if (structureStart.func_75069_d()) {
/* 168 */         return structureStart.func_75071_a().func_78885_a(p_142038_1_, p_142038_3_, p_142038_1_, p_142038_3_);
/*     */       }
/*     */     } 
/* 171 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ChunkPosition func_151545_a(World p_151545_1_, int p_151545_2_, int p_151545_3_, int p_151545_4_) {
/* 178 */     this.field_75039_c = p_151545_1_;
/*     */     
/* 180 */     func_143027_a(p_151545_1_);
/*     */     
/* 182 */     this.field_75038_b.setSeed(p_151545_1_.func_72905_C());
/* 183 */     long l1 = this.field_75038_b.nextLong();
/* 184 */     long l2 = this.field_75038_b.nextLong();
/* 185 */     long l3 = (p_151545_2_ >> 4) * l1;
/* 186 */     long l4 = (p_151545_4_ >> 4) * l2;
/* 187 */     this.field_75038_b.setSeed(l3 ^ l4 ^ p_151545_1_.func_72905_C());
/*     */     
/* 189 */     func_151538_a(p_151545_1_, p_151545_2_ >> 4, p_151545_4_ >> 4, 0, 0, (Block[])null);
/*     */     
/* 191 */     double d = Double.MAX_VALUE;
/* 192 */     ChunkPosition chunkPosition = null;
/*     */     
/* 194 */     for (StructureStart structureStart : this.field_75053_d.values()) {
/* 195 */       if (structureStart.func_75069_d()) {
/*     */         
/* 197 */         StructureComponent structureComponent = structureStart.func_75073_b().get(0);
/* 198 */         ChunkPosition chunkPosition1 = structureComponent.func_151553_a();
/*     */         
/* 200 */         int i = chunkPosition1.field_151329_a - p_151545_2_;
/* 201 */         int j = chunkPosition1.field_151327_b - p_151545_3_;
/* 202 */         int k = chunkPosition1.field_151328_c - p_151545_4_;
/* 203 */         double d1 = (i * i + j * j + k * k);
/*     */         
/* 205 */         if (d1 < d) {
/* 206 */           d = d1;
/* 207 */           chunkPosition = chunkPosition1;
/*     */         } 
/*     */       } 
/*     */     } 
/* 211 */     if (chunkPosition != null) {
/* 212 */       return chunkPosition;
/*     */     }
/* 214 */     List list = func_75052_o_();
/* 215 */     if (list != null) {
/* 216 */       ChunkPosition chunkPosition1 = null;
/* 217 */       for (ChunkPosition chunkPosition2 : list) {
/*     */         
/* 219 */         int i = chunkPosition2.field_151329_a - p_151545_2_;
/* 220 */         int j = chunkPosition2.field_151327_b - p_151545_3_;
/* 221 */         int k = chunkPosition2.field_151328_c - p_151545_4_;
/* 222 */         double d1 = (i * i + j * j + k * k);
/*     */         
/* 224 */         if (d1 < d) {
/* 225 */           d = d1;
/* 226 */           chunkPosition1 = chunkPosition2;
/*     */         } 
/*     */       } 
/* 229 */       return chunkPosition1;
/*     */     } 
/*     */     
/* 232 */     return null;
/*     */   }
/*     */   
/*     */   protected List func_75052_o_() {
/* 236 */     return null;
/*     */   }
/*     */   
/*     */   private void func_143027_a(World p_143027_1_) {
/* 240 */     if (this.field_143029_e == null) {
/* 241 */       this.field_143029_e = (MapGenStructureData)p_143027_1_.func_72943_a(MapGenStructureData.class, func_143025_a());
/*     */       
/* 243 */       if (this.field_143029_e == null) {
/* 244 */         this.field_143029_e = new MapGenStructureData(func_143025_a());
/* 245 */         p_143027_1_.func_72823_a(func_143025_a(), this.field_143029_e);
/*     */       } else {
/* 247 */         NBTTagCompound nBTTagCompound = this.field_143029_e.func_143041_a();
/*     */         
/* 249 */         for (String str : nBTTagCompound.func_150296_c()) {
/* 250 */           NBTBase nBTBase = nBTTagCompound.func_74781_a(str);
/* 251 */           if (nBTBase.func_74732_a() == 10) {
/* 252 */             NBTTagCompound nBTTagCompound1 = (NBTTagCompound)nBTBase;
/*     */             
/* 254 */             if (nBTTagCompound1.func_74764_b("ChunkX") && nBTTagCompound1.func_74764_b("ChunkZ")) {
/* 255 */               int i = nBTTagCompound1.func_74762_e("ChunkX");
/* 256 */               int j = nBTTagCompound1.func_74762_e("ChunkZ");
/*     */               
/* 258 */               StructureStart structureStart = MapGenStructureIO.func_143035_a(nBTTagCompound1, p_143027_1_);
/* 259 */               if (structureStart != null) {
/* 260 */                 this.field_75053_d.put(Long.valueOf(ChunkCoordIntPair.func_77272_a(i, j)), structureStart);
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_143026_a(int p_143026_1_, int p_143026_2_, StructureStart p_143026_3_) {
/* 270 */     this.field_143029_e.func_143043_a(p_143026_3_.func_143021_a(p_143026_1_, p_143026_2_), p_143026_1_, p_143026_2_);
/* 271 */     this.field_143029_e.func_76185_a();
/*     */   }
/*     */   
/*     */   protected abstract boolean func_75047_a(int paramInt1, int paramInt2);
/*     */   
/*     */   protected abstract StructureStart func_75049_b(int paramInt1, int paramInt2);
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\structure\MapGenStructure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */