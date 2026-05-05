/*     */ package net.minecraft.block;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.boss.EntityWither;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemSkull;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTUtil;
/*     */ import net.minecraft.stats.AchievementList;
/*     */ import net.minecraft.stats.StatBase;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.tileentity.TileEntitySkull;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.EnumDifficulty;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockSkull extends BlockContainer {
/*     */   protected BlockSkull() {
/*  32 */     super(Material.field_151594_q);
/*  33 */     func_149676_a(0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F);
/*     */   }
/*     */   private static final String __OBFID = "CL_00000307";
/*     */   
/*     */   public int func_149645_b() {
/*  38 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  43 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  48 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
/*  53 */     int i = p_149719_1_.func_72805_g(p_149719_2_, p_149719_3_, p_149719_4_) & 0x7;
/*     */     
/*  55 */     switch (i) {
/*     */       
/*     */       default:
/*  58 */         func_149676_a(0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F);
/*     */         return;
/*     */       case 2:
/*  61 */         func_149676_a(0.25F, 0.25F, 0.5F, 0.75F, 0.75F, 1.0F);
/*     */         return;
/*     */       case 3:
/*  64 */         func_149676_a(0.25F, 0.25F, 0.0F, 0.75F, 0.75F, 0.5F);
/*     */         return;
/*     */       case 4:
/*  67 */         func_149676_a(0.5F, 0.25F, 0.25F, 1.0F, 0.75F, 0.75F); return;
/*     */       case 5:
/*     */         break;
/*  70 */     }  func_149676_a(0.0F, 0.25F, 0.25F, 0.5F, 0.75F, 0.75F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
/*  77 */     func_149719_a((IBlockAccess)p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
/*  78 */     return super.func_149668_a(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149689_a(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
/*  83 */     int i = MathHelper.func_76128_c((p_149689_5_.field_70177_z * 4.0F / 360.0F) + 2.5D) & 0x3;
/*  84 */     p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, i, 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
/*  89 */     return (TileEntity)new TileEntitySkull();
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
/*  94 */     return Items.field_151144_bL;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149643_k(World p_149643_1_, int p_149643_2_, int p_149643_3_, int p_149643_4_) {
/*  99 */     TileEntity tileEntity = p_149643_1_.func_147438_o(p_149643_2_, p_149643_3_, p_149643_4_);
/* 100 */     if (tileEntity != null && tileEntity instanceof TileEntitySkull) {
/* 101 */       return ((TileEntitySkull)tileEntity).func_145904_a();
/*     */     }
/* 103 */     return super.func_149643_k(p_149643_1_, p_149643_2_, p_149643_3_, p_149643_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149692_a(int p_149692_1_) {
/* 108 */     return p_149692_1_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149690_a(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149681_a(World p_149681_1_, int p_149681_2_, int p_149681_3_, int p_149681_4_, int p_149681_5_, EntityPlayer p_149681_6_) {
/* 119 */     if (p_149681_6_.field_71075_bZ.field_75098_d) {
/*     */       
/* 121 */       p_149681_5_ |= 0x8;
/* 122 */       p_149681_1_.func_72921_c(p_149681_2_, p_149681_3_, p_149681_4_, p_149681_5_, 4);
/*     */     } 
/* 124 */     super.func_149681_a(p_149681_1_, p_149681_2_, p_149681_3_, p_149681_4_, p_149681_5_, p_149681_6_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
/* 129 */     if (p_149749_1_.field_72995_K)
/* 130 */       return;  if ((p_149749_6_ & 0x8) == 0) {
/* 131 */       ItemStack itemStack = new ItemStack(Items.field_151144_bL, 1, func_149643_k(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_));
/* 132 */       TileEntitySkull tileEntitySkull = (TileEntitySkull)p_149749_1_.func_147438_o(p_149749_2_, p_149749_3_, p_149749_4_);
/*     */       
/* 134 */       if (tileEntitySkull.func_145904_a() == 3 && tileEntitySkull.func_152108_a() != null) {
/* 135 */         itemStack.func_77982_d(new NBTTagCompound());
/* 136 */         NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 137 */         NBTUtil.func_152460_a(nBTTagCompound, tileEntitySkull.func_152108_a());
/* 138 */         itemStack.func_77978_p().func_74782_a("SkullOwner", (NBTBase)nBTTagCompound);
/*     */       } 
/*     */       
/* 141 */       func_149642_a(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, itemStack);
/*     */     } 
/* 143 */     super.func_149749_a(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
/*     */   }
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 148 */     return Items.field_151144_bL;
/*     */   }
/*     */   
/*     */   public void func_149965_a(World p_149965_1_, int p_149965_2_, int p_149965_3_, int p_149965_4_, TileEntitySkull p_149965_5_) {
/* 152 */     if (p_149965_5_.func_145904_a() == 1 && p_149965_3_ >= 2 && p_149965_1_.field_73013_u != EnumDifficulty.PEACEFUL && !p_149965_1_.field_72995_K) {
/*     */       byte b;
/*     */ 
/*     */ 
/*     */       
/* 157 */       for (b = -2; b <= 0; b++) {
/* 158 */         if (p_149965_1_.func_147439_a(p_149965_2_, p_149965_3_ - 1, p_149965_4_ + b) == Blocks.field_150425_aM && p_149965_1_.func_147439_a(p_149965_2_, p_149965_3_ - 1, p_149965_4_ + b + 1) == Blocks.field_150425_aM && p_149965_1_.func_147439_a(p_149965_2_, p_149965_3_ - 2, p_149965_4_ + b + 1) == Blocks.field_150425_aM && p_149965_1_.func_147439_a(p_149965_2_, p_149965_3_ - 1, p_149965_4_ + b + 2) == Blocks.field_150425_aM && func_149966_a(p_149965_1_, p_149965_2_, p_149965_3_, p_149965_4_ + b, 1) && func_149966_a(p_149965_1_, p_149965_2_, p_149965_3_, p_149965_4_ + b + 1, 1) && func_149966_a(p_149965_1_, p_149965_2_, p_149965_3_, p_149965_4_ + b + 2, 1)) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 167 */           p_149965_1_.func_72921_c(p_149965_2_, p_149965_3_, p_149965_4_ + b, 8, 2);
/* 168 */           p_149965_1_.func_72921_c(p_149965_2_, p_149965_3_, p_149965_4_ + b + 1, 8, 2);
/* 169 */           p_149965_1_.func_72921_c(p_149965_2_, p_149965_3_, p_149965_4_ + b + 2, 8, 2);
/* 170 */           p_149965_1_.func_147465_d(p_149965_2_, p_149965_3_, p_149965_4_ + b, func_149729_e(0), 0, 2);
/* 171 */           p_149965_1_.func_147465_d(p_149965_2_, p_149965_3_, p_149965_4_ + b + 1, func_149729_e(0), 0, 2);
/* 172 */           p_149965_1_.func_147465_d(p_149965_2_, p_149965_3_, p_149965_4_ + b + 2, func_149729_e(0), 0, 2);
/* 173 */           p_149965_1_.func_147465_d(p_149965_2_, p_149965_3_ - 1, p_149965_4_ + b, func_149729_e(0), 0, 2);
/* 174 */           p_149965_1_.func_147465_d(p_149965_2_, p_149965_3_ - 1, p_149965_4_ + b + 1, func_149729_e(0), 0, 2);
/* 175 */           p_149965_1_.func_147465_d(p_149965_2_, p_149965_3_ - 1, p_149965_4_ + b + 2, func_149729_e(0), 0, 2);
/* 176 */           p_149965_1_.func_147465_d(p_149965_2_, p_149965_3_ - 2, p_149965_4_ + b + 1, func_149729_e(0), 0, 2);
/*     */           
/* 178 */           if (!p_149965_1_.field_72995_K) {
/* 179 */             EntityWither entityWither = new EntityWither(p_149965_1_);
/* 180 */             entityWither.func_70012_b(p_149965_2_ + 0.5D, p_149965_3_ - 1.45D, (p_149965_4_ + b) + 1.5D, 90.0F, 0.0F);
/* 181 */             entityWither.field_70761_aq = 90.0F;
/* 182 */             entityWither.func_82206_m();
/*     */             
/* 184 */             if (!p_149965_1_.field_72995_K) {
/* 185 */               for (EntityPlayer entityPlayer : p_149965_1_.func_72872_a(EntityPlayer.class, entityWither.field_70121_D.func_72314_b(50.0D, 50.0D, 50.0D))) {
/* 186 */                 entityPlayer.func_71029_a((StatBase)AchievementList.field_150963_I);
/*     */               }
/*     */             }
/*     */             
/* 190 */             p_149965_1_.func_72838_d((Entity)entityWither);
/*     */           } 
/*     */           
/* 193 */           for (byte b1 = 0; b1 < 120; b1++) {
/* 194 */             p_149965_1_.func_72869_a("snowballpoof", p_149965_2_ + p_149965_1_.field_73012_v.nextDouble(), (p_149965_3_ - 2) + p_149965_1_.field_73012_v.nextDouble() * 3.9D, (p_149965_4_ + b + 1) + p_149965_1_.field_73012_v.nextDouble(), 0.0D, 0.0D, 0.0D);
/*     */           }
/*     */           
/* 197 */           p_149965_1_.func_147444_c(p_149965_2_, p_149965_3_, p_149965_4_ + b, func_149729_e(0));
/* 198 */           p_149965_1_.func_147444_c(p_149965_2_, p_149965_3_, p_149965_4_ + b + 1, func_149729_e(0));
/* 199 */           p_149965_1_.func_147444_c(p_149965_2_, p_149965_3_, p_149965_4_ + b + 2, func_149729_e(0));
/* 200 */           p_149965_1_.func_147444_c(p_149965_2_, p_149965_3_ - 1, p_149965_4_ + b, func_149729_e(0));
/* 201 */           p_149965_1_.func_147444_c(p_149965_2_, p_149965_3_ - 1, p_149965_4_ + b + 1, func_149729_e(0));
/* 202 */           p_149965_1_.func_147444_c(p_149965_2_, p_149965_3_ - 1, p_149965_4_ + b + 2, func_149729_e(0));
/* 203 */           p_149965_1_.func_147444_c(p_149965_2_, p_149965_3_ - 2, p_149965_4_ + b + 1, func_149729_e(0));
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/*     */       
/* 209 */       for (b = -2; b <= 0; b++) {
/* 210 */         if (p_149965_1_.func_147439_a(p_149965_2_ + b, p_149965_3_ - 1, p_149965_4_) == Blocks.field_150425_aM && p_149965_1_.func_147439_a(p_149965_2_ + b + 1, p_149965_3_ - 1, p_149965_4_) == Blocks.field_150425_aM && p_149965_1_.func_147439_a(p_149965_2_ + b + 1, p_149965_3_ - 2, p_149965_4_) == Blocks.field_150425_aM && p_149965_1_.func_147439_a(p_149965_2_ + b + 2, p_149965_3_ - 1, p_149965_4_) == Blocks.field_150425_aM && func_149966_a(p_149965_1_, p_149965_2_ + b, p_149965_3_, p_149965_4_, 1) && func_149966_a(p_149965_1_, p_149965_2_ + b + 1, p_149965_3_, p_149965_4_, 1) && func_149966_a(p_149965_1_, p_149965_2_ + b + 2, p_149965_3_, p_149965_4_, 1)) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 219 */           p_149965_1_.func_72921_c(p_149965_2_ + b, p_149965_3_, p_149965_4_, 8, 2);
/* 220 */           p_149965_1_.func_72921_c(p_149965_2_ + b + 1, p_149965_3_, p_149965_4_, 8, 2);
/* 221 */           p_149965_1_.func_72921_c(p_149965_2_ + b + 2, p_149965_3_, p_149965_4_, 8, 2);
/* 222 */           p_149965_1_.func_147465_d(p_149965_2_ + b, p_149965_3_, p_149965_4_, func_149729_e(0), 0, 2);
/* 223 */           p_149965_1_.func_147465_d(p_149965_2_ + b + 1, p_149965_3_, p_149965_4_, func_149729_e(0), 0, 2);
/* 224 */           p_149965_1_.func_147465_d(p_149965_2_ + b + 2, p_149965_3_, p_149965_4_, func_149729_e(0), 0, 2);
/* 225 */           p_149965_1_.func_147465_d(p_149965_2_ + b, p_149965_3_ - 1, p_149965_4_, func_149729_e(0), 0, 2);
/* 226 */           p_149965_1_.func_147465_d(p_149965_2_ + b + 1, p_149965_3_ - 1, p_149965_4_, func_149729_e(0), 0, 2);
/* 227 */           p_149965_1_.func_147465_d(p_149965_2_ + b + 2, p_149965_3_ - 1, p_149965_4_, func_149729_e(0), 0, 2);
/* 228 */           p_149965_1_.func_147465_d(p_149965_2_ + b + 1, p_149965_3_ - 2, p_149965_4_, func_149729_e(0), 0, 2);
/*     */           
/* 230 */           if (!p_149965_1_.field_72995_K) {
/* 231 */             EntityWither entityWither = new EntityWither(p_149965_1_);
/* 232 */             entityWither.func_70012_b((p_149965_2_ + b) + 1.5D, p_149965_3_ - 1.45D, p_149965_4_ + 0.5D, 0.0F, 0.0F);
/* 233 */             entityWither.func_82206_m();
/*     */             
/* 235 */             if (!p_149965_1_.field_72995_K) {
/* 236 */               for (EntityPlayer entityPlayer : p_149965_1_.func_72872_a(EntityPlayer.class, entityWither.field_70121_D.func_72314_b(50.0D, 50.0D, 50.0D))) {
/* 237 */                 entityPlayer.func_71029_a((StatBase)AchievementList.field_150963_I);
/*     */               }
/*     */             }
/*     */             
/* 241 */             p_149965_1_.func_72838_d((Entity)entityWither);
/*     */           } 
/*     */           
/* 244 */           for (byte b1 = 0; b1 < 120; b1++) {
/* 245 */             p_149965_1_.func_72869_a("snowballpoof", (p_149965_2_ + b + 1) + p_149965_1_.field_73012_v.nextDouble(), (p_149965_3_ - 2) + p_149965_1_.field_73012_v.nextDouble() * 3.9D, p_149965_4_ + p_149965_1_.field_73012_v.nextDouble(), 0.0D, 0.0D, 0.0D);
/*     */           }
/*     */           
/* 248 */           p_149965_1_.func_147444_c(p_149965_2_ + b, p_149965_3_, p_149965_4_, func_149729_e(0));
/* 249 */           p_149965_1_.func_147444_c(p_149965_2_ + b + 1, p_149965_3_, p_149965_4_, func_149729_e(0));
/* 250 */           p_149965_1_.func_147444_c(p_149965_2_ + b + 2, p_149965_3_, p_149965_4_, func_149729_e(0));
/* 251 */           p_149965_1_.func_147444_c(p_149965_2_ + b, p_149965_3_ - 1, p_149965_4_, func_149729_e(0));
/* 252 */           p_149965_1_.func_147444_c(p_149965_2_ + b + 1, p_149965_3_ - 1, p_149965_4_, func_149729_e(0));
/* 253 */           p_149965_1_.func_147444_c(p_149965_2_ + b + 2, p_149965_3_ - 1, p_149965_4_, func_149729_e(0));
/* 254 */           p_149965_1_.func_147444_c(p_149965_2_ + b + 1, p_149965_3_ - 2, p_149965_4_, func_149729_e(0));
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean func_149966_a(World p_149966_1_, int p_149966_2_, int p_149966_3_, int p_149966_4_, int p_149966_5_) {
/* 263 */     if (p_149966_1_.func_147439_a(p_149966_2_, p_149966_3_, p_149966_4_) != this) {
/* 264 */       return false;
/*     */     }
/* 266 */     TileEntity tileEntity = p_149966_1_.func_147438_o(p_149966_2_, p_149966_3_, p_149966_4_);
/* 267 */     if (tileEntity == null || !(tileEntity instanceof TileEntitySkull)) {
/* 268 */       return false;
/*     */     }
/* 270 */     return (((TileEntitySkull)tileEntity).func_145904_a() == p_149966_5_);
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {}
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/* 280 */     return Blocks.field_150425_aM.func_149733_h(p_149691_1_);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String func_149702_O() {
/* 285 */     return func_149641_N() + "_" + ItemSkull.field_94587_a[0];
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockSkull.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */