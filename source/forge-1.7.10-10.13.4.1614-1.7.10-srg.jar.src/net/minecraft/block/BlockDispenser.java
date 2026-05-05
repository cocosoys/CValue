/*     */ package net.minecraft.block;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.dispenser.IBehaviorDispenseItem;
/*     */ import net.minecraft.dispenser.IBlockSource;
/*     */ import net.minecraft.dispenser.IPosition;
/*     */ import net.minecraft.dispenser.PositionImpl;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.tileentity.TileEntityDispenser;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.IRegistry;
/*     */ import net.minecraft.util.RegistryDefaulted;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockDispenser extends BlockContainer {
/*  24 */   public static final IRegistry field_149943_a = (IRegistry)new RegistryDefaulted(new BehaviorDefaultDispenseItem());
/*  25 */   protected Random field_149942_b = new Random(); @SideOnly(Side.CLIENT)
/*     */   protected IIcon field_149944_M; @SideOnly(Side.CLIENT)
/*     */   protected IIcon field_149945_N; @SideOnly(Side.CLIENT)
/*     */   protected IIcon field_149946_O; private static final String __OBFID = "CL_00000229";
/*     */   
/*     */   protected BlockDispenser() {
/*  31 */     super(Material.field_151576_e);
/*  32 */     func_149647_a(CreativeTabs.field_78028_d);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149738_a(World p_149738_1_) {
/*  37 */     return 4;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
/*  42 */     super.func_149726_b(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
/*  43 */     func_149938_m(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
/*     */   }
/*     */   
/*     */   private void func_149938_m(World p_149938_1_, int p_149938_2_, int p_149938_3_, int p_149938_4_) {
/*  47 */     if (p_149938_1_.field_72995_K) {
/*     */       return;
/*     */     }
/*     */     
/*  51 */     Block block1 = p_149938_1_.func_147439_a(p_149938_2_, p_149938_3_, p_149938_4_ - 1);
/*  52 */     Block block2 = p_149938_1_.func_147439_a(p_149938_2_, p_149938_3_, p_149938_4_ + 1);
/*  53 */     Block block3 = p_149938_1_.func_147439_a(p_149938_2_ - 1, p_149938_3_, p_149938_4_);
/*  54 */     Block block4 = p_149938_1_.func_147439_a(p_149938_2_ + 1, p_149938_3_, p_149938_4_);
/*     */     
/*  56 */     byte b = 3;
/*  57 */     if (block1.func_149730_j() && !block2.func_149730_j()) b = 3; 
/*  58 */     if (block2.func_149730_j() && !block1.func_149730_j()) b = 2; 
/*  59 */     if (block3.func_149730_j() && !block4.func_149730_j()) b = 5; 
/*  60 */     if (block4.func_149730_j() && !block3.func_149730_j()) b = 4; 
/*  61 */     p_149938_1_.func_72921_c(p_149938_2_, p_149938_3_, p_149938_4_, b, 2);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/*  66 */     int i = p_149691_2_ & 0x7;
/*     */     
/*  68 */     if (p_149691_1_ == i) {
/*  69 */       if (i == 1 || i == 0) {
/*  70 */         return this.field_149946_O;
/*     */       }
/*  72 */       return this.field_149945_N;
/*     */     } 
/*     */ 
/*     */     
/*  76 */     if (i == 1 || i == 0)
/*  77 */       return this.field_149944_M; 
/*  78 */     if (p_149691_1_ == 1 || p_149691_1_ == 0) {
/*  79 */       return this.field_149944_M;
/*     */     }
/*     */     
/*  82 */     return this.field_149761_L;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/*  87 */     this.field_149761_L = p_149651_1_.func_94245_a("furnace_side");
/*  88 */     this.field_149944_M = p_149651_1_.func_94245_a("furnace_top");
/*  89 */     this.field_149945_N = p_149651_1_.func_94245_a(func_149641_N() + "_front_horizontal");
/*  90 */     this.field_149946_O = p_149651_1_.func_94245_a(func_149641_N() + "_front_vertical");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
/*  95 */     if (p_149727_1_.field_72995_K) {
/*  96 */       return true;
/*     */     }
/*  98 */     TileEntityDispenser tileEntityDispenser = (TileEntityDispenser)p_149727_1_.func_147438_o(p_149727_2_, p_149727_3_, p_149727_4_);
/*  99 */     if (tileEntityDispenser != null) p_149727_5_.func_146102_a(tileEntityDispenser);
/*     */     
/* 101 */     return true;
/*     */   }
/*     */   
/*     */   protected void func_149941_e(World p_149941_1_, int p_149941_2_, int p_149941_3_, int p_149941_4_) {
/* 105 */     BlockSourceImpl blockSourceImpl = new BlockSourceImpl(p_149941_1_, p_149941_2_, p_149941_3_, p_149941_4_);
/* 106 */     TileEntityDispenser tileEntityDispenser = (TileEntityDispenser)blockSourceImpl.func_150835_j();
/* 107 */     if (tileEntityDispenser == null)
/*     */       return; 
/* 109 */     int i = tileEntityDispenser.func_146017_i();
/* 110 */     if (i < 0) {
/* 111 */       p_149941_1_.func_72926_e(1001, p_149941_2_, p_149941_3_, p_149941_4_, 0);
/*     */     } else {
/* 113 */       ItemStack itemStack = tileEntityDispenser.func_70301_a(i);
/* 114 */       IBehaviorDispenseItem iBehaviorDispenseItem = func_149940_a(itemStack);
/*     */       
/* 116 */       if (iBehaviorDispenseItem != IBehaviorDispenseItem.field_82483_a) {
/* 117 */         ItemStack itemStack1 = iBehaviorDispenseItem.func_82482_a(blockSourceImpl, itemStack);
/*     */         
/* 119 */         tileEntityDispenser.func_70299_a(i, (itemStack1.field_77994_a == 0) ? null : itemStack1);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected IBehaviorDispenseItem func_149940_a(ItemStack p_149940_1_) {
/* 125 */     return (IBehaviorDispenseItem)field_149943_a.func_82594_a(p_149940_1_.func_77973_b());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/* 131 */     boolean bool1 = (p_149695_1_.func_72864_z(p_149695_2_, p_149695_3_, p_149695_4_) || p_149695_1_.func_72864_z(p_149695_2_, p_149695_3_ + 1, p_149695_4_)) ? true : false;
/* 132 */     int i = p_149695_1_.func_72805_g(p_149695_2_, p_149695_3_, p_149695_4_);
/* 133 */     boolean bool2 = ((i & 0x8) != 0) ? true : false;
/*     */     
/* 135 */     if (bool1 && !bool2) {
/* 136 */       p_149695_1_.func_147464_a(p_149695_2_, p_149695_3_, p_149695_4_, this, func_149738_a(p_149695_1_));
/* 137 */       p_149695_1_.func_72921_c(p_149695_2_, p_149695_3_, p_149695_4_, i | 0x8, 4);
/*     */     }
/* 139 */     else if (!bool1 && bool2) {
/* 140 */       p_149695_1_.func_72921_c(p_149695_2_, p_149695_3_, p_149695_4_, i & 0xFFFFFFF7, 4);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/* 147 */     if (!p_149674_1_.field_72995_K) {
/* 148 */       func_149941_e(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
/* 154 */     return (TileEntity)new TileEntityDispenser();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149689_a(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
/* 159 */     int i = BlockPistonBase.func_150071_a(p_149689_1_, p_149689_2_, p_149689_3_, p_149689_4_, p_149689_5_);
/*     */     
/* 161 */     p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, i, 2);
/*     */     
/* 163 */     if (p_149689_6_.func_82837_s()) {
/* 164 */       ((TileEntityDispenser)p_149689_1_.func_147438_o(p_149689_2_, p_149689_3_, p_149689_4_)).func_146018_a(p_149689_6_.func_82833_r());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
/* 170 */     TileEntityDispenser tileEntityDispenser = (TileEntityDispenser)p_149749_1_.func_147438_o(p_149749_2_, p_149749_3_, p_149749_4_);
/* 171 */     if (tileEntityDispenser != null) {
/* 172 */       for (byte b = 0; b < tileEntityDispenser.func_70302_i_(); b++) {
/* 173 */         ItemStack itemStack = tileEntityDispenser.func_70301_a(b);
/* 174 */         if (itemStack != null) {
/* 175 */           float f1 = this.field_149942_b.nextFloat() * 0.8F + 0.1F;
/* 176 */           float f2 = this.field_149942_b.nextFloat() * 0.8F + 0.1F;
/* 177 */           float f3 = this.field_149942_b.nextFloat() * 0.8F + 0.1F;
/*     */           
/* 179 */           while (itemStack.field_77994_a > 0) {
/* 180 */             int i = this.field_149942_b.nextInt(21) + 10;
/* 181 */             if (i > itemStack.field_77994_a) i = itemStack.field_77994_a; 
/* 182 */             itemStack.field_77994_a -= i;
/*     */             
/* 184 */             EntityItem entityItem = new EntityItem(p_149749_1_, (p_149749_2_ + f1), (p_149749_3_ + f2), (p_149749_4_ + f3), new ItemStack(itemStack.func_77973_b(), i, itemStack.func_77960_j()));
/*     */             
/* 186 */             if (itemStack.func_77942_o()) {
/* 187 */               entityItem.func_92059_d().func_77982_d((NBTTagCompound)itemStack.func_77978_p().func_74737_b());
/*     */             }
/*     */             
/* 190 */             float f = 0.05F;
/* 191 */             entityItem.field_70159_w = ((float)this.field_149942_b.nextGaussian() * f);
/* 192 */             entityItem.field_70181_x = ((float)this.field_149942_b.nextGaussian() * f + 0.2F);
/* 193 */             entityItem.field_70179_y = ((float)this.field_149942_b.nextGaussian() * f);
/* 194 */             p_149749_1_.func_72838_d((Entity)entityItem);
/*     */           } 
/*     */         } 
/*     */       } 
/* 198 */       p_149749_1_.func_147453_f(p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_);
/*     */     } 
/* 200 */     super.func_149749_a(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
/*     */   }
/*     */   
/*     */   public static IPosition func_149939_a(IBlockSource p_149939_0_) {
/* 204 */     EnumFacing enumFacing = func_149937_b(p_149939_0_.func_82620_h());
/*     */     
/* 206 */     double d1 = p_149939_0_.func_82615_a() + 0.7D * enumFacing.func_82601_c();
/* 207 */     double d2 = p_149939_0_.func_82617_b() + 0.7D * enumFacing.func_96559_d();
/* 208 */     double d3 = p_149939_0_.func_82616_c() + 0.7D * enumFacing.func_82599_e();
/*     */     
/* 210 */     return (IPosition)new PositionImpl(d1, d2, d3);
/*     */   }
/*     */   
/*     */   public static EnumFacing func_149937_b(int p_149937_0_) {
/* 214 */     return EnumFacing.func_82600_a(p_149937_0_ & 0x7);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149740_M() {
/* 219 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149736_g(World p_149736_1_, int p_149736_2_, int p_149736_3_, int p_149736_4_, int p_149736_5_) {
/* 224 */     return Container.func_94526_b((IInventory)p_149736_1_.func_147438_o(p_149736_2_, p_149736_3_, p_149736_4_));
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockDispenser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */