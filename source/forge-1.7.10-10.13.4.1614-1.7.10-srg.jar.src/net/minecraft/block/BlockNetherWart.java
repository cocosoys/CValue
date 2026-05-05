/*     */ package net.minecraft.block;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockNetherWart extends BlockBush {
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon[] field_149883_a;
/*     */   
/*     */   protected BlockNetherWart() {
/*  16 */     func_149675_a(true);
/*  17 */     float f = 0.5F;
/*  18 */     func_149676_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
/*  19 */     func_149647_a(null);
/*     */   }
/*     */   private static final String __OBFID = "CL_00000274";
/*     */   
/*     */   protected boolean func_149854_a(Block p_149854_1_) {
/*  24 */     return (p_149854_1_ == Blocks.field_150425_aM);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149718_j(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_) {
/*  29 */     return func_149854_a(p_149718_1_.func_147439_a(p_149718_2_, p_149718_3_ - 1, p_149718_4_));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/*  35 */     int i = p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_);
/*  36 */     if (i < 3)
/*     */     {
/*  38 */       if (p_149674_5_.nextInt(10) == 0) {
/*  39 */         i++;
/*  40 */         p_149674_1_.func_72921_c(p_149674_2_, p_149674_3_, p_149674_4_, i, 2);
/*     */       } 
/*     */     }
/*     */     
/*  44 */     super.func_149674_a(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/*  55 */     if (p_149691_2_ >= 3) {
/*  56 */       return this.field_149883_a[2];
/*     */     }
/*  58 */     if (p_149691_2_ > 0) {
/*  59 */       return this.field_149883_a[1];
/*     */     }
/*  61 */     return this.field_149883_a[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  66 */     return 6;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149690_a(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_) {
/*  75 */     if (p_149690_1_.field_72995_K) {
/*     */       return;
/*     */     }
/*  78 */     int i = 1;
/*  79 */     if (p_149690_5_ >= 3) {
/*  80 */       i = 2 + p_149690_1_.field_73012_v.nextInt(3);
/*  81 */       if (p_149690_7_ > 0) {
/*  82 */         i += p_149690_1_.field_73012_v.nextInt(p_149690_7_ + 1);
/*     */       }
/*     */     } 
/*  85 */     for (byte b = 0; b < i; b++) {
/*  86 */       func_149642_a(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, new ItemStack(Items.field_151075_bm));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/*  92 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149745_a(Random p_149745_1_) {
/*  97 */     return 0;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
/* 102 */     return Items.field_151075_bm;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 107 */     this.field_149883_a = new IIcon[3];
/*     */     
/* 109 */     for (byte b = 0; b < this.field_149883_a.length; b++)
/* 110 */       this.field_149883_a[b] = p_149651_1_.func_94245_a(func_149641_N() + "_stage_" + b); 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockNetherWart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */