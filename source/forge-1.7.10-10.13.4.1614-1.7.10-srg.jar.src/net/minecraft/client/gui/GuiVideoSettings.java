/*    */ package net.minecraft.client.gui;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.OpenGlHelper;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ import net.minecraft.client.settings.GameSettings;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GuiVideoSettings extends GuiScreen {
/*    */   private GuiScreen field_146498_f;
/* 12 */   protected String field_146500_a = "Video Settings";
/*    */   
/*    */   private GameSettings field_146499_g;
/*    */   private GuiListExtended field_146501_h;
/* 16 */   private static final GameSettings.Options[] field_146502_i = new GameSettings.Options[] { GameSettings.Options.GRAPHICS, GameSettings.Options.RENDER_DISTANCE, GameSettings.Options.AMBIENT_OCCLUSION, GameSettings.Options.FRAMERATE_LIMIT, GameSettings.Options.ANAGLYPH, GameSettings.Options.VIEW_BOBBING, GameSettings.Options.GUI_SCALE, GameSettings.Options.ADVANCED_OPENGL, GameSettings.Options.GAMMA, GameSettings.Options.RENDER_CLOUDS, GameSettings.Options.PARTICLES, GameSettings.Options.USE_FULLSCREEN, GameSettings.Options.ENABLE_VSYNC, GameSettings.Options.MIPMAP_LEVELS, GameSettings.Options.ANISOTROPIC_FILTERING };
/*    */ 
/*    */   
/*    */   private static final String __OBFID = "CL_00000718";
/*    */ 
/*    */   
/*    */   public GuiVideoSettings(GuiScreen p_i1062_1_, GameSettings p_i1062_2_) {
/* 23 */     this.field_146498_f = p_i1062_1_;
/* 24 */     this.field_146499_g = p_i1062_2_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_73866_w_() {
/* 29 */     this.field_146500_a = I18n.func_135052_a("options.videoTitle", new Object[0]);
/* 30 */     this.field_146292_n.clear();
/*    */     
/* 32 */     this.field_146292_n.add(new GuiButton(200, this.field_146294_l / 2 - 100, this.field_146295_m - 27, I18n.func_135052_a("gui.done", new Object[0])));
/*    */     
/* 34 */     if (OpenGlHelper.field_153197_d) {
/* 35 */       this.field_146501_h = new GuiOptionsRowList(this.field_146297_k, this.field_146294_l, this.field_146295_m, 32, this.field_146295_m - 32, 25, field_146502_i);
/*    */     } else {
/* 37 */       GameSettings.Options[] arrayOfOptions = new GameSettings.Options[field_146502_i.length - 1];
/* 38 */       byte b = 0;
/* 39 */       for (GameSettings.Options options : field_146502_i) {
/* 40 */         if (options != GameSettings.Options.ADVANCED_OPENGL) {
/*    */ 
/*    */           
/* 43 */           arrayOfOptions[b] = options;
/* 44 */           b++;
/*    */         } 
/* 46 */       }  this.field_146501_h = new GuiOptionsRowList(this.field_146297_k, this.field_146294_l, this.field_146295_m, 32, this.field_146295_m - 32, 25, arrayOfOptions);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_146284_a(GuiButton p_146284_1_) {
/* 52 */     if (!p_146284_1_.field_146124_l)
/*    */       return; 
/* 54 */     if (p_146284_1_.field_146127_k == 200) {
/* 55 */       this.field_146297_k.field_71474_y.func_74303_b();
/* 56 */       this.field_146297_k.func_147108_a(this.field_146498_f);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
/* 62 */     int i = this.field_146499_g.field_74335_Z;
/*    */     
/* 64 */     super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
/* 65 */     this.field_146501_h.func_148179_a(p_73864_1_, p_73864_2_, p_73864_3_);
/*    */     
/* 67 */     if (this.field_146499_g.field_74335_Z != i) {
/* 68 */       ScaledResolution scaledResolution = new ScaledResolution(this.field_146297_k, this.field_146297_k.field_71443_c, this.field_146297_k.field_71440_d);
/* 69 */       int j = scaledResolution.func_78326_a();
/* 70 */       int k = scaledResolution.func_78328_b();
/* 71 */       func_146280_a(this.field_146297_k, j, k);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_146286_b(int p_146286_1_, int p_146286_2_, int p_146286_3_) {
/* 77 */     int i = this.field_146499_g.field_74335_Z;
/*    */     
/* 79 */     super.func_146286_b(p_146286_1_, p_146286_2_, p_146286_3_);
/* 80 */     this.field_146501_h.func_148181_b(p_146286_1_, p_146286_2_, p_146286_3_);
/*    */     
/* 82 */     if (this.field_146499_g.field_74335_Z != i) {
/* 83 */       ScaledResolution scaledResolution = new ScaledResolution(this.field_146297_k, this.field_146297_k.field_71443_c, this.field_146297_k.field_71440_d);
/* 84 */       int j = scaledResolution.func_78326_a();
/* 85 */       int k = scaledResolution.func_78328_b();
/* 86 */       func_146280_a(this.field_146297_k, j, k);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 92 */     func_146276_q_();
/* 93 */     this.field_146501_h.func_148128_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*    */     
/* 95 */     func_73732_a(this.field_146289_q, this.field_146500_a, this.field_146294_l / 2, 5, 16777215);
/*    */     
/* 97 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiVideoSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */