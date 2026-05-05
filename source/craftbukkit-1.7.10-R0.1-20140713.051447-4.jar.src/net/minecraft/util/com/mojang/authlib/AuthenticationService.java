package net.minecraft.util.com.mojang.authlib;

import net.minecraft.util.com.mojang.authlib.minecraft.MinecraftSessionService;

public interface AuthenticationService {
  UserAuthentication createUserAuthentication(Agent paramAgent);
  
  MinecraftSessionService createMinecraftSessionService();
  
  GameProfileRepository createProfileRepository();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\com\mojang\authlib\AuthenticationService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */