package com.avaje.ebean.text.json;

import java.sql.Date;
import java.sql.Timestamp;

public interface JsonValueAdapter {
  String jsonFromDate(Date paramDate);
  
  String jsonFromTimestamp(Timestamp paramTimestamp);
  
  Date jsonToDate(String paramString);
  
  Timestamp jsonToTimestamp(String paramString);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\text\json\JsonValueAdapter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */