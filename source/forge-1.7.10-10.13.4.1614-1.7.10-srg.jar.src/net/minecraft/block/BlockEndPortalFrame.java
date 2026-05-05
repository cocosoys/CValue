/*     */ package net.minecraft.block;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockEndPortalFrame extends Block {
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon field_150023_a;
/*     */   
/*     */   public BlockEndPortalFrame() {
/*  23 */     super(Material.field_151576_e);
/*     */   } @SideOnly(Side.CLIENT)
/*     */   private IIcon field_150022_b; private static final String __OBFID = "CL_00000237";
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/*  28 */     if (p_149691_1_ == 1) {
/*  29 */       return this.field_150023_a;
/*     */     }
/*  31 */     if (p_149691_1_ == 0) {
/*  32 */       return Blocks.field_150377_bs.func_149733_h(p_149691_1_);
/*     */     }
/*  34 */     return this.field_149761_L;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/*  39 */     this.field_149761_L = p_149651_1_.func_94245_a(func_149641_N() + "_side");
/*  40 */     this.field_150023_a = p_149651_1_.func_94245_a(func_149641_N() + "_top");
/*  41 */     this.field_150022_b = p_149651_1_.func_94245_a(func_149641_N() + "_eye");
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_150021_e() {
/*  45 */     return this.field_150022_b;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  50 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  55 */     return 26;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149683_g() {
/*  60 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149743_a(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_) {
/*  65 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
/*  66 */     super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/*     */     
/*  68 */     int i = p_149743_1_.func_72805_g(p_149743_2_, p_149743_3_, p_149743_4_);
/*  69 */     if (func_150020_b(i)) {
/*  70 */       func_149676_a(0.3125F, 0.8125F, 0.3125F, 0.6875F, 1.0F, 0.6875F);
/*  71 */       super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/*     */     } 
/*  73 */     func_149683_g();
/*     */   }
/*     */   
/*     */   public static boolean func_150020_b(int p_150020_0_) {
/*  77 */     return ((p_150020_0_ & 0x4) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/*  82 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149689_a(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
/*  87 */     int i = ((MathHelper.func_76128_c((p_149689_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 0x3) + 2) % 4;
/*  88 */     p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, i, 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149740_M() {
/*  93 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149736_g(World p_149736_1_, int p_149736_2_, int p_149736_3_, int p_149736_4_, int p_149736_5_) {
/*  98 */     int i = p_149736_1_.func_72805_g(p_149736_2_, p_149736_3_, p_149736_4_);
/*     */     
/* 100 */     if (func_150020_b(i)) {
/* 101 */       return 15;
/*     */     }
/* 103 */     return 0;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockEndPortalFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */