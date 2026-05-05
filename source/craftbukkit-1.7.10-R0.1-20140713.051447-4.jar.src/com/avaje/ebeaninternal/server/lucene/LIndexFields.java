/*     */ package com.avaje.ebeaninternal.server.lucene;
/*     */ 
/*     */ import com.avaje.ebean.config.lucene.LuceneIndex;
/*     */ import com.avaje.ebean.text.PathProperties;
/*     */ import com.avaje.ebeaninternal.server.deploy.BeanDescriptor;
/*     */ import com.avaje.ebeaninternal.server.el.ElPropertyValue;
/*     */ import com.avaje.ebeaninternal.server.query.SplitName;
/*     */ import com.avaje.ebeaninternal.server.querydefn.OrmQueryDetail;
/*     */ import com.avaje.ebeaninternal.server.transaction.IndexInvalidate;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.logging.Logger;
/*     */ import org.apache.lucene.document.Document;
/*     */ import org.apache.lucene.queryParser.QueryParser;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LIndexFields
/*     */ {
/*  46 */   private static final Logger logger = Logger.getLogger(LIndexFields.class.getName());
/*     */   
/*     */   private final String defaultFieldName;
/*     */   
/*     */   private final BeanDescriptor<?> descriptor;
/*     */   
/*     */   private final LIndexField[] fields;
/*     */   
/*     */   private final LIndexField[] readFields;
/*     */   
/*     */   private final PathProperties pathProperties;
/*     */   
/*     */   private final OrmQueryDetail ormQueryDetail;
/*     */   
/*  60 */   private final HashMap<String, LIndexField> fieldMap = new HashMap<String, LIndexField>();
/*     */   
/*  62 */   private final HashMap<String, LIndexField> sortableExpressionMap = new HashMap<String, LIndexField>();
/*     */   
/*  64 */   private final LinkedHashSet<String> requiredPropertyNames = new LinkedHashSet<String>();
/*  65 */   private final LinkedHashSet<String> resolvePropertyNames = new LinkedHashSet<String>();
/*  66 */   private final LinkedHashSet<String> restorePropertyNames = new LinkedHashSet<String>();
/*     */   
/*     */   private final Set<String> nonRestorablePropertyNames;
/*     */   
/*     */   private final LIndexFieldId idField;
/*     */   
/*     */   public LIndexFields(List<LIndexField> definedFields, BeanDescriptor<?> descriptor, String defaultFieldName) {
/*  73 */     this.descriptor = descriptor;
/*  74 */     this.defaultFieldName = defaultFieldName;
/*  75 */     this.fields = definedFields.<LIndexField>toArray(new LIndexField[definedFields.size()]);
/*     */     
/*  77 */     LIndexFieldId tempIdField = null;
/*  78 */     for (LIndexField field : this.fields) {
/*  79 */       String fieldName = field.getName();
/*  80 */       if (field instanceof LIndexFieldId && fieldName.indexOf('.') == -1) {
/*  81 */         tempIdField = (LIndexFieldId)field;
/*     */       }
/*     */       
/*  84 */       this.fieldMap.put(fieldName, field);
/*  85 */       field.addIndexRequiredPropertyNames(this.requiredPropertyNames);
/*  86 */       field.addIndexResolvePropertyNames(this.resolvePropertyNames);
/*  87 */       field.addIndexRestorePropertyNames(this.restorePropertyNames);
/*     */       
/*  89 */       String sortableProperty = field.getSortableProperty();
/*  90 */       if (sortableProperty != null) {
/*  91 */         this.sortableExpressionMap.put(sortableProperty, field);
/*     */       }
/*     */     } 
/*     */     
/*  95 */     this.idField = tempIdField;
/*  96 */     this.nonRestorablePropertyNames = getNonRestorableProperties();
/*  97 */     if (!this.nonRestorablePropertyNames.isEmpty()) {
/*  98 */       logger.info("Index has properties [" + this.nonRestorablePropertyNames + "] that are not stored");
/*     */     }
/*     */     
/* 101 */     this.readFields = createReadFields();
/* 102 */     this.pathProperties = createPathProperties();
/* 103 */     this.ormQueryDetail = createOrmQueryDetail();
/*     */   }
/*     */   
/*     */   public LIndexFieldId getIdField() {
/* 107 */     return this.idField;
/*     */   }
/*     */ 
/*     */   
/*     */   public void registerIndexWithProperties(LuceneIndex luceneIndex) {
/* 112 */     IndexInvalidate invalidate = new IndexInvalidate(this.descriptor.getBeanType().getName());
/*     */     
/* 114 */     for (String prop : this.restorePropertyNames) {
/* 115 */       ElPropertyValue elProp = this.descriptor.getElGetValue(prop);
/* 116 */       if (elProp.isAssocProperty()) {
/*     */ 
/*     */         
/* 119 */         elProp.getBeanProperty().getBeanDescriptor().addIndexInvalidate(invalidate);
/*     */         
/*     */         continue;
/*     */       } 
/* 123 */       elProp.getBeanProperty().registerLuceneIndex(luceneIndex);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Set<String> getNonRestorableProperties() {
/* 133 */     HashSet<String> nonRestoreable = new HashSet<String>();
/* 134 */     for (String reqrProp : this.requiredPropertyNames) {
/* 135 */       if (!this.restorePropertyNames.contains(reqrProp)) {
/* 136 */         nonRestoreable.add(reqrProp);
/*     */       }
/*     */     } 
/* 139 */     return nonRestoreable;
/*     */   }
/*     */   
/*     */   public LIndexField getSortableField(String propertyName) {
/* 143 */     return this.sortableExpressionMap.get(propertyName);
/*     */   }
/*     */   
/*     */   public QueryParser createQueryParser(String fieldName) {
/* 147 */     if (fieldName == null) {
/* 148 */       fieldName = this.defaultFieldName;
/*     */     }
/* 150 */     LIndexField fld = this.fieldMap.get(fieldName);
/* 151 */     if (fld == null) {
/* 152 */       throw new NullPointerException("fieldName [" + fieldName + "] not in index?");
/*     */     }
/* 154 */     return fld.createQueryParser();
/*     */   }
/*     */   
/*     */   public OrmQueryDetail getOrmQueryDetail() {
/* 158 */     return this.ormQueryDetail;
/*     */   }
/*     */   
/*     */   public Set<String> getResolvePropertyNames() {
/* 162 */     return this.resolvePropertyNames;
/*     */   }
/*     */   
/*     */   public LinkedHashSet<String> getRequiredPropertyNames() {
/* 166 */     return this.requiredPropertyNames;
/*     */   }
/*     */ 
/*     */   
/*     */   public DocFieldWriter createDocFieldWriter() {
/* 171 */     DocFieldWriter[] dw = new DocFieldWriter[this.fields.length];
/* 172 */     for (int j = 0; j < dw.length; j++) {
/* 173 */       dw[j] = this.fields[j].createDocFieldWriter();
/*     */     }
/* 175 */     return new Writer(dw);
/*     */   }
/*     */   
/*     */   public void readDocument(Document doc, Object bean) {
/* 179 */     for (LIndexField indexField : this.readFields) {
/* 180 */       indexField.readValue(doc, bean);
/*     */     }
/*     */   }
/*     */   
/*     */   public LIndexField[] getReadFields() {
/* 185 */     return this.readFields;
/*     */   }
/*     */ 
/*     */   
/*     */   private LIndexField[] createReadFields() {
/* 190 */     ArrayList<LIndexField> readFieldList = new ArrayList<LIndexField>();
/*     */     
/* 192 */     for (int i = 0; i < this.fields.length; i++) {
/* 193 */       LIndexField field = this.fields[i];
/* 194 */       if (field.isStored() && field.isBeanProperty())
/*     */       {
/*     */ 
/*     */ 
/*     */         
/* 199 */         readFieldList.add(field);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 204 */     Collections.sort(readFieldList, new Comparator<LIndexField>() {
/*     */           public int compare(LIndexField o1, LIndexField o2) {
/* 206 */             int v1 = o1.getPropertyOrder();
/* 207 */             int v2 = o2.getPropertyOrder();
/* 208 */             return (v1 < v2) ? -1 : ((v1 == v2) ? 0 : 1);
/*     */           }
/*     */         });
/*     */     
/* 212 */     return readFieldList.<LIndexField>toArray(new LIndexField[readFieldList.size()]);
/*     */   }
/*     */ 
/*     */   
/*     */   private PathProperties createPathProperties() {
/* 217 */     PathProperties pathProps = new PathProperties();
/*     */     
/* 219 */     for (int i = 0; i < this.readFields.length; i++) {
/* 220 */       LIndexField field = this.readFields[i];
/* 221 */       String propertyName = field.getName();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 226 */       ElPropertyValue el = field.getElBeanProperty();
/* 227 */       if (el.getBeanProperty().isId())
/*     */       {
/* 229 */         propertyName = SplitName.parent(propertyName);
/*     */       }
/* 231 */       if (propertyName != null) {
/* 232 */         String[] pathProp = SplitName.split(propertyName);
/* 233 */         pathProps.addToPath(pathProp[0], pathProp[1]);
/*     */       } 
/*     */     } 
/*     */     
/* 237 */     return pathProps;
/*     */   }
/*     */ 
/*     */   
/*     */   private OrmQueryDetail createOrmQueryDetail() {
/* 242 */     OrmQueryDetail detail = new OrmQueryDetail();
/*     */ 
/*     */     
/* 245 */     Iterator<String> pathIt = this.pathProperties.getPaths().iterator();
/* 246 */     while (pathIt.hasNext()) {
/* 247 */       String path = pathIt.next();
/* 248 */       Set<String> props = this.pathProperties.get(path);
/* 249 */       detail.getChunk(path, true).setDefaultProperties(null, props);
/*     */     } 
/*     */     
/* 252 */     return detail;
/*     */   }
/*     */   
/*     */   static class Writer
/*     */     implements DocFieldWriter {
/*     */     private final DocFieldWriter[] dw;
/*     */     
/*     */     private Writer(DocFieldWriter[] dw) {
/* 260 */       this.dw = dw;
/*     */     }
/*     */     
/*     */     public void writeValue(Object bean, Document document) {
/* 264 */       for (DocFieldWriter w : this.dw)
/* 265 */         w.writeValue(bean, document); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\lucene\LIndexFields.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */