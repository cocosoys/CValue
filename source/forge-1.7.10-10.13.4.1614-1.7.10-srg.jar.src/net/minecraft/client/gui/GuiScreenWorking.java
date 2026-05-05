/*    */ package net.minecraft.client.gui;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GuiScreenWorking extends GuiScreen implements IProgressUpdate {
/*  6 */   private String field_146591_a = "";
/*  7 */   private String field_146589_f = "";
/*    */   private int field_146590_g;
/*    */   private boolean field_146592_h;
/*    */   private static final String __OBFID = "CL_00000707";
/*    */   
/*    */   public void func_73720_a(String p_73720_1_) {
/* 13 */     func_73721_b(p_73720_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_73721_b(String p_73721_1_) {
/* 18 */     this.field_146591_a = p_73721_1_;
/*    */     
/* 20 */     func_73719_c("Working...");
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_73719_c(String p_73719_1_) {
/* 25 */     this.field_146589_f = p_73719_1_;
/*    */     
/* 27 */     func_73718_a(0);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_73718_a(int p_73718_1_) {
/* 32 */     this.field_146590_g = p_73718_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_146586_a() {
/* 37 */     this.field_146592_h = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 42 */     if (this.field_146592_h) {
/* 43 */       this.field_146297_k.func_147108_a(null);
/*    */       
/*    */       return;
/*    */     } 
/* 47 */     func_146276_q_();
/*    */     
/* 49 */     func_73732_a(this.field_146289_q, this.field_146591_a, this.field_146294_l / 2, 70, 16777215);
/* 50 */     func_73732_a(this.field_146289_q, this.field_146589_f + " " + this.field_146590_g + "%", this.field_146294_l / 2, 90, 16777215);
/*    */     
/* 52 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiScreenWorking.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */