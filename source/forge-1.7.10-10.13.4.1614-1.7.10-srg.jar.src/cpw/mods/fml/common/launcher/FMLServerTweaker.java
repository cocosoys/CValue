/*    */ package cpw.mods.fml.common.launcher;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.FMLLaunchHandler;
/*    */ import net.minecraft.launchwrapper.LaunchClassLoader;
/*    */ 
/*    */ public class FMLServerTweaker
/*    */   extends FMLTweaker
/*    */ {
/*    */   public String getLaunchTarget() {
/* 10 */     return "net.minecraft.server.MinecraftServer";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void injectIntoClassLoader(LaunchClassLoader classLoader) {
/* 18 */     classLoader.addClassLoaderExclusion("com.mojang.");
/* 19 */     classLoader.addTransformerExclusion("cpw.mods.fml.repackage.");
/* 20 */     classLoader.addTransformerExclusion("cpw.mods.fml.relauncher.");
/* 21 */     classLoader.addTransformerExclusion("cpw.mods.fml.common.asm.transformers.");
/* 22 */     classLoader.addClassLoaderExclusion("LZMA.");
/* 23 */     FMLLaunchHandler.configureForServerLaunch(classLoader, this);
/* 24 */     FMLLaunchHandler.appendCoreMods();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\launcher\FMLServerTweaker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */