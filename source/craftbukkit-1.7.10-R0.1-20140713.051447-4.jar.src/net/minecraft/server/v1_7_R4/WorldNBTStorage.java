/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.io.DataInputStream;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.util.UUID;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WorldNBTStorage
/*     */   implements IDataManager, IPlayerFileData
/*     */ {
/*  23 */   private static final Logger a = LogManager.getLogger();
/*     */   private final File baseDir;
/*     */   private final File playerDir;
/*     */   private final File dataDir;
/*  27 */   private final long sessionId = MinecraftServer.ar();
/*     */   private final String f;
/*  29 */   private UUID uuid = null;
/*     */   
/*     */   public WorldNBTStorage(File file1, String s, boolean flag) {
/*  32 */     this.baseDir = new File(file1, s);
/*  33 */     this.baseDir.mkdirs();
/*  34 */     this.playerDir = new File(this.baseDir, "playerdata");
/*  35 */     this.dataDir = new File(this.baseDir, "data");
/*  36 */     this.dataDir.mkdirs();
/*  37 */     this.f = s;
/*  38 */     if (flag) {
/*  39 */       this.playerDir.mkdirs();
/*     */     }
/*     */     
/*  42 */     h();
/*     */   }
/*     */   
/*     */   private void h() {
/*     */     try {
/*  47 */       File file1 = new File(this.baseDir, "session.lock");
/*  48 */       DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(file1));
/*     */       
/*     */       try {
/*  51 */         dataoutputstream.writeLong(this.sessionId);
/*     */       } finally {
/*  53 */         dataoutputstream.close();
/*     */       } 
/*  55 */     } catch (IOException ioexception) {
/*  56 */       ioexception.printStackTrace();
/*  57 */       throw new RuntimeException("Failed to check session lock, aborting");
/*     */     } 
/*     */   }
/*     */   
/*     */   public File getDirectory() {
/*  62 */     return this.baseDir;
/*     */   }
/*     */   
/*     */   public void checkSession() throws ExceptionWorldConflict {
/*     */     try {
/*  67 */       File file1 = new File(this.baseDir, "session.lock");
/*  68 */       DataInputStream datainputstream = new DataInputStream(new FileInputStream(file1));
/*     */       
/*     */       try {
/*  71 */         if (datainputstream.readLong() != this.sessionId) {
/*  72 */           throw new ExceptionWorldConflict("The save is being accessed from another location, aborting");
/*     */         }
/*     */       } finally {
/*  75 */         datainputstream.close();
/*     */       } 
/*  77 */     } catch (IOException ioexception) {
/*  78 */       throw new ExceptionWorldConflict("Failed to check session lock, aborting");
/*     */     } 
/*     */   }
/*     */   
/*     */   public IChunkLoader createChunkLoader(WorldProvider worldprovider) {
/*  83 */     throw new RuntimeException("Old Chunk Storage is no longer supported.");
/*     */   }
/*     */   
/*     */   public WorldData getWorldData() {
/*  87 */     File file1 = new File(this.baseDir, "level.dat");
/*     */ 
/*     */ 
/*     */     
/*  91 */     if (file1.exists()) {
/*     */       try {
/*  93 */         NBTTagCompound nbttagcompound = NBTCompressedStreamTools.a(new FileInputStream(file1));
/*  94 */         NBTTagCompound nbttagcompound1 = nbttagcompound.getCompound("Data");
/*  95 */         return new WorldData(nbttagcompound1);
/*  96 */       } catch (Exception exception) {
/*  97 */         exception.printStackTrace();
/*     */       } 
/*     */     }
/*     */     
/* 101 */     file1 = new File(this.baseDir, "level.dat_old");
/* 102 */     if (file1.exists()) {
/*     */       try {
/* 104 */         NBTTagCompound nBTTagCompound1 = NBTCompressedStreamTools.a(new FileInputStream(file1));
/* 105 */         NBTTagCompound nBTTagCompound2 = nBTTagCompound1.getCompound("Data");
/* 106 */         return new WorldData(nBTTagCompound2);
/* 107 */       } catch (Exception exception1) {
/* 108 */         exception1.printStackTrace();
/*     */       } 
/*     */     }
/*     */     
/* 112 */     return null;
/*     */   }
/*     */   
/*     */   public void saveWorldData(WorldData worlddata, NBTTagCompound nbttagcompound) {
/* 116 */     NBTTagCompound nbttagcompound1 = worlddata.a(nbttagcompound);
/* 117 */     NBTTagCompound nbttagcompound2 = new NBTTagCompound();
/*     */     
/* 119 */     nbttagcompound2.set("Data", nbttagcompound1);
/*     */     
/*     */     try {
/* 122 */       File file1 = new File(this.baseDir, "level.dat_new");
/* 123 */       File file2 = new File(this.baseDir, "level.dat_old");
/* 124 */       File file3 = new File(this.baseDir, "level.dat");
/*     */       
/* 126 */       NBTCompressedStreamTools.a(nbttagcompound2, new FileOutputStream(file1));
/* 127 */       if (file2.exists()) {
/* 128 */         file2.delete();
/*     */       }
/*     */       
/* 131 */       file3.renameTo(file2);
/* 132 */       if (file3.exists()) {
/* 133 */         file3.delete();
/*     */       }
/*     */       
/* 136 */       file1.renameTo(file3);
/* 137 */       if (file1.exists()) {
/* 138 */         file1.delete();
/*     */       }
/* 140 */     } catch (Exception exception) {
/* 141 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void saveWorldData(WorldData worlddata) {
/* 146 */     NBTTagCompound nbttagcompound = worlddata.a();
/* 147 */     NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/*     */     
/* 149 */     nbttagcompound1.set("Data", nbttagcompound);
/*     */     
/*     */     try {
/* 152 */       File file1 = new File(this.baseDir, "level.dat_new");
/* 153 */       File file2 = new File(this.baseDir, "level.dat_old");
/* 154 */       File file3 = new File(this.baseDir, "level.dat");
/*     */       
/* 156 */       NBTCompressedStreamTools.a(nbttagcompound1, new FileOutputStream(file1));
/* 157 */       if (file2.exists()) {
/* 158 */         file2.delete();
/*     */       }
/*     */       
/* 161 */       file3.renameTo(file2);
/* 162 */       if (file3.exists()) {
/* 163 */         file3.delete();
/*     */       }
/*     */       
/* 166 */       file1.renameTo(file3);
/* 167 */       if (file1.exists()) {
/* 168 */         file1.delete();
/*     */       }
/* 170 */     } catch (Exception exception) {
/* 171 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void save(EntityHuman entityhuman) {
/*     */     try {
/* 177 */       NBTTagCompound nbttagcompound = new NBTTagCompound();
/*     */       
/* 179 */       entityhuman.e(nbttagcompound);
/* 180 */       File file1 = new File(this.playerDir, entityhuman.getUniqueID().toString() + ".dat.tmp");
/* 181 */       File file2 = new File(this.playerDir, entityhuman.getUniqueID().toString() + ".dat");
/*     */       
/* 183 */       NBTCompressedStreamTools.a(nbttagcompound, new FileOutputStream(file1));
/* 184 */       if (file2.exists()) {
/* 185 */         file2.delete();
/*     */       }
/*     */       
/* 188 */       file1.renameTo(file2);
/* 189 */     } catch (Exception exception) {
/* 190 */       a.warn("Failed to save player data for " + entityhuman.getName());
/*     */     } 
/*     */   }
/*     */   
/*     */   public NBTTagCompound load(EntityHuman entityhuman) {
/* 195 */     NBTTagCompound nbttagcompound = null;
/*     */     
/*     */     try {
/* 198 */       File file1 = new File(this.playerDir, entityhuman.getUniqueID().toString() + ".dat");
/*     */       
/* 200 */       if (file1.exists() && file1.isFile()) {
/* 201 */         nbttagcompound = NBTCompressedStreamTools.a(new FileInputStream(file1));
/*     */       }
/* 203 */     } catch (Exception exception) {
/* 204 */       a.warn("Failed to load player data for " + entityhuman.getName());
/*     */     } 
/*     */     
/* 207 */     if (nbttagcompound != null) {
/*     */       
/* 209 */       if (entityhuman instanceof EntityPlayer) {
/* 210 */         CraftPlayer player = (CraftPlayer)entityhuman.bukkitEntity;
/*     */         
/* 212 */         long modified = (new File(this.playerDir, entityhuman.getUniqueID().toString() + ".dat")).lastModified();
/* 213 */         if (modified < player.getFirstPlayed()) {
/* 214 */           player.setFirstPlayed(modified);
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 219 */       entityhuman.f(nbttagcompound);
/*     */     } 
/*     */     
/* 222 */     return nbttagcompound;
/*     */   }
/*     */   
/*     */   public NBTTagCompound getPlayerData(String s) {
/*     */     try {
/* 227 */       File file1 = new File(this.playerDir, s + ".dat");
/*     */       
/* 229 */       if (file1.exists()) {
/* 230 */         return NBTCompressedStreamTools.a(new FileInputStream(file1));
/*     */       }
/* 232 */     } catch (Exception exception) {
/* 233 */       a.warn("Failed to load player data for " + s);
/*     */     } 
/*     */     
/* 236 */     return null;
/*     */   }
/*     */   
/*     */   public IPlayerFileData getPlayerFileData() {
/* 240 */     return this;
/*     */   }
/*     */   
/*     */   public String[] getSeenPlayers() {
/* 244 */     String[] astring = this.playerDir.list();
/*     */     
/* 246 */     for (int i = 0; i < astring.length; i++) {
/* 247 */       if (astring[i].endsWith(".dat")) {
/* 248 */         astring[i] = astring[i].substring(0, astring[i].length() - 4);
/*     */       }
/*     */     } 
/*     */     
/* 252 */     return astring;
/*     */   }
/*     */   
/*     */   public void a() {}
/*     */   
/*     */   public File getDataFile(String s) {
/* 258 */     return new File(this.dataDir, s + ".dat");
/*     */   }
/*     */   
/*     */   public String g() {
/* 262 */     return this.f;
/*     */   }
/*     */ 
/*     */   
/*     */   public UUID getUUID() {
/* 267 */     if (this.uuid != null) return this.uuid; 
/* 268 */     File file1 = new File(this.baseDir, "uid.dat");
/* 269 */     if (file1.exists()) {
/* 270 */       DataInputStream dis = null;
/*     */       try {
/* 272 */         dis = new DataInputStream(new FileInputStream(file1));
/* 273 */         return this.uuid = new UUID(dis.readLong(), dis.readLong());
/* 274 */       } catch (IOException ex) {
/* 275 */         a.warn("Failed to read " + file1 + ", generating new random UUID", ex);
/*     */       } finally {
/* 277 */         if (dis != null) {
/*     */           try {
/* 279 */             dis.close();
/* 280 */           } catch (IOException ex) {}
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 286 */     this.uuid = UUID.randomUUID();
/* 287 */     DataOutputStream dos = null;
/*     */     try {
/* 289 */       dos = new DataOutputStream(new FileOutputStream(file1));
/* 290 */       dos.writeLong(this.uuid.getMostSignificantBits());
/* 291 */       dos.writeLong(this.uuid.getLeastSignificantBits());
/* 292 */     } catch (IOException ex) {
/* 293 */       a.warn("Failed to write " + file1, ex);
/*     */     } finally {
/* 295 */       if (dos != null) {
/*     */         try {
/* 297 */           dos.close();
/* 298 */         } catch (IOException ex) {}
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 303 */     return this.uuid;
/*     */   }
/*     */   
/*     */   public File getPlayerDir() {
/* 307 */     return this.playerDir;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\WorldNBTStorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */