/*    */ package net.minecraft.util;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ResourceLocation {
/*    */   private final String field_110626_a;
/*    */   
/*    */   public ResourceLocation(String p_i1292_1_, String p_i1292_2_) {
/* 10 */     Validate.notNull(p_i1292_2_);
/*    */     
/* 12 */     if (p_i1292_1_ == null || p_i1292_1_.length() == 0) {
/* 13 */       this.field_110626_a = "minecraft";
/*    */     } else {
/* 15 */       this.field_110626_a = p_i1292_1_;
/*    */     } 
/*    */     
/* 18 */     this.field_110625_b = p_i1292_2_;
/*    */   }
/*    */   private final String field_110625_b; private static final String __OBFID = "CL_00001082";
/*    */   public ResourceLocation(String p_i1293_1_) {
/* 22 */     String str1 = "minecraft";
/* 23 */     String str2 = p_i1293_1_;
/*    */     
/* 25 */     int i = p_i1293_1_.indexOf(':');
/* 26 */     if (i >= 0) {
/* 27 */       str2 = p_i1293_1_.substring(i + 1, p_i1293_1_.length());
/* 28 */       if (i > 1) {
/* 29 */         str1 = p_i1293_1_.substring(0, i);
/*    */       }
/*    */     } 
/*    */     
/* 33 */     this.field_110626_a = str1.toLowerCase();
/* 34 */     this.field_110625_b = str2;
/*    */   }
/*    */   
/*    */   public String func_110623_a() {
/* 38 */     return this.field_110625_b;
/*    */   }
/*    */   
/*    */   public String func_110624_b() {
/* 42 */     return this.field_110626_a;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 47 */     return this.field_110626_a + ":" + this.field_110625_b;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object p_equals_1_) {
/* 52 */     if (this == p_equals_1_) return true;
/*    */     
/* 54 */     if (p_equals_1_ instanceof ResourceLocation) {
/* 55 */       ResourceLocation resourceLocation = (ResourceLocation)p_equals_1_;
/*    */       
/* 57 */       return (this.field_110626_a.equals(resourceLocation.field_110626_a) && this.field_110625_b.equals(resourceLocation.field_110625_b));
/*    */     } 
/*    */     
/* 60 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 65 */     return 31 * this.field_110626_a.hashCode() + this.field_110625_b.hashCode();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\ResourceLocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */