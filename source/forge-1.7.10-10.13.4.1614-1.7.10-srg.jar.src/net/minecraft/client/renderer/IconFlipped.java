/*    */ package net.minecraft.client.renderer;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.util.IIcon;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class IconFlipped implements IIcon {
/*    */   private final IIcon field_96454_a;
/*    */   private final boolean field_96452_b;
/*    */   
/*    */   public IconFlipped(IIcon p_i1560_1_, boolean p_i1560_2_, boolean p_i1560_3_) {
/* 11 */     this.field_96454_a = p_i1560_1_;
/* 12 */     this.field_96452_b = p_i1560_2_;
/* 13 */     this.field_96453_c = p_i1560_3_;
/*    */   }
/*    */   private final boolean field_96453_c; private static final String __OBFID = "CL_00001511";
/*    */   
/*    */   public int func_94211_a() {
/* 18 */     return this.field_96454_a.func_94211_a();
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_94216_b() {
/* 23 */     return this.field_96454_a.func_94216_b();
/*    */   }
/*    */ 
/*    */   
/*    */   public float func_94209_e() {
/* 28 */     if (this.field_96452_b) return this.field_96454_a.func_94212_f(); 
/* 29 */     return this.field_96454_a.func_94209_e();
/*    */   }
/*    */ 
/*    */   
/*    */   public float func_94212_f() {
/* 34 */     if (this.field_96452_b) return this.field_96454_a.func_94209_e(); 
/* 35 */     return this.field_96454_a.func_94212_f();
/*    */   }
/*    */ 
/*    */   
/*    */   public float func_94214_a(double p_94214_1_) {
/* 40 */     float f = func_94212_f() - func_94209_e();
/* 41 */     return func_94209_e() + f * (float)p_94214_1_ / 16.0F;
/*    */   }
/*    */ 
/*    */   
/*    */   public float func_94206_g() {
/* 46 */     if (this.field_96453_c) return this.field_96454_a.func_94206_g(); 
/* 47 */     return this.field_96454_a.func_94206_g();
/*    */   }
/*    */ 
/*    */   
/*    */   public float func_94210_h() {
/* 52 */     if (this.field_96453_c) return this.field_96454_a.func_94206_g(); 
/* 53 */     return this.field_96454_a.func_94210_h();
/*    */   }
/*    */ 
/*    */   
/*    */   public float func_94207_b(double p_94207_1_) {
/* 58 */     float f = func_94210_h() - func_94206_g();
/* 59 */     return func_94206_g() + f * (float)p_94207_1_ / 16.0F;
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_94215_i() {
/* 64 */     return this.field_96454_a.func_94215_i();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\IconFlipped.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */