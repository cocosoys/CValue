/*     */ package net.minecraft.block;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockCake extends Block {
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon field_150038_a;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon field_150037_b;
/*     */   
/*     */   protected BlockCake() {
/*  22 */     super(Material.field_151568_F);
/*  23 */     func_149675_a(true);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon field_150039_M; private static final String __OBFID = "CL_00000211";
/*     */   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
/*  28 */     int i = p_149719_1_.func_72805_g(p_149719_2_, p_149719_3_, p_149719_4_);
/*  29 */     float f1 = 0.0625F;
/*  30 */     float f2 = (1 + i * 2) / 16.0F;
/*  31 */     float f3 = 0.5F;
/*  32 */     func_149676_a(f2, 0.0F, f1, 1.0F - f1, f3, 1.0F - f1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149683_g() {
/*  37 */     float f1 = 0.0625F;
/*  38 */     float f2 = 0.5F;
/*  39 */     func_149676_a(f1, 0.0F, f1, 1.0F - f1, f2, 1.0F - f1);
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
/*  44 */     int i = p_149668_1_.func_72805_g(p_149668_2_, p_149668_3_, p_149668_4_);
/*  45 */     float f1 = 0.0625F;
/*  46 */     float f2 = (1 + i * 2) / 16.0F;
/*  47 */     float f3 = 0.5F;
/*  48 */     return AxisAlignedBB.func_72330_a((p_149668_2_ + f2), p_149668_3_, (p_149668_4_ + f1), ((p_149668_2_ + 1) - f1), (p_149668_3_ + f3 - f1), ((p_149668_4_ + 1) - f1));
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public AxisAlignedBB func_149633_g(World p_149633_1_, int p_149633_2_, int p_149633_3_, int p_149633_4_) {
/*  53 */     int i = p_149633_1_.func_72805_g(p_149633_2_, p_149633_3_, p_149633_4_);
/*  54 */     float f1 = 0.0625F;
/*  55 */     float f2 = (1 + i * 2) / 16.0F;
/*  56 */     float f3 = 0.5F;
/*  57 */     return AxisAlignedBB.func_72330_a((p_149633_2_ + f2), p_149633_3_, (p_149633_4_ + f1), ((p_149633_2_ + 1) - f1), (p_149633_3_ + f3), ((p_149633_4_ + 1) - f1));
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/*  62 */     if (p_149691_1_ == 1) return this.field_150038_a; 
/*  63 */     if (p_149691_1_ == 0) return this.field_150037_b; 
/*  64 */     if (p_149691_2_ > 0 && p_149691_1_ == 4) return this.field_150039_M; 
/*  65 */     return this.field_149761_L;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/*  70 */     this.field_149761_L = p_149651_1_.func_94245_a(func_149641_N() + "_side");
/*  71 */     this.field_150039_M = p_149651_1_.func_94245_a(func_149641_N() + "_inner");
/*  72 */     this.field_150038_a = p_149651_1_.func_94245_a(func_149641_N() + "_top");
/*  73 */     this.field_150037_b = p_149651_1_.func_94245_a(func_149641_N() + "_bottom");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  78 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  83 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
/*  88 */     func_150036_b(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, p_149727_5_);
/*  89 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149699_a(World p_149699_1_, int p_149699_2_, int p_149699_3_, int p_149699_4_, EntityPlayer p_149699_5_) {
/*  94 */     func_150036_b(p_149699_1_, p_149699_2_, p_149699_3_, p_149699_4_, p_149699_5_);
/*     */   }
/*     */   
/*     */   private void func_150036_b(World p_150036_1_, int p_150036_2_, int p_150036_3_, int p_150036_4_, EntityPlayer p_150036_5_) {
/*  98 */     if (p_150036_5_.func_71043_e(false)) {
/*  99 */       p_150036_5_.func_71024_bL().func_75122_a(2, 0.1F);
/*     */       
/* 101 */       int i = p_150036_1_.func_72805_g(p_150036_2_, p_150036_3_, p_150036_4_) + 1;
/* 102 */       if (i >= 6) {
/* 103 */         p_150036_1_.func_147468_f(p_150036_2_, p_150036_3_, p_150036_4_);
/*     */       } else {
/* 105 */         p_150036_1_.func_72921_c(p_150036_2_, p_150036_3_, p_150036_4_, i, 2);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
/* 112 */     if (!super.func_149742_c(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_)) return false;
/*     */     
/* 114 */     return func_149718_j(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/* 119 */     if (!func_149718_j(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_)) {
/* 120 */       p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_, p_149695_4_);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149718_j(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_) {
/* 126 */     return p_149718_1_.func_147439_a(p_149718_2_, p_149718_3_ - 1, p_149718_4_).func_149688_o().func_76220_a();
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149745_a(Random p_149745_1_) {
/* 131 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 136 */     return null;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
/* 141 */     return Items.field_151105_aU;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockCake.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */