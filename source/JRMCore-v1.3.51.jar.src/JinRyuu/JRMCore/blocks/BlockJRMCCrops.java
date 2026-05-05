/*     */ package JinRyuu.JRMCore.blocks;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockBush;
/*     */ import net.minecraft.block.IGrowable;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.IPlantable;
/*     */ import net.minecraftforge.common.util.ForgeDirection;
/*     */ 
/*     */ public class BlockJRMCCrops extends BlockBush implements IGrowable {
/*  20 */   protected int maxGrowthStage = 7;
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   protected IIcon[] iIcon;
/*     */ 
/*     */ 
/*     */   
/*     */   public BlockJRMCCrops() {
/*  29 */     func_149675_a(true);
/*  30 */     float f = 0.5F;
/*  31 */     func_149676_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
/*  32 */     func_149647_a((CreativeTabs)null);
/*  33 */     func_149711_c(0.0F);
/*  34 */     func_149672_a(field_149779_h);
/*  35 */     func_149649_H();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_149854_a(Block parBlock) {
/*  44 */     return (parBlock == Blocks.field_150458_ak);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/*  52 */     super.func_149674_a(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);
/*     */     
/*  54 */     if (p_149674_1_.func_72957_l(p_149674_2_, p_149674_3_ + 1, p_149674_4_) >= 9) {
/*     */       
/*  56 */       int l = p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_);
/*     */       
/*  58 */       if (l < 7) {
/*     */         
/*  60 */         float f = func_149864_n(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_);
/*     */         
/*  62 */         if (p_149674_5_.nextInt((int)(25.0F / f) + 1) == 0) {
/*     */           
/*  64 */           l++;
/*  65 */           if (l > this.maxGrowthStage)
/*     */           {
/*  67 */             l = this.maxGrowthStage;
/*     */           }
/*  69 */           p_149674_1_.func_72921_c(p_149674_2_, p_149674_3_, p_149674_4_, l, 2);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private float func_149864_n(World p_149864_1_, int p_149864_2_, int p_149864_3_, int p_149864_4_) {
/*  77 */     float f = 1.0F;
/*  78 */     Block block = p_149864_1_.func_147439_a(p_149864_2_, p_149864_3_, p_149864_4_ - 1);
/*  79 */     Block block1 = p_149864_1_.func_147439_a(p_149864_2_, p_149864_3_, p_149864_4_ + 1);
/*  80 */     Block block2 = p_149864_1_.func_147439_a(p_149864_2_ - 1, p_149864_3_, p_149864_4_);
/*  81 */     Block block3 = p_149864_1_.func_147439_a(p_149864_2_ + 1, p_149864_3_, p_149864_4_);
/*  82 */     Block block4 = p_149864_1_.func_147439_a(p_149864_2_ - 1, p_149864_3_, p_149864_4_ - 1);
/*  83 */     Block block5 = p_149864_1_.func_147439_a(p_149864_2_ + 1, p_149864_3_, p_149864_4_ - 1);
/*  84 */     Block block6 = p_149864_1_.func_147439_a(p_149864_2_ + 1, p_149864_3_, p_149864_4_ + 1);
/*  85 */     Block block7 = p_149864_1_.func_147439_a(p_149864_2_ - 1, p_149864_3_, p_149864_4_ + 1);
/*  86 */     boolean flag = (block2 == this || block3 == this);
/*  87 */     boolean flag1 = (block == this || block1 == this);
/*  88 */     boolean flag2 = (block4 == this || block5 == this || block6 == this || block7 == this);
/*     */     
/*  90 */     for (int l = p_149864_2_ - 1; l <= p_149864_2_ + 1; l++) {
/*     */       
/*  92 */       for (int i1 = p_149864_4_ - 1; i1 <= p_149864_4_ + 1; i1++) {
/*     */         
/*  94 */         float f1 = 0.0F;
/*     */         
/*  96 */         if (p_149864_1_.func_147439_a(l, p_149864_3_ - 1, i1).canSustainPlant((IBlockAccess)p_149864_1_, l, p_149864_3_ - 1, i1, ForgeDirection.UP, (IPlantable)this)) {
/*     */           
/*  98 */           f1 = 1.0F;
/*     */           
/* 100 */           if (p_149864_1_.func_147439_a(l, p_149864_3_ - 1, i1).isFertile(p_149864_1_, l, p_149864_3_ - 1, i1))
/*     */           {
/* 102 */             f1 = 3.0F;
/*     */           }
/*     */         } 
/*     */         
/* 106 */         if (l != p_149864_2_ || i1 != p_149864_4_)
/*     */         {
/* 108 */           f1 /= 4.0F;
/*     */         }
/*     */         
/* 111 */         f += f1;
/*     */       } 
/*     */     } 
/*     */     
/* 115 */     if (flag2 || (flag && flag1))
/*     */     {
/* 117 */       f /= 2.0F;
/*     */     }
/*     */     
/* 120 */     return f;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void incrementGrowStage(World parWorld, Random parRand, int parX, int parY, int parZ) {
/* 126 */     int growStage = parWorld.func_72805_g(parX, parY, parZ) + MathHelper.func_76136_a(parRand, 2, 5);
/*     */     
/* 128 */     if (growStage > this.maxGrowthStage)
/*     */     {
/* 130 */       growStage = this.maxGrowthStage;
/*     */     }
/* 132 */     parWorld.func_72921_c(parX, parY, parZ, growStage, 2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int p_149650_1_, Random parRand, int parFortune) {
/* 138 */     return Item.func_150898_a((Block)this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 147 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int parSide, int pargs) {
/* 157 */     if (pargs < 0 || pargs > this.maxGrowthStage)
/*     */     {
/* 159 */       pargs = this.maxGrowthStage;
/*     */     }
/* 161 */     return this.iIcon[(this.iIcon.length > pargs) ? pargs : (this.iIcon.length - 1)];
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
/*     */   
/*     */   public boolean func_149851_a(World parWorld, int parX, int parY, int parZ, boolean p_149851_5_) {
/* 178 */     return (parWorld.func_72805_g(parX, parY, parZ) != 7);
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
/*     */   public boolean func_149852_a(World p_149852_1_, Random parRand, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
/* 190 */     return true;
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
/*     */   public void func_149853_b(World parWorld, Random parRand, int parX, int parY, int parZ) {
/* 202 */     incrementGrowStage(parWorld, parRand, parX, parY, parZ);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\blocks\BlockJRMCCrops.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */