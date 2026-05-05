/*     */ package JinRyuu.JRMCore;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class JRMCoreGuiButtonEmpty
/*     */   extends GuiButton {
/*     */   private boolean categoryIcon;
/*     */   private int col;
/*     */   private int icon;
/*     */   private int mode;
/*     */   private int state;
/*     */   private float alpha;
/*     */   
/*     */   public JRMCoreGuiButtonEmpty(boolean categoryIcon, int mode, int icon, int state, int x, int y, int par3, int par4, int par5, String text, int col) {
/*  20 */     super(x, y, par3, par4, par5, text);
/*  21 */     this.categoryIcon = categoryIcon;
/*  22 */     this.col = col;
/*  23 */     this.icon = icon;
/*  24 */     this.mode = mode;
/*  25 */     this.state = state;
/*  26 */     this.alpha = 1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public JRMCoreGuiButtonEmpty(int x, int y, int par3, int par4, int par5, String text) {
/*  31 */     this(false, 0, 0, 0, x, y, par3, par4, par5, text, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_146112_a(Minecraft minecraft, int par2, int par3) {
/*  37 */     if (this.field_146125_m) {
/*     */       
/*  39 */       FontRenderer var4 = minecraft.field_71466_p;
/*  40 */       boolean select = (this.icon == 0);
/*  41 */       this.field_146123_n = (par2 >= this.field_146128_h && par3 >= this.field_146129_i && par2 < this.field_146128_h + this.field_146120_f && par3 < this.field_146129_i + this.field_146121_g);
/*  42 */       int hoverState = func_146114_a(this.field_146123_n);
/*  43 */       int idY = 0, idX = 0;
/*     */       
/*  45 */       ResourceLocation txx = new ResourceLocation(JRMCoreH.tjjrmc + ":" + (select ? "note_select.png" : "note_category_icons.png"));
/*  46 */       minecraft.func_110434_K().func_110577_a(txx);
/*     */ 
/*     */ 
/*     */       
/*  50 */       if (!select && this.mode == 0 && hoverState != 2) {
/*     */         
/*  52 */         this.alpha = 0.6F;
/*     */       }
/*     */       else {
/*     */         
/*  56 */         this.alpha = 1.0F;
/*     */       } 
/*     */       
/*  59 */       GL11.glColor4f(1.0F * this.alpha, 1.0F * this.alpha, 1.0F * this.alpha, 1.0F);
/*     */       
/*  61 */       if (this.icon != 0) {
/*     */         
/*  63 */         int TEXTURE_SIZE = 16;
/*  64 */         idY = (this.icon - 1) * 16 / 256;
/*  65 */         idX = (this.icon - 1) * 16 - idY * 256;
/*  66 */         idY *= 16;
/*     */       } 
/*     */ 
/*     */       
/*  70 */       if (select) {
/*     */         
/*  72 */         hoverState = func_146114_a(this.field_146123_n);
/*     */         
/*  74 */         func_73729_b(this.field_146128_h, this.field_146129_i, 0, 0 + hoverState * this.field_146121_g, this.field_146120_f, this.field_146121_g);
/*     */       
/*     */       }
/*     */       else {
/*     */         
/*  79 */         func_73729_b(this.field_146128_h - 2, this.field_146129_i - 2, 20, 196 + hoverState * (this.field_146121_g + 4), this.field_146120_f + 4, this.field_146121_g + 4);
/*     */         
/*  81 */         if (this.categoryIcon)
/*     */         {
/*  83 */           setColor(hoverState);
/*     */         }
/*     */ 
/*     */         
/*  87 */         func_73729_b(this.field_146128_h, this.field_146129_i, idX, idY, this.field_146120_f, this.field_146121_g);
/*     */         
/*  89 */         if (this.categoryIcon) {
/*     */           
/*  91 */           GL11.glColor4f(1.0F * this.alpha, 1.0F * this.alpha, 1.0F * this.alpha, 1.0F);
/*     */         }
/*     */         else {
/*     */           
/*  95 */           setColor(hoverState);
/*     */         } 
/*     */ 
/*     */         
/*  99 */         if (this.state > 0) func_73729_b(this.field_146128_h, this.field_146129_i, 0 + (this.state - 1) * 16, idY + 16, this.field_146120_f, this.field_146121_g);
/*     */ 
/*     */         
/* 102 */         if (this.mode != 0) func_73729_b(this.field_146128_h - 2, this.field_146129_i - 2, 0, 196 + 2 * (this.field_146121_g + 4), this.field_146120_f + 4, this.field_146121_g + 4);
/*     */       
/*     */       } 
/*     */       
/* 106 */       func_146119_b(minecraft, par2, par3);
/* 107 */       int var6 = 14737632;
/*     */       
/* 109 */       if (!this.field_146124_l) {
/*     */         
/* 111 */         var6 = -6250336;
/*     */       }
/* 113 */       else if (this.field_146123_n) {
/*     */         
/* 115 */         var6 = 16777120;
/*     */       } 
/*     */       
/* 118 */       if (this.field_146126_j.length() > 0)
/*     */       {
/* 120 */         func_73732_a(var4, this.field_146126_j, this.field_146128_h + this.field_146120_f / 2, this.field_146129_i + (this.field_146121_g - 8) / 2, var6);
/*     */       }
/*     */       
/* 123 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void setColor(int hoverState) {
/* 129 */     if (this.col != 0) {
/*     */ 
/*     */       
/* 132 */       float h2 = (this.col >> 16 & 0xFF) / 255.0F;
/* 133 */       float h3 = (this.col >> 8 & 0xFF) / 255.0F;
/* 134 */       float h4 = (this.col & 0xFF) / 255.0F;
/* 135 */       float h1 = 1.0F * this.alpha;
/*     */       
/* 137 */       if (hoverState == 2) {
/*     */         
/* 139 */         int r = (int)(h2 * 254.0F);
/* 140 */         int g = (int)(h3 * 254.0F);
/* 141 */         int b = (int)(h4 * 254.0F);
/* 142 */         float[] hsb = Color.RGBtoHSB(r, g, b, null);
/* 143 */         float hue = hsb[0];
/* 144 */         float saturation = 0.33F;
/* 145 */         float brightness = hsb[2];
/* 146 */         int rgb = Color.HSBtoRGB(hue, saturation, brightness);
/* 147 */         h2 = (rgb >> 16 & 0xFF) / 255.0F;
/* 148 */         h3 = (rgb >> 8 & 0xFF) / 255.0F;
/* 149 */         h4 = (rgb & 0xFF) / 255.0F;
/*     */       } 
/* 151 */       GL11.glColor3f(h1 * h2, h1 * h3, h1 * h4);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreGuiButtonEmpty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */