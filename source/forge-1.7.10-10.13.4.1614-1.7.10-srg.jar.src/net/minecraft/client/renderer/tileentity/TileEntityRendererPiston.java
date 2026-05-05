/*    */ package net.minecraft.client.renderer.tileentity;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.BlockPistonBase;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.RenderBlocks;
/*    */ import net.minecraft.client.renderer.RenderHelper;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.client.renderer.texture.TextureMap;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.tileentity.TileEntityPiston;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraft.world.World;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class TileEntityRendererPiston
/*    */   extends TileEntitySpecialRenderer
/*    */ {
/*    */   private RenderBlocks field_147516_b;
/*    */   private static final String __OBFID = "CL_00000969";
/*    */   
/*    */   public void func_147500_a(TileEntityPiston p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_) {
/* 29 */     Block block = p_147500_1_.func_145861_a();
/* 30 */     if (block.func_149688_o() == Material.field_151579_a || p_147500_1_.func_145860_a(p_147500_8_) >= 1.0F) {
/*    */       return;
/*    */     }
/*    */     
/* 34 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 35 */     func_147499_a(TextureMap.field_110575_b);
/*    */     
/* 37 */     RenderHelper.func_74518_a();
/*    */     
/* 39 */     GL11.glBlendFunc(770, 771);
/* 40 */     GL11.glEnable(3042);
/* 41 */     GL11.glDisable(2884);
/* 42 */     if (Minecraft.func_71379_u()) {
/* 43 */       GL11.glShadeModel(7425);
/*    */     } else {
/* 45 */       GL11.glShadeModel(7424);
/*    */     } 
/*    */     
/* 48 */     tessellator.func_78382_b();
/*    */     
/* 50 */     tessellator.func_78373_b(((float)p_147500_2_ - p_147500_1_.field_145851_c + p_147500_1_.func_145865_b(p_147500_8_)), ((float)p_147500_4_ - p_147500_1_.field_145848_d + p_147500_1_.func_145862_c(p_147500_8_)), ((float)p_147500_6_ - p_147500_1_.field_145849_e + p_147500_1_.func_145859_d(p_147500_8_)));
/* 51 */     tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
/* 52 */     if (block == Blocks.field_150332_K && p_147500_1_.func_145860_a(p_147500_8_) < 0.5F) {
/*    */       
/* 54 */       this.field_147516_b.func_147750_a(block, p_147500_1_.field_145851_c, p_147500_1_.field_145848_d, p_147500_1_.field_145849_e, false);
/* 55 */     } else if (p_147500_1_.func_145867_d() && !p_147500_1_.func_145868_b()) {
/*    */       
/* 57 */       Blocks.field_150332_K.func_150086_a(((BlockPistonBase)block).func_150073_e());
/* 58 */       this.field_147516_b.func_147750_a((Block)Blocks.field_150332_K, p_147500_1_.field_145851_c, p_147500_1_.field_145848_d, p_147500_1_.field_145849_e, (p_147500_1_.func_145860_a(p_147500_8_) < 0.5F));
/* 59 */       Blocks.field_150332_K.func_150087_e();
/*    */       
/* 61 */       tessellator.func_78373_b(((float)p_147500_2_ - p_147500_1_.field_145851_c), ((float)p_147500_4_ - p_147500_1_.field_145848_d), ((float)p_147500_6_ - p_147500_1_.field_145849_e));
/* 62 */       this.field_147516_b.func_147804_d(block, p_147500_1_.field_145851_c, p_147500_1_.field_145848_d, p_147500_1_.field_145849_e);
/*    */     } else {
/* 64 */       this.field_147516_b.func_147769_a(block, p_147500_1_.field_145851_c, p_147500_1_.field_145848_d, p_147500_1_.field_145849_e);
/*    */     } 
/* 66 */     tessellator.func_78373_b(0.0D, 0.0D, 0.0D);
/* 67 */     tessellator.func_78381_a();
/*    */     
/* 69 */     RenderHelper.func_74519_b();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_147496_a(World p_147496_1_) {
/* 74 */     this.field_147516_b = new RenderBlocks((IBlockAccess)p_147496_1_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\tileentity\TileEntityRendererPiston.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */