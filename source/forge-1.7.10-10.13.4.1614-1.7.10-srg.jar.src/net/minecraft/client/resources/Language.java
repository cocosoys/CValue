/*    */ package net.minecraft.client.resources;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class Language implements Comparable {
/*    */   private final String field_135039_a;
/*    */   private final String field_135037_b;
/*    */   
/*    */   public Language(String p_i1303_1_, String p_i1303_2_, String p_i1303_3_, boolean p_i1303_4_) {
/* 10 */     this.field_135039_a = p_i1303_1_;
/* 11 */     this.field_135037_b = p_i1303_2_;
/* 12 */     this.field_135038_c = p_i1303_3_;
/* 13 */     this.field_135036_d = p_i1303_4_;
/*    */   }
/*    */   private final String field_135038_c; private final boolean field_135036_d; private static final String __OBFID = "CL_00001095";
/*    */   public String func_135034_a() {
/* 17 */     return this.field_135039_a;
/*    */   }
/*    */   
/*    */   public boolean func_135035_b() {
/* 21 */     return this.field_135036_d;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 26 */     return String.format("%s (%s)", new Object[] { this.field_135038_c, this.field_135037_b });
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object p_equals_1_) {
/* 32 */     if (this == p_equals_1_) return true; 
/* 33 */     if (!(p_equals_1_ instanceof Language)) return false;
/*    */     
/* 35 */     return this.field_135039_a.equals(((Language)p_equals_1_).field_135039_a);
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 40 */     return this.field_135039_a.hashCode();
/*    */   }
/*    */ 
/*    */   
/*    */   public int compareTo(Language p_compareTo_1_) {
/* 45 */     return this.field_135039_a.compareTo(p_compareTo_1_.field_135039_a);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\resources\Language.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */