/*    */ package net.minecraft.util;
/*    */ import net.minecraft.client.settings.GameSettings;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class MovementInputFromOptions extends MovementInput {
/*    */   private GameSettings field_78903_e;
/*    */   
/*    */   public MovementInputFromOptions(GameSettings p_i1237_1_) {
/*  9 */     this.field_78903_e = p_i1237_1_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00000937";
/*    */   
/*    */   public void func_78898_a() {
/* 14 */     this.field_78902_a = 0.0F;
/* 15 */     this.field_78900_b = 0.0F;
/* 16 */     if (this.field_78903_e.field_74351_w.func_151470_d()) this.field_78900_b++; 
/* 17 */     if (this.field_78903_e.field_74368_y.func_151470_d()) this.field_78900_b--; 
/* 18 */     if (this.field_78903_e.field_74370_x.func_151470_d()) this.field_78902_a++; 
/* 19 */     if (this.field_78903_e.field_74366_z.func_151470_d()) this.field_78902_a--; 
/* 20 */     this.field_78901_c = this.field_78903_e.field_74314_A.func_151470_d();
/* 21 */     this.field_78899_d = this.field_78903_e.field_74311_E.func_151470_d();
/* 22 */     if (this.field_78899_d) {
/* 23 */       this.field_78902_a = (float)(this.field_78902_a * 0.3D);
/* 24 */       this.field_78900_b = (float)(this.field_78900_b * 0.3D);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\MovementInputFromOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */