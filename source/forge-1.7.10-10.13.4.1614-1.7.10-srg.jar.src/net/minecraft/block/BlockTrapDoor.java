/*     */ package net.minecraft.block;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockTrapDoor extends Block {
/*     */   protected BlockTrapDoor(Material p_i45434_1_) {
/*  14 */     super(p_i45434_1_);
/*     */     
/*  16 */     float f1 = 0.5F;
/*  17 */     float f2 = 1.0F;
/*     */     
/*  19 */     func_149676_a(0.5F - f1, 0.0F, 0.5F - f1, 0.5F + f1, f2, 0.5F + f1);
/*  20 */     func_149647_a(CreativeTabs.field_78028_d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String __OBFID = "CL_00000327";
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  29 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  34 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149655_b(IBlockAccess p_149655_1_, int p_149655_2_, int p_149655_3_, int p_149655_4_) {
/*  39 */     return !func_150118_d(p_149655_1_.func_72805_g(p_149655_2_, p_149655_3_, p_149655_4_));
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  44 */     return 0;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public AxisAlignedBB func_149633_g(World p_149633_1_, int p_149633_2_, int p_149633_3_, int p_149633_4_) {
/*  49 */     func_149719_a((IBlockAccess)p_149633_1_, p_149633_2_, p_149633_3_, p_149633_4_);
/*  50 */     return super.func_149633_g(p_149633_1_, p_149633_2_, p_149633_3_, p_149633_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
/*  55 */     func_149719_a((IBlockAccess)p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
/*  56 */     return super.func_149668_a(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
/*  61 */     func_150117_b(p_149719_1_.func_72805_g(p_149719_2_, p_149719_3_, p_149719_4_));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149683_g() {
/*  66 */     float f = 0.1875F;
/*  67 */     func_149676_a(0.0F, 0.5F - f / 2.0F, 0.0F, 1.0F, 0.5F + f / 2.0F, 1.0F);
/*     */   }
/*     */   
/*     */   public void func_150117_b(int p_150117_1_) {
/*  71 */     float f = 0.1875F;
/*     */     
/*  73 */     if ((p_150117_1_ & 0x8) != 0) {
/*  74 */       func_149676_a(0.0F, 1.0F - f, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */     } else {
/*  76 */       func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
/*     */     } 
/*     */     
/*  79 */     if (func_150118_d(p_150117_1_)) {
/*  80 */       if ((p_150117_1_ & 0x3) == 0) func_149676_a(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F); 
/*  81 */       if ((p_150117_1_ & 0x3) == 1) func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f); 
/*  82 */       if ((p_150117_1_ & 0x3) == 2) func_149676_a(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F); 
/*  83 */       if ((p_150117_1_ & 0x3) == 3) func_149676_a(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149699_a(World p_149699_1_, int p_149699_2_, int p_149699_3_, int p_149699_4_, EntityPlayer p_149699_5_) {}
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
/*  93 */     if (this.field_149764_J == Material.field_151573_f) return true;
/*     */     
/*  95 */     int i = p_149727_1_.func_72805_g(p_149727_2_, p_149727_3_, p_149727_4_);
/*  96 */     p_149727_1_.func_72921_c(p_149727_2_, p_149727_3_, p_149727_4_, i ^ 0x4, 2);
/*     */     
/*  98 */     p_149727_1_.func_72889_a(p_149727_5_, 1003, p_149727_2_, p_149727_3_, p_149727_4_, 0);
/*  99 */     return true;
/*     */   }
/*     */   
/*     */   public void func_150120_a(World p_150120_1_, int p_150120_2_, int p_150120_3_, int p_150120_4_, boolean p_150120_5_) {
/* 103 */     int i = p_150120_1_.func_72805_g(p_150120_2_, p_150120_3_, p_150120_4_);
/*     */     
/* 105 */     boolean bool = ((i & 0x4) > 0);
/* 106 */     if (bool == p_150120_5_)
/*     */       return; 
/* 108 */     p_150120_1_.func_72921_c(p_150120_2_, p_150120_3_, p_150120_4_, i ^ 0x4, 2);
/*     */     
/* 110 */     p_150120_1_.func_72889_a(null, 1003, p_150120_2_, p_150120_3_, p_150120_4_, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/* 115 */     if (p_149695_1_.field_72995_K)
/*     */       return; 
/* 117 */     int i = p_149695_1_.func_72805_g(p_149695_2_, p_149695_3_, p_149695_4_);
/* 118 */     int j = p_149695_2_;
/* 119 */     int k = p_149695_4_;
/* 120 */     if ((i & 0x3) == 0) k++; 
/* 121 */     if ((i & 0x3) == 1) k--; 
/* 122 */     if ((i & 0x3) == 2) j++; 
/* 123 */     if ((i & 0x3) == 3) j--;
/*     */     
/* 125 */     if (!func_150119_a(p_149695_1_.func_147439_a(j, p_149695_3_, k))) {
/* 126 */       p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_, p_149695_4_);
/* 127 */       func_149697_b(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, i, 0);
/*     */     } 
/*     */     
/* 130 */     boolean bool = p_149695_1_.func_72864_z(p_149695_2_, p_149695_3_, p_149695_4_);
/* 131 */     if (bool || p_149695_5_.func_149744_f()) {
/* 132 */       func_150120_a(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, bool);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public MovingObjectPosition func_149731_a(World p_149731_1_, int p_149731_2_, int p_149731_3_, int p_149731_4_, Vec3 p_149731_5_, Vec3 p_149731_6_) {
/* 138 */     func_149719_a((IBlockAccess)p_149731_1_, p_149731_2_, p_149731_3_, p_149731_4_);
/* 139 */     return super.func_149731_a(p_149731_1_, p_149731_2_, p_149731_3_, p_149731_4_, p_149731_5_, p_149731_6_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149660_a(World p_149660_1_, int p_149660_2_, int p_149660_3_, int p_149660_4_, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_) {
/* 152 */     int i = 0;
/* 153 */     if (p_149660_5_ == 2) i = 0; 
/* 154 */     if (p_149660_5_ == 3) i = 1; 
/* 155 */     if (p_149660_5_ == 4) i = 2; 
/* 156 */     if (p_149660_5_ == 5) i = 3; 
/* 157 */     if (p_149660_5_ != 1 && p_149660_5_ != 0 && p_149660_7_ > 0.5F) i |= 0x8; 
/* 158 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149707_d(World p_149707_1_, int p_149707_2_, int p_149707_3_, int p_149707_4_, int p_149707_5_) {
/* 163 */     if (p_149707_5_ == 0) return false; 
/* 164 */     if (p_149707_5_ == 1) return false; 
/* 165 */     if (p_149707_5_ == 2) p_149707_4_++; 
/* 166 */     if (p_149707_5_ == 3) p_149707_4_--; 
/* 167 */     if (p_149707_5_ == 4) p_149707_2_++; 
/* 168 */     if (p_149707_5_ == 5) p_149707_2_--;
/*     */     
/* 170 */     return func_150119_a(p_149707_1_.func_147439_a(p_149707_2_, p_149707_3_, p_149707_4_));
/*     */   }
/*     */   
/*     */   public static boolean func_150118_d(int p_150118_0_) {
/* 174 */     return ((p_150118_0_ & 0x4) != 0);
/*     */   }
/*     */   
/*     */   private static boolean func_150119_a(Block p_150119_0_) {
/* 178 */     return ((p_150119_0_.field_149764_J.func_76218_k() && p_150119_0_.func_149686_d()) || p_150119_0_ == Blocks.field_150426_aN || p_150119_0_ instanceof BlockSlab || p_150119_0_ instanceof BlockStairs);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockTrapDoor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */