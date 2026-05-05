/*    */ package net.minecraft.block;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.tileentity.TileEntityBeacon;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class BlockBeacon extends BlockContainer {
/*    */   public BlockBeacon() {
/* 14 */     super(Material.field_151592_s);
/* 15 */     func_149711_c(3.0F);
/* 16 */     func_149647_a(CreativeTabs.field_78026_f);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000197";
/*    */   
/*    */   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
/* 21 */     return (TileEntity)new TileEntityBeacon();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
/* 26 */     if (p_149727_1_.field_72995_K) return true;
/*    */     
/* 28 */     TileEntityBeacon tileEntityBeacon = (TileEntityBeacon)p_149727_1_.func_147438_o(p_149727_2_, p_149727_3_, p_149727_4_);
/* 29 */     if (tileEntityBeacon != null) p_149727_5_.func_146104_a(tileEntityBeacon);
/*    */     
/* 31 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_149662_c() {
/* 36 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_149686_d() {
/* 41 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_149645_b() {
/* 50 */     return 34;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 55 */     super.func_149651_a(p_149651_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_149689_a(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
/* 60 */     super.func_149689_a(p_149689_1_, p_149689_2_, p_149689_3_, p_149689_4_, p_149689_5_, p_149689_6_);
/* 61 */     if (p_149689_6_.func_82837_s())
/* 62 */       ((TileEntityBeacon)p_149689_1_.func_147438_o(p_149689_2_, p_149689_3_, p_149689_4_)).func_145999_a(p_149689_6_.func_82833_r()); 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockBeacon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */