/*     */ package net.minecraft.block;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockRedstoneRepeater
/*     */   extends BlockRedstoneDiode
/*     */ {
/*  16 */   public static final double[] field_149973_b = new double[] { -0.0625D, 0.0625D, 0.1875D, 0.3125D };
/*     */ 
/*     */ 
/*     */   
/*  20 */   private static final int[] field_149974_M = new int[] { 1, 2, 3, 4 };
/*     */   
/*     */   private static final String __OBFID = "CL_00000301";
/*     */   
/*     */   protected BlockRedstoneRepeater(boolean p_i45424_1_) {
/*  25 */     super(p_i45424_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
/*  30 */     int i = p_149727_1_.func_72805_g(p_149727_2_, p_149727_3_, p_149727_4_);
/*  31 */     int j = (i & 0xC) >> 2;
/*  32 */     j = j + 1 << 2 & 0xC;
/*     */     
/*  34 */     p_149727_1_.func_72921_c(p_149727_2_, p_149727_3_, p_149727_4_, j | i & 0x3, 3);
/*  35 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int func_149901_b(int p_149901_1_) {
/*  40 */     return field_149974_M[(p_149901_1_ & 0xC) >> 2] * 2;
/*     */   }
/*     */ 
/*     */   
/*     */   protected BlockRedstoneDiode func_149906_e() {
/*  45 */     return Blocks.field_150416_aS;
/*     */   }
/*     */ 
/*     */   
/*     */   protected BlockRedstoneDiode func_149898_i() {
/*  50 */     return Blocks.field_150413_aR;
/*     */   }
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/*  55 */     return Items.field_151107_aW;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
/*  60 */     return Items.field_151107_aW;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  65 */     return 15;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149910_g(IBlockAccess p_149910_1_, int p_149910_2_, int p_149910_3_, int p_149910_4_, int p_149910_5_) {
/*  70 */     return (func_149902_h(p_149910_1_, p_149910_2_, p_149910_3_, p_149910_4_, p_149910_5_) > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean func_149908_a(Block p_149908_1_) {
/*  75 */     return func_149909_d(p_149908_1_);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149734_b(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
/*  80 */     if (!this.field_149914_a)
/*  81 */       return;  int i = p_149734_1_.func_72805_g(p_149734_2_, p_149734_3_, p_149734_4_);
/*  82 */     int j = func_149895_l(i);
/*     */     
/*  84 */     double d1 = (p_149734_2_ + 0.5F) + (p_149734_5_.nextFloat() - 0.5F) * 0.2D;
/*  85 */     double d2 = (p_149734_3_ + 0.4F) + (p_149734_5_.nextFloat() - 0.5F) * 0.2D;
/*  86 */     double d3 = (p_149734_4_ + 0.5F) + (p_149734_5_.nextFloat() - 0.5F) * 0.2D;
/*     */     
/*  88 */     double d4 = 0.0D;
/*  89 */     double d5 = 0.0D;
/*     */     
/*  91 */     if (p_149734_5_.nextInt(2) == 0) {
/*     */       
/*  93 */       switch (j) {
/*     */         case 0:
/*  95 */           d5 = -0.3125D;
/*     */           break;
/*     */         case 2:
/*  98 */           d5 = 0.3125D;
/*     */           break;
/*     */         case 3:
/* 101 */           d4 = -0.3125D;
/*     */           break;
/*     */         case 1:
/* 104 */           d4 = 0.3125D;
/*     */           break;
/*     */       } 
/*     */     
/*     */     } else {
/* 109 */       int k = (i & 0xC) >> 2;
/* 110 */       switch (j) {
/*     */         case 0:
/* 112 */           d5 = field_149973_b[k];
/*     */           break;
/*     */         case 2:
/* 115 */           d5 = -field_149973_b[k];
/*     */           break;
/*     */         case 3:
/* 118 */           d4 = field_149973_b[k];
/*     */           break;
/*     */         case 1:
/* 121 */           d4 = -field_149973_b[k];
/*     */           break;
/*     */       } 
/*     */     
/*     */     } 
/* 126 */     p_149734_1_.func_72869_a("reddust", d1 + d4, d2, d3 + d5, 0.0D, 0.0D, 0.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
/* 131 */     super.func_149749_a(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
/* 132 */     func_149911_e(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockRedstoneRepeater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */