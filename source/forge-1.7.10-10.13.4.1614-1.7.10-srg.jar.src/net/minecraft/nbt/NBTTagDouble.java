/*    */ package net.minecraft.nbt;
/*    */ 
/*    */ import java.io.DataInput;
/*    */ import java.io.DataOutput;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.util.MathHelper;
/*    */ 
/*    */ public class NBTTagDouble
/*    */   extends NBTBase.NBTPrimitive
/*    */ {
/*    */   private double field_74755_a;
/*    */   private static final String __OBFID = "CL_00001218";
/*    */   
/*    */   NBTTagDouble() {}
/*    */   
/*    */   public NBTTagDouble(double p_i45130_1_) {
/* 17 */     this.field_74755_a = p_i45130_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   void func_74734_a(DataOutput p_74734_1_) throws IOException {
/* 22 */     p_74734_1_.writeDouble(this.field_74755_a);
/*    */   }
/*    */ 
/*    */   
/*    */   void func_152446_a(DataInput p_152446_1_, int p_152446_2_, NBTSizeTracker p_152446_3_) throws IOException {
/* 27 */     p_152446_3_.func_152450_a(64L);
/* 28 */     this.field_74755_a = p_152446_1_.readDouble();
/*    */   }
/*    */ 
/*    */   
/*    */   public byte func_74732_a() {
/* 33 */     return 6;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 38 */     return "" + this.field_74755_a + "d";
/*    */   }
/*    */ 
/*    */   
/*    */   public NBTBase func_74737_b() {
/* 43 */     return new NBTTagDouble(this.field_74755_a);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object p_equals_1_) {
/* 48 */     if (super.equals(p_equals_1_)) {
/* 49 */       NBTTagDouble nBTTagDouble = (NBTTagDouble)p_equals_1_;
/* 50 */       return (this.field_74755_a == nBTTagDouble.field_74755_a);
/*    */     } 
/* 52 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 57 */     long l = Double.doubleToLongBits(this.field_74755_a);
/* 58 */     return super.hashCode() ^ (int)(l ^ l >>> 32L);
/*    */   }
/*    */ 
/*    */   
/*    */   public long func_150291_c() {
/* 63 */     return (long)Math.floor(this.field_74755_a);
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_150287_d() {
/* 68 */     return MathHelper.func_76128_c(this.field_74755_a);
/*    */   }
/*    */ 
/*    */   
/*    */   public short func_150289_e() {
/* 73 */     return (short)(MathHelper.func_76128_c(this.field_74755_a) & 0xFFFF);
/*    */   }
/*    */ 
/*    */   
/*    */   public byte func_150290_f() {
/* 78 */     return (byte)(MathHelper.func_76128_c(this.field_74755_a) & 0xFF);
/*    */   }
/*    */ 
/*    */   
/*    */   public double func_150286_g() {
/* 83 */     return this.field_74755_a;
/*    */   }
/*    */ 
/*    */   
/*    */   public float func_150288_h() {
/* 88 */     return (float)this.field_74755_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\nbt\NBTTagDouble.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */