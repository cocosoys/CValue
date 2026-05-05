/*    */ package cpw.mods.fml.relauncher;
/*    */ 
/*    */ import java.lang.reflect.Method;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ServerLaunchWrapper
/*    */ {
/*    */   public static void main(String[] args) {
/* 12 */     (new ServerLaunchWrapper()).run(args);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void run(String[] args) {
/* 22 */     Class<?> launchwrapper = null;
/*    */     
/*    */     try {
/* 25 */       launchwrapper = Class.forName("net.minecraft.launchwrapper.Launch", true, getClass().getClassLoader());
/* 26 */       Class.forName("org.objectweb.asm.Type", true, getClass().getClassLoader());
/*    */     }
/* 28 */     catch (Exception e) {
/*    */       
/* 30 */       System.err.printf("We appear to be missing one or more essential library files.\nYou will need to add them to your server before FML and Forge will run successfully.", new Object[0]);
/*    */       
/* 32 */       e.printStackTrace(System.err);
/* 33 */       System.exit(1);
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 38 */       Method main = launchwrapper.getMethod("main", new Class[] { String[].class });
/* 39 */       String[] allArgs = new String[args.length + 2];
/* 40 */       allArgs[0] = "--tweakClass";
/* 41 */       allArgs[1] = "cpw.mods.fml.common.launcher.FMLServerTweaker";
/* 42 */       System.arraycopy(args, 0, allArgs, 2, args.length);
/* 43 */       main.invoke(null, new Object[] { allArgs });
/*    */     }
/* 45 */     catch (Exception e) {
/*    */       
/* 47 */       System.err.printf("A problem occurred running the Server launcher.", new Object[0]);
/* 48 */       e.printStackTrace(System.err);
/* 49 */       System.exit(1);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\relauncher\ServerLaunchWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */