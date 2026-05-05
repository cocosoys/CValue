/*    */ package net.minecraft.nbt;
/*    */ 
/*    */ import java.io.DataInput;
/*    */ import java.io.DataOutput;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.util.MathHelper;
/*    */ 
/*    */ public class NBTTagFloat
/*    */   extends NBTBase.NBTPrimitive
/*    */ {
/*    */   private float field_74750_a;
/*    */   private static final String __OBFID = "CL_00001220";
/*    */   
/*    */   NBTTagFloat() {}
/*    */   
/*    */   public NBTTagFloat(float p_i45131_1_) {
/* 17 */     this.field_74750_a = p_i45131_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   void func_74734_a(DataOutput p_74734_1_) throws IOException {
/* 22 */     p_74734_1_.writeFloat(this.field_74750_a);
/*    */   }
/*    */ 
/*    */   
/*    */   void func_152446_a(DataInput p_152446_1_, int p_152446_2_, NBTSizeTracker p_152446_3_) throws IOException {
/* 27 */     p_152446_3_.func_152450_a(32L);
/* 28 */     this.field_74750_a = p_152446_1_.readFloat();
/*    */   }
/*    */ 
/*    */   
/*    */   public byte func_74732_a() {
/* 33 */     return 5;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 38 */     return "" + this.field_74750_a + "f";
/*    */   }
/*    */ 
/*    */   
/*    */   public NBTBase func_74737_b() {
/* 43 */     return new NBTTagFloat(this.field_74750_a);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object p_equals_1_) {
/* 48 */     if (super.equals(p_equals_1_)) {
/* 49 */       NBTTagFloat nBTTagFloat = (NBTTagFloat)p_equals_1_;
/* 50 */       return (this.field_74750_a == nBTTagFloat.field_74750_a);
/*    */     } 
/* 52 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 57 */     return super.hashCode() ^ Float.floatToIntBits(this.field_74750_a);
/*    */   }
/*    */ 
/*    */   
/*    */   public long func_150291_c() {
/* 62 */     return (long)this.field_74750_a;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_150287_d() {
/* 67 */     return MathHelper.func_76141_d(this.field_74750_a);
/*    */   }
/*    */ 
/*    */   
/*    */   public short func_150289_e() {
/* 72 */     return (short)(MathHelper.func_76141_d(this.field_74750_a) & 0xFFFF);
/*    */   }
/*    */ 
/*    */   
/*    */   public byte func_150290_f() {
/* 77 */     return (byte)(MathHelper.func_76141_d(this.field_74750_a) & 0xFF);
/*    */   }
/*    */ 
/*    */   
/*    */   public double func_150286_g() {
/* 82 */     return this.field_74750_a;
/*    */   }
/*    */ 
/*    */   
/*    */   public float func_150288_h() {
/* 87 */     return this.field_74750_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\nbt\NBTTagFloat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */