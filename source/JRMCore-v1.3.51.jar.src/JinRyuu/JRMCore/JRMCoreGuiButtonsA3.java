/*    */ package JinRyuu.JRMCore;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ public class JRMCoreGuiButtonsA3
/*    */   extends GuiButton
/*    */ {
/*    */   private String string;
/*    */   private int type;
/*    */   
/*    */   public JRMCoreGuiButtonsA3(int par1, int par2, int par3, int width, int type, boolean b) {
/* 17 */     this(par1, par2, par3, width, type);
/* 18 */     this.field_146124_l = b;
/*    */   }
/*    */   
/*    */   public JRMCoreGuiButtonsA3(int par1, int par2, int par3, int width, int type) {
/* 22 */     super(par1, par2, par3, width, 10, "");
/* 23 */     this.field_146120_f = width;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 32 */     this.string = "+";
/* 33 */     this.type = type;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_146112_a(Minecraft par1Minecraft, int par2, int par3) {
/* 41 */     if (this.field_146125_m) {
/*    */ 
/*    */       
/* 44 */       FontRenderer var4 = par1Minecraft.field_71466_p;
/* 45 */       ResourceLocation txx = new ResourceLocation(JRMCoreGuiScreen.button1);
/* 46 */       par1Minecraft.func_110434_K().func_110577_a(txx);
/* 47 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 48 */       this.field_146123_n = (par2 >= this.field_146128_h && par3 >= this.field_146129_i && par2 < this.field_146128_h + this.field_146120_f && par3 < this.field_146129_i + this.field_146121_g);
/* 49 */       int var5 = func_146114_a(this.field_146123_n);
/* 50 */       func_73729_b(this.field_146128_h, this.field_146129_i, (this.type == 3) ? 50 : ((this.type == 2) ? 0 : (10 + ((this.type == 0) ? 20 : 0))), 106 + (this.field_146124_l ? (var5 * 10) : 0), this.field_146120_f, this.field_146121_g);
/* 51 */       func_146119_b(par1Minecraft, par2, par3);
/* 52 */       int var6 = 14737632;
/*    */       
/* 54 */       if (!this.field_146124_l) {
/*    */         
/* 56 */         var6 = -6250336;
/*    */       }
/* 58 */       else if (this.field_146123_n) {
/*    */         
/* 60 */         var6 = 16777120;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreGuiButtonsA3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */