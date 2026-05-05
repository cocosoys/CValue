/*    */ package JinRyuu.DragonBC.common.Gui;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class DBCGuiButtonsC
/*    */   extends GuiButton
/*    */ {
/* 12 */   public String tex = "jinryuudragonbc:guibutton06.png";
/*    */   
/*    */   public DBCGuiButtonsC(int par1, int par2, int par3, int par4, int par5, String par6Str, String tex) {
/* 15 */     super(par1, par2, par3, par4, par5, par6Str);
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
/* 26 */     this.tex = tex;
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
/* 38 */       ResourceLocation txx = new ResourceLocation(this.tex);
/* 39 */       par1Minecraft.func_110434_K().func_110577_a(txx);
/* 40 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 41 */       this.field_146123_n = (par2 >= this.field_146128_h && par3 >= this.field_146129_i && par2 < this.field_146128_h + this.field_146120_f && par3 < this.field_146129_i + this.field_146121_g);
/* 42 */       int var5 = func_146114_a(this.field_146123_n);
/* 43 */       func_73729_b(this.field_146128_h, this.field_146129_i, 0, 46 + var5 * 20, this.field_146120_f / 2, this.field_146121_g);
/* 44 */       func_73729_b(this.field_146128_h + this.field_146120_f / 2, this.field_146129_i, 200 - this.field_146120_f / 2, 46 + var5 * 20, this.field_146120_f / 2, this.field_146121_g);
/* 45 */       func_146119_b(par1Minecraft, par2, par3);
/* 46 */       int var6 = 14737632;
/*    */       
/* 48 */       if (!this.field_146124_l) {
/*    */         
/* 50 */         var6 = -6250336;
/*    */       }
/* 52 */       else if (this.field_146123_n) {
/*    */         
/* 54 */         var6 = 16777120;
/*    */       } 
/*    */       
/* 57 */       func_73732_a(var4, this.field_146126_j, this.field_146128_h + this.field_146120_f / 2, this.field_146129_i + (this.field_146121_g - 8) / 2, var6);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Gui\DBCGuiButtonsC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */