/*    */ package net.minecraft.client.resources;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.client.renderer.texture.TextureUtil;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.ColorizerFoliage;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class FoliageColorReloadListener implements IResourceManagerReloadListener {
/*  9 */   private static final ResourceLocation field_130079_a = new ResourceLocation("textures/colormap/foliage.png");
/*    */   private static final String __OBFID = "CL_00001077";
/*    */   
/*    */   public void func_110549_a(IResourceManager p_110549_1_) {
/*    */     try {
/* 14 */       ColorizerFoliage.func_77467_a(TextureUtil.func_110986_a(p_110549_1_, field_130079_a));
/* 15 */     } catch (IOException iOException) {}
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\resources\FoliageColorReloadListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */