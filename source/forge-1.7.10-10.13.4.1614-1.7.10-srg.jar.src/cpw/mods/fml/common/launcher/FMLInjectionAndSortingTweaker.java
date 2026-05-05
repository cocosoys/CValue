/*    */ package cpw.mods.fml.common.launcher;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.CoreModManager;
/*    */ import java.io.File;
/*    */ import java.util.List;
/*    */ import net.minecraft.launchwrapper.ITweaker;
/*    */ import net.minecraft.launchwrapper.Launch;
/*    */ import net.minecraft.launchwrapper.LaunchClassLoader;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FMLInjectionAndSortingTweaker
/*    */   implements ITweaker
/*    */ {
/*    */   private boolean run;
/*    */   
/*    */   public FMLInjectionAndSortingTweaker() {
/* 23 */     CoreModManager.injectCoreModTweaks(this);
/* 24 */     this.run = false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void acceptOptions(List<String> args, File gameDir, File assetsDir, String profile) {
/* 30 */     if (!this.run) {
/*    */ 
/*    */       
/* 33 */       CoreModManager.sortTweakList();
/*    */       
/* 35 */       List<String> newTweaks = (List<String>)Launch.blackboard.get("TweakClasses");
/* 36 */       newTweaks.add("cpw.mods.fml.common.launcher.TerminalTweaker");
/*    */     } 
/* 38 */     this.run = true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void injectIntoClassLoader(LaunchClassLoader classLoader) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public String getLaunchTarget() {
/* 49 */     return "";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String[] getLaunchArguments() {
/* 55 */     return new String[0];
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\launcher\FMLInjectionAndSortingTweaker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */