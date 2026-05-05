/*     */ package net.minecraft.block;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.tileentity.TileEntityFlowerPot;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockFlowerPot
/*     */   extends BlockContainer
/*     */ {
/*     */   private static final String __OBFID = "CL_00000247";
/*     */   
/*     */   public BlockFlowerPot() {
/*  27 */     super(Material.field_151594_q);
/*  28 */     func_149683_g();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149683_g() {
/*  33 */     float f1 = 0.375F;
/*  34 */     float f2 = f1 / 2.0F;
/*  35 */     func_149676_a(0.5F - f2, 0.0F, 0.5F - f2, 0.5F + f2, f1, 0.5F + f2);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  40 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  45 */     return 33;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  50 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
/*  55 */     ItemStack itemStack = p_149727_5_.field_71071_by.func_70448_g();
/*  56 */     if (itemStack == null || !(itemStack.func_77973_b() instanceof net.minecraft.item.ItemBlock)) return false;
/*     */     
/*  58 */     TileEntityFlowerPot tileEntityFlowerPot = func_149929_e(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_);
/*  59 */     if (tileEntityFlowerPot != null) {
/*  60 */       if (tileEntityFlowerPot.func_145965_a() != null) {
/*  61 */         return false;
/*     */       }
/*  63 */       Block block = Block.func_149634_a(itemStack.func_77973_b());
/*  64 */       if (!func_149928_a(block, itemStack.func_77960_j())) {
/*  65 */         return false;
/*     */       }
/*  67 */       tileEntityFlowerPot.func_145964_a(itemStack.func_77973_b(), itemStack.func_77960_j());
/*  68 */       tileEntityFlowerPot.func_70296_d();
/*     */       
/*  70 */       if (!p_149727_1_.func_72921_c(p_149727_2_, p_149727_3_, p_149727_4_, itemStack.func_77960_j(), 2))
/*     */       {
/*  72 */         p_149727_1_.func_147471_g(p_149727_2_, p_149727_3_, p_149727_4_);
/*     */       }
/*     */       
/*  75 */       if (!p_149727_5_.field_71075_bZ.field_75098_d && 
/*  76 */         --itemStack.field_77994_a <= 0) {
/*  77 */         p_149727_5_.field_71071_by.func_70299_a(p_149727_5_.field_71071_by.field_70461_c, null);
/*     */       }
/*     */ 
/*     */       
/*  81 */       return true;
/*     */     } 
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   private boolean func_149928_a(Block p_149928_1_, int p_149928_2_) {
/*  87 */     if (p_149928_1_ == Blocks.field_150327_N || p_149928_1_ == Blocks.field_150328_O || p_149928_1_ == Blocks.field_150434_aF || p_149928_1_ == Blocks.field_150338_P || p_149928_1_ == Blocks.field_150337_Q || p_149928_1_ == Blocks.field_150345_g || p_149928_1_ == Blocks.field_150330_I) {
/*  88 */       return true;
/*     */     }
/*  90 */     if (p_149928_1_ == Blocks.field_150329_H && p_149928_2_ == 2) {
/*  91 */       return true;
/*     */     }
/*  93 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
/*  98 */     TileEntityFlowerPot tileEntityFlowerPot = func_149929_e(p_149694_1_, p_149694_2_, p_149694_3_, p_149694_4_);
/*  99 */     if (tileEntityFlowerPot != null && tileEntityFlowerPot.func_145965_a() != null) {
/* 100 */       return tileEntityFlowerPot.func_145965_a();
/*     */     }
/* 102 */     return Items.field_151162_bE;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149643_k(World p_149643_1_, int p_149643_2_, int p_149643_3_, int p_149643_4_) {
/* 107 */     TileEntityFlowerPot tileEntityFlowerPot = func_149929_e(p_149643_1_, p_149643_2_, p_149643_3_, p_149643_4_);
/* 108 */     if (tileEntityFlowerPot != null && tileEntityFlowerPot.func_145965_a() != null) {
/* 109 */       return tileEntityFlowerPot.func_145966_b();
/*     */     }
/* 111 */     return 0;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149648_K() {
/* 116 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
/* 121 */     return (super.func_149742_c(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_) && World.func_147466_a((IBlockAccess)p_149742_1_, p_149742_2_, p_149742_3_ - 1, p_149742_4_));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/* 126 */     if (!World.func_147466_a((IBlockAccess)p_149695_1_, p_149695_2_, p_149695_3_ - 1, p_149695_4_)) {
/* 127 */       func_149697_b(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_1_.func_72805_g(p_149695_2_, p_149695_3_, p_149695_4_), 0);
/*     */       
/* 129 */       p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_, p_149695_4_);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
/* 137 */     TileEntityFlowerPot tileEntityFlowerPot = func_149929_e(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_);
/* 138 */     if (tileEntityFlowerPot != null && tileEntityFlowerPot.func_145965_a() != null) {
/* 139 */       func_149642_a(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, new ItemStack(tileEntityFlowerPot.func_145965_a(), 1, tileEntityFlowerPot.func_145966_b()));
/*     */     }
/* 141 */     super.func_149749_a(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149681_a(World p_149681_1_, int p_149681_2_, int p_149681_3_, int p_149681_4_, int p_149681_5_, EntityPlayer p_149681_6_) {
/* 146 */     super.func_149681_a(p_149681_1_, p_149681_2_, p_149681_3_, p_149681_4_, p_149681_5_, p_149681_6_);
/*     */     
/* 148 */     if (p_149681_6_.field_71075_bZ.field_75098_d) {
/* 149 */       TileEntityFlowerPot tileEntityFlowerPot = func_149929_e(p_149681_1_, p_149681_2_, p_149681_3_, p_149681_4_);
/* 150 */       if (tileEntityFlowerPot != null)
/*     */       {
/* 152 */         tileEntityFlowerPot.func_145964_a(Item.func_150899_d(0), 0);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 159 */     return Items.field_151162_bE;
/*     */   }
/*     */   
/*     */   private TileEntityFlowerPot func_149929_e(World p_149929_1_, int p_149929_2_, int p_149929_3_, int p_149929_4_) {
/* 163 */     TileEntity tileEntity = p_149929_1_.func_147438_o(p_149929_2_, p_149929_3_, p_149929_4_);
/* 164 */     if (tileEntity != null && tileEntity instanceof TileEntityFlowerPot) {
/* 165 */       return (TileEntityFlowerPot)tileEntity;
/*     */     }
/* 167 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
/* 173 */     Block block = null;
/* 174 */     byte b = 0;
/* 175 */     switch (p_149915_2_) {
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       default:
/* 226 */         return (TileEntity)new TileEntityFlowerPot(Item.func_150898_a(block), b);
/*     */       case 1:
/*     */         block = Blocks.field_150328_O;
/*     */         b = 0;
/*     */       case 2:
/*     */         block = Blocks.field_150327_N;
/*     */       case 3:
/*     */         block = Blocks.field_150345_g;
/*     */         b = 0;
/*     */       case 4:
/*     */         block = Blocks.field_150345_g;
/*     */         b = 1;
/*     */       case 5:
/*     */         block = Blocks.field_150345_g;
/*     */         b = 2;
/*     */       case 6:
/*     */         block = Blocks.field_150345_g;
/*     */         b = 3;
/*     */       case 12:
/*     */         block = Blocks.field_150345_g;
/*     */         b = 4;
/*     */       case 13:
/*     */         block = Blocks.field_150345_g;
/*     */         b = 5;
/*     */       case 7:
/*     */         block = Blocks.field_150337_Q;
/*     */       case 8:
/*     */         block = Blocks.field_150338_P;
/*     */       case 9:
/*     */         block = Blocks.field_150434_aF;
/*     */       case 10:
/*     */         block = Blocks.field_150330_I;
/*     */       case 11:
/*     */         break;
/*     */     } 
/*     */     block = Blocks.field_150329_H;
/*     */     b = 2;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockFlowerPot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */