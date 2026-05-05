/*     */ package net.minecraft.world.gen.layer;
/*     */ 
/*     */ public class GenLayerEdge extends GenLayer {
/*     */   private final Mode field_151627_c;
/*     */   private static final String __OBFID = "CL_00000547";
/*     */   
/*     */   public enum Mode {
/*   8 */     COOL_WARM, HEAT_ICE, SPECIAL;
/*     */     private static final String __OBFID = "CL_00000549"; }
/*     */   
/*     */   public GenLayerEdge(long p_i45474_1_, GenLayer p_i45474_3_, Mode p_i45474_4_) {
/*  12 */     super(p_i45474_1_);
/*  13 */     this.field_75909_a = p_i45474_3_;
/*  14 */     this.field_151627_c = p_i45474_4_;
/*     */   }
/*     */ 
/*     */   
/*     */   public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_) {
/*  19 */     switch (SwitchMode.field_151642_a[this.field_151627_c.ordinal()])
/*     */     
/*     */     { default:
/*  22 */         return func_151626_c(p_75904_1_, p_75904_2_, p_75904_3_, p_75904_4_);
/*     */       case 2:
/*  24 */         return func_151624_d(p_75904_1_, p_75904_2_, p_75904_3_, p_75904_4_);
/*     */       case 3:
/*  26 */         break; }  return func_151625_e(p_75904_1_, p_75904_2_, p_75904_3_, p_75904_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   private int[] func_151626_c(int p_151626_1_, int p_151626_2_, int p_151626_3_, int p_151626_4_) {
/*  31 */     int i = p_151626_1_ - 1;
/*  32 */     int j = p_151626_2_ - 1;
/*  33 */     int k = 1 + p_151626_3_ + 1;
/*  34 */     int m = 1 + p_151626_4_ + 1;
/*  35 */     int[] arrayOfInt1 = this.field_75909_a.func_75904_a(i, j, k, m);
/*     */     
/*  37 */     int[] arrayOfInt2 = IntCache.func_76445_a(p_151626_3_ * p_151626_4_);
/*     */     
/*  39 */     for (byte b = 0; b < p_151626_4_; b++) {
/*  40 */       for (byte b1 = 0; b1 < p_151626_3_; b1++) {
/*  41 */         func_75903_a((b1 + p_151626_1_), (b + p_151626_2_));
/*     */         
/*  43 */         int n = arrayOfInt1[b1 + 1 + (b + 1) * k];
/*     */         
/*  45 */         if (n == 1) {
/*  46 */           int i1 = arrayOfInt1[b1 + 1 + (b + 1 - 1) * k];
/*  47 */           int i2 = arrayOfInt1[b1 + 1 + 1 + (b + 1) * k];
/*  48 */           int i3 = arrayOfInt1[b1 + 1 - 1 + (b + 1) * k];
/*  49 */           int i4 = arrayOfInt1[b1 + 1 + (b + 1 + 1) * k];
/*     */           
/*  51 */           boolean bool1 = (i1 == 3 || i2 == 3 || i3 == 3 || i4 == 3) ? true : false;
/*  52 */           boolean bool2 = (i1 == 4 || i2 == 4 || i3 == 4 || i4 == 4) ? true : false;
/*  53 */           if (bool1 || bool2) {
/*  54 */             n = 2;
/*     */           }
/*     */         } 
/*     */         
/*  58 */         arrayOfInt2[b1 + b * p_151626_3_] = n;
/*     */       } 
/*     */     } 
/*     */     
/*  62 */     return arrayOfInt2;
/*     */   }
/*     */   
/*     */   private int[] func_151624_d(int p_151624_1_, int p_151624_2_, int p_151624_3_, int p_151624_4_) {
/*  66 */     int i = p_151624_1_ - 1;
/*  67 */     int j = p_151624_2_ - 1;
/*  68 */     int k = 1 + p_151624_3_ + 1;
/*  69 */     int m = 1 + p_151624_4_ + 1;
/*  70 */     int[] arrayOfInt1 = this.field_75909_a.func_75904_a(i, j, k, m);
/*     */     
/*  72 */     int[] arrayOfInt2 = IntCache.func_76445_a(p_151624_3_ * p_151624_4_);
/*     */     
/*  74 */     for (byte b = 0; b < p_151624_4_; b++) {
/*  75 */       for (byte b1 = 0; b1 < p_151624_3_; b1++) {
/*  76 */         int n = arrayOfInt1[b1 + 1 + (b + 1) * k];
/*     */         
/*  78 */         if (n == 4) {
/*  79 */           int i1 = arrayOfInt1[b1 + 1 + (b + 1 - 1) * k];
/*  80 */           int i2 = arrayOfInt1[b1 + 1 + 1 + (b + 1) * k];
/*  81 */           int i3 = arrayOfInt1[b1 + 1 - 1 + (b + 1) * k];
/*  82 */           int i4 = arrayOfInt1[b1 + 1 + (b + 1 + 1) * k];
/*     */           
/*  84 */           boolean bool1 = (i1 == 2 || i2 == 2 || i3 == 2 || i4 == 2) ? true : false;
/*  85 */           boolean bool2 = (i1 == 1 || i2 == 1 || i3 == 1 || i4 == 1) ? true : false;
/*     */           
/*  87 */           if (bool2 || bool1) {
/*  88 */             n = 3;
/*     */           }
/*     */         } 
/*     */         
/*  92 */         arrayOfInt2[b1 + b * p_151624_3_] = n;
/*     */       } 
/*     */     } 
/*     */     
/*  96 */     return arrayOfInt2;
/*     */   }
/*     */   
/*     */   private int[] func_151625_e(int p_151625_1_, int p_151625_2_, int p_151625_3_, int p_151625_4_) {
/* 100 */     int[] arrayOfInt1 = this.field_75909_a.func_75904_a(p_151625_1_, p_151625_2_, p_151625_3_, p_151625_4_);
/* 101 */     int[] arrayOfInt2 = IntCache.func_76445_a(p_151625_3_ * p_151625_4_);
/*     */     
/* 103 */     for (byte b = 0; b < p_151625_4_; b++) {
/* 104 */       for (byte b1 = 0; b1 < p_151625_3_; b1++) {
/* 105 */         func_75903_a((b1 + p_151625_1_), (b + p_151625_2_));
/*     */         
/* 107 */         int i = arrayOfInt1[b1 + b * p_151625_3_];
/*     */         
/* 109 */         if (i != 0 && func_75902_a(13) == 0) {
/* 110 */           i |= 1 + func_75902_a(15) << 8 & 0xF00;
/*     */         }
/*     */         
/* 113 */         arrayOfInt2[b1 + b * p_151625_3_] = i;
/*     */       } 
/*     */     } 
/*     */     
/* 117 */     return arrayOfInt2;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\layer\GenLayerEdge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */