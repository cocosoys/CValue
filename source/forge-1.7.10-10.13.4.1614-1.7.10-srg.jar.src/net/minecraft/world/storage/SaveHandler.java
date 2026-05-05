/*     */ package net.minecraft.world.storage;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.CompressedStreamTools;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.world.MinecraftException;
/*     */ 
/*     */ public class SaveHandler implements ISaveHandler, IPlayerFileData {
/*  15 */   private static final Logger field_151478_a = LogManager.getLogger();
/*     */   private final File field_75770_b;
/*     */   private final File field_75771_c;
/*     */   private final File field_75768_d;
/*  19 */   private final long field_75769_e = MinecraftServer.func_130071_aq(); private final String field_75767_f;
/*     */   private static final String __OBFID = "CL_00000585";
/*     */   
/*     */   public SaveHandler(File p_i2146_1_, String p_i2146_2_, boolean p_i2146_3_) {
/*  23 */     this.field_75770_b = new File(p_i2146_1_, p_i2146_2_);
/*  24 */     this.field_75770_b.mkdirs();
/*  25 */     this.field_75771_c = new File(this.field_75770_b, "playerdata");
/*  26 */     this.field_75768_d = new File(this.field_75770_b, "data");
/*  27 */     this.field_75768_d.mkdirs();
/*  28 */     this.field_75767_f = p_i2146_2_;
/*     */     
/*  30 */     if (p_i2146_3_) {
/*  31 */       this.field_75771_c.mkdirs();
/*     */     }
/*     */     
/*  34 */     func_75766_h();
/*     */   }
/*     */   
/*     */   private void func_75766_h() {
/*     */     try {
/*  39 */       File file = new File(this.field_75770_b, "session.lock");
/*  40 */       DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
/*     */       try {
/*  42 */         dataOutputStream.writeLong(this.field_75769_e);
/*     */       } finally {
/*  44 */         dataOutputStream.close();
/*     */       } 
/*  46 */     } catch (IOException iOException) {
/*  47 */       iOException.printStackTrace();
/*  48 */       throw new RuntimeException("Failed to check session lock, aborting");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public File func_75765_b() {
/*  54 */     return this.field_75770_b;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75762_c() throws MinecraftException {
/*     */     try {
/*  60 */       File file = new File(this.field_75770_b, "session.lock");
/*  61 */       DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
/*     */       try {
/*  63 */         if (dataInputStream.readLong() != this.field_75769_e) {
/*  64 */           throw new MinecraftException("The save is being accessed from another location, aborting");
/*     */         }
/*     */       } finally {
/*  67 */         dataInputStream.close();
/*     */       } 
/*  69 */     } catch (IOException iOException) {
/*  70 */       throw new MinecraftException("Failed to check session lock, aborting");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public IChunkLoader func_75763_a(WorldProvider p_75763_1_) {
/*  76 */     throw new RuntimeException("Old Chunk Storage is no longer supported.");
/*     */   }
/*     */ 
/*     */   
/*     */   public WorldInfo func_75757_d() {
/*  81 */     File file = new File(this.field_75770_b, "level.dat");
/*  82 */     if (file.exists()) {
/*     */       try {
/*  84 */         NBTTagCompound nBTTagCompound1 = CompressedStreamTools.func_74796_a(new FileInputStream(file));
/*  85 */         NBTTagCompound nBTTagCompound2 = nBTTagCompound1.func_74775_l("Data");
/*     */         
/*  87 */         return new WorldInfo(nBTTagCompound2);
/*     */       }
/*  89 */       catch (Exception exception) {
/*  90 */         exception.printStackTrace();
/*     */       } 
/*     */     }
/*  93 */     file = new File(this.field_75770_b, "level.dat_old");
/*  94 */     if (file.exists()) {
/*     */       try {
/*  96 */         NBTTagCompound nBTTagCompound1 = CompressedStreamTools.func_74796_a(new FileInputStream(file));
/*  97 */         NBTTagCompound nBTTagCompound2 = nBTTagCompound1.func_74775_l("Data");
/*     */         
/*  99 */         return new WorldInfo(nBTTagCompound2);
/*     */       }
/* 101 */       catch (Exception exception) {
/* 102 */         exception.printStackTrace();
/*     */       } 
/*     */     }
/* 105 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75755_a(WorldInfo p_75755_1_, NBTTagCompound p_75755_2_) {
/* 110 */     NBTTagCompound nBTTagCompound1 = p_75755_1_.func_76082_a(p_75755_2_);
/*     */     
/* 112 */     NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
/* 113 */     nBTTagCompound2.func_74782_a("Data", (NBTBase)nBTTagCompound1);
/*     */     
/*     */     try {
/* 116 */       File file1 = new File(this.field_75770_b, "level.dat_new");
/* 117 */       File file2 = new File(this.field_75770_b, "level.dat_old");
/* 118 */       File file3 = new File(this.field_75770_b, "level.dat");
/*     */       
/* 120 */       CompressedStreamTools.func_74799_a(nBTTagCompound2, new FileOutputStream(file1));
/*     */       
/* 122 */       if (file2.exists()) file2.delete(); 
/* 123 */       file3.renameTo(file2);
/* 124 */       if (file3.exists()) file3.delete(); 
/* 125 */       file1.renameTo(file3);
/* 126 */       if (file1.exists()) file1.delete(); 
/* 127 */     } catch (Exception exception) {
/* 128 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75761_a(WorldInfo p_75761_1_) {
/* 134 */     NBTTagCompound nBTTagCompound1 = p_75761_1_.func_76066_a();
/*     */     
/* 136 */     NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
/* 137 */     nBTTagCompound2.func_74782_a("Data", (NBTBase)nBTTagCompound1);
/*     */     
/*     */     try {
/* 140 */       File file1 = new File(this.field_75770_b, "level.dat_new");
/* 141 */       File file2 = new File(this.field_75770_b, "level.dat_old");
/* 142 */       File file3 = new File(this.field_75770_b, "level.dat");
/*     */       
/* 144 */       CompressedStreamTools.func_74799_a(nBTTagCompound2, new FileOutputStream(file1));
/*     */       
/* 146 */       if (file2.exists()) file2.delete(); 
/* 147 */       file3.renameTo(file2);
/* 148 */       if (file3.exists()) file3.delete(); 
/* 149 */       file1.renameTo(file3);
/* 150 */       if (file1.exists()) file1.delete(); 
/* 151 */     } catch (Exception exception) {
/* 152 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75753_a(EntityPlayer p_75753_1_) {
/*     */     try {
/* 159 */       NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 160 */       p_75753_1_.func_70109_d(nBTTagCompound);
/* 161 */       File file1 = new File(this.field_75771_c, p_75753_1_.func_110124_au().toString() + ".dat.tmp");
/* 162 */       File file2 = new File(this.field_75771_c, p_75753_1_.func_110124_au().toString() + ".dat");
/* 163 */       CompressedStreamTools.func_74799_a(nBTTagCompound, new FileOutputStream(file1));
/* 164 */       if (file2.exists()) file2.delete(); 
/* 165 */       file1.renameTo(file2);
/* 166 */     } catch (Exception exception) {
/* 167 */       field_151478_a.warn("Failed to save player data for " + p_75753_1_.func_70005_c_());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public NBTTagCompound func_75752_b(EntityPlayer p_75752_1_) {
/* 173 */     NBTTagCompound nBTTagCompound = null;
/*     */     try {
/* 175 */       File file = new File(this.field_75771_c, p_75752_1_.func_110124_au().toString() + ".dat");
/* 176 */       if (file.exists() && file.isFile()) {
/* 177 */         nBTTagCompound = CompressedStreamTools.func_74796_a(new FileInputStream(file));
/*     */       }
/* 179 */     } catch (Exception exception) {
/* 180 */       field_151478_a.warn("Failed to load player data for " + p_75752_1_.func_70005_c_());
/*     */     } 
/* 182 */     if (nBTTagCompound != null) {
/* 183 */       p_75752_1_.func_70020_e(nBTTagCompound);
/*     */     }
/* 185 */     return nBTTagCompound;
/*     */   }
/*     */ 
/*     */   
/*     */   public IPlayerFileData func_75756_e() {
/* 190 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] func_75754_f() {
/* 195 */     String[] arrayOfString = this.field_75771_c.list();
/*     */     
/* 197 */     for (byte b = 0; b < arrayOfString.length; b++) {
/* 198 */       if (arrayOfString[b].endsWith(".dat")) {
/* 199 */         arrayOfString[b] = arrayOfString[b].substring(0, arrayOfString[b].length() - 4);
/*     */       }
/*     */     } 
/*     */     
/* 203 */     return arrayOfString;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75759_a() {}
/*     */ 
/*     */   
/*     */   public File func_75758_b(String p_75758_1_) {
/* 212 */     return new File(this.field_75768_d, p_75758_1_ + ".dat");
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_75760_g() {
/* 217 */     return this.field_75767_f;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\storage\SaveHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */