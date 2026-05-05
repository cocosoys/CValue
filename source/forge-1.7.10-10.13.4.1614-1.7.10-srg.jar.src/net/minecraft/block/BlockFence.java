/*     */ package net.minecraft.block;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockFence extends Block {
/*     */   private final String field_149827_a;
/*     */   
/*     */   public BlockFence(String p_i45406_1_, Material p_i45406_2_) {
/*  17 */     super(p_i45406_2_);
/*  18 */     this.field_149827_a = p_i45406_1_;
/*  19 */     func_149647_a(CreativeTabs.field_78031_c);
/*     */   }
/*     */   private static final String __OBFID = "CL_00000242";
/*     */   
/*     */   public void func_149743_a(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_) {
/*  24 */     boolean bool1 = func_149826_e((IBlockAccess)p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_ - 1);
/*  25 */     boolean bool2 = func_149826_e((IBlockAccess)p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_ + 1);
/*  26 */     boolean bool3 = func_149826_e((IBlockAccess)p_149743_1_, p_149743_2_ - 1, p_149743_3_, p_149743_4_);
/*  27 */     boolean bool4 = func_149826_e((IBlockAccess)p_149743_1_, p_149743_2_ + 1, p_149743_3_, p_149743_4_);
/*     */     
/*  29 */     float f1 = 0.375F;
/*  30 */     float f2 = 0.625F;
/*  31 */     float f3 = 0.375F;
/*  32 */     float f4 = 0.625F;
/*     */     
/*  34 */     if (bool1) {
/*  35 */       f3 = 0.0F;
/*     */     }
/*  37 */     if (bool2) {
/*  38 */       f4 = 1.0F;
/*     */     }
/*  40 */     if (bool1 || bool2) {
/*  41 */       func_149676_a(f1, 0.0F, f3, f2, 1.5F, f4);
/*  42 */       super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/*     */     } 
/*  44 */     f3 = 0.375F;
/*  45 */     f4 = 0.625F;
/*  46 */     if (bool3) {
/*  47 */       f1 = 0.0F;
/*     */     }
/*  49 */     if (bool4) {
/*  50 */       f2 = 1.0F;
/*     */     }
/*  52 */     if (bool3 || bool4 || (!bool1 && !bool2)) {
/*  53 */       func_149676_a(f1, 0.0F, f3, f2, 1.5F, f4);
/*  54 */       super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/*     */     } 
/*     */     
/*  57 */     if (bool1) {
/*  58 */       f3 = 0.0F;
/*     */     }
/*  60 */     if (bool2) {
/*  61 */       f4 = 1.0F;
/*     */     }
/*     */     
/*  64 */     func_149676_a(f1, 0.0F, f3, f2, 1.0F, f4);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
/*  69 */     boolean bool1 = func_149826_e(p_149719_1_, p_149719_2_, p_149719_3_, p_149719_4_ - 1);
/*  70 */     boolean bool2 = func_149826_e(p_149719_1_, p_149719_2_, p_149719_3_, p_149719_4_ + 1);
/*  71 */     boolean bool3 = func_149826_e(p_149719_1_, p_149719_2_ - 1, p_149719_3_, p_149719_4_);
/*  72 */     boolean bool4 = func_149826_e(p_149719_1_, p_149719_2_ + 1, p_149719_3_, p_149719_4_);
/*     */     
/*  74 */     float f1 = 0.375F;
/*  75 */     float f2 = 0.625F;
/*  76 */     float f3 = 0.375F;
/*  77 */     float f4 = 0.625F;
/*     */     
/*  79 */     if (bool1) {
/*  80 */       f3 = 0.0F;
/*     */     }
/*  82 */     if (bool2) {
/*  83 */       f4 = 1.0F;
/*     */     }
/*  85 */     if (bool3) {
/*  86 */       f1 = 0.0F;
/*     */     }
/*  88 */     if (bool4) {
/*  89 */       f2 = 1.0F;
/*     */     }
/*     */     
/*  92 */     func_149676_a(f1, 0.0F, f3, f2, 1.0F, f4);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  97 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 102 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149655_b(IBlockAccess p_149655_1_, int p_149655_2_, int p_149655_3_, int p_149655_4_) {
/* 107 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 112 */     return 11;
/*     */   }
/*     */   
/*     */   public boolean func_149826_e(IBlockAccess p_149826_1_, int p_149826_2_, int p_149826_3_, int p_149826_4_) {
/* 116 */     Block block = p_149826_1_.func_147439_a(p_149826_2_, p_149826_3_, p_149826_4_);
/* 117 */     if (block == this || block == Blocks.field_150396_be) {
/* 118 */       return true;
/*     */     }
/* 120 */     if (block.field_149764_J.func_76218_k() && block.func_149686_d()) {
/* 121 */       return (block.field_149764_J != Material.field_151572_C);
/*     */     }
/* 123 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean func_149825_a(Block p_149825_0_) {
/* 127 */     return (p_149825_0_ == Blocks.field_150422_aJ || p_149825_0_ == Blocks.field_150386_bk);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149646_a(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
/* 132 */     return true;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 137 */     this.field_149761_L = p_149651_1_.func_94245_a(this.field_149827_a);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
/* 142 */     if (p_149727_1_.field_72995_K) return true; 
/* 143 */     if (ItemLead.func_150909_a(p_149727_5_, p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_)) {
/* 144 */       return true;
/*     */     }
/* 146 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockFence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */