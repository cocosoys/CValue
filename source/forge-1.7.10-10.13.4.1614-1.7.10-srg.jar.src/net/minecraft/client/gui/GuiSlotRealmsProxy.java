/*    */ package net.minecraft.client.gui;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.realms.RealmsScrolledSelectionList;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GuiSlotRealmsProxy extends GuiSlot {
/*    */   private final RealmsScrolledSelectionList field_154340_k;
/*    */   
/*    */   public GuiSlotRealmsProxy(RealmsScrolledSelectionList p_i1085_1_, int p_i1085_2_, int p_i1085_3_, int p_i1085_4_, int p_i1085_5_, int p_i1085_6_) {
/* 13 */     super(Minecraft.func_71410_x(), p_i1085_2_, p_i1085_3_, p_i1085_4_, p_i1085_5_, p_i1085_6_);
/* 14 */     this.field_154340_k = p_i1085_1_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001846";
/*    */   
/*    */   protected int func_148127_b() {
/* 19 */     return this.field_154340_k.getItemCount();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_148144_a(int p_148144_1_, boolean p_148144_2_, int p_148144_3_, int p_148144_4_) {
/* 24 */     this.field_154340_k.selectItem(p_148144_1_, p_148144_2_, p_148144_3_, p_148144_4_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean func_148131_a(int p_148131_1_) {
/* 29 */     return this.field_154340_k.isSelectedItem(p_148131_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_148123_a() {
/* 34 */     this.field_154340_k.renderBackground();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_148126_a(int p_148126_1_, int p_148126_2_, int p_148126_3_, int p_148126_4_, Tessellator p_148126_5_, int p_148126_6_, int p_148126_7_) {
/* 39 */     this.field_154340_k.renderItem(p_148126_1_, p_148126_2_, p_148126_3_, p_148126_4_, p_148126_6_, p_148126_7_);
/*    */   }
/*    */   
/*    */   public int func_154338_k() {
/* 43 */     return this.field_148155_a;
/*    */   }
/*    */   
/*    */   public int func_154339_l() {
/* 47 */     return this.field_148162_h;
/*    */   }
/*    */   
/*    */   public int func_154337_m() {
/* 51 */     return this.field_148150_g;
/*    */   }
/*    */ 
/*    */   
/*    */   protected int func_148138_e() {
/* 56 */     return this.field_154340_k.getMaxPosition();
/*    */   }
/*    */ 
/*    */   
/*    */   protected int func_148137_d() {
/* 61 */     return this.field_154340_k.getScrollbarPosition();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiSlotRealmsProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */