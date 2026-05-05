/*    */ package cpw.mods.fml.relauncher;
/*    */ 
/*    */ import java.security.Permission;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FMLSecurityManager
/*    */   extends SecurityManager
/*    */ {
/*    */   public void checkPermission(Permission perm) {
/* 16 */     String permName = (perm.getName() != null) ? perm.getName() : "missing";
/* 17 */     if (permName.startsWith("exitVM")) {
/*    */       
/* 19 */       Class<?>[] classContexts = getClassContext();
/* 20 */       String callingClass = (classContexts.length > 3) ? classContexts[4].getName() : "none";
/* 21 */       String callingParent = (classContexts.length > 4) ? classContexts[5].getName() : "none";
/*    */       
/* 23 */       if (!callingClass.startsWith("cpw.mods.fml.") && (!"net.minecraft.client.Minecraft".equals(callingClass) || !"net.minecraft.client.Minecraft".equals(callingParent)) && (!"net.minecraft.server.dedicated.DedicatedServer".equals(callingClass) || !"net.minecraft.server.MinecraftServer".equals(callingParent)))
/*    */       {
/* 25 */         throw new ExitTrappedException();
/*    */       }
/*    */     }
/* 28 */     else if ("setSecurityManager".equals(permName)) {
/*    */       
/* 30 */       throw new SecurityException("Cannot replace the FML security manager");
/*    */     } 
/*    */   }
/*    */   
/*    */   public static class ExitTrappedException extends SecurityException {
/*    */     private static final long serialVersionUID = 1L;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\relauncher\FMLSecurityManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */