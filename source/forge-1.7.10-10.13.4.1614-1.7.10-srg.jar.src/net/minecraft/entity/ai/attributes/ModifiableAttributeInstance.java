/*     */ package net.minecraft.entity.ai.attributes;
/*     */ import com.google.common.collect.Maps;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class ModifiableAttributeInstance implements IAttributeInstance {
/*     */   private final BaseAttributeMap field_111138_a;
/*  10 */   private final Map field_111137_c = Maps.newHashMap(); private final IAttribute field_111136_b;
/*  11 */   private final Map field_111134_d = Maps.newHashMap();
/*  12 */   private final Map field_111135_e = Maps.newHashMap(); private double field_111132_f;
/*     */   private boolean field_111133_g = true;
/*     */   private double field_111139_h;
/*     */   private static final String __OBFID = "CL_00001567";
/*     */   
/*     */   public ModifiableAttributeInstance(BaseAttributeMap p_i1608_1_, IAttribute p_i1608_2_) {
/*  18 */     this.field_111138_a = p_i1608_1_;
/*  19 */     this.field_111136_b = p_i1608_2_;
/*  20 */     this.field_111132_f = p_i1608_2_.func_111110_b();
/*     */     
/*  22 */     for (byte b = 0; b < 3; b++) {
/*  23 */       this.field_111137_c.put(Integer.valueOf(b), new HashSet());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IAttribute func_111123_a() {
/*  29 */     return this.field_111136_b;
/*     */   }
/*     */ 
/*     */   
/*     */   public double func_111125_b() {
/*  34 */     return this.field_111132_f;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_111128_a(double p_111128_1_) {
/*  39 */     if (p_111128_1_ == func_111125_b())
/*  40 */       return;  this.field_111132_f = p_111128_1_;
/*  41 */     func_111131_f();
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection func_111130_a(int p_111130_1_) {
/*  46 */     return (Collection)this.field_111137_c.get(Integer.valueOf(p_111130_1_));
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection func_111122_c() {
/*  51 */     HashSet hashSet = new HashSet();
/*     */     
/*  53 */     for (byte b = 0; b < 3; b++) {
/*  54 */       hashSet.addAll(func_111130_a(b));
/*     */     }
/*     */     
/*  57 */     return hashSet;
/*     */   }
/*     */ 
/*     */   
/*     */   public AttributeModifier func_111127_a(UUID p_111127_1_) {
/*  62 */     return (AttributeModifier)this.field_111135_e.get(p_111127_1_);
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
/*     */   public void func_111121_a(AttributeModifier p_111121_1_) {
/*  74 */     if (func_111127_a(p_111121_1_.func_111167_a()) != null) throw new IllegalArgumentException("Modifier is already applied on this attribute!");
/*     */     
/*  76 */     Set<AttributeModifier> set = (Set)this.field_111134_d.get(p_111121_1_.func_111166_b());
/*     */     
/*  78 */     if (set == null) {
/*  79 */       set = new HashSet();
/*  80 */       this.field_111134_d.put(p_111121_1_.func_111166_b(), set);
/*     */     } 
/*     */     
/*  83 */     ((Set<AttributeModifier>)this.field_111137_c.get(Integer.valueOf(p_111121_1_.func_111169_c()))).add(p_111121_1_);
/*  84 */     set.add(p_111121_1_);
/*  85 */     this.field_111135_e.put(p_111121_1_.func_111167_a(), p_111121_1_);
/*     */     
/*  87 */     func_111131_f();
/*     */   }
/*     */   
/*     */   private void func_111131_f() {
/*  91 */     this.field_111133_g = true;
/*  92 */     this.field_111138_a.func_111149_a(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_111124_b(AttributeModifier p_111124_1_) {
/*  97 */     for (byte b = 0; b < 3; b++) {
/*  98 */       Set set1 = (Set)this.field_111137_c.get(Integer.valueOf(b));
/*  99 */       set1.remove(p_111124_1_);
/*     */     } 
/*     */     
/* 102 */     Set set = (Set)this.field_111134_d.get(p_111124_1_.func_111166_b());
/*     */     
/* 104 */     if (set != null) {
/* 105 */       set.remove(p_111124_1_);
/*     */       
/* 107 */       if (set.isEmpty()) {
/* 108 */         this.field_111134_d.remove(p_111124_1_.func_111166_b());
/*     */       }
/*     */     } 
/*     */     
/* 112 */     this.field_111135_e.remove(p_111124_1_.func_111167_a());
/* 113 */     func_111131_f();
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
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_142049_d() {
/* 141 */     Collection<?> collection = func_111122_c();
/* 142 */     if (collection == null)
/*     */       return; 
/* 144 */     collection = new ArrayList(collection);
/*     */     
/* 146 */     for (AttributeModifier attributeModifier : collection) {
/* 147 */       func_111124_b(attributeModifier);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public double func_111126_e() {
/* 153 */     if (this.field_111133_g) {
/* 154 */       this.field_111139_h = func_111129_g();
/* 155 */       this.field_111133_g = false;
/*     */     } 
/*     */     
/* 158 */     return this.field_111139_h;
/*     */   }
/*     */   
/*     */   private double func_111129_g() {
/* 162 */     double d1 = func_111125_b();
/*     */     
/* 164 */     for (AttributeModifier attributeModifier : func_111130_a(0)) {
/* 165 */       d1 += attributeModifier.func_111164_d();
/*     */     }
/*     */     
/* 168 */     double d2 = d1;
/*     */     
/* 170 */     for (AttributeModifier attributeModifier : func_111130_a(1)) {
/* 171 */       d2 += d1 * attributeModifier.func_111164_d();
/*     */     }
/*     */     
/* 174 */     for (AttributeModifier attributeModifier : func_111130_a(2)) {
/* 175 */       d2 *= 1.0D + attributeModifier.func_111164_d();
/*     */     }
/*     */     
/* 178 */     return this.field_111136_b.func_111109_a(d2);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\attributes\ModifiableAttributeInstance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */