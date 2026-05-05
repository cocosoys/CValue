/*    */ package cpw.mods.fml.common.discovery.asm;
/*    */ 
/*    */ import org.objectweb.asm.AnnotationVisitor;
/*    */ import org.objectweb.asm.FieldVisitor;
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
/*    */ public class ModFieldVisitor
/*    */   extends FieldVisitor
/*    */ {
/*    */   private String fieldName;
/*    */   private ASMModParser discoverer;
/*    */   
/*    */   public ModFieldVisitor(String name, ASMModParser discoverer) {
/* 27 */     super(327680);
/* 28 */     this.fieldName = name;
/* 29 */     this.discoverer = discoverer;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public AnnotationVisitor visitAnnotation(String annotationName, boolean runtimeVisible) {
/* 35 */     this.discoverer.startFieldAnnotation(this.fieldName, annotationName);
/* 36 */     return new ModAnnotationVisitor(this.discoverer);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\discovery\asm\ModFieldVisitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */