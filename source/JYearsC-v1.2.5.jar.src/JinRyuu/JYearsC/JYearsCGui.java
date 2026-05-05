/*    */ package JinRyuu.JYearsC;
/*    */ 
/*    */ import JinRyuu.JRMCore.JRMCoreClient;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.client.gui.ScaledResolution;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class JYearsCGui
/*    */   extends Gui
/*    */ {
/* 13 */   protected FontRenderer fontRenderer = JYearsCClient.mc.field_71466_p;
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
/*    */   
/*    */   private Minecraft mc;
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
/*    */ 
/*    */   
/*    */   public JYearsCGui() {
/* 45 */     this.mc = JRMCoreClient.mc;
/*    */   }
/*    */   public void watch(int i) {
/* 48 */     ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
/* 49 */     int var6 = var5.func_78326_a();
/* 50 */     int var7 = var5.func_78328_b();
/* 51 */     FontRenderer var8 = this.mc.field_71466_p;
/*    */ 
/*    */     
/* 54 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 55 */     this.field_73735_i = -89.0F;
/*    */ 
/*    */     
/* 58 */     int s = (int)(this.mc.field_71439_g.field_70170_p.func_72820_D() % 24000L / 1000L) + 6;
/* 59 */     int w = (s > 24) ? (s - 24) : s;
/* 60 */     int m = (int)(this.mc.field_71439_g.field_70170_p.func_72820_D() % 24000L - ((int)(this.mc.field_71439_g.field_70170_p.func_72820_D() % 24000L / 1000L) * 1000));
/* 61 */     float mi = m / 16.67F;
/* 62 */     int min = (int)mi;
/* 63 */     String var34 = ((w < 10) ? ("0" + w) : (String)Integer.valueOf(w)) + ":" + ((min < 10) ? ("0" + min) : (String)Integer.valueOf(min));
/* 64 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 65 */     int var38 = var6 / 2 + 80 + var8.func_78256_a(var34) / 2;
/* 66 */     int var37 = var7 - 10;
/* 67 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 68 */     var8.func_78276_b(var34, var38, var37, 15388564);
/* 69 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JYearsC-v1.2.5.jar!\JinRyuu\JYearsC\JYearsCGui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */