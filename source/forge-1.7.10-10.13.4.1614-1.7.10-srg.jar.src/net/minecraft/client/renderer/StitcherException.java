/*   */ package net.minecraft.client.renderer;
/*   */ import cpw.mods.fml.relauncher.Side;
/*   */ import net.minecraft.client.renderer.texture.Stitcher;
/*   */ 
/*   */ @SideOnly(Side.CLIENT)
/*   */ public class StitcherException extends RuntimeException {
/*   */   public StitcherException(Stitcher.Holder p_i2344_1_, String p_i2344_2_) {
/* 8 */     super(p_i2344_2_);
/* 9 */     this.field_98149_a = p_i2344_1_;
/*   */   }
/*   */   
/*   */   private final Stitcher.Holder field_98149_a;
/*   */   private static final String __OBFID = "CL_00001057";
/*   */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\StitcherException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */