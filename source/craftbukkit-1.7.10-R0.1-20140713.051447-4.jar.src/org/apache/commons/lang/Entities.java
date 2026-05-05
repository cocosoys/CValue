/*     */ package org.apache.commons.lang;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.StringWriter;
/*     */ import java.io.Writer;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Entities
/*     */ {
/*  45 */   private static final String[][] BASIC_ARRAY = new String[][] { { "quot", "34" }, { "amp", "38" }, { "lt", "60" }, { "gt", "62" } };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  51 */   private static final String[][] APOS_ARRAY = new String[][] { { "apos", "39" } };
/*     */ 
/*     */ 
/*     */   
/*  55 */   static final String[][] ISO8859_1_ARRAY = new String[][] { { "nbsp", "160" }, { "iexcl", "161" }, { "cent", "162" }, { "pound", "163" }, { "curren", "164" }, { "yen", "165" }, { "brvbar", "166" }, { "sect", "167" }, { "uml", "168" }, { "copy", "169" }, { "ordf", "170" }, { "laquo", "171" }, { "not", "172" }, { "shy", "173" }, { "reg", "174" }, { "macr", "175" }, { "deg", "176" }, { "plusmn", "177" }, { "sup2", "178" }, { "sup3", "179" }, { "acute", "180" }, { "micro", "181" }, { "para", "182" }, { "middot", "183" }, { "cedil", "184" }, { "sup1", "185" }, { "ordm", "186" }, { "raquo", "187" }, { "frac14", "188" }, { "frac12", "189" }, { "frac34", "190" }, { "iquest", "191" }, { "Agrave", "192" }, { "Aacute", "193" }, { "Acirc", "194" }, { "Atilde", "195" }, { "Auml", "196" }, { "Aring", "197" }, { "AElig", "198" }, { "Ccedil", "199" }, { "Egrave", "200" }, { "Eacute", "201" }, { "Ecirc", "202" }, { "Euml", "203" }, { "Igrave", "204" }, { "Iacute", "205" }, { "Icirc", "206" }, { "Iuml", "207" }, { "ETH", "208" }, { "Ntilde", "209" }, { "Ograve", "210" }, { "Oacute", "211" }, { "Ocirc", "212" }, { "Otilde", "213" }, { "Ouml", "214" }, { "times", "215" }, { "Oslash", "216" }, { "Ugrave", "217" }, { "Uacute", "218" }, { "Ucirc", "219" }, { "Uuml", "220" }, { "Yacute", "221" }, { "THORN", "222" }, { "szlig", "223" }, { "agrave", "224" }, { "aacute", "225" }, { "acirc", "226" }, { "atilde", "227" }, { "auml", "228" }, { "aring", "229" }, { "aelig", "230" }, { "ccedil", "231" }, { "egrave", "232" }, { "eacute", "233" }, { "ecirc", "234" }, { "euml", "235" }, { "igrave", "236" }, { "iacute", "237" }, { "icirc", "238" }, { "iuml", "239" }, { "eth", "240" }, { "ntilde", "241" }, { "ograve", "242" }, { "oacute", "243" }, { "ocirc", "244" }, { "otilde", "245" }, { "ouml", "246" }, { "divide", "247" }, { "oslash", "248" }, { "ugrave", "249" }, { "uacute", "250" }, { "ucirc", "251" }, { "uuml", "252" }, { "yacute", "253" }, { "thorn", "254" }, { "yuml", "255" } };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 155 */   static final String[][] HTML40_ARRAY = new String[][] { { "fnof", "402" }, { "Alpha", "913" }, { "Beta", "914" }, { "Gamma", "915" }, { "Delta", "916" }, { "Epsilon", "917" }, { "Zeta", "918" }, { "Eta", "919" }, { "Theta", "920" }, { "Iota", "921" }, { "Kappa", "922" }, { "Lambda", "923" }, { "Mu", "924" }, { "Nu", "925" }, { "Xi", "926" }, { "Omicron", "927" }, { "Pi", "928" }, { "Rho", "929" }, { "Sigma", "931" }, { "Tau", "932" }, { "Upsilon", "933" }, { "Phi", "934" }, { "Chi", "935" }, { "Psi", "936" }, { "Omega", "937" }, { "alpha", "945" }, { "beta", "946" }, { "gamma", "947" }, { "delta", "948" }, { "epsilon", "949" }, { "zeta", "950" }, { "eta", "951" }, { "theta", "952" }, { "iota", "953" }, { "kappa", "954" }, { "lambda", "955" }, { "mu", "956" }, { "nu", "957" }, { "xi", "958" }, { "omicron", "959" }, { "pi", "960" }, { "rho", "961" }, { "sigmaf", "962" }, { "sigma", "963" }, { "tau", "964" }, { "upsilon", "965" }, { "phi", "966" }, { "chi", "967" }, { "psi", "968" }, { "omega", "969" }, { "thetasym", "977" }, { "upsih", "978" }, { "piv", "982" }, { "bull", "8226" }, { "hellip", "8230" }, { "prime", "8242" }, { "Prime", "8243" }, { "oline", "8254" }, { "frasl", "8260" }, { "weierp", "8472" }, { "image", "8465" }, { "real", "8476" }, { "trade", "8482" }, { "alefsym", "8501" }, { "larr", "8592" }, { "uarr", "8593" }, { "rarr", "8594" }, { "darr", "8595" }, { "harr", "8596" }, { "crarr", "8629" }, { "lArr", "8656" }, { "uArr", "8657" }, { "rArr", "8658" }, { "dArr", "8659" }, { "hArr", "8660" }, { "forall", "8704" }, { "part", "8706" }, { "exist", "8707" }, { "empty", "8709" }, { "nabla", "8711" }, { "isin", "8712" }, { "notin", "8713" }, { "ni", "8715" }, { "prod", "8719" }, { "sum", "8721" }, { "minus", "8722" }, { "lowast", "8727" }, { "radic", "8730" }, { "prop", "8733" }, { "infin", "8734" }, { "ang", "8736" }, { "and", "8743" }, { "or", "8744" }, { "cap", "8745" }, { "cup", "8746" }, { "int", "8747" }, { "there4", "8756" }, { "sim", "8764" }, { "cong", "8773" }, { "asymp", "8776" }, { "ne", "8800" }, { "equiv", "8801" }, { "le", "8804" }, { "ge", "8805" }, { "sub", "8834" }, { "sup", "8835" }, { "sube", "8838" }, { "supe", "8839" }, { "oplus", "8853" }, { "otimes", "8855" }, { "perp", "8869" }, { "sdot", "8901" }, { "lceil", "8968" }, { "rceil", "8969" }, { "lfloor", "8970" }, { "rfloor", "8971" }, { "lang", "9001" }, { "rang", "9002" }, { "loz", "9674" }, { "spades", "9824" }, { "clubs", "9827" }, { "hearts", "9829" }, { "diams", "9830" }, { "OElig", "338" }, { "oelig", "339" }, { "Scaron", "352" }, { "scaron", "353" }, { "Yuml", "376" }, { "circ", "710" }, { "tilde", "732" }, { "ensp", "8194" }, { "emsp", "8195" }, { "thinsp", "8201" }, { "zwnj", "8204" }, { "zwj", "8205" }, { "lrm", "8206" }, { "rlm", "8207" }, { "ndash", "8211" }, { "mdash", "8212" }, { "lsquo", "8216" }, { "rsquo", "8217" }, { "sbquo", "8218" }, { "ldquo", "8220" }, { "rdquo", "8221" }, { "bdquo", "8222" }, { "dagger", "8224" }, { "Dagger", "8225" }, { "permil", "8240" }, { "lsaquo", "8249" }, { "rsaquo", "8250" }, { "euro", "8364" } };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 374 */   public static final Entities XML = new Entities(); static {
/* 375 */     XML.addEntities(BASIC_ARRAY);
/* 376 */     XML.addEntities(APOS_ARRAY);
/*     */   }
/*     */ 
/*     */   
/* 380 */   public static final Entities HTML32 = new Entities(); static {
/* 381 */     HTML32.addEntities(BASIC_ARRAY);
/* 382 */     HTML32.addEntities(ISO8859_1_ARRAY);
/*     */   }
/*     */ 
/*     */   
/* 386 */   public static final Entities HTML40 = new Entities(); static {
/* 387 */     fillWithHtml40Entities(HTML40);
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
/*     */   static void fillWithHtml40Entities(Entities entities) {
/* 399 */     entities.addEntities(BASIC_ARRAY);
/* 400 */     entities.addEntities(ISO8859_1_ARRAY);
/* 401 */     entities.addEntities(HTML40_ARRAY);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static interface EntityMap
/*     */   {
/*     */     void add(String param1String, int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     String name(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int value(String param1String);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class PrimitiveEntityMap
/*     */     implements EntityMap
/*     */   {
/* 441 */     private Map mapNameToValue = new HashMap();
/*     */     
/* 443 */     private IntHashMap mapValueToName = new IntHashMap();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void add(String name, int value) {
/* 449 */       this.mapNameToValue.put(name, new Integer(value));
/* 450 */       this.mapValueToName.put(value, name);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String name(int value) {
/* 457 */       return (String)this.mapValueToName.get(value);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int value(String name) {
/* 464 */       Object value = this.mapNameToValue.get(name);
/* 465 */       if (value == null) {
/* 466 */         return -1;
/*     */       }
/* 468 */       return ((Integer)value).intValue();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static abstract class MapIntMap
/*     */     implements EntityMap
/*     */   {
/*     */     protected Map mapNameToValue;
/*     */     
/*     */     protected Map mapValueToName;
/*     */     
/*     */     public void add(String name, int value) {
/* 481 */       this.mapNameToValue.put(name, new Integer(value));
/* 482 */       this.mapValueToName.put(new Integer(value), name);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String name(int value) {
/* 489 */       return (String)this.mapValueToName.get(new Integer(value));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int value(String name) {
/* 496 */       Object value = this.mapNameToValue.get(name);
/* 497 */       if (value == null) {
/* 498 */         return -1;
/*     */       }
/* 500 */       return ((Integer)value).intValue();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class HashEntityMap
/*     */     extends MapIntMap
/*     */   {
/*     */     public HashEntityMap() {
/* 509 */       this.mapNameToValue = new HashMap();
/* 510 */       this.mapValueToName = new HashMap();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class TreeEntityMap
/*     */     extends MapIntMap
/*     */   {
/*     */     public TreeEntityMap() {
/* 519 */       this.mapNameToValue = new TreeMap();
/* 520 */       this.mapValueToName = new TreeMap();
/*     */     }
/*     */   }
/*     */   
/*     */   static class LookupEntityMap
/*     */     extends PrimitiveEntityMap {
/*     */     private String[] lookupTable;
/* 527 */     private int LOOKUP_TABLE_SIZE = 256;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String name(int value) {
/* 533 */       if (value < this.LOOKUP_TABLE_SIZE) {
/* 534 */         return lookupTable()[value];
/*     */       }
/* 536 */       return super.name(value);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private String[] lookupTable() {
/* 547 */       if (this.lookupTable == null) {
/* 548 */         createLookupTable();
/*     */       }
/* 550 */       return this.lookupTable;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void createLookupTable() {
/* 559 */       this.lookupTable = new String[this.LOOKUP_TABLE_SIZE];
/* 560 */       for (int i = 0; i < this.LOOKUP_TABLE_SIZE; i++)
/* 561 */         this.lookupTable[i] = super.name(i); 
/*     */     }
/*     */   }
/*     */   
/*     */   static class ArrayEntityMap
/*     */     implements EntityMap {
/* 567 */     protected int growBy = 100;
/*     */     
/* 569 */     protected int size = 0;
/*     */ 
/*     */     
/*     */     protected String[] names;
/*     */ 
/*     */     
/*     */     protected int[] values;
/*     */ 
/*     */     
/*     */     public ArrayEntityMap() {
/* 579 */       this.names = new String[this.growBy];
/* 580 */       this.values = new int[this.growBy];
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ArrayEntityMap(int growBy) {
/* 591 */       this.growBy = growBy;
/* 592 */       this.names = new String[growBy];
/* 593 */       this.values = new int[growBy];
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void add(String name, int value) {
/* 600 */       ensureCapacity(this.size + 1);
/* 601 */       this.names[this.size] = name;
/* 602 */       this.values[this.size] = value;
/* 603 */       this.size++;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void ensureCapacity(int capacity) {
/* 613 */       if (capacity > this.names.length) {
/* 614 */         int newSize = Math.max(capacity, this.size + this.growBy);
/* 615 */         String[] newNames = new String[newSize];
/* 616 */         System.arraycopy(this.names, 0, newNames, 0, this.size);
/* 617 */         this.names = newNames;
/* 618 */         int[] newValues = new int[newSize];
/* 619 */         System.arraycopy(this.values, 0, newValues, 0, this.size);
/* 620 */         this.values = newValues;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String name(int value) {
/* 628 */       for (int i = 0; i < this.size; i++) {
/* 629 */         if (this.values[i] == value) {
/* 630 */           return this.names[i];
/*     */         }
/*     */       } 
/* 633 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int value(String name) {
/* 640 */       for (int i = 0; i < this.size; i++) {
/* 641 */         if (this.names[i].equals(name)) {
/* 642 */           return this.values[i];
/*     */         }
/*     */       } 
/* 645 */       return -1;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class BinaryEntityMap
/*     */     extends ArrayEntityMap
/*     */   {
/*     */     public BinaryEntityMap() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public BinaryEntityMap(int growBy) {
/* 666 */       super(growBy);
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
/*     */     private int binarySearch(int key) {
/* 678 */       int low = 0;
/* 679 */       int high = this.size - 1;
/*     */       
/* 681 */       while (low <= high) {
/* 682 */         int mid = low + high >> 1;
/* 683 */         int midVal = this.values[mid];
/*     */         
/* 685 */         if (midVal < key) {
/* 686 */           low = mid + 1; continue;
/* 687 */         }  if (midVal > key) {
/* 688 */           high = mid - 1; continue;
/*     */         } 
/* 690 */         return mid;
/*     */       } 
/*     */       
/* 693 */       return -(low + 1);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void add(String name, int value) {
/* 700 */       ensureCapacity(this.size + 1);
/* 701 */       int insertAt = binarySearch(value);
/* 702 */       if (insertAt > 0) {
/*     */         return;
/*     */       }
/* 705 */       insertAt = -(insertAt + 1);
/* 706 */       System.arraycopy(this.values, insertAt, this.values, insertAt + 1, this.size - insertAt);
/* 707 */       this.values[insertAt] = value;
/* 708 */       System.arraycopy(this.names, insertAt, this.names, insertAt + 1, this.size - insertAt);
/* 709 */       this.names[insertAt] = name;
/* 710 */       this.size++;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String name(int value) {
/* 717 */       int index = binarySearch(value);
/* 718 */       if (index < 0) {
/* 719 */         return null;
/*     */       }
/* 721 */       return this.names[index];
/*     */     }
/*     */   }
/*     */ 
/*     */   
/* 726 */   EntityMap map = new LookupEntityMap();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addEntities(String[][] entityArray) {
/* 737 */     for (int i = 0; i < entityArray.length; i++) {
/* 738 */       addEntity(entityArray[i][0], Integer.parseInt(entityArray[i][1]));
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
/*     */ 
/*     */   
/*     */   public void addEntity(String name, int value) {
/* 753 */     this.map.add(name, value);
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
/*     */   public String entityName(int value) {
/* 766 */     return this.map.name(value);
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
/*     */   public int entityValue(String name) {
/* 779 */     return this.map.value(name);
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
/*     */   public String escape(String str) {
/* 797 */     StringWriter stringWriter = createStringWriter(str);
/*     */     try {
/* 799 */       escape(stringWriter, str);
/*     */     }
/*     */     catch (IOException e) {
/*     */       
/* 803 */       throw new UnhandledException(e);
/*     */     } 
/* 805 */     return stringWriter.toString();
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
/*     */   public void escape(Writer writer, String str) throws IOException {
/* 826 */     int len = str.length();
/* 827 */     for (int i = 0; i < len; i++) {
/* 828 */       char c = str.charAt(i);
/* 829 */       String entityName = entityName(c);
/* 830 */       if (entityName == null) {
/* 831 */         if (c > '') {
/* 832 */           writer.write("&#");
/* 833 */           writer.write(Integer.toString(c, 10));
/* 834 */           writer.write(59);
/*     */         } else {
/* 836 */           writer.write(c);
/*     */         } 
/*     */       } else {
/* 839 */         writer.write(38);
/* 840 */         writer.write(entityName);
/* 841 */         writer.write(59);
/*     */       } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String unescape(String str) {
/* 861 */     int firstAmp = str.indexOf('&');
/* 862 */     if (firstAmp < 0) {
/* 863 */       return str;
/*     */     }
/* 865 */     StringWriter stringWriter = createStringWriter(str);
/*     */     try {
/* 867 */       doUnescape(stringWriter, str, firstAmp);
/*     */     }
/*     */     catch (IOException e) {
/*     */       
/* 871 */       throw new UnhandledException(e);
/*     */     } 
/* 873 */     return stringWriter.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private StringWriter createStringWriter(String str) {
/* 884 */     return new StringWriter((int)(str.length() + str.length() * 0.1D));
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
/*     */   public void unescape(Writer writer, String str) throws IOException {
/* 905 */     int firstAmp = str.indexOf('&');
/* 906 */     if (firstAmp < 0) {
/* 907 */       writer.write(str);
/*     */       return;
/*     */     } 
/* 910 */     doUnescape(writer, str, firstAmp);
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
/*     */   private void doUnescape(Writer writer, String str, int firstAmp) throws IOException {
/* 928 */     writer.write(str, 0, firstAmp);
/* 929 */     int len = str.length();
/* 930 */     for (int i = firstAmp; i < len; i++) {
/* 931 */       char c = str.charAt(i);
/* 932 */       if (c == '&')
/* 933 */       { int nextIdx = i + 1;
/* 934 */         int semiColonIdx = str.indexOf(';', nextIdx);
/* 935 */         if (semiColonIdx == -1) {
/* 936 */           writer.write(c);
/*     */         } else {
/*     */           
/* 939 */           int amphersandIdx = str.indexOf('&', i + 1);
/* 940 */           if (amphersandIdx != -1 && amphersandIdx < semiColonIdx)
/*     */           
/* 942 */           { writer.write(c); }
/*     */           else
/*     */           
/* 945 */           { String entityContent = str.substring(nextIdx, semiColonIdx);
/* 946 */             int entityValue = -1;
/* 947 */             int entityContentLen = entityContent.length();
/* 948 */             if (entityContentLen > 0) {
/* 949 */               if (entityContent.charAt(0) == '#') {
/*     */                 
/* 951 */                 if (entityContentLen > 1) {
/* 952 */                   char isHexChar = entityContent.charAt(1);
/*     */                   try {
/* 954 */                     switch (isHexChar) {
/*     */                       case 'X':
/*     */                       case 'x':
/* 957 */                         entityValue = Integer.parseInt(entityContent.substring(2), 16);
/*     */                         break;
/*     */                       
/*     */                       default:
/* 961 */                         entityValue = Integer.parseInt(entityContent.substring(1), 10);
/*     */                         break;
/*     */                     } 
/* 964 */                     if (entityValue > 65535) {
/* 965 */                       entityValue = -1;
/*     */                     }
/*     */                   } catch (NumberFormatException e) {
/* 968 */                     entityValue = -1;
/*     */                   } 
/*     */                 } 
/*     */               } else {
/* 972 */                 entityValue = entityValue(entityContent);
/*     */               } 
/*     */             }
/*     */             
/* 976 */             if (entityValue == -1) {
/* 977 */               writer.write(38);
/* 978 */               writer.write(entityContent);
/* 979 */               writer.write(59);
/*     */             } else {
/* 981 */               writer.write(entityValue);
/*     */             } 
/* 983 */             i = semiColonIdx; } 
/*     */         }  }
/* 985 */       else { writer.write(c); }
/*     */     
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\Entities.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */