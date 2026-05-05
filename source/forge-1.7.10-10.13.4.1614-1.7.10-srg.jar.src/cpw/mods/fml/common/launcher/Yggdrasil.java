/*    */ package cpw.mods.fml.common.launcher;
/*    */ 
/*    */ import com.google.common.base.Throwables;
/*    */ import com.mojang.authlib.Agent;
/*    */ import com.mojang.authlib.exceptions.AuthenticationException;
/*    */ import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
/*    */ import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;
/*    */ import java.net.Proxy;
/*    */ import java.util.Map;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Yggdrasil
/*    */ {
/*    */   public static void login(Map<String, String> args) {
/* 22 */     if (!args.containsKey("--username") || !args.containsKey("--password"))
/* 23 */       return;  YggdrasilUserAuthentication auth = (YggdrasilUserAuthentication)(new YggdrasilAuthenticationService(Proxy.NO_PROXY, "1")).createUserAuthentication(Agent.MINECRAFT);
/* 24 */     auth.setUsername(args.get("--username"));
/* 25 */     auth.setPassword(args.remove("--password"));
/*    */ 
/*    */     
/*    */     try {
/* 29 */       auth.logIn();
/*    */     }
/* 31 */     catch (AuthenticationException e) {
/*    */       
/* 33 */       LogManager.getLogger("FMLTWEAK").error("-- Login failed!  " + e.getMessage());
/* 34 */       Throwables.propagate((Throwable)e);
/*    */       
/*    */       return;
/*    */     } 
/* 38 */     args.put("--username", auth.getSelectedProfile().getName());
/* 39 */     args.put("--uuid", auth.getSelectedProfile().getId().toString().replace("-", ""));
/* 40 */     args.put("--accessToken", auth.getAuthenticatedToken());
/* 41 */     args.put("--userProperties", auth.getUserProperties().toString());
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\launcher\Yggdrasil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */