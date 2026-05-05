/*    */ package net.minecraft.world.gen.structure;
/*    */ 
/*    */ import net.minecraft.nbt.NBTBase;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.world.WorldSavedData;
/*    */ 
/*    */ public class MapGenStructureData extends WorldSavedData {
/*    */   private NBTTagCompound field_143044_a;
/*    */   private static final String __OBFID = "CL_00000510";
/*    */   
/*    */   public MapGenStructureData(String p_i43001_1_) {
/* 12 */     super(p_i43001_1_);
/* 13 */     this.field_143044_a = new NBTTagCompound();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_76184_a(NBTTagCompound p_76184_1_) {
/* 18 */     this.field_143044_a = p_76184_1_.func_74775_l("Features");
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_76187_b(NBTTagCompound p_76187_1_) {
/* 23 */     p_76187_1_.func_74782_a("Features", (NBTBase)this.field_143044_a);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_143043_a(NBTTagCompound p_143043_1_, int p_143043_2_, int p_143043_3_) {
/* 31 */     this.field_143044_a.func_74782_a(func_143042_b(p_143043_2_, p_143043_3_), (NBTBase)p_143043_1_);
/*    */   }
/*    */   
/*    */   public static String func_143042_b(int p_143042_0_, int p_143042_1_) {
/* 35 */     return "[" + p_143042_0_ + "," + p_143042_1_ + "]";
/*    */   }
/*    */   
/*    */   public NBTTagCompound func_143041_a() {
/* 39 */     return this.field_143044_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\structure\MapGenStructureData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */