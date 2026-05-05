/*    */ package net.minecraft.client.renderer;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class EntitySorter implements Comparator {
/*    */   private double field_78949_a;
/*    */   private double field_78947_b;
/*    */   
/*    */   public EntitySorter(Entity p_i1242_1_) {
/* 11 */     this.field_78949_a = -p_i1242_1_.field_70165_t;
/* 12 */     this.field_78947_b = -p_i1242_1_.field_70163_u;
/* 13 */     this.field_78948_c = -p_i1242_1_.field_70161_v;
/*    */   }
/*    */   private double field_78948_c; private static final String __OBFID = "CL_00000944";
/*    */   
/*    */   public int compare(WorldRenderer p_compare_1_, WorldRenderer p_compare_2_) {
/* 18 */     double d1 = p_compare_1_.field_78925_n + this.field_78949_a;
/* 19 */     double d2 = p_compare_1_.field_78926_o + this.field_78947_b;
/* 20 */     double d3 = p_compare_1_.field_78940_p + this.field_78948_c;
/*    */     
/* 22 */     double d4 = p_compare_2_.field_78925_n + this.field_78949_a;
/* 23 */     double d5 = p_compare_2_.field_78926_o + this.field_78947_b;
/* 24 */     double d6 = p_compare_2_.field_78940_p + this.field_78948_c;
/*    */     
/* 26 */     return (int)((d1 * d1 + d2 * d2 + d3 * d3 - d4 * d4 + d5 * d5 + d6 * d6) * 1024.0D);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\EntitySorter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */