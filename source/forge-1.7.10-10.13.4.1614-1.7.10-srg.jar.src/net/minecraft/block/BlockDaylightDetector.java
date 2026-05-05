/*     */ package net.minecraft.block;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.tileentity.TileEntityDaylightDetector;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.EnumSkyBlock;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockDaylightDetector extends BlockContainer {
/*  16 */   private IIcon[] field_149958_a = new IIcon[2]; private static final String __OBFID = "CL_00000223";
/*     */   
/*     */   public BlockDaylightDetector() {
/*  19 */     super(Material.field_151575_d);
/*  20 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.375F, 1.0F);
/*  21 */     func_149647_a(CreativeTabs.field_78028_d);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
/*  26 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.375F, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149709_b(IBlockAccess p_149709_1_, int p_149709_2_, int p_149709_3_, int p_149709_4_, int p_149709_5_) {
/*  31 */     return p_149709_1_.func_72805_g(p_149709_2_, p_149709_3_, p_149709_4_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {}
/*     */ 
/*     */   
/*     */   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {}
/*     */ 
/*     */   
/*     */   public void func_149957_e(World p_149957_1_, int p_149957_2_, int p_149957_3_, int p_149957_4_) {
/*  47 */     if (p_149957_1_.field_73011_w.field_76576_e)
/*     */       return; 
/*  49 */     int i = p_149957_1_.func_72805_g(p_149957_2_, p_149957_3_, p_149957_4_);
/*  50 */     int j = p_149957_1_.func_72972_b(EnumSkyBlock.Sky, p_149957_2_, p_149957_3_, p_149957_4_) - p_149957_1_.field_73008_k;
/*  51 */     float f = p_149957_1_.func_72929_e(1.0F);
/*     */ 
/*     */ 
/*     */     
/*  55 */     if (f < 3.1415927F) {
/*  56 */       f += (0.0F - f) * 0.2F;
/*     */     } else {
/*  58 */       f += (6.2831855F - f) * 0.2F;
/*     */     } 
/*     */     
/*  61 */     j = Math.round(j * MathHelper.func_76134_b(f));
/*  62 */     if (j < 0) {
/*  63 */       j = 0;
/*     */     }
/*  65 */     if (j > 15) {
/*  66 */       j = 15;
/*     */     }
/*     */     
/*  69 */     if (i != j) {
/*  70 */       p_149957_1_.func_72921_c(p_149957_2_, p_149957_3_, p_149957_4_, j, 3);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  76 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  81 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149744_f() {
/*  86 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
/*  91 */     return (TileEntity)new TileEntityDaylightDetector();
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/*  96 */     if (p_149691_1_ == 1) {
/*  97 */       return this.field_149958_a[0];
/*     */     }
/*  99 */     return this.field_149958_a[1];
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 104 */     this.field_149958_a[0] = p_149651_1_.func_94245_a(func_149641_N() + "_top");
/* 105 */     this.field_149958_a[1] = p_149651_1_.func_94245_a(func_149641_N() + "_side");
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockDaylightDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */