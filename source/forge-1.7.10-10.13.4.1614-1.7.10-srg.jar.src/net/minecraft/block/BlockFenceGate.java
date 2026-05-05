/*     */ package net.minecraft.block;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockFenceGate extends BlockDirectional {
/*     */   public BlockFenceGate() {
/*  17 */     super(Material.field_151575_d);
/*  18 */     func_149647_a(CreativeTabs.field_78028_d);
/*     */   }
/*     */   private static final String __OBFID = "CL_00000243";
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/*  23 */     return Blocks.field_150344_f.func_149733_h(p_149691_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
/*  28 */     if (!p_149742_1_.func_147439_a(p_149742_2_, p_149742_3_ - 1, p_149742_4_).func_149688_o().func_76220_a()) return false; 
/*  29 */     return super.func_149742_c(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
/*  34 */     int i = p_149668_1_.func_72805_g(p_149668_2_, p_149668_3_, p_149668_4_);
/*  35 */     if (func_149896_b(i)) {
/*  36 */       return null;
/*     */     }
/*  38 */     if (i == 2 || i == 0) {
/*  39 */       return AxisAlignedBB.func_72330_a(p_149668_2_, p_149668_3_, (p_149668_4_ + 0.375F), (p_149668_2_ + 1), (p_149668_3_ + 1.5F), (p_149668_4_ + 0.625F));
/*     */     }
/*  41 */     return AxisAlignedBB.func_72330_a((p_149668_2_ + 0.375F), p_149668_3_, p_149668_4_, (p_149668_2_ + 0.625F), (p_149668_3_ + 1.5F), (p_149668_4_ + 1));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
/*  46 */     int i = func_149895_l(p_149719_1_.func_72805_g(p_149719_2_, p_149719_3_, p_149719_4_));
/*  47 */     if (i == 2 || i == 0) {
/*  48 */       func_149676_a(0.0F, 0.0F, 0.375F, 1.0F, 1.0F, 0.625F);
/*     */     } else {
/*  50 */       func_149676_a(0.375F, 0.0F, 0.0F, 0.625F, 1.0F, 1.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  60 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  65 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149655_b(IBlockAccess p_149655_1_, int p_149655_2_, int p_149655_3_, int p_149655_4_) {
/*  70 */     return func_149896_b(p_149655_1_.func_72805_g(p_149655_2_, p_149655_3_, p_149655_4_));
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  75 */     return 21;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149689_a(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
/*  80 */     int i = (MathHelper.func_76128_c((p_149689_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 0x3) % 4;
/*  81 */     p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, i, 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
/*  86 */     int i = p_149727_1_.func_72805_g(p_149727_2_, p_149727_3_, p_149727_4_);
/*  87 */     if (func_149896_b(i)) {
/*  88 */       p_149727_1_.func_72921_c(p_149727_2_, p_149727_3_, p_149727_4_, i & 0xFFFFFFFB, 2);
/*     */     } else {
/*     */       
/*  91 */       int j = (MathHelper.func_76128_c((p_149727_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 0x3) % 4;
/*  92 */       int k = func_149895_l(i);
/*  93 */       if (k == (j + 2) % 4) {
/*  94 */         i = j;
/*     */       }
/*  96 */       p_149727_1_.func_72921_c(p_149727_2_, p_149727_3_, p_149727_4_, i | 0x4, 2);
/*     */     } 
/*  98 */     p_149727_1_.func_72889_a(p_149727_5_, 1003, p_149727_2_, p_149727_3_, p_149727_4_, 0);
/*  99 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/* 104 */     if (p_149695_1_.field_72995_K)
/*     */       return; 
/* 106 */     int i = p_149695_1_.func_72805_g(p_149695_2_, p_149695_3_, p_149695_4_);
/*     */     
/* 108 */     boolean bool = p_149695_1_.func_72864_z(p_149695_2_, p_149695_3_, p_149695_4_);
/* 109 */     if (bool || p_149695_5_.func_149744_f()) {
/* 110 */       if (bool && !func_149896_b(i)) {
/* 111 */         p_149695_1_.func_72921_c(p_149695_2_, p_149695_3_, p_149695_4_, i | 0x4, 2);
/* 112 */         p_149695_1_.func_72889_a(null, 1003, p_149695_2_, p_149695_3_, p_149695_4_, 0);
/* 113 */       } else if (!bool && func_149896_b(i)) {
/* 114 */         p_149695_1_.func_72921_c(p_149695_2_, p_149695_3_, p_149695_4_, i & 0xFFFFFFFB, 2);
/* 115 */         p_149695_1_.func_72889_a(null, 1003, p_149695_2_, p_149695_3_, p_149695_4_, 0);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static boolean func_149896_b(int p_149896_0_) {
/* 121 */     return ((p_149896_0_ & 0x4) != 0);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149646_a(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
/* 126 */     return true;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {}
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockFenceGate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */