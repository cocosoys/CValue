/*    */ package cpw.mods.fml.common.discovery.asm;
/*    */ 
/*    */ import org.objectweb.asm.AnnotationVisitor;
/*    */ import org.objectweb.asm.ClassVisitor;
/*    */ import org.objectweb.asm.FieldVisitor;
/*    */ import org.objectweb.asm.MethodVisitor;
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
/*    */ public class ModClassVisitor
/*    */   extends ClassVisitor
/*    */ {
/*    */   private ASMModParser discoverer;
/*    */   
/*    */   public ModClassVisitor(ASMModParser discoverer) {
/* 27 */     super(327680);
/* 28 */     this.discoverer = discoverer;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
/* 35 */     this.discoverer.beginNewTypeName(name, version, superName);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public AnnotationVisitor visitAnnotation(String annotationName, boolean runtimeVisible) {
/* 41 */     this.discoverer.startClassAnnotation(annotationName);
/* 42 */     return new ModAnnotationVisitor(this.discoverer);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
/* 49 */     return new ModFieldVisitor(name, this.discoverer);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
/* 55 */     return new ModMethodVisitor(name, desc, this.discoverer);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\discovery\asm\ModClassVisitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */