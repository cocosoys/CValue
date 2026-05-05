/*    */ package net.minecraft.client.gui;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GuiButtonLanguage extends GuiButton {
/*    */   public GuiButtonLanguage(int p_i1041_1_, int p_i1041_2_, int p_i1041_3_) {
/* 11 */     super(p_i1041_1_, p_i1041_2_, p_i1041_3_, 20, 20, "");
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_146112_a(Minecraft p_146112_1_, int p_146112_2_, int p_146112_3_) {
/* 16 */     if (!this.field_146125_m)
/*    */       return; 
/* 18 */     p_146112_1_.func_110434_K().func_110577_a(GuiButton.field_146122_a);
/* 19 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*    */     
/* 21 */     boolean bool = (p_146112_2_ >= this.field_146128_h && p_146112_3_ >= this.field_146129_i && p_146112_2_ < this.field_146128_h + this.field_146120_f && p_146112_3_ < this.field_146129_i + this.field_146121_g) ? true : false;
/* 22 */     int i = 106;
/* 23 */     if (bool) {
/* 24 */       i += this.field_146121_g;
/*    */     }
/*    */     
/* 27 */     func_73729_b(this.field_146128_h, this.field_146129_i, 0, i, this.field_146120_f, this.field_146121_g);
/*    */   }
/*    */   
/*    */   private static final String __OBFID = "CL_00000672";
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiButtonLanguage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */