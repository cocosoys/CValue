/*    */ package net.minecraft.client.resources.data;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Collection;
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class LanguageMetadataSection
/*    */   implements IMetadataSection
/*    */ {
/*    */   private final Collection field_135019_a;
/*    */   private static final String __OBFID = "CL_00001110";
/*    */   
/*    */   public LanguageMetadataSection(Collection p_i1311_1_) {
/* 16 */     this.field_135019_a = p_i1311_1_;
/*    */   }
/*    */   
/*    */   public Collection func_135018_a() {
/* 20 */     return this.field_135019_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\resources\data\LanguageMetadataSection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */