package cpw.mods.fml.client.config;

import java.util.List;
import java.util.regex.Pattern;

public interface IConfigElement<T> {
  boolean isProperty();
  
  Class<? extends GuiConfigEntries.IConfigEntry> getConfigEntryClass();
  
  Class<? extends GuiEditArrayEntries.IArrayEntry> getArrayEntryClass();
  
  String getName();
  
  String getQualifiedName();
  
  String getLanguageKey();
  
  String getComment();
  
  List<IConfigElement> getChildElements();
  
  ConfigGuiType getType();
  
  boolean isList();
  
  boolean isListLengthFixed();
  
  int getMaxListLength();
  
  boolean isDefault();
  
  Object getDefault();
  
  Object[] getDefaults();
  
  void setToDefault();
  
  boolean requiresWorldRestart();
  
  boolean showInGui();
  
  boolean requiresMcRestart();
  
  Object get();
  
  Object[] getList();
  
  void set(T paramT);
  
  void set(T[] paramArrayOfT);
  
  String[] getValidValues();
  
  T getMinValue();
  
  T getMaxValue();
  
  Pattern getValidationPattern();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\config\IConfigElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */