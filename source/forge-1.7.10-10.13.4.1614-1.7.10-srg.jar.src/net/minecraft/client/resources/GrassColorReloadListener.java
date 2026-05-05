/*    */ package net.minecraft.client.resources;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.client.renderer.texture.TextureUtil;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.ColorizerGrass;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GrassColorReloadListener implements IResourceManagerReloadListener {
/*  9 */   private static final ResourceLocation field_130078_a = new ResourceLocation("textures/colormap/grass.png");
/*    */   private static final String __OBFID = "CL_00001078";
/*    */   
/*    */   public void func_110549_a(IResourceManager p_110549_1_) {
/*    */     try {
/* 14 */       ColorizerGrass.func_77479_a(TextureUtil.func_110986_a(p_110549_1_, field_130078_a));
/* 15 */     } catch (IOException iOException) {}
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\resources\GrassColorReloadListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */