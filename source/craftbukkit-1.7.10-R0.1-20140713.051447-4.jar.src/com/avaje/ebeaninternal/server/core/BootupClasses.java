/*     */ package com.avaje.ebeaninternal.server.core;
/*     */ 
/*     */ import com.avaje.ebean.annotation.LdapDomain;
/*     */ import com.avaje.ebean.config.CompoundType;
/*     */ import com.avaje.ebean.config.ScalarTypeConverter;
/*     */ import com.avaje.ebean.config.lucene.IndexDefn;
/*     */ import com.avaje.ebean.event.BeanFinder;
/*     */ import com.avaje.ebean.event.BeanPersistController;
/*     */ import com.avaje.ebean.event.BeanPersistListener;
/*     */ import com.avaje.ebean.event.BeanQueryAdapter;
/*     */ import com.avaje.ebeaninternal.server.type.ScalarType;
/*     */ import com.avaje.ebeaninternal.server.util.ClassPathSearchMatcher;
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.persistence.Embeddable;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Table;
/*     */ import javax.xml.bind.annotation.XmlRootElement;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BootupClasses
/*     */   implements ClassPathSearchMatcher
/*     */ {
/*  52 */   private static final Logger logger = Logger.getLogger(BootupClasses.class.getName());
/*     */   
/*  54 */   private ArrayList<Class<?>> xmlBeanList = new ArrayList<Class<?>>();
/*     */   
/*  56 */   private ArrayList<Class<?>> embeddableList = new ArrayList<Class<?>>();
/*     */   
/*  58 */   private ArrayList<Class<?>> entityList = new ArrayList<Class<?>>();
/*     */   
/*  60 */   private ArrayList<Class<?>> scalarTypeList = new ArrayList<Class<?>>();
/*     */   
/*  62 */   private ArrayList<Class<?>> scalarConverterList = new ArrayList<Class<?>>();
/*     */   
/*  64 */   private ArrayList<Class<?>> compoundTypeList = new ArrayList<Class<?>>();
/*     */   
/*  66 */   private ArrayList<Class<?>> beanControllerList = new ArrayList<Class<?>>();
/*     */   
/*  68 */   private ArrayList<Class<?>> beanFinderList = new ArrayList<Class<?>>();
/*     */   
/*  70 */   private ArrayList<Class<?>> beanListenerList = new ArrayList<Class<?>>();
/*     */   
/*  72 */   private ArrayList<Class<?>> beanQueryAdapterList = new ArrayList<Class<?>>();
/*     */   
/*  74 */   private ArrayList<Class<?>> luceneIndexList = new ArrayList<Class<?>>();
/*     */   
/*  76 */   private List<BeanPersistController> persistControllerInstances = new ArrayList<BeanPersistController>();
/*  77 */   private List<BeanPersistListener<?>> persistListenerInstances = new ArrayList<BeanPersistListener<?>>();
/*  78 */   private List<BeanQueryAdapter> queryAdapterInstances = new ArrayList<BeanQueryAdapter>();
/*  79 */   private List<IndexDefn<?>> luceneIndexInstances = new ArrayList<IndexDefn<?>>();
/*     */ 
/*     */   
/*     */   public BootupClasses() {}
/*     */   
/*     */   public BootupClasses(List<Class<?>> list) {
/*  85 */     if (list != null) {
/*  86 */       process(list.iterator());
/*     */     }
/*     */   }
/*     */   
/*     */   private BootupClasses(BootupClasses parent) {
/*  91 */     this.xmlBeanList.addAll(parent.xmlBeanList);
/*  92 */     this.embeddableList.addAll(parent.embeddableList);
/*  93 */     this.entityList.addAll(parent.entityList);
/*  94 */     this.scalarTypeList.addAll(parent.scalarTypeList);
/*  95 */     this.scalarConverterList.addAll(parent.scalarConverterList);
/*  96 */     this.compoundTypeList.addAll(parent.compoundTypeList);
/*  97 */     this.beanControllerList.addAll(parent.beanControllerList);
/*  98 */     this.beanFinderList.addAll(parent.beanFinderList);
/*  99 */     this.beanListenerList.addAll(parent.beanListenerList);
/* 100 */     this.beanQueryAdapterList.addAll(parent.beanQueryAdapterList);
/* 101 */     this.luceneIndexList.addAll(parent.luceneIndexList);
/*     */   }
/*     */   
/*     */   private void process(Iterator<Class<?>> it) {
/* 105 */     while (it.hasNext()) {
/* 106 */       Class<?> cls = it.next();
/* 107 */       isMatch(cls);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BootupClasses createCopy() {
/* 115 */     return new BootupClasses(this);
/*     */   }
/*     */   
/*     */   public void addIndexDefns(List<IndexDefn<?>> indexInstances) {
/* 119 */     if (indexInstances != null) {
/* 120 */       this.luceneIndexInstances.addAll(indexInstances);
/*     */     }
/*     */   }
/*     */   
/*     */   public void addQueryAdapters(List<BeanQueryAdapter> queryAdapterInstances) {
/* 125 */     if (queryAdapterInstances != null) {
/* 126 */       this.queryAdapterInstances.addAll(queryAdapterInstances);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addPersistControllers(List<BeanPersistController> beanControllerInstances) {
/* 134 */     if (beanControllerInstances != null) {
/* 135 */       this.persistControllerInstances.addAll(beanControllerInstances);
/*     */     }
/*     */   }
/*     */   
/*     */   public void addPersistListeners(List<BeanPersistListener<?>> listenerInstances) {
/* 140 */     if (listenerInstances != null) {
/* 141 */       this.persistListenerInstances.addAll(listenerInstances);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<BeanQueryAdapter> getBeanQueryAdapters() {
/* 148 */     for (Class<?> cls : this.beanQueryAdapterList) {
/*     */       try {
/* 150 */         BeanQueryAdapter newInstance = (BeanQueryAdapter)cls.newInstance();
/* 151 */         this.queryAdapterInstances.add(newInstance);
/* 152 */       } catch (Exception e) {
/* 153 */         String msg = "Error creating BeanQueryAdapter " + cls;
/* 154 */         logger.log(Level.SEVERE, msg, e);
/*     */       } 
/*     */     } 
/*     */     
/* 158 */     return this.queryAdapterInstances;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<BeanPersistListener<?>> getBeanPersistListeners() {
/* 164 */     for (Class<?> cls : this.beanListenerList) {
/*     */       try {
/* 166 */         BeanPersistListener<?> newInstance = (BeanPersistListener)cls.newInstance();
/* 167 */         this.persistListenerInstances.add(newInstance);
/* 168 */       } catch (Exception e) {
/* 169 */         String msg = "Error creating BeanPersistController " + cls;
/* 170 */         logger.log(Level.SEVERE, msg, e);
/*     */       } 
/*     */     } 
/*     */     
/* 174 */     return this.persistListenerInstances;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<BeanPersistController> getBeanPersistControllers() {
/* 180 */     for (Class<?> cls : this.beanControllerList) {
/*     */       try {
/* 182 */         BeanPersistController newInstance = (BeanPersistController)cls.newInstance();
/* 183 */         this.persistControllerInstances.add(newInstance);
/* 184 */       } catch (Exception e) {
/* 185 */         String msg = "Error creating BeanPersistController " + cls;
/* 186 */         logger.log(Level.SEVERE, msg, e);
/*     */       } 
/*     */     } 
/*     */     
/* 190 */     return this.persistControllerInstances;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IndexDefn<?>> getLuceneIndexInstances() {
/* 198 */     for (Class<?> cls : this.luceneIndexList) {
/*     */       try {
/* 200 */         IndexDefn<?> indexDefn = (IndexDefn)cls.newInstance();
/* 201 */         this.luceneIndexInstances.add(indexDefn);
/* 202 */       } catch (Exception e) {
/* 203 */         String msg = "Error creating BeanPersistController " + cls;
/* 204 */         logger.log(Level.SEVERE, msg, e);
/*     */       } 
/*     */     } 
/*     */     
/* 208 */     return this.luceneIndexInstances;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<Class<?>> getEmbeddables() {
/* 215 */     return this.embeddableList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<Class<?>> getEntities() {
/* 222 */     return this.entityList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<Class<?>> getScalarTypes() {
/* 229 */     return this.scalarTypeList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<Class<?>> getScalarConverters() {
/* 236 */     return this.scalarConverterList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<Class<?>> getCompoundTypes() {
/* 243 */     return this.compoundTypeList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<Class<?>> getBeanControllers() {
/* 250 */     return this.beanControllerList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<Class<?>> getBeanFinders() {
/* 257 */     return this.beanFinderList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<Class<?>> getBeanListeners() {
/* 264 */     return this.beanListenerList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<Class<?>> getXmlBeanList() {
/* 271 */     return this.xmlBeanList;
/*     */   }
/*     */   
/*     */   public void add(Iterator<Class<?>> it) {
/* 275 */     while (it.hasNext()) {
/* 276 */       Class<?> clazz = it.next();
/* 277 */       isMatch(clazz);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isMatch(Class<?> cls) {
/* 283 */     if (isEmbeddable(cls)) {
/* 284 */       this.embeddableList.add(cls);
/*     */     }
/* 286 */     else if (isEntity(cls)) {
/* 287 */       this.entityList.add(cls);
/*     */     }
/* 289 */     else if (isXmlBean(cls)) {
/* 290 */       this.entityList.add(cls);
/*     */     } else {
/*     */       
/* 293 */       if (isInterestingInterface(cls)) {
/* 294 */         return true;
/*     */       }
/*     */       
/* 297 */       return false;
/*     */     } 
/*     */     
/* 300 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isInterestingInterface(Class<?> cls) {
/* 311 */     boolean interesting = false;
/*     */     
/* 313 */     if (BeanPersistController.class.isAssignableFrom(cls)) {
/* 314 */       this.beanControllerList.add(cls);
/* 315 */       interesting = true;
/*     */     } 
/*     */     
/* 318 */     if (ScalarType.class.isAssignableFrom(cls)) {
/* 319 */       this.scalarTypeList.add(cls);
/* 320 */       interesting = true;
/*     */     } 
/*     */     
/* 323 */     if (ScalarTypeConverter.class.isAssignableFrom(cls)) {
/* 324 */       this.scalarConverterList.add(cls);
/* 325 */       interesting = true;
/*     */     } 
/*     */     
/* 328 */     if (CompoundType.class.isAssignableFrom(cls)) {
/* 329 */       this.compoundTypeList.add(cls);
/* 330 */       interesting = true;
/*     */     } 
/*     */     
/* 333 */     if (BeanFinder.class.isAssignableFrom(cls)) {
/* 334 */       this.beanFinderList.add(cls);
/* 335 */       interesting = true;
/*     */     } 
/*     */     
/* 338 */     if (BeanPersistListener.class.isAssignableFrom(cls)) {
/* 339 */       this.beanListenerList.add(cls);
/* 340 */       interesting = true;
/*     */     } 
/*     */     
/* 343 */     if (BeanQueryAdapter.class.isAssignableFrom(cls)) {
/* 344 */       this.beanQueryAdapterList.add(cls);
/* 345 */       interesting = true;
/*     */     } 
/*     */     
/* 348 */     if (IndexDefn.class.isAssignableFrom(cls)) {
/* 349 */       this.luceneIndexList.add(cls);
/* 350 */       interesting = true;
/*     */     } 
/*     */     
/* 353 */     return interesting;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isEntity(Class<?> cls) {
/* 358 */     Annotation ann = (Annotation)cls.getAnnotation(Entity.class);
/* 359 */     if (ann != null) {
/* 360 */       return true;
/*     */     }
/* 362 */     ann = cls.getAnnotation(Table.class);
/* 363 */     if (ann != null) {
/* 364 */       return true;
/*     */     }
/* 366 */     ann = cls.getAnnotation(LdapDomain.class);
/* 367 */     if (ann != null) {
/* 368 */       return true;
/*     */     }
/* 370 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isEmbeddable(Class<?> cls) {
/* 375 */     Annotation ann = (Annotation)cls.getAnnotation(Embeddable.class);
/* 376 */     if (ann != null) {
/* 377 */       return true;
/*     */     }
/* 379 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isXmlBean(Class<?> cls) {
/* 384 */     Annotation ann = (Annotation)cls.getAnnotation(XmlRootElement.class);
/* 385 */     if (ann != null) {
/* 386 */       return true;
/*     */     }
/* 388 */     ann = cls.getAnnotation(XmlType.class);
/* 389 */     if (ann != null)
/*     */     {
/* 391 */       return !cls.isEnum();
/*     */     }
/* 393 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\core\BootupClasses.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */