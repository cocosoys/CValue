/*    */ package JinRyuu.DragonBC.common.Render;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.block.BlockContainer;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.AxisAlignedBB;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class block01dbc
/*    */   extends BlockContainer
/*    */ {
/*    */   public block01dbc(Material par2Material) {
/* 18 */     super(par2Material);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean sitOnBlock(World par1World, double par2, double par3, double par4, EntityPlayer par5EntityPlayer) {
/* 23 */     checkForExistingEntity(par1World, par2, par3, par4, par5EntityPlayer);
/* 24 */     block01dbcEntity nemb = new block01dbcEntity(par1World, par2, par3, par4);
/* 25 */     par1World.func_72838_d(nemb);
/* 26 */     par5EntityPlayer.func_70078_a(nemb);
/* 27 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean checkForExistingEntity(World par1World, double par2, double par3, double par4, EntityPlayer par5EntityPlayer) {
/* 32 */     List<block01dbcEntity> listEMB = par1World.func_72872_a(block01dbcEntity.class, AxisAlignedBB.func_72330_a(par2, par3, par4, par2 + 1.0D, par3 + 1.0D, par4 + 1.0D).func_72314_b(1.0D, 1.0D, 1.0D));
/* 33 */     for (block01dbcEntity mount : listEMB) {
/* 34 */       if (mount.getX() == par2 && mount.getY() == par3 && mount.getZ() == par4) {
/*    */         
/* 36 */         if (mount.field_70153_n == null) {
/* 37 */           par5EntityPlayer.func_70078_a(mount);
/*    */         }
/* 39 */         return true;
/*    */       } 
/*    */     } 
/* 42 */     return false;
/*    */   }
/*    */   
/*    */   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
/* 46 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\block01dbc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */