/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ 
/*     */ public class BlockHopper
/*     */   extends BlockContainer {
/*   8 */   private final Random a = new Random();
/*     */   
/*     */   public BlockHopper() {
/*  11 */     super(Material.ORE);
/*  12 */     a(CreativeModeTab.d);
/*  13 */     a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   public void updateShape(IBlockAccess iblockaccess, int i, int j, int k) {
/*  17 */     a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   public void a(World world, int i, int j, int k, AxisAlignedBB axisalignedbb, List list, Entity entity) {
/*  21 */     a(0.0F, 0.0F, 0.0F, 1.0F, 0.625F, 1.0F);
/*  22 */     super.a(world, i, j, k, axisalignedbb, list, entity);
/*  23 */     float f = 0.125F;
/*     */     
/*  25 */     a(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
/*  26 */     super.a(world, i, j, k, axisalignedbb, list, entity);
/*  27 */     a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
/*  28 */     super.a(world, i, j, k, axisalignedbb, list, entity);
/*  29 */     a(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*  30 */     super.a(world, i, j, k, axisalignedbb, list, entity);
/*  31 */     a(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
/*  32 */     super.a(world, i, j, k, axisalignedbb, list, entity);
/*  33 */     a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   public int getPlacedData(World world, int i, int j, int k, int l, float f, float f1, float f2, int i1) {
/*  37 */     int j1 = Facing.OPPOSITE_FACING[l];
/*     */     
/*  39 */     if (j1 == 1) {
/*  40 */       j1 = 0;
/*     */     }
/*     */     
/*  43 */     return j1;
/*     */   }
/*     */   
/*     */   public TileEntity a(World world, int i) {
/*  47 */     return new TileEntityHopper();
/*     */   }
/*     */   
/*     */   public void postPlace(World world, int i, int j, int k, EntityLiving entityliving, ItemStack itemstack) {
/*  51 */     super.postPlace(world, i, j, k, entityliving, itemstack);
/*  52 */     if (itemstack.hasName()) {
/*  53 */       TileEntityHopper tileentityhopper = e(world, i, j, k);
/*     */       
/*  55 */       tileentityhopper.a(itemstack.getName());
/*     */     } 
/*     */   }
/*     */   
/*     */   public void onPlace(World world, int i, int j, int k) {
/*  60 */     super.onPlace(world, i, j, k);
/*  61 */     e(world, i, j, k);
/*     */   }
/*     */   
/*     */   public boolean interact(World world, int i, int j, int k, EntityHuman entityhuman, int l, float f, float f1, float f2) {
/*  65 */     if (world.isStatic) {
/*  66 */       return true;
/*     */     }
/*  68 */     TileEntityHopper tileentityhopper = e(world, i, j, k);
/*     */     
/*  70 */     if (tileentityhopper != null) {
/*  71 */       entityhuman.openHopper(tileentityhopper);
/*     */     }
/*     */     
/*  74 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void doPhysics(World world, int i, int j, int k, Block block) {
/*  79 */     e(world, i, j, k);
/*     */   }
/*     */   
/*     */   private void e(World world, int i, int j, int k) {
/*  83 */     int l = world.getData(i, j, k);
/*  84 */     int i1 = b(l);
/*  85 */     boolean flag = !world.isBlockIndirectlyPowered(i, j, k);
/*  86 */     boolean flag1 = c(l);
/*     */     
/*  88 */     if (flag != flag1) {
/*  89 */       world.setData(i, j, k, i1 | (flag ? 0 : 8), 4);
/*     */     }
/*     */   }
/*     */   
/*     */   public void remove(World world, int i, int j, int k, Block block, int l) {
/*  94 */     TileEntityHopper tileentityhopper = (TileEntityHopper)world.getTileEntity(i, j, k);
/*     */     
/*  96 */     if (tileentityhopper != null) {
/*  97 */       for (int i1 = 0; i1 < tileentityhopper.getSize(); i1++) {
/*  98 */         ItemStack itemstack = tileentityhopper.getItem(i1);
/*     */         
/* 100 */         if (itemstack != null) {
/* 101 */           float f = this.a.nextFloat() * 0.8F + 0.1F;
/* 102 */           float f1 = this.a.nextFloat() * 0.8F + 0.1F;
/* 103 */           float f2 = this.a.nextFloat() * 0.8F + 0.1F;
/*     */           
/* 105 */           while (itemstack.count > 0) {
/* 106 */             int j1 = this.a.nextInt(21) + 10;
/*     */             
/* 108 */             if (j1 > itemstack.count) {
/* 109 */               j1 = itemstack.count;
/*     */             }
/*     */             
/* 112 */             itemstack.count -= j1;
/* 113 */             EntityItem entityitem = new EntityItem(world, (i + f), (j + f1), (k + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getData()));
/*     */             
/* 115 */             if (itemstack.hasTag()) {
/* 116 */               entityitem.getItemStack().setTag((NBTTagCompound)itemstack.getTag().clone());
/*     */             }
/*     */             
/* 119 */             float f3 = 0.05F;
/*     */             
/* 121 */             entityitem.motX = ((float)this.a.nextGaussian() * f3);
/* 122 */             entityitem.motY = ((float)this.a.nextGaussian() * f3 + 0.2F);
/* 123 */             entityitem.motZ = ((float)this.a.nextGaussian() * f3);
/* 124 */             world.addEntity(entityitem);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 129 */       world.updateAdjacentComparators(i, j, k, block);
/*     */     } 
/*     */     
/* 132 */     super.remove(world, i, j, k, block, l);
/*     */   }
/*     */   
/*     */   public int b() {
/* 136 */     return 38;
/*     */   }
/*     */   
/*     */   public boolean d() {
/* 140 */     return false;
/*     */   }
/*     */   
/*     */   public boolean c() {
/* 144 */     return false;
/*     */   }
/*     */   
/*     */   public static int b(int i) {
/* 148 */     return Math.min(i & 0x7, 5);
/*     */   }
/*     */   
/*     */   public static boolean c(int i) {
/* 152 */     return ((i & 0x8) != 8);
/*     */   }
/*     */   
/*     */   public boolean isComplexRedstone() {
/* 156 */     return true;
/*     */   }
/*     */   
/*     */   public int g(World world, int i, int j, int k, int l) {
/* 160 */     return Container.b(e(world, i, j, k));
/*     */   }
/*     */   
/*     */   public static TileEntityHopper e(IBlockAccess iblockaccess, int i, int j, int k) {
/* 164 */     return (TileEntityHopper)iblockaccess.getTileEntity(i, j, k);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\BlockHopper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */