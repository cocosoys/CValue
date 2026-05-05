/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockAnvil
/*     */   extends BlockFalling
/*     */ {
/*  22 */   public static final String[] a = new String[] { "intact", "slightlyDamaged", "veryDamaged" };
/*     */ 
/*     */ 
/*     */   
/*  26 */   private static final String[] N = new String[] { "anvil_top_damaged_0", "anvil_top_damaged_1", "anvil_top_damaged_2" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected BlockAnvil() {
/*  34 */     super(Material.HEAVY);
/*  35 */     g(0);
/*  36 */     a(CreativeModeTab.c);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean d() {
/*  41 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean c() {
/*  46 */     return false;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void postPlace(World paramWorld, int paramInt1, int paramInt2, int paramInt3, EntityLiving paramEntityLiving, ItemStack paramItemStack) {
/*  70 */     int i = MathHelper.floor((paramEntityLiving.yaw * 4.0F / 360.0F) + 0.5D) & 0x3;
/*  71 */     int j = paramWorld.getData(paramInt1, paramInt2, paramInt3) >> 2;
/*     */     
/*  73 */     i = ++i % 4;
/*  74 */     if (i == 0) paramWorld.setData(paramInt1, paramInt2, paramInt3, 0x2 | j << 2, 2); 
/*  75 */     if (i == 1) paramWorld.setData(paramInt1, paramInt2, paramInt3, 0x3 | j << 2, 2); 
/*  76 */     if (i == 2) paramWorld.setData(paramInt1, paramInt2, paramInt3, 0x0 | j << 2, 2); 
/*  77 */     if (i == 3) paramWorld.setData(paramInt1, paramInt2, paramInt3, 0x1 | j << 2, 2);
/*     */   
/*     */   }
/*     */   
/*     */   public boolean interact(World paramWorld, int paramInt1, int paramInt2, int paramInt3, EntityHuman paramEntityHuman, int paramInt4, float paramFloat1, float paramFloat2, float paramFloat3) {
/*  82 */     if (paramWorld.isStatic) {
/*  83 */       return true;
/*     */     }
/*  85 */     paramEntityHuman.openAnvil(paramInt1, paramInt2, paramInt3);
/*  86 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int b() {
/*  91 */     return 35;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDropData(int paramInt) {
/*  96 */     return paramInt >> 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateShape(IBlockAccess paramIBlockAccess, int paramInt1, int paramInt2, int paramInt3) {
/* 101 */     int i = paramIBlockAccess.getData(paramInt1, paramInt2, paramInt3) & 0x3;
/*     */     
/* 103 */     if (i == 3 || i == 1) {
/* 104 */       a(0.0F, 0.0F, 0.125F, 1.0F, 1.0F, 0.875F);
/*     */     } else {
/* 106 */       a(0.125F, 0.0F, 0.0F, 0.875F, 1.0F, 1.0F);
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
/*     */   protected void a(EntityFallingBlock paramEntityFallingBlock) {
/* 119 */     paramEntityFallingBlock.a(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(World paramWorld, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 124 */     paramWorld.triggerEffect(1022, paramInt1, paramInt2, paramInt3, 0);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\BlockAnvil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */