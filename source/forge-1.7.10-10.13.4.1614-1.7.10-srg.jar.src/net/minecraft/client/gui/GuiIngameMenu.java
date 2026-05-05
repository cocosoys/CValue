/*    */ package net.minecraft.client.gui;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.gui.achievement.GuiAchievements;
/*    */ import net.minecraft.client.gui.achievement.GuiStats;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GuiIngameMenu extends GuiScreen {
/*    */   private int field_146445_a;
/*    */   
/*    */   public void func_73866_w_() {
/* 13 */     this.field_146445_a = 0;
/* 14 */     this.field_146292_n.clear();
/*    */     
/* 16 */     byte b = -16;
/* 17 */     byte b1 = 98;
/* 18 */     this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 120 + b, I18n.func_135052_a("menu.returnToMenu", new Object[0])));
/* 19 */     if (!this.field_146297_k.func_71387_A()) {
/* 20 */       ((GuiButton)this.field_146292_n.get(0)).field_146126_j = I18n.func_135052_a("menu.disconnect", new Object[0]);
/*    */     }
/*    */     
/* 23 */     this.field_146292_n.add(new GuiButton(4, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 24 + b, I18n.func_135052_a("menu.returnToGame", new Object[0])));
/* 24 */     this.field_146292_n.add(new GuiButton(0, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 96 + b, 98, 20, I18n.func_135052_a("menu.options", new Object[0])));
/*    */     GuiButton guiButton;
/* 26 */     this.field_146292_n.add(guiButton = new GuiButton(7, this.field_146294_l / 2 + 2, this.field_146295_m / 4 + 96 + b, 98, 20, I18n.func_135052_a("menu.shareToLan", new Object[0])));
/*    */     
/* 28 */     this.field_146292_n.add(new GuiButton(5, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 48 + b, 98, 20, I18n.func_135052_a("gui.achievements", new Object[0])));
/* 29 */     this.field_146292_n.add(new GuiButton(6, this.field_146294_l / 2 + 2, this.field_146295_m / 4 + 48 + b, 98, 20, I18n.func_135052_a("gui.stats", new Object[0])));
/*    */     
/* 31 */     guiButton.field_146124_l = (this.field_146297_k.func_71356_B() && !this.field_146297_k.func_71401_C().func_71344_c());
/*    */   }
/*    */   private int field_146444_f; private static final String __OBFID = "CL_00000703";
/*    */   
/*    */   protected void func_146284_a(GuiButton p_146284_1_) {
/* 36 */     switch (p_146284_1_.field_146127_k) {
/*    */       case 0:
/* 38 */         this.field_146297_k.func_147108_a(new GuiOptions(this, this.field_146297_k.field_71474_y));
/*    */         break;
/*    */ 
/*    */       
/*    */       case 1:
/* 43 */         p_146284_1_.field_146124_l = false;
/* 44 */         this.field_146297_k.field_71441_e.func_72882_A();
/* 45 */         this.field_146297_k.func_71403_a(null);
/* 46 */         this.field_146297_k.func_147108_a(new GuiMainMenu());
/*    */         break;
/*    */       case 4:
/* 49 */         this.field_146297_k.func_147108_a(null);
/* 50 */         this.field_146297_k.func_71381_h();
/*    */         break;
/*    */       case 5:
/* 53 */         this.field_146297_k.func_147108_a((GuiScreen)new GuiAchievements(this, this.field_146297_k.field_71439_g.func_146107_m()));
/*    */         break;
/*    */       case 6:
/* 56 */         this.field_146297_k.func_147108_a((GuiScreen)new GuiStats(this, this.field_146297_k.field_71439_g.func_146107_m()));
/*    */         break;
/*    */       case 7:
/* 59 */         this.field_146297_k.func_147108_a(new GuiShareToLan(this));
/*    */         break;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_73876_c() {
/* 66 */     super.func_73876_c();
/* 67 */     this.field_146444_f++;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 72 */     func_146276_q_();
/*    */     
/* 74 */     func_73732_a(this.field_146289_q, I18n.func_135052_a("menu.game", new Object[0]), this.field_146294_l / 2, 40, 16777215);
/*    */     
/* 76 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiIngameMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */