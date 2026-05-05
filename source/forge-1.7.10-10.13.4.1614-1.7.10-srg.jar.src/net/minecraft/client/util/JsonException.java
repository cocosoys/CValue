/*    */ package net.minecraft.client.util;
/*    */ import com.google.common.collect.Lists;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import org.apache.commons.lang3.StringUtils;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class JsonException extends IOException {
/* 11 */   private final List field_151383_a = Lists.newArrayList(); private final String field_151382_b;
/*    */   private static final String __OBFID = "CL_00001414";
/*    */   
/*    */   public JsonException(String p_i45279_1_) {
/* 15 */     this.field_151383_a.add(new Entry());
/* 16 */     this.field_151382_b = p_i45279_1_;
/*    */   }
/*    */   
/*    */   public JsonException(String p_i45280_1_, Throwable p_i45280_2_) {
/* 20 */     super(p_i45280_2_);
/* 21 */     this.field_151383_a.add(new Entry());
/* 22 */     this.field_151382_b = p_i45280_1_;
/*    */   }
/*    */   
/*    */   public void func_151380_a(String p_151380_1_) {
/* 26 */     ((Entry)this.field_151383_a.get(0)).func_151373_a(p_151380_1_);
/*    */   }
/*    */   
/*    */   public void func_151381_b(String p_151381_1_) {
/* 30 */     (this.field_151383_a.get(0)).field_151376_a = p_151381_1_;
/* 31 */     this.field_151383_a.add(0, new Entry());
/*    */   }
/*    */ 
/*    */   
/*    */   public String getMessage() {
/* 36 */     return "Invalid " + ((Entry)this.field_151383_a.get(this.field_151383_a.size() - 1)).toString() + ": " + this.field_151382_b;
/*    */   }
/*    */   
/*    */   public static JsonException func_151379_a(Exception p_151379_0_) {
/* 40 */     if (p_151379_0_ instanceof JsonException) {
/* 41 */       return (JsonException)p_151379_0_;
/*    */     }
/* 43 */     String str = p_151379_0_.getMessage();
/* 44 */     if (p_151379_0_ instanceof java.io.FileNotFoundException) {
/* 45 */       str = "File not found";
/*    */     }
/* 47 */     return new JsonException(str, p_151379_0_);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public static class Entry {
/* 52 */     private String field_151376_a = null;
/* 53 */     private final List field_151375_b = Lists.newArrayList();
/*    */     
/*    */     private static final String __OBFID = "CL_00001416";
/*    */ 
/*    */     
/*    */     private void func_151373_a(String p_151373_1_) {
/* 59 */       this.field_151375_b.add(0, p_151373_1_);
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public String func_151372_b() {
/* 67 */       return StringUtils.join(this.field_151375_b, "->");
/*    */     }
/*    */ 
/*    */     
/*    */     public String toString() {
/* 72 */       if (this.field_151376_a != null) {
/* 73 */         if (!this.field_151375_b.isEmpty()) {
/* 74 */           return this.field_151376_a + " " + func_151372_b();
/*    */         }
/* 76 */         return this.field_151376_a;
/*    */       } 
/*    */       
/* 79 */       if (!this.field_151375_b.isEmpty()) {
/* 80 */         return "(Unknown file) " + func_151372_b();
/*    */       }
/* 82 */       return "(Unknown file)";
/*    */     }
/*    */     
/*    */     private Entry() {}
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\clien\\util\JsonException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */