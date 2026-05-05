/*     */ package JinRyuu.JRMCore;
/*     */ 
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class JRMCoreGuiSlider01
/*     */   extends GuiButton
/*     */ {
/*  12 */   public float sliderValue = 0.5F;
/*  13 */   public float sliderMaxValue = 1.0F;
/*     */   public boolean dragging = false;
/*     */   public String label;
/*     */   
/*     */   public JRMCoreGuiSlider01(int id, int x, int y, int sizex, int sizey, String label, float startingValue, float maxValue) {
/*  18 */     super(id, x, y, sizex, sizey, label);
/*     */     
/*  20 */     this.field_146120_f = (sizex > 200) ? 200 : sizex;
/*  21 */     this.field_146121_g = (sizey > 15) ? 15 : sizey;
/*     */     
/*  23 */     this.label = label;
/*  24 */     this.sliderValue = startingValue;
/*  25 */     this.sliderMaxValue = maxValue;
/*     */   }
/*     */   
/*     */   public int func_146114_a(boolean par1) {
/*  29 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146112_a(Minecraft par1Minecraft, int par2, int par3) {
/*  34 */     if (this.field_146125_m) {
/*     */       
/*  36 */       FontRenderer fontrenderer = par1Minecraft.field_71466_p;
/*  37 */       ResourceLocation txx = new ResourceLocation(JRMCoreGuiScreen.button1);
/*  38 */       par1Minecraft.func_110434_K().func_110577_a(txx);
/*  39 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  40 */       this.field_146123_n = (par2 >= this.field_146128_h && par3 >= this.field_146129_i && par2 < this.field_146128_h + this.field_146120_f && par3 < this.field_146129_i + this.field_146121_g);
/*  41 */       int k = func_146114_a(this.field_146123_n);
/*  42 */       func_73729_b(this.field_146128_h, this.field_146129_i, 0, 0, this.field_146120_f, this.field_146121_g);
/*     */       
/*  44 */       func_146119_b(par1Minecraft, par2, par3);
/*  45 */       int l = 14737632;
/*     */       
/*  47 */       if (!this.field_146124_l) {
/*     */         
/*  49 */         l = -6250336;
/*     */       }
/*  51 */       else if (this.field_146123_n) {
/*     */         
/*  53 */         l = 16777120;
/*     */       } 
/*     */       
/*  56 */       func_73732_a(fontrenderer, this.field_146126_j, this.field_146128_h + this.field_146120_f / 2, this.field_146129_i + (this.field_146121_g - 8) / 2, l);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_146119_b(Minecraft par1Minecraft, int par2, int par3) {
/*  61 */     if (this.field_146125_m) {
/*  62 */       if (this.dragging) {
/*  63 */         this.sliderValue = (par2 - this.field_146128_h) / this.field_146120_f;
/*     */         
/*  65 */         if (this.sliderValue < 0.0F) {
/*  66 */           this.sliderValue = 0.0F;
/*     */         }
/*     */         
/*  69 */         if (this.sliderValue > 1.0F) {
/*  70 */           this.sliderValue = 1.0F;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/*  75 */       ResourceLocation txx = new ResourceLocation(JRMCoreGuiScreen.button1);
/*  76 */       par1Minecraft.func_110434_K().func_110577_a(txx);
/*     */ 
/*     */ 
/*     */       
/*  80 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  81 */       func_73729_b(this.field_146128_h + (int)(this.sliderValue * (this.field_146120_f + 2)), this.field_146129_i, 200, 0, 2, this.field_146121_g);
/*  82 */       func_73729_b(this.field_146128_h + (int)(this.sliderValue * (this.field_146120_f + 2)) + 2, this.field_146129_i, 202, 0, 2, this.field_146121_g);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean func_146116_c(Minecraft par1Minecraft, int par2, int par3) {
/*  87 */     if (super.func_146116_c(par1Minecraft, par2, par3)) {
/*  88 */       this.sliderValue = (par2 - this.field_146128_h) / this.field_146120_f;
/*     */       
/*  90 */       if (this.sliderValue < 0.0F) {
/*  91 */         this.sliderValue = 0.0F;
/*     */       }
/*     */       
/*  94 */       if (this.sliderValue > 1.0F) {
/*  95 */         this.sliderValue = 1.0F;
/*     */       }
/*     */       
/*  98 */       this.dragging = true;
/*  99 */       return true;
/*     */     } 
/* 101 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146118_a(int par1, int par2) {
/* 106 */     this.dragging = false;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreGuiSlider01.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */