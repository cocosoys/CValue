/*     */ package cpw.mods.fml.common.asm.transformers;
/*     */ 
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import net.minecraft.launchwrapper.IClassTransformer;
/*     */ import org.objectweb.asm.ClassReader;
/*     */ import org.objectweb.asm.ClassVisitor;
/*     */ import org.objectweb.asm.ClassWriter;
/*     */ import org.objectweb.asm.Type;
/*     */ import org.objectweb.asm.tree.AbstractInsnNode;
/*     */ import org.objectweb.asm.tree.AnnotationNode;
/*     */ import org.objectweb.asm.tree.ClassNode;
/*     */ import org.objectweb.asm.tree.FieldInsnNode;
/*     */ import org.objectweb.asm.tree.FieldNode;
/*     */ import org.objectweb.asm.tree.FrameNode;
/*     */ import org.objectweb.asm.tree.InsnNode;
/*     */ import org.objectweb.asm.tree.JumpInsnNode;
/*     */ import org.objectweb.asm.tree.LabelNode;
/*     */ import org.objectweb.asm.tree.MethodInsnNode;
/*     */ import org.objectweb.asm.tree.MethodNode;
/*     */ import org.objectweb.asm.tree.TypeInsnNode;
/*     */ import org.objectweb.asm.tree.VarInsnNode;
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
/*     */ 
/*     */ 
/*     */ public class EventSubscriptionTransformer
/*     */   implements IClassTransformer
/*     */ {
/*     */   public byte[] transform(String name, String transformedName, byte[] bytes) {
/*  56 */     if (bytes == null || name.equals("cpw.mods.fml.common.eventhandler.Event") || name.startsWith("net.minecraft.") || name.indexOf('.') == -1)
/*     */     {
/*  58 */       return bytes;
/*     */     }
/*  60 */     ClassReader cr = new ClassReader(bytes);
/*  61 */     ClassNode classNode = new ClassNode();
/*  62 */     cr.accept((ClassVisitor)classNode, 0);
/*     */ 
/*     */     
/*     */     try {
/*  66 */       if (buildEvents(classNode)) {
/*     */         
/*  68 */         ClassWriter cw = new ClassWriter(2);
/*  69 */         classNode.accept((ClassVisitor)cw);
/*  70 */         return cw.toByteArray();
/*     */       } 
/*  72 */       return bytes;
/*     */     }
/*  74 */     catch (ClassNotFoundException classNotFoundException) {
/*     */ 
/*     */     
/*     */     }
/*  78 */     catch (Exception e) {
/*     */       
/*  80 */       e.printStackTrace();
/*     */     } 
/*     */     
/*  83 */     return bytes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean buildEvents(ClassNode classNode) throws Exception {
/*  90 */     Class<?> parent = getClass().getClassLoader().loadClass(classNode.superName.replace('/', '.'));
/*  91 */     if (!Event.class.isAssignableFrom(parent))
/*     */     {
/*  93 */       return false;
/*     */     }
/*     */ 
/*     */     
/*  97 */     Type tList = Type.getType("Lcpw/mods/fml/common/eventhandler/ListenerList;");
/*     */     
/*  99 */     boolean edited = false;
/* 100 */     boolean hasSetup = false;
/* 101 */     boolean hasGetListenerList = false;
/* 102 */     boolean hasDefaultCtr = false;
/* 103 */     boolean hasCancelable = false;
/* 104 */     boolean hasResult = false;
/* 105 */     String voidDesc = Type.getMethodDescriptor(Type.VOID_TYPE, new Type[0]);
/* 106 */     String boolDesc = Type.getMethodDescriptor(Type.BOOLEAN_TYPE, new Type[0]);
/* 107 */     String listDesc = tList.getDescriptor();
/* 108 */     String listDescM = Type.getMethodDescriptor(tList, new Type[0]);
/*     */     
/* 110 */     for (MethodNode methodNode : classNode.methods) {
/*     */       
/* 112 */       if (methodNode.name.equals("setup") && methodNode.desc.equals(voidDesc) && (methodNode.access & 0x4) == 4) hasSetup = true; 
/* 113 */       if ((methodNode.access & 0x1) == 1) {
/*     */         
/* 115 */         if (methodNode.name.equals("getListenerList") && methodNode.desc.equals(listDescM)) hasGetListenerList = true; 
/* 116 */         if (methodNode.name.equals("isCancelable") && methodNode.desc.equals(boolDesc)) hasCancelable = true; 
/* 117 */         if (methodNode.name.equals("hasResult") && methodNode.desc.equals(boolDesc)) hasResult = true; 
/*     */       } 
/* 119 */       if (methodNode.name.equals("<init>") && methodNode.desc.equals(voidDesc)) hasDefaultCtr = true;
/*     */     
/*     */     } 
/* 122 */     if (classNode.visibleAnnotations != null)
/*     */     {
/* 124 */       for (AnnotationNode node : classNode.visibleAnnotations) {
/*     */         
/* 126 */         if (!hasResult && node.desc.equals("Lcpw/mods/fml/common/eventhandler/Event$HasResult;")) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 134 */           MethodNode methodNode = new MethodNode(1, "hasResult", boolDesc, null, null);
/* 135 */           methodNode.instructions.add((AbstractInsnNode)new InsnNode(4));
/* 136 */           methodNode.instructions.add((AbstractInsnNode)new InsnNode(172));
/* 137 */           classNode.methods.add(methodNode);
/* 138 */           edited = true; continue;
/*     */         } 
/* 140 */         if (!hasCancelable && node.desc.equals("Lcpw/mods/fml/common/eventhandler/Cancelable;")) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 148 */           MethodNode methodNode = new MethodNode(1, "isCancelable", boolDesc, null, null);
/* 149 */           methodNode.instructions.add((AbstractInsnNode)new InsnNode(4));
/* 150 */           methodNode.instructions.add((AbstractInsnNode)new InsnNode(172));
/* 151 */           classNode.methods.add(methodNode);
/* 152 */           edited = true;
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 157 */     if (hasSetup) {
/*     */       
/* 159 */       if (!hasGetListenerList) {
/* 160 */         throw new RuntimeException("Event class defines setup() but does not define getListenerList! " + classNode.name);
/*     */       }
/* 162 */       return edited;
/*     */     } 
/*     */     
/* 165 */     Type tSuper = Type.getType(classNode.superName);
/*     */ 
/*     */     
/* 168 */     classNode.fields.add(new FieldNode(10, "LISTENER_LIST", listDesc, null, null));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 176 */     if (!hasDefaultCtr) {
/*     */       
/* 178 */       MethodNode methodNode = new MethodNode(1, "<init>", voidDesc, null, null);
/* 179 */       methodNode.instructions.add((AbstractInsnNode)new VarInsnNode(25, 0));
/* 180 */       methodNode.instructions.add((AbstractInsnNode)new MethodInsnNode(183, tSuper.getInternalName(), "<init>", voidDesc, false));
/* 181 */       methodNode.instructions.add((AbstractInsnNode)new InsnNode(177));
/* 182 */       classNode.methods.add(methodNode);
/*     */     } 
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
/* 196 */     MethodNode method = new MethodNode(4, "setup", voidDesc, null, null);
/* 197 */     method.instructions.add((AbstractInsnNode)new VarInsnNode(25, 0));
/* 198 */     method.instructions.add((AbstractInsnNode)new MethodInsnNode(183, tSuper.getInternalName(), "setup", voidDesc, false));
/* 199 */     method.instructions.add((AbstractInsnNode)new FieldInsnNode(178, classNode.name, "LISTENER_LIST", listDesc));
/* 200 */     LabelNode initLisitener = new LabelNode();
/* 201 */     method.instructions.add((AbstractInsnNode)new JumpInsnNode(198, initLisitener));
/* 202 */     method.instructions.add((AbstractInsnNode)new InsnNode(177));
/* 203 */     method.instructions.add((AbstractInsnNode)initLisitener);
/* 204 */     method.instructions.add((AbstractInsnNode)new FrameNode(3, 0, null, 0, null));
/* 205 */     method.instructions.add((AbstractInsnNode)new TypeInsnNode(187, tList.getInternalName()));
/* 206 */     method.instructions.add((AbstractInsnNode)new InsnNode(89));
/* 207 */     method.instructions.add((AbstractInsnNode)new VarInsnNode(25, 0));
/* 208 */     method.instructions.add((AbstractInsnNode)new MethodInsnNode(183, tSuper.getInternalName(), "getListenerList", listDescM, false));
/* 209 */     method.instructions.add((AbstractInsnNode)new MethodInsnNode(183, tList.getInternalName(), "<init>", Type.getMethodDescriptor(Type.VOID_TYPE, new Type[] { tList }), false));
/* 210 */     method.instructions.add((AbstractInsnNode)new FieldInsnNode(179, classNode.name, "LISTENER_LIST", listDesc));
/* 211 */     method.instructions.add((AbstractInsnNode)new InsnNode(177));
/* 212 */     classNode.methods.add(method);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 220 */     method = new MethodNode(1, "getListenerList", listDescM, null, null);
/* 221 */     method.instructions.add((AbstractInsnNode)new FieldInsnNode(178, classNode.name, "LISTENER_LIST", listDesc));
/* 222 */     method.instructions.add((AbstractInsnNode)new InsnNode(176));
/* 223 */     classNode.methods.add(method);
/* 224 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\asm\transformers\EventSubscriptionTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */