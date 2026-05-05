/*     */ package org.yaml.snakeyaml.introspector;
/*     */ 
/*     */ import java.beans.IntrospectionException;
/*     */ import java.beans.Introspector;
/*     */ import java.beans.PropertyDescriptor;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.TreeSet;
/*     */ import org.yaml.snakeyaml.error.YAMLException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PropertyUtils
/*     */ {
/*  36 */   private final Map<Class<?>, Map<String, Property>> propertiesCache = new HashMap<Class<?>, Map<String, Property>>();
/*  37 */   private final Map<Class<?>, Set<Property>> readableProperties = new HashMap<Class<?>, Set<Property>>();
/*  38 */   private BeanAccess beanAccess = BeanAccess.DEFAULT;
/*     */   private boolean allowReadOnlyProperties = false;
/*     */   
/*     */   protected Map<String, Property> getPropertiesMap(Class<?> type, BeanAccess bAccess) throws IntrospectionException {
/*     */     Class<?> c;
/*  43 */     if (this.propertiesCache.containsKey(type)) {
/*  44 */       return this.propertiesCache.get(type);
/*     */     }
/*     */     
/*  47 */     Map<String, Property> properties = new LinkedHashMap<String, Property>();
/*  48 */     boolean inaccessableFieldsExist = false;
/*  49 */     switch (bAccess) {
/*     */       case FIELD:
/*  51 */         for (c = type; c != null; c = c.getSuperclass()) {
/*  52 */           for (Field field : c.getDeclaredFields()) {
/*  53 */             int modifiers = field.getModifiers();
/*  54 */             if (!Modifier.isStatic(modifiers) && !Modifier.isTransient(modifiers) && !properties.containsKey(field.getName()))
/*     */             {
/*  56 */               properties.put(field.getName(), new FieldProperty(field));
/*     */             }
/*     */           } 
/*     */         } 
/*     */         break;
/*     */ 
/*     */       
/*     */       default:
/*  64 */         for (PropertyDescriptor property : Introspector.getBeanInfo(type).getPropertyDescriptors()) {
/*  65 */           Method readMethod = property.getReadMethod();
/*  66 */           if (readMethod == null || !readMethod.getName().equals("getClass")) {
/*  67 */             properties.put(property.getName(), new MethodProperty(property));
/*     */           }
/*     */         } 
/*     */ 
/*     */         
/*  72 */         for (c = type; c != null; c = c.getSuperclass()) {
/*  73 */           for (Field field : c.getDeclaredFields()) {
/*  74 */             int modifiers = field.getModifiers();
/*  75 */             if (!Modifier.isStatic(modifiers) && !Modifier.isTransient(modifiers)) {
/*  76 */               if (Modifier.isPublic(modifiers)) {
/*  77 */                 properties.put(field.getName(), new FieldProperty(field));
/*     */               } else {
/*  79 */                 inaccessableFieldsExist = true;
/*     */               } 
/*     */             }
/*     */           } 
/*     */         } 
/*     */         break;
/*     */     } 
/*  86 */     if (properties.isEmpty() && inaccessableFieldsExist) {
/*  87 */       throw new YAMLException("No JavaBean properties found in " + type.getName());
/*     */     }
/*  89 */     this.propertiesCache.put(type, properties);
/*  90 */     return properties;
/*     */   }
/*     */   
/*     */   public Set<Property> getProperties(Class<? extends Object> type) throws IntrospectionException {
/*  94 */     return getProperties(type, this.beanAccess);
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<Property> getProperties(Class<? extends Object> type, BeanAccess bAccess) throws IntrospectionException {
/*  99 */     if (this.readableProperties.containsKey(type)) {
/* 100 */       return this.readableProperties.get(type);
/*     */     }
/* 102 */     Set<Property> properties = createPropertySet(type, bAccess);
/* 103 */     this.readableProperties.put(type, properties);
/* 104 */     return properties;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Set<Property> createPropertySet(Class<? extends Object> type, BeanAccess bAccess) throws IntrospectionException {
/* 109 */     Set<Property> properties = new TreeSet<Property>();
/* 110 */     Collection<Property> props = getPropertiesMap(type, bAccess).values();
/* 111 */     for (Property property : props) {
/* 112 */       if (property.isReadable() && (this.allowReadOnlyProperties || property.isWritable())) {
/* 113 */         properties.add(property);
/*     */       }
/*     */     } 
/* 116 */     return properties;
/*     */   }
/*     */ 
/*     */   
/*     */   public Property getProperty(Class<? extends Object> type, String name) throws IntrospectionException {
/* 121 */     return getProperty(type, name, this.beanAccess);
/*     */   }
/*     */ 
/*     */   
/*     */   public Property getProperty(Class<? extends Object> type, String name, BeanAccess bAccess) throws IntrospectionException {
/* 126 */     Map<String, Property> properties = getPropertiesMap(type, bAccess);
/* 127 */     Property property = properties.get(name);
/* 128 */     if (property == null || !property.isWritable()) {
/* 129 */       throw new YAMLException("Unable to find property '" + name + "' on class: " + type.getName());
/*     */     }
/*     */     
/* 132 */     return property;
/*     */   }
/*     */   
/*     */   public void setBeanAccess(BeanAccess beanAccess) {
/* 136 */     if (this.beanAccess != beanAccess) {
/* 137 */       this.beanAccess = beanAccess;
/* 138 */       this.propertiesCache.clear();
/* 139 */       this.readableProperties.clear();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setAllowReadOnlyProperties(boolean allowReadOnlyProperties) {
/* 144 */     if (this.allowReadOnlyProperties != allowReadOnlyProperties) {
/* 145 */       this.allowReadOnlyProperties = allowReadOnlyProperties;
/* 146 */       this.readableProperties.clear();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\introspector\PropertyUtils.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */