/*     */ package net.minecraft.client.shader;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.gson.JsonArray;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonParser;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.InputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.resources.IResourceManager;
/*     */ import net.minecraft.client.util.JsonBlendingMode;
/*     */ import net.minecraft.client.util.JsonException;
/*     */ import net.minecraft.util.JsonUtils;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.apache.commons.io.IOUtils;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.opengl.GL13;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ShaderManager {
/*  25 */   private static final Logger field_148003_a = LogManager.getLogger();
/*  26 */   private static final ShaderDefault field_148001_b = new ShaderDefault();
/*     */ 
/*     */   
/*  29 */   private static ShaderManager field_148002_c = null;
/*  30 */   private static int field_147999_d = -1;
/*     */   
/*     */   private static boolean field_148000_e = true;
/*     */   
/*  34 */   private final Map field_147997_f = Maps.newHashMap();
/*  35 */   private final List field_147998_g = Lists.newArrayList();
/*  36 */   private final List field_148010_h = Lists.newArrayList();
/*     */ 
/*     */   
/*  39 */   private final List field_148011_i = Lists.newArrayList();
/*  40 */   private final List field_148008_j = Lists.newArrayList();
/*  41 */   private final Map field_148009_k = Maps.newHashMap();
/*     */   
/*     */   private final int field_148006_l;
/*     */   
/*     */   private final String field_148007_m;
/*     */   
/*     */   private final boolean field_148004_n;
/*     */   
/*     */   private boolean field_148005_o;
/*     */   
/*     */   private final JsonBlendingMode field_148016_p;
/*     */   
/*     */   private final List field_148015_q;
/*     */   
/*     */   private final List field_148014_r;
/*     */   
/*     */   private final ShaderLoader field_148013_s;
/*     */   private final ShaderLoader field_148012_t;
/*     */   private static final String __OBFID = "CL_00001040";
/*     */   
/*     */   public ShaderManager(IResourceManager p_i45087_1_, String p_i45087_2_) throws JsonException {
/*  62 */     JsonParser jsonParser = new JsonParser();
/*     */     
/*  64 */     ResourceLocation resourceLocation = new ResourceLocation("shaders/program/" + p_i45087_2_ + ".json");
/*  65 */     this.field_148007_m = p_i45087_2_;
/*     */     
/*  67 */     InputStream inputStream = null;
/*     */     
/*     */     try {
/*  70 */       inputStream = p_i45087_1_.func_110536_a(resourceLocation).func_110527_b();
/*  71 */       JsonObject jsonObject = jsonParser.parse(IOUtils.toString(inputStream, Charsets.UTF_8)).getAsJsonObject();
/*     */       
/*  73 */       String str1 = JsonUtils.func_151200_h(jsonObject, "vertex");
/*  74 */       String str2 = JsonUtils.func_151200_h(jsonObject, "fragment");
/*     */       
/*  76 */       JsonArray jsonArray1 = JsonUtils.func_151213_a(jsonObject, "samplers", null);
/*  77 */       if (jsonArray1 != null) {
/*  78 */         byte b = 0;
/*  79 */         for (JsonElement jsonElement : jsonArray1) {
/*     */           try {
/*  81 */             func_147996_a(jsonElement);
/*  82 */           } catch (Exception exception) {
/*  83 */             JsonException jsonException = JsonException.func_151379_a(exception);
/*  84 */             jsonException.func_151380_a("samplers[" + b + "]");
/*  85 */             throw jsonException;
/*     */           } 
/*  87 */           b++;
/*     */         } 
/*     */       } 
/*     */       
/*  91 */       JsonArray jsonArray2 = JsonUtils.func_151213_a(jsonObject, "attributes", null);
/*  92 */       if (jsonArray2 != null) {
/*  93 */         byte b = 0;
/*  94 */         this.field_148015_q = Lists.newArrayListWithCapacity(jsonArray2.size());
/*  95 */         this.field_148014_r = Lists.newArrayListWithCapacity(jsonArray2.size());
/*  96 */         for (JsonElement jsonElement : jsonArray2) {
/*     */           try {
/*  98 */             this.field_148014_r.add(JsonUtils.func_151206_a(jsonElement, "attribute"));
/*  99 */           } catch (Exception exception) {
/* 100 */             JsonException jsonException = JsonException.func_151379_a(exception);
/* 101 */             jsonException.func_151380_a("attributes[" + b + "]");
/* 102 */             throw jsonException;
/*     */           } 
/* 104 */           b++;
/*     */         } 
/*     */       } else {
/* 107 */         this.field_148015_q = null;
/* 108 */         this.field_148014_r = null;
/*     */       } 
/*     */       
/* 111 */       JsonArray jsonArray3 = JsonUtils.func_151213_a(jsonObject, "uniforms", null);
/* 112 */       if (jsonArray3 != null) {
/* 113 */         byte b = 0;
/* 114 */         for (JsonElement jsonElement : jsonArray3) {
/*     */           try {
/* 116 */             func_147987_b(jsonElement);
/* 117 */           } catch (Exception exception) {
/* 118 */             JsonException jsonException = JsonException.func_151379_a(exception);
/* 119 */             jsonException.func_151380_a("uniforms[" + b + "]");
/* 120 */             throw jsonException;
/*     */           } 
/* 122 */           b++;
/*     */         } 
/*     */       } 
/*     */       
/* 126 */       this.field_148016_p = JsonBlendingMode.func_148110_a(JsonUtils.func_151218_a(jsonObject, "blend", null));
/* 127 */       this.field_148004_n = JsonUtils.func_151209_a(jsonObject, "cull", true);
/*     */       
/* 129 */       this.field_148013_s = ShaderLoader.func_148057_a(p_i45087_1_, ShaderLoader.ShaderType.VERTEX, str1);
/* 130 */       this.field_148012_t = ShaderLoader.func_148057_a(p_i45087_1_, ShaderLoader.ShaderType.FRAGMENT, str2);
/*     */       
/* 132 */       this.field_148006_l = ShaderLinkHelper.func_148074_b().func_148078_c();
/* 133 */       ShaderLinkHelper.func_148074_b().func_148075_b(this);
/*     */       
/* 135 */       func_147990_i();
/*     */       
/* 137 */       if (this.field_148014_r != null) {
/* 138 */         for (String str : this.field_148014_r) {
/* 139 */           int i = OpenGlHelper.func_153164_b(this.field_148006_l, str);
/* 140 */           this.field_148015_q.add(Integer.valueOf(i));
/*     */         } 
/*     */       }
/* 143 */     } catch (Exception exception) {
/* 144 */       JsonException jsonException = JsonException.func_151379_a(exception);
/* 145 */       jsonException.func_151381_b(resourceLocation.func_110623_a());
/* 146 */       throw jsonException;
/*     */     } finally {
/* 148 */       IOUtils.closeQuietly(inputStream);
/*     */     } 
/*     */     
/* 151 */     func_147985_d();
/*     */   }
/*     */   
/*     */   public void func_147988_a() {
/* 155 */     ShaderLinkHelper.func_148074_b().func_148077_a(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_147993_b() {
/* 160 */     OpenGlHelper.func_153161_d(0);
/* 161 */     field_147999_d = -1;
/* 162 */     field_148002_c = null;
/* 163 */     field_148000_e = true;
/*     */ 
/*     */     
/* 166 */     for (byte b = 0; b < this.field_148010_h.size(); b++) {
/* 167 */       if (this.field_147997_f.get(this.field_147998_g.get(b)) != null) {
/*     */ 
/*     */ 
/*     */         
/* 171 */         GL13.glActiveTexture(33984 + b);
/* 172 */         GL11.glBindTexture(3553, 0);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_147995_c() {
/* 182 */     this.field_148005_o = false;
/*     */     
/* 184 */     field_148002_c = this;
/*     */     
/* 186 */     this.field_148016_p.func_148109_a();
/*     */     
/* 188 */     if (this.field_148006_l != field_147999_d) {
/* 189 */       OpenGlHelper.func_153161_d(this.field_148006_l);
/* 190 */       field_147999_d = this.field_148006_l;
/*     */     } 
/*     */     
/* 193 */     if (field_148000_e != this.field_148004_n) {
/* 194 */       field_148000_e = this.field_148004_n;
/* 195 */       if (this.field_148004_n) {
/* 196 */         GL11.glEnable(2884);
/*     */       } else {
/* 198 */         GL11.glDisable(2884);
/*     */       } 
/*     */     } 
/*     */     
/* 202 */     for (byte b = 0; b < this.field_148010_h.size(); b++) {
/* 203 */       if (this.field_147997_f.get(this.field_147998_g.get(b)) != null) {
/*     */ 
/*     */ 
/*     */         
/* 207 */         GL13.glActiveTexture(33984 + b);
/* 208 */         GL11.glEnable(3553);
/* 209 */         Object object = this.field_147997_f.get(this.field_147998_g.get(b));
/* 210 */         int i = -1;
/* 211 */         if (object instanceof Framebuffer) {
/* 212 */           i = ((Framebuffer)object).field_147617_g;
/* 213 */         } else if (object instanceof ITextureObject) {
/* 214 */           i = ((ITextureObject)object).func_110552_b();
/* 215 */         } else if (object instanceof Integer) {
/* 216 */           i = ((Integer)object).intValue();
/*     */         } 
/* 218 */         if (i != -1) {
/*     */ 
/*     */           
/* 221 */           GL11.glBindTexture(3553, i);
/*     */           
/* 223 */           OpenGlHelper.func_153163_f(OpenGlHelper.func_153194_a(this.field_148006_l, this.field_147998_g.get(b)), b);
/*     */         } 
/*     */       } 
/*     */     } 
/* 227 */     for (ShaderUniform shaderUniform : this.field_148011_i) {
/* 228 */       shaderUniform.func_148093_b();
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_147985_d() {
/* 233 */     this.field_148005_o = true;
/*     */   }
/*     */   
/*     */   public ShaderUniform func_147991_a(String p_147991_1_) {
/* 237 */     if (this.field_148009_k.containsKey(p_147991_1_)) {
/* 238 */       return (ShaderUniform)this.field_148009_k.get(p_147991_1_);
/*     */     }
/*     */     
/* 241 */     return null;
/*     */   }
/*     */   
/*     */   public ShaderUniform func_147984_b(String p_147984_1_) {
/* 245 */     if (this.field_148009_k.containsKey(p_147984_1_)) {
/* 246 */       return (ShaderUniform)this.field_148009_k.get(p_147984_1_);
/*     */     }
/*     */     
/* 249 */     return field_148001_b;
/*     */   }
/*     */   
/*     */   private void func_147990_i() {
/* 253 */     for (byte b1 = 0, b2 = 0; b1 < this.field_147998_g.size(); b1++, b2++) {
/* 254 */       String str = this.field_147998_g.get(b1);
/* 255 */       int i = OpenGlHelper.func_153194_a(this.field_148006_l, str);
/* 256 */       if (i == -1) {
/* 257 */         field_148003_a.warn("Shader " + this.field_148007_m + "could not find sampler named " + str + " in the specified shader program.");
/*     */         
/* 259 */         this.field_147997_f.remove(str);
/* 260 */         this.field_147998_g.remove(b2);
/* 261 */         b2--;
/*     */       } else {
/*     */         
/* 264 */         this.field_148010_h.add(Integer.valueOf(i));
/*     */       } 
/*     */     } 
/* 267 */     for (ShaderUniform shaderUniform : this.field_148011_i) {
/* 268 */       String str = shaderUniform.func_148086_a();
/* 269 */       int i = OpenGlHelper.func_153194_a(this.field_148006_l, str);
/* 270 */       if (i == -1) {
/* 271 */         field_148003_a.warn("Could not find uniform named " + str + " in the specified" + " shader program.");
/*     */         continue;
/*     */       } 
/* 274 */       this.field_148008_j.add(Integer.valueOf(i));
/* 275 */       shaderUniform.func_148084_b(i);
/* 276 */       this.field_148009_k.put(str, shaderUniform);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_147996_a(JsonElement p_147996_1_) {
/* 281 */     JsonObject jsonObject = JsonUtils.func_151210_l(p_147996_1_, "sampler");
/* 282 */     String str = JsonUtils.func_151200_h(jsonObject, "name");
/*     */     
/* 284 */     if (!JsonUtils.func_151205_a(jsonObject, "file")) {
/*     */       
/* 286 */       this.field_147997_f.put(str, null);
/* 287 */       this.field_147998_g.add(str);
/*     */       return;
/*     */     } 
/* 290 */     this.field_147998_g.add(str);
/*     */   }
/*     */   
/*     */   public void func_147992_a(String p_147992_1_, Object p_147992_2_) {
/* 294 */     if (this.field_147997_f.containsKey(p_147992_1_)) {
/* 295 */       this.field_147997_f.remove(p_147992_1_);
/*     */     }
/*     */     
/* 298 */     this.field_147997_f.put(p_147992_1_, p_147992_2_);
/* 299 */     func_147985_d();
/*     */   }
/*     */   
/*     */   private void func_147987_b(JsonElement p_147987_1_) throws JsonException {
/* 303 */     JsonObject jsonObject = JsonUtils.func_151210_l(p_147987_1_, "uniform");
/* 304 */     String str = JsonUtils.func_151200_h(jsonObject, "name");
/* 305 */     int i = ShaderUniform.func_148085_a(JsonUtils.func_151200_h(jsonObject, "type"));
/* 306 */     int j = JsonUtils.func_151203_m(jsonObject, "count");
/* 307 */     float[] arrayOfFloat = new float[Math.max(j, 16)];
/*     */     
/* 309 */     JsonArray jsonArray = JsonUtils.func_151214_t(jsonObject, "values");
/* 310 */     if (jsonArray.size() != j && jsonArray.size() > 1) {
/* 311 */       throw new JsonException("Invalid amount of values specified (expected " + j + ", found " + jsonArray.size() + ")");
/*     */     }
/*     */     
/* 314 */     byte b1 = 0;
/* 315 */     for (JsonElement jsonElement : jsonArray) {
/*     */       try {
/* 317 */         arrayOfFloat[b1] = JsonUtils.func_151220_d(jsonElement, "value");
/* 318 */       } catch (Exception exception) {
/* 319 */         JsonException jsonException = JsonException.func_151379_a(exception);
/* 320 */         jsonException.func_151380_a("values[" + b1 + "]");
/* 321 */         throw jsonException;
/*     */       } 
/* 323 */       b1++;
/*     */     } 
/*     */ 
/*     */     
/* 327 */     if (j > 1 && jsonArray.size() == 1) {
/* 328 */       for (; b1 < j; b1++) {
/* 329 */         arrayOfFloat[b1] = arrayOfFloat[0];
/*     */       }
/*     */     }
/*     */     
/* 333 */     byte b2 = (j > 1 && j <= 4 && i < 8) ? (j - 1) : 0;
/* 334 */     ShaderUniform shaderUniform = new ShaderUniform(str, i + b2, j, this);
/*     */     
/* 336 */     if (i <= 3) {
/*     */       
/* 338 */       shaderUniform.func_148083_a((int)arrayOfFloat[0], (int)arrayOfFloat[1], (int)arrayOfFloat[2], (int)arrayOfFloat[3]);
/* 339 */     } else if (i <= 7) {
/*     */       
/* 341 */       shaderUniform.func_148092_b(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3]);
/*     */     } else {
/*     */       
/* 344 */       shaderUniform.func_148097_a(arrayOfFloat);
/*     */     } 
/*     */     
/* 347 */     this.field_148011_i.add(shaderUniform);
/*     */   }
/*     */   
/*     */   public ShaderLoader func_147989_e() {
/* 351 */     return this.field_148013_s;
/*     */   }
/*     */   
/*     */   public ShaderLoader func_147994_f() {
/* 355 */     return this.field_148012_t;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_147986_h() {
/* 363 */     return this.field_148006_l;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\shader\ShaderManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */