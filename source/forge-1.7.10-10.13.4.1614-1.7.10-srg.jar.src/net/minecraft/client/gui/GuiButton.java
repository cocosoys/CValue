/*    */ package net.minecraft.client.gui;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.audio.ISound;
/*    */ import net.minecraft.client.audio.SoundHandler;
/*    */ import net.minecraft.client.renderer.OpenGlHelper;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GuiButton extends Gui {
/* 12 */   protected static final ResourceLocation field_146122_a = new ResourceLocation("textures/gui/widgets.png");
/*    */   
/* 14 */   public int field_146120_f = 200;
/* 15 */   public int field_146121_g = 20; public int field_146128_h; public int field_146129_i;
/*    */   public String field_146126_j;
/*    */   public int field_146127_k;
/*    */   public boolean field_146124_l = true;
/*    */   public boolean field_146125_m = true;
/*    */   protected boolean field_146123_n;
/*    */   private static final String __OBFID = "CL_00000668";
/*    */   
/*    */   public GuiButton(int p_i1020_1_, int p_i1020_2_, int p_i1020_3_, String p_i1020_4_) {
/* 24 */     this(p_i1020_1_, p_i1020_2_, p_i1020_3_, 200, 20, p_i1020_4_);
/*    */   }
/*    */   
/*    */   public GuiButton(int p_i1021_1_, int p_i1021_2_, int p_i1021_3_, int p_i1021_4_, int p_i1021_5_, String p_i1021_6_) {
/* 28 */     this.field_146127_k = p_i1021_1_;
/* 29 */     this.field_146128_h = p_i1021_2_;
/* 30 */     this.field_146129_i = p_i1021_3_;
/* 31 */     this.field_146120_f = p_i1021_4_;
/* 32 */     this.field_146121_g = p_i1021_5_;
/* 33 */     this.field_146126_j = p_i1021_6_;
/*    */   }
/*    */   
/*    */   public int func_146114_a(boolean p_146114_1_) {
/* 37 */     byte b = 1;
/* 38 */     if (!this.field_146124_l) { b = 0; }
/* 39 */     else if (p_146114_1_) { b = 2; }
/* 40 */      return b;
/*    */   }
/*    */   
/*    */   public void func_146112_a(Minecraft p_146112_1_, int p_146112_2_, int p_146112_3_) {
/* 44 */     if (!this.field_146125_m)
/*    */       return; 
/* 46 */     FontRenderer fontRenderer = p_146112_1_.field_71466_p;
/*    */     
/* 48 */     p_146112_1_.func_110434_K().func_110577_a(field_146122_a);
/* 49 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*    */     
/* 51 */     this.field_146123_n = (p_146112_2_ >= this.field_146128_h && p_146112_3_ >= this.field_146129_i && p_146112_2_ < this.field_146128_h + this.field_146120_f && p_146112_3_ < this.field_146129_i + this.field_146121_g);
/* 52 */     int i = func_146114_a(this.field_146123_n);
/*    */     
/* 54 */     GL11.glEnable(3042);
/* 55 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/* 56 */     GL11.glBlendFunc(770, 771);
/* 57 */     func_73729_b(this.field_146128_h, this.field_146129_i, 0, 46 + i * 20, this.field_146120_f / 2, this.field_146121_g);
/* 58 */     func_73729_b(this.field_146128_h + this.field_146120_f / 2, this.field_146129_i, 200 - this.field_146120_f / 2, 46 + i * 20, this.field_146120_f / 2, this.field_146121_g);
/*    */     
/* 60 */     func_146119_b(p_146112_1_, p_146112_2_, p_146112_3_);
/*    */     
/* 62 */     int j = 14737632;
/* 63 */     if (!this.field_146124_l) {
/* 64 */       j = 10526880;
/* 65 */     } else if (this.field_146123_n) {
/* 66 */       j = 16777120;
/*    */     } 
/* 68 */     func_73732_a(fontRenderer, this.field_146126_j, this.field_146128_h + this.field_146120_f / 2, this.field_146129_i + (this.field_146121_g - 8) / 2, j);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_146119_b(Minecraft p_146119_1_, int p_146119_2_, int p_146119_3_) {}
/*    */ 
/*    */   
/*    */   public void func_146118_a(int p_146118_1_, int p_146118_2_) {}
/*    */   
/*    */   public boolean func_146116_c(Minecraft p_146116_1_, int p_146116_2_, int p_146116_3_) {
/* 78 */     return (this.field_146124_l && this.field_146125_m && p_146116_2_ >= this.field_146128_h && p_146116_3_ >= this.field_146129_i && p_146116_2_ < this.field_146128_h + this.field_146120_f && p_146116_3_ < this.field_146129_i + this.field_146121_g);
/*    */   }
/*    */   
/*    */   public boolean func_146115_a() {
/* 82 */     return this.field_146123_n;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_146111_b(int p_146111_1_, int p_146111_2_) {}
/*    */ 
/*    */   
/*    */   public void func_146113_a(SoundHandler p_146113_1_) {
/* 90 */     p_146113_1_.func_147682_a((ISound)PositionedSoundRecord.func_147674_a(new ResourceLocation("gui.button.press"), 1.0F));
/*    */   }
/*    */   
/*    */   public int func_146117_b() {
/* 94 */     return this.field_146120_f;
/*    */   }
/*    */   
/*    */   public int func_154310_c() {
/* 98 */     return this.field_146121_g;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */