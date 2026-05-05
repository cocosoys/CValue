/*    */ package net.minecraft.client.renderer;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderSorter implements Comparator {
/*    */   private EntityLivingBase field_78945_a;
/*    */   
/*    */   public RenderSorter(EntityLivingBase p_i1241_1_) {
/* 11 */     this.field_78945_a = p_i1241_1_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00000943";
/*    */   
/*    */   public int compare(WorldRenderer p_compare_1_, WorldRenderer p_compare_2_) {
/* 16 */     if (p_compare_1_.field_78927_l && !p_compare_2_.field_78927_l) return 1; 
/* 17 */     if (p_compare_2_.field_78927_l && !p_compare_1_.field_78927_l) return -1;
/*    */     
/* 19 */     double d1 = p_compare_1_.func_78912_a((Entity)this.field_78945_a);
/* 20 */     double d2 = p_compare_2_.func_78912_a((Entity)this.field_78945_a);
/*    */     
/* 22 */     if (d1 < d2) return 1; 
/* 23 */     if (d1 > d2) return -1;
/*    */     
/* 25 */     return (p_compare_1_.field_78937_s < p_compare_2_.field_78937_s) ? 1 : -1;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\RenderSorter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */