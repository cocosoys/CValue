/*    */ package net.minecraft.client.stream;
/*    */ import com.google.common.base.Objects;
/*    */ import com.google.common.collect.Maps;
/*    */ import com.google.gson.Gson;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class Metadata {
/* 10 */   private static final Gson field_152811_a = new Gson();
/*    */   
/*    */   private final String field_152812_b;
/*    */   
/*    */   private String field_152813_c;
/*    */   
/*    */   private Map field_152814_d;
/*    */   private static final String __OBFID = "CL_00001823";
/*    */   
/*    */   public Metadata(String p_i1029_1_, String p_i1029_2_) {
/* 20 */     this.field_152812_b = p_i1029_1_;
/* 21 */     this.field_152813_c = p_i1029_2_;
/*    */   }
/*    */   
/*    */   public Metadata(String p_i1030_1_) {
/* 25 */     this(p_i1030_1_, null);
/*    */   }
/*    */   
/*    */   public void func_152807_a(String p_152807_1_) {
/* 29 */     this.field_152813_c = p_152807_1_;
/*    */   }
/*    */   
/*    */   public String func_152809_a() {
/* 33 */     return (this.field_152813_c == null) ? this.field_152812_b : this.field_152813_c;
/*    */   }
/*    */   
/*    */   public void func_152808_a(String p_152808_1_, String p_152808_2_) {
/* 37 */     if (this.field_152814_d == null) this.field_152814_d = Maps.newHashMap(); 
/* 38 */     if (this.field_152814_d.size() > 50) throw new IllegalArgumentException("Metadata payload is full, cannot add more to it!"); 
/* 39 */     if (p_152808_1_ == null) throw new IllegalArgumentException("Metadata payload key cannot be null!"); 
/* 40 */     if (p_152808_1_.length() > 255) throw new IllegalArgumentException("Metadata payload key is too long!"); 
/* 41 */     if (p_152808_2_ == null) throw new IllegalArgumentException("Metadata payload value cannot be null!"); 
/* 42 */     if (p_152808_2_.length() > 255) throw new IllegalArgumentException("Metadata payload value is too long!");
/*    */     
/* 44 */     this.field_152814_d.put(p_152808_1_, p_152808_2_);
/*    */   }
/*    */   
/*    */   public String func_152806_b() {
/* 48 */     if (this.field_152814_d == null || this.field_152814_d.isEmpty()) return null;
/*    */     
/* 50 */     return field_152811_a.toJson(this.field_152814_d);
/*    */   }
/*    */   
/*    */   public String func_152810_c() {
/* 54 */     return this.field_152812_b;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 59 */     return Objects.toStringHelper(this).add("name", this.field_152812_b).add("description", this.field_152813_c).add("data", func_152806_b()).toString();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\stream\Metadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */