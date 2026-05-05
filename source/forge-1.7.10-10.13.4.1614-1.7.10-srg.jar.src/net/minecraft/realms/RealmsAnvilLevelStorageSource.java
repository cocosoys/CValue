/*    */ package net.minecraft.realms;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.AnvilConverterException;
/*    */ import net.minecraft.util.IProgressUpdate;
/*    */ import net.minecraft.world.storage.ISaveFormat;
/*    */ import net.minecraft.world.storage.SaveFormatComparator;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RealmsAnvilLevelStorageSource {
/*    */   private ISaveFormat levelStorageSource;
/*    */   
/*    */   public RealmsAnvilLevelStorageSource(ISaveFormat p_i1106_1_) {
/* 16 */     this.levelStorageSource = p_i1106_1_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001856";
/*    */   public String getName() {
/* 20 */     return this.levelStorageSource.func_154333_a();
/*    */   }
/*    */   
/*    */   public boolean levelExists(String p_levelExists_1_) {
/* 24 */     return this.levelStorageSource.func_90033_f(p_levelExists_1_);
/*    */   }
/*    */   
/*    */   public boolean convertLevel(String p_convertLevel_1_, IProgressUpdate p_convertLevel_2_) {
/* 28 */     return this.levelStorageSource.func_75805_a(p_convertLevel_1_, p_convertLevel_2_);
/*    */   }
/*    */   
/*    */   public boolean requiresConversion(String p_requiresConversion_1_) {
/* 32 */     return this.levelStorageSource.func_75801_b(p_requiresConversion_1_);
/*    */   }
/*    */   
/*    */   public boolean isNewLevelIdAcceptable(String p_isNewLevelIdAcceptable_1_) {
/* 36 */     return this.levelStorageSource.func_154335_d(p_isNewLevelIdAcceptable_1_);
/*    */   }
/*    */   
/*    */   public boolean deleteLevel(String p_deleteLevel_1_) {
/* 40 */     return this.levelStorageSource.func_75802_e(p_deleteLevel_1_);
/*    */   }
/*    */   
/*    */   public boolean isConvertible(String p_isConvertible_1_) {
/* 44 */     return this.levelStorageSource.func_154334_a(p_isConvertible_1_);
/*    */   }
/*    */   
/*    */   public void renameLevel(String p_renameLevel_1_, String p_renameLevel_2_) {
/* 48 */     this.levelStorageSource.func_75806_a(p_renameLevel_1_, p_renameLevel_2_);
/*    */   }
/*    */   
/*    */   public void clearAll() {
/* 52 */     this.levelStorageSource.func_75800_d();
/*    */   }
/*    */   
/*    */   public List getLevelList() throws AnvilConverterException {
/* 56 */     ArrayList<RealmsLevelSummary> arrayList = new ArrayList();
/* 57 */     for (SaveFormatComparator saveFormatComparator : this.levelStorageSource.func_75799_b()) {
/* 58 */       arrayList.add(new RealmsLevelSummary(saveFormatComparator));
/*    */     }
/* 60 */     return arrayList;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\realms\RealmsAnvilLevelStorageSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */