/*    */ package net.minecraft.client.gui;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GuiErrorScreen extends GuiScreen {
/*    */   private String field_146313_a;
/*    */   
/*    */   public GuiErrorScreen(String p_i1034_1_, String p_i1034_2_) {
/*  9 */     this.field_146313_a = p_i1034_1_;
/* 10 */     this.field_146312_f = p_i1034_2_;
/*    */   }
/*    */   private String field_146312_f; private static final String __OBFID = "CL_00000696";
/*    */   
/*    */   public void func_73866_w_() {
/* 15 */     super.func_73866_w_();
/*    */     
/* 17 */     this.field_146292_n.add(new GuiButton(0, this.field_146294_l / 2 - 100, 140, I18n.func_135052_a("gui.cancel", new Object[0])));
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 22 */     func_73733_a(0, 0, this.field_146294_l, this.field_146295_m, -12574688, -11530224);
/*    */     
/* 24 */     func_73732_a(this.field_146289_q, this.field_146313_a, this.field_146294_l / 2, 90, 16777215);
/* 25 */     func_73732_a(this.field_146289_q, this.field_146312_f, this.field_146294_l / 2, 110, 16777215);
/*    */     
/* 27 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {}
/*    */ 
/*    */   
/*    */   protected void func_146284_a(GuiButton p_146284_1_) {
/* 36 */     this.field_146297_k.func_147108_a(null);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiErrorScreen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */