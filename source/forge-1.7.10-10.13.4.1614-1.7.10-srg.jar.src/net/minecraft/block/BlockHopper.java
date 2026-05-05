/*     */ package net.minecraft.block;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.tileentity.TileEntityHopper;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.Facing;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockHopper extends BlockContainer {
/*  26 */   private final Random field_149922_a = new Random();
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon field_149921_b;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon field_149923_M;
/*     */   
/*     */   public BlockHopper() {
/*  33 */     super(Material.field_151573_f);
/*  34 */     func_149647_a(CreativeTabs.field_78028_d);
/*  35 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon field_149924_N; private static final String __OBFID = "CL_00000257";
/*     */   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
/*  40 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149743_a(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_) {
/*  45 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.625F, 1.0F);
/*  46 */     super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/*  47 */     float f = 0.125F;
/*  48 */     func_149676_a(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
/*  49 */     super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/*  50 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
/*  51 */     super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/*  52 */     func_149676_a(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*  53 */     super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/*  54 */     func_149676_a(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
/*  55 */     super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/*     */     
/*  57 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149660_a(World p_149660_1_, int p_149660_2_, int p_149660_3_, int p_149660_4_, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_) {
/*  62 */     int i = Facing.field_71588_a[p_149660_5_];
/*  63 */     if (i == 1) i = 0; 
/*  64 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
/*  69 */     return (TileEntity)new TileEntityHopper();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149689_a(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
/*  74 */     super.func_149689_a(p_149689_1_, p_149689_2_, p_149689_3_, p_149689_4_, p_149689_5_, p_149689_6_);
/*     */     
/*  76 */     if (p_149689_6_.func_82837_s()) {
/*  77 */       TileEntityHopper tileEntityHopper = func_149920_e((IBlockAccess)p_149689_1_, p_149689_2_, p_149689_3_, p_149689_4_);
/*  78 */       tileEntityHopper.func_145886_a(p_149689_6_.func_82833_r());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
/*  84 */     super.func_149726_b(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
/*  85 */     func_149919_e(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
/*  90 */     if (p_149727_1_.field_72995_K) {
/*  91 */       return true;
/*     */     }
/*  93 */     TileEntityHopper tileEntityHopper = func_149920_e((IBlockAccess)p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_);
/*  94 */     if (tileEntityHopper != null) p_149727_5_.func_146093_a(tileEntityHopper); 
/*  95 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/* 100 */     func_149919_e(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_);
/*     */   }
/*     */   
/*     */   private void func_149919_e(World p_149919_1_, int p_149919_2_, int p_149919_3_, int p_149919_4_) {
/* 104 */     int i = p_149919_1_.func_72805_g(p_149919_2_, p_149919_3_, p_149919_4_);
/* 105 */     int j = func_149918_b(i);
/* 106 */     boolean bool1 = !p_149919_1_.func_72864_z(p_149919_2_, p_149919_3_, p_149919_4_);
/* 107 */     boolean bool2 = func_149917_c(i);
/*     */     
/* 109 */     if (bool1 != bool2) {
/* 110 */       p_149919_1_.func_72921_c(p_149919_2_, p_149919_3_, p_149919_4_, j | (bool1 ? 0 : 8), 4);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
/* 116 */     TileEntityHopper tileEntityHopper = (TileEntityHopper)p_149749_1_.func_147438_o(p_149749_2_, p_149749_3_, p_149749_4_);
/* 117 */     if (tileEntityHopper != null) {
/* 118 */       for (byte b = 0; b < tileEntityHopper.func_70302_i_(); b++) {
/* 119 */         ItemStack itemStack = tileEntityHopper.func_70301_a(b);
/* 120 */         if (itemStack != null) {
/* 121 */           float f1 = this.field_149922_a.nextFloat() * 0.8F + 0.1F;
/* 122 */           float f2 = this.field_149922_a.nextFloat() * 0.8F + 0.1F;
/* 123 */           float f3 = this.field_149922_a.nextFloat() * 0.8F + 0.1F;
/*     */           
/* 125 */           while (itemStack.field_77994_a > 0) {
/* 126 */             int i = this.field_149922_a.nextInt(21) + 10;
/* 127 */             if (i > itemStack.field_77994_a) i = itemStack.field_77994_a; 
/* 128 */             itemStack.field_77994_a -= i;
/*     */             
/* 130 */             EntityItem entityItem = new EntityItem(p_149749_1_, (p_149749_2_ + f1), (p_149749_3_ + f2), (p_149749_4_ + f3), new ItemStack(itemStack.func_77973_b(), i, itemStack.func_77960_j()));
/*     */             
/* 132 */             if (itemStack.func_77942_o()) {
/* 133 */               entityItem.func_92059_d().func_77982_d((NBTTagCompound)itemStack.func_77978_p().func_74737_b());
/*     */             }
/*     */             
/* 136 */             float f = 0.05F;
/* 137 */             entityItem.field_70159_w = ((float)this.field_149922_a.nextGaussian() * f);
/* 138 */             entityItem.field_70181_x = ((float)this.field_149922_a.nextGaussian() * f + 0.2F);
/* 139 */             entityItem.field_70179_y = ((float)this.field_149922_a.nextGaussian() * f);
/* 140 */             p_149749_1_.func_72838_d((Entity)entityItem);
/*     */           } 
/*     */         } 
/*     */       } 
/* 144 */       p_149749_1_.func_147453_f(p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_);
/*     */     } 
/*     */     
/* 147 */     super.func_149749_a(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 152 */     return 38;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 157 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 162 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149646_a(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
/* 167 */     return true;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/* 172 */     if (p_149691_1_ == 1) {
/* 173 */       return this.field_149923_M;
/*     */     }
/* 175 */     return this.field_149921_b;
/*     */   }
/*     */   
/*     */   public static int func_149918_b(int p_149918_0_) {
/* 179 */     return p_149918_0_ & 0x7;
/*     */   }
/*     */   
/*     */   public static boolean func_149917_c(int p_149917_0_) {
/* 183 */     return ((p_149917_0_ & 0x8) != 8);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149740_M() {
/* 188 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149736_g(World p_149736_1_, int p_149736_2_, int p_149736_3_, int p_149736_4_, int p_149736_5_) {
/* 193 */     return Container.func_94526_b((IInventory)func_149920_e((IBlockAccess)p_149736_1_, p_149736_2_, p_149736_3_, p_149736_4_));
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 198 */     this.field_149921_b = p_149651_1_.func_94245_a("hopper_outside");
/* 199 */     this.field_149923_M = p_149651_1_.func_94245_a("hopper_top");
/* 200 */     this.field_149924_N = p_149651_1_.func_94245_a("hopper_inside");
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static IIcon func_149916_e(String p_149916_0_) {
/* 205 */     if (p_149916_0_.equals("hopper_outside")) return Blocks.field_150438_bZ.field_149921_b; 
/* 206 */     if (p_149916_0_.equals("hopper_inside")) return Blocks.field_150438_bZ.field_149924_N; 
/* 207 */     return null;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String func_149702_O() {
/* 212 */     return "hopper";
/*     */   }
/*     */   
/*     */   public static TileEntityHopper func_149920_e(IBlockAccess p_149920_0_, int p_149920_1_, int p_149920_2_, int p_149920_3_) {
/* 216 */     return (TileEntityHopper)p_149920_0_.func_147438_o(p_149920_1_, p_149920_2_, p_149920_3_);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockHopper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */