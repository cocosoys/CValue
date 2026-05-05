/*    */ package net.minecraft.client.gui;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GuiMemoryErrorScreen extends GuiScreen {
/*    */   private static final String __OBFID = "CL_00000702";
/*    */   
/*    */   public void func_73866_w_() {
/* 12 */     this.field_146292_n.clear();
/* 13 */     this.field_146292_n.add(new GuiOptionButton(0, this.field_146294_l / 2 - 155, this.field_146295_m / 4 + 120 + 12, I18n.func_135052_a("gui.toMenu", new Object[0])));
/* 14 */     this.field_146292_n.add(new GuiOptionButton(1, this.field_146294_l / 2 - 155 + 160, this.field_146295_m / 4 + 120 + 12, I18n.func_135052_a("menu.quit", new Object[0])));
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_146284_a(GuiButton p_146284_1_) {
/* 19 */     if (p_146284_1_.field_146127_k == 0) {
/* 20 */       this.field_146297_k.func_147108_a(new GuiMainMenu());
/* 21 */     } else if (p_146284_1_.field_146127_k == 1) {
/* 22 */       this.field_146297_k.func_71400_g();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {}
/*    */ 
/*    */   
/*    */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 32 */     func_146276_q_();
/*    */     
/* 34 */     func_73732_a(this.field_146289_q, "Out of memory!", this.field_146294_l / 2, this.field_146295_m / 4 - 60 + 20, 16777215);
/* 35 */     func_73731_b(this.field_146289_q, "Minecraft has run out of memory.", this.field_146294_l / 2 - 140, this.field_146295_m / 4 - 60 + 60 + 0, 10526880);
/* 36 */     func_73731_b(this.field_146289_q, "This could be caused by a bug in the game or by the", this.field_146294_l / 2 - 140, this.field_146295_m / 4 - 60 + 60 + 18, 10526880);
/* 37 */     func_73731_b(this.field_146289_q, "Java Virtual Machine not being allocated enough", this.field_146294_l / 2 - 140, this.field_146295_m / 4 - 60 + 60 + 27, 10526880);
/* 38 */     func_73731_b(this.field_146289_q, "memory.", this.field_146294_l / 2 - 140, this.field_146295_m / 4 - 60 + 60 + 36, 10526880);
/* 39 */     func_73731_b(this.field_146289_q, "To prevent level corruption, the current game has quit.", this.field_146294_l / 2 - 140, this.field_146295_m / 4 - 60 + 60 + 54, 10526880);
/* 40 */     func_73731_b(this.field_146289_q, "We've tried to free up enough memory to let you go back to", this.field_146294_l / 2 - 140, this.field_146295_m / 4 - 60 + 60 + 63, 10526880);
/* 41 */     func_73731_b(this.field_146289_q, "the main menu and back to playing, but this may not have worked.", this.field_146294_l / 2 - 140, this.field_146295_m / 4 - 60 + 60 + 72, 10526880);
/* 42 */     func_73731_b(this.field_146289_q, "Please restart the game if you see this message again.", this.field_146294_l / 2 - 140, this.field_146295_m / 4 - 60 + 60 + 81, 10526880);
/*    */     
/* 44 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiMemoryErrorScreen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */