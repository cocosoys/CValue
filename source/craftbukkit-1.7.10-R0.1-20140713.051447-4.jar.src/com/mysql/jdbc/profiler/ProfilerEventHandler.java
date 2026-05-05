package com.mysql.jdbc.profiler;

import com.mysql.jdbc.Extension;

public interface ProfilerEventHandler extends Extension {
  void consumeEvent(ProfilerEvent paramProfilerEvent);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\mysql\jdbc\profiler\ProfilerEventHandler.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */