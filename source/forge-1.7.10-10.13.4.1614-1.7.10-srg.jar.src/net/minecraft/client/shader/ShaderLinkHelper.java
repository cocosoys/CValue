/*    */ package net.minecraft.client.shader;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.OpenGlHelper;
/*    */ import net.minecraft.client.util.JsonException;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ShaderLinkHelper {
/* 11 */   private static final Logger field_148080_a = LogManager.getLogger(); private static ShaderLinkHelper field_148079_b;
/*    */   private static final String __OBFID = "CL_00001045";
/*    */   
/*    */   public static void func_148076_a() {
/* 15 */     field_148079_b = new ShaderLinkHelper();
/*    */   }
/*    */   
/*    */   public static ShaderLinkHelper func_148074_b() {
/* 19 */     return field_148079_b;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_148077_a(ShaderManager p_148077_1_) {
/* 26 */     p_148077_1_.func_147994_f().func_148054_b(p_148077_1_);
/* 27 */     p_148077_1_.func_147989_e().func_148054_b(p_148077_1_);
/*    */     
/* 29 */     OpenGlHelper.func_153187_e(p_148077_1_.func_147986_h());
/*    */   }
/*    */   
/*    */   public int func_148078_c() throws JsonException {
/* 33 */     int i = OpenGlHelper.func_153183_d();
/*    */     
/* 35 */     if (i <= 0) {
/* 36 */       throw new JsonException("Could not create shader program (returned program ID " + i + ")");
/*    */     }
/*    */     
/* 39 */     return i;
/*    */   }
/*    */   
/*    */   public void func_148075_b(ShaderManager p_148075_1_) {
/* 43 */     p_148075_1_.func_147994_f().func_148056_a(p_148075_1_);
/* 44 */     p_148075_1_.func_147989_e().func_148056_a(p_148075_1_);
/*    */     
/* 46 */     OpenGlHelper.func_153179_f(p_148075_1_.func_147986_h());
/* 47 */     int i = OpenGlHelper.func_153175_a(p_148075_1_.func_147986_h(), OpenGlHelper.field_153207_o);
/* 48 */     if (i == 0) {
/* 49 */       field_148080_a.warn("Error encountered when linking program containing VS " + p_148075_1_.func_147989_e().func_148055_a() + " and FS " + p_148075_1_.func_147994_f().func_148055_a() + ". Log output:");
/* 50 */       field_148080_a.warn(OpenGlHelper.func_153166_e(p_148075_1_.func_147986_h(), 32768));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\shader\ShaderLinkHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */