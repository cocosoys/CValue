/*    */ package net.minecraft.tileentity;
/*    */ 
/*    */ import net.minecraft.block.BlockDaylightDetector;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TileEntityDaylightDetector
/*    */   extends TileEntity
/*    */ {
/*    */   private static final String __OBFID = "CL_00000350";
/*    */   
/*    */   public void func_145845_h() {
/* 13 */     if (this.field_145850_b != null && !this.field_145850_b.field_72995_K && this.field_145850_b.func_82737_E() % 20L == 0L) {
/* 14 */       this.field_145854_h = func_145838_q();
/* 15 */       if (this.field_145854_h instanceof BlockDaylightDetector)
/* 16 */         ((BlockDaylightDetector)this.field_145854_h).func_149957_e(this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\tileentity\TileEntityDaylightDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */