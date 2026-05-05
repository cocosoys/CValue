/*     */ package net.minecraft.block;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.tileentity.TileEntityBrewingStand;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockBrewingStand extends BlockContainer {
/*  20 */   private Random field_149961_a = new Random(); @SideOnly(Side.CLIENT)
/*     */   private IIcon field_149960_b; private static final String __OBFID = "CL_00000207";
/*     */   
/*     */   public BlockBrewingStand() {
/*  24 */     super(Material.field_151573_f);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  29 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  34 */     return 25;
/*     */   }
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
/*  39 */     return (TileEntity)new TileEntityBrewingStand();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  44 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149743_a(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_) {
/*  49 */     func_149676_a(0.4375F, 0.0F, 0.4375F, 0.5625F, 0.875F, 0.5625F);
/*  50 */     super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/*  51 */     func_149683_g();
/*  52 */     super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149683_g() {
/*  57 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
/*  62 */     if (p_149727_1_.field_72995_K) {
/*  63 */       return true;
/*     */     }
/*  65 */     TileEntityBrewingStand tileEntityBrewingStand = (TileEntityBrewingStand)p_149727_1_.func_147438_o(p_149727_2_, p_149727_3_, p_149727_4_);
/*  66 */     if (tileEntityBrewingStand != null) p_149727_5_.func_146098_a(tileEntityBrewingStand);
/*     */     
/*  68 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149689_a(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
/*  73 */     if (p_149689_6_.func_82837_s()) {
/*  74 */       ((TileEntityBrewingStand)p_149689_1_.func_147438_o(p_149689_2_, p_149689_3_, p_149689_4_)).func_145937_a(p_149689_6_.func_82833_r());
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149734_b(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
/*  80 */     double d1 = (p_149734_2_ + 0.4F + p_149734_5_.nextFloat() * 0.2F);
/*  81 */     double d2 = (p_149734_3_ + 0.7F + p_149734_5_.nextFloat() * 0.3F);
/*  82 */     double d3 = (p_149734_4_ + 0.4F + p_149734_5_.nextFloat() * 0.2F);
/*     */     
/*  84 */     p_149734_1_.func_72869_a("smoke", d1, d2, d3, 0.0D, 0.0D, 0.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
/*  89 */     TileEntity tileEntity = p_149749_1_.func_147438_o(p_149749_2_, p_149749_3_, p_149749_4_);
/*  90 */     if (tileEntity instanceof TileEntityBrewingStand) {
/*  91 */       TileEntityBrewingStand tileEntityBrewingStand = (TileEntityBrewingStand)tileEntity;
/*  92 */       for (byte b = 0; b < tileEntityBrewingStand.func_70302_i_(); b++) {
/*  93 */         ItemStack itemStack = tileEntityBrewingStand.func_70301_a(b);
/*  94 */         if (itemStack != null) {
/*  95 */           float f1 = this.field_149961_a.nextFloat() * 0.8F + 0.1F;
/*  96 */           float f2 = this.field_149961_a.nextFloat() * 0.8F + 0.1F;
/*  97 */           float f3 = this.field_149961_a.nextFloat() * 0.8F + 0.1F;
/*     */           
/*  99 */           while (itemStack.field_77994_a > 0) {
/* 100 */             int i = this.field_149961_a.nextInt(21) + 10;
/* 101 */             if (i > itemStack.field_77994_a) i = itemStack.field_77994_a; 
/* 102 */             itemStack.field_77994_a -= i;
/*     */             
/* 104 */             EntityItem entityItem = new EntityItem(p_149749_1_, (p_149749_2_ + f1), (p_149749_3_ + f2), (p_149749_4_ + f3), new ItemStack(itemStack.func_77973_b(), i, itemStack.func_77960_j()));
/* 105 */             float f = 0.05F;
/* 106 */             entityItem.field_70159_w = ((float)this.field_149961_a.nextGaussian() * f);
/* 107 */             entityItem.field_70181_x = ((float)this.field_149961_a.nextGaussian() * f + 0.2F);
/* 108 */             entityItem.field_70179_y = ((float)this.field_149961_a.nextGaussian() * f);
/* 109 */             p_149749_1_.func_72838_d((Entity)entityItem);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 114 */     super.func_149749_a(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
/*     */   }
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 119 */     return Items.field_151067_bt;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
/* 124 */     return Items.field_151067_bt;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149740_M() {
/* 129 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149736_g(World p_149736_1_, int p_149736_2_, int p_149736_3_, int p_149736_4_, int p_149736_5_) {
/* 134 */     return Container.func_94526_b((IInventory)p_149736_1_.func_147438_o(p_149736_2_, p_149736_3_, p_149736_4_));
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 139 */     super.func_149651_a(p_149651_1_);
/* 140 */     this.field_149960_b = p_149651_1_.func_94245_a(func_149641_N() + "_base");
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149959_e() {
/* 144 */     return this.field_149960_b;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockBrewingStand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */