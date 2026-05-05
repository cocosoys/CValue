package org.bukkit.scoreboard;

import org.bukkit.OfflinePlayer;

public interface Score {
  @Deprecated
  OfflinePlayer getPlayer();
  
  String getEntry();
  
  Objective getObjective();
  
  int getScore() throws IllegalStateException;
  
  void setScore(int paramInt) throws IllegalStateException;
  
  Scoreboard getScoreboard();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\scoreboard\Score.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */