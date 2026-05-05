/*     */ package net.minecraft.item;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.IGrowable;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.passive.EntitySheep;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class ItemDye extends Item {
/*  15 */   public static final String[] field_150923_a = new String[] { "black", "red", "green", "brown", "blue", "purple", "cyan", "silver", "gray", "pink", "lime", "yellow", "lightBlue", "magenta", "orange", "white" };
/*     */ 
/*     */   
/*  18 */   public static final String[] field_150921_b = new String[] { "black", "red", "green", "brown", "blue", "purple", "cyan", "silver", "gray", "pink", "lime", "yellow", "light_blue", "magenta", "orange", "white" };
/*     */ 
/*     */ 
/*     */   
/*  22 */   public static final int[] field_150922_c = new int[] { 1973019, 11743532, 3887386, 5320730, 2437522, 8073150, 2651799, 11250603, 4408131, 14188952, 4312372, 14602026, 6719955, 12801229, 15435844, 15790320 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon[] field_150920_d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String __OBFID = "CL_00000022";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemDye() {
/*  46 */     func_77627_a(true);
/*  47 */     func_77656_e(0);
/*  48 */     func_77637_a(CreativeTabs.field_78035_l);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_77617_a(int p_77617_1_) {
/*  53 */     int i = MathHelper.func_76125_a(p_77617_1_, 0, 15);
/*  54 */     return this.field_150920_d[i];
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_77667_c(ItemStack p_77667_1_) {
/*  59 */     int i = MathHelper.func_76125_a(p_77667_1_.func_77960_j(), 0, 15);
/*  60 */     return func_77658_a() + "." + field_150923_a[i];
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
/*  65 */     if (!p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_)) return false;
/*     */     
/*  67 */     if (p_77648_1_.func_77960_j() == 15) {
/*     */ 
/*     */       
/*  70 */       if (func_150919_a(p_77648_1_, p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_)) {
/*  71 */         if (!p_77648_3_.field_72995_K) p_77648_3_.func_72926_e(2005, p_77648_4_, p_77648_5_, p_77648_6_, 0); 
/*  72 */         return true;
/*     */       } 
/*  74 */     } else if (p_77648_1_.func_77960_j() == 3) {
/*     */ 
/*     */       
/*  77 */       Block block = p_77648_3_.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_);
/*  78 */       int i = p_77648_3_.func_72805_g(p_77648_4_, p_77648_5_, p_77648_6_);
/*     */       
/*  80 */       if (block == Blocks.field_150364_r && BlockLog.func_150165_c(i) == 3) {
/*  81 */         if (p_77648_7_ == 0) return false; 
/*  82 */         if (p_77648_7_ == 1) return false; 
/*  83 */         if (p_77648_7_ == 2) p_77648_6_--; 
/*  84 */         if (p_77648_7_ == 3) p_77648_6_++; 
/*  85 */         if (p_77648_7_ == 4) p_77648_4_--; 
/*  86 */         if (p_77648_7_ == 5) p_77648_4_++;
/*     */         
/*  88 */         if (p_77648_3_.func_147437_c(p_77648_4_, p_77648_5_, p_77648_6_)) {
/*  89 */           int j = Blocks.field_150375_by.func_149660_a(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_8_, p_77648_9_, p_77648_10_, 0);
/*  90 */           p_77648_3_.func_147465_d(p_77648_4_, p_77648_5_, p_77648_6_, Blocks.field_150375_by, j, 2);
/*  91 */           if (!p_77648_2_.field_71075_bZ.field_75098_d) {
/*  92 */             p_77648_1_.field_77994_a--;
/*     */           }
/*     */         } 
/*  95 */         return true;
/*     */       } 
/*     */     } 
/*     */     
/*  99 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean func_150919_a(ItemStack p_150919_0_, World p_150919_1_, int p_150919_2_, int p_150919_3_, int p_150919_4_) {
/* 103 */     Block block = p_150919_1_.func_147439_a(p_150919_2_, p_150919_3_, p_150919_4_);
/*     */     
/* 105 */     if (block instanceof IGrowable) {
/* 106 */       IGrowable iGrowable = (IGrowable)block;
/*     */       
/* 108 */       if (iGrowable.func_149851_a(p_150919_1_, p_150919_2_, p_150919_3_, p_150919_4_, p_150919_1_.field_72995_K)) {
/* 109 */         if (!p_150919_1_.field_72995_K) {
/* 110 */           if (iGrowable.func_149852_a(p_150919_1_, p_150919_1_.field_73012_v, p_150919_2_, p_150919_3_, p_150919_4_)) {
/* 111 */             iGrowable.func_149853_b(p_150919_1_, p_150919_1_.field_73012_v, p_150919_2_, p_150919_3_, p_150919_4_);
/*     */           }
/* 113 */           p_150919_0_.field_77994_a--;
/*     */         } 
/* 115 */         return true;
/*     */       } 
/*     */     } 
/* 118 */     return false;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static void func_150918_a(World p_150918_0_, int p_150918_1_, int p_150918_2_, int p_150918_3_, int p_150918_4_) {
/* 122 */     if (p_150918_4_ == 0) p_150918_4_ = 15;
/*     */     
/* 124 */     Block block = p_150918_0_.func_147439_a(p_150918_1_, p_150918_2_, p_150918_3_);
/* 125 */     if (block.func_149688_o() == Material.field_151579_a)
/* 126 */       return;  block.func_149719_a((IBlockAccess)p_150918_0_, p_150918_1_, p_150918_2_, p_150918_3_);
/*     */     
/* 128 */     for (byte b = 0; b < p_150918_4_; b++) {
/* 129 */       double d1 = field_77697_d.nextGaussian() * 0.02D;
/* 130 */       double d2 = field_77697_d.nextGaussian() * 0.02D;
/* 131 */       double d3 = field_77697_d.nextGaussian() * 0.02D;
/* 132 */       p_150918_0_.func_72869_a("happyVillager", (p_150918_1_ + field_77697_d.nextFloat()), p_150918_2_ + field_77697_d.nextFloat() * block.func_149669_A(), (p_150918_3_ + field_77697_d.nextFloat()), d1, d2, d3);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_111207_a(ItemStack p_111207_1_, EntityPlayer p_111207_2_, EntityLivingBase p_111207_3_) {
/* 138 */     if (p_111207_3_ instanceof EntitySheep) {
/* 139 */       EntitySheep entitySheep = (EntitySheep)p_111207_3_;
/*     */       
/* 141 */       int i = BlockColored.func_150032_b(p_111207_1_.func_77960_j());
/* 142 */       if (!entitySheep.func_70892_o() && entitySheep.func_70896_n() != i) {
/* 143 */         entitySheep.func_70891_b(i);
/* 144 */         p_111207_1_.field_77994_a--;
/*     */       } 
/*     */       
/* 147 */       return true;
/*     */     } 
/* 149 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_150895_a(Item p_150895_1_, CreativeTabs p_150895_2_, List<ItemStack> p_150895_3_) {
/* 154 */     for (byte b = 0; b < 16; b++) {
/* 155 */       p_150895_3_.add(new ItemStack(p_150895_1_, 1, b));
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94581_a(IIconRegister p_94581_1_) {
/* 161 */     this.field_150920_d = new IIcon[field_150921_b.length];
/*     */     
/* 163 */     for (byte b = 0; b < field_150921_b.length; b++)
/* 164 */       this.field_150920_d[b] = p_94581_1_.func_94245_a(func_111208_A() + "_" + field_150921_b[b]); 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemDye.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */