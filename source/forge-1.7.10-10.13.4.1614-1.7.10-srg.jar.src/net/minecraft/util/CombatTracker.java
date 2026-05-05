/*     */ package net.minecraft.util;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CombatTracker
/*     */ {
/*  19 */   private final List field_94556_a = new ArrayList();
/*     */   
/*     */   private final EntityLivingBase field_94554_b;
/*     */   
/*     */   private int field_94555_c;
/*     */   
/*     */   private int field_152775_d;
/*     */   private int field_152776_e;
/*     */   
/*     */   public CombatTracker(EntityLivingBase p_i1565_1_) {
/*  29 */     this.field_94554_b = p_i1565_1_;
/*     */   }
/*     */   private boolean field_94552_d; private boolean field_94553_e; private String field_94551_f; private static final String __OBFID = "CL_00001520";
/*     */   public void func_94545_a() {
/*  33 */     func_94542_g();
/*     */     
/*  35 */     if (this.field_94554_b.func_70617_f_()) {
/*  36 */       Block block = this.field_94554_b.field_70170_p.func_147439_a(MathHelper.func_76128_c(this.field_94554_b.field_70165_t), MathHelper.func_76128_c(this.field_94554_b.field_70121_D.field_72338_b), MathHelper.func_76128_c(this.field_94554_b.field_70161_v));
/*     */       
/*  38 */       if (block == Blocks.field_150468_ap) {
/*  39 */         this.field_94551_f = "ladder";
/*  40 */       } else if (block == Blocks.field_150395_bd) {
/*  41 */         this.field_94551_f = "vines";
/*     */       } 
/*  43 */     } else if (this.field_94554_b.func_70090_H()) {
/*  44 */       this.field_94551_f = "water";
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_94547_a(DamageSource p_94547_1_, float p_94547_2_, float p_94547_3_) {
/*  49 */     func_94549_h();
/*  50 */     func_94545_a();
/*     */     
/*  52 */     CombatEntry combatEntry = new CombatEntry(p_94547_1_, this.field_94554_b.field_70173_aa, p_94547_2_, p_94547_3_, this.field_94551_f, this.field_94554_b.field_70143_R);
/*     */     
/*  54 */     this.field_94556_a.add(combatEntry);
/*  55 */     this.field_94555_c = this.field_94554_b.field_70173_aa;
/*  56 */     this.field_94553_e = true;
/*     */     
/*  58 */     if (combatEntry.func_94559_f() && !this.field_94552_d && this.field_94554_b.func_70089_S()) {
/*  59 */       this.field_94552_d = true;
/*  60 */       this.field_152775_d = this.field_94554_b.field_70173_aa;
/*  61 */       this.field_152776_e = this.field_152775_d;
/*  62 */       this.field_94554_b.func_152111_bt();
/*     */     } 
/*     */   }
/*     */   public IChatComponent func_151521_b() {
/*     */     IChatComponent iChatComponent1;
/*  67 */     if (this.field_94556_a.size() == 0) return new ChatComponentTranslation("death.attack.generic", new Object[] { this.field_94554_b.func_145748_c_() });
/*     */     
/*  69 */     CombatEntry combatEntry1 = func_94544_f();
/*  70 */     CombatEntry combatEntry2 = this.field_94556_a.get(this.field_94556_a.size() - 1);
/*     */     
/*  72 */     IChatComponent iChatComponent2 = combatEntry2.func_151522_h();
/*  73 */     Entity entity = combatEntry2.func_94560_a().func_76346_g();
/*     */     
/*  75 */     if (combatEntry1 != null && combatEntry2.func_94560_a() == DamageSource.field_76379_h) {
/*  76 */       IChatComponent iChatComponent = combatEntry1.func_151522_h();
/*     */       
/*  78 */       if (combatEntry1.func_94560_a() == DamageSource.field_76379_h || combatEntry1.func_94560_a() == DamageSource.field_76380_i) {
/*  79 */         iChatComponent1 = new ChatComponentTranslation("death.fell.accident." + func_94548_b(combatEntry1), new Object[] { this.field_94554_b.func_145748_c_() });
/*  80 */       } else if (iChatComponent != null && (iChatComponent2 == null || !iChatComponent.equals(iChatComponent2))) {
/*  81 */         Entity entity1 = combatEntry1.func_94560_a().func_76346_g();
/*  82 */         ItemStack itemStack = (entity1 instanceof EntityLivingBase) ? ((EntityLivingBase)entity1).func_70694_bm() : null;
/*     */         
/*  84 */         if (itemStack != null && itemStack.func_82837_s()) {
/*  85 */           iChatComponent1 = new ChatComponentTranslation("death.fell.assist.item", new Object[] { this.field_94554_b.func_145748_c_(), iChatComponent, itemStack.func_151000_E() });
/*     */         } else {
/*  87 */           iChatComponent1 = new ChatComponentTranslation("death.fell.assist", new Object[] { this.field_94554_b.func_145748_c_(), iChatComponent });
/*     */         } 
/*  89 */       } else if (iChatComponent2 != null) {
/*  90 */         ItemStack itemStack = (entity instanceof EntityLivingBase) ? ((EntityLivingBase)entity).func_70694_bm() : null;
/*  91 */         if (itemStack != null && itemStack.func_82837_s()) {
/*  92 */           iChatComponent1 = new ChatComponentTranslation("death.fell.finish.item", new Object[] { this.field_94554_b.func_145748_c_(), iChatComponent2, itemStack.func_151000_E() });
/*     */         } else {
/*  94 */           iChatComponent1 = new ChatComponentTranslation("death.fell.finish", new Object[] { this.field_94554_b.func_145748_c_(), iChatComponent2 });
/*     */         } 
/*     */       } else {
/*  97 */         iChatComponent1 = new ChatComponentTranslation("death.fell.killer", new Object[] { this.field_94554_b.func_145748_c_() });
/*     */       } 
/*     */     } else {
/* 100 */       iChatComponent1 = combatEntry2.func_94560_a().func_151519_b(this.field_94554_b);
/*     */     } 
/*     */     
/* 103 */     return iChatComponent1;
/*     */   }
/*     */   
/*     */   public EntityLivingBase func_94550_c() {
/* 107 */     EntityLivingBase entityLivingBase = null;
/* 108 */     EntityPlayer entityPlayer = null;
/* 109 */     float f1 = 0.0F;
/* 110 */     float f2 = 0.0F;
/*     */     
/* 112 */     for (CombatEntry combatEntry : this.field_94556_a) {
/* 113 */       if (combatEntry.func_94560_a().func_76346_g() instanceof EntityPlayer && (entityPlayer == null || combatEntry.func_94563_c() > f2)) {
/* 114 */         f2 = combatEntry.func_94563_c();
/* 115 */         entityPlayer = (EntityPlayer)combatEntry.func_94560_a().func_76346_g();
/*     */       } 
/*     */       
/* 118 */       if (combatEntry.func_94560_a().func_76346_g() instanceof EntityLivingBase && (entityLivingBase == null || combatEntry.func_94563_c() > f1)) {
/* 119 */         f1 = combatEntry.func_94563_c();
/* 120 */         entityLivingBase = (EntityLivingBase)combatEntry.func_94560_a().func_76346_g();
/*     */       } 
/*     */     } 
/*     */     
/* 124 */     if (entityPlayer != null && f2 >= f1 / 3.0F) {
/* 125 */       return (EntityLivingBase)entityPlayer;
/*     */     }
/* 127 */     return entityLivingBase;
/*     */   }
/*     */ 
/*     */   
/*     */   private CombatEntry func_94544_f() {
/* 132 */     CombatEntry combatEntry1 = null;
/* 133 */     CombatEntry combatEntry2 = null;
/* 134 */     byte b1 = 0;
/* 135 */     float f = 0.0F;
/*     */     
/* 137 */     for (byte b2 = 0; b2 < this.field_94556_a.size(); b2++) {
/* 138 */       CombatEntry combatEntry3 = this.field_94556_a.get(b2);
/* 139 */       CombatEntry combatEntry4 = (b2 > 0) ? this.field_94556_a.get(b2 - 1) : null;
/*     */       
/* 141 */       if ((combatEntry3.func_94560_a() == DamageSource.field_76379_h || combatEntry3.func_94560_a() == DamageSource.field_76380_i) && combatEntry3.func_94561_i() > 0.0F && (combatEntry1 == null || combatEntry3.func_94561_i() > f)) {
/* 142 */         if (b2 > 0) {
/* 143 */           combatEntry1 = combatEntry4;
/*     */         } else {
/* 145 */           combatEntry1 = combatEntry3;
/*     */         } 
/* 147 */         f = combatEntry3.func_94561_i();
/*     */       } 
/*     */       
/* 150 */       if (combatEntry3.func_94562_g() != null && (combatEntry2 == null || combatEntry3.func_94563_c() > b1)) {
/* 151 */         combatEntry2 = combatEntry3;
/*     */       }
/*     */     } 
/*     */     
/* 155 */     if (f > 5.0F && combatEntry1 != null)
/* 156 */       return combatEntry1; 
/* 157 */     if (b1 > 5 && combatEntry2 != null) {
/* 158 */       return combatEntry2;
/*     */     }
/* 160 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private String func_94548_b(CombatEntry p_94548_1_) {
/* 165 */     return (p_94548_1_.func_94562_g() == null) ? "generic" : p_94548_1_.func_94562_g();
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
/*     */   private void func_94542_g() {
/* 188 */     this.field_94551_f = null;
/*     */   }
/*     */   
/*     */   public void func_94549_h() {
/* 192 */     byte b = this.field_94552_d ? 300 : 100;
/*     */     
/* 194 */     if (this.field_94553_e && (!this.field_94554_b.func_70089_S() || this.field_94554_b.field_70173_aa - this.field_94555_c > b)) {
/* 195 */       boolean bool = this.field_94552_d;
/* 196 */       this.field_94553_e = false;
/* 197 */       this.field_94552_d = false;
/* 198 */       this.field_152776_e = this.field_94554_b.field_70173_aa;
/*     */       
/* 200 */       if (bool) {
/* 201 */         this.field_94554_b.func_152112_bu();
/*     */       }
/* 203 */       this.field_94556_a.clear();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\CombatTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */