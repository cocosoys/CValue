/*     */ package net.minecraft.block;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.tileentity.TileEntityPiston;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.Facing;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockPistonMoving extends BlockContainer {
/*     */   public BlockPistonMoving() {
/*  18 */     super(Material.field_76233_E);
/*  19 */     func_149711_c(-1.0F);
/*     */   }
/*     */   private static final String __OBFID = "CL_00000368";
/*     */   
/*     */   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
/*  24 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {}
/*     */ 
/*     */   
/*     */   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
/*  33 */     TileEntity tileEntity = p_149749_1_.func_147438_o(p_149749_2_, p_149749_3_, p_149749_4_);
/*  34 */     if (tileEntity instanceof TileEntityPiston) {
/*  35 */       ((TileEntityPiston)tileEntity).func_145866_f();
/*     */     } else {
/*  37 */       super.func_149749_a(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
/*  43 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149707_d(World p_149707_1_, int p_149707_2_, int p_149707_3_, int p_149707_4_, int p_149707_5_) {
/*  48 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  53 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  58 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  63 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
/*  69 */     if (!p_149727_1_.field_72995_K && p_149727_1_.func_147438_o(p_149727_2_, p_149727_3_, p_149727_4_) == null) {
/*     */       
/*  71 */       p_149727_1_.func_147468_f(p_149727_2_, p_149727_3_, p_149727_4_);
/*  72 */       return true;
/*     */     } 
/*  74 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/*  79 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149690_a(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_) {
/*  84 */     if (p_149690_1_.field_72995_K)
/*     */       return; 
/*  86 */     TileEntityPiston tileEntityPiston = func_149963_e((IBlockAccess)p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_);
/*  87 */     if (tileEntityPiston == null) {
/*     */       return;
/*     */     }
/*     */     
/*  91 */     tileEntityPiston.func_145861_a().func_149697_b(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, tileEntityPiston.func_145832_p(), 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/*  96 */     if (!p_149695_1_.field_72995_K) {
/*  97 */       p_149695_1_.func_147438_o(p_149695_2_, p_149695_3_, p_149695_4_);
/*     */     }
/*     */   }
/*     */   
/*     */   public static TileEntity func_149962_a(Block p_149962_0_, int p_149962_1_, int p_149962_2_, boolean p_149962_3_, boolean p_149962_4_) {
/* 102 */     return (TileEntity)new TileEntityPiston(p_149962_0_, p_149962_1_, p_149962_2_, p_149962_3_, p_149962_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
/* 107 */     TileEntityPiston tileEntityPiston = func_149963_e((IBlockAccess)p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
/* 108 */     if (tileEntityPiston == null) {
/* 109 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 113 */     float f = tileEntityPiston.func_145860_a(0.0F);
/* 114 */     if (tileEntityPiston.func_145868_b()) {
/* 115 */       f = 1.0F - f;
/*     */     }
/* 117 */     return func_149964_a(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_, tileEntityPiston.func_145861_a(), f, tileEntityPiston.func_145864_c());
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
/* 122 */     TileEntityPiston tileEntityPiston = func_149963_e(p_149719_1_, p_149719_2_, p_149719_3_, p_149719_4_);
/* 123 */     if (tileEntityPiston != null) {
/* 124 */       Block block = tileEntityPiston.func_145861_a();
/* 125 */       if (block == this || block.func_149688_o() == Material.field_151579_a) {
/*     */         return;
/*     */       }
/* 128 */       block.func_149719_a(p_149719_1_, p_149719_2_, p_149719_3_, p_149719_4_);
/*     */       
/* 130 */       float f = tileEntityPiston.func_145860_a(0.0F);
/* 131 */       if (tileEntityPiston.func_145868_b()) {
/* 132 */         f = 1.0F - f;
/*     */       }
/* 134 */       int i = tileEntityPiston.func_145864_c();
/* 135 */       this.field_149759_B = block.func_149704_x() - (Facing.field_71586_b[i] * f);
/* 136 */       this.field_149760_C = block.func_149665_z() - (Facing.field_71587_c[i] * f);
/* 137 */       this.field_149754_D = block.func_149706_B() - (Facing.field_71585_d[i] * f);
/* 138 */       this.field_149755_E = block.func_149753_y() - (Facing.field_71586_b[i] * f);
/* 139 */       this.field_149756_F = block.func_149669_A() - (Facing.field_71587_c[i] * f);
/* 140 */       this.field_149757_G = block.func_149693_C() - (Facing.field_71585_d[i] * f);
/*     */     } 
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_149964_a(World p_149964_1_, int p_149964_2_, int p_149964_3_, int p_149964_4_, Block p_149964_5_, float p_149964_6_, int p_149964_7_) {
/* 145 */     if (p_149964_5_ == this || p_149964_5_.func_149688_o() == Material.field_151579_a) {
/* 146 */       return null;
/*     */     }
/* 148 */     AxisAlignedBB axisAlignedBB = p_149964_5_.func_149668_a(p_149964_1_, p_149964_2_, p_149964_3_, p_149964_4_);
/*     */     
/* 150 */     if (axisAlignedBB == null) {
/* 151 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 155 */     if (Facing.field_71586_b[p_149964_7_] < 0) {
/* 156 */       axisAlignedBB.field_72340_a -= (Facing.field_71586_b[p_149964_7_] * p_149964_6_);
/*     */     } else {
/* 158 */       axisAlignedBB.field_72336_d -= (Facing.field_71586_b[p_149964_7_] * p_149964_6_);
/*     */     } 
/* 160 */     if (Facing.field_71587_c[p_149964_7_] < 0) {
/* 161 */       axisAlignedBB.field_72338_b -= (Facing.field_71587_c[p_149964_7_] * p_149964_6_);
/*     */     } else {
/* 163 */       axisAlignedBB.field_72337_e -= (Facing.field_71587_c[p_149964_7_] * p_149964_6_);
/*     */     } 
/* 165 */     if (Facing.field_71585_d[p_149964_7_] < 0) {
/* 166 */       axisAlignedBB.field_72339_c -= (Facing.field_71585_d[p_149964_7_] * p_149964_6_);
/*     */     } else {
/* 168 */       axisAlignedBB.field_72334_f -= (Facing.field_71585_d[p_149964_7_] * p_149964_6_);
/*     */     } 
/* 170 */     return axisAlignedBB;
/*     */   }
/*     */   
/*     */   private TileEntityPiston func_149963_e(IBlockAccess p_149963_1_, int p_149963_2_, int p_149963_3_, int p_149963_4_) {
/* 174 */     TileEntity tileEntity = p_149963_1_.func_147438_o(p_149963_2_, p_149963_3_, p_149963_4_);
/* 175 */     if (tileEntity instanceof TileEntityPiston) {
/* 176 */       return (TileEntityPiston)tileEntity;
/*     */     }
/* 178 */     return null;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
/* 183 */     return Item.func_150899_d(0);
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 189 */     this.field_149761_L = p_149651_1_.func_94245_a("piston_top_normal");
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockPistonMoving.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */