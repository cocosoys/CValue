/*    */ package cpw.mods.fml.common.launcher;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.util.List;
/*    */ import net.minecraft.launchwrapper.ITweaker;
/*    */ import net.minecraft.launchwrapper.LaunchClassLoader;
/*    */ 
/*    */ public final class TerminalTweaker
/*    */   implements ITweaker
/*    */ {
/*    */   public void injectIntoClassLoader(LaunchClassLoader classLoader) {
/* 12 */     classLoader.registerTransformer("cpw.mods.fml.common.asm.transformers.TerminalTransformer");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getLaunchTarget() {
/* 18 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String[] getLaunchArguments() {
/* 24 */     return new String[0];
/*    */   }
/*    */   
/*    */   public void acceptOptions(List<String> args, File gameDir, File assetsDir, String profile) {}
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\launcher\TerminalTweaker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */