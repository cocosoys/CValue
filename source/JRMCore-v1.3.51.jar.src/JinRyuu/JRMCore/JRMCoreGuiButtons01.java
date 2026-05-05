/*    */ package JinRyuu.JRMCore;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class JRMCoreGuiButtons01
/*    */   extends GuiButton
/*    */ {
/*    */   public int col;
/*    */   private boolean shadow = true;
/*    */   
/*    */   public Object setShadow(boolean b) {
/* 16 */     this.shadow = b; return this;
/*    */   }
/*    */   
/*    */   public JRMCoreGuiButtons01(int par1, int par2, int par3, int par4, String par6Str, int c) {
/* 20 */     super(par1, par2, par3, par4, 10, par6Str);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 33 */     this.field_146121_g = 10;
/* 34 */     this.col = c;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_146112_a(Minecraft par1Minecraft, int par2, int par3) {
/* 42 */     if (this.field_146125_m) {
/*    */       
/* 44 */       FontRenderer var4 = par1Minecraft.field_71466_p;
/* 45 */       int width = var4.func_78256_a(this.field_146126_j);
/* 46 */       this.field_146120_f = width;
/* 47 */       this.field_146123_n = (par2 >= this.field_146128_h && par3 >= this.field_146129_i && par2 < this.field_146128_h + this.field_146120_f && par3 < this.field_146129_i + this.field_146121_g);
/* 48 */       int var5 = func_146114_a(this.field_146123_n);
/*    */ 
/*    */       
/* 51 */       int j = (this.col == 0) ? 14737632 : this.col;
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
/* 71 */       func_146119_b(par1Minecraft, par2, par3);
/* 72 */       int var6 = j;
/*    */       
/* 74 */       if (!this.field_146124_l) {
/*    */         
/* 76 */         var6 = -6250336;
/*    */       }
/* 78 */       else if (this.field_146123_n) {
/*    */         
/* 80 */         var6 = 16777120;
/*    */       } 
/* 82 */       if (this.shadow) {
/* 83 */         func_73731_b(var4, this.field_146126_j, this.field_146128_h, this.field_146129_i, var6);
/*    */       } else {
/* 85 */         var4.func_85187_a(this.field_146126_j, this.field_146128_h, this.field_146129_i, var6, false);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreGuiButtons01.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */