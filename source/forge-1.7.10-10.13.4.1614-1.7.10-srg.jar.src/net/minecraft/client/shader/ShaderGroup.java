/*     */ package net.minecraft.client.shader;
/*     */ 
/*     */ import com.google.common.base.Charsets;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.gson.JsonArray;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonParser;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.InputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.vecmath.Matrix4f;
/*     */ import net.minecraft.client.renderer.texture.ITextureObject;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.client.resources.IResource;
/*     */ import net.minecraft.client.resources.IResourceManager;
/*     */ import net.minecraft.client.util.JsonException;
/*     */ import net.minecraft.util.JsonUtils;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.apache.commons.io.IOUtils;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ShaderGroup {
/*     */   private final Framebuffer field_148035_a;
/*  30 */   private final List field_148031_d = Lists.newArrayList(); private final IResourceManager field_148033_b; private final String field_148034_c;
/*  31 */   private final Map field_148032_e = Maps.newHashMap();
/*  32 */   private final List field_148029_f = Lists.newArrayList();
/*     */   private Matrix4f field_148030_g;
/*     */   private int field_148038_h;
/*     */   private int field_148039_i;
/*     */   private float field_148036_j;
/*     */   private float field_148037_k;
/*     */   private static final String __OBFID = "CL_00001041";
/*     */   
/*     */   public ShaderGroup(TextureManager p_i1050_1_, IResourceManager p_i1050_2_, Framebuffer p_i1050_3_, ResourceLocation p_i1050_4_) throws JsonException {
/*  41 */     this.field_148033_b = p_i1050_2_;
/*  42 */     this.field_148035_a = p_i1050_3_;
/*  43 */     this.field_148036_j = 0.0F;
/*  44 */     this.field_148037_k = 0.0F;
/*  45 */     this.field_148038_h = p_i1050_3_.field_147621_c;
/*  46 */     this.field_148039_i = p_i1050_3_.field_147618_d;
/*  47 */     this.field_148034_c = p_i1050_4_.toString();
/*  48 */     func_148024_c();
/*     */     
/*  50 */     func_152765_a(p_i1050_1_, p_i1050_4_);
/*     */   }
/*     */   
/*     */   public void func_152765_a(TextureManager p_152765_1_, ResourceLocation p_152765_2_) throws JsonException {
/*  54 */     JsonParser jsonParser = new JsonParser();
/*  55 */     InputStream inputStream = null;
/*     */     
/*     */     try {
/*  58 */       IResource iResource = this.field_148033_b.func_110536_a(p_152765_2_);
/*  59 */       inputStream = iResource.func_110527_b();
/*  60 */       JsonObject jsonObject = jsonParser.parse(IOUtils.toString(inputStream, Charsets.UTF_8)).getAsJsonObject();
/*     */       
/*  62 */       if (JsonUtils.func_151202_d(jsonObject, "targets")) {
/*  63 */         JsonArray jsonArray = jsonObject.getAsJsonArray("targets");
/*  64 */         byte b = 0;
/*     */         
/*  66 */         for (JsonElement jsonElement : jsonArray) {
/*     */           try {
/*  68 */             func_148027_a(jsonElement);
/*  69 */           } catch (Exception exception) {
/*  70 */             JsonException jsonException = JsonException.func_151379_a(exception);
/*  71 */             jsonException.func_151380_a("targets[" + b + "]");
/*  72 */             throw jsonException;
/*     */           } 
/*  74 */           b++;
/*     */         } 
/*     */       } 
/*     */       
/*  78 */       if (JsonUtils.func_151202_d(jsonObject, "passes")) {
/*  79 */         JsonArray jsonArray = jsonObject.getAsJsonArray("passes");
/*  80 */         byte b = 0;
/*     */         
/*  82 */         for (JsonElement jsonElement : jsonArray) {
/*     */           try {
/*  84 */             func_152764_a(p_152765_1_, jsonElement);
/*  85 */           } catch (Exception exception) {
/*  86 */             JsonException jsonException = JsonException.func_151379_a(exception);
/*  87 */             jsonException.func_151380_a("passes[" + b + "]");
/*  88 */             throw jsonException;
/*     */           } 
/*  90 */           b++;
/*     */         } 
/*     */       } 
/*  93 */     } catch (Exception exception) {
/*  94 */       JsonException jsonException = JsonException.func_151379_a(exception);
/*  95 */       jsonException.func_151381_b(p_152765_2_.func_110623_a());
/*  96 */       throw jsonException;
/*     */     } finally {
/*  98 */       IOUtils.closeQuietly(inputStream);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_148027_a(JsonElement p_148027_1_) throws JsonException {
/* 103 */     if (JsonUtils.func_151211_a(p_148027_1_)) {
/* 104 */       func_148020_a(p_148027_1_.getAsString(), this.field_148038_h, this.field_148039_i);
/*     */     } else {
/* 106 */       JsonObject jsonObject = JsonUtils.func_151210_l(p_148027_1_, "target");
/*     */       
/* 108 */       String str = JsonUtils.func_151200_h(jsonObject, "name");
/* 109 */       int i = JsonUtils.func_151208_a(jsonObject, "width", this.field_148038_h);
/* 110 */       int j = JsonUtils.func_151208_a(jsonObject, "height", this.field_148039_i);
/*     */       
/* 112 */       if (this.field_148032_e.containsKey(str)) {
/* 113 */         throw new JsonException(str + " is already defined");
/*     */       }
/* 115 */       func_148020_a(str, i, j);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void func_152764_a(TextureManager p_152764_1_, JsonElement p_152764_2_) throws JsonException {
/* 121 */     JsonObject jsonObject = JsonUtils.func_151210_l(p_152764_2_, "pass");
/*     */     
/* 123 */     String str1 = JsonUtils.func_151200_h(jsonObject, "name");
/* 124 */     String str2 = JsonUtils.func_151200_h(jsonObject, "intarget");
/* 125 */     String str3 = JsonUtils.func_151200_h(jsonObject, "outtarget");
/* 126 */     Framebuffer framebuffer1 = func_148017_a(str2);
/* 127 */     Framebuffer framebuffer2 = func_148017_a(str3);
/*     */     
/* 129 */     if (framebuffer1 == null) {
/* 130 */       throw new JsonException("Input target '" + str2 + "' does not exist");
/*     */     }
/* 132 */     if (framebuffer2 == null) {
/* 133 */       throw new JsonException("Output target '" + str3 + "' does not exist");
/*     */     }
/*     */     
/* 136 */     Shader shader = func_148023_a(str1, framebuffer1, framebuffer2);
/*     */     
/* 138 */     JsonArray jsonArray1 = JsonUtils.func_151213_a(jsonObject, "auxtargets", null);
/* 139 */     if (jsonArray1 != null) {
/* 140 */       byte b = 0;
/* 141 */       for (JsonElement jsonElement : jsonArray1) {
/*     */         try {
/* 143 */           JsonObject jsonObject1 = JsonUtils.func_151210_l(jsonElement, "auxtarget");
/* 144 */           String str4 = JsonUtils.func_151200_h(jsonObject1, "name");
/* 145 */           String str5 = JsonUtils.func_151200_h(jsonObject1, "id");
/* 146 */           Framebuffer framebuffer = func_148017_a(str5);
/*     */           
/* 148 */           if (framebuffer == null) {
/*     */             
/* 150 */             ResourceLocation resourceLocation = new ResourceLocation("textures/effect/" + str5 + ".png");
/*     */             try {
/* 152 */               this.field_148033_b.func_110536_a(resourceLocation);
/* 153 */             } catch (FileNotFoundException fileNotFoundException) {
/* 154 */               throw new JsonException("Render target or texture '" + str5 + "' does not exist");
/*     */             } 
/*     */             
/* 157 */             p_152764_1_.func_110577_a(resourceLocation);
/* 158 */             ITextureObject iTextureObject = p_152764_1_.func_110581_b(resourceLocation);
/* 159 */             int i = JsonUtils.func_151203_m(jsonObject1, "width");
/* 160 */             int j = JsonUtils.func_151203_m(jsonObject1, "height");
/* 161 */             boolean bool = JsonUtils.func_151212_i(jsonObject1, "bilinear");
/* 162 */             if (bool) {
/* 163 */               GL11.glTexParameteri(3553, 10241, 9729);
/* 164 */               GL11.glTexParameteri(3553, 10240, 9729);
/*     */             } else {
/* 166 */               GL11.glTexParameteri(3553, 10241, 9728);
/* 167 */               GL11.glTexParameteri(3553, 10240, 9728);
/*     */             } 
/* 169 */             shader.func_148041_a(str4, Integer.valueOf(iTextureObject.func_110552_b()), i, j);
/*     */           } else {
/* 171 */             shader.func_148041_a(str4, framebuffer, framebuffer.field_147622_a, framebuffer.field_147620_b);
/*     */           } 
/* 173 */         } catch (Exception exception) {
/* 174 */           JsonException jsonException = JsonException.func_151379_a(exception);
/* 175 */           jsonException.func_151380_a("auxtargets[" + b + "]");
/* 176 */           throw jsonException;
/*     */         } 
/* 178 */         b++;
/*     */       } 
/*     */     } 
/*     */     
/* 182 */     JsonArray jsonArray2 = JsonUtils.func_151213_a(jsonObject, "uniforms", null);
/* 183 */     if (jsonArray2 != null) {
/* 184 */       byte b = 0;
/* 185 */       for (JsonElement jsonElement : jsonArray2) {
/*     */         try {
/* 187 */           func_148028_c(jsonElement);
/* 188 */         } catch (Exception exception) {
/* 189 */           JsonException jsonException = JsonException.func_151379_a(exception);
/* 190 */           jsonException.func_151380_a("uniforms[" + b + "]");
/* 191 */           throw jsonException;
/*     */         } 
/* 193 */         b++;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_148028_c(JsonElement p_148028_1_) throws JsonException {
/* 199 */     JsonObject jsonObject = JsonUtils.func_151210_l(p_148028_1_, "uniform");
/* 200 */     String str = JsonUtils.func_151200_h(jsonObject, "name");
/* 201 */     ShaderUniform shaderUniform = ((Shader)this.field_148031_d.get(this.field_148031_d.size() - 1)).func_148043_c().func_147991_a(str);
/*     */     
/* 203 */     if (shaderUniform == null) {
/* 204 */       throw new JsonException("Uniform '" + str + "' does not exist");
/*     */     }
/*     */     
/* 207 */     float[] arrayOfFloat = new float[4];
/* 208 */     byte b = 0;
/* 209 */     JsonArray jsonArray = JsonUtils.func_151214_t(jsonObject, "values");
/*     */     
/* 211 */     for (JsonElement jsonElement : jsonArray) {
/*     */       try {
/* 213 */         arrayOfFloat[b] = JsonUtils.func_151220_d(jsonElement, "value");
/* 214 */       } catch (Exception exception) {
/* 215 */         JsonException jsonException = JsonException.func_151379_a(exception);
/* 216 */         jsonException.func_151380_a("values[" + b + "]");
/* 217 */         throw jsonException;
/*     */       } 
/* 219 */       b++;
/*     */     } 
/*     */     
/* 222 */     switch (b) {
/*     */ 
/*     */ 
/*     */       
/*     */       case 1:
/* 227 */         shaderUniform.func_148090_a(arrayOfFloat[0]);
/*     */         break;
/*     */       case 2:
/* 230 */         shaderUniform.func_148087_a(arrayOfFloat[0], arrayOfFloat[1]);
/*     */         break;
/*     */       case 3:
/* 233 */         shaderUniform.func_148095_a(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2]);
/*     */         break;
/*     */       case 4:
/* 236 */         shaderUniform.func_148081_a(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3]);
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_148020_a(String p_148020_1_, int p_148020_2_, int p_148020_3_) {
/* 242 */     Framebuffer framebuffer = new Framebuffer(p_148020_2_, p_148020_3_, true);
/* 243 */     framebuffer.func_147604_a(0.0F, 0.0F, 0.0F, 0.0F);
/* 244 */     this.field_148032_e.put(p_148020_1_, framebuffer);
/*     */     
/* 246 */     if (p_148020_2_ == this.field_148038_h && p_148020_3_ == this.field_148039_i) {
/* 247 */       this.field_148029_f.add(framebuffer);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_148021_a() {
/* 252 */     for (Framebuffer framebuffer : this.field_148032_e.values()) {
/* 253 */       framebuffer.func_147608_a();
/*     */     }
/* 255 */     for (Shader shader : this.field_148031_d) {
/* 256 */       shader.func_148044_b();
/*     */     }
/* 258 */     this.field_148031_d.clear();
/*     */   }
/*     */   
/*     */   public Shader func_148023_a(String p_148023_1_, Framebuffer p_148023_2_, Framebuffer p_148023_3_) throws JsonException {
/* 262 */     Shader shader = new Shader(this.field_148033_b, p_148023_1_, p_148023_2_, p_148023_3_);
/* 263 */     this.field_148031_d.add(this.field_148031_d.size(), shader);
/* 264 */     return shader;
/*     */   }
/*     */   
/*     */   private void func_148024_c() {
/* 268 */     this.field_148030_g = new Matrix4f();
/* 269 */     this.field_148030_g.setIdentity();
/* 270 */     this.field_148030_g.m00 = 2.0F / this.field_148035_a.field_147622_a;
/* 271 */     this.field_148030_g.m11 = 2.0F / -this.field_148035_a.field_147620_b;
/* 272 */     this.field_148030_g.m22 = -0.0020001999F;
/* 273 */     this.field_148030_g.m33 = 1.0F;
/* 274 */     this.field_148030_g.m03 = -1.0F;
/* 275 */     this.field_148030_g.m13 = 1.0F;
/* 276 */     this.field_148030_g.m23 = -1.0001999F;
/*     */   }
/*     */   
/*     */   public void func_148026_a(int p_148026_1_, int p_148026_2_) {
/* 280 */     this.field_148038_h = this.field_148035_a.field_147622_a;
/* 281 */     this.field_148039_i = this.field_148035_a.field_147620_b;
/* 282 */     func_148024_c();
/* 283 */     for (Shader shader : this.field_148031_d) {
/* 284 */       shader.func_148045_a(this.field_148030_g);
/*     */     }
/* 286 */     for (Framebuffer framebuffer : this.field_148029_f) {
/* 287 */       framebuffer.func_147613_a(p_148026_1_, p_148026_2_);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148018_a(float p_148018_1_) {
/* 293 */     if (p_148018_1_ < this.field_148037_k) {
/* 294 */       this.field_148036_j += 1.0F - this.field_148037_k;
/* 295 */       this.field_148036_j += p_148018_1_;
/*     */     } else {
/* 297 */       this.field_148036_j += p_148018_1_ - this.field_148037_k;
/*     */     } 
/* 299 */     this.field_148037_k = p_148018_1_;
/* 300 */     while (this.field_148036_j > 20.0F) {
/* 301 */       this.field_148036_j -= 20.0F;
/*     */     }
/* 303 */     for (Shader shader : this.field_148031_d) {
/* 304 */       shader.func_148042_a(this.field_148036_j / 20.0F);
/*     */     }
/*     */   }
/*     */   
/*     */   public final String func_148022_b() {
/* 309 */     return this.field_148034_c;
/*     */   }
/*     */   
/*     */   private Framebuffer func_148017_a(String p_148017_1_) {
/* 313 */     if (p_148017_1_ == null) return null; 
/* 314 */     if (p_148017_1_.equals("minecraft:main")) return this.field_148035_a; 
/* 315 */     return (Framebuffer)this.field_148032_e.get(p_148017_1_);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\shader\ShaderGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */