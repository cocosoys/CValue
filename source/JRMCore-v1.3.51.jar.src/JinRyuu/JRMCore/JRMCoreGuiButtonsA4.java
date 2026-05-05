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
/*    */ public class JRMCoreGuiButtonsA4
/*    */   extends GuiButton
/*    */ {
/*    */   private String string;
/*    */   private int type;
/*    */   public int col;
/*    */   
/*    */   public JRMCoreGuiButtonsA4(int par1, int par2, int par3, int width, int type, int c) {
/* 19 */     super(par1, par2, par3, width, 10, "");
/* 20 */     this.field_146120_f = width;
/* 21 */     this.string = "+";
/* 22 */     this.type = type;
/* 23 */     this.col = c;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_146112_a(Minecraft par1Minecraft, int par2, int par3) {
/* 29 */     if (this.field_146125_m) {
/*    */       
/* 31 */       this.field_146123_n = (par2 >= this.field_146128_h && par3 >= this.field_146129_i && par2 < this.field_146128_h + this.field_146120_f && par3 < this.field_146129_i + this.field_146121_g);
/* 32 */       int var5 = func_146114_a(this.field_146123_n);
/*    */       
/* 34 */       int j = (this.col == 0) ? 16449280 : this.col;
/* 35 */       FontRenderer var4 = par1Minecraft.field_71466_p;
/* 36 */       ResourceLocation txx = new ResourceLocation(JRMCoreGuiScreen.button1);
/* 37 */       par1Minecraft.func_110434_K().func_110577_a(txx);
/* 38 */       float h2 = (j >> 16 & 0xFF) / 255.0F;
/* 39 */       float h3 = (j >> 8 & 0xFF) / 255.0F;
/* 40 */       float h4 = (j & 0xFF) / 255.0F;
/* 41 */       float h1 = 1.0F;
/* 42 */       if (var5 == 2) {
/* 43 */         int r = (int)(h2 * 254.0F);
/* 44 */         int g = (int)(h3 * 254.0F);
/* 45 */         int b = (int)(h4 * 254.0F);
/* 46 */         float[] hsb = Color.RGBtoHSB(r, g, b, null);
/* 47 */         float hue = hsb[0];
/* 48 */         float saturation = 0.33F;
/* 49 */         float brightness = hsb[2];
/* 50 */         int rgb = Color.HSBtoRGB(hue, saturation, brightness);
/* 51 */         h2 = (rgb >> 16 & 0xFF) / 255.0F;
/* 52 */         h3 = (rgb >> 8 & 0xFF) / 255.0F;
/* 53 */         h4 = (rgb & 0xFF) / 255.0F;
/*    */       } 
/* 55 */       GL11.glColor3f(h1 * h2, h1 * h3, h1 * h4);
/* 56 */       func_73729_b(this.field_146128_h, this.field_146129_i, (this.type == 3) ? 50 : ((this.type == 2) ? 0 : (60 + ((this.type == 0) ? 20 : 0))), 106 + var5 * 10, this.field_146120_f, this.field_146121_g);
/* 57 */       func_146119_b(par1Minecraft, par2, par3);
/* 58 */       int var6 = 14737632;
/*    */       
/* 60 */       if (!this.field_146124_l) {
/*    */         
/* 62 */         var6 = -6250336;
/*    */       }
/* 64 */       else if (this.field_146123_n) {
/*    */         
/* 66 */         var6 = 16777120;
/*    */       } 
/* 68 */       this.field_146126_j = (this.type == 0) ? "Off" : "On";
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreGuiButtonsA4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */