/*     */ package net.minecraft.block;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.IconFlipped;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockDoor
/*     */   extends Block
/*     */ {
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon[] field_150017_a;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon[] field_150016_b;
/*     */   private static final String __OBFID = "CL_00000230";
/*     */   
/*     */   protected BlockDoor(Material p_i45402_1_) {
/*  32 */     super(p_i45402_1_);
/*     */     
/*  34 */     float f1 = 0.5F;
/*  35 */     float f2 = 1.0F;
/*  36 */     func_149676_a(0.5F - f1, 0.0F, 0.5F - f1, 0.5F + f1, f2, 0.5F + f1);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/*  41 */     return this.field_150016_b[0];
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149673_e(IBlockAccess p_149673_1_, int p_149673_2_, int p_149673_3_, int p_149673_4_, int p_149673_5_) {
/*  46 */     if (p_149673_5_ == 1 || p_149673_5_ == 0) return this.field_150016_b[0];
/*     */     
/*  48 */     int i = func_150012_g(p_149673_1_, p_149673_2_, p_149673_3_, p_149673_4_);
/*  49 */     int j = i & 0x3;
/*  50 */     boolean bool1 = ((i & 0x4) != 0) ? true : false;
/*  51 */     boolean bool2 = false;
/*  52 */     boolean bool3 = ((i & 0x8) != 0) ? true : false;
/*     */     
/*  54 */     if (bool1)
/*  55 */     { if (j == 0 && p_149673_5_ == 2) { bool2 = !bool2 ? true : false; }
/*  56 */       else if (j == 1 && p_149673_5_ == 5) { bool2 = !bool2 ? true : false; }
/*  57 */       else if (j == 2 && p_149673_5_ == 3) { bool2 = !bool2 ? true : false; }
/*  58 */       else if (j == 3 && p_149673_5_ == 4) { bool2 = !bool2 ? true : false; }
/*     */        }
/*  60 */     else { if (j == 0 && p_149673_5_ == 5) { bool2 = !bool2 ? true : false; }
/*  61 */       else if (j == 1 && p_149673_5_ == 3) { bool2 = !bool2 ? true : false; }
/*  62 */       else if (j == 2 && p_149673_5_ == 4) { bool2 = !bool2 ? true : false; }
/*  63 */       else if (j == 3 && p_149673_5_ == 2) { bool2 = !bool2 ? true : false; }
/*  64 */        if ((i & 0x10) != 0) bool2 = !bool2 ? true : false;
/*     */        }
/*     */     
/*  67 */     if (bool3) {
/*  68 */       return this.field_150017_a[bool2 ? 1 : 0];
/*     */     }
/*  70 */     return this.field_150016_b[bool2 ? 1 : 0];
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/*  76 */     this.field_150017_a = new IIcon[2];
/*  77 */     this.field_150016_b = new IIcon[2];
/*     */     
/*  79 */     this.field_150017_a[0] = p_149651_1_.func_94245_a(func_149641_N() + "_upper");
/*  80 */     this.field_150016_b[0] = p_149651_1_.func_94245_a(func_149641_N() + "_lower");
/*  81 */     this.field_150017_a[1] = (IIcon)new IconFlipped(this.field_150017_a[0], true, false);
/*  82 */     this.field_150016_b[1] = (IIcon)new IconFlipped(this.field_150016_b[0], true, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  91 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149655_b(IBlockAccess p_149655_1_, int p_149655_2_, int p_149655_3_, int p_149655_4_) {
/*  96 */     int i = func_150012_g(p_149655_1_, p_149655_2_, p_149655_3_, p_149655_4_);
/*  97 */     return ((i & 0x4) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 102 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 107 */     return 7;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public AxisAlignedBB func_149633_g(World p_149633_1_, int p_149633_2_, int p_149633_3_, int p_149633_4_) {
/* 112 */     func_149719_a((IBlockAccess)p_149633_1_, p_149633_2_, p_149633_3_, p_149633_4_);
/* 113 */     return super.func_149633_g(p_149633_1_, p_149633_2_, p_149633_3_, p_149633_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
/* 118 */     func_149719_a((IBlockAccess)p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
/* 119 */     return super.func_149668_a(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
/* 124 */     func_150011_b(func_150012_g(p_149719_1_, p_149719_2_, p_149719_3_, p_149719_4_));
/*     */   }
/*     */   
/*     */   public int func_150013_e(IBlockAccess p_150013_1_, int p_150013_2_, int p_150013_3_, int p_150013_4_) {
/* 128 */     return func_150012_g(p_150013_1_, p_150013_2_, p_150013_3_, p_150013_4_) & 0x3;
/*     */   }
/*     */   
/*     */   public boolean func_150015_f(IBlockAccess p_150015_1_, int p_150015_2_, int p_150015_3_, int p_150015_4_) {
/* 132 */     return ((func_150012_g(p_150015_1_, p_150015_2_, p_150015_3_, p_150015_4_) & 0x4) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   private void func_150011_b(int p_150011_1_) {
/* 137 */     float f = 0.1875F;
/* 138 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
/* 139 */     int i = p_150011_1_ & 0x3;
/* 140 */     boolean bool1 = ((p_150011_1_ & 0x4) != 0) ? true : false;
/* 141 */     boolean bool2 = ((p_150011_1_ & 0x10) != 0) ? true : false;
/* 142 */     if (i == 0) {
/* 143 */       if (bool1)
/* 144 */       { if (!bool2) { func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f); }
/* 145 */         else { func_149676_a(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F); }  }
/* 146 */       else { func_149676_a(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F); } 
/* 147 */     } else if (i == 1) {
/* 148 */       if (bool1)
/* 149 */       { if (!bool2) { func_149676_a(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F); }
/* 150 */         else { func_149676_a(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F); }  }
/* 151 */       else { func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f); } 
/* 152 */     } else if (i == 2) {
/* 153 */       if (bool1)
/* 154 */       { if (!bool2) { func_149676_a(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F); }
/* 155 */         else { func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f); }  }
/* 156 */       else { func_149676_a(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F); } 
/* 157 */     } else if (i == 3) {
/* 158 */       if (bool1)
/* 159 */       { if (!bool2) { func_149676_a(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F); }
/* 160 */         else { func_149676_a(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F); }  }
/* 161 */       else { func_149676_a(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F); }
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149699_a(World p_149699_1_, int p_149699_2_, int p_149699_3_, int p_149699_4_, EntityPlayer p_149699_5_) {}
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
/* 171 */     if (this.field_149764_J == Material.field_151573_f) return true;
/*     */     
/* 173 */     int i = func_150012_g((IBlockAccess)p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_);
/* 174 */     int j = i & 0x7;
/* 175 */     j ^= 0x4;
/* 176 */     if ((i & 0x8) == 0) {
/* 177 */       p_149727_1_.func_72921_c(p_149727_2_, p_149727_3_, p_149727_4_, j, 2);
/* 178 */       p_149727_1_.func_147458_c(p_149727_2_, p_149727_3_, p_149727_4_, p_149727_2_, p_149727_3_, p_149727_4_);
/*     */     } else {
/* 180 */       p_149727_1_.func_72921_c(p_149727_2_, p_149727_3_ - 1, p_149727_4_, j, 2);
/* 181 */       p_149727_1_.func_147458_c(p_149727_2_, p_149727_3_ - 1, p_149727_4_, p_149727_2_, p_149727_3_, p_149727_4_);
/*     */     } 
/*     */     
/* 184 */     p_149727_1_.func_72889_a(p_149727_5_, 1003, p_149727_2_, p_149727_3_, p_149727_4_, 0);
/* 185 */     return true;
/*     */   }
/*     */   
/*     */   public void func_150014_a(World p_150014_1_, int p_150014_2_, int p_150014_3_, int p_150014_4_, boolean p_150014_5_) {
/* 189 */     int i = func_150012_g((IBlockAccess)p_150014_1_, p_150014_2_, p_150014_3_, p_150014_4_);
/* 190 */     boolean bool = ((i & 0x4) != 0);
/* 191 */     if (bool == p_150014_5_)
/*     */       return; 
/* 193 */     int j = i & 0x7;
/* 194 */     j ^= 0x4;
/* 195 */     if ((i & 0x8) == 0) {
/* 196 */       p_150014_1_.func_72921_c(p_150014_2_, p_150014_3_, p_150014_4_, j, 2);
/* 197 */       p_150014_1_.func_147458_c(p_150014_2_, p_150014_3_, p_150014_4_, p_150014_2_, p_150014_3_, p_150014_4_);
/*     */     } else {
/* 199 */       p_150014_1_.func_72921_c(p_150014_2_, p_150014_3_ - 1, p_150014_4_, j, 2);
/* 200 */       p_150014_1_.func_147458_c(p_150014_2_, p_150014_3_ - 1, p_150014_4_, p_150014_2_, p_150014_3_, p_150014_4_);
/*     */     } 
/*     */     
/* 203 */     p_150014_1_.func_72889_a(null, 1003, p_150014_2_, p_150014_3_, p_150014_4_, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/* 208 */     int i = p_149695_1_.func_72805_g(p_149695_2_, p_149695_3_, p_149695_4_);
/* 209 */     if ((i & 0x8) == 0) {
/* 210 */       boolean bool = false;
/* 211 */       if (p_149695_1_.func_147439_a(p_149695_2_, p_149695_3_ + 1, p_149695_4_) != this) {
/* 212 */         p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_, p_149695_4_);
/* 213 */         bool = true;
/*     */       } 
/* 215 */       if (!World.func_147466_a((IBlockAccess)p_149695_1_, p_149695_2_, p_149695_3_ - 1, p_149695_4_)) {
/* 216 */         p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_, p_149695_4_);
/* 217 */         bool = true;
/* 218 */         if (p_149695_1_.func_147439_a(p_149695_2_, p_149695_3_ + 1, p_149695_4_) == this) {
/* 219 */           p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_ + 1, p_149695_4_);
/*     */         }
/*     */       } 
/* 222 */       if (bool) {
/* 223 */         if (!p_149695_1_.field_72995_K) {
/* 224 */           func_149697_b(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, i, 0);
/*     */         }
/*     */       } else {
/* 227 */         boolean bool1 = (p_149695_1_.func_72864_z(p_149695_2_, p_149695_3_, p_149695_4_) || p_149695_1_.func_72864_z(p_149695_2_, p_149695_3_ + 1, p_149695_4_)) ? true : false;
/* 228 */         if ((bool1 || p_149695_5_.func_149744_f()) && p_149695_5_ != this) {
/* 229 */           func_150014_a(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, bool1);
/*     */         }
/*     */       } 
/*     */     } else {
/* 233 */       if (p_149695_1_.func_147439_a(p_149695_2_, p_149695_3_ - 1, p_149695_4_) != this) {
/* 234 */         p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_, p_149695_4_);
/*     */       }
/* 236 */       if (p_149695_5_ != this) {
/* 237 */         func_149695_a(p_149695_1_, p_149695_2_, p_149695_3_ - 1, p_149695_4_, p_149695_5_);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 244 */     if ((p_149650_1_ & 0x8) != 0) return null; 
/* 245 */     if (this.field_149764_J == Material.field_151573_f) return Items.field_151139_aw; 
/* 246 */     return Items.field_151135_aq;
/*     */   }
/*     */ 
/*     */   
/*     */   public MovingObjectPosition func_149731_a(World p_149731_1_, int p_149731_2_, int p_149731_3_, int p_149731_4_, Vec3 p_149731_5_, Vec3 p_149731_6_) {
/* 251 */     func_149719_a((IBlockAccess)p_149731_1_, p_149731_2_, p_149731_3_, p_149731_4_);
/* 252 */     return super.func_149731_a(p_149731_1_, p_149731_2_, p_149731_3_, p_149731_4_, p_149731_5_, p_149731_6_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
/* 257 */     if (p_149742_3_ >= 255) return false;
/*     */     
/* 259 */     return (World.func_147466_a((IBlockAccess)p_149742_1_, p_149742_2_, p_149742_3_ - 1, p_149742_4_) && super.func_149742_c(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_) && super.func_149742_c(p_149742_1_, p_149742_2_, p_149742_3_ + 1, p_149742_4_));
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149656_h() {
/* 264 */     return 1;
/*     */   }
/*     */   
/*     */   public int func_150012_g(IBlockAccess p_150012_1_, int p_150012_2_, int p_150012_3_, int p_150012_4_) {
/* 268 */     int j, k, i = p_150012_1_.func_72805_g(p_150012_2_, p_150012_3_, p_150012_4_);
/* 269 */     boolean bool1 = ((i & 0x8) != 0) ? true : false;
/*     */ 
/*     */     
/* 272 */     if (bool1) {
/* 273 */       j = p_150012_1_.func_72805_g(p_150012_2_, p_150012_3_ - 1, p_150012_4_);
/* 274 */       k = i;
/*     */     } else {
/* 276 */       j = i;
/* 277 */       k = p_150012_1_.func_72805_g(p_150012_2_, p_150012_3_ + 1, p_150012_4_);
/*     */     } 
/*     */ 
/*     */     
/* 281 */     boolean bool2 = ((k & 0x1) != 0) ? true : false;
/* 282 */     return j & 0x7 | (bool1 ? 8 : 0) | (bool2 ? 16 : 0);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
/* 287 */     return (this.field_149764_J == Material.field_151573_f) ? Items.field_151139_aw : Items.field_151135_aq;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149681_a(World p_149681_1_, int p_149681_2_, int p_149681_3_, int p_149681_4_, int p_149681_5_, EntityPlayer p_149681_6_) {
/* 292 */     if (p_149681_6_.field_71075_bZ.field_75098_d && (
/* 293 */       p_149681_5_ & 0x8) != 0 && 
/* 294 */       p_149681_1_.func_147439_a(p_149681_2_, p_149681_3_ - 1, p_149681_4_) == this)
/* 295 */       p_149681_1_.func_147468_f(p_149681_2_, p_149681_3_ - 1, p_149681_4_); 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockDoor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */