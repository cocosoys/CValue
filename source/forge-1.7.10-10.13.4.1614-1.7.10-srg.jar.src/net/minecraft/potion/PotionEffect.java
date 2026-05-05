/*     */ package net.minecraft.potion;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PotionEffect
/*     */ {
/*     */   private int field_76462_a;
/*     */   private int field_76460_b;
/*     */   private int field_76461_c;
/*     */   private boolean field_82723_d;
/*     */   private boolean field_82724_e;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private boolean field_100013_f;
/*     */   private static final String __OBFID = "CL_00001529";
/*     */   
/*     */   public PotionEffect(int p_i1574_1_, int p_i1574_2_) {
/*  23 */     this(p_i1574_1_, p_i1574_2_, 0);
/*     */   }
/*     */   
/*     */   public PotionEffect(int p_i1575_1_, int p_i1575_2_, int p_i1575_3_) {
/*  27 */     this(p_i1575_1_, p_i1575_2_, p_i1575_3_, false);
/*     */   }
/*     */   
/*     */   public PotionEffect(int p_i1576_1_, int p_i1576_2_, int p_i1576_3_, boolean p_i1576_4_) {
/*  31 */     this.field_76462_a = p_i1576_1_;
/*  32 */     this.field_76460_b = p_i1576_2_;
/*  33 */     this.field_76461_c = p_i1576_3_;
/*  34 */     this.field_82724_e = p_i1576_4_;
/*     */   }
/*     */   
/*     */   public PotionEffect(PotionEffect p_i1577_1_) {
/*  38 */     this.field_76462_a = p_i1577_1_.field_76462_a;
/*  39 */     this.field_76460_b = p_i1577_1_.field_76460_b;
/*  40 */     this.field_76461_c = p_i1577_1_.field_76461_c;
/*     */   }
/*     */   
/*     */   public void func_76452_a(PotionEffect p_76452_1_) {
/*  44 */     if (this.field_76462_a != p_76452_1_.field_76462_a) {
/*  45 */       System.err.println("This method should only be called for matching effects!");
/*     */     }
/*  47 */     if (p_76452_1_.field_76461_c > this.field_76461_c) {
/*  48 */       this.field_76461_c = p_76452_1_.field_76461_c;
/*  49 */       this.field_76460_b = p_76452_1_.field_76460_b;
/*  50 */     } else if (p_76452_1_.field_76461_c == this.field_76461_c && this.field_76460_b < p_76452_1_.field_76460_b) {
/*  51 */       this.field_76460_b = p_76452_1_.field_76460_b;
/*  52 */     } else if (!p_76452_1_.field_82724_e && this.field_82724_e) {
/*  53 */       this.field_82724_e = p_76452_1_.field_82724_e;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int func_76456_a() {
/*  58 */     return this.field_76462_a;
/*     */   }
/*     */   
/*     */   public int func_76459_b() {
/*  62 */     return this.field_76460_b;
/*     */   }
/*     */   
/*     */   public int func_76458_c() {
/*  66 */     return this.field_76461_c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_82721_a(boolean p_82721_1_) {
/*  74 */     this.field_82723_d = p_82721_1_;
/*     */   }
/*     */   
/*     */   public boolean func_82720_e() {
/*  78 */     return this.field_82724_e;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_76455_a(EntityLivingBase p_76455_1_) {
/*  88 */     if (this.field_76460_b > 0) {
/*  89 */       if (Potion.field_76425_a[this.field_76462_a].func_76397_a(this.field_76460_b, this.field_76461_c)) {
/*  90 */         func_76457_b(p_76455_1_);
/*     */       }
/*  92 */       func_76454_e();
/*     */     } 
/*  94 */     return (this.field_76460_b > 0);
/*     */   }
/*     */   
/*     */   private int func_76454_e() {
/*  98 */     return --this.field_76460_b;
/*     */   }
/*     */   
/*     */   public void func_76457_b(EntityLivingBase p_76457_1_) {
/* 102 */     if (this.field_76460_b > 0) {
/* 103 */       Potion.field_76425_a[this.field_76462_a].func_76394_a(p_76457_1_, this.field_76461_c);
/*     */     }
/*     */   }
/*     */   
/*     */   public String func_76453_d() {
/* 108 */     return Potion.field_76425_a[this.field_76462_a].func_76393_a();
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 113 */     return this.field_76462_a;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 118 */     String str = "";
/* 119 */     if (func_76458_c() > 0) {
/* 120 */       str = func_76453_d() + " x " + (func_76458_c() + 1) + ", Duration: " + func_76459_b();
/*     */     } else {
/* 122 */       str = func_76453_d() + ", Duration: " + func_76459_b();
/*     */     } 
/* 124 */     if (this.field_82723_d) {
/* 125 */       str = str + ", Splash: true";
/*     */     }
/* 127 */     if (Potion.field_76425_a[this.field_76462_a].func_76395_i()) {
/* 128 */       return "(" + str + ")";
/*     */     }
/* 130 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object p_equals_1_) {
/* 135 */     if (!(p_equals_1_ instanceof PotionEffect)) {
/* 136 */       return false;
/*     */     }
/* 138 */     PotionEffect potionEffect = (PotionEffect)p_equals_1_;
/* 139 */     return (this.field_76462_a == potionEffect.field_76462_a && this.field_76461_c == potionEffect.field_76461_c && this.field_76460_b == potionEffect.field_76460_b && this.field_82723_d == potionEffect.field_82723_d && this.field_82724_e == potionEffect.field_82724_e);
/*     */   }
/*     */   
/*     */   public NBTTagCompound func_82719_a(NBTTagCompound p_82719_1_) {
/* 143 */     p_82719_1_.func_74774_a("Id", (byte)func_76456_a());
/* 144 */     p_82719_1_.func_74774_a("Amplifier", (byte)func_76458_c());
/* 145 */     p_82719_1_.func_74768_a("Duration", func_76459_b());
/* 146 */     p_82719_1_.func_74757_a("Ambient", func_82720_e());
/* 147 */     return p_82719_1_;
/*     */   }
/*     */   
/*     */   public static PotionEffect func_82722_b(NBTTagCompound p_82722_0_) {
/* 151 */     byte b1 = p_82722_0_.func_74771_c("Id");
/* 152 */     if (b1 < 0 || b1 >= Potion.field_76425_a.length || Potion.field_76425_a[b1] == null) {
/* 153 */       return null;
/*     */     }
/* 155 */     byte b2 = p_82722_0_.func_74771_c("Amplifier");
/* 156 */     int i = p_82722_0_.func_74762_e("Duration");
/* 157 */     boolean bool = p_82722_0_.func_74767_n("Ambient");
/* 158 */     return new PotionEffect(b1, i, b2, bool);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_100012_b(boolean p_100012_1_) {
/* 162 */     this.field_100013_f = p_100012_1_;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_100011_g() {
/* 166 */     return this.field_100013_f;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\potion\PotionEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */