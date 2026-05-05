/*     */ package com.avaje.ebean.meta;
/*     */ 
/*     */ import com.avaje.ebean.bean.ObjectGraphOrigin;
/*     */ import java.io.Serializable;
/*     */ import java.util.Arrays;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Transient;
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
/*     */ public class MetaAutoFetchStatistic
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -6640406753257176803L;
/*     */   @Id
/*     */   private String id;
/*     */   private ObjectGraphOrigin origin;
/*     */   private String beanType;
/*     */   private int counter;
/*     */   @Transient
/*     */   private List<QueryStats> queryStats;
/*     */   @Transient
/*     */   private List<NodeUsageStats> nodeUsageStats;
/*     */   
/*     */   public MetaAutoFetchStatistic() {}
/*     */   
/*     */   public MetaAutoFetchStatistic(ObjectGraphOrigin origin, int counter, List<QueryStats> queryStats, List<NodeUsageStats> nodeUsageStats) {
/*  43 */     this.origin = origin;
/*  44 */     this.beanType = (origin == null) ? null : origin.getBeanType();
/*  45 */     this.id = (origin == null) ? null : origin.getKey();
/*  46 */     this.counter = counter;
/*  47 */     this.queryStats = queryStats;
/*  48 */     this.nodeUsageStats = nodeUsageStats;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getId() {
/*  55 */     return this.id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getBeanType() {
/*  62 */     return this.beanType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjectGraphOrigin getOrigin() {
/*  69 */     return this.origin;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCounter() {
/*  76 */     return this.counter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<QueryStats> getQueryStats() {
/*  83 */     return this.queryStats;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<NodeUsageStats> getNodeUsageStats() {
/*  90 */     return this.nodeUsageStats;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class QueryStats
/*     */     implements Serializable
/*     */   {
/*     */     private static final long serialVersionUID = -5517935732867671387L;
/*     */     
/*     */     private final String path;
/*     */     
/*     */     private final int exeCount;
/*     */     
/*     */     private final int totalBeanLoaded;
/*     */     
/*     */     private final int totalMicros;
/*     */ 
/*     */     
/*     */     public QueryStats(String path, int exeCount, int totalBeanLoaded, int totalMicros) {
/* 109 */       this.path = path;
/* 110 */       this.exeCount = exeCount;
/* 111 */       this.totalBeanLoaded = totalBeanLoaded;
/* 112 */       this.totalMicros = totalMicros;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getPath() {
/* 120 */       return this.path;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getExeCount() {
/* 127 */       return this.exeCount;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getTotalBeanLoaded() {
/* 134 */       return this.totalBeanLoaded;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getTotalMicros() {
/* 141 */       return this.totalMicros;
/*     */     }
/*     */     
/*     */     public String toString() {
/* 145 */       long avgMicros = (this.exeCount == 0) ? 0L : (this.totalMicros / this.exeCount);
/*     */       
/* 147 */       return "queryExe path[" + this.path + "] count[" + this.exeCount + "] totalBeansLoaded[" + this.totalBeanLoaded + "] avgMicros[" + avgMicros + "] totalMicros[" + this.totalMicros + "]";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class NodeUsageStats
/*     */     implements Serializable
/*     */   {
/*     */     private static final long serialVersionUID = 1786787832374844739L;
/*     */ 
/*     */     
/*     */     private final String path;
/*     */     
/*     */     private final int profileCount;
/*     */     
/*     */     private final int profileUsedCount;
/*     */     
/*     */     private final String[] usedProperties;
/*     */ 
/*     */     
/*     */     public NodeUsageStats(String path, int profileCount, int profileUsedCount, String[] usedProperties) {
/* 169 */       this.path = (path == null) ? "" : path;
/* 170 */       this.profileCount = profileCount;
/* 171 */       this.profileUsedCount = profileUsedCount;
/* 172 */       this.usedProperties = usedProperties;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getPath() {
/* 180 */       return this.path;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getProfileCount() {
/* 187 */       return this.profileCount;
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
/*     */     public int getProfileUsedCount() {
/* 199 */       return this.profileUsedCount;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String[] getUsedProperties() {
/* 206 */       return this.usedProperties;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Set<String> getUsedPropertiesSet() {
/* 213 */       LinkedHashSet<String> s = new LinkedHashSet<String>();
/* 214 */       for (int i = 0; i < this.usedProperties.length; i++) {
/* 215 */         s.add(this.usedProperties[i]);
/*     */       }
/* 217 */       return s;
/*     */     }
/*     */     
/*     */     public String toString() {
/* 221 */       return "path[" + this.path + "] profileCount[" + this.profileCount + "] used[" + this.profileUsedCount + "] props" + Arrays.toString((Object[])this.usedProperties);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\meta\MetaAutoFetchStatistic.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */