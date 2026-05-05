/*    */ package JinRyuu.JRMCore;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ public class JRMCoreGuiButtonsA2
/*    */   extends GuiButton
/*    */ {
/*    */   private String string;
/*    */   
/*    */   public JRMCoreGuiButtonsA2(int par1, int par2, int par3, String par6Str) {
/* 16 */     super(par1, par2, par3, 10, 10, "");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 26 */     this.string = par6Str;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_146112_a(Minecraft par1Minecraft, int par2, int par3) {
/* 34 */     if (this.field_146125_m) {
/*    */ 
/*    */       
/* 37 */       FontRenderer var4 = par1Minecraft.field_71466_p;
/* 38 */       ResourceLocation txx = new ResourceLocation(JRMCoreGuiScreen.button1);
/* 39 */       par1Minecraft.func_110434_K().func_110577_a(txx);
/* 40 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 41 */       this.field_146123_n = (par2 >= this.field_146128_h && par3 >= this.field_146129_i && par2 < this.field_146128_h + this.field_146120_f && par3 < this.field_146129_i + this.field_146121_g);
/* 42 */       int var5 = func_146114_a(this.field_146123_n);
/*    */       
/* 44 */       int s = 0;
/*    */       
/* 46 */       if (this.string.equals("<<")) { s = 70; }
/* 47 */       else if (this.string.equals(">>")) { s = 80; }
/* 48 */       else if (this.string.equals("|<")) { s = 90; }
/* 49 */       else if (this.string.equals(">|")) { s = 100; }
/* 50 */       else if (this.string.equals("<")) { s = 30; }
/* 51 */       else if (this.string.equals(">")) { s = 40; }
/* 52 */       else if (this.string.equals("^")) { s = 50; }
/* 53 */       else if (this.string.equals("v")) { s = 60; }
/* 54 */       else if (this.string.equals("x")) { s = 150; }
/* 55 */       else if (this.string.equals("o")) { s = 160; }
/* 56 */       else if (this.string.equals("(|)")) { s = 170; }
/* 57 */       else if (this.string.equals("(||)")) { s = 180; }
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
/*    */       
/* 71 */       func_73729_b(this.field_146128_h, this.field_146129_i, s, 5 + var5 * 10, this.field_146120_f, this.field_146121_g);
/* 72 */       func_146119_b(par1Minecraft, par2, par3);
/* 73 */       int var6 = 14737632;
/*    */       
/* 75 */       if (!this.field_146124_l) {
/*    */         
/* 77 */         var6 = -6250336;
/*    */       }
/* 79 */       else if (this.field_146123_n) {
/*    */         
/* 81 */         var6 = 16777120;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreGuiButtonsA2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */