/*     */ package net.minecraft.block;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockSign extends BlockContainer {
/*     */   private Class field_149968_a;
/*     */   
/*     */   protected BlockSign(Class p_i45426_1_, boolean p_i45426_2_) {
/*  19 */     super(Material.field_151575_d);
/*  20 */     this.field_149967_b = p_i45426_2_;
/*  21 */     this.field_149968_a = p_i45426_1_;
/*  22 */     float f1 = 0.25F;
/*  23 */     float f2 = 1.0F;
/*  24 */     func_149676_a(0.5F - f1, 0.0F, 0.5F - f1, 0.5F + f1, f2, 0.5F + f1);
/*     */   }
/*     */   private boolean field_149967_b; private static final String __OBFID = "CL_00000306";
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/*  29 */     return Blocks.field_150344_f.func_149733_h(p_149691_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
/*  34 */     return null;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public AxisAlignedBB func_149633_g(World p_149633_1_, int p_149633_2_, int p_149633_3_, int p_149633_4_) {
/*  39 */     func_149719_a((IBlockAccess)p_149633_1_, p_149633_2_, p_149633_3_, p_149633_4_);
/*  40 */     return super.func_149633_g(p_149633_1_, p_149633_2_, p_149633_3_, p_149633_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
/*  45 */     if (this.field_149967_b)
/*     */       return; 
/*  47 */     int i = p_149719_1_.func_72805_g(p_149719_2_, p_149719_3_, p_149719_4_);
/*     */     
/*  49 */     float f1 = 0.28125F;
/*  50 */     float f2 = 0.78125F;
/*  51 */     float f3 = 0.0F;
/*  52 */     float f4 = 1.0F;
/*     */     
/*  54 */     float f5 = 0.125F;
/*     */     
/*  56 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*  57 */     if (i == 2) func_149676_a(f3, f1, 1.0F - f5, f4, f2, 1.0F); 
/*  58 */     if (i == 3) func_149676_a(f3, f1, 0.0F, f4, f2, f5); 
/*  59 */     if (i == 4) func_149676_a(1.0F - f5, f1, f3, 1.0F, f2, f4); 
/*  60 */     if (i == 5) func_149676_a(0.0F, f1, f3, f5, f2, f4);
/*     */   
/*     */   }
/*     */   
/*     */   public int func_149645_b() {
/*  65 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  70 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149655_b(IBlockAccess p_149655_1_, int p_149655_2_, int p_149655_3_, int p_149655_4_) {
/*  75 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  80 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
/*     */     try {
/*  86 */       return this.field_149968_a.newInstance();
/*  87 */     } catch (Exception exception) {
/*  88 */       throw new RuntimeException(exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/*  94 */     return Items.field_151155_ap;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/*  99 */     boolean bool = false;
/*     */     
/* 101 */     if (this.field_149967_b) {
/* 102 */       if (!p_149695_1_.func_147439_a(p_149695_2_, p_149695_3_ - 1, p_149695_4_).func_149688_o().func_76220_a()) bool = true; 
/*     */     } else {
/* 104 */       int i = p_149695_1_.func_72805_g(p_149695_2_, p_149695_3_, p_149695_4_);
/* 105 */       bool = true;
/* 106 */       if (i == 2 && p_149695_1_.func_147439_a(p_149695_2_, p_149695_3_, p_149695_4_ + 1).func_149688_o().func_76220_a()) bool = false; 
/* 107 */       if (i == 3 && p_149695_1_.func_147439_a(p_149695_2_, p_149695_3_, p_149695_4_ - 1).func_149688_o().func_76220_a()) bool = false; 
/* 108 */       if (i == 4 && p_149695_1_.func_147439_a(p_149695_2_ + 1, p_149695_3_, p_149695_4_).func_149688_o().func_76220_a()) bool = false; 
/* 109 */       if (i == 5 && p_149695_1_.func_147439_a(p_149695_2_ - 1, p_149695_3_, p_149695_4_).func_149688_o().func_76220_a()) bool = false; 
/*     */     } 
/* 111 */     if (bool) {
/* 112 */       func_149697_b(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_1_.func_72805_g(p_149695_2_, p_149695_3_, p_149695_4_), 0);
/* 113 */       p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_, p_149695_4_);
/*     */     } 
/*     */     
/* 116 */     super.func_149695_a(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_5_);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
/* 121 */     return Items.field_151155_ap;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {}
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockSign.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */