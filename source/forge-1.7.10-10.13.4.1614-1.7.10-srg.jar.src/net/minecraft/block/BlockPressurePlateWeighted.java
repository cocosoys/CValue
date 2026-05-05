/*    */ package net.minecraft.block;
/*    */ 
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class BlockPressurePlateWeighted
/*    */   extends BlockBasePressurePlate {
/*    */   private final int field_150068_a;
/*    */   private static final String __OBFID = "CL_00000334";
/*    */   
/*    */   protected BlockPressurePlateWeighted(String p_i45436_1_, Material p_i45436_2_, int p_i45436_3_) {
/* 14 */     super(p_i45436_1_, p_i45436_2_);
/*    */     
/* 16 */     this.field_150068_a = p_i45436_3_;
/*    */   }
/*    */ 
/*    */   
/*    */   protected int func_150065_e(World p_150065_1_, int p_150065_2_, int p_150065_3_, int p_150065_4_) {
/* 21 */     int i = Math.min(p_150065_1_.func_72872_a(Entity.class, func_150061_a(p_150065_2_, p_150065_3_, p_150065_4_)).size(), this.field_150068_a);
/*    */     
/* 23 */     if (i <= 0) {
/* 24 */       return 0;
/*    */     }
/* 26 */     float f = Math.min(this.field_150068_a, i) / this.field_150068_a;
/* 27 */     return MathHelper.func_76123_f(f * 15.0F);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected int func_150060_c(int p_150060_1_) {
/* 33 */     return p_150060_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   protected int func_150066_d(int p_150066_1_) {
/* 38 */     return p_150066_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149738_a(World p_149738_1_) {
/* 43 */     return 10;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockPressurePlateWeighted.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */