/*    */ package net.minecraftforge.classloading;
/*    */ 
/*    */ import cpw.mods.fml.common.FMLLog;
/*    */ import java.util.ListIterator;
/*    */ import net.minecraft.launchwrapper.IClassTransformer;
/*    */ import org.objectweb.asm.ClassReader;
/*    */ import org.objectweb.asm.ClassVisitor;
/*    */ import org.objectweb.asm.ClassWriter;
/*    */ import org.objectweb.asm.tree.AbstractInsnNode;
/*    */ import org.objectweb.asm.tree.ClassNode;
/*    */ import org.objectweb.asm.tree.FieldInsnNode;
/*    */ import org.objectweb.asm.tree.MethodInsnNode;
/*    */ import org.objectweb.asm.tree.MethodNode;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FluidIdTransformer
/*    */   implements IClassTransformer
/*    */ {
/*    */   private static final String FLUID_TYPE = "net/minecraftforge/fluids/FluidStack";
/*    */   private static final String GETID_NAME = "getFluidID";
/*    */   private static final String LEGACY_FIELDNAME = "fluidID";
/*    */   private static final String GETID_DESC = "()I";
/*    */   
/*    */   public byte[] transform(String name, String transformedName, byte[] basicClass) {
/* 27 */     if (basicClass == null)
/* 28 */       return null; 
/* 29 */     ClassNode classNode = new ClassNode();
/* 30 */     ClassReader classReader = new ClassReader(basicClass);
/* 31 */     classReader.accept((ClassVisitor)classNode, 0);
/*    */     
/* 33 */     for (MethodNode m : classNode.methods) {
/*    */       
/* 35 */       for (ListIterator<AbstractInsnNode> it = m.instructions.iterator(); it.hasNext(); ) {
/*    */         
/* 37 */         AbstractInsnNode insnNode = it.next();
/* 38 */         if (insnNode.getType() == 4) {
/*    */           
/* 40 */           FieldInsnNode fi = (FieldInsnNode)insnNode;
/* 41 */           if ("net/minecraftforge/fluids/FluidStack".equals(fi.owner) && "fluidID".equals(fi.name) && fi.getOpcode() == 180) {
/*    */             
/* 43 */             FMLLog.fine("Method %s.%s%s: Replacing GETFIELD fluidID with INVOKEVIRTUAL getFluidID", new Object[] { name, m.name, m.desc });
/* 44 */             it.remove();
/* 45 */             MethodInsnNode replace = new MethodInsnNode(182, "net/minecraftforge/fluids/FluidStack", "getFluidID", "()I", false);
/* 46 */             it.add(replace);
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/* 51 */     ClassWriter writer = new ClassWriter(1);
/* 52 */     classNode.accept((ClassVisitor)writer);
/* 53 */     return writer.toByteArray();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\classloading\FluidIdTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */