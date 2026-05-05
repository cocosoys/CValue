/*     */ package com.avaje.ebean.meta;
/*     */ 
/*     */ import com.avaje.ebean.bean.ObjectGraphOrigin;
/*     */ import java.io.Serializable;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Id;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ public class MetaAutoFetchTunedQueryInfo
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 3119991928889170215L;
/*     */   @Id
/*     */   private String id;
/*     */   private String beanType;
/*     */   private ObjectGraphOrigin origin;
/*     */   private String tunedDetail;
/*     */   private int profileCount;
/*     */   private int tunedCount;
/*     */   private long lastTuneTime;
/*     */   
/*     */   public MetaAutoFetchTunedQueryInfo() {}
/*     */   
/*     */   public MetaAutoFetchTunedQueryInfo(ObjectGraphOrigin origin, String tunedDetail, int profileCount, int tunedCount, long lastTuneTime) {
/*  58 */     this.origin = origin;
/*  59 */     this.beanType = (origin == null) ? null : origin.getBeanType();
/*  60 */     this.id = (origin == null) ? null : origin.getKey();
/*  61 */     this.tunedDetail = tunedDetail;
/*  62 */     this.profileCount = profileCount;
/*  63 */     this.tunedCount = tunedCount;
/*  64 */     this.lastTuneTime = lastTuneTime;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getId() {
/*  71 */     return this.id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getBeanType() {
/*  78 */     return this.beanType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjectGraphOrigin getOrigin() {
/*  85 */     return this.origin;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTunedDetail() {
/*  92 */     return this.tunedDetail;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getProfileCount() {
/*  99 */     return this.profileCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTunedCount() {
/* 106 */     return this.tunedCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getLastTuneTime() {
/* 113 */     return this.lastTuneTime;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 117 */     return "origin[" + this.origin + "] query[" + this.tunedDetail + "] profileCount[" + this.profileCount + "]";
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\meta\MetaAutoFetchTunedQueryInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */