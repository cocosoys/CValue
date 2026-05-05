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
/*     */ public class BlockTNT
/*     */   extends Block
/*     */ {
/*     */   public BlockTNT() {
/*  24 */     super(Material.TNT);
/*  25 */     a(CreativeModeTab.d);
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
/*     */   public void onPlace(World paramWorld, int paramInt1, int paramInt2, int paramInt3) {
/*  37 */     super.onPlace(paramWorld, paramInt1, paramInt2, paramInt3);
/*  38 */     if (paramWorld.isBlockIndirectlyPowered(paramInt1, paramInt2, paramInt3)) {
/*  39 */       postBreak(paramWorld, paramInt1, paramInt2, paramInt3, 1);
/*  40 */       paramWorld.setAir(paramInt1, paramInt2, paramInt3);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void doPhysics(World paramWorld, int paramInt1, int paramInt2, int paramInt3, Block paramBlock) {
/*  47 */     if (paramWorld.isBlockIndirectlyPowered(paramInt1, paramInt2, paramInt3)) {
/*  48 */       postBreak(paramWorld, paramInt1, paramInt2, paramInt3, 1);
/*  49 */       paramWorld.setAir(paramInt1, paramInt2, paramInt3);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int a(Random paramRandom) {
/*  56 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void wasExploded(World paramWorld, int paramInt1, int paramInt2, int paramInt3, Explosion paramExplosion) {
/*  61 */     if (paramWorld.isStatic)
/*     */       return; 
/*  63 */     EntityTNTPrimed entityTNTPrimed = new EntityTNTPrimed(paramWorld, (paramInt1 + 0.5F), (paramInt2 + 0.5F), (paramInt3 + 0.5F), paramExplosion.c());
/*  64 */     entityTNTPrimed.fuseTicks = paramWorld.random.nextInt(entityTNTPrimed.fuseTicks / 4) + entityTNTPrimed.fuseTicks / 8;
/*  65 */     paramWorld.addEntity(entityTNTPrimed);
/*     */   }
/*     */ 
/*     */   
/*     */   public void postBreak(World paramWorld, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  70 */     a(paramWorld, paramInt1, paramInt2, paramInt3, paramInt4, null);
/*     */   }
/*     */   
/*     */   public void a(World paramWorld, int paramInt1, int paramInt2, int paramInt3, int paramInt4, EntityLiving paramEntityLiving) {
/*  74 */     if (paramWorld.isStatic)
/*     */       return; 
/*  76 */     if ((paramInt4 & 0x1) == 1) {
/*  77 */       EntityTNTPrimed entityTNTPrimed = new EntityTNTPrimed(paramWorld, (paramInt1 + 0.5F), (paramInt2 + 0.5F), (paramInt3 + 0.5F), paramEntityLiving);
/*  78 */       paramWorld.addEntity(entityTNTPrimed);
/*  79 */       paramWorld.makeSound(entityTNTPrimed, "game.tnt.primed", 1.0F, 1.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean interact(World paramWorld, int paramInt1, int paramInt2, int paramInt3, EntityHuman paramEntityHuman, int paramInt4, float paramFloat1, float paramFloat2, float paramFloat3) {
/*  85 */     if (paramEntityHuman.bF() != null && paramEntityHuman.bF().getItem() == Items.FLINT_AND_STEEL) {
/*  86 */       a(paramWorld, paramInt1, paramInt2, paramInt3, 1, paramEntityHuman);
/*  87 */       paramWorld.setAir(paramInt1, paramInt2, paramInt3);
/*  88 */       paramEntityHuman.bF().damage(1, paramEntityHuman);
/*  89 */       return true;
/*     */     } 
/*  91 */     return super.interact(paramWorld, paramInt1, paramInt2, paramInt3, paramEntityHuman, paramInt4, paramFloat1, paramFloat2, paramFloat3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(World paramWorld, int paramInt1, int paramInt2, int paramInt3, Entity paramEntity) {
/*  96 */     if (paramEntity instanceof EntityArrow && !paramWorld.isStatic) {
/*  97 */       EntityArrow entityArrow = (EntityArrow)paramEntity;
/*  98 */       if (entityArrow.isBurning()) {
/*  99 */         a(paramWorld, paramInt1, paramInt2, paramInt3, 1, (entityArrow.shooter instanceof EntityLiving) ? (EntityLiving)entityArrow.shooter : null);
/* 100 */         paramWorld.setAir(paramInt1, paramInt2, paramInt3);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean a(Explosion paramExplosion) {
/* 107 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\BlockTNT.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */