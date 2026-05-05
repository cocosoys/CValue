/*     */ package net.minecraft.block;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.Direction;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockTripWire
/*     */   extends Block {
/*     */   public BlockTripWire() {
/*  21 */     super(Material.field_151594_q);
/*  22 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.15625F, 1.0F);
/*  23 */     func_149675_a(true);
/*     */   }
/*     */   private static final String __OBFID = "CL_00000328";
/*     */   
/*     */   public int func_149738_a(World p_149738_1_) {
/*  28 */     return 10;
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
/*  33 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  42 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  47 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149701_w() {
/*  52 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  57 */     return 30;
/*     */   }
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/*  62 */     return Items.field_151007_F;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
/*  67 */     return Items.field_151007_F;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/*  72 */     int i = p_149695_1_.func_72805_g(p_149695_2_, p_149695_3_, p_149695_4_);
/*  73 */     boolean bool1 = ((i & 0x2) == 2) ? true : false;
/*  74 */     boolean bool2 = !World.func_147466_a((IBlockAccess)p_149695_1_, p_149695_2_, p_149695_3_ - 1, p_149695_4_) ? true : false;
/*     */     
/*  76 */     if (bool1 != bool2) {
/*  77 */       func_149697_b(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, i, 0);
/*  78 */       p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_, p_149695_4_);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
/*  84 */     int i = p_149719_1_.func_72805_g(p_149719_2_, p_149719_3_, p_149719_4_);
/*  85 */     boolean bool1 = ((i & 0x4) == 4) ? true : false;
/*  86 */     boolean bool2 = ((i & 0x2) == 2) ? true : false;
/*     */     
/*  88 */     if (!bool2) {
/*  89 */       func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.09375F, 1.0F);
/*  90 */     } else if (!bool1) {
/*  91 */       func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
/*     */     } else {
/*  93 */       func_149676_a(0.0F, 0.0625F, 0.0F, 1.0F, 0.15625F, 1.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
/*  99 */     boolean bool = World.func_147466_a((IBlockAccess)p_149726_1_, p_149726_2_, p_149726_3_ - 1, p_149726_4_) ? false : true;
/* 100 */     p_149726_1_.func_72921_c(p_149726_2_, p_149726_3_, p_149726_4_, bool, 3);
/* 101 */     func_150138_a(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_, bool);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
/* 106 */     func_150138_a(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_6_ | 0x1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149681_a(World p_149681_1_, int p_149681_2_, int p_149681_3_, int p_149681_4_, int p_149681_5_, EntityPlayer p_149681_6_) {
/* 111 */     if (p_149681_1_.field_72995_K)
/*     */       return; 
/* 113 */     if (p_149681_6_.func_71045_bC() != null && p_149681_6_.func_71045_bC().func_77973_b() == Items.field_151097_aZ) {
/* 114 */       p_149681_1_.func_72921_c(p_149681_2_, p_149681_3_, p_149681_4_, p_149681_5_ | 0x8, 4);
/*     */     }
/*     */   }
/*     */   
/*     */   private void func_150138_a(World p_150138_1_, int p_150138_2_, int p_150138_3_, int p_150138_4_, int p_150138_5_) {
/* 119 */     for (byte b = 0; b < 2; b++) {
/* 120 */       for (byte b1 = 1; b1 < 42; b1++) {
/* 121 */         int i = p_150138_2_ + Direction.field_71583_a[b] * b1;
/* 122 */         int j = p_150138_4_ + Direction.field_71581_b[b] * b1;
/* 123 */         Block block = p_150138_1_.func_147439_a(i, p_150138_3_, j);
/*     */         
/* 125 */         if (block == Blocks.field_150479_bC) {
/* 126 */           int k = p_150138_1_.func_72805_g(i, p_150138_3_, j) & 0x3;
/*     */           
/* 128 */           if (k == Direction.field_71580_e[b]) {
/* 129 */             Blocks.field_150479_bC.func_150136_a(p_150138_1_, i, p_150138_3_, j, false, p_150138_1_.func_72805_g(i, p_150138_3_, j), true, b1, p_150138_5_);
/*     */           }
/*     */           break;
/*     */         } 
/* 133 */         if (block != Blocks.field_150473_bD) {
/*     */           break;
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149670_a(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_) {
/* 142 */     if (p_149670_1_.field_72995_K)
/*     */       return; 
/* 144 */     if ((p_149670_1_.func_72805_g(p_149670_2_, p_149670_3_, p_149670_4_) & 0x1) == 1) {
/*     */       return;
/*     */     }
/*     */     
/* 148 */     func_150140_e(p_149670_1_, p_149670_2_, p_149670_3_, p_149670_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/* 153 */     if (p_149674_1_.field_72995_K)
/*     */       return; 
/* 155 */     if ((p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_) & 0x1) != 1) {
/*     */       return;
/*     */     }
/*     */     
/* 159 */     func_150140_e(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_);
/*     */   }
/*     */   
/*     */   private void func_150140_e(World p_150140_1_, int p_150140_2_, int p_150140_3_, int p_150140_4_) {
/* 163 */     int i = p_150140_1_.func_72805_g(p_150140_2_, p_150140_3_, p_150140_4_);
/* 164 */     boolean bool1 = ((i & 0x1) == 1) ? true : false;
/* 165 */     boolean bool2 = false;
/*     */     
/* 167 */     List list = p_150140_1_.func_72839_b(null, AxisAlignedBB.func_72330_a(p_150140_2_ + this.field_149759_B, p_150140_3_ + this.field_149760_C, p_150140_4_ + this.field_149754_D, p_150140_2_ + this.field_149755_E, p_150140_3_ + this.field_149756_F, p_150140_4_ + this.field_149757_G));
/* 168 */     if (!list.isEmpty()) {
/* 169 */       for (Entity entity : list) {
/* 170 */         if (!entity.func_145773_az()) {
/* 171 */           bool2 = true;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     }
/* 177 */     if (bool2 && !bool1) {
/* 178 */       i |= 0x1;
/*     */     }
/*     */     
/* 181 */     if (!bool2 && bool1) {
/* 182 */       i &= 0xFFFFFFFE;
/*     */     }
/*     */     
/* 185 */     if (bool2 != bool1) {
/* 186 */       p_150140_1_.func_72921_c(p_150140_2_, p_150140_3_, p_150140_4_, i, 3);
/* 187 */       func_150138_a(p_150140_1_, p_150140_2_, p_150140_3_, p_150140_4_, i);
/*     */     } 
/*     */     
/* 190 */     if (bool2)
/* 191 */       p_150140_1_.func_147464_a(p_150140_2_, p_150140_3_, p_150140_4_, this, func_149738_a(p_150140_1_)); 
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static boolean func_150139_a(IBlockAccess p_150139_0_, int p_150139_1_, int p_150139_2_, int p_150139_3_, int p_150139_4_, int p_150139_5_) {
/* 196 */     int i = p_150139_1_ + Direction.field_71583_a[p_150139_5_];
/* 197 */     int j = p_150139_2_;
/* 198 */     int k = p_150139_3_ + Direction.field_71581_b[p_150139_5_];
/* 199 */     Block block = p_150139_0_.func_147439_a(i, j, k);
/* 200 */     boolean bool = ((p_150139_4_ & 0x2) == 2) ? true : false;
/*     */     
/* 202 */     if (block == Blocks.field_150479_bC) {
/* 203 */       int m = p_150139_0_.func_72805_g(i, j, k);
/* 204 */       int n = m & 0x3;
/*     */       
/* 206 */       return (n == Direction.field_71580_e[p_150139_5_]);
/*     */     } 
/*     */     
/* 209 */     if (block == Blocks.field_150473_bD) {
/* 210 */       int m = p_150139_0_.func_72805_g(i, j, k);
/* 211 */       boolean bool1 = ((m & 0x2) == 2) ? true : false;
/* 212 */       return (bool == bool1);
/*     */     } 
/*     */     
/* 215 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockTripWire.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */