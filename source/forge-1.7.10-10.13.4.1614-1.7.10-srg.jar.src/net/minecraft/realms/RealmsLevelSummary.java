/*    */ package net.minecraft.realms;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.world.storage.SaveFormatComparator;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RealmsLevelSummary implements Comparable {
/*    */   private SaveFormatComparator levelSummary;
/*    */   
/*    */   public RealmsLevelSummary(SaveFormatComparator p_i1109_1_) {
/* 10 */     this.levelSummary = p_i1109_1_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001857";
/*    */   public int getGameMode() {
/* 14 */     return this.levelSummary.func_75790_f().func_77148_a();
/*    */   }
/*    */   
/*    */   public String getLevelId() {
/* 18 */     return this.levelSummary.func_75786_a();
/*    */   }
/*    */   
/*    */   public boolean hasCheats() {
/* 22 */     return this.levelSummary.func_75783_h();
/*    */   }
/*    */   
/*    */   public boolean isHardcore() {
/* 26 */     return this.levelSummary.func_75789_g();
/*    */   }
/*    */   
/*    */   public boolean isRequiresConversion() {
/* 30 */     return this.levelSummary.func_75785_d();
/*    */   }
/*    */   
/*    */   public String getLevelName() {
/* 34 */     return this.levelSummary.func_75788_b();
/*    */   }
/*    */   
/*    */   public long getLastPlayed() {
/* 38 */     return this.levelSummary.func_75784_e();
/*    */   }
/*    */   
/*    */   public int compareTo(SaveFormatComparator p_compareTo_1_) {
/* 42 */     return this.levelSummary.compareTo(p_compareTo_1_);
/*    */   }
/*    */   
/*    */   public long getSizeOnDisk() {
/* 46 */     return this.levelSummary.func_154336_c();
/*    */   }
/*    */ 
/*    */   
/*    */   public int compareTo(RealmsLevelSummary p_compareTo_1_) {
/* 51 */     if (this.levelSummary.func_75784_e() < p_compareTo_1_.getLastPlayed()) {
/* 52 */       return 1;
/*    */     }
/* 54 */     if (this.levelSummary.func_75784_e() > p_compareTo_1_.getLastPlayed()) {
/* 55 */       return -1;
/*    */     }
/* 57 */     return this.levelSummary.func_75786_a().compareTo(p_compareTo_1_.getLevelId());
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\realms\RealmsLevelSummary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */