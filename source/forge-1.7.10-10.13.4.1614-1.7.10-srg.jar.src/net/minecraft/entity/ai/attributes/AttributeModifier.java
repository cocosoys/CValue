/*    */ package net.minecraft.entity.ai.attributes;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import org.apache.commons.lang3.Validate;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AttributeModifier
/*    */ {
/*    */   private final double field_111174_a;
/*    */   private final int field_111172_b;
/*    */   private final String field_111173_c;
/*    */   private final UUID field_111170_d;
/*    */   private boolean field_111171_e = true;
/*    */   private static final String __OBFID = "CL_00001564";
/*    */   
/*    */   public AttributeModifier(String p_i1605_1_, double p_i1605_2_, int p_i1605_4_) {
/* 20 */     this(UUID.randomUUID(), p_i1605_1_, p_i1605_2_, p_i1605_4_);
/*    */   }
/*    */   
/*    */   public AttributeModifier(UUID p_i1606_1_, String p_i1606_2_, double p_i1606_3_, int p_i1606_5_) {
/* 24 */     this.field_111170_d = p_i1606_1_;
/* 25 */     this.field_111173_c = p_i1606_2_;
/* 26 */     this.field_111174_a = p_i1606_3_;
/* 27 */     this.field_111172_b = p_i1606_5_;
/*    */     
/* 29 */     Validate.notEmpty(p_i1606_2_, "Modifier name cannot be empty", new Object[0]);
/* 30 */     Validate.inclusiveBetween(Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(p_i1606_5_), "Invalid operation", new Object[0]);
/*    */   }
/*    */   
/*    */   public UUID func_111167_a() {
/* 34 */     return this.field_111170_d;
/*    */   }
/*    */   
/*    */   public String func_111166_b() {
/* 38 */     return this.field_111173_c;
/*    */   }
/*    */   
/*    */   public int func_111169_c() {
/* 42 */     return this.field_111172_b;
/*    */   }
/*    */   
/*    */   public double func_111164_d() {
/* 46 */     return this.field_111174_a;
/*    */   }
/*    */   
/*    */   public boolean func_111165_e() {
/* 50 */     return this.field_111171_e;
/*    */   }
/*    */   
/*    */   public AttributeModifier func_111168_a(boolean p_111168_1_) {
/* 54 */     this.field_111171_e = p_111168_1_;
/* 55 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object p_equals_1_) {
/* 60 */     if (this == p_equals_1_) return true; 
/* 61 */     if (p_equals_1_ == null || getClass() != p_equals_1_.getClass()) return false;
/*    */     
/* 63 */     AttributeModifier attributeModifier = (AttributeModifier)p_equals_1_;
/*    */     
/* 65 */     if ((this.field_111170_d != null) ? !this.field_111170_d.equals(attributeModifier.field_111170_d) : (attributeModifier.field_111170_d != null)) return false;
/*    */     
/* 67 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 72 */     return (this.field_111170_d != null) ? this.field_111170_d.hashCode() : 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 77 */     return "AttributeModifier{amount=" + this.field_111174_a + ", operation=" + this.field_111172_b + ", name='" + this.field_111173_c + '\'' + ", id=" + this.field_111170_d + ", serialize=" + this.field_111171_e + '}';
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\attributes\AttributeModifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */