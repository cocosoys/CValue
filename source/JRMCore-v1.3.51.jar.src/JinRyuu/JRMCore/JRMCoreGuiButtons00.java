/*    */ package JinRyuu.JRMCore;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ public class JRMCoreGuiButtons00
/*    */   extends GuiButton
/*    */ {
/*    */   public int col;
/*    */   
/*    */   public JRMCoreGuiButtons00(int id, int x, int y, int height, int width, String text, int color) {
/* 17 */     super(id, x, y, height, width, text);
/* 18 */     this.col = color;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_146112_a(Minecraft par1Minecraft, int par2, int par3) {
/* 24 */     if (this.field_146125_m) {
/*    */       
/* 26 */       this.field_146123_n = (par2 >= this.field_146128_h && par3 >= this.field_146129_i && par2 < this.field_146128_h + this.field_146120_f && par3 < this.field_146129_i + this.field_146121_g);
/* 27 */       int var5 = func_146114_a(this.field_146123_n);
/*    */       
/* 29 */       int j = (this.col == 0) ? 16449280 : this.col;
/* 30 */       FontRenderer var4 = par1Minecraft.field_71466_p;
/* 31 */       ResourceLocation txx = new ResourceLocation(JRMCoreGuiScreen.button1);
/* 32 */       par1Minecraft.func_110434_K().func_110577_a(txx);
/* 33 */       float h2 = (j >> 16 & 0xFF) / 255.0F;
/* 34 */       float h3 = (j >> 8 & 0xFF) / 255.0F;
/* 35 */       float h4 = (j & 0xFF) / 255.0F;
/* 36 */       float h1 = 1.0F;
/* 37 */       if (var5 == 2) {
/* 38 */         int r = (int)(h2 * 254.0F);
/* 39 */         int g = (int)(h3 * 254.0F);
/* 40 */         int b = (int)(h4 * 254.0F);
/* 41 */         float[] hsb = Color.RGBtoHSB(r, g, b, null);
/* 42 */         float hue = hsb[0];
/* 43 */         float saturation = 0.33F;
/* 44 */         float brightness = hsb[2];
/* 45 */         int rgb = Color.HSBtoRGB(hue, saturation, brightness);
/* 46 */         h2 = (rgb >> 16 & 0xFF) / 255.0F;
/* 47 */         h3 = (rgb >> 8 & 0xFF) / 255.0F;
/* 48 */         h4 = (rgb & 0xFF) / 255.0F;
/*    */       } 
/* 50 */       GL11.glColor3f(h1 * h2, h1 * h3, h1 * h4);
/*    */       
/* 52 */       func_73729_b(this.field_146128_h, this.field_146129_i, 0, 46 + var5 * 20, this.field_146120_f / 2, this.field_146121_g);
/* 53 */       func_73729_b(this.field_146128_h + this.field_146120_f / 2, this.field_146129_i, 200 - this.field_146120_f / 2, 46 + var5 * 20, this.field_146120_f / 2, this.field_146121_g);
/* 54 */       func_146119_b(par1Minecraft, par2, par3);
/* 55 */       int var6 = 14737632;
/*    */       
/* 57 */       if (!this.field_146124_l) {
/*    */         
/* 59 */         var6 = -6250336;
/*    */       }
/* 61 */       else if (this.field_146123_n) {
/*    */         
/* 63 */         var6 = 16777120;
/*    */       } 
/*    */ 
/*    */ 
/*    */       
/* 68 */       func_73732_a(var4, this.field_146126_j, this.field_146128_h + this.field_146120_f / 2, this.field_146129_i + (this.field_146121_g - 8) / 2, var6);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreGuiButtons00.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */