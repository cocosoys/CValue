/*     */ package net.minecraft.block;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockLadder extends Block {
/*     */   protected BlockLadder() {
/*  12 */     super(Material.field_151594_q);
/*  13 */     func_149647_a(CreativeTabs.field_78031_c);
/*     */   }
/*     */   private static final String __OBFID = "CL_00000262";
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
/*  18 */     func_149719_a((IBlockAccess)p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
/*  19 */     return super.func_149668_a(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public AxisAlignedBB func_149633_g(World p_149633_1_, int p_149633_2_, int p_149633_3_, int p_149633_4_) {
/*  24 */     func_149719_a((IBlockAccess)p_149633_1_, p_149633_2_, p_149633_3_, p_149633_4_);
/*  25 */     return super.func_149633_g(p_149633_1_, p_149633_2_, p_149633_3_, p_149633_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
/*  30 */     func_149797_b(p_149719_1_.func_72805_g(p_149719_2_, p_149719_3_, p_149719_4_));
/*     */   }
/*     */   
/*     */   public void func_149797_b(int p_149797_1_) {
/*  34 */     int i = p_149797_1_;
/*  35 */     float f = 0.125F;
/*     */     
/*  37 */     if (i == 2) func_149676_a(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F); 
/*  38 */     if (i == 3) func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f); 
/*  39 */     if (i == 4) func_149676_a(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F); 
/*  40 */     if (i == 5) func_149676_a(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  49 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  54 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  59 */     return 8;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
/*  64 */     if (p_149742_1_.func_147439_a(p_149742_2_ - 1, p_149742_3_, p_149742_4_).func_149721_r())
/*  65 */       return true; 
/*  66 */     if (p_149742_1_.func_147439_a(p_149742_2_ + 1, p_149742_3_, p_149742_4_).func_149721_r())
/*  67 */       return true; 
/*  68 */     if (p_149742_1_.func_147439_a(p_149742_2_, p_149742_3_, p_149742_4_ - 1).func_149721_r())
/*  69 */       return true; 
/*  70 */     if (p_149742_1_.func_147439_a(p_149742_2_, p_149742_3_, p_149742_4_ + 1).func_149721_r()) {
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149660_a(World p_149660_1_, int p_149660_2_, int p_149660_3_, int p_149660_4_, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_) {
/*  78 */     int i = p_149660_9_;
/*     */     
/*  80 */     if ((i == 0 || p_149660_5_ == 2) && p_149660_1_.func_147439_a(p_149660_2_, p_149660_3_, p_149660_4_ + 1).func_149721_r()) i = 2; 
/*  81 */     if ((i == 0 || p_149660_5_ == 3) && p_149660_1_.func_147439_a(p_149660_2_, p_149660_3_, p_149660_4_ - 1).func_149721_r()) i = 3; 
/*  82 */     if ((i == 0 || p_149660_5_ == 4) && p_149660_1_.func_147439_a(p_149660_2_ + 1, p_149660_3_, p_149660_4_).func_149721_r()) i = 4; 
/*  83 */     if ((i == 0 || p_149660_5_ == 5) && p_149660_1_.func_147439_a(p_149660_2_ - 1, p_149660_3_, p_149660_4_).func_149721_r()) i = 5;
/*     */     
/*  85 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/*  90 */     int i = p_149695_1_.func_72805_g(p_149695_2_, p_149695_3_, p_149695_4_);
/*  91 */     boolean bool = false;
/*     */     
/*  93 */     if (i == 2 && p_149695_1_.func_147439_a(p_149695_2_, p_149695_3_, p_149695_4_ + 1).func_149721_r()) bool = true; 
/*  94 */     if (i == 3 && p_149695_1_.func_147439_a(p_149695_2_, p_149695_3_, p_149695_4_ - 1).func_149721_r()) bool = true; 
/*  95 */     if (i == 4 && p_149695_1_.func_147439_a(p_149695_2_ + 1, p_149695_3_, p_149695_4_).func_149721_r()) bool = true; 
/*  96 */     if (i == 5 && p_149695_1_.func_147439_a(p_149695_2_ - 1, p_149695_3_, p_149695_4_).func_149721_r()) bool = true; 
/*  97 */     if (!bool) {
/*  98 */       func_149697_b(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, i, 0);
/*  99 */       p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_, p_149695_4_);
/*     */     } 
/*     */     
/* 102 */     super.func_149695_a(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_5_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149745_a(Random p_149745_1_) {
/* 107 */     return 1;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockLadder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */