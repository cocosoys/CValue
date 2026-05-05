/*     */ package net.minecraft.world.storage;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.util.ArrayList;
/*     */ import net.minecraft.nbt.CompressedStreamTools;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ 
/*     */ public class SaveFormatOld implements ISaveFormat {
/*  12 */   private static final Logger field_151479_b = LogManager.getLogger();
/*     */   public final File field_75808_a;
/*     */   private static final String __OBFID = "CL_00000586";
/*     */   
/*     */   public SaveFormatOld(File p_i2147_1_) {
/*  17 */     if (!p_i2147_1_.exists()) p_i2147_1_.mkdirs(); 
/*  18 */     this.field_75808_a = p_i2147_1_;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String func_154333_a() {
/*  23 */     return "Old Format";
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public List func_75799_b() throws AnvilConverterException {
/*  29 */     ArrayList<SaveFormatComparator> arrayList = new ArrayList();
/*     */     
/*  31 */     for (byte b = 0; b < 5; b++) {
/*     */       
/*  33 */       String str = "World" + (b + 1);
/*     */       
/*  35 */       WorldInfo worldInfo = func_75803_c(str);
/*  36 */       if (worldInfo != null) {
/*  37 */         arrayList.add(new SaveFormatComparator(str, "", worldInfo.func_76057_l(), worldInfo.func_76092_g(), worldInfo.func_76077_q(), false, worldInfo.func_76093_s(), worldInfo.func_76086_u()));
/*     */       }
/*     */     } 
/*     */     
/*  41 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75800_d() {}
/*     */ 
/*     */   
/*     */   public WorldInfo func_75803_c(String p_75803_1_) {
/*  50 */     File file1 = new File(this.field_75808_a, p_75803_1_);
/*  51 */     if (!file1.exists()) return null;
/*     */     
/*  53 */     File file2 = new File(file1, "level.dat");
/*  54 */     if (file2.exists()) {
/*     */       try {
/*  56 */         NBTTagCompound nBTTagCompound1 = CompressedStreamTools.func_74796_a(new FileInputStream(file2));
/*  57 */         NBTTagCompound nBTTagCompound2 = nBTTagCompound1.func_74775_l("Data");
/*  58 */         return new WorldInfo(nBTTagCompound2);
/*  59 */       } catch (Exception exception) {
/*  60 */         field_151479_b.error("Exception reading " + file2, exception);
/*     */       } 
/*     */     }
/*     */     
/*  64 */     file2 = new File(file1, "level.dat_old");
/*  65 */     if (file2.exists()) {
/*     */       try {
/*  67 */         NBTTagCompound nBTTagCompound1 = CompressedStreamTools.func_74796_a(new FileInputStream(file2));
/*  68 */         NBTTagCompound nBTTagCompound2 = nBTTagCompound1.func_74775_l("Data");
/*  69 */         return new WorldInfo(nBTTagCompound2);
/*  70 */       } catch (Exception exception) {
/*  71 */         field_151479_b.error("Exception reading " + file2, exception);
/*     */       } 
/*     */     }
/*  74 */     return null;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_75806_a(String p_75806_1_, String p_75806_2_) {
/*  79 */     File file1 = new File(this.field_75808_a, p_75806_1_);
/*  80 */     if (!file1.exists())
/*     */       return; 
/*  82 */     File file2 = new File(file1, "level.dat");
/*  83 */     if (file2.exists()) {
/*     */       try {
/*  85 */         NBTTagCompound nBTTagCompound1 = CompressedStreamTools.func_74796_a(new FileInputStream(file2));
/*  86 */         NBTTagCompound nBTTagCompound2 = nBTTagCompound1.func_74775_l("Data");
/*  87 */         nBTTagCompound2.func_74778_a("LevelName", p_75806_2_);
/*     */         
/*  89 */         CompressedStreamTools.func_74799_a(nBTTagCompound1, new FileOutputStream(file2));
/*  90 */       } catch (Exception exception) {
/*  91 */         exception.printStackTrace();
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_154335_d(String p_154335_1_) {
/*  99 */     File file = new File(this.field_75808_a, p_154335_1_);
/* 100 */     if (file.exists()) {
/* 101 */       return false;
/*     */     }
/*     */     
/*     */     try {
/* 105 */       file.mkdir();
/* 106 */       file.delete();
/* 107 */     } catch (Throwable throwable) {
/* 108 */       field_151479_b.warn("Couldn't make new level", throwable);
/* 109 */       return false;
/*     */     } 
/*     */     
/* 112 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_75802_e(String p_75802_1_) {
/* 117 */     File file = new File(this.field_75808_a, p_75802_1_);
/* 118 */     if (!file.exists()) return true;
/*     */     
/* 120 */     field_151479_b.info("Deleting level " + p_75802_1_);
/*     */     
/* 122 */     for (byte b = 1; b <= 5; b++) {
/* 123 */       field_151479_b.info("Attempt " + b + "...");
/*     */       
/* 125 */       if (func_75807_a(file.listFiles())) {
/*     */         break;
/*     */       }
/* 128 */       field_151479_b.warn("Unsuccessful in deleting contents.");
/*     */ 
/*     */       
/* 131 */       if (b < 5) {
/*     */         try {
/* 133 */           Thread.sleep(500L);
/* 134 */         } catch (InterruptedException interruptedException) {}
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 139 */     return file.delete();
/*     */   }
/*     */   
/*     */   protected static boolean func_75807_a(File[] p_75807_0_) {
/* 143 */     for (byte b = 0; b < p_75807_0_.length; b++) {
/* 144 */       File file = p_75807_0_[b];
/* 145 */       field_151479_b.debug("Deleting " + file);
/*     */       
/* 147 */       if (file.isDirectory() && 
/* 148 */         !func_75807_a(file.listFiles())) {
/* 149 */         field_151479_b.warn("Couldn't delete directory " + file);
/* 150 */         return false;
/*     */       } 
/*     */ 
/*     */       
/* 154 */       if (!file.delete()) {
/* 155 */         field_151479_b.warn("Couldn't delete file " + file);
/* 156 */         return false;
/*     */       } 
/*     */     } 
/*     */     
/* 160 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ISaveHandler func_75804_a(String p_75804_1_, boolean p_75804_2_) {
/* 165 */     return new SaveHandler(this.field_75808_a, p_75804_1_, p_75804_2_);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_154334_a(String p_154334_1_) {
/* 170 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_75801_b(String p_75801_1_) {
/* 175 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_75805_a(String p_75805_1_, IProgressUpdate p_75805_2_) {
/* 180 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_90033_f(String p_90033_1_) {
/* 185 */     File file = new File(this.field_75808_a, p_90033_1_);
/* 186 */     return file.isDirectory();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\storage\SaveFormatOld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */