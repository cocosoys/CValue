package org.bukkit.map;

import java.awt.Image;

public interface MapCanvas {
  MapView getMapView();
  
  MapCursorCollection getCursors();
  
  void setCursors(MapCursorCollection paramMapCursorCollection);
  
  void setPixel(int paramInt1, int paramInt2, byte paramByte);
  
  byte getPixel(int paramInt1, int paramInt2);
  
  byte getBasePixel(int paramInt1, int paramInt2);
  
  void drawImage(int paramInt1, int paramInt2, Image paramImage);
  
  void drawText(int paramInt1, int paramInt2, MapFont paramMapFont, String paramString);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\map\MapCanvas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */