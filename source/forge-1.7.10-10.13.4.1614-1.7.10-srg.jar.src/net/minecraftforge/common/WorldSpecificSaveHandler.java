/*    */ package net.minecraftforge.common;
/*    */ 
/*    */ import java.io.File;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.world.MinecraftException;
/*    */ import net.minecraft.world.WorldProvider;
/*    */ import net.minecraft.world.WorldServer;
/*    */ import net.minecraft.world.chunk.storage.IChunkLoader;
/*    */ import net.minecraft.world.storage.IPlayerFileData;
/*    */ import net.minecraft.world.storage.ISaveHandler;
/*    */ import net.minecraft.world.storage.WorldInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorldSpecificSaveHandler
/*    */   implements ISaveHandler
/*    */ {
/*    */   private WorldServer world;
/*    */   private ISaveHandler parent;
/*    */   private File dataDir;
/*    */   
/*    */   public WorldSpecificSaveHandler(WorldServer world, ISaveHandler parent) {
/* 24 */     this.world = world;
/* 25 */     this.parent = parent;
/* 26 */     this.dataDir = new File(world.getChunkSaveLocation(), "data");
/* 27 */     this.dataDir.mkdirs();
/*    */   }
/*    */   
/* 30 */   public WorldInfo loadWorldInfo() { return this.parent.loadWorldInfo(); }
/* 31 */   public void checkSessionLock() throws MinecraftException { this.parent.checkSessionLock(); }
/* 32 */   public IChunkLoader getChunkLoader(WorldProvider var1) { return this.parent.getChunkLoader(var1); }
/* 33 */   public void saveWorldInfoWithPlayer(WorldInfo var1, NBTTagCompound var2) { this.parent.saveWorldInfoWithPlayer(var1, var2); }
/* 34 */   public void saveWorldInfo(WorldInfo var1) { this.parent.saveWorldInfo(var1); }
/* 35 */   public IPlayerFileData getSaveHandler() { return this.parent.getSaveHandler(); }
/* 36 */   public void flush() { this.parent.flush(); }
/* 37 */   public String getWorldDirectoryName() { return this.parent.getWorldDirectoryName(); } public File getWorldDirectory() {
/* 38 */     return this.parent.getWorldDirectory();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public File getMapFileFromName(String name) {
/* 46 */     return new File(this.dataDir, name + ".dat");
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\common\WorldSpecificSaveHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */