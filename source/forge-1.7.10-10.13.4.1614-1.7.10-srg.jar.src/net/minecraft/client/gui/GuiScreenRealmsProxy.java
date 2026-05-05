/*     */ package net.minecraft.client.gui;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.realms.RealmsButton;
/*     */ import net.minecraft.realms.RealmsScreen;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiScreenRealmsProxy
/*     */   extends GuiScreen
/*     */ {
/*     */   private RealmsScreen field_154330_a;
/*     */   private static final String __OBFID = "CL_00001847";
/*     */   
/*     */   public GuiScreenRealmsProxy(RealmsScreen p_i1087_1_) {
/*  27 */     this.field_154330_a = p_i1087_1_;
/*  28 */     this.field_146292_n = Collections.synchronizedList(new ArrayList());
/*     */   }
/*     */   
/*     */   public RealmsScreen func_154321_a() {
/*  32 */     return this.field_154330_a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/*  41 */     this.field_154330_a.init();
/*  42 */     super.func_73866_w_();
/*     */   }
/*     */   
/*     */   public void func_154325_a(String p_154325_1_, int p_154325_2_, int p_154325_3_, int p_154325_4_) {
/*  46 */     func_73732_a(this.field_146289_q, p_154325_1_, p_154325_2_, p_154325_3_, p_154325_4_);
/*     */   }
/*     */   
/*     */   public void func_154322_b(String p_154322_1_, int p_154322_2_, int p_154322_3_, int p_154322_4_) {
/*  50 */     func_73731_b(this.field_146289_q, p_154322_1_, p_154322_2_, p_154322_3_, p_154322_4_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73729_b(int p_73729_1_, int p_73729_2_, int p_73729_3_, int p_73729_4_, int p_73729_5_, int p_73729_6_) {
/*  56 */     this.field_154330_a.blit(p_73729_1_, p_73729_2_, p_73729_3_, p_73729_4_, p_73729_5_, p_73729_6_);
/*  57 */     super.func_73729_b(p_73729_1_, p_73729_2_, p_73729_3_, p_73729_4_, p_73729_5_, p_73729_6_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73733_a(int p_73733_1_, int p_73733_2_, int p_73733_3_, int p_73733_4_, int p_73733_5_, int p_73733_6_) {
/*  70 */     super.func_73733_a(p_73733_1_, p_73733_2_, p_73733_3_, p_73733_4_, p_73733_5_, p_73733_6_);
/*     */   }
/*     */   
/*     */   public void func_146276_q_() {
/*  74 */     super.func_146276_q_();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_73868_f() {
/*  79 */     return super.func_73868_f();
/*     */   }
/*     */   
/*     */   public void func_146270_b(int p_146270_1_) {
/*  83 */     super.func_146270_b(p_146270_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/*  88 */     this.field_154330_a.render(p_73863_1_, p_73863_2_, p_73863_3_);
/*     */   }
/*     */   
/*     */   public void func_146285_a(ItemStack p_146285_1_, int p_146285_2_, int p_146285_3_) {
/*  92 */     super.func_146285_a(p_146285_1_, p_146285_2_, p_146285_3_);
/*     */   }
/*     */   
/*     */   public void func_146279_a(String p_146279_1_, int p_146279_2_, int p_146279_3_) {
/*  96 */     super.func_146279_a(p_146279_1_, p_146279_2_, p_146279_3_);
/*     */   }
/*     */   
/*     */   public void func_146283_a(List p_146283_1_, int p_146283_2_, int p_146283_3_) {
/* 100 */     super.func_146283_a(p_146283_1_, p_146283_2_, p_146283_3_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73876_c() {
/* 119 */     this.field_154330_a.tick();
/* 120 */     super.func_73876_c();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_154329_h() {
/* 137 */     return this.field_146289_q.field_78288_b;
/*     */   }
/*     */   
/*     */   public int func_154326_c(String p_154326_1_) {
/* 141 */     return this.field_146289_q.func_78256_a(p_154326_1_);
/*     */   }
/*     */   
/*     */   public void func_154319_c(String p_154319_1_, int p_154319_2_, int p_154319_3_, int p_154319_4_) {
/* 145 */     this.field_146289_q.func_78261_a(p_154319_1_, p_154319_2_, p_154319_3_, p_154319_4_);
/*     */   }
/*     */   
/*     */   public List func_154323_a(String p_154323_1_, int p_154323_2_) {
/* 149 */     return this.field_146289_q.func_78271_c(p_154323_1_, p_154323_2_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void func_146284_a(GuiButton p_146284_1_) {
/* 160 */     this.field_154330_a.buttonClicked(((GuiButtonRealmsProxy)p_146284_1_).func_154317_g());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_154324_i() {
/* 175 */     this.field_146292_n.clear();
/*     */   }
/*     */   
/*     */   public void func_154327_a(RealmsButton p_154327_1_) {
/* 179 */     this.field_146292_n.add(p_154327_1_.getProxy());
/*     */   }
/*     */   
/*     */   public List func_154320_j() {
/* 183 */     ArrayList<RealmsButton> arrayList = new ArrayList(this.field_146292_n.size());
/* 184 */     for (GuiButton guiButton : this.field_146292_n) {
/* 185 */       arrayList.add(((GuiButtonRealmsProxy)guiButton).func_154317_g());
/*     */     }
/* 187 */     return arrayList;
/*     */   }
/*     */   
/*     */   public void func_154328_b(RealmsButton p_154328_1_) {
/* 191 */     this.field_146292_n.remove(p_154328_1_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
/* 209 */     this.field_154330_a.mouseClicked(p_73864_1_, p_73864_2_, p_73864_3_);
/* 210 */     super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146274_d() {
/* 215 */     this.field_154330_a.mouseEvent();
/* 216 */     super.func_146274_d();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146282_l() {
/* 221 */     this.field_154330_a.keyboardEvent();
/* 222 */     super.func_146282_l();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146286_b(int p_146286_1_, int p_146286_2_, int p_146286_3_) {
/* 227 */     this.field_154330_a.mouseReleased(p_146286_1_, p_146286_2_, p_146286_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146273_a(int p_146273_1_, int p_146273_2_, int p_146273_3_, long p_146273_4_) {
/* 232 */     this.field_154330_a.mouseDragged(p_146273_1_, p_146273_2_, p_146273_3_, p_146273_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73869_a(char p_73869_1_, int p_73869_2_) {
/* 237 */     this.field_154330_a.keyPressed(p_73869_1_, p_73869_2_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73878_a(boolean p_73878_1_, int p_73878_2_) {
/* 243 */     this.field_154330_a.confirmResult(p_73878_1_, p_73878_2_);
/*     */   }
/*     */   
/*     */   public void func_146281_b() {
/* 247 */     this.field_154330_a.removed();
/* 248 */     super.func_146281_b();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiScreenRealmsProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */