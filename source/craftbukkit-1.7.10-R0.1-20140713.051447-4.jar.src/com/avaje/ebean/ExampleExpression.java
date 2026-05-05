package com.avaje.ebean;

public interface ExampleExpression extends Expression {
  ExampleExpression includeZeros();
  
  ExampleExpression caseInsensitive();
  
  ExampleExpression useStartsWith();
  
  ExampleExpression useContains();
  
  ExampleExpression useEndsWith();
  
  ExampleExpression useEqualTo();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\ExampleExpression.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */