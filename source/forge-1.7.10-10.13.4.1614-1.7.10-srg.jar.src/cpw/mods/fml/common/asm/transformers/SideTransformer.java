/*     */ package cpw.mods.fml.common.asm.transformers;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.FMLLaunchHandler;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.launchwrapper.IClassTransformer;
/*     */ import org.objectweb.asm.ClassReader;
/*     */ import org.objectweb.asm.ClassVisitor;
/*     */ import org.objectweb.asm.ClassWriter;
/*     */ import org.objectweb.asm.Type;
/*     */ import org.objectweb.asm.tree.AnnotationNode;
/*     */ import org.objectweb.asm.tree.ClassNode;
/*     */ import org.objectweb.asm.tree.FieldNode;
/*     */ import org.objectweb.asm.tree.MethodNode;
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
/*     */ public class SideTransformer
/*     */   implements IClassTransformer
/*     */ {
/*  33 */   private static String SIDE = FMLLaunchHandler.side().name();
/*     */   
/*     */   private static final boolean DEBUG = false;
/*     */   
/*     */   public byte[] transform(String name, String transformedName, byte[] bytes) {
/*  38 */     if (bytes == null) return null;
/*     */     
/*  40 */     ClassNode classNode = new ClassNode();
/*  41 */     ClassReader classReader = new ClassReader(bytes);
/*  42 */     classReader.accept((ClassVisitor)classNode, 0);
/*     */     
/*  44 */     if (remove(classNode.visibleAnnotations, SIDE))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  50 */       throw new RuntimeException(String.format("Attempted to load class %s for invalid side %s", new Object[] { classNode.name, SIDE }));
/*     */     }
/*     */     
/*  53 */     Iterator<FieldNode> fields = classNode.fields.iterator();
/*  54 */     while (fields.hasNext()) {
/*     */       
/*  56 */       FieldNode field = fields.next();
/*  57 */       if (remove(field.visibleAnnotations, SIDE))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  63 */         fields.remove();
/*     */       }
/*     */     } 
/*  66 */     Iterator<MethodNode> methods = classNode.methods.iterator();
/*  67 */     while (methods.hasNext()) {
/*     */       
/*  69 */       MethodNode method = methods.next();
/*  70 */       if (remove(method.visibleAnnotations, SIDE))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  76 */         methods.remove();
/*     */       }
/*     */     } 
/*     */     
/*  80 */     ClassWriter writer = new ClassWriter(1);
/*  81 */     classNode.accept((ClassVisitor)writer);
/*  82 */     return writer.toByteArray();
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean remove(List<AnnotationNode> anns, String side) {
/*  87 */     if (anns == null)
/*     */     {
/*  89 */       return false;
/*     */     }
/*  91 */     for (AnnotationNode ann : anns) {
/*     */       
/*  93 */       if (ann.desc.equals(Type.getDescriptor(SideOnly.class)))
/*     */       {
/*  95 */         if (ann.values != null)
/*     */         {
/*  97 */           for (int x = 0; x < ann.values.size() - 1; x += 2) {
/*     */             
/*  99 */             Object key = ann.values.get(x);
/* 100 */             Object value = ann.values.get(x + 1);
/* 101 */             if (key instanceof String && key.equals("value"))
/*     */             {
/* 103 */               if (value instanceof String[])
/*     */               {
/* 105 */                 if (!((String[])value)[1].equals(side))
/*     */                 {
/* 107 */                   return true;
/*     */                 }
/*     */               }
/*     */             }
/*     */           } 
/*     */         }
/*     */       }
/*     */     } 
/* 115 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\asm\transformers\SideTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */