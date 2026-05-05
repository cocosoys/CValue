/*     */ package com.avaje.ebeaninternal.server.ddl;
/*     */ 
/*     */ import com.avaje.ebean.config.NamingConvention;
/*     */ import com.avaje.ebean.config.dbplatform.DatabasePlatform;
/*     */ import com.avaje.ebean.config.dbplatform.DbDdlSyntax;
/*     */ import com.avaje.ebean.config.dbplatform.DbType;
/*     */ import com.avaje.ebean.config.dbplatform.DbTypeMap;
/*     */ import com.avaje.ebeaninternal.server.deploy.BeanProperty;
/*     */ import com.avaje.ebeaninternal.server.type.ScalarType;
/*     */ import java.io.StringWriter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
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
/*     */ public class DdlGenContext
/*     */ {
/*  30 */   private final StringWriter stringWriter = new StringWriter();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final DbTypeMap dbTypeMap;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final DbDdlSyntax ddlSyntax;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String newLine;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  50 */   private final List<String> contentBuffer = new ArrayList<String>();
/*     */   
/*  52 */   private Set<String> intersectionTables = new HashSet<String>();
/*     */   
/*  54 */   private List<String> intersectionTablesCreateDdl = new ArrayList<String>();
/*  55 */   private List<String> intersectionTablesFkDdl = new ArrayList<String>();
/*     */ 
/*     */   
/*     */   private final DatabasePlatform dbPlatform;
/*     */ 
/*     */   
/*     */   private final NamingConvention namingConvention;
/*     */   
/*     */   private int fkCount;
/*     */   
/*     */   private int ixCount;
/*     */ 
/*     */   
/*     */   public DdlGenContext(DatabasePlatform dbPlatform, NamingConvention namingConvention) {
/*  69 */     this.dbPlatform = dbPlatform;
/*  70 */     this.dbTypeMap = dbPlatform.getDbTypeMap();
/*  71 */     this.ddlSyntax = dbPlatform.getDbDdlSyntax();
/*  72 */     this.newLine = this.ddlSyntax.getNewLine();
/*  73 */     this.namingConvention = namingConvention;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DatabasePlatform getDbPlatform() {
/*  80 */     return this.dbPlatform;
/*     */   }
/*     */   
/*     */   public boolean isProcessIntersectionTable(String tableName) {
/*  84 */     return this.intersectionTables.add(tableName);
/*     */   }
/*     */   
/*     */   public void addCreateIntersectionTable(String createTableDdl) {
/*  88 */     this.intersectionTablesCreateDdl.add(createTableDdl);
/*     */   }
/*     */   
/*     */   public void addIntersectionTableFk(String intTableFk) {
/*  92 */     this.intersectionTablesFkDdl.add(intTableFk);
/*     */   }
/*     */   
/*     */   public void addIntersectionCreateTables() {
/*  96 */     for (String intTableCreate : this.intersectionTablesCreateDdl) {
/*  97 */       write(this.newLine);
/*  98 */       write(intTableCreate);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addIntersectionFkeys() {
/* 103 */     write(this.newLine);
/* 104 */     write(this.newLine);
/* 105 */     for (String intTableFk : this.intersectionTablesFkDdl) {
/* 106 */       write(this.newLine);
/* 107 */       write(intTableFk);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getContent() {
/* 115 */     return this.stringWriter.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DbTypeMap getDbTypeMap() {
/* 123 */     return this.dbTypeMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DbDdlSyntax getDdlSyntax() {
/* 130 */     return this.ddlSyntax;
/*     */   }
/*     */   
/*     */   public String getColumnDefn(BeanProperty p) {
/* 134 */     DbType dbType = getDbType(p);
/* 135 */     return p.renderDbType(dbType);
/*     */   }
/*     */ 
/*     */   
/*     */   private DbType getDbType(BeanProperty p) {
/* 140 */     ScalarType<?> scalarType = p.getScalarType();
/* 141 */     if (scalarType == null) {
/* 142 */       throw new RuntimeException("No scalarType for " + p.getFullBeanName());
/*     */     }
/*     */     
/* 145 */     if (p.isDbEncrypted()) {
/* 146 */       return this.dbTypeMap.get(p.getDbEncryptedType());
/*     */     }
/*     */     
/* 149 */     int jdbcType = scalarType.getJdbcType();
/* 150 */     if (p.isLob() && jdbcType == 12)
/*     */     {
/*     */       
/* 153 */       jdbcType = 2005;
/*     */     }
/* 155 */     return this.dbTypeMap.get(jdbcType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DdlGenContext write(String content, int minWidth) {
/* 162 */     content = pad(content, minWidth);
/*     */     
/* 164 */     this.contentBuffer.add(content);
/*     */     
/* 166 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DdlGenContext write(String content) {
/* 174 */     return write(content, 0);
/*     */   }
/*     */   
/*     */   public DdlGenContext writeNewLine() {
/* 178 */     write(this.newLine);
/* 179 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DdlGenContext removeLast() {
/* 186 */     if (!this.contentBuffer.isEmpty()) {
/* 187 */       this.contentBuffer.remove(this.contentBuffer.size() - 1);
/*     */     } else {
/* 189 */       throw new RuntimeException("No lastContent to remove?");
/*     */     } 
/* 191 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DdlGenContext flush() {
/* 198 */     if (!this.contentBuffer.isEmpty()) {
/* 199 */       for (String s : this.contentBuffer) {
/*     */         
/* 201 */         if (s != null) {
/* 202 */           this.stringWriter.write(s);
/*     */         }
/*     */       } 
/* 205 */       this.contentBuffer.clear();
/*     */     } 
/* 207 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   private String padding(int length) {
/* 212 */     StringBuffer sb = new StringBuffer(length);
/* 213 */     for (int i = 0; i < length; i++) {
/* 214 */       sb.append(" ");
/*     */     }
/* 216 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public String pad(String content, int minWidth) {
/* 220 */     if (minWidth > 0 && content.length() < minWidth) {
/* 221 */       int padding = minWidth - content.length();
/* 222 */       return content + padding(padding);
/*     */     } 
/* 224 */     return content;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NamingConvention getNamingConvention() {
/* 231 */     return this.namingConvention;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int incrementFkCount() {
/* 238 */     return ++this.fkCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int incrementIxCount() {
/* 245 */     return ++this.ixCount;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\ddl\DdlGenContext.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */