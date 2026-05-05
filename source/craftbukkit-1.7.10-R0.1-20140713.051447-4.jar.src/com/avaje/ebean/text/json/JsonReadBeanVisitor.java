package com.avaje.ebean.text.json;

import java.util.Map;

public interface JsonReadBeanVisitor<T> {
  void visit(T paramT, Map<String, JsonElement> paramMap);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\text\json\JsonReadBeanVisitor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */