/*    */ package com.avaje.ebeaninternal.server.core;
/*    */ 
/*    */ import com.avaje.ebean.BeanState;
/*    */ import com.avaje.ebean.bean.EntityBean;
/*    */ import com.avaje.ebean.bean.EntityBeanIntercept;
/*    */ import java.beans.PropertyChangeListener;
/*    */ import java.util.Collections;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DefaultBeanState
/*    */   implements BeanState
/*    */ {
/*    */   final EntityBean entityBean;
/*    */   final EntityBeanIntercept intercept;
/*    */   
/*    */   public DefaultBeanState(EntityBean entityBean) {
/* 21 */     this.entityBean = entityBean;
/* 22 */     this.intercept = entityBean._ebean_getIntercept();
/*    */   }
/*    */   
/*    */   public boolean isReference() {
/* 26 */     return this.intercept.isReference();
/*    */   }
/*    */   
/*    */   public boolean isSharedInstance() {
/* 30 */     return this.intercept.isSharedInstance();
/*    */   }
/*    */   
/*    */   public boolean isNew() {
/* 34 */     return this.intercept.isNew();
/*    */   }
/*    */   
/*    */   public boolean isNewOrDirty() {
/* 38 */     return this.intercept.isNewOrDirty();
/*    */   }
/*    */   
/*    */   public boolean isDirty() {
/* 42 */     return this.intercept.isDirty();
/*    */   }
/*    */   
/*    */   public Set<String> getLoadedProps() {
/* 46 */     Set<String> props = this.intercept.getLoadedProps();
/* 47 */     return (props == null) ? null : Collections.<String>unmodifiableSet(props);
/*    */   }
/*    */   
/*    */   public Set<String> getChangedProps() {
/* 51 */     Set<String> props = this.intercept.getChangedProps();
/* 52 */     return (props == null) ? null : Collections.<String>unmodifiableSet(props);
/*    */   }
/*    */   
/*    */   public boolean isReadOnly() {
/* 56 */     return this.intercept.isReadOnly();
/*    */   }
/*    */   
/*    */   public void setReadOnly(boolean readOnly) {
/* 60 */     this.intercept.setReadOnly(readOnly);
/*    */   }
/*    */   
/*    */   public void addPropertyChangeListener(PropertyChangeListener listener) {
/* 64 */     this.entityBean.addPropertyChangeListener(listener);
/*    */   }
/*    */   
/*    */   public void removePropertyChangeListener(PropertyChangeListener listener) {
/* 68 */     this.entityBean.removePropertyChangeListener(listener);
/*    */   }
/*    */   
/*    */   public void setLoaded(Set<String> loadedProperties) {
/* 72 */     this.intercept.setLoadedProps(loadedProperties);
/* 73 */     this.intercept.setLoaded();
/*    */   }
/*    */   
/*    */   public void setReference() {
/* 77 */     this.intercept.setReference();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\core\DefaultBeanState.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */