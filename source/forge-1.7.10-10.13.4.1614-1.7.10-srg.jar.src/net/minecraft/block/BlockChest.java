/*     */ package net.minecraft.block;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.passive.EntityOcelot;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.InventoryLargeChest;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.tileentity.TileEntityChest;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockChest extends BlockContainer {
/*  27 */   private final Random field_149955_b = new Random();
/*     */   public final int field_149956_a;
/*     */   
/*     */   protected BlockChest(int p_i45397_1_) {
/*  31 */     super(Material.field_151575_d);
/*  32 */     this.field_149956_a = p_i45397_1_;
/*  33 */     func_149647_a(CreativeTabs.field_78031_c);
/*     */     
/*  35 */     func_149676_a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
/*     */   }
/*     */   private static final String __OBFID = "CL_00000214";
/*     */   
/*     */   public boolean func_149662_c() {
/*  40 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  45 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  50 */     return 22;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
/*  55 */     if (p_149719_1_.func_147439_a(p_149719_2_, p_149719_3_, p_149719_4_ - 1) == this) {
/*  56 */       func_149676_a(0.0625F, 0.0F, 0.0F, 0.9375F, 0.875F, 0.9375F);
/*  57 */     } else if (p_149719_1_.func_147439_a(p_149719_2_, p_149719_3_, p_149719_4_ + 1) == this) {
/*  58 */       func_149676_a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 1.0F);
/*  59 */     } else if (p_149719_1_.func_147439_a(p_149719_2_ - 1, p_149719_3_, p_149719_4_) == this) {
/*  60 */       func_149676_a(0.0F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
/*  61 */     } else if (p_149719_1_.func_147439_a(p_149719_2_ + 1, p_149719_3_, p_149719_4_) == this) {
/*  62 */       func_149676_a(0.0625F, 0.0F, 0.0625F, 1.0F, 0.875F, 0.9375F);
/*     */     } else {
/*  64 */       func_149676_a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
/*  70 */     super.func_149726_b(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
/*  71 */     func_149954_e(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
/*     */     
/*  73 */     Block block1 = p_149726_1_.func_147439_a(p_149726_2_, p_149726_3_, p_149726_4_ - 1);
/*  74 */     Block block2 = p_149726_1_.func_147439_a(p_149726_2_, p_149726_3_, p_149726_4_ + 1);
/*  75 */     Block block3 = p_149726_1_.func_147439_a(p_149726_2_ - 1, p_149726_3_, p_149726_4_);
/*  76 */     Block block4 = p_149726_1_.func_147439_a(p_149726_2_ + 1, p_149726_3_, p_149726_4_);
/*  77 */     if (block1 == this) func_149954_e(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_ - 1); 
/*  78 */     if (block2 == this) func_149954_e(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_ + 1); 
/*  79 */     if (block3 == this) func_149954_e(p_149726_1_, p_149726_2_ - 1, p_149726_3_, p_149726_4_); 
/*  80 */     if (block4 == this) func_149954_e(p_149726_1_, p_149726_2_ + 1, p_149726_3_, p_149726_4_);
/*     */   
/*     */   }
/*     */   
/*     */   public void func_149689_a(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
/*  85 */     Block block1 = p_149689_1_.func_147439_a(p_149689_2_, p_149689_3_, p_149689_4_ - 1);
/*  86 */     Block block2 = p_149689_1_.func_147439_a(p_149689_2_, p_149689_3_, p_149689_4_ + 1);
/*  87 */     Block block3 = p_149689_1_.func_147439_a(p_149689_2_ - 1, p_149689_3_, p_149689_4_);
/*  88 */     Block block4 = p_149689_1_.func_147439_a(p_149689_2_ + 1, p_149689_3_, p_149689_4_);
/*     */     
/*  90 */     byte b = 0;
/*  91 */     int i = MathHelper.func_76128_c((p_149689_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 0x3;
/*     */     
/*  93 */     if (i == 0) b = 2; 
/*  94 */     if (i == 1) b = 5; 
/*  95 */     if (i == 2) b = 3; 
/*  96 */     if (i == 3) b = 4;
/*     */     
/*  98 */     if (block1 != this && block2 != this && block3 != this && block4 != this) {
/*  99 */       p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, b, 3);
/*     */     } else {
/* 101 */       if ((block1 == this || block2 == this) && (b == 4 || b == 5)) {
/* 102 */         if (block1 == this) { p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_ - 1, b, 3); }
/* 103 */         else { p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_ + 1, b, 3); }
/* 104 */          p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, b, 3);
/*     */       } 
/* 106 */       if ((block3 == this || block4 == this) && (b == 2 || b == 3)) {
/* 107 */         if (block3 == this) { p_149689_1_.func_72921_c(p_149689_2_ - 1, p_149689_3_, p_149689_4_, b, 3); }
/* 108 */         else { p_149689_1_.func_72921_c(p_149689_2_ + 1, p_149689_3_, p_149689_4_, b, 3); }
/* 109 */          p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, b, 3);
/*     */       } 
/*     */     } 
/*     */     
/* 113 */     if (p_149689_6_.func_82837_s()) {
/* 114 */       ((TileEntityChest)p_149689_1_.func_147438_o(p_149689_2_, p_149689_3_, p_149689_4_)).func_145976_a(p_149689_6_.func_82833_r());
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_149954_e(World p_149954_1_, int p_149954_2_, int p_149954_3_, int p_149954_4_) {
/* 119 */     if (p_149954_1_.field_72995_K) {
/*     */       return;
/*     */     }
/*     */     
/* 123 */     Block block1 = p_149954_1_.func_147439_a(p_149954_2_, p_149954_3_, p_149954_4_ - 1);
/* 124 */     Block block2 = p_149954_1_.func_147439_a(p_149954_2_, p_149954_3_, p_149954_4_ + 1);
/* 125 */     Block block3 = p_149954_1_.func_147439_a(p_149954_2_ - 1, p_149954_3_, p_149954_4_);
/* 126 */     Block block4 = p_149954_1_.func_147439_a(p_149954_2_ + 1, p_149954_3_, p_149954_4_);
/*     */ 
/*     */     
/* 129 */     byte b = 4;
/* 130 */     if (block1 == this || block2 == this) {
/* 131 */       int i = (block1 == this) ? (p_149954_4_ - 1) : (p_149954_4_ + 1);
/* 132 */       Block block5 = p_149954_1_.func_147439_a(p_149954_2_ - 1, p_149954_3_, i);
/* 133 */       int j = (block1 == this) ? (p_149954_4_ - 1) : (p_149954_4_ + 1);
/* 134 */       Block block6 = p_149954_1_.func_147439_a(p_149954_2_ + 1, p_149954_3_, j);
/*     */       
/* 136 */       b = 5;
/*     */       
/* 138 */       int k = -1;
/* 139 */       if (block1 == this) { k = p_149954_1_.func_72805_g(p_149954_2_, p_149954_3_, p_149954_4_ - 1); }
/* 140 */       else { k = p_149954_1_.func_72805_g(p_149954_2_, p_149954_3_, p_149954_4_ + 1); }
/* 141 */        if (k == 4) b = 4;
/*     */       
/* 143 */       if ((block3.func_149730_j() || block5.func_149730_j()) && !block4.func_149730_j() && !block6.func_149730_j()) b = 5; 
/* 144 */       if ((block4.func_149730_j() || block6.func_149730_j()) && !block3.func_149730_j() && !block5.func_149730_j()) b = 4; 
/* 145 */     } else if (block3 == this || block4 == this) {
/* 146 */       int i = (block3 == this) ? (p_149954_2_ - 1) : (p_149954_2_ + 1);
/* 147 */       Block block5 = p_149954_1_.func_147439_a(i, p_149954_3_, p_149954_4_ - 1);
/* 148 */       int j = (block3 == this) ? (p_149954_2_ - 1) : (p_149954_2_ + 1);
/* 149 */       Block block6 = p_149954_1_.func_147439_a(j, p_149954_3_, p_149954_4_ + 1);
/*     */       
/* 151 */       b = 3;
/* 152 */       int k = -1;
/* 153 */       if (block3 == this) { k = p_149954_1_.func_72805_g(p_149954_2_ - 1, p_149954_3_, p_149954_4_); }
/* 154 */       else { k = p_149954_1_.func_72805_g(p_149954_2_ + 1, p_149954_3_, p_149954_4_); }
/* 155 */        if (k == 2) b = 2;
/*     */       
/* 157 */       if ((block1.func_149730_j() || block5.func_149730_j()) && !block2.func_149730_j() && !block6.func_149730_j()) b = 3; 
/* 158 */       if ((block2.func_149730_j() || block6.func_149730_j()) && !block1.func_149730_j() && !block5.func_149730_j()) b = 2; 
/*     */     } else {
/* 160 */       b = 3;
/* 161 */       if (block1.func_149730_j() && !block2.func_149730_j()) b = 3; 
/* 162 */       if (block2.func_149730_j() && !block1.func_149730_j()) b = 2; 
/* 163 */       if (block3.func_149730_j() && !block4.func_149730_j()) b = 5; 
/* 164 */       if (block4.func_149730_j() && !block3.func_149730_j()) b = 4;
/*     */     
/*     */     } 
/* 167 */     p_149954_1_.func_72921_c(p_149954_2_, p_149954_3_, p_149954_4_, b, 3);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
/* 172 */     byte b = 0;
/*     */     
/* 174 */     if (p_149742_1_.func_147439_a(p_149742_2_ - 1, p_149742_3_, p_149742_4_) == this) b++; 
/* 175 */     if (p_149742_1_.func_147439_a(p_149742_2_ + 1, p_149742_3_, p_149742_4_) == this) b++; 
/* 176 */     if (p_149742_1_.func_147439_a(p_149742_2_, p_149742_3_, p_149742_4_ - 1) == this) b++; 
/* 177 */     if (p_149742_1_.func_147439_a(p_149742_2_, p_149742_3_, p_149742_4_ + 1) == this) b++;
/*     */     
/* 179 */     if (b > 1) return false;
/*     */     
/* 181 */     if (func_149952_n(p_149742_1_, p_149742_2_ - 1, p_149742_3_, p_149742_4_)) return false; 
/* 182 */     if (func_149952_n(p_149742_1_, p_149742_2_ + 1, p_149742_3_, p_149742_4_)) return false; 
/* 183 */     if (func_149952_n(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_ - 1)) return false; 
/* 184 */     if (func_149952_n(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_ + 1)) return false; 
/* 185 */     return true;
/*     */   }
/*     */   
/*     */   private boolean func_149952_n(World p_149952_1_, int p_149952_2_, int p_149952_3_, int p_149952_4_) {
/* 189 */     if (p_149952_1_.func_147439_a(p_149952_2_, p_149952_3_, p_149952_4_) != this) return false; 
/* 190 */     if (p_149952_1_.func_147439_a(p_149952_2_ - 1, p_149952_3_, p_149952_4_) == this) return true; 
/* 191 */     if (p_149952_1_.func_147439_a(p_149952_2_ + 1, p_149952_3_, p_149952_4_) == this) return true; 
/* 192 */     if (p_149952_1_.func_147439_a(p_149952_2_, p_149952_3_, p_149952_4_ - 1) == this) return true; 
/* 193 */     if (p_149952_1_.func_147439_a(p_149952_2_, p_149952_3_, p_149952_4_ + 1) == this) return true; 
/* 194 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/* 199 */     super.func_149695_a(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_5_);
/* 200 */     TileEntityChest tileEntityChest = (TileEntityChest)p_149695_1_.func_147438_o(p_149695_2_, p_149695_3_, p_149695_4_);
/* 201 */     if (tileEntityChest != null) tileEntityChest.func_145836_u();
/*     */   
/*     */   }
/*     */   
/*     */   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
/* 206 */     TileEntityChest tileEntityChest = (TileEntityChest)p_149749_1_.func_147438_o(p_149749_2_, p_149749_3_, p_149749_4_);
/* 207 */     if (tileEntityChest != null) {
/* 208 */       for (byte b = 0; b < tileEntityChest.func_70302_i_(); b++) {
/* 209 */         ItemStack itemStack = tileEntityChest.func_70301_a(b);
/* 210 */         if (itemStack != null) {
/* 211 */           float f1 = this.field_149955_b.nextFloat() * 0.8F + 0.1F;
/* 212 */           float f2 = this.field_149955_b.nextFloat() * 0.8F + 0.1F;
/* 213 */           float f3 = this.field_149955_b.nextFloat() * 0.8F + 0.1F;
/*     */           
/* 215 */           while (itemStack.field_77994_a > 0) {
/* 216 */             int i = this.field_149955_b.nextInt(21) + 10;
/* 217 */             if (i > itemStack.field_77994_a) i = itemStack.field_77994_a; 
/* 218 */             itemStack.field_77994_a -= i;
/*     */             
/* 220 */             EntityItem entityItem = new EntityItem(p_149749_1_, (p_149749_2_ + f1), (p_149749_3_ + f2), (p_149749_4_ + f3), new ItemStack(itemStack.func_77973_b(), i, itemStack.func_77960_j()));
/* 221 */             float f = 0.05F;
/* 222 */             entityItem.field_70159_w = ((float)this.field_149955_b.nextGaussian() * f);
/* 223 */             entityItem.field_70181_x = ((float)this.field_149955_b.nextGaussian() * f + 0.2F);
/* 224 */             entityItem.field_70179_y = ((float)this.field_149955_b.nextGaussian() * f);
/* 225 */             if (itemStack.func_77942_o()) {
/* 226 */               entityItem.func_92059_d().func_77982_d((NBTTagCompound)itemStack.func_77978_p().func_74737_b());
/*     */             }
/* 228 */             p_149749_1_.func_72838_d((Entity)entityItem);
/*     */           } 
/*     */         } 
/*     */       } 
/* 232 */       p_149749_1_.func_147453_f(p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_);
/*     */     } 
/* 234 */     super.func_149749_a(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
/* 239 */     if (p_149727_1_.field_72995_K) return true; 
/* 240 */     IInventory iInventory = func_149951_m(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_);
/*     */     
/* 242 */     if (iInventory != null) {
/* 243 */       p_149727_5_.func_71007_a(iInventory);
/*     */     }
/*     */     
/* 246 */     return true;
/*     */   }
/*     */   public IInventory func_149951_m(World p_149951_1_, int p_149951_2_, int p_149951_3_, int p_149951_4_) {
/*     */     InventoryLargeChest inventoryLargeChest;
/* 250 */     TileEntityChest tileEntityChest = (TileEntityChest)p_149951_1_.func_147438_o(p_149951_2_, p_149951_3_, p_149951_4_);
/* 251 */     if (tileEntityChest == null) return null;
/*     */     
/* 253 */     if (p_149951_1_.func_147439_a(p_149951_2_, p_149951_3_ + 1, p_149951_4_).func_149721_r()) return null; 
/* 254 */     if (func_149953_o(p_149951_1_, p_149951_2_, p_149951_3_, p_149951_4_)) return null;
/*     */     
/* 256 */     if (p_149951_1_.func_147439_a(p_149951_2_ - 1, p_149951_3_, p_149951_4_) == this && (p_149951_1_.func_147439_a(p_149951_2_ - 1, p_149951_3_ + 1, p_149951_4_).func_149721_r() || func_149953_o(p_149951_1_, p_149951_2_ - 1, p_149951_3_, p_149951_4_))) return null; 
/* 257 */     if (p_149951_1_.func_147439_a(p_149951_2_ + 1, p_149951_3_, p_149951_4_) == this && (p_149951_1_.func_147439_a(p_149951_2_ + 1, p_149951_3_ + 1, p_149951_4_).func_149721_r() || func_149953_o(p_149951_1_, p_149951_2_ + 1, p_149951_3_, p_149951_4_))) return null; 
/* 258 */     if (p_149951_1_.func_147439_a(p_149951_2_, p_149951_3_, p_149951_4_ - 1) == this && (p_149951_1_.func_147439_a(p_149951_2_, p_149951_3_ + 1, p_149951_4_ - 1).func_149721_r() || func_149953_o(p_149951_1_, p_149951_2_, p_149951_3_, p_149951_4_ - 1))) return null; 
/* 259 */     if (p_149951_1_.func_147439_a(p_149951_2_, p_149951_3_, p_149951_4_ + 1) == this && (p_149951_1_.func_147439_a(p_149951_2_, p_149951_3_ + 1, p_149951_4_ + 1).func_149721_r() || func_149953_o(p_149951_1_, p_149951_2_, p_149951_3_, p_149951_4_ + 1))) return null;
/*     */     
/* 261 */     if (p_149951_1_.func_147439_a(p_149951_2_ - 1, p_149951_3_, p_149951_4_) == this) inventoryLargeChest = new InventoryLargeChest("container.chestDouble", (IInventory)p_149951_1_.func_147438_o(p_149951_2_ - 1, p_149951_3_, p_149951_4_), (IInventory)tileEntityChest); 
/* 262 */     if (p_149951_1_.func_147439_a(p_149951_2_ + 1, p_149951_3_, p_149951_4_) == this) inventoryLargeChest = new InventoryLargeChest("container.chestDouble", (IInventory)inventoryLargeChest, (IInventory)p_149951_1_.func_147438_o(p_149951_2_ + 1, p_149951_3_, p_149951_4_)); 
/* 263 */     if (p_149951_1_.func_147439_a(p_149951_2_, p_149951_3_, p_149951_4_ - 1) == this) inventoryLargeChest = new InventoryLargeChest("container.chestDouble", (IInventory)p_149951_1_.func_147438_o(p_149951_2_, p_149951_3_, p_149951_4_ - 1), (IInventory)inventoryLargeChest); 
/* 264 */     if (p_149951_1_.func_147439_a(p_149951_2_, p_149951_3_, p_149951_4_ + 1) == this) inventoryLargeChest = new InventoryLargeChest("container.chestDouble", (IInventory)inventoryLargeChest, (IInventory)p_149951_1_.func_147438_o(p_149951_2_, p_149951_3_, p_149951_4_ + 1));
/*     */     
/* 266 */     return (IInventory)inventoryLargeChest;
/*     */   }
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
/* 271 */     return (TileEntity)new TileEntityChest();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149744_f() {
/* 277 */     return (this.field_149956_a == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149709_b(IBlockAccess p_149709_1_, int p_149709_2_, int p_149709_3_, int p_149709_4_, int p_149709_5_) {
/* 282 */     if (!func_149744_f()) return 0;
/*     */     
/* 284 */     int i = ((TileEntityChest)p_149709_1_.func_147438_o(p_149709_2_, p_149709_3_, p_149709_4_)).field_145987_o;
/* 285 */     return MathHelper.func_76125_a(i, 0, 15);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149748_c(IBlockAccess p_149748_1_, int p_149748_2_, int p_149748_3_, int p_149748_4_, int p_149748_5_) {
/* 290 */     if (p_149748_5_ == 1) {
/* 291 */       return func_149709_b(p_149748_1_, p_149748_2_, p_149748_3_, p_149748_4_, p_149748_5_);
/*     */     }
/* 293 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean func_149953_o(World p_149953_0_, int p_149953_1_, int p_149953_2_, int p_149953_3_) {
/* 298 */     for (Entity entity : p_149953_0_.func_72872_a(EntityOcelot.class, AxisAlignedBB.func_72330_a(p_149953_1_, (p_149953_2_ + 1), p_149953_3_, (p_149953_1_ + 1), (p_149953_2_ + 2), (p_149953_3_ + 1)))) {
/* 299 */       EntityOcelot entityOcelot = (EntityOcelot)entity;
/* 300 */       if (entityOcelot.func_70906_o()) return true; 
/*     */     } 
/* 302 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149740_M() {
/* 307 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149736_g(World p_149736_1_, int p_149736_2_, int p_149736_3_, int p_149736_4_, int p_149736_5_) {
/* 312 */     return Container.func_94526_b(func_149951_m(p_149736_1_, p_149736_2_, p_149736_3_, p_149736_4_));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 319 */     this.field_149761_L = p_149651_1_.func_94245_a("planks_oak");
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockChest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */