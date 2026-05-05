/*     */ package net.minecraft.item;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class ItemBucket extends Item {
/*     */   private Block field_77876_a;
/*     */   
/*     */   public ItemBucket(Block p_i45331_1_) {
/*  14 */     this.field_77777_bU = 1;
/*  15 */     this.field_77876_a = p_i45331_1_;
/*  16 */     func_77637_a(CreativeTabs.field_78026_f);
/*     */   }
/*     */   private static final String __OBFID = "CL_00000000";
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
/*  21 */     boolean bool = (this.field_77876_a == Blocks.field_150350_a) ? true : false;
/*     */     
/*  23 */     MovingObjectPosition movingObjectPosition = func_77621_a(p_77659_2_, p_77659_3_, bool);
/*  24 */     if (movingObjectPosition == null) return p_77659_1_;
/*     */     
/*  26 */     if (movingObjectPosition.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) {
/*  27 */       int i = movingObjectPosition.field_72311_b;
/*  28 */       int j = movingObjectPosition.field_72312_c;
/*  29 */       int k = movingObjectPosition.field_72309_d;
/*     */       
/*  31 */       if (!p_77659_2_.func_72962_a(p_77659_3_, i, j, k)) {
/*  32 */         return p_77659_1_;
/*     */       }
/*     */       
/*  35 */       if (bool)
/*  36 */       { if (!p_77659_3_.func_82247_a(i, j, k, movingObjectPosition.field_72310_e, p_77659_1_)) return p_77659_1_; 
/*  37 */         Material material = p_77659_2_.func_147439_a(i, j, k).func_149688_o();
/*  38 */         int m = p_77659_2_.func_72805_g(i, j, k);
/*     */         
/*  40 */         if (material == Material.field_151586_h && m == 0) {
/*  41 */           p_77659_2_.func_147468_f(i, j, k);
/*  42 */           return func_150910_a(p_77659_1_, p_77659_3_, Items.field_151131_as);
/*     */         } 
/*     */         
/*  45 */         if (material == Material.field_151587_i && m == 0) {
/*  46 */           p_77659_2_.func_147468_f(i, j, k);
/*  47 */           return func_150910_a(p_77659_1_, p_77659_3_, Items.field_151129_at);
/*     */         }  }
/*  49 */       else { if (this.field_77876_a == Blocks.field_150350_a) {
/*  50 */           return new ItemStack(Items.field_151133_ar);
/*     */         }
/*  52 */         if (movingObjectPosition.field_72310_e == 0) j--; 
/*  53 */         if (movingObjectPosition.field_72310_e == 1) j++; 
/*  54 */         if (movingObjectPosition.field_72310_e == 2) k--; 
/*  55 */         if (movingObjectPosition.field_72310_e == 3) k++; 
/*  56 */         if (movingObjectPosition.field_72310_e == 4) i--; 
/*  57 */         if (movingObjectPosition.field_72310_e == 5) i++;
/*     */         
/*  59 */         if (!p_77659_3_.func_82247_a(i, j, k, movingObjectPosition.field_72310_e, p_77659_1_)) return p_77659_1_;
/*     */         
/*  61 */         if (func_77875_a(p_77659_2_, i, j, k) && !p_77659_3_.field_71075_bZ.field_75098_d) {
/*  62 */           return new ItemStack(Items.field_151133_ar);
/*     */         } }
/*     */     
/*     */     } 
/*     */     
/*  67 */     return p_77659_1_;
/*     */   }
/*     */   
/*     */   private ItemStack func_150910_a(ItemStack p_150910_1_, EntityPlayer p_150910_2_, Item p_150910_3_) {
/*  71 */     if (p_150910_2_.field_71075_bZ.field_75098_d) {
/*  72 */       return p_150910_1_;
/*     */     }
/*     */     
/*  75 */     if (--p_150910_1_.field_77994_a <= 0) {
/*  76 */       return new ItemStack(p_150910_3_);
/*     */     }
/*  78 */     if (!p_150910_2_.field_71071_by.func_70441_a(new ItemStack(p_150910_3_))) {
/*  79 */       p_150910_2_.func_71019_a(new ItemStack(p_150910_3_, 1, 0), false);
/*     */     }
/*  81 */     return p_150910_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_77875_a(World p_77875_1_, int p_77875_2_, int p_77875_3_, int p_77875_4_) {
/*  86 */     if (this.field_77876_a == Blocks.field_150350_a) return false;
/*     */     
/*  88 */     Material material = p_77875_1_.func_147439_a(p_77875_2_, p_77875_3_, p_77875_4_).func_149688_o();
/*  89 */     boolean bool = !material.func_76220_a() ? true : false;
/*  90 */     if (p_77875_1_.func_147437_c(p_77875_2_, p_77875_3_, p_77875_4_) || bool) {
/*  91 */       if (p_77875_1_.field_73011_w.field_76575_d && this.field_77876_a == Blocks.field_150358_i) {
/*  92 */         p_77875_1_.func_72908_a((p_77875_2_ + 0.5F), (p_77875_3_ + 0.5F), (p_77875_4_ + 0.5F), "random.fizz", 0.5F, 2.6F + (p_77875_1_.field_73012_v.nextFloat() - p_77875_1_.field_73012_v.nextFloat()) * 0.8F);
/*     */         
/*  94 */         for (byte b = 0; b < 8; b++) {
/*  95 */           p_77875_1_.func_72869_a("largesmoke", p_77875_2_ + Math.random(), p_77875_3_ + Math.random(), p_77875_4_ + Math.random(), 0.0D, 0.0D, 0.0D);
/*     */         }
/*     */       } else {
/*  98 */         if (!p_77875_1_.field_72995_K && bool && !material.func_76224_d()) {
/*  99 */           p_77875_1_.func_147480_a(p_77875_2_, p_77875_3_, p_77875_4_, true);
/*     */         }
/*     */         
/* 102 */         p_77875_1_.func_147465_d(p_77875_2_, p_77875_3_, p_77875_4_, this.field_77876_a, 0, 3);
/*     */       } 
/*     */       
/* 105 */       return true;
/*     */     } 
/*     */     
/* 108 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemBucket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */