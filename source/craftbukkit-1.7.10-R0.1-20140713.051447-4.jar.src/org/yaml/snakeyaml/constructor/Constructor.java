/*     */ package org.yaml.snakeyaml.constructor;
/*     */ 
/*     */ import java.beans.IntrospectionException;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.BigInteger;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import java.util.Set;
/*     */ import java.util.SortedMap;
/*     */ import java.util.SortedSet;
/*     */ import java.util.TreeMap;
/*     */ import java.util.TreeSet;
/*     */ import org.yaml.snakeyaml.TypeDescription;
/*     */ import org.yaml.snakeyaml.error.YAMLException;
/*     */ import org.yaml.snakeyaml.introspector.Property;
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
/*     */ public class Constructor
/*     */   extends SafeConstructor
/*     */ {
/*     */   private final Map<Tag, Class<? extends Object>> typeTags;
/*     */   private final Map<Class<? extends Object>, TypeDescription> typeDefinitions;
/*     */   
/*     */   public Constructor() {
/*  55 */     this(Object.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Constructor(Class<? extends Object> theRoot) {
/*  65 */     this(new TypeDescription(checkRoot(theRoot)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Class<? extends Object> checkRoot(Class<? extends Object> theRoot) {
/*  72 */     if (theRoot == null) {
/*  73 */       throw new NullPointerException("Root class must be provided.");
/*     */     }
/*  75 */     return theRoot;
/*     */   }
/*     */   
/*     */   public Constructor(TypeDescription theRoot) {
/*  79 */     if (theRoot == null) {
/*  80 */       throw new NullPointerException("Root type must be provided.");
/*     */     }
/*  82 */     this.yamlConstructors.put(null, new ConstructYamlObject());
/*  83 */     if (!Object.class.equals(theRoot.getType())) {
/*  84 */       this.rootTag = new Tag(theRoot.getType());
/*     */     }
/*  86 */     this.typeTags = new HashMap<Tag, Class<? extends Object>>();
/*  87 */     this.typeDefinitions = new HashMap<Class<? extends Object>, TypeDescription>();
/*  88 */     this.yamlClassConstructors.put(NodeId.scalar, new ConstructScalar());
/*  89 */     this.yamlClassConstructors.put(NodeId.mapping, new ConstructMapping());
/*  90 */     this.yamlClassConstructors.put(NodeId.sequence, new ConstructSequence());
/*  91 */     addTypeDescription(theRoot);
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
/*     */   public Constructor(String theRoot) throws ClassNotFoundException {
/* 104 */     this((Class)Class.forName(check(theRoot)));
/*     */   }
/*     */   
/*     */   private static final String check(String s) {
/* 108 */     if (s == null) {
/* 109 */       throw new NullPointerException("Root type must be provided.");
/*     */     }
/* 111 */     if (s.trim().length() == 0) {
/* 112 */       throw new YAMLException("Root type must be provided.");
/*     */     }
/* 114 */     return s;
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
/*     */   public TypeDescription addTypeDescription(TypeDescription definition) {
/* 128 */     if (definition == null) {
/* 129 */       throw new NullPointerException("TypeDescription is required.");
/*     */     }
/* 131 */     Tag tag = definition.getTag();
/* 132 */     this.typeTags.put(tag, definition.getType());
/* 133 */     return this.typeDefinitions.put(definition.getType(), definition);
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
/*     */   protected class ConstructMapping
/*     */     implements Construct
/*     */   {
/*     */     public Object construct(Node node) {
/* 152 */       MappingNode mnode = (MappingNode)node;
/* 153 */       if (Properties.class.isAssignableFrom(node.getType())) {
/* 154 */         Properties properties = new Properties();
/* 155 */         if (!node.isTwoStepsConstruction()) {
/* 156 */           Constructor.this.constructMapping2ndStep(mnode, properties);
/*     */         } else {
/* 158 */           throw new YAMLException("Properties must not be recursive.");
/*     */         } 
/* 160 */         return properties;
/* 161 */       }  if (SortedMap.class.isAssignableFrom(node.getType())) {
/* 162 */         SortedMap<Object, Object> map = new TreeMap<Object, Object>();
/* 163 */         if (!node.isTwoStepsConstruction()) {
/* 164 */           Constructor.this.constructMapping2ndStep(mnode, map);
/*     */         }
/* 166 */         return map;
/* 167 */       }  if (Map.class.isAssignableFrom(node.getType())) {
/* 168 */         if (node.isTwoStepsConstruction()) {
/* 169 */           return Constructor.this.createDefaultMap();
/*     */         }
/* 171 */         return Constructor.this.constructMapping(mnode);
/*     */       } 
/* 173 */       if (SortedSet.class.isAssignableFrom(node.getType())) {
/* 174 */         SortedSet<Object> set = new TreeSet();
/*     */ 
/*     */         
/* 177 */         Constructor.this.constructSet2ndStep(mnode, set);
/*     */         
/* 179 */         return set;
/* 180 */       }  if (Collection.class.isAssignableFrom(node.getType())) {
/* 181 */         if (node.isTwoStepsConstruction()) {
/* 182 */           return Constructor.this.createDefaultSet();
/*     */         }
/* 184 */         return Constructor.this.constructSet(mnode);
/*     */       } 
/*     */       
/* 187 */       if (node.isTwoStepsConstruction()) {
/* 188 */         return createEmptyJavaBean(mnode);
/*     */       }
/* 190 */       return constructJavaBean2ndStep(mnode, createEmptyJavaBean(mnode));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void construct2ndStep(Node node, Object object) {
/* 197 */       if (Map.class.isAssignableFrom(node.getType())) {
/* 198 */         Constructor.this.constructMapping2ndStep((MappingNode)node, (Map<Object, Object>)object);
/* 199 */       } else if (Set.class.isAssignableFrom(node.getType())) {
/* 200 */         Constructor.this.constructSet2ndStep((MappingNode)node, (Set<Object>)object);
/*     */       } else {
/* 202 */         constructJavaBean2ndStep((MappingNode)node, object);
/*     */       } 
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
/*     */     protected Object createEmptyJavaBean(MappingNode node) {
/*     */       try {
/* 216 */         Constructor<?> c = node.getType().getDeclaredConstructor(new Class[0]);
/* 217 */         c.setAccessible(true);
/* 218 */         return c.newInstance(new Object[0]);
/* 219 */       } catch (Exception e) {
/* 220 */         throw new YAMLException(e);
/*     */       } 
/*     */     }
/*     */     
/*     */     protected Object constructJavaBean2ndStep(MappingNode node, Object object) {
/* 225 */       Constructor.this.flattenMapping(node);
/* 226 */       Class<? extends Object> beanType = node.getType();
/* 227 */       List<NodeTuple> nodeValue = node.getValue();
/* 228 */       for (NodeTuple tuple : nodeValue) {
/*     */         ScalarNode keyNode;
/* 230 */         if (tuple.getKeyNode() instanceof ScalarNode) {
/*     */           
/* 232 */           keyNode = (ScalarNode)tuple.getKeyNode();
/*     */         } else {
/* 234 */           throw new YAMLException("Keys must be scalars but found: " + tuple.getKeyNode());
/*     */         } 
/* 236 */         Node valueNode = tuple.getValueNode();
/*     */         
/* 238 */         keyNode.setType(String.class);
/* 239 */         String key = (String)Constructor.this.constructObject((Node)keyNode);
/*     */         try {
/* 241 */           Property property = getProperty(beanType, key);
/* 242 */           valueNode.setType(property.getType());
/* 243 */           TypeDescription memberDescription = (TypeDescription)Constructor.this.typeDefinitions.get(beanType);
/* 244 */           boolean typeDetected = false;
/* 245 */           if (memberDescription != null) {
/* 246 */             SequenceNode snode; Class<? extends Object> memberType; MappingNode mnode; Class<? extends Object> keyType; switch (valueNode.getNodeId()) {
/*     */               case sequence:
/* 248 */                 snode = (SequenceNode)valueNode;
/* 249 */                 memberType = memberDescription.getListPropertyType(key);
/*     */                 
/* 251 */                 if (memberType != null) {
/* 252 */                   snode.setListType(memberType);
/* 253 */                   typeDetected = true; break;
/* 254 */                 }  if (property.getType().isArray()) {
/* 255 */                   snode.setListType(property.getType().getComponentType());
/* 256 */                   typeDetected = true;
/*     */                 } 
/*     */                 break;
/*     */               case mapping:
/* 260 */                 mnode = (MappingNode)valueNode;
/* 261 */                 keyType = memberDescription.getMapKeyType(key);
/* 262 */                 if (keyType != null) {
/* 263 */                   mnode.setTypes(keyType, memberDescription.getMapValueType(key));
/* 264 */                   typeDetected = true;
/*     */                 } 
/*     */                 break;
/*     */             } 
/*     */           } 
/* 269 */           if (!typeDetected && valueNode.getNodeId() != NodeId.scalar) {
/*     */             
/* 271 */             Class<?>[] arguments = property.getActualTypeArguments();
/* 272 */             if (arguments != null)
/*     */             {
/*     */               
/* 275 */               if (valueNode.getNodeId() == NodeId.sequence) {
/* 276 */                 Class<?> t = arguments[0];
/* 277 */                 SequenceNode snode = (SequenceNode)valueNode;
/* 278 */                 snode.setListType(t);
/* 279 */               } else if (valueNode.getTag().equals(Tag.SET)) {
/* 280 */                 Class<?> t = arguments[0];
/* 281 */                 MappingNode mnode = (MappingNode)valueNode;
/* 282 */                 mnode.setOnlyKeyType(t);
/* 283 */                 mnode.setUseClassConstructor(Boolean.valueOf(true));
/* 284 */               } else if (property.getType().isAssignableFrom(Map.class)) {
/* 285 */                 Class<?> ketType = arguments[0];
/* 286 */                 Class<?> valueType = arguments[1];
/* 287 */                 MappingNode mnode = (MappingNode)valueNode;
/* 288 */                 mnode.setTypes(ketType, valueType);
/* 289 */                 mnode.setUseClassConstructor(Boolean.valueOf(true));
/*     */               } 
/*     */             }
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 296 */           Object value = Constructor.this.constructObject(valueNode);
/* 297 */           property.set(object, value);
/* 298 */         } catch (Exception e) {
/* 299 */           throw new YAMLException("Cannot create property=" + key + " for JavaBean=" + object + "; " + e.getMessage(), e);
/*     */         } 
/*     */       } 
/*     */       
/* 303 */       return object;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Property getProperty(Class<? extends Object> type, String name) throws IntrospectionException {
/* 308 */       return Constructor.this.getPropertyUtils().getProperty(type, name);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected class ConstructYamlObject
/*     */     implements Construct
/*     */   {
/*     */     private Construct getConstructor(Node node) {
/* 321 */       Class<?> cl = Constructor.this.getClassForNode(node);
/* 322 */       node.setType(cl);
/*     */       
/* 324 */       Construct constructor = Constructor.this.yamlClassConstructors.get(node.getNodeId());
/* 325 */       return constructor;
/*     */     }
/*     */     
/*     */     public Object construct(Node node) {
/* 329 */       Object result = null;
/*     */       try {
/* 331 */         result = getConstructor(node).construct(node);
/* 332 */       } catch (Exception e) {
/* 333 */         throw new ConstructorException(null, null, "Can't construct a java object for " + node.getTag() + "; exception=" + e.getMessage(), node.getStartMark(), e);
/*     */       } 
/*     */       
/* 336 */       return result;
/*     */     }
/*     */     
/*     */     public void construct2ndStep(Node node, Object object) {
/*     */       try {
/* 341 */         getConstructor(node).construct2ndStep(node, object);
/* 342 */       } catch (Exception e) {
/* 343 */         throw new ConstructorException(null, null, "Can't construct a second step for a java object for " + node.getTag() + "; exception=" + e.getMessage(), node.getStartMark(), e);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected class ConstructScalar
/*     */     extends AbstractConstruct
/*     */   {
/*     */     public Object construct(Node nnode) {
/*     */       Object result;
/* 356 */       ScalarNode node = (ScalarNode)nnode;
/* 357 */       Class<?> type = node.getType();
/*     */       
/* 359 */       if (type.isPrimitive() || type == String.class || Number.class.isAssignableFrom(type) || type == Boolean.class || Date.class.isAssignableFrom(type) || type == Character.class || type == BigInteger.class || type == BigDecimal.class || Enum.class.isAssignableFrom(type) || Tag.BINARY.equals(node.getTag()) || Calendar.class.isAssignableFrom(type)) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 365 */         result = constructStandardJavaInstance(type, node);
/*     */       } else {
/*     */         Object argument;
/* 368 */         Constructor[] arrayOfConstructor = (Constructor[])type.getConstructors();
/* 369 */         int oneArgCount = 0;
/* 370 */         Constructor<?> javaConstructor = null;
/* 371 */         for (Constructor<?> c : arrayOfConstructor) {
/* 372 */           if ((c.getParameterTypes()).length == 1) {
/* 373 */             oneArgCount++;
/* 374 */             javaConstructor = c;
/*     */           } 
/*     */         } 
/*     */         
/* 378 */         if (javaConstructor == null)
/* 379 */           throw new YAMLException("No single argument constructor found for " + type); 
/* 380 */         if (oneArgCount == 1) {
/* 381 */           argument = constructStandardJavaInstance(javaConstructor.getParameterTypes()[0], node);
/*     */ 
/*     */ 
/*     */         
/*     */         }
/*     */         else {
/*     */ 
/*     */ 
/*     */           
/* 390 */           argument = Constructor.this.constructScalar(node);
/*     */           try {
/* 392 */             javaConstructor = type.getConstructor(new Class[] { String.class });
/* 393 */           } catch (Exception e) {
/* 394 */             throw new ConstructorException(null, null, "Can't construct a java object for scalar " + node.getTag() + "; No String constructor found. Exception=" + e.getMessage(), node.getStartMark(), e);
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/*     */         try {
/* 401 */           result = javaConstructor.newInstance(new Object[] { argument });
/* 402 */         } catch (Exception e) {
/* 403 */           throw new ConstructorException(null, null, "Can't construct a java object for scalar " + node.getTag() + "; exception=" + e.getMessage(), node.getStartMark(), e);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 408 */       return result;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private Object constructStandardJavaInstance(Class<String> type, ScalarNode node) {
/*     */       Object result;
/* 415 */       if (type == String.class) {
/* 416 */         Construct stringConstructor = Constructor.this.yamlConstructors.get(Tag.STR);
/* 417 */         result = stringConstructor.construct((Node)node);
/* 418 */       } else if (type == Boolean.class || type == boolean.class) {
/* 419 */         Construct boolConstructor = Constructor.this.yamlConstructors.get(Tag.BOOL);
/* 420 */         result = boolConstructor.construct((Node)node);
/* 421 */       } else if (type == Character.class || type == char.class) {
/* 422 */         Construct charConstructor = Constructor.this.yamlConstructors.get(Tag.STR);
/* 423 */         String ch = (String)charConstructor.construct((Node)node);
/* 424 */         if (ch.length() == 0)
/* 425 */         { result = null; }
/* 426 */         else { if (ch.length() != 1) {
/* 427 */             throw new YAMLException("Invalid node Character: '" + ch + "'; length: " + ch.length());
/*     */           }
/*     */           
/* 430 */           result = new Character(ch.charAt(0)); }
/*     */       
/* 432 */       } else if (Date.class.isAssignableFrom(type)) {
/* 433 */         Construct dateConstructor = Constructor.this.yamlConstructors.get(Tag.TIMESTAMP);
/* 434 */         Date date = (Date)dateConstructor.construct((Node)node);
/* 435 */         if (type == Date.class) {
/* 436 */           result = date;
/*     */         } else {
/*     */           try {
/* 439 */             Constructor<?> constr = type.getConstructor(new Class[] { long.class });
/* 440 */             result = constr.newInstance(new Object[] { Long.valueOf(date.getTime()) });
/* 441 */           } catch (Exception e) {
/* 442 */             throw new YAMLException("Cannot construct: '" + type + "'");
/*     */           } 
/*     */         } 
/* 445 */       } else if (type == Float.class || type == Double.class || type == float.class || type == double.class || type == BigDecimal.class) {
/*     */         
/* 447 */         if (type == BigDecimal.class) {
/* 448 */           result = new BigDecimal(node.getValue());
/*     */         } else {
/* 450 */           Construct doubleConstructor = Constructor.this.yamlConstructors.get(Tag.FLOAT);
/* 451 */           result = doubleConstructor.construct((Node)node);
/* 452 */           if (type == Float.class || type == float.class) {
/* 453 */             result = new Float(((Double)result).doubleValue());
/*     */           }
/*     */         } 
/* 456 */       } else if (type == Byte.class || type == Short.class || type == Integer.class || type == Long.class || type == BigInteger.class || type == byte.class || type == short.class || type == int.class || type == long.class) {
/*     */ 
/*     */         
/* 459 */         Construct intConstructor = Constructor.this.yamlConstructors.get(Tag.INT);
/* 460 */         result = intConstructor.construct((Node)node);
/* 461 */         if (type == Byte.class || type == byte.class) {
/* 462 */           result = new Byte(result.toString());
/* 463 */         } else if (type == Short.class || type == short.class) {
/* 464 */           result = new Short(result.toString());
/* 465 */         } else if (type == Integer.class || type == int.class) {
/* 466 */           result = new Integer(result.toString());
/* 467 */         } else if (type == Long.class || type == long.class) {
/* 468 */           result = new Long(result.toString());
/*     */         } else {
/*     */           
/* 471 */           result = new BigInteger(result.toString());
/*     */         } 
/* 473 */       } else if (Enum.class.isAssignableFrom(type)) {
/* 474 */         String enumValueName = node.getValue();
/*     */         try {
/* 476 */           result = Enum.valueOf(type, enumValueName);
/* 477 */         } catch (Exception ex) {
/* 478 */           throw new YAMLException("Unable to find enum value '" + enumValueName + "' for enum class: " + type.getName());
/*     */         }
/*     */       
/* 481 */       } else if (Calendar.class.isAssignableFrom(type)) {
/* 482 */         SafeConstructor.ConstructYamlTimestamp contr = new SafeConstructor.ConstructYamlTimestamp(Constructor.this);
/* 483 */         contr.construct((Node)node);
/* 484 */         result = contr.getCalendar();
/*     */       } else {
/* 486 */         throw new YAMLException("Unsupported class: " + type);
/*     */       } 
/* 488 */       return result;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected class ConstructSequence
/*     */     implements Construct
/*     */   {
/*     */     public Object construct(Node node) {
/* 499 */       SequenceNode snode = (SequenceNode)node;
/* 500 */       if (Set.class.isAssignableFrom(node.getType())) {
/* 501 */         if (node.isTwoStepsConstruction()) {
/* 502 */           throw new YAMLException("Set cannot be recursive.");
/*     */         }
/* 504 */         return Constructor.this.constructSet(snode);
/*     */       } 
/* 506 */       if (Collection.class.isAssignableFrom(node.getType())) {
/* 507 */         if (node.isTwoStepsConstruction()) {
/* 508 */           return Constructor.this.createDefaultList(snode.getValue().size());
/*     */         }
/* 510 */         return Constructor.this.constructSequence(snode);
/*     */       } 
/* 512 */       if (node.getType().isArray()) {
/* 513 */         if (node.isTwoStepsConstruction()) {
/* 514 */           return Constructor.this.createArray(node.getType(), snode.getValue().size());
/*     */         }
/* 516 */         return Constructor.this.constructArray(snode);
/*     */       } 
/*     */ 
/*     */       
/* 520 */       List<Constructor<?>> possibleConstructors = new ArrayList<Constructor<?>>(snode.getValue().size());
/*     */ 
/*     */       
/* 523 */       for (Constructor<?> constructor : node.getType().getConstructors()) {
/* 524 */         if (snode.getValue().size() == (constructor.getParameterTypes()).length) {
/* 525 */           possibleConstructors.add(constructor);
/*     */         }
/*     */       } 
/* 528 */       if (!possibleConstructors.isEmpty()) {
/* 529 */         if (possibleConstructors.size() == 1) {
/* 530 */           Object[] arrayOfObject = new Object[snode.getValue().size()];
/* 531 */           Constructor<?> c = possibleConstructors.get(0);
/* 532 */           int i = 0;
/* 533 */           for (Node argumentNode : snode.getValue()) {
/* 534 */             Class<?> type = c.getParameterTypes()[i];
/*     */             
/* 536 */             argumentNode.setType(type);
/* 537 */             arrayOfObject[i++] = Constructor.this.constructObject(argumentNode);
/*     */           } 
/*     */           
/*     */           try {
/* 541 */             return c.newInstance(arrayOfObject);
/* 542 */           } catch (Exception e) {
/* 543 */             throw new YAMLException(e);
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 548 */         List<Object> argumentList = (List)Constructor.this.constructSequence(snode);
/* 549 */         Class<?>[] parameterTypes = new Class[argumentList.size()];
/* 550 */         int index = 0;
/* 551 */         for (Object parameter : argumentList) {
/* 552 */           parameterTypes[index] = parameter.getClass();
/* 553 */           index++;
/*     */         } 
/*     */         
/* 556 */         for (Constructor<?> c : possibleConstructors) {
/* 557 */           Class<?>[] argTypes = c.getParameterTypes();
/* 558 */           boolean foundConstructor = true;
/* 559 */           for (int i = 0; i < argTypes.length; i++) {
/* 560 */             if (!wrapIfPrimitive(argTypes[i]).isAssignableFrom(parameterTypes[i])) {
/* 561 */               foundConstructor = false;
/*     */               break;
/*     */             } 
/*     */           } 
/* 565 */           if (foundConstructor) {
/*     */             try {
/* 567 */               return c.newInstance(argumentList.toArray());
/* 568 */             } catch (Exception e) {
/* 569 */               throw new YAMLException(e);
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/* 574 */       throw new YAMLException("No suitable constructor with " + String.valueOf(snode.getValue().size()) + " arguments found for " + node.getType());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final Class<? extends Object> wrapIfPrimitive(Class<?> clazz) {
/* 582 */       if (!clazz.isPrimitive()) {
/* 583 */         return (Class)clazz;
/*     */       }
/* 585 */       if (clazz == int.class) {
/* 586 */         return (Class)Integer.class;
/*     */       }
/* 588 */       if (clazz == float.class) {
/* 589 */         return (Class)Float.class;
/*     */       }
/* 591 */       if (clazz == double.class) {
/* 592 */         return (Class)Double.class;
/*     */       }
/* 594 */       if (clazz == boolean.class) {
/* 595 */         return (Class)Boolean.class;
/*     */       }
/* 597 */       if (clazz == long.class) {
/* 598 */         return (Class)Long.class;
/*     */       }
/* 600 */       if (clazz == char.class) {
/* 601 */         return (Class)Character.class;
/*     */       }
/* 603 */       if (clazz == short.class) {
/* 604 */         return (Class)Short.class;
/*     */       }
/* 606 */       if (clazz == byte.class) {
/* 607 */         return (Class)Byte.class;
/*     */       }
/* 609 */       throw new YAMLException("Unexpected primitive " + clazz);
/*     */     }
/*     */ 
/*     */     
/*     */     public void construct2ndStep(Node node, Object object) {
/* 614 */       SequenceNode snode = (SequenceNode)node;
/* 615 */       if (List.class.isAssignableFrom(node.getType())) {
/* 616 */         List<Object> list = (List<Object>)object;
/* 617 */         Constructor.this.constructSequenceStep2(snode, list);
/* 618 */       } else if (node.getType().isArray()) {
/* 619 */         Constructor.this.constructArrayStep2(snode, object);
/*     */       } else {
/* 621 */         throw new YAMLException("Immutable objects cannot be recursive.");
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   protected Class<?> getClassForNode(Node node) {
/* 627 */     Class<? extends Object> classForTag = this.typeTags.get(node.getTag());
/* 628 */     if (classForTag == null) {
/* 629 */       Class<?> cl; String name = node.getTag().getClassName();
/*     */       
/*     */       try {
/* 632 */         cl = getClassForName(name);
/* 633 */       } catch (ClassNotFoundException e) {
/* 634 */         throw new YAMLException("Class not found: " + name);
/*     */       } 
/* 636 */       this.typeTags.put(node.getTag(), cl);
/* 637 */       return cl;
/*     */     } 
/* 639 */     return classForTag;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Class<?> getClassForName(String name) throws ClassNotFoundException {
/* 644 */     return Class.forName(name);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\constructor\Constructor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */