/*     */ package net.minecraft.block;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.MapColor;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockEndPortal extends BlockContainer {
/*     */   public static boolean field_149948_a;
/*     */   
/*     */   protected BlockEndPortal(Material p_i45404_1_) {
/*  18 */     super(p_i45404_1_);
/*  19 */     func_149715_a(1.0F);
/*     */   }
/*     */   private static final String __OBFID = "CL_00000236";
/*     */   
/*     */   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
/*  24 */     return (TileEntity)new TileEntityEndPortal();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
/*  29 */     float f = 0.0625F;
/*  30 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149646_a(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
/*  35 */     if (p_149646_5_ != 0) return false; 
/*  36 */     return super.func_149646_a(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149743_a(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_) {}
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  45 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  50 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149745_a(Random p_149745_1_) {
/*  55 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149670_a(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_) {
/*  60 */     if (p_149670_5_.field_70154_o == null && p_149670_5_.field_70153_n == null && 
/*  61 */       !p_149670_1_.field_72995_K) {
/*  62 */       p_149670_5_.func_71027_c(1);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149734_b(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
/*  69 */     double d1 = (p_149734_2_ + p_149734_5_.nextFloat());
/*  70 */     double d2 = (p_149734_3_ + 0.8F);
/*  71 */     double d3 = (p_149734_4_ + p_149734_5_.nextFloat());
/*  72 */     double d4 = 0.0D;
/*  73 */     double d5 = 0.0D;
/*  74 */     double d6 = 0.0D;
/*     */     
/*  76 */     p_149734_1_.func_72869_a("smoke", d1, d2, d3, d4, d5, d6);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  81 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
/*  86 */     if (field_149948_a)
/*     */       return; 
/*  88 */     if (p_149726_1_.field_73011_w.field_76574_g != 0) {
/*  89 */       p_149726_1_.func_147468_f(p_149726_2_, p_149726_3_, p_149726_4_);
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
/*  95 */     return Item.func_150899_d(0);
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 101 */     this.field_149761_L = p_149651_1_.func_94245_a("portal");
/*     */   }
/*     */ 
/*     */   
/*     */   public MapColor func_149728_f(int p_149728_1_) {
/* 106 */     return MapColor.field_151654_J;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockEndPortal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */