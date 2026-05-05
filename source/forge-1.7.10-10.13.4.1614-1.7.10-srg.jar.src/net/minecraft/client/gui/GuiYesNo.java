/*    */ package net.minecraft.client.gui;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GuiYesNo
/*    */   extends GuiScreen {
/*    */   protected GuiYesNoCallback field_146355_a;
/*    */   protected String field_146351_f;
/*    */   private String field_146354_r;
/*    */   protected String field_146352_g;
/*    */   
/*    */   public GuiYesNo(GuiYesNoCallback p_i1082_1_, String p_i1082_2_, String p_i1082_3_, int p_i1082_4_) {
/* 16 */     this.field_146355_a = p_i1082_1_;
/* 17 */     this.field_146351_f = p_i1082_2_;
/* 18 */     this.field_146354_r = p_i1082_3_;
/* 19 */     this.field_146357_i = p_i1082_4_;
/*    */     
/* 21 */     this.field_146352_g = I18n.func_135052_a("gui.yes", new Object[0]);
/* 22 */     this.field_146356_h = I18n.func_135052_a("gui.no", new Object[0]);
/*    */   }
/*    */   protected String field_146356_h; protected int field_146357_i; private int field_146353_s; private static final String __OBFID = "CL_00000684";
/*    */   public GuiYesNo(GuiYesNoCallback p_i1083_1_, String p_i1083_2_, String p_i1083_3_, String p_i1083_4_, String p_i1083_5_, int p_i1083_6_) {
/* 26 */     this.field_146355_a = p_i1083_1_;
/* 27 */     this.field_146351_f = p_i1083_2_;
/* 28 */     this.field_146354_r = p_i1083_3_;
/* 29 */     this.field_146352_g = p_i1083_4_;
/* 30 */     this.field_146356_h = p_i1083_5_;
/* 31 */     this.field_146357_i = p_i1083_6_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_73866_w_() {
/* 36 */     this.field_146292_n.add(new GuiOptionButton(0, this.field_146294_l / 2 - 155, this.field_146295_m / 6 + 96, this.field_146352_g));
/* 37 */     this.field_146292_n.add(new GuiOptionButton(1, this.field_146294_l / 2 - 155 + 160, this.field_146295_m / 6 + 96, this.field_146356_h));
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_146284_a(GuiButton p_146284_1_) {
/* 42 */     this.field_146355_a.func_73878_a((p_146284_1_.field_146127_k == 0), this.field_146357_i);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 47 */     func_146276_q_();
/*    */     
/* 49 */     func_73732_a(this.field_146289_q, this.field_146351_f, this.field_146294_l / 2, 70, 16777215);
/* 50 */     func_73732_a(this.field_146289_q, this.field_146354_r, this.field_146294_l / 2, 90, 16777215);
/*    */     
/* 52 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*    */   }
/*    */   
/*    */   public void func_146350_a(int p_146350_1_) {
/* 56 */     this.field_146353_s = p_146350_1_;
/*    */     
/* 58 */     for (GuiButton guiButton : this.field_146292_n) {
/* 59 */       guiButton.field_146124_l = false;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_73876_c() {
/* 65 */     super.func_73876_c();
/*    */     
/* 67 */     if (--this.field_146353_s == 0)
/* 68 */       for (GuiButton guiButton : this.field_146292_n)
/* 69 */         guiButton.field_146124_l = true;  
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiYesNo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */