/*    */ package com.avaje.ebean.config.lucene;
/*    */ 
/*    */ import com.avaje.ebean.Query;
/*    */ import com.avaje.ebean.config.GlobalProperties;
/*    */ import org.apache.lucene.analysis.Analyzer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LuceneConfig
/*    */ {
/*    */   protected String baseDirectory;
/*    */   protected Analyzer defaultAnalyzer;
/*    */   protected Query.UseIndex defaultUseIndex;
/*    */   
/*    */   public Analyzer getDefaultAnalyzer() {
/* 45 */     return this.defaultAnalyzer;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setDefaultAnalyzer(Analyzer defaultAnalyzer) {
/* 52 */     this.defaultAnalyzer = defaultAnalyzer;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getBaseDirectory() {
/* 59 */     return this.baseDirectory;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setBaseDirectory(String baseDirectory) {
/* 66 */     this.baseDirectory = baseDirectory;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Query.UseIndex getDefaultUseIndex() {
/* 73 */     return this.defaultUseIndex;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setDefaultUseIndex(Query.UseIndex defaultUseIndex) {
/* 80 */     this.defaultUseIndex = defaultUseIndex;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void loadSettings(String serverName) {
/* 88 */     GlobalProperties.PropertySource p = GlobalProperties.getPropertySource(serverName);
/*    */     
/* 90 */     this.baseDirectory = p.get("lucene.baseDirectory", "lucene");
/* 91 */     this.defaultUseIndex = (Query.UseIndex)p.getEnum(Query.UseIndex.class, "lucene.useIndex", (Enum)Query.UseIndex.NO);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\config\lucene\LuceneConfig.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */