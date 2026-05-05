package net.minecraft.util.com.mojang.authlib;

import java.util.Map;
import net.minecraft.util.com.mojang.authlib.exceptions.AuthenticationException;
import net.minecraft.util.com.mojang.authlib.properties.PropertyMap;

public interface UserAuthentication {
  boolean canLogIn();
  
  void logIn() throws AuthenticationException;
  
  void logOut();
  
  boolean isLoggedIn();
  
  boolean canPlayOnline();
  
  GameProfile[] getAvailableProfiles();
  
  GameProfile getSelectedProfile();
  
  void selectGameProfile(GameProfile paramGameProfile) throws AuthenticationException;
  
  void loadFromStorage(Map<String, Object> paramMap);
  
  Map<String, Object> saveForStorage();
  
  void setUsername(String paramString);
  
  void setPassword(String paramString);
  
  String getAuthenticatedToken();
  
  String getUserID();
  
  PropertyMap getUserProperties();
  
  UserType getUserType();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\com\mojang\authlib\UserAuthentication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */