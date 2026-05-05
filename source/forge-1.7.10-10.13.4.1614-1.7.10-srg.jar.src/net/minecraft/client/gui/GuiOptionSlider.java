/*    */ package net.minecraft.client.gui;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.settings.GameSettings;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GuiOptionSlider extends GuiButton {
/* 10 */   private float field_146134_p = 1.0F; public boolean field_146135_o;
/*    */   private GameSettings.Options field_146133_q;
/*    */   private final float field_146132_r;
/*    */   private final float field_146131_s;
/*    */   private static final String __OBFID = "CL_00000680";
/*    */   
/*    */   public GuiOptionSlider(int p_i45016_1_, int p_i45016_2_, int p_i45016_3_, GameSettings.Options p_i45016_4_) {
/* 17 */     this(p_i45016_1_, p_i45016_2_, p_i45016_3_, p_i45016_4_, 0.0F, 1.0F);
/*    */   }
/*    */   
/*    */   public GuiOptionSlider(int p_i45017_1_, int p_i45017_2_, int p_i45017_3_, GameSettings.Options p_i45017_4_, float p_i45017_5_, float p_i45017_6_) {
/* 21 */     super(p_i45017_1_, p_i45017_2_, p_i45017_3_, 150, 20, "");
/* 22 */     this.field_146133_q = p_i45017_4_;
/* 23 */     this.field_146132_r = p_i45017_5_;
/* 24 */     this.field_146131_s = p_i45017_6_;
/*    */     
/* 26 */     Minecraft minecraft = Minecraft.func_71410_x();
/* 27 */     this.field_146134_p = p_i45017_4_.func_148266_c(minecraft.field_71474_y.func_74296_a(p_i45017_4_));
/* 28 */     this.field_146126_j = minecraft.field_71474_y.func_74297_c(p_i45017_4_);
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_146114_a(boolean p_146114_1_) {
/* 33 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_146119_b(Minecraft p_146119_1_, int p_146119_2_, int p_146119_3_) {
/* 38 */     if (!this.field_146125_m)
/*    */       return; 
/* 40 */     if (this.field_146135_o) {
/* 41 */       this.field_146134_p = (p_146119_2_ - this.field_146128_h + 4) / (this.field_146120_f - 8);
/* 42 */       if (this.field_146134_p < 0.0F) this.field_146134_p = 0.0F; 
/* 43 */       if (this.field_146134_p > 1.0F) this.field_146134_p = 1.0F; 
/* 44 */       float f = this.field_146133_q.func_148262_d(this.field_146134_p);
/* 45 */       p_146119_1_.field_71474_y.func_74304_a(this.field_146133_q, f);
/* 46 */       this.field_146134_p = this.field_146133_q.func_148266_c(f);
/* 47 */       this.field_146126_j = p_146119_1_.field_71474_y.func_74297_c(this.field_146133_q);
/*    */     } 
/*    */     
/* 50 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 51 */     func_73729_b(this.field_146128_h + (int)(this.field_146134_p * (this.field_146120_f - 8)), this.field_146129_i, 0, 66, 4, 20);
/* 52 */     func_73729_b(this.field_146128_h + (int)(this.field_146134_p * (this.field_146120_f - 8)) + 4, this.field_146129_i, 196, 66, 4, 20);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_146116_c(Minecraft p_146116_1_, int p_146116_2_, int p_146116_3_) {
/* 57 */     if (super.func_146116_c(p_146116_1_, p_146116_2_, p_146116_3_)) {
/* 58 */       this.field_146134_p = (p_146116_2_ - this.field_146128_h + 4) / (this.field_146120_f - 8);
/* 59 */       if (this.field_146134_p < 0.0F) this.field_146134_p = 0.0F; 
/* 60 */       if (this.field_146134_p > 1.0F) this.field_146134_p = 1.0F; 
/* 61 */       p_146116_1_.field_71474_y.func_74304_a(this.field_146133_q, this.field_146133_q.func_148262_d(this.field_146134_p));
/* 62 */       this.field_146126_j = p_146116_1_.field_71474_y.func_74297_c(this.field_146133_q);
/* 63 */       this.field_146135_o = true;
/* 64 */       return true;
/*    */     } 
/*    */     
/* 67 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_146118_a(int p_146118_1_, int p_146118_2_) {
/* 72 */     this.field_146135_o = false;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiOptionSlider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */