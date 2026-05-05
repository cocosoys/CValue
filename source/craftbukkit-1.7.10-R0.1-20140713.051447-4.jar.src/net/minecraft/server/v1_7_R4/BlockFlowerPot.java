/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockFlowerPot
/*     */   extends BlockContainer
/*     */ {
/*     */   public BlockFlowerPot() {
/*  27 */     super(Material.ORIENTABLE);
/*  28 */     g();
/*     */   }
/*     */ 
/*     */   
/*     */   public void g() {
/*  33 */     float f1 = 0.375F;
/*  34 */     float f2 = f1 / 2.0F;
/*  35 */     a(0.5F - f2, 0.0F, 0.5F - f2, 0.5F + f2, f1, 0.5F + f2);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean c() {
/*  40 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int b() {
/*  45 */     return 33;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean d() {
/*  50 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean interact(World paramWorld, int paramInt1, int paramInt2, int paramInt3, EntityHuman paramEntityHuman, int paramInt4, float paramFloat1, float paramFloat2, float paramFloat3) {
/*  55 */     ItemStack itemStack = paramEntityHuman.inventory.getItemInHand();
/*  56 */     if (itemStack == null || !(itemStack.getItem() instanceof ItemBlock)) return false;
/*     */     
/*  58 */     TileEntityFlowerPot tileEntityFlowerPot = e(paramWorld, paramInt1, paramInt2, paramInt3);
/*  59 */     if (tileEntityFlowerPot != null) {
/*  60 */       if (tileEntityFlowerPot.a() != null) {
/*  61 */         return false;
/*     */       }
/*  63 */       Block block = Block.a(itemStack.getItem());
/*  64 */       if (!a(block, itemStack.getData())) {
/*  65 */         return false;
/*     */       }
/*  67 */       tileEntityFlowerPot.a(itemStack.getItem(), itemStack.getData());
/*  68 */       tileEntityFlowerPot.update();
/*     */       
/*  70 */       if (!paramWorld.setData(paramInt1, paramInt2, paramInt3, itemStack.getData(), 2))
/*     */       {
/*  72 */         paramWorld.notify(paramInt1, paramInt2, paramInt3);
/*     */       }
/*     */       
/*  75 */       if (!paramEntityHuman.abilities.canInstantlyBuild && 
/*  76 */         --itemStack.count <= 0) {
/*  77 */         paramEntityHuman.inventory.setItem(paramEntityHuman.inventory.itemInHandIndex, null);
/*     */       }
/*     */ 
/*     */       
/*  81 */       return true;
/*     */     } 
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   private boolean a(Block paramBlock, int paramInt) {
/*  87 */     if (paramBlock == Blocks.YELLOW_FLOWER || paramBlock == Blocks.RED_ROSE || paramBlock == Blocks.CACTUS || paramBlock == Blocks.BROWN_MUSHROOM || paramBlock == Blocks.RED_MUSHROOM || paramBlock == Blocks.SAPLING || paramBlock == Blocks.DEAD_BUSH) {
/*  88 */       return true;
/*     */     }
/*  90 */     if (paramBlock == Blocks.LONG_GRASS && paramInt == 2) {
/*  91 */       return true;
/*     */     }
/*  93 */     return false;
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
/*     */   public int getDropData(World paramWorld, int paramInt1, int paramInt2, int paramInt3) {
/* 107 */     TileEntityFlowerPot tileEntityFlowerPot = e(paramWorld, paramInt1, paramInt2, paramInt3);
/* 108 */     if (tileEntityFlowerPot != null && tileEntityFlowerPot.a() != null) {
/* 109 */       return tileEntityFlowerPot.b();
/*     */     }
/* 111 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canPlace(World paramWorld, int paramInt1, int paramInt2, int paramInt3) {
/* 121 */     return (super.canPlace(paramWorld, paramInt1, paramInt2, paramInt3) && World.a(paramWorld, paramInt1, paramInt2 - 1, paramInt3));
/*     */   }
/*     */ 
/*     */   
/*     */   public void doPhysics(World paramWorld, int paramInt1, int paramInt2, int paramInt3, Block paramBlock) {
/* 126 */     if (!World.a(paramWorld, paramInt1, paramInt2 - 1, paramInt3)) {
/* 127 */       b(paramWorld, paramInt1, paramInt2, paramInt3, paramWorld.getData(paramInt1, paramInt2, paramInt3), 0);
/*     */       
/* 129 */       paramWorld.setAir(paramInt1, paramInt2, paramInt3);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(World paramWorld, int paramInt1, int paramInt2, int paramInt3, Block paramBlock, int paramInt4) {
/* 137 */     TileEntityFlowerPot tileEntityFlowerPot = e(paramWorld, paramInt1, paramInt2, paramInt3);
/* 138 */     if (tileEntityFlowerPot != null && tileEntityFlowerPot.a() != null) {
/* 139 */       a(paramWorld, paramInt1, paramInt2, paramInt3, new ItemStack(tileEntityFlowerPot.a(), 1, tileEntityFlowerPot.b()));
/*     */     }
/* 141 */     super.remove(paramWorld, paramInt1, paramInt2, paramInt3, paramBlock, paramInt4);
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(World paramWorld, int paramInt1, int paramInt2, int paramInt3, int paramInt4, EntityHuman paramEntityHuman) {
/* 146 */     super.a(paramWorld, paramInt1, paramInt2, paramInt3, paramInt4, paramEntityHuman);
/*     */     
/* 148 */     if (paramEntityHuman.abilities.canInstantlyBuild) {
/* 149 */       TileEntityFlowerPot tileEntityFlowerPot = e(paramWorld, paramInt1, paramInt2, paramInt3);
/* 150 */       if (tileEntityFlowerPot != null)
/*     */       {
/* 152 */         tileEntityFlowerPot.a(Item.getById(0), 0);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Item getDropType(int paramInt1, Random paramRandom, int paramInt2) {
/* 159 */     return Items.FLOWER_POT;
/*     */   }
/*     */   
/*     */   private TileEntityFlowerPot e(World paramWorld, int paramInt1, int paramInt2, int paramInt3) {
/* 163 */     TileEntity tileEntity = paramWorld.getTileEntity(paramInt1, paramInt2, paramInt3);
/* 164 */     if (tileEntity != null && tileEntity instanceof TileEntityFlowerPot) {
/* 165 */       return (TileEntityFlowerPot)tileEntity;
/*     */     }
/* 167 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity a(World paramWorld, int paramInt) {
/* 173 */     Block block = null;
/* 174 */     byte b = 0;
/* 175 */     switch (paramInt) {
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
/*     */       
/*     */       default:
/* 226 */         return new TileEntityFlowerPot(Item.getItemOf(block), b);
/*     */       case 1:
/*     */         block = Blocks.RED_ROSE;
/*     */         b = 0;
/*     */       case 2:
/*     */         block = Blocks.YELLOW_FLOWER;
/*     */       case 3:
/*     */         block = Blocks.SAPLING;
/*     */         b = 0;
/*     */       case 4:
/*     */         block = Blocks.SAPLING;
/*     */         b = 1;
/*     */       case 5:
/*     */         block = Blocks.SAPLING;
/*     */         b = 2;
/*     */       case 6:
/*     */         block = Blocks.SAPLING;
/*     */         b = 3;
/*     */       case 12:
/*     */         block = Blocks.SAPLING;
/*     */         b = 4;
/*     */       case 13:
/*     */         block = Blocks.SAPLING;
/*     */         b = 5;
/*     */       case 7:
/*     */         block = Blocks.RED_MUSHROOM;
/*     */       case 8:
/*     */         block = Blocks.BROWN_MUSHROOM;
/*     */       case 9:
/*     */         block = Blocks.CACTUS;
/*     */       case 10:
/*     */         block = Blocks.DEAD_BUSH;
/*     */       case 11:
/*     */         break;
/*     */     } 
/*     */     block = Blocks.LONG_GRASS;
/*     */     b = 2;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\BlockFlowerPot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */