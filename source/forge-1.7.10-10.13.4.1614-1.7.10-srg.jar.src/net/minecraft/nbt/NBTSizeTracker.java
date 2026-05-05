/*    */ package net.minecraft.nbt;
/*    */ 
/*    */ public class NBTSizeTracker {
/*  4 */   public static final NBTSizeTracker field_152451_a = new NBTSizeTracker(0L)
/*    */     {
/*    */       private static final String __OBFID = "CL_00001902";
/*    */       
/*    */       public void func_152450_a(long p_152450_1_) {}
/*    */     };
/*    */   private final long field_152452_b;
/*    */   private long field_152453_c;
/*    */   private static final String __OBFID = "CL_00001903";
/*    */   
/*    */   public NBTSizeTracker(long p_i1203_1_) {
/* 15 */     this.field_152452_b = p_i1203_1_;
/*    */   }
/*    */   
/*    */   public void func_152450_a(long p_152450_1_) {
/* 19 */     this.field_152453_c += p_152450_1_ / 8L;
/* 20 */     if (this.field_152453_c > this.field_152452_b)
/* 21 */       throw new RuntimeException("Tried to read NBT tag that was too big; tried to allocate: " + this.field_152453_c + "bytes where max allowed: " + this.field_152452_b); 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\nbt\NBTSizeTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */