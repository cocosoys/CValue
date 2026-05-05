/*     */ package net.minecraft.block;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.tileentity.TileEntityFurnace;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockFurnace extends BlockContainer {
/*  22 */   private final Random field_149933_a = new Random(); private final boolean field_149932_b; private static boolean field_149934_M; @SideOnly(Side.CLIENT)
/*     */   private IIcon field_149935_N;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon field_149936_O;
/*     */   private static final String __OBFID = "CL_00000248";
/*     */   
/*     */   protected BlockFurnace(boolean p_i45407_1_) {
/*  29 */     super(Material.field_151576_e);
/*  30 */     this.field_149932_b = p_i45407_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/*  35 */     return Item.func_150898_a(Blocks.field_150460_al);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
/*  40 */     super.func_149726_b(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
/*  41 */     func_149930_e(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   private void func_149930_e(World p_149930_1_, int p_149930_2_, int p_149930_3_, int p_149930_4_) {
/*  46 */     if (p_149930_1_.field_72995_K) {
/*     */       return;
/*     */     }
/*     */     
/*  50 */     Block block1 = p_149930_1_.func_147439_a(p_149930_2_, p_149930_3_, p_149930_4_ - 1);
/*  51 */     Block block2 = p_149930_1_.func_147439_a(p_149930_2_, p_149930_3_, p_149930_4_ + 1);
/*  52 */     Block block3 = p_149930_1_.func_147439_a(p_149930_2_ - 1, p_149930_3_, p_149930_4_);
/*  53 */     Block block4 = p_149930_1_.func_147439_a(p_149930_2_ + 1, p_149930_3_, p_149930_4_);
/*     */     
/*  55 */     byte b = 3;
/*  56 */     if (block1.func_149730_j() && !block2.func_149730_j()) b = 3; 
/*  57 */     if (block2.func_149730_j() && !block1.func_149730_j()) b = 2; 
/*  58 */     if (block3.func_149730_j() && !block4.func_149730_j()) b = 5; 
/*  59 */     if (block4.func_149730_j() && !block3.func_149730_j()) b = 4; 
/*  60 */     p_149930_1_.func_72921_c(p_149930_2_, p_149930_3_, p_149930_4_, b, 2);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/*  65 */     if (p_149691_1_ == 1) return this.field_149935_N; 
/*  66 */     if (p_149691_1_ == 0) return this.field_149935_N;
/*     */     
/*  68 */     if (p_149691_1_ != p_149691_2_) return this.field_149761_L; 
/*  69 */     return this.field_149936_O;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/*  74 */     this.field_149761_L = p_149651_1_.func_94245_a("furnace_side");
/*  75 */     this.field_149936_O = p_149651_1_.func_94245_a(this.field_149932_b ? "furnace_front_on" : "furnace_front_off");
/*  76 */     this.field_149935_N = p_149651_1_.func_94245_a("furnace_top");
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149734_b(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
/*  81 */     if (!this.field_149932_b)
/*     */       return; 
/*  83 */     int i = p_149734_1_.func_72805_g(p_149734_2_, p_149734_3_, p_149734_4_);
/*     */     
/*  85 */     float f1 = p_149734_2_ + 0.5F;
/*  86 */     float f2 = p_149734_3_ + 0.0F + p_149734_5_.nextFloat() * 6.0F / 16.0F;
/*  87 */     float f3 = p_149734_4_ + 0.5F;
/*  88 */     float f4 = 0.52F;
/*  89 */     float f5 = p_149734_5_.nextFloat() * 0.6F - 0.3F;
/*     */     
/*  91 */     if (i == 4) {
/*  92 */       p_149734_1_.func_72869_a("smoke", (f1 - f4), f2, (f3 + f5), 0.0D, 0.0D, 0.0D);
/*  93 */       p_149734_1_.func_72869_a("flame", (f1 - f4), f2, (f3 + f5), 0.0D, 0.0D, 0.0D);
/*  94 */     } else if (i == 5) {
/*  95 */       p_149734_1_.func_72869_a("smoke", (f1 + f4), f2, (f3 + f5), 0.0D, 0.0D, 0.0D);
/*  96 */       p_149734_1_.func_72869_a("flame", (f1 + f4), f2, (f3 + f5), 0.0D, 0.0D, 0.0D);
/*  97 */     } else if (i == 2) {
/*  98 */       p_149734_1_.func_72869_a("smoke", (f1 + f5), f2, (f3 - f4), 0.0D, 0.0D, 0.0D);
/*  99 */       p_149734_1_.func_72869_a("flame", (f1 + f5), f2, (f3 - f4), 0.0D, 0.0D, 0.0D);
/* 100 */     } else if (i == 3) {
/* 101 */       p_149734_1_.func_72869_a("smoke", (f1 + f5), f2, (f3 + f4), 0.0D, 0.0D, 0.0D);
/* 102 */       p_149734_1_.func_72869_a("flame", (f1 + f5), f2, (f3 + f4), 0.0D, 0.0D, 0.0D);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
/* 108 */     if (p_149727_1_.field_72995_K) {
/* 109 */       return true;
/*     */     }
/* 111 */     TileEntityFurnace tileEntityFurnace = (TileEntityFurnace)p_149727_1_.func_147438_o(p_149727_2_, p_149727_3_, p_149727_4_);
/* 112 */     if (tileEntityFurnace != null) p_149727_5_.func_146101_a(tileEntityFurnace); 
/* 113 */     return true;
/*     */   }
/*     */   
/*     */   public static void func_149931_a(boolean p_149931_0_, World p_149931_1_, int p_149931_2_, int p_149931_3_, int p_149931_4_) {
/* 117 */     int i = p_149931_1_.func_72805_g(p_149931_2_, p_149931_3_, p_149931_4_);
/* 118 */     TileEntity tileEntity = p_149931_1_.func_147438_o(p_149931_2_, p_149931_3_, p_149931_4_);
/*     */     
/* 120 */     field_149934_M = true;
/* 121 */     if (p_149931_0_) { p_149931_1_.func_147449_b(p_149931_2_, p_149931_3_, p_149931_4_, Blocks.field_150470_am); }
/* 122 */     else { p_149931_1_.func_147449_b(p_149931_2_, p_149931_3_, p_149931_4_, Blocks.field_150460_al); }
/* 123 */      field_149934_M = false;
/*     */     
/* 125 */     p_149931_1_.func_72921_c(p_149931_2_, p_149931_3_, p_149931_4_, i, 2);
/*     */     
/* 127 */     if (tileEntity != null) {
/* 128 */       tileEntity.func_145829_t();
/* 129 */       p_149931_1_.func_147455_a(p_149931_2_, p_149931_3_, p_149931_4_, tileEntity);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
/* 135 */     return (TileEntity)new TileEntityFurnace();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149689_a(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
/* 140 */     int i = MathHelper.func_76128_c((p_149689_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 0x3;
/*     */     
/* 142 */     if (i == 0) p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, 2, 2); 
/* 143 */     if (i == 1) p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, 5, 2); 
/* 144 */     if (i == 2) p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, 3, 2); 
/* 145 */     if (i == 3) p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, 4, 2);
/*     */     
/* 147 */     if (p_149689_6_.func_82837_s()) {
/* 148 */       ((TileEntityFurnace)p_149689_1_.func_147438_o(p_149689_2_, p_149689_3_, p_149689_4_)).func_145951_a(p_149689_6_.func_82833_r());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
/* 154 */     if (!field_149934_M) {
/* 155 */       TileEntityFurnace tileEntityFurnace = (TileEntityFurnace)p_149749_1_.func_147438_o(p_149749_2_, p_149749_3_, p_149749_4_);
/* 156 */       if (tileEntityFurnace != null) {
/* 157 */         for (byte b = 0; b < tileEntityFurnace.func_70302_i_(); b++) {
/* 158 */           ItemStack itemStack = tileEntityFurnace.func_70301_a(b);
/* 159 */           if (itemStack != null) {
/* 160 */             float f1 = this.field_149933_a.nextFloat() * 0.8F + 0.1F;
/* 161 */             float f2 = this.field_149933_a.nextFloat() * 0.8F + 0.1F;
/* 162 */             float f3 = this.field_149933_a.nextFloat() * 0.8F + 0.1F;
/*     */             
/* 164 */             while (itemStack.field_77994_a > 0) {
/* 165 */               int i = this.field_149933_a.nextInt(21) + 10;
/* 166 */               if (i > itemStack.field_77994_a) i = itemStack.field_77994_a; 
/* 167 */               itemStack.field_77994_a -= i;
/*     */               
/* 169 */               EntityItem entityItem = new EntityItem(p_149749_1_, (p_149749_2_ + f1), (p_149749_3_ + f2), (p_149749_4_ + f3), new ItemStack(itemStack.func_77973_b(), i, itemStack.func_77960_j()));
/*     */               
/* 171 */               if (itemStack.func_77942_o()) {
/* 172 */                 entityItem.func_92059_d().func_77982_d((NBTTagCompound)itemStack.func_77978_p().func_74737_b());
/*     */               }
/*     */               
/* 175 */               float f = 0.05F;
/* 176 */               entityItem.field_70159_w = ((float)this.field_149933_a.nextGaussian() * f);
/* 177 */               entityItem.field_70181_x = ((float)this.field_149933_a.nextGaussian() * f + 0.2F);
/* 178 */               entityItem.field_70179_y = ((float)this.field_149933_a.nextGaussian() * f);
/* 179 */               p_149749_1_.func_72838_d((Entity)entityItem);
/*     */             } 
/*     */           } 
/*     */         } 
/* 183 */         p_149749_1_.func_147453_f(p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_);
/*     */       } 
/*     */     } 
/* 186 */     super.func_149749_a(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149740_M() {
/* 191 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149736_g(World p_149736_1_, int p_149736_2_, int p_149736_3_, int p_149736_4_, int p_149736_5_) {
/* 196 */     return Container.func_94526_b((IInventory)p_149736_1_.func_147438_o(p_149736_2_, p_149736_3_, p_149736_4_));
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
/* 201 */     return Item.func_150898_a(Blocks.field_150460_al);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockFurnace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */