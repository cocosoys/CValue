/*     */ package net.minecraft.world.chunk.storage;
/*     */ 
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.world.biome.WorldChunkManager;
/*     */ import net.minecraft.world.chunk.NibbleArray;
/*     */ 
/*     */ public class ChunkLoader {
/*     */   private static final String __OBFID = "CL_00000379";
/*     */   
/*     */   public static AnvilConverterData func_76691_a(NBTTagCompound p_76691_0_) {
/*  13 */     int i = p_76691_0_.func_74762_e("xPos");
/*  14 */     int j = p_76691_0_.func_74762_e("zPos");
/*     */     
/*  16 */     AnvilConverterData anvilConverterData = new AnvilConverterData(i, j);
/*  17 */     anvilConverterData.field_76693_g = p_76691_0_.func_74770_j("Blocks");
/*  18 */     anvilConverterData.field_76692_f = new NibbleArrayReader(p_76691_0_.func_74770_j("Data"), 7);
/*  19 */     anvilConverterData.field_76695_e = new NibbleArrayReader(p_76691_0_.func_74770_j("SkyLight"), 7);
/*  20 */     anvilConverterData.field_76694_d = new NibbleArrayReader(p_76691_0_.func_74770_j("BlockLight"), 7);
/*  21 */     anvilConverterData.field_76697_c = p_76691_0_.func_74770_j("HeightMap");
/*  22 */     anvilConverterData.field_76696_b = p_76691_0_.func_74767_n("TerrainPopulated");
/*  23 */     anvilConverterData.field_76702_h = p_76691_0_.func_150295_c("Entities", 10);
/*  24 */     anvilConverterData.field_151564_i = p_76691_0_.func_150295_c("TileEntities", 10);
/*  25 */     anvilConverterData.field_151563_j = p_76691_0_.func_150295_c("TileTicks", 10);
/*     */ 
/*     */     
/*     */     try {
/*  29 */       anvilConverterData.field_76698_a = p_76691_0_.func_74763_f("LastUpdate");
/*  30 */     } catch (ClassCastException classCastException) {
/*  31 */       anvilConverterData.field_76698_a = p_76691_0_.func_74762_e("LastUpdate");
/*     */     } 
/*     */     
/*  34 */     return anvilConverterData;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void func_76690_a(AnvilConverterData p_76690_0_, NBTTagCompound p_76690_1_, WorldChunkManager p_76690_2_) {
/*  39 */     p_76690_1_.func_74768_a("xPos", p_76690_0_.field_76701_k);
/*  40 */     p_76690_1_.func_74768_a("zPos", p_76690_0_.field_76699_l);
/*  41 */     p_76690_1_.func_74772_a("LastUpdate", p_76690_0_.field_76698_a);
/*  42 */     int[] arrayOfInt = new int[p_76690_0_.field_76697_c.length];
/*  43 */     for (byte b1 = 0; b1 < p_76690_0_.field_76697_c.length; b1++) {
/*  44 */       arrayOfInt[b1] = p_76690_0_.field_76697_c[b1];
/*     */     }
/*  46 */     p_76690_1_.func_74783_a("HeightMap", arrayOfInt);
/*  47 */     p_76690_1_.func_74757_a("TerrainPopulated", p_76690_0_.field_76696_b);
/*     */     
/*  49 */     NBTTagList nBTTagList = new NBTTagList();
/*  50 */     for (byte b2 = 0; b2 < 8; b2++) {
/*     */ 
/*     */       
/*  53 */       boolean bool = true;
/*  54 */       for (byte b = 0; b < 16 && bool; b++) {
/*  55 */         for (byte b4 = 0; b4 < 16 && bool; b4++) {
/*  56 */           for (byte b5 = 0; b5 < 16; b5++) {
/*  57 */             int i = b << 11 | b5 << 7 | b4 + (b2 << 4);
/*  58 */             byte b6 = p_76690_0_.field_76693_g[i];
/*  59 */             if (b6 != 0) {
/*  60 */               bool = false;
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*  67 */       if (!bool) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  72 */         byte[] arrayOfByte1 = new byte[4096];
/*  73 */         NibbleArray nibbleArray1 = new NibbleArray(arrayOfByte1.length, 4);
/*  74 */         NibbleArray nibbleArray2 = new NibbleArray(arrayOfByte1.length, 4);
/*  75 */         NibbleArray nibbleArray3 = new NibbleArray(arrayOfByte1.length, 4);
/*     */         
/*  77 */         for (byte b4 = 0; b4 < 16; b4++) {
/*  78 */           for (byte b5 = 0; b5 < 16; b5++) {
/*  79 */             for (byte b6 = 0; b6 < 16; b6++) {
/*  80 */               int i = b4 << 11 | b6 << 7 | b5 + (b2 << 4);
/*  81 */               byte b7 = p_76690_0_.field_76693_g[i];
/*     */               
/*  83 */               arrayOfByte1[b5 << 8 | b6 << 4 | b4] = (byte)(b7 & 0xFF);
/*  84 */               nibbleArray1.func_76581_a(b4, b5, b6, p_76690_0_.field_76692_f.func_76686_a(b4, b5 + (b2 << 4), b6));
/*  85 */               nibbleArray2.func_76581_a(b4, b5, b6, p_76690_0_.field_76695_e.func_76686_a(b4, b5 + (b2 << 4), b6));
/*  86 */               nibbleArray3.func_76581_a(b4, b5, b6, p_76690_0_.field_76694_d.func_76686_a(b4, b5 + (b2 << 4), b6));
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/*  91 */         NBTTagCompound nBTTagCompound = new NBTTagCompound();
/*     */         
/*  93 */         nBTTagCompound.func_74774_a("Y", (byte)(b2 & 0xFF));
/*  94 */         nBTTagCompound.func_74773_a("Blocks", arrayOfByte1);
/*  95 */         nBTTagCompound.func_74773_a("Data", nibbleArray1.field_76585_a);
/*  96 */         nBTTagCompound.func_74773_a("SkyLight", nibbleArray2.field_76585_a);
/*  97 */         nBTTagCompound.func_74773_a("BlockLight", nibbleArray3.field_76585_a);
/*     */         
/*  99 */         nBTTagList.func_74742_a((NBTBase)nBTTagCompound);
/*     */       } 
/* 101 */     }  p_76690_1_.func_74782_a("Sections", (NBTBase)nBTTagList);
/*     */ 
/*     */     
/* 104 */     byte[] arrayOfByte = new byte[256];
/* 105 */     for (byte b3 = 0; b3 < 16; b3++) {
/* 106 */       for (byte b = 0; b < 16; b++) {
/* 107 */         arrayOfByte[b << 4 | b3] = (byte)((p_76690_2_.func_76935_a(p_76690_0_.field_76701_k << 4 | b3, p_76690_0_.field_76699_l << 4 | b)).field_76756_M & 0xFF);
/*     */       }
/*     */     } 
/* 110 */     p_76690_1_.func_74773_a("Biomes", arrayOfByte);
/* 111 */     p_76690_1_.func_74782_a("Entities", (NBTBase)p_76690_0_.field_76702_h);
/* 112 */     p_76690_1_.func_74782_a("TileEntities", (NBTBase)p_76690_0_.field_151564_i);
/* 113 */     if (p_76690_0_.field_151563_j != null) {
/* 114 */       p_76690_1_.func_74782_a("TileTicks", (NBTBase)p_76690_0_.field_151563_j);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class AnvilConverterData
/*     */   {
/*     */     public long field_76698_a;
/*     */     
/*     */     public boolean field_76696_b;
/*     */     public byte[] field_76697_c;
/*     */     public NibbleArrayReader field_76694_d;
/*     */     public NibbleArrayReader field_76695_e;
/*     */     public NibbleArrayReader field_76692_f;
/*     */     public byte[] field_76693_g;
/*     */     public NBTTagList field_76702_h;
/*     */     public NBTTagList field_151564_i;
/*     */     public NBTTagList field_151563_j;
/*     */     public final int field_76701_k;
/*     */     public final int field_76699_l;
/*     */     private static final String __OBFID = "CL_00000380";
/*     */     
/*     */     public AnvilConverterData(int p_i1999_1_, int p_i1999_2_) {
/* 137 */       this.field_76701_k = p_i1999_1_;
/* 138 */       this.field_76699_l = p_i1999_2_;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\chunk\storage\ChunkLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */