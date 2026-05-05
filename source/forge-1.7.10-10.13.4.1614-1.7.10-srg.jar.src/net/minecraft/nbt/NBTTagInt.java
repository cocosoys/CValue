/*    */ package net.minecraft.nbt;
/*    */ 
/*    */ import java.io.DataInput;
/*    */ import java.io.DataOutput;
/*    */ import java.io.IOException;
/*    */ 
/*    */ public class NBTTagInt
/*    */   extends NBTBase.NBTPrimitive
/*    */ {
/*    */   private int field_74748_a;
/*    */   private static final String __OBFID = "CL_00001223";
/*    */   
/*    */   NBTTagInt() {}
/*    */   
/*    */   public NBTTagInt(int p_i45133_1_) {
/* 16 */     this.field_74748_a = p_i45133_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   void func_74734_a(DataOutput p_74734_1_) throws IOException {
/* 21 */     p_74734_1_.writeInt(this.field_74748_a);
/*    */   }
/*    */ 
/*    */   
/*    */   void func_152446_a(DataInput p_152446_1_, int p_152446_2_, NBTSizeTracker p_152446_3_) throws IOException {
/* 26 */     p_152446_3_.func_152450_a(32L);
/* 27 */     this.field_74748_a = p_152446_1_.readInt();
/*    */   }
/*    */ 
/*    */   
/*    */   public byte func_74732_a() {
/* 32 */     return 3;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 37 */     return "" + this.field_74748_a;
/*    */   }
/*    */ 
/*    */   
/*    */   public NBTBase func_74737_b() {
/* 42 */     return new NBTTagInt(this.field_74748_a);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object p_equals_1_) {
/* 47 */     if (super.equals(p_equals_1_)) {
/* 48 */       NBTTagInt nBTTagInt = (NBTTagInt)p_equals_1_;
/* 49 */       return (this.field_74748_a == nBTTagInt.field_74748_a);
/*    */     } 
/* 51 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 56 */     return super.hashCode() ^ this.field_74748_a;
/*    */   }
/*    */ 
/*    */   
/*    */   public long func_150291_c() {
/* 61 */     return this.field_74748_a;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_150287_d() {
/* 66 */     return this.field_74748_a;
/*    */   }
/*    */ 
/*    */   
/*    */   public short func_150289_e() {
/* 71 */     return (short)(this.field_74748_a & 0xFFFF);
/*    */   }
/*    */ 
/*    */   
/*    */   public byte func_150290_f() {
/* 76 */     return (byte)(this.field_74748_a & 0xFF);
/*    */   }
/*    */ 
/*    */   
/*    */   public double func_150286_g() {
/* 81 */     return this.field_74748_a;
/*    */   }
/*    */ 
/*    */   
/*    */   public float func_150288_h() {
/* 86 */     return this.field_74748_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\nbt\NBTTagInt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */