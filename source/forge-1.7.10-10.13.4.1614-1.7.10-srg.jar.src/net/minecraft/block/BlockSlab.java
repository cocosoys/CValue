/*     */ package net.minecraft.block;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.Facing;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public abstract class BlockSlab extends Block {
/*     */   protected final boolean field_150004_a;
/*     */   
/*     */   public BlockSlab(boolean p_i45410_1_, Material p_i45410_2_) {
/*  20 */     super(p_i45410_2_);
/*  21 */     this.field_150004_a = p_i45410_1_;
/*     */     
/*  23 */     if (p_i45410_1_) {
/*  24 */       this.field_149787_q = true;
/*     */     } else {
/*  26 */       func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
/*     */     } 
/*  28 */     func_149713_g(255);
/*     */   }
/*     */   private static final String __OBFID = "CL_00000253";
/*     */   
/*     */   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
/*  33 */     if (this.field_150004_a) {
/*  34 */       func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */     } else {
/*  36 */       boolean bool = ((p_149719_1_.func_72805_g(p_149719_2_, p_149719_3_, p_149719_4_) & 0x8) != 0) ? true : false;
/*  37 */       if (bool) {
/*  38 */         func_149676_a(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */       } else {
/*  40 */         func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149683_g() {
/*  47 */     if (this.field_150004_a) {
/*  48 */       func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */     } else {
/*  50 */       func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149743_a(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_) {
/*  56 */     func_149719_a((IBlockAccess)p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_);
/*  57 */     super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  62 */     return this.field_150004_a;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149660_a(World p_149660_1_, int p_149660_2_, int p_149660_3_, int p_149660_4_, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_) {
/*  67 */     if (this.field_150004_a) return p_149660_9_;
/*     */     
/*  69 */     if (p_149660_5_ == 0 || (p_149660_5_ != 1 && p_149660_7_ > 0.5D)) {
/*  70 */       return p_149660_9_ | 0x8;
/*     */     }
/*  72 */     return p_149660_9_;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149745_a(Random p_149745_1_) {
/*  77 */     if (this.field_150004_a) {
/*  78 */       return 2;
/*     */     }
/*  80 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149692_a(int p_149692_1_) {
/*  85 */     return p_149692_1_ & 0x7;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  90 */     return this.field_150004_a;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149646_a(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
/*  95 */     if (this.field_150004_a) return super.func_149646_a(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_);
/*     */     
/*  97 */     if (p_149646_5_ != 1 && p_149646_5_ != 0 && !super.func_149646_a(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_)) {
/*  98 */       return false;
/*     */     }
/*     */     
/* 101 */     int i = p_149646_2_, j = p_149646_3_, k = p_149646_4_;
/* 102 */     i += Facing.field_71586_b[Facing.field_71588_a[p_149646_5_]];
/* 103 */     j += Facing.field_71587_c[Facing.field_71588_a[p_149646_5_]];
/* 104 */     k += Facing.field_71585_d[Facing.field_71588_a[p_149646_5_]];
/*     */     
/* 106 */     boolean bool = ((p_149646_1_.func_72805_g(i, j, k) & 0x8) != 0) ? true : false;
/* 107 */     if (bool) {
/* 108 */       if (p_149646_5_ == 0) return true; 
/* 109 */       if (p_149646_5_ == 1 && super.func_149646_a(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_)) return true; 
/* 110 */       return (!func_150003_a(p_149646_1_.func_147439_a(p_149646_2_, p_149646_3_, p_149646_4_)) || (p_149646_1_.func_72805_g(p_149646_2_, p_149646_3_, p_149646_4_) & 0x8) == 0);
/*     */     } 
/* 112 */     if (p_149646_5_ == 1) return true; 
/* 113 */     if (p_149646_5_ == 0 && super.func_149646_a(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_)) return true; 
/* 114 */     return (!func_150003_a(p_149646_1_.func_147439_a(p_149646_2_, p_149646_3_, p_149646_4_)) || (p_149646_1_.func_72805_g(p_149646_2_, p_149646_3_, p_149646_4_) & 0x8) != 0);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   private static boolean func_150003_a(Block p_150003_0_) {
/* 119 */     return (p_150003_0_ == Blocks.field_150333_U || p_150003_0_ == Blocks.field_150376_bx);
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract String func_150002_b(int paramInt);
/*     */   
/*     */   public int func_149643_k(World p_149643_1_, int p_149643_2_, int p_149643_3_, int p_149643_4_) {
/* 126 */     return super.func_149643_k(p_149643_1_, p_149643_2_, p_149643_3_, p_149643_4_) & 0x7;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
/* 131 */     if (func_150003_a(this)) {
/* 132 */       return Item.func_150898_a(this);
/*     */     }
/* 134 */     if (this == Blocks.field_150334_T) {
/* 135 */       return Item.func_150898_a(Blocks.field_150333_U);
/*     */     }
/* 137 */     if (this == Blocks.field_150373_bw) {
/* 138 */       return Item.func_150898_a(Blocks.field_150376_bx);
/*     */     }
/* 140 */     return Item.func_150898_a(Blocks.field_150333_U);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockSlab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */