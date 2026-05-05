package com.avaje.ebean.enhance.asm.commons;

import com.avaje.ebean.enhance.asm.Label;

public interface TableSwitchGenerator {
  void generateCase(int paramInt, Label paramLabel);
  
  void generateDefault();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\enhance\asm\commons\TableSwitchGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */