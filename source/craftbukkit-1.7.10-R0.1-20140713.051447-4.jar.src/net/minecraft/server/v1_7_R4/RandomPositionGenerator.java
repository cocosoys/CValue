/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ import java.util.Random;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RandomPositionGenerator
/*    */ {
/* 10 */   private static Vec3D a = Vec3D.a(0.0D, 0.0D, 0.0D);
/*    */   
/*    */   public static Vec3D a(EntityCreature paramEntityCreature, int paramInt1, int paramInt2) {
/* 13 */     return c(paramEntityCreature, paramInt1, paramInt2, null);
/*    */   }
/*    */   
/*    */   public static Vec3D a(EntityCreature paramEntityCreature, int paramInt1, int paramInt2, Vec3D paramVec3D) {
/* 17 */     paramVec3D.a -= paramEntityCreature.locX;
/* 18 */     paramVec3D.b -= paramEntityCreature.locY;
/* 19 */     paramVec3D.c -= paramEntityCreature.locZ;
/* 20 */     return c(paramEntityCreature, paramInt1, paramInt2, a);
/*    */   }
/*    */   
/*    */   public static Vec3D b(EntityCreature paramEntityCreature, int paramInt1, int paramInt2, Vec3D paramVec3D) {
/* 24 */     a.a = paramEntityCreature.locX - paramVec3D.a;
/* 25 */     a.b = paramEntityCreature.locY - paramVec3D.b;
/* 26 */     a.c = paramEntityCreature.locZ - paramVec3D.c;
/* 27 */     return c(paramEntityCreature, paramInt1, paramInt2, a);
/*    */   }
/*    */   private static Vec3D c(EntityCreature paramEntityCreature, int paramInt1, int paramInt2, Vec3D paramVec3D) {
/*    */     boolean bool2;
/* 31 */     Random random = paramEntityCreature.aI();
/* 32 */     boolean bool1 = false;
/* 33 */     int i = 0, j = 0, k = 0;
/* 34 */     float f = -99999.0F;
/*    */ 
/*    */     
/* 37 */     if (paramEntityCreature.bY())
/* 38 */     { double d1 = (paramEntityCreature.bV().e(MathHelper.floor(paramEntityCreature.locX), MathHelper.floor(paramEntityCreature.locY), MathHelper.floor(paramEntityCreature.locZ)) + 4.0F);
/* 39 */       double d2 = (paramEntityCreature.bW() + paramInt1);
/* 40 */       bool2 = (d1 < d2 * d2) ? true : false; }
/* 41 */     else { bool2 = false; }
/*    */     
/* 43 */     for (byte b = 0; b < 10; b++) {
/* 44 */       int m = random.nextInt(2 * paramInt1) - paramInt1;
/* 45 */       int n = random.nextInt(2 * paramInt2) - paramInt2;
/* 46 */       int i1 = random.nextInt(2 * paramInt1) - paramInt1;
/*    */       
/* 48 */       if (paramVec3D == null || m * paramVec3D.a + i1 * paramVec3D.c >= 0.0D) {
/*    */         
/* 50 */         m += MathHelper.floor(paramEntityCreature.locX);
/* 51 */         n += MathHelper.floor(paramEntityCreature.locY);
/* 52 */         i1 += MathHelper.floor(paramEntityCreature.locZ);
/*    */         
/* 54 */         if (!bool2 || paramEntityCreature.b(m, n, i1)) {
/* 55 */           float f1 = paramEntityCreature.a(m, n, i1);
/* 56 */           if (f1 > f)
/* 57 */           { f = f1;
/* 58 */             i = m;
/* 59 */             j = n;
/* 60 */             k = i1;
/* 61 */             bool1 = true; } 
/*    */         } 
/*    */       } 
/* 64 */     }  if (bool1) {
/* 65 */       return Vec3D.a(i, j, k);
/*    */     }
/*    */     
/* 68 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\RandomPositionGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */