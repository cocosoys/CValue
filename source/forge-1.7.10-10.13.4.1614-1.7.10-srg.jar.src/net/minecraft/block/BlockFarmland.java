/*     */ package net.minecraft.block;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockFarmland
/*     */   extends Block {
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon field_149824_a;
/*     */   
/*     */   protected BlockFarmland() {
/*  21 */     super(Material.field_151578_c);
/*  22 */     func_149675_a(true);
/*  23 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
/*  24 */     func_149713_g(255);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon field_149823_b; private static final String __OBFID = "CL_00000241";
/*     */   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
/*  29 */     return AxisAlignedBB.func_72330_a((p_149668_2_ + 0), (p_149668_3_ + 0), (p_149668_4_ + 0), (p_149668_2_ + 1), (p_149668_3_ + 1), (p_149668_4_ + 1));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  34 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  39 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/*  44 */     if (p_149691_1_ == 1) {
/*  45 */       if (p_149691_2_ > 0) {
/*  46 */         return this.field_149824_a;
/*     */       }
/*  48 */       return this.field_149823_b;
/*     */     } 
/*     */     
/*  51 */     return Blocks.field_150346_d.func_149733_h(p_149691_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/*  56 */     if (func_149821_m(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_) || p_149674_1_.func_72951_B(p_149674_2_, p_149674_3_ + 1, p_149674_4_)) {
/*  57 */       p_149674_1_.func_72921_c(p_149674_2_, p_149674_3_, p_149674_4_, 7, 2);
/*     */     } else {
/*  59 */       int i = p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_);
/*  60 */       if (i > 0) {
/*  61 */         p_149674_1_.func_72921_c(p_149674_2_, p_149674_3_, p_149674_4_, i - 1, 2);
/*     */       }
/*  63 */       else if (!func_149822_e(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_)) {
/*  64 */         p_149674_1_.func_147449_b(p_149674_2_, p_149674_3_, p_149674_4_, Blocks.field_150346_d);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149746_a(World p_149746_1_, int p_149746_2_, int p_149746_3_, int p_149746_4_, Entity p_149746_5_, float p_149746_6_) {
/*  72 */     if (!p_149746_1_.field_72995_K && p_149746_1_.field_73012_v.nextFloat() < p_149746_6_ - 0.5F) {
/*  73 */       if (!(p_149746_5_ instanceof net.minecraft.entity.player.EntityPlayer) && !p_149746_1_.func_82736_K().func_82766_b("mobGriefing")) {
/*     */         return;
/*     */       }
/*  76 */       p_149746_1_.func_147449_b(p_149746_2_, p_149746_3_, p_149746_4_, Blocks.field_150346_d);
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean func_149822_e(World p_149822_1_, int p_149822_2_, int p_149822_3_, int p_149822_4_) {
/*  81 */     byte b = 0;
/*  82 */     for (int i = p_149822_2_ - b; i <= p_149822_2_ + b; i++) {
/*  83 */       for (int j = p_149822_4_ - b; j <= p_149822_4_ + b; j++) {
/*  84 */         Block block = p_149822_1_.func_147439_a(i, p_149822_3_ + 1, j);
/*  85 */         if (block == Blocks.field_150464_aj || block == Blocks.field_150394_bc || block == Blocks.field_150393_bb || block == Blocks.field_150469_bN || block == Blocks.field_150459_bM)
/*  86 */           return true; 
/*     */       } 
/*     */     } 
/*  89 */     return false;
/*     */   }
/*     */   
/*     */   private boolean func_149821_m(World p_149821_1_, int p_149821_2_, int p_149821_3_, int p_149821_4_) {
/*  93 */     for (int i = p_149821_2_ - 4; i <= p_149821_2_ + 4; i++) {
/*  94 */       for (int j = p_149821_3_; j <= p_149821_3_ + 1; j++) {
/*  95 */         for (int k = p_149821_4_ - 4; k <= p_149821_4_ + 4; k++) {
/*  96 */           if (p_149821_1_.func_147439_a(i, j, k).func_149688_o() == Material.field_151586_h)
/*  97 */             return true; 
/*     */         } 
/*     */       } 
/* 100 */     }  return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/* 105 */     super.func_149695_a(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_5_);
/* 106 */     Material material = p_149695_1_.func_147439_a(p_149695_2_, p_149695_3_ + 1, p_149695_4_).func_149688_o();
/* 107 */     if (material.func_76220_a()) {
/* 108 */       p_149695_1_.func_147449_b(p_149695_2_, p_149695_3_, p_149695_4_, Blocks.field_150346_d);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 118 */     return Blocks.field_150346_d.func_149650_a(0, p_149650_2_, p_149650_3_);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
/* 123 */     return Item.func_150898_a(Blocks.field_150346_d);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 128 */     this.field_149824_a = p_149651_1_.func_94245_a(func_149641_N() + "_wet");
/* 129 */     this.field_149823_b = p_149651_1_.func_94245_a(func_149641_N() + "_dry");
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockFarmland.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */