/*    */ package net.minecraft.client.gui;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GuiConfirmOpenLink
/*    */   extends GuiYesNo
/*    */ {
/*    */   private final String field_146363_r;
/*    */   private final String field_146362_s;
/*    */   private final String field_146361_t;
/*    */   private boolean field_146360_u = true;
/*    */   private static final String __OBFID = "CL_00000683";
/*    */   
/*    */   public GuiConfirmOpenLink(GuiYesNoCallback p_i1084_1_, String p_i1084_2_, int p_i1084_3_, boolean p_i1084_4_) {
/* 19 */     super(p_i1084_1_, I18n.func_135052_a(p_i1084_4_ ? "chat.link.confirmTrusted" : "chat.link.confirm", new Object[0]), p_i1084_2_, p_i1084_3_);
/*    */     
/* 21 */     this.field_146352_g = I18n.func_135052_a(p_i1084_4_ ? "chat.link.open" : "gui.yes", new Object[0]);
/* 22 */     this.field_146356_h = I18n.func_135052_a(p_i1084_4_ ? "gui.cancel" : "gui.no", new Object[0]);
/* 23 */     this.field_146362_s = I18n.func_135052_a("chat.copy", new Object[0]);
/* 24 */     this.field_146363_r = I18n.func_135052_a("chat.link.warning", new Object[0]);
/* 25 */     this.field_146361_t = p_i1084_2_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_73866_w_() {
/* 30 */     this.field_146292_n.add(new GuiButton(0, this.field_146294_l / 3 - 83 + 0, this.field_146295_m / 6 + 96, 100, 20, this.field_146352_g));
/* 31 */     this.field_146292_n.add(new GuiButton(2, this.field_146294_l / 3 - 83 + 105, this.field_146295_m / 6 + 96, 100, 20, this.field_146362_s));
/* 32 */     this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 3 - 83 + 210, this.field_146295_m / 6 + 96, 100, 20, this.field_146356_h));
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_146284_a(GuiButton p_146284_1_) {
/* 37 */     if (p_146284_1_.field_146127_k == 2) {
/* 38 */       func_146359_e();
/*    */     }
/*    */     
/* 41 */     this.field_146355_a.func_73878_a((p_146284_1_.field_146127_k == 0), this.field_146357_i);
/*    */   }
/*    */   
/*    */   public void func_146359_e() {
/* 45 */     func_146275_d(this.field_146361_t);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 50 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*    */     
/* 52 */     if (this.field_146360_u) func_73732_a(this.field_146289_q, this.field_146363_r, this.field_146294_l / 2, 110, 16764108); 
/*    */   }
/*    */   
/*    */   public void func_146358_g() {
/* 56 */     this.field_146360_u = false;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiConfirmOpenLink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */