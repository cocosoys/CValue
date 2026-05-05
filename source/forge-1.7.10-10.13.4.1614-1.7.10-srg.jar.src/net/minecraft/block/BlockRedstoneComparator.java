/*     */ package net.minecraft.block;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.tileentity.TileEntityComparator;
/*     */ import net.minecraft.util.Direction;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockRedstoneComparator
/*     */   extends BlockRedstoneDiode implements ITileEntityProvider {
/*     */   public BlockRedstoneComparator(boolean p_i45399_1_) {
/*  20 */     super(p_i45399_1_);
/*  21 */     this.field_149758_A = true;
/*     */   }
/*     */   private static final String __OBFID = "CL_00000220";
/*     */   
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/*  26 */     return Items.field_151132_bS;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
/*  31 */     return Items.field_151132_bS;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int func_149901_b(int p_149901_1_) {
/*  36 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   protected BlockRedstoneDiode func_149906_e() {
/*  41 */     return Blocks.field_150455_bV;
/*     */   }
/*     */ 
/*     */   
/*     */   protected BlockRedstoneDiode func_149898_i() {
/*  46 */     return Blocks.field_150441_bU;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  51 */     return 37;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/*  56 */     boolean bool = (this.field_149914_a || (p_149691_2_ & 0x8) != 0) ? true : false;
/*     */     
/*  58 */     if (p_149691_1_ == 0) {
/*  59 */       if (bool) {
/*  60 */         return Blocks.field_150429_aA.func_149733_h(p_149691_1_);
/*     */       }
/*  62 */       return Blocks.field_150437_az.func_149733_h(p_149691_1_);
/*     */     } 
/*  64 */     if (p_149691_1_ == 1) {
/*  65 */       if (bool) {
/*  66 */         return Blocks.field_150455_bV.field_149761_L;
/*     */       }
/*  68 */       return this.field_149761_L;
/*     */     } 
/*     */     
/*  71 */     return Blocks.field_150334_T.func_149733_h(1);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean func_149905_c(int p_149905_1_) {
/*  76 */     return (this.field_149914_a || (p_149905_1_ & 0x8) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected int func_149904_f(IBlockAccess p_149904_1_, int p_149904_2_, int p_149904_3_, int p_149904_4_, int p_149904_5_) {
/*  81 */     return func_149971_e(p_149904_1_, p_149904_2_, p_149904_3_, p_149904_4_).func_145996_a();
/*     */   }
/*     */   
/*     */   private int func_149970_j(World p_149970_1_, int p_149970_2_, int p_149970_3_, int p_149970_4_, int p_149970_5_) {
/*  85 */     if (!func_149969_d(p_149970_5_)) {
/*  86 */       return func_149903_h(p_149970_1_, p_149970_2_, p_149970_3_, p_149970_4_, p_149970_5_);
/*     */     }
/*  88 */     return Math.max(func_149903_h(p_149970_1_, p_149970_2_, p_149970_3_, p_149970_4_, p_149970_5_) - func_149902_h((IBlockAccess)p_149970_1_, p_149970_2_, p_149970_3_, p_149970_4_, p_149970_5_), 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149969_d(int p_149969_1_) {
/*  93 */     return ((p_149969_1_ & 0x4) == 4);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean func_149900_a(World p_149900_1_, int p_149900_2_, int p_149900_3_, int p_149900_4_, int p_149900_5_) {
/*  98 */     int i = func_149903_h(p_149900_1_, p_149900_2_, p_149900_3_, p_149900_4_, p_149900_5_);
/*  99 */     if (i >= 15) return true; 
/* 100 */     if (i == 0) return false;
/*     */     
/* 102 */     int j = func_149902_h((IBlockAccess)p_149900_1_, p_149900_2_, p_149900_3_, p_149900_4_, p_149900_5_);
/* 103 */     if (j == 0) return true;
/*     */     
/* 105 */     return (i >= j);
/*     */   }
/*     */ 
/*     */   
/*     */   protected int func_149903_h(World p_149903_1_, int p_149903_2_, int p_149903_3_, int p_149903_4_, int p_149903_5_) {
/* 110 */     int i = super.func_149903_h(p_149903_1_, p_149903_2_, p_149903_3_, p_149903_4_, p_149903_5_);
/*     */     
/* 112 */     int j = func_149895_l(p_149903_5_);
/* 113 */     int k = p_149903_2_ + Direction.field_71583_a[j];
/* 114 */     int m = p_149903_4_ + Direction.field_71581_b[j];
/* 115 */     Block block = p_149903_1_.func_147439_a(k, p_149903_3_, m);
/*     */     
/* 117 */     if (block.func_149740_M()) {
/* 118 */       i = block.func_149736_g(p_149903_1_, k, p_149903_3_, m, Direction.field_71580_e[j]);
/* 119 */     } else if (i < 15 && block.func_149721_r()) {
/* 120 */       k += Direction.field_71583_a[j];
/* 121 */       m += Direction.field_71581_b[j];
/*     */       
/* 123 */       block = p_149903_1_.func_147439_a(k, p_149903_3_, m);
/* 124 */       if (block.func_149740_M()) {
/* 125 */         i = block.func_149736_g(p_149903_1_, k, p_149903_3_, m, Direction.field_71580_e[j]);
/*     */       }
/*     */     } 
/*     */     
/* 129 */     return i;
/*     */   }
/*     */   
/*     */   public TileEntityComparator func_149971_e(IBlockAccess p_149971_1_, int p_149971_2_, int p_149971_3_, int p_149971_4_) {
/* 133 */     return (TileEntityComparator)p_149971_1_.func_147438_o(p_149971_2_, p_149971_3_, p_149971_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
/* 138 */     int i = p_149727_1_.func_72805_g(p_149727_2_, p_149727_3_, p_149727_4_);
/* 139 */     int j = this.field_149914_a | (((i & 0x8) != 0) ? 1 : 0);
/* 140 */     boolean bool = !func_149969_d(i) ? true : false;
/* 141 */     int k = bool ? 4 : 0;
/* 142 */     k |= (j != 0) ? 8 : 0;
/*     */     
/* 144 */     p_149727_1_.func_72908_a(p_149727_2_ + 0.5D, p_149727_3_ + 0.5D, p_149727_4_ + 0.5D, "random.click", 0.3F, bool ? 0.55F : 0.5F);
/*     */     
/* 146 */     p_149727_1_.func_72921_c(p_149727_2_, p_149727_3_, p_149727_4_, k | i & 0x3, 2);
/* 147 */     func_149972_c(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, p_149727_1_.field_73012_v);
/* 148 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_149897_b(World p_149897_1_, int p_149897_2_, int p_149897_3_, int p_149897_4_, Block p_149897_5_) {
/* 153 */     if (!p_149897_1_.func_147477_a(p_149897_2_, p_149897_3_, p_149897_4_, this)) {
/* 154 */       int i = p_149897_1_.func_72805_g(p_149897_2_, p_149897_3_, p_149897_4_);
/* 155 */       int j = func_149970_j(p_149897_1_, p_149897_2_, p_149897_3_, p_149897_4_, i);
/* 156 */       int k = func_149971_e((IBlockAccess)p_149897_1_, p_149897_2_, p_149897_3_, p_149897_4_).func_145996_a();
/*     */       
/* 158 */       if (j != k || func_149905_c(i) != func_149900_a(p_149897_1_, p_149897_2_, p_149897_3_, p_149897_4_, i))
/*     */       {
/* 160 */         if (func_149912_i(p_149897_1_, p_149897_2_, p_149897_3_, p_149897_4_, i)) {
/* 161 */           p_149897_1_.func_147454_a(p_149897_2_, p_149897_3_, p_149897_4_, this, func_149901_b(0), -1);
/*     */         } else {
/* 163 */           p_149897_1_.func_147454_a(p_149897_2_, p_149897_3_, p_149897_4_, this, func_149901_b(0), 0);
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_149972_c(World p_149972_1_, int p_149972_2_, int p_149972_3_, int p_149972_4_, Random p_149972_5_) {
/* 170 */     int i = p_149972_1_.func_72805_g(p_149972_2_, p_149972_3_, p_149972_4_);
/* 171 */     int j = func_149970_j(p_149972_1_, p_149972_2_, p_149972_3_, p_149972_4_, i);
/* 172 */     int k = func_149971_e((IBlockAccess)p_149972_1_, p_149972_2_, p_149972_3_, p_149972_4_).func_145996_a();
/* 173 */     func_149971_e((IBlockAccess)p_149972_1_, p_149972_2_, p_149972_3_, p_149972_4_).func_145995_a(j);
/*     */     
/* 175 */     if (k != j || !func_149969_d(i)) {
/* 176 */       boolean bool = func_149900_a(p_149972_1_, p_149972_2_, p_149972_3_, p_149972_4_, i);
/* 177 */       boolean bool1 = (this.field_149914_a || (i & 0x8) != 0) ? true : false;
/* 178 */       if (bool1 && !bool) {
/* 179 */         p_149972_1_.func_72921_c(p_149972_2_, p_149972_3_, p_149972_4_, i & 0xFFFFFFF7, 2);
/* 180 */       } else if (!bool1 && bool) {
/* 181 */         p_149972_1_.func_72921_c(p_149972_2_, p_149972_3_, p_149972_4_, i | 0x8, 2);
/*     */       } 
/* 183 */       func_149911_e(p_149972_1_, p_149972_2_, p_149972_3_, p_149972_4_);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/* 189 */     if (this.field_149914_a) {
/*     */       
/* 191 */       int i = p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_);
/* 192 */       p_149674_1_.func_147465_d(p_149674_2_, p_149674_3_, p_149674_4_, func_149898_i(), i | 0x8, 4);
/*     */     } 
/* 194 */     func_149972_c(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
/* 199 */     super.func_149726_b(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
/* 200 */     p_149726_1_.func_147455_a(p_149726_2_, p_149726_3_, p_149726_4_, func_149915_a(p_149726_1_, 0));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
/* 205 */     super.func_149749_a(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
/* 206 */     p_149749_1_.func_147475_p(p_149749_2_, p_149749_3_, p_149749_4_);
/*     */     
/* 208 */     func_149911_e(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149696_a(World p_149696_1_, int p_149696_2_, int p_149696_3_, int p_149696_4_, int p_149696_5_, int p_149696_6_) {
/* 213 */     super.func_149696_a(p_149696_1_, p_149696_2_, p_149696_3_, p_149696_4_, p_149696_5_, p_149696_6_);
/* 214 */     TileEntity tileEntity = p_149696_1_.func_147438_o(p_149696_2_, p_149696_3_, p_149696_4_);
/* 215 */     if (tileEntity != null) {
/* 216 */       return tileEntity.func_145842_c(p_149696_5_, p_149696_6_);
/*     */     }
/* 218 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
/* 223 */     return (TileEntity)new TileEntityComparator();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockRedstoneComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */