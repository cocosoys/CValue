package cpw.mods.fml.common;

import org.objectweb.asm.tree.ClassNode;

public interface IASMHook {
  ClassNode[] inject(ClassNode paramClassNode);
  
  void modifyClass(String paramString, ClassNode paramClassNode);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\IASMHook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */