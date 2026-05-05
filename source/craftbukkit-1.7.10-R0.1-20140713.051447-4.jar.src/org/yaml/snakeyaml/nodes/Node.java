/*     */ package org.yaml.snakeyaml.nodes;
/*     */ 
/*     */ import org.yaml.snakeyaml.error.Mark;
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
/*     */ public abstract class Node
/*     */ {
/*     */   private Tag tag;
/*     */   private Mark startMark;
/*     */   protected Mark endMark;
/*     */   private Class<? extends Object> type;
/*     */   private boolean twoStepsConstruction;
/*     */   protected boolean resolved;
/*     */   protected Boolean useClassConstructor;
/*     */   
/*     */   public Node(Tag tag, Mark startMark, Mark endMark) {
/*  47 */     setTag(tag);
/*  48 */     this.startMark = startMark;
/*  49 */     this.endMark = endMark;
/*  50 */     this.type = Object.class;
/*  51 */     this.twoStepsConstruction = false;
/*  52 */     this.resolved = true;
/*  53 */     this.useClassConstructor = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Tag getTag() {
/*  64 */     return this.tag;
/*     */   }
/*     */   
/*     */   public Mark getEndMark() {
/*  68 */     return this.endMark;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract NodeId getNodeId();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Mark getStartMark() {
/*  80 */     return this.startMark;
/*     */   }
/*     */   
/*     */   public void setTag(Tag tag) {
/*  84 */     if (tag == null) {
/*  85 */       throw new NullPointerException("tag in a Node is required.");
/*     */     }
/*  87 */     this.tag = tag;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean equals(Object obj) {
/*  95 */     return super.equals(obj);
/*     */   }
/*     */   
/*     */   public Class<? extends Object> getType() {
/*  99 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(Class<? extends Object> type) {
/* 103 */     if (!type.isAssignableFrom(this.type)) {
/* 104 */       this.type = type;
/*     */     }
/*     */   }
/*     */   
/*     */   public void setTwoStepsConstruction(boolean twoStepsConstruction) {
/* 109 */     this.twoStepsConstruction = twoStepsConstruction;
/*     */   }
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
/*     */   public boolean isTwoStepsConstruction() {
/* 130 */     return this.twoStepsConstruction;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 135 */     return super.hashCode();
/*     */   }
/*     */   
/*     */   public boolean useClassConstructor() {
/* 139 */     if (this.useClassConstructor == null) {
/* 140 */       if (isResolved() && !Object.class.equals(this.type) && !this.tag.equals(Tag.NULL))
/* 141 */         return true; 
/* 142 */       if (this.tag.isCompatible(getType()))
/*     */       {
/*     */         
/* 145 */         return true;
/*     */       }
/* 147 */       return false;
/*     */     } 
/*     */     
/* 150 */     return this.useClassConstructor.booleanValue();
/*     */   }
/*     */   
/*     */   public void setUseClassConstructor(Boolean useClassConstructor) {
/* 154 */     this.useClassConstructor = useClassConstructor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isResolved() {
/* 164 */     return this.resolved;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\nodes\Node.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */