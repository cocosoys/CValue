/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.Random;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockTorch
/*     */   extends Block
/*     */ {
/*     */   protected BlockTorch() {
/*  12 */     super(Material.ORIENTABLE);
/*  13 */     a(true);
/*  14 */     a(CreativeModeTab.c);
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisAlignedBB a(World paramWorld, int paramInt1, int paramInt2, int paramInt3) {
/*  19 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean c() {
/*  24 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean d() {
/*  29 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int b() {
/*  34 */     return 2;
/*     */   }
/*     */   
/*     */   private boolean m(World paramWorld, int paramInt1, int paramInt2, int paramInt3) {
/*  38 */     if (World.a(paramWorld, paramInt1, paramInt2, paramInt3)) {
/*  39 */       return true;
/*     */     }
/*  41 */     Block block = paramWorld.getType(paramInt1, paramInt2, paramInt3);
/*  42 */     if (block == Blocks.FENCE || block == Blocks.NETHER_FENCE || block == Blocks.GLASS || block == Blocks.COBBLE_WALL) {
/*  43 */       return true;
/*     */     }
/*  45 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canPlace(World paramWorld, int paramInt1, int paramInt2, int paramInt3) {
/*  50 */     if (paramWorld.c(paramInt1 - 1, paramInt2, paramInt3, true))
/*  51 */       return true; 
/*  52 */     if (paramWorld.c(paramInt1 + 1, paramInt2, paramInt3, true))
/*  53 */       return true; 
/*  54 */     if (paramWorld.c(paramInt1, paramInt2, paramInt3 - 1, true))
/*  55 */       return true; 
/*  56 */     if (paramWorld.c(paramInt1, paramInt2, paramInt3 + 1, true))
/*  57 */       return true; 
/*  58 */     if (m(paramWorld, paramInt1, paramInt2 - 1, paramInt3)) {
/*  59 */       return true;
/*     */     }
/*     */     
/*  62 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPlacedData(World paramWorld, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt5) {
/*  67 */     int i = paramInt5;
/*     */     
/*  69 */     if (paramInt4 == 1 && m(paramWorld, paramInt1, paramInt2 - 1, paramInt3)) i = 5; 
/*  70 */     if (paramInt4 == 2 && paramWorld.c(paramInt1, paramInt2, paramInt3 + 1, true)) i = 4; 
/*  71 */     if (paramInt4 == 3 && paramWorld.c(paramInt1, paramInt2, paramInt3 - 1, true)) i = 3; 
/*  72 */     if (paramInt4 == 4 && paramWorld.c(paramInt1 + 1, paramInt2, paramInt3, true)) i = 2; 
/*  73 */     if (paramInt4 == 5 && paramWorld.c(paramInt1 - 1, paramInt2, paramInt3, true)) i = 1;
/*     */     
/*  75 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(World paramWorld, int paramInt1, int paramInt2, int paramInt3, Random paramRandom) {
/*  80 */     super.a(paramWorld, paramInt1, paramInt2, paramInt3, paramRandom);
/*  81 */     if (paramWorld.getData(paramInt1, paramInt2, paramInt3) == 0) onPlace(paramWorld, paramInt1, paramInt2, paramInt3);
/*     */   
/*     */   }
/*     */   
/*     */   public void onPlace(World paramWorld, int paramInt1, int paramInt2, int paramInt3) {
/*  86 */     if (paramWorld.getData(paramInt1, paramInt2, paramInt3) == 0) {
/*  87 */       if (paramWorld.c(paramInt1 - 1, paramInt2, paramInt3, true)) {
/*  88 */         paramWorld.setData(paramInt1, paramInt2, paramInt3, 1, 2);
/*  89 */       } else if (paramWorld.c(paramInt1 + 1, paramInt2, paramInt3, true)) {
/*  90 */         paramWorld.setData(paramInt1, paramInt2, paramInt3, 2, 2);
/*  91 */       } else if (paramWorld.c(paramInt1, paramInt2, paramInt3 - 1, true)) {
/*  92 */         paramWorld.setData(paramInt1, paramInt2, paramInt3, 3, 2);
/*  93 */       } else if (paramWorld.c(paramInt1, paramInt2, paramInt3 + 1, true)) {
/*  94 */         paramWorld.setData(paramInt1, paramInt2, paramInt3, 4, 2);
/*  95 */       } else if (m(paramWorld, paramInt1, paramInt2 - 1, paramInt3)) {
/*  96 */         paramWorld.setData(paramInt1, paramInt2, paramInt3, 5, 2);
/*     */       } 
/*     */     }
/*  99 */     e(paramWorld, paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void doPhysics(World paramWorld, int paramInt1, int paramInt2, int paramInt3, Block paramBlock) {
/* 104 */     b(paramWorld, paramInt1, paramInt2, paramInt3, paramBlock);
/*     */   }
/*     */   
/*     */   protected boolean b(World paramWorld, int paramInt1, int paramInt2, int paramInt3, Block paramBlock) {
/* 108 */     if (e(paramWorld, paramInt1, paramInt2, paramInt3)) {
/* 109 */       int i = paramWorld.getData(paramInt1, paramInt2, paramInt3);
/* 110 */       boolean bool = false;
/*     */       
/* 112 */       if (!paramWorld.c(paramInt1 - 1, paramInt2, paramInt3, true) && i == 1) bool = true; 
/* 113 */       if (!paramWorld.c(paramInt1 + 1, paramInt2, paramInt3, true) && i == 2) bool = true; 
/* 114 */       if (!paramWorld.c(paramInt1, paramInt2, paramInt3 - 1, true) && i == 3) bool = true; 
/* 115 */       if (!paramWorld.c(paramInt1, paramInt2, paramInt3 + 1, true) && i == 4) bool = true; 
/* 116 */       if (!m(paramWorld, paramInt1, paramInt2 - 1, paramInt3) && i == 5) bool = true;
/*     */       
/* 118 */       if (bool) {
/* 119 */         b(paramWorld, paramInt1, paramInt2, paramInt3, paramWorld.getData(paramInt1, paramInt2, paramInt3), 0);
/* 120 */         paramWorld.setAir(paramInt1, paramInt2, paramInt3);
/* 121 */         return true;
/*     */       } 
/*     */     } else {
/* 124 */       return true;
/*     */     } 
/* 126 */     return false;
/*     */   }
/*     */   
/*     */   protected boolean e(World paramWorld, int paramInt1, int paramInt2, int paramInt3) {
/* 130 */     if (!canPlace(paramWorld, paramInt1, paramInt2, paramInt3)) {
/* 131 */       if (paramWorld.getType(paramInt1, paramInt2, paramInt3) == this) {
/* 132 */         b(paramWorld, paramInt1, paramInt2, paramInt3, paramWorld.getData(paramInt1, paramInt2, paramInt3), 0);
/* 133 */         paramWorld.setAir(paramInt1, paramInt2, paramInt3);
/*     */       } 
/* 135 */       return false;
/*     */     } 
/* 137 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public MovingObjectPosition a(World paramWorld, int paramInt1, int paramInt2, int paramInt3, Vec3D paramVec3D1, Vec3D paramVec3D2) {
/* 142 */     int i = paramWorld.getData(paramInt1, paramInt2, paramInt3) & 0x7;
/*     */     
/* 144 */     float f = 0.15F;
/* 145 */     if (i == 1) {
/* 146 */       a(0.0F, 0.2F, 0.5F - f, f * 2.0F, 0.8F, 0.5F + f);
/* 147 */     } else if (i == 2) {
/* 148 */       a(1.0F - f * 2.0F, 0.2F, 0.5F - f, 1.0F, 0.8F, 0.5F + f);
/* 149 */     } else if (i == 3) {
/* 150 */       a(0.5F - f, 0.2F, 0.0F, 0.5F + f, 0.8F, f * 2.0F);
/* 151 */     } else if (i == 4) {
/* 152 */       a(0.5F - f, 0.2F, 1.0F - f * 2.0F, 0.5F + f, 0.8F, 1.0F);
/*     */     } else {
/* 154 */       f = 0.1F;
/* 155 */       a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.6F, 0.5F + f);
/*     */     } 
/*     */     
/* 158 */     return super.a(paramWorld, paramInt1, paramInt2, paramInt3, paramVec3D1, paramVec3D2);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\BlockTorch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */