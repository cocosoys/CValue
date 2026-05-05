/*     */ package JinRyuu.JRMCore;
/*     */ 
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class JRMCoreGuiSlider00
/*     */   extends GuiButton
/*     */ {
/*  12 */   public float sliderValue = 1.0F;
/*  13 */   public float sliderMaxValue = 1.0F;
/*     */   public boolean dragging = false;
/*     */   public String label;
/*     */   
/*     */   public JRMCoreGuiSlider00(int id, int x, int y, String label, float startingValue, float maxValue) {
/*  18 */     super(id, x, y, 20, 128, label);
/*  19 */     this.label = label;
/*  20 */     this.sliderValue = startingValue;
/*  21 */     this.sliderMaxValue = maxValue;
/*     */   }
/*     */   
/*     */   public int func_146114_a(boolean par1) {
/*  25 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146112_a(Minecraft par1Minecraft, int par2, int par3) {
/*  30 */     if (this.field_146125_m) {
/*     */       
/*  32 */       FontRenderer fontrenderer = par1Minecraft.field_71466_p;
/*  33 */       ResourceLocation txx = new ResourceLocation(JRMCoreGuiScreen.button1);
/*  34 */       par1Minecraft.func_110434_K().func_110577_a(txx);
/*  35 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  36 */       this.field_146123_n = (par2 >= this.field_146128_h && par3 >= this.field_146129_i && par2 < this.field_146128_h + this.field_146120_f && par3 < this.field_146129_i + this.field_146121_g);
/*  37 */       int k = func_146114_a(this.field_146123_n);
/*  38 */       func_73729_b(this.field_146128_h, this.field_146129_i, 236 - k * 20, 0, this.field_146120_f, this.field_146121_g);
/*     */       
/*  40 */       func_146119_b(par1Minecraft, par2, par3);
/*  41 */       int l = 14737632;
/*     */       
/*  43 */       if (!this.field_146124_l) {
/*     */         
/*  45 */         l = -6250336;
/*     */       }
/*  47 */       else if (this.field_146123_n) {
/*     */         
/*  49 */         l = 16777120;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  64 */       func_73732_a(fontrenderer, this.field_146126_j, this.field_146128_h + this.field_146120_f / 2, this.field_146129_i + (this.field_146121_g - 8) / 2, l);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_146119_b(Minecraft par1Minecraft, int par2, int par3) {
/*  69 */     if (this.field_146125_m) {
/*  70 */       if (this.dragging) {
/*  71 */         this.sliderValue = (par3 - this.field_146129_i + 4) / (this.field_146121_g - 8);
/*     */         
/*  73 */         if (this.sliderValue < 0.0F) {
/*  74 */           this.sliderValue = 0.0F;
/*     */         }
/*     */         
/*  77 */         if (this.sliderValue > 1.0F) {
/*  78 */           this.sliderValue = 1.0F;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/*  83 */       ResourceLocation txx = new ResourceLocation(JRMCoreGuiScreen.button1);
/*  84 */       par1Minecraft.func_110434_K().func_110577_a(txx);
/*     */ 
/*     */ 
/*     */       
/*  88 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  89 */       func_73729_b(this.field_146128_h, this.field_146129_i + (int)(this.sliderValue * (this.field_146121_g - 4)), 216, 0, 20, 2);
/*  90 */       func_73729_b(this.field_146128_h, this.field_146129_i + (int)(this.sliderValue * (this.field_146121_g - 4)) + 2, 216, 126, 20, 2);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean func_146116_c(Minecraft par1Minecraft, int par2, int par3) {
/*  95 */     if (super.func_146116_c(par1Minecraft, par2, par3)) {
/*  96 */       this.sliderValue = (par3 - this.field_146129_i + 4) / (this.field_146121_g - 8);
/*     */       
/*  98 */       if (this.sliderValue < 0.0F) {
/*  99 */         this.sliderValue = 0.0F;
/*     */       }
/*     */       
/* 102 */       if (this.sliderValue > 1.0F) {
/* 103 */         this.sliderValue = 1.0F;
/*     */       }
/*     */       
/* 106 */       this.dragging = true;
/* 107 */       return true;
/*     */     } 
/* 109 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146118_a(int par1, int par2) {
/* 114 */     this.dragging = false;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreGuiSlider00.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */