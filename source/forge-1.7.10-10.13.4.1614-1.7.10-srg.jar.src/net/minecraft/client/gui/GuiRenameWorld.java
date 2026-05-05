/*    */ package net.minecraft.client.gui;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ import net.minecraft.world.storage.ISaveFormat;
/*    */ import net.minecraft.world.storage.WorldInfo;
/*    */ import org.lwjgl.input.Keyboard;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GuiRenameWorld extends GuiScreen {
/*    */   private GuiScreen field_146585_a;
/*    */   private GuiTextField field_146583_f;
/*    */   
/*    */   public GuiRenameWorld(GuiScreen p_i1050_1_, String p_i1050_2_) {
/* 16 */     this.field_146585_a = p_i1050_1_;
/* 17 */     this.field_146584_g = p_i1050_2_;
/*    */   }
/*    */   private final String field_146584_g; private static final String __OBFID = "CL_00000709";
/*    */   
/*    */   public void func_73876_c() {
/* 22 */     this.field_146583_f.func_146178_a();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_73866_w_() {
/* 28 */     Keyboard.enableRepeatEvents(true);
/* 29 */     this.field_146292_n.clear();
/* 30 */     this.field_146292_n.add(new GuiButton(0, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 96 + 12, I18n.func_135052_a("selectWorld.renameButton", new Object[0])));
/* 31 */     this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 120 + 12, I18n.func_135052_a("gui.cancel", new Object[0])));
/*    */     
/* 33 */     ISaveFormat iSaveFormat = this.field_146297_k.func_71359_d();
/* 34 */     WorldInfo worldInfo = iSaveFormat.func_75803_c(this.field_146584_g);
/* 35 */     String str = worldInfo.func_76065_j();
/*    */     
/* 37 */     this.field_146583_f = new GuiTextField(this.field_146289_q, this.field_146294_l / 2 - 100, 60, 200, 20);
/* 38 */     this.field_146583_f.func_146195_b(true);
/* 39 */     this.field_146583_f.func_146180_a(str);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_146281_b() {
/* 44 */     Keyboard.enableRepeatEvents(false);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_146284_a(GuiButton p_146284_1_) {
/* 49 */     if (!p_146284_1_.field_146124_l)
/* 50 */       return;  if (p_146284_1_.field_146127_k == 1) {
/* 51 */       this.field_146297_k.func_147108_a(this.field_146585_a);
/* 52 */     } else if (p_146284_1_.field_146127_k == 0) {
/*    */       
/* 54 */       ISaveFormat iSaveFormat = this.field_146297_k.func_71359_d();
/* 55 */       iSaveFormat.func_75806_a(this.field_146584_g, this.field_146583_f.func_146179_b().trim());
/*    */       
/* 57 */       this.field_146297_k.func_147108_a(this.field_146585_a);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
/* 63 */     this.field_146583_f.func_146201_a(p_73869_1_, p_73869_2_);
/* 64 */     ((GuiButton)this.field_146292_n.get(0)).field_146124_l = (this.field_146583_f.func_146179_b().trim().length() > 0);
/*    */     
/* 66 */     if (p_73869_2_ == 28 || p_73869_2_ == 156) {
/* 67 */       func_146284_a(this.field_146292_n.get(0));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
/* 73 */     super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
/*    */     
/* 75 */     this.field_146583_f.func_146192_a(p_73864_1_, p_73864_2_, p_73864_3_);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 81 */     func_146276_q_();
/*    */     
/* 83 */     func_73732_a(this.field_146289_q, I18n.func_135052_a("selectWorld.renameTitle", new Object[0]), this.field_146294_l / 2, 20, 16777215);
/* 84 */     func_73731_b(this.field_146289_q, I18n.func_135052_a("selectWorld.enterName", new Object[0]), this.field_146294_l / 2 - 100, 47, 10526880);
/*    */     
/* 86 */     this.field_146583_f.func_146194_f();
/*    */     
/* 88 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiRenameWorld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */