/*    */ package net.minecraft.client.renderer.tileentity;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.renderer.texture.TextureManager;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public abstract class TileEntitySpecialRenderer
/*    */ {
/*    */   protected void func_147499_a(ResourceLocation p_147499_1_) {
/* 15 */     TextureManager textureManager = this.field_147501_a.field_147553_e;
/* 16 */     if (textureManager != null)
/* 17 */       textureManager.func_110577_a(p_147499_1_); 
/*    */   }
/*    */   
/*    */   protected TileEntityRendererDispatcher field_147501_a;
/*    */   private static final String __OBFID = "CL_00000964";
/*    */   
/*    */   public abstract void func_147500_a(TileEntity paramTileEntity, double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat);
/*    */   
/*    */   public void func_147497_a(TileEntityRendererDispatcher p_147497_1_) {
/* 26 */     this.field_147501_a = p_147497_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_147496_a(World p_147496_1_) {}
/*    */ 
/*    */   
/*    */   public FontRenderer func_147498_b() {
/* 34 */     return this.field_147501_a.func_147548_a();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\tileentity\TileEntitySpecialRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */