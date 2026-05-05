/*     */ package org.yaml.snakeyaml.nodes;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.math.BigInteger;
/*     */ import java.net.URI;
/*     */ import java.sql.Date;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.yaml.snakeyaml.error.YAMLException;
/*     */ import org.yaml.snakeyaml.util.UriEncoder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Tag
/*     */   implements Comparable<Tag>
/*     */ {
/*     */   public static final String PREFIX = "tag:yaml.org,2002:";
/*  34 */   public static final Tag YAML = new Tag("tag:yaml.org,2002:yaml");
/*  35 */   public static final Tag VALUE = new Tag("tag:yaml.org,2002:value");
/*  36 */   public static final Tag MERGE = new Tag("tag:yaml.org,2002:merge");
/*  37 */   public static final Tag SET = new Tag("tag:yaml.org,2002:set");
/*  38 */   public static final Tag PAIRS = new Tag("tag:yaml.org,2002:pairs");
/*  39 */   public static final Tag OMAP = new Tag("tag:yaml.org,2002:omap");
/*  40 */   public static final Tag BINARY = new Tag("tag:yaml.org,2002:binary");
/*  41 */   public static final Tag INT = new Tag("tag:yaml.org,2002:int");
/*  42 */   public static final Tag FLOAT = new Tag("tag:yaml.org,2002:float");
/*  43 */   public static final Tag TIMESTAMP = new Tag("tag:yaml.org,2002:timestamp");
/*  44 */   public static final Tag BOOL = new Tag("tag:yaml.org,2002:bool");
/*  45 */   public static final Tag NULL = new Tag("tag:yaml.org,2002:null");
/*  46 */   public static final Tag STR = new Tag("tag:yaml.org,2002:str");
/*  47 */   public static final Tag SEQ = new Tag("tag:yaml.org,2002:seq");
/*  48 */   public static final Tag MAP = new Tag("tag:yaml.org,2002:map");
/*     */ 
/*     */   
/*  51 */   public static final Map<Tag, Set<Class<?>>> COMPATIBILITY_MAP = new HashMap<Tag, Set<Class<?>>>(); static {
/*  52 */     Set<Class<?>> floatSet = new HashSet<Class<?>>();
/*  53 */     floatSet.add(Double.class);
/*  54 */     floatSet.add(Float.class);
/*  55 */     floatSet.add(BigDecimal.class);
/*  56 */     COMPATIBILITY_MAP.put(FLOAT, floatSet);
/*     */     
/*  58 */     Set<Class<?>> intSet = new HashSet<Class<?>>();
/*  59 */     intSet.add(Integer.class);
/*  60 */     intSet.add(Long.class);
/*  61 */     intSet.add(BigInteger.class);
/*  62 */     COMPATIBILITY_MAP.put(INT, intSet);
/*     */     
/*  64 */     Set<Class<?>> timestampSet = new HashSet<Class<?>>();
/*  65 */     timestampSet.add(Date.class);
/*  66 */     timestampSet.add(Date.class);
/*  67 */     timestampSet.add(Timestamp.class);
/*  68 */     COMPATIBILITY_MAP.put(TIMESTAMP, timestampSet);
/*     */   }
/*     */   
/*     */   private final String value;
/*     */   
/*     */   public Tag(String tag) {
/*  74 */     if (tag == null)
/*  75 */       throw new NullPointerException("Tag must be provided."); 
/*  76 */     if (tag.length() == 0)
/*  77 */       throw new IllegalArgumentException("Tag must not be empty."); 
/*  78 */     if (tag.trim().length() != tag.length()) {
/*  79 */       throw new IllegalArgumentException("Tag must not contain leading or trailing spaces.");
/*     */     }
/*  81 */     this.value = UriEncoder.encode(tag);
/*     */   }
/*     */   
/*     */   public Tag(Class<? extends Object> clazz) {
/*  85 */     if (clazz == null) {
/*  86 */       throw new NullPointerException("Class for tag must be provided.");
/*     */     }
/*  88 */     this.value = "tag:yaml.org,2002:" + UriEncoder.encode(clazz.getName());
/*     */   }
/*     */   
/*     */   public Tag(URI uri) {
/*  92 */     if (uri == null) {
/*  93 */       throw new NullPointerException("URI for tag must be provided.");
/*     */     }
/*  95 */     this.value = uri.toASCIIString();
/*     */   }
/*     */   
/*     */   public String getValue() {
/*  99 */     return this.value;
/*     */   }
/*     */   
/*     */   public boolean startsWith(String prefix) {
/* 103 */     return this.value.startsWith(prefix);
/*     */   }
/*     */   
/*     */   public String getClassName() {
/* 107 */     if (!this.value.startsWith("tag:yaml.org,2002:")) {
/* 108 */       throw new YAMLException("Invalid tag: " + this.value);
/*     */     }
/* 110 */     return UriEncoder.decode(this.value.substring("tag:yaml.org,2002:".length()));
/*     */   }
/*     */   
/*     */   public int getLength() {
/* 114 */     return this.value.length();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 119 */     return this.value;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/* 124 */     if (obj == null) {
/* 125 */       return false;
/*     */     }
/* 127 */     if (obj instanceof Tag)
/* 128 */       return this.value.equals(((Tag)obj).getValue()); 
/* 129 */     if (obj instanceof String && 
/* 130 */       this.value.equals(obj.toString())) {
/*     */       
/* 132 */       System.err.println("Comparing Tag and String is deprecated.");
/* 133 */       return true;
/*     */     } 
/*     */     
/* 136 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 141 */     return this.value.hashCode();
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
/*     */   public boolean isCompatible(Class<?> clazz) {
/* 154 */     Set<Class<?>> set = COMPATIBILITY_MAP.get(this);
/* 155 */     if (set != null) {
/* 156 */       return set.contains(clazz);
/*     */     }
/* 158 */     return false;
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
/*     */   public boolean matches(Class<? extends Object> clazz) {
/* 170 */     return this.value.equals("tag:yaml.org,2002:" + clazz.getName());
/*     */   }
/*     */   
/*     */   public int compareTo(Tag o) {
/* 174 */     return this.value.compareTo(o.getValue());
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\nodes\Tag.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */