/*    */ package JinRyuu.JRMCore;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class JRMCoreGuiButtonC
/*    */   extends GuiButton
/*    */ {
/*    */   private int bgCol;
/* 13 */   private int defCol = 0;
/*    */   public int getBgCol() {
/* 15 */     return this.bgCol;
/*    */   }
/*    */   
/*    */   public JRMCoreGuiButtonC(int par1, int par2, int par3, int par4, int par5, String par6Str) {
/* 19 */     super(par1, par2, par3, par4, par5, par6Str);
/*    */   }
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
/*    */   public JRMCoreGuiButtonC(int par1, int par2, int par3, int par4, int par5, String par6Str, int par7) {
/* 33 */     super(par1, par2, par3, par4, par5, par6Str);
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
/* 44 */     this.bgCol = par7;
/*    */   }
/*    */   
/*    */   public JRMCoreGuiButtonC(int par1, int par2, int par3, int par4, int par5, String par6Str, int par7, int par8) {
/* 48 */     this(par1, par2, par3, par4, par5, par6Str, par7);
/* 49 */     this.defCol = par8;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_146112_a(Minecraft par1Minecraft, int par2, int par3) {
/* 57 */     if (this.field_146125_m) {
/*    */ 
/*    */       
/* 60 */       FontRenderer var4 = par1Minecraft.field_71466_p;
/* 61 */       ResourceLocation txx = new ResourceLocation(JRMCoreGuiScreen.button1);
/* 62 */       par1Minecraft.func_110434_K().func_110577_a(txx);
/*    */       
/* 64 */       int col = (this.defCol == 0) ? this.bgCol : this.defCol;
/* 65 */       float h2 = (col >> 16 & 0xFF) / 255.0F;
/* 66 */       float h3 = (col >> 8 & 0xFF) / 255.0F;
/* 67 */       float h4 = (col & 0xFF) / 255.0F;
/* 68 */       float h1 = 1.0F;
/* 69 */       GL11.glColor3f(h1 * h2, h1 * h3, h1 * h4);
/* 70 */       this.field_146123_n = (par2 >= this.field_146128_h && par3 >= this.field_146129_i && par2 < this.field_146128_h + this.field_146120_f && par3 < this.field_146129_i + this.field_146121_g);
/* 71 */       int var5 = func_146114_a(this.field_146123_n);
/* 72 */       func_73729_b(this.field_146128_h, this.field_146129_i, 0, 0 + var5 * 1, this.field_146120_f, this.field_146121_g);
/*    */       
/* 74 */       func_146119_b(par1Minecraft, par2, par3);
/* 75 */       int var6 = 14737632;
/*    */       
/* 77 */       if (!this.field_146124_l) {
/*    */         
/* 79 */         var6 = -6250336;
/*    */       }
/* 81 */       else if (this.field_146123_n) {
/*    */         
/* 83 */         var6 = 16777120;
/*    */       } 
/*    */       
/* 86 */       func_73732_a(var4, this.field_146126_j, this.field_146128_h + this.field_146120_f / 2, this.field_146129_i + (this.field_146121_g - 8) / 2, var6);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreGuiButtonC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */