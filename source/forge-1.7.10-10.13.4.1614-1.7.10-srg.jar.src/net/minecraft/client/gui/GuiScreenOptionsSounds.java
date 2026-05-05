/*     */ package net.minecraft.client.gui;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.audio.ISound;
/*     */ import net.minecraft.client.audio.PositionedSoundRecord;
/*     */ import net.minecraft.client.audio.SoundCategory;
/*     */ import net.minecraft.client.audio.SoundHandler;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.client.settings.GameSettings;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiScreenOptionsSounds extends GuiScreen {
/*     */   private final GuiScreen field_146505_f;
/*     */   private final GameSettings field_146506_g;
/*  19 */   protected String field_146507_a = "Options";
/*     */   private String field_146508_h;
/*     */   
/*     */   public GuiScreenOptionsSounds(GuiScreen p_i45025_1_, GameSettings p_i45025_2_) {
/*  23 */     this.field_146505_f = p_i45025_1_;
/*  24 */     this.field_146506_g = p_i45025_2_;
/*     */   }
/*     */   private static final String __OBFID = "CL_00000716";
/*     */   
/*     */   public void func_73866_w_() {
/*  29 */     byte b = 0;
/*  30 */     this.field_146507_a = I18n.func_135052_a("options.sounds.title", new Object[0]);
/*  31 */     this.field_146508_h = I18n.func_135052_a("options.off", new Object[0]);
/*     */     
/*  33 */     this.field_146292_n.add(new Button(this, SoundCategory.MASTER.func_147156_b(), this.field_146294_l / 2 - 155 + b % 2 * 160, this.field_146295_m / 6 - 12 + 24 * (b >> 1), SoundCategory.MASTER, true));
/*  34 */     b += 2;
/*     */     
/*  36 */     for (SoundCategory soundCategory : SoundCategory.values()) {
/*  37 */       if (soundCategory != SoundCategory.MASTER) {
/*  38 */         this.field_146292_n.add(new Button(this, soundCategory.func_147156_b(), this.field_146294_l / 2 - 155 + b % 2 * 160, this.field_146295_m / 6 - 12 + 24 * (b >> 1), soundCategory, false));
/*     */         
/*  40 */         b++;
/*     */       } 
/*     */     } 
/*     */     
/*  44 */     this.field_146292_n.add(new GuiButton(200, this.field_146294_l / 2 - 100, this.field_146295_m / 6 + 168, I18n.func_135052_a("gui.done", new Object[0])));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton p_146284_1_) {
/*  49 */     if (!p_146284_1_.field_146124_l)
/*     */       return; 
/*  51 */     if (p_146284_1_.field_146127_k == 200) {
/*  52 */       this.field_146297_k.field_71474_y.func_74303_b();
/*  53 */       this.field_146297_k.func_147108_a(this.field_146505_f);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/*  59 */     func_146276_q_();
/*  60 */     func_73732_a(this.field_146289_q, this.field_146507_a, this.field_146294_l / 2, 15, 16777215);
/*  61 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*     */   }
/*     */   
/*     */   protected String func_146504_a(SoundCategory p_146504_1_) {
/*  65 */     float f = this.field_146506_g.func_151438_a(p_146504_1_);
/*     */     
/*  67 */     if (f == 0.0F) {
/*  68 */       return this.field_146508_h;
/*     */     }
/*  70 */     return (int)(f * 100.0F) + "%";
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   class Button extends GuiButton {
/*     */     private final SoundCategory field_146153_r;
/*     */     private final String field_146152_s;
/*  77 */     public float field_146156_o = 1.0F; public boolean field_146155_p;
/*     */     private static final String __OBFID = "CL_00000717";
/*     */     
/*     */     public Button(GuiScreenOptionsSounds p_i45024_1_, int p_i45024_2_, int p_i45024_3_, int p_i45024_4_, SoundCategory p_i45024_5_, boolean p_i45024_6_) {
/*  81 */       super(p_i45024_2_, p_i45024_3_, p_i45024_4_, p_i45024_6_ ? 310 : 150, 20, "");
/*  82 */       this.field_146153_r = p_i45024_5_;
/*  83 */       this.field_146152_s = I18n.func_135052_a("soundCategory." + p_i45024_5_.func_147155_a(), new Object[0]);
/*  84 */       this.field_146126_j = this.field_146152_s + ": " + p_i45024_1_.func_146504_a(p_i45024_5_);
/*  85 */       this.field_146156_o = p_i45024_1_.field_146506_g.func_151438_a(p_i45024_5_);
/*     */     }
/*     */ 
/*     */     
/*     */     public int func_146114_a(boolean p_146114_1_) {
/*  90 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void func_146119_b(Minecraft p_146119_1_, int p_146119_2_, int p_146119_3_) {
/*  95 */       if (!this.field_146125_m)
/*     */         return; 
/*  97 */       if (this.field_146155_p) {
/*  98 */         this.field_146156_o = (p_146119_2_ - this.field_146128_h + 4) / (this.field_146120_f - 8);
/*  99 */         if (this.field_146156_o < 0.0F) this.field_146156_o = 0.0F; 
/* 100 */         if (this.field_146156_o > 1.0F) this.field_146156_o = 1.0F; 
/* 101 */         p_146119_1_.field_71474_y.func_151439_a(this.field_146153_r, this.field_146156_o);
/* 102 */         p_146119_1_.field_71474_y.func_74303_b();
/* 103 */         this.field_146126_j = this.field_146152_s + ": " + this.field_146154_q.func_146504_a(this.field_146153_r);
/*     */       } 
/*     */       
/* 106 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 107 */       func_73729_b(this.field_146128_h + (int)(this.field_146156_o * (this.field_146120_f - 8)), this.field_146129_i, 0, 66, 4, 20);
/* 108 */       func_73729_b(this.field_146128_h + (int)(this.field_146156_o * (this.field_146120_f - 8)) + 4, this.field_146129_i, 196, 66, 4, 20);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean func_146116_c(Minecraft p_146116_1_, int p_146116_2_, int p_146116_3_) {
/* 113 */       if (super.func_146116_c(p_146116_1_, p_146116_2_, p_146116_3_)) {
/* 114 */         this.field_146156_o = (p_146116_2_ - this.field_146128_h + 4) / (this.field_146120_f - 8);
/* 115 */         if (this.field_146156_o < 0.0F) this.field_146156_o = 0.0F; 
/* 116 */         if (this.field_146156_o > 1.0F) this.field_146156_o = 1.0F; 
/* 117 */         p_146116_1_.field_71474_y.func_151439_a(this.field_146153_r, this.field_146156_o);
/* 118 */         p_146116_1_.field_71474_y.func_74303_b();
/* 119 */         this.field_146126_j = this.field_146152_s + ": " + this.field_146154_q.func_146504_a(this.field_146153_r);
/* 120 */         this.field_146155_p = true;
/* 121 */         return true;
/*     */       } 
/*     */       
/* 124 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void func_146113_a(SoundHandler p_146113_1_) {}
/*     */ 
/*     */     
/*     */     public void func_146118_a(int p_146118_1_, int p_146118_2_) {
/* 133 */       if (this.field_146155_p) {
/* 134 */         float f = (this.field_146153_r == SoundCategory.MASTER) ? 1.0F : this.field_146154_q.field_146506_g.func_151438_a(this.field_146153_r);
/* 135 */         this.field_146154_q.field_146297_k.func_147118_V().func_147682_a((ISound)PositionedSoundRecord.func_147674_a(new ResourceLocation("gui.button.press"), 1.0F));
/*     */       } 
/* 137 */       this.field_146155_p = false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiScreenOptionsSounds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */