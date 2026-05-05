/*    */ package net.minecraft.tileentity;
/*    */ 
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ 
/*    */ public class TileEntityComparator extends TileEntity {
/*    */   private int field_145997_a;
/*    */   private static final String __OBFID = "CL_00000349";
/*    */   
/*    */   public void func_145841_b(NBTTagCompound p_145841_1_) {
/* 10 */     super.func_145841_b(p_145841_1_);
/* 11 */     p_145841_1_.func_74768_a("OutputSignal", this.field_145997_a);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_145839_a(NBTTagCompound p_145839_1_) {
/* 16 */     super.func_145839_a(p_145839_1_);
/* 17 */     this.field_145997_a = p_145839_1_.func_74762_e("OutputSignal");
/*    */   }
/*    */   
/*    */   public int func_145996_a() {
/* 21 */     return this.field_145997_a;
/*    */   }
/*    */   
/*    */   public void func_145995_a(int p_145995_1_) {
/* 25 */     this.field_145997_a = p_145995_1_;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\tileentity\TileEntityComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */