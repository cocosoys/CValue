/*    */ package net.minecraft.realms;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.GuiButtonRealmsProxy;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RealmsButton {
/*    */   private GuiButtonRealmsProxy proxy;
/*    */   
/*    */   public RealmsButton(int p_i1177_1_, int p_i1177_2_, int p_i1177_3_, String p_i1177_4_) {
/* 13 */     this.proxy = new GuiButtonRealmsProxy(this, p_i1177_1_, p_i1177_2_, p_i1177_3_, p_i1177_4_);
/*    */   }
/*    */   private static final String __OBFID = "CL_00001890";
/*    */   public RealmsButton(int p_i1178_1_, int p_i1178_2_, int p_i1178_3_, int p_i1178_4_, int p_i1178_5_, String p_i1178_6_) {
/* 17 */     this.proxy = new GuiButtonRealmsProxy(this, p_i1178_1_, p_i1178_2_, p_i1178_3_, p_i1178_6_, p_i1178_4_, p_i1178_5_);
/*    */   }
/*    */   
/*    */   public GuiButton getProxy() {
/* 21 */     return (GuiButton)this.proxy;
/*    */   }
/*    */   
/*    */   public int id() {
/* 25 */     return this.proxy.func_154314_d();
/*    */   }
/*    */   
/*    */   public boolean active() {
/* 29 */     return this.proxy.func_154315_e();
/*    */   }
/*    */   
/*    */   public void active(boolean p_active_1_) {
/* 33 */     this.proxy.func_154313_b(p_active_1_);
/*    */   }
/*    */   
/*    */   public void msg(String p_msg_1_) {
/* 37 */     this.proxy.func_154311_a(p_msg_1_);
/*    */   }
/*    */   
/*    */   public int getWidth() {
/* 41 */     return this.proxy.func_146117_b();
/*    */   }
/*    */   
/*    */   public int getHeight() {
/* 45 */     return this.proxy.func_154310_c();
/*    */   }
/*    */   
/*    */   public int y() {
/* 49 */     return this.proxy.func_154316_f();
/*    */   }
/*    */   
/*    */   public void render(int p_render_1_, int p_render_2_) {
/* 53 */     this.proxy.func_146112_a(Minecraft.func_71410_x(), p_render_1_, p_render_2_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void clicked(int p_clicked_1_, int p_clicked_2_) {}
/*    */ 
/*    */   
/*    */   public void released(int p_released_1_, int p_released_2_) {}
/*    */   
/*    */   public void blit(int p_blit_1_, int p_blit_2_, int p_blit_3_, int p_blit_4_, int p_blit_5_, int p_blit_6_) {
/* 63 */     this.proxy.func_73729_b(p_blit_1_, p_blit_2_, p_blit_3_, p_blit_4_, p_blit_5_, p_blit_6_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderBg(int p_renderBg_1_, int p_renderBg_2_) {}
/*    */ 
/*    */   
/*    */   public int getYImage(boolean p_getYImage_1_) {
/* 71 */     return this.proxy.func_154312_c(p_getYImage_1_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\realms\RealmsButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */