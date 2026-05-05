/*    */ package net.minecraft.client.renderer.texture;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.client.resources.IResourceManager;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class DynamicTexture extends AbstractTexture {
/*    */   private final int[] field_110566_b;
/*    */   private final int field_94233_j;
/*    */   
/*    */   public DynamicTexture(BufferedImage p_i1270_1_) {
/* 14 */     this(p_i1270_1_.getWidth(), p_i1270_1_.getHeight());
/*    */     
/* 16 */     p_i1270_1_.getRGB(0, 0, p_i1270_1_.getWidth(), p_i1270_1_.getHeight(), this.field_110566_b, 0, p_i1270_1_.getWidth());
/*    */     
/* 18 */     func_110564_a();
/*    */   }
/*    */   private final int field_94234_k; private static final String __OBFID = "CL_00001048";
/*    */   public DynamicTexture(int p_i1271_1_, int p_i1271_2_) {
/* 22 */     this.field_94233_j = p_i1271_1_;
/* 23 */     this.field_94234_k = p_i1271_2_;
/* 24 */     this.field_110566_b = new int[p_i1271_1_ * p_i1271_2_];
/*    */     
/* 26 */     TextureUtil.func_110991_a(func_110552_b(), p_i1271_1_, p_i1271_2_);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_110551_a(IResourceManager p_110551_1_) throws IOException {}
/*    */ 
/*    */   
/*    */   public void func_110564_a() {
/* 35 */     TextureUtil.func_110988_a(func_110552_b(), this.field_110566_b, this.field_94233_j, this.field_94234_k);
/*    */   }
/*    */   
/*    */   public int[] func_110565_c() {
/* 39 */     return this.field_110566_b;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\texture\DynamicTexture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */