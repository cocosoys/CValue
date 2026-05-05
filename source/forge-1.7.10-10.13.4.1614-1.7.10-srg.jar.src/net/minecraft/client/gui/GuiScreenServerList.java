/*    */ package net.minecraft.client.gui;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.multiplayer.ServerData;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ import org.lwjgl.input.Keyboard;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GuiScreenServerList extends GuiScreen {
/*    */   private final GuiScreen field_146303_a;
/*    */   private final ServerData field_146301_f;
/*    */   
/*    */   public GuiScreenServerList(GuiScreen p_i1031_1_, ServerData p_i1031_2_) {
/* 15 */     this.field_146303_a = p_i1031_1_;
/* 16 */     this.field_146301_f = p_i1031_2_;
/*    */   }
/*    */   private GuiTextField field_146302_g; private static final String __OBFID = "CL_00000692";
/*    */   
/*    */   public void func_73876_c() {
/* 21 */     this.field_146302_g.func_146178_a();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_73866_w_() {
/* 27 */     Keyboard.enableRepeatEvents(true);
/* 28 */     this.field_146292_n.clear();
/* 29 */     this.field_146292_n.add(new GuiButton(0, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 96 + 12, I18n.func_135052_a("selectServer.select", new Object[0])));
/* 30 */     this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 120 + 12, I18n.func_135052_a("gui.cancel", new Object[0])));
/*    */     
/* 32 */     this.field_146302_g = new GuiTextField(this.field_146289_q, this.field_146294_l / 2 - 100, 116, 200, 20);
/* 33 */     this.field_146302_g.func_146203_f(128);
/* 34 */     this.field_146302_g.func_146195_b(true);
/* 35 */     this.field_146302_g.func_146180_a(this.field_146297_k.field_71474_y.field_74332_R);
/*    */     
/* 37 */     ((GuiButton)this.field_146292_n.get(0)).field_146124_l = (this.field_146302_g.func_146179_b().length() > 0 && (this.field_146302_g.func_146179_b().split(":")).length > 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_146281_b() {
/* 42 */     Keyboard.enableRepeatEvents(false);
/* 43 */     this.field_146297_k.field_71474_y.field_74332_R = this.field_146302_g.func_146179_b();
/* 44 */     this.field_146297_k.field_71474_y.func_74303_b();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_146284_a(GuiButton p_146284_1_) {
/* 49 */     if (!p_146284_1_.field_146124_l)
/* 50 */       return;  if (p_146284_1_.field_146127_k == 1) {
/* 51 */       this.field_146303_a.func_73878_a(false, 0);
/* 52 */     } else if (p_146284_1_.field_146127_k == 0) {
/* 53 */       this.field_146301_f.field_78845_b = this.field_146302_g.func_146179_b();
/* 54 */       this.field_146303_a.func_73878_a(true, 0);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
/* 60 */     if (this.field_146302_g.func_146201_a(p_73869_1_, p_73869_2_)) {
/* 61 */       ((GuiButton)this.field_146292_n.get(0)).field_146124_l = (this.field_146302_g.func_146179_b().length() > 0 && (this.field_146302_g.func_146179_b().split(":")).length > 0);
/* 62 */     } else if (p_73869_2_ == 28 || p_73869_2_ == 156) {
/* 63 */       func_146284_a(this.field_146292_n.get(0));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
/* 69 */     super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
/*    */     
/* 71 */     this.field_146302_g.func_146192_a(p_73864_1_, p_73864_2_, p_73864_3_);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 77 */     func_146276_q_();
/*    */     
/* 79 */     func_73732_a(this.field_146289_q, I18n.func_135052_a("selectServer.direct", new Object[0]), this.field_146294_l / 2, 20, 16777215);
/* 80 */     func_73731_b(this.field_146289_q, I18n.func_135052_a("addServer.enterIp", new Object[0]), this.field_146294_l / 2 - 100, 100, 10526880);
/*    */     
/* 82 */     this.field_146302_g.func_146194_f();
/*    */     
/* 84 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiScreenServerList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */