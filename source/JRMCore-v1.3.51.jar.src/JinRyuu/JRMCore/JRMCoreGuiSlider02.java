/*     */ package JinRyuu.JRMCore;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ public class JRMCoreGuiSlider02
/*     */   extends GuiButton
/*     */ {
/*  14 */   public float sliderValue = 1.0F;
/*  15 */   public float sliderMaxValue = 1.0F;
/*     */   public boolean dragging = false;
/*     */   public String label;
/*     */   private int col;
/*     */   
/*     */   public JRMCoreGuiSlider02(int id, int x, int y, int sizex, int sizey, String label, float startingValue, float maxValue, int c) {
/*  21 */     this(id, x, y, sizex, sizey, label, startingValue, maxValue);
/*  22 */     this.col = c;
/*     */   }
/*     */   public JRMCoreGuiSlider02(int id, int x, int y, int sizex, int sizey, String label, float startingValue, float maxValue) {
/*  25 */     super(id, x, y, sizex, sizey, label);
/*  26 */     this.label = label;
/*  27 */     this.sliderValue = startingValue;
/*  28 */     this.sliderMaxValue = maxValue;
/*     */   }
/*     */   
/*     */   public int func_146114_a(boolean par1) {
/*  32 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146112_a(Minecraft par1Minecraft, int par2, int par3) {
/*  37 */     if (this.field_146125_m) {
/*     */       
/*  39 */       FontRenderer fontrenderer = par1Minecraft.field_71466_p;
/*  40 */       ResourceLocation txx = new ResourceLocation(JRMCoreGuiScreen.button1);
/*  41 */       par1Minecraft.func_110434_K().func_110577_a(txx);
/*  42 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  43 */       this.field_146123_n = (par2 >= this.field_146128_h && par3 >= this.field_146129_i && par2 < this.field_146128_h + this.field_146120_f && par3 < this.field_146129_i + this.field_146121_g);
/*  44 */       int k = func_146114_a(this.field_146123_n);
/*     */       
/*  46 */       if (this.col != 0) {
/*  47 */         int j = this.col;
/*  48 */         float h2 = (j >> 16 & 0xFF) / 255.0F;
/*  49 */         float h3 = (j >> 8 & 0xFF) / 255.0F;
/*  50 */         float h4 = (j & 0xFF) / 255.0F;
/*  51 */         float h1 = 1.0F;
/*  52 */         if (k == 2) {
/*  53 */           int r = (int)(h2 * 254.0F);
/*  54 */           int g = (int)(h3 * 254.0F);
/*  55 */           int b = (int)(h4 * 254.0F);
/*  56 */           float[] hsb = Color.RGBtoHSB(r, g, b, null);
/*  57 */           float hue = hsb[0];
/*  58 */           float saturation = 0.33F;
/*  59 */           float brightness = hsb[2];
/*  60 */           int rgb = Color.HSBtoRGB(hue, saturation, brightness);
/*  61 */           h2 = (rgb >> 16 & 0xFF) / 255.0F;
/*  62 */           h3 = (rgb >> 8 & 0xFF) / 255.0F;
/*  63 */           h4 = (rgb & 0xFF) / 255.0F;
/*     */         } 
/*  65 */         GL11.glColor3f(h1 * h2, h1 * h3, h1 * h4);
/*     */       } 
/*     */       
/*  68 */       func_73729_b(this.field_146128_h, this.field_146129_i, 241, 159, this.field_146120_f, this.field_146121_g);
/*     */       
/*  70 */       func_146119_b(par1Minecraft, par2, par3);
/*  71 */       int l = 14737632;
/*     */       
/*  73 */       if (!this.field_146124_l) {
/*     */         
/*  75 */         l = -6250336;
/*     */       }
/*  77 */       else if (this.field_146123_n) {
/*     */         
/*  79 */         l = 16777120;
/*     */       } 
/*     */       
/*  82 */       func_73732_a(fontrenderer, this.field_146126_j, this.field_146128_h + this.field_146120_f / 2, this.field_146129_i + (this.field_146121_g - 8) / 2, l);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_146119_b(Minecraft par1Minecraft, int par2, int par3) {
/*  87 */     if (this.field_146125_m) {
/*  88 */       if (this.dragging) {
/*  89 */         this.sliderValue = (par3 - this.field_146129_i) / this.field_146121_g;
/*     */         
/*  91 */         if (this.sliderValue < 0.0F) {
/*  92 */           this.sliderValue = 0.0F;
/*     */         }
/*     */         
/*  95 */         if (this.sliderValue > 1.0F) {
/*  96 */           this.sliderValue = 1.0F;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 101 */       ResourceLocation txx = new ResourceLocation(JRMCoreGuiScreen.button1);
/* 102 */       par1Minecraft.func_110434_K().func_110577_a(txx);
/*     */ 
/*     */ 
/*     */       
/* 106 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */       
/* 108 */       func_73729_b(this.field_146128_h, this.field_146129_i + (int)(this.sliderValue * this.field_146121_g), 241, 155, this.field_146120_f / 2, 2);
/* 109 */       func_73729_b(this.field_146128_h + 2, this.field_146129_i + (int)(this.sliderValue * this.field_146121_g), 256 - this.field_146120_f - this.field_146120_f / 2, 155, this.field_146120_f - this.field_146120_f / 2, 2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_146116_c(Minecraft par1Minecraft, int par2, int par3) {
/* 117 */     if (super.func_146116_c(par1Minecraft, par2, par3)) {
/* 118 */       this.sliderValue = (par3 - this.field_146129_i) / this.field_146121_g;
/*     */       
/* 120 */       if (this.sliderValue < 0.0F) {
/* 121 */         this.sliderValue = 0.0F;
/*     */       }
/*     */       
/* 124 */       if (this.sliderValue > 1.0F) {
/* 125 */         this.sliderValue = 1.0F;
/*     */       }
/*     */       
/* 128 */       this.dragging = true;
/* 129 */       return true;
/*     */     } 
/* 131 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146118_a(int par1, int par2) {
/* 136 */     this.dragging = false;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreGuiSlider02.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */