/*     */ package net.minecraft.client.gui;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiLabel
/*     */   extends Gui
/*     */ {
/*     */   protected int field_146167_a;
/*     */   protected int field_146161_f;
/*     */   public int field_146162_g;
/*     */   public int field_146174_h;
/*     */   private ArrayList field_146173_k;
/*     */   private boolean field_146170_l;
/*     */   public boolean field_146172_j;
/*     */   private boolean field_146171_m;
/*     */   private int field_146168_n;
/*     */   private int field_146169_o;
/*     */   private int field_146166_p;
/*     */   private int field_146165_q;
/*     */   private FontRenderer field_146164_r;
/*     */   private int field_146163_s;
/*     */   private static final String __OBFID = "CL_00000671";
/*     */   
/*     */   public void func_146159_a(Minecraft p_146159_1_, int p_146159_2_, int p_146159_3_) {
/*  74 */     if (!this.field_146172_j)
/*     */       return; 
/*  76 */     GL11.glEnable(3042);
/*  77 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*  78 */     GL11.glBlendFunc(770, 771);
/*     */     
/*  80 */     func_146160_b(p_146159_1_, p_146159_2_, p_146159_3_);
/*  81 */     int i = this.field_146174_h + this.field_146161_f / 2 + this.field_146163_s / 2;
/*  82 */     int j = i - this.field_146173_k.size() * 10 / 2;
/*  83 */     for (byte b = 0; b < this.field_146173_k.size(); b++) {
/*  84 */       if (this.field_146170_l) {
/*  85 */         func_73732_a(this.field_146164_r, this.field_146173_k.get(b), this.field_146162_g + this.field_146167_a / 2, j + b * 10, this.field_146168_n);
/*     */       } else {
/*  87 */         func_73731_b(this.field_146164_r, this.field_146173_k.get(b), this.field_146162_g, j + b * 10, this.field_146168_n);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_146160_b(Minecraft p_146160_1_, int p_146160_2_, int p_146160_3_) {
/*  93 */     if (this.field_146171_m) {
/*  94 */       int i = this.field_146167_a + this.field_146163_s * 2;
/*  95 */       int j = this.field_146161_f + this.field_146163_s * 2;
/*  96 */       int k = this.field_146162_g - this.field_146163_s;
/*  97 */       int m = this.field_146174_h - this.field_146163_s;
/*  98 */       func_73734_a(k, m, k + i, m + j, this.field_146169_o);
/*  99 */       func_73730_a(k, k + i, m, this.field_146166_p);
/* 100 */       func_73730_a(k, k + i, m + j, this.field_146165_q);
/* 101 */       func_73728_b(k, m, m + j, this.field_146166_p);
/* 102 */       func_73728_b(k + i, m, m + j, this.field_146165_q);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiLabel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */