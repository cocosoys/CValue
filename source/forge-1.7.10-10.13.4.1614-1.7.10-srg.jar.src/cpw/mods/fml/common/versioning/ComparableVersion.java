/*     */ package cpw.mods.fml.common.versioning;
/*     */ 
/*     */ import java.math.BigInteger;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import java.util.Locale;
/*     */ import java.util.Properties;
/*     */ import java.util.Stack;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ComparableVersion
/*     */   implements Comparable<ComparableVersion>
/*     */ {
/*     */   private String value;
/*     */   private String canonical;
/*     */   private ListItem items;
/*     */   
/*     */   private static interface Item
/*     */   {
/*     */     public static final int INTEGER_ITEM = 0;
/*     */     public static final int STRING_ITEM = 1;
/*     */     public static final int LIST_ITEM = 2;
/*     */     
/*     */     int compareTo(Item param1Item);
/*     */     
/*     */     int getType();
/*     */     
/*     */     boolean isNull();
/*     */   }
/*     */   
/*     */   private static class IntegerItem
/*     */     implements Item
/*     */   {
/* 101 */     private static final BigInteger BigInteger_ZERO = new BigInteger("0");
/*     */     
/*     */     private final BigInteger value;
/*     */     
/* 105 */     public static final IntegerItem ZERO = new IntegerItem();
/*     */ 
/*     */     
/*     */     private IntegerItem() {
/* 109 */       this.value = BigInteger_ZERO;
/*     */     }
/*     */ 
/*     */     
/*     */     public IntegerItem(String str) {
/* 114 */       this.value = new BigInteger(str);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int getType() {
/* 120 */       return 0;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isNull() {
/* 126 */       return BigInteger_ZERO.equals(this.value);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int compareTo(ComparableVersion.Item item) {
/* 132 */       if (item == null)
/*     */       {
/* 134 */         return BigInteger_ZERO.equals(this.value) ? 0 : 1;
/*     */       }
/*     */       
/* 137 */       switch (item.getType()) {
/*     */         
/*     */         case 0:
/* 140 */           return this.value.compareTo(((IntegerItem)item).value);
/*     */         
/*     */         case 1:
/* 143 */           return 1;
/*     */         
/*     */         case 2:
/* 146 */           return 1;
/*     */       } 
/*     */       
/* 149 */       throw new RuntimeException("invalid item: " + item.getClass());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 156 */       return this.value.toString();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class StringItem
/*     */     implements Item
/*     */   {
/* 166 */     private static final String[] QUALIFIERS = new String[] { "alpha", "beta", "milestone", "rc", "snapshot", "", "sp" };
/*     */     
/* 168 */     private static final List<String> _QUALIFIERS = Arrays.asList(QUALIFIERS);
/*     */     
/* 170 */     private static final Properties ALIASES = new Properties();
/*     */     
/*     */     static {
/* 173 */       ALIASES.put("ga", "");
/* 174 */       ALIASES.put("final", "");
/* 175 */       ALIASES.put("cr", "rc");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 182 */     private static final String RELEASE_VERSION_INDEX = String.valueOf(_QUALIFIERS.indexOf(""));
/*     */     
/*     */     private String value;
/*     */ 
/*     */     
/*     */     public StringItem(String value, boolean followedByDigit) {
/* 188 */       if (followedByDigit && value.length() == 1)
/*     */       {
/*     */         
/* 191 */         switch (value.charAt(0)) {
/*     */           
/*     */           case 'a':
/* 194 */             value = "alpha";
/*     */             break;
/*     */           case 'b':
/* 197 */             value = "beta";
/*     */             break;
/*     */           case 'm':
/* 200 */             value = "milestone";
/*     */             break;
/*     */         } 
/*     */       }
/* 204 */       this.value = ALIASES.getProperty(value, value);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int getType() {
/* 210 */       return 1;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isNull() {
/* 216 */       return (comparableQualifier(this.value).compareTo(RELEASE_VERSION_INDEX) == 0);
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
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static String comparableQualifier(String qualifier) {
/* 233 */       int i = _QUALIFIERS.indexOf(qualifier);
/*     */       
/* 235 */       return (i == -1) ? (_QUALIFIERS.size() + "-" + qualifier) : String.valueOf(i);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int compareTo(ComparableVersion.Item item) {
/* 241 */       if (item == null)
/*     */       {
/*     */         
/* 244 */         return comparableQualifier(this.value).compareTo(RELEASE_VERSION_INDEX);
/*     */       }
/* 246 */       switch (item.getType()) {
/*     */         
/*     */         case 0:
/* 249 */           return -1;
/*     */         
/*     */         case 1:
/* 252 */           return comparableQualifier(this.value).compareTo(comparableQualifier(((StringItem)item).value));
/*     */         
/*     */         case 2:
/* 255 */           return -1;
/*     */       } 
/*     */       
/* 258 */       throw new RuntimeException("invalid item: " + item.getClass());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 265 */       return this.value;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class ListItem
/*     */     extends ArrayList<Item>
/*     */     implements Item
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */     
/*     */     private ListItem() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public int getType() {
/* 285 */       return 2;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isNull() {
/* 291 */       return (size() == 0);
/*     */     }
/*     */ 
/*     */     
/*     */     void normalize() {
/* 296 */       for (ListIterator<ComparableVersion.Item> iterator = listIterator(size()); iterator.hasPrevious(); ) {
/*     */         
/* 298 */         ComparableVersion.Item item = iterator.previous();
/* 299 */         if (item.isNull())
/*     */         {
/* 301 */           iterator.remove();
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int compareTo(ComparableVersion.Item item) {
/*     */       Iterator<ComparableVersion.Item> left;
/*     */       Iterator<ComparableVersion.Item> right;
/* 313 */       if (item == null) {
/*     */         
/* 315 */         if (size() == 0)
/*     */         {
/* 317 */           return 0;
/*     */         }
/* 319 */         ComparableVersion.Item first = get(0);
/* 320 */         return first.compareTo(null);
/*     */       } 
/* 322 */       switch (item.getType()) {
/*     */         
/*     */         case 0:
/* 325 */           return -1;
/*     */         
/*     */         case 1:
/* 328 */           return 1;
/*     */         
/*     */         case 2:
/* 331 */           left = iterator();
/* 332 */           right = ((ListItem)item).iterator();
/*     */           
/* 334 */           while (left.hasNext() || right.hasNext()) {
/*     */             
/* 336 */             ComparableVersion.Item l = left.hasNext() ? left.next() : null;
/* 337 */             ComparableVersion.Item r = right.hasNext() ? right.next() : null;
/*     */ 
/*     */             
/* 340 */             int result = (l == null) ? (-1 * r.compareTo(l)) : l.compareTo(r);
/*     */             
/* 342 */             if (result != 0)
/*     */             {
/* 344 */               return result;
/*     */             }
/*     */           } 
/*     */           
/* 348 */           return 0;
/*     */       } 
/*     */       
/* 351 */       throw new RuntimeException("invalid item: " + item.getClass());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 358 */       StringBuilder buffer = new StringBuilder("(");
/* 359 */       for (Iterator<ComparableVersion.Item> iter = iterator(); iter.hasNext(); ) {
/*     */         
/* 361 */         buffer.append(iter.next());
/* 362 */         if (iter.hasNext())
/*     */         {
/* 364 */           buffer.append(',');
/*     */         }
/*     */       } 
/* 367 */       buffer.append(')');
/* 368 */       return buffer.toString();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public ComparableVersion(String version) {
/* 374 */     parseVersion(version);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void parseVersion(String version) {
/* 379 */     this.value = version;
/*     */     
/* 381 */     this.items = new ListItem();
/*     */     
/* 383 */     version = version.toLowerCase(Locale.ENGLISH);
/*     */     
/* 385 */     ListItem list = this.items;
/*     */     
/* 387 */     Stack<Item> stack = new Stack<Item>();
/* 388 */     stack.push(list);
/*     */     
/* 390 */     boolean isDigit = false;
/*     */     
/* 392 */     int startIndex = 0;
/*     */     
/* 394 */     for (int i = 0; i < version.length(); i++) {
/*     */       
/* 396 */       char c = version.charAt(i);
/*     */       
/* 398 */       if (c == '.') {
/*     */         
/* 400 */         if (i == startIndex) {
/*     */           
/* 402 */           list.add(IntegerItem.ZERO);
/*     */         }
/*     */         else {
/*     */           
/* 406 */           list.add(parseItem(isDigit, version.substring(startIndex, i)));
/*     */         } 
/* 408 */         startIndex = i + 1;
/*     */       }
/* 410 */       else if (c == '-') {
/*     */         
/* 412 */         if (i == startIndex) {
/*     */           
/* 414 */           list.add(IntegerItem.ZERO);
/*     */         }
/*     */         else {
/*     */           
/* 418 */           list.add(parseItem(isDigit, version.substring(startIndex, i)));
/*     */         } 
/* 420 */         startIndex = i + 1;
/*     */         
/* 422 */         if (isDigit) {
/*     */           
/* 424 */           list.normalize();
/*     */           
/* 426 */           if (i + 1 < version.length() && Character.isDigit(version.charAt(i + 1)))
/*     */           {
/*     */ 
/*     */             
/* 430 */             list.add(list = new ListItem());
/*     */             
/* 432 */             stack.push(list);
/*     */           }
/*     */         
/*     */         } 
/* 436 */       } else if (Character.isDigit(c)) {
/*     */         
/* 438 */         if (!isDigit && i > startIndex) {
/*     */           
/* 440 */           list.add(new StringItem(version.substring(startIndex, i), true));
/* 441 */           startIndex = i;
/*     */         } 
/*     */         
/* 444 */         isDigit = true;
/*     */       }
/*     */       else {
/*     */         
/* 448 */         if (isDigit && i > startIndex) {
/*     */           
/* 450 */           list.add(parseItem(true, version.substring(startIndex, i)));
/* 451 */           startIndex = i;
/*     */         } 
/*     */         
/* 454 */         isDigit = false;
/*     */       } 
/*     */     } 
/*     */     
/* 458 */     if (version.length() > startIndex)
/*     */     {
/* 460 */       list.add(parseItem(isDigit, version.substring(startIndex)));
/*     */     }
/*     */     
/* 463 */     while (!stack.isEmpty()) {
/*     */       
/* 465 */       list = (ListItem)stack.pop();
/* 466 */       list.normalize();
/*     */     } 
/*     */     
/* 469 */     this.canonical = this.items.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   private static Item parseItem(boolean isDigit, String buf) {
/* 474 */     return isDigit ? new IntegerItem(buf) : new StringItem(buf, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(ComparableVersion o) {
/* 480 */     return this.items.compareTo(o.items);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 486 */     return this.value;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 492 */     return (o instanceof ComparableVersion && this.canonical.equals(((ComparableVersion)o).canonical));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 498 */     return this.canonical.hashCode();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\versioning\ComparableVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */