/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TileEntityLightDetector
/*    */   extends TileEntity
/*    */ {
/*    */   public void h() {
/* 13 */     if (this.world != null && !this.world.isStatic && this.world.getTime() % 20L == 0L) {
/* 14 */       this.h = q();
/* 15 */       if (this.h instanceof BlockDaylightDetector)
/* 16 */         ((BlockDaylightDetector)this.h).e(this.world, this.x, this.y, this.z); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\TileEntityLightDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */