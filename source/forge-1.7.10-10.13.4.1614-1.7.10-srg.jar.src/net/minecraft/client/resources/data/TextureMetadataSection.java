/*    */ package net.minecraft.client.resources.data;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class TextureMetadataSection
/*    */   implements IMetadataSection
/*    */ {
/*    */   private final boolean field_110482_a;
/*    */   private final boolean field_110481_b;
/*    */   private final List field_148536_c;
/*    */   private static final String __OBFID = "CL_00001114";
/*    */   
/*    */   public TextureMetadataSection(boolean p_i45102_1_, boolean p_i45102_2_, List p_i45102_3_) {
/* 19 */     this.field_110482_a = p_i45102_1_;
/* 20 */     this.field_110481_b = p_i45102_2_;
/* 21 */     this.field_148536_c = p_i45102_3_;
/*    */   }
/*    */   
/*    */   public boolean func_110479_a() {
/* 25 */     return this.field_110482_a;
/*    */   }
/*    */   
/*    */   public boolean func_110480_b() {
/* 29 */     return this.field_110481_b;
/*    */   }
/*    */   
/*    */   public List func_148535_c() {
/* 33 */     return Collections.unmodifiableList(this.field_148536_c);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\resources\data\TextureMetadataSection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */