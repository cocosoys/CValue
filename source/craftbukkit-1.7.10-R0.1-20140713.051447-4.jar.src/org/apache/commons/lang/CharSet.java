/*     */ package org.apache.commons.lang;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
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
/*     */ public class CharSet
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 5947847346149275958L;
/*  51 */   public static final CharSet EMPTY = new CharSet((String)null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  57 */   public static final CharSet ASCII_ALPHA = new CharSet("a-zA-Z");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  63 */   public static final CharSet ASCII_ALPHA_LOWER = new CharSet("a-z");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  69 */   public static final CharSet ASCII_ALPHA_UPPER = new CharSet("A-Z");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  75 */   public static final CharSet ASCII_NUMERIC = new CharSet("0-9");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  82 */   protected static final Map COMMON = new HashMap();
/*     */   
/*     */   static {
/*  85 */     COMMON.put(null, EMPTY);
/*  86 */     COMMON.put("", EMPTY);
/*  87 */     COMMON.put("a-zA-Z", ASCII_ALPHA);
/*  88 */     COMMON.put("A-Za-z", ASCII_ALPHA);
/*  89 */     COMMON.put("a-z", ASCII_ALPHA_LOWER);
/*  90 */     COMMON.put("A-Z", ASCII_ALPHA_UPPER);
/*  91 */     COMMON.put("0-9", ASCII_NUMERIC);
/*     */   }
/*     */ 
/*     */   
/*  95 */   private Set set = new HashSet();
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
/*     */   public static CharSet getInstance(String setStr) {
/* 142 */     Object set = COMMON.get(setStr);
/* 143 */     if (set != null) {
/* 144 */       return (CharSet)set;
/*     */     }
/* 146 */     return new CharSet(setStr);
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
/*     */   protected CharSet(String setStr) {
/* 158 */     add(setStr);
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
/*     */   protected CharSet(String[] set) {
/* 170 */     int sz = set.length;
/* 171 */     for (int i = 0; i < sz; i++) {
/* 172 */       add(set[i]);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void add(String str) {
/* 183 */     if (str == null) {
/*     */       return;
/*     */     }
/*     */     
/* 187 */     int len = str.length();
/* 188 */     int pos = 0;
/* 189 */     while (pos < len) {
/* 190 */       int remainder = len - pos;
/* 191 */       if (remainder >= 4 && str.charAt(pos) == '^' && str.charAt(pos + 2) == '-') {
/*     */         
/* 193 */         this.set.add(new CharRange(str.charAt(pos + 1), str.charAt(pos + 3), true));
/* 194 */         pos += 4; continue;
/* 195 */       }  if (remainder >= 3 && str.charAt(pos + 1) == '-') {
/*     */         
/* 197 */         this.set.add(new CharRange(str.charAt(pos), str.charAt(pos + 2)));
/* 198 */         pos += 3; continue;
/* 199 */       }  if (remainder >= 2 && str.charAt(pos) == '^') {
/*     */         
/* 201 */         this.set.add(new CharRange(str.charAt(pos + 1), true));
/* 202 */         pos += 2;
/*     */         continue;
/*     */       } 
/* 205 */       this.set.add(new CharRange(str.charAt(pos)));
/* 206 */       pos++;
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
/*     */   
/*     */   public CharRange[] getCharRanges() {
/* 219 */     return (CharRange[])this.set.toArray((Object[])new CharRange[this.set.size()]);
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
/*     */   public boolean contains(char ch) {
/* 231 */     for (Iterator it = this.set.iterator(); it.hasNext(); ) {
/* 232 */       CharRange range = it.next();
/* 233 */       if (range.contains(ch)) {
/* 234 */         return true;
/*     */       }
/*     */     } 
/* 237 */     return false;
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
/*     */   public boolean equals(Object obj) {
/* 254 */     if (obj == this) {
/* 255 */       return true;
/*     */     }
/* 257 */     if (!(obj instanceof CharSet)) {
/* 258 */       return false;
/*     */     }
/* 260 */     CharSet other = (CharSet)obj;
/* 261 */     return this.set.equals(other.set);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 271 */     return 89 + this.set.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 280 */     return this.set.toString();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\CharSet.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */