/*     */ package net.minecraft.client.shader;
/*     */ 
/*     */ import com.google.common.collect.Maps;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.IOException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.Map;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.resources.IResourceManager;
/*     */ import net.minecraft.client.util.JsonException;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.apache.commons.io.IOUtils;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.lwjgl.BufferUtils;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ShaderLoader
/*     */ {
/*     */   private final ShaderType field_148061_a;
/*     */   private final String field_148059_b;
/*     */   private int field_148060_c;
/*  24 */   private int field_148058_d = 0; private static final String __OBFID = "CL_00001043";
/*     */   
/*     */   private ShaderLoader(ShaderType p_i45091_1_, int p_i45091_2_, String p_i45091_3_) {
/*  27 */     this.field_148061_a = p_i45091_1_;
/*  28 */     this.field_148060_c = p_i45091_2_;
/*  29 */     this.field_148059_b = p_i45091_3_;
/*     */   }
/*     */   
/*     */   public void func_148056_a(ShaderManager p_148056_1_) {
/*  33 */     this.field_148058_d++;
/*  34 */     OpenGlHelper.func_153178_b(p_148056_1_.func_147986_h(), this.field_148060_c);
/*     */   }
/*     */   
/*     */   public void func_148054_b(ShaderManager p_148054_1_) {
/*  38 */     this.field_148058_d--;
/*     */     
/*  40 */     if (this.field_148058_d <= 0) {
/*  41 */       OpenGlHelper.func_153180_a(this.field_148060_c);
/*  42 */       this.field_148061_a.func_148064_d().remove(this.field_148059_b);
/*     */     } 
/*     */   }
/*     */   
/*     */   public String func_148055_a() {
/*  47 */     return this.field_148059_b;
/*     */   }
/*     */   
/*     */   public static ShaderLoader func_148057_a(IResourceManager p_148057_0_, ShaderType p_148057_1_, String p_148057_2_) throws IOException {
/*  51 */     ShaderLoader shaderLoader = (ShaderLoader)p_148057_1_.func_148064_d().get(p_148057_2_);
/*     */     
/*  53 */     if (shaderLoader == null) {
/*  54 */       ResourceLocation resourceLocation = new ResourceLocation("shaders/program/" + p_148057_2_ + p_148057_1_.func_148063_b());
/*  55 */       BufferedInputStream bufferedInputStream = new BufferedInputStream(p_148057_0_.func_110536_a(resourceLocation).func_110527_b());
/*  56 */       byte[] arrayOfByte = IOUtils.toByteArray(bufferedInputStream);
/*  57 */       ByteBuffer byteBuffer = BufferUtils.createByteBuffer(arrayOfByte.length);
/*  58 */       byteBuffer.put(arrayOfByte);
/*  59 */       byteBuffer.position(0);
/*     */       
/*  61 */       int i = OpenGlHelper.func_153195_b(p_148057_1_.func_148065_c());
/*  62 */       OpenGlHelper.func_153169_a(i, byteBuffer);
/*  63 */       OpenGlHelper.func_153170_c(i);
/*     */       
/*  65 */       if (OpenGlHelper.func_153157_c(i, OpenGlHelper.field_153208_p) == 0) {
/*  66 */         String str = StringUtils.trim(OpenGlHelper.func_153158_d(i, 32768));
/*  67 */         JsonException jsonException = new JsonException("Couldn't compile " + p_148057_1_.func_148062_a() + " program: " + str);
/*  68 */         jsonException.func_151381_b(resourceLocation.func_110623_a());
/*  69 */         throw jsonException;
/*     */       } 
/*     */       
/*  72 */       shaderLoader = new ShaderLoader(p_148057_1_, i, p_148057_2_);
/*  73 */       p_148057_1_.func_148064_d().put(p_148057_2_, shaderLoader);
/*     */     } 
/*     */     
/*  76 */     return shaderLoader;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*  80 */   public enum ShaderType { VERTEX("vertex", ".vsh", OpenGlHelper.field_153209_q),
/*  81 */     FRAGMENT("fragment", ".fsh", OpenGlHelper.field_153210_r);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  86 */     private final Map field_148067_f = Maps.newHashMap(); private final String field_148072_c; private final String field_148069_d;
/*     */     
/*     */     ShaderType(String p_i45090_3_, String p_i45090_4_, int p_i45090_5_) {
/*  89 */       this.field_148072_c = p_i45090_3_;
/*  90 */       this.field_148069_d = p_i45090_4_;
/*  91 */       this.field_148070_e = p_i45090_5_;
/*     */     }
/*     */     private final int field_148070_e; private static final String __OBFID = "CL_00001044";
/*     */     public String func_148062_a() {
/*  95 */       return this.field_148072_c;
/*     */     }
/*     */     
/*     */     protected String func_148063_b() {
/*  99 */       return this.field_148069_d;
/*     */     }
/*     */     
/*     */     protected int func_148065_c() {
/* 103 */       return this.field_148070_e;
/*     */     }
/*     */     
/*     */     protected Map func_148064_d() {
/* 107 */       return this.field_148067_f;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\shader\ShaderLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */