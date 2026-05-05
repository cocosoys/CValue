/*     */ package org.yaml.snakeyaml.extensions.compactnotation;
/*     */ 
/*     */ import java.beans.IntrospectionException;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.yaml.snakeyaml.constructor.AbstractConstruct;
/*     */ import org.yaml.snakeyaml.constructor.Construct;
/*     */ import org.yaml.snakeyaml.constructor.Constructor;
/*     */ import org.yaml.snakeyaml.error.YAMLException;
/*     */ import org.yaml.snakeyaml.introspector.Property;
/*     */ import org.yaml.snakeyaml.nodes.MappingNode;
/*     */ import org.yaml.snakeyaml.nodes.Node;
/*     */ import org.yaml.snakeyaml.nodes.NodeTuple;
/*     */ import org.yaml.snakeyaml.nodes.ScalarNode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CompactConstructor
/*     */   extends Constructor
/*     */ {
/*  42 */   private static final Pattern FIRST_PATTERN = Pattern.compile("(\\p{Alpha}.*)(\\s*)\\((.*?)\\)");
/*  43 */   private static final Pattern PROPERTY_NAME_PATTERN = Pattern.compile("\\s*(\\p{Alpha}\\w*)\\s*=(.+)");
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object constructScalar(ScalarNode node) {
/*  48 */     CompactData data = getCompactData(node.getValue());
/*  49 */     if (data != null) {
/*  50 */       return constructCompactFormat(node, data);
/*     */     }
/*  52 */     return super.constructScalar(node);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Object constructCompactFormat(ScalarNode node, CompactData data) {
/*     */     try {
/*  58 */       Object obj = createInstance(node, data);
/*  59 */       Map<String, Object> properties = new HashMap<String, Object>(data.getProperties());
/*  60 */       setProperties(obj, properties);
/*  61 */       return obj;
/*  62 */     } catch (Exception e) {
/*  63 */       throw new YAMLException(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected Object createInstance(ScalarNode node, CompactData data) throws Exception {
/*  68 */     Class<?> clazz = getClassForName(data.getPrefix());
/*  69 */     Class<?>[] args = new Class[data.getArguments().size()];
/*  70 */     for (int i = 0; i < args.length; i++)
/*     */     {
/*  72 */       args[i] = String.class;
/*     */     }
/*  74 */     Constructor<?> c = clazz.getDeclaredConstructor(args);
/*  75 */     c.setAccessible(true);
/*  76 */     return c.newInstance(data.getArguments().toArray());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void setProperties(Object bean, Map<String, Object> data) throws Exception {
/*  81 */     if (data == null) {
/*  82 */       throw new NullPointerException("Data for Compact Object Notation cannot be null.");
/*     */     }
/*  84 */     for (String key : data.keySet()) {
/*  85 */       Property property = getPropertyUtils().getProperty(bean.getClass(), key);
/*     */       try {
/*  87 */         property.set(bean, data.get(key));
/*  88 */       } catch (IllegalArgumentException e) {
/*  89 */         throw new YAMLException("Cannot set property='" + key + "' with value='" + data.get(key) + "' (" + data.get(key).getClass() + ") in " + bean);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public CompactData getCompactData(String scalar) {
/*  96 */     if (!scalar.endsWith(")")) {
/*  97 */       return null;
/*     */     }
/*  99 */     if (scalar.indexOf('(') < 0) {
/* 100 */       return null;
/*     */     }
/* 102 */     Matcher m = FIRST_PATTERN.matcher(scalar);
/* 103 */     if (m.matches()) {
/* 104 */       String tag = m.group(1).trim();
/* 105 */       String content = m.group(3);
/* 106 */       CompactData data = new CompactData(tag);
/* 107 */       if (content.length() == 0)
/* 108 */         return data; 
/* 109 */       String[] names = content.split("\\s*,\\s*");
/* 110 */       for (int i = 0; i < names.length; i++) {
/* 111 */         String section = names[i];
/* 112 */         if (section.indexOf('=') < 0) {
/* 113 */           data.getArguments().add(section);
/*     */         } else {
/* 115 */           Matcher sm = PROPERTY_NAME_PATTERN.matcher(section);
/* 116 */           if (sm.matches()) {
/* 117 */             String name = sm.group(1);
/* 118 */             String value = sm.group(2).trim();
/* 119 */             data.getProperties().put(name, value);
/*     */           } else {
/* 121 */             return null;
/*     */           } 
/*     */         } 
/*     */       } 
/* 125 */       return data;
/*     */     } 
/* 127 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Construct getConstructor(Node node) {
/* 132 */     if (node instanceof MappingNode) {
/* 133 */       MappingNode mnode = (MappingNode)node;
/* 134 */       List<NodeTuple> list = mnode.getValue();
/* 135 */       if (list.size() == 1) {
/* 136 */         NodeTuple tuple = list.get(0);
/* 137 */         Node key = tuple.getKeyNode();
/* 138 */         if (key instanceof ScalarNode) {
/* 139 */           ScalarNode scalar = (ScalarNode)key;
/* 140 */           CompactData data = getCompactData(scalar.getValue());
/* 141 */           if (data != null) {
/* 142 */             return (Construct)new ConstructCompactObject();
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 147 */     return super.getConstructor(node);
/*     */   }
/*     */   
/*     */   public class ConstructCompactObject
/*     */     extends AbstractConstruct {
/*     */     public Object construct(Node node) {
/* 153 */       Map<Object, Object> map = CompactConstructor.this.constructMapping((MappingNode)node);
/*     */       
/* 155 */       Map.Entry<Object, Object> entry = map.entrySet().iterator().next();
/* 156 */       Object result = entry.getKey();
/* 157 */       Object value = entry.getValue();
/* 158 */       if (value instanceof Map) {
/* 159 */         Map<String, Object> properties = (Map<String, Object>)value;
/*     */         try {
/* 161 */           CompactConstructor.this.setProperties(result, properties);
/* 162 */         } catch (Exception e) {
/* 163 */           throw new YAMLException(e);
/*     */         } 
/*     */       } else {
/*     */         
/* 167 */         CompactConstructor.this.applySequence(result, (List)value);
/*     */       } 
/* 169 */       return result;
/*     */     }
/*     */   }
/*     */   
/*     */   protected void applySequence(Object bean, List<?> value) {
/*     */     try {
/* 175 */       Property property = getPropertyUtils().getProperty(bean.getClass(), getSequencePropertyName(bean.getClass()));
/*     */       
/* 177 */       property.set(bean, value);
/* 178 */     } catch (Exception e) {
/* 179 */       throw new YAMLException(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getSequencePropertyName(Class<?> bean) throws IntrospectionException {
/* 190 */     Set<Property> properties = getPropertyUtils().getProperties(bean);
/* 191 */     for (Iterator<Property> iterator = properties.iterator(); iterator.hasNext(); ) {
/* 192 */       Property property = iterator.next();
/* 193 */       if (!List.class.isAssignableFrom(property.getType())) {
/* 194 */         iterator.remove();
/*     */       }
/*     */     } 
/* 197 */     if (properties.size() == 0)
/* 198 */       throw new YAMLException("No list property found in " + bean); 
/* 199 */     if (properties.size() > 1) {
/* 200 */       throw new YAMLException("Many list properties found in " + bean + "; Please override getSequencePropertyName() to specify which property to use.");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 205 */     return ((Property)properties.iterator().next()).getName();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\extensions\compactnotation\CompactConstructor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */