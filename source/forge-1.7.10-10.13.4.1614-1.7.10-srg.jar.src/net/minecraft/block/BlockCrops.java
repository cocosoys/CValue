/*     */ package net.minecraft.block;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockCrops extends BlockBush implements IGrowable {
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon[] field_149867_a;
/*     */   
/*     */   protected BlockCrops() {
/*  14 */     func_149675_a(true);
/*  15 */     float f = 0.5F;
/*  16 */     func_149676_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
/*  17 */     func_149647_a(null);
/*     */     
/*  19 */     func_149711_c(0.0F);
/*  20 */     func_149672_a(field_149779_h);
/*  21 */     func_149649_H();
/*     */   }
/*     */   private static final String __OBFID = "CL_00000222";
/*     */   
/*     */   protected boolean func_149854_a(Block p_149854_1_) {
/*  26 */     return (p_149854_1_ == Blocks.field_150458_ak);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/*  31 */     super.func_149674_a(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);
/*  32 */     if (p_149674_1_.func_72957_l(p_149674_2_, p_149674_3_ + 1, p_149674_4_) >= 9) {
/*     */       
/*  34 */       int i = p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_);
/*  35 */       if (i < 7) {
/*  36 */         float f = func_149864_n(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_);
/*     */         
/*  38 */         if (p_149674_5_.nextInt((int)(25.0F / f) + 1) == 0) {
/*  39 */           i++;
/*  40 */           p_149674_1_.func_72921_c(p_149674_2_, p_149674_3_, p_149674_4_, i, 2);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_149863_m(World p_149863_1_, int p_149863_2_, int p_149863_3_, int p_149863_4_) {
/*  47 */     int i = p_149863_1_.func_72805_g(p_149863_2_, p_149863_3_, p_149863_4_) + MathHelper.func_76136_a(p_149863_1_.field_73012_v, 2, 5);
/*  48 */     if (i > 7) i = 7; 
/*  49 */     p_149863_1_.func_72921_c(p_149863_2_, p_149863_3_, p_149863_4_, i, 2);
/*     */   }
/*     */   
/*     */   private float func_149864_n(World p_149864_1_, int p_149864_2_, int p_149864_3_, int p_149864_4_) {
/*  53 */     float f = 1.0F;
/*     */     
/*  55 */     Block block1 = p_149864_1_.func_147439_a(p_149864_2_, p_149864_3_, p_149864_4_ - 1);
/*  56 */     Block block2 = p_149864_1_.func_147439_a(p_149864_2_, p_149864_3_, p_149864_4_ + 1);
/*  57 */     Block block3 = p_149864_1_.func_147439_a(p_149864_2_ - 1, p_149864_3_, p_149864_4_);
/*  58 */     Block block4 = p_149864_1_.func_147439_a(p_149864_2_ + 1, p_149864_3_, p_149864_4_);
/*     */     
/*  60 */     Block block5 = p_149864_1_.func_147439_a(p_149864_2_ - 1, p_149864_3_, p_149864_4_ - 1);
/*  61 */     Block block6 = p_149864_1_.func_147439_a(p_149864_2_ + 1, p_149864_3_, p_149864_4_ - 1);
/*  62 */     Block block7 = p_149864_1_.func_147439_a(p_149864_2_ + 1, p_149864_3_, p_149864_4_ + 1);
/*  63 */     Block block8 = p_149864_1_.func_147439_a(p_149864_2_ - 1, p_149864_3_, p_149864_4_ + 1);
/*     */     
/*  65 */     boolean bool1 = (block3 == this || block4 == this) ? true : false;
/*  66 */     boolean bool2 = (block1 == this || block2 == this) ? true : false;
/*  67 */     boolean bool3 = (block5 == this || block6 == this || block7 == this || block8 == this) ? true : false;
/*     */     
/*  69 */     for (int i = p_149864_2_ - 1; i <= p_149864_2_ + 1; i++) {
/*  70 */       for (int j = p_149864_4_ - 1; j <= p_149864_4_ + 1; j++) {
/*     */         
/*  72 */         float f1 = 0.0F;
/*  73 */         if (p_149864_1_.func_147439_a(i, p_149864_3_ - 1, j) == Blocks.field_150458_ak) {
/*  74 */           f1 = 1.0F;
/*  75 */           if (p_149864_1_.func_72805_g(i, p_149864_3_ - 1, j) > 0) f1 = 3.0F;
/*     */         
/*     */         } 
/*  78 */         if (i != p_149864_2_ || j != p_149864_4_) f1 /= 4.0F;
/*     */         
/*  80 */         f += f1;
/*     */       } 
/*     */     } 
/*  83 */     if (bool3 || (bool1 && bool2)) f /= 2.0F;
/*     */     
/*  85 */     return f;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/*  90 */     if (p_149691_2_ < 0 || p_149691_2_ > 7) p_149691_2_ = 7; 
/*  91 */     return this.field_149867_a[p_149691_2_];
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  96 */     return 6;
/*     */   }
/*     */   
/*     */   protected Item func_149866_i() {
/* 100 */     return Items.field_151014_N;
/*     */   }
/*     */   
/*     */   protected Item func_149865_P() {
/* 104 */     return Items.field_151015_O;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149690_a(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_) {
/* 114 */     super.func_149690_a(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, p_149690_5_, p_149690_6_, 0);
/*     */     
/* 116 */     if (p_149690_1_.field_72995_K) {
/*     */       return;
/*     */     }
/* 119 */     if (p_149690_5_ >= 7) {
/*     */       
/* 121 */       int i = 3 + p_149690_7_;
/* 122 */       for (byte b = 0; b < i; b++) {
/* 123 */         if (p_149690_1_.field_73012_v.nextInt(15) <= p_149690_5_) {
/* 124 */           func_149642_a(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, new ItemStack(func_149866_i(), 1, 0));
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 131 */     if (p_149650_1_ == 7) {
/* 132 */       return func_149865_P();
/*     */     }
/*     */     
/* 135 */     return func_149866_i();
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149745_a(Random p_149745_1_) {
/* 140 */     return 1;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
/* 145 */     return func_149866_i();
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 150 */     this.field_149867_a = new IIcon[8];
/*     */     
/* 152 */     for (byte b = 0; b < this.field_149867_a.length; b++) {
/* 153 */       this.field_149867_a[b] = p_149651_1_.func_94245_a(func_149641_N() + "_stage_" + b);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_) {
/* 160 */     if (p_149851_1_.func_72805_g(p_149851_2_, p_149851_3_, p_149851_4_) == 7) {
/* 161 */       return false;
/*     */     }
/* 163 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
/* 168 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_) {
/* 173 */     func_149863_m(p_149853_1_, p_149853_3_, p_149853_4_, p_149853_5_);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockCrops.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */