/*     */ package net.minecraft.client.shader;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.nio.ByteBuffer;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.texture.TextureUtil;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class Framebuffer
/*     */ {
/*     */   public int field_147622_a;
/*     */   public int field_147620_b;
/*     */   public int field_147621_c;
/*     */   public int field_147618_d;
/*     */   public boolean field_147619_e;
/*     */   public int field_147616_f;
/*     */   public int field_147617_g;
/*     */   public int field_147624_h;
/*     */   public float[] field_147625_i;
/*     */   public int field_147623_j;
/*     */   private static final String __OBFID = "CL_00000959";
/*     */   
/*     */   public Framebuffer(int p_i45078_1_, int p_i45078_2_, boolean p_i45078_3_) {
/*  34 */     this.field_147619_e = p_i45078_3_;
/*     */     
/*  36 */     this.field_147616_f = -1;
/*  37 */     this.field_147617_g = -1;
/*  38 */     this.field_147624_h = -1;
/*     */     
/*  40 */     this.field_147625_i = new float[4];
/*  41 */     this.field_147625_i[0] = 1.0F;
/*  42 */     this.field_147625_i[1] = 1.0F;
/*  43 */     this.field_147625_i[2] = 1.0F;
/*  44 */     this.field_147625_i[3] = 0.0F;
/*     */     
/*  46 */     func_147613_a(p_i45078_1_, p_i45078_2_);
/*     */   }
/*     */   
/*     */   public void func_147613_a(int p_147613_1_, int p_147613_2_) {
/*  50 */     if (!OpenGlHelper.func_148822_b()) {
/*  51 */       this.field_147621_c = p_147613_1_;
/*  52 */       this.field_147618_d = p_147613_2_;
/*     */       return;
/*     */     } 
/*  55 */     GL11.glEnable(2929);
/*     */     
/*  57 */     if (this.field_147616_f >= 0) {
/*  58 */       func_147608_a();
/*     */     }
/*  60 */     func_147605_b(p_147613_1_, p_147613_2_);
/*  61 */     func_147611_b();
/*     */ 
/*     */     
/*  64 */     OpenGlHelper.func_153171_g(OpenGlHelper.field_153198_e, 0);
/*     */   }
/*     */   
/*     */   public void func_147608_a() {
/*  68 */     if (!OpenGlHelper.func_148822_b()) {
/*     */       return;
/*     */     }
/*     */     
/*  72 */     func_147606_d();
/*  73 */     func_147609_e();
/*     */     
/*  75 */     if (this.field_147624_h > -1) {
/*  76 */       OpenGlHelper.func_153184_g(this.field_147624_h);
/*  77 */       this.field_147624_h = -1;
/*     */     } 
/*  79 */     if (this.field_147617_g > -1) {
/*  80 */       TextureUtil.func_147942_a(this.field_147617_g);
/*  81 */       this.field_147617_g = -1;
/*     */     } 
/*  83 */     if (this.field_147616_f > -1) {
/*  84 */       OpenGlHelper.func_153171_g(OpenGlHelper.field_153198_e, 0);
/*  85 */       OpenGlHelper.func_153174_h(this.field_147616_f);
/*  86 */       this.field_147616_f = -1;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_147605_b(int p_147605_1_, int p_147605_2_) {
/*  91 */     this.field_147621_c = p_147605_1_;
/*  92 */     this.field_147618_d = p_147605_2_;
/*     */     
/*  94 */     this.field_147622_a = p_147605_1_;
/*  95 */     this.field_147620_b = p_147605_2_;
/*     */     
/*  97 */     if (!OpenGlHelper.func_148822_b()) {
/*  98 */       func_147614_f();
/*     */       
/*     */       return;
/*     */     } 
/* 102 */     this.field_147616_f = OpenGlHelper.func_153165_e();
/* 103 */     this.field_147617_g = TextureUtil.func_110996_a();
/* 104 */     if (this.field_147619_e) {
/* 105 */       this.field_147624_h = OpenGlHelper.func_153185_f();
/*     */     }
/*     */     
/* 108 */     func_147607_a(9728);
/* 109 */     GL11.glBindTexture(3553, this.field_147617_g);
/* 110 */     GL11.glTexImage2D(3553, 0, 32856, this.field_147622_a, this.field_147620_b, 0, 6408, 5121, (ByteBuffer)null);
/*     */     
/* 112 */     OpenGlHelper.func_153171_g(OpenGlHelper.field_153198_e, this.field_147616_f);
/* 113 */     OpenGlHelper.func_153188_a(OpenGlHelper.field_153198_e, OpenGlHelper.field_153200_g, 3553, this.field_147617_g, 0);
/*     */     
/* 115 */     if (this.field_147619_e) {
/*     */       
/* 117 */       OpenGlHelper.func_153176_h(OpenGlHelper.field_153199_f, this.field_147624_h);
/*     */ 
/*     */       
/* 120 */       OpenGlHelper.func_153186_a(OpenGlHelper.field_153199_f, 33190, this.field_147622_a, this.field_147620_b);
/*     */ 
/*     */       
/* 123 */       OpenGlHelper.func_153190_b(OpenGlHelper.field_153198_e, OpenGlHelper.field_153201_h, OpenGlHelper.field_153199_f, this.field_147624_h);
/*     */     } 
/*     */     
/* 126 */     func_147614_f();
/* 127 */     func_147606_d();
/*     */   }
/*     */   
/*     */   public void func_147607_a(int p_147607_1_) {
/* 131 */     if (OpenGlHelper.func_148822_b()) {
/* 132 */       this.field_147623_j = p_147607_1_;
/* 133 */       GL11.glBindTexture(3553, this.field_147617_g);
/* 134 */       GL11.glTexParameterf(3553, 10241, p_147607_1_);
/* 135 */       GL11.glTexParameterf(3553, 10240, p_147607_1_);
/* 136 */       GL11.glTexParameterf(3553, 10242, 10496.0F);
/* 137 */       GL11.glTexParameterf(3553, 10243, 10496.0F);
/* 138 */       GL11.glBindTexture(3553, 0);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_147611_b() {
/* 143 */     int i = OpenGlHelper.func_153167_i(OpenGlHelper.field_153198_e);
/* 144 */     if (i == OpenGlHelper.field_153202_i)
/*     */       return; 
/* 146 */     if (i == OpenGlHelper.field_153203_j)
/* 147 */       throw new RuntimeException("GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT"); 
/* 148 */     if (i == OpenGlHelper.field_153204_k)
/* 149 */       throw new RuntimeException("GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT"); 
/* 150 */     if (i == OpenGlHelper.field_153205_l)
/* 151 */       throw new RuntimeException("GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER"); 
/* 152 */     if (i == OpenGlHelper.field_153206_m) {
/* 153 */       throw new RuntimeException("GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER");
/*     */     }
/* 155 */     throw new RuntimeException("glCheckFramebufferStatus returned unknown status:" + i);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_147612_c() {
/* 160 */     if (OpenGlHelper.func_148822_b()) {
/* 161 */       GL11.glBindTexture(3553, this.field_147617_g);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_147606_d() {
/* 173 */     if (OpenGlHelper.func_148822_b()) {
/* 174 */       GL11.glBindTexture(3553, 0);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_147610_a(boolean p_147610_1_) {
/* 179 */     if (OpenGlHelper.func_148822_b()) {
/* 180 */       OpenGlHelper.func_153171_g(OpenGlHelper.field_153198_e, this.field_147616_f);
/* 181 */       if (p_147610_1_) {
/* 182 */         GL11.glViewport(0, 0, this.field_147621_c, this.field_147618_d);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_147609_e() {
/* 188 */     if (OpenGlHelper.func_148822_b()) {
/* 189 */       OpenGlHelper.func_153171_g(OpenGlHelper.field_153198_e, 0);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_147604_a(float p_147604_1_, float p_147604_2_, float p_147604_3_, float p_147604_4_) {
/* 194 */     this.field_147625_i[0] = p_147604_1_;
/* 195 */     this.field_147625_i[1] = p_147604_2_;
/* 196 */     this.field_147625_i[2] = p_147604_3_;
/* 197 */     this.field_147625_i[3] = p_147604_4_;
/*     */   }
/*     */   
/*     */   public void func_147615_c(int p_147615_1_, int p_147615_2_) {
/* 201 */     if (!OpenGlHelper.func_148822_b()) {
/*     */       return;
/*     */     }
/* 204 */     GL11.glColorMask(true, true, true, false);
/* 205 */     GL11.glDisable(2929);
/* 206 */     GL11.glDepthMask(false);
/*     */     
/* 208 */     GL11.glMatrixMode(5889);
/* 209 */     GL11.glLoadIdentity();
/* 210 */     GL11.glOrtho(0.0D, p_147615_1_, p_147615_2_, 0.0D, 1000.0D, 3000.0D);
/* 211 */     GL11.glMatrixMode(5888);
/* 212 */     GL11.glLoadIdentity();
/* 213 */     GL11.glTranslatef(0.0F, 0.0F, -2000.0F);
/*     */     
/* 215 */     GL11.glViewport(0, 0, p_147615_1_, p_147615_2_);
/*     */     
/* 217 */     GL11.glEnable(3553);
/* 218 */     GL11.glDisable(2896);
/* 219 */     GL11.glDisable(3008);
/* 220 */     GL11.glDisable(3042);
/*     */     
/* 222 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 223 */     GL11.glEnable(2903);
/*     */     
/* 225 */     func_147612_c();
/*     */     
/* 227 */     float f1 = p_147615_1_;
/* 228 */     float f2 = p_147615_2_;
/* 229 */     float f3 = this.field_147621_c / this.field_147622_a;
/* 230 */     float f4 = this.field_147618_d / this.field_147620_b;
/*     */     
/* 232 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 233 */     tessellator.func_78382_b();
/* 234 */     tessellator.func_78378_d(-1);
/* 235 */     tessellator.func_78374_a(0.0D, f2, 0.0D, 0.0D, 0.0D);
/* 236 */     tessellator.func_78374_a(f1, f2, 0.0D, f3, 0.0D);
/* 237 */     tessellator.func_78374_a(f1, 0.0D, 0.0D, f3, f4);
/* 238 */     tessellator.func_78374_a(0.0D, 0.0D, 0.0D, 0.0D, f4);
/* 239 */     tessellator.func_78381_a();
/*     */     
/* 241 */     func_147606_d();
/*     */     
/* 243 */     GL11.glDepthMask(true);
/* 244 */     GL11.glColorMask(true, true, true, true);
/*     */   }
/*     */   
/*     */   public void func_147614_f() {
/* 248 */     func_147610_a(true);
/* 249 */     GL11.glClearColor(this.field_147625_i[0], this.field_147625_i[1], this.field_147625_i[2], this.field_147625_i[3]);
/*     */     
/* 251 */     int i = 16384;
/* 252 */     if (this.field_147619_e) {
/* 253 */       GL11.glClearDepth(1.0D);
/* 254 */       i |= 0x100;
/*     */     } 
/* 256 */     GL11.glClear(i);
/* 257 */     func_147609_e();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\shader\Framebuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */