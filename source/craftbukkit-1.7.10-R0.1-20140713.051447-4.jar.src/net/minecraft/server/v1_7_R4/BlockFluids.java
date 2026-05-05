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
/*     */ public abstract class BlockFluids
/*     */   extends Block
/*     */ {
/*     */   protected BlockFluids(Material paramMaterial) {
/*  23 */     super(paramMaterial);
/*  24 */     float f1 = 0.0F;
/*  25 */     float f2 = 0.0F;
/*     */     
/*  27 */     a(0.0F + f2, 0.0F + f1, 0.0F + f2, 1.0F + f2, 1.0F + f1, 1.0F + f2);
/*  28 */     a(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean b(IBlockAccess paramIBlockAccess, int paramInt1, int paramInt2, int paramInt3) {
/*  33 */     return (this.material != Material.LAVA);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float b(int paramInt) {
/*  64 */     if (paramInt >= 8) paramInt = 0; 
/*  65 */     return (paramInt + 1) / 9.0F;
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
/*     */   protected int e(World paramWorld, int paramInt1, int paramInt2, int paramInt3) {
/*  78 */     if (paramWorld.getType(paramInt1, paramInt2, paramInt3).getMaterial() == this.material) return paramWorld.getData(paramInt1, paramInt2, paramInt3); 
/*  79 */     return -1;
/*     */   }
/*     */   
/*     */   protected int e(IBlockAccess paramIBlockAccess, int paramInt1, int paramInt2, int paramInt3) {
/*  83 */     if (paramIBlockAccess.getType(paramInt1, paramInt2, paramInt3).getMaterial() != this.material) return -1; 
/*  84 */     int i = paramIBlockAccess.getData(paramInt1, paramInt2, paramInt3);
/*  85 */     if (i >= 8) i = 0; 
/*  86 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean d() {
/*  91 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean c() {
/*  96 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean a(int paramInt, boolean paramBoolean) {
/* 101 */     return (paramBoolean && paramInt == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean d(IBlockAccess paramIBlockAccess, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 106 */     Material material = paramIBlockAccess.getType(paramInt1, paramInt2, paramInt3).getMaterial();
/* 107 */     if (material == this.material) return false; 
/* 108 */     if (paramInt4 == 1) return true; 
/* 109 */     if (material == Material.ICE) return false; 
/* 110 */     return super.d(paramIBlockAccess, paramInt1, paramInt2, paramInt3, paramInt4);
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
/*     */   public AxisAlignedBB a(World paramWorld, int paramInt1, int paramInt2, int paramInt3) {
/* 125 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int b() {
/* 130 */     return 4;
/*     */   }
/*     */ 
/*     */   
/*     */   public Item getDropType(int paramInt1, Random paramRandom, int paramInt2) {
/* 135 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int a(Random paramRandom) {
/* 140 */     return 0;
/*     */   }
/*     */   
/*     */   private Vec3D f(IBlockAccess paramIBlockAccess, int paramInt1, int paramInt2, int paramInt3) {
/* 144 */     Vec3D vec3D = Vec3D.a(0.0D, 0.0D, 0.0D);
/* 145 */     int i = e(paramIBlockAccess, paramInt1, paramInt2, paramInt3); byte b;
/* 146 */     for (b = 0; b < 4; b++) {
/*     */       
/* 148 */       int j = paramInt1;
/* 149 */       int k = paramInt2;
/* 150 */       int m = paramInt3;
/*     */       
/* 152 */       if (b == 0) j--; 
/* 153 */       if (b == 1) m--; 
/* 154 */       if (b == 2) j++; 
/* 155 */       if (b == 3) m++;
/*     */       
/* 157 */       int n = e(paramIBlockAccess, j, k, m);
/* 158 */       if (n < 0) {
/* 159 */         if (!paramIBlockAccess.getType(j, k, m).getMaterial().isSolid()) {
/* 160 */           n = e(paramIBlockAccess, j, k - 1, m);
/* 161 */           if (n >= 0) {
/* 162 */             int i1 = n - i - 8;
/* 163 */             vec3D = vec3D.add(((j - paramInt1) * i1), ((k - paramInt2) * i1), ((m - paramInt3) * i1));
/*     */           }
/*     */         
/*     */         } 
/* 167 */       } else if (n >= 0) {
/* 168 */         int i1 = n - i;
/* 169 */         vec3D = vec3D.add(((j - paramInt1) * i1), ((k - paramInt2) * i1), ((m - paramInt3) * i1));
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 174 */     if (paramIBlockAccess.getData(paramInt1, paramInt2, paramInt3) >= 8) {
/* 175 */       b = 0;
/* 176 */       if (b != 0 || d(paramIBlockAccess, paramInt1, paramInt2, paramInt3 - 1, 2)) b = 1; 
/* 177 */       if (b != 0 || d(paramIBlockAccess, paramInt1, paramInt2, paramInt3 + 1, 3)) b = 1; 
/* 178 */       if (b != 0 || d(paramIBlockAccess, paramInt1 - 1, paramInt2, paramInt3, 4)) b = 1; 
/* 179 */       if (b != 0 || d(paramIBlockAccess, paramInt1 + 1, paramInt2, paramInt3, 5)) b = 1; 
/* 180 */       if (b != 0 || d(paramIBlockAccess, paramInt1, paramInt2 + 1, paramInt3 - 1, 2)) b = 1; 
/* 181 */       if (b != 0 || d(paramIBlockAccess, paramInt1, paramInt2 + 1, paramInt3 + 1, 3)) b = 1; 
/* 182 */       if (b != 0 || d(paramIBlockAccess, paramInt1 - 1, paramInt2 + 1, paramInt3, 4)) b = 1; 
/* 183 */       if (b != 0 || d(paramIBlockAccess, paramInt1 + 1, paramInt2 + 1, paramInt3, 5)) b = 1; 
/* 184 */       if (b != 0) vec3D = vec3D.a().add(0.0D, -6.0D, 0.0D); 
/*     */     } 
/* 186 */     vec3D = vec3D.a();
/* 187 */     return vec3D;
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(World paramWorld, int paramInt1, int paramInt2, int paramInt3, Entity paramEntity, Vec3D paramVec3D) {
/* 192 */     Vec3D vec3D = f(paramWorld, paramInt1, paramInt2, paramInt3);
/* 193 */     paramVec3D.a += vec3D.a;
/* 194 */     paramVec3D.b += vec3D.b;
/* 195 */     paramVec3D.c += vec3D.c;
/*     */   }
/*     */ 
/*     */   
/*     */   public int a(World paramWorld) {
/* 200 */     if (this.material == Material.WATER) return 5; 
/* 201 */     if (this.material == Material.LAVA) {
/* 202 */       if (paramWorld.worldProvider.g) {
/* 203 */         return 10;
/*     */       }
/* 205 */       return 30;
/*     */     } 
/*     */     
/* 208 */     return 0;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 312 */     n(paramWorld, paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void doPhysics(World paramWorld, int paramInt1, int paramInt2, int paramInt3, Block paramBlock) {
/* 317 */     n(paramWorld, paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */   
/*     */   private void n(World paramWorld, int paramInt1, int paramInt2, int paramInt3) {
/* 321 */     if (paramWorld.getType(paramInt1, paramInt2, paramInt3) != this)
/* 322 */       return;  if (this.material == Material.LAVA) {
/* 323 */       boolean bool = false;
/* 324 */       if (bool || paramWorld.getType(paramInt1, paramInt2, paramInt3 - 1).getMaterial() == Material.WATER) bool = true; 
/* 325 */       if (bool || paramWorld.getType(paramInt1, paramInt2, paramInt3 + 1).getMaterial() == Material.WATER) bool = true; 
/* 326 */       if (bool || paramWorld.getType(paramInt1 - 1, paramInt2, paramInt3).getMaterial() == Material.WATER) bool = true; 
/* 327 */       if (bool || paramWorld.getType(paramInt1 + 1, paramInt2, paramInt3).getMaterial() == Material.WATER) bool = true; 
/* 328 */       if (bool || paramWorld.getType(paramInt1, paramInt2 + 1, paramInt3).getMaterial() == Material.WATER) bool = true; 
/* 329 */       if (bool) {
/* 330 */         int i = paramWorld.getData(paramInt1, paramInt2, paramInt3);
/* 331 */         if (i == 0) {
/* 332 */           paramWorld.setTypeUpdate(paramInt1, paramInt2, paramInt3, Blocks.OBSIDIAN);
/* 333 */         } else if (i <= 4) {
/* 334 */           paramWorld.setTypeUpdate(paramInt1, paramInt2, paramInt3, Blocks.COBBLESTONE);
/*     */         } 
/* 336 */         fizz(paramWorld, paramInt1, paramInt2, paramInt3);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void fizz(World paramWorld, int paramInt1, int paramInt2, int paramInt3) {
/* 342 */     paramWorld.makeSound((paramInt1 + 0.5F), (paramInt2 + 0.5F), (paramInt3 + 0.5F), "random.fizz", 0.5F, 2.6F + (paramWorld.random.nextFloat() - paramWorld.random.nextFloat()) * 0.8F);
/* 343 */     for (byte b = 0; b < 8; b++)
/* 344 */       paramWorld.addParticle("largesmoke", paramInt1 + Math.random(), paramInt2 + 1.2D, paramInt3 + Math.random(), 0.0D, 0.0D, 0.0D); 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\BlockFluids.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */