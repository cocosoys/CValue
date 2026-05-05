/*    */ package net.minecraft.util;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class MouseFilter {
/*    */   public float func_76333_a(float p_76333_1_, float p_76333_2_) {
/*  9 */     this.field_76336_a += p_76333_1_;
/*    */     
/* 11 */     p_76333_1_ = (this.field_76336_a - this.field_76334_b) * p_76333_2_;
/* 12 */     this.field_76335_c += (p_76333_1_ - this.field_76335_c) * 0.5F;
/* 13 */     if ((p_76333_1_ > 0.0F && p_76333_1_ > this.field_76335_c) || (p_76333_1_ < 0.0F && p_76333_1_ < this.field_76335_c)) {
/* 14 */       p_76333_1_ = this.field_76335_c;
/*    */     }
/* 16 */     this.field_76334_b += p_76333_1_;
/*    */     
/* 18 */     return p_76333_1_;
/*    */   }
/*    */   
/*    */   private float field_76336_a;
/*    */   private float field_76334_b;
/*    */   private float field_76335_c;
/*    */   private static final String __OBFID = "CL_00001500";
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\MouseFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */