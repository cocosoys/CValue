package cpw.mods.fml.relauncher;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

public interface IFMLLoadingPlugin {
  String[] getASMTransformerClass();
  
  String getModContainerClass();
  
  String getSetupClass();
  
  void injectData(Map<String, Object> paramMap);
  
  String getAccessTransformerClass();
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.TYPE})
  public static @interface SortingIndex {
    int value() default 0;
  }
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.TYPE})
  public static @interface DependsOn {
    String[] value() default {};
  }
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.TYPE})
  public static @interface Name {
    String value() default "";
  }
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.TYPE})
  public static @interface MCVersion {
    String value() default "";
  }
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.TYPE})
  public static @interface TransformerExclusions {
    String[] value() default {""};
  }
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\relauncher\IFMLLoadingPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */