/*     */ package net.minecraft.block;
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockRedstoneOre extends Block {
/*     */   private boolean field_150187_a;
/*     */   
/*     */   public BlockRedstoneOre(boolean p_i45420_1_) {
/*  15 */     super(Material.field_151576_e);
/*  16 */     if (p_i45420_1_) {
/*  17 */       func_149675_a(true);
/*     */     }
/*  19 */     this.field_150187_a = p_i45420_1_;
/*     */   }
/*     */   private static final String __OBFID = "CL_00000294";
/*     */   
/*     */   public int func_149738_a(World p_149738_1_) {
/*  24 */     return 30;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149699_a(World p_149699_1_, int p_149699_2_, int p_149699_3_, int p_149699_4_, EntityPlayer p_149699_5_) {
/*  29 */     func_150185_e(p_149699_1_, p_149699_2_, p_149699_3_, p_149699_4_);
/*  30 */     super.func_149699_a(p_149699_1_, p_149699_2_, p_149699_3_, p_149699_4_, p_149699_5_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149724_b(World p_149724_1_, int p_149724_2_, int p_149724_3_, int p_149724_4_, Entity p_149724_5_) {
/*  35 */     func_150185_e(p_149724_1_, p_149724_2_, p_149724_3_, p_149724_4_);
/*  36 */     super.func_149724_b(p_149724_1_, p_149724_2_, p_149724_3_, p_149724_4_, p_149724_5_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
/*  41 */     func_150185_e(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_);
/*  42 */     return super.func_149727_a(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, p_149727_5_, p_149727_6_, p_149727_7_, p_149727_8_, p_149727_9_);
/*     */   }
/*     */   
/*     */   private void func_150185_e(World p_150185_1_, int p_150185_2_, int p_150185_3_, int p_150185_4_) {
/*  46 */     func_150186_m(p_150185_1_, p_150185_2_, p_150185_3_, p_150185_4_);
/*  47 */     if (this == Blocks.field_150450_ax) {
/*  48 */       p_150185_1_.func_147449_b(p_150185_2_, p_150185_3_, p_150185_4_, Blocks.field_150439_ay);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/*  54 */     if (this == Blocks.field_150439_ay) {
/*  55 */       p_149674_1_.func_147449_b(p_149674_2_, p_149674_3_, p_149674_4_, Blocks.field_150450_ax);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/*  61 */     return Items.field_151137_ax;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149679_a(int p_149679_1_, Random p_149679_2_) {
/*  66 */     return func_149745_a(p_149679_2_) + p_149679_2_.nextInt(p_149679_1_ + 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149745_a(Random p_149745_1_) {
/*  71 */     return 4 + p_149745_1_.nextInt(2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149690_a(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_) {
/*  76 */     super.func_149690_a(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, p_149690_5_, p_149690_6_, p_149690_7_);
/*     */ 
/*     */     
/*  79 */     if (func_149650_a(p_149690_5_, p_149690_1_.field_73012_v, p_149690_7_) != Item.func_150898_a(this)) {
/*  80 */       int i = 1 + p_149690_1_.field_73012_v.nextInt(5);
/*  81 */       func_149657_c(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, i);
/*     */     } 
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149734_b(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
/*  87 */     if (this.field_150187_a) {
/*  88 */       func_150186_m(p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_);
/*     */     }
/*     */   }
/*     */   
/*     */   private void func_150186_m(World p_150186_1_, int p_150186_2_, int p_150186_3_, int p_150186_4_) {
/*  93 */     Random random = p_150186_1_.field_73012_v;
/*  94 */     double d = 0.0625D;
/*  95 */     for (byte b = 0; b < 6; b++) {
/*  96 */       double d1 = (p_150186_2_ + random.nextFloat());
/*  97 */       double d2 = (p_150186_3_ + random.nextFloat());
/*  98 */       double d3 = (p_150186_4_ + random.nextFloat());
/*  99 */       if (b == 0 && !p_150186_1_.func_147439_a(p_150186_2_, p_150186_3_ + 1, p_150186_4_).func_149662_c()) d2 = (p_150186_3_ + 1) + d; 
/* 100 */       if (b == 1 && !p_150186_1_.func_147439_a(p_150186_2_, p_150186_3_ - 1, p_150186_4_).func_149662_c()) d2 = (p_150186_3_ + 0) - d; 
/* 101 */       if (b == 2 && !p_150186_1_.func_147439_a(p_150186_2_, p_150186_3_, p_150186_4_ + 1).func_149662_c()) d3 = (p_150186_4_ + 1) + d; 
/* 102 */       if (b == 3 && !p_150186_1_.func_147439_a(p_150186_2_, p_150186_3_, p_150186_4_ - 1).func_149662_c()) d3 = (p_150186_4_ + 0) - d; 
/* 103 */       if (b == 4 && !p_150186_1_.func_147439_a(p_150186_2_ + 1, p_150186_3_, p_150186_4_).func_149662_c()) d1 = (p_150186_2_ + 1) + d; 
/* 104 */       if (b == 5 && !p_150186_1_.func_147439_a(p_150186_2_ - 1, p_150186_3_, p_150186_4_).func_149662_c()) d1 = (p_150186_2_ + 0) - d; 
/* 105 */       if (d1 < p_150186_2_ || d1 > (p_150186_2_ + 1) || d2 < 0.0D || d2 > (p_150186_3_ + 1) || d3 < p_150186_4_ || d3 > (p_150186_4_ + 1)) {
/* 106 */         p_150186_1_.func_72869_a("reddust", d1, d2, d3, 0.0D, 0.0D, 0.0D);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected ItemStack func_149644_j(int p_149644_1_) {
/* 113 */     return new ItemStack(Blocks.field_150450_ax);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockRedstoneOre.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */