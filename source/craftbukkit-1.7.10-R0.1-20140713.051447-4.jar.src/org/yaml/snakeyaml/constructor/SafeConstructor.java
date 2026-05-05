/*     */ package org.yaml.snakeyaml.constructor;
/*     */ 
/*     */ import java.math.BigInteger;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.TimeZone;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.yaml.snakeyaml.error.YAMLException;
/*     */ import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;
/*     */ import org.yaml.snakeyaml.nodes.MappingNode;
/*     */ import org.yaml.snakeyaml.nodes.Node;
/*     */ import org.yaml.snakeyaml.nodes.NodeId;
/*     */ import org.yaml.snakeyaml.nodes.NodeTuple;
/*     */ import org.yaml.snakeyaml.nodes.ScalarNode;
/*     */ import org.yaml.snakeyaml.nodes.SequenceNode;
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
/*     */ public class SafeConstructor
/*     */   extends BaseConstructor
/*     */ {
/*  47 */   public static ConstructUndefined undefinedConstructor = new ConstructUndefined();
/*     */   
/*     */   public SafeConstructor() {
/*  50 */     this.yamlConstructors.put(Tag.NULL, new ConstructYamlNull());
/*  51 */     this.yamlConstructors.put(Tag.BOOL, new ConstructYamlBool());
/*  52 */     this.yamlConstructors.put(Tag.INT, new ConstructYamlInt());
/*  53 */     this.yamlConstructors.put(Tag.FLOAT, new ConstructYamlFloat());
/*  54 */     this.yamlConstructors.put(Tag.BINARY, new ConstructYamlBinary());
/*  55 */     this.yamlConstructors.put(Tag.TIMESTAMP, new ConstructYamlTimestamp());
/*  56 */     this.yamlConstructors.put(Tag.OMAP, new ConstructYamlOmap());
/*  57 */     this.yamlConstructors.put(Tag.PAIRS, new ConstructYamlPairs());
/*  58 */     this.yamlConstructors.put(Tag.SET, new ConstructYamlSet());
/*  59 */     this.yamlConstructors.put(Tag.STR, new ConstructYamlStr());
/*  60 */     this.yamlConstructors.put(Tag.SEQ, new ConstructYamlSeq());
/*  61 */     this.yamlConstructors.put(Tag.MAP, new ConstructYamlMap());
/*  62 */     this.yamlConstructors.put(null, undefinedConstructor);
/*  63 */     this.yamlClassConstructors.put(NodeId.scalar, undefinedConstructor);
/*  64 */     this.yamlClassConstructors.put(NodeId.sequence, undefinedConstructor);
/*  65 */     this.yamlClassConstructors.put(NodeId.mapping, undefinedConstructor);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void flattenMapping(MappingNode node) {
/*  70 */     if (node.isMerged()) {
/*  71 */       node.setValue(mergeNode(node, true, new HashMap<Object, Integer>(), new ArrayList<NodeTuple>()));
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
/*     */ 
/*     */   
/*     */   private List<NodeTuple> mergeNode(MappingNode node, boolean isPreffered, Map<Object, Integer> key2index, List<NodeTuple> values) {
/*  92 */     List<NodeTuple> nodeValue = node.getValue();
/*  93 */     for (Iterator<NodeTuple> iter = nodeValue.iterator(); iter.hasNext(); ) {
/*  94 */       NodeTuple nodeTuple = iter.next();
/*  95 */       Node keyNode = nodeTuple.getKeyNode();
/*  96 */       Node valueNode = nodeTuple.getValueNode();
/*  97 */       if (keyNode.getTag().equals(Tag.MERGE)) {
/*  98 */         MappingNode mn; SequenceNode sn; List<Node> vals; iter.remove();
/*  99 */         switch (valueNode.getNodeId()) {
/*     */           case mapping:
/* 101 */             mn = (MappingNode)valueNode;
/* 102 */             mergeNode(mn, false, key2index, values);
/*     */             continue;
/*     */           case sequence:
/* 105 */             sn = (SequenceNode)valueNode;
/* 106 */             vals = sn.getValue();
/* 107 */             for (Node subnode : vals) {
/* 108 */               if (!(subnode instanceof MappingNode)) {
/* 109 */                 throw new ConstructorException("while constructing a mapping", node.getStartMark(), "expected a mapping for merging, but found " + subnode.getNodeId(), subnode.getStartMark());
/*     */               }
/*     */ 
/*     */ 
/*     */               
/* 114 */               MappingNode mnode = (MappingNode)subnode;
/* 115 */               mergeNode(mnode, false, key2index, values);
/*     */             } 
/*     */             continue;
/*     */         } 
/* 119 */         throw new ConstructorException("while constructing a mapping", node.getStartMark(), "expected a mapping or list of mappings for merging, but found " + valueNode.getNodeId(), valueNode.getStartMark());
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 126 */       Object key = constructObject(keyNode);
/* 127 */       if (!key2index.containsKey(key)) {
/* 128 */         values.add(nodeTuple);
/*     */         
/* 130 */         key2index.put(key, Integer.valueOf(values.size() - 1)); continue;
/* 131 */       }  if (isPreffered)
/*     */       {
/*     */         
/* 134 */         values.set(((Integer)key2index.get(key)).intValue(), nodeTuple);
/*     */       }
/*     */     } 
/*     */     
/* 138 */     return values;
/*     */   }
/*     */   
/*     */   protected void constructMapping2ndStep(MappingNode node, Map<Object, Object> mapping) {
/* 142 */     flattenMapping(node);
/* 143 */     super.constructMapping2ndStep(node, mapping);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void constructSet2ndStep(MappingNode node, Set<Object> set) {
/* 148 */     flattenMapping(node);
/* 149 */     super.constructSet2ndStep(node, set);
/*     */   }
/*     */   
/*     */   public class ConstructYamlNull extends AbstractConstruct {
/*     */     public Object construct(Node node) {
/* 154 */       SafeConstructor.this.constructScalar((ScalarNode)node);
/* 155 */       return null;
/*     */     }
/*     */   }
/*     */   
/* 159 */   private static final Map<String, Boolean> BOOL_VALUES = new HashMap<String, Boolean>();
/*     */   static {
/* 161 */     BOOL_VALUES.put("yes", Boolean.TRUE);
/* 162 */     BOOL_VALUES.put("no", Boolean.FALSE);
/* 163 */     BOOL_VALUES.put("true", Boolean.TRUE);
/* 164 */     BOOL_VALUES.put("false", Boolean.FALSE);
/* 165 */     BOOL_VALUES.put("on", Boolean.TRUE);
/* 166 */     BOOL_VALUES.put("off", Boolean.FALSE);
/*     */   }
/*     */   
/*     */   public class ConstructYamlBool extends AbstractConstruct {
/*     */     public Object construct(Node node) {
/* 171 */       String val = (String)SafeConstructor.this.constructScalar((ScalarNode)node);
/* 172 */       return SafeConstructor.BOOL_VALUES.get(val.toLowerCase());
/*     */     }
/*     */   }
/*     */   
/*     */   public class ConstructYamlInt extends AbstractConstruct {
/*     */     public Object construct(Node node) {
/* 178 */       String value = SafeConstructor.this.constructScalar((ScalarNode)node).toString().replaceAll("_", "");
/* 179 */       int sign = 1;
/* 180 */       char first = value.charAt(0);
/* 181 */       if (first == '-') {
/* 182 */         sign = -1;
/* 183 */         value = value.substring(1);
/* 184 */       } else if (first == '+') {
/* 185 */         value = value.substring(1);
/*     */       } 
/* 187 */       int base = 10;
/* 188 */       if ("0".equals(value))
/* 189 */         return new Integer(0); 
/* 190 */       if (value.startsWith("0b"))
/* 191 */       { value = value.substring(2);
/* 192 */         base = 2; }
/* 193 */       else if (value.startsWith("0x"))
/* 194 */       { value = value.substring(2);
/* 195 */         base = 16; }
/* 196 */       else if (value.startsWith("0"))
/* 197 */       { value = value.substring(1);
/* 198 */         base = 8; }
/* 199 */       else { if (value.indexOf(':') != -1) {
/* 200 */           String[] digits = value.split(":");
/* 201 */           int bes = 1;
/* 202 */           int val = 0;
/* 203 */           for (int i = 0, j = digits.length; i < j; i++) {
/* 204 */             val = (int)(val + Long.parseLong(digits[j - i - 1]) * bes);
/* 205 */             bes *= 60;
/*     */           } 
/* 207 */           return SafeConstructor.this.createNumber(sign, String.valueOf(val), 10);
/*     */         } 
/* 209 */         return SafeConstructor.this.createNumber(sign, value, 10); }
/*     */       
/* 211 */       return SafeConstructor.this.createNumber(sign, value, base);
/*     */     }
/*     */   }
/*     */   
/*     */   private Number createNumber(int sign, String number, int radix) {
/*     */     Number number1;
/* 217 */     if (sign < 0) {
/* 218 */       number = "-" + number;
/*     */     }
/*     */     try {
/* 221 */       number1 = Integer.valueOf(number, radix);
/* 222 */     } catch (NumberFormatException e) {
/*     */       try {
/* 224 */         number1 = Long.valueOf(number, radix);
/* 225 */       } catch (NumberFormatException e1) {
/* 226 */         number1 = new BigInteger(number, radix);
/*     */       } 
/*     */     } 
/* 229 */     return number1;
/*     */   }
/*     */   
/*     */   public class ConstructYamlFloat extends AbstractConstruct {
/*     */     public Object construct(Node node) {
/* 234 */       String value = SafeConstructor.this.constructScalar((ScalarNode)node).toString().replaceAll("_", "");
/* 235 */       int sign = 1;
/* 236 */       char first = value.charAt(0);
/* 237 */       if (first == '-') {
/* 238 */         sign = -1;
/* 239 */         value = value.substring(1);
/* 240 */       } else if (first == '+') {
/* 241 */         value = value.substring(1);
/*     */       } 
/* 243 */       String valLower = value.toLowerCase();
/* 244 */       if (".inf".equals(valLower))
/* 245 */         return new Double((sign == -1) ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY); 
/* 246 */       if (".nan".equals(valLower))
/* 247 */         return new Double(Double.NaN); 
/* 248 */       if (value.indexOf(':') != -1) {
/* 249 */         String[] digits = value.split(":");
/* 250 */         int bes = 1;
/* 251 */         double val = 0.0D;
/* 252 */         for (int i = 0, j = digits.length; i < j; i++) {
/* 253 */           val += Double.parseDouble(digits[j - i - 1]) * bes;
/* 254 */           bes *= 60;
/*     */         } 
/* 256 */         return new Double(sign * val);
/*     */       } 
/* 258 */       Double d = Double.valueOf(value);
/* 259 */       return new Double(d.doubleValue() * sign);
/*     */     }
/*     */   }
/*     */   
/*     */   public class ConstructYamlBinary
/*     */     extends AbstractConstruct {
/*     */     public Object construct(Node node) {
/* 266 */       byte[] decoded = Base64Coder.decode(SafeConstructor.this.constructScalar((ScalarNode)node).toString().toCharArray());
/*     */       
/* 268 */       return decoded;
/*     */     }
/*     */   }
/*     */   
/* 272 */   private static final Pattern TIMESTAMP_REGEXP = Pattern.compile("^([0-9][0-9][0-9][0-9])-([0-9][0-9]?)-([0-9][0-9]?)(?:(?:[Tt]|[ \t]+)([0-9][0-9]?):([0-9][0-9]):([0-9][0-9])(?:\\.([0-9]*))?(?:[ \t]*(?:Z|([-+][0-9][0-9]?)(?::([0-9][0-9])?)?))?)?$");
/*     */   
/* 274 */   private static final Pattern YMD_REGEXP = Pattern.compile("^([0-9][0-9][0-9][0-9])-([0-9][0-9]?)-([0-9][0-9]?)$");
/*     */   
/*     */   public class ConstructYamlTimestamp
/*     */     extends AbstractConstruct {
/*     */     private Calendar calendar;
/*     */     
/*     */     public Calendar getCalendar() {
/* 281 */       return this.calendar;
/*     */     }
/*     */     public Object construct(Node node) {
/*     */       TimeZone timeZone;
/* 285 */       ScalarNode scalar = (ScalarNode)node;
/* 286 */       String nodeValue = scalar.getValue();
/* 287 */       Matcher match = SafeConstructor.YMD_REGEXP.matcher(nodeValue);
/* 288 */       if (match.matches()) {
/* 289 */         String str1 = match.group(1);
/* 290 */         String str2 = match.group(2);
/* 291 */         String str3 = match.group(3);
/* 292 */         this.calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
/* 293 */         this.calendar.clear();
/* 294 */         this.calendar.set(1, Integer.parseInt(str1));
/*     */         
/* 296 */         this.calendar.set(2, Integer.parseInt(str2) - 1);
/* 297 */         this.calendar.set(5, Integer.parseInt(str3));
/* 298 */         return this.calendar.getTime();
/*     */       } 
/* 300 */       match = SafeConstructor.TIMESTAMP_REGEXP.matcher(nodeValue);
/* 301 */       if (!match.matches()) {
/* 302 */         throw new YAMLException("Unexpected timestamp: " + nodeValue);
/*     */       }
/* 304 */       String year_s = match.group(1);
/* 305 */       String month_s = match.group(2);
/* 306 */       String day_s = match.group(3);
/* 307 */       String hour_s = match.group(4);
/* 308 */       String min_s = match.group(5);
/*     */       
/* 310 */       String seconds = match.group(6);
/* 311 */       String millis = match.group(7);
/* 312 */       if (millis != null) {
/* 313 */         seconds = seconds + "." + millis;
/*     */       }
/* 315 */       double fractions = Double.parseDouble(seconds);
/* 316 */       int sec_s = (int)Math.round(Math.floor(fractions));
/* 317 */       int usec = (int)Math.round((fractions - sec_s) * 1000.0D);
/*     */       
/* 319 */       String timezoneh_s = match.group(8);
/* 320 */       String timezonem_s = match.group(9);
/*     */       
/* 322 */       if (timezoneh_s != null) {
/* 323 */         String time = (timezonem_s != null) ? (":" + timezonem_s) : "00";
/* 324 */         timeZone = TimeZone.getTimeZone("GMT" + timezoneh_s + time);
/*     */       } else {
/*     */         
/* 327 */         timeZone = TimeZone.getTimeZone("UTC");
/*     */       } 
/* 329 */       this.calendar = Calendar.getInstance(timeZone);
/* 330 */       this.calendar.set(1, Integer.parseInt(year_s));
/*     */       
/* 332 */       this.calendar.set(2, Integer.parseInt(month_s) - 1);
/* 333 */       this.calendar.set(5, Integer.parseInt(day_s));
/* 334 */       this.calendar.set(11, Integer.parseInt(hour_s));
/* 335 */       this.calendar.set(12, Integer.parseInt(min_s));
/* 336 */       this.calendar.set(13, sec_s);
/* 337 */       this.calendar.set(14, usec);
/* 338 */       return this.calendar.getTime();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public class ConstructYamlOmap
/*     */     extends AbstractConstruct
/*     */   {
/*     */     public Object construct(Node node) {
/* 347 */       Map<Object, Object> omap = new LinkedHashMap<Object, Object>();
/* 348 */       if (!(node instanceof SequenceNode)) {
/* 349 */         throw new ConstructorException("while constructing an ordered map", node.getStartMark(), "expected a sequence, but found " + node.getNodeId(), node.getStartMark());
/*     */       }
/*     */ 
/*     */       
/* 353 */       SequenceNode snode = (SequenceNode)node;
/* 354 */       for (Node subnode : snode.getValue()) {
/* 355 */         if (!(subnode instanceof MappingNode)) {
/* 356 */           throw new ConstructorException("while constructing an ordered map", node.getStartMark(), "expected a mapping of length 1, but found " + subnode.getNodeId(), subnode.getStartMark());
/*     */         }
/*     */ 
/*     */         
/* 360 */         MappingNode mnode = (MappingNode)subnode;
/* 361 */         if (mnode.getValue().size() != 1) {
/* 362 */           throw new ConstructorException("while constructing an ordered map", node.getStartMark(), "expected a single mapping item, but found " + mnode.getValue().size() + " items", mnode.getStartMark());
/*     */         }
/*     */ 
/*     */         
/* 366 */         Node keyNode = ((NodeTuple)mnode.getValue().get(0)).getKeyNode();
/* 367 */         Node valueNode = ((NodeTuple)mnode.getValue().get(0)).getValueNode();
/* 368 */         Object key = SafeConstructor.this.constructObject(keyNode);
/* 369 */         Object value = SafeConstructor.this.constructObject(valueNode);
/* 370 */         omap.put(key, value);
/*     */       } 
/* 372 */       return omap;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public class ConstructYamlPairs
/*     */     extends AbstractConstruct
/*     */   {
/*     */     public Object construct(Node node) {
/* 381 */       if (!(node instanceof SequenceNode)) {
/* 382 */         throw new ConstructorException("while constructing pairs", node.getStartMark(), "expected a sequence, but found " + node.getNodeId(), node.getStartMark());
/*     */       }
/*     */       
/* 385 */       SequenceNode snode = (SequenceNode)node;
/* 386 */       List<Object[]> pairs = new ArrayList(snode.getValue().size());
/* 387 */       for (Node subnode : snode.getValue()) {
/* 388 */         if (!(subnode instanceof MappingNode)) {
/* 389 */           throw new ConstructorException("while constructingpairs", node.getStartMark(), "expected a mapping of length 1, but found " + subnode.getNodeId(), subnode.getStartMark());
/*     */         }
/*     */ 
/*     */         
/* 393 */         MappingNode mnode = (MappingNode)subnode;
/* 394 */         if (mnode.getValue().size() != 1) {
/* 395 */           throw new ConstructorException("while constructing pairs", node.getStartMark(), "expected a single mapping item, but found " + mnode.getValue().size() + " items", mnode.getStartMark());
/*     */         }
/*     */ 
/*     */         
/* 399 */         Node keyNode = ((NodeTuple)mnode.getValue().get(0)).getKeyNode();
/* 400 */         Node valueNode = ((NodeTuple)mnode.getValue().get(0)).getValueNode();
/* 401 */         Object key = SafeConstructor.this.constructObject(keyNode);
/* 402 */         Object value = SafeConstructor.this.constructObject(valueNode);
/* 403 */         pairs.add(new Object[] { key, value });
/*     */       } 
/* 405 */       return pairs;
/*     */     }
/*     */   }
/*     */   
/*     */   public class ConstructYamlSet implements Construct {
/*     */     public Object construct(Node node) {
/* 411 */       if (node.isTwoStepsConstruction()) {
/* 412 */         return SafeConstructor.this.createDefaultSet();
/*     */       }
/* 414 */       return SafeConstructor.this.constructSet((MappingNode)node);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void construct2ndStep(Node node, Object object) {
/* 420 */       if (node.isTwoStepsConstruction()) {
/* 421 */         SafeConstructor.this.constructSet2ndStep((MappingNode)node, (Set<Object>)object);
/*     */       } else {
/* 423 */         throw new YAMLException("Unexpected recursive set structure. Node: " + node);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public class ConstructYamlStr extends AbstractConstruct {
/*     */     public Object construct(Node node) {
/* 430 */       return SafeConstructor.this.constructScalar((ScalarNode)node);
/*     */     }
/*     */   }
/*     */   
/*     */   public class ConstructYamlSeq implements Construct {
/*     */     public Object construct(Node node) {
/* 436 */       SequenceNode seqNode = (SequenceNode)node;
/* 437 */       if (node.isTwoStepsConstruction()) {
/* 438 */         return SafeConstructor.this.createDefaultList(seqNode.getValue().size());
/*     */       }
/* 440 */       return SafeConstructor.this.constructSequence(seqNode);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void construct2ndStep(Node node, Object data) {
/* 446 */       if (node.isTwoStepsConstruction()) {
/* 447 */         SafeConstructor.this.constructSequenceStep2((SequenceNode)node, (List)data);
/*     */       } else {
/* 449 */         throw new YAMLException("Unexpected recursive sequence structure. Node: " + node);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public class ConstructYamlMap implements Construct {
/*     */     public Object construct(Node node) {
/* 456 */       if (node.isTwoStepsConstruction()) {
/* 457 */         return SafeConstructor.this.createDefaultMap();
/*     */       }
/* 459 */       return SafeConstructor.this.constructMapping((MappingNode)node);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void construct2ndStep(Node node, Object object) {
/* 465 */       if (node.isTwoStepsConstruction()) {
/* 466 */         SafeConstructor.this.constructMapping2ndStep((MappingNode)node, (Map<Object, Object>)object);
/*     */       } else {
/* 468 */         throw new YAMLException("Unexpected recursive mapping structure. Node: " + node);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class ConstructUndefined extends AbstractConstruct {
/*     */     public Object construct(Node node) {
/* 475 */       throw new ConstructorException(null, null, "could not determine a constructor for the tag " + node.getTag(), node.getStartMark());
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\constructor\SafeConstructor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */