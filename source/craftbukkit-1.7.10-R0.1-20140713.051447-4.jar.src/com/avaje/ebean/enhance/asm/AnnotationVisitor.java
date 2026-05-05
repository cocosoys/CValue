package com.avaje.ebean.enhance.asm;

public interface AnnotationVisitor {
  void visit(String paramString, Object paramObject);
  
  void visitEnum(String paramString1, String paramString2, String paramString3);
  
  AnnotationVisitor visitAnnotation(String paramString1, String paramString2);
  
  AnnotationVisitor visitArray(String paramString);
  
  void visitEnd();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\enhance\asm\AnnotationVisitor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */