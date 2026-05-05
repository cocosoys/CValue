/*    */ package net.minecraft.world;
/*    */ 
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ 
/*    */ public abstract class WorldSavedData
/*    */ {
/*    */   public final String field_76190_i;
/*    */   
/*    */   public WorldSavedData(String p_i2141_1_) {
/* 10 */     this.field_76190_i = p_i2141_1_;
/*    */   }
/*    */   private boolean field_76189_a; private static final String __OBFID = "CL_00000580";
/*    */   public abstract void func_76184_a(NBTTagCompound paramNBTTagCompound);
/*    */   
/*    */   public abstract void func_76187_b(NBTTagCompound paramNBTTagCompound);
/*    */   
/*    */   public void func_76185_a() {
/* 18 */     func_76186_a(true);
/*    */   }
/*    */   
/*    */   public void func_76186_a(boolean p_76186_1_) {
/* 22 */     this.field_76189_a = p_76186_1_;
/*    */   }
/*    */   
/*    */   public boolean func_76188_b() {
/* 26 */     return this.field_76189_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\WorldSavedData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */