/*    */ package org.yaml.snakeyaml.extensions.compactnotation;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
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
/*    */ public class CompactData
/*    */ {
/*    */   private String prefix;
/* 26 */   private List<String> arguments = new ArrayList<String>();
/* 27 */   private Map<String, String> properties = new HashMap<String, String>();
/*    */   
/*    */   public CompactData(String prefix) {
/* 30 */     this.prefix = prefix;
/*    */   }
/*    */   
/*    */   public String getPrefix() {
/* 34 */     return this.prefix;
/*    */   }
/*    */   
/*    */   public Map<String, String> getProperties() {
/* 38 */     return this.properties;
/*    */   }
/*    */   
/*    */   public List<String> getArguments() {
/* 42 */     return this.arguments;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 47 */     return "CompactData: " + this.prefix + " " + this.properties;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\extensions\compactnotation\CompactData.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */