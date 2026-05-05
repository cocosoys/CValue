/*     */ package net.minecraft.potion;
/*     */ 
/*     */ import com.google.common.collect.Maps;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Map;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.attributes.AttributeModifier;
/*     */ import net.minecraft.entity.ai.attributes.BaseAttributeMap;
/*     */ import net.minecraft.entity.ai.attributes.IAttribute;
/*     */ import net.minecraft.entity.ai.attributes.IAttributeInstance;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Potion
/*     */ {
/*  23 */   public static final Potion[] field_76425_a = new Potion[32];
/*     */   
/*  25 */   public static final Potion field_76423_b = null;
/*  26 */   public static final Potion field_76424_c = (new Potion(1, false, 8171462)).func_76390_b("potion.moveSpeed").func_76399_b(0, 0).func_111184_a(SharedMonsterAttributes.field_111263_d, "91AEAA56-376B-4498-935B-2F7F68070635", 0.20000000298023224D, 2);
/*  27 */   public static final Potion field_76421_d = (new Potion(2, true, 5926017)).func_76390_b("potion.moveSlowdown").func_76399_b(1, 0).func_111184_a(SharedMonsterAttributes.field_111263_d, "7107DE5E-7CE8-4030-940E-514C1F160890", -0.15000000596046448D, 2);
/*  28 */   public static final Potion field_76422_e = (new Potion(3, false, 14270531)).func_76390_b("potion.digSpeed").func_76399_b(2, 0).func_76404_a(1.5D);
/*  29 */   public static final Potion field_76419_f = (new Potion(4, true, 4866583)).func_76390_b("potion.digSlowDown").func_76399_b(3, 0);
/*  30 */   public static final Potion field_76420_g = (new PotionAttackDamage(5, false, 9643043)).func_76390_b("potion.damageBoost").func_76399_b(4, 0).func_111184_a(SharedMonsterAttributes.field_111264_e, "648D7064-6A60-4F59-8ABE-C2C23A6DD7A9", 3.0D, 2);
/*  31 */   public static final Potion field_76432_h = (new PotionHealth(6, false, 16262179)).func_76390_b("potion.heal");
/*  32 */   public static final Potion field_76433_i = (new PotionHealth(7, true, 4393481)).func_76390_b("potion.harm");
/*  33 */   public static final Potion field_76430_j = (new Potion(8, false, 7889559)).func_76390_b("potion.jump").func_76399_b(2, 1);
/*  34 */   public static final Potion field_76431_k = (new Potion(9, true, 5578058)).func_76390_b("potion.confusion").func_76399_b(3, 1).func_76404_a(0.25D);
/*  35 */   public static final Potion field_76428_l = (new Potion(10, false, 13458603)).func_76390_b("potion.regeneration").func_76399_b(7, 0).func_76404_a(0.25D);
/*  36 */   public static final Potion field_76429_m = (new Potion(11, false, 10044730)).func_76390_b("potion.resistance").func_76399_b(6, 1);
/*  37 */   public static final Potion field_76426_n = (new Potion(12, false, 14981690)).func_76390_b("potion.fireResistance").func_76399_b(7, 1);
/*  38 */   public static final Potion field_76427_o = (new Potion(13, false, 3035801)).func_76390_b("potion.waterBreathing").func_76399_b(0, 2);
/*  39 */   public static final Potion field_76441_p = (new Potion(14, false, 8356754)).func_76390_b("potion.invisibility").func_76399_b(0, 1);
/*  40 */   public static final Potion field_76440_q = (new Potion(15, true, 2039587)).func_76390_b("potion.blindness").func_76399_b(5, 1).func_76404_a(0.25D);
/*  41 */   public static final Potion field_76439_r = (new Potion(16, false, 2039713)).func_76390_b("potion.nightVision").func_76399_b(4, 1);
/*  42 */   public static final Potion field_76438_s = (new Potion(17, true, 5797459)).func_76390_b("potion.hunger").func_76399_b(1, 1);
/*  43 */   public static final Potion field_76437_t = (new PotionAttackDamage(18, true, 4738376)).func_76390_b("potion.weakness").func_76399_b(5, 0).func_111184_a(SharedMonsterAttributes.field_111264_e, "22653B89-116E-49DC-9B6B-9971489B5BE5", 2.0D, 0);
/*  44 */   public static final Potion field_76436_u = (new Potion(19, true, 5149489)).func_76390_b("potion.poison").func_76399_b(6, 0).func_76404_a(0.25D);
/*  45 */   public static final Potion field_82731_v = (new Potion(20, true, 3484199)).func_76390_b("potion.wither").func_76399_b(1, 2).func_76404_a(0.25D);
/*  46 */   public static final Potion field_76434_w = (new PotionHealthBoost(21, false, 16284963)).func_76390_b("potion.healthBoost").func_76399_b(2, 2).func_111184_a(SharedMonsterAttributes.field_111267_a, "5D6F0BA2-1186-46AC-B896-C61C5CEE99CC", 4.0D, 0);
/*  47 */   public static final Potion field_76444_x = (new PotionAbsoption(22, false, 2445989)).func_76390_b("potion.absorption").func_76399_b(2, 2);
/*  48 */   public static final Potion field_76443_y = (new PotionHealth(23, false, 16262179)).func_76390_b("potion.saturation");
/*  49 */   public static final Potion field_76442_z = null;
/*  50 */   public static final Potion field_76409_A = null;
/*  51 */   public static final Potion field_76410_B = null;
/*  52 */   public static final Potion field_76411_C = null;
/*  53 */   public static final Potion field_76405_D = null;
/*  54 */   public static final Potion field_76406_E = null;
/*  55 */   public static final Potion field_76407_F = null;
/*  56 */   public static final Potion field_76408_G = null;
/*     */   
/*     */   public final int field_76415_H;
/*  59 */   private final Map field_111188_I = Maps.newHashMap();
/*     */   private final boolean field_76418_K;
/*     */   private final int field_76414_N;
/*  62 */   private String field_76416_I = "";
/*  63 */   private int field_76417_J = -1;
/*     */   
/*     */   private double field_76412_L;
/*     */   
/*     */   protected Potion(int p_i1573_1_, boolean p_i1573_2_, int p_i1573_3_) {
/*  68 */     this.field_76415_H = p_i1573_1_;
/*     */     
/*  70 */     field_76425_a[p_i1573_1_] = this;
/*  71 */     this.field_76418_K = p_i1573_2_;
/*  72 */     if (p_i1573_2_) {
/*  73 */       this.field_76412_L = 0.5D;
/*     */     } else {
/*  75 */       this.field_76412_L = 1.0D;
/*     */     } 
/*  77 */     this.field_76414_N = p_i1573_3_;
/*     */   }
/*     */   private boolean field_76413_M; private static final String __OBFID = "CL_00001528";
/*     */   protected Potion func_76399_b(int p_76399_1_, int p_76399_2_) {
/*  81 */     this.field_76417_J = p_76399_1_ + p_76399_2_ * 8;
/*  82 */     return this;
/*     */   }
/*     */   
/*     */   public int func_76396_c() {
/*  86 */     return this.field_76415_H;
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
/*     */   public void func_76394_a(EntityLivingBase p_76394_1_, int p_76394_2_) {
/* 100 */     if (this.field_76415_H == field_76428_l.field_76415_H) {
/* 101 */       if (p_76394_1_.func_110143_aJ() < p_76394_1_.func_110138_aP()) {
/* 102 */         p_76394_1_.func_70691_i(1.0F);
/*     */       }
/* 104 */     } else if (this.field_76415_H == field_76436_u.field_76415_H) {
/* 105 */       if (p_76394_1_.func_110143_aJ() > 1.0F) {
/* 106 */         p_76394_1_.func_70097_a(DamageSource.field_76376_m, 1.0F);
/*     */       }
/* 108 */     } else if (this.field_76415_H == field_82731_v.field_76415_H) {
/* 109 */       p_76394_1_.func_70097_a(DamageSource.field_82727_n, 1.0F);
/* 110 */     } else if (this.field_76415_H == field_76438_s.field_76415_H && p_76394_1_ instanceof EntityPlayer) {
/*     */ 
/*     */       
/* 113 */       ((EntityPlayer)p_76394_1_).func_71020_j(0.025F * (p_76394_2_ + 1));
/* 114 */     } else if (this.field_76415_H == field_76443_y.field_76415_H && p_76394_1_ instanceof EntityPlayer) {
/* 115 */       if (!p_76394_1_.field_70170_p.field_72995_K) {
/* 116 */         ((EntityPlayer)p_76394_1_).func_71024_bL().func_75122_a(p_76394_2_ + 1, 1.0F);
/*     */       }
/* 118 */     } else if ((this.field_76415_H == field_76432_h.field_76415_H && !p_76394_1_.func_70662_br()) || (this.field_76415_H == field_76433_i.field_76415_H && p_76394_1_.func_70662_br())) {
/* 119 */       p_76394_1_.func_70691_i(Math.max(4 << p_76394_2_, 0));
/* 120 */     } else if ((this.field_76415_H == field_76433_i.field_76415_H && !p_76394_1_.func_70662_br()) || (this.field_76415_H == field_76432_h.field_76415_H && p_76394_1_.func_70662_br())) {
/* 121 */       p_76394_1_.func_70097_a(DamageSource.field_76376_m, (6 << p_76394_2_));
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_76402_a(EntityLivingBase p_76402_1_, EntityLivingBase p_76402_2_, int p_76402_3_, double p_76402_4_) {
/* 126 */     if ((this.field_76415_H == field_76432_h.field_76415_H && !p_76402_2_.func_70662_br()) || (this.field_76415_H == field_76433_i.field_76415_H && p_76402_2_.func_70662_br())) {
/* 127 */       int i = (int)(p_76402_4_ * (4 << p_76402_3_) + 0.5D);
/* 128 */       p_76402_2_.func_70691_i(i);
/* 129 */     } else if ((this.field_76415_H == field_76433_i.field_76415_H && !p_76402_2_.func_70662_br()) || (this.field_76415_H == field_76432_h.field_76415_H && p_76402_2_.func_70662_br())) {
/* 130 */       int i = (int)(p_76402_4_ * (6 << p_76402_3_) + 0.5D);
/* 131 */       if (p_76402_1_ == null) {
/* 132 */         p_76402_2_.func_70097_a(DamageSource.field_76376_m, i);
/*     */       } else {
/* 134 */         p_76402_2_.func_70097_a(DamageSource.func_76354_b((Entity)p_76402_2_, (Entity)p_76402_1_), i);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean func_76403_b() {
/* 140 */     return false;
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
/*     */   public boolean func_76397_a(int p_76397_1_, int p_76397_2_) {
/* 156 */     if (this.field_76415_H == field_76428_l.field_76415_H) {
/*     */       
/* 158 */       int i = 50 >> p_76397_2_;
/* 159 */       if (i > 0) {
/* 160 */         return (p_76397_1_ % i == 0);
/*     */       }
/* 162 */       return true;
/* 163 */     }  if (this.field_76415_H == field_76436_u.field_76415_H) {
/*     */       
/* 165 */       int i = 25 >> p_76397_2_;
/* 166 */       if (i > 0) {
/* 167 */         return (p_76397_1_ % i == 0);
/*     */       }
/* 169 */       return true;
/* 170 */     }  if (this.field_76415_H == field_82731_v.field_76415_H) {
/* 171 */       int i = 40 >> p_76397_2_;
/* 172 */       if (i > 0) {
/* 173 */         return (p_76397_1_ % i == 0);
/*     */       }
/* 175 */       return true;
/* 176 */     }  if (this.field_76415_H == field_76438_s.field_76415_H) {
/* 177 */       return true;
/*     */     }
/*     */     
/* 180 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Potion func_76390_b(String p_76390_1_) {
/* 185 */     this.field_76416_I = p_76390_1_;
/* 186 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_76393_a() {
/* 191 */     return this.field_76416_I;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_76400_d() {
/* 195 */     return (this.field_76417_J >= 0);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_76392_e() {
/* 199 */     return this.field_76417_J;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_76398_f() {
/* 203 */     return this.field_76418_K;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static String func_76389_a(PotionEffect p_76389_0_) {
/* 207 */     if (p_76389_0_.func_100011_g()) {
/* 208 */       return "**:**";
/*     */     }
/* 210 */     int i = p_76389_0_.func_76459_b();
/* 211 */     return StringUtils.func_76337_a(i);
/*     */   }
/*     */   
/*     */   protected Potion func_76404_a(double p_76404_1_) {
/* 215 */     this.field_76412_L = p_76404_1_;
/* 216 */     return this;
/*     */   }
/*     */   
/*     */   public double func_76388_g() {
/* 220 */     return this.field_76412_L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_76395_i() {
/* 229 */     return this.field_76413_M;
/*     */   }
/*     */   
/*     */   public int func_76401_j() {
/* 233 */     return this.field_76414_N;
/*     */   }
/*     */   
/*     */   public Potion func_111184_a(IAttribute p_111184_1_, String p_111184_2_, double p_111184_3_, int p_111184_5_) {
/* 237 */     AttributeModifier attributeModifier = new AttributeModifier(UUID.fromString(p_111184_2_), func_76393_a(), p_111184_3_, p_111184_5_);
/* 238 */     this.field_111188_I.put(p_111184_1_, attributeModifier);
/* 239 */     return this;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Map func_111186_k() {
/* 243 */     return this.field_111188_I;
/*     */   }
/*     */   
/*     */   public void func_111187_a(EntityLivingBase p_111187_1_, BaseAttributeMap p_111187_2_, int p_111187_3_) {
/* 247 */     for (Map.Entry entry : this.field_111188_I.entrySet()) {
/* 248 */       IAttributeInstance iAttributeInstance = p_111187_2_.func_111151_a((IAttribute)entry.getKey());
/*     */       
/* 250 */       if (iAttributeInstance != null) {
/* 251 */         iAttributeInstance.func_111124_b((AttributeModifier)entry.getValue());
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_111185_a(EntityLivingBase p_111185_1_, BaseAttributeMap p_111185_2_, int p_111185_3_) {
/* 257 */     for (Map.Entry entry : this.field_111188_I.entrySet()) {
/* 258 */       IAttributeInstance iAttributeInstance = p_111185_2_.func_111151_a((IAttribute)entry.getKey());
/*     */       
/* 260 */       if (iAttributeInstance != null) {
/* 261 */         AttributeModifier attributeModifier = (AttributeModifier)entry.getValue();
/* 262 */         iAttributeInstance.func_111124_b(attributeModifier);
/* 263 */         iAttributeInstance.func_111121_a(new AttributeModifier(attributeModifier.func_111167_a(), func_76393_a() + " " + p_111185_3_, func_111183_a(p_111185_3_, attributeModifier), attributeModifier.func_111169_c()));
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public double func_111183_a(int p_111183_1_, AttributeModifier p_111183_2_) {
/* 269 */     return p_111183_2_.func_111164_d() * (p_111183_1_ + 1);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\potion\Potion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */