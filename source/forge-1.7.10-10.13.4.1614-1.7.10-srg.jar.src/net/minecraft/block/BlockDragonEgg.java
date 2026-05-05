/*     */ package net.minecraft.block;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.item.EntityFallingBlock;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockDragonEgg extends Block {
/*     */   public BlockDragonEgg() {
/*  13 */     super(Material.field_151566_D);
/*     */     
/*  15 */     func_149676_a(0.0625F, 0.0F, 0.0625F, 0.9375F, 1.0F, 0.9375F);
/*     */   }
/*     */   private static final String __OBFID = "CL_00000232";
/*     */   
/*     */   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
/*  20 */     p_149726_1_.func_147464_a(p_149726_2_, p_149726_3_, p_149726_4_, this, func_149738_a(p_149726_1_));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/*  25 */     p_149695_1_.func_147464_a(p_149695_2_, p_149695_3_, p_149695_4_, this, func_149738_a(p_149695_1_));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/*  30 */     func_150018_e(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_);
/*     */   }
/*     */   
/*     */   private void func_150018_e(World p_150018_1_, int p_150018_2_, int p_150018_3_, int p_150018_4_) {
/*  34 */     if (BlockFalling.func_149831_e(p_150018_1_, p_150018_2_, p_150018_3_ - 1, p_150018_4_) && p_150018_3_ >= 0) {
/*  35 */       byte b = 32;
/*  36 */       if (BlockFalling.field_149832_M || !p_150018_1_.func_72904_c(p_150018_2_ - b, p_150018_3_ - b, p_150018_4_ - b, p_150018_2_ + b, p_150018_3_ + b, p_150018_4_ + b)) {
/*  37 */         p_150018_1_.func_147468_f(p_150018_2_, p_150018_3_, p_150018_4_);
/*  38 */         while (BlockFalling.func_149831_e(p_150018_1_, p_150018_2_, p_150018_3_ - 1, p_150018_4_) && p_150018_3_ > 0)
/*  39 */           p_150018_3_--; 
/*  40 */         if (p_150018_3_ > 0) {
/*  41 */           p_150018_1_.func_147465_d(p_150018_2_, p_150018_3_, p_150018_4_, this, 0, 2);
/*     */         }
/*     */       } else {
/*  44 */         EntityFallingBlock entityFallingBlock = new EntityFallingBlock(p_150018_1_, (p_150018_2_ + 0.5F), (p_150018_3_ + 0.5F), (p_150018_4_ + 0.5F), this);
/*  45 */         p_150018_1_.func_72838_d((Entity)entityFallingBlock);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
/*  52 */     func_150019_m(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_);
/*  53 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149699_a(World p_149699_1_, int p_149699_2_, int p_149699_3_, int p_149699_4_, EntityPlayer p_149699_5_) {
/*  59 */     func_150019_m(p_149699_1_, p_149699_2_, p_149699_3_, p_149699_4_);
/*     */   }
/*     */   
/*     */   private void func_150019_m(World p_150019_1_, int p_150019_2_, int p_150019_3_, int p_150019_4_) {
/*  63 */     if (p_150019_1_.func_147439_a(p_150019_2_, p_150019_3_, p_150019_4_) != this)
/*     */       return; 
/*  65 */     for (byte b = 0; b < 'Ϩ'; b++) {
/*  66 */       int i = p_150019_2_ + p_150019_1_.field_73012_v.nextInt(16) - p_150019_1_.field_73012_v.nextInt(16);
/*  67 */       int j = p_150019_3_ + p_150019_1_.field_73012_v.nextInt(8) - p_150019_1_.field_73012_v.nextInt(8);
/*  68 */       int k = p_150019_4_ + p_150019_1_.field_73012_v.nextInt(16) - p_150019_1_.field_73012_v.nextInt(16);
/*  69 */       if ((p_150019_1_.func_147439_a(i, j, k)).field_149764_J == Material.field_151579_a) {
/*  70 */         if (!p_150019_1_.field_72995_K) {
/*  71 */           p_150019_1_.func_147465_d(i, j, k, this, p_150019_1_.func_72805_g(p_150019_2_, p_150019_3_, p_150019_4_), 2);
/*  72 */           p_150019_1_.func_147468_f(p_150019_2_, p_150019_3_, p_150019_4_);
/*     */         } else {
/*  74 */           char c = '';
/*  75 */           for (byte b1 = 0; b1 < c; b1++) {
/*  76 */             double d1 = p_150019_1_.field_73012_v.nextDouble();
/*  77 */             float f1 = (p_150019_1_.field_73012_v.nextFloat() - 0.5F) * 0.2F;
/*  78 */             float f2 = (p_150019_1_.field_73012_v.nextFloat() - 0.5F) * 0.2F;
/*  79 */             float f3 = (p_150019_1_.field_73012_v.nextFloat() - 0.5F) * 0.2F;
/*     */             
/*  81 */             double d2 = i + (p_150019_2_ - i) * d1 + (p_150019_1_.field_73012_v.nextDouble() - 0.5D) * 1.0D + 0.5D;
/*  82 */             double d3 = j + (p_150019_3_ - j) * d1 + p_150019_1_.field_73012_v.nextDouble() * 1.0D - 0.5D;
/*  83 */             double d4 = k + (p_150019_4_ - k) * d1 + (p_150019_1_.field_73012_v.nextDouble() - 0.5D) * 1.0D + 0.5D;
/*  84 */             p_150019_1_.func_72869_a("portal", d2, d3, d4, f1, f2, f3);
/*     */           } 
/*     */         } 
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149738_a(World p_149738_1_) {
/*  94 */     return 5;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 103 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 108 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149646_a(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
/* 113 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 118 */     return 27;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
/* 123 */     return Item.func_150899_d(0);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockDragonEgg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */