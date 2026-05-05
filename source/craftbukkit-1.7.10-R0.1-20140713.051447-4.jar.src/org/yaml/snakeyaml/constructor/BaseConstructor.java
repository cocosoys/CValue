/*     */ package org.yaml.snakeyaml.constructor;
/*     */ 
/*     */ import java.lang.reflect.Array;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.EnumMap;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.yaml.snakeyaml.composer.Composer;
/*     */ import org.yaml.snakeyaml.error.YAMLException;
/*     */ import org.yaml.snakeyaml.introspector.PropertyUtils;
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
/*     */ 
/*     */ 
/*     */ public abstract class BaseConstructor
/*     */ {
/*  48 */   protected final Map<NodeId, Construct> yamlClassConstructors = new EnumMap<NodeId, Construct>(NodeId.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  57 */   protected final Map<Tag, Construct> yamlConstructors = new HashMap<Tag, Construct>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  62 */   protected final Map<String, Construct> yamlMultiConstructors = new HashMap<String, Construct>();
/*     */   
/*     */   private Composer composer;
/*     */   
/*     */   private final Map<Node, Object> constructedObjects;
/*     */   private final Set<Node> recursiveObjects;
/*     */   private final ArrayList<RecursiveTuple<Map<Object, Object>, RecursiveTuple<Object, Object>>> maps2fill;
/*     */   private final ArrayList<RecursiveTuple<Set<Object>, Object>> sets2fill;
/*     */   protected Tag rootTag;
/*     */   private PropertyUtils propertyUtils;
/*     */   private boolean explicitPropertyUtils;
/*     */   
/*     */   public BaseConstructor() {
/*  75 */     this.constructedObjects = new HashMap<Node, Object>();
/*  76 */     this.recursiveObjects = new HashSet<Node>();
/*  77 */     this.maps2fill = new ArrayList<RecursiveTuple<Map<Object, Object>, RecursiveTuple<Object, Object>>>();
/*  78 */     this.sets2fill = new ArrayList<RecursiveTuple<Set<Object>, Object>>();
/*  79 */     this.rootTag = null;
/*  80 */     this.explicitPropertyUtils = false;
/*     */   }
/*     */   
/*     */   public void setComposer(Composer composer) {
/*  84 */     this.composer = composer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean checkData() {
/*  94 */     return this.composer.checkNode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getData() {
/* 104 */     this.composer.checkNode();
/* 105 */     Node node = this.composer.getNode();
/* 106 */     if (this.rootTag != null) {
/* 107 */       node.setTag(this.rootTag);
/*     */     }
/* 109 */     return constructDocument(node);
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
/*     */   public Object getSingleData(Class<?> type) {
/* 121 */     Node node = this.composer.getSingleNode();
/* 122 */     if (node != null) {
/* 123 */       if (Object.class != type) {
/* 124 */         node.setTag(new Tag(type));
/* 125 */       } else if (this.rootTag != null) {
/* 126 */         node.setTag(this.rootTag);
/*     */       } 
/* 128 */       return constructDocument(node);
/*     */     } 
/* 130 */     return null;
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
/*     */   private Object constructDocument(Node node) {
/* 142 */     Object data = constructObject(node);
/* 143 */     fillRecursive();
/* 144 */     this.constructedObjects.clear();
/* 145 */     this.recursiveObjects.clear();
/* 146 */     return data;
/*     */   }
/*     */   
/*     */   private void fillRecursive() {
/* 150 */     if (!this.maps2fill.isEmpty()) {
/* 151 */       for (RecursiveTuple<Map<Object, Object>, RecursiveTuple<Object, Object>> entry : this.maps2fill) {
/* 152 */         RecursiveTuple<Object, Object> key_value = entry._2();
/* 153 */         ((Map)entry._1()).put(key_value._1(), key_value._2());
/*     */       } 
/* 155 */       this.maps2fill.clear();
/*     */     } 
/* 157 */     if (!this.sets2fill.isEmpty()) {
/* 158 */       for (RecursiveTuple<Set<Object>, Object> value : this.sets2fill) {
/* 159 */         ((Set)value._1()).add(value._2());
/*     */       }
/* 161 */       this.sets2fill.clear();
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
/*     */   protected Object constructObject(Node node) {
/* 174 */     if (this.constructedObjects.containsKey(node)) {
/* 175 */       return this.constructedObjects.get(node);
/*     */     }
/* 177 */     if (this.recursiveObjects.contains(node)) {
/* 178 */       throw new ConstructorException(null, null, "found unconstructable recursive node", node.getStartMark());
/*     */     }
/*     */     
/* 181 */     this.recursiveObjects.add(node);
/* 182 */     Construct constructor = getConstructor(node);
/* 183 */     Object data = constructor.construct(node);
/* 184 */     this.constructedObjects.put(node, data);
/* 185 */     this.recursiveObjects.remove(node);
/* 186 */     if (node.isTwoStepsConstruction()) {
/* 187 */       constructor.construct2ndStep(node, data);
/*     */     }
/* 189 */     return data;
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
/*     */   protected Construct getConstructor(Node node) {
/* 202 */     if (node.useClassConstructor()) {
/* 203 */       return this.yamlClassConstructors.get(node.getNodeId());
/*     */     }
/* 205 */     Construct constructor = this.yamlConstructors.get(node.getTag());
/* 206 */     if (constructor == null) {
/* 207 */       for (String prefix : this.yamlMultiConstructors.keySet()) {
/* 208 */         if (node.getTag().startsWith(prefix)) {
/* 209 */           return this.yamlMultiConstructors.get(prefix);
/*     */         }
/*     */       } 
/* 212 */       return this.yamlConstructors.get(null);
/*     */     } 
/* 214 */     return constructor;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Object constructScalar(ScalarNode node) {
/* 219 */     return node.getValue();
/*     */   }
/*     */   
/*     */   protected List<Object> createDefaultList(int initSize) {
/* 223 */     return new ArrayList(initSize);
/*     */   }
/*     */   
/*     */   protected Set<Object> createDefaultSet(int initSize) {
/* 227 */     return new LinkedHashSet(initSize);
/*     */   }
/*     */ 
/*     */   
/*     */   protected <T> T[] createArray(Class<T> type, int size) {
/* 232 */     return (T[])Array.newInstance(type.getComponentType(), size);
/*     */   }
/*     */ 
/*     */   
/*     */   protected List<? extends Object> constructSequence(SequenceNode node) {
/*     */     List<Object> list;
/* 238 */     if (List.class.isAssignableFrom(node.getType()) && !node.getType().isInterface()) {
/*     */       
/*     */       try {
/* 241 */         list = node.getType().newInstance();
/* 242 */       } catch (Exception e) {
/* 243 */         throw new YAMLException(e);
/*     */       } 
/*     */     } else {
/* 246 */       list = createDefaultList(node.getValue().size());
/*     */     } 
/* 248 */     constructSequenceStep2(node, list);
/* 249 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Set<? extends Object> constructSet(SequenceNode node) {
/*     */     Set<Object> set;
/* 256 */     if (!node.getType().isInterface()) {
/*     */       
/*     */       try {
/* 259 */         set = node.getType().newInstance();
/* 260 */       } catch (Exception e) {
/* 261 */         throw new YAMLException(e);
/*     */       } 
/*     */     } else {
/* 264 */       set = createDefaultSet(node.getValue().size());
/*     */     } 
/* 266 */     constructSequenceStep2(node, set);
/* 267 */     return set;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Object constructArray(SequenceNode node) {
/* 272 */     return constructArrayStep2(node, createArray(node.getType(), node.getValue().size()));
/*     */   }
/*     */   
/*     */   protected void constructSequenceStep2(SequenceNode node, Collection<Object> collection) {
/* 276 */     for (Node child : node.getValue()) {
/* 277 */       collection.add(constructObject(child));
/*     */     }
/*     */   }
/*     */   
/*     */   protected Object constructArrayStep2(SequenceNode node, Object array) {
/* 282 */     int index = 0;
/* 283 */     for (Node child : node.getValue()) {
/* 284 */       Array.set(array, index++, constructObject(child));
/*     */     }
/* 286 */     return array;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Map<Object, Object> createDefaultMap() {
/* 291 */     return new LinkedHashMap<Object, Object>();
/*     */   }
/*     */ 
/*     */   
/*     */   protected Set<Object> createDefaultSet() {
/* 296 */     return new LinkedHashSet();
/*     */   }
/*     */   
/*     */   protected Set<Object> constructSet(MappingNode node) {
/* 300 */     Set<Object> set = createDefaultSet();
/* 301 */     constructSet2ndStep(node, set);
/* 302 */     return set;
/*     */   }
/*     */   
/*     */   protected Map<Object, Object> constructMapping(MappingNode node) {
/* 306 */     Map<Object, Object> mapping = createDefaultMap();
/* 307 */     constructMapping2ndStep(node, mapping);
/* 308 */     return mapping;
/*     */   }
/*     */   
/*     */   protected void constructMapping2ndStep(MappingNode node, Map<Object, Object> mapping) {
/* 312 */     List<NodeTuple> nodeValue = node.getValue();
/* 313 */     for (NodeTuple tuple : nodeValue) {
/* 314 */       Node keyNode = tuple.getKeyNode();
/* 315 */       Node valueNode = tuple.getValueNode();
/* 316 */       Object key = constructObject(keyNode);
/* 317 */       if (key != null) {
/*     */         try {
/* 319 */           key.hashCode();
/* 320 */         } catch (Exception e) {
/* 321 */           throw new ConstructorException("while constructing a mapping", node.getStartMark(), "found unacceptable key " + key, tuple.getKeyNode().getStartMark(), e);
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/* 326 */       Object value = constructObject(valueNode);
/* 327 */       if (keyNode.isTwoStepsConstruction()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 334 */         this.maps2fill.add(0, new RecursiveTuple<Map<Object, Object>, RecursiveTuple<Object, Object>>(mapping, new RecursiveTuple<Object, Object>(key, value)));
/*     */         
/*     */         continue;
/*     */       } 
/* 338 */       mapping.put(key, value);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void constructSet2ndStep(MappingNode node, Set<Object> set) {
/* 344 */     List<NodeTuple> nodeValue = node.getValue();
/* 345 */     for (NodeTuple tuple : nodeValue) {
/* 346 */       Node keyNode = tuple.getKeyNode();
/* 347 */       Object key = constructObject(keyNode);
/* 348 */       if (key != null) {
/*     */         try {
/* 350 */           key.hashCode();
/* 351 */         } catch (Exception e) {
/* 352 */           throw new ConstructorException("while constructing a Set", node.getStartMark(), "found unacceptable key " + key, tuple.getKeyNode().getStartMark(), e);
/*     */         } 
/*     */       }
/*     */       
/* 356 */       if (keyNode.isTwoStepsConstruction()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 363 */         this.sets2fill.add(0, new RecursiveTuple<Set<Object>, Object>(set, key)); continue;
/*     */       } 
/* 365 */       set.add(key);
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
/*     */   public void setPropertyUtils(PropertyUtils propertyUtils) {
/* 383 */     this.propertyUtils = propertyUtils;
/* 384 */     this.explicitPropertyUtils = true;
/*     */   }
/*     */   
/*     */   public final PropertyUtils getPropertyUtils() {
/* 388 */     if (this.propertyUtils == null) {
/* 389 */       this.propertyUtils = new PropertyUtils();
/*     */     }
/* 391 */     return this.propertyUtils;
/*     */   }
/*     */   
/*     */   private static class RecursiveTuple<T, K> {
/*     */     private final T _1;
/*     */     private final K _2;
/*     */     
/*     */     public RecursiveTuple(T _1, K _2) {
/* 399 */       this._1 = _1;
/* 400 */       this._2 = _2;
/*     */     }
/*     */     
/*     */     public K _2() {
/* 404 */       return this._2;
/*     */     }
/*     */     
/*     */     public T _1() {
/* 408 */       return this._1;
/*     */     }
/*     */   }
/*     */   
/*     */   public final boolean isExplicitPropertyUtils() {
/* 413 */     return this.explicitPropertyUtils;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\constructor\BaseConstructor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */