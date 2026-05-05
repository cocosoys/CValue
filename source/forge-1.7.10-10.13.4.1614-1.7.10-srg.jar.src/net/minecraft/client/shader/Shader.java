/*     */ package net.minecraft.client.shader;
/*     */ 
/*     */ import com.google.common.collect.Lists;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import javax.vecmath.Matrix4f;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.resources.IResourceManager;
/*     */ import net.minecraft.client.util.JsonException;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class Shader {
/*     */   private final ShaderManager field_148051_c;
/*     */   public final Framebuffer field_148052_a;
/*     */   public final Framebuffer field_148050_b;
/*  19 */   private final List field_148048_d = Lists.newArrayList();
/*  20 */   private final List field_148049_e = Lists.newArrayList();
/*  21 */   private final List field_148046_f = Lists.newArrayList();
/*  22 */   private final List field_148047_g = Lists.newArrayList();
/*     */   private Matrix4f field_148053_h;
/*     */   
/*     */   public Shader(IResourceManager p_i45089_1_, String p_i45089_2_, Framebuffer p_i45089_3_, Framebuffer p_i45089_4_) throws JsonException {
/*  26 */     this.field_148051_c = new ShaderManager(p_i45089_1_, p_i45089_2_);
/*  27 */     this.field_148052_a = p_i45089_3_;
/*  28 */     this.field_148050_b = p_i45089_4_;
/*     */   }
/*     */ 
/*     */   
/*     */   private static final String __OBFID = "CL_00001042";
/*     */ 
/*     */   
/*     */   public void func_148044_b() {
/*  36 */     this.field_148051_c.func_147988_a();
/*     */   }
/*     */   
/*     */   public void func_148041_a(String p_148041_1_, Object p_148041_2_, int p_148041_3_, int p_148041_4_) {
/*  40 */     this.field_148049_e.add(this.field_148049_e.size(), p_148041_1_);
/*  41 */     this.field_148048_d.add(this.field_148048_d.size(), p_148041_2_);
/*  42 */     this.field_148046_f.add(this.field_148046_f.size(), Integer.valueOf(p_148041_3_));
/*  43 */     this.field_148047_g.add(this.field_148047_g.size(), Integer.valueOf(p_148041_4_));
/*     */   }
/*     */   
/*     */   private void func_148040_d() {
/*  47 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  48 */     GL11.glDisable(3042);
/*  49 */     GL11.glDisable(2929);
/*  50 */     GL11.glDisable(3008);
/*  51 */     GL11.glDisable(2912);
/*  52 */     GL11.glDisable(2896);
/*  53 */     GL11.glDisable(2903);
/*  54 */     GL11.glEnable(3553);
/*  55 */     GL11.glBindTexture(3553, 0);
/*     */   }
/*     */   
/*     */   public void func_148045_a(Matrix4f p_148045_1_) {
/*  59 */     this.field_148053_h = p_148045_1_;
/*     */   }
/*     */   
/*     */   public void func_148042_a(float p_148042_1_) {
/*  63 */     func_148040_d();
/*  64 */     this.field_148052_a.func_147609_e();
/*     */     
/*  66 */     float f1 = this.field_148050_b.field_147622_a;
/*  67 */     float f2 = this.field_148050_b.field_147620_b;
/*  68 */     GL11.glViewport(0, 0, (int)f1, (int)f2);
/*     */     
/*  70 */     this.field_148051_c.func_147992_a("DiffuseSampler", this.field_148052_a);
/*     */ 
/*     */     
/*  73 */     for (byte b = 0; b < this.field_148048_d.size(); b++) {
/*  74 */       this.field_148051_c.func_147992_a(this.field_148049_e.get(b), this.field_148048_d.get(b));
/*  75 */       this.field_148051_c.func_147984_b("AuxSize" + b).func_148087_a(((Integer)this.field_148046_f.get(b)).intValue(), ((Integer)this.field_148047_g.get(b)).intValue());
/*     */     } 
/*     */     
/*  78 */     this.field_148051_c.func_147984_b("ProjMat").func_148088_a(this.field_148053_h);
/*  79 */     this.field_148051_c.func_147984_b("InSize").func_148087_a(this.field_148052_a.field_147622_a, this.field_148052_a.field_147620_b);
/*  80 */     this.field_148051_c.func_147984_b("OutSize").func_148087_a(f1, f2);
/*  81 */     this.field_148051_c.func_147984_b("Time").func_148090_a(p_148042_1_);
/*     */     
/*  83 */     Minecraft minecraft = Minecraft.func_71410_x();
/*  84 */     this.field_148051_c.func_147984_b("ScreenSize").func_148087_a(minecraft.field_71443_c, minecraft.field_71440_d);
/*  85 */     this.field_148051_c.func_147995_c();
/*  86 */     this.field_148050_b.func_147614_f();
/*  87 */     this.field_148050_b.func_147610_a(false);
/*     */     
/*  89 */     GL11.glDepthMask(false);
/*  90 */     GL11.glColorMask(true, true, true, false);
/*     */ 
/*     */     
/*  93 */     Tessellator tessellator = Tessellator.field_78398_a;
/*  94 */     tessellator.func_78382_b();
/*  95 */     tessellator.func_78378_d(-1);
/*  96 */     tessellator.func_78377_a(0.0D, f2, 500.0D);
/*  97 */     tessellator.func_78377_a(f1, f2, 500.0D);
/*  98 */     tessellator.func_78377_a(f1, 0.0D, 500.0D);
/*  99 */     tessellator.func_78377_a(0.0D, 0.0D, 500.0D);
/* 100 */     tessellator.func_78381_a();
/*     */     
/* 102 */     GL11.glDepthMask(true);
/* 103 */     GL11.glColorMask(true, true, true, true);
/*     */     
/* 105 */     this.field_148051_c.func_147993_b();
/* 106 */     this.field_148050_b.func_147609_e();
/* 107 */     this.field_148052_a.func_147606_d();
/* 108 */     for (Framebuffer framebuffer : this.field_148048_d) {
/* 109 */       if (framebuffer instanceof Framebuffer) {
/* 110 */         ((Framebuffer)framebuffer).func_147606_d();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public ShaderManager func_148043_c() {
/* 116 */     return this.field_148051_c;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\shader\Shader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */