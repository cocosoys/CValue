/*    */ package net.minecraft.nbt;
/*    */ 
/*    */ import java.io.DataInput;
/*    */ import java.io.DataOutput;
/*    */ import java.io.IOException;
/*    */ 
/*    */ public class NBTTagLong
/*    */   extends NBTBase.NBTPrimitive
/*    */ {
/*    */   private long field_74753_a;
/*    */   private static final String __OBFID = "CL_00001225";
/*    */   
/*    */   NBTTagLong() {}
/*    */   
/*    */   public NBTTagLong(long p_i45134_1_) {
/* 16 */     this.field_74753_a = p_i45134_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   void func_74734_a(DataOutput p_74734_1_) throws IOException {
/* 21 */     p_74734_1_.writeLong(this.field_74753_a);
/*    */   }
/*    */ 
/*    */   
/*    */   void func_152446_a(DataInput p_152446_1_, int p_152446_2_, NBTSizeTracker p_152446_3_) throws IOException {
/* 26 */     p_152446_3_.func_152450_a(64L);
/* 27 */     this.field_74753_a = p_152446_1_.readLong();
/*    */   }
/*    */ 
/*    */   
/*    */   public byte func_74732_a() {
/* 32 */     return 4;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 37 */     return "" + this.field_74753_a + "L";
/*    */   }
/*    */ 
/*    */   
/*    */   public NBTBase func_74737_b() {
/* 42 */     return new NBTTagLong(this.field_74753_a);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object p_equals_1_) {
/* 47 */     if (super.equals(p_equals_1_)) {
/* 48 */       NBTTagLong nBTTagLong = (NBTTagLong)p_equals_1_;
/* 49 */       return (this.field_74753_a == nBTTagLong.field_74753_a);
/*    */     } 
/* 51 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 56 */     return super.hashCode() ^ (int)(this.field_74753_a ^ this.field_74753_a >>> 32L);
/*    */   }
/*    */ 
/*    */   
/*    */   public long func_150291_c() {
/* 61 */     return this.field_74753_a;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_150287_d() {
/* 66 */     return (int)(this.field_74753_a & 0xFFFFFFFFFFFFFFFFL);
/*    */   }
/*    */ 
/*    */   
/*    */   public short func_150289_e() {
/* 71 */     return (short)(int)(this.field_74753_a & 0xFFFFL);
/*    */   }
/*    */ 
/*    */   
/*    */   public byte func_150290_f() {
/* 76 */     return (byte)(int)(this.field_74753_a & 0xFFL);
/*    */   }
/*    */ 
/*    */   
/*    */   public double func_150286_g() {
/* 81 */     return this.field_74753_a;
/*    */   }
/*    */ 
/*    */   
/*    */   public float func_150288_h() {
/* 86 */     return (float)this.field_74753_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\nbt\NBTTagLong.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */