/*    */ package net.minecraftforge.common.util;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.world.ChunkCoordIntPair;
/*    */ 
/*    */ public class ChunkCoordComparator
/*    */   implements Comparator<ChunkCoordIntPair>
/*    */ {
/*    */   private int x;
/*    */   private int z;
/*    */   
/*    */   public ChunkCoordComparator(EntityPlayerMP entityplayer) {
/* 14 */     this.x = (int)entityplayer.posX >> 4;
/* 15 */     this.z = (int)entityplayer.posZ >> 4;
/*    */   }
/*    */ 
/*    */   
/*    */   public int compare(ChunkCoordIntPair a, ChunkCoordIntPair b) {
/* 20 */     if (a.equals(b))
/*    */     {
/* 22 */       return 0;
/*    */     }
/*    */ 
/*    */     
/* 26 */     int ax = a.chunkXPos - this.x;
/* 27 */     int az = a.chunkZPos - this.z;
/* 28 */     int bx = b.chunkXPos - this.x;
/* 29 */     int bz = b.chunkZPos - this.z;
/* 30 */     int result = (ax - bx) * (ax + bx) + (az - bz) * (az + bz);
/*    */     
/* 32 */     if (result != 0)
/*    */     {
/* 34 */       return result;
/*    */     }
/*    */     
/* 37 */     if (ax < 0) {
/*    */       
/* 39 */       if (bx < 0)
/*    */       {
/* 41 */         return bz - az;
/*    */       }
/*    */ 
/*    */       
/* 45 */       return -1;
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 50 */     if (bx < 0)
/*    */     {
/* 52 */       return 1;
/*    */     }
/*    */ 
/*    */     
/* 56 */     return az - bz;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\commo\\util\ChunkCoordComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */