/*    */ package net.minecraft.util.com.mojang.authlib.minecraft;
/*    */ 
/*    */ import net.minecraft.util.com.mojang.authlib.AuthenticationService;
/*    */ 
/*    */ public abstract class BaseMinecraftSessionService implements MinecraftSessionService {
/*    */   private final AuthenticationService authenticationService;
/*    */   
/*    */   protected BaseMinecraftSessionService(AuthenticationService authenticationService) {
/*  9 */     this.authenticationService = authenticationService;
/*    */   }
/*    */   
/*    */   public AuthenticationService getAuthenticationService() {
/* 13 */     return this.authenticationService;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\com\mojang\authlib\minecraft\BaseMinecraftSessionService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */