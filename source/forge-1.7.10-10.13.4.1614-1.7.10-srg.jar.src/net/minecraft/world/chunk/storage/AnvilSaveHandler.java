/*    */ package net.minecraft.world.chunk.storage;
/*    */ 
/*    */ import java.io.File;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.world.WorldProvider;
/*    */ import net.minecraft.world.storage.SaveHandler;
/*    */ import net.minecraft.world.storage.ThreadedFileIOBase;
/*    */ import net.minecraft.world.storage.WorldInfo;
/*    */ 
/*    */ public class AnvilSaveHandler
/*    */   extends SaveHandler
/*    */ {
/*    */   private static final String __OBFID = "CL_00000581";
/*    */   
/*    */   public AnvilSaveHandler(File p_i2142_1_, String p_i2142_2_, boolean p_i2142_3_) {
/* 16 */     super(p_i2142_1_, p_i2142_2_, p_i2142_3_);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IChunkLoader func_75763_a(WorldProvider p_75763_1_) {
/* 22 */     File file = func_75765_b();
/*    */     
/* 24 */     if (p_75763_1_ instanceof net.minecraft.world.WorldProviderHell) {
/* 25 */       File file1 = new File(file, "DIM-1");
/* 26 */       file1.mkdirs();
/* 27 */       return new AnvilChunkLoader(file1);
/*    */     } 
/* 29 */     if (p_75763_1_ instanceof net.minecraft.world.WorldProviderEnd) {
/* 30 */       File file1 = new File(file, "DIM1");
/* 31 */       file1.mkdirs();
/* 32 */       return new AnvilChunkLoader(file1);
/*    */     } 
/*    */     
/* 35 */     return new AnvilChunkLoader(file);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75755_a(WorldInfo p_75755_1_, NBTTagCompound p_75755_2_) {
/* 40 */     p_75755_1_.func_76078_e(19133);
/* 41 */     super.func_75755_a(p_75755_1_, p_75755_2_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75759_a() {
/*    */     try {
/* 47 */       ThreadedFileIOBase.field_75741_a.func_75734_a();
/* 48 */     } catch (InterruptedException interruptedException) {
/* 49 */       interruptedException.printStackTrace();
/*    */     } 
/*    */     
/* 52 */     RegionFileCache.func_76551_a();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\chunk\storage\AnvilSaveHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */