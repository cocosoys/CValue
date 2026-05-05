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
/*     */ public abstract class BlockMinecartTrackAbstract
/*     */   extends Block
/*     */ {
/*     */   protected final boolean a;
/*     */   
/*     */   public static final boolean b_(World paramWorld, int paramInt1, int paramInt2, int paramInt3) {
/* 260 */     return a(paramWorld.getType(paramInt1, paramInt2, paramInt3));
/*     */   }
/*     */   
/*     */   public static final boolean a(Block paramBlock) {
/* 264 */     return (paramBlock == Blocks.RAILS || paramBlock == Blocks.GOLDEN_RAIL || paramBlock == Blocks.DETECTOR_RAIL || paramBlock == Blocks.ACTIVATOR_RAIL);
/*     */   }
/*     */   
/*     */   protected BlockMinecartTrackAbstract(boolean paramBoolean) {
/* 268 */     super(Material.ORIENTABLE);
/* 269 */     this.a = paramBoolean;
/* 270 */     a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
/* 271 */     a(CreativeModeTab.e);
/*     */   }
/*     */   
/*     */   public boolean e() {
/* 275 */     return this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisAlignedBB a(World paramWorld, int paramInt1, int paramInt2, int paramInt3) {
/* 280 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean c() {
/* 289 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public MovingObjectPosition a(World paramWorld, int paramInt1, int paramInt2, int paramInt3, Vec3D paramVec3D1, Vec3D paramVec3D2) {
/* 294 */     updateShape(paramWorld, paramInt1, paramInt2, paramInt3);
/* 295 */     return super.a(paramWorld, paramInt1, paramInt2, paramInt3, paramVec3D1, paramVec3D2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateShape(IBlockAccess paramIBlockAccess, int paramInt1, int paramInt2, int paramInt3) {
/* 300 */     int i = paramIBlockAccess.getData(paramInt1, paramInt2, paramInt3);
/* 301 */     if (i >= 2 && i <= 5) {
/* 302 */       a(0.0F, 0.0F, 0.0F, 1.0F, 0.625F, 1.0F);
/*     */     } else {
/* 304 */       a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean d() {
/* 310 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int b() {
/* 315 */     return 9;
/*     */   }
/*     */ 
/*     */   
/*     */   public int a(Random paramRandom) {
/* 320 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canPlace(World paramWorld, int paramInt1, int paramInt2, int paramInt3) {
/* 325 */     if (World.a(paramWorld, paramInt1, paramInt2 - 1, paramInt3)) {
/* 326 */       return true;
/*     */     }
/* 328 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onPlace(World paramWorld, int paramInt1, int paramInt2, int paramInt3) {
/* 333 */     if (!paramWorld.isStatic) {
/* 334 */       a(paramWorld, paramInt1, paramInt2, paramInt3, true);
/*     */       
/* 336 */       if (this.a) {
/* 337 */         doPhysics(paramWorld, paramInt1, paramInt2, paramInt3, this);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void doPhysics(World paramWorld, int paramInt1, int paramInt2, int paramInt3, Block paramBlock) {
/* 344 */     if (paramWorld.isStatic)
/*     */       return; 
/* 346 */     int i = paramWorld.getData(paramInt1, paramInt2, paramInt3);
/* 347 */     int j = i;
/* 348 */     if (this.a) {
/* 349 */       j &= 0x7;
/*     */     }
/* 351 */     boolean bool = false;
/*     */     
/* 353 */     if (!World.a(paramWorld, paramInt1, paramInt2 - 1, paramInt3)) bool = true; 
/* 354 */     if (j == 2 && !World.a(paramWorld, paramInt1 + 1, paramInt2, paramInt3)) bool = true; 
/* 355 */     if (j == 3 && !World.a(paramWorld, paramInt1 - 1, paramInt2, paramInt3)) bool = true; 
/* 356 */     if (j == 4 && !World.a(paramWorld, paramInt1, paramInt2, paramInt3 - 1)) bool = true; 
/* 357 */     if (j == 5 && !World.a(paramWorld, paramInt1, paramInt2, paramInt3 + 1)) bool = true;
/*     */     
/* 359 */     if (bool) {
/* 360 */       b(paramWorld, paramInt1, paramInt2, paramInt3, paramWorld.getData(paramInt1, paramInt2, paramInt3), 0);
/* 361 */       paramWorld.setAir(paramInt1, paramInt2, paramInt3);
/*     */     } else {
/* 363 */       a(paramWorld, paramInt1, paramInt2, paramInt3, i, j, paramBlock);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void a(World paramWorld, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Block paramBlock) {}
/*     */   
/*     */   protected void a(World paramWorld, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
/* 371 */     if (paramWorld.isStatic)
/* 372 */       return;  (new MinecartTrackLogic(this, paramWorld, paramInt1, paramInt2, paramInt3)).a(paramWorld.isBlockIndirectlyPowered(paramInt1, paramInt2, paramInt3), paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int h() {
/* 378 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(World paramWorld, int paramInt1, int paramInt2, int paramInt3, Block paramBlock, int paramInt4) {
/* 383 */     int i = paramInt4;
/* 384 */     if (this.a) {
/* 385 */       i &= 0x7;
/*     */     }
/*     */     
/* 388 */     super.remove(paramWorld, paramInt1, paramInt2, paramInt3, paramBlock, paramInt4);
/*     */     
/* 390 */     if (i == 2 || i == 3 || i == 4 || i == 5) {
/* 391 */       paramWorld.applyPhysics(paramInt1, paramInt2 + 1, paramInt3, paramBlock);
/*     */     }
/* 393 */     if (this.a) {
/* 394 */       paramWorld.applyPhysics(paramInt1, paramInt2, paramInt3, paramBlock);
/* 395 */       paramWorld.applyPhysics(paramInt1, paramInt2 - 1, paramInt3, paramBlock);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\BlockMinecartTrackAbstract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */