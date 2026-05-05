/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Random;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorldGenVillage
/*    */   extends StructureGenerator
/*    */ {
/* 15 */   public static final List e = Arrays.asList(new BiomeBase[] { BiomeBase.PLAINS, BiomeBase.DESERT, BiomeBase.SAVANNA });
/*    */   
/*    */   private int f;
/* 18 */   private int g = 32;
/* 19 */   private int h = 8;
/*    */ 
/*    */   
/*    */   public WorldGenVillage() {}
/*    */ 
/*    */   
/*    */   public WorldGenVillage(Map paramMap) {
/* 26 */     this();
/*    */     
/* 28 */     for (Map.Entry entry : paramMap.entrySet()) {
/* 29 */       if (((String)entry.getKey()).equals("size")) {
/* 30 */         this.f = MathHelper.a((String)entry.getValue(), this.f, 0); continue;
/* 31 */       }  if (((String)entry.getKey()).equals("distance")) {
/* 32 */         this.g = MathHelper.a((String)entry.getValue(), this.g, this.h + 1);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public String a() {
/* 39 */     return "Village";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean a(int paramInt1, int paramInt2) {
/* 45 */     int i = paramInt1;
/* 46 */     int j = paramInt2;
/* 47 */     if (paramInt1 < 0) paramInt1 -= this.g - 1; 
/* 48 */     if (paramInt2 < 0) paramInt2 -= this.g - 1;
/*    */     
/* 50 */     int k = paramInt1 / this.g;
/* 51 */     int m = paramInt2 / this.g;
/* 52 */     Random random = this.c.A(k, m, 10387312);
/* 53 */     k *= this.g;
/* 54 */     m *= this.g;
/* 55 */     k += random.nextInt(this.g - this.h);
/* 56 */     m += random.nextInt(this.g - this.h);
/* 57 */     paramInt1 = i;
/* 58 */     paramInt2 = j;
/*    */     
/* 60 */     if (paramInt1 == k && paramInt2 == m) {
/* 61 */       boolean bool = this.c.getWorldChunkManager().a(paramInt1 * 16 + 8, paramInt2 * 16 + 8, 0, e);
/* 62 */       if (bool) {
/* 63 */         return true;
/*    */       }
/*    */     } 
/*    */     
/* 67 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected StructureStart b(int paramInt1, int paramInt2) {
/* 73 */     return new WorldGenVillageStart(this.c, this.b, paramInt1, paramInt2, this.f);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\WorldGenVillage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */