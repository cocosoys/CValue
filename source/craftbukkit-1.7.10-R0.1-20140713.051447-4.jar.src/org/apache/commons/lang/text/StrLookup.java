/*     */ package org.apache.commons.lang.text;
/*     */ 
/*     */ import java.util.Map;
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
/*     */ public abstract class StrLookup
/*     */ {
/*  49 */   private static final StrLookup NONE_LOOKUP = new MapStrLookup(null); static {
/*  50 */     StrLookup lookup = null;
/*     */     try {
/*  52 */       lookup = new MapStrLookup(System.getProperties());
/*     */     } catch (SecurityException ex) {
/*  54 */       lookup = NONE_LOOKUP;
/*     */     } 
/*  56 */     SYSTEM_PROPERTIES_LOOKUP = lookup;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final StrLookup SYSTEM_PROPERTIES_LOOKUP;
/*     */ 
/*     */ 
/*     */   
/*     */   public static StrLookup noneLookup() {
/*  66 */     return NONE_LOOKUP;
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
/*     */   public static StrLookup systemPropertiesLookup() {
/*  81 */     return SYSTEM_PROPERTIES_LOOKUP;
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
/*     */   public static StrLookup mapLookup(Map map) {
/*  94 */     return new MapStrLookup(map);
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
/*     */   public abstract String lookup(String paramString);
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
/*     */   static class MapStrLookup
/*     */     extends StrLookup
/*     */   {
/*     */     private final Map map;
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
/*     */     MapStrLookup(Map map) {
/* 138 */       this.map = map;
/*     */     }
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
/*     */     public String lookup(String key) {
/* 151 */       if (this.map == null) {
/* 152 */         return null;
/*     */       }
/* 154 */       Object obj = this.map.get(key);
/* 155 */       if (obj == null) {
/* 156 */         return null;
/*     */       }
/* 158 */       return obj.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\text\StrLookup.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */