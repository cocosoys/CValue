/*    */ package net.minecraft.client.particle;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class EntityCrit2FX extends EntityFX {
/*    */   private Entity field_70557_a;
/*    */   private int field_70560_aq;
/*    */   
/*    */   public EntityCrit2FX(World p_i1199_1_, Entity p_i1199_2_) {
/* 14 */     this(p_i1199_1_, p_i1199_2_, "crit");
/*    */   }
/*    */   private int field_70559_ar; private String field_70558_as; private static final String __OBFID = "CL_00000899";
/*    */   public EntityCrit2FX(World p_i1200_1_, Entity p_i1200_2_, String p_i1200_3_) {
/* 18 */     super(p_i1200_1_, p_i1200_2_.field_70165_t, p_i1200_2_.field_70121_D.field_72338_b + (p_i1200_2_.field_70131_O / 2.0F), p_i1200_2_.field_70161_v, p_i1200_2_.field_70159_w, p_i1200_2_.field_70181_x, p_i1200_2_.field_70179_y);
/* 19 */     this.field_70557_a = p_i1200_2_;
/* 20 */     this.field_70559_ar = 3;
/* 21 */     this.field_70558_as = p_i1200_3_;
/* 22 */     func_70071_h_();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {}
/*    */ 
/*    */   
/*    */   public void func_70071_h_() {
/* 31 */     for (byte b = 0; b < 16; b++) {
/* 32 */       double d1 = (this.field_70146_Z.nextFloat() * 2.0F - 1.0F);
/* 33 */       double d2 = (this.field_70146_Z.nextFloat() * 2.0F - 1.0F);
/* 34 */       double d3 = (this.field_70146_Z.nextFloat() * 2.0F - 1.0F);
/* 35 */       if (d1 * d1 + d2 * d2 + d3 * d3 <= 1.0D) {
/* 36 */         double d4 = this.field_70557_a.field_70165_t + d1 * this.field_70557_a.field_70130_N / 4.0D;
/* 37 */         double d5 = this.field_70557_a.field_70121_D.field_72338_b + (this.field_70557_a.field_70131_O / 2.0F) + d2 * this.field_70557_a.field_70131_O / 4.0D;
/* 38 */         double d6 = this.field_70557_a.field_70161_v + d3 * this.field_70557_a.field_70130_N / 4.0D;
/* 39 */         this.field_70170_p.func_72869_a(this.field_70558_as, d4, d5, d6, d1, d2 + 0.2D, d3);
/*    */       } 
/* 41 */     }  this.field_70560_aq++;
/* 42 */     if (this.field_70560_aq >= this.field_70559_ar) func_70106_y();
/*    */   
/*    */   }
/*    */   
/*    */   public int func_70537_b() {
/* 47 */     return 3;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\particle\EntityCrit2FX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */