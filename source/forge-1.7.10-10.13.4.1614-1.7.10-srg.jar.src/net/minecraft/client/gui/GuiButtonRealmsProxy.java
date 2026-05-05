/*    */ package net.minecraft.client.gui;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.realms.RealmsButton;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GuiButtonRealmsProxy extends GuiButton {
/*    */   private RealmsButton field_154318_o;
/*    */   
/*    */   public GuiButtonRealmsProxy(RealmsButton p_i1089_1_, int p_i1089_2_, int p_i1089_3_, int p_i1089_4_, String p_i1089_5_) {
/* 12 */     super(p_i1089_2_, p_i1089_3_, p_i1089_4_, p_i1089_5_);
/* 13 */     this.field_154318_o = p_i1089_1_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001848";
/*    */   public GuiButtonRealmsProxy(RealmsButton p_i1090_1_, int p_i1090_2_, int p_i1090_3_, int p_i1090_4_, String p_i1090_5_, int p_i1090_6_, int p_i1090_7_) {
/* 17 */     super(p_i1090_2_, p_i1090_3_, p_i1090_4_, p_i1090_6_, p_i1090_7_, p_i1090_5_);
/* 18 */     this.field_154318_o = p_i1090_1_;
/*    */   }
/*    */   
/*    */   public int func_154314_d() {
/* 22 */     return this.field_146127_k;
/*    */   }
/*    */   
/*    */   public boolean func_154315_e() {
/* 26 */     return this.field_146124_l;
/*    */   }
/*    */   
/*    */   public void func_154313_b(boolean p_154313_1_) {
/* 30 */     this.field_146124_l = p_154313_1_;
/*    */   }
/*    */   
/*    */   public void func_154311_a(String p_154311_1_) {
/* 34 */     this.field_146126_j = p_154311_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_146117_b() {
/* 39 */     return super.func_146117_b();
/*    */   }
/*    */   
/*    */   public int func_154316_f() {
/* 43 */     return this.field_146129_i;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_146116_c(Minecraft p_146116_1_, int p_146116_2_, int p_146116_3_) {
/* 48 */     if (super.func_146116_c(p_146116_1_, p_146116_2_, p_146116_3_)) {
/* 49 */       this.field_154318_o.clicked(p_146116_2_, p_146116_3_);
/*    */     }
/* 51 */     return super.func_146116_c(p_146116_1_, p_146116_2_, p_146116_3_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_146118_a(int p_146118_1_, int p_146118_2_) {
/* 56 */     this.field_154318_o.released(p_146118_1_, p_146118_2_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_146119_b(Minecraft p_146119_1_, int p_146119_2_, int p_146119_3_) {
/* 61 */     this.field_154318_o.renderBg(p_146119_2_, p_146119_3_);
/*    */   }
/*    */   
/*    */   public RealmsButton func_154317_g() {
/* 65 */     return this.field_154318_o;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_146114_a(boolean p_146114_1_) {
/* 70 */     return this.field_154318_o.getYImage(p_146114_1_);
/*    */   }
/*    */   
/*    */   public int func_154312_c(boolean p_154312_1_) {
/* 74 */     return super.func_146114_a(p_154312_1_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiButtonRealmsProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */