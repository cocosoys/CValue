/*    */ package cpw.mods.fml.common.asm.transformers.deobf;
/*    */ 
/*    */ import org.objectweb.asm.ClassVisitor;
/*    */ import org.objectweb.asm.MethodVisitor;
/*    */ import org.objectweb.asm.commons.Remapper;
/*    */ import org.objectweb.asm.commons.RemappingClassAdapter;
/*    */ import org.objectweb.asm.commons.RemappingMethodAdapter;
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
/*    */ public class FMLRemappingAdapter
/*    */   extends RemappingClassAdapter
/*    */ {
/*    */   public FMLRemappingAdapter(ClassVisitor cv) {
/* 25 */     super(cv, FMLDeobfuscatingRemapper.INSTANCE);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
/* 31 */     if (interfaces == null)
/*    */     {
/* 33 */       interfaces = new String[0];
/*    */     }
/* 35 */     FMLDeobfuscatingRemapper.INSTANCE.mergeSuperMaps(name, superName, interfaces);
/* 36 */     super.visit(version, access, name, signature, superName, interfaces);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected MethodVisitor createRemappingMethodAdapter(int access, String newDesc, MethodVisitor mv) {
/* 42 */     return (MethodVisitor)new StaticFixingMethodVisitor(access, newDesc, mv, this.remapper);
/*    */   }
/*    */ 
/*    */   
/*    */   private static class StaticFixingMethodVisitor
/*    */     extends RemappingMethodAdapter
/*    */   {
/*    */     public StaticFixingMethodVisitor(int access, String desc, MethodVisitor mv, Remapper remapper) {
/* 50 */       super(access, desc, mv, remapper);
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public void visitFieldInsn(int opcode, String originalType, String originalName, String desc) {
/* 58 */       String type = this.remapper.mapType(originalType);
/* 59 */       String fieldName = this.remapper.mapFieldName(originalType, originalName, desc);
/* 60 */       String newDesc = this.remapper.mapDesc(desc);
/* 61 */       if (opcode == 178 && type.startsWith("net/minecraft/") && newDesc.startsWith("Lnet/minecraft/")) {
/*    */         
/* 63 */         String replDesc = FMLDeobfuscatingRemapper.INSTANCE.getStaticFieldType(originalType, originalName, type, fieldName);
/* 64 */         if (replDesc != null)
/*    */         {
/* 66 */           newDesc = this.remapper.mapDesc(replDesc);
/*    */         }
/*    */       } 
/*    */       
/* 70 */       if (this.mv != null)
/* 71 */         this.mv.visitFieldInsn(opcode, type, fieldName, newDesc); 
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\asm\transformers\deobf\FMLRemappingAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */