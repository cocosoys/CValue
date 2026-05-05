/*     */ package JinRyuu.JRMCore;
/*     */ 
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class JRMCoreGuiSliderX00
/*     */   extends GuiButton {
/*  11 */   public static float sliderValue = 1.0F;
/*  12 */   public float sliderMaxValue = 1.0F;
/*     */   
/*     */   public boolean dragging = false;
/*     */   public String label;
/*     */   private boolean mc0;
/*     */   private boolean mainTexture;
/*     */   
/*     */   public JRMCoreGuiSliderX00(int id, int x, int y, boolean mc0, float startingValue, float maxValue, boolean mainTexture) {
/*  20 */     super(id, x, y, 15, 115, "");
/*  21 */     this.label = "";
/*  22 */     this; sliderValue = startingValue;
/*  23 */     this.sliderMaxValue = maxValue;
/*  24 */     this.mc0 = mc0;
/*  25 */     this.mainTexture = mainTexture;
/*     */   }
/*     */ 
/*     */   
/*     */   public JRMCoreGuiSliderX00(int id, int x, int y, boolean mc0, float startingValue, float maxValue) {
/*  30 */     this(id, x, y, mc0, startingValue, maxValue, true);
/*     */   }
/*     */   
/*     */   public int func_146114_a(boolean par1) {
/*  34 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146112_a(Minecraft par1Minecraft, int par2, int par3) {
/*  39 */     if (this.field_146125_m) {
/*     */       
/*  41 */       FontRenderer fontrenderer = par1Minecraft.field_71466_p;
/*  42 */       ResourceLocation txx = new ResourceLocation(this.mainTexture ? JRMCoreGuiScreen.button1 : JRMCoreGuiScreen.button2);
/*  43 */       par1Minecraft.func_110434_K().func_110577_a(txx);
/*  44 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  45 */       this.field_146123_n = (par2 >= this.field_146128_h && par3 >= this.field_146129_i && par2 < this.field_146128_h + this.field_146120_f && par3 < this.field_146129_i + this.field_146121_g);
/*  46 */       int k = func_146114_a(this.field_146123_n);
/*  47 */       func_73729_b(this.field_146128_h, this.field_146129_i, 216 - k * 20, 128, this.field_146120_f, this.field_146121_g);
/*     */       
/*  49 */       func_146119_b(par1Minecraft, par2, par3);
/*  50 */       int l = 14737632;
/*     */       
/*  52 */       if (!this.field_146124_l) {
/*     */         
/*  54 */         l = -6250336;
/*     */       }
/*  56 */       else if (this.field_146123_n) {
/*     */         
/*  58 */         l = 16777120;
/*     */       } 
/*     */       
/*  61 */       func_73732_a(fontrenderer, this.field_146126_j, this.field_146128_h + this.field_146120_f / 2, this.field_146129_i + (this.field_146121_g - 8) / 2, l);
/*     */       
/*  63 */       if (this.mc0 && super.func_146116_c(par1Minecraft, par2, par3)) {
/*  64 */         this; sliderValue = (par3 - this.field_146129_i + 4) / (this.field_146121_g - 8);
/*     */         
/*  66 */         this; if (sliderValue < 0.0F) {
/*  67 */           this; sliderValue = 0.0F;
/*     */         } 
/*     */         
/*  70 */         this; if (sliderValue > 1.0F) {
/*  71 */           this; sliderValue = 1.0F;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146119_b(Minecraft par1Minecraft, int par2, int par3) {
/*  79 */     if (this.field_146125_m) {
/*  80 */       if (this.dragging) {
/*  81 */         this; sliderValue = (par3 - this.field_146129_i + 4) / (this.field_146121_g - 8);
/*     */         
/*  83 */         this; if (sliderValue < 0.0F) {
/*  84 */           this; sliderValue = 0.0F;
/*     */         } 
/*     */         
/*  87 */         this; if (sliderValue > 1.0F) {
/*  88 */           this; sliderValue = 1.0F;
/*     */         } 
/*     */       } 
/*     */       
/*  92 */       ResourceLocation txx = new ResourceLocation(this.mainTexture ? JRMCoreGuiScreen.button1 : JRMCoreGuiScreen.button2);
/*  93 */       par1Minecraft.func_110434_K().func_110577_a(txx);
/*     */ 
/*     */ 
/*     */       
/*  97 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  98 */       this; func_73729_b(this.field_146128_h, this.field_146129_i + (int)(sliderValue * (this.field_146121_g - 4)), 241, 155, 15, 2);
/*  99 */       this; func_73729_b(this.field_146128_h, this.field_146129_i + (int)(sliderValue * (this.field_146121_g - 4)) + 2, 241, 157, 15, 2);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean func_146116_c(Minecraft par1Minecraft, int par2, int par3) {
/* 104 */     return false;
/*     */   }
/*     */   
/*     */   public void func_146118_a(int par1, int par2) {}
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreGuiSliderX00.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */