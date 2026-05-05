/*     */ package net.minecraft.client.gui.achievement;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.renderer.RenderHelper;
/*     */ import net.minecraft.client.renderer.entity.RenderItem;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.stats.Achievement;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiAchievement extends Gui {
/*  16 */   private static final ResourceLocation field_146261_a = new ResourceLocation("textures/gui/achievement/achievement_background.png"); private Minecraft field_146259_f;
/*     */   private int field_146260_g;
/*     */   private int field_146267_h;
/*     */   private String field_146268_i;
/*     */   private String field_146265_j;
/*     */   private Achievement field_146266_k;
/*     */   private long field_146263_l;
/*     */   private RenderItem field_146264_m;
/*     */   private boolean field_146262_n;
/*     */   private static final String __OBFID = "CL_00000721";
/*     */   
/*     */   public GuiAchievement(Minecraft p_i1063_1_) {
/*  28 */     this.field_146259_f = p_i1063_1_;
/*  29 */     this.field_146264_m = new RenderItem();
/*     */   }
/*     */   
/*     */   public void func_146256_a(Achievement p_146256_1_) {
/*  33 */     this.field_146268_i = I18n.func_135052_a("achievement.get", new Object[0]);
/*  34 */     this.field_146265_j = p_146256_1_.func_150951_e().func_150260_c();
/*  35 */     this.field_146263_l = Minecraft.func_71386_F();
/*  36 */     this.field_146266_k = p_146256_1_;
/*  37 */     this.field_146262_n = false;
/*     */   }
/*     */   
/*     */   public void func_146255_b(Achievement p_146255_1_) {
/*  41 */     this.field_146268_i = p_146255_1_.func_150951_e().func_150260_c();
/*  42 */     this.field_146265_j = p_146255_1_.func_75989_e();
/*     */     
/*  44 */     this.field_146263_l = Minecraft.func_71386_F() + 2500L;
/*  45 */     this.field_146266_k = p_146255_1_;
/*  46 */     this.field_146262_n = true;
/*     */   }
/*     */   
/*     */   private void func_146258_c() {
/*  50 */     GL11.glViewport(0, 0, this.field_146259_f.field_71443_c, this.field_146259_f.field_71440_d);
/*  51 */     GL11.glMatrixMode(5889);
/*  52 */     GL11.glLoadIdentity();
/*  53 */     GL11.glMatrixMode(5888);
/*  54 */     GL11.glLoadIdentity();
/*     */     
/*  56 */     this.field_146260_g = this.field_146259_f.field_71443_c;
/*  57 */     this.field_146267_h = this.field_146259_f.field_71440_d;
/*     */     
/*  59 */     ScaledResolution scaledResolution = new ScaledResolution(this.field_146259_f, this.field_146259_f.field_71443_c, this.field_146259_f.field_71440_d);
/*  60 */     this.field_146260_g = scaledResolution.func_78326_a();
/*  61 */     this.field_146267_h = scaledResolution.func_78328_b();
/*     */     
/*  63 */     GL11.glClear(256);
/*  64 */     GL11.glMatrixMode(5889);
/*  65 */     GL11.glLoadIdentity();
/*  66 */     GL11.glOrtho(0.0D, this.field_146260_g, this.field_146267_h, 0.0D, 1000.0D, 3000.0D);
/*  67 */     GL11.glMatrixMode(5888);
/*  68 */     GL11.glLoadIdentity();
/*  69 */     GL11.glTranslatef(0.0F, 0.0F, -2000.0F);
/*     */   }
/*     */   
/*     */   public void func_146254_a() {
/*  73 */     if (this.field_146266_k == null || this.field_146263_l == 0L || (Minecraft.func_71410_x()).field_71439_g == null)
/*     */       return; 
/*  75 */     double d1 = (Minecraft.func_71386_F() - this.field_146263_l) / 3000.0D;
/*  76 */     if (!this.field_146262_n)
/*  77 */     { if (d1 < 0.0D || d1 > 1.0D) {
/*  78 */         this.field_146263_l = 0L;
/*     */         
/*     */         return;
/*     */       }  }
/*  82 */     else if (d1 > 0.5D) { d1 = 0.5D; }
/*     */ 
/*     */     
/*  85 */     func_146258_c();
/*  86 */     GL11.glDisable(2929);
/*  87 */     GL11.glDepthMask(false);
/*     */     
/*  89 */     double d2 = d1 * 2.0D;
/*  90 */     if (d2 > 1.0D) d2 = 2.0D - d2; 
/*  91 */     d2 *= 4.0D;
/*  92 */     d2 = 1.0D - d2;
/*  93 */     if (d2 < 0.0D) d2 = 0.0D; 
/*  94 */     d2 *= d2;
/*  95 */     d2 *= d2;
/*     */     
/*  97 */     int i = this.field_146260_g - 160;
/*  98 */     int j = 0 - (int)(d2 * 36.0D);
/*  99 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 100 */     GL11.glEnable(3553);
/* 101 */     this.field_146259_f.func_110434_K().func_110577_a(field_146261_a);
/* 102 */     GL11.glDisable(2896);
/*     */     
/* 104 */     func_73729_b(i, j, 96, 202, 160, 32);
/*     */     
/* 106 */     if (this.field_146262_n) {
/* 107 */       this.field_146259_f.field_71466_p.func_78279_b(this.field_146265_j, i + 30, j + 7, 120, -1);
/*     */     } else {
/* 109 */       this.field_146259_f.field_71466_p.func_78276_b(this.field_146268_i, i + 30, j + 7, -256);
/* 110 */       this.field_146259_f.field_71466_p.func_78276_b(this.field_146265_j, i + 30, j + 18, -1);
/*     */     } 
/*     */     
/* 113 */     RenderHelper.func_74520_c();
/* 114 */     GL11.glDisable(2896);
/* 115 */     GL11.glEnable(32826);
/* 116 */     GL11.glEnable(2903);
/*     */     
/* 118 */     GL11.glEnable(2896);
/* 119 */     this.field_146264_m.func_82406_b(this.field_146259_f.field_71466_p, this.field_146259_f.func_110434_K(), this.field_146266_k.field_75990_d, i + 8, j + 8);
/* 120 */     GL11.glDisable(2896);
/*     */     
/* 122 */     GL11.glDepthMask(true);
/* 123 */     GL11.glEnable(2929);
/*     */   }
/*     */   
/*     */   public void func_146257_b() {
/* 127 */     this.field_146266_k = null;
/* 128 */     this.field_146263_l = 0L;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\achievement\GuiAchievement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */