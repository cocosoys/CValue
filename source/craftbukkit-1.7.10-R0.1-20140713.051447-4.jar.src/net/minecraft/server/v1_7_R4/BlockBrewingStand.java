/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockBrewingStand
/*     */   extends BlockContainer
/*     */ {
/*  20 */   private Random a = new Random();
/*     */ 
/*     */   
/*     */   public BlockBrewingStand() {
/*  24 */     super(Material.ORE);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean c() {
/*  29 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int b() {
/*  34 */     return 25;
/*     */   }
/*     */ 
/*     */   
/*     */   public TileEntity a(World paramWorld, int paramInt) {
/*  39 */     return new TileEntityBrewingStand();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean d() {
/*  44 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(World paramWorld, int paramInt1, int paramInt2, int paramInt3, AxisAlignedBB paramAxisAlignedBB, List paramList, Entity paramEntity) {
/*  49 */     a(0.4375F, 0.0F, 0.4375F, 0.5625F, 0.875F, 0.5625F);
/*  50 */     super.a(paramWorld, paramInt1, paramInt2, paramInt3, paramAxisAlignedBB, paramList, paramEntity);
/*  51 */     g();
/*  52 */     super.a(paramWorld, paramInt1, paramInt2, paramInt3, paramAxisAlignedBB, paramList, paramEntity);
/*     */   }
/*     */ 
/*     */   
/*     */   public void g() {
/*  57 */     a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean interact(World paramWorld, int paramInt1, int paramInt2, int paramInt3, EntityHuman paramEntityHuman, int paramInt4, float paramFloat1, float paramFloat2, float paramFloat3) {
/*  62 */     if (paramWorld.isStatic) {
/*  63 */       return true;
/*     */     }
/*  65 */     TileEntityBrewingStand tileEntityBrewingStand = (TileEntityBrewingStand)paramWorld.getTileEntity(paramInt1, paramInt2, paramInt3);
/*  66 */     if (tileEntityBrewingStand != null) paramEntityHuman.openBrewingStand(tileEntityBrewingStand);
/*     */     
/*  68 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void postPlace(World paramWorld, int paramInt1, int paramInt2, int paramInt3, EntityLiving paramEntityLiving, ItemStack paramItemStack) {
/*  73 */     if (paramItemStack.hasName()) {
/*  74 */       ((TileEntityBrewingStand)paramWorld.getTileEntity(paramInt1, paramInt2, paramInt3)).a(paramItemStack.getName());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(World paramWorld, int paramInt1, int paramInt2, int paramInt3, Block paramBlock, int paramInt4) {
/*  89 */     TileEntity tileEntity = paramWorld.getTileEntity(paramInt1, paramInt2, paramInt3);
/*  90 */     if (tileEntity instanceof TileEntityBrewingStand) {
/*  91 */       TileEntityBrewingStand tileEntityBrewingStand = (TileEntityBrewingStand)tileEntity;
/*  92 */       for (byte b = 0; b < tileEntityBrewingStand.getSize(); b++) {
/*  93 */         ItemStack itemStack = tileEntityBrewingStand.getItem(b);
/*  94 */         if (itemStack != null) {
/*  95 */           float f1 = this.a.nextFloat() * 0.8F + 0.1F;
/*  96 */           float f2 = this.a.nextFloat() * 0.8F + 0.1F;
/*  97 */           float f3 = this.a.nextFloat() * 0.8F + 0.1F;
/*     */           
/*  99 */           while (itemStack.count > 0) {
/* 100 */             int i = this.a.nextInt(21) + 10;
/* 101 */             if (i > itemStack.count) i = itemStack.count; 
/* 102 */             itemStack.count -= i;
/*     */             
/* 104 */             EntityItem entityItem = new EntityItem(paramWorld, (paramInt1 + f1), (paramInt2 + f2), (paramInt3 + f3), new ItemStack(itemStack.getItem(), i, itemStack.getData()));
/* 105 */             float f = 0.05F;
/* 106 */             entityItem.motX = ((float)this.a.nextGaussian() * f);
/* 107 */             entityItem.motY = ((float)this.a.nextGaussian() * f + 0.2F);
/* 108 */             entityItem.motZ = ((float)this.a.nextGaussian() * f);
/* 109 */             paramWorld.addEntity(entityItem);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 114 */     super.remove(paramWorld, paramInt1, paramInt2, paramInt3, paramBlock, paramInt4);
/*     */   }
/*     */ 
/*     */   
/*     */   public Item getDropType(int paramInt1, Random paramRandom, int paramInt2) {
/* 119 */     return Items.BREWING_STAND;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isComplexRedstone() {
/* 129 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int g(World paramWorld, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 134 */     return Container.b((IInventory)paramWorld.getTileEntity(paramInt1, paramInt2, paramInt3));
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\BlockBrewingStand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */