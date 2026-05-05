package com.google.common.eventbus;

import com.google.common.collect.Multimap;

interface HandlerFindingStrategy {
  Multimap<Class<?>, EventHandler> findAllHandlers(Object paramObject);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\google\common\eventbus\HandlerFindingStrategy.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */