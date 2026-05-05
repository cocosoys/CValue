/*     */ package net.minecraft.client.util;
/*     */ import com.google.gson.JsonObject;
/*     */ import net.minecraft.util.JsonUtils;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.opengl.GL14;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class JsonBlendingMode {
/*   9 */   private static JsonBlendingMode field_148118_a = null;
/*     */   private final int field_148116_b;
/*     */   private final int field_148117_c;
/*     */   private final int field_148114_d;
/*     */   private final int field_148115_e;
/*     */   private final int field_148112_f;
/*     */   private final boolean field_148113_g;
/*     */   private final boolean field_148119_h;
/*     */   private static final String __OBFID = "CL_00001038";
/*     */   
/*     */   private JsonBlendingMode(boolean p_i45084_1_, boolean p_i45084_2_, int p_i45084_3_, int p_i45084_4_, int p_i45084_5_, int p_i45084_6_, int p_i45084_7_) {
/*  20 */     this.field_148113_g = p_i45084_1_;
/*     */     
/*  22 */     this.field_148116_b = p_i45084_3_;
/*  23 */     this.field_148114_d = p_i45084_4_;
/*     */     
/*  25 */     this.field_148117_c = p_i45084_5_;
/*  26 */     this.field_148115_e = p_i45084_6_;
/*     */     
/*  28 */     this.field_148119_h = p_i45084_2_;
/*  29 */     this.field_148112_f = p_i45084_7_;
/*     */   }
/*     */   
/*     */   public JsonBlendingMode() {
/*  33 */     this(false, true, 1, 0, 1, 0, 32774);
/*     */   }
/*     */   
/*     */   public JsonBlendingMode(int p_i45085_1_, int p_i45085_2_, int p_i45085_3_) {
/*  37 */     this(false, false, p_i45085_1_, p_i45085_2_, p_i45085_1_, p_i45085_2_, p_i45085_3_);
/*     */   }
/*     */   
/*     */   public JsonBlendingMode(int p_i45086_1_, int p_i45086_2_, int p_i45086_3_, int p_i45086_4_, int p_i45086_5_) {
/*  41 */     this(true, false, p_i45086_1_, p_i45086_2_, p_i45086_3_, p_i45086_4_, p_i45086_5_);
/*     */   }
/*     */   
/*     */   public void func_148109_a() {
/*  45 */     if (equals(field_148118_a)) {
/*     */       return;
/*     */     }
/*     */     
/*  49 */     if (field_148118_a == null || this.field_148119_h != field_148118_a.func_148111_b()) {
/*  50 */       field_148118_a = this;
/*  51 */       if (this.field_148119_h) {
/*  52 */         GL11.glDisable(3042);
/*     */         return;
/*     */       } 
/*  55 */       GL11.glEnable(3042);
/*     */     } 
/*     */     
/*  58 */     GL14.glBlendEquation(this.field_148112_f);
/*     */     
/*  60 */     if (this.field_148113_g) {
/*  61 */       GL14.glBlendFuncSeparate(this.field_148116_b, this.field_148114_d, this.field_148117_c, this.field_148115_e);
/*     */     } else {
/*  63 */       GL11.glBlendFunc(this.field_148116_b, this.field_148114_d);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object p_equals_1_) {
/*  69 */     if (this == p_equals_1_) return true; 
/*  70 */     if (!(p_equals_1_ instanceof JsonBlendingMode)) return false;
/*     */     
/*  72 */     JsonBlendingMode jsonBlendingMode = (JsonBlendingMode)p_equals_1_;
/*     */     
/*  74 */     if (this.field_148112_f != jsonBlendingMode.field_148112_f) return false; 
/*  75 */     if (this.field_148115_e != jsonBlendingMode.field_148115_e) return false; 
/*  76 */     if (this.field_148114_d != jsonBlendingMode.field_148114_d) return false; 
/*  77 */     if (this.field_148119_h != jsonBlendingMode.field_148119_h) return false; 
/*  78 */     if (this.field_148113_g != jsonBlendingMode.field_148113_g) return false; 
/*  79 */     if (this.field_148117_c != jsonBlendingMode.field_148117_c) return false; 
/*  80 */     if (this.field_148116_b != jsonBlendingMode.field_148116_b) return false;
/*     */     
/*  82 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  87 */     int i = this.field_148116_b;
/*  88 */     i = 31 * i + this.field_148117_c;
/*  89 */     i = 31 * i + this.field_148114_d;
/*  90 */     i = 31 * i + this.field_148115_e;
/*  91 */     i = 31 * i + this.field_148112_f;
/*  92 */     i = 31 * i + (this.field_148113_g ? 1 : 0);
/*  93 */     i = 31 * i + (this.field_148119_h ? 1 : 0);
/*  94 */     return i;
/*     */   }
/*     */   
/*     */   public boolean func_148111_b() {
/*  98 */     return this.field_148119_h;
/*     */   }
/*     */   
/*     */   public static JsonBlendingMode func_148110_a(JsonObject p_148110_0_) {
/* 102 */     if (p_148110_0_ == null) return new JsonBlendingMode(); 
/* 103 */     int i = 32774;
/* 104 */     int j = 1;
/* 105 */     int k = 0;
/* 106 */     int m = 1;
/* 107 */     int n = 0;
/* 108 */     boolean bool1 = true;
/* 109 */     boolean bool2 = false;
/*     */     
/* 111 */     if (JsonUtils.func_151205_a(p_148110_0_, "func")) {
/* 112 */       i = func_148108_a(p_148110_0_.get("func").getAsString());
/* 113 */       if (i != 32774) {
/* 114 */         bool1 = false;
/*     */       }
/*     */     } 
/*     */     
/* 118 */     if (JsonUtils.func_151205_a(p_148110_0_, "srcrgb")) {
/* 119 */       j = func_148107_b(p_148110_0_.get("srcrgb").getAsString());
/* 120 */       if (j != 1) {
/* 121 */         bool1 = false;
/*     */       }
/*     */     } 
/*     */     
/* 125 */     if (JsonUtils.func_151205_a(p_148110_0_, "dstrgb")) {
/* 126 */       k = func_148107_b(p_148110_0_.get("dstrgb").getAsString());
/* 127 */       if (k != 0) {
/* 128 */         bool1 = false;
/*     */       }
/*     */     } 
/*     */     
/* 132 */     if (JsonUtils.func_151205_a(p_148110_0_, "srcalpha")) {
/* 133 */       m = func_148107_b(p_148110_0_.get("srcalpha").getAsString());
/* 134 */       if (m != 1) {
/* 135 */         bool1 = false;
/*     */       }
/* 137 */       bool2 = true;
/*     */     } 
/*     */     
/* 140 */     if (JsonUtils.func_151205_a(p_148110_0_, "dstalpha")) {
/* 141 */       n = func_148107_b(p_148110_0_.get("dstalpha").getAsString());
/* 142 */       if (n != 0) {
/* 143 */         bool1 = false;
/*     */       }
/* 145 */       bool2 = true;
/*     */     } 
/*     */ 
/*     */     
/* 149 */     if (bool1) {
/* 150 */       return new JsonBlendingMode();
/*     */     }
/*     */ 
/*     */     
/* 154 */     if (bool2) {
/* 155 */       return new JsonBlendingMode(j, k, m, n, i);
/*     */     }
/* 157 */     return new JsonBlendingMode(j, k, i);
/*     */   }
/*     */ 
/*     */   
/*     */   private static int func_148108_a(String p_148108_0_) {
/* 162 */     String str = p_148108_0_.trim().toLowerCase();
/*     */     
/* 164 */     if (str.equals("add"))
/* 165 */       return 32774; 
/* 166 */     if (str.equals("subtract"))
/* 167 */       return 32778; 
/* 168 */     if (str.equals("reversesubtract"))
/* 169 */       return 32779; 
/* 170 */     if (str.equals("reverse_subtract"))
/* 171 */       return 32779; 
/* 172 */     if (str.equals("min"))
/* 173 */       return 32775; 
/* 174 */     if (str.equals("max")) {
/* 175 */       return 32776;
/*     */     }
/*     */     
/* 178 */     return 32774;
/*     */   }
/*     */   
/*     */   private static int func_148107_b(String p_148107_0_) {
/* 182 */     String str = p_148107_0_.trim().toLowerCase();
/* 183 */     str = str.replaceAll("_", "");
/* 184 */     str = str.replaceAll("one", "1");
/* 185 */     str = str.replaceAll("zero", "0");
/* 186 */     str = str.replaceAll("minus", "-");
/*     */     
/* 188 */     if (str.equals("0"))
/* 189 */       return 0; 
/* 190 */     if (str.equals("1"))
/* 191 */       return 1; 
/* 192 */     if (str.equals("srccolor"))
/* 193 */       return 768; 
/* 194 */     if (str.equals("1-srccolor"))
/* 195 */       return 769; 
/* 196 */     if (str.equals("dstcolor"))
/* 197 */       return 774; 
/* 198 */     if (str.equals("1-dstcolor"))
/* 199 */       return 775; 
/* 200 */     if (str.equals("srcalpha"))
/* 201 */       return 770; 
/* 202 */     if (str.equals("1-srcalpha"))
/* 203 */       return 771; 
/* 204 */     if (str.equals("dstalpha"))
/* 205 */       return 772; 
/* 206 */     if (str.equals("1-dstalpha")) {
/* 207 */       return 773;
/*     */     }
/* 209 */     return -1;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\clien\\util\JsonBlendingMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */