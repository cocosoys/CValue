/*    */ package net.minecraft.client.gui;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GuiDisconnected
/*    */   extends GuiScreen
/*    */ {
/*    */   private String field_146306_a;
/*    */   private IChatComponent field_146304_f;
/*    */   
/*    */   public GuiDisconnected(GuiScreen p_i45020_1_, String p_i45020_2_, IChatComponent p_i45020_3_) {
/* 17 */     this.field_146307_h = p_i45020_1_;
/* 18 */     this.field_146306_a = I18n.func_135052_a(p_i45020_2_, new Object[0]);
/* 19 */     this.field_146304_f = p_i45020_3_;
/*    */   }
/*    */   
/*    */   private List field_146305_g;
/*    */   private final GuiScreen field_146307_h;
/*    */   private static final String __OBFID = "CL_00000693";
/*    */   
/*    */   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {}
/*    */   
/*    */   public void func_73866_w_() {
/* 29 */     this.field_146292_n.clear();
/* 30 */     this.field_146292_n.add(new GuiButton(0, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 120 + 12, I18n.func_135052_a("gui.toMenu", new Object[0])));
/*    */     
/* 32 */     this.field_146305_g = this.field_146289_q.func_78271_c(this.field_146304_f.func_150254_d(), this.field_146294_l - 50);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_146284_a(GuiButton p_146284_1_) {
/* 37 */     if (p_146284_1_.field_146127_k == 0) {
/* 38 */       this.field_146297_k.func_147108_a(this.field_146307_h);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 44 */     func_146276_q_();
/*    */     
/* 46 */     func_73732_a(this.field_146289_q, this.field_146306_a, this.field_146294_l / 2, this.field_146295_m / 2 - 50, 11184810);
/*    */     
/* 48 */     int i = this.field_146295_m / 2 - 30;
/*    */     
/* 50 */     if (this.field_146305_g != null) {
/* 51 */       for (String str : this.field_146305_g) {
/* 52 */         func_73732_a(this.field_146289_q, str, this.field_146294_l / 2, i, 16777215);
/* 53 */         i += this.field_146289_q.field_78288_b;
/*    */       } 
/*    */     }
/*    */     
/* 57 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiDisconnected.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */