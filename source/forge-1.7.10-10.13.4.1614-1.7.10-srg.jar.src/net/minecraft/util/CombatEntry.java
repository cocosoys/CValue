/*    */ package net.minecraft.util;
/*    */ 
/*    */ 
/*    */ public class CombatEntry
/*    */ {
/*    */   private final DamageSource field_94569_a;
/*    */   private final int field_94567_b;
/*    */   private final float field_94568_c;
/*    */   private final float field_94565_d;
/*    */   private final String field_94566_e;
/*    */   private final float field_94564_f;
/*    */   private static final String __OBFID = "CL_00001519";
/*    */   
/*    */   public CombatEntry(DamageSource p_i1564_1_, int p_i1564_2_, float p_i1564_3_, float p_i1564_4_, String p_i1564_5_, float p_i1564_6_) {
/* 15 */     this.field_94569_a = p_i1564_1_;
/* 16 */     this.field_94567_b = p_i1564_2_;
/* 17 */     this.field_94568_c = p_i1564_4_;
/* 18 */     this.field_94565_d = p_i1564_3_;
/* 19 */     this.field_94566_e = p_i1564_5_;
/* 20 */     this.field_94564_f = p_i1564_6_;
/*    */   }
/*    */   
/*    */   public DamageSource func_94560_a() {
/* 24 */     return this.field_94569_a;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public float func_94563_c() {
/* 32 */     return this.field_94568_c;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_94559_f() {
/* 44 */     return this.field_94569_a.func_76346_g() instanceof net.minecraft.entity.EntityLivingBase;
/*    */   }
/*    */   
/*    */   public String func_94562_g() {
/* 48 */     return this.field_94566_e;
/*    */   }
/*    */   
/*    */   public IChatComponent func_151522_h() {
/* 52 */     return (func_94560_a().func_76346_g() == null) ? null : func_94560_a().func_76346_g().func_145748_c_();
/*    */   }
/*    */   
/*    */   public float func_94561_i() {
/* 56 */     if (this.field_94569_a == DamageSource.field_76380_i) return Float.MAX_VALUE; 
/* 57 */     return this.field_94564_f;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\CombatEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */