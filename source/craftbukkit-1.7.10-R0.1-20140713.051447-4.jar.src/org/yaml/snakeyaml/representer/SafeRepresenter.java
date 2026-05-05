/*     */ package org.yaml.snakeyaml.representer;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.TimeZone;
/*     */ import java.util.regex.Pattern;
/*     */ import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;
/*     */ import org.yaml.snakeyaml.nodes.Node;
/*     */ import org.yaml.snakeyaml.nodes.Tag;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class SafeRepresenter
/*     */   extends BaseRepresenter
/*     */ {
/*     */   protected Map<Class<? extends Object>, Tag> classTags;
/*     */   
/*     */   public SafeRepresenter() {
/*  44 */     this.nullRepresenter = new RepresentNull();
/*  45 */     this.representers.put(String.class, new RepresentString());
/*  46 */     this.representers.put(Boolean.class, new RepresentBoolean());
/*  47 */     this.representers.put(Character.class, new RepresentString());
/*  48 */     this.representers.put(byte[].class, new RepresentByteArray());
/*  49 */     this.multiRepresenters.put(Number.class, new RepresentNumber());
/*  50 */     this.multiRepresenters.put(List.class, new RepresentList());
/*  51 */     this.multiRepresenters.put(Map.class, new RepresentMap());
/*  52 */     this.multiRepresenters.put(Set.class, new RepresentSet());
/*  53 */     this.multiRepresenters.put(Iterator.class, new RepresentIterator());
/*  54 */     this.multiRepresenters.put((new Object[0]).getClass(), new RepresentArray());
/*  55 */     this.multiRepresenters.put(Date.class, new RepresentDate());
/*  56 */     this.multiRepresenters.put(Enum.class, new RepresentEnum());
/*  57 */     this.multiRepresenters.put(Calendar.class, new RepresentDate());
/*  58 */     this.classTags = new HashMap<Class<? extends Object>, Tag>();
/*     */   }
/*     */   
/*     */   protected Tag getTag(Class<?> clazz, Tag defaultTag) {
/*  62 */     if (this.classTags.containsKey(clazz)) {
/*  63 */       return this.classTags.get(clazz);
/*     */     }
/*  65 */     return defaultTag;
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
/*     */   public Tag addClassTag(Class<? extends Object> clazz, String tag) {
/*  81 */     return addClassTag(clazz, new Tag(tag));
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
/*     */   public Tag addClassTag(Class<? extends Object> clazz, Tag tag) {
/*  95 */     if (tag == null) {
/*  96 */       throw new NullPointerException("Tag must be provided.");
/*     */     }
/*  98 */     return this.classTags.put(clazz, tag);
/*     */   }
/*     */   
/*     */   protected class RepresentNull implements Represent {
/*     */     public Node representData(Object data) {
/* 103 */       return SafeRepresenter.this.representScalar(Tag.NULL, "null");
/*     */     }
/*     */   }
/*     */   
/* 107 */   public static Pattern BINARY_PATTERN = Pattern.compile("[\\x00-\\x08\\x0B\\x0C\\x0E-\\x1F]");
/*     */   
/*     */   protected class RepresentString implements Represent {
/*     */     public Node representData(Object data) {
/* 111 */       Tag tag = Tag.STR;
/* 112 */       Character style = null;
/* 113 */       String value = data.toString();
/* 114 */       if (SafeRepresenter.BINARY_PATTERN.matcher(value).find()) {
/* 115 */         tag = Tag.BINARY;
/*     */         
/* 117 */         char[] binary = Base64Coder.encode(value.getBytes());
/* 118 */         value = String.valueOf(binary);
/* 119 */         style = Character.valueOf('|');
/*     */       } 
/* 121 */       return SafeRepresenter.this.representScalar(tag, value, style);
/*     */     }
/*     */   }
/*     */   
/*     */   protected class RepresentBoolean implements Represent {
/*     */     public Node representData(Object data) {
/*     */       String value;
/* 128 */       if (Boolean.TRUE.equals(data)) {
/* 129 */         value = "true";
/*     */       } else {
/* 131 */         value = "false";
/*     */       } 
/* 133 */       return SafeRepresenter.this.representScalar(Tag.BOOL, value);
/*     */     }
/*     */   }
/*     */   
/*     */   protected class RepresentNumber implements Represent {
/*     */     public Node representData(Object data) {
/*     */       Tag tag;
/*     */       String value;
/* 141 */       if (data instanceof Byte || data instanceof Short || data instanceof Integer || data instanceof Long || data instanceof java.math.BigInteger) {
/*     */         
/* 143 */         tag = Tag.INT;
/* 144 */         value = data.toString();
/*     */       } else {
/* 146 */         Number number = (Number)data;
/* 147 */         tag = Tag.FLOAT;
/* 148 */         if (number.equals(Double.valueOf(Double.NaN))) {
/* 149 */           value = ".NaN";
/* 150 */         } else if (number.equals(Double.valueOf(Double.POSITIVE_INFINITY))) {
/* 151 */           value = ".inf";
/* 152 */         } else if (number.equals(Double.valueOf(Double.NEGATIVE_INFINITY))) {
/* 153 */           value = "-.inf";
/*     */         } else {
/* 155 */           value = number.toString();
/*     */         } 
/*     */       } 
/* 158 */       return SafeRepresenter.this.representScalar(SafeRepresenter.this.getTag(data.getClass(), tag), value);
/*     */     }
/*     */   }
/*     */   
/*     */   protected class RepresentList
/*     */     implements Represent {
/*     */     public Node representData(Object data) {
/* 165 */       return SafeRepresenter.this.representSequence(SafeRepresenter.this.getTag(data.getClass(), Tag.SEQ), (List)data, null);
/*     */     }
/*     */   }
/*     */   
/*     */   protected class RepresentIterator
/*     */     implements Represent {
/*     */     public Node representData(Object data) {
/* 172 */       Iterator<Object> iter = (Iterator<Object>)data;
/* 173 */       return SafeRepresenter.this.representSequence(SafeRepresenter.this.getTag(data.getClass(), Tag.SEQ), new SafeRepresenter.IteratorWrapper(iter), null);
/*     */     }
/*     */   }
/*     */   
/*     */   private class IteratorWrapper
/*     */     implements Iterable<Object> {
/*     */     private Iterator<Object> iter;
/*     */     
/*     */     public IteratorWrapper(Iterator<Object> iter) {
/* 182 */       this.iter = iter;
/*     */     }
/*     */     
/*     */     public Iterator<Object> iterator() {
/* 186 */       return this.iter;
/*     */     }
/*     */   }
/*     */   
/*     */   protected class RepresentArray implements Represent {
/*     */     public Node representData(Object data) {
/* 192 */       Object[] array = (Object[])data;
/* 193 */       List<Object> list = Arrays.asList(array);
/* 194 */       return SafeRepresenter.this.representSequence(Tag.SEQ, list, null);
/*     */     }
/*     */   }
/*     */   
/*     */   protected class RepresentMap
/*     */     implements Represent {
/*     */     public Node representData(Object data) {
/* 201 */       return SafeRepresenter.this.representMapping(SafeRepresenter.this.getTag(data.getClass(), Tag.MAP), (Map<? extends Object, Object>)data, null);
/*     */     }
/*     */   }
/*     */   
/*     */   protected class RepresentSet
/*     */     implements Represent
/*     */   {
/*     */     public Node representData(Object data) {
/* 209 */       Map<Object, Object> value = new LinkedHashMap<Object, Object>();
/* 210 */       Set<Object> set = (Set<Object>)data;
/* 211 */       for (Object key : set) {
/* 212 */         value.put(key, null);
/*     */       }
/* 214 */       return SafeRepresenter.this.representMapping(SafeRepresenter.this.getTag(data.getClass(), Tag.SET), value, null);
/*     */     }
/*     */   }
/*     */   
/*     */   protected class RepresentDate
/*     */     implements Represent {
/*     */     public Node representData(Object data) {
/*     */       Calendar calendar;
/* 222 */       if (data instanceof Calendar) {
/* 223 */         calendar = (Calendar)data;
/*     */       } else {
/* 225 */         calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
/* 226 */         calendar.setTime((Date)data);
/*     */       } 
/* 228 */       int years = calendar.get(1);
/* 229 */       int months = calendar.get(2) + 1;
/* 230 */       int days = calendar.get(5);
/* 231 */       int hour24 = calendar.get(11);
/* 232 */       int minutes = calendar.get(12);
/* 233 */       int seconds = calendar.get(13);
/* 234 */       int millis = calendar.get(14);
/* 235 */       StringBuilder buffer = new StringBuilder(String.valueOf(years));
/* 236 */       while (buffer.length() < 4)
/*     */       {
/* 238 */         buffer.insert(0, "0");
/*     */       }
/* 240 */       buffer.append("-");
/* 241 */       if (months < 10) {
/* 242 */         buffer.append("0");
/*     */       }
/* 244 */       buffer.append(String.valueOf(months));
/* 245 */       buffer.append("-");
/* 246 */       if (days < 10) {
/* 247 */         buffer.append("0");
/*     */       }
/* 249 */       buffer.append(String.valueOf(days));
/* 250 */       buffer.append("T");
/* 251 */       if (hour24 < 10) {
/* 252 */         buffer.append("0");
/*     */       }
/* 254 */       buffer.append(String.valueOf(hour24));
/* 255 */       buffer.append(":");
/* 256 */       if (minutes < 10) {
/* 257 */         buffer.append("0");
/*     */       }
/* 259 */       buffer.append(String.valueOf(minutes));
/* 260 */       buffer.append(":");
/* 261 */       if (seconds < 10) {
/* 262 */         buffer.append("0");
/*     */       }
/* 264 */       buffer.append(String.valueOf(seconds));
/* 265 */       if (millis > 0) {
/* 266 */         if (millis < 10) {
/* 267 */           buffer.append(".00");
/* 268 */         } else if (millis < 100) {
/* 269 */           buffer.append(".0");
/*     */         } else {
/* 271 */           buffer.append(".");
/*     */         } 
/* 273 */         buffer.append(String.valueOf(millis));
/*     */       } 
/* 275 */       if (TimeZone.getTimeZone("UTC").equals(calendar.getTimeZone())) {
/* 276 */         buffer.append("Z");
/*     */       } else {
/*     */         
/* 279 */         int gmtOffset = calendar.getTimeZone().getOffset(calendar.get(0), calendar.get(1), calendar.get(2), calendar.get(5), calendar.get(7), calendar.get(14));
/*     */ 
/*     */ 
/*     */         
/* 283 */         int minutesOffset = gmtOffset / 60000;
/* 284 */         int hoursOffset = minutesOffset / 60;
/* 285 */         int partOfHour = minutesOffset % 60;
/* 286 */         buffer.append(((hoursOffset > 0) ? "+" : "") + hoursOffset + ":" + ((partOfHour < 10) ? ("0" + partOfHour) : (String)Integer.valueOf(partOfHour)));
/*     */       } 
/*     */       
/* 289 */       return SafeRepresenter.this.representScalar(SafeRepresenter.this.getTag(data.getClass(), Tag.TIMESTAMP), buffer.toString(), null);
/*     */     }
/*     */   }
/*     */   
/*     */   protected class RepresentEnum implements Represent {
/*     */     public Node representData(Object data) {
/* 295 */       Tag tag = new Tag(data.getClass());
/* 296 */       return SafeRepresenter.this.representScalar(SafeRepresenter.this.getTag(data.getClass(), tag), ((Enum)data).name());
/*     */     }
/*     */   }
/*     */   
/*     */   protected class RepresentByteArray implements Represent {
/*     */     public Node representData(Object data) {
/* 302 */       char[] binary = Base64Coder.encode((byte[])data);
/* 303 */       return SafeRepresenter.this.representScalar(Tag.BINARY, String.valueOf(binary), Character.valueOf('|'));
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\representer\SafeRepresenter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */