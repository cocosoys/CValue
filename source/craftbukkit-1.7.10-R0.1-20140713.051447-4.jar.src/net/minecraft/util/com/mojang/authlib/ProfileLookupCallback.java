package net.minecraft.util.com.mojang.authlib;

public interface ProfileLookupCallback {
  void onProfileLookupSucceeded(GameProfile paramGameProfile);
  
  void onProfileLookupFailed(GameProfile paramGameProfile, Exception paramException);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\com\mojang\authlib\ProfileLookupCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */