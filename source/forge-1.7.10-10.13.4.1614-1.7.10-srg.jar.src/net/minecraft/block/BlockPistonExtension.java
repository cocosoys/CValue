/*     */ package net.minecraft.block;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.Facing;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockPistonExtension extends Block {
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon field_150088_a;
/*     */   
/*     */   public BlockPistonExtension() {
/*  24 */     super(Material.field_76233_E);
/*  25 */     func_149672_a(field_149780_i);
/*  26 */     func_149711_c(0.5F);
/*     */   } private static final String __OBFID = "CL_00000367";
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_150086_a(IIcon p_150086_1_) {
/*  30 */     this.field_150088_a = p_150086_1_;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_150087_e() {
/*  34 */     this.field_150088_a = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149681_a(World p_149681_1_, int p_149681_2_, int p_149681_3_, int p_149681_4_, int p_149681_5_, EntityPlayer p_149681_6_) {
/*  39 */     if (p_149681_6_.field_71075_bZ.field_75098_d) {
/*  40 */       int i = func_150085_b(p_149681_5_);
/*  41 */       Block block = p_149681_1_.func_147439_a(p_149681_2_ - Facing.field_71586_b[i], p_149681_3_ - Facing.field_71587_c[i], p_149681_4_ - Facing.field_71585_d[i]);
/*  42 */       if (block == Blocks.field_150331_J || block == Blocks.field_150320_F) {
/*  43 */         p_149681_1_.func_147468_f(p_149681_2_ - Facing.field_71586_b[i], p_149681_3_ - Facing.field_71587_c[i], p_149681_4_ - Facing.field_71585_d[i]);
/*     */       }
/*     */     } 
/*  46 */     super.func_149681_a(p_149681_1_, p_149681_2_, p_149681_3_, p_149681_4_, p_149681_5_, p_149681_6_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
/*  51 */     super.func_149749_a(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
/*  52 */     int i = Facing.field_71588_a[func_150085_b(p_149749_6_)];
/*  53 */     p_149749_2_ += Facing.field_71586_b[i];
/*  54 */     p_149749_3_ += Facing.field_71587_c[i];
/*  55 */     p_149749_4_ += Facing.field_71585_d[i];
/*     */     
/*  57 */     Block block = p_149749_1_.func_147439_a(p_149749_2_, p_149749_3_, p_149749_4_);
/*  58 */     if (block == Blocks.field_150331_J || block == Blocks.field_150320_F) {
/*  59 */       p_149749_6_ = p_149749_1_.func_72805_g(p_149749_2_, p_149749_3_, p_149749_4_);
/*  60 */       if (BlockPistonBase.func_150075_c(p_149749_6_)) {
/*  61 */         block.func_149697_b(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_6_, 0);
/*  62 */         p_149749_1_.func_147468_f(p_149749_2_, p_149749_3_, p_149749_4_);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/*  70 */     int i = func_150085_b(p_149691_2_);
/*     */     
/*  72 */     if (p_149691_1_ == i) {
/*  73 */       if (this.field_150088_a != null) {
/*  74 */         return this.field_150088_a;
/*     */       }
/*  76 */       if ((p_149691_2_ & 0x8) != 0) {
/*  77 */         return BlockPistonBase.func_150074_e("piston_top_sticky");
/*     */       }
/*  79 */       return BlockPistonBase.func_150074_e("piston_top_normal");
/*     */     } 
/*  81 */     if (i < 6 && p_149691_1_ == Facing.field_71588_a[i]) {
/*  82 */       return BlockPistonBase.func_150074_e("piston_top_normal");
/*     */     }
/*  84 */     return BlockPistonBase.func_150074_e("piston_side");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {}
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  94 */     return 17;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  99 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 104 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
/* 109 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149707_d(World p_149707_1_, int p_149707_2_, int p_149707_3_, int p_149707_4_, int p_149707_5_) {
/* 114 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149745_a(Random p_149745_1_) {
/* 119 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149743_a(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_) {
/* 124 */     int i = p_149743_1_.func_72805_g(p_149743_2_, p_149743_3_, p_149743_4_);
/*     */     
/* 126 */     float f1 = 0.25F;
/* 127 */     float f2 = 0.375F;
/* 128 */     float f3 = 0.625F;
/* 129 */     float f4 = 0.25F;
/* 130 */     float f5 = 0.75F;
/*     */     
/* 132 */     switch (func_150085_b(i)) {
/*     */       case 0:
/* 134 */         func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
/* 135 */         super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/* 136 */         func_149676_a(0.375F, 0.25F, 0.375F, 0.625F, 1.0F, 0.625F);
/* 137 */         super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/*     */         break;
/*     */       case 1:
/* 140 */         func_149676_a(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
/* 141 */         super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/* 142 */         func_149676_a(0.375F, 0.0F, 0.375F, 0.625F, 0.75F, 0.625F);
/* 143 */         super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/*     */         break;
/*     */       case 2:
/* 146 */         func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
/* 147 */         super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/* 148 */         func_149676_a(0.25F, 0.375F, 0.25F, 0.75F, 0.625F, 1.0F);
/* 149 */         super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/*     */         break;
/*     */       case 3:
/* 152 */         func_149676_a(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
/* 153 */         super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/* 154 */         func_149676_a(0.25F, 0.375F, 0.0F, 0.75F, 0.625F, 0.75F);
/* 155 */         super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/*     */         break;
/*     */       case 4:
/* 158 */         func_149676_a(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
/* 159 */         super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/* 160 */         func_149676_a(0.375F, 0.25F, 0.25F, 0.625F, 0.75F, 1.0F);
/* 161 */         super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/*     */         break;
/*     */       case 5:
/* 164 */         func_149676_a(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/* 165 */         super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/* 166 */         func_149676_a(0.0F, 0.375F, 0.25F, 0.75F, 0.625F, 0.75F);
/* 167 */         super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/*     */         break;
/*     */     } 
/* 170 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
/* 175 */     int i = p_149719_1_.func_72805_g(p_149719_2_, p_149719_3_, p_149719_4_);
/*     */     
/* 177 */     float f = 0.25F;
/*     */     
/* 179 */     switch (func_150085_b(i)) {
/*     */       case 0:
/* 181 */         func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
/*     */         break;
/*     */       case 1:
/* 184 */         func_149676_a(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */         break;
/*     */       case 2:
/* 187 */         func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
/*     */         break;
/*     */       case 3:
/* 190 */         func_149676_a(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
/*     */         break;
/*     */       case 4:
/* 193 */         func_149676_a(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
/*     */         break;
/*     */       case 5:
/* 196 */         func_149676_a(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/* 203 */     int i = func_150085_b(p_149695_1_.func_72805_g(p_149695_2_, p_149695_3_, p_149695_4_));
/* 204 */     Block block = p_149695_1_.func_147439_a(p_149695_2_ - Facing.field_71586_b[i], p_149695_3_ - Facing.field_71587_c[i], p_149695_4_ - Facing.field_71585_d[i]);
/* 205 */     if (block != Blocks.field_150331_J && block != Blocks.field_150320_F) {
/* 206 */       p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_, p_149695_4_);
/*     */     } else {
/* 208 */       block.func_149695_a(p_149695_1_, p_149695_2_ - Facing.field_71586_b[i], p_149695_3_ - Facing.field_71587_c[i], p_149695_4_ - Facing.field_71585_d[i], p_149695_5_);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static int func_150085_b(int p_150085_0_) {
/* 213 */     return MathHelper.func_76125_a(p_150085_0_ & 0x7, 0, Facing.field_71586_b.length - 1);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
/* 218 */     int i = p_149694_1_.func_72805_g(p_149694_2_, p_149694_3_, p_149694_4_);
/* 219 */     if ((i & 0x8) != 0) {
/* 220 */       return Item.func_150898_a(Blocks.field_150320_F);
/*     */     }
/* 222 */     return Item.func_150898_a(Blocks.field_150331_J);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockPistonExtension.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */