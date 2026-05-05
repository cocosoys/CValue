package cpw.mods.fml.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Mod {
  String modid();
  
  String name() default "";
  
  String version() default "";
  
  String dependencies() default "";
  
  boolean useMetadata() default false;
  
  String acceptedMinecraftVersions() default "";
  
  String acceptableRemoteVersions() default "";
  
  String acceptableSaveVersions() default "";
  
  String bukkitPlugin() default "";
  
  String certificateFingerprint() default "";
  
  String modLanguage() default "java";
  
  String modLanguageAdapter() default "";
  
  @Deprecated
  String asmHookClass() default "";
  
  boolean canBeDeactivated() default false;
  
  String guiFactory() default "";
  
  CustomProperty[] customProperties() default {};
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.METHOD})
  public static @interface InstanceFactory {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.FIELD})
  public static @interface Metadata {
    String value() default "";
  }
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.FIELD})
  public static @interface Instance {
    String value() default "";
  }
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.METHOD})
  public static @interface EventHandler {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({})
  public static @interface CustomProperty {
    String k();
    
    String v();
  }
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\Mod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */