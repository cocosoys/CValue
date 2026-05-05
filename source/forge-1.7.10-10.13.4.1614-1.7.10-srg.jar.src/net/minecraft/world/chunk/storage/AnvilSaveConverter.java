/*     */ package net.minecraft.world.chunk.storage;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.IProgressUpdate;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import net.minecraft.world.biome.WorldChunkManager;
/*     */ import net.minecraft.world.biome.WorldChunkManagerHell;
/*     */ import net.minecraft.world.storage.ISaveHandler;
/*     */ import net.minecraft.world.storage.SaveFormatComparator;
/*     */ import net.minecraft.world.storage.WorldInfo;
/*     */ 
/*     */ public class AnvilSaveConverter extends SaveFormatOld {
/*  17 */   private static final Logger field_151480_b = LogManager.getLogger(); private static final String __OBFID = "CL_00000582";
/*     */   
/*     */   public AnvilSaveConverter(File p_i2144_1_) {
/*  20 */     super(p_i2144_1_);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String func_154333_a() {
/*  25 */     return "Anvil";
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public List func_75799_b() throws AnvilConverterException {
/*  31 */     if (this.field_75808_a == null || !this.field_75808_a.exists() || !this.field_75808_a.isDirectory()) {
/*  32 */       throw new AnvilConverterException("Unable to read or access folder where game worlds are saved!");
/*     */     }
/*     */     
/*  35 */     ArrayList<SaveFormatComparator> arrayList = new ArrayList();
/*     */     
/*  37 */     File[] arrayOfFile = this.field_75808_a.listFiles();
/*  38 */     for (File file : arrayOfFile) {
/*  39 */       if (file.isDirectory()) {
/*     */ 
/*     */ 
/*     */         
/*  43 */         String str = file.getName();
/*     */         
/*  45 */         WorldInfo worldInfo = func_75803_c(str);
/*  46 */         if (worldInfo != null && (worldInfo.func_76088_k() == 19132 || worldInfo.func_76088_k() == 19133)) {
/*  47 */           boolean bool = (worldInfo.func_76088_k() != func_75812_c()) ? true : false;
/*  48 */           String str1 = worldInfo.func_76065_j();
/*  49 */           if (str1 == null || MathHelper.func_76139_a(str1)) {
/*  50 */             str1 = str;
/*     */           }
/*  52 */           long l = 0L;
/*  53 */           arrayList.add(new SaveFormatComparator(str, str1, worldInfo.func_76057_l(), l, worldInfo.func_76077_q(), bool, worldInfo.func_76093_s(), worldInfo.func_76086_u()));
/*     */         } 
/*     */       } 
/*     */     } 
/*  57 */     return arrayList;
/*     */   }
/*     */   
/*     */   protected int func_75812_c() {
/*  61 */     return 19133;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75800_d() {
/*  66 */     RegionFileCache.func_76551_a();
/*     */   }
/*     */ 
/*     */   
/*     */   public ISaveHandler func_75804_a(String p_75804_1_, boolean p_75804_2_) {
/*  71 */     return (ISaveHandler)new AnvilSaveHandler(this.field_75808_a, p_75804_1_, p_75804_2_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_154334_a(String p_154334_1_) {
/*  78 */     WorldInfo worldInfo = func_75803_c(p_154334_1_);
/*  79 */     if (worldInfo == null || worldInfo.func_76088_k() != 19132) {
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_75801_b(String p_75801_1_) {
/*  88 */     WorldInfo worldInfo = func_75803_c(p_75801_1_);
/*  89 */     if (worldInfo == null || worldInfo.func_76088_k() == func_75812_c()) {
/*  90 */       return false;
/*     */     }
/*  92 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_75805_a(String p_75805_1_, IProgressUpdate p_75805_2_) {
/*     */     WorldChunkManager worldChunkManager;
/*  98 */     p_75805_2_.func_73718_a(0);
/*     */     
/* 100 */     ArrayList arrayList1 = new ArrayList();
/* 101 */     ArrayList arrayList2 = new ArrayList();
/* 102 */     ArrayList arrayList3 = new ArrayList();
/* 103 */     File file1 = new File(this.field_75808_a, p_75805_1_);
/* 104 */     File file2 = new File(file1, "DIM-1");
/* 105 */     File file3 = new File(file1, "DIM1");
/*     */     
/* 107 */     field_151480_b.info("Scanning folders...");
/*     */ 
/*     */     
/* 110 */     func_75810_a(file1, arrayList1);
/*     */ 
/*     */     
/* 113 */     if (file2.exists()) {
/* 114 */       func_75810_a(file2, arrayList2);
/*     */     }
/* 116 */     if (file3.exists()) {
/* 117 */       func_75810_a(file3, arrayList3);
/*     */     }
/*     */     
/* 120 */     int i = arrayList1.size() + arrayList2.size() + arrayList3.size();
/* 121 */     field_151480_b.info("Total conversion count is " + i);
/*     */     
/* 123 */     WorldInfo worldInfo = func_75803_c(p_75805_1_);
/*     */     
/* 125 */     WorldChunkManagerHell worldChunkManagerHell = null;
/* 126 */     if (worldInfo.func_76067_t() == WorldType.field_77138_c) {
/* 127 */       worldChunkManagerHell = new WorldChunkManagerHell(BiomeGenBase.field_76772_c, 0.5F);
/*     */     } else {
/* 129 */       worldChunkManager = new WorldChunkManager(worldInfo.func_76063_b(), worldInfo.func_76067_t());
/*     */     } 
/*     */ 
/*     */     
/* 133 */     func_75813_a(new File(file1, "region"), arrayList1, worldChunkManager, 0, i, p_75805_2_);
/*     */     
/* 135 */     func_75813_a(new File(file2, "region"), arrayList2, (WorldChunkManager)new WorldChunkManagerHell(BiomeGenBase.field_76778_j, 0.0F), arrayList1.size(), i, p_75805_2_);
/*     */     
/* 137 */     func_75813_a(new File(file3, "region"), arrayList3, (WorldChunkManager)new WorldChunkManagerHell(BiomeGenBase.field_76779_k, 0.0F), arrayList1.size() + arrayList2.size(), i, p_75805_2_);
/*     */     
/* 139 */     worldInfo.func_76078_e(19133);
/* 140 */     if (worldInfo.func_76067_t() == WorldType.field_77136_e) {
/* 141 */       worldInfo.func_76085_a(WorldType.field_77137_b);
/*     */     }
/*     */     
/* 144 */     func_75809_f(p_75805_1_);
/*     */     
/* 146 */     ISaveHandler iSaveHandler = func_75804_a(p_75805_1_, false);
/* 147 */     iSaveHandler.func_75761_a(worldInfo);
/*     */     
/* 149 */     return true;
/*     */   }
/*     */   
/*     */   private void func_75809_f(String p_75809_1_) {
/* 153 */     File file1 = new File(this.field_75808_a, p_75809_1_);
/* 154 */     if (!file1.exists()) {
/* 155 */       field_151480_b.warn("Unable to create level.dat_mcr backup");
/*     */       
/*     */       return;
/*     */     } 
/* 159 */     File file2 = new File(file1, "level.dat");
/* 160 */     if (!file2.exists()) {
/* 161 */       field_151480_b.warn("Unable to create level.dat_mcr backup");
/*     */       
/*     */       return;
/*     */     } 
/* 165 */     File file3 = new File(file1, "level.dat_mcr");
/* 166 */     if (!file2.renameTo(file3)) {
/* 167 */       field_151480_b.warn("Unable to create level.dat_mcr backup");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void func_75813_a(File p_75813_1_, Iterable p_75813_2_, WorldChunkManager p_75813_3_, int p_75813_4_, int p_75813_5_, IProgressUpdate p_75813_6_) {
/* 173 */     for (File file : p_75813_2_) {
/* 174 */       func_75811_a(p_75813_1_, file, p_75813_3_, p_75813_4_, p_75813_5_, p_75813_6_);
/*     */       
/* 176 */       p_75813_4_++;
/* 177 */       int i = (int)Math.round(100.0D * p_75813_4_ / p_75813_5_);
/* 178 */       p_75813_6_.func_73718_a(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void func_75811_a(File p_75811_1_, File p_75811_2_, WorldChunkManager p_75811_3_, int p_75811_4_, int p_75811_5_, IProgressUpdate p_75811_6_) {
/*     */     try {
/* 186 */       String str = p_75811_2_.getName();
/*     */       
/* 188 */       RegionFile regionFile1 = new RegionFile(p_75811_2_);
/* 189 */       RegionFile regionFile2 = new RegionFile(new File(p_75811_1_, str.substring(0, str.length() - ".mcr".length()) + ".mca"));
/*     */       
/* 191 */       for (byte b = 0; b < 32; b++) {
/* 192 */         int i; for (i = 0; i < 32; i++) {
/* 193 */           if (regionFile1.func_76709_c(b, i) && !regionFile2.func_76709_c(b, i)) {
/* 194 */             DataInputStream dataInputStream = regionFile1.func_76704_a(b, i);
/* 195 */             if (dataInputStream == null) {
/* 196 */               field_151480_b.warn("Failed to fetch input stream");
/*     */             } else {
/*     */               
/* 199 */               NBTTagCompound nBTTagCompound1 = CompressedStreamTools.func_74794_a(dataInputStream);
/* 200 */               dataInputStream.close();
/*     */               
/* 202 */               NBTTagCompound nBTTagCompound2 = nBTTagCompound1.func_74775_l("Level");
/* 203 */               ChunkLoader.AnvilConverterData anvilConverterData = ChunkLoader.func_76691_a(nBTTagCompound2);
/*     */               
/* 205 */               NBTTagCompound nBTTagCompound3 = new NBTTagCompound();
/* 206 */               NBTTagCompound nBTTagCompound4 = new NBTTagCompound();
/* 207 */               nBTTagCompound3.func_74782_a("Level", (NBTBase)nBTTagCompound4);
/* 208 */               ChunkLoader.func_76690_a(anvilConverterData, nBTTagCompound4, p_75811_3_);
/*     */               
/* 210 */               DataOutputStream dataOutputStream = regionFile2.func_76710_b(b, i);
/* 211 */               CompressedStreamTools.func_74800_a(nBTTagCompound3, dataOutputStream);
/* 212 */               dataOutputStream.close();
/*     */             } 
/*     */           } 
/* 215 */         }  i = (int)Math.round(100.0D * (p_75811_4_ * 1024) / (p_75811_5_ * 1024));
/* 216 */         int j = (int)Math.round(100.0D * ((b + 1) * 32 + p_75811_4_ * 1024) / (p_75811_5_ * 1024));
/* 217 */         if (j > i) {
/* 218 */           p_75811_6_.func_73718_a(j);
/*     */         }
/*     */       } 
/*     */       
/* 222 */       regionFile1.func_76708_c();
/* 223 */       regionFile2.func_76708_c();
/* 224 */     } catch (IOException iOException) {
/* 225 */       iOException.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void func_75810_a(File p_75810_1_, Collection<? super File> p_75810_2_) {
/* 231 */     File file = new File(p_75810_1_, "region");
/* 232 */     File[] arrayOfFile = file.listFiles(new FilenameFilter(this) { private static final String __OBFID = "CL_00000583";
/*     */           
/*     */           public boolean accept(File p_accept_1_, String p_accept_2_) {
/* 235 */             return p_accept_2_.endsWith(".mcr");
/*     */           } }
/*     */       );
/*     */     
/* 239 */     if (arrayOfFile != null)
/* 240 */       Collections.addAll(p_75810_2_, arrayOfFile); 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\chunk\storage\AnvilSaveConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */