/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ import java.util.Random;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockFalling
/*    */   extends Block
/*    */ {
/*    */   public static boolean instaFall;
/*    */   
/*    */   public BlockFalling() {
/* 14 */     super(Material.SAND);
/* 15 */     a(CreativeModeTab.b);
/*    */   }
/*    */   
/*    */   public BlockFalling(Material paramMaterial) {
/* 19 */     super(paramMaterial);
/*    */   }
/*    */ 
/*    */   
/*    */   public void onPlace(World paramWorld, int paramInt1, int paramInt2, int paramInt3) {
/* 24 */     paramWorld.a(paramInt1, paramInt2, paramInt3, this, a(paramWorld));
/*    */   }
/*    */ 
/*    */   
/*    */   public void doPhysics(World paramWorld, int paramInt1, int paramInt2, int paramInt3, Block paramBlock) {
/* 29 */     paramWorld.a(paramInt1, paramInt2, paramInt3, this, a(paramWorld));
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(World paramWorld, int paramInt1, int paramInt2, int paramInt3, Random paramRandom) {
/* 34 */     if (!paramWorld.isStatic) {
/* 35 */       m(paramWorld, paramInt1, paramInt2, paramInt3);
/*    */     }
/*    */   }
/*    */   
/*    */   private void m(World paramWorld, int paramInt1, int paramInt2, int paramInt3) {
/* 40 */     int i = paramInt1;
/* 41 */     int j = paramInt2;
/* 42 */     int k = paramInt3;
/* 43 */     if (canFall(paramWorld, i, j - 1, k) && j >= 0) {
/* 44 */       byte b = 32;
/* 45 */       if (instaFall || !paramWorld.b(paramInt1 - b, paramInt2 - b, paramInt3 - b, paramInt1 + b, paramInt2 + b, paramInt3 + b)) {
/* 46 */         paramWorld.setAir(paramInt1, paramInt2, paramInt3);
/* 47 */         while (canFall(paramWorld, paramInt1, paramInt2 - 1, paramInt3) && paramInt2 > 0)
/* 48 */           paramInt2--; 
/* 49 */         if (paramInt2 > 0) {
/* 50 */           paramWorld.setTypeUpdate(paramInt1, paramInt2, paramInt3, this);
/*    */         }
/* 52 */       } else if (!paramWorld.isStatic) {
/* 53 */         EntityFallingBlock entityFallingBlock = new EntityFallingBlock(paramWorld, (paramInt1 + 0.5F), (paramInt2 + 0.5F), (paramInt3 + 0.5F), this, paramWorld.getData(paramInt1, paramInt2, paramInt3));
/* 54 */         a(entityFallingBlock);
/* 55 */         paramWorld.addEntity(entityFallingBlock);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected void a(EntityFallingBlock paramEntityFallingBlock) {}
/*    */ 
/*    */   
/*    */   public int a(World paramWorld) {
/* 65 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean canFall(World paramWorld, int paramInt1, int paramInt2, int paramInt3) {
/* 70 */     Block block = paramWorld.getType(paramInt1, paramInt2, paramInt3);
/* 71 */     if (block.material == Material.AIR) return true; 
/* 72 */     if (block == Blocks.FIRE) return true; 
/* 73 */     Material material = block.material;
/* 74 */     if (material == Material.WATER) return true; 
/* 75 */     if (material == Material.LAVA) return true; 
/* 76 */     return false;
/*    */   }
/*    */   
/*    */   public void a(World paramWorld, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\BlockFalling.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */