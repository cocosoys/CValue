/*    */ package net.minecraft.realms;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.client.gui.GuiSlotRealmsProxy;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RealmsScrolledSelectionList {
/*    */   private final GuiSlotRealmsProxy proxy;
/*    */   
/*    */   public RealmsScrolledSelectionList(int p_i1119_1_, int p_i1119_2_, int p_i1119_3_, int p_i1119_4_, int p_i1119_5_) {
/* 10 */     this.proxy = new GuiSlotRealmsProxy(this, p_i1119_1_, p_i1119_2_, p_i1119_3_, p_i1119_4_, p_i1119_5_);
/*    */   }
/*    */   private static final String __OBFID = "CL_00001863";
/*    */   public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
/* 14 */     this.proxy.func_148128_a(p_render_1_, p_render_2_, p_render_3_);
/*    */   }
/*    */   
/*    */   public int width() {
/* 18 */     return this.proxy.func_154338_k();
/*    */   }
/*    */   
/*    */   public int ym() {
/* 22 */     return this.proxy.func_154339_l();
/*    */   }
/*    */   
/*    */   public int xm() {
/* 26 */     return this.proxy.func_154337_m();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renderItem(int p_renderItem_1_, int p_renderItem_2_, int p_renderItem_3_, int p_renderItem_4_, Tezzelator p_renderItem_5_, int p_renderItem_6_, int p_renderItem_7_) {}
/*    */ 
/*    */   
/*    */   public void renderItem(int p_renderItem_1_, int p_renderItem_2_, int p_renderItem_3_, int p_renderItem_4_, int p_renderItem_5_, int p_renderItem_6_) {
/* 34 */     renderItem(p_renderItem_1_, p_renderItem_2_, p_renderItem_3_, p_renderItem_4_, Tezzelator.instance, p_renderItem_5_, p_renderItem_6_);
/*    */   }
/*    */   
/*    */   public int getItemCount() {
/* 38 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public void selectItem(int p_selectItem_1_, boolean p_selectItem_2_, int p_selectItem_3_, int p_selectItem_4_) {}
/*    */ 
/*    */   
/*    */   public boolean isSelectedItem(int p_isSelectedItem_1_) {
/* 46 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderBackground() {}
/*    */ 
/*    */   
/*    */   public int getMaxPosition() {
/* 54 */     return 0;
/*    */   }
/*    */   
/*    */   public int getScrollbarPosition() {
/* 58 */     return this.proxy.func_154338_k() / 2 + 124;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\realms\RealmsScrolledSelectionList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */