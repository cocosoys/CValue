/*     */ package JinRyuu.DragonBC.common.Worlds;
/*     */ 
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.gen.feature.WorldGenerator;
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
/*     */ public class WorldGenOre
/*     */   extends WorldGenerator
/*     */ {
/*     */   private Block field_150519_a;
/*     */   private int numberOfBlocks;
/*     */   private Block field_150518_c;
/*     */   private static final String __OBFID = "CL_00000426";
/*     */   private int mineableBlockMeta;
/*     */   
/*     */   public WorldGenOre(Block blockToPlace, int howMeny, Block replaceableBlock) {
/*  32 */     this.field_150519_a = blockToPlace;
/*  33 */     this.numberOfBlocks = howMeny;
/*  34 */     this.field_150518_c = replaceableBlock;
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
/*     */   public WorldGenOre(Block block, int meta, int number, Block target) {
/*  46 */     this(block, number, target);
/*  47 */     this.mineableBlockMeta = meta;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
/*  55 */     float f = p_76484_2_.nextFloat() * 3.1415927F;
/*  56 */     double d0 = ((p_76484_3_ + 8) + MathHelper.func_76126_a(f) * this.numberOfBlocks / 8.0F);
/*  57 */     double d1 = ((p_76484_3_ + 8) - MathHelper.func_76126_a(f) * this.numberOfBlocks / 8.0F);
/*  58 */     double d2 = ((p_76484_5_ + 8) + MathHelper.func_76134_b(f) * this.numberOfBlocks / 8.0F);
/*  59 */     double d3 = ((p_76484_5_ + 8) - MathHelper.func_76134_b(f) * this.numberOfBlocks / 8.0F);
/*  60 */     double d4 = (p_76484_4_ + p_76484_2_.nextInt(3) - 2);
/*  61 */     double d5 = (p_76484_4_ + p_76484_2_.nextInt(3) - 2);
/*     */     
/*  63 */     for (int l = 0; l <= this.numberOfBlocks; l++) {
/*     */       
/*  65 */       double d6 = d0 + (d1 - d0) * l / this.numberOfBlocks;
/*  66 */       double d7 = d4 + (d5 - d4) * l / this.numberOfBlocks;
/*  67 */       double d8 = d2 + (d3 - d2) * l / this.numberOfBlocks;
/*  68 */       double d9 = p_76484_2_.nextDouble() * this.numberOfBlocks / 16.0D;
/*  69 */       double d10 = (MathHelper.func_76126_a(l * 3.1415927F / this.numberOfBlocks) + 1.0F) * d9 + 1.0D;
/*  70 */       double d11 = (MathHelper.func_76126_a(l * 3.1415927F / this.numberOfBlocks) + 1.0F) * d9 + 1.0D;
/*  71 */       int i1 = MathHelper.func_76128_c(d6 - d10 / 2.0D);
/*  72 */       int j1 = MathHelper.func_76128_c(d7 - d11 / 2.0D);
/*  73 */       int k1 = MathHelper.func_76128_c(d8 - d10 / 2.0D);
/*  74 */       int l1 = MathHelper.func_76128_c(d6 + d10 / 2.0D);
/*  75 */       int i2 = MathHelper.func_76128_c(d7 + d11 / 2.0D);
/*  76 */       int j2 = MathHelper.func_76128_c(d8 + d10 / 2.0D);
/*     */       
/*  78 */       for (int k2 = i1; k2 <= l1; k2++) {
/*     */         
/*  80 */         double d12 = (k2 + 0.5D - d6) / d10 / 2.0D;
/*     */         
/*  82 */         if (d12 * d12 < 1.0D)
/*     */         {
/*  84 */           for (int l2 = j1; l2 <= i2; l2++) {
/*     */             
/*  86 */             double d13 = (l2 + 0.5D - d7) / d11 / 2.0D;
/*     */             
/*  88 */             if (d12 * d12 + d13 * d13 < 1.0D)
/*     */             {
/*  90 */               for (int i3 = k1; i3 <= j2; i3++) {
/*     */                 
/*  92 */                 double d14 = (i3 + 0.5D - d8) / d10 / 2.0D;
/*     */                 
/*  94 */                 if (d12 * d12 + d13 * d13 + d14 * d14 < 1.0D && p_76484_1_.func_147439_a(k2, l2, i3).isReplaceableOreGen(p_76484_1_, k2, l2, i3, this.field_150518_c))
/*     */                 {
/*  96 */                   p_76484_1_.func_147465_d(k2, l2, i3, this.field_150519_a, this.mineableBlockMeta, 2);
/*     */                 }
/*     */               } 
/*     */             }
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 105 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Worlds\WorldGenOre.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */