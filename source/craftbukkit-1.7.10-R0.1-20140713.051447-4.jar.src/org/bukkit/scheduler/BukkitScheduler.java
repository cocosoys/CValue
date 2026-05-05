package org.bukkit.scheduler;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.bukkit.plugin.Plugin;

public interface BukkitScheduler {
  int scheduleSyncDelayedTask(Plugin paramPlugin, Runnable paramRunnable, long paramLong);
  
  int scheduleSyncDelayedTask(Plugin paramPlugin, Runnable paramRunnable);
  
  int scheduleSyncRepeatingTask(Plugin paramPlugin, Runnable paramRunnable, long paramLong1, long paramLong2);
  
  @Deprecated
  int scheduleAsyncDelayedTask(Plugin paramPlugin, Runnable paramRunnable, long paramLong);
  
  @Deprecated
  int scheduleAsyncDelayedTask(Plugin paramPlugin, Runnable paramRunnable);
  
  @Deprecated
  int scheduleAsyncRepeatingTask(Plugin paramPlugin, Runnable paramRunnable, long paramLong1, long paramLong2);
  
  <T> Future<T> callSyncMethod(Plugin paramPlugin, Callable<T> paramCallable);
  
  void cancelTask(int paramInt);
  
  void cancelTasks(Plugin paramPlugin);
  
  void cancelAllTasks();
  
  boolean isCurrentlyRunning(int paramInt);
  
  boolean isQueued(int paramInt);
  
  List<BukkitWorker> getActiveWorkers();
  
  List<BukkitTask> getPendingTasks();
  
  BukkitTask runTask(Plugin paramPlugin, Runnable paramRunnable) throws IllegalArgumentException;
  
  BukkitTask runTaskAsynchronously(Plugin paramPlugin, Runnable paramRunnable) throws IllegalArgumentException;
  
  BukkitTask runTaskLater(Plugin paramPlugin, Runnable paramRunnable, long paramLong) throws IllegalArgumentException;
  
  BukkitTask runTaskLaterAsynchronously(Plugin paramPlugin, Runnable paramRunnable, long paramLong) throws IllegalArgumentException;
  
  BukkitTask runTaskTimer(Plugin paramPlugin, Runnable paramRunnable, long paramLong1, long paramLong2) throws IllegalArgumentException;
  
  BukkitTask runTaskTimerAsynchronously(Plugin paramPlugin, Runnable paramRunnable, long paramLong1, long paramLong2) throws IllegalArgumentException;
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\scheduler\BukkitScheduler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */