/*     */ package JinRyuu.JRMCore;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class JRMCoreSafe {
/*     */   public File dataDir;
/*     */   public File saveDir;
/*     */   public File playersDir;
/*     */   public World world;
/*     */   public File NamekDir;
/*     */   public File NamDataDir;
/*     */   public File OWDir;
/*     */   public File OWDataDir;
/*     */   
/*     */   public JRMCoreSafe(World worldObj) {
/*  22 */     this.world = worldObj;
/*     */     
/*  24 */     if (!this.world.field_72995_K) {
/*  25 */       this.saveDir = JRMCoreSafeUtil.getWorldSaveDir(this.world);
/*     */     }
/*     */     
/*  28 */     if (!this.world.field_72995_K) {
/*  29 */       this.dataDir = new File(this.saveDir, "data");
/*  30 */       if (!this.dataDir.exists()) {
/*  31 */         this.dataDir.mkdir();
/*     */       }
/*  33 */       this.playersDir = new File(this.saveDir, "players");
/*  34 */       if (!this.playersDir.exists()) {
/*  35 */         this.playersDir.mkdir();
/*     */       }
/*     */     } 
/*  38 */     if (!this.world.field_72995_K) {
/*  39 */       this.NamekDir = new File(this.saveDir, "Namek");
/*     */       
/*  41 */       if (!this.NamekDir.exists()) {
/*  42 */         this.NamekDir.mkdir();
/*     */       }
/*  44 */       this.NamDataDir = new File(this.NamekDir, "data");
/*     */       
/*  46 */       if (!this.NamDataDir.exists()) {
/*  47 */         this.NamDataDir.mkdir();
/*     */       }
/*     */     } 
/*  50 */     if (!this.world.field_72995_K) {
/*  51 */       this.OWDir = new File(this.saveDir, "OtherWorld");
/*  52 */       if (!this.OWDir.exists()) {
/*  53 */         this.OWDir.mkdir();
/*     */       }
/*  55 */       this.OWDataDir = new File(this.OWDir, "data");
/*  56 */       if (!this.OWDataDir.exists()) {
/*  57 */         this.OWDataDir.mkdir();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void saveSpawnList(String string, File dataDir, String dataName) {
/*  63 */     if (this.world.field_72995_K) {
/*     */       return;
/*     */     }
/*     */     
/*  67 */     File spawnLog = new File(dataDir, dataName);
/*     */     
/*     */     try {
/*  70 */       BufferedWriter writer = JRMCoreSafeUtil.getWriter(spawnLog);
/*     */       
/*  72 */       writer.write(string + "");
/*  73 */       writer.flush();
/*  74 */       writer.close();
/*  75 */     } catch (IOException e) {
/*  76 */       e.printStackTrace();
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void SAAUW(int n, String un, String saa) {
/*  82 */     JRMCoreH.nbt((Entity)this.world.func_72924_a(un), "pres").func_74768_a(saa, n);
/*     */   }
/*     */   public int SAAUR(EntityPlayer un, String saa) {
/*  85 */     if (un != null && !un.field_70128_L && JRMCoreH.nbt((Entity)un, "pres").func_74762_e(saa) == 0) {
/*  86 */       if (saa == JRMCoreH.SEvil) {
/*  87 */         JRMCoreH.nbt((Entity)un, "pres").func_74768_a(saa, 67);
/*     */       }
/*  89 */       else if (saa == JRMCoreH.SHealth) {
/*  90 */         JRMCoreH.nbt((Entity)un, "pres").func_74768_a(saa, 20);
/*     */       }
/*  92 */       else if (saa == JRMCoreH.SkiMax) {
/*  93 */         JRMCoreH.nbt((Entity)un, "pres").func_74768_a(saa, 10);
/*     */       }
/*  95 */       else if (saa == JRMCoreH.Sbody) {
/*  96 */         JRMCoreH.nbt((Entity)un, "pres").func_74768_a(saa, 20);
/*     */       }
/*  98 */       else if (saa == JRMCoreH.SchMax) {
/*  99 */         JRMCoreH.nbt((Entity)un, "pres").func_74768_a(saa, 10);
/*     */       } else {
/*     */         
/* 102 */         JRMCoreH.nbt((Entity)un, "pres").func_74768_a(saa, 1);
/*     */       } 
/*     */     }
/*     */     
/* 106 */     return JRMCoreH.nbt((Entity)un, "pres").func_74762_e(saa);
/*     */   }
/*     */   
/*     */   public void SAAUW_OLD(int n, String un, String saa) {
/* 110 */     if (this.world.field_72995_K) {
/*     */       return;
/*     */     }
/* 113 */     File uf = new File(this.playersDir, un);
/* 114 */     File ud = new File(uf, saa);
/*     */ 
/*     */     
/*     */     try {
/* 118 */       BufferedWriter writer = JRMCoreSafeUtil.getWriter(ud);
/* 119 */       writer.write(Integer.toString(n));
/*     */       
/* 121 */       writer.close();
/* 122 */     } catch (IOException e) {
/* 123 */       e.printStackTrace();
/*     */       return;
/*     */     } 
/*     */   }
/*     */   public int SAAUR_OLD(String un, String saa) {
/* 128 */     File uf = new File(this.playersDir, un);
/*     */     
/* 130 */     if (!uf.exists() && 
/* 131 */       !uf.exists()) {
/* 132 */       uf.mkdir();
/*     */     }
/*     */     
/* 135 */     File ud = new File(uf, saa);
/* 136 */     if (!ud.exists()) {
/* 137 */       if (saa == JRMCoreH.SEvil) {
/* 138 */         saveSpawnList("67", uf, saa);
/*     */       }
/* 140 */       else if (saa == JRMCoreH.SHealth) {
/* 141 */         saveSpawnList("20", uf, saa);
/*     */       }
/* 143 */       else if (saa == JRMCoreH.SkiMax) {
/* 144 */         saveSpawnList("10", uf, saa);
/*     */       }
/* 146 */       else if (saa == JRMCoreH.Sbody) {
/* 147 */         saveSpawnList("20", uf, saa);
/*     */       }
/* 149 */       else if (saa == JRMCoreH.SchMax) {
/* 150 */         saveSpawnList("10", uf, saa);
/*     */       } else {
/*     */         
/* 153 */         saveSpawnList("1", uf, saa);
/*     */       } 
/*     */     }
/* 156 */     String line = null;
/*     */     
/*     */     try {
/* 159 */       BufferedReader reader = JRMCoreSafeUtil.getReader(ud);
/* 160 */       line = reader.readLine();
/* 161 */       reader.close();
/* 162 */     } catch (IOException e) {
/* 163 */       e.printStackTrace();
/*     */     } 
/* 165 */     if (line == null) {
/* 166 */       line = "0";
/*     */     }
/*     */     
/* 169 */     return Integer.parseInt(line);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSpawn(String emp, int colu, File dataDir, String dataName) {
/* 175 */     File spawnLog = new File(dataDir, dataName);
/*     */     
/* 177 */     if (!spawnLog.exists()) {
/* 178 */       saveSpawnList(emp + " ", dataDir, dataName);
/*     */     }
/*     */     
/* 181 */     String line = null;
/*     */     
/*     */     try {
/* 184 */       BufferedReader reader = JRMCoreSafeUtil.getReader(spawnLog);
/* 185 */       line = reader.readLine();
/* 186 */       reader.close();
/* 187 */     } catch (IOException e) {
/* 188 */       e.printStackTrace();
/*     */     } 
/* 190 */     if (line == null) {
/* 191 */       line = " ";
/*     */     }
/* 193 */     String[] col = line.split(" ");
/*     */     
/* 195 */     boolean gen = true;
/* 196 */     if (col[colu].compareTo(emp) == 0) {
/* 197 */       gen = false;
/*     */     }
/* 199 */     return gen;
/*     */   }
/*     */   
/*     */   public boolean isSpawn(String emp, String dont, int colu, File dataDir, String dataName) {
/* 203 */     File spawnLog = new File(dataDir, dataName);
/*     */     
/* 205 */     if (!spawnLog.exists()) {
/* 206 */       saveSpawnList(emp, dataDir, dataName);
/*     */     }
/*     */     
/* 209 */     String line = null;
/*     */ 
/*     */     
/*     */     try {
/* 213 */       BufferedReader reader = JRMCoreSafeUtil.getReader(spawnLog);
/* 214 */       line = reader.readLine();
/*     */       
/* 216 */       reader.close();
/* 217 */     } catch (IOException e) {
/* 218 */       e.printStackTrace();
/*     */     } 
/* 220 */     if (line == null) {
/* 221 */       line = " ";
/*     */     }
/* 223 */     String[] col = line.split(" ");
/*     */     
/* 225 */     boolean gen = true;
/* 226 */     if (col[colu].compareTo(dont) == 0) {
/* 227 */       gen = false;
/*     */     }
/*     */     
/* 230 */     return gen;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreSafe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */