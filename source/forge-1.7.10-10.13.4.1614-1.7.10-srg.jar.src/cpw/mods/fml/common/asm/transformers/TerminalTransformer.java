/*     */ package cpw.mods.fml.common.asm.transformers;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.FMLRelaunchLog;
/*     */ import cpw.mods.fml.relauncher.FMLSecurityManager;
/*     */ import net.minecraft.launchwrapper.IClassTransformer;
/*     */ import org.objectweb.asm.ClassReader;
/*     */ import org.objectweb.asm.ClassVisitor;
/*     */ import org.objectweb.asm.ClassWriter;
/*     */ import org.objectweb.asm.MethodVisitor;
/*     */ import org.objectweb.asm.Type;
/*     */ 
/*     */ public class TerminalTransformer implements IClassTransformer {
/*     */   public byte[] transform(String name, String transformedName, byte[] basicClass) {
/*  14 */     if (basicClass == null) return null; 
/*  15 */     ClassReader reader = new ClassReader(basicClass);
/*  16 */     ClassWriter writer = new ClassWriter(1);
/*     */     
/*  18 */     ClassWriter classWriter1 = writer;
/*  19 */     ExitVisitor exitVisitor = new ExitVisitor((ClassVisitor)classWriter1);
/*     */     
/*  21 */     reader.accept(exitVisitor, 0);
/*  22 */     return writer.toByteArray();
/*     */   }
/*     */   
/*     */   public static class ExitVisitor
/*     */     extends ClassVisitor {
/*  27 */     private String clsName = null;
/*  28 */     private static final String callbackOwner = Type.getInternalName(ExitVisitor.class);
/*     */ 
/*     */     
/*     */     private ExitVisitor(ClassVisitor cv) {
/*  32 */       super(327680, cv);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
/*  38 */       super.visit(version, access, name, signature, superName, interfaces);
/*  39 */       this.clsName = name;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public MethodVisitor visitMethod(int mAccess, final String mName, final String mDesc, String mSignature, String[] mExceptions) {
/*  49 */       final boolean warn = (!this.clsName.equals("net/minecraft/client/Minecraft") && !this.clsName.equals("net/minecraft/server/dedicated/DedicatedServer") && !this.clsName.equals("cpw/mods/fml/common/FMLCommonHandler") && !this.clsName.startsWith("com/jcraft/jogg/") && !this.clsName.startsWith("scala/sys/"));
/*     */ 
/*     */       
/*  52 */       return new MethodVisitor(327680, super.visitMethod(mAccess, mName, mDesc, mSignature, mExceptions))
/*     */         {
/*     */           
/*     */           public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean isIntf)
/*     */           {
/*  57 */             if (opcode == 184 && owner.equals("java/lang/System") && name.equals("exit") && desc.equals("(I)V")) {
/*     */               
/*  59 */               if (warn) {
/*     */                 
/*  61 */                 FMLRelaunchLog.warning("=============================================================", new Object[0]);
/*  62 */                 FMLRelaunchLog.warning("MOD HAS DIRECT REFERENCE System.exit() THIS IS NOT ALLOWED REROUTING TO FML!", new Object[0]);
/*  63 */                 FMLRelaunchLog.warning("Offendor: %s.%s%s", new Object[] { TerminalTransformer.ExitVisitor.access$100(this.this$0), this.val$mName, this.val$mDesc });
/*  64 */                 FMLRelaunchLog.warning("Use FMLCommonHandler.exitJava instead", new Object[0]);
/*  65 */                 FMLRelaunchLog.warning("=============================================================", new Object[0]);
/*     */               } 
/*  67 */               owner = TerminalTransformer.ExitVisitor.callbackOwner;
/*  68 */               name = "systemExitCalled";
/*     */             }
/*  70 */             else if (opcode == 182 && owner.equals("java/lang/Runtime") && name.equals("exit") && desc.equals("(I)V")) {
/*     */               
/*  72 */               if (warn) {
/*     */                 
/*  74 */                 FMLRelaunchLog.warning("=============================================================", new Object[0]);
/*  75 */                 FMLRelaunchLog.warning("MOD HAS DIRECT REFERENCE Runtime.exit() THIS IS NOT ALLOWED REROUTING TO FML!", new Object[0]);
/*  76 */                 FMLRelaunchLog.warning("Offendor: %s.%s%s", new Object[] { TerminalTransformer.ExitVisitor.access$100(this.this$0), this.val$mName, this.val$mDesc });
/*  77 */                 FMLRelaunchLog.warning("Use FMLCommonHandler.exitJava instead", new Object[0]);
/*  78 */                 FMLRelaunchLog.warning("=============================================================", new Object[0]);
/*     */               } 
/*  80 */               opcode = 184;
/*  81 */               owner = TerminalTransformer.ExitVisitor.callbackOwner;
/*  82 */               name = "runtimeExitCalled";
/*  83 */               desc = "(Ljava/lang/Runtime;I)V";
/*     */             }
/*  85 */             else if (opcode == 182 && owner.equals("java/lang/Runtime") && name.equals("halt") && desc.equals("(I)V")) {
/*     */               
/*  87 */               if (warn) {
/*     */                 
/*  89 */                 FMLRelaunchLog.warning("=============================================================", new Object[0]);
/*  90 */                 FMLRelaunchLog.warning("MOD HAS DIRECT REFERENCE Runtime.halt() THIS IS NOT ALLOWED REROUTING TO FML!", new Object[0]);
/*  91 */                 FMLRelaunchLog.warning("Offendor: %s.%s%s", new Object[] { TerminalTransformer.ExitVisitor.access$100(this.this$0), this.val$mName, this.val$mDesc });
/*  92 */                 FMLRelaunchLog.warning("Use FMLCommonHandler.exitJava instead", new Object[0]);
/*  93 */                 FMLRelaunchLog.warning("=============================================================", new Object[0]);
/*     */               } 
/*  95 */               opcode = 184;
/*  96 */               owner = TerminalTransformer.ExitVisitor.callbackOwner;
/*  97 */               name = "runtimeHaltCalled";
/*  98 */               desc = "(Ljava/lang/Runtime;I)V";
/*     */             } 
/*     */             
/* 101 */             super.visitMethodInsn(opcode, owner, name, desc, isIntf);
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static void systemExitCalled(int status) {
/* 109 */       checkAccess();
/* 110 */       System.exit(status);
/*     */     }
/*     */ 
/*     */     
/*     */     public static void runtimeExitCalled(Runtime runtime, int status) {
/* 115 */       checkAccess();
/* 116 */       runtime.exit(status);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static void runtimeHaltCalled(Runtime runtime, int status) {
/* 122 */       checkAccess();
/* 123 */       runtime.halt(status);
/*     */     }
/*     */ 
/*     */     
/*     */     private static void checkAccess() {
/* 128 */       StackTraceElement[] cause = Thread.currentThread().getStackTrace();
/*     */       
/* 130 */       String callingClass = (cause.length > 2) ? cause[3].getClassName() : "none";
/* 131 */       String callingParent = (cause.length > 3) ? cause[4].getClassName() : "none";
/*     */       
/* 133 */       if (!callingClass.startsWith("cpw.mods.fml.") && (
/* 134 */         !"net.minecraft.client.Minecraft".equals(callingClass) || !"net.minecraft.client.Minecraft".equals(callingParent)) && (
/* 135 */         !"net.minecraft.server.dedicated.DedicatedServer".equals(callingClass) || !"net.minecraft.server.MinecraftServer".equals(callingParent)))
/*     */       {
/*     */         
/* 138 */         throw new FMLSecurityManager.ExitTrappedException();
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\asm\transformers\TerminalTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */