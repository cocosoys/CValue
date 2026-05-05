/*     */ package com.avaje.ebeaninternal.server.deploy.meta;
/*     */ 
/*     */ import com.avaje.ebean.bean.BeanCollection;
/*     */ import com.avaje.ebean.validation.factory.Validator;
/*     */ import com.avaje.ebeaninternal.server.deploy.BeanDescriptor;
/*     */ import com.avaje.ebeaninternal.server.deploy.BeanDescriptorMap;
/*     */ import com.avaje.ebeaninternal.server.deploy.BeanProperty;
/*     */ import com.avaje.ebeaninternal.server.deploy.BeanPropertyAssocMany;
/*     */ import com.avaje.ebeaninternal.server.deploy.BeanPropertyAssocOne;
/*     */ import com.avaje.ebeaninternal.server.deploy.BeanPropertyCompound;
/*     */ import com.avaje.ebeaninternal.server.deploy.BeanPropertySimpleCollection;
/*     */ import com.avaje.ebeaninternal.server.deploy.TableJoin;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DeployBeanPropertyLists
/*     */ {
/*     */   private BeanProperty derivedFirstVersionProp;
/*     */   private final BeanDescriptor<?> desc;
/*     */   private final LinkedHashMap<String, BeanProperty> propertyMap;
/*  49 */   private final ArrayList<BeanProperty> ids = new ArrayList<BeanProperty>();
/*     */   
/*  51 */   private final ArrayList<BeanProperty> version = new ArrayList<BeanProperty>();
/*     */   
/*  53 */   private final ArrayList<BeanProperty> local = new ArrayList<BeanProperty>();
/*     */   
/*  55 */   private final ArrayList<BeanProperty> manys = new ArrayList<BeanProperty>();
/*     */   
/*  57 */   private final ArrayList<BeanProperty> ones = new ArrayList<BeanProperty>();
/*     */   
/*  59 */   private final ArrayList<BeanProperty> onesExported = new ArrayList<BeanProperty>();
/*     */   
/*  61 */   private final ArrayList<BeanProperty> onesImported = new ArrayList<BeanProperty>();
/*     */   
/*  63 */   private final ArrayList<BeanProperty> embedded = new ArrayList<BeanProperty>();
/*     */   
/*  65 */   private final ArrayList<BeanProperty> baseScalar = new ArrayList<BeanProperty>();
/*     */   
/*  67 */   private final ArrayList<BeanPropertyCompound> baseCompound = new ArrayList<BeanPropertyCompound>();
/*     */   
/*  69 */   private final ArrayList<BeanProperty> transients = new ArrayList<BeanProperty>();
/*     */   
/*  71 */   private final ArrayList<BeanProperty> nonTransients = new ArrayList<BeanProperty>();
/*     */   
/*     */   private final TableJoin[] tableJoins;
/*     */   
/*     */   private final BeanPropertyAssocOne<?> unidirectional;
/*     */ 
/*     */   
/*     */   public DeployBeanPropertyLists(BeanDescriptorMap owner, BeanDescriptor<?> desc, DeployBeanDescriptor<?> deploy) {
/*  79 */     this.desc = desc;
/*     */     
/*  81 */     DeployBeanPropertyAssocOne<?> deployUnidirectional = deploy.getUnidirectional();
/*  82 */     if (deployUnidirectional == null) {
/*  83 */       this.unidirectional = null;
/*     */     } else {
/*  85 */       this.unidirectional = new BeanPropertyAssocOne(owner, desc, deployUnidirectional);
/*     */     } 
/*     */     
/*  88 */     this.propertyMap = new LinkedHashMap<String, BeanProperty>();
/*     */     
/*  90 */     Iterator<DeployBeanProperty> deployIt = deploy.propertiesAll();
/*  91 */     while (deployIt.hasNext()) {
/*  92 */       DeployBeanProperty deployProp = deployIt.next();
/*  93 */       BeanProperty beanProp = createBeanProperty(owner, deployProp);
/*  94 */       this.propertyMap.put(beanProp.getName(), beanProp);
/*     */     } 
/*     */     
/*  97 */     Iterator<BeanProperty> it = this.propertyMap.values().iterator();
/*     */     
/*  99 */     int order = 0;
/* 100 */     while (it.hasNext()) {
/* 101 */       BeanProperty prop = it.next();
/* 102 */       prop.setDeployOrder(order++);
/* 103 */       allocateToList(prop);
/*     */     } 
/*     */     
/* 106 */     List<DeployTableJoin> deployTableJoins = deploy.getTableJoins();
/* 107 */     this.tableJoins = new TableJoin[deployTableJoins.size()];
/* 108 */     for (int i = 0; i < deployTableJoins.size(); i++) {
/* 109 */       this.tableJoins[i] = new TableJoin(deployTableJoins.get(i), this.propertyMap);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BeanPropertyAssocOne<?> getUnidirectional() {
/* 118 */     return this.unidirectional;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void allocateToList(BeanProperty prop) {
/* 125 */     if (prop.isTransient()) {
/* 126 */       this.transients.add(prop);
/*     */       return;
/*     */     } 
/* 129 */     if (prop.isId()) {
/* 130 */       this.ids.add(prop);
/*     */       return;
/*     */     } 
/* 133 */     this.nonTransients.add(prop);
/*     */ 
/*     */     
/* 136 */     if (this.desc.getInheritInfo() != null && prop.isLocal()) {
/* 137 */       this.local.add(prop);
/*     */     }
/*     */     
/* 140 */     if (prop instanceof BeanPropertyAssocMany) {
/* 141 */       this.manys.add(prop);
/*     */     }
/* 143 */     else if (prop instanceof BeanPropertyAssocOne) {
/* 144 */       if (prop.isEmbedded()) {
/* 145 */         this.embedded.add(prop);
/*     */       } else {
/* 147 */         this.ones.add(prop);
/* 148 */         BeanPropertyAssocOne<?> assocOne = (BeanPropertyAssocOne)prop;
/* 149 */         if (assocOne.isOneToOneExported()) {
/* 150 */           this.onesExported.add(prop);
/*     */         } else {
/* 152 */           this.onesImported.add(prop);
/*     */         }
/*     */       
/*     */       } 
/*     */     } else {
/*     */       
/* 158 */       if (prop.isVersion()) {
/* 159 */         this.version.add(prop);
/* 160 */         if (this.derivedFirstVersionProp == null) {
/* 161 */           this.derivedFirstVersionProp = prop;
/*     */         }
/*     */       } 
/* 164 */       if (prop instanceof BeanPropertyCompound) {
/* 165 */         this.baseCompound.add((BeanPropertyCompound)prop);
/*     */       } else {
/* 167 */         this.baseScalar.add(prop);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public BeanProperty getFirstVersion() {
/* 173 */     return this.derivedFirstVersionProp;
/*     */   }
/*     */ 
/*     */   
/*     */   public BeanProperty[] getPropertiesWithValidators(boolean recurse) {
/* 178 */     ArrayList<BeanProperty> list = new ArrayList<BeanProperty>();
/* 179 */     Iterator<BeanProperty> it = this.propertyMap.values().iterator();
/* 180 */     while (it.hasNext()) {
/* 181 */       BeanProperty property = it.next();
/* 182 */       if (property.hasValidationRules(recurse)) {
/* 183 */         list.add(property);
/*     */       }
/*     */     } 
/* 186 */     return list.<BeanProperty>toArray(new BeanProperty[list.size()]);
/*     */   }
/*     */   
/*     */   public Validator[] getBeanValidators() {
/* 190 */     return new Validator[0];
/*     */   }
/*     */   
/*     */   public LinkedHashMap<String, BeanProperty> getPropertyMap() {
/* 194 */     return this.propertyMap;
/*     */   }
/*     */   
/*     */   public TableJoin[] getTableJoin() {
/* 198 */     return this.tableJoins;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BeanProperty[] getBaseScalar() {
/* 206 */     return this.baseScalar.<BeanProperty>toArray(new BeanProperty[this.baseScalar.size()]);
/*     */   }
/*     */   
/*     */   public BeanPropertyCompound[] getBaseCompound() {
/* 210 */     return this.baseCompound.<BeanPropertyCompound>toArray(new BeanPropertyCompound[this.baseCompound.size()]);
/*     */   }
/*     */   
/*     */   public BeanProperty[] getId() {
/* 214 */     return this.ids.<BeanProperty>toArray(new BeanProperty[this.ids.size()]);
/*     */   }
/*     */   
/*     */   public BeanProperty[] getNonTransients() {
/* 218 */     return this.nonTransients.<BeanProperty>toArray(new BeanProperty[this.nonTransients.size()]);
/*     */   }
/*     */   
/*     */   public BeanProperty[] getTransients() {
/* 222 */     return this.transients.<BeanProperty>toArray(new BeanProperty[this.transients.size()]);
/*     */   }
/*     */   
/*     */   public BeanProperty[] getVersion() {
/* 226 */     return this.version.<BeanProperty>toArray(new BeanProperty[this.version.size()]);
/*     */   }
/*     */   
/*     */   public BeanProperty[] getLocal() {
/* 230 */     return this.local.<BeanProperty>toArray(new BeanProperty[this.local.size()]);
/*     */   }
/*     */   
/*     */   public BeanPropertyAssocOne<?>[] getEmbedded() {
/* 234 */     return (BeanPropertyAssocOne<?>[])this.embedded.<BeanPropertyAssocOne>toArray(new BeanPropertyAssocOne[this.embedded.size()]);
/*     */   }
/*     */   
/*     */   public BeanPropertyAssocOne<?>[] getOneExported() {
/* 238 */     return (BeanPropertyAssocOne<?>[])this.onesExported.<BeanPropertyAssocOne>toArray(new BeanPropertyAssocOne[this.onesExported.size()]);
/*     */   }
/*     */   
/*     */   public BeanPropertyAssocOne<?>[] getOneImported() {
/* 242 */     return (BeanPropertyAssocOne<?>[])this.onesImported.<BeanPropertyAssocOne>toArray(new BeanPropertyAssocOne[this.onesImported.size()]);
/*     */   }
/*     */   
/*     */   public BeanPropertyAssocOne<?>[] getOnes() {
/* 246 */     return (BeanPropertyAssocOne<?>[])this.ones.<BeanPropertyAssocOne>toArray(new BeanPropertyAssocOne[this.ones.size()]);
/*     */   }
/*     */   
/*     */   public BeanPropertyAssocOne<?>[] getOneExportedSave() {
/* 250 */     return getOne(false, Mode.Save);
/*     */   }
/*     */   
/*     */   public BeanPropertyAssocOne<?>[] getOneExportedDelete() {
/* 254 */     return getOne(false, Mode.Delete);
/*     */   }
/*     */   
/*     */   public BeanPropertyAssocOne<?>[] getOneImportedSave() {
/* 258 */     return getOne(true, Mode.Save);
/*     */   }
/*     */   
/*     */   public BeanPropertyAssocOne<?>[] getOneImportedDelete() {
/* 262 */     return getOne(true, Mode.Delete);
/*     */   }
/*     */   
/*     */   public BeanPropertyAssocMany<?>[] getMany() {
/* 266 */     return (BeanPropertyAssocMany<?>[])this.manys.<BeanPropertyAssocMany>toArray(new BeanPropertyAssocMany[this.manys.size()]);
/*     */   }
/*     */   
/*     */   public BeanPropertyAssocMany<?>[] getManySave() {
/* 270 */     return getMany(Mode.Save);
/*     */   }
/*     */   
/*     */   public BeanPropertyAssocMany<?>[] getManyDelete() {
/* 274 */     return getMany(Mode.Delete);
/*     */   }
/*     */   
/*     */   public BeanPropertyAssocMany<?>[] getManyToMany() {
/* 278 */     return getMany2Many();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private enum Mode
/*     */   {
/* 285 */     Save, Delete, Validate;
/*     */   }
/*     */   
/*     */   private BeanPropertyAssocOne<?>[] getOne(boolean imported, Mode mode) {
/* 289 */     ArrayList<BeanPropertyAssocOne<?>> list = new ArrayList<BeanPropertyAssocOne<?>>();
/* 290 */     for (int i = 0; i < this.ones.size(); i++) {
/* 291 */       BeanPropertyAssocOne<?> prop = (BeanPropertyAssocOne)this.ones.get(i);
/* 292 */       if (imported != prop.isOneToOneExported()) {
/* 293 */         switch (mode) {
/*     */           case Save:
/* 295 */             if (prop.getCascadeInfo().isSave()) {
/* 296 */               list.add(prop);
/*     */             }
/*     */             break;
/*     */           case Delete:
/* 300 */             if (prop.getCascadeInfo().isDelete()) {
/* 301 */               list.add(prop);
/*     */             }
/*     */             break;
/*     */           case Validate:
/* 305 */             if (prop.getCascadeInfo().isValidate()) {
/* 306 */               list.add(prop);
/*     */             }
/*     */             break;
/*     */         } 
/*     */ 
/*     */ 
/*     */       
/*     */       }
/*     */     } 
/* 315 */     return (BeanPropertyAssocOne<?>[])list.<BeanPropertyAssocOne>toArray(new BeanPropertyAssocOne[list.size()]);
/*     */   }
/*     */   
/*     */   private BeanPropertyAssocMany<?>[] getMany2Many() {
/* 319 */     ArrayList<BeanPropertyAssocMany<?>> list = new ArrayList<BeanPropertyAssocMany<?>>();
/* 320 */     for (int i = 0; i < this.manys.size(); i++) {
/* 321 */       BeanPropertyAssocMany<?> prop = (BeanPropertyAssocMany)this.manys.get(i);
/* 322 */       if (prop.isManyToMany()) {
/* 323 */         list.add(prop);
/*     */       }
/*     */     } 
/*     */     
/* 327 */     return (BeanPropertyAssocMany<?>[])list.<BeanPropertyAssocMany>toArray(new BeanPropertyAssocMany[list.size()]);
/*     */   }
/*     */   
/*     */   private BeanPropertyAssocMany<?>[] getMany(Mode mode) {
/* 331 */     ArrayList<BeanPropertyAssocMany<?>> list = new ArrayList<BeanPropertyAssocMany<?>>();
/* 332 */     for (int i = 0; i < this.manys.size(); i++) {
/* 333 */       BeanPropertyAssocMany<?> prop = (BeanPropertyAssocMany)this.manys.get(i);
/*     */       
/* 335 */       switch (mode) {
/*     */         case Save:
/* 337 */           if (prop.getCascadeInfo().isSave() || prop.isManyToMany() || BeanCollection.ModifyListenMode.REMOVALS.equals(prop.getModifyListenMode()))
/*     */           {
/*     */ 
/*     */ 
/*     */             
/* 342 */             list.add(prop);
/*     */           }
/*     */           break;
/*     */         case Delete:
/* 346 */           if (prop.getCascadeInfo().isDelete() || BeanCollection.ModifyListenMode.REMOVALS.equals(prop.getModifyListenMode()))
/*     */           {
/*     */             
/* 349 */             list.add(prop);
/*     */           }
/*     */           break;
/*     */         case Validate:
/* 353 */           if (prop.getCascadeInfo().isValidate()) {
/* 354 */             list.add(prop);
/*     */           }
/*     */           break;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     } 
/* 363 */     return (BeanPropertyAssocMany<?>[])list.<BeanPropertyAssocMany>toArray(new BeanPropertyAssocMany[list.size()]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private BeanProperty createBeanProperty(BeanDescriptorMap owner, DeployBeanProperty deployProp) {
/* 369 */     if (deployProp instanceof DeployBeanPropertyAssocOne)
/*     */     {
/* 371 */       return (BeanProperty)new BeanPropertyAssocOne(owner, this.desc, (DeployBeanPropertyAssocOne)deployProp);
/*     */     }
/* 373 */     if (deployProp instanceof DeployBeanPropertySimpleCollection)
/*     */     {
/* 375 */       return (BeanProperty)new BeanPropertySimpleCollection(owner, this.desc, (DeployBeanPropertySimpleCollection)deployProp);
/*     */     }
/* 377 */     if (deployProp instanceof DeployBeanPropertyAssocMany)
/*     */     {
/* 379 */       return (BeanProperty)new BeanPropertyAssocMany(owner, this.desc, (DeployBeanPropertyAssocMany)deployProp);
/*     */     }
/* 381 */     if (deployProp instanceof DeployBeanPropertyCompound)
/*     */     {
/* 383 */       return (BeanProperty)new BeanPropertyCompound(owner, this.desc, (DeployBeanPropertyCompound)deployProp);
/*     */     }
/*     */     
/* 386 */     return new BeanProperty(owner, this.desc, deployProp);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\deploy\meta\DeployBeanPropertyLists.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */