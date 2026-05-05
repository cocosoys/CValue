/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.Vec3;
/*    */ 
/*    */ public class RandomPositionGenerator
/*    */ {
/* 10 */   private static Vec3 field_75465_a = Vec3.func_72443_a(0.0D, 0.0D, 0.0D); private static final String __OBFID = "CL_00001629";
/*    */   
/*    */   public static Vec3 func_75463_a(EntityCreature p_75463_0_, int p_75463_1_, int p_75463_2_) {
/* 13 */     return func_75462_c(p_75463_0_, p_75463_1_, p_75463_2_, null);
/*    */   }
/*    */   
/*    */   public static Vec3 func_75464_a(EntityCreature p_75464_0_, int p_75464_1_, int p_75464_2_, Vec3 p_75464_3_) {
/* 17 */     p_75464_3_.field_72450_a -= p_75464_0_.field_70165_t;
/* 18 */     p_75464_3_.field_72448_b -= p_75464_0_.field_70163_u;
/* 19 */     p_75464_3_.field_72449_c -= p_75464_0_.field_70161_v;
/* 20 */     return func_75462_c(p_75464_0_, p_75464_1_, p_75464_2_, field_75465_a);
/*    */   }
/*    */   
/*    */   public static Vec3 func_75461_b(EntityCreature p_75461_0_, int p_75461_1_, int p_75461_2_, Vec3 p_75461_3_) {
/* 24 */     field_75465_a.field_72450_a = p_75461_0_.field_70165_t - p_75461_3_.field_72450_a;
/* 25 */     field_75465_a.field_72448_b = p_75461_0_.field_70163_u - p_75461_3_.field_72448_b;
/* 26 */     field_75465_a.field_72449_c = p_75461_0_.field_70161_v - p_75461_3_.field_72449_c;
/* 27 */     return func_75462_c(p_75461_0_, p_75461_1_, p_75461_2_, field_75465_a);
/*    */   }
/*    */   private static Vec3 func_75462_c(EntityCreature p_75462_0_, int p_75462_1_, int p_75462_2_, Vec3 p_75462_3_) {
/*    */     boolean bool2;
/* 31 */     Random random = p_75462_0_.func_70681_au();
/* 32 */     boolean bool1 = false;
/* 33 */     int i = 0, j = 0, k = 0;
/* 34 */     float f = -99999.0F;
/*    */ 
/*    */     
/* 37 */     if (p_75462_0_.func_110175_bO())
/* 38 */     { double d1 = (p_75462_0_.func_110172_bL().func_71569_e(MathHelper.func_76128_c(p_75462_0_.field_70165_t), MathHelper.func_76128_c(p_75462_0_.field_70163_u), MathHelper.func_76128_c(p_75462_0_.field_70161_v)) + 4.0F);
/* 39 */       double d2 = (p_75462_0_.func_110174_bM() + p_75462_1_);
/* 40 */       bool2 = (d1 < d2 * d2) ? true : false; }
/* 41 */     else { bool2 = false; }
/*    */     
/* 43 */     for (byte b = 0; b < 10; b++) {
/* 44 */       int m = random.nextInt(2 * p_75462_1_) - p_75462_1_;
/* 45 */       int n = random.nextInt(2 * p_75462_2_) - p_75462_2_;
/* 46 */       int i1 = random.nextInt(2 * p_75462_1_) - p_75462_1_;
/*    */       
/* 48 */       if (p_75462_3_ == null || m * p_75462_3_.field_72450_a + i1 * p_75462_3_.field_72449_c >= 0.0D) {
/*    */         
/* 50 */         m += MathHelper.func_76128_c(p_75462_0_.field_70165_t);
/* 51 */         n += MathHelper.func_76128_c(p_75462_0_.field_70163_u);
/* 52 */         i1 += MathHelper.func_76128_c(p_75462_0_.field_70161_v);
/*    */         
/* 54 */         if (!bool2 || p_75462_0_.func_110176_b(m, n, i1)) {
/* 55 */           float f1 = p_75462_0_.func_70783_a(m, n, i1);
/* 56 */           if (f1 > f)
/* 57 */           { f = f1;
/* 58 */             i = m;
/* 59 */             j = n;
/* 60 */             k = i1;
/* 61 */             bool1 = true; } 
/*    */         } 
/*    */       } 
/* 64 */     }  if (bool1) {
/* 65 */       return Vec3.func_72443_a(i, j, k);
/*    */     }
/*    */     
/* 68 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\RandomPositionGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */