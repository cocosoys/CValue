/*   */ package net.minecraft.client.renderer;
/*   */ import cpw.mods.fml.relauncher.Side;
/*   */ 
/*   */ @SideOnly(Side.CLIENT)
/*   */ public class OpenGlCapsChecker {
/*   */   public static boolean func_74371_a() {
/* 7 */     return (GLContext.getCapabilities()).GL_ARB_occlusion_query;
/*   */   }
/*   */   
/*   */   private static final String __OBFID = "CL_00000649";
/*   */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\OpenGlCapsChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */