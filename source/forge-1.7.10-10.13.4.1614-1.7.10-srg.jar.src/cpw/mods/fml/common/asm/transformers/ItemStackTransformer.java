/*    */ package cpw.mods.fml.common.asm.transformers;
/*    */ 
/*    */ import java.util.ListIterator;
/*    */ import net.minecraft.launchwrapper.IClassTransformer;
/*    */ import org.objectweb.asm.ClassReader;
/*    */ import org.objectweb.asm.ClassVisitor;
/*    */ import org.objectweb.asm.ClassWriter;
/*    */ import org.objectweb.asm.tree.AbstractInsnNode;
/*    */ import org.objectweb.asm.tree.ClassNode;
/*    */ import org.objectweb.asm.tree.FieldInsnNode;
/*    */ import org.objectweb.asm.tree.FieldNode;
/*    */ import org.objectweb.asm.tree.MethodInsnNode;
/*    */ import org.objectweb.asm.tree.MethodNode;
/*    */ 
/*    */ 
/*    */ public class ItemStackTransformer
/*    */   implements IClassTransformer
/*    */ {
/*    */   private static final String ITEM_TYPE = "Lnet/minecraft/item/Item;";
/*    */   private static final String GETITEM_DESC = "()Lnet/minecraft/item/Item;";
/*    */   
/*    */   public byte[] transform(String name, String transformedName, byte[] basicClass) {
/* 23 */     if (!"net.minecraft.item.ItemStack".equals(name))
/* 24 */       return basicClass; 
/* 25 */     ClassNode classNode = new ClassNode();
/* 26 */     ClassReader classReader = new ClassReader(basicClass);
/* 27 */     classReader.accept((ClassVisitor)classNode, 0);
/*    */     
/* 29 */     FieldNode itemField = null;
/* 30 */     for (FieldNode f : classNode.fields) {
/*    */       
/* 32 */       if ("Lnet/minecraft/item/Item;".equals(f.desc) && itemField == null) {
/*    */         
/* 34 */         itemField = f; continue;
/*    */       } 
/* 36 */       if ("Lnet/minecraft/item/Item;".equals(f.desc))
/*    */       {
/* 38 */         throw new RuntimeException("Error processing ItemStack - found a duplicate Item field");
/*    */       }
/*    */     } 
/* 41 */     if (itemField == null)
/*    */     {
/* 43 */       throw new RuntimeException("Error processing ItemStack - no Item field declared (is the code somehow obfuscated?)");
/*    */     }
/*    */     
/* 46 */     MethodNode getItemMethod = null;
/* 47 */     for (MethodNode m : classNode.methods) {
/*    */       
/* 49 */       if ("()Lnet/minecraft/item/Item;".equals(m.desc) && getItemMethod == null) {
/*    */         
/* 51 */         getItemMethod = m; continue;
/*    */       } 
/* 53 */       if ("()Lnet/minecraft/item/Item;".equals(m.desc))
/*    */       {
/* 55 */         throw new RuntimeException("Error processing ItemStack - duplicate getItem method found");
/*    */       }
/*    */     } 
/* 58 */     if (getItemMethod == null)
/*    */     {
/* 60 */       throw new RuntimeException("Error processing ItemStack - no getItem method found (is the code somehow obfuscated?)");
/*    */     }
/*    */     
/* 63 */     for (MethodNode m : classNode.methods) {
/*    */       
/* 65 */       for (ListIterator<AbstractInsnNode> it = m.instructions.iterator(); it.hasNext(); ) {
/*    */         
/* 67 */         AbstractInsnNode insnNode = it.next();
/* 68 */         if (insnNode.getType() == 4) {
/*    */           
/* 70 */           FieldInsnNode fi = (FieldInsnNode)insnNode;
/* 71 */           if (itemField.name.equals(fi.name) && fi.getOpcode() == 180) {
/*    */             
/* 73 */             it.remove();
/* 74 */             MethodInsnNode replace = new MethodInsnNode(182, "net/minecraft/item/ItemStack", getItemMethod.name, getItemMethod.desc, false);
/* 75 */             it.add(replace);
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/* 80 */     ClassWriter writer = new ClassWriter(1);
/* 81 */     classNode.accept((ClassVisitor)writer);
/* 82 */     return writer.toByteArray();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\asm\transformers\ItemStackTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */