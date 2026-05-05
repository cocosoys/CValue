/*    */ package org.yaml.snakeyaml.resolver;
/*    */ 
/*    */ import java.util.regex.Pattern;
/*    */ import org.yaml.snakeyaml.nodes.Tag;
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
/*    */ final class ResolverTuple
/*    */ {
/*    */   private final Tag tag;
/*    */   private final Pattern regexp;
/*    */   
/*    */   public ResolverTuple(Tag tag, Pattern regexp) {
/* 28 */     this.tag = tag;
/* 29 */     this.regexp = regexp;
/*    */   }
/*    */   
/*    */   public Tag getTag() {
/* 33 */     return this.tag;
/*    */   }
/*    */   
/*    */   public Pattern getRegexp() {
/* 37 */     return this.regexp;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 42 */     return "Tuple tag=" + this.tag + " regexp=" + this.regexp;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\resolver\ResolverTuple.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */