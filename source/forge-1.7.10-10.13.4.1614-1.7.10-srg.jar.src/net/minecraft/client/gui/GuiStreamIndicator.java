/*     */ package net.minecraft.client.gui;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiStreamIndicator {
/*  11 */   private static final ResourceLocation field_152441_a = new ResourceLocation("textures/gui/stream_indicator.png");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Minecraft field_152442_b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  23 */   private float field_152443_c = 1.0F;
/*  24 */   private int field_152444_d = 1; private static final String __OBFID = "CL_00001849";
/*     */   
/*     */   public GuiStreamIndicator(Minecraft p_i1092_1_) {
/*  27 */     this.field_152442_b = p_i1092_1_;
/*     */   }
/*     */   
/*     */   public void func_152437_a(int p_152437_1_, int p_152437_2_) {
/*  31 */     if (this.field_152442_b.func_152346_Z().func_152934_n()) {
/*  32 */       GL11.glEnable(3042);
/*     */ 
/*     */       
/*  35 */       int i = this.field_152442_b.func_152346_Z().func_152920_A();
/*  36 */       if (i > 0) {
/*  37 */         String str = "" + i;
/*  38 */         int j = this.field_152442_b.field_71466_p.func_78256_a(str);
/*  39 */         byte b = 20;
/*     */         
/*  41 */         int k = p_152437_1_ - j - 1;
/*  42 */         int m = p_152437_2_ + 20 - 1;
/*  43 */         int n = p_152437_1_;
/*  44 */         int i1 = p_152437_2_ + 20 + this.field_152442_b.field_71466_p.field_78288_b - 1;
/*  45 */         GL11.glDisable(3553);
/*  46 */         Tessellator tessellator = Tessellator.field_78398_a;
/*  47 */         GL11.glColor4f(0.0F, 0.0F, 0.0F, (0.65F + 0.35000002F * this.field_152443_c) / 2.0F);
/*  48 */         tessellator.func_78382_b();
/*  49 */         tessellator.func_78377_a(k, i1, 0.0D);
/*  50 */         tessellator.func_78377_a(n, i1, 0.0D);
/*  51 */         tessellator.func_78377_a(n, m, 0.0D);
/*  52 */         tessellator.func_78377_a(k, m, 0.0D);
/*  53 */         tessellator.func_78381_a();
/*  54 */         GL11.glEnable(3553);
/*  55 */         this.field_152442_b.field_71466_p.func_78276_b(str, p_152437_1_ - j, p_152437_2_ + 20, 16777215);
/*     */       } 
/*     */ 
/*     */       
/*  59 */       func_152436_a(p_152437_1_, p_152437_2_, func_152440_b(), 0);
/*     */ 
/*     */       
/*  62 */       func_152436_a(p_152437_1_, p_152437_2_, func_152438_c(), 17);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_152436_a(int p_152436_1_, int p_152436_2_, int p_152436_3_, int p_152436_4_) {
/*  67 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.65F + 0.35000002F * this.field_152443_c);
/*  68 */     this.field_152442_b.func_110434_K().func_110577_a(field_152441_a);
/*  69 */     float f1 = 150.0F;
/*     */     
/*  71 */     float f2 = 0.0F;
/*  72 */     float f3 = p_152436_3_ * 0.015625F;
/*  73 */     float f4 = 1.0F;
/*  74 */     float f5 = (p_152436_3_ + 16) * 0.015625F;
/*     */     
/*  76 */     Tessellator tessellator = Tessellator.field_78398_a;
/*  77 */     tessellator.func_78382_b();
/*  78 */     tessellator.func_78374_a((p_152436_1_ - 16 - p_152436_4_), (p_152436_2_ + 16), f1, f2, f5);
/*  79 */     tessellator.func_78374_a((p_152436_1_ - p_152436_4_), (p_152436_2_ + 16), f1, f4, f5);
/*  80 */     tessellator.func_78374_a((p_152436_1_ - p_152436_4_), (p_152436_2_ + 0), f1, f4, f3);
/*  81 */     tessellator.func_78374_a((p_152436_1_ - 16 - p_152436_4_), (p_152436_2_ + 0), f1, f2, f3);
/*  82 */     tessellator.func_78381_a();
/*  83 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   private int func_152440_b() {
/*  87 */     return this.field_152442_b.func_152346_Z().func_152919_o() ? 16 : 0;
/*     */   }
/*     */   
/*     */   private int func_152438_c() {
/*  91 */     return this.field_152442_b.func_152346_Z().func_152929_G() ? 48 : 32;
/*     */   }
/*     */   
/*     */   public void func_152439_a() {
/*  95 */     if (this.field_152442_b.func_152346_Z().func_152934_n()) {
/*  96 */       this.field_152443_c += 0.025F * this.field_152444_d;
/*     */       
/*  98 */       if (this.field_152443_c < 0.0F) {
/*  99 */         this.field_152444_d *= -1;
/* 100 */         this.field_152443_c = 0.0F;
/* 101 */       } else if (this.field_152443_c > 1.0F) {
/* 102 */         this.field_152444_d *= -1;
/* 103 */         this.field_152443_c = 1.0F;
/*     */       } 
/*     */     } else {
/* 106 */       this.field_152443_c = 1.0F;
/* 107 */       this.field_152444_d = 1;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiStreamIndicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */