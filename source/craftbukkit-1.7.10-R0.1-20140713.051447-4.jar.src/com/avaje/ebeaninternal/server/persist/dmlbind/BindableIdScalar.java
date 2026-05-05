/*     */ package com.avaje.ebeaninternal.server.persist.dmlbind;
/*     */ 
/*     */ import com.avaje.ebeaninternal.server.core.PersistRequestBean;
/*     */ import com.avaje.ebeaninternal.server.deploy.BeanProperty;
/*     */ import com.avaje.ebeaninternal.server.persist.dml.GenerateDmlRequest;
/*     */ import java.sql.SQLException;
/*     */ import java.util.List;
/*     */ import javax.persistence.PersistenceException;
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
/*     */ public class BindableIdScalar
/*     */   implements BindableId
/*     */ {
/*     */   private final BeanProperty uidProp;
/*     */   
/*     */   public BindableIdScalar(BeanProperty uidProp) {
/*  39 */     this.uidProp = uidProp;
/*     */   }
/*     */   
/*     */   public boolean isConcatenated() {
/*  43 */     return false;
/*     */   }
/*     */   
/*     */   public String getIdentityColumn() {
/*  47 */     return this.uidProp.getDbColumn();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  52 */     return this.uidProp.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addChanged(PersistRequestBean<?> request, List<Bindable> list) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean deriveConcatenatedId(PersistRequestBean<?> persist) {
/*  66 */     throw new PersistenceException("Should not be called? only for concatinated keys");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dmlWhere(GenerateDmlRequest request, boolean checkIncludes, Object bean) {
/*  74 */     request.appendColumn(this.uidProp.getDbColumn());
/*     */   }
/*     */   
/*     */   public void dmlInsert(GenerateDmlRequest request, boolean checkIncludes) {
/*  78 */     dmlAppend(request, checkIncludes);
/*     */   }
/*     */ 
/*     */   
/*     */   public void dmlAppend(GenerateDmlRequest request, boolean checkIncludes) {
/*  83 */     request.appendColumn(this.uidProp.getDbColumn());
/*     */   }
/*     */   
/*     */   public void dmlBind(BindableRequest request, boolean checkIncludes, Object bean) throws SQLException {
/*  87 */     dmlBind(request, checkIncludes, bean, true);
/*     */   }
/*     */   
/*     */   public void dmlBindWhere(BindableRequest request, boolean checkIncludes, Object bean) throws SQLException {
/*  91 */     dmlBind(request, checkIncludes, bean, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void dmlBind(BindableRequest bindRequest, boolean checkIncludes, Object bean, boolean bindNull) throws SQLException {
/*  97 */     Object value = this.uidProp.getValue(bean);
/*     */     
/*  99 */     bindRequest.bind(value, this.uidProp, this.uidProp.getName(), bindNull);
/*     */ 
/*     */     
/* 102 */     bindRequest.setIdValue(value);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\persist\dmlbind\BindableIdScalar.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */