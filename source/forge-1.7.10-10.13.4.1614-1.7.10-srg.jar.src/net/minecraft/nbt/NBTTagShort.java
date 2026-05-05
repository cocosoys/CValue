/*    */ package net.minecraft.nbt;
/*    */ 
/*    */ import java.io.DataInput;
/*    */ import java.io.DataOutput;
/*    */ import java.io.IOException;
/*    */ 
/*    */ public class NBTTagShort
/*    */   extends NBTBase.NBTPrimitive
/*    */ {
/*    */   private short field_74752_a;
/*    */   private static final String __OBFID = "CL_00001227";
/*    */   
/*    */   public NBTTagShort() {}
/*    */   
/*    */   public NBTTagShort(short p_i45135_1_) {
/* 16 */     this.field_74752_a = p_i45135_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   void func_74734_a(DataOutput p_74734_1_) throws IOException {
/* 21 */     p_74734_1_.writeShort(this.field_74752_a);
/*    */   }
/*    */ 
/*    */   
/*    */   void func_152446_a(DataInput p_152446_1_, int p_152446_2_, NBTSizeTracker p_152446_3_) throws IOException {
/* 26 */     p_152446_3_.func_152450_a(16L);
/* 27 */     this.field_74752_a = p_152446_1_.readShort();
/*    */   }
/*    */ 
/*    */   
/*    */   public byte func_74732_a() {
/* 32 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 37 */     return "" + this.field_74752_a + "s";
/*    */   }
/*    */ 
/*    */   
/*    */   public NBTBase func_74737_b() {
/* 42 */     return new NBTTagShort(this.field_74752_a);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object p_equals_1_) {
/* 47 */     if (super.equals(p_equals_1_)) {
/* 48 */       NBTTagShort nBTTagShort = (NBTTagShort)p_equals_1_;
/* 49 */       return (this.field_74752_a == nBTTagShort.field_74752_a);
/*    */     } 
/* 51 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 56 */     return super.hashCode() ^ this.field_74752_a;
/*    */   }
/*    */ 
/*    */   
/*    */   public long func_150291_c() {
/* 61 */     return this.field_74752_a;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_150287_d() {
/* 66 */     return this.field_74752_a;
/*    */   }
/*    */ 
/*    */   
/*    */   public short func_150289_e() {
/* 71 */     return this.field_74752_a;
/*    */   }
/*    */ 
/*    */   
/*    */   public byte func_150290_f() {
/* 76 */     return (byte)(this.field_74752_a & 0xFF);
/*    */   }
/*    */ 
/*    */   
/*    */   public double func_150286_g() {
/* 81 */     return this.field_74752_a;
/*    */   }
/*    */ 
/*    */   
/*    */   public float func_150288_h() {
/* 86 */     return this.field_74752_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\nbt\NBTTagShort.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */