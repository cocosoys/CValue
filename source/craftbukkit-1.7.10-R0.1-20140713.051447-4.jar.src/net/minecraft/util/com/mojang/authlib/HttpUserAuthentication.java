/*    */ package net.minecraft.util.com.mojang.authlib;
/*    */ 
/*    */ public abstract class HttpUserAuthentication extends BaseUserAuthentication {
/*    */   protected HttpUserAuthentication(HttpAuthenticationService authenticationService) {
/*  5 */     super(authenticationService);
/*    */   }
/*    */ 
/*    */   
/*    */   public HttpAuthenticationService getAuthenticationService() {
/* 10 */     return (HttpAuthenticationService)super.getAuthenticationService();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\com\mojang\authlib\HttpUserAuthentication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */