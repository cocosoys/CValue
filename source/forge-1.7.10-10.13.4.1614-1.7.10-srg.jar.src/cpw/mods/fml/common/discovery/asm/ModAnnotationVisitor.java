/*    */ package cpw.mods.fml.common.discovery.asm;
/*    */ 
/*    */ import org.objectweb.asm.AnnotationVisitor;
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
/*    */ public class ModAnnotationVisitor
/*    */   extends AnnotationVisitor
/*    */ {
/*    */   private ASMModParser discoverer;
/*    */   private boolean array;
/*    */   private String name;
/*    */   private boolean isSubAnnotation;
/*    */   
/*    */   public ModAnnotationVisitor(ASMModParser discoverer) {
/* 28 */     super(327680);
/* 29 */     this.discoverer = discoverer;
/*    */   }
/*    */ 
/*    */   
/*    */   public ModAnnotationVisitor(ASMModParser discoverer, String name) {
/* 34 */     this(discoverer);
/* 35 */     this.array = true;
/* 36 */     this.name = name;
/* 37 */     discoverer.addAnnotationArray(name);
/*    */   }
/*    */ 
/*    */   
/*    */   public ModAnnotationVisitor(ASMModParser discoverer, boolean isSubAnnotation) {
/* 42 */     this(discoverer);
/* 43 */     this.isSubAnnotation = true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void visit(String key, Object value) {
/* 49 */     this.discoverer.addAnnotationProperty(key, value);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void visitEnum(String name, String desc, String value) {
/* 55 */     this.discoverer.addAnnotationEnumProperty(name, desc, value);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public AnnotationVisitor visitArray(String name) {
/* 61 */     return new ModAnnotationVisitor(this.discoverer, name);
/*    */   }
/*    */ 
/*    */   
/*    */   public AnnotationVisitor visitAnnotation(String name, String desc) {
/* 66 */     this.discoverer.addSubAnnotation(name, desc);
/* 67 */     return new ModAnnotationVisitor(this.discoverer, true);
/*    */   }
/*    */ 
/*    */   
/*    */   public void visitEnd() {
/* 72 */     if (this.array)
/*    */     {
/* 74 */       this.discoverer.endArray();
/*    */     }
/*    */     
/* 77 */     if (this.isSubAnnotation)
/*    */     {
/* 79 */       this.discoverer.endSubAnnotation();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\discovery\asm\ModAnnotationVisitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */