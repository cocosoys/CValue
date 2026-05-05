/*    */ package net.minecraft.nbt;
/*    */ 
/*    */ import java.io.DataInput;
/*    */ import java.io.DataOutput;
/*    */ import java.io.IOException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NBTTagEnd
/*    */   extends NBTBase
/*    */ {
/*    */   private static final String __OBFID = "CL_00001219";
/*    */   
/*    */   void func_152446_a(DataInput p_152446_1_, int p_152446_2_, NBTSizeTracker p_152446_3_) throws IOException {}
/*    */   
/*    */   void func_74734_a(DataOutput p_74734_1_) throws IOException {}
/*    */   
/*    */   public byte func_74732_a() {
/* 21 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 26 */     return "END";
/*    */   }
/*    */ 
/*    */   
/*    */   public NBTBase func_74737_b() {
/* 31 */     return new NBTTagEnd();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\nbt\NBTTagEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */