/*    */ package cpw.mods.fml.common.discovery.asm;
/*    */ 
/*    */ import org.objectweb.asm.AnnotationVisitor;
/*    */ import org.objectweb.asm.MethodVisitor;
/*    */ 
/*    */ 
/*    */ public class ModMethodVisitor
/*    */   extends MethodVisitor
/*    */ {
/*    */   private String methodName;
/*    */   private String methodDescriptor;
/*    */   private ASMModParser discoverer;
/*    */   
/*    */   public ModMethodVisitor(String name, String desc, ASMModParser discoverer) {
/* 15 */     super(327680);
/* 16 */     this.methodName = name;
/* 17 */     this.methodDescriptor = desc;
/* 18 */     this.discoverer = discoverer;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public AnnotationVisitor visitAnnotation(String annotationName, boolean runtimeVisible) {
/* 24 */     this.discoverer.startMethodAnnotation(this.methodName, this.methodDescriptor, annotationName);
/* 25 */     return new ModAnnotationVisitor(this.discoverer);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\discovery\asm\ModMethodVisitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */