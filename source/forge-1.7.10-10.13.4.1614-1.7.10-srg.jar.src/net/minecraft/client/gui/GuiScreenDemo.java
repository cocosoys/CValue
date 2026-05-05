/*    */ package net.minecraft.client.gui;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.net.URI;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ import net.minecraft.client.settings.GameSettings;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GuiScreenDemo extends GuiScreen {
/* 15 */   private static final Logger field_146349_a = LogManager.getLogger();
/*    */ 
/*    */ 
/*    */   
/* 19 */   private static final ResourceLocation field_146348_f = new ResourceLocation("textures/gui/demo_background.png");
/*    */   private static final String __OBFID = "CL_00000691";
/*    */   
/*    */   public void func_73866_w_() {
/* 23 */     this.field_146292_n.clear();
/*    */     
/* 25 */     byte b = -16;
/*    */     
/* 27 */     this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 2 - 116, this.field_146295_m / 2 + 62 + b, 114, 20, I18n.func_135052_a("demo.help.buy", new Object[0])));
/* 28 */     this.field_146292_n.add(new GuiButton(2, this.field_146294_l / 2 + 2, this.field_146295_m / 2 + 62 + b, 114, 20, I18n.func_135052_a("demo.help.later", new Object[0])));
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_146284_a(GuiButton p_146284_1_) {
/* 33 */     switch (p_146284_1_.field_146127_k) {
/*    */       case 2:
/* 35 */         this.field_146297_k.func_147108_a(null);
/* 36 */         this.field_146297_k.func_71381_h();
/*    */         break;
/*    */       case 1:
/* 39 */         p_146284_1_.field_146124_l = false;
/*    */         try {
/* 41 */           Class<?> clazz = Class.forName("java.awt.Desktop");
/* 42 */           Object object = clazz.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
/* 43 */           clazz.getMethod("browse", new Class[] { URI.class }).invoke(object, new Object[] { new URI("http://www.minecraft.net/store?source=demo") });
/* 44 */         } catch (Throwable throwable) {
/* 45 */           field_146349_a.error("Couldn't open link", throwable);
/*    */         } 
/*    */         break;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_73876_c() {
/* 53 */     super.func_73876_c();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_146276_q_() {
/* 58 */     super.func_146276_q_();
/*    */     
/* 60 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 61 */     this.field_146297_k.func_110434_K().func_110577_a(field_146348_f);
/* 62 */     int i = (this.field_146294_l - 248) / 2;
/* 63 */     int j = (this.field_146295_m - 166) / 2;
/* 64 */     func_73729_b(i, j, 0, 0, 248, 166);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 69 */     func_146276_q_();
/*    */     
/* 71 */     int i = (this.field_146294_l - 248) / 2 + 10;
/*    */     
/* 73 */     int j = (this.field_146295_m - 166) / 2 + 8;
/*    */     
/* 75 */     this.field_146289_q.func_78276_b(I18n.func_135052_a("demo.help.title", new Object[0]), i, j, 2039583);
/* 76 */     j += 12;
/*    */     
/* 78 */     GameSettings gameSettings = this.field_146297_k.field_71474_y;
/*    */     
/* 80 */     this.field_146289_q.func_78276_b(I18n.func_135052_a("demo.help.movementShort", new Object[] { GameSettings.func_74298_c(gameSettings.field_74351_w.func_151463_i()), GameSettings.func_74298_c(gameSettings.field_74370_x.func_151463_i()), GameSettings.func_74298_c(gameSettings.field_74368_y.func_151463_i()), GameSettings.func_74298_c(gameSettings.field_74366_z.func_151463_i()) }), i, j, 5197647);
/*    */     
/* 82 */     this.field_146289_q.func_78276_b(I18n.func_135052_a("demo.help.movementMouse", new Object[0]), i, j + 12, 5197647);
/*    */     
/* 84 */     this.field_146289_q.func_78276_b(I18n.func_135052_a("demo.help.jump", new Object[] { GameSettings.func_74298_c(gameSettings.field_74314_A.func_151463_i()) }), i, j + 24, 5197647);
/*    */     
/* 86 */     this.field_146289_q.func_78276_b(I18n.func_135052_a("demo.help.inventory", new Object[] { GameSettings.func_74298_c(gameSettings.field_151445_Q.func_151463_i()) }), i, j + 36, 5197647);
/*    */     
/* 88 */     this.field_146289_q.func_78279_b(I18n.func_135052_a("demo.help.fullWrapped", new Object[0]), i, j + 68, 218, 2039583);
/*    */     
/* 90 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiScreenDemo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */