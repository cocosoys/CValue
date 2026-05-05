/*    */ package JinRyuu.JRMCore;
/*    */ 
/*    */ import JinRyuu.JRMCore.client.minigame.MiniGame;
/*    */ import JinRyuu.JRMCore.server.config.core.JGConfigMiniGameConcentration;
/*    */ import java.awt.Color;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.input.Mouse;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ public class JRMCoreGuiButtonsMG0
/*    */   extends GuiButton
/*    */ {
/*    */   public static boolean clicked = false;
/*    */   
/*    */   public JRMCoreGuiButtonsMG0(int par1, int par2, int par3, int par4, int par5, String par6Str, Object c) {
/* 20 */     super(par1, par2, par3, par4, par5, par6Str);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_146118_a(int p_146118_1_, int p_146118_2_) {
/* 25 */     super.func_146118_a(p_146118_1_, p_146118_2_);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_146116_c(Minecraft p_146116_1_, int p_146116_2_, int p_146116_3_) {
/* 31 */     clicked = super.func_146116_c(p_146116_1_, p_146116_2_, p_146116_3_);
/* 32 */     return clicked;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_146112_a(Minecraft par1Minecraft, int par2, int par3) {
/* 38 */     if (JGConfigMiniGameConcentration.ConstantClickOn) {
/*    */       
/* 40 */       if (clicked)
/*    */       {
/* 42 */         if (!Mouse.isButtonDown(0)) clicked = !clicked;
/*    */       
/*    */       }
/*    */     } else {
/*    */       
/* 47 */       clicked = false;
/*    */     } 
/*    */     
/* 50 */     if (this.field_146125_m) {
/*    */       
/* 52 */       this.field_146123_n = (par2 >= this.field_146128_h && par3 >= this.field_146129_i && par2 < this.field_146128_h + this.field_146120_f && par3 < this.field_146129_i + this.field_146121_g);
/* 53 */       int var5 = 0;
/*    */       
/* 55 */       int j = 16449280;
/* 56 */       FontRenderer var4 = par1Minecraft.field_71466_p;
/* 57 */       ResourceLocation txx = new ResourceLocation(MiniGame.training1);
/* 58 */       par1Minecraft.func_110434_K().func_110577_a(txx);
/* 59 */       float h2 = (j >> 16 & 0xFF) / 255.0F;
/* 60 */       float h3 = (j >> 8 & 0xFF) / 255.0F;
/* 61 */       float h4 = (j & 0xFF) / 255.0F;
/* 62 */       float h1 = 1.0F;
/* 63 */       if (var5 == 0) {
/* 64 */         int r = (int)(h2 * 254.0F);
/* 65 */         int g = (int)(h3 * 254.0F);
/* 66 */         int b = (int)(h4 * 254.0F);
/* 67 */         float[] hsb = Color.RGBtoHSB(r, g, b, null);
/* 68 */         float hue = hsb[0];
/* 69 */         float saturation = 0.33F;
/* 70 */         float brightness = hsb[2];
/* 71 */         int rgb = Color.HSBtoRGB(hue, saturation, brightness);
/* 72 */         h2 = (rgb >> 16 & 0xFF) / 255.0F;
/* 73 */         h3 = (rgb >> 8 & 0xFF) / 255.0F;
/* 74 */         h4 = (rgb & 0xFF) / 255.0F;
/*    */       } 
/* 76 */       GL11.glColor3f(h1 * h2, h1 * h3, h1 * h4);
/*    */       
/* 78 */       func_73729_b(this.field_146128_h, this.field_146129_i, 0, 0, this.field_146120_f / 2, this.field_146121_g);
/* 79 */       func_73729_b(this.field_146128_h + this.field_146120_f / 2, this.field_146129_i, 200 - this.field_146120_f / 2, 0, this.field_146120_f / 2, this.field_146121_g);
/* 80 */       func_146119_b(par1Minecraft, par2, par3);
/* 81 */       int var6 = 14737632;
/*    */       
/* 83 */       if (!this.field_146124_l) {
/*    */         
/* 85 */         var6 = -6250336;
/*    */       }
/* 87 */       else if (this.field_146123_n) {
/*    */         
/* 89 */         var6 = 16777120;
/*    */       } 
/*    */ 
/*    */ 
/*    */       
/* 94 */       func_73732_a(var4, this.field_146126_j, this.field_146128_h + this.field_146120_f / 2, this.field_146129_i + (this.field_146121_g - 8) / 2, var6);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreGuiButtonsMG0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */