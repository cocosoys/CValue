/*     */ package net.minecraft.client.renderer.texture;
/*     */ import com.google.common.collect.Lists;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class Stitcher {
/*  11 */   private final Set field_94319_a = new HashSet(256); private final int field_147971_a;
/*  12 */   private final List field_94317_b = new ArrayList(256);
/*     */   private int field_94318_c;
/*     */   private int field_94315_d;
/*     */   private final int field_94316_e;
/*     */   private final int field_94313_f;
/*     */   private final boolean field_94314_g;
/*     */   private final int field_94323_h;
/*     */   private static final String __OBFID = "CL_00001054";
/*     */   
/*     */   public Stitcher(int p_i45095_1_, int p_i45095_2_, boolean p_i45095_3_, int p_i45095_4_, int p_i45095_5_) {
/*  22 */     this.field_147971_a = p_i45095_5_;
/*  23 */     this.field_94316_e = p_i45095_1_;
/*  24 */     this.field_94313_f = p_i45095_2_;
/*  25 */     this.field_94314_g = p_i45095_3_;
/*  26 */     this.field_94323_h = p_i45095_4_;
/*     */   }
/*     */   
/*     */   public int func_110935_a() {
/*  30 */     return this.field_94318_c;
/*     */   }
/*     */   
/*     */   public int func_110936_b() {
/*  34 */     return this.field_94315_d;
/*     */   }
/*     */   
/*     */   public void func_110934_a(TextureAtlasSprite p_110934_1_) {
/*  38 */     Holder holder = new Holder(p_110934_1_, this.field_147971_a);
/*  39 */     if (this.field_94323_h > 0) {
/*  40 */       holder.func_94196_a(this.field_94323_h);
/*     */     }
/*  42 */     this.field_94319_a.add(holder);
/*     */   }
/*     */   
/*     */   public void func_94305_f() {
/*  46 */     Holder[] arrayOfHolder = (Holder[])this.field_94319_a.toArray((Object[])new Holder[this.field_94319_a.size()]);
/*  47 */     Arrays.sort((Object[])arrayOfHolder);
/*     */     
/*  49 */     for (Holder holder : arrayOfHolder) {
/*  50 */       if (!func_94310_b(holder)) {
/*  51 */         String str = String.format("Unable to fit: %s - size: %dx%d - Maybe try a lowerresolution resourcepack?", new Object[] { holder.func_98150_a().func_94215_i(), Integer.valueOf(holder.func_98150_a().func_94211_a()), Integer.valueOf(holder.func_98150_a().func_94216_b()) });
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  56 */         throw new StitcherException(holder, str);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  61 */     if (this.field_94314_g) {
/*     */       
/*  63 */       this.field_94318_c = MathHelper.func_151236_b(this.field_94318_c);
/*  64 */       this.field_94315_d = MathHelper.func_151236_b(this.field_94315_d);
/*     */     } 
/*     */   }
/*     */   
/*     */   public List func_94309_g() {
/*  69 */     ArrayList arrayList = Lists.newArrayList();
/*     */     
/*  71 */     for (Slot slot : this.field_94317_b) {
/*  72 */       slot.func_94184_a(arrayList);
/*     */     }
/*     */     
/*  75 */     ArrayList<TextureAtlasSprite> arrayList1 = Lists.newArrayList();
/*  76 */     for (Slot slot : arrayList) {
/*  77 */       Holder holder = slot.func_94183_a();
/*     */       
/*  79 */       TextureAtlasSprite textureAtlasSprite = holder.func_98150_a();
/*  80 */       textureAtlasSprite.func_110971_a(this.field_94318_c, this.field_94315_d, slot.func_94186_b(), slot.func_94185_c(), holder.func_94195_e());
/*     */       
/*  82 */       arrayList1.add(textureAtlasSprite);
/*     */     } 
/*     */     
/*  85 */     return arrayList1;
/*     */   }
/*     */   
/*     */   private static int func_147969_b(int p_147969_0_, int p_147969_1_) {
/*  89 */     return (p_147969_0_ >> p_147969_1_) + (((p_147969_0_ & (1 << p_147969_1_) - 1) == 0) ? 0 : 1) << p_147969_1_;
/*     */   }
/*     */   
/*     */   private boolean func_94310_b(Holder p_94310_1_) {
/*  93 */     for (byte b = 0; b < this.field_94317_b.size(); b++) {
/*  94 */       if (((Slot)this.field_94317_b.get(b)).func_94182_a(p_94310_1_)) {
/*  95 */         return true;
/*     */       }
/*     */ 
/*     */       
/*  99 */       p_94310_1_.func_94194_d();
/* 100 */       if (((Slot)this.field_94317_b.get(b)).func_94182_a(p_94310_1_)) {
/* 101 */         return true;
/*     */       }
/*     */ 
/*     */       
/* 105 */       p_94310_1_.func_94194_d();
/*     */     } 
/*     */     
/* 108 */     return func_94311_c(p_94310_1_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean func_94311_c(Holder p_94311_1_) {
/*     */     boolean bool2;
/*     */     Slot slot;
/* 119 */     int i = Math.min(p_94311_1_.func_94197_a(), p_94311_1_.func_94199_b());
/* 120 */     boolean bool1 = (this.field_94318_c == 0 && this.field_94315_d == 0) ? true : false;
/*     */ 
/*     */ 
/*     */     
/* 124 */     if (this.field_94314_g) {
/* 125 */       int k = MathHelper.func_151236_b(this.field_94318_c);
/* 126 */       int m = MathHelper.func_151236_b(this.field_94315_d);
/* 127 */       int n = MathHelper.func_151236_b(this.field_94318_c + i);
/* 128 */       int i1 = MathHelper.func_151236_b(this.field_94315_d + i);
/*     */       
/* 130 */       boolean bool3 = (n <= this.field_94316_e) ? true : false;
/* 131 */       boolean bool4 = (i1 <= this.field_94313_f) ? true : false;
/*     */       
/* 133 */       if (!bool3 && !bool4) {
/* 134 */         return false;
/*     */       }
/*     */       
/* 137 */       boolean bool5 = (k != n) ? true : false;
/* 138 */       boolean bool6 = (m != i1) ? true : false;
/*     */       
/* 140 */       if ((bool5 ^ bool6) != 0) {
/*     */         
/* 142 */         bool2 = !bool5 ? true : false;
/*     */       } else {
/*     */         
/* 145 */         bool2 = (bool3 && k <= m) ? true : false;
/*     */       } 
/*     */     } else {
/*     */       
/* 149 */       boolean bool3 = (this.field_94318_c + i <= this.field_94316_e) ? true : false;
/* 150 */       boolean bool4 = (this.field_94315_d + i <= this.field_94313_f) ? true : false;
/*     */       
/* 152 */       if (!bool3 && !bool4) {
/* 153 */         return false;
/*     */       }
/*     */ 
/*     */       
/* 157 */       bool2 = (bool3 && (bool1 || this.field_94318_c <= this.field_94315_d)) ? true : false;
/*     */     } 
/*     */ 
/*     */     
/* 161 */     int j = Math.max(p_94311_1_.func_94197_a(), p_94311_1_.func_94199_b());
/* 162 */     if (MathHelper.func_151236_b((bool2 ? this.field_94315_d : this.field_94318_c) + j) > (bool2 ? this.field_94313_f : this.field_94316_e)) {
/* 163 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 167 */     if (bool2) {
/* 168 */       if (p_94311_1_.func_94197_a() > p_94311_1_.func_94199_b()) {
/* 169 */         p_94311_1_.func_94194_d();
/*     */       }
/*     */ 
/*     */       
/* 173 */       if (this.field_94315_d == 0) {
/* 174 */         this.field_94315_d = p_94311_1_.func_94199_b();
/*     */       }
/*     */       
/* 177 */       slot = new Slot(this.field_94318_c, 0, p_94311_1_.func_94197_a(), this.field_94315_d);
/* 178 */       this.field_94318_c += p_94311_1_.func_94197_a();
/*     */     } else {
/*     */       
/* 181 */       slot = new Slot(0, this.field_94315_d, this.field_94318_c, p_94311_1_.func_94199_b());
/* 182 */       this.field_94315_d += p_94311_1_.func_94199_b();
/*     */     } 
/*     */     
/* 185 */     slot.func_94182_a(p_94311_1_);
/* 186 */     this.field_94317_b.add(slot);
/*     */     
/* 188 */     return true;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static class Holder implements Comparable { private final TextureAtlasSprite field_98151_a;
/*     */     private final int field_94204_c;
/*     */     private final int field_94201_d;
/*     */     private final int field_147968_d;
/*     */     private boolean field_94202_e;
/* 197 */     private float field_94205_a = 1.0F; private static final String __OBFID = "CL_00001055";
/*     */     
/*     */     public Holder(TextureAtlasSprite p_i45094_1_, int p_i45094_2_) {
/* 200 */       this.field_98151_a = p_i45094_1_;
/* 201 */       this.field_94204_c = p_i45094_1_.func_94211_a();
/* 202 */       this.field_94201_d = p_i45094_1_.func_94216_b();
/* 203 */       this.field_147968_d = p_i45094_2_;
/*     */       
/* 205 */       this.field_94202_e = (Stitcher.func_147969_b(this.field_94201_d, p_i45094_2_) > Stitcher.func_147969_b(this.field_94204_c, p_i45094_2_));
/*     */     }
/*     */     
/*     */     public TextureAtlasSprite func_98150_a() {
/* 209 */       return this.field_98151_a;
/*     */     }
/*     */     
/*     */     public int func_94197_a() {
/* 213 */       return this.field_94202_e ? Stitcher.func_147969_b((int)(this.field_94201_d * this.field_94205_a), this.field_147968_d) : Stitcher.func_147969_b((int)(this.field_94204_c * this.field_94205_a), this.field_147968_d);
/*     */     }
/*     */     
/*     */     public int func_94199_b() {
/* 217 */       return this.field_94202_e ? Stitcher.func_147969_b((int)(this.field_94204_c * this.field_94205_a), this.field_147968_d) : Stitcher.func_147969_b((int)(this.field_94201_d * this.field_94205_a), this.field_147968_d);
/*     */     }
/*     */     
/*     */     public void func_94194_d() {
/* 221 */       this.field_94202_e = !this.field_94202_e;
/*     */     }
/*     */     
/*     */     public boolean func_94195_e() {
/* 225 */       return this.field_94202_e;
/*     */     }
/*     */     
/*     */     public void func_94196_a(int p_94196_1_) {
/* 229 */       if (this.field_94204_c <= p_94196_1_ || this.field_94201_d <= p_94196_1_) {
/*     */         return;
/*     */       }
/*     */       
/* 233 */       this.field_94205_a = p_94196_1_ / Math.min(this.field_94204_c, this.field_94201_d);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 238 */       return "Holder{width=" + this.field_94204_c + ", height=" + this.field_94201_d + '}';
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int compareTo(Holder p_compareTo_1_) {
/*     */       boolean bool;
/* 247 */       if (func_94199_b() == p_compareTo_1_.func_94199_b()) {
/* 248 */         if (func_94197_a() == p_compareTo_1_.func_94197_a()) {
/* 249 */           if (this.field_98151_a.func_94215_i() == null) {
/* 250 */             return (p_compareTo_1_.field_98151_a.func_94215_i() == null) ? 0 : -1;
/*     */           }
/* 252 */           return this.field_98151_a.func_94215_i().compareTo(p_compareTo_1_.field_98151_a.func_94215_i());
/*     */         } 
/* 254 */         bool = (func_94197_a() < p_compareTo_1_.func_94197_a()) ? true : true;
/*     */       } else {
/* 256 */         bool = (func_94199_b() < p_compareTo_1_.func_94199_b()) ? true : true;
/*     */       } 
/* 258 */       return bool;
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static class Slot
/*     */   {
/*     */     private final int field_94192_a;
/*     */     private final int field_94190_b;
/*     */     private final int field_94191_c;
/*     */     private final int field_94188_d;
/*     */     private List field_94189_e;
/*     */     private Stitcher.Holder field_94187_f;
/*     */     private static final String __OBFID = "CL_00001056";
/*     */     
/*     */     public Slot(int p_i1277_1_, int p_i1277_2_, int p_i1277_3_, int p_i1277_4_) {
/* 275 */       this.field_94192_a = p_i1277_1_;
/* 276 */       this.field_94190_b = p_i1277_2_;
/* 277 */       this.field_94191_c = p_i1277_3_;
/* 278 */       this.field_94188_d = p_i1277_4_;
/*     */     }
/*     */     
/*     */     public Stitcher.Holder func_94183_a() {
/* 282 */       return this.field_94187_f;
/*     */     }
/*     */     
/*     */     public int func_94186_b() {
/* 286 */       return this.field_94192_a;
/*     */     }
/*     */     
/*     */     public int func_94185_c() {
/* 290 */       return this.field_94190_b;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean func_94182_a(Stitcher.Holder p_94182_1_) {
/* 295 */       if (this.field_94187_f != null) {
/* 296 */         return false;
/*     */       }
/*     */       
/* 299 */       int i = p_94182_1_.func_94197_a();
/* 300 */       int j = p_94182_1_.func_94199_b();
/*     */ 
/*     */       
/* 303 */       if (i > this.field_94191_c || j > this.field_94188_d) {
/* 304 */         return false;
/*     */       }
/*     */ 
/*     */       
/* 308 */       if (i == this.field_94191_c && j == this.field_94188_d) {
/*     */         
/* 310 */         this.field_94187_f = p_94182_1_;
/* 311 */         return true;
/*     */       } 
/*     */ 
/*     */       
/* 315 */       if (this.field_94189_e == null) {
/* 316 */         this.field_94189_e = new ArrayList(1);
/*     */ 
/*     */         
/* 319 */         this.field_94189_e.add(new Slot(this.field_94192_a, this.field_94190_b, i, j));
/*     */         
/* 321 */         int k = this.field_94191_c - i;
/* 322 */         int m = this.field_94188_d - j;
/*     */         
/* 324 */         if (m > 0 && k > 0) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 339 */           int n = Math.max(this.field_94188_d, k);
/* 340 */           int i1 = Math.max(this.field_94191_c, m);
/* 341 */           if (n >= i1) {
/* 342 */             this.field_94189_e.add(new Slot(this.field_94192_a, this.field_94190_b + j, i, m));
/* 343 */             this.field_94189_e.add(new Slot(this.field_94192_a + i, this.field_94190_b, k, this.field_94188_d));
/*     */           } else {
/* 345 */             this.field_94189_e.add(new Slot(this.field_94192_a + i, this.field_94190_b, k, j));
/* 346 */             this.field_94189_e.add(new Slot(this.field_94192_a, this.field_94190_b + j, this.field_94191_c, m));
/*     */           }
/*     */         
/* 349 */         } else if (k == 0) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 359 */           this.field_94189_e.add(new Slot(this.field_94192_a, this.field_94190_b + j, i, m));
/* 360 */         } else if (m == 0) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 371 */           this.field_94189_e.add(new Slot(this.field_94192_a + i, this.field_94190_b, k, j));
/*     */         } 
/*     */       } 
/*     */       
/* 375 */       for (Slot slot : this.field_94189_e) {
/* 376 */         if (slot.func_94182_a(p_94182_1_)) {
/* 377 */           return true;
/*     */         }
/*     */       } 
/*     */       
/* 381 */       return false;
/*     */     }
/*     */     
/*     */     public void func_94184_a(List<Slot> p_94184_1_) {
/* 385 */       if (this.field_94187_f != null) {
/* 386 */         p_94184_1_.add(this);
/* 387 */       } else if (this.field_94189_e != null) {
/* 388 */         for (Slot slot : this.field_94189_e) {
/* 389 */           slot.func_94184_a(p_94184_1_);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 396 */       return "Slot{originX=" + this.field_94192_a + ", originY=" + this.field_94190_b + ", width=" + this.field_94191_c + ", height=" + this.field_94188_d + ", texture=" + this.field_94187_f + ", subSlots=" + this.field_94189_e + '}';
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\texture\Stitcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */