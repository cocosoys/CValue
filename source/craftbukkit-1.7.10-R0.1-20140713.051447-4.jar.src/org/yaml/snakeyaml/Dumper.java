/*    */ package org.yaml.snakeyaml;
/*    */ 
/*    */ import org.yaml.snakeyaml.representer.Representer;
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
/*    */ public final class Dumper
/*    */ {
/*    */   protected final Representer representer;
/*    */   protected final DumperOptions options;
/*    */   
/*    */   public Dumper(Representer representer, DumperOptions options) {
/* 29 */     this.representer = representer;
/* 30 */     this.options = options;
/*    */   }
/*    */   
/*    */   public Dumper(DumperOptions options) {
/* 34 */     this(new Representer(), options);
/*    */   }
/*    */   
/*    */   public Dumper(Representer representer) {
/* 38 */     this(representer, new DumperOptions());
/*    */   }
/*    */   
/*    */   public Dumper() {
/* 42 */     this(new Representer(), new DumperOptions());
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\Dumper.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */