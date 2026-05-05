/*     */ package net.minecraft.nbt;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Stack;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ public class JsonToNBT {
/*   9 */   private static final Logger field_150317_a = LogManager.getLogger();
/*     */ 
/*     */   
/*     */   private static final String __OBFID = "CL_00001232";
/*     */ 
/*     */   
/*     */   public static NBTBase func_150315_a(String p_150315_0_) throws NBTException {
/*  16 */     p_150315_0_ = p_150315_0_.trim();
/*  17 */     int i = func_150310_b(p_150315_0_);
/*  18 */     if (i != 1) {
/*  19 */       throw new NBTException("Encountered multiple top tags, only one expected");
/*     */     }
/*     */     
/*  22 */     Any any = null;
/*  23 */     if (p_150315_0_.startsWith("{")) {
/*  24 */       any = func_150316_a("tag", p_150315_0_);
/*     */     } else {
/*  26 */       any = func_150316_a(func_150313_b(p_150315_0_, false), func_150311_c(p_150315_0_, false));
/*     */     } 
/*     */     
/*  29 */     return any.func_150489_a();
/*     */   }
/*     */ 
/*     */   
/*     */   static int func_150310_b(String p_150310_0_) throws NBTException {
/*  34 */     byte b1 = 0;
/*  35 */     boolean bool = false;
/*  36 */     Stack<Character> stack = new Stack();
/*     */     
/*  38 */     byte b2 = 0;
/*  39 */     while (b2 < p_150310_0_.length()) {
/*  40 */       char c = p_150310_0_.charAt(b2);
/*  41 */       if (c == '"') {
/*  42 */         if (b2 > 0 && p_150310_0_.charAt(b2 - 1) == '\\') {
/*  43 */           if (!bool) {
/*  44 */             throw new NBTException("Illegal use of \\\": " + p_150310_0_);
/*     */           }
/*     */         } else {
/*  47 */           bool = !bool ? true : false;
/*     */         } 
/*  49 */       } else if (!bool) {
/*  50 */         if (c == '{' || c == '[')
/*  51 */         { if (stack.isEmpty()) {
/*  52 */             b1++;
/*     */           }
/*  54 */           stack.push(Character.valueOf(c)); }
/*  55 */         else { if (c == '}' && (stack.isEmpty() || ((Character)stack.pop()).charValue() != '{'))
/*  56 */             throw new NBTException("Unbalanced curly brackets {}: " + p_150310_0_); 
/*  57 */           if (c == ']' && (stack.isEmpty() || ((Character)stack.pop()).charValue() != '['))
/*  58 */             throw new NBTException("Unbalanced square brackets []: " + p_150310_0_);  }
/*     */       
/*     */       } 
/*  61 */       b2++;
/*     */     } 
/*  63 */     if (bool) {
/*  64 */       throw new NBTException("Unbalanced quotation: " + p_150310_0_);
/*     */     }
/*  66 */     if (!stack.isEmpty()) {
/*  67 */       throw new NBTException("Unbalanced brackets: " + p_150310_0_);
/*     */     }
/*     */     
/*  70 */     if (b1 == 0 && !p_150310_0_.isEmpty()) {
/*  71 */       return 1;
/*     */     }
/*  73 */     return b1;
/*     */   }
/*     */   
/*     */   static Any func_150316_a(String p_150316_0_, String p_150316_1_) throws NBTException {
/*  77 */     p_150316_1_ = p_150316_1_.trim();
/*  78 */     func_150310_b(p_150316_1_);
/*     */     
/*  80 */     if (p_150316_1_.startsWith("{")) {
/*  81 */       if (!p_150316_1_.endsWith("}")) {
/*  82 */         throw new NBTException("Unable to locate ending bracket for: " + p_150316_1_);
/*     */       }
/*     */       
/*  85 */       p_150316_1_ = p_150316_1_.substring(1, p_150316_1_.length() - 1);
/*     */       
/*  87 */       Compound compound = new Compound(p_150316_0_);
/*  88 */       while (p_150316_1_.length() > 0) {
/*  89 */         String str = func_150314_a(p_150316_1_, false);
/*  90 */         if (str.length() > 0) {
/*  91 */           String str1 = func_150313_b(str, false);
/*  92 */           String str2 = func_150311_c(str, false);
/*  93 */           compound.field_150491_b.add(func_150316_a(str1, str2));
/*     */           
/*  95 */           if (p_150316_1_.length() >= str.length() + 1) {
/*  96 */             char c = p_150316_1_.charAt(str.length());
/*  97 */             if (c != ',' && c != '{' && c != '}' && c != '[' && c != ']') {
/*  98 */               throw new NBTException("Unexpected token '" + c + "' at: " + p_150316_1_.substring(str.length()));
/*     */             }
/* 100 */             p_150316_1_ = p_150316_1_.substring(str.length() + 1);
/*     */             
/*     */             continue;
/*     */           } 
/*     */           break;
/*     */         } 
/*     */       } 
/* 107 */       return compound;
/* 108 */     }  if (p_150316_1_.startsWith("[") && !p_150316_1_.matches("\\[[-\\d|,\\s]+\\]")) {
/* 109 */       if (!p_150316_1_.endsWith("]")) {
/* 110 */         throw new NBTException("Unable to locate ending bracket for: " + p_150316_1_);
/*     */       }
/*     */       
/* 113 */       p_150316_1_ = p_150316_1_.substring(1, p_150316_1_.length() - 1);
/*     */       
/* 115 */       List list = new List(p_150316_0_);
/* 116 */       while (p_150316_1_.length() > 0) {
/* 117 */         String str = func_150314_a(p_150316_1_, true);
/* 118 */         if (str.length() > 0) {
/* 119 */           String str1 = func_150313_b(str, true);
/* 120 */           String str2 = func_150311_c(str, true);
/* 121 */           list.field_150492_b.add(func_150316_a(str1, str2));
/*     */           
/* 123 */           if (p_150316_1_.length() >= str.length() + 1) {
/* 124 */             char c = p_150316_1_.charAt(str.length());
/* 125 */             if (c != ',' && c != '{' && c != '}' && c != '[' && c != ']') {
/* 126 */               throw new NBTException("Unexpected token '" + c + "' at: " + p_150316_1_.substring(str.length()));
/*     */             }
/* 128 */             p_150316_1_ = p_150316_1_.substring(str.length() + 1);
/*     */             continue;
/*     */           } 
/*     */           break;
/*     */         } 
/* 133 */         field_150317_a.debug(p_150316_1_);
/*     */       } 
/*     */ 
/*     */       
/* 137 */       return list;
/*     */     } 
/* 139 */     return new Primitive(p_150316_0_, p_150316_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   private static String func_150314_a(String p_150314_0_, boolean p_150314_1_) throws NBTException {
/* 144 */     int i = func_150312_a(p_150314_0_, ':');
/* 145 */     if (i < 0 && !p_150314_1_) {
/* 146 */       throw new NBTException("Unable to locate name/value separator for string: " + p_150314_0_);
/*     */     }
/* 148 */     int j = func_150312_a(p_150314_0_, ',');
/* 149 */     if (j >= 0 && j < i && !p_150314_1_) {
/* 150 */       throw new NBTException("Name error at: " + p_150314_0_);
/*     */     }
/* 152 */     if (p_150314_1_ && (i < 0 || i > j)) {
/* 153 */       i = -1;
/*     */     }
/*     */     
/* 156 */     Stack<Character> stack = new Stack();
/* 157 */     int k = i + 1;
/* 158 */     boolean bool1 = false;
/* 159 */     boolean bool2 = false;
/* 160 */     boolean bool3 = false;
/* 161 */     int m = 0;
/*     */     
/* 163 */     while (k < p_150314_0_.length()) {
/* 164 */       char c = p_150314_0_.charAt(k);
/*     */       
/* 166 */       if (c == '"') {
/* 167 */         if (k > 0 && p_150314_0_.charAt(k - 1) == '\\') {
/* 168 */           if (!bool1) {
/* 169 */             throw new NBTException("Illegal use of \\\": " + p_150314_0_);
/*     */           }
/*     */         } else {
/* 172 */           bool1 = !bool1 ? true : false;
/* 173 */           if (bool1 && !bool3) {
/* 174 */             bool2 = true;
/*     */           }
/* 176 */           if (!bool1) {
/* 177 */             m = k;
/*     */           }
/*     */         } 
/* 180 */       } else if (!bool1) {
/* 181 */         if (c == '{' || c == '[')
/* 182 */         { stack.push(Character.valueOf(c)); }
/* 183 */         else { if (c == '}' && (stack.isEmpty() || ((Character)stack.pop()).charValue() != '{'))
/* 184 */             throw new NBTException("Unbalanced curly brackets {}: " + p_150314_0_); 
/* 185 */           if (c == ']' && (stack.isEmpty() || ((Character)stack.pop()).charValue() != '['))
/* 186 */             throw new NBTException("Unbalanced square brackets []: " + p_150314_0_); 
/* 187 */           if (c == ',' && 
/* 188 */             stack.isEmpty()) {
/* 189 */             return p_150314_0_.substring(0, k);
/*     */           } }
/*     */       
/*     */       } 
/* 193 */       if (!Character.isWhitespace(c)) {
/* 194 */         if (!bool1 && bool2 && m != k) {
/* 195 */           return p_150314_0_.substring(0, m + 1);
/*     */         }
/* 197 */         bool3 = true;
/*     */       } 
/*     */       
/* 200 */       k++;
/*     */     } 
/*     */     
/* 203 */     return p_150314_0_.substring(0, k);
/*     */   }
/*     */   
/*     */   private static String func_150313_b(String p_150313_0_, boolean p_150313_1_) throws NBTException {
/* 207 */     if (p_150313_1_) {
/* 208 */       p_150313_0_ = p_150313_0_.trim();
/* 209 */       if (p_150313_0_.startsWith("{") || p_150313_0_.startsWith("[")) {
/* 210 */         return "";
/*     */       }
/*     */     } 
/*     */     
/* 214 */     int i = p_150313_0_.indexOf(':');
/* 215 */     if (i < 0) {
/* 216 */       if (p_150313_1_) {
/* 217 */         return "";
/*     */       }
/* 219 */       throw new NBTException("Unable to locate name/value separator for string: " + p_150313_0_);
/*     */     } 
/* 221 */     return p_150313_0_.substring(0, i).trim();
/*     */   }
/*     */   
/*     */   private static String func_150311_c(String p_150311_0_, boolean p_150311_1_) throws NBTException {
/* 225 */     if (p_150311_1_) {
/* 226 */       p_150311_0_ = p_150311_0_.trim();
/* 227 */       if (p_150311_0_.startsWith("{") || p_150311_0_.startsWith("[")) {
/* 228 */         return p_150311_0_;
/*     */       }
/*     */     } 
/*     */     
/* 232 */     int i = p_150311_0_.indexOf(':');
/* 233 */     if (i < 0) {
/* 234 */       if (p_150311_1_) {
/* 235 */         return p_150311_0_;
/*     */       }
/* 237 */       throw new NBTException("Unable to locate name/value separator for string: " + p_150311_0_);
/*     */     } 
/* 239 */     return p_150311_0_.substring(i + 1).trim();
/*     */   }
/*     */   
/*     */   private static int func_150312_a(String p_150312_0_, char p_150312_1_) {
/* 243 */     byte b = 0;
/* 244 */     boolean bool = false;
/* 245 */     while (b < p_150312_0_.length()) {
/* 246 */       char c = p_150312_0_.charAt(b);
/* 247 */       if (c == '"') {
/* 248 */         if (b <= 0 || p_150312_0_.charAt(b - 1) != '\\')
/*     */         {
/* 250 */           bool = !bool ? true : false;
/*     */         }
/* 252 */       } else if (!bool) {
/* 253 */         if (c == p_150312_1_) {
/* 254 */           return b;
/*     */         }
/* 256 */         if (c == '{' || c == '[') {
/* 257 */           return -1;
/*     */         }
/*     */       } 
/* 260 */       b++;
/*     */     } 
/* 262 */     return -1;
/*     */   }
/*     */   
/*     */   static abstract class Any {
/*     */     protected String field_150490_a;
/*     */     private static final String __OBFID = "CL_00001233";
/*     */     
/*     */     public abstract NBTBase func_150489_a();
/*     */   }
/*     */   
/*     */   static class Compound extends Any {
/* 273 */     protected ArrayList field_150491_b = new ArrayList(); private static final String __OBFID = "CL_00001234";
/*     */     
/*     */     public Compound(String p_i45137_1_) {
/* 276 */       this.field_150490_a = p_i45137_1_;
/*     */     }
/*     */ 
/*     */     
/*     */     public NBTBase func_150489_a() {
/* 281 */       NBTTagCompound nBTTagCompound = new NBTTagCompound();
/*     */       
/* 283 */       for (JsonToNBT.Any any : this.field_150491_b) {
/* 284 */         nBTTagCompound.func_74782_a(any.field_150490_a, any.func_150489_a());
/*     */       }
/*     */       
/* 287 */       return nBTTagCompound;
/*     */     }
/*     */   }
/*     */   
/*     */   static class List extends Any {
/* 292 */     protected ArrayList field_150492_b = new ArrayList(); private static final String __OBFID = "CL_00001235";
/*     */     
/*     */     public List(String p_i45138_1_) {
/* 295 */       this.field_150490_a = p_i45138_1_;
/*     */     }
/*     */ 
/*     */     
/*     */     public NBTBase func_150489_a() {
/* 300 */       NBTTagList nBTTagList = new NBTTagList();
/*     */       
/* 302 */       for (JsonToNBT.Any any : this.field_150492_b) {
/* 303 */         nBTTagList.func_74742_a(any.func_150489_a());
/*     */       }
/*     */       
/* 306 */       return nBTTagList;
/*     */     }
/*     */   }
/*     */   
/*     */   static class Primitive extends Any {
/*     */     protected String field_150493_b;
/*     */     private static final String __OBFID = "CL_00001236";
/*     */     
/*     */     public Primitive(String p_i45139_1_, String p_i45139_2_) {
/* 315 */       this.field_150490_a = p_i45139_1_;
/* 316 */       this.field_150493_b = p_i45139_2_;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public NBTBase func_150489_a() {
/*     */       try {
/* 323 */         if (this.field_150493_b.matches("[-+]?[0-9]*\\.?[0-9]+[d|D]"))
/* 324 */           return new NBTTagDouble(Double.parseDouble(this.field_150493_b.substring(0, this.field_150493_b.length() - 1))); 
/* 325 */         if (this.field_150493_b.matches("[-+]?[0-9]*\\.?[0-9]+[f|F]"))
/* 326 */           return new NBTTagFloat(Float.parseFloat(this.field_150493_b.substring(0, this.field_150493_b.length() - 1))); 
/* 327 */         if (this.field_150493_b.matches("[-+]?[0-9]+[b|B]"))
/* 328 */           return new NBTTagByte(Byte.parseByte(this.field_150493_b.substring(0, this.field_150493_b.length() - 1))); 
/* 329 */         if (this.field_150493_b.matches("[-+]?[0-9]+[l|L]"))
/* 330 */           return new NBTTagLong(Long.parseLong(this.field_150493_b.substring(0, this.field_150493_b.length() - 1))); 
/* 331 */         if (this.field_150493_b.matches("[-+]?[0-9]+[s|S]"))
/* 332 */           return new NBTTagShort(Short.parseShort(this.field_150493_b.substring(0, this.field_150493_b.length() - 1))); 
/* 333 */         if (this.field_150493_b.matches("[-+]?[0-9]+"))
/* 334 */           return new NBTTagInt(Integer.parseInt(this.field_150493_b.substring(0, this.field_150493_b.length()))); 
/* 335 */         if (this.field_150493_b.matches("[-+]?[0-9]*\\.?[0-9]+"))
/* 336 */           return new NBTTagDouble(Double.parseDouble(this.field_150493_b.substring(0, this.field_150493_b.length()))); 
/* 337 */         if (this.field_150493_b.equalsIgnoreCase("true") || this.field_150493_b.equalsIgnoreCase("false")) {
/* 338 */           return new NBTTagByte(Boolean.parseBoolean(this.field_150493_b) ? 1 : 0);
/*     */         }
/* 340 */         if (this.field_150493_b.startsWith("[") && this.field_150493_b.endsWith("]")) {
/* 341 */           if (this.field_150493_b.length() > 2) {
/* 342 */             String str = this.field_150493_b.substring(1, this.field_150493_b.length() - 1);
/* 343 */             String[] arrayOfString = str.split(",");
/*     */             try {
/* 345 */               if (arrayOfString.length <= 1) {
/* 346 */                 return new NBTTagIntArray(new int[] { Integer.parseInt(str.trim()) });
/*     */               }
/*     */ 
/*     */               
/* 350 */               int[] arrayOfInt = new int[arrayOfString.length];
/* 351 */               for (byte b = 0; b < arrayOfString.length; b++) {
/* 352 */                 arrayOfInt[b] = Integer.parseInt(arrayOfString[b].trim());
/*     */               }
/* 354 */               return new NBTTagIntArray(arrayOfInt);
/*     */             }
/* 356 */             catch (NumberFormatException numberFormatException) {
/* 357 */               return new NBTTagString(this.field_150493_b);
/*     */             } 
/*     */           } 
/* 360 */           return new NBTTagIntArray();
/*     */         } 
/*     */         
/* 363 */         if (this.field_150493_b.startsWith("\"") && this.field_150493_b.endsWith("\"") && this.field_150493_b.length() > 2) {
/* 364 */           this.field_150493_b = this.field_150493_b.substring(1, this.field_150493_b.length() - 1);
/*     */         }
/*     */         
/* 367 */         this.field_150493_b = this.field_150493_b.replaceAll("\\\\\"", "\"");
/* 368 */         return new NBTTagString(this.field_150493_b);
/*     */       }
/* 370 */       catch (NumberFormatException numberFormatException) {
/* 371 */         this.field_150493_b = this.field_150493_b.replaceAll("\\\\\"", "\"");
/* 372 */         return new NBTTagString(this.field_150493_b);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\nbt\JsonToNBT.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */