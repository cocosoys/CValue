package cpw.mods.fml.relauncher;

import java.util.Map;
import java.util.concurrent.Callable;

public interface IFMLCallHook extends Callable<Void> {
  void injectData(Map<String, Object> paramMap);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\relauncher\IFMLCallHook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */