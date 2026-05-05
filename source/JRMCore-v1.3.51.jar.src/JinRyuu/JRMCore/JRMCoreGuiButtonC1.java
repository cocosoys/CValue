/*    */ package JinRyuu.JRMCore;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class JRMCoreGuiButtonC1
/*    */   extends GuiButton {
/*    */   private int bgCol;
/*    */   
/*    */   public int getBgCol() {
/* 15 */     return this.bgCol;
/*    */   }
/*    */   
/*    */   public JRMCoreGuiButtonC1(int par1, int par2, int par3, int par4, int par5, String par6Str) {
/* 19 */     super(par1, par2, par3, par4, par5, par6Str);
/*    */   }
/*    */ 
/*    */   
/*    */   public JRMCoreGuiButtonC1(int par1, int par2, int par3, int par4, int par5, String par6Str, int par7) {
/* 24 */     super(par1, par2, par3, par4, par5, par6Str);
/* 25 */     this.bgCol = par7;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_146112_a(Minecraft par1Minecraft, int par2, int par3) {
/* 31 */     if (this.field_146125_m) {
/*    */       
/* 33 */       FontRenderer var4 = par1Minecraft.field_71466_p;
/* 34 */       ResourceLocation txx = new ResourceLocation(JRMCoreGuiScreen.button1);
/* 35 */       par1Minecraft.func_110434_K().func_110577_a(txx);
/*    */       
/* 37 */       this.field_146123_n = (par2 >= this.field_146128_h && par3 >= this.field_146129_i && par2 < this.field_146128_h + this.field_146120_f && par3 < this.field_146129_i + this.field_146121_g);
/* 38 */       int var5 = func_146114_a(this.field_146123_n);
/*    */       
/* 40 */       int j = 16449280;
/* 41 */       float h2 = (j >> 16 & 0xFF) / 255.0F;
/* 42 */       float h3 = (j >> 8 & 0xFF) / 255.0F;
/* 43 */       float h4 = (j & 0xFF) / 255.0F;
/* 44 */       float h1 = 1.0F;
/* 45 */       if (var5 == 2) {
/* 46 */         int r = (int)(h2 * 254.0F);
/* 47 */         int g = (int)(h3 * 254.0F);
/* 48 */         int b = (int)(h4 * 254.0F);
/* 49 */         float[] hsb = Color.RGBtoHSB(r, g, b, null);
/* 50 */         float hue = hsb[0];
/* 51 */         float saturation = 0.33F;
/* 52 */         float brightness = hsb[2];
/* 53 */         int rgb = Color.HSBtoRGB(hue, saturation, brightness);
/* 54 */         h2 = (rgb >> 16 & 0xFF) / 255.0F;
/* 55 */         h3 = (rgb >> 8 & 0xFF) / 255.0F;
/* 56 */         h4 = (rgb & 0xFF) / 255.0F;
/*    */       } 
/* 58 */       GL11.glColor3f(h1 * h2, h1 * h3, h1 * h4);
/* 59 */       func_73729_b(this.field_146128_h, this.field_146129_i, 0, 0 + var5 * 1, this.field_146120_f, this.field_146121_g);
/*    */ 
/*    */       
/* 62 */       h2 = (this.bgCol >> 16 & 0xFF) / 255.0F;
/* 63 */       h3 = (this.bgCol >> 8 & 0xFF) / 255.0F;
/* 64 */       h4 = (this.bgCol & 0xFF) / 255.0F;
/* 65 */       h1 = 1.0F;
/* 66 */       GL11.glColor3f(h1 * h2, h1 * h3, h1 * h4);
/*    */       
/* 68 */       func_73729_b(this.field_146128_h + ((var5 == 2) ? 1 : 0), this.field_146129_i + ((var5 == 2) ? 1 : 0), 0, 0, this.field_146120_f - ((var5 == 2) ? 2 : 0), this.field_146121_g - ((var5 == 2) ? 2 : 0));
/*    */ 
/*    */       
/* 71 */       func_146119_b(par1Minecraft, par2, par3);
/* 72 */       int var6 = 14737632;
/*    */       
/* 74 */       if (!this.field_146124_l) {
/*    */         
/* 76 */         var6 = -6250336;
/*    */       }
/* 78 */       else if (this.field_146123_n) {
/*    */         
/* 80 */         var6 = 16777120;
/*    */       } 
/*    */       
/* 83 */       func_73732_a(var4, this.field_146126_j, this.field_146128_h + this.field_146120_f / 2, this.field_146129_i + (this.field_146121_g - 8) / 2, var6);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreGuiButtonC1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */