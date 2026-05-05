/*    */ package cpw.mods.fml.common.asm.transformers;
/*    */ 
/*    */ import cpw.mods.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;
/*    */ import cpw.mods.fml.common.asm.transformers.deobf.FMLRemappingAdapter;
/*    */ import net.minecraft.launchwrapper.IClassNameTransformer;
/*    */ import net.minecraft.launchwrapper.IClassTransformer;
/*    */ import org.objectweb.asm.ClassReader;
/*    */ import org.objectweb.asm.ClassVisitor;
/*    */ import org.objectweb.asm.ClassWriter;
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
/*    */ 
/*    */ public class DeobfuscationTransformer
/*    */   implements IClassTransformer, IClassNameTransformer
/*    */ {
/*    */   public byte[] transform(String name, String transformedName, byte[] bytes) {
/* 30 */     if (bytes == null)
/*    */     {
/* 32 */       return null;
/*    */     }
/* 34 */     ClassReader classReader = new ClassReader(bytes);
/* 35 */     ClassWriter classWriter = new ClassWriter(1);
/* 36 */     FMLRemappingAdapter fMLRemappingAdapter = new FMLRemappingAdapter((ClassVisitor)classWriter);
/* 37 */     classReader.accept((ClassVisitor)fMLRemappingAdapter, 8);
/* 38 */     return classWriter.toByteArray();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String remapClassName(String name) {
/* 44 */     return FMLDeobfuscatingRemapper.INSTANCE.map(name.replace('.', '/')).replace('/', '.');
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String unmapClassName(String name) {
/* 50 */     return FMLDeobfuscatingRemapper.INSTANCE.unmap(name.replace('.', '/')).replace('/', '.');
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\asm\transformers\DeobfuscationTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */