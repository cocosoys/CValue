/*     */ package net.minecraft.block;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.Direction;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ 
/*     */ public class BlockBed
/*     */   extends BlockDirectional
/*     */ {
/*  24 */   public static final int[][] field_149981_a = new int[][] { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon[] field_149980_b;
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon[] field_149982_M;
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon[] field_149983_N;
/*     */   
/*     */   private static final String __OBFID = "CL_00000198";
/*     */ 
/*     */   
/*     */   public BlockBed() {
/*  41 */     super(Material.field_151580_n);
/*     */     
/*  43 */     func_149978_e();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
/*  48 */     if (p_149727_1_.field_72995_K) return true;
/*     */     
/*  50 */     int i = p_149727_1_.func_72805_g(p_149727_2_, p_149727_3_, p_149727_4_);
/*     */     
/*  52 */     if (!func_149975_b(i)) {
/*     */       
/*  54 */       int j = func_149895_l(i);
/*  55 */       p_149727_2_ += field_149981_a[j][0];
/*  56 */       p_149727_4_ += field_149981_a[j][1];
/*  57 */       if (p_149727_1_.func_147439_a(p_149727_2_, p_149727_3_, p_149727_4_) != this) {
/*  58 */         return true;
/*     */       }
/*  60 */       i = p_149727_1_.func_72805_g(p_149727_2_, p_149727_3_, p_149727_4_);
/*     */     } 
/*     */     
/*  63 */     if (!p_149727_1_.field_73011_w.func_76567_e() || p_149727_1_.func_72807_a(p_149727_2_, p_149727_4_) == BiomeGenBase.field_76778_j) {
/*  64 */       double d1 = p_149727_2_ + 0.5D;
/*  65 */       double d2 = p_149727_3_ + 0.5D;
/*  66 */       double d3 = p_149727_4_ + 0.5D;
/*  67 */       p_149727_1_.func_147468_f(p_149727_2_, p_149727_3_, p_149727_4_);
/*  68 */       int j = func_149895_l(i);
/*  69 */       p_149727_2_ += field_149981_a[j][0];
/*  70 */       p_149727_4_ += field_149981_a[j][1];
/*  71 */       if (p_149727_1_.func_147439_a(p_149727_2_, p_149727_3_, p_149727_4_) == this) {
/*  72 */         p_149727_1_.func_147468_f(p_149727_2_, p_149727_3_, p_149727_4_);
/*  73 */         d1 = (d1 + p_149727_2_ + 0.5D) / 2.0D;
/*  74 */         d2 = (d2 + p_149727_3_ + 0.5D) / 2.0D;
/*  75 */         d3 = (d3 + p_149727_4_ + 0.5D) / 2.0D;
/*     */       } 
/*  77 */       p_149727_1_.func_72885_a(null, (p_149727_2_ + 0.5F), (p_149727_3_ + 0.5F), (p_149727_4_ + 0.5F), 5.0F, true, true);
/*  78 */       return true;
/*     */     } 
/*     */     
/*  81 */     if (func_149976_c(i)) {
/*  82 */       EntityPlayer entityPlayer = null;
/*  83 */       for (EntityPlayer entityPlayer1 : p_149727_1_.field_73010_i) {
/*  84 */         if (entityPlayer1.func_70608_bn()) {
/*  85 */           ChunkCoordinates chunkCoordinates = entityPlayer1.field_71081_bT;
/*  86 */           if (chunkCoordinates.field_71574_a == p_149727_2_ && chunkCoordinates.field_71572_b == p_149727_3_ && chunkCoordinates.field_71573_c == p_149727_4_) {
/*  87 */             entityPlayer = entityPlayer1;
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/*  92 */       if (entityPlayer == null) {
/*  93 */         func_149979_a(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, false);
/*     */       } else {
/*  95 */         p_149727_5_.func_146105_b((IChatComponent)new ChatComponentTranslation("tile.bed.occupied", new Object[0]));
/*  96 */         return true;
/*     */       } 
/*     */     } 
/*     */     
/* 100 */     EntityPlayer.EnumStatus enumStatus = p_149727_5_.func_71018_a(p_149727_2_, p_149727_3_, p_149727_4_);
/* 101 */     if (enumStatus == EntityPlayer.EnumStatus.OK) {
/* 102 */       func_149979_a(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, true);
/* 103 */       return true;
/*     */     } 
/*     */     
/* 106 */     if (enumStatus == EntityPlayer.EnumStatus.NOT_POSSIBLE_NOW) {
/* 107 */       p_149727_5_.func_146105_b((IChatComponent)new ChatComponentTranslation("tile.bed.noSleep", new Object[0]));
/* 108 */     } else if (enumStatus == EntityPlayer.EnumStatus.NOT_SAFE) {
/* 109 */       p_149727_5_.func_146105_b((IChatComponent)new ChatComponentTranslation("tile.bed.notSafe", new Object[0]));
/*     */     } 
/* 111 */     return true;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/* 116 */     if (p_149691_1_ == 0) {
/* 117 */       return Blocks.field_150344_f.func_149733_h(p_149691_1_);
/*     */     }
/*     */     
/* 120 */     int i = func_149895_l(p_149691_2_);
/* 121 */     int j = Direction.field_71584_h[i][p_149691_1_];
/* 122 */     boolean bool = func_149975_b(p_149691_2_) ? true : false;
/*     */     
/* 124 */     if ((bool == true && j == 2) || (!bool && j == 3)) {
/* 125 */       return this.field_149980_b[bool];
/*     */     }
/* 127 */     if (j == 5 || j == 4) {
/* 128 */       return this.field_149982_M[bool];
/*     */     }
/* 130 */     return this.field_149983_N[bool];
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 135 */     this.field_149983_N = new IIcon[] { p_149651_1_.func_94245_a(func_149641_N() + "_feet_top"), p_149651_1_.func_94245_a(func_149641_N() + "_head_top") };
/* 136 */     this.field_149980_b = new IIcon[] { p_149651_1_.func_94245_a(func_149641_N() + "_feet_end"), p_149651_1_.func_94245_a(func_149641_N() + "_head_end") };
/* 137 */     this.field_149982_M = new IIcon[] { p_149651_1_.func_94245_a(func_149641_N() + "_feet_side"), p_149651_1_.func_94245_a(func_149641_N() + "_head_side") };
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 142 */     return 14;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 147 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 152 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
/* 157 */     func_149978_e();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/* 162 */     int i = p_149695_1_.func_72805_g(p_149695_2_, p_149695_3_, p_149695_4_);
/* 163 */     int j = func_149895_l(i);
/*     */     
/* 165 */     if (func_149975_b(i)) {
/* 166 */       if (p_149695_1_.func_147439_a(p_149695_2_ - field_149981_a[j][0], p_149695_3_, p_149695_4_ - field_149981_a[j][1]) != this) {
/* 167 */         p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_, p_149695_4_);
/*     */       }
/*     */     }
/* 170 */     else if (p_149695_1_.func_147439_a(p_149695_2_ + field_149981_a[j][0], p_149695_3_, p_149695_4_ + field_149981_a[j][1]) != this) {
/* 171 */       p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_, p_149695_4_);
/* 172 */       if (!p_149695_1_.field_72995_K) {
/* 173 */         func_149697_b(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, i, 0);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 181 */     if (func_149975_b(p_149650_1_)) {
/* 182 */       return Item.func_150899_d(0);
/*     */     }
/* 184 */     return Items.field_151104_aV;
/*     */   }
/*     */   
/*     */   private void func_149978_e() {
/* 188 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5625F, 1.0F);
/*     */   }
/*     */   
/*     */   public static boolean func_149975_b(int p_149975_0_) {
/* 192 */     return ((p_149975_0_ & 0x8) != 0);
/*     */   }
/*     */   
/*     */   public static boolean func_149976_c(int p_149976_0_) {
/* 196 */     return ((p_149976_0_ & 0x4) != 0);
/*     */   }
/*     */   
/*     */   public static void func_149979_a(World p_149979_0_, int p_149979_1_, int p_149979_2_, int p_149979_3_, boolean p_149979_4_) {
/* 200 */     int i = p_149979_0_.func_72805_g(p_149979_1_, p_149979_2_, p_149979_3_);
/* 201 */     if (p_149979_4_) {
/* 202 */       i |= 0x4;
/*     */     } else {
/* 204 */       i &= 0xFFFFFFFB;
/*     */     } 
/* 206 */     p_149979_0_.func_72921_c(p_149979_1_, p_149979_2_, p_149979_3_, i, 4);
/*     */   }
/*     */   
/*     */   public static ChunkCoordinates func_149977_a(World p_149977_0_, int p_149977_1_, int p_149977_2_, int p_149977_3_, int p_149977_4_) {
/* 210 */     int i = p_149977_0_.func_72805_g(p_149977_1_, p_149977_2_, p_149977_3_);
/* 211 */     int j = BlockDirectional.func_149895_l(i);
/*     */ 
/*     */     
/* 214 */     for (byte b = 0; b <= 1; b++) {
/* 215 */       int k = p_149977_1_ - field_149981_a[j][0] * b - 1;
/* 216 */       int m = p_149977_3_ - field_149981_a[j][1] * b - 1;
/* 217 */       int n = k + 2;
/* 218 */       int i1 = m + 2;
/*     */       
/* 220 */       for (int i2 = k; i2 <= n; i2++) {
/* 221 */         for (int i3 = m; i3 <= i1; i3++) {
/* 222 */           if (World.func_147466_a((IBlockAccess)p_149977_0_, i2, p_149977_2_ - 1, i3) && !p_149977_0_.func_147439_a(i2, p_149977_2_, i3).func_149688_o().func_76218_k() && !p_149977_0_.func_147439_a(i2, p_149977_2_ + 1, i3).func_149688_o().func_76218_k()) {
/* 223 */             if (p_149977_4_ > 0) {
/* 224 */               p_149977_4_--;
/*     */             } else {
/*     */               
/* 227 */               return new ChunkCoordinates(i2, p_149977_2_, i3);
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 233 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149690_a(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_) {
/* 238 */     if (!func_149975_b(p_149690_5_)) {
/* 239 */       super.func_149690_a(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, p_149690_5_, p_149690_6_, 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149656_h() {
/* 245 */     return 1;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
/* 250 */     return Items.field_151104_aV;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149681_a(World p_149681_1_, int p_149681_2_, int p_149681_3_, int p_149681_4_, int p_149681_5_, EntityPlayer p_149681_6_) {
/* 255 */     if (p_149681_6_.field_71075_bZ.field_75098_d && 
/* 256 */       func_149975_b(p_149681_5_)) {
/* 257 */       int i = func_149895_l(p_149681_5_);
/* 258 */       p_149681_2_ -= field_149981_a[i][0];
/* 259 */       p_149681_4_ -= field_149981_a[i][1];
/* 260 */       if (p_149681_1_.func_147439_a(p_149681_2_, p_149681_3_, p_149681_4_) == this)
/* 261 */         p_149681_1_.func_147468_f(p_149681_2_, p_149681_3_, p_149681_4_); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockBed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */