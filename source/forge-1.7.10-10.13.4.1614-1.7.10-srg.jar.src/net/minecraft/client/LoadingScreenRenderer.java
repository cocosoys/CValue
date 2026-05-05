/*     */ package net.minecraft.client;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.shader.Framebuffer;
/*     */ import net.minecraft.util.IProgressUpdate;
/*     */ import net.minecraft.util.MinecraftError;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class LoadingScreenRenderer implements IProgressUpdate {
/*  15 */   private String field_73727_a = "";
/*     */   private Minecraft field_73725_b;
/*  17 */   private String field_73726_c = "";
/*  18 */   private long field_73723_d = Minecraft.func_71386_F(); private boolean field_73724_e;
/*     */   private ScaledResolution field_146587_f;
/*     */   private Framebuffer field_146588_g;
/*     */   private static final String __OBFID = "CL_00000655";
/*     */   
/*     */   public LoadingScreenRenderer(Minecraft p_i1017_1_) {
/*  24 */     this.field_73725_b = p_i1017_1_;
/*  25 */     this.field_146587_f = new ScaledResolution(p_i1017_1_, p_i1017_1_.field_71443_c, p_i1017_1_.field_71440_d);
/*  26 */     this.field_146588_g = new Framebuffer(p_i1017_1_.field_71443_c, p_i1017_1_.field_71440_d, false);
/*  27 */     this.field_146588_g.func_147607_a(9728);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73721_b(String p_73721_1_) {
/*  32 */     this.field_73724_e = false;
/*  33 */     func_73722_d(p_73721_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73720_a(String p_73720_1_) {
/*  38 */     this.field_73724_e = true;
/*  39 */     func_73722_d(p_73720_1_);
/*     */   }
/*     */   
/*     */   public void func_73722_d(String p_73722_1_) {
/*  43 */     this.field_73726_c = p_73722_1_;
/*  44 */     if (!this.field_73725_b.field_71425_J) {
/*  45 */       if (this.field_73724_e)
/*  46 */         return;  throw new MinecraftError();
/*     */     } 
/*     */     
/*  49 */     GL11.glClear(256);
/*  50 */     GL11.glMatrixMode(5889);
/*  51 */     GL11.glLoadIdentity();
/*  52 */     if (OpenGlHelper.func_148822_b()) {
/*  53 */       int i = this.field_146587_f.func_78325_e();
/*  54 */       GL11.glOrtho(0.0D, (this.field_146587_f.func_78326_a() * i), (this.field_146587_f.func_78328_b() * i), 0.0D, 100.0D, 300.0D);
/*     */     } else {
/*  56 */       ScaledResolution scaledResolution = new ScaledResolution(this.field_73725_b, this.field_73725_b.field_71443_c, this.field_73725_b.field_71440_d);
/*  57 */       GL11.glOrtho(0.0D, scaledResolution.func_78327_c(), scaledResolution.func_78324_d(), 0.0D, 100.0D, 300.0D);
/*     */     } 
/*  59 */     GL11.glMatrixMode(5888);
/*  60 */     GL11.glLoadIdentity();
/*  61 */     GL11.glTranslatef(0.0F, 0.0F, -200.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73719_c(String p_73719_1_) {
/*  66 */     if (!this.field_73725_b.field_71425_J) {
/*  67 */       if (this.field_73724_e)
/*  68 */         return;  throw new MinecraftError();
/*     */     } 
/*     */     
/*  71 */     this.field_73723_d = 0L;
/*  72 */     this.field_73727_a = p_73719_1_;
/*  73 */     func_73718_a(-1);
/*  74 */     this.field_73723_d = 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73718_a(int p_73718_1_) {
/*  79 */     if (!this.field_73725_b.field_71425_J) {
/*  80 */       if (this.field_73724_e)
/*  81 */         return;  throw new MinecraftError();
/*     */     } 
/*     */     
/*  84 */     long l = Minecraft.func_71386_F();
/*  85 */     if (l - this.field_73723_d < 100L)
/*  86 */       return;  this.field_73723_d = l;
/*     */     
/*  88 */     ScaledResolution scaledResolution = new ScaledResolution(this.field_73725_b, this.field_73725_b.field_71443_c, this.field_73725_b.field_71440_d);
/*  89 */     int i = scaledResolution.func_78325_e();
/*  90 */     int j = scaledResolution.func_78326_a();
/*  91 */     int k = scaledResolution.func_78328_b();
/*     */     
/*  93 */     if (OpenGlHelper.func_148822_b()) {
/*  94 */       this.field_146588_g.func_147614_f();
/*     */     } else {
/*  96 */       GL11.glClear(256);
/*     */     } 
/*  98 */     this.field_146588_g.func_147610_a(false);
/*  99 */     GL11.glMatrixMode(5889);
/* 100 */     GL11.glLoadIdentity();
/* 101 */     GL11.glOrtho(0.0D, scaledResolution.func_78327_c(), scaledResolution.func_78324_d(), 0.0D, 100.0D, 300.0D);
/* 102 */     GL11.glMatrixMode(5888);
/* 103 */     GL11.glLoadIdentity();
/* 104 */     GL11.glTranslatef(0.0F, 0.0F, -200.0F);
/*     */     
/* 106 */     if (!OpenGlHelper.func_148822_b()) {
/* 107 */       GL11.glClear(16640);
/*     */     }
/*     */     
/* 110 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 111 */     this.field_73725_b.func_110434_K().func_110577_a(Gui.field_110325_k);
/* 112 */     float f = 32.0F;
/* 113 */     tessellator.func_78382_b();
/* 114 */     tessellator.func_78378_d(4210752);
/* 115 */     tessellator.func_78374_a(0.0D, k, 0.0D, 0.0D, (k / f));
/* 116 */     tessellator.func_78374_a(j, k, 0.0D, (j / f), (k / f));
/* 117 */     tessellator.func_78374_a(j, 0.0D, 0.0D, (j / f), 0.0D);
/* 118 */     tessellator.func_78374_a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
/* 119 */     tessellator.func_78381_a();
/*     */     
/* 121 */     if (p_73718_1_ >= 0) {
/* 122 */       byte b1 = 100;
/* 123 */       byte b2 = 2;
/* 124 */       int m = j / 2 - b1 / 2;
/* 125 */       int n = k / 2 + 16;
/*     */       
/* 127 */       GL11.glDisable(3553);
/* 128 */       tessellator.func_78382_b();
/* 129 */       tessellator.func_78378_d(8421504);
/* 130 */       tessellator.func_78377_a(m, n, 0.0D);
/* 131 */       tessellator.func_78377_a(m, (n + b2), 0.0D);
/* 132 */       tessellator.func_78377_a((m + b1), (n + b2), 0.0D);
/* 133 */       tessellator.func_78377_a((m + b1), n, 0.0D);
/*     */       
/* 135 */       tessellator.func_78378_d(8454016);
/* 136 */       tessellator.func_78377_a(m, n, 0.0D);
/* 137 */       tessellator.func_78377_a(m, (n + b2), 0.0D);
/* 138 */       tessellator.func_78377_a((m + p_73718_1_), (n + b2), 0.0D);
/* 139 */       tessellator.func_78377_a((m + p_73718_1_), n, 0.0D);
/* 140 */       tessellator.func_78381_a();
/* 141 */       GL11.glEnable(3553);
/*     */     } 
/*     */     
/* 144 */     GL11.glEnable(3042);
/* 145 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/* 146 */     this.field_73725_b.field_71466_p.func_78261_a(this.field_73726_c, (j - this.field_73725_b.field_71466_p.func_78256_a(this.field_73726_c)) / 2, k / 2 - 4 - 16, 16777215);
/* 147 */     this.field_73725_b.field_71466_p.func_78261_a(this.field_73727_a, (j - this.field_73725_b.field_71466_p.func_78256_a(this.field_73727_a)) / 2, k / 2 - 4 + 8, 16777215);
/* 148 */     this.field_146588_g.func_147609_e();
/* 149 */     if (OpenGlHelper.func_148822_b()) {
/* 150 */       this.field_146588_g.func_147615_c(j * i, k * i);
/*     */     }
/* 152 */     this.field_73725_b.func_147120_f();
/*     */     
/*     */     try {
/* 155 */       Thread.yield();
/* 156 */     } catch (Exception exception) {}
/*     */   }
/*     */   
/*     */   public void func_146586_a() {}
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\LoadingScreenRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */