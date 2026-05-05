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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JRMCoreGuiButtons02
/*    */   extends GuiButton
/*    */ {
/*    */   private int col;
/*    */   private int type;
/*    */   
/*    */   public JRMCoreGuiButtons02(int par1, int par2, int par3, String par6Str, int type, int col) {
/* 21 */     super(par1, par2, par3, 20, 20, par6Str);
/* 22 */     this.field_146120_f = 20;
/* 23 */     this.field_146121_g = 20;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 32 */     this.col = col;
/* 33 */     this.type = type;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_146112_a(Minecraft par1Minecraft, int par2, int par3) {
/* 41 */     if (this.field_146125_m) {
/*    */ 
/*    */       
/* 44 */       FontRenderer var4 = par1Minecraft.field_71466_p;
/* 45 */       ResourceLocation txx = new ResourceLocation(JRMCoreGuiScreen.button1);
/* 46 */       par1Minecraft.func_110434_K().func_110577_a(txx);
/* 47 */       GL11.glColor4f(0.7F, 0.7F, 0.7F, 1.0F);
/* 48 */       this.field_146123_n = (par2 >= this.field_146128_h && par3 >= this.field_146129_i && par2 < this.field_146128_h + this.field_146120_f && par3 < this.field_146129_i + this.field_146121_g);
/* 49 */       int var5 = func_146114_a(this.field_146123_n);
/*    */       
/* 51 */       int j = (this.col == 0) ? 16449280 : this.col;
/* 52 */       float h2 = (j >> 16 & 0xFF) / 255.0F;
/* 53 */       float h3 = (j >> 8 & 0xFF) / 255.0F;
/* 54 */       float h4 = (j & 0xFF) / 255.0F;
/* 55 */       float h1 = 1.0F;
/* 56 */       if (var5 == 2) {
/* 57 */         int r = (int)(h2 * 254.0F);
/* 58 */         int g = (int)(h3 * 254.0F);
/* 59 */         int b = (int)(h4 * 254.0F);
/* 60 */         float[] hsb = Color.RGBtoHSB(r, g, b, null);
/* 61 */         float hue = hsb[0];
/* 62 */         float saturation = 0.33F;
/* 63 */         float brightness = hsb[2];
/* 64 */         int rgb = Color.HSBtoRGB(hue, saturation, brightness);
/* 65 */         h2 = (rgb >> 16 & 0xFF) / 255.0F;
/* 66 */         h3 = (rgb >> 8 & 0xFF) / 255.0F;
/* 67 */         h4 = (rgb & 0xFF) / 255.0F;
/*    */       } 
/* 69 */       GL11.glColor3f(h1 * h2, h1 * h3, h1 * h4);
/*    */       
/* 71 */       func_73729_b(this.field_146128_h, this.field_146129_i, 0 + var5 * 20, 156 + this.type * 20, this.field_146120_f, this.field_146121_g);
/*    */       
/* 73 */       func_146119_b(par1Minecraft, par2, par3);
/* 74 */       int var6 = 14737632;
/*    */       
/* 76 */       if (!this.field_146124_l) {
/*    */         
/* 78 */         var6 = -6250336;
/*    */       }
/* 80 */       else if (this.field_146123_n) {
/*    */         
/* 82 */         var6 = 16777120;
/*    */       } 
/*    */       
/* 85 */       func_73732_a(var4, this.field_146126_j, this.field_146128_h + this.field_146120_f / 2, this.field_146129_i + (this.field_146121_g - 8) / 2, var6);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreGuiButtons02.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */