/*    */ package org.yaml.snakeyaml.error;
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
/*    */ public class MarkedYAMLException
/*    */   extends YAMLException
/*    */ {
/*    */   private static final long serialVersionUID = -9119388488683035101L;
/*    */   private String context;
/*    */   private Mark contextMark;
/*    */   private String problem;
/*    */   private Mark problemMark;
/*    */   private String note;
/*    */   
/*    */   protected MarkedYAMLException(String context, Mark contextMark, String problem, Mark problemMark, String note) {
/* 30 */     this(context, contextMark, problem, problemMark, note, null);
/*    */   }
/*    */ 
/*    */   
/*    */   protected MarkedYAMLException(String context, Mark contextMark, String problem, Mark problemMark, String note, Throwable cause) {
/* 35 */     super(context + "; " + problem, cause);
/* 36 */     this.context = context;
/* 37 */     this.contextMark = contextMark;
/* 38 */     this.problem = problem;
/* 39 */     this.problemMark = problemMark;
/* 40 */     this.note = note;
/*    */   }
/*    */   
/*    */   protected MarkedYAMLException(String context, Mark contextMark, String problem, Mark problemMark) {
/* 44 */     this(context, contextMark, problem, problemMark, null, null);
/*    */   }
/*    */ 
/*    */   
/*    */   protected MarkedYAMLException(String context, Mark contextMark, String problem, Mark problemMark, Throwable cause) {
/* 49 */     this(context, contextMark, problem, problemMark, null, cause);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 54 */     StringBuilder lines = new StringBuilder();
/* 55 */     if (this.context != null) {
/* 56 */       lines.append(this.context);
/* 57 */       lines.append("\n");
/*    */     } 
/* 59 */     if (this.contextMark != null && (this.problem == null || this.problemMark == null || this.contextMark.getName() != this.problemMark.getName() || this.contextMark.getLine() != this.problemMark.getLine() || this.contextMark.getColumn() != this.problemMark.getColumn())) {
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 64 */       lines.append(this.contextMark.toString());
/* 65 */       lines.append("\n");
/*    */     } 
/* 67 */     if (this.problem != null) {
/* 68 */       lines.append(this.problem);
/* 69 */       lines.append("\n");
/*    */     } 
/* 71 */     if (this.problemMark != null) {
/* 72 */       lines.append(this.problemMark.toString());
/* 73 */       lines.append("\n");
/*    */     } 
/* 75 */     if (this.note != null) {
/* 76 */       lines.append(this.note);
/* 77 */       lines.append("\n");
/*    */     } 
/* 79 */     return lines.toString();
/*    */   }
/*    */   
/*    */   public String getContext() {
/* 83 */     return this.context;
/*    */   }
/*    */   
/*    */   public Mark getContextMark() {
/* 87 */     return this.contextMark;
/*    */   }
/*    */   
/*    */   public String getProblem() {
/* 91 */     return this.problem;
/*    */   }
/*    */   
/*    */   public Mark getProblemMark() {
/* 95 */     return this.problemMark;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\error\MarkedYAMLException.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */