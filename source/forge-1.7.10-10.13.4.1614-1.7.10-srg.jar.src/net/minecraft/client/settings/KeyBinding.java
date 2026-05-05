/*     */ package net.minecraft.client.settings;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.util.IntHashMap;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class KeyBinding implements Comparable {
/*  13 */   private static final List field_74516_a = new ArrayList();
/*  14 */   private static final IntHashMap field_74514_b = new IntHashMap();
/*  15 */   private static final Set field_151473_c = new HashSet();
/*     */   
/*     */   private final String field_74515_c;
/*     */   private final int field_151472_e;
/*     */   private final String field_151471_f;
/*     */   private int field_74512_d;
/*     */   private boolean field_74513_e;
/*     */   private int field_151474_i;
/*     */   private static final String __OBFID = "CL_00000628";
/*     */   
/*     */   public static void func_74507_a(int p_74507_0_) {
/*  26 */     if (p_74507_0_ == 0)
/*  27 */       return;  KeyBinding keyBinding = (KeyBinding)field_74514_b.func_76041_a(p_74507_0_);
/*  28 */     if (keyBinding != null) keyBinding.field_151474_i++; 
/*     */   }
/*     */   
/*     */   public static void func_74510_a(int p_74510_0_, boolean p_74510_1_) {
/*  32 */     if (p_74510_0_ == 0)
/*  33 */       return;  KeyBinding keyBinding = (KeyBinding)field_74514_b.func_76041_a(p_74510_0_);
/*  34 */     if (keyBinding != null) keyBinding.field_74513_e = p_74510_1_; 
/*     */   }
/*     */   
/*     */   public static void func_74506_a() {
/*  38 */     for (KeyBinding keyBinding : field_74516_a) {
/*  39 */       keyBinding.func_74505_d();
/*     */     }
/*     */   }
/*     */   
/*     */   public static void func_74508_b() {
/*  44 */     field_74514_b.func_76046_c();
/*  45 */     for (KeyBinding keyBinding : field_74516_a) {
/*  46 */       field_74514_b.func_76038_a(keyBinding.field_74512_d, keyBinding);
/*     */     }
/*     */   }
/*     */   
/*     */   public static Set func_151467_c() {
/*  51 */     return field_151473_c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public KeyBinding(String p_i45001_1_, int p_i45001_2_, String p_i45001_3_) {
/*  62 */     this.field_74515_c = p_i45001_1_;
/*  63 */     this.field_74512_d = p_i45001_2_;
/*  64 */     this.field_151472_e = p_i45001_2_;
/*  65 */     this.field_151471_f = p_i45001_3_;
/*     */     
/*  67 */     field_74516_a.add(this);
/*  68 */     field_74514_b.func_76038_a(p_i45001_2_, this);
/*  69 */     field_151473_c.add(p_i45001_3_);
/*     */   }
/*     */   
/*     */   public boolean func_151470_d() {
/*  73 */     return this.field_74513_e;
/*     */   }
/*     */   
/*     */   public String func_151466_e() {
/*  77 */     return this.field_151471_f;
/*     */   }
/*     */   
/*     */   public boolean func_151468_f() {
/*  81 */     if (this.field_151474_i == 0) return false; 
/*  82 */     this.field_151474_i--;
/*  83 */     return true;
/*     */   }
/*     */   
/*     */   private void func_74505_d() {
/*  87 */     this.field_151474_i = 0;
/*  88 */     this.field_74513_e = false;
/*     */   }
/*     */   
/*     */   public String func_151464_g() {
/*  92 */     return this.field_74515_c;
/*     */   }
/*     */   
/*     */   public int func_151469_h() {
/*  96 */     return this.field_151472_e;
/*     */   }
/*     */   
/*     */   public int func_151463_i() {
/* 100 */     return this.field_74512_d;
/*     */   }
/*     */   
/*     */   public void func_151462_b(int p_151462_1_) {
/* 104 */     this.field_74512_d = p_151462_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public int compareTo(KeyBinding p_compareTo_1_) {
/* 109 */     int i = I18n.func_135052_a(this.field_151471_f, new Object[0]).compareTo(I18n.func_135052_a(p_compareTo_1_.field_151471_f, new Object[0]));
/*     */     
/* 111 */     if (i == 0) {
/* 112 */       i = I18n.func_135052_a(this.field_74515_c, new Object[0]).compareTo(I18n.func_135052_a(p_compareTo_1_.field_74515_c, new Object[0]));
/*     */     }
/*     */     
/* 115 */     return i;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\settings\KeyBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */