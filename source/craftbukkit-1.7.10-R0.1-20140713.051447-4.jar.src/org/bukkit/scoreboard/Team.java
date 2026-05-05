package org.bukkit.scoreboard;

import java.util.Set;
import org.bukkit.OfflinePlayer;

public interface Team {
  String getName() throws IllegalStateException;
  
  String getDisplayName() throws IllegalStateException;
  
  void setDisplayName(String paramString) throws IllegalStateException, IllegalArgumentException;
  
  String getPrefix() throws IllegalStateException;
  
  void setPrefix(String paramString) throws IllegalStateException, IllegalArgumentException;
  
  String getSuffix() throws IllegalStateException;
  
  void setSuffix(String paramString) throws IllegalStateException, IllegalArgumentException;
  
  boolean allowFriendlyFire() throws IllegalStateException;
  
  void setAllowFriendlyFire(boolean paramBoolean) throws IllegalStateException;
  
  boolean canSeeFriendlyInvisibles() throws IllegalStateException;
  
  void setCanSeeFriendlyInvisibles(boolean paramBoolean) throws IllegalStateException;
  
  Set<OfflinePlayer> getPlayers() throws IllegalStateException;
  
  int getSize() throws IllegalStateException;
  
  Scoreboard getScoreboard();
  
  void addPlayer(OfflinePlayer paramOfflinePlayer) throws IllegalStateException, IllegalArgumentException;
  
  boolean removePlayer(OfflinePlayer paramOfflinePlayer) throws IllegalStateException, IllegalArgumentException;
  
  void unregister() throws IllegalStateException;
  
  boolean hasPlayer(OfflinePlayer paramOfflinePlayer) throws IllegalArgumentException, IllegalStateException;
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\scoreboard\Team.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */