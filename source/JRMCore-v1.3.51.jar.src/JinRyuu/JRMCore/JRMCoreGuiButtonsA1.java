/*    */ package JinRyuu.JRMCore;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class JRMCoreGuiButtonsA1
/*    */   extends GuiButton
/*    */ {
/*    */   private String string;
/*    */   public static boolean clicked;
/*    */   private boolean mainTexture;
/*    */   
/*    */   public JRMCoreGuiButtonsA1(int par1, int par2, int par3, String par6Str, boolean mainTexture) {
/* 17 */     super(par1, par2, par3, 15, 15, "");
/* 18 */     this.string = par6Str;
/* 19 */     clicked = false;
/* 20 */     this.mainTexture = mainTexture;
/*    */   }
/*    */ 
/*    */   
/*    */   public JRMCoreGuiButtonsA1(int par1, int par2, int par3, String par6Str) {
/* 25 */     this(par1, par2, par3, par6Str, true);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_146116_c(Minecraft p_146116_1_, int p_146116_2_, int p_146116_3_) {
/* 34 */     this; clicked = true;
/* 35 */     return super.func_146116_c(p_146116_1_, p_146116_2_, p_146116_3_);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_146112_a(Minecraft par1Minecraft, int par2, int par3) {
/* 43 */     if (this.field_146125_m) {
/*    */       
/* 45 */       FontRenderer var4 = par1Minecraft.field_71466_p;
/* 46 */       ResourceLocation txx = new ResourceLocation(this.mainTexture ? JRMCoreGuiScreen.button1 : JRMCoreGuiScreen.button2);
/* 47 */       par1Minecraft.func_110434_K().func_110577_a(txx);
/* 48 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 49 */       this.field_146123_n = (par2 >= this.field_146128_h && par3 >= this.field_146129_i && par2 < this.field_146128_h + this.field_146120_f && par3 < this.field_146129_i + this.field_146121_g);
/* 50 */       int var5 = func_146114_a(this.field_146123_n);
/*    */       
/* 52 */       int huv = 0;
/* 53 */       int vuv = 0 + var5 * 15;
/*    */       
/* 55 */       if (this.string.equals("<")) { huv = 0; }
/* 56 */       else if (this.string.equals(">")) { huv = 15; }
/* 57 */       else if (this.string.equals("x")) { huv = 120; }
/* 58 */       else if (this.string.equals("o")) { huv = 135; }
/* 59 */       else if (this.string.equals("v")) { huv = 135; vuv = 91 + var5 * 15; }
/* 60 */       else if (this.string.equals("i")) { huv = 120; vuv = 91 + var5 * 15; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 68 */       func_73729_b(this.field_146128_h, this.field_146129_i, huv, vuv, this.field_146120_f, this.field_146121_g);
/* 69 */       func_146119_b(par1Minecraft, par2, par3);
/* 70 */       int var6 = 14737632;
/*    */       
/* 72 */       if (!this.field_146124_l) {
/*    */         
/* 74 */         var6 = -6250336;
/*    */       }
/* 76 */       else if (this.field_146123_n) {
/*    */         
/* 78 */         var6 = 16777120;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreGuiButtonsA1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */