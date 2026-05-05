package org.bukkit;

import java.util.Date;

public interface BanEntry {
  String getTarget();
  
  Date getCreated();
  
  void setCreated(Date paramDate);
  
  String getSource();
  
  void setSource(String paramString);
  
  Date getExpiration();
  
  void setExpiration(Date paramDate);
  
  String getReason();
  
  void setReason(String paramString);
  
  void save();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\BanEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */