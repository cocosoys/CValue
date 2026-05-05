/*    */ package JinRyuu.DragonBC.common.Render;
/*    */ 
/*    */ import JinRyuu.JRMCore.JRMCoreH;
/*    */ import java.util.List;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.AxisAlignedBB;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class namekian_throneBlock
/*    */   extends block01dbc
/*    */ {
/*    */   private Class TileEntity;
/*    */   
/*    */   public namekian_throneBlock() {
/* 23 */     super(Material.field_151576_e);
/* 24 */     this.TileEntity = namekian_throneTileEntity.class;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_149689_a(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
/* 29 */     int l = MathHelper.func_76128_c((p_149689_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 0x3;
/*    */     
/* 31 */     if (l == 0)
/* 32 */       p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, 0, 2); 
/* 33 */     if (l == 1)
/* 34 */       p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, 1, 2); 
/* 35 */     if (l == 2)
/* 36 */       p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, 2, 2); 
/* 37 */     if (l == 3) {
/* 38 */       p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, 3, 2);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_149651_a(IIconRegister par1IconRegister) {
/* 45 */     this.field_149761_L = par1IconRegister.func_94245_a(JRMCoreH.tjdbcAssts + ":" + func_149739_a());
/*    */   }
/*    */   
/*    */   public int idDropped(int i, Random random, int j) {
/* 49 */     return 0;
/*    */   }
/*    */   
/*    */   public int quanityDropped(Random random) {
/* 53 */     return 0;
/*    */   }
/*    */   
/*    */   public int func_149645_b() {
/* 57 */     return -1;
/*    */   }
/*    */   
/*    */   public boolean func_149662_c() {
/* 61 */     return false;
/*    */   }
/*    */   
/*    */   public boolean func_149686_d() {
/* 65 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_149674_a(World par1World, int par2, int par3, int par4, Random par5Random) {}
/*    */ 
/*    */   
/*    */   public int func_149738_a(World par1World) {
/* 73 */     return 1;
/*    */   }
/*    */   
/*    */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t) {
/* 77 */     sitOnBlock(world, x, y + 0.99D, z, player);
/* 78 */     return true;
/*    */   }
/*    */   
/*    */   public void func_149743_a(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {
/* 82 */     int l = par1World.func_72805_g(par2, par3, par4);
/*    */     
/* 84 */     func_149676_a(-0.5F, 0.0F, -0.5F, 1.5F, 0.8F, 1.5F);
/* 85 */     super.func_149743_a(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public TileEntity func_149915_a(World world, int i) {
/* 92 */     return new namekian_throneTileEntity();
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\namekian_throneBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */