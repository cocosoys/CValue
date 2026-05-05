/*    */ package net.minecraft.world.biome;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class BiomeGenOcean extends BiomeGenBase {
/*    */   private static final String __OBFID = "CL_00000179";
/*    */   
/*    */   public BiomeGenOcean(int p_i1985_1_) {
/* 11 */     super(p_i1985_1_);
/*    */     
/* 13 */     this.field_76762_K.clear();
/*    */   }
/*    */ 
/*    */   
/*    */   public BiomeGenBase.TempCategory func_150561_m() {
/* 18 */     return BiomeGenBase.TempCategory.OCEAN;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_150573_a(World p_150573_1_, Random p_150573_2_, Block[] p_150573_3_, byte[] p_150573_4_, int p_150573_5_, int p_150573_6_, double p_150573_7_) {
/* 24 */     super.func_150573_a(p_150573_1_, p_150573_2_, p_150573_3_, p_150573_4_, p_150573_5_, p_150573_6_, p_150573_7_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\biome\BiomeGenOcean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */