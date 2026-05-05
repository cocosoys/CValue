/*     */ package net.minecraft.block;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockRedstoneTorch extends BlockTorch {
/*     */   private boolean field_150113_a;
/*     */   
/*     */   static class Toggle { int field_150847_a;
/*     */     int field_150845_b;
/*     */     
/*     */     public Toggle(int p_i45422_1_, int p_i45422_2_, int p_i45422_3_, long p_i45422_4_) {
/*  20 */       this.field_150847_a = p_i45422_1_;
/*  21 */       this.field_150845_b = p_i45422_2_;
/*  22 */       this.field_150846_c = p_i45422_3_;
/*  23 */       this.field_150844_d = p_i45422_4_;
/*     */     }
/*     */     int field_150846_c; long field_150844_d;
/*     */     private static final String __OBFID = "CL_00000299"; }
/*  27 */   private static Map field_150112_b = new HashMap<Object, Object>(); private static final String __OBFID = "CL_00000298";
/*     */   
/*     */   private boolean func_150111_a(World p_150111_1_, int p_150111_2_, int p_150111_3_, int p_150111_4_, boolean p_150111_5_) {
/*  30 */     if (!field_150112_b.containsKey(p_150111_1_)) field_150112_b.put(p_150111_1_, new ArrayList());
/*     */     
/*  32 */     List<Toggle> list = (List)field_150112_b.get(p_150111_1_);
/*  33 */     if (p_150111_5_) list.add(new Toggle(p_150111_2_, p_150111_3_, p_150111_4_, p_150111_1_.func_82737_E())); 
/*  34 */     byte b1 = 0;
/*  35 */     for (byte b2 = 0; b2 < list.size(); b2++) {
/*  36 */       Toggle toggle = list.get(b2);
/*     */       
/*  38 */       b1++;
/*  39 */       if (toggle.field_150847_a == p_150111_2_ && toggle.field_150845_b == p_150111_3_ && toggle.field_150846_c == p_150111_4_ && b1 >= 8) {
/*  40 */         return true;
/*     */       }
/*     */     } 
/*     */     
/*  44 */     return false;
/*     */   }
/*     */   
/*     */   protected BlockRedstoneTorch(boolean p_i45423_1_) {
/*  48 */     this.field_150113_a = p_i45423_1_;
/*  49 */     func_149675_a(true);
/*  50 */     func_149647_a(null);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149738_a(World p_149738_1_) {
/*  55 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
/*  60 */     if (p_149726_1_.func_72805_g(p_149726_2_, p_149726_3_, p_149726_4_) == 0) super.func_149726_b(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_); 
/*  61 */     if (this.field_150113_a) {
/*  62 */       p_149726_1_.func_147459_d(p_149726_2_, p_149726_3_ - 1, p_149726_4_, this);
/*  63 */       p_149726_1_.func_147459_d(p_149726_2_, p_149726_3_ + 1, p_149726_4_, this);
/*  64 */       p_149726_1_.func_147459_d(p_149726_2_ - 1, p_149726_3_, p_149726_4_, this);
/*  65 */       p_149726_1_.func_147459_d(p_149726_2_ + 1, p_149726_3_, p_149726_4_, this);
/*  66 */       p_149726_1_.func_147459_d(p_149726_2_, p_149726_3_, p_149726_4_ - 1, this);
/*  67 */       p_149726_1_.func_147459_d(p_149726_2_, p_149726_3_, p_149726_4_ + 1, this);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
/*  73 */     if (this.field_150113_a) {
/*  74 */       p_149749_1_.func_147459_d(p_149749_2_, p_149749_3_ - 1, p_149749_4_, this);
/*  75 */       p_149749_1_.func_147459_d(p_149749_2_, p_149749_3_ + 1, p_149749_4_, this);
/*  76 */       p_149749_1_.func_147459_d(p_149749_2_ - 1, p_149749_3_, p_149749_4_, this);
/*  77 */       p_149749_1_.func_147459_d(p_149749_2_ + 1, p_149749_3_, p_149749_4_, this);
/*  78 */       p_149749_1_.func_147459_d(p_149749_2_, p_149749_3_, p_149749_4_ - 1, this);
/*  79 */       p_149749_1_.func_147459_d(p_149749_2_, p_149749_3_, p_149749_4_ + 1, this);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149709_b(IBlockAccess p_149709_1_, int p_149709_2_, int p_149709_3_, int p_149709_4_, int p_149709_5_) {
/*  85 */     if (!this.field_150113_a) return 0;
/*     */     
/*  87 */     int i = p_149709_1_.func_72805_g(p_149709_2_, p_149709_3_, p_149709_4_);
/*     */     
/*  89 */     if (i == 5 && p_149709_5_ == 1) return 0; 
/*  90 */     if (i == 3 && p_149709_5_ == 3) return 0; 
/*  91 */     if (i == 4 && p_149709_5_ == 2) return 0; 
/*  92 */     if (i == 1 && p_149709_5_ == 5) return 0; 
/*  93 */     if (i == 2 && p_149709_5_ == 4) return 0;
/*     */     
/*  95 */     return 15;
/*     */   }
/*     */   
/*     */   private boolean func_150110_m(World p_150110_1_, int p_150110_2_, int p_150110_3_, int p_150110_4_) {
/*  99 */     int i = p_150110_1_.func_72805_g(p_150110_2_, p_150110_3_, p_150110_4_);
/*     */     
/* 101 */     if (i == 5 && p_150110_1_.func_94574_k(p_150110_2_, p_150110_3_ - 1, p_150110_4_, 0)) return true; 
/* 102 */     if (i == 3 && p_150110_1_.func_94574_k(p_150110_2_, p_150110_3_, p_150110_4_ - 1, 2)) return true; 
/* 103 */     if (i == 4 && p_150110_1_.func_94574_k(p_150110_2_, p_150110_3_, p_150110_4_ + 1, 3)) return true; 
/* 104 */     if (i == 1 && p_150110_1_.func_94574_k(p_150110_2_ - 1, p_150110_3_, p_150110_4_, 4)) return true; 
/* 105 */     if (i == 2 && p_150110_1_.func_94574_k(p_150110_2_ + 1, p_150110_3_, p_150110_4_, 5)) return true; 
/* 106 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/* 111 */     boolean bool = func_150110_m(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_);
/*     */     
/* 113 */     List list = (List)field_150112_b.get(p_149674_1_);
/* 114 */     while (list != null && !list.isEmpty() && p_149674_1_.func_82737_E() - ((Toggle)list.get(0)).field_150844_d > 60L) {
/* 115 */       list.remove(0);
/*     */     }
/*     */     
/* 118 */     if (this.field_150113_a) {
/* 119 */       if (bool) {
/* 120 */         p_149674_1_.func_147465_d(p_149674_2_, p_149674_3_, p_149674_4_, Blocks.field_150437_az, p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_), 3);
/*     */         
/* 122 */         if (func_150111_a(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, true)) {
/* 123 */           p_149674_1_.func_72908_a((p_149674_2_ + 0.5F), (p_149674_3_ + 0.5F), (p_149674_4_ + 0.5F), "random.fizz", 0.5F, 2.6F + (p_149674_1_.field_73012_v.nextFloat() - p_149674_1_.field_73012_v.nextFloat()) * 0.8F);
/* 124 */           for (byte b = 0; b < 5; b++) {
/* 125 */             double d1 = p_149674_2_ + p_149674_5_.nextDouble() * 0.6D + 0.2D;
/* 126 */             double d2 = p_149674_3_ + p_149674_5_.nextDouble() * 0.6D + 0.2D;
/* 127 */             double d3 = p_149674_4_ + p_149674_5_.nextDouble() * 0.6D + 0.2D;
/*     */             
/* 129 */             p_149674_1_.func_72869_a("smoke", d1, d2, d3, 0.0D, 0.0D, 0.0D);
/*     */           }
/*     */         
/*     */         } 
/*     */       } 
/* 134 */     } else if (!bool && 
/* 135 */       !func_150111_a(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, false)) {
/* 136 */       p_149674_1_.func_147465_d(p_149674_2_, p_149674_3_, p_149674_4_, Blocks.field_150429_aA, p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_), 3);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/* 144 */     if (func_150108_b(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_5_)) {
/*     */       return;
/*     */     }
/*     */     
/* 148 */     boolean bool = func_150110_m(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_);
/* 149 */     if ((this.field_150113_a && bool) || (!this.field_150113_a && !bool)) {
/* 150 */       p_149695_1_.func_147464_a(p_149695_2_, p_149695_3_, p_149695_4_, this, func_149738_a(p_149695_1_));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149748_c(IBlockAccess p_149748_1_, int p_149748_2_, int p_149748_3_, int p_149748_4_, int p_149748_5_) {
/* 156 */     if (p_149748_5_ == 0) {
/* 157 */       return func_149709_b(p_149748_1_, p_149748_2_, p_149748_3_, p_149748_4_, p_149748_5_);
/*     */     }
/* 159 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 164 */     return Item.func_150898_a(Blocks.field_150429_aA);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149744_f() {
/* 169 */     return true;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149734_b(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
/* 174 */     if (!this.field_150113_a)
/* 175 */       return;  int i = p_149734_1_.func_72805_g(p_149734_2_, p_149734_3_, p_149734_4_);
/* 176 */     double d1 = (p_149734_2_ + 0.5F) + (p_149734_5_.nextFloat() - 0.5F) * 0.2D;
/* 177 */     double d2 = (p_149734_3_ + 0.7F) + (p_149734_5_.nextFloat() - 0.5F) * 0.2D;
/* 178 */     double d3 = (p_149734_4_ + 0.5F) + (p_149734_5_.nextFloat() - 0.5F) * 0.2D;
/* 179 */     double d4 = 0.2199999988079071D;
/* 180 */     double d5 = 0.27000001072883606D;
/* 181 */     if (i == 1) {
/* 182 */       p_149734_1_.func_72869_a("reddust", d1 - d5, d2 + d4, d3, 0.0D, 0.0D, 0.0D);
/* 183 */     } else if (i == 2) {
/* 184 */       p_149734_1_.func_72869_a("reddust", d1 + d5, d2 + d4, d3, 0.0D, 0.0D, 0.0D);
/* 185 */     } else if (i == 3) {
/* 186 */       p_149734_1_.func_72869_a("reddust", d1, d2 + d4, d3 - d5, 0.0D, 0.0D, 0.0D);
/* 187 */     } else if (i == 4) {
/* 188 */       p_149734_1_.func_72869_a("reddust", d1, d2 + d4, d3 + d5, 0.0D, 0.0D, 0.0D);
/*     */     } else {
/* 190 */       p_149734_1_.func_72869_a("reddust", d1, d2, d3, 0.0D, 0.0D, 0.0D);
/*     */     } 
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
/* 196 */     return Item.func_150898_a(Blocks.field_150429_aA);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149667_c(Block p_149667_1_) {
/* 212 */     return (p_149667_1_ == Blocks.field_150437_az || p_149667_1_ == Blocks.field_150429_aA);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockRedstoneTorch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */