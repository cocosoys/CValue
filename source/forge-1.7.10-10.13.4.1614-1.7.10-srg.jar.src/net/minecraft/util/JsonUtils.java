/*     */ package net.minecraft.util;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonSyntaxException;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class JsonUtils {
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static boolean func_151205_a(JsonObject p_151205_0_, String p_151205_1_) {
/*  11 */     if (!func_151201_f(p_151205_0_, p_151205_1_)) {
/*  12 */       return false;
/*     */     }
/*  14 */     return p_151205_0_.getAsJsonPrimitive(p_151205_1_).isString();
/*     */   } private static final String __OBFID = "CL_00001484";
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static boolean func_151211_a(JsonElement p_151211_0_) {
/*  18 */     if (!p_151211_0_.isJsonPrimitive()) {
/*  19 */       return false;
/*     */     }
/*  21 */     return p_151211_0_.getAsJsonPrimitive().isString();
/*     */   }
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
/*     */   public static boolean func_151202_d(JsonObject p_151202_0_, String p_151202_1_) {
/*  53 */     if (!func_151204_g(p_151202_0_, p_151202_1_)) {
/*  54 */       return false;
/*     */     }
/*  56 */     if (!p_151202_0_.get(p_151202_1_).isJsonArray()) {
/*  57 */       return false;
/*     */     }
/*  59 */     return true;
/*     */   }
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
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static boolean func_151201_f(JsonObject p_151201_0_, String p_151201_1_) {
/*  73 */     if (!func_151204_g(p_151201_0_, p_151201_1_)) {
/*  74 */       return false;
/*     */     }
/*  76 */     if (!p_151201_0_.get(p_151201_1_).isJsonPrimitive()) {
/*  77 */       return false;
/*     */     }
/*  79 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean func_151204_g(JsonObject p_151204_0_, String p_151204_1_) {
/*  83 */     if (p_151204_0_ == null) {
/*  84 */       return false;
/*     */     }
/*  86 */     if (p_151204_0_.get(p_151204_1_) == null) {
/*  87 */       return false;
/*     */     }
/*  89 */     return true;
/*     */   }
/*     */   
/*     */   public static String func_151206_a(JsonElement p_151206_0_, String p_151206_1_) {
/*  93 */     if (p_151206_0_.isJsonPrimitive()) {
/*  94 */       return p_151206_0_.getAsString();
/*     */     }
/*  96 */     throw new JsonSyntaxException("Expected " + p_151206_1_ + " to be a string, was " + func_151222_d(p_151206_0_));
/*     */   }
/*     */ 
/*     */   
/*     */   public static String func_151200_h(JsonObject p_151200_0_, String p_151200_1_) {
/* 101 */     if (p_151200_0_.has(p_151200_1_)) {
/* 102 */       return func_151206_a(p_151200_0_.get(p_151200_1_), p_151200_1_);
/*     */     }
/* 104 */     throw new JsonSyntaxException("Missing " + p_151200_1_ + ", expected to find a string");
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static String func_151219_a(JsonObject p_151219_0_, String p_151219_1_, String p_151219_2_) {
/* 109 */     if (p_151219_0_.has(p_151219_1_)) {
/* 110 */       return func_151206_a(p_151219_0_.get(p_151219_1_), p_151219_1_);
/*     */     }
/* 112 */     return p_151219_2_;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static boolean func_151216_b(JsonElement p_151216_0_, String p_151216_1_) {
/* 117 */     if (p_151216_0_.isJsonPrimitive()) {
/* 118 */       return p_151216_0_.getAsBoolean();
/*     */     }
/* 120 */     throw new JsonSyntaxException("Expected " + p_151216_1_ + " to be a Boolean, was " + func_151222_d(p_151216_0_));
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static boolean func_151212_i(JsonObject p_151212_0_, String p_151212_1_) {
/* 125 */     if (p_151212_0_.has(p_151212_1_)) {
/* 126 */       return func_151216_b(p_151212_0_.get(p_151212_1_), p_151212_1_);
/*     */     }
/* 128 */     throw new JsonSyntaxException("Missing " + p_151212_1_ + ", expected to find a Boolean");
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static boolean func_151209_a(JsonObject p_151209_0_, String p_151209_1_, boolean p_151209_2_) {
/* 133 */     if (p_151209_0_.has(p_151209_1_)) {
/* 134 */       return func_151216_b(p_151209_0_.get(p_151209_1_), p_151209_1_);
/*     */     }
/* 136 */     return p_151209_2_;
/*     */   }
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
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static float func_151220_d(JsonElement p_151220_0_, String p_151220_1_) {
/* 165 */     if (p_151220_0_.isJsonPrimitive() && p_151220_0_.getAsJsonPrimitive().isNumber()) {
/* 166 */       return p_151220_0_.getAsFloat();
/*     */     }
/* 168 */     throw new JsonSyntaxException("Expected " + p_151220_1_ + " to be a Float, was " + func_151222_d(p_151220_0_));
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static float func_151217_k(JsonObject p_151217_0_, String p_151217_1_) {
/* 173 */     if (p_151217_0_.has(p_151217_1_)) {
/* 174 */       return func_151220_d(p_151217_0_.get(p_151217_1_), p_151217_1_);
/*     */     }
/* 176 */     throw new JsonSyntaxException("Missing " + p_151217_1_ + ", expected to find a Float");
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static float func_151221_a(JsonObject p_151221_0_, String p_151221_1_, float p_151221_2_) {
/* 181 */     if (p_151221_0_.has(p_151221_1_)) {
/* 182 */       return func_151220_d(p_151221_0_.get(p_151221_1_), p_151221_1_);
/*     */     }
/* 184 */     return p_151221_2_;
/*     */   }
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
/*     */   public static int func_151215_f(JsonElement p_151215_0_, String p_151215_1_) {
/* 213 */     if (p_151215_0_.isJsonPrimitive() && p_151215_0_.getAsJsonPrimitive().isNumber()) {
/* 214 */       return p_151215_0_.getAsInt();
/*     */     }
/* 216 */     throw new JsonSyntaxException("Expected " + p_151215_1_ + " to be a Int, was " + func_151222_d(p_151215_0_));
/*     */   }
/*     */ 
/*     */   
/*     */   public static int func_151203_m(JsonObject p_151203_0_, String p_151203_1_) {
/* 221 */     if (p_151203_0_.has(p_151203_1_)) {
/* 222 */       return func_151215_f(p_151203_0_.get(p_151203_1_), p_151203_1_);
/*     */     }
/* 224 */     throw new JsonSyntaxException("Missing " + p_151203_1_ + ", expected to find a Int");
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static int func_151208_a(JsonObject p_151208_0_, String p_151208_1_, int p_151208_2_) {
/* 229 */     if (p_151208_0_.has(p_151208_1_)) {
/* 230 */       return func_151215_f(p_151208_0_.get(p_151208_1_), p_151208_1_);
/*     */     }
/* 232 */     return p_151208_2_;
/*     */   }
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
/*     */   public static JsonObject func_151210_l(JsonElement p_151210_0_, String p_151210_1_) {
/* 357 */     if (p_151210_0_.isJsonObject()) {
/* 358 */       return p_151210_0_.getAsJsonObject();
/*     */     }
/* 360 */     throw new JsonSyntaxException("Expected " + p_151210_1_ + " to be a JsonObject, was " + func_151222_d(p_151210_0_));
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static JsonObject func_152754_s(JsonObject p_152754_0_, String p_152754_1_) {
/* 365 */     if (p_152754_0_.has(p_152754_1_)) {
/* 366 */       return func_151210_l(p_152754_0_.get(p_152754_1_), p_152754_1_);
/*     */     }
/* 368 */     throw new JsonSyntaxException("Missing " + p_152754_1_ + ", expected to find a JsonObject");
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static JsonObject func_151218_a(JsonObject p_151218_0_, String p_151218_1_, JsonObject p_151218_2_) {
/* 373 */     if (p_151218_0_.has(p_151218_1_)) {
/* 374 */       return func_151210_l(p_151218_0_.get(p_151218_1_), p_151218_1_);
/*     */     }
/* 376 */     return p_151218_2_;
/*     */   }
/*     */ 
/*     */   
/*     */   public static JsonArray func_151207_m(JsonElement p_151207_0_, String p_151207_1_) {
/* 381 */     if (p_151207_0_.isJsonArray()) {
/* 382 */       return p_151207_0_.getAsJsonArray();
/*     */     }
/* 384 */     throw new JsonSyntaxException("Expected " + p_151207_1_ + " to be a JsonArray, was " + func_151222_d(p_151207_0_));
/*     */   }
/*     */ 
/*     */   
/*     */   public static JsonArray func_151214_t(JsonObject p_151214_0_, String p_151214_1_) {
/* 389 */     if (p_151214_0_.has(p_151214_1_)) {
/* 390 */       return func_151207_m(p_151214_0_.get(p_151214_1_), p_151214_1_);
/*     */     }
/* 392 */     throw new JsonSyntaxException("Missing " + p_151214_1_ + ", expected to find a JsonArray");
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static JsonArray func_151213_a(JsonObject p_151213_0_, String p_151213_1_, JsonArray p_151213_2_) {
/* 397 */     if (p_151213_0_.has(p_151213_1_)) {
/* 398 */       return func_151207_m(p_151213_0_.get(p_151213_1_), p_151213_1_);
/*     */     }
/* 400 */     return p_151213_2_;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String func_151222_d(JsonElement p_151222_0_) {
/* 405 */     String str = StringUtils.abbreviateMiddle(String.valueOf(p_151222_0_), "...", 10);
/* 406 */     if (p_151222_0_ == null) return "null (missing)"; 
/* 407 */     if (p_151222_0_.isJsonNull()) return "null (json)"; 
/* 408 */     if (p_151222_0_.isJsonArray()) return "an array (" + str + ")"; 
/* 409 */     if (p_151222_0_.isJsonObject()) return "an object (" + str + ")"; 
/* 410 */     if (p_151222_0_.isJsonPrimitive()) {
/* 411 */       JsonPrimitive jsonPrimitive = p_151222_0_.getAsJsonPrimitive();
/* 412 */       if (jsonPrimitive.isNumber()) return "a number (" + str + ")"; 
/* 413 */       if (jsonPrimitive.isBoolean()) return "a boolean (" + str + ")"; 
/*     */     } 
/* 415 */     return str;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\JsonUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */