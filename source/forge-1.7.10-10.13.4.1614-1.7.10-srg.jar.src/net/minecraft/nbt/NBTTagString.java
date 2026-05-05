/*    */ package net.minecraft.nbt;
/*    */ import java.io.DataInput;
/*    */ import java.io.DataOutput;
/*    */ import java.io.IOException;
/*    */ 
/*    */ public class NBTTagString extends NBTBase {
/*    */   private String field_74751_a;
/*    */   
/*    */   public NBTTagString() {
/* 10 */     this.field_74751_a = "";
/*    */   }
/*    */   private static final String __OBFID = "CL_00001228";
/*    */   public NBTTagString(String p_i1389_1_) {
/* 14 */     this.field_74751_a = p_i1389_1_;
/* 15 */     if (p_i1389_1_ == null) throw new IllegalArgumentException("Empty string not allowed");
/*    */   
/*    */   }
/*    */   
/*    */   void func_74734_a(DataOutput p_74734_1_) throws IOException {
/* 20 */     p_74734_1_.writeUTF(this.field_74751_a);
/*    */   }
/*    */ 
/*    */   
/*    */   void func_152446_a(DataInput p_152446_1_, int p_152446_2_, NBTSizeTracker p_152446_3_) throws IOException {
/* 25 */     this.field_74751_a = p_152446_1_.readUTF();
/* 26 */     p_152446_3_.func_152450_a((16 * this.field_74751_a.length()));
/*    */   }
/*    */ 
/*    */   
/*    */   public byte func_74732_a() {
/* 31 */     return 8;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 36 */     return "\"" + this.field_74751_a + "\"";
/*    */   }
/*    */ 
/*    */   
/*    */   public NBTBase func_74737_b() {
/* 41 */     return new NBTTagString(this.field_74751_a);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object p_equals_1_) {
/* 46 */     if (super.equals(p_equals_1_)) {
/* 47 */       NBTTagString nBTTagString = (NBTTagString)p_equals_1_;
/* 48 */       return ((this.field_74751_a == null && nBTTagString.field_74751_a == null) || (this.field_74751_a != null && this.field_74751_a.equals(nBTTagString.field_74751_a)));
/*    */     } 
/* 50 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 55 */     return super.hashCode() ^ this.field_74751_a.hashCode();
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_150285_a_() {
/* 60 */     return this.field_74751_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\nbt\NBTTagString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */