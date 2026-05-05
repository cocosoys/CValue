/*    */ package net.minecraft.block;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.tileentity.TileEntityEnchantmentTable;
/*    */ import net.minecraft.util.IIcon;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class BlockEnchantmentTable
/*    */   extends BlockContainer
/*    */ {
/*    */   @SideOnly(Side.CLIENT)
/*    */   private IIcon field_149950_a;
/*    */   
/*    */   protected BlockEnchantmentTable() {
/* 25 */     super(Material.field_151576_e);
/* 26 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
/* 27 */     func_149713_g(0);
/* 28 */     func_149647_a(CreativeTabs.field_78031_c);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   private IIcon field_149949_b; private static final String __OBFID = "CL_00000235";
/*    */   public boolean func_149686_d() {
/* 33 */     return false;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149734_b(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
/* 38 */     super.func_149734_b(p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_, p_149734_5_);
/*    */     
/* 40 */     for (int i = p_149734_2_ - 2; i <= p_149734_2_ + 2; i++) {
/* 41 */       for (int j = p_149734_4_ - 2; j <= p_149734_4_ + 2; j++) {
/* 42 */         if (i > p_149734_2_ - 2 && i < p_149734_2_ + 2 && j == p_149734_4_ - 1) {
/* 43 */           j = p_149734_4_ + 2;
/*    */         }
/* 45 */         if (p_149734_5_.nextInt(16) == 0) {
/* 46 */           for (int k = p_149734_3_; k <= p_149734_3_ + 1; k++) {
/* 47 */             if (p_149734_1_.func_147439_a(i, k, j) == Blocks.field_150342_X) {
/* 48 */               if (!p_149734_1_.func_147437_c((i - p_149734_2_) / 2 + p_149734_2_, k, (j - p_149734_4_) / 2 + p_149734_4_))
/*    */                 break; 
/* 50 */               p_149734_1_.func_72869_a("enchantmenttable", p_149734_2_ + 0.5D, p_149734_3_ + 2.0D, p_149734_4_ + 0.5D, ((i - p_149734_2_) + p_149734_5_.nextFloat()) - 0.5D, ((k - p_149734_3_) - p_149734_5_.nextFloat() - 1.0F), ((j - p_149734_4_) + p_149734_5_.nextFloat()) - 0.5D);
/*    */             } 
/*    */           } 
/*    */         }
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean func_149662_c() {
/* 59 */     return false;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/* 64 */     if (p_149691_1_ == 0) return this.field_149949_b; 
/* 65 */     if (p_149691_1_ == 1) return this.field_149950_a; 
/* 66 */     return this.field_149761_L;
/*    */   }
/*    */ 
/*    */   
/*    */   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
/* 71 */     return (TileEntity)new TileEntityEnchantmentTable();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
/* 76 */     if (p_149727_1_.field_72995_K) {
/* 77 */       return true;
/*    */     }
/* 79 */     TileEntityEnchantmentTable tileEntityEnchantmentTable = (TileEntityEnchantmentTable)p_149727_1_.func_147438_o(p_149727_2_, p_149727_3_, p_149727_4_);
/* 80 */     p_149727_5_.func_71002_c(p_149727_2_, p_149727_3_, p_149727_4_, tileEntityEnchantmentTable.func_145921_b() ? tileEntityEnchantmentTable.func_145919_a() : null);
/* 81 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_149689_a(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
/* 86 */     super.func_149689_a(p_149689_1_, p_149689_2_, p_149689_3_, p_149689_4_, p_149689_5_, p_149689_6_);
/* 87 */     if (p_149689_6_.func_82837_s())
/* 88 */       ((TileEntityEnchantmentTable)p_149689_1_.func_147438_o(p_149689_2_, p_149689_3_, p_149689_4_)).func_145920_a(p_149689_6_.func_82833_r()); 
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 93 */     this.field_149761_L = p_149651_1_.func_94245_a(func_149641_N() + "_" + "side");
/* 94 */     this.field_149950_a = p_149651_1_.func_94245_a(func_149641_N() + "_" + "top");
/* 95 */     this.field_149949_b = p_149651_1_.func_94245_a(func_149641_N() + "_" + "bottom");
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockEnchantmentTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */