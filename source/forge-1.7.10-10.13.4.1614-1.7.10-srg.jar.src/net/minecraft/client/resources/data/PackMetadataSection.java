/*    */ package net.minecraft.client.resources.data;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class PackMetadataSection
/*    */   implements IMetadataSection {
/*    */   private final IChatComponent field_110464_a;
/*    */   
/*    */   public PackMetadataSection(IChatComponent p_i1034_1_, int p_i1034_2_) {
/* 13 */     this.field_110464_a = p_i1034_1_;
/* 14 */     this.field_110463_b = p_i1034_2_;
/*    */   }
/*    */   private final int field_110463_b; private static final String __OBFID = "CL_00001112";
/*    */   public IChatComponent func_152805_a() {
/* 18 */     return this.field_110464_a;
/*    */   }
/*    */   
/*    */   public int func_110462_b() {
/* 22 */     return this.field_110463_b;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\resources\data\PackMetadataSection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */