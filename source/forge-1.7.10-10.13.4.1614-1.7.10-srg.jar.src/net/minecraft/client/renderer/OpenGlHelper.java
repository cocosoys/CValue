/*     */ package net.minecraft.client.renderer;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.settings.GameSettings;
/*     */ import org.lwjgl.opengl.ARBFramebufferObject;
/*     */ import org.lwjgl.opengl.ARBMultitexture;
/*     */ import org.lwjgl.opengl.ARBShaderObjects;
/*     */ import org.lwjgl.opengl.ARBVertexShader;
/*     */ import org.lwjgl.opengl.ContextCapabilities;
/*     */ import org.lwjgl.opengl.EXTBlendFuncSeparate;
/*     */ import org.lwjgl.opengl.EXTFramebufferObject;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.opengl.GL13;
/*     */ import org.lwjgl.opengl.GL14;
/*     */ import org.lwjgl.opengl.GL20;
/*     */ import org.lwjgl.opengl.GL30;
/*     */ import org.lwjgl.opengl.GLContext;
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
/*     */ public class OpenGlHelper
/*     */ {
/*     */   public static boolean field_148827_a;
/*     */   public static int field_77478_a;
/*     */   public static int field_77476_b;
/*     */   public static boolean field_153197_d;
/*     */   public static int field_153198_e;
/*     */   public static int field_153199_f;
/*     */   public static int field_153200_g;
/*     */   public static int field_153201_h;
/*     */   public static int field_153202_i;
/*     */   public static int field_153203_j;
/*     */   public static int field_153204_k;
/*     */   public static int field_153205_l;
/*     */   public static int field_153206_m;
/*  50 */   private static String field_153196_B = ""; private static int field_153212_w; public static boolean field_148823_f; private static boolean field_153213_x; private static boolean field_153214_y; public static int field_153207_o; public static int field_153208_p; public static int field_153209_q; public static int field_153210_r; public static boolean field_148825_d; public static int field_148826_e; private static boolean field_153215_z; private static boolean field_148828_i; public static boolean field_153211_u; public static boolean field_148824_g; private static final String __OBFID = "CL_00001179";
/*     */   
/*     */   public static void func_77474_a() {
/*  53 */     ContextCapabilities contextCapabilities = GLContext.getCapabilities();
/*  54 */     field_153215_z = (contextCapabilities.GL_ARB_multitexture && !contextCapabilities.OpenGL13);
/*     */     
/*  56 */     if (field_153215_z) {
/*  57 */       field_153196_B += "Using multitexturing ARB.\n";
/*  58 */       field_77478_a = 33984;
/*  59 */       field_77476_b = 33985;
/*     */     } else {
/*  61 */       field_153196_B += "Using GL 1.3 multitexturing.\n";
/*  62 */       field_77478_a = 33984;
/*  63 */       field_77476_b = 33985;
/*     */     } 
/*     */     
/*  66 */     field_153211_u = (contextCapabilities.GL_EXT_blend_func_separate && !contextCapabilities.OpenGL14);
/*  67 */     field_148828_i = (contextCapabilities.OpenGL14 || contextCapabilities.GL_EXT_blend_func_separate);
/*  68 */     field_148823_f = (field_148828_i && (contextCapabilities.GL_ARB_framebuffer_object || contextCapabilities.GL_EXT_framebuffer_object || contextCapabilities.OpenGL30));
/*  69 */     if (field_148823_f) {
/*  70 */       field_153196_B += "Using framebuffer objects because ";
/*  71 */       if (contextCapabilities.OpenGL30) {
/*  72 */         field_153196_B += "OpenGL 3.0 is supported and separate blending is supported.\n";
/*  73 */         field_153212_w = 0;
/*  74 */         field_153198_e = 36160;
/*  75 */         field_153199_f = 36161;
/*  76 */         field_153200_g = 36064;
/*  77 */         field_153201_h = 36096;
/*  78 */         field_153202_i = 36053;
/*  79 */         field_153203_j = 36054;
/*  80 */         field_153204_k = 36055;
/*  81 */         field_153205_l = 36059;
/*  82 */         field_153206_m = 36060;
/*  83 */       } else if (contextCapabilities.GL_ARB_framebuffer_object) {
/*  84 */         field_153196_B += "ARB_framebuffer_object is supported and separate blending is supported.\n";
/*  85 */         field_153212_w = 1;
/*  86 */         field_153198_e = 36160;
/*  87 */         field_153199_f = 36161;
/*  88 */         field_153200_g = 36064;
/*  89 */         field_153201_h = 36096;
/*  90 */         field_153202_i = 36053;
/*  91 */         field_153204_k = 36055;
/*  92 */         field_153203_j = 36054;
/*  93 */         field_153205_l = 36059;
/*  94 */         field_153206_m = 36060;
/*  95 */       } else if (contextCapabilities.GL_EXT_framebuffer_object) {
/*  96 */         field_153196_B += "EXT_framebuffer_object is supported.\n";
/*  97 */         field_153212_w = 2;
/*  98 */         field_153198_e = 36160;
/*  99 */         field_153199_f = 36161;
/* 100 */         field_153200_g = 36064;
/* 101 */         field_153201_h = 36096;
/* 102 */         field_153202_i = 36053;
/* 103 */         field_153204_k = 36055;
/* 104 */         field_153203_j = 36054;
/* 105 */         field_153205_l = 36059;
/* 106 */         field_153206_m = 36060;
/*     */       } 
/*     */     } else {
/* 109 */       field_153196_B += "Not using framebuffer objects because ";
/* 110 */       field_153196_B += "OpenGL 1.4 is " + (contextCapabilities.OpenGL14 ? "" : "not ") + "supported, ";
/* 111 */       field_153196_B += "EXT_blend_func_separate is " + (contextCapabilities.GL_EXT_blend_func_separate ? "" : "not ") + "supported, ";
/* 112 */       field_153196_B += "OpenGL 3.0 is " + (contextCapabilities.OpenGL30 ? "" : "not ") + "supported, ";
/* 113 */       field_153196_B += "ARB_framebuffer_object is " + (contextCapabilities.GL_ARB_framebuffer_object ? "" : "not ") + "supported, and ";
/* 114 */       field_153196_B += "EXT_framebuffer_object is " + (contextCapabilities.GL_EXT_framebuffer_object ? "" : "not ") + "supported.\n";
/*     */     } 
/*     */     
/* 117 */     field_148825_d = contextCapabilities.GL_EXT_texture_filter_anisotropic;
/* 118 */     field_148826_e = (int)(field_148825_d ? GL11.glGetFloat(34047) : 0.0F);
/* 119 */     field_153196_B += "Anisotropic filtering is " + (field_148825_d ? "" : "not ") + "supported";
/* 120 */     if (field_148825_d) {
/* 121 */       field_153196_B += " and maximum anisotropy is " + field_148826_e + ".\n";
/*     */     } else {
/* 123 */       field_153196_B += ".\n";
/*     */     } 
/*     */     
/* 126 */     GameSettings.Options.ANISOTROPIC_FILTERING.func_148263_a(field_148826_e);
/*     */     
/* 128 */     field_148827_a = contextCapabilities.OpenGL21;
/* 129 */     field_153213_x = (field_148827_a || (contextCapabilities.GL_ARB_vertex_shader && contextCapabilities.GL_ARB_fragment_shader && contextCapabilities.GL_ARB_shader_objects));
/* 130 */     field_153196_B += "Shaders are " + (field_153213_x ? "" : "not ") + "available because ";
/* 131 */     if (field_153213_x) {
/* 132 */       if (contextCapabilities.OpenGL21) {
/* 133 */         field_153196_B += "OpenGL 2.1 is supported.\n";
/* 134 */         field_153214_y = false;
/* 135 */         field_153207_o = 35714;
/* 136 */         field_153208_p = 35713;
/* 137 */         field_153209_q = 35633;
/* 138 */         field_153210_r = 35632;
/*     */       } else {
/* 140 */         field_153196_B += "ARB_shader_objects, ARB_vertex_shader, and ARB_fragment_shader are supported.\n";
/* 141 */         field_153214_y = true;
/* 142 */         field_153207_o = 35714;
/* 143 */         field_153208_p = 35713;
/* 144 */         field_153209_q = 35633;
/* 145 */         field_153210_r = 35632;
/*     */       } 
/*     */     } else {
/* 148 */       field_153196_B += "OpenGL 2.1 is " + (contextCapabilities.OpenGL21 ? "" : "not ") + "supported, ";
/* 149 */       field_153196_B += "ARB_shader_objects is " + (contextCapabilities.GL_ARB_shader_objects ? "" : "not ") + "supported, ";
/* 150 */       field_153196_B += "ARB_vertex_shader is " + (contextCapabilities.GL_ARB_vertex_shader ? "" : "not ") + "supported, and ";
/* 151 */       field_153196_B += "ARB_fragment_shader is " + (contextCapabilities.GL_ARB_fragment_shader ? "" : "not ") + "supported.\n";
/*     */     } 
/* 153 */     field_148824_g = (field_148823_f && field_153213_x);
/*     */     
/* 155 */     field_153197_d = GL11.glGetString(7936).toLowerCase().contains("nvidia");
/*     */   }
/*     */   
/*     */   public static boolean func_153193_b() {
/* 159 */     return field_148824_g;
/*     */   }
/*     */   
/*     */   public static String func_153172_c() {
/* 163 */     return field_153196_B;
/*     */   }
/*     */   
/*     */   public static int func_153175_a(int p_153175_0_, int p_153175_1_) {
/* 167 */     if (field_153214_y) {
/* 168 */       return ARBShaderObjects.glGetObjectParameteriARB(p_153175_0_, p_153175_1_);
/*     */     }
/* 170 */     return GL20.glGetProgrami(p_153175_0_, p_153175_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void func_153178_b(int p_153178_0_, int p_153178_1_) {
/* 175 */     if (field_153214_y) {
/* 176 */       ARBShaderObjects.glAttachObjectARB(p_153178_0_, p_153178_1_);
/*     */     } else {
/* 178 */       GL20.glAttachShader(p_153178_0_, p_153178_1_);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void func_153180_a(int p_153180_0_) {
/* 183 */     if (field_153214_y) {
/* 184 */       ARBShaderObjects.glDeleteObjectARB(p_153180_0_);
/*     */     } else {
/* 186 */       GL20.glDeleteShader(p_153180_0_);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static int func_153195_b(int p_153195_0_) {
/* 191 */     if (field_153214_y) {
/* 192 */       return ARBShaderObjects.glCreateShaderObjectARB(p_153195_0_);
/*     */     }
/* 194 */     return GL20.glCreateShader(p_153195_0_);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void func_153169_a(int p_153169_0_, ByteBuffer p_153169_1_) {
/* 199 */     if (field_153214_y) {
/* 200 */       ARBShaderObjects.glShaderSourceARB(p_153169_0_, p_153169_1_);
/*     */     } else {
/* 202 */       GL20.glShaderSource(p_153169_0_, p_153169_1_);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void func_153170_c(int p_153170_0_) {
/* 207 */     if (field_153214_y) {
/* 208 */       ARBShaderObjects.glCompileShaderARB(p_153170_0_);
/*     */     } else {
/* 210 */       GL20.glCompileShader(p_153170_0_);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static int func_153157_c(int p_153157_0_, int p_153157_1_) {
/* 215 */     if (field_153214_y) {
/* 216 */       return ARBShaderObjects.glGetObjectParameteriARB(p_153157_0_, p_153157_1_);
/*     */     }
/* 218 */     return GL20.glGetShaderi(p_153157_0_, p_153157_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public static String func_153158_d(int p_153158_0_, int p_153158_1_) {
/* 223 */     if (field_153214_y) {
/* 224 */       return ARBShaderObjects.glGetInfoLogARB(p_153158_0_, p_153158_1_);
/*     */     }
/* 226 */     return GL20.glGetShaderInfoLog(p_153158_0_, p_153158_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public static String func_153166_e(int p_153166_0_, int p_153166_1_) {
/* 231 */     if (field_153214_y) {
/* 232 */       return ARBShaderObjects.glGetInfoLogARB(p_153166_0_, p_153166_1_);
/*     */     }
/* 234 */     return GL20.glGetProgramInfoLog(p_153166_0_, p_153166_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void func_153161_d(int p_153161_0_) {
/* 239 */     if (field_153214_y) {
/* 240 */       ARBShaderObjects.glUseProgramObjectARB(p_153161_0_);
/*     */     } else {
/* 242 */       GL20.glUseProgram(p_153161_0_);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static int func_153183_d() {
/* 247 */     if (field_153214_y) {
/* 248 */       return ARBShaderObjects.glCreateProgramObjectARB();
/*     */     }
/* 250 */     return GL20.glCreateProgram();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void func_153187_e(int p_153187_0_) {
/* 255 */     if (field_153214_y) {
/* 256 */       ARBShaderObjects.glDeleteObjectARB(p_153187_0_);
/*     */     } else {
/* 258 */       GL20.glDeleteProgram(p_153187_0_);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void func_153179_f(int p_153179_0_) {
/* 263 */     if (field_153214_y) {
/* 264 */       ARBShaderObjects.glLinkProgramARB(p_153179_0_);
/*     */     } else {
/* 266 */       GL20.glLinkProgram(p_153179_0_);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static int func_153194_a(int p_153194_0_, CharSequence p_153194_1_) {
/* 271 */     if (field_153214_y) {
/* 272 */       return ARBShaderObjects.glGetUniformLocationARB(p_153194_0_, p_153194_1_);
/*     */     }
/* 274 */     return GL20.glGetUniformLocation(p_153194_0_, p_153194_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void func_153181_a(int p_153181_0_, IntBuffer p_153181_1_) {
/* 279 */     if (field_153214_y) {
/* 280 */       ARBShaderObjects.glUniform1ARB(p_153181_0_, p_153181_1_);
/*     */     } else {
/* 282 */       GL20.glUniform1(p_153181_0_, p_153181_1_);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void func_153163_f(int p_153163_0_, int p_153163_1_) {
/* 287 */     if (field_153214_y) {
/* 288 */       ARBShaderObjects.glUniform1iARB(p_153163_0_, p_153163_1_);
/*     */     } else {
/* 290 */       GL20.glUniform1i(p_153163_0_, p_153163_1_);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void func_153168_a(int p_153168_0_, FloatBuffer p_153168_1_) {
/* 295 */     if (field_153214_y) {
/* 296 */       ARBShaderObjects.glUniform1ARB(p_153168_0_, p_153168_1_);
/*     */     } else {
/* 298 */       GL20.glUniform1(p_153168_0_, p_153168_1_);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void func_153182_b(int p_153182_0_, IntBuffer p_153182_1_) {
/* 303 */     if (field_153214_y) {
/* 304 */       ARBShaderObjects.glUniform2ARB(p_153182_0_, p_153182_1_);
/*     */     } else {
/* 306 */       GL20.glUniform2(p_153182_0_, p_153182_1_);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void func_153177_b(int p_153177_0_, FloatBuffer p_153177_1_) {
/* 311 */     if (field_153214_y) {
/* 312 */       ARBShaderObjects.glUniform2ARB(p_153177_0_, p_153177_1_);
/*     */     } else {
/* 314 */       GL20.glUniform2(p_153177_0_, p_153177_1_);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void func_153192_c(int p_153192_0_, IntBuffer p_153192_1_) {
/* 319 */     if (field_153214_y) {
/* 320 */       ARBShaderObjects.glUniform3ARB(p_153192_0_, p_153192_1_);
/*     */     } else {
/* 322 */       GL20.glUniform3(p_153192_0_, p_153192_1_);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void func_153191_c(int p_153191_0_, FloatBuffer p_153191_1_) {
/* 327 */     if (field_153214_y) {
/* 328 */       ARBShaderObjects.glUniform3ARB(p_153191_0_, p_153191_1_);
/*     */     } else {
/* 330 */       GL20.glUniform3(p_153191_0_, p_153191_1_);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void func_153162_d(int p_153162_0_, IntBuffer p_153162_1_) {
/* 335 */     if (field_153214_y) {
/* 336 */       ARBShaderObjects.glUniform4ARB(p_153162_0_, p_153162_1_);
/*     */     } else {
/* 338 */       GL20.glUniform4(p_153162_0_, p_153162_1_);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void func_153159_d(int p_153159_0_, FloatBuffer p_153159_1_) {
/* 343 */     if (field_153214_y) {
/* 344 */       ARBShaderObjects.glUniform4ARB(p_153159_0_, p_153159_1_);
/*     */     } else {
/* 346 */       GL20.glUniform4(p_153159_0_, p_153159_1_);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void func_153173_a(int p_153173_0_, boolean p_153173_1_, FloatBuffer p_153173_2_) {
/* 351 */     if (field_153214_y) {
/* 352 */       ARBShaderObjects.glUniformMatrix2ARB(p_153173_0_, p_153173_1_, p_153173_2_);
/*     */     } else {
/* 354 */       GL20.glUniformMatrix2(p_153173_0_, p_153173_1_, p_153173_2_);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void func_153189_b(int p_153189_0_, boolean p_153189_1_, FloatBuffer p_153189_2_) {
/* 359 */     if (field_153214_y) {
/* 360 */       ARBShaderObjects.glUniformMatrix3ARB(p_153189_0_, p_153189_1_, p_153189_2_);
/*     */     } else {
/* 362 */       GL20.glUniformMatrix3(p_153189_0_, p_153189_1_, p_153189_2_);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void func_153160_c(int p_153160_0_, boolean p_153160_1_, FloatBuffer p_153160_2_) {
/* 367 */     if (field_153214_y) {
/* 368 */       ARBShaderObjects.glUniformMatrix4ARB(p_153160_0_, p_153160_1_, p_153160_2_);
/*     */     } else {
/* 370 */       GL20.glUniformMatrix4(p_153160_0_, p_153160_1_, p_153160_2_);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static int func_153164_b(int p_153164_0_, CharSequence p_153164_1_) {
/* 375 */     if (field_153214_y) {
/* 376 */       return ARBVertexShader.glGetAttribLocationARB(p_153164_0_, p_153164_1_);
/*     */     }
/* 378 */     return GL20.glGetAttribLocation(p_153164_0_, p_153164_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void func_153171_g(int p_153171_0_, int p_153171_1_) {
/* 383 */     if (!field_148823_f)
/* 384 */       return;  switch (field_153212_w) {
/*     */       case 0:
/* 386 */         GL30.glBindFramebuffer(p_153171_0_, p_153171_1_);
/*     */         break;
/*     */       case 1:
/* 389 */         ARBFramebufferObject.glBindFramebuffer(p_153171_0_, p_153171_1_);
/*     */         break;
/*     */       case 2:
/* 392 */         EXTFramebufferObject.glBindFramebufferEXT(p_153171_0_, p_153171_1_);
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void func_153176_h(int p_153176_0_, int p_153176_1_) {
/* 398 */     if (!field_148823_f)
/* 399 */       return;  switch (field_153212_w) {
/*     */       case 0:
/* 401 */         GL30.glBindRenderbuffer(p_153176_0_, p_153176_1_);
/*     */         break;
/*     */       case 1:
/* 404 */         ARBFramebufferObject.glBindRenderbuffer(p_153176_0_, p_153176_1_);
/*     */         break;
/*     */       case 2:
/* 407 */         EXTFramebufferObject.glBindRenderbufferEXT(p_153176_0_, p_153176_1_);
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void func_153184_g(int p_153184_0_) {
/* 413 */     if (!field_148823_f)
/* 414 */       return;  switch (field_153212_w) {
/*     */       case 0:
/* 416 */         GL30.glDeleteRenderbuffers(p_153184_0_);
/*     */         break;
/*     */       case 1:
/* 419 */         ARBFramebufferObject.glDeleteRenderbuffers(p_153184_0_);
/*     */         break;
/*     */       case 2:
/* 422 */         EXTFramebufferObject.glDeleteRenderbuffersEXT(p_153184_0_);
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void func_153174_h(int p_153174_0_) {
/* 428 */     if (!field_148823_f)
/* 429 */       return;  switch (field_153212_w) {
/*     */       case 0:
/* 431 */         GL30.glDeleteFramebuffers(p_153174_0_);
/*     */         break;
/*     */       case 1:
/* 434 */         ARBFramebufferObject.glDeleteFramebuffers(p_153174_0_);
/*     */         break;
/*     */       case 2:
/* 437 */         EXTFramebufferObject.glDeleteFramebuffersEXT(p_153174_0_);
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static int func_153165_e() {
/* 443 */     if (!field_148823_f) return -1; 
/* 444 */     switch (field_153212_w) {
/*     */       case 0:
/* 446 */         return GL30.glGenFramebuffers();
/*     */       case 1:
/* 448 */         return ARBFramebufferObject.glGenFramebuffers();
/*     */       case 2:
/* 450 */         return EXTFramebufferObject.glGenFramebuffersEXT();
/*     */     } 
/* 452 */     return -1;
/*     */   }
/*     */   
/*     */   public static int func_153185_f() {
/* 456 */     if (!field_148823_f) return -1; 
/* 457 */     switch (field_153212_w) {
/*     */       case 0:
/* 459 */         return GL30.glGenRenderbuffers();
/*     */       case 1:
/* 461 */         return ARBFramebufferObject.glGenRenderbuffers();
/*     */       case 2:
/* 463 */         return EXTFramebufferObject.glGenRenderbuffersEXT();
/*     */     } 
/* 465 */     return -1;
/*     */   }
/*     */   
/*     */   public static void func_153186_a(int p_153186_0_, int p_153186_1_, int p_153186_2_, int p_153186_3_) {
/* 469 */     if (!field_148823_f)
/* 470 */       return;  switch (field_153212_w) {
/*     */       case 0:
/* 472 */         GL30.glRenderbufferStorage(p_153186_0_, p_153186_1_, p_153186_2_, p_153186_3_);
/*     */         break;
/*     */       case 1:
/* 475 */         ARBFramebufferObject.glRenderbufferStorage(p_153186_0_, p_153186_1_, p_153186_2_, p_153186_3_);
/*     */         break;
/*     */       case 2:
/* 478 */         EXTFramebufferObject.glRenderbufferStorageEXT(p_153186_0_, p_153186_1_, p_153186_2_, p_153186_3_);
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void func_153190_b(int p_153190_0_, int p_153190_1_, int p_153190_2_, int p_153190_3_) {
/* 484 */     if (!field_148823_f)
/* 485 */       return;  switch (field_153212_w) {
/*     */       case 0:
/* 487 */         GL30.glFramebufferRenderbuffer(p_153190_0_, p_153190_1_, p_153190_2_, p_153190_3_);
/*     */         break;
/*     */       case 1:
/* 490 */         ARBFramebufferObject.glFramebufferRenderbuffer(p_153190_0_, p_153190_1_, p_153190_2_, p_153190_3_);
/*     */         break;
/*     */       case 2:
/* 493 */         EXTFramebufferObject.glFramebufferRenderbufferEXT(p_153190_0_, p_153190_1_, p_153190_2_, p_153190_3_);
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static int func_153167_i(int p_153167_0_) {
/* 499 */     if (!field_148823_f) return -1; 
/* 500 */     switch (field_153212_w) {
/*     */       case 0:
/* 502 */         return GL30.glCheckFramebufferStatus(p_153167_0_);
/*     */       case 1:
/* 504 */         return ARBFramebufferObject.glCheckFramebufferStatus(p_153167_0_);
/*     */       case 2:
/* 506 */         return EXTFramebufferObject.glCheckFramebufferStatusEXT(p_153167_0_);
/*     */     } 
/* 508 */     return -1;
/*     */   }
/*     */   
/*     */   public static void func_153188_a(int p_153188_0_, int p_153188_1_, int p_153188_2_, int p_153188_3_, int p_153188_4_) {
/* 512 */     if (!field_148823_f)
/* 513 */       return;  switch (field_153212_w) {
/*     */       case 0:
/* 515 */         GL30.glFramebufferTexture2D(p_153188_0_, p_153188_1_, p_153188_2_, p_153188_3_, p_153188_4_);
/*     */         break;
/*     */       case 1:
/* 518 */         ARBFramebufferObject.glFramebufferTexture2D(p_153188_0_, p_153188_1_, p_153188_2_, p_153188_3_, p_153188_4_);
/*     */         break;
/*     */       case 2:
/* 521 */         EXTFramebufferObject.glFramebufferTexture2DEXT(p_153188_0_, p_153188_1_, p_153188_2_, p_153188_3_, p_153188_4_);
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void func_77473_a(int p_77473_0_) {
/* 527 */     if (field_153215_z) {
/* 528 */       ARBMultitexture.glActiveTextureARB(p_77473_0_);
/*     */     } else {
/* 530 */       GL13.glActiveTexture(p_77473_0_);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void func_77472_b(int p_77472_0_) {
/* 535 */     if (field_153215_z) {
/* 536 */       ARBMultitexture.glClientActiveTextureARB(p_77472_0_);
/*     */     } else {
/* 538 */       GL13.glClientActiveTexture(p_77472_0_);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void func_77475_a(int p_77475_0_, float p_77475_1_, float p_77475_2_) {
/* 543 */     if (field_153215_z) {
/* 544 */       ARBMultitexture.glMultiTexCoord2fARB(p_77475_0_, p_77475_1_, p_77475_2_);
/*     */     } else {
/* 546 */       GL13.glMultiTexCoord2f(p_77475_0_, p_77475_1_, p_77475_2_);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void func_148821_a(int p_148821_0_, int p_148821_1_, int p_148821_2_, int p_148821_3_) {
/* 551 */     if (field_148828_i) {
/* 552 */       if (field_153211_u) {
/* 553 */         EXTBlendFuncSeparate.glBlendFuncSeparateEXT(p_148821_0_, p_148821_1_, p_148821_2_, p_148821_3_);
/*     */       } else {
/* 555 */         GL14.glBlendFuncSeparate(p_148821_0_, p_148821_1_, p_148821_2_, p_148821_3_);
/*     */       } 
/*     */     } else {
/* 558 */       GL11.glBlendFunc(p_148821_0_, p_148821_1_);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static boolean func_148822_b() {
/* 563 */     return (field_148823_f && (Minecraft.func_71410_x()).field_71474_y.field_151448_g);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\OpenGlHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */